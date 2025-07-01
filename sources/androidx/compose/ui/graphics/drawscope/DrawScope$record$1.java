package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawScope.kt */
final class DrawScope$record$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ Function1<DrawScope, Unit> $block;
    final /* synthetic */ DrawScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawScope$record$1(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        super(1);
        this.this$0 = drawScope;
        this.$block = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope drawScope2 = this.this$0;
        Density density = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        long r4 = drawScope.getDrawContext().m4806getSizeNHjbRc();
        GraphicsLayer graphicsLayer = drawScope.getDrawContext().getGraphicsLayer();
        Function1<DrawScope, Unit> function1 = this.$block;
        Density density2 = drawScope2.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope2.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope2.getDrawContext().getCanvas();
        long r10 = drawScope2.getDrawContext().m4806getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope2.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope2.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.m4807setSizeuvyYCjk(r4);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            function1.invoke(drawScope2);
        } finally {
            canvas.restore();
            DrawContext drawContext2 = drawScope2.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.m4807setSizeuvyYCjk(r10);
            drawContext2.setGraphicsLayer(graphicsLayer2);
        }
    }
}
