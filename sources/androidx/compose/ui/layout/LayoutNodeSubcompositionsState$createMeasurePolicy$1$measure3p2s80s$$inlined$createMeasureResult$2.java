package androidx.compose.ui.layout;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR'\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\b\u000f8VX\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0005X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\n¨\u0006\u0015¸\u0006\u0000"}, d2 = {"androidx/compose/ui/layout/LayoutNodeSubcompositionsState$createMeasureResult$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "placeChildren", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$2  reason: invalid class name */
/* compiled from: SubcomposeLayout.kt */
public final class LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure3p2s80s$$inlined$createMeasureResult$2 implements MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    final /* synthetic */ int $indexAfterMeasure$inlined;
    final /* synthetic */ MeasureResult $result$inlined;
    final /* synthetic */ LayoutNodeSubcompositionsState this$0;

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    public LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure3p2s80s$$inlined$createMeasureResult$2(MeasureResult measureResult, LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, MeasureResult measureResult2) {
        this.this$0 = layoutNodeSubcompositionsState;
        this.$indexAfterMeasure$inlined = i;
        this.$result$inlined = measureResult2;
        this.$$delegate_0 = measureResult;
    }

    public void placeChildren() {
        this.this$0.currentIndex = this.$indexAfterMeasure$inlined;
        this.$result$inlined.placeChildren();
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.this$0;
        layoutNodeSubcompositionsState.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState.currentIndex);
    }
}
