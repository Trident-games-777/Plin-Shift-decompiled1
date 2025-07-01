package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalRuler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0004J\u0015\u0010\u0010\u001a\u00020\r*\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0007H\u0004R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"androidx/compose/ui/node/LookaheadCapablePlaceable$rulerScope$1", "Landroidx/compose/ui/layout/RulerScope;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "provides", "", "Landroidx/compose/ui/layout/Ruler;", "value", "providesRelative", "Landroidx/compose/ui/layout/VerticalRuler;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadDelegate.kt */
public final class LookaheadCapablePlaceable$rulerScope$1 implements RulerScope {
    final /* synthetic */ LookaheadCapablePlaceable this$0;

    LookaheadCapablePlaceable$rulerScope$1(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.this$0 = lookaheadCapablePlaceable;
    }

    public LayoutCoordinates getCoordinates() {
        this.this$0.getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
        return this.this$0.getCoordinates();
    }

    public void provides(Ruler ruler, float f) {
        this.this$0.provideRulerValue(ruler, f);
    }

    public void providesRelative(VerticalRuler verticalRuler, float f) {
        this.this$0.provideRelativeRulerValue(verticalRuler, f);
    }

    public float getDensity() {
        return this.this$0.getDensity();
    }

    public float getFontScale() {
        return this.this$0.getFontScale();
    }
}
