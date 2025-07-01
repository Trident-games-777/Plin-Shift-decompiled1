package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000eJ²\u0001\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u00020\t*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "()V", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "defaultSwitchColors", "Landroidx/compose/material3/SwitchColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = Dp.m7111constructorimpl((float) 16);

    private SwitchDefaults() {
    }

    public final SwitchColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 435552781, "C(colors)299@11393L11:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(435552781, i, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:299)");
        }
        SwitchColors defaultSwitchColors$material3_release = getDefaultSwitchColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSwitchColors$material3_release;
    }

    /* renamed from: colors-V1nXRL4  reason: not valid java name */
    public final SwitchColors m2568colorsV1nXRL4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, Composer composer, int i, int i2, int i3) {
        long j17;
        long j18;
        long j19;
        long j20;
        int i4;
        Composer composer2 = composer;
        int i5 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, 1937926421, "C(colors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,14:c#ui.graphics.Color,15:c#ui.graphics.Color,12:c#ui.graphics.Color,13:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color,8:c#ui.graphics.Color,9:c#ui.graphics.Color)324@13145L5,325@13219L5,327@13346L5,328@13425L5,329@13503L5,330@13594L5,331@13670L5,333@13773L5,335@13898L11,337@14015L5,339@14131L11,342@14309L5,344@14432L11,346@14554L5,348@14681L11,350@14802L5,352@14918L11,354@15047L5,356@15163L11,358@15282L5,360@15407L11:Switch.kt#uh7d8r");
        long value = (i5 & 1) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer2, 6) : j;
        long value2 = (i5 & 2) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer2, 6) : j2;
        long r12 = (i5 & 4) != 0 ? Color.Companion.m4274getTransparent0d7_KjU() : j3;
        long value3 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), composer2, 6) : j4;
        long value4 = (i5 & 16) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer2, 6) : j5;
        long value5 = (i5 & 32) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer2, 6) : j6;
        long value6 = (i5 & 64) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer2, 6) : j7;
        long value7 = (i5 & 128) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer2, 6) : j8;
        long r2 = (i5 & 256) != 0 ? ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), composer2, 6), SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1872getSurface0d7_KjU()) : j9;
        if ((i5 & 512) != 0) {
            j17 = value;
            j18 = ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), composer2, 6), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1872getSurface0d7_KjU());
        } else {
            j17 = value;
            j18 = j10;
        }
        long r28 = (i5 & 1024) != 0 ? Color.Companion.m4274getTransparent0d7_KjU() : j11;
        if ((i5 & 2048) != 0) {
            i4 = 6;
            j19 = r2;
            j20 = ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), composer2, 6), SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1872getSurface0d7_KjU());
        } else {
            j19 = r2;
            i4 = 6;
            j20 = j12;
        }
        long r32 = (i5 & 4096) != 0 ? ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), composer2, i4), SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, i4).m1872getSurface0d7_KjU()) : j13;
        long r34 = (i5 & 8192) != 0 ? ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), composer2, i4), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, i4).m1872getSurface0d7_KjU()) : j14;
        long r36 = (i5 & 16384) != 0 ? ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), composer2, i4), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, i4).m1872getSurface0d7_KjU()) : j15;
        long r38 = (i5 & 32768) != 0 ? ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), composer2, i4), SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, i4).m1872getSurface0d7_KjU()) : j16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, i, i2, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:362)");
        }
        SwitchColors switchColors = new SwitchColors(j17, value2, r12, value3, value4, value5, value6, value7, j19, j18, r28, j20, r32, r34, r36, r38, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return switchColors;
    }

    public final SwitchColors getDefaultSwitchColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SwitchColors defaultSwitchColorsCached$material3_release = colorScheme2.getDefaultSwitchColorsCached$material3_release();
        if (defaultSwitchColorsCached$material3_release != null) {
            return defaultSwitchColorsCached$material3_release;
        }
        long fromToken = ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getSelectedHandleColor());
        long fromToken2 = ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getSelectedTrackColor());
        long r7 = Color.Companion.m4274getTransparent0d7_KjU();
        long fromToken3 = ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getSelectedIconColor());
        long fromToken4 = ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getUnselectedHandleColor());
        long fromToken5 = ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getUnselectedTrackColor());
        long fromToken6 = ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor());
        long fromToken7 = ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getUnselectedIconColor());
        long j = fromToken;
        long r21 = ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledSelectedHandleColor()), SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme2.m1872getSurface0d7_KjU());
        long r1 = ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledSelectedTrackColor()), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme2.m1872getSurface0d7_KjU());
        long r23 = Color.Companion.m4274getTransparent0d7_KjU();
        long j2 = r1;
        long r12 = ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledSelectedIconColor()), SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme2.m1872getSurface0d7_KjU());
        long j3 = r12;
        long r13 = ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor()), SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme2.m1872getSurface0d7_KjU());
        long j4 = r13;
        long r14 = ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor()), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme2.m1872getSurface0d7_KjU());
        long j5 = r14;
        long r15 = ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor()), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme2.m1872getSurface0d7_KjU());
        SwitchColors switchColors = new SwitchColors(j, fromToken2, r7, fromToken3, fromToken4, fromToken5, fromToken6, fromToken7, r21, j2, r23, j3, j4, j5, r15, ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledUnselectedIconColor()), SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme2.m1872getSurface0d7_KjU()), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultSwitchColorsCached$material3_release(switchColors);
        return switchColors;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m2569getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
