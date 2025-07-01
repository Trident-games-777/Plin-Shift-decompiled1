package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsLayerOwnerLayer.android.kt */
final class GraphicsLayerOwnerLayer$recordLambda$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ GraphicsLayerOwnerLayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphicsLayerOwnerLayer$recordLambda$1(GraphicsLayerOwnerLayer graphicsLayerOwnerLayer) {
        super(1);
        this.this$0 = graphicsLayerOwnerLayer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = this.this$0;
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        Function2 access$getDrawBlock$p = graphicsLayerOwnerLayer.drawBlock;
        if (access$getDrawBlock$p != null) {
            access$getDrawBlock$p.invoke(canvas, drawScope.getDrawContext().getGraphicsLayer());
        }
    }
}
