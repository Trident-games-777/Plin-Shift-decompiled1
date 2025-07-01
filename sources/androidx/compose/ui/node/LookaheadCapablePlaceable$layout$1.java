package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerScope;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0014\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR'\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\b\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\n¨\u0006\u0015"}, d2 = {"androidx/compose/ui/node/LookaheadCapablePlaceable$layout$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "placeChildren", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadDelegate.kt */
public final class LookaheadCapablePlaceable$layout$1 implements MeasureResult {
    final /* synthetic */ Map<AlignmentLine, Integer> $alignmentLines;
    final /* synthetic */ int $height;
    final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
    final /* synthetic */ Function1<RulerScope, Unit> $rulers;
    final /* synthetic */ int $width;
    final /* synthetic */ LookaheadCapablePlaceable this$0;

    LookaheadCapablePlaceable$layout$1(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super RulerScope, Unit> function1, Function1<? super Placeable.PlacementScope, Unit> function12, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.$width = i;
        this.$height = i2;
        this.$alignmentLines = map;
        this.$rulers = function1;
        this.$placementBlock = function12;
        this.this$0 = lookaheadCapablePlaceable;
    }

    public int getWidth() {
        return this.$width;
    }

    public int getHeight() {
        return this.$height;
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$alignmentLines;
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.$rulers;
    }

    public void placeChildren() {
        this.$placementBlock.invoke(this.this$0.getPlacementScope());
    }
}
