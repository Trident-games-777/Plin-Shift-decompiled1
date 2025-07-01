package com.plinkofortune.cash.winspin.seq;

import com.plinkofortune.cash.winspin.seq.models.BallInScreen;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.seq.SeqViewModel$ballInScreenFinished$1", f = "SeqViewModel.kt", i = {0, 1}, l = {277, 63}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
/* compiled from: SeqViewModel.kt */
final class SeqViewModel$ballInScreenFinished$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BallInScreen $ball;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SeqViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeqViewModel$ballInScreenFinished$1(SeqViewModel seqViewModel, BallInScreen ballInScreen, Continuation<? super SeqViewModel$ballInScreenFinished$1> continuation) {
        super(2, continuation);
        this.this$0 = seqViewModel;
        this.$ball = ballInScreen;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeqViewModel$ballInScreenFinished$1(this.this$0, this.$ball, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeqViewModel$ballInScreenFinished$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0181, code lost:
        if (r6.doOnFinish(r1) == r0) goto L_0x0183;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            r34 = this;
            r1 = r34
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x001e
            java.lang.Object r0 = r1.L$0
            r2 = r0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r35)     // Catch:{ all -> 0x001b }
            goto L_0x0184
        L_0x001b:
            r0 = move-exception
            goto L_0x018c
        L_0x001e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r2 = 47
            byte[] r2 = new byte[r2]
            r2 = {34, -106, 89, 37, -110, 56, 34, 116, 102, -123, 80, 58, -57, 33, 40, 115, 97, -107, 80, 47, -35, 62, 40, 116, 102, -98, 91, 63, -35, 39, 40, 115, 97, -128, 92, 61, -38, 108, 46, 59, 51, -104, 64, 61, -37, 34, 40} // fill-array
            r3 = 8
            byte[] r3 = new byte[r3]
            r3 = {65, -9, 53, 73, -78, 76, 77, 84} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r3)
            r0.<init>(r2)
            throw r0
        L_0x0036:
            java.lang.Object r2 = r1.L$2
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r2 = (com.plinkofortune.cash.winspin.seq.models.BallInScreen) r2
            java.lang.Object r6 = r1.L$1
            com.plinkofortune.cash.winspin.seq.SeqViewModel r6 = (com.plinkofortune.cash.winspin.seq.SeqViewModel) r6
            java.lang.Object r7 = r1.L$0
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            kotlin.ResultKt.throwOnFailure(r35)
            r9 = r2
            r2 = r7
            goto L_0x0069
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r35)
            com.plinkofortune.cash.winspin.seq.SeqViewModel r2 = r1.this$0
            kotlinx.coroutines.sync.Mutex r2 = r2.stateMutex
            com.plinkofortune.cash.winspin.seq.SeqViewModel r6 = r1.this$0
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r7 = r1.$ball
            r8 = r1
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r1.L$0 = r2
            r1.L$1 = r6
            r1.L$2 = r7
            r1.label = r4
            java.lang.Object r8 = r2.lock(r5, r8)
            if (r8 != r0) goto L_0x0068
            goto L_0x0183
        L_0x0068:
            r9 = r7
        L_0x0069:
            kotlinx.coroutines.flow.MutableStateFlow r7 = r6._state     // Catch:{ all -> 0x001b }
            java.lang.Object r7 = r7.getValue()     // Catch:{ all -> 0x001b }
            com.plinkofortune.cash.winspin.seq.SeqState r7 = (com.plinkofortune.cash.winspin.seq.SeqState) r7     // Catch:{ all -> 0x001b }
            if (r7 != 0) goto L_0x0077
            goto L_0x0184
        L_0x0077:
            java.lang.Boolean r8 = r7.getWin()     // Catch:{ all -> 0x001b }
            if (r8 != 0) goto L_0x0184
            boolean r8 = r9.getFinished()     // Catch:{ all -> 0x001b }
            if (r8 != 0) goto L_0x0184
            java.util.List r8 = r7.getBallsInScreen()     // Catch:{ all -> 0x001b }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x001b }
            r21 = 0
            r10 = r21
        L_0x008f:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x001b }
            r12 = -1
            if (r11 == 0) goto L_0x00ab
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x001b }
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r11 = (com.plinkofortune.cash.winspin.seq.models.BallInScreen) r11     // Catch:{ all -> 0x001b }
            int r11 = r11.getRow()     // Catch:{ all -> 0x001b }
            int r13 = r9.getRow()     // Catch:{ all -> 0x001b }
            if (r11 != r13) goto L_0x00a8
            r8 = r10
            goto L_0x00ac
        L_0x00a8:
            int r10 = r10 + 1
            goto L_0x008f
        L_0x00ab:
            r8 = r12
        L_0x00ac:
            if (r8 == r12) goto L_0x0184
            java.util.List r10 = r7.getBallsInScreen()     // Catch:{ all -> 0x001b }
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ all -> 0x001b }
            java.util.List r15 = kotlin.collections.CollectionsKt.toMutableList(r10)     // Catch:{ all -> 0x001b }
            r10 = r15
            r15 = 29
            r16 = 0
            r11 = r10
            r10 = 0
            r13 = r11
            r11 = 1
            r14 = r12
            r12 = 0
            r17 = r13
            r13 = 0
            r18 = r14
            r14 = 0
            r22 = r4
            r4 = r17
            r3 = r18
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r9 = com.plinkofortune.cash.winspin.seq.models.BallInScreen.copy$default(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x001b }
            r4.set(r8, r9)     // Catch:{ all -> 0x001b }
            r19 = 239(0xef, float:3.35E-43)
            r20 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r15 = r4
            r10 = r7
            com.plinkofortune.cash.winspin.seq.SeqState r4 = com.plinkofortune.cash.winspin.seq.SeqState.copy$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x001b }
            kotlinx.coroutines.flow.MutableStateFlow r7 = r6._state     // Catch:{ all -> 0x001b }
            r7.setValue(r4)     // Catch:{ all -> 0x001b }
            int r7 = r4.getStars()     // Catch:{ all -> 0x001b }
            if (r7 != r3) goto L_0x011b
            kotlinx.coroutines.flow.MutableStateFlow r0 = r6._state     // Catch:{ all -> 0x001b }
            java.lang.Boolean r31 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r21)     // Catch:{ all -> 0x001b }
            r32 = 127(0x7f, float:1.78E-43)
            r33 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r23 = r4
            com.plinkofortune.cash.winspin.seq.SeqState r3 = com.plinkofortune.cash.winspin.seq.SeqState.copy$default(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x001b }
            r0.setValue(r3)     // Catch:{ all -> 0x001b }
            goto L_0x0184
        L_0x011b:
            r23 = r4
            java.util.List r3 = r23.getBallsInScreen()     // Catch:{ all -> 0x001b }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x001b }
            boolean r4 = r3 instanceof java.util.Collection     // Catch:{ all -> 0x001b }
            if (r4 == 0) goto L_0x0131
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x001b }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x001b }
            if (r4 == 0) goto L_0x0131
            goto L_0x0148
        L_0x0131:
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x001b }
        L_0x0135:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x001b }
            if (r4 == 0) goto L_0x0148
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x001b }
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r4 = (com.plinkofortune.cash.winspin.seq.models.BallInScreen) r4     // Catch:{ all -> 0x001b }
            boolean r4 = r4.getFinished()     // Catch:{ all -> 0x001b }
            if (r4 != 0) goto L_0x0135
            goto L_0x0184
        L_0x0148:
            java.util.List r3 = r23.getBallsInScreen()     // Catch:{ all -> 0x001b }
            int r3 = r3.size()     // Catch:{ all -> 0x001b }
            r4 = 7
            if (r3 != r4) goto L_0x0184
            kotlinx.coroutines.flow.MutableStateFlow r3 = r6._state     // Catch:{ all -> 0x001b }
            java.lang.Boolean r31 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r22)     // Catch:{ all -> 0x001b }
            r32 = 127(0x7f, float:1.78E-43)
            r33 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            com.plinkofortune.cash.winspin.seq.SeqState r4 = com.plinkofortune.cash.winspin.seq.SeqState.copy$default(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x001b }
            r3.setValue(r4)     // Catch:{ all -> 0x001b }
            r1.L$0 = r2     // Catch:{ all -> 0x001b }
            r1.L$1 = r5     // Catch:{ all -> 0x001b }
            r1.L$2 = r5     // Catch:{ all -> 0x001b }
            r3 = 2
            r1.label = r3     // Catch:{ all -> 0x001b }
            java.lang.Object r3 = r6.doOnFinish(r1)     // Catch:{ all -> 0x001b }
            if (r3 != r0) goto L_0x0184
        L_0x0183:
            return r0
        L_0x0184:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001b }
            r2.unlock(r5)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x018c:
            r2.unlock(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.seq.SeqViewModel$ballInScreenFinished$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
