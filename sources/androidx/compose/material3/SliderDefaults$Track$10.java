package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderDefaults$Track$10 extends Lambda implements Function3<DrawScope, Offset, Color, Unit> {
    public static final SliderDefaults$Track$10 INSTANCE = new SliderDefaults$Track$10();

    SliderDefaults$Track$10() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m2487invokewPWG1Vc((DrawScope) obj, ((Offset) obj2).m3997unboximpl(), ((Color) obj3).m4249unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-wPWG1Vc  reason: not valid java name */
    public final void m2487invokewPWG1Vc(DrawScope drawScope, long j, long j2) {
        SliderDefaults.INSTANCE.m2478drawStopIndicatorx3O1jOs(drawScope, j, SliderDefaults.INSTANCE.m2485getTickSizeD9Ej5fM(), j2);
    }
}
