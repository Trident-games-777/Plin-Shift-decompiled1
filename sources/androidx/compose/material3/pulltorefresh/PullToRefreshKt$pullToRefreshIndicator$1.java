package androidx.compose.material3.pulltorefresh;

import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$pullToRefreshIndicator$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    public static final PullToRefreshKt$pullToRefreshIndicator$1 INSTANCE = new PullToRefreshKt$pullToRefreshIndicator$1();

    PullToRefreshKt$pullToRefreshIndicator$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        int r7 = ClipOp.Companion.m4228getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long r8 = drawContext.m4806getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().m4926clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, r7);
            contentDrawScope.drawContent();
            drawContext.getCanvas().restore();
            drawContext.m4807setSizeuvyYCjk(r8);
        } catch (Throwable th) {
            Throwable th2 = th;
            drawContext.getCanvas().restore();
            drawContext.m4807setSizeuvyYCjk(r8);
            throw th2;
        }
    }
}
