package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationItem.kt */
final class NavigationItemKt$placeIcon$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ int $iconX;
    final /* synthetic */ int $iconY;
    final /* synthetic */ Placeable $indicatorPlaceable;
    final /* synthetic */ Placeable $indicatorRipplePlaceable;
    final /* synthetic */ int $indicatorX;
    final /* synthetic */ int $indicatorY;
    final /* synthetic */ int $rippleX;
    final /* synthetic */ int $rippleY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationItemKt$placeIcon$1(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, Placeable placeable3, int i5, int i6) {
        super(1);
        this.$indicatorPlaceable = placeable;
        this.$indicatorX = i;
        this.$indicatorY = i2;
        this.$iconPlaceable = placeable2;
        this.$iconX = i3;
        this.$iconY = i4;
        this.$indicatorRipplePlaceable = placeable3;
        this.$rippleX = i5;
        this.$rippleY = i6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeRelative$default(placementScope2, this.$indicatorPlaceable, this.$indicatorX, this.$indicatorY, 0.0f, 4, (Object) null);
        Placeable.PlacementScope placementScope3 = placementScope2;
        Placeable.PlacementScope.placeRelative$default(placementScope3, this.$iconPlaceable, this.$iconX, this.$iconY, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope3, this.$indicatorRipplePlaceable, this.$rippleX, this.$rippleY, 0.0f, 4, (Object) null);
    }
}
