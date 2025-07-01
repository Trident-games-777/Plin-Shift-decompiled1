package com.plinkofortune.cash.winspin.seq;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.seq.SeqViewModel$click$1", f = "SeqViewModel.kt", i = {0}, l = {277}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
/* compiled from: SeqViewModel.kt */
final class SeqViewModel$click$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SeqViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeqViewModel$click$1(SeqViewModel seqViewModel, Continuation<? super SeqViewModel$click$1> continuation) {
        super(2, continuation);
        this.this$0 = seqViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeqViewModel$click$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeqViewModel$click$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017b A[Catch:{ all -> 0x01d9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r4) goto L_0x001a
            java.lang.Object r0 = r1.L$1
            com.plinkofortune.cash.winspin.seq.SeqViewModel r0 = (com.plinkofortune.cash.winspin.seq.SeqViewModel) r0
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x004e
        L_0x001a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r2 = 47
            byte[] r2 = new byte[r2]
            r2 = {18, 25, -126, -56, 115, 116, 37, 57, 86, 10, -117, -41, 38, 109, 47, 62, 81, 26, -117, -62, 60, 114, 47, 57, 86, 17, -128, -46, 60, 107, 47, 62, 81, 15, -121, -48, 59, 32, 41, 118, 3, 23, -101, -48, 58, 110, 47} // fill-array
            r3 = 8
            byte[] r3 = new byte[r3]
            r3 = {113, 120, -18, -92, 83, 0, 74, 25} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r3)
            r0.<init>(r2)
            throw r0
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r20)
            com.plinkofortune.cash.winspin.seq.SeqViewModel r2 = r1.this$0
            kotlinx.coroutines.sync.Mutex r2 = r2.stateMutex
            com.plinkofortune.cash.winspin.seq.SeqViewModel r5 = r1.this$0
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.L$0 = r2
            r1.L$1 = r5
            r1.label = r4
            java.lang.Object r6 = r2.lock(r3, r6)
            if (r6 != r0) goto L_0x004d
            return r0
        L_0x004d:
            r0 = r5
        L_0x004e:
            kotlinx.coroutines.flow.MutableStateFlow r5 = r0._state     // Catch:{ all -> 0x01d9 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x01d9 }
            r6 = r5
            com.plinkofortune.cash.winspin.seq.SeqState r6 = (com.plinkofortune.cash.winspin.seq.SeqState) r6     // Catch:{ all -> 0x01d9 }
            if (r6 != 0) goto L_0x005d
            goto L_0x01d1
        L_0x005d:
            java.lang.Boolean r5 = r6.getWin()     // Catch:{ all -> 0x01d9 }
            if (r5 != 0) goto L_0x01d1
            java.util.List r5 = r6.getBallsInScreen()     // Catch:{ all -> 0x01d9 }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x01d9 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x01d9 }
        L_0x006d:
            boolean r7 = r5.hasNext()     // Catch:{ all -> 0x01d9 }
            if (r7 == 0) goto L_0x0087
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x01d9 }
            r8 = r7
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r8 = (com.plinkofortune.cash.winspin.seq.models.BallInScreen) r8     // Catch:{ all -> 0x01d9 }
            boolean r9 = r8.getFallingDown()     // Catch:{ all -> 0x01d9 }
            if (r9 != 0) goto L_0x006d
            boolean r8 = r8.getFinished()     // Catch:{ all -> 0x01d9 }
            if (r8 != 0) goto L_0x006d
            goto L_0x0088
        L_0x0087:
            r7 = r3
        L_0x0088:
            r8 = r7
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r8 = (com.plinkofortune.cash.winspin.seq.models.BallInScreen) r8     // Catch:{ all -> 0x01d9 }
            if (r8 == 0) goto L_0x01d1
            java.util.List r5 = r6.getBallsInScreen()     // Catch:{ all -> 0x01d9 }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x01d9 }
            boolean r7 = r5 instanceof java.util.Collection     // Catch:{ all -> 0x01d9 }
            r16 = 0
            if (r7 == 0) goto L_0x00a5
            r7 = r5
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ all -> 0x01d9 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x01d9 }
            if (r7 == 0) goto L_0x00a5
            r7 = r16
            goto L_0x00cf
        L_0x00a5:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x01d9 }
            r7 = r16
        L_0x00ab:
            boolean r9 = r5.hasNext()     // Catch:{ all -> 0x01d9 }
            if (r9 == 0) goto L_0x00cf
            java.lang.Object r9 = r5.next()     // Catch:{ all -> 0x01d9 }
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r9 = (com.plinkofortune.cash.winspin.seq.models.BallInScreen) r9     // Catch:{ all -> 0x01d9 }
            int r9 = r9.getRow()     // Catch:{ all -> 0x01d9 }
            int r10 = r8.getRow()     // Catch:{ all -> 0x01d9 }
            if (r9 != r10) goto L_0x00c3
            r9 = r4
            goto L_0x00c5
        L_0x00c3:
            r9 = r16
        L_0x00c5:
            if (r9 == 0) goto L_0x00ab
            int r7 = r7 + 1
            if (r7 >= 0) goto L_0x00ab
            kotlin.collections.CollectionsKt.throwCountOverflow()     // Catch:{ all -> 0x01d9 }
            goto L_0x00ab
        L_0x00cf:
            if (r7 != r4) goto L_0x01d1
            r14 = 30
            r15 = 0
            r9 = 1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r5 = com.plinkofortune.cash.winspin.seq.models.BallInScreen.copy$default(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x01d9 }
            java.util.List r7 = r6.getBallsInScreen()     // Catch:{ all -> 0x01d9 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x01d9 }
            r8 = r16
        L_0x00e7:
            boolean r9 = r7.hasNext()     // Catch:{ all -> 0x01d9 }
            r10 = -1
            if (r9 == 0) goto L_0x0108
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x01d9 }
            com.plinkofortune.cash.winspin.seq.models.BallInScreen r9 = (com.plinkofortune.cash.winspin.seq.models.BallInScreen) r9     // Catch:{ all -> 0x01d9 }
            int r9 = r9.getRow()     // Catch:{ all -> 0x01d9 }
            int r11 = r5.getRow()     // Catch:{ all -> 0x01d9 }
            if (r9 != r11) goto L_0x0100
            r9 = r4
            goto L_0x0102
        L_0x0100:
            r9 = r16
        L_0x0102:
            if (r9 == 0) goto L_0x0105
            goto L_0x0109
        L_0x0105:
            int r8 = r8 + 1
            goto L_0x00e7
        L_0x0108:
            r8 = r10
        L_0x0109:
            java.util.List r7 = r6.getMultis()     // Catch:{ all -> 0x01d9 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x01d9 }
            r9 = r16
        L_0x0113:
            boolean r11 = r7.hasNext()     // Catch:{ all -> 0x01d9 }
            if (r11 == 0) goto L_0x0133
            java.lang.Object r11 = r7.next()     // Catch:{ all -> 0x01d9 }
            com.plinkofortune.cash.winspin.seq.models.Multi r11 = (com.plinkofortune.cash.winspin.seq.models.Multi) r11     // Catch:{ all -> 0x01d9 }
            int r11 = r11.getRow()     // Catch:{ all -> 0x01d9 }
            int r12 = r5.getRow()     // Catch:{ all -> 0x01d9 }
            if (r11 != r12) goto L_0x012b
            r11 = r4
            goto L_0x012d
        L_0x012b:
            r11 = r16
        L_0x012d:
            if (r11 == 0) goto L_0x0130
            goto L_0x0134
        L_0x0130:
            int r9 = r9 + 1
            goto L_0x0113
        L_0x0133:
            r9 = r10
        L_0x0134:
            if (r8 == r10) goto L_0x01d1
            if (r9 == r10) goto L_0x01d1
            int r7 = r5.getRow()     // Catch:{ all -> 0x01d9 }
            int r7 = r7 - r4
            int r10 = r5.getResource()     // Catch:{ all -> 0x01d9 }
            int r11 = com.plinkofortune.cash.winspin.R.drawable.surprise     // Catch:{ all -> 0x01d9 }
            if (r10 == r11) goto L_0x015f
            java.util.List r10 = r6.getSeqBalls()     // Catch:{ all -> 0x01d9 }
            java.lang.Object r10 = r10.get(r7)     // Catch:{ all -> 0x01d9 }
            com.plinkofortune.cash.winspin.seq.models.SeqBall r10 = (com.plinkofortune.cash.winspin.seq.models.SeqBall) r10     // Catch:{ all -> 0x01d9 }
            int r10 = r10.getResource()     // Catch:{ all -> 0x01d9 }
            int r11 = r5.getResource()     // Catch:{ all -> 0x01d9 }
            if (r10 != r11) goto L_0x015a
            goto L_0x015f
        L_0x015a:
            int r7 = r6.getScore()     // Catch:{ all -> 0x01d9 }
            goto L_0x0172
        L_0x015f:
            int r10 = r6.getScore()     // Catch:{ all -> 0x01d9 }
            java.util.List r11 = r6.getMultis()     // Catch:{ all -> 0x01d9 }
            java.lang.Object r7 = r11.get(r7)     // Catch:{ all -> 0x01d9 }
            com.plinkofortune.cash.winspin.seq.models.Multi r7 = (com.plinkofortune.cash.winspin.seq.models.Multi) r7     // Catch:{ all -> 0x01d9 }
            int r7 = r7.getScore()     // Catch:{ all -> 0x01d9 }
            int r7 = r7 + r10
        L_0x0172:
            r10 = r7
            int r7 = r5.getResource()     // Catch:{ all -> 0x01d9 }
            int r11 = com.plinkofortune.cash.winspin.R.drawable.surprise     // Catch:{ all -> 0x01d9 }
            if (r7 == r11) goto L_0x0188
            int r7 = r6.getScore()     // Catch:{ all -> 0x01d9 }
            if (r10 == r7) goto L_0x0182
            goto L_0x0188
        L_0x0182:
            int r7 = r6.getStars()     // Catch:{ all -> 0x01d9 }
            int r7 = r7 - r4
            goto L_0x018c
        L_0x0188:
            int r7 = r6.getStars()     // Catch:{ all -> 0x01d9 }
        L_0x018c:
            java.util.List r4 = r6.getBallsInScreen()     // Catch:{ all -> 0x01d9 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x01d9 }
            java.util.List r11 = kotlin.collections.CollectionsKt.toMutableList(r4)     // Catch:{ all -> 0x01d9 }
            r11.set(r8, r5)     // Catch:{ all -> 0x01d9 }
            java.util.List r4 = r6.getMultis()     // Catch:{ all -> 0x01d9 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x01d9 }
            java.util.List r12 = kotlin.collections.CollectionsKt.toMutableList(r4)     // Catch:{ all -> 0x01d9 }
            java.util.List r4 = r6.getMultis()     // Catch:{ all -> 0x01d9 }
            java.lang.Object r4 = r4.get(r9)     // Catch:{ all -> 0x01d9 }
            r13 = r4
            com.plinkofortune.cash.winspin.seq.models.Multi r13 = (com.plinkofortune.cash.winspin.seq.models.Multi) r13     // Catch:{ all -> 0x01d9 }
            r17 = 3
            r18 = 0
            r14 = 0
            r15 = 0
            r16 = 1
            com.plinkofortune.cash.winspin.seq.models.Multi r4 = com.plinkofortune.cash.winspin.seq.models.Multi.copy$default(r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x01d9 }
            r12.set(r9, r4)     // Catch:{ all -> 0x01d9 }
            kotlinx.coroutines.flow.MutableStateFlow r0 = r0._state     // Catch:{ all -> 0x01d9 }
            r15 = 195(0xc3, float:2.73E-43)
            r16 = 0
            r9 = r7
            r7 = 0
            r8 = 0
            r13 = 0
            r14 = 0
            com.plinkofortune.cash.winspin.seq.SeqState r4 = com.plinkofortune.cash.winspin.seq.SeqState.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x01d9 }
            r0.setValue(r4)     // Catch:{ all -> 0x01d9 }
        L_0x01d1:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01d9 }
            r2.unlock(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01d9:
            r0 = move-exception
            r2.unlock(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.seq.SeqViewModel$click$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
