package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderDefaults$Track$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $activeTickColor;
    final /* synthetic */ long $activeTrackColor;
    final /* synthetic */ long $inactiveTickColor;
    final /* synthetic */ long $inactiveTrackColor;
    final /* synthetic */ SliderPositions $sliderPositions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderDefaults$Track$1$1(long j, SliderPositions sliderPositions, long j2, long j3, long j4) {
        super(1);
        this.$inactiveTrackColor = j;
        this.$sliderPositions = sliderPositions;
        this.$activeTrackColor = j2;
        this.$inactiveTickColor = j3;
        this.$activeTickColor = j4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        long j;
        List list;
        long j2;
        DrawScope drawScope2 = drawScope;
        boolean z = drawScope2.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(0.0f, Offset.m3988getYimpl(drawScope2.m4864getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m4056getWidthimpl(drawScope2.m4865getSizeNHjbRc()), Offset.m3988getYimpl(drawScope2.m4864getCenterF1C5BW0()));
        long j3 = Offset;
        long j4 = z ? Offset2 : j3;
        if (!z) {
            j3 = Offset2;
        }
        float r18 = drawScope2.m7091toPx0680j_4(SliderDefaults.INSTANCE.m2485getTickSizeD9Ej5fM());
        float r8 = drawScope2.m7091toPx0680j_4(SliderKt.getTrackHeight());
        DrawScope.m4832drawLineNGM6Ib0$default(drawScope2, this.$inactiveTrackColor, j4, j3, r8, StrokeCap.Companion.m4635getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        long j5 = j4;
        long j6 = j3;
        DrawScope.m4832drawLineNGM6Ib0$default(drawScope, this.$activeTrackColor, OffsetKt.Offset(Offset.m3987getXimpl(j4) + ((Offset.m3987getXimpl(j3) - Offset.m3987getXimpl(j4)) * this.$sliderPositions.getActiveRange().getStart().floatValue()), Offset.m3988getYimpl(drawScope.m4864getCenterF1C5BW0())), OffsetKt.Offset(Offset.m3987getXimpl(j4) + ((Offset.m3987getXimpl(j3) - Offset.m3987getXimpl(j4)) * this.$sliderPositions.getActiveRange().getEndInclusive().floatValue()), Offset.m3988getYimpl(drawScope.m4864getCenterF1C5BW0())), r8, StrokeCap.Companion.m4635getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        float[] tickFractions = this.$sliderPositions.getTickFractions();
        SliderPositions sliderPositions = this.$sliderPositions;
        Map linkedHashMap = new LinkedHashMap();
        int length = tickFractions.length;
        for (int i = 0; i < length; i++) {
            float f = tickFractions[i];
            Boolean valueOf = Boolean.valueOf(f > sliderPositions.getActiveRange().getEndInclusive().floatValue() || f < sliderPositions.getActiveRange().getStart().floatValue());
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(valueOf, obj);
            }
            ((List) obj).add(Float.valueOf(f));
        }
        long j7 = this.$inactiveTickColor;
        long j8 = this.$activeTickColor;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list2 = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(list2.size());
            int size = list2.size();
            int i2 = 0;
            while (i2 < size) {
                arrayList.add(Offset.m3976boximpl(OffsetKt.Offset(Offset.m3987getXimpl(OffsetKt.m4010lerpWko1d7g(j5, j6, ((Number) list2.get(i2)).floatValue())), Offset.m3988getYimpl(drawScope.m4864getCenterF1C5BW0()))));
                i2++;
            }
            long j9 = j5;
            long j10 = j6;
            List list3 = arrayList;
            int r3 = PointMode.Companion.m4569getPointsr_lszbg();
            if (booleanValue) {
                j2 = j8;
                list = list3;
                j = j7;
            } else {
                list = list3;
                j2 = j8;
                j = j2;
            }
            long j11 = j2;
            DrawScope.m4837drawPointsF8ZwMP8$default(drawScope, list, r3, j, r18, StrokeCap.Companion.m4635getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            j6 = j10;
            j8 = j11;
            j5 = j9;
        }
    }
}
