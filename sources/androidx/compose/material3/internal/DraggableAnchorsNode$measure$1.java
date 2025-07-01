package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class DraggableAnchorsNode$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ DraggableAnchorsNode<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableAnchorsNode$measure$1(MeasureScope measureScope, DraggableAnchorsNode<T> draggableAnchorsNode, Placeable placeable) {
        super(1);
        this.$this_measure = measureScope;
        this.this$0 = draggableAnchorsNode;
        this.$placeable = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        float f;
        if (this.$this_measure.isLookingAhead()) {
            f = this.this$0.getState().getAnchors().positionOf(this.this$0.getState().getTargetValue());
        } else {
            f = this.this$0.getState().requireOffset();
        }
        float f2 = this.this$0.getOrientation() == Orientation.Horizontal ? f : 0.0f;
        if (this.this$0.getOrientation() != Orientation.Vertical) {
            f = 0.0f;
        }
        Placeable.PlacementScope.place$default(placementScope, this.$placeable, MathKt.roundToInt(f2), MathKt.roundToInt(f), 0.0f, 4, (Object) null);
    }
}
