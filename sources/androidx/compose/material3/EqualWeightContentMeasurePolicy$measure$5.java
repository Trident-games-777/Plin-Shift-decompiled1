package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExpressiveNavigationBar.kt */
final class EqualWeightContentMeasurePolicy$measure$5 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Placeable> $itemsPlaceables;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EqualWeightContentMeasurePolicy$measure$5(List<? extends Placeable> list) {
        super(1);
        this.$itemsPlaceables = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        List<Placeable> list = this.$itemsPlaceables;
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Placeable placeable = list.get(i);
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, i2, 0, 0.0f, 4, (Object) null);
            i2 += placeable.getWidth();
            i++;
            placementScope = placementScope2;
        }
    }
}
