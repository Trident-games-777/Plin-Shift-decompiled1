package coil3.network;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH@¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@¢\u0006\u0004\b\n\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u001c"}, d2 = {"Lcoil3/network/SourceResponseBody;", "Lcoil3/network/NetworkResponseBody;", "source", "Lokio/BufferedSource;", "constructor-impl", "(Lokio/BufferedSource;)Lokio/BufferedSource;", "writeTo", "", "sink", "Lokio/BufferedSink;", "writeTo-impl", "(Lokio/BufferedSource;Lokio/BufferedSink;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "(Lokio/BufferedSource;Lokio/FileSystem;Lokio/Path;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "close-impl", "(Lokio/BufferedSource;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* compiled from: NetworkClient.kt */
final class SourceResponseBody implements NetworkResponseBody {
    private final BufferedSource source;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SourceResponseBody m7513boximpl(BufferedSource bufferedSource) {
        return new SourceResponseBody(bufferedSource);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static BufferedSource m7515constructorimpl(BufferedSource bufferedSource) {
        return bufferedSource;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7516equalsimpl(BufferedSource bufferedSource, Object obj) {
        return (obj instanceof SourceResponseBody) && Intrinsics.areEqual((Object) bufferedSource, (Object) ((SourceResponseBody) obj).m7522unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7517equalsimpl0(BufferedSource bufferedSource, BufferedSource bufferedSource2) {
        return Intrinsics.areEqual((Object) bufferedSource, (Object) bufferedSource2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7518hashCodeimpl(BufferedSource bufferedSource) {
        return bufferedSource.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7519toStringimpl(BufferedSource bufferedSource) {
        return "SourceResponseBody(source=" + bufferedSource + ')';
    }

    public boolean equals(Object obj) {
        return m7516equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m7518hashCodeimpl(this.source);
    }

    public String toString() {
        return m7519toStringimpl(this.source);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ BufferedSource m7522unboximpl() {
        return this.source;
    }

    private /* synthetic */ SourceResponseBody(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public Object writeTo(BufferedSink bufferedSink, Continuation<? super Unit> continuation) {
        return m7520writeToimpl(this.source, bufferedSink, continuation);
    }

    /* renamed from: writeTo-impl  reason: not valid java name */
    public static Object m7520writeToimpl(BufferedSource bufferedSource, BufferedSink bufferedSink, Continuation<? super Unit> continuation) {
        bufferedSource.readAll(bufferedSink);
        return Unit.INSTANCE;
    }

    public Object writeTo(FileSystem fileSystem, Path path, Continuation<? super Unit> continuation) {
        return m7521writeToimpl(this.source, fileSystem, path, continuation);
    }

    public void close() {
        m7514closeimpl(this.source);
    }

    /* renamed from: close-impl  reason: not valid java name */
    public static void m7514closeimpl(BufferedSource bufferedSource) {
        bufferedSource.close();
    }

    /* renamed from: writeTo-impl  reason: not valid java name */
    public static Object m7521writeToimpl(BufferedSource bufferedSource, FileSystem fileSystem, Path path, Continuation<? super Unit> continuation) {
        Closeable buffer = Okio.buffer(fileSystem.sink(path, false));
        try {
            Boxing.boxLong(bufferedSource.readAll((BufferedSink) buffer));
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th) {
                    th = th;
                }
            }
            th = null;
        } catch (Throwable th2) {
            ExceptionsKt.addSuppressed(th, th2);
        }
        if (th == null) {
            return Unit.INSTANCE;
        }
        throw th;
    }
}
