package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderDefaults$Track$7 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ Function2<DrawScope, Offset, Unit> $drawStopIndicator;
    final /* synthetic */ Function3<DrawScope, Offset, Color, Unit> $drawTick;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ SliderState $sliderState;
    final /* synthetic */ float $thumbTrackGapSize;
    final /* synthetic */ SliderDefaults $tmp2_rcvr;
    final /* synthetic */ float $trackInsideCornerSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderDefaults$Track$7(SliderDefaults sliderDefaults, SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, float f, float f2, int i, int i2) {
        super(2);
        this.$tmp2_rcvr = sliderDefaults;
        this.$sliderState = sliderState;
        this.$modifier = modifier;
        this.$enabled = z;
        this.$colors = sliderColors;
        this.$drawStopIndicator = function2;
        this.$drawTick = function3;
        this.$thumbTrackGapSize = f;
        this.$trackInsideCornerSize = f2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp2_rcvr.m2483Track4EFweAY(this.$sliderState, this.$modifier, this.$enabled, this.$colors, (Function2<? super DrawScope, ? super Offset, Unit>) this.$drawStopIndicator, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) this.$drawTick, this.$thumbTrackGapSize, this.$trackInsideCornerSize, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
