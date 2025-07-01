package androidx.room.util;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileUtil {
    public static void copy(ReadableByteChannel readableByteChannel, FileChannel fileChannel) throws IOException {
        ReadableByteChannel readableByteChannel2 = readableByteChannel;
        FileChannel fileChannel2 = fileChannel;
        try {
            fileChannel2.transferFrom(readableByteChannel2, 0, Long.MAX_VALUE);
            fileChannel2.force(false);
            readableByteChannel2.close();
            fileChannel2.close();
        } catch (Throwable th) {
            Throwable th2 = th;
            readableByteChannel2.close();
            fileChannel2.close();
            throw th2;
        }
    }

    private FileUtil() {
    }
}
