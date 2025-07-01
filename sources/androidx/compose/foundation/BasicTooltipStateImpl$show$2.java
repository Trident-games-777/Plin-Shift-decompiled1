package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.BasicTooltipStateImpl$show$2", f = "BasicTooltip.kt", i = {}, l = {156, 158}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BasicTooltip.kt */
final class BasicTooltipStateImpl$show$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $cancellableShow;
    int label;
    final /* synthetic */ BasicTooltipStateImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTooltipStateImpl$show$2(BasicTooltipStateImpl basicTooltipStateImpl, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super BasicTooltipStateImpl$show$2> continuation) {
        super(1, continuation);
        this.this$0 = basicTooltipStateImpl;
        this.$cancellableShow = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BasicTooltipStateImpl$show$2(this.this$0, this.$cancellableShow, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BasicTooltipStateImpl$show$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (kotlinx.coroutines.TimeoutKt.withTimeout(1500, new androidx.compose.foundation.BasicTooltipStateImpl$show$2.AnonymousClass1((kotlin.coroutines.Continuation<? super androidx.compose.foundation.BasicTooltipStateImpl$show$2.AnonymousClass1>) null), r5) == r0) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r4) goto L_0x0018
            if (r1 != r3) goto L_0x0010
            goto L_0x0018
        L_0x0010:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x001c }
            goto L_0x004c
        L_0x001c:
            r6 = move-exception
            goto L_0x0054
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.BasicTooltipStateImpl r6 = r5.this$0     // Catch:{ all -> 0x001c }
            boolean r6 = r6.isPersistent()     // Catch:{ all -> 0x001c }
            if (r6 == 0) goto L_0x0034
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r5.$cancellableShow     // Catch:{ all -> 0x001c }
            r5.label = r4     // Catch:{ all -> 0x001c }
            java.lang.Object r6 = r6.invoke(r5)     // Catch:{ all -> 0x001c }
            if (r6 != r0) goto L_0x004c
            goto L_0x004b
        L_0x0034:
            androidx.compose.foundation.BasicTooltipStateImpl$show$2$1 r6 = new androidx.compose.foundation.BasicTooltipStateImpl$show$2$1     // Catch:{ all -> 0x001c }
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$cancellableShow     // Catch:{ all -> 0x001c }
            r4 = 0
            r6.<init>(r1, r4)     // Catch:{ all -> 0x001c }
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ all -> 0x001c }
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ all -> 0x001c }
            r5.label = r3     // Catch:{ all -> 0x001c }
            r3 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.withTimeout(r3, r6, r1)     // Catch:{ all -> 0x001c }
            if (r6 != r0) goto L_0x004c
        L_0x004b:
            return r0
        L_0x004c:
            androidx.compose.foundation.BasicTooltipStateImpl r6 = r5.this$0
            r6.setVisible(r2)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0054:
            androidx.compose.foundation.BasicTooltipStateImpl r0 = r5.this$0
            r0.setVisible(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BasicTooltipStateImpl$show$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
