package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"okio/AsyncTimeout$sink$1", "Lokio/Sink;", "close", "", "flush", "timeout", "Lokio/AsyncTimeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AsyncTimeout.kt */
public final class AsyncTimeout$sink$1 implements Sink {
    final /* synthetic */ Sink $sink;
    final /* synthetic */ AsyncTimeout this$0;

    AsyncTimeout$sink$1(AsyncTimeout asyncTimeout, Sink sink) {
        this.this$0 = asyncTimeout;
        this.$sink = sink;
    }

    public void write(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, j);
        while (true) {
            long j2 = 0;
            if (j > 0) {
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += (long) (segment.limit - segment.pos);
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    } else {
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                    }
                }
                AsyncTimeout asyncTimeout = this.this$0;
                Sink sink = this.$sink;
                asyncTimeout.enter();
                try {
                    sink.write(buffer, j2);
                    Unit unit = Unit.INSTANCE;
                    if (!asyncTimeout.exit()) {
                        j -= j2;
                    } else {
                        throw asyncTimeout.access$newTimeoutException((IOException) null);
                    }
                } catch (IOException e) {
                    IOException iOException = e;
                    if (asyncTimeout.exit()) {
                        iOException = asyncTimeout.access$newTimeoutException(iOException);
                    }
                    throw iOException;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    asyncTimeout.exit();
                    throw th2;
                }
            } else {
                return;
            }
        }
    }

    public void flush() {
        AsyncTimeout asyncTimeout = this.this$0;
        Sink sink = this.$sink;
        asyncTimeout.enter();
        try {
            sink.flush();
            Unit unit = Unit.INSTANCE;
            if (asyncTimeout.exit()) {
                throw asyncTimeout.access$newTimeoutException((IOException) null);
            }
        } catch (IOException e) {
            e = e;
            if (asyncTimeout.exit()) {
                e = asyncTimeout.access$newTimeoutException(e);
            }
            throw e;
        } finally {
            asyncTimeout.exit();
        }
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.this$0;
        Sink sink = this.$sink;
        asyncTimeout.enter();
        try {
            sink.close();
            Unit unit = Unit.INSTANCE;
            if (asyncTimeout.exit()) {
                throw asyncTimeout.access$newTimeoutException((IOException) null);
            }
        } catch (IOException e) {
            e = e;
            if (asyncTimeout.exit()) {
                e = asyncTimeout.access$newTimeoutException(e);
            }
            throw e;
        } finally {
            asyncTimeout.exit();
        }
    }

    public AsyncTimeout timeout() {
        return this.this$0;
    }

    public String toString() {
        return "AsyncTimeout.sink(" + this.$sink + ')';
    }
}
