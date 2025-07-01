package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
final class FlowLineMeasurePolicy$placeHelper$1$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $beforeCrossAxisAlignmentLine;
    final /* synthetic */ int $crossAxisLayoutSize;
    final /* synthetic */ int[] $crossAxisOffset;
    final /* synthetic */ int $currentLineIndex;
    final /* synthetic */ int $endIndex;
    final /* synthetic */ int[] $mainAxisPositions;
    final /* synthetic */ Placeable[] $placeables;
    final /* synthetic */ int $startIndex;
    final /* synthetic */ MeasureScope $this_with;
    final /* synthetic */ FlowLineMeasurePolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLineMeasurePolicy$placeHelper$1$1(int[] iArr, int i, int i2, int i3, Placeable[] placeableArr, FlowLineMeasurePolicy flowLineMeasurePolicy, int i4, MeasureScope measureScope, int i5, int[] iArr2) {
        super(1);
        this.$crossAxisOffset = iArr;
        this.$currentLineIndex = i;
        this.$startIndex = i2;
        this.$endIndex = i3;
        this.$placeables = placeableArr;
        this.this$0 = flowLineMeasurePolicy;
        this.$crossAxisLayoutSize = i4;
        this.$this_with = measureScope;
        this.$beforeCrossAxisAlignmentLine = i5;
        this.$mainAxisPositions = iArr2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2;
        int[] iArr = this.$crossAxisOffset;
        int i = iArr != null ? iArr[this.$currentLineIndex] : 0;
        int i2 = this.$startIndex;
        while (i2 < this.$endIndex) {
            Placeable placeable = this.$placeables[i2];
            Intrinsics.checkNotNull(placeable);
            int crossAxisPosition = this.this$0.getCrossAxisPosition(placeable, RowColumnImplKt.getRowColumnParentData(placeable), this.$crossAxisLayoutSize, this.$this_with.getLayoutDirection(), this.$beforeCrossAxisAlignmentLine) + i;
            if (this.this$0.isHorizontal()) {
                placementScope2 = placementScope;
                Placeable.PlacementScope.place$default(placementScope2, placeable, this.$mainAxisPositions[i2 - this.$startIndex], crossAxisPosition, 0.0f, 4, (Object) null);
            } else {
                placementScope2 = placementScope;
                Placeable.PlacementScope.place$default(placementScope2, placeable, crossAxisPosition, this.$mainAxisPositions[i2 - this.$startIndex], 0.0f, 4, (Object) null);
            }
            i2++;
            placementScope = placementScope2;
        }
    }
}
