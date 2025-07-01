package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\fH\u0014J%\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001bH\bø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001f"}, d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "next", "state", "", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "cancel", "", "enter", "exit", "", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AsyncTimeout.kt */
public class AsyncTimeout extends Timeout {
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long IDLE_TIMEOUT_MILLIS;
    /* access modifiers changed from: private */
    public static final long IDLE_TIMEOUT_NANOS;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    /* access modifiers changed from: private */
    public static final Condition condition;
    /* access modifiers changed from: private */
    public static AsyncTimeout head;
    /* access modifiers changed from: private */
    public static final ReentrantLock lock;
    /* access modifiers changed from: private */
    public AsyncTimeout next;
    /* access modifiers changed from: private */
    public int state;
    /* access modifiers changed from: private */
    public long timeoutAt;

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            Lock lock2 = lock;
            lock2.lock();
            try {
                if (this.state == 0) {
                    this.state = 1;
                    Companion.insertIntoQueue(this, timeoutNanos, hasDeadline);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                throw new IllegalStateException("Unbalanced enter/exit".toString());
            } finally {
                lock2.unlock();
            }
        }
    }

    public final boolean exit() {
        Lock lock2 = lock;
        lock2.lock();
        try {
            int i = this.state;
            boolean z = false;
            this.state = 0;
            if (i == 1) {
                Companion.removeFromQueue(this);
                return false;
            }
            if (i == 2) {
                z = true;
            }
            lock2.unlock();
            return z;
        } finally {
            lock2.unlock();
        }
    }

    public void cancel() {
        super.cancel();
        Lock lock2 = lock;
        lock2.lock();
        try {
            if (this.state == 1) {
                Companion.removeFromQueue(this);
                this.state = 3;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: private */
    public final long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    public final Sink sink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new AsyncTimeout$sink$1(this, sink);
    }

    public final Source source(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new AsyncTimeout$source$1(this, source);
    }

    public final <T> T withTimeout(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        enter();
        try {
            T invoke = function0.invoke();
            if (!exit()) {
                return invoke;
            }
            throw access$newTimeoutException((IOException) null);
        } catch (IOException e) {
            e = e;
            if (exit()) {
                e = access$newTimeoutException(e);
            }
            throw e;
        } finally {
            exit();
        }
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AsyncTimeout.kt */
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|(5:5|6|7|19|8)(5:9|10|11|12|(2:14|23)(1:22))|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
            r0.unlock();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
            throw r1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:18:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                okio.AsyncTimeout$Companion r0 = okio.AsyncTimeout.Companion     // Catch:{ InterruptedException -> 0x0000 }
                java.util.concurrent.locks.ReentrantLock r0 = r0.getLock()     // Catch:{ InterruptedException -> 0x0000 }
                java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0     // Catch:{ InterruptedException -> 0x0000 }
                r0.lock()     // Catch:{ InterruptedException -> 0x0000 }
                okio.AsyncTimeout$Companion r1 = okio.AsyncTimeout.Companion     // Catch:{ all -> 0x0031 }
                okio.AsyncTimeout r1 = r1.awaitTimeout()     // Catch:{ all -> 0x0031 }
                okio.AsyncTimeout r2 = okio.AsyncTimeout.head     // Catch:{ all -> 0x0031 }
                if (r1 != r2) goto L_0x0026
                okio.AsyncTimeout.Companion unused = okio.AsyncTimeout.Companion     // Catch:{ all -> 0x0031 }
                r1 = 0
                okio.AsyncTimeout.head = r1     // Catch:{ all -> 0x0031 }
                r0.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                return
            L_0x0026:
                kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0031 }
                r0.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                if (r1 == 0) goto L_0x0000
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0031:
                r1 = move-exception
                r0.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "STATE_CANCELED", "", "STATE_IDLE", "STATE_IN_QUEUE", "STATE_TIMED_OUT", "TIMEOUT_WRITE_SIZE", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "head", "Lokio/AsyncTimeout;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "awaitTimeout", "insertIntoQueue", "", "node", "timeoutNanos", "hasDeadline", "", "removeFromQueue", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AsyncTimeout.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReentrantLock getLock() {
            return AsyncTimeout.lock;
        }

        public final Condition getCondition() {
            return AsyncTimeout.condition;
        }

        /* access modifiers changed from: private */
        public final void insertIntoQueue(AsyncTimeout asyncTimeout, long j, boolean z) {
            if (AsyncTimeout.head == null) {
                AsyncTimeout.head = new AsyncTimeout();
                new Watchdog().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (i != 0) {
                asyncTimeout.timeoutAt = j + nanoTime;
            } else if (z) {
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long access$remainingNanos = asyncTimeout.remainingNanos(nanoTime);
            AsyncTimeout access$getHead$cp = AsyncTimeout.head;
            Intrinsics.checkNotNull(access$getHead$cp);
            while (access$getHead$cp.next != null) {
                AsyncTimeout access$getNext$p = access$getHead$cp.next;
                Intrinsics.checkNotNull(access$getNext$p);
                if (access$remainingNanos < access$getNext$p.remainingNanos(nanoTime)) {
                    break;
                }
                access$getHead$cp = access$getHead$cp.next;
                Intrinsics.checkNotNull(access$getHead$cp);
            }
            asyncTimeout.next = access$getHead$cp.next;
            access$getHead$cp.next = asyncTimeout;
            if (access$getHead$cp == AsyncTimeout.head) {
                getCondition().signal();
            }
        }

        /* access modifiers changed from: private */
        public final void removeFromQueue(AsyncTimeout asyncTimeout) {
            for (AsyncTimeout access$getHead$cp = AsyncTimeout.head; access$getHead$cp != null; access$getHead$cp = access$getHead$cp.next) {
                if (access$getHead$cp.next == asyncTimeout) {
                    access$getHead$cp.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return;
                }
            }
            throw new IllegalStateException("node was not found in the queue".toString());
        }

        public final AsyncTimeout awaitTimeout() throws InterruptedException {
            AsyncTimeout access$getHead$cp = AsyncTimeout.head;
            Intrinsics.checkNotNull(access$getHead$cp);
            AsyncTimeout access$getNext$p = access$getHead$cp.next;
            if (access$getNext$p == null) {
                long nanoTime = System.nanoTime();
                getCondition().await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                AsyncTimeout access$getHead$cp2 = AsyncTimeout.head;
                Intrinsics.checkNotNull(access$getHead$cp2);
                if (access$getHead$cp2.next != null || System.nanoTime() - nanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long access$remainingNanos = access$getNext$p.remainingNanos(System.nanoTime());
            if (access$remainingNanos > 0) {
                getCondition().await(access$remainingNanos, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout access$getHead$cp3 = AsyncTimeout.head;
            Intrinsics.checkNotNull(access$getHead$cp3);
            access$getHead$cp3.next = access$getNext$p.next;
            access$getNext$p.next = null;
            access$getNext$p.state = 2;
            return access$getNext$p;
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(newCondition, "newCondition(...)");
        condition = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }
}
