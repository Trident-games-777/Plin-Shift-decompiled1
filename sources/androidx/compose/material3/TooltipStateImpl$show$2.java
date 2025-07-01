package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TooltipStateImpl$show$2", f = "Tooltip.kt", i = {}, l = {504, 506}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Tooltip.kt */
final class TooltipStateImpl$show$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $cancellableShow;
    final /* synthetic */ MutatePriority $mutatePriority;
    int label;
    final /* synthetic */ TooltipStateImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipStateImpl$show$2(TooltipStateImpl tooltipStateImpl, Function1<? super Continuation<? super Unit>, ? extends Object> function1, MutatePriority mutatePriority, Continuation<? super TooltipStateImpl$show$2> continuation) {
        super(1, continuation);
        this.this$0 = tooltipStateImpl;
        this.$cancellableShow = function1;
        this.$mutatePriority = mutatePriority;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TooltipStateImpl$show$2(this.this$0, this.$cancellableShow, this.$mutatePriority, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TooltipStateImpl$show$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (kotlinx.coroutines.TimeoutKt.withTimeout(1500, new androidx.compose.material3.TooltipStateImpl$show$2.AnonymousClass1((kotlin.coroutines.Continuation<? super androidx.compose.material3.TooltipStateImpl$show$2.AnonymousClass1>) null), r4) == r0) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001d
            if (r1 == r3) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x001b }
            goto L_0x004b
        L_0x001b:
            r5 = move-exception
            goto L_0x0059
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.material3.TooltipStateImpl r5 = r4.this$0     // Catch:{ all -> 0x001b }
            boolean r5 = r5.isPersistent()     // Catch:{ all -> 0x001b }
            if (r5 == 0) goto L_0x0033
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r5 = r4.$cancellableShow     // Catch:{ all -> 0x001b }
            r4.label = r3     // Catch:{ all -> 0x001b }
            java.lang.Object r5 = r5.invoke(r4)     // Catch:{ all -> 0x001b }
            if (r5 != r0) goto L_0x004b
            goto L_0x004a
        L_0x0033:
            androidx.compose.material3.TooltipStateImpl$show$2$1 r5 = new androidx.compose.material3.TooltipStateImpl$show$2$1     // Catch:{ all -> 0x001b }
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r4.$cancellableShow     // Catch:{ all -> 0x001b }
            r3 = 0
            r5.<init>(r1, r3)     // Catch:{ all -> 0x001b }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x001b }
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ all -> 0x001b }
            r4.label = r2     // Catch:{ all -> 0x001b }
            r2 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r5 = kotlinx.coroutines.TimeoutKt.withTimeout(r2, r5, r1)     // Catch:{ all -> 0x001b }
            if (r5 != r0) goto L_0x004b
        L_0x004a:
            return r0
        L_0x004b:
            androidx.compose.foundation.MutatePriority r5 = r4.$mutatePriority
            androidx.compose.foundation.MutatePriority r0 = androidx.compose.foundation.MutatePriority.PreventUserInput
            if (r5 == r0) goto L_0x0056
            androidx.compose.material3.TooltipStateImpl r5 = r4.this$0
            r5.dismiss()
        L_0x0056:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0059:
            androidx.compose.foundation.MutatePriority r0 = r4.$mutatePriority
            androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.PreventUserInput
            if (r0 == r1) goto L_0x0064
            androidx.compose.material3.TooltipStateImpl r0 = r4.this$0
            r0.dismiss()
        L_0x0064:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipStateImpl$show$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
