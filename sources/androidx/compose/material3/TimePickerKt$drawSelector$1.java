package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$drawSelector$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ AnalogTimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$drawSelector$1(AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors) {
        super(1);
        this.$state = analogTimePickerState;
        this.$colors = timePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        long Offset = OffsetKt.Offset(contentDrawScope2.m7091toPx0680j_4(DpOffset.m7172getXD9Ej5fM(TimePickerKt.getSelectorPos(this.$state))), contentDrawScope2.m7091toPx0680j_4(DpOffset.m7174getYD9Ej5fM(TimePickerKt.getSelectorPos(this.$state))));
        float f = (float) 2;
        float r7 = contentDrawScope2.m7091toPx0680j_4(TimePickerTokens.INSTANCE.m3563getClockDialSelectorHandleContainerSizeD9Ej5fM()) / f;
        long r16 = this.$colors.m2708getSelectorColor0d7_KjU();
        DrawScope drawScope = contentDrawScope2;
        DrawScope.m4827drawCircleVaOC9Bg$default(drawScope, Color.Companion.m4265getBlack0d7_KjU(), r7, Offset, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m4143getClear0nO6VwU(), 56, (Object) null);
        contentDrawScope2.drawContent();
        long j = r16;
        DrawScope.m4827drawCircleVaOC9Bg$default(drawScope, j, r7, Offset, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m4171getXor0nO6VwU(), 56, (Object) null);
        long j2 = j;
        float r17 = contentDrawScope2.m7091toPx0680j_4(TimePickerTokens.INSTANCE.m3564getClockDialSelectorTrackContainerWidthD9Ej5fM());
        DrawScope drawScope2 = drawScope;
        DrawScope.m4832drawLineNGM6Ib0$default(drawScope2, j2, SizeKt.m4066getCenteruvyYCjk(contentDrawScope2.m4865getSizeNHjbRc()), Offset.m3991minusMKHz9U(Offset, OffsetKt.Offset(((float) Math.cos((double) this.$state.getCurrentAngle())) * r7, ((float) Math.sin((double) this.$state.getCurrentAngle())) * r7)), r17, 0, (PathEffect) null, 0.0f, (ColorFilter) null, BlendMode.Companion.m4170getSrcOver0nO6VwU(), 240, (Object) null);
        DrawScope.m4827drawCircleVaOC9Bg$default(drawScope2, j2, contentDrawScope2.m7091toPx0680j_4(TimePickerTokens.INSTANCE.m3562getClockDialSelectorCenterContainerSizeD9Ej5fM()) / f, SizeKt.m4066getCenteruvyYCjk(contentDrawScope2.m4865getSizeNHjbRc()), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
        DrawScope.m4827drawCircleVaOC9Bg$default(drawScope, this.$colors.m2697clockDialContentColorvNxB06k$material3_release(true), r7, Offset, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m4153getDstOver0nO6VwU(), 56, (Object) null);
    }
}
