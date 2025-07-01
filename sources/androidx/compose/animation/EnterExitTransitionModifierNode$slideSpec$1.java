package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/EnterExitState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionModifierNode$slideSpec$1 extends Lambda implements Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> {
    final /* synthetic */ EnterExitTransitionModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionModifierNode$slideSpec$1(EnterExitTransitionModifierNode enterExitTransitionModifierNode) {
        super(1);
        this.this$0 = enterExitTransitionModifierNode;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        r3 = r3.getAnimationSpec();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> invoke(androidx.compose.animation.core.Transition.Segment<androidx.compose.animation.EnterExitState> r3) {
        /*
            r2 = this;
            androidx.compose.animation.EnterExitState r0 = androidx.compose.animation.EnterExitState.PreEnter
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.Visible
            boolean r0 = r3.isTransitioningTo(r0, r1)
            if (r0 == 0) goto L_0x0029
            androidx.compose.animation.EnterExitTransitionModifierNode r3 = r2.this$0
            androidx.compose.animation.EnterTransition r3 = r3.getEnter()
            androidx.compose.animation.TransitionData r3 = r3.getData$animation_release()
            androidx.compose.animation.Slide r3 = r3.getSlide()
            if (r3 == 0) goto L_0x0022
            androidx.compose.animation.core.FiniteAnimationSpec r3 = r3.getAnimationSpec()
            if (r3 != 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            return r3
        L_0x0022:
            androidx.compose.animation.core.SpringSpec r3 = androidx.compose.animation.EnterExitTransitionKt.DefaultOffsetAnimationSpec
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            return r3
        L_0x0029:
            androidx.compose.animation.EnterExitState r0 = androidx.compose.animation.EnterExitState.Visible
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PostExit
            boolean r3 = r3.isTransitioningTo(r0, r1)
            if (r3 == 0) goto L_0x0052
            androidx.compose.animation.EnterExitTransitionModifierNode r3 = r2.this$0
            androidx.compose.animation.ExitTransition r3 = r3.getExit()
            androidx.compose.animation.TransitionData r3 = r3.getData$animation_release()
            androidx.compose.animation.Slide r3 = r3.getSlide()
            if (r3 == 0) goto L_0x004b
            androidx.compose.animation.core.FiniteAnimationSpec r3 = r3.getAnimationSpec()
            if (r3 != 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            return r3
        L_0x004b:
            androidx.compose.animation.core.SpringSpec r3 = androidx.compose.animation.EnterExitTransitionKt.DefaultOffsetAnimationSpec
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            return r3
        L_0x0052:
            androidx.compose.animation.core.SpringSpec r3 = androidx.compose.animation.EnterExitTransitionKt.DefaultOffsetAnimationSpec
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1.invoke(androidx.compose.animation.core.Transition$Segment):androidx.compose.animation.core.FiniteAnimationSpec");
    }
}
