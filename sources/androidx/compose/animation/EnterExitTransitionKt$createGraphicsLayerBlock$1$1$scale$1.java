package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/EnterExitState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1 extends Lambda implements Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>> {
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1(EnterTransition enterTransition, ExitTransition exitTransition) {
        super(1);
        this.$enter = enterTransition;
        this.$exit = exitTransition;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r3 = r3.getAnimationSpec();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> invoke(androidx.compose.animation.core.Transition.Segment<androidx.compose.animation.EnterExitState> r3) {
        /*
            r2 = this;
            androidx.compose.animation.EnterExitState r0 = androidx.compose.animation.EnterExitState.PreEnter
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.Visible
            boolean r0 = r3.isTransitioningTo(r0, r1)
            if (r0 == 0) goto L_0x0025
            androidx.compose.animation.EnterTransition r3 = r2.$enter
            androidx.compose.animation.TransitionData r3 = r3.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 == 0) goto L_0x001e
            androidx.compose.animation.core.FiniteAnimationSpec r3 = r3.getAnimationSpec()
            if (r3 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            return r3
        L_0x001e:
            androidx.compose.animation.core.SpringSpec r3 = androidx.compose.animation.EnterExitTransitionKt.DefaultAlphaAndScaleSpring
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            return r3
        L_0x0025:
            androidx.compose.animation.EnterExitState r0 = androidx.compose.animation.EnterExitState.Visible
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PostExit
            boolean r3 = r3.isTransitioningTo(r0, r1)
            if (r3 == 0) goto L_0x004a
            androidx.compose.animation.ExitTransition r3 = r2.$exit
            androidx.compose.animation.TransitionData r3 = r3.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 == 0) goto L_0x0043
            androidx.compose.animation.core.FiniteAnimationSpec r3 = r3.getAnimationSpec()
            if (r3 != 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            return r3
        L_0x0043:
            androidx.compose.animation.core.SpringSpec r3 = androidx.compose.animation.EnterExitTransitionKt.DefaultAlphaAndScaleSpring
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            return r3
        L_0x004a:
            androidx.compose.animation.core.SpringSpec r3 = androidx.compose.animation.EnterExitTransitionKt.DefaultAlphaAndScaleSpring
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1.invoke(androidx.compose.animation.core.Transition$Segment):androidx.compose.animation.core.FiniteAnimationSpec");
    }
}
