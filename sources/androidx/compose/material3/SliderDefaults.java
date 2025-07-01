package androidx.compose.material3;

import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010!J\u0001\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0017\u001a\u00020\r2!\b\u0002\u0010\"\u001a\u001b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0012\u0018\u00010#¢\u0006\u0002\b&2%\b\u0002\u0010'\u001a\u001f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\b&2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-J3\u0010\u001e\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u00100J3\u0010\u001e\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u00103J\u0001\u0010\u001e\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0017\u001a\u00020\r2!\b\u0002\u0010\"\u001a\u001b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0012\u0018\u00010#¢\u0006\u0002\b&2%\b\u0002\u0010'\u001a\u001f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\b&2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u00104J\r\u0010\u0017\u001a\u00020\rH\u0007¢\u0006\u0002\u00105Jv\u0010\u0017\u001a\u00020\r2\b\b\u0002\u00106\u001a\u00020)2\b\b\u0002\u00107\u001a\u00020)2\b\b\u0002\u00108\u001a\u00020)2\b\b\u0002\u00109\u001a\u00020)2\b\b\u0002\u0010:\u001a\u00020)2\b\b\u0002\u0010;\u001a\u00020)2\b\b\u0002\u0010<\u001a\u00020)2\b\b\u0002\u0010=\u001a\u00020)2\b\b\u0002\u0010>\u001a\u00020)2\b\b\u0002\u0010?\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ2\u0010\"\u001a\u00020\u00122\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010GJÄ\u0001\u0010H\u001a\u00020\u0012*\u00020$2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020L2\u0006\u00109\u001a\u00020)2\u0006\u00107\u001a\u00020)2\u0006\u0010:\u001a\u00020)2\u0006\u00108\u001a\u00020)2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u001f\u0010\"\u001a\u001b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0012\u0018\u00010#¢\u0006\u0002\b&2#\u0010'\u001a\u001f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\b&2\u0006\u0010Q\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ>\u0010T\u001a\u00020\u0012*\u00020$2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020U2\u0006\u0010E\u001a\u00020)2\u0006\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u00020LH\u0002ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "TickSize", "Landroidx/compose/ui/unit/Dp;", "getTickSize-D9Ej5fM", "()F", "F", "TrackStopIndicatorSize", "getTrackStopIndicatorSize-D9Ej5fM", "trackPath", "Landroidx/compose/ui/graphics/Path;", "defaultSliderColors", "Landroidx/compose/material3/SliderColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "drawTick", "Lkotlin/Function3;", "Landroidx/compose/ui/graphics/Color;", "thumbTrackGapSize", "trackInsideCornerSize", "Track-4EFweAY", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "drawScope", "offset", "size", "color", "drawStopIndicator-x3O1jOs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFJ)V", "drawTrack", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "height", "startThumbWidth", "endThumbWidth", "isRangeSlider", "drawTrack-ngJ0SCU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJFFFFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Z)V", "drawTrackPath", "Landroidx/compose/ui/geometry/Size;", "startCornerRadius", "endCornerRadius", "drawTrackPath-Cx2C_VA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJJFF)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    private static final float TickSize = SliderTokens.INSTANCE.m3521getStopIndicatorSizeD9Ej5fM();
    private static final float TrackStopIndicatorSize = SliderTokens.INSTANCE.m3521getStopIndicatorSizeD9Ej5fM();
    private static final Path trackPath = AndroidPath_androidKt.Path();

    private SliderDefaults() {
    }

    public final SliderColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1376295968, "C(colors)845@36907L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, i, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:845)");
        }
        SliderColors defaultSliderColors$material3_release = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSliderColors$material3_release;
    }

    /* renamed from: colors-q0g_0yA  reason: not valid java name */
    public final SliderColors m2484colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, 885588574, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)887@39230L11:Slider.kt#uh7d8r");
        long r7 = (i4 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i4 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r11 = (i4 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i4 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r15 = (i4 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r17 = (i4 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        long r19 = (i4 & 64) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j7;
        long r21 = (i4 & 128) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j8;
        long r23 = (i4 & 256) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j9;
        long r25 = (i4 & 512) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:887)");
        }
        SliderColors r1 = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2462copyK518z4(r7, r9, r11, r13, r15, r17, r19, r21, r23, r25);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final SliderColors getDefaultSliderColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SliderColors defaultSliderColorsCached$material3_release = colorScheme2.getDefaultSliderColorsCached$material3_release();
        if (defaultSliderColorsCached$material3_release != null) {
            return defaultSliderColorsCached$material3_release;
        }
        SliderColors sliderColors = new SliderColors(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getHandleColor()), ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getActiveTrackColor()), ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getInactiveTrackColor()), ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getActiveTrackColor()), ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getDisabledHandleColor()), SliderTokens.INSTANCE.getDisabledHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme2.m1872getSurface0d7_KjU()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultSliderColorsCached$material3_release(sliderColors);
        return sliderColors;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0146  */
    /* renamed from: Thumb-9LiSoMs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2481Thumb9LiSoMs(androidx.compose.foundation.interaction.MutableInteractionSource r24, androidx.compose.ui.Modifier r25, androidx.compose.material3.SliderColors r26, boolean r27, long r28, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r8 = r31
            r0 = -290277409(0xffffffffeeb2b7df, float:-2.765531E28)
            r3 = r30
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)947@42562L8,951@42678L46,952@42767L658,952@42733L692,975@43824L5,971@43620L220:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r32 & 1
            if (r4 == 0) goto L_0x001b
            r4 = r8 | 6
            goto L_0x002b
        L_0x001b:
            r4 = r8 & 6
            if (r4 != 0) goto L_0x002a
            boolean r4 = r3.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x0027
            r4 = 4
            goto L_0x0028
        L_0x0027:
            r4 = 2
        L_0x0028:
            r4 = r4 | r8
            goto L_0x002b
        L_0x002a:
            r4 = r8
        L_0x002b:
            r7 = r32 & 2
            if (r7 == 0) goto L_0x0032
            r4 = r4 | 48
            goto L_0x0045
        L_0x0032:
            r9 = r8 & 48
            if (r9 != 0) goto L_0x0045
            r9 = r25
            boolean r10 = r3.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0041
            r10 = 32
            goto L_0x0043
        L_0x0041:
            r10 = 16
        L_0x0043:
            r4 = r4 | r10
            goto L_0x0047
        L_0x0045:
            r9 = r25
        L_0x0047:
            r10 = r8 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x0060
            r10 = r32 & 4
            if (r10 != 0) goto L_0x005a
            r10 = r26
            boolean r11 = r3.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x005c
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r10 = r26
        L_0x005c:
            r11 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r4 = r4 | r11
            goto L_0x0062
        L_0x0060:
            r10 = r26
        L_0x0062:
            r11 = r32 & 8
            if (r11 == 0) goto L_0x0069
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r12 = r8 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007c
            r12 = r27
            boolean r13 = r3.changed((boolean) r12)
            if (r13 == 0) goto L_0x0078
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r13
            goto L_0x007e
        L_0x007c:
            r12 = r27
        L_0x007e:
            r13 = r32 & 16
            if (r13 == 0) goto L_0x0085
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0085:
            r14 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r14 != 0) goto L_0x0099
            r14 = r28
            boolean r16 = r3.changed((long) r14)
            if (r16 == 0) goto L_0x0094
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r4 = r4 | r16
            goto L_0x009b
        L_0x0099:
            r14 = r28
        L_0x009b:
            r16 = r32 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a4
            r4 = r4 | r17
            goto L_0x00b5
        L_0x00a4:
            r16 = r8 & r17
            if (r16 != 0) goto L_0x00b5
            boolean r16 = r3.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x00b1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r4 = r4 | r16
        L_0x00b5:
            r16 = 74899(0x12493, float:1.04956E-40)
            r5 = r4 & r16
            r6 = 74898(0x12492, float:1.04954E-40)
            if (r5 != r6) goto L_0x00ce
            boolean r5 = r3.getSkipping()
            if (r5 != 0) goto L_0x00c6
            goto L_0x00ce
        L_0x00c6:
            r3.skipToGroupEnd()
            r6 = r14
        L_0x00ca:
            r4 = r10
            r5 = r12
            goto L_0x01b5
        L_0x00ce:
            r3.startDefaults()
            r5 = r8 & 1
            r6 = 1
            if (r5 == 0) goto L_0x00e9
            boolean r5 = r3.getDefaultsInvalid()
            if (r5 == 0) goto L_0x00dd
            goto L_0x00e9
        L_0x00dd:
            r3.skipToGroupEnd()
            r5 = r32 & 4
            if (r5 == 0) goto L_0x00e6
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00e6:
            r17 = r14
            goto L_0x010a
        L_0x00e9:
            if (r7 == 0) goto L_0x00f0
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r9 = r5
        L_0x00f0:
            r5 = r32 & 4
            if (r5 == 0) goto L_0x00ff
            int r5 = r4 >> 15
            r5 = r5 & 14
            androidx.compose.material3.SliderColors r5 = r1.colors(r3, r5)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r10 = r5
        L_0x00ff:
            if (r11 == 0) goto L_0x0102
            r12 = r6
        L_0x0102:
            if (r13 == 0) goto L_0x00e6
            long r13 = androidx.compose.material3.SliderKt.ThumbSize
            r17 = r13
        L_0x010a:
            r3.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0119
            r5 = -1
            java.lang.String r7 = "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r5, r7)
        L_0x0119:
            r0 = -1068636116(0xffffffffc04de82c, float:-3.2172956)
            java.lang.String r5 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r5)
            java.lang.Object r0 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r0 != r7) goto L_0x0134
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r3.updateRememberedValue(r0)
        L_0x0134:
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r7 = -1068632656(0xffffffffc04df5b0, float:-3.2181206)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r7, r5)
            r4 = r4 & 14
            r5 = 0
            r7 = 4
            if (r4 != r7) goto L_0x0146
            goto L_0x0147
        L_0x0146:
            r6 = r5
        L_0x0147:
            java.lang.Object r7 = r3.rememberedValue()
            r11 = 0
            if (r6 != 0) goto L_0x0156
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x0161
        L_0x0156:
            androidx.compose.material3.SliderDefaults$Thumb$1$1 r6 = new androidx.compose.material3.SliderDefaults$Thumb$1$1
            r6.<init>(r2, r0, r11)
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r3.updateRememberedValue(r7)
        L_0x0161:
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r7, (androidx.compose.runtime.Composer) r3, (int) r4)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0187
            float r0 = androidx.compose.ui.unit.DpSize.m7209getWidthD9Ej5fM(r17)
            r4 = 2
            float r6 = (float) r4
            float r0 = r0 / r6
            float r19 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r0)
            r21 = 2
            r22 = 0
            r20 = 0
            long r6 = androidx.compose.ui.unit.DpSize.m7202copyDwJknco$default(r17, r19, r20, r21, r22)
            goto L_0x018a
        L_0x0187:
            r4 = 2
            r6 = r17
        L_0x018a:
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m846size6HolHcs(r9, r6)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.HoverableKt.hoverable$default(r0, r2, r5, r4, r11)
            long r6 = r10.m2473thumbColorvNxB06k$material3_release(r12)
            androidx.compose.material3.tokens.SliderTokens r4 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r4 = r4.getHandleShape()
            r11 = 6
            androidx.compose.ui.graphics.Shape r4 = androidx.compose.material3.ShapesKt.getValue(r4, r3, r11)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m247backgroundbw27NRU(r0, r6, r4)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r3, r5)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b1:
            r6 = r17
            goto L_0x00ca
        L_0x01b5:
            androidx.compose.runtime.ScopeUpdateScope r10 = r3.endRestartGroup()
            if (r10 == 0) goto L_0x01c8
            androidx.compose.material3.SliderDefaults$Thumb$2 r0 = new androidx.compose.material3.SliderDefaults$Thumb$2
            r3 = r9
            r9 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m2481Thumb9LiSoMs(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(message = "Use version that supports slider state")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Track(androidx.compose.material3.SliderPositions r18, androidx.compose.ui.Modifier r19, androidx.compose.material3.SliderColors r20, boolean r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r17 = this;
            r1 = r17
            r6 = r23
            r0 = -1546713545(0xffffffffa3cf0637, float:-2.2445617E-17)
            r2 = r22
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(Track)P(3,2)997@44755L8,1004@45160L1834,1004@45108L1886:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r24 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r6 | 6
            r10 = r18
            goto L_0x002d
        L_0x001b:
            r3 = r6 & 6
            r10 = r18
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x0029
            r3 = 4
            goto L_0x002a
        L_0x0029:
            r3 = 2
        L_0x002a:
            r3 = r3 | r6
            goto L_0x002d
        L_0x002c:
            r3 = r6
        L_0x002d:
            r5 = r24 & 2
            if (r5 == 0) goto L_0x0034
            r3 = r3 | 48
            goto L_0x0047
        L_0x0034:
            r7 = r6 & 48
            if (r7 != 0) goto L_0x0047
            r7 = r19
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0043
            r8 = 32
            goto L_0x0045
        L_0x0043:
            r8 = 16
        L_0x0045:
            r3 = r3 | r8
            goto L_0x0049
        L_0x0047:
            r7 = r19
        L_0x0049:
            r8 = r6 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0062
            r8 = r24 & 4
            if (r8 != 0) goto L_0x005c
            r8 = r20
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005e
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r8 = r20
        L_0x005e:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r3 = r3 | r9
            goto L_0x0064
        L_0x0062:
            r8 = r20
        L_0x0064:
            r9 = r24 & 8
            if (r9 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r11 = r6 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007e
            r11 = r21
            boolean r12 = r2.changed((boolean) r11)
            if (r12 == 0) goto L_0x007a
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r12
            goto L_0x0080
        L_0x007e:
            r11 = r21
        L_0x0080:
            r12 = r24 & 16
            if (r12 == 0) goto L_0x0087
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0087:
            r12 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0097
            boolean r12 = r2.changed((java.lang.Object) r1)
            if (r12 == 0) goto L_0x0094
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r3 = r3 | r12
        L_0x0097:
            r12 = r3 & 9363(0x2493, float:1.312E-41)
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x00ac
            boolean r12 = r2.getSkipping()
            if (r12 != 0) goto L_0x00a4
            goto L_0x00ac
        L_0x00a4:
            r2.skipToGroupEnd()
            r3 = r7
            r4 = r8
            r5 = r11
            goto L_0x017a
        L_0x00ac:
            r2.startDefaults()
            r12 = r6 & 1
            r13 = 1
            if (r12 == 0) goto L_0x00ca
            boolean r12 = r2.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00bb
            goto L_0x00ca
        L_0x00bb:
            r2.skipToGroupEnd()
            r5 = r24 & 4
            if (r5 == 0) goto L_0x00c4
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c4:
            r5 = r8
            r8 = r3
            r3 = r5
            r5 = r7
        L_0x00c8:
            r7 = r11
            goto L_0x00e7
        L_0x00ca:
            if (r5 == 0) goto L_0x00d1
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x00d2
        L_0x00d1:
            r5 = r7
        L_0x00d2:
            r7 = r24 & 4
            if (r7 == 0) goto L_0x00e1
            int r7 = r3 >> 12
            r7 = r7 & 14
            androidx.compose.material3.SliderColors r7 = r1.colors(r2, r7)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r8 = r7
        L_0x00e1:
            r7 = r8
            r8 = r3
            r3 = r7
            if (r9 == 0) goto L_0x00c8
            r7 = r13
        L_0x00e7:
            r2.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x00f6
            r9 = -1
            java.lang.String r11 = "androidx.compose.material3.SliderDefaults.Track (Slider.kt:999)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r9, r11)
        L_0x00f6:
            r0 = 0
            r11 = r8
            long r8 = r3.m2475trackColorWaAFU9c$material3_release(r7, r0)
            r14 = r11
            long r11 = r3.m2475trackColorWaAFU9c$material3_release(r7, r13)
            r19 = r5
            long r4 = r3.m2474tickColorWaAFU9c$material3_release(r7, r0)
            long r0 = r3.m2474tickColorWaAFU9c$material3_release(r7, r13)
            r15 = 0
            r21 = r3
            r3 = 0
            r6 = r19
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r6, r15, r13, r3)
            float r15 = androidx.compose.material3.SliderKt.getTrackHeight()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r3, r15)
            r15 = -801023075(0xffffffffd0415b9d, float:-1.29760266E10)
            java.lang.String r13 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r13)
            boolean r13 = r2.changed((long) r8)
            r14 = r14 & 14
            r15 = 4
            if (r14 != r15) goto L_0x0131
            r16 = 1
            goto L_0x0133
        L_0x0131:
            r16 = 0
        L_0x0133:
            r13 = r13 | r16
            boolean r14 = r2.changed((long) r11)
            r13 = r13 | r14
            boolean r14 = r2.changed((long) r4)
            r13 = r13 | r14
            boolean r14 = r2.changed((long) r0)
            r13 = r13 | r14
            java.lang.Object r14 = r2.rememberedValue()
            if (r13 != 0) goto L_0x0155
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x0153
            goto L_0x0155
        L_0x0153:
            r0 = r7
            goto L_0x0164
        L_0x0155:
            r13 = r7
            androidx.compose.material3.SliderDefaults$Track$1$1 r7 = new androidx.compose.material3.SliderDefaults$Track$1$1
            r15 = r0
            r0 = r13
            r13 = r4
            r7.<init>(r8, r10, r11, r13, r15)
            r14 = r7
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r2.updateRememberedValue(r14)
        L_0x0164:
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r1 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r3, r14, r2, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0176
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0176:
            r4 = r21
            r5 = r0
            r3 = r6
        L_0x017a:
            androidx.compose.runtime.ScopeUpdateScope r8 = r2.endRestartGroup()
            if (r8 == 0) goto L_0x0192
            androidx.compose.material3.SliderDefaults$Track$2 r0 = new androidx.compose.material3.SliderDefaults$Track$2
            r1 = r17
            r2 = r18
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x0192:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.SliderPositions, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacySliderSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "Track(sliderState, modifier, enabled, colors, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void Track(androidx.compose.material3.SliderState r15, androidx.compose.ui.Modifier r16, androidx.compose.material3.SliderColors r17, boolean r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r14 = this;
            r12 = r20
            r1 = 593554206(0x2360eb1e, float:1.2192852E-17)
            r2 = r19
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(Track)P(3,2)1079@48295L8,1082@48353L213:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r21 & 1
            if (r2 == 0) goto L_0x0018
            r2 = r12 | 6
            r3 = r2
            goto L_0x0028
        L_0x0018:
            r2 = r12 & 6
            if (r2 != 0) goto L_0x0027
            boolean r3 = r9.changedInstance(r15)
            if (r3 == 0) goto L_0x0024
            r3 = 4
            goto L_0x0025
        L_0x0024:
            r3 = 2
        L_0x0025:
            r3 = r3 | r12
            goto L_0x0028
        L_0x0027:
            r3 = r12
        L_0x0028:
            r4 = r21 & 2
            if (r4 == 0) goto L_0x002f
            r3 = r3 | 48
            goto L_0x0042
        L_0x002f:
            r5 = r12 & 48
            if (r5 != 0) goto L_0x0042
            r5 = r16
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003e
            r6 = 32
            goto L_0x0040
        L_0x003e:
            r6 = 16
        L_0x0040:
            r3 = r3 | r6
            goto L_0x0044
        L_0x0042:
            r5 = r16
        L_0x0044:
            r6 = r12 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005d
            r6 = r21 & 4
            if (r6 != 0) goto L_0x0057
            r6 = r17
            boolean r7 = r9.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0059
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0057:
            r6 = r17
        L_0x0059:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r3 = r3 | r7
            goto L_0x005f
        L_0x005d:
            r6 = r17
        L_0x005f:
            r7 = r21 & 8
            if (r7 == 0) goto L_0x0066
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r8 = r12 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r18
            boolean r10 = r9.changed((boolean) r8)
            if (r10 == 0) goto L_0x0075
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r10
            goto L_0x007b
        L_0x0079:
            r8 = r18
        L_0x007b:
            r10 = r21 & 16
            if (r10 == 0) goto L_0x0082
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0092
        L_0x0082:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0092
            boolean r10 = r9.changed((java.lang.Object) r14)
            if (r10 == 0) goto L_0x008f
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0091
        L_0x008f:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0091:
            r3 = r3 | r10
        L_0x0092:
            r10 = r3 & 9363(0x2493, float:1.312E-41)
            r11 = 9362(0x2492, float:1.3119E-41)
            if (r10 != r11) goto L_0x00a7
            boolean r10 = r9.getSkipping()
            if (r10 != 0) goto L_0x009f
            goto L_0x00a7
        L_0x009f:
            r9.skipToGroupEnd()
            r3 = r5
            r4 = r6
            r5 = r8
            goto L_0x0127
        L_0x00a7:
            r9.startDefaults()
            r10 = r12 & 1
            if (r10 == 0) goto L_0x00c3
            boolean r10 = r9.getDefaultsInvalid()
            if (r10 == 0) goto L_0x00b5
            goto L_0x00c3
        L_0x00b5:
            r9.skipToGroupEnd()
            r4 = r21 & 4
            if (r4 == 0) goto L_0x00be
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00be:
            r4 = r5
            r5 = r6
        L_0x00c0:
            r6 = r3
            r3 = r8
            goto L_0x00e1
        L_0x00c3:
            if (r4 == 0) goto L_0x00ca
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00cb
        L_0x00ca:
            r4 = r5
        L_0x00cb:
            r5 = r21 & 4
            if (r5 == 0) goto L_0x00da
            int r5 = r3 >> 12
            r5 = r5 & 14
            androidx.compose.material3.SliderColors r5 = r14.colors(r9, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00db
        L_0x00da:
            r5 = r6
        L_0x00db:
            if (r7 == 0) goto L_0x00c0
            r6 = 1
            r13 = r6
            r6 = r3
            r3 = r13
        L_0x00e1:
            r9.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00f0
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1081)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r6, r7, r8)
        L_0x00f0:
            float r7 = androidx.compose.material3.SliderKt.ThumbTrackGapSize
            float r8 = androidx.compose.material3.SliderKt.TrackInsideCornerSize
            r1 = r6 & 14
            r10 = 14155776(0xd80000, float:1.9836467E-38)
            r1 = r1 | r10
            r10 = r6 & 112(0x70, float:1.57E-43)
            r1 = r1 | r10
            int r10 = r6 >> 3
            r10 = r10 & 896(0x380, float:1.256E-42)
            r1 = r1 | r10
            int r10 = r6 << 3
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r10
            r10 = 234881024(0xe000000, float:1.5777218E-30)
            int r6 = r6 << 12
            r6 = r6 & r10
            r10 = r1 | r6
            r11 = 48
            r2 = r4
            r4 = r5
            r5 = 0
            r6 = 0
            r0 = r14
            r1 = r15
            r0.m2483Track4EFweAY((androidx.compose.material3.SliderState) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (androidx.compose.material3.SliderColors) r4, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit>) r5, (kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit>) r6, (float) r7, (float) r8, (androidx.compose.runtime.Composer) r9, (int) r10, (int) r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0125
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0125:
            r5 = r3
            r3 = r2
        L_0x0127:
            androidx.compose.runtime.ScopeUpdateScope r8 = r9.endRestartGroup()
            if (r8 == 0) goto L_0x013c
            androidx.compose.material3.SliderDefaults$Track$3 r0 = new androidx.compose.material3.SliderDefaults$Track$3
            r1 = r14
            r2 = r15
            r7 = r21
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x027a, code lost:
        if (r5.changed((java.lang.Object) r2) == false) goto L_0x027f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0120  */
    /* renamed from: Track-4EFweAY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2483Track4EFweAY(androidx.compose.material3.SliderState r25, androidx.compose.ui.Modifier r26, boolean r27, androidx.compose.material3.SliderColors r28, kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit> r30, float r31, float r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r0 = r34
            r3 = r35
            r4 = 49984771(0x2fab503, float:3.6838094E-37)
            r5 = r33
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r4)
            java.lang.String r6 = "C(Track)P(5,4,3!3,6:c#ui.unit.Dp,7:c#ui.unit.Dp)1114@49756L8,1115@49825L232,1137@50806L7,1138@50862L595,1133@50659L798:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r3 & 1
            if (r6 == 0) goto L_0x001d
            r6 = r0 | 6
            goto L_0x002d
        L_0x001d:
            r6 = r0 & 6
            if (r6 != 0) goto L_0x002c
            boolean r6 = r5.changedInstance(r2)
            if (r6 == 0) goto L_0x0029
            r6 = 4
            goto L_0x002a
        L_0x0029:
            r6 = 2
        L_0x002a:
            r6 = r6 | r0
            goto L_0x002d
        L_0x002c:
            r6 = r0
        L_0x002d:
            r7 = r3 & 2
            if (r7 == 0) goto L_0x0034
            r6 = r6 | 48
            goto L_0x0047
        L_0x0034:
            r8 = r0 & 48
            if (r8 != 0) goto L_0x0047
            r8 = r26
            boolean r9 = r5.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0043
            r9 = 32
            goto L_0x0045
        L_0x0043:
            r9 = 16
        L_0x0045:
            r6 = r6 | r9
            goto L_0x0049
        L_0x0047:
            r8 = r26
        L_0x0049:
            r9 = r3 & 4
            if (r9 == 0) goto L_0x0050
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r11 = r0 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0063
            r11 = r27
            boolean r12 = r5.changed((boolean) r11)
            if (r12 == 0) goto L_0x005f
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r6 = r6 | r12
            goto L_0x0065
        L_0x0063:
            r11 = r27
        L_0x0065:
            r12 = r0 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007e
            r12 = r3 & 8
            if (r12 != 0) goto L_0x0078
            r12 = r28
            boolean r14 = r5.changed((java.lang.Object) r12)
            if (r14 == 0) goto L_0x007a
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x0078:
            r12 = r28
        L_0x007a:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r6 = r6 | r14
            goto L_0x0080
        L_0x007e:
            r12 = r28
        L_0x0080:
            r14 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r14 != 0) goto L_0x009a
            r14 = r3 & 16
            if (r14 != 0) goto L_0x0093
            r14 = r29
            boolean r16 = r5.changedInstance(r14)
            if (r16 == 0) goto L_0x0095
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r14 = r29
        L_0x0095:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r6 = r6 | r16
            goto L_0x009c
        L_0x009a:
            r14 = r29
        L_0x009c:
            r16 = r3 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a7
            r6 = r6 | r17
            r15 = r30
            goto L_0x00ba
        L_0x00a7:
            r17 = r0 & r17
            r15 = r30
            if (r17 != 0) goto L_0x00ba
            boolean r18 = r5.changedInstance(r15)
            if (r18 == 0) goto L_0x00b6
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r6 = r6 | r18
        L_0x00ba:
            r18 = r3 & 64
            r20 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00c5
            r6 = r6 | r20
            r4 = r31
            goto L_0x00d8
        L_0x00c5:
            r20 = r0 & r20
            r4 = r31
            if (r20 != 0) goto L_0x00d8
            boolean r21 = r5.changed((float) r4)
            if (r21 == 0) goto L_0x00d4
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r6 = r6 | r21
        L_0x00d8:
            r10 = r3 & 128(0x80, float:1.794E-43)
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00e3
            r6 = r6 | r22
            r13 = r32
            goto L_0x00f6
        L_0x00e3:
            r22 = r0 & r22
            r13 = r32
            if (r22 != 0) goto L_0x00f6
            boolean r23 = r5.changed((float) r13)
            if (r23 == 0) goto L_0x00f2
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r6 = r6 | r23
        L_0x00f6:
            r0 = r3 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x00fe
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x00fc:
            r6 = r6 | r0
            goto L_0x0110
        L_0x00fe:
            r0 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r34 & r0
            if (r0 != 0) goto L_0x0110
            boolean r0 = r5.changed((java.lang.Object) r1)
            if (r0 == 0) goto L_0x010d
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00fc
        L_0x010d:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00fc
        L_0x0110:
            r0 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r0 & r6
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r3) goto L_0x012d
            boolean r0 = r5.getSkipping()
            if (r0 != 0) goto L_0x0120
            goto L_0x012d
        L_0x0120:
            r5.skipToGroupEnd()
            r1 = r5
            r3 = r8
            r5 = r12
            r8 = r4
            r4 = r11
        L_0x0128:
            r9 = r13
            r6 = r14
            r7 = r15
            goto L_0x02e6
        L_0x012d:
            r5.startDefaults()
            r0 = r34 & 1
            r3 = 1
            if (r0 == 0) goto L_0x0154
            boolean r0 = r5.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013c
            goto L_0x0154
        L_0x013c:
            r5.skipToGroupEnd()
            r0 = r35 & 8
            if (r0 == 0) goto L_0x0145
            r6 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0145:
            r0 = r35 & 16
            if (r0 == 0) goto L_0x014d
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = r6 & r0
        L_0x014d:
            r7 = r6
            r0 = r8
            r6 = r12
            r12 = r4
            r4 = r11
            goto L_0x01d3
        L_0x0154:
            if (r7 == 0) goto L_0x015b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r8 = r0
        L_0x015b:
            if (r9 == 0) goto L_0x015e
            r11 = r3
        L_0x015e:
            r0 = r35 & 8
            if (r0 == 0) goto L_0x016d
            int r0 = r6 >> 24
            r0 = r0 & 14
            androidx.compose.material3.SliderColors r0 = r1.colors(r5, r0)
            r6 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
            r12 = r0
        L_0x016d:
            r0 = r35 & 16
            if (r0 == 0) goto L_0x01bc
            r0 = -800875397(0xffffffffd0439c7b, float:-1.31272489E10)
            java.lang.String r7 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r7)
            r0 = r6 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 ^ 3072(0xc00, float:4.305E-42)
            r7 = 2048(0x800, float:2.87E-42)
            if (r0 <= r7) goto L_0x0187
            boolean r0 = r5.changed((java.lang.Object) r12)
            if (r0 != 0) goto L_0x018b
        L_0x0187:
            r0 = r6 & 3072(0xc00, float:4.305E-42)
            if (r0 != r7) goto L_0x018d
        L_0x018b:
            r0 = r3
            goto L_0x018e
        L_0x018d:
            r0 = 0
        L_0x018e:
            r7 = r6 & 896(0x380, float:1.256E-42)
            r9 = 256(0x100, float:3.59E-43)
            if (r7 != r9) goto L_0x0196
            r7 = r3
            goto L_0x0197
        L_0x0196:
            r7 = 0
        L_0x0197:
            r0 = r0 | r7
            java.lang.Object r7 = r5.rememberedValue()
            if (r0 != 0) goto L_0x01a6
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r7 != r0) goto L_0x01b1
        L_0x01a6:
            androidx.compose.material3.SliderDefaults$Track$4$1 r0 = new androidx.compose.material3.SliderDefaults$Track$4$1
            r0.<init>(r12, r11)
            r7 = r0
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r5.updateRememberedValue(r7)
        L_0x01b1:
            r0 = r7
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r7 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = r6 & r7
            r14 = r0
        L_0x01bc:
            if (r16 == 0) goto L_0x01c3
            androidx.compose.material3.SliderDefaults$Track$5 r0 = androidx.compose.material3.SliderDefaults$Track$5.INSTANCE
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r15 = r0
        L_0x01c3:
            if (r18 == 0) goto L_0x01ca
            float r0 = androidx.compose.material3.SliderKt.ThumbTrackGapSize
            r4 = r0
        L_0x01ca:
            if (r10 == 0) goto L_0x014d
            float r0 = androidx.compose.material3.SliderKt.TrackInsideCornerSize
            r13 = r0
            goto L_0x014d
        L_0x01d3:
            r5.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x01e5
            r8 = -1
            java.lang.String r9 = "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1128)"
            r10 = 49984771(0x2fab503, float:3.6838094E-37)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r7, r8, r9)
        L_0x01e5:
            r8 = 0
            long r9 = r6.m2475trackColorWaAFU9c$material3_release(r4, r8)
            r26 = r12
            long r11 = r6.m2475trackColorWaAFU9c$material3_release(r4, r3)
            r27 = r13
            r16 = r14
            long r13 = r6.m2474tickColorWaAFU9c$material3_release(r4, r8)
            r28 = r9
            long r8 = r6.m2474tickColorWaAFU9c$material3_release(r4, r3)
            r10 = 0
            r1 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r10, r3, r1)
            float r10 = androidx.compose.material3.SliderKt.getTrackHeight()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r1, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r19 = r0
            java.lang.String r0 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r0)
            java.lang.Object r0 = r5.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r3 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r0 != r3) goto L_0x022a
            r0 = 1127481344(0x43340000, float:180.0)
            goto L_0x022b
        L_0x022a:
            r0 = 0
        L_0x022b:
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.RotateKt.rotate(r1, r0)
            r1 = -800841850(0xffffffffd0441f86, float:-1.3161601E10)
            java.lang.String r3 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r1, r3)
            boolean r1 = r5.changedInstance(r2)
            r30 = r1
            r1 = r28
            boolean r3 = r5.changed((long) r1)
            r3 = r30 | r3
            boolean r10 = r5.changed((long) r11)
            r3 = r3 | r10
            boolean r10 = r5.changed((long) r13)
            r3 = r3 | r10
            boolean r10 = r5.changed((long) r8)
            r3 = r3 | r10
            r10 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r7
            r1 = 1048576(0x100000, float:1.469368E-39)
            if (r10 != r1) goto L_0x025d
            r1 = 1
            goto L_0x025e
        L_0x025d:
            r1 = 0
        L_0x025e:
            r1 = r1 | r3
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r7
            r3 = 8388608(0x800000, float:1.17549435E-38)
            if (r2 != r3) goto L_0x0268
            r2 = 1
            goto L_0x0269
        L_0x0268:
            r2 = 0
        L_0x0269:
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r7
            r2 = r2 ^ 24576(0x6000, float:3.4438E-41)
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r2 <= r3) goto L_0x027d
            r2 = r16
            boolean r10 = r5.changed((java.lang.Object) r2)
            if (r10 != 0) goto L_0x0283
            goto L_0x027f
        L_0x027d:
            r2 = r16
        L_0x027f:
            r10 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r10 != r3) goto L_0x0285
        L_0x0283:
            r3 = 1
            goto L_0x0286
        L_0x0285:
            r3 = 0
        L_0x0286:
            r1 = r1 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r7
            r7 = 131072(0x20000, float:1.83671E-40)
            if (r3 != r7) goto L_0x0290
            r3 = 1
            goto L_0x0291
        L_0x0290:
            r3 = 0
        L_0x0291:
            r1 = r1 | r3
            java.lang.Object r3 = r5.rememberedValue()
            if (r1 != 0) goto L_0x02ac
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x02a1
            goto L_0x02ac
        L_0x02a1:
            r12 = r26
            r13 = r27
            r14 = r2
            r16 = r4
            r1 = r5
            r17 = r6
            goto L_0x02cb
        L_0x02ac:
            r16 = r2
            androidx.compose.material3.SliderDefaults$Track$6$1 r2 = new androidx.compose.material3.SliderDefaults$Track$6$1
            r3 = r25
            r1 = r5
            r17 = r6
            r6 = r11
            r12 = r26
            r10 = r8
            r8 = r13
            r14 = r16
            r13 = r27
            r16 = r4
            r4 = r28
            r2.<init>(r3, r4, r6, r8, r10, r12, r13, r14, r15)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r1.updateRememberedValue(r3)
        L_0x02cb:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r8 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r0, r3, r1, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02dd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02dd:
            r8 = r12
            r4 = r16
            r5 = r17
            r3 = r19
            goto L_0x0128
        L_0x02e6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x02fe
            androidx.compose.material3.SliderDefaults$Track$7 r0 = new androidx.compose.material3.SliderDefaults$Track$7
            r1 = r24
            r2 = r25
            r10 = r34
            r11 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x02fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m2483Track4EFweAY(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "Track(rangeSliderState, modifier, colors, enabled, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void Track(androidx.compose.material3.RangeSliderState r15, androidx.compose.ui.Modifier r16, androidx.compose.material3.SliderColors r17, boolean r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r14 = this;
            r12 = r20
            r1 = -1617869097(0xffffffff9f9146d7, float:-6.1527083E-20)
            r2 = r19
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(Track)P(3,2)1187@52807L8,1190@52865L218:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r21 & 1
            if (r2 == 0) goto L_0x0018
            r2 = r12 | 6
            r3 = r2
            goto L_0x0028
        L_0x0018:
            r2 = r12 & 6
            if (r2 != 0) goto L_0x0027
            boolean r3 = r9.changedInstance(r15)
            if (r3 == 0) goto L_0x0024
            r3 = 4
            goto L_0x0025
        L_0x0024:
            r3 = 2
        L_0x0025:
            r3 = r3 | r12
            goto L_0x0028
        L_0x0027:
            r3 = r12
        L_0x0028:
            r4 = r21 & 2
            if (r4 == 0) goto L_0x002f
            r3 = r3 | 48
            goto L_0x0042
        L_0x002f:
            r5 = r12 & 48
            if (r5 != 0) goto L_0x0042
            r5 = r16
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003e
            r6 = 32
            goto L_0x0040
        L_0x003e:
            r6 = 16
        L_0x0040:
            r3 = r3 | r6
            goto L_0x0044
        L_0x0042:
            r5 = r16
        L_0x0044:
            r6 = r12 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005d
            r6 = r21 & 4
            if (r6 != 0) goto L_0x0057
            r6 = r17
            boolean r7 = r9.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0059
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0057:
            r6 = r17
        L_0x0059:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r3 = r3 | r7
            goto L_0x005f
        L_0x005d:
            r6 = r17
        L_0x005f:
            r7 = r21 & 8
            if (r7 == 0) goto L_0x0066
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r8 = r12 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r18
            boolean r10 = r9.changed((boolean) r8)
            if (r10 == 0) goto L_0x0075
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r10
            goto L_0x007b
        L_0x0079:
            r8 = r18
        L_0x007b:
            r10 = r21 & 16
            if (r10 == 0) goto L_0x0082
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0092
        L_0x0082:
            r10 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0092
            boolean r10 = r9.changed((java.lang.Object) r14)
            if (r10 == 0) goto L_0x008f
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0091
        L_0x008f:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0091:
            r3 = r3 | r10
        L_0x0092:
            r10 = r3 & 9363(0x2493, float:1.312E-41)
            r11 = 9362(0x2492, float:1.3119E-41)
            if (r10 != r11) goto L_0x00a7
            boolean r10 = r9.getSkipping()
            if (r10 != 0) goto L_0x009f
            goto L_0x00a7
        L_0x009f:
            r9.skipToGroupEnd()
            r3 = r5
            r4 = r6
            r5 = r8
            goto L_0x0127
        L_0x00a7:
            r9.startDefaults()
            r10 = r12 & 1
            if (r10 == 0) goto L_0x00c3
            boolean r10 = r9.getDefaultsInvalid()
            if (r10 == 0) goto L_0x00b5
            goto L_0x00c3
        L_0x00b5:
            r9.skipToGroupEnd()
            r4 = r21 & 4
            if (r4 == 0) goto L_0x00be
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00be:
            r4 = r5
            r5 = r6
        L_0x00c0:
            r6 = r3
            r3 = r8
            goto L_0x00e1
        L_0x00c3:
            if (r4 == 0) goto L_0x00ca
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00cb
        L_0x00ca:
            r4 = r5
        L_0x00cb:
            r5 = r21 & 4
            if (r5 == 0) goto L_0x00da
            int r5 = r3 >> 12
            r5 = r5 & 14
            androidx.compose.material3.SliderColors r5 = r14.colors(r9, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00db
        L_0x00da:
            r5 = r6
        L_0x00db:
            if (r7 == 0) goto L_0x00c0
            r6 = 1
            r13 = r6
            r6 = r3
            r3 = r13
        L_0x00e1:
            r9.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00f0
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1189)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r6, r7, r8)
        L_0x00f0:
            float r7 = androidx.compose.material3.SliderKt.ThumbTrackGapSize
            float r8 = androidx.compose.material3.SliderKt.TrackInsideCornerSize
            r1 = r6 & 14
            r10 = 14155776(0xd80000, float:1.9836467E-38)
            r1 = r1 | r10
            r10 = r6 & 112(0x70, float:1.57E-43)
            r1 = r1 | r10
            int r10 = r6 >> 3
            r10 = r10 & 896(0x380, float:1.256E-42)
            r1 = r1 | r10
            int r10 = r6 << 3
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r10
            r10 = 234881024(0xe000000, float:1.5777218E-30)
            int r6 = r6 << 12
            r6 = r6 & r10
            r10 = r1 | r6
            r11 = 48
            r2 = r4
            r4 = r5
            r5 = 0
            r6 = 0
            r0 = r14
            r1 = r15
            r0.m2482Track4EFweAY((androidx.compose.material3.RangeSliderState) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (androidx.compose.material3.SliderColors) r4, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit>) r5, (kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit>) r6, (float) r7, (float) r8, (androidx.compose.runtime.Composer) r9, (int) r10, (int) r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0125
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0125:
            r5 = r3
            r3 = r2
        L_0x0127:
            androidx.compose.runtime.ScopeUpdateScope r8 = r9.endRestartGroup()
            if (r8 == 0) goto L_0x013c
            androidx.compose.material3.SliderDefaults$Track$8 r0 = new androidx.compose.material3.SliderDefaults$Track$8
            r1 = r14
            r2 = r15
            r7 = r21
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x027a, code lost:
        if (r5.changed((java.lang.Object) r2) == false) goto L_0x027f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0120  */
    /* renamed from: Track-4EFweAY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2482Track4EFweAY(androidx.compose.material3.RangeSliderState r25, androidx.compose.ui.Modifier r26, boolean r27, androidx.compose.material3.SliderColors r28, kotlin.jvm.functions.Function2<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.drawscope.DrawScope, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.graphics.Color, kotlin.Unit> r30, float r31, float r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r0 = r34
            r3 = r35
            r4 = -541824132(0xffffffffdfb46b7c, float:-2.6001242E19)
            r5 = r33
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r4)
            java.lang.String r6 = "C(Track)P(5,4,3!3,6:c#ui.unit.Dp,7:c#ui.unit.Dp)1222@54320L8,1223@54389L232,1245@55370L7,1246@55426L706,1241@55223L909:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r3 & 1
            if (r6 == 0) goto L_0x001d
            r6 = r0 | 6
            goto L_0x002d
        L_0x001d:
            r6 = r0 & 6
            if (r6 != 0) goto L_0x002c
            boolean r6 = r5.changedInstance(r2)
            if (r6 == 0) goto L_0x0029
            r6 = 4
            goto L_0x002a
        L_0x0029:
            r6 = 2
        L_0x002a:
            r6 = r6 | r0
            goto L_0x002d
        L_0x002c:
            r6 = r0
        L_0x002d:
            r7 = r3 & 2
            if (r7 == 0) goto L_0x0034
            r6 = r6 | 48
            goto L_0x0047
        L_0x0034:
            r8 = r0 & 48
            if (r8 != 0) goto L_0x0047
            r8 = r26
            boolean r9 = r5.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0043
            r9 = 32
            goto L_0x0045
        L_0x0043:
            r9 = 16
        L_0x0045:
            r6 = r6 | r9
            goto L_0x0049
        L_0x0047:
            r8 = r26
        L_0x0049:
            r9 = r3 & 4
            if (r9 == 0) goto L_0x0050
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r11 = r0 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0063
            r11 = r27
            boolean r12 = r5.changed((boolean) r11)
            if (r12 == 0) goto L_0x005f
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r6 = r6 | r12
            goto L_0x0065
        L_0x0063:
            r11 = r27
        L_0x0065:
            r12 = r0 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007e
            r12 = r3 & 8
            if (r12 != 0) goto L_0x0078
            r12 = r28
            boolean r14 = r5.changed((java.lang.Object) r12)
            if (r14 == 0) goto L_0x007a
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x0078:
            r12 = r28
        L_0x007a:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r6 = r6 | r14
            goto L_0x0080
        L_0x007e:
            r12 = r28
        L_0x0080:
            r14 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r14 != 0) goto L_0x009a
            r14 = r3 & 16
            if (r14 != 0) goto L_0x0093
            r14 = r29
            boolean r16 = r5.changedInstance(r14)
            if (r16 == 0) goto L_0x0095
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r14 = r29
        L_0x0095:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r6 = r6 | r16
            goto L_0x009c
        L_0x009a:
            r14 = r29
        L_0x009c:
            r16 = r3 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a7
            r6 = r6 | r17
            r15 = r30
            goto L_0x00ba
        L_0x00a7:
            r17 = r0 & r17
            r15 = r30
            if (r17 != 0) goto L_0x00ba
            boolean r18 = r5.changedInstance(r15)
            if (r18 == 0) goto L_0x00b6
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r6 = r6 | r18
        L_0x00ba:
            r18 = r3 & 64
            r20 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00c5
            r6 = r6 | r20
            r4 = r31
            goto L_0x00d8
        L_0x00c5:
            r20 = r0 & r20
            r4 = r31
            if (r20 != 0) goto L_0x00d8
            boolean r21 = r5.changed((float) r4)
            if (r21 == 0) goto L_0x00d4
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r6 = r6 | r21
        L_0x00d8:
            r10 = r3 & 128(0x80, float:1.794E-43)
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00e3
            r6 = r6 | r22
            r13 = r32
            goto L_0x00f6
        L_0x00e3:
            r22 = r0 & r22
            r13 = r32
            if (r22 != 0) goto L_0x00f6
            boolean r23 = r5.changed((float) r13)
            if (r23 == 0) goto L_0x00f2
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r6 = r6 | r23
        L_0x00f6:
            r0 = r3 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x00fe
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x00fc:
            r6 = r6 | r0
            goto L_0x0110
        L_0x00fe:
            r0 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r34 & r0
            if (r0 != 0) goto L_0x0110
            boolean r0 = r5.changed((java.lang.Object) r1)
            if (r0 == 0) goto L_0x010d
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00fc
        L_0x010d:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00fc
        L_0x0110:
            r0 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r0 & r6
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r3) goto L_0x012d
            boolean r0 = r5.getSkipping()
            if (r0 != 0) goto L_0x0120
            goto L_0x012d
        L_0x0120:
            r5.skipToGroupEnd()
            r1 = r5
            r3 = r8
            r5 = r12
            r8 = r4
            r4 = r11
        L_0x0128:
            r9 = r13
            r6 = r14
            r7 = r15
            goto L_0x02e6
        L_0x012d:
            r5.startDefaults()
            r0 = r34 & 1
            r3 = 1
            if (r0 == 0) goto L_0x0154
            boolean r0 = r5.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013c
            goto L_0x0154
        L_0x013c:
            r5.skipToGroupEnd()
            r0 = r35 & 8
            if (r0 == 0) goto L_0x0145
            r6 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0145:
            r0 = r35 & 16
            if (r0 == 0) goto L_0x014d
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = r6 & r0
        L_0x014d:
            r7 = r6
            r0 = r8
            r6 = r12
            r12 = r4
            r4 = r11
            goto L_0x01d3
        L_0x0154:
            if (r7 == 0) goto L_0x015b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r8 = r0
        L_0x015b:
            if (r9 == 0) goto L_0x015e
            r11 = r3
        L_0x015e:
            r0 = r35 & 8
            if (r0 == 0) goto L_0x016d
            int r0 = r6 >> 24
            r0 = r0 & 14
            androidx.compose.material3.SliderColors r0 = r1.colors(r5, r0)
            r6 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
            r12 = r0
        L_0x016d:
            r0 = r35 & 16
            if (r0 == 0) goto L_0x01bc
            r0 = -800729349(0xffffffffd045d6fb, float:-1.3276802E10)
            java.lang.String r7 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r7)
            r0 = r6 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 ^ 3072(0xc00, float:4.305E-42)
            r7 = 2048(0x800, float:2.87E-42)
            if (r0 <= r7) goto L_0x0187
            boolean r0 = r5.changed((java.lang.Object) r12)
            if (r0 != 0) goto L_0x018b
        L_0x0187:
            r0 = r6 & 3072(0xc00, float:4.305E-42)
            if (r0 != r7) goto L_0x018d
        L_0x018b:
            r0 = r3
            goto L_0x018e
        L_0x018d:
            r0 = 0
        L_0x018e:
            r7 = r6 & 896(0x380, float:1.256E-42)
            r9 = 256(0x100, float:3.59E-43)
            if (r7 != r9) goto L_0x0196
            r7 = r3
            goto L_0x0197
        L_0x0196:
            r7 = 0
        L_0x0197:
            r0 = r0 | r7
            java.lang.Object r7 = r5.rememberedValue()
            if (r0 != 0) goto L_0x01a6
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r7 != r0) goto L_0x01b1
        L_0x01a6:
            androidx.compose.material3.SliderDefaults$Track$9$1 r0 = new androidx.compose.material3.SliderDefaults$Track$9$1
            r0.<init>(r12, r11)
            r7 = r0
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r5.updateRememberedValue(r7)
        L_0x01b1:
            r0 = r7
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r7 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = r6 & r7
            r14 = r0
        L_0x01bc:
            if (r16 == 0) goto L_0x01c3
            androidx.compose.material3.SliderDefaults$Track$10 r0 = androidx.compose.material3.SliderDefaults$Track$10.INSTANCE
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r15 = r0
        L_0x01c3:
            if (r18 == 0) goto L_0x01ca
            float r0 = androidx.compose.material3.SliderKt.ThumbTrackGapSize
            r4 = r0
        L_0x01ca:
            if (r10 == 0) goto L_0x014d
            float r0 = androidx.compose.material3.SliderKt.TrackInsideCornerSize
            r13 = r0
            goto L_0x014d
        L_0x01d3:
            r5.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x01e5
            r8 = -1
            java.lang.String r9 = "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1236)"
            r10 = -541824132(0xffffffffdfb46b7c, float:-2.6001242E19)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r7, r8, r9)
        L_0x01e5:
            r8 = 0
            long r9 = r6.m2475trackColorWaAFU9c$material3_release(r4, r8)
            r26 = r12
            long r11 = r6.m2475trackColorWaAFU9c$material3_release(r4, r3)
            r27 = r13
            r16 = r14
            long r13 = r6.m2474tickColorWaAFU9c$material3_release(r4, r8)
            r28 = r9
            long r8 = r6.m2474tickColorWaAFU9c$material3_release(r4, r3)
            r10 = 0
            r1 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r10, r3, r1)
            float r10 = androidx.compose.material3.SliderKt.getTrackHeight()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r1, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r19 = r0
            java.lang.String r0 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r0)
            java.lang.Object r0 = r5.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r3 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r0 != r3) goto L_0x022a
            r0 = 1127481344(0x43340000, float:180.0)
            goto L_0x022b
        L_0x022a:
            r0 = 0
        L_0x022b:
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.RotateKt.rotate(r1, r0)
            r1 = -800695691(0xffffffffd0465a75, float:-1.33112678E10)
            java.lang.String r3 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r1, r3)
            boolean r1 = r5.changedInstance(r2)
            r30 = r1
            r1 = r28
            boolean r3 = r5.changed((long) r1)
            r3 = r30 | r3
            boolean r10 = r5.changed((long) r11)
            r3 = r3 | r10
            boolean r10 = r5.changed((long) r13)
            r3 = r3 | r10
            boolean r10 = r5.changed((long) r8)
            r3 = r3 | r10
            r10 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r7
            r1 = 1048576(0x100000, float:1.469368E-39)
            if (r10 != r1) goto L_0x025d
            r1 = 1
            goto L_0x025e
        L_0x025d:
            r1 = 0
        L_0x025e:
            r1 = r1 | r3
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r7
            r3 = 8388608(0x800000, float:1.17549435E-38)
            if (r2 != r3) goto L_0x0268
            r2 = 1
            goto L_0x0269
        L_0x0268:
            r2 = 0
        L_0x0269:
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r7
            r2 = r2 ^ 24576(0x6000, float:3.4438E-41)
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r2 <= r3) goto L_0x027d
            r2 = r16
            boolean r10 = r5.changed((java.lang.Object) r2)
            if (r10 != 0) goto L_0x0283
            goto L_0x027f
        L_0x027d:
            r2 = r16
        L_0x027f:
            r10 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r10 != r3) goto L_0x0285
        L_0x0283:
            r3 = 1
            goto L_0x0286
        L_0x0285:
            r3 = 0
        L_0x0286:
            r1 = r1 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r7
            r7 = 131072(0x20000, float:1.83671E-40)
            if (r3 != r7) goto L_0x0290
            r3 = 1
            goto L_0x0291
        L_0x0290:
            r3 = 0
        L_0x0291:
            r1 = r1 | r3
            java.lang.Object r3 = r5.rememberedValue()
            if (r1 != 0) goto L_0x02ac
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x02a1
            goto L_0x02ac
        L_0x02a1:
            r12 = r26
            r13 = r27
            r14 = r2
            r16 = r4
            r1 = r5
            r17 = r6
            goto L_0x02cb
        L_0x02ac:
            r16 = r2
            androidx.compose.material3.SliderDefaults$Track$11$1 r2 = new androidx.compose.material3.SliderDefaults$Track$11$1
            r3 = r25
            r1 = r5
            r17 = r6
            r6 = r11
            r12 = r26
            r10 = r8
            r8 = r13
            r14 = r16
            r13 = r27
            r16 = r4
            r4 = r28
            r2.<init>(r3, r4, r6, r8, r10, r12, r13, r14, r15)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r1.updateRememberedValue(r3)
        L_0x02cb:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r8 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r0, r3, r1, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02dd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02dd:
            r8 = r12
            r4 = r16
            r5 = r17
            r3 = r19
            goto L_0x0128
        L_0x02e6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x02fe
            androidx.compose.material3.SliderDefaults$Track$12 r0 = new androidx.compose.material3.SliderDefaults$Track$12
            r1 = r24
            r2 = r25
            r10 = r34
            r11 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x02fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m2482Track4EFweAY(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawTrack-ngJ0SCU  reason: not valid java name */
    public final void m2479drawTrackngJ0SCU(DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4, float f3, float f4, float f5, float f6, float f7, Function2<? super DrawScope, ? super Offset, Unit> function2, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function3, boolean z) {
        float f8;
        float f9;
        float f10;
        int i;
        float f11;
        float f12;
        DrawScope drawScope2 = drawScope;
        float[] fArr2 = fArr;
        float f13 = f6;
        Function2<? super DrawScope, ? super Offset, Unit> function22 = function2;
        long Offset = OffsetKt.Offset(0.0f, Offset.m3988getYimpl(drawScope2.m4864getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m4056getWidthimpl(drawScope2.m4865getSizeNHjbRc()), Offset.m3988getYimpl(drawScope2.m4864getCenterF1C5BW0()));
        float r2 = drawScope2.m7091toPx0680j_4(f3);
        long Offset3 = OffsetKt.Offset(Offset.m3987getXimpl(Offset) + ((Offset.m3987getXimpl(Offset2) - Offset.m3987getXimpl(Offset)) * f2), Offset.m3988getYimpl(drawScope2.m4864getCenterF1C5BW0()));
        long Offset4 = OffsetKt.Offset(Offset.m3987getXimpl(Offset) + ((Offset.m3987getXimpl(Offset2) - Offset.m3987getXimpl(Offset)) * f), Offset.m3988getYimpl(drawScope2.m4864getCenterF1C5BW0()));
        float f14 = (float) 2;
        float f15 = r2 / f14;
        float r9 = drawScope2.m7091toPx0680j_4(f7);
        if (Dp.m7110compareTo0680j_4(f13, Dp.m7111constructorimpl((float) 0)) > 0) {
            f9 = (drawScope2.m7091toPx0680j_4(f4) / f14) + drawScope2.m7091toPx0680j_4(f13);
            f8 = (drawScope2.m7091toPx0680j_4(f5) / f14) + drawScope2.m7091toPx0680j_4(f13);
        } else {
            f9 = 0.0f;
            f8 = 0.0f;
        }
        if (!z || Offset.m3987getXimpl(Offset4) <= Offset.m3987getXimpl(Offset) + f9 + f15) {
            f10 = r2;
            i = 0;
        } else {
            float r23 = Offset.m3987getXimpl(Offset);
            f10 = r2;
            i = 0;
            m2480drawTrackPathCx2C_VA(drawScope2, Offset.Companion.m4003getZeroF1C5BW0(), SizeKt.Size((Offset.m3987getXimpl(Offset4) - f9) - r23, r2), j, f15, r9);
            if (function22 != null) {
                function22.invoke(drawScope2, Offset.m3976boximpl(OffsetKt.Offset(r23 + f15, Offset.m3988getYimpl(drawScope2.m4864getCenterF1C5BW0()))));
            }
        }
        if (Offset.m3987getXimpl(Offset3) < (Offset.m3987getXimpl(Offset2) - f8) - f15) {
            float r0 = Offset.m3987getXimpl(Offset3) + f8;
            float r232 = Offset.m3987getXimpl(Offset2);
            long Offset5 = OffsetKt.Offset(r0, 0.0f);
            float f16 = f10;
            long Size = SizeKt.Size(r232 - r0, f16);
            float f17 = r9;
            float f18 = f15;
            float f19 = f17;
            f11 = f16;
            m2480drawTrackPathCx2C_VA(drawScope2, Offset5, Size, j, f19, f18);
            f12 = f18;
            r9 = f19;
            if (function22 != null) {
                function22.invoke(drawScope2, Offset.m3976boximpl(OffsetKt.Offset(r232 - f12, Offset.m3988getYimpl(drawScope2.m4864getCenterF1C5BW0()))));
            }
        } else {
            f12 = f15;
            f11 = f10;
        }
        float r02 = z ? Offset.m3987getXimpl(Offset4) + f9 : 0.0f;
        float r22 = Offset.m3987getXimpl(Offset3) - f8;
        float f20 = z ? r9 : f12;
        float f21 = r22 - r02;
        if (f21 > f20) {
            m2480drawTrackPathCx2C_VA(drawScope2, OffsetKt.Offset(r02, 0.0f), SizeKt.Size(f21, f11), j2, f20, r9);
        }
        long Offset6 = OffsetKt.Offset(Offset.m3987getXimpl(Offset) + f12, Offset.m3988getYimpl(Offset));
        long Offset7 = OffsetKt.Offset(Offset.m3987getXimpl(Offset2) - f12, Offset.m3988getYimpl(Offset2));
        ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(Offset.m3987getXimpl(Offset4) - f9, Offset.m3987getXimpl(Offset4) + f9);
        ClosedFloatingPointRange<Float> rangeTo2 = RangesKt.rangeTo(Offset.m3987getXimpl(Offset3) - f8, Offset.m3987getXimpl(Offset3) + f8);
        int length = fArr2.length;
        int i2 = i;
        int i3 = i2;
        while (i2 < length) {
            float f22 = fArr2[i2];
            int i4 = i3 + 1;
            int i5 = 1;
            if (function22 == null || ((!z || i3 != 0) && i3 != fArr2.length - 1)) {
                if (f22 <= f2 && f22 >= f) {
                    i5 = i;
                }
                long Offset8 = OffsetKt.Offset(Offset.m3987getXimpl(OffsetKt.m4010lerpWko1d7g(Offset6, Offset7, f22)), Offset.m3988getYimpl(drawScope2.m4864getCenterF1C5BW0()));
                if ((!z || !rangeTo.contains(Float.valueOf(Offset.m3987getXimpl(Offset8)))) && !rangeTo2.contains(Float.valueOf(Offset.m3987getXimpl(Offset8)))) {
                    function3.invoke(drawScope2, Offset.m3976boximpl(Offset8), Color.m4229boximpl(i5 != 0 ? j3 : j4));
                    i2++;
                    i3 = i4;
                }
            }
            Function3<? super DrawScope, ? super Offset, ? super Color, Unit> function32 = function3;
            i2++;
            i3 = i4;
        }
    }

    /* renamed from: drawTrackPath-Cx2C_VA  reason: not valid java name */
    private final void m2480drawTrackPathCx2C_VA(DrawScope drawScope, long j, long j2, long j3, float f, float f2) {
        float f3 = f;
        long CornerRadius = CornerRadiusKt.CornerRadius(f3, f3);
        float f4 = f2;
        long CornerRadius2 = CornerRadiusKt.CornerRadius(f4, f4);
        RoundRect r12 = RoundRectKt.m4039RoundRectZAM2FJo(RectKt.m4027Recttz77jQw(OffsetKt.Offset(Offset.m3987getXimpl(j), 0.0f), SizeKt.Size(Size.m4056getWidthimpl(j2), Size.m4053getHeightimpl(j2))), CornerRadius, CornerRadius2, CornerRadius2, CornerRadius);
        Path path = trackPath;
        Path.addRoundRect$default(path, r12, (Path.Direction) null, 2, (Object) null);
        DrawScope.m4836drawPathLG529CI$default(drawScope, path, j3, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        path.rewind();
    }

    /* access modifiers changed from: private */
    /* renamed from: drawStopIndicator-x3O1jOs  reason: not valid java name */
    public final void m2478drawStopIndicatorx3O1jOs(DrawScope drawScope, long j, float f, long j2) {
        DrawScope.m4827drawCircleVaOC9Bg$default(drawScope, j2, drawScope.m7091toPx0680j_4(f) / 2.0f, j, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
    }

    /* renamed from: getTrackStopIndicatorSize-D9Ej5fM  reason: not valid java name */
    public final float m2486getTrackStopIndicatorSizeD9Ej5fM() {
        return TrackStopIndicatorSize;
    }

    /* renamed from: getTickSize-D9Ej5fM  reason: not valid java name */
    public final float m2485getTickSizeD9Ej5fM() {
        return TickSize;
    }
}
