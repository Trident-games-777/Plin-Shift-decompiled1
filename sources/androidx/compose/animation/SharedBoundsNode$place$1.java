package androidx.compose.animation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedContentNode.kt */
final class SharedBoundsNode$place$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ SharedBoundsNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedBoundsNode$place$1(SharedBoundsNode sharedBoundsNode, Placeable placeable) {
        super(1);
        this.this$0 = sharedBoundsNode;
        this.$placeable = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        long j;
        LayoutCoordinates coordinates;
        if (!this.this$0.getSharedElement().getFoundMatch()) {
            LayoutCoordinates coordinates2 = placementScope.getCoordinates();
            if (coordinates2 != null) {
                this.this$0.updateCurrentBounds(coordinates2);
            }
            Placeable.PlacementScope.place$default(placementScope, this.$placeable, 0, 0, 0.0f, 4, (Object) null);
            return;
        }
        if (this.this$0.getSharedElement().getTargetBounds() != null) {
            BoundsAnimation access$getBoundsAnimation = this.this$0.getBoundsAnimation();
            Rect currentBounds = this.this$0.getSharedElement().getCurrentBounds();
            Intrinsics.checkNotNull(currentBounds);
            Rect targetBounds = this.this$0.getSharedElement().getTargetBounds();
            Intrinsics.checkNotNull(targetBounds);
            access$getBoundsAnimation.animate(currentBounds, targetBounds);
        }
        Rect value = this.this$0.getBoundsAnimation().getValue();
        LayoutCoordinates coordinates3 = placementScope.getCoordinates();
        Offset r2 = coordinates3 != null ? Offset.m3976boximpl(this.this$0.getRootCoords().m5801localPositionOfR5De75A(coordinates3, Offset.Companion.m4003getZeroF1C5BW0())) : null;
        if (value != null) {
            if (this.this$0.getBoundsAnimation().getTarget()) {
                this.this$0.getSharedElement().setCurrentBounds(value);
            }
            j = value.m4022getTopLeftF1C5BW0();
        } else {
            if (this.this$0.getBoundsAnimation().getTarget() && (coordinates = placementScope.getCoordinates()) != null) {
                this.this$0.updateCurrentBounds(coordinates);
            }
            Rect currentBounds2 = this.this$0.getSharedElement().getCurrentBounds();
            Intrinsics.checkNotNull(currentBounds2);
            j = currentBounds2.m4022getTopLeftF1C5BW0();
        }
        long r1 = r2 != null ? Offset.m3991minusMKHz9U(j, r2.m3997unboximpl()) : Offset.Companion.m4003getZeroF1C5BW0();
        Placeable.PlacementScope.place$default(placementScope, this.$placeable, Math.round(Offset.m3987getXimpl(r1)), Math.round(Offset.m3988getYimpl(r1)), 0.0f, 4, (Object) null);
    }
}
