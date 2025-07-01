package androidx.compose.animation;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Rect;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BoundsAnimation.kt */
final class BoundsAnimation$animate$2 extends Lambda implements Function1<Boolean, Rect> {
    final /* synthetic */ Rect $currentBounds;
    final /* synthetic */ Rect $targetBounds;
    final /* synthetic */ BoundsAnimation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoundsAnimation$animate$2(BoundsAnimation boundsAnimation, Rect rect, Rect rect2) {
        super(1);
        this.this$0 = boundsAnimation;
        this.$targetBounds = rect;
        this.$currentBounds = rect2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }

    public final Rect invoke(boolean z) {
        if (z == this.this$0.getTransition().getTargetState().booleanValue()) {
            return this.$targetBounds;
        }
        return this.$currentBounds;
    }
}
