package androidx.compose.material3;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$place$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $endPadding;
    final /* synthetic */ Placeable $headlinePlaceable;
    final /* synthetic */ int $height;
    final /* synthetic */ boolean $isThreeLine;
    final /* synthetic */ Placeable $leadingPlaceable;
    final /* synthetic */ Placeable $overlinePlaceable;
    final /* synthetic */ int $startPadding;
    final /* synthetic */ Placeable $supportingPlaceable;
    final /* synthetic */ int $topPadding;
    final /* synthetic */ Placeable $trailingPlaceable;
    final /* synthetic */ int $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$place$1(Placeable placeable, Placeable placeable2, int i, boolean z, int i2, Placeable placeable3, Placeable placeable4, Placeable placeable5, int i3, int i4, int i5) {
        super(1);
        this.$leadingPlaceable = placeable;
        this.$trailingPlaceable = placeable2;
        this.$startPadding = i;
        this.$isThreeLine = z;
        this.$topPadding = i2;
        this.$headlinePlaceable = placeable3;
        this.$overlinePlaceable = placeable4;
        this.$supportingPlaceable = placeable5;
        this.$height = i3;
        this.$width = i4;
        this.$endPadding = i5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2;
        int i;
        Placeable placeable = this.$leadingPlaceable;
        if (placeable != null) {
            int i2 = this.$startPadding;
            boolean z = this.$isThreeLine;
            int i3 = this.$topPadding;
            int i4 = this.$height;
            if (!z) {
                i3 = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i4);
            }
            Placeable.PlacementScope placementScope3 = placementScope;
            Placeable.PlacementScope.placeRelative$default(placementScope3, placeable, i2, i3, 0.0f, 4, (Object) null);
            placementScope2 = placementScope3;
        } else {
            placementScope2 = placementScope;
        }
        Placeable placeable2 = this.$trailingPlaceable;
        if (placeable2 != null) {
            int i5 = this.$width;
            int i6 = this.$endPadding;
            boolean z2 = this.$isThreeLine;
            int i7 = this.$topPadding;
            int i8 = this.$height;
            int width = (i5 - i6) - placeable2.getWidth();
            if (!z2) {
                i7 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i8);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, width, i7, 0.0f, 4, (Object) null);
        }
        int widthOrZero = this.$startPadding + TextFieldImplKt.widthOrZero(this.$leadingPlaceable);
        if (this.$isThreeLine) {
            i = this.$topPadding;
        } else {
            i = Alignment.Companion.getCenterVertically().align(TextFieldImplKt.heightOrZero(this.$headlinePlaceable) + TextFieldImplKt.heightOrZero(this.$overlinePlaceable) + TextFieldImplKt.heightOrZero(this.$supportingPlaceable), this.$height);
        }
        int i9 = i;
        Placeable placeable3 = this.$overlinePlaceable;
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable3, widthOrZero, i9, 0.0f, 4, (Object) null);
        }
        int heightOrZero = i9 + TextFieldImplKt.heightOrZero(this.$overlinePlaceable);
        Placeable placeable4 = this.$headlinePlaceable;
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable4, widthOrZero, heightOrZero, 0.0f, 4, (Object) null);
        }
        int heightOrZero2 = heightOrZero + TextFieldImplKt.heightOrZero(this.$headlinePlaceable);
        Placeable placeable5 = this.$supportingPlaceable;
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable5, widthOrZero, heightOrZero2, 0.0f, 4, (Object) null);
        }
    }
}
