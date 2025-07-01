package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$7$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ State<Float> $firstLineHead;
    final /* synthetic */ State<Float> $firstLineTail;
    final /* synthetic */ float $gapSize;
    final /* synthetic */ State<Float> $secondLineHead;
    final /* synthetic */ State<Float> $secondLineTail;
    final /* synthetic */ int $strokeCap;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$7$1(int i, float f, State<Float> state, long j, State<Float> state2, long j2, State<Float> state3, State<Float> state4) {
        super(1);
        this.$strokeCap = i;
        this.$gapSize = f;
        this.$firstLineHead = state;
        this.$trackColor = j;
        this.$firstLineTail = state2;
        this.$color = j2;
        this.$secondLineHead = state3;
        this.$secondLineTail = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        float f;
        DrawScope drawScope2;
        float r7 = Size.m4053getHeightimpl(drawScope.m4865getSizeNHjbRc());
        if (StrokeCap.m4630equalsimpl0(this.$strokeCap, StrokeCap.Companion.m4634getButtKaPHkGw()) || Size.m4053getHeightimpl(drawScope.m4865getSizeNHjbRc()) > Size.m4056getWidthimpl(drawScope.m4865getSizeNHjbRc())) {
            f = this.$gapSize;
        } else {
            f = Dp.m7111constructorimpl(this.$gapSize + drawScope.m7087toDpu2uoSUM(r7));
        }
        float r0 = f / drawScope.m7087toDpu2uoSUM(Size.m4056getWidthimpl(drawScope.m4865getSizeNHjbRc()));
        float f2 = 1.0f;
        if (this.$firstLineHead.getValue().floatValue() < 1.0f - r0) {
            drawScope2 = drawScope;
            ProgressIndicatorKt.m2368drawLinearIndicatorqYKTg0g(drawScope2, this.$firstLineHead.getValue().floatValue() > 0.0f ? this.$firstLineHead.getValue().floatValue() + r0 : 0.0f, 1.0f, this.$trackColor, r7, this.$strokeCap);
        } else {
            drawScope2 = drawScope;
        }
        if (this.$firstLineHead.getValue().floatValue() - this.$firstLineTail.getValue().floatValue() > 0.0f) {
            ProgressIndicatorKt.m2368drawLinearIndicatorqYKTg0g(drawScope2, this.$firstLineHead.getValue().floatValue(), this.$firstLineTail.getValue().floatValue(), this.$color, r7, this.$strokeCap);
        }
        if (this.$firstLineTail.getValue().floatValue() > r0) {
            ProgressIndicatorKt.m2368drawLinearIndicatorqYKTg0g(drawScope2, this.$secondLineHead.getValue().floatValue() > 0.0f ? this.$secondLineHead.getValue().floatValue() + r0 : 0.0f, this.$firstLineTail.getValue().floatValue() < 1.0f ? this.$firstLineTail.getValue().floatValue() - r0 : 1.0f, this.$trackColor, r7, this.$strokeCap);
        }
        if (this.$secondLineHead.getValue().floatValue() - this.$secondLineTail.getValue().floatValue() > 0.0f) {
            ProgressIndicatorKt.m2368drawLinearIndicatorqYKTg0g(drawScope2, this.$secondLineHead.getValue().floatValue(), this.$secondLineTail.getValue().floatValue(), this.$color, r7, this.$strokeCap);
        }
        if (this.$secondLineTail.getValue().floatValue() > r0) {
            if (this.$secondLineTail.getValue().floatValue() < 1.0f) {
                f2 = this.$secondLineTail.getValue().floatValue() - r0;
            }
            ProgressIndicatorKt.m2368drawLinearIndicatorqYKTg0g(drawScope2, 0.0f, f2, this.$trackColor, r7, this.$strokeCap);
        }
    }
}
