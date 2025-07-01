package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderDefaults$Track$6$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $activeTickColor;
    final /* synthetic */ long $activeTrackColor;
    final /* synthetic */ Function2<DrawScope, Offset, Unit> $drawStopIndicator;
    final /* synthetic */ Function3<DrawScope, Offset, Color, Unit> $drawTick;
    final /* synthetic */ long $inactiveTickColor;
    final /* synthetic */ long $inactiveTrackColor;
    final /* synthetic */ SliderState $sliderState;
    final /* synthetic */ float $thumbTrackGapSize;
    final /* synthetic */ float $trackInsideCornerSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderDefaults$Track$6$1(SliderState sliderState, long j, long j2, long j3, long j4, float f, float f2, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3) {
        super(1);
        this.$sliderState = sliderState;
        this.$inactiveTrackColor = j;
        this.$activeTrackColor = j2;
        this.$inactiveTickColor = j3;
        this.$activeTickColor = j4;
        this.$thumbTrackGapSize = f;
        this.$trackInsideCornerSize = f2;
        this.$drawStopIndicator = function2;
        this.$drawTick = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope drawScope2 = drawScope;
        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
        SliderDefaults sliderDefaults2 = sliderDefaults;
        sliderDefaults2.m2479drawTrackngJ0SCU(drawScope2, this.$sliderState.getTickFractions$material3_release(), 0.0f, this.$sliderState.getCoercedValueAsFraction$material3_release(), this.$inactiveTrackColor, this.$activeTrackColor, this.$inactiveTickColor, this.$activeTickColor, drawScope2.m7087toDpu2uoSUM(this.$sliderState.getTrackHeight$material3_release()), drawScope2.m7088toDpu2uoSUM(0), drawScope2.m7087toDpu2uoSUM(this.$sliderState.getThumbWidth$material3_release()), this.$thumbTrackGapSize, this.$trackInsideCornerSize, this.$drawStopIndicator, this.$drawTick, false);
    }
}
