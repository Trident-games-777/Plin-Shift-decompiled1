package androidx.compose.material3;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$3$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ Function0<Float> $coercedProgress;
    final /* synthetic */ long $color;
    final /* synthetic */ float $gapSize;
    final /* synthetic */ Stroke $stroke;
    final /* synthetic */ int $strokeCap;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$3$1(Function0<Float> function0, int i, float f, float f2, long j, Stroke stroke, long j2) {
        super(1);
        this.$coercedProgress = function0;
        this.$strokeCap = i;
        this.$gapSize = f;
        this.$strokeWidth = f2;
        this.$trackColor = j;
        this.$stroke = stroke;
        this.$color = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        float f;
        float floatValue = this.$coercedProgress.invoke().floatValue() * 360.0f;
        if (StrokeCap.m4630equalsimpl0(this.$strokeCap, StrokeCap.Companion.m4634getButtKaPHkGw()) || Size.m4053getHeightimpl(drawScope.m4865getSizeNHjbRc()) > Size.m4056getWidthimpl(drawScope.m4865getSizeNHjbRc())) {
            f = this.$gapSize;
        } else {
            f = Dp.m7111constructorimpl(this.$gapSize + this.$strokeWidth);
        }
        float r0 = (f / ((float) (((double) drawScope.m7087toDpu2uoSUM(Size.m4056getWidthimpl(drawScope.m4865getSizeNHjbRc()))) * 3.141592653589793d))) * 360.0f;
        DrawScope drawScope2 = drawScope;
        ProgressIndicatorKt.m2364drawCircularIndicator42QJj7c(drawScope2, 270.0f + floatValue + Math.min(floatValue, r0), (360.0f - floatValue) - (Math.min(floatValue, r0) * ((float) 2)), this.$trackColor, this.$stroke);
        ProgressIndicatorKt.m2366drawDeterminateCircularIndicator42QJj7c(drawScope2, 270.0f, floatValue, this.$color, this.$stroke);
    }
}
