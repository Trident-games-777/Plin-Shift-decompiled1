package androidx.compose.material3.pulltorefresh;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$pullToRefreshIndicator$2 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ float $elevation;
    final /* synthetic */ boolean $isRefreshing;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ PullToRefreshState $state;
    final /* synthetic */ float $threshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshKt$pullToRefreshIndicator$2(PullToRefreshState pullToRefreshState, boolean z, float f, float f2, Shape shape) {
        super(1);
        this.$state = pullToRefreshState;
        this.$isRefreshing = z;
        this.$threshold = f;
        this.$elevation = f2;
        this.$shape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        float f = 0.0f;
        boolean z = this.$state.getDistanceFraction() > 0.0f || this.$isRefreshing;
        graphicsLayerScope.setTranslationY((this.$state.getDistanceFraction() * ((float) graphicsLayerScope.m7086roundToPx0680j_4(this.$threshold))) - Size.m4053getHeightimpl(graphicsLayerScope.m4427getSizeNHjbRc()));
        if (z) {
            f = graphicsLayerScope.m7091toPx0680j_4(this.$elevation);
        }
        graphicsLayerScope.setShadowElevation(f);
        graphicsLayerScope.setShape(this.$shape);
        graphicsLayerScope.setClip(true);
    }
}
