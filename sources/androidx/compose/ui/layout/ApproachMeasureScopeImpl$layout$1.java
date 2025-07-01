package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0016\u001a\u00020\u0010H\u0016R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR'\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e¢\u0006\u0002\b\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\f¨\u0006\u0017"}, d2 = {"androidx/compose/ui/layout/ApproachMeasureScopeImpl$layout$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines$annotations", "()V", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "placeChildren", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ApproachMeasureScope.kt */
public final class ApproachMeasureScopeImpl$layout$1 implements MeasureResult {
    final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
    private final Map<AlignmentLine, Integer> alignmentLines;
    private final int height;
    private final Function1<RulerScope, Unit> rulers;
    final /* synthetic */ ApproachMeasureScopeImpl this$0;
    private final int width;

    public static /* synthetic */ void getAlignmentLines$annotations() {
    }

    ApproachMeasureScopeImpl$layout$1(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super RulerScope, Unit> function1, Function1<? super Placeable.PlacementScope, Unit> function12, ApproachMeasureScopeImpl approachMeasureScopeImpl) {
        this.$placementBlock = function12;
        this.this$0 = approachMeasureScopeImpl;
        this.width = i;
        this.height = i2;
        this.alignmentLines = map;
        this.rulers = function1;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.alignmentLines;
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.rulers;
    }

    public void placeChildren() {
        this.$placementBlock.invoke(this.this$0.getCoordinator().getPlacementScope());
    }
}
