package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Shadow.kt */
final class ShadowGraphicsLayerElement$createBlock$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ ShadowGraphicsLayerElement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShadowGraphicsLayerElement$createBlock$1(ShadowGraphicsLayerElement shadowGraphicsLayerElement) {
        super(1);
        this.this$0 = shadowGraphicsLayerElement;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setShadowElevation(graphicsLayerScope.m7091toPx0680j_4(this.this$0.m3882getElevationD9Ej5fM()));
        graphicsLayerScope.setShape(this.this$0.getShape());
        graphicsLayerScope.setClip(this.this$0.getClip());
        graphicsLayerScope.m4430setAmbientShadowColor8_81llA(this.this$0.m3881getAmbientColor0d7_KjU());
        graphicsLayerScope.m4432setSpotShadowColor8_81llA(this.this$0.m3883getSpotColor0d7_KjU());
    }
}
