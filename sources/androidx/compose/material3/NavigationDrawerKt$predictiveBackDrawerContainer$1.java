package androidx.compose.material3;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$predictiveBackDrawerContainer$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
    final /* synthetic */ boolean $isRtl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$predictiveBackDrawerContainer$1(DrawerPredictiveBackState drawerPredictiveBackState, boolean z) {
        super(1);
        this.$drawerPredictiveBackState = drawerPredictiveBackState;
        this.$isRtl = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setScaleX(NavigationDrawerKt.calculatePredictiveBackScaleX(graphicsLayerScope, this.$drawerPredictiveBackState));
        graphicsLayerScope.setScaleY(NavigationDrawerKt.calculatePredictiveBackScaleY(graphicsLayerScope, this.$drawerPredictiveBackState));
        graphicsLayerScope.m4433setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(this.$isRtl ? 1.0f : 0.0f, 0.5f));
    }
}
