package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1", f = "LazyLayoutItemAnimation.kt", i = {0}, l = {151, 158}, m = "invokeSuspend", n = {"finalSpec"}, s = {"L$0"})
/* compiled from: LazyLayoutItemAnimation.kt */
final class LazyLayoutItemAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemAnimation$animatePlacementDelta$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j, Continuation<? super LazyLayoutItemAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutItemAnimation$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b0, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r13.this$0.placementDeltaAnimation, androidx.compose.ui.unit.IntOffset.m7232boximpl(r3), r1, (java.lang.Object) null, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1.AnonymousClass1(), r13, 4, (java.lang.Object) null) != r0) goto L_0x00b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ CancellationException -> 0x00be }
            goto L_0x00b3
        L_0x0013:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001b:
            java.lang.Object r1 = r13.L$0
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ CancellationException -> 0x00be }
            goto L_0x006b
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r14)
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r14 = r13.this$0     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.animation.core.Animatable r14 = r14.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00be }
            boolean r14 = r14.isRunning()     // Catch:{ CancellationException -> 0x00be }
            if (r14 == 0) goto L_0x0042
            androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> r14 = r13.$spec     // Catch:{ CancellationException -> 0x00be }
            boolean r1 = r14 instanceof androidx.compose.animation.core.SpringSpec     // Catch:{ CancellationException -> 0x00be }
            if (r1 == 0) goto L_0x003b
            androidx.compose.animation.core.SpringSpec r14 = (androidx.compose.animation.core.SpringSpec) r14     // Catch:{ CancellationException -> 0x00be }
            goto L_0x003f
        L_0x003b:
            androidx.compose.animation.core.SpringSpec r14 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimationKt.InterruptionSpec     // Catch:{ CancellationException -> 0x00be }
        L_0x003f:
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14     // Catch:{ CancellationException -> 0x00be }
            goto L_0x0044
        L_0x0042:
            androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> r14 = r13.$spec     // Catch:{ CancellationException -> 0x00be }
        L_0x0044:
            r1 = r14
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r14 = r13.this$0     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.animation.core.Animatable r14 = r14.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00be }
            boolean r14 = r14.isRunning()     // Catch:{ CancellationException -> 0x00be }
            if (r14 != 0) goto L_0x0074
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r14 = r13.this$0     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.animation.core.Animatable r14 = r14.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00be }
            long r4 = r13.$totalDelta     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.ui.unit.IntOffset r4 = androidx.compose.ui.unit.IntOffset.m7232boximpl(r4)     // Catch:{ CancellationException -> 0x00be }
            r5 = r13
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ CancellationException -> 0x00be }
            r13.L$0 = r1     // Catch:{ CancellationException -> 0x00be }
            r13.label = r3     // Catch:{ CancellationException -> 0x00be }
            java.lang.Object r14 = r14.snapTo(r4, r5)     // Catch:{ CancellationException -> 0x00be }
            if (r14 != r0) goto L_0x006b
            goto L_0x00b2
        L_0x006b:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r14 = r13.this$0     // Catch:{ CancellationException -> 0x00be }
            kotlin.jvm.functions.Function0 r14 = r14.onLayerPropertyChanged     // Catch:{ CancellationException -> 0x00be }
            r14.invoke()     // Catch:{ CancellationException -> 0x00be }
        L_0x0074:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r14 = r13.this$0     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.animation.core.Animatable r14 = r14.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00be }
            java.lang.Object r14 = r14.getValue()     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.ui.unit.IntOffset r14 = (androidx.compose.ui.unit.IntOffset) r14     // Catch:{ CancellationException -> 0x00be }
            long r3 = r14.m7250unboximpl()     // Catch:{ CancellationException -> 0x00be }
            long r5 = r13.$totalDelta     // Catch:{ CancellationException -> 0x00be }
            long r3 = androidx.compose.ui.unit.IntOffset.m7244minusqkQi6aY(r3, r5)     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r14 = r13.this$0     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.animation.core.Animatable r5 = r14.placementDeltaAnimation     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.ui.unit.IntOffset r6 = androidx.compose.ui.unit.IntOffset.m7232boximpl(r3)     // Catch:{ CancellationException -> 0x00be }
            r7 = r1
            androidx.compose.animation.core.AnimationSpec r7 = (androidx.compose.animation.core.AnimationSpec) r7     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1$1 r14 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1$1     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r1 = r13.this$0     // Catch:{ CancellationException -> 0x00be }
            r14.<init>(r1, r3)     // Catch:{ CancellationException -> 0x00be }
            r9 = r14
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9     // Catch:{ CancellationException -> 0x00be }
            r10 = r13
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ CancellationException -> 0x00be }
            r14 = 0
            r13.L$0 = r14     // Catch:{ CancellationException -> 0x00be }
            r13.label = r2     // Catch:{ CancellationException -> 0x00be }
            r8 = 0
            r11 = 4
            r12 = 0
            java.lang.Object r14 = androidx.compose.animation.core.Animatable.animateTo$default(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ CancellationException -> 0x00be }
            if (r14 != r0) goto L_0x00b3
        L_0x00b2:
            return r0
        L_0x00b3:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r14 = r13.this$0     // Catch:{ CancellationException -> 0x00be }
            r0 = 0
            r14.setPlacementAnimationInProgress(r0)     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r14 = r13.this$0     // Catch:{ CancellationException -> 0x00be }
            r14.isRunningMovingAwayAnimation = r0     // Catch:{ CancellationException -> 0x00be }
        L_0x00be:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
