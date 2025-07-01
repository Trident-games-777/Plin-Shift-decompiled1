package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/Transition$Segment;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BoundsAnimation.kt */
final class BoundsAnimation$animate$1 extends Lambda implements Function1<Transition.Segment<Boolean>, FiniteAnimationSpec<Rect>> {
    final /* synthetic */ BoundsAnimation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoundsAnimation$animate$1(BoundsAnimation boundsAnimation) {
        super(1);
        this.this$0 = boundsAnimation;
    }

    public final FiniteAnimationSpec<Rect> invoke(Transition.Segment<Boolean> segment) {
        return this.this$0.getAnimationSpec();
    }
}
