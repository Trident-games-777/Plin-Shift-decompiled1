package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J:\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH@¢\u0006\u0002\u0010!J.\u0010\"\u001a\u00020\u0006*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH@¢\u0006\u0002\u0010!JQ\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u001a*\u00020\u001c2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020 0\u001fH@¢\u0006\u0002\u0010*JB\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0,*\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH@¢\u0006\u0002\u0010*R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "motionScaleDuration", "Landroidx/compose/ui/MotionDurationScale;", "getMotionScaleDuration$foundation_release", "()Landroidx/compose/ui/MotionDurationScale;", "setMotionScaleDuration$foundation_release", "(Landroidx/compose/ui/MotionDurationScale;)V", "equals", "", "other", "", "hashCode", "", "isDecayApproachPossible", "offset", "velocity", "fling", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "onRemainingScrollOffsetUpdate", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "onRemainingDistanceUpdated", "runApproach", "initialTargetOffset", "onAnimationStep", "Lkotlin/ParameterName;", "name", "delta", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryApproach", "Landroidx/compose/animation/core/AnimationState;", "updateRemainingScrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(message = "Please use the snapFlingBehavior function", replaceWith = @ReplaceWith(expression = "androidx.compose.foundation.gestures.snapping.snapFlingBehavior", imports = {}))
/* compiled from: SnapFlingBehavior.kt */
public final class SnapFlingBehavior implements TargetedFlingBehavior {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public final DecayAnimationSpec<Float> decayAnimationSpec;
    private MotionDurationScale motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    /* access modifiers changed from: private */
    public final AnimationSpec<Float> snapAnimationSpec;
    /* access modifiers changed from: private */
    public final SnapLayoutInfoProvider snapLayoutInfoProvider;

    public SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider2, DecayAnimationSpec<Float> decayAnimationSpec2, AnimationSpec<Float> animationSpec) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider2;
        this.decayAnimationSpec = decayAnimationSpec2;
        this.snapAnimationSpec = animationSpec;
    }

    public final MotionDurationScale getMotionScaleDuration$foundation_release() {
        return this.motionScaleDuration;
    }

    public final void setMotionScaleDuration$foundation_release(MotionDurationScale motionDurationScale) {
        this.motionScaleDuration = motionDurationScale;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object performFling(androidx.compose.foundation.gestures.ScrollScope r5, float r6, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super java.lang.Float> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1
            r0.<init>(r4, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x003e
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.label = r3
            java.lang.Object r8 = r4.fling(r5, r6, r7, r0)
            if (r8 != r1) goto L_0x003e
            return r1
        L_0x003e:
            androidx.compose.foundation.gestures.snapping.AnimationResult r8 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r8
            java.lang.Object r5 = r8.component1()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            androidx.compose.animation.core.AnimationState r6 = r8.component2()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0054
            goto L_0x005e
        L_0x0054:
            java.lang.Object r5 = r6.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r7 = r5.floatValue()
        L_0x005e:
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fling(androidx.compose.foundation.gestures.ScrollScope r11, float r12, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r13, kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1
            r0.<init>(r10, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r11 = r0.L$0
            r13 = r11
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0056
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r14)
            androidx.compose.ui.MotionDurationScale r14 = r10.motionScaleDuration
            kotlin.coroutines.CoroutineContext r14 = (kotlin.coroutines.CoroutineContext) r14
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1 r4 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1
            r9 = 0
            r5 = r10
            r8 = r11
            r6 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r4, r0)
            if (r14 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r13 = r7
        L_0x0056:
            androidx.compose.foundation.gestures.snapping.AnimationResult r14 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r14
            r11 = 0
            java.lang.Float r11 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11)
            r13.invoke(r11)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.fling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object tryApproach(androidx.compose.foundation.gestures.ScrollScope r18, float r19, float r20, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r22) {
        /*
            r17 = this;
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1 r1 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r17
            goto L_0x001f
        L_0x0018:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1 r1 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001f:
            r7 = r1
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r7.label
            r4 = 1
            if (r3 == 0) goto L_0x0039
            if (r3 != r4) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0071
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r0)
            float r0 = java.lang.Math.abs(r19)
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0046
            goto L_0x004e
        L_0x0046:
            float r0 = java.lang.Math.abs(r20)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0060
        L_0x004e:
            r15 = 28
            r16 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r8 = r19
            r9 = r20
            androidx.compose.animation.core.AnimationState r0 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r8, r9, r10, r12, r14, r15, r16)
            return r0
        L_0x0060:
            r7.label = r4
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            java.lang.Object r0 = r2.runApproach(r3, r4, r5, r6, r7)
            if (r0 != r1) goto L_0x0071
            return r1
        L_0x0071:
            androidx.compose.foundation.gestures.snapping.AnimationResult r0 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r0
            androidx.compose.animation.core.AnimationState r0 = r0.getCurrentAnimationState()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.tryApproach(androidx.compose.foundation.gestures.ScrollScope, float, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object runApproach(ScrollScope scrollScope, float f, float f2, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        ApproachAnimation approachAnimation;
        if (isDecayApproachPossible(f, f2)) {
            approachAnimation = new DecayApproachAnimation(this.decayAnimationSpec);
        } else {
            approachAnimation = new TargetApproachAnimation(this.snapAnimationSpec);
        }
        return SnapFlingBehaviorKt.approach(scrollScope, f, f2, approachAnimation, function1, continuation);
    }

    private final boolean isDecayApproachPossible(float f, float f2) {
        return Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0.0f, f2)) >= Math.abs(f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof SnapFlingBehavior) {
            SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
            if (!Intrinsics.areEqual((Object) snapFlingBehavior.snapAnimationSpec, (Object) this.snapAnimationSpec) || !Intrinsics.areEqual((Object) snapFlingBehavior.decayAnimationSpec, (Object) this.decayAnimationSpec) || !Intrinsics.areEqual((Object) snapFlingBehavior.snapLayoutInfoProvider, (Object) this.snapLayoutInfoProvider)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.snapAnimationSpec.hashCode() * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode();
    }
}
