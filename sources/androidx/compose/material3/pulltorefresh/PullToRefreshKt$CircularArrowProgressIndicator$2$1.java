package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$CircularArrowProgressIndicator$2$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Float> $alphaState;
    final /* synthetic */ long $color;
    final /* synthetic */ Path $path;
    final /* synthetic */ Function0<Float> $progress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshKt$CircularArrowProgressIndicator$2$1(Function0<Float> function0, State<Float> state, long j, Path path) {
        super(1);
        this.$progress = function0;
        this.$alphaState = state;
        this.$color = j;
        this.$path = path;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        ArrowValues access$ArrowValues = PullToRefreshKt.ArrowValues(this.$progress.invoke().floatValue());
        float floatValue = this.$alphaState.getValue().floatValue();
        float rotation = access$ArrowValues.getRotation();
        long j = this.$color;
        Path path = this.$path;
        long r6 = drawScope.m4864getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long r10 = drawContext.m4806getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().m4929rotateUv8p0NA(rotation, r6);
            Rect r62 = RectKt.m4026Rect3MmeM6k(SizeKt.m4066getCenteruvyYCjk(drawScope.m4865getSizeNHjbRc()), drawScope.m7091toPx0680j_4(PullToRefreshKt.ArcRadius) + (drawScope.m7091toPx0680j_4(PullToRefreshKt.StrokeWidth) / 2.0f));
            DrawScope drawScope2 = drawScope;
            PullToRefreshKt.m3015drawCircularIndicatorKzyDr3Q(drawScope2, j, floatValue, access$ArrowValues, r62, PullToRefreshKt.StrokeWidth);
            Rect rect = r62;
            float f = floatValue;
            long j2 = j;
            Path path2 = path;
            PullToRefreshKt.m3014drawArrowuDrxG_w(drawScope2, path2, rect, j2, f, access$ArrowValues, PullToRefreshKt.StrokeWidth);
            drawContext.getCanvas().restore();
            drawContext.m4807setSizeuvyYCjk(r10);
        } catch (Throwable th) {
            Throwable th2 = th;
            drawContext.getCanvas().restore();
            drawContext.m4807setSizeuvyYCjk(r10);
            throw th2;
        }
    }
}
