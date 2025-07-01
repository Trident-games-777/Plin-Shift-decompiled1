package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1", f = "BasicMarquee.kt", i = {}, l = {349, 350}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BasicMarquee.kt */
final class MarqueeModifierNode$restartAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $oldJob;
    int label;
    final /* synthetic */ MarqueeModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MarqueeModifierNode$restartAnimation$1(Job job, MarqueeModifierNode marqueeModifierNode, Continuation<? super MarqueeModifierNode$restartAnimation$1> continuation) {
        super(2, continuation);
        this.$oldJob = job;
        this.this$0 = marqueeModifierNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MarqueeModifierNode$restartAnimation$1(this.$oldJob, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MarqueeModifierNode$restartAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r5.join(r4) == r0) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (androidx.compose.foundation.MarqueeModifierNode.access$runAnimation(r4.this$0, r4) == r0) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003f
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0031
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.Job r5 = r4.$oldJob
            if (r5 == 0) goto L_0x0031
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            java.lang.Object r5 = r5.join(r1)
            if (r5 != r0) goto L_0x0031
            goto L_0x003e
        L_0x0031:
            androidx.compose.foundation.MarqueeModifierNode r5 = r4.this$0
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r2
            java.lang.Object r5 = r5.runAnimation(r1)
            if (r5 != r0) goto L_0x003f
        L_0x003e:
            return r0
        L_0x003f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
