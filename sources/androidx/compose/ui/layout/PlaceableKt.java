package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"DefaultConstraints", "Landroidx/compose/ui/unit/Constraints;", "J", "DefaultLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "PlacementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCapablePlaceable", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "owner", "Landroidx/compose/ui/node/Owner;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Placeable.kt */
public final class PlaceableKt {
    /* access modifiers changed from: private */
    public static final long DefaultConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
    /* access modifiers changed from: private */
    public static final Function1<GraphicsLayerScope, Unit> DefaultLayerBlock = PlaceableKt$DefaultLayerBlock$1.INSTANCE;

    public static final Placeable.PlacementScope PlacementScope(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        return new LookaheadCapablePlacementScope(lookaheadCapablePlaceable);
    }

    public static final Placeable.PlacementScope PlacementScope(Owner owner) {
        return new OuterPlacementScope(owner);
    }
}
