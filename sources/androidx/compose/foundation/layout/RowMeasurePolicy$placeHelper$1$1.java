package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Row.kt */
final class RowMeasurePolicy$placeHelper$1$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $beforeCrossAxisAlignmentLine;
    final /* synthetic */ int $crossAxisLayoutSize;
    final /* synthetic */ int[] $mainAxisPositions;
    final /* synthetic */ Placeable[] $placeables;
    final /* synthetic */ RowMeasurePolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RowMeasurePolicy$placeHelper$1$1(Placeable[] placeableArr, RowMeasurePolicy rowMeasurePolicy, int i, int i2, int[] iArr) {
        super(1);
        this.$placeables = placeableArr;
        this.this$0 = rowMeasurePolicy;
        this.$crossAxisLayoutSize = i;
        this.$beforeCrossAxisAlignmentLine = i2;
        this.$mainAxisPositions = iArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable[] placeableArr = this.$placeables;
        RowMeasurePolicy rowMeasurePolicy = this.this$0;
        int i = this.$crossAxisLayoutSize;
        int i2 = this.$beforeCrossAxisAlignmentLine;
        int[] iArr = this.$mainAxisPositions;
        int length = placeableArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            Placeable placeable = placeableArr[i3];
            Intrinsics.checkNotNull(placeable);
            Placeable.PlacementScope.place$default(placementScope, placeable, iArr[i4], rowMeasurePolicy.getCrossAxisPosition(placeable, RowColumnImplKt.getRowColumnParentData(placeable), i, i2), 0.0f, 4, (Object) null);
            i3++;
            i4++;
        }
    }
}
