package okhttp3.internal.concurrent;

import androidx.compose.animation.core.AnimationKt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 #2\u00020\u0001:\u0003\"#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016J\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\tJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner;", "", "backend", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "busyQueues", "", "Lokhttp3/internal/concurrent/TaskQueue;", "coordinatorWaiting", "", "coordinatorWakeUpAt", "", "nextQueueName", "", "readyQueues", "runnable", "Ljava/lang/Runnable;", "activeQueues", "", "afterRun", "", "task", "Lokhttp3/internal/concurrent/Task;", "delayNanos", "awaitTaskToRun", "beforeRun", "cancelAll", "kickCoordinator", "taskQueue", "kickCoordinator$okhttp", "newQueue", "runTask", "Backend", "Companion", "RealBackend", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TaskRunner.kt */
public final class TaskRunner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final TaskRunner INSTANCE = new TaskRunner(new RealBackend(Util.threadFactory(Util.okHttpName + " TaskRunner", true)));
    /* access modifiers changed from: private */
    public static final Logger logger;
    private final Backend backend;
    private final List<TaskQueue> busyQueues = new ArrayList();
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private int nextQueueName = 10000;
    private final List<TaskQueue> readyQueues = new ArrayList();
    private final Runnable runnable = new TaskRunner$runnable$1(this);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TaskRunner.kt */
    public interface Backend {
        void beforeTask(TaskRunner taskRunner);

        void coordinatorNotify(TaskRunner taskRunner);

        void coordinatorWait(TaskRunner taskRunner, long j);

        void execute(Runnable runnable);

        long nanoTime();
    }

    public TaskRunner(Backend backend2) {
        Intrinsics.checkNotNullParameter(backend2, "backend");
        this.backend = backend2;
    }

    public final Backend getBackend() {
        return this.backend;
    }

    public final TaskQueue newQueue() {
        int i;
        synchronized (this) {
            i = this.nextQueueName;
            this.nextQueueName = i + 1;
        }
        return new TaskQueue(this, "Q" + i);
    }

    public final List<TaskQueue> activeQueues() {
        List<TaskQueue> plus;
        synchronized (this) {
            plus = CollectionsKt.plus(this.busyQueues, this.readyQueues);
        }
        return plus;
    }

    public final void cancelAll() {
        int size = this.busyQueues.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            }
            this.busyQueues.get(size).cancelAllAndDecide$okhttp();
        }
        for (int size2 = this.readyQueues.size() - 1; -1 < size2; size2--) {
            TaskQueue taskQueue = this.readyQueues.get(size2);
            taskQueue.cancelAllAndDecide$okhttp();
            if (taskQueue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(size2);
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "shutdown", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TaskRunner.kt */
    public static final class RealBackend implements Backend {
        private final ThreadPoolExecutor executor;

        public void beforeTask(TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        }

        public RealBackend(ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        public long nanoTime() {
            return System.nanoTime();
        }

        public void coordinatorWait(TaskRunner taskRunner, long j) throws InterruptedException {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            long j2 = j / AnimationKt.MillisToNanos;
            long j3 = j - (AnimationKt.MillisToNanos * j2);
            if (j2 > 0 || j > 0) {
                taskRunner.wait(j2, (int) j3);
            }
        }

        public void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.executor.execute(runnable);
        }

        public final void shutdown() {
            this.executor.shutdown();
        }

        public void coordinatorNotify(TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Companion;", "", "()V", "INSTANCE", "Lokhttp3/internal/concurrent/TaskRunner;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TaskRunner.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Logger getLogger() {
            return TaskRunner.logger;
        }
    }

    static {
        Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(TaskRunner::class.java.name)");
        logger = logger2;
    }

    public final void kickCoordinator$okhttp(TaskQueue taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            if (taskQueue.getActiveTask$okhttp() == null) {
                if (!taskQueue.getFutureTasks$okhttp().isEmpty()) {
                    Util.addIfAbsent(this.readyQueues, taskQueue);
                } else {
                    this.readyQueues.remove(taskQueue);
                }
            }
            if (this.coordinatorWaiting) {
                this.backend.coordinatorNotify(this);
            } else {
                this.backend.execute(this.runnable);
            }
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
    }

    private final void beforeRun(Task task) {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            task.setNextExecuteNanoTime$okhttp(-1);
            TaskQueue queue$okhttp = task.getQueue$okhttp();
            Intrinsics.checkNotNull(queue$okhttp);
            queue$okhttp.getFutureTasks$okhttp().remove(task);
            this.readyQueues.remove(queue$okhttp);
            queue$okhttp.setActiveTask$okhttp(task);
            this.busyQueues.add(queue$okhttp);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    /* access modifiers changed from: private */
    public final void runTask(Task task) {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName(task.getName());
            try {
                long runOnce = task.runOnce();
                synchronized (this) {
                    afterRun(task, runOnce);
                    Unit unit = Unit.INSTANCE;
                }
                currentThread.setName(name);
            } catch (Throwable th) {
                synchronized (this) {
                    afterRun(task, -1);
                    Unit unit2 = Unit.INSTANCE;
                    currentThread.setName(name);
                    throw th;
                }
            }
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
    }

    private final void afterRun(Task task, long j) {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            TaskQueue queue$okhttp = task.getQueue$okhttp();
            Intrinsics.checkNotNull(queue$okhttp);
            if (queue$okhttp.getActiveTask$okhttp() == task) {
                boolean cancelActiveTask$okhttp = queue$okhttp.getCancelActiveTask$okhttp();
                queue$okhttp.setCancelActiveTask$okhttp(false);
                queue$okhttp.setActiveTask$okhttp((Task) null);
                this.busyQueues.remove(queue$okhttp);
                if (j != -1 && !cancelActiveTask$okhttp && !queue$okhttp.getShutdown$okhttp()) {
                    queue$okhttp.scheduleAndDecide$okhttp(task, j, true);
                }
                if (!queue$okhttp.getFutureTasks$okhttp().isEmpty()) {
                    this.readyQueues.add(queue$okhttp);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00bf */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.internal.concurrent.Task awaitTaskToRun() {
        /*
            r14 = this;
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L_0x0032
            boolean r0 = java.lang.Thread.holdsLock(r14)
            if (r0 == 0) goto L_0x000b
            goto L_0x0032
        L_0x000b:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Thread "
            r1.<init>(r2)
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " MUST hold lock on "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0032:
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r14.readyQueues
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x003c
            return r1
        L_0x003c:
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r14.backend
            long r2 = r0.nanoTime()
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r14.readyQueues
            java.util.Iterator r0 = r0.iterator()
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = r1
        L_0x004e:
            boolean r7 = r0.hasNext()
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x0080
            java.lang.Object r7 = r0.next()
            okhttp3.internal.concurrent.TaskQueue r7 = (okhttp3.internal.concurrent.TaskQueue) r7
            java.util.List r7 = r7.getFutureTasks$okhttp()
            java.lang.Object r7 = r7.get(r9)
            okhttp3.internal.concurrent.Task r7 = (okhttp3.internal.concurrent.Task) r7
            long r10 = r7.getNextExecuteNanoTime$okhttp()
            long r10 = r10 - r2
            r12 = 0
            long r10 = java.lang.Math.max(r12, r10)
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x007a
            long r4 = java.lang.Math.min(r10, r4)
            goto L_0x004e
        L_0x007a:
            if (r6 == 0) goto L_0x007e
            r0 = r8
            goto L_0x0081
        L_0x007e:
            r6 = r7
            goto L_0x004e
        L_0x0080:
            r0 = r9
        L_0x0081:
            if (r6 == 0) goto L_0x009e
            r14.beforeRun(r6)
            if (r0 != 0) goto L_0x0096
            boolean r0 = r14.coordinatorWaiting
            if (r0 != 0) goto L_0x009d
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r14.readyQueues
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x009d
        L_0x0096:
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r14.backend
            java.lang.Runnable r1 = r14.runnable
            r0.execute(r1)
        L_0x009d:
            return r6
        L_0x009e:
            boolean r0 = r14.coordinatorWaiting
            if (r0 == 0) goto L_0x00af
            long r6 = r14.coordinatorWakeUpAt
            long r6 = r6 - r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ae
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r14.backend
            r0.coordinatorNotify(r14)
        L_0x00ae:
            return r1
        L_0x00af:
            r14.coordinatorWaiting = r8
            long r2 = r2 + r4
            r14.coordinatorWakeUpAt = r2
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r14.backend     // Catch:{ InterruptedException -> 0x00bf }
            r0.coordinatorWait(r14, r4)     // Catch:{ InterruptedException -> 0x00bf }
        L_0x00b9:
            r14.coordinatorWaiting = r9
            goto L_0x0032
        L_0x00bd:
            r0 = move-exception
            goto L_0x00c3
        L_0x00bf:
            r14.cancelAll()     // Catch:{ all -> 0x00bd }
            goto L_0x00b9
        L_0x00c3:
            r14.coordinatorWaiting = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskRunner.awaitTaskToRun():okhttp3.internal.concurrent.Task");
    }
}
