package com.google.firebase.crashlytics.internal.metadata;

import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

class QueueFile implements Closeable {
    static final int HEADER_LENGTH = 16;
    private static final int INITIAL_LENGTH = 4096;
    private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    private final byte[] buffer = new byte[16];
    private int elementCount;
    int fileLength;
    private Element first;
    private Element last;
    /* access modifiers changed from: private */
    public final RandomAccessFile raf;

    public interface ElementReader {
        void read(InputStream inputStream, int i) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            initialize(file);
        }
        this.raf = open(file);
        readHeader();
    }

    QueueFile(RandomAccessFile randomAccessFile) throws IOException {
        this.raf = randomAccessFile;
        readHeader();
    }

    private static void writeInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void writeInts(byte[] bArr, int... iArr) {
        int i = 0;
        for (int writeInt : iArr) {
            writeInt(bArr, i, writeInt);
            i += 4;
        }
    }

    private static int readInt(byte[] bArr, int i) {
        return ((bArr[i] & 255) << Ascii.CAN) + ((bArr[i + 1] & 255) << Ascii.DLE) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    private void readHeader() throws IOException {
        this.raf.seek(0);
        this.raf.readFully(this.buffer);
        int readInt = readInt(this.buffer, 0);
        this.fileLength = readInt;
        if (((long) readInt) <= this.raf.length()) {
            this.elementCount = readInt(this.buffer, 4);
            int readInt2 = readInt(this.buffer, 8);
            int readInt3 = readInt(this.buffer, 12);
            this.first = readElement(readInt2);
            this.last = readElement(readInt3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
    }

    private void writeHeader(int i, int i2, int i3, int i4) throws IOException {
        writeInts(this.buffer, i, i2, i3, i4);
        this.raf.seek(0);
        this.raf.write(this.buffer);
    }

    private Element readElement(int i) throws IOException {
        if (i == 0) {
            return Element.NULL;
        }
        this.raf.seek((long) i);
        return new Element(i, this.raf.readInt());
    }

    /* JADX INFO: finally extract failed */
    private static void initialize(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile open = open(file2);
        try {
            open.setLength(4096);
            open.seek(0);
            byte[] bArr = new byte[16];
            writeInts(bArr, 4096, 0, 0, 0);
            open.write(bArr);
            open.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            open.close();
            throw th;
        }
    }

    private static RandomAccessFile open(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* access modifiers changed from: private */
    public int wrapPosition(int i) {
        int i2 = this.fileLength;
        return i < i2 ? i : (i + 16) - i2;
    }

    private void ringWrite(int i, byte[] bArr, int i2, int i3) throws IOException {
        int wrapPosition = wrapPosition(i);
        int i4 = wrapPosition + i3;
        int i5 = this.fileLength;
        if (i4 <= i5) {
            this.raf.seek((long) wrapPosition);
            this.raf.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - wrapPosition;
        this.raf.seek((long) wrapPosition);
        this.raf.write(bArr, i2, i6);
        this.raf.seek(16);
        this.raf.write(bArr, i2 + i6, i3 - i6);
    }

    /* access modifiers changed from: private */
    public void ringRead(int i, byte[] bArr, int i2, int i3) throws IOException {
        int wrapPosition = wrapPosition(i);
        int i4 = wrapPosition + i3;
        int i5 = this.fileLength;
        if (i4 <= i5) {
            this.raf.seek((long) wrapPosition);
            this.raf.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - wrapPosition;
        this.raf.seek((long) wrapPosition);
        this.raf.readFully(bArr, i2, i6);
        this.raf.seek(16);
        this.raf.readFully(bArr, i2 + i6, i3 - i6);
    }

    public void add(byte[] bArr) throws IOException {
        add(bArr, 0, bArr.length);
    }

    public synchronized void add(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        nonNull(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        expandIfNecessary(i2);
        boolean isEmpty = isEmpty();
        if (isEmpty) {
            i3 = 16;
        } else {
            i3 = wrapPosition(this.last.position + 4 + this.last.length);
        }
        Element element = new Element(i3, i2);
        writeInt(this.buffer, 0, i2);
        ringWrite(element.position, this.buffer, 0, 4);
        ringWrite(element.position + 4, bArr, i, i2);
        writeHeader(this.fileLength, this.elementCount + 1, isEmpty ? element.position : this.first.position, element.position);
        this.last = element;
        this.elementCount++;
        if (isEmpty) {
            this.first = element;
        }
    }

    public int usedBytes() {
        if (this.elementCount == 0) {
            return 16;
        }
        if (this.last.position >= this.first.position) {
            return (this.last.position - this.first.position) + 4 + this.last.length + 16;
        }
        return (((this.last.position + 4) + this.last.length) + this.fileLength) - this.first.position;
    }

    private int remainingBytes() {
        return this.fileLength - usedBytes();
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    private void expandIfNecessary(int i) throws IOException {
        int i2 = i + 4;
        int remainingBytes = remainingBytes();
        if (remainingBytes < i2) {
            int i3 = this.fileLength;
            do {
                remainingBytes += i3;
                i3 <<= 1;
            } while (remainingBytes < i2);
            setLength(i3);
            int wrapPosition = wrapPosition(this.last.position + 4 + this.last.length);
            if (wrapPosition < this.first.position) {
                FileChannel channel = this.raf.getChannel();
                channel.position((long) this.fileLength);
                long j = (long) (wrapPosition - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.last.position < this.first.position) {
                int i4 = (this.fileLength + this.last.position) - 16;
                writeHeader(i3, this.elementCount, this.first.position, i4);
                this.last = new Element(i4, this.last.length);
            } else {
                writeHeader(i3, this.elementCount, this.first.position, this.last.position);
            }
            this.fileLength = i3;
        }
    }

    private void setLength(int i) throws IOException {
        this.raf.setLength((long) i);
        this.raf.getChannel().force(true);
    }

    public synchronized byte[] peek() throws IOException {
        if (isEmpty()) {
            return null;
        }
        int i = this.first.length;
        byte[] bArr = new byte[i];
        ringRead(this.first.position + 4, bArr, 0, i);
        return bArr;
    }

    public synchronized void peek(ElementReader elementReader) throws IOException {
        if (this.elementCount > 0) {
            elementReader.read(new ElementInputStream(this.first), this.first.length);
        }
    }

    public synchronized void forEach(ElementReader elementReader) throws IOException {
        int i = this.first.position;
        for (int i2 = 0; i2 < this.elementCount; i2++) {
            Element readElement = readElement(i);
            elementReader.read(new ElementInputStream(readElement), readElement.length);
            i = wrapPosition(readElement.position + 4 + readElement.length);
        }
    }

    /* access modifiers changed from: private */
    public static <T> T nonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    private final class ElementInputStream extends InputStream {
        private int position;
        private int remaining;

        private ElementInputStream(Element element) {
            this.position = QueueFile.this.wrapPosition(element.position + 4);
            this.remaining = element.length;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            Object unused = QueueFile.nonNull(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.remaining;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            QueueFile.this.ringRead(this.position, bArr, i, i2);
            this.position = QueueFile.this.wrapPosition(this.position + i2);
            this.remaining -= i2;
            return i2;
        }

        public int read() throws IOException {
            if (this.remaining == 0) {
                return -1;
            }
            QueueFile.this.raf.seek((long) this.position);
            int read = QueueFile.this.raf.read();
            this.position = QueueFile.this.wrapPosition(this.position + 1);
            this.remaining--;
            return read;
        }
    }

    public synchronized int size() {
        return this.elementCount;
    }

    public synchronized void remove() throws IOException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (this.elementCount == 1) {
            clear();
        } else {
            int wrapPosition = wrapPosition(this.first.position + 4 + this.first.length);
            ringRead(wrapPosition, this.buffer, 0, 4);
            int readInt = readInt(this.buffer, 0);
            writeHeader(this.fileLength, this.elementCount - 1, wrapPosition, this.last.position);
            this.elementCount--;
            this.first = new Element(wrapPosition, readInt);
        }
    }

    public synchronized void clear() throws IOException {
        writeHeader(4096, 0, 0, 0);
        this.elementCount = 0;
        this.first = Element.NULL;
        this.last = Element.NULL;
        if (this.fileLength > 4096) {
            setLength(4096);
        }
        this.fileLength = 4096;
    }

    public synchronized void close() throws IOException {
        this.raf.close();
    }

    public boolean hasSpaceFor(int i, int i2) {
        return (usedBytes() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("[fileLength=");
        sb.append(this.fileLength);
        sb.append(", size=").append(this.elementCount);
        sb.append(", first=").append(this.first);
        sb.append(", last=").append(this.last);
        sb.append(", element lengths=[");
        try {
            forEach(new ElementReader() {
                boolean first = true;

                public void read(InputStream inputStream, int i) throws IOException {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "read error", e);
        }
        sb.append("]]");
        return sb.toString();
    }

    static class Element {
        static final int HEADER_LENGTH = 4;
        static final Element NULL = new Element(0, 0);
        final int length;
        final int position;

        Element(int i, int i2) {
            this.position = i;
            this.length = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.position + ", length = " + this.length + "]";
        }
    }
}
