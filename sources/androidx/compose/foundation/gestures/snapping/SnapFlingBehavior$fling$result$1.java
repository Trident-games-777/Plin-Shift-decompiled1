package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1", f = "SnapFlingBehavior.kt", i = {0}, l = {142, 161}, m = "invokeSuspend", n = {"remainingScrollOffset"}, s = {"L$0"})
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ Function1<Float, Unit> $onRemainingScrollOffsetUpdate;
    final /* synthetic */ ScrollScope $this_fling;
    Object L$0;
    int label;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$fling$result$1(SnapFlingBehavior snapFlingBehavior, float f, Function1<? super Float, Unit> function1, ScrollScope scrollScope, Continuation<? super SnapFlingBehavior$fling$result$1> continuation) {
        super(2, continuation);
        this.this$0 = snapFlingBehavior;
        this.$initialVelocity = f;
        this.$onRemainingScrollOffsetUpdate = function1;
        this.$this_fling = scrollScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnapFlingBehavior$fling$result$1(this.this$0, this.$initialVelocity, this.$onRemainingScrollOffsetUpdate, this.$this_fling, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return ((SnapFlingBehavior$fling$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0083, code lost:
        if (r2 == r1) goto L_0x00e0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0027
            if (r2 == r4) goto L_0x001c
            if (r2 != r3) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r18)
            return r18
        L_0x0014:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001c:
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.internal.Ref$FloatRef r2 = (kotlin.jvm.internal.Ref.FloatRef) r2
            kotlin.ResultKt.throwOnFailure(r18)
            r5 = r2
            r2 = r18
            goto L_0x0086
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r18)
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r2 = r0.this$0
            androidx.compose.animation.core.DecayAnimationSpec r2 = r2.decayAnimationSpec
            r5 = 0
            float r6 = r0.$initialVelocity
            float r2 = androidx.compose.animation.core.DecayAnimationSpecKt.calculateTargetValue(r2, r5, r6)
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r5 = r0.this$0
            androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r5 = r5.snapLayoutInfoProvider
            float r6 = r0.$initialVelocity
            float r2 = r5.calculateApproachOffset(r6, r2)
            boolean r5 = java.lang.Float.isNaN(r2)
            if (r5 != 0) goto L_0x00ee
            kotlin.jvm.internal.Ref$FloatRef r5 = new kotlin.jvm.internal.Ref$FloatRef
            r5.<init>()
            float r2 = java.lang.Math.abs(r2)
            float r6 = r0.$initialVelocity
            float r6 = java.lang.Math.signum(r6)
            float r2 = r2 * r6
            r5.element = r2
            kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r2 = r0.$onRemainingScrollOffsetUpdate
            float r6 = r5.element
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
            r2.invoke(r6)
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r7 = r0.this$0
            androidx.compose.foundation.gestures.ScrollScope r8 = r0.$this_fling
            float r9 = r5.element
            float r10 = r0.$initialVelocity
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$animationState$1 r2 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$animationState$1
            kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r6 = r0.$onRemainingScrollOffsetUpdate
            r2.<init>(r5, r6)
            r11 = r2
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r12 = r0
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r2 = r7.tryApproach(r8, r9, r10, r11, r12)
            if (r2 != r1) goto L_0x0086
            goto L_0x00e0
        L_0x0086:
            r6 = r2
            androidx.compose.animation.core.AnimationState r6 = (androidx.compose.animation.core.AnimationState) r6
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r2 = r0.this$0
            androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r2 = r2.snapLayoutInfoProvider
            java.lang.Object r4 = r6.getVelocity()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r2 = r2.calculateSnapOffset(r4)
            boolean r4 = java.lang.Float.isNaN(r2)
            if (r4 != 0) goto L_0x00e2
            r5.element = r2
            androidx.compose.foundation.gestures.ScrollScope r2 = r0.$this_fling
            float r4 = r5.element
            float r7 = r5.element
            r14 = 30
            r15 = 0
            r9 = r7
            r7 = 0
            r8 = 0
            r11 = r9
            r9 = 0
            r13 = r11
            r11 = 0
            r16 = r13
            r13 = 0
            androidx.compose.animation.core.AnimationState r10 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r6, (float) r7, (float) r8, (long) r9, (long) r11, (boolean) r13, (int) r14, (java.lang.Object) r15)
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r6 = r0.this$0
            androidx.compose.animation.core.AnimationSpec r11 = r6.snapAnimationSpec
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$4 r6 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$4
            kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r7 = r0.$onRemainingScrollOffsetUpdate
            r6.<init>(r5, r7)
            r12 = r6
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r13 = r0
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r5 = 0
            r0.L$0 = r5
            r0.label = r3
            r7 = r2
            r8 = r4
            r9 = r16
            java.lang.Object r2 = androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateWithTarget(r7, r8, r9, r10, r11, r12, r13)
            if (r2 != r1) goto L_0x00e1
        L_0x00e0:
            return r1
        L_0x00e1:
            return r2
        L_0x00e2:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "calculateSnapOffset returned NaN. Please use a valid value."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00ee:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "calculateApproachOffset returned NaN. Please use a valid value."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
