package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0012\u0010\n\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00040\fH\u0000\u001a;\u0010\r\u001a\u00020\u000b*\u0006\u0012\u0002\b\u00030\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED", "resumeCancellableWith", "", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "yieldUndispatched", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "executeUnconfined", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: DispatchedContinuation.kt */
public final class DispatchedContinuationKt {
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");
    /* access modifiers changed from: private */
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED");

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009d, code lost:
        if (r0.clearThreadContext() != false) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void resumeCancellableWith(kotlin.coroutines.Continuation<? super T> r7, java.lang.Object r8) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto L_0x00c3
            kotlinx.coroutines.internal.DispatchedContinuation r7 = (kotlinx.coroutines.internal.DispatchedContinuation) r7
            java.lang.Object r0 = kotlinx.coroutines.CompletionStateKt.toState(r8)
            kotlinx.coroutines.CoroutineDispatcher r1 = r7.dispatcher
            kotlin.coroutines.CoroutineContext r2 = r7.getContext()
            boolean r1 = r1.isDispatchNeeded(r2)
            r2 = 1
            if (r1 == 0) goto L_0x0028
            r7._state = r0
            r7.resumeMode = r2
            kotlinx.coroutines.CoroutineDispatcher r8 = r7.dispatcher
            kotlin.coroutines.CoroutineContext r0 = r7.getContext()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r8.dispatch(r0, r7)
            goto L_0x00bd
        L_0x0028:
            kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r1 = r1.getEventLoop$kotlinx_coroutines_core()
            boolean r3 = r1.isUnconfinedLoopActive()
            if (r3 == 0) goto L_0x0042
            r7._state = r0
            r7.resumeMode = r2
            kotlinx.coroutines.DispatchedTask r7 = (kotlinx.coroutines.DispatchedTask) r7
            r1.dispatchUnconfined(r7)
            goto L_0x00bd
        L_0x0042:
            r3 = r7
            kotlinx.coroutines.DispatchedTask r3 = (kotlinx.coroutines.DispatchedTask) r3
            r1.incrementUseCount(r2)
            kotlin.coroutines.CoroutineContext r4 = r7.getContext()     // Catch:{ all -> 0x00b6 }
            kotlinx.coroutines.Job$Key r5 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00b6 }
            kotlin.coroutines.CoroutineContext$Key r5 = (kotlin.coroutines.CoroutineContext.Key) r5     // Catch:{ all -> 0x00b6 }
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r5)     // Catch:{ all -> 0x00b6 }
            kotlinx.coroutines.Job r4 = (kotlinx.coroutines.Job) r4     // Catch:{ all -> 0x00b6 }
            if (r4 == 0) goto L_0x007a
            boolean r5 = r4.isActive()     // Catch:{ all -> 0x00b6 }
            if (r5 != 0) goto L_0x007a
            java.util.concurrent.CancellationException r8 = r4.getCancellationException()     // Catch:{ all -> 0x00b6 }
            r4 = r8
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x00b6 }
            r7.cancelCompletedResult$kotlinx_coroutines_core(r0, r4)     // Catch:{ all -> 0x00b6 }
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ all -> 0x00b6 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00b6 }
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ all -> 0x00b6 }
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)     // Catch:{ all -> 0x00b6 }
            java.lang.Object r8 = kotlin.Result.m7823constructorimpl(r8)     // Catch:{ all -> 0x00b6 }
            r7.resumeWith(r8)     // Catch:{ all -> 0x00b6 }
            goto L_0x00a2
        L_0x007a:
            kotlin.coroutines.Continuation<T> r0 = r7.continuation     // Catch:{ all -> 0x00b6 }
            java.lang.Object r4 = r7.countOrElement     // Catch:{ all -> 0x00b6 }
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()     // Catch:{ all -> 0x00b6 }
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r5, r4)     // Catch:{ all -> 0x00b6 }
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS     // Catch:{ all -> 0x00b6 }
            if (r4 == r6) goto L_0x008f
            kotlinx.coroutines.UndispatchedCoroutine r0 = kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(r0, r5, r4)     // Catch:{ all -> 0x00b6 }
            goto L_0x0090
        L_0x008f:
            r0 = 0
        L_0x0090:
            kotlin.coroutines.Continuation<T> r7 = r7.continuation     // Catch:{ all -> 0x00a9 }
            r7.resumeWith(r8)     // Catch:{ all -> 0x00a9 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x009f
            boolean r7 = r0.clearThreadContext()     // Catch:{ all -> 0x00b6 }
            if (r7 == 0) goto L_0x00a2
        L_0x009f:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r5, r4)     // Catch:{ all -> 0x00b6 }
        L_0x00a2:
            boolean r7 = r1.processUnconfinedEvent()     // Catch:{ all -> 0x00b6 }
            if (r7 != 0) goto L_0x00a2
            goto L_0x00ba
        L_0x00a9:
            r7 = move-exception
            if (r0 == 0) goto L_0x00b2
            boolean r8 = r0.clearThreadContext()     // Catch:{ all -> 0x00b6 }
            if (r8 == 0) goto L_0x00b5
        L_0x00b2:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r5, r4)     // Catch:{ all -> 0x00b6 }
        L_0x00b5:
            throw r7     // Catch:{ all -> 0x00b6 }
        L_0x00b6:
            r7 = move-exception
            r3.handleFatalException$kotlinx_coroutines_core(r7)     // Catch:{ all -> 0x00be }
        L_0x00ba:
            r1.decrementUseCount(r2)
        L_0x00bd:
            return
        L_0x00be:
            r7 = move-exception
            r1.decrementUseCount(r2)
            throw r7
        L_0x00c3:
            r7.resumeWith(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(kotlin.coroutines.Continuation, java.lang.Object):void");
    }

    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.INSTANCE;
        DebugKt.getASSERTIONS_ENABLED();
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        DispatchedTask dispatchedTask = dispatchedContinuation;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } catch (Throwable th) {
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            throw th;
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        return false;
    }

    private static final boolean executeUnconfined(DispatchedContinuation<?> dispatchedContinuation, Object obj, int i, boolean z, Function0<Unit> function0) {
        if (!DebugKt.getASSERTIONS_ENABLED() || i != -1) {
            EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
                return false;
            }
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = obj;
                dispatchedContinuation.resumeMode = i;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
                return true;
            }
            DispatchedTask dispatchedTask = dispatchedContinuation;
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                function0.invoke();
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            } catch (Throwable th) {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                throw th;
            }
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            return false;
        }
        throw new AssertionError();
    }

    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation dispatchedContinuation, Object obj, int i, boolean z, Function0 function0, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if (!DebugKt.getASSERTIONS_ENABLED() || i != -1) {
            EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
                return false;
            }
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = obj;
                dispatchedContinuation.resumeMode = i;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
                return true;
            }
            DispatchedTask dispatchedTask = dispatchedContinuation;
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                function0.invoke();
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            } catch (Throwable th) {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                throw th;
            }
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            return false;
        }
        throw new AssertionError();
    }
}
