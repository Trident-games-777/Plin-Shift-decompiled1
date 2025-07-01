package com.plinkofortune.cash.winspin.rounds;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.rounds.ZabgTpCHxFDS$retryConnection$1", f = "ZabgTpCHxFDS.kt", i = {}, l = {92, 93}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ZabgTpCHxFDS.kt */
final class ZabgTpCHxFDS$retryConnection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $retryCount;
    int label;
    final /* synthetic */ ZabgTpCHxFDS this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZabgTpCHxFDS$retryConnection$1(ZabgTpCHxFDS zabgTpCHxFDS, Context context, int i, Continuation<? super ZabgTpCHxFDS$retryConnection$1> continuation) {
        super(2, continuation);
        this.this$0 = zabgTpCHxFDS;
        this.$context = context;
        this.$retryCount = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZabgTpCHxFDS$retryConnection$1(this.this$0, this.$context, this.$retryCount, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZabgTpCHxFDS$retryConnection$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r5.this$0.iQLhOuiIOxLa(r5.$context, r5.$retryCount, r5) == r0) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (kotlinx.coroutines.DelayKt.delay(300, r5) == r0) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002e
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0051
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r0 = 47
            byte[] r0 = new byte[r0]
            r0 = {96, 67, -17, 13, -49, -57, 65, 114, 36, 80, -26, 18, -102, -34, 75, 117, 35, 64, -26, 7, -128, -63, 75, 114, 36, 75, -19, 23, -128, -40, 75, 117, 35, 85, -22, 21, -121, -109, 77, 61, 113, 77, -10, 21, -122, -35, 75} // fill-array
            r1 = 8
            byte[] r1 = new byte[r1]
            r1 = {3, 34, -125, 97, -17, -77, 46, 82} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            r6.<init>(r0)
            throw r6
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003f
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.label = r3
            r3 = 300(0x12c, double:1.48E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L_0x003f
            goto L_0x0050
        L_0x003f:
            com.plinkofortune.cash.winspin.rounds.ZabgTpCHxFDS r6 = r5.this$0
            android.content.Context r1 = r5.$context
            int r3 = r5.$retryCount
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r2
            java.lang.Object r6 = r6.iQLhOuiIOxLa(r1, r3, r4)
            if (r6 != r0) goto L_0x0051
        L_0x0050:
            return r0
        L_0x0051:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.rounds.ZabgTpCHxFDS$retryConnection$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
