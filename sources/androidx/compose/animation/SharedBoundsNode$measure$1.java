package androidx.compose.animation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedContentNode.kt */
final class SharedBoundsNode$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ long $lookaheadSize;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ SharedBoundsNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedBoundsNode$measure$1(Placeable placeable, SharedBoundsNode sharedBoundsNode, long j) {
        super(1);
        this.$placeable = placeable;
        this.this$0 = sharedBoundsNode;
        this.$lookaheadSize = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Offset offset;
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        if (coordinates != null) {
            SharedBoundsNode sharedBoundsNode = this.this$0;
            long j = this.$lookaheadSize;
            long r4 = sharedBoundsNode.getRootLookaheadCoords().m5801localPositionOfR5De75A(coordinates, Offset.Companion.m4003getZeroF1C5BW0());
            if (sharedBoundsNode.getSharedElement().getCurrentBounds() == null) {
                sharedBoundsNode.getSharedElement().setCurrentBounds(RectKt.m4027Recttz77jQw(r4, j));
            }
            offset = Offset.m3976boximpl(r4);
        } else {
            offset = null;
        }
        Placeable.PlacementScope.place$default(placementScope, this.$placeable, 0, 0, 0.0f, 4, (Object) null);
        if (offset != null) {
            SharedBoundsNode sharedBoundsNode2 = this.this$0;
            sharedBoundsNode2.getSharedElement().m112onLookaheadResultv_w8tDc(sharedBoundsNode2.getState(), this.$lookaheadSize, offset.m3997unboximpl());
        }
    }
}
