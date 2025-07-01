package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {890, 910, 911}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.$recomposeCoroutineContext = coroutineContext;
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(this.$recomposeCoroutineContext, this.this$0, continuation);
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = monotonicFrameClock;
        return recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c7, code lost:
        if (r1.this$0.awaitWorkAvailable(r1) == r0) goto L_0x01c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b8, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(kotlinx.coroutines.JobKt.getJob(r9.getCoroutineContext()), r1) == r0) goto L_0x01c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c6, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r2, r1) == r0) goto L_0x01c8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r7) goto L_0x002b
            if (r2 == r4) goto L_0x0022
            if (r2 != r3) goto L_0x001a
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x01c9
        L_0x001a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0022:
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x01bb
        L_0x002b:
            java.lang.Object r2 = r1.L$2
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r8 = r1.L$1
            androidx.compose.runtime.ProduceFrameSignal r8 = (androidx.compose.runtime.ProduceFrameSignal) r8
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x00cb
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r1.L$0
            r8 = r2
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            java.lang.Object r2 = r1.L$1
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            kotlin.coroutines.CoroutineContext r9 = r1.$recomposeCoroutineContext
            kotlinx.coroutines.Job$Key r10 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r10 = (kotlin.coroutines.CoroutineContext.Key) r10
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r10)
            if (r9 != 0) goto L_0x0056
            r9 = r7
            goto L_0x0057
        L_0x0056:
            r9 = r5
        L_0x0057:
            kotlin.coroutines.CoroutineContext r10 = r1.$recomposeCoroutineContext
            if (r9 != 0) goto L_0x0075
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "recomposeCoroutineContext may not contain a Job; found "
            r9.<init>(r11)
            kotlinx.coroutines.Job$Key r11 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r11 = (kotlin.coroutines.CoroutineContext.Key) r11
            kotlin.coroutines.CoroutineContext$Element r10 = r10.get(r11)
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            androidx.compose.runtime.PreconditionsKt.throwIllegalArgumentException(r9)
        L_0x0075:
            kotlin.coroutines.CoroutineContext r9 = r8.getCoroutineContext()
            kotlin.coroutines.CoroutineContext r10 = r1.$recomposeCoroutineContext
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
            kotlin.coroutines.CoroutineContext r10 = r8.getCoroutineContext()
            kotlinx.coroutines.Job r10 = kotlinx.coroutines.JobKt.getJob(r10)
            kotlinx.coroutines.CompletableJob r10 = kotlinx.coroutines.JobKt.Job((kotlinx.coroutines.Job) r10)
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
            kotlinx.coroutines.CoroutineScope r14 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r9)
            androidx.compose.runtime.ProduceFrameSignal r15 = new androidx.compose.runtime.ProduceFrameSignal
            r15.<init>()
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1 r9 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1
            androidx.compose.runtime.Recomposer r10 = r1.this$0
            r9.<init>(r10, r2, r15, r6)
            r11 = r9
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 3
            r13 = 0
            r9 = 0
            r10 = 0
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
            r9 = r14
            r8 = r15
        L_0x00ae:
            androidx.compose.runtime.Recomposer r10 = r1.this$0
            boolean r10 = r10.getShouldKeepRecomposing()
            if (r10 == 0) goto L_0x01a1
            androidx.compose.runtime.Recomposer r10 = r1.this$0
            r11 = r1
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r1.L$0 = r9
            r1.L$1 = r8
            r1.L$2 = r2
            r1.label = r7
            java.lang.Object r10 = r10.awaitWorkAvailable(r11)
            if (r10 != r0) goto L_0x00cb
            goto L_0x01c8
        L_0x00cb:
            androidx.compose.runtime.Recomposer r15 = r1.this$0
            java.lang.Object r10 = r15.stateLock
            monitor-enter(r10)
            androidx.collection.MutableScatterSet r11 = r15.snapshotInvalidations     // Catch:{ all -> 0x019e }
            boolean r12 = r11.isNotEmpty()     // Catch:{ all -> 0x019e }
            if (r12 == 0) goto L_0x00e4
            androidx.collection.MutableScatterSet r12 = new androidx.collection.MutableScatterSet     // Catch:{ all -> 0x019e }
            r12.<init>(r5, r7, r6)     // Catch:{ all -> 0x019e }
            r15.snapshotInvalidations = r12     // Catch:{ all -> 0x019e }
        L_0x00e4:
            monitor-exit(r10)
            androidx.collection.ScatterSet r11 = (androidx.collection.ScatterSet) r11
            java.util.Set r10 = androidx.compose.runtime.collection.ScatterSetWrapperKt.wrapIntoSet(r11)
            r11 = r10
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x010b
            java.util.List r11 = r15.getKnownCompositions()
            int r12 = r11.size()
            r13 = r5
        L_0x00fd:
            if (r13 >= r12) goto L_0x010b
            java.lang.Object r14 = r11.get(r13)
            androidx.compose.runtime.ControlledComposition r14 = (androidx.compose.runtime.ControlledComposition) r14
            r14.recordModificationsOf(r10)
            int r13 = r13 + 1
            goto L_0x00fd
        L_0x010b:
            androidx.compose.runtime.collection.MutableVector r10 = r15.compositionInvalidations
            int r11 = r10.getSize()
            if (r11 <= 0) goto L_0x0151
            java.lang.Object[] r16 = r10.getContent()
            r17 = r5
        L_0x011b:
            r10 = r16[r17]
            androidx.compose.runtime.ControlledComposition r10 = (androidx.compose.runtime.ControlledComposition) r10
            java.lang.Object r12 = r15.stateLock
            monitor-enter(r12)
            int r13 = r15.concurrentCompositionsOutstanding     // Catch:{ all -> 0x014e }
            int r13 = r13 + r7
            r15.concurrentCompositionsOutstanding = r13     // Catch:{ all -> 0x014e }
            monitor-exit(r12)
            kotlin.coroutines.CoroutineContext r12 = androidx.compose.runtime.CompositionKt.getRecomposeCoroutineContext(r10)
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2 r13 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2
            r13.<init>(r15, r10, r6)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r10 = r12
            r12 = r13
            r13 = 2
            r14 = 0
            r18 = r11
            r11 = 0
            r5 = r18
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
            int r10 = r17 + 1
            if (r10 < r5) goto L_0x0149
            goto L_0x0151
        L_0x0149:
            r11 = r5
            r17 = r10
            r5 = 0
            goto L_0x011b
        L_0x014e:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        L_0x0151:
            androidx.compose.runtime.collection.MutableVector r5 = r15.compositionInvalidations
            r5.clear()
            java.lang.Object r5 = r15.stateLock
            monitor-enter(r5)
            kotlinx.coroutines.CancellableContinuation r10 = r15.deriveStateLocked()     // Catch:{ all -> 0x019b }
            if (r10 != 0) goto L_0x018f
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x019b }
            monitor-exit(r5)
            androidx.compose.runtime.Recomposer r5 = r1.this$0
            java.lang.Object r5 = r5.stateLock
            androidx.compose.runtime.Recomposer r10 = r1.this$0
            monitor-enter(r5)
            boolean r10 = r10.getHasConcurrentFrameWorkLocked()     // Catch:{ all -> 0x018c }
            if (r10 == 0) goto L_0x017a
            kotlin.coroutines.Continuation r10 = r8.requestFrameLocked()     // Catch:{ all -> 0x018c }
            goto L_0x017b
        L_0x017a:
            r10 = r6
        L_0x017b:
            monitor-exit(r5)
            if (r10 == 0) goto L_0x0189
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.Object r5 = kotlin.Result.m7823constructorimpl(r5)
            r10.resumeWith(r5)
        L_0x0189:
            r5 = 0
            goto L_0x00ae
        L_0x018c:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x018f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x019b }
            java.lang.String r2 = "called outside of runRecomposeAndApplyChanges"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x019b }
            r0.<init>(r2)     // Catch:{ all -> 0x019b }
            throw r0     // Catch:{ all -> 0x019b }
        L_0x019b:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x019e:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L_0x01a1:
            kotlin.coroutines.CoroutineContext r5 = r9.getCoroutineContext()
            kotlinx.coroutines.Job r5 = kotlinx.coroutines.JobKt.getJob(r5)
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r1.L$0 = r2
            r1.L$1 = r6
            r1.L$2 = r6
            r1.label = r4
            java.lang.Object r4 = kotlinx.coroutines.JobKt.cancelAndJoin(r5, r7)
            if (r4 != r0) goto L_0x01bb
            goto L_0x01c8
        L_0x01bb:
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r1.L$0 = r6
            r1.label = r3
            java.lang.Object r2 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r4)
            if (r2 != r0) goto L_0x01c9
        L_0x01c8:
            return r0
        L_0x01c9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
