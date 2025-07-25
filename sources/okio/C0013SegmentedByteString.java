package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.SegmentedByteString;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\r\u0010 \u001a\u00020\u0015H\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006E"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "copyInto", "", "offset", "", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "equals", "", "other", "", "getSize", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "otherOffset", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: okio.SegmentedByteString  reason: case insensitive filesystem */
/* compiled from: SegmentedByteString.kt */
public final class C0013SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0013SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.getData$okio());
        Intrinsics.checkNotNullParameter(bArr, "segments");
        Intrinsics.checkNotNullParameter(iArr, "directory");
        this.segments = bArr;
        this.directory = iArr;
    }

    public String string(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return toByteString().string(charset);
    }

    public String base64() {
        return toByteString().base64();
    }

    public String hex() {
        return toByteString().hex();
    }

    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public ByteString digest$okio(String str) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = ((Object[]) getSegments$okio()).length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            instance.update(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] digest = instance.digest();
        Intrinsics.checkNotNull(digest);
        return new ByteString(digest);
    }

    public ByteString hmac$okio(String str, ByteString byteString) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        Intrinsics.checkNotNullParameter(byteString, "key");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = ((Object[]) getSegments$okio()).length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = getDirectory$okio()[length + i];
                int i4 = getDirectory$okio()[i];
                instance.update(getSegments$okio()[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            byte[] doFinal = instance.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String base64Url() {
        return toByteString().base64Url();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return asReadOnlyBuffer;
    }

    public int indexOf(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return toByteString().indexOf(bArr, i);
    }

    public int lastIndexOf(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return toByteString().lastIndexOf(bArr, i);
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    public byte[] internalArray$okio() {
        return toByteArray();
    }

    public String toString() {
        return toByteString().toString();
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        Intrinsics.checkNotNull(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }

    public ByteString substring(int i, int i2) {
        ByteString byteString = this;
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString, i2);
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        } else if (resolveDefaultParameter <= size()) {
            int i3 = resolveDefaultParameter - i;
            if (i3 < 0) {
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i).toString());
            } else if (i == 0 && resolveDefaultParameter == size()) {
                return byteString;
            } else {
                if (i == resolveDefaultParameter) {
                    return ByteString.EMPTY;
                }
                int segment = SegmentedByteString.segment(this, i);
                int segment2 = SegmentedByteString.segment(this, resolveDefaultParameter - 1);
                byte[][] bArr = (byte[][]) ArraysKt.copyOfRange((T[]) (Object[]) getSegments$okio(), segment, segment2 + 1);
                Object[] objArr = (Object[]) bArr;
                int[] iArr = new int[(objArr.length * 2)];
                int i4 = 0;
                if (segment <= segment2) {
                    int i5 = segment;
                    int i6 = 0;
                    while (true) {
                        iArr[i6] = Math.min(getDirectory$okio()[i5] - i, i3);
                        int i7 = i6 + 1;
                        iArr[i6 + objArr.length] = getDirectory$okio()[((Object[]) getSegments$okio()).length + i5];
                        if (i5 == segment2) {
                            break;
                        }
                        i5++;
                        i6 = i7;
                    }
                }
                if (segment != 0) {
                    i4 = getDirectory$okio()[segment - 1];
                }
                int length = objArr.length;
                iArr[length] = iArr[length] + (i - i4);
                return new C0013SegmentedByteString(bArr, iArr);
            }
        } else {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + ')').toString());
        }
    }

    public byte internalGet$okio(int i) {
        int i2;
        SegmentedByteString.checkOffsetAndCount((long) getDirectory$okio()[((Object[]) getSegments$okio()).length - 1], (long) i, 1);
        int segment = SegmentedByteString.segment(this, i);
        if (segment == 0) {
            i2 = 0;
        } else {
            i2 = getDirectory$okio()[segment - 1];
        }
        return getSegments$okio()[segment][(i - i2) + getDirectory$okio()[((Object[]) getSegments$okio()).length + segment]];
    }

    public int getSize$okio() {
        return getDirectory$okio()[((Object[]) getSegments$okio()).length - 1];
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = ((Object[]) getSegments$okio()).length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            int i6 = i5 - i2;
            ArraysKt.copyInto(getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public void write(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        int length = ((Object[]) getSegments$okio()).length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            outputStream.write(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    public void write$okio(Buffer buffer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i4 = i + i2;
        int segment = SegmentedByteString.segment(this, i);
        while (i < i4) {
            if (segment == 0) {
                i3 = 0;
            } else {
                i3 = getDirectory$okio()[segment - 1];
            }
            int i5 = getDirectory$okio()[((Object[]) getSegments$okio()).length + segment];
            int min = Math.min(i4, (getDirectory$okio()[segment] - i3) + i3) - i;
            int i6 = i5 + (i - i3);
            Segment segment2 = new Segment(getSegments$okio()[segment], i6, i6 + min, true, false);
            if (buffer.head == null) {
                segment2.prev = segment2;
                segment2.next = segment2.prev;
                buffer.head = segment2.next;
            } else {
                Segment segment3 = buffer.head;
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            i += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i2));
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(byteString, "other");
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int i5 = i3 + i;
        int segment = SegmentedByteString.segment(this, i);
        while (i < i5) {
            if (segment == 0) {
                i4 = 0;
            } else {
                i4 = getDirectory$okio()[segment - 1];
            }
            int i6 = getDirectory$okio()[((Object[]) getSegments$okio()).length + segment];
            int min = Math.min(i5, (getDirectory$okio()[segment] - i4) + i4) - i;
            if (!byteString.rangeEquals(i2, getSegments$okio()[segment], i6 + (i - i4), min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(bArr, "other");
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i5 = i3 + i;
        int segment = SegmentedByteString.segment(this, i);
        while (i < i5) {
            if (segment == 0) {
                i4 = 0;
            } else {
                i4 = getDirectory$okio()[segment - 1];
            }
            int i6 = getDirectory$okio()[((Object[]) getSegments$okio()).length + segment];
            int min = Math.min(i5, (getDirectory$okio()[segment] - i4) + i4) - i;
            if (!SegmentedByteString.arrayRangeEquals(getSegments$okio()[segment], i6 + (i - i4), bArr, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    public void copyInto(int i, byte[] bArr, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(bArr, "target");
        long j = (long) i3;
        SegmentedByteString.checkOffsetAndCount((long) size(), (long) i, j);
        long j2 = j;
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i2, j2);
        int i5 = i3 + i;
        int segment = SegmentedByteString.segment(this, i);
        while (i < i5) {
            if (segment == 0) {
                i4 = 0;
            } else {
                i4 = getDirectory$okio()[segment - 1];
            }
            int i6 = getDirectory$okio()[((Object[]) getSegments$okio()).length + segment];
            int min = Math.min(i5, (getDirectory$okio()[segment] - i4) + i4) - i;
            int i7 = i6 + (i - i4);
            ArraysKt.copyInto(getSegments$okio()[segment], bArr, i2, i7, i7 + min);
            i2 += min;
            i += min;
            segment++;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == size() && rangeEquals(0, byteString, 0, size());
        }
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = ((Object[]) getSegments$okio()).length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            byte[] bArr = getSegments$okio()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        setHashCode$okio(i2);
        return i2;
    }
}
