package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/graphics/Canvas;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RenderNodeLayer.android.kt */
final class RenderNodeLayer$updateDisplayList$1$1 extends Lambda implements Function1<Canvas, Unit> {
    final /* synthetic */ Function2<Canvas, GraphicsLayer, Unit> $drawBlock;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderNodeLayer$updateDisplayList$1$1(Function2<? super Canvas, ? super GraphicsLayer, Unit> function2) {
        super(1);
        this.$drawBlock = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Canvas) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Canvas canvas) {
        this.$drawBlock.invoke(canvas, null);
    }
}
