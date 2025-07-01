package androidx.compose.ui.draw;

import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawModifier.kt */
final class CacheDrawScope$record$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ Function1<ContentDrawScope, Unit> $block;
    final /* synthetic */ Density $density;
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ long $size;
    final /* synthetic */ CacheDrawScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CacheDrawScope$record$1(CacheDrawScope cacheDrawScope, Density density, LayoutDirection layoutDirection, long j, Function1<? super ContentDrawScope, Unit> function1) {
        super(1);
        this.this$0 = cacheDrawScope;
        this.$density = density;
        this.$layoutDirection = layoutDirection;
        this.$size = j;
        this.$block = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        ContentDrawScope contentDrawScope$ui_release = this.this$0.getContentDrawScope$ui_release();
        Intrinsics.checkNotNull(contentDrawScope$ui_release);
        Density density = this.$density;
        LayoutDirection layoutDirection = this.$layoutDirection;
        long j = this.$size;
        Function1<ContentDrawScope, Unit> function1 = this.$block;
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        DrawScope drawScope2 = contentDrawScope$ui_release;
        long Size = SizeKt.Size((float) IntSize.m7283getWidthimpl(j), (float) IntSize.m7282getHeightimpl(j));
        Density density2 = drawScope2.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope2.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope2.getDrawContext().getCanvas();
        long r10 = drawScope2.getDrawContext().m4806getSizeNHjbRc();
        GraphicsLayer graphicsLayer = drawScope2.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope2.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.m4807setSizeuvyYCjk(Size);
        drawContext.setGraphicsLayer((GraphicsLayer) null);
        canvas.save();
        try {
            function1.invoke(contentDrawScope$ui_release);
        } finally {
            canvas.restore();
            DrawContext drawContext2 = drawScope2.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.m4807setSizeuvyYCjk(r10);
            drawContext2.setGraphicsLayer(graphicsLayer);
        }
    }
}
