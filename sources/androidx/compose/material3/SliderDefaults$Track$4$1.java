package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderDefaults$Track$4$1 extends Lambda implements Function2<DrawScope, Offset, Unit> {
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderDefaults$Track$4$1(SliderColors sliderColors, boolean z) {
        super(2);
        this.$colors = sliderColors;
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m2488invokeUv8p0NA((DrawScope) obj, ((Offset) obj2).m3997unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m2488invokeUv8p0NA(DrawScope drawScope, long j) {
        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
        long r5 = this.$colors.m2475trackColorWaAFU9c$material3_release(this.$enabled, true);
        sliderDefaults.m2478drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m2486getTrackStopIndicatorSizeD9Ej5fM(), r5);
    }
}
