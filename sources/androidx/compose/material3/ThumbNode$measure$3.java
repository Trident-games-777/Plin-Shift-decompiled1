package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class ThumbNode$measure$3 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ float $offset;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ ThumbNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ThumbNode$measure$3(Placeable placeable, ThumbNode thumbNode, float f) {
        super(1);
        this.$placeable = placeable;
        this.this$0 = thumbNode;
        this.$offset = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable placeable = this.$placeable;
        Animatable access$getOffsetAnim$p = this.this$0.offsetAnim;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (int) (access$getOffsetAnim$p != null ? ((Number) access$getOffsetAnim$p.getValue()).floatValue() : this.$offset), 0, 0.0f, 4, (Object) null);
    }
}
