package okio;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000\u001a-\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\u00060\u0001j\u0002`\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\bø\u0001\u0000¢\u0006\u0002\u0010\u000b*\n\u0010\f\"\u00020\r2\u00020\r*\n\u0010\u000e\"\u00020\u000f2\u00020\u000f*\n\u0010\u0010\"\u00020\u00112\u00020\u0011*\n\u0010\u0012\"\u00020\u00132\u00020\u0013*\n\u0010\u0014\"\u00020\u00152\u00020\u0015*\n\u0010\u0016\"\u00020\u00172\u00020\u0017*\n\u0010\u0018\"\u00020\u00192\u00020\u0019*\n\u0010\u001a\"\u00020\u00012\u00020\u0001*\n\u0010\u001b\"\u00020\u001c2\u00020\u001c\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001d"}, d2 = {"newLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lokio/Lock;", "asUtf8ToByteArray", "", "", "toUtf8String", "withLock", "T", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "Closeable", "Ljava/io/Closeable;", "Deflater", "Ljava/util/zip/Deflater;", "EOFException", "Ljava/io/EOFException;", "FileNotFoundException", "Ljava/io/FileNotFoundException;", "IOException", "Ljava/io/IOException;", "Inflater", "Ljava/util/zip/Inflater;", "Lock", "ProtocolException", "Ljava/net/ProtocolException;", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: -JvmPlatform.kt */
public final class _JvmPlatformKt {
    public static final String toUtf8String(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, Charsets.UTF_8);
    }

    public static final byte[] asUtf8ToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    public static final <T> T withLock(ReentrantLock reentrantLock, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(reentrantLock, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        Lock lock = reentrantLock;
        lock.lock();
        try {
            return function0.invoke();
        } finally {
            lock.unlock();
        }
    }
}
