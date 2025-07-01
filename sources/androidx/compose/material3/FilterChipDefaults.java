package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0016J\u0001\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%JN\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010-\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/J^\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00182\b\b\u0002\u00106\u001a\u00020\u00182\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0016J\u0001\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010%JN\u0010?\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010-\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010/R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u000f*\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006A"}, d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultElevatedFilterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultElevatedFilterChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColors", "getDefaultFilterChipColors$material3_release", "elevatedFilterChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "elevatedFilterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "elevatedFilterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedFilterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "filterChipColors", "filterChipColors-XqyqHi0", "filterChipElevation", "filterChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class FilterChipDefaults {
    public static final int $stable = 0;
    private static final float Height = FilterChipTokens.INSTANCE.m3295getContainerHeightD9Ej5fM();
    public static final FilterChipDefaults INSTANCE = new FilterChipDefaults();
    private static final float IconSize = FilterChipTokens.INSTANCE.m3311getIconSizeD9Ej5fM();

    private FilterChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m2087getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m2088getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final SelectableChipColors filterChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1743772077, "C(filterChipColors)1273@61089L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1743772077, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1273)");
        }
        SelectableChipColors defaultFilterChipColors$material3_release = getDefaultFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilterChipColors$material3_release;
    }

    /* renamed from: filterChipColors-XqyqHi0  reason: not valid java name */
    public final SelectableChipColors m2085filterChipColorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, -1831479801, "C(filterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1308@63087L11:Chip.kt#uh7d8r");
        long r7 = (i4 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i4 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r11 = (i4 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r15 = (i4 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r17 = (i4 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r19 = (i4 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        long r21 = (i4 & 64) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j7;
        long r23 = (i4 & 128) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j8;
        long r25 = (i4 & 256) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j9;
        long r27 = (i4 & 512) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j10;
        long r29 = (i4 & 1024) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j11;
        long r31 = (i4 & 2048) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1831479801, i, i2, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1308)");
        }
        SelectableChipColors r1 = getDefaultFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2445copydaRQuJA(r7, r9, r11, r11, r15, r17, r19, r21, r23, r25, r27, r29, r31);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final SelectableChipColors getDefaultFilterChipColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SelectableChipColors defaultFilterChipColorsCached$material3_release = colorScheme2.getDefaultFilterChipColorsCached$material3_release();
        if (defaultFilterChipColorsCached$material3_release != null) {
            return defaultFilterChipColorsCached$material3_release;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(Color.Companion.m4274getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), Color.Companion.m4274getTransparent0d7_KjU(), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getFlatSelectedContainerColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor()), FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultFilterChipColorsCached$material3_release(selectableChipColors);
        return selectableChipColors;
    }

    /* renamed from: filterChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m2086filterChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -757972185, "C(filterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilterChipTokens.INSTANCE.m3302getFlatContainerElevationD9Ej5fM();
        }
        float f7 = f;
        if ((i2 & 2) != 0) {
            f2 = FilterChipTokens.INSTANCE.m3306getFlatSelectedPressedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilterChipTokens.INSTANCE.m3303getFlatSelectedFocusContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilterChipTokens.INSTANCE.m3304getFlatSelectedHoverContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        float r8 = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m3296getDraggedContainerElevationD9Ej5fM() : f5;
        float f11 = (i2 & 32) != 0 ? f7 : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-757972185, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:1378)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f7, f8, f9, f10, r8, f11, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return selectableChipElevation;
    }

    /* renamed from: filterChipBorder-_7El2pE  reason: not valid java name */
    public final BorderStroke m2084filterChipBorder_7El2pE(boolean z, boolean z2, long j, long j2, long j3, long j4, float f, float f2, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        ComposerKt.sourceInformationMarkerStart(composer2, -1138342447, "C(filterChipBorder)P(4,5,0:c#ui.graphics.Color,6:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.unit.Dp,7:c#ui.unit.Dp)1406@68670L5,1409@68834L5:Chip.kt#uh7d8r");
        long value = (i3 & 4) != 0 ? ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), composer2, 6) : j;
        long r7 = (i3 & 8) != 0 ? Color.Companion.m4274getTransparent0d7_KjU() : j2;
        long r9 = (i3 & 16) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), composer2, 6), FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long r11 = (i3 & 32) != 0 ? Color.Companion.m4274getTransparent0d7_KjU() : j4;
        float r2 = (i3 & 64) != 0 ? FilterChipTokens.INSTANCE.m3309getFlatUnselectedOutlineWidthD9Ej5fM() : f;
        float r1 = (i3 & 128) != 0 ? FilterChipTokens.INSTANCE.m3305getFlatSelectedOutlineWidthD9Ej5fM() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1138342447, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:1415)");
        }
        if (!z) {
            value = z2 ? r11 : r9;
        } else if (z2) {
            value = r7;
        }
        if (z2) {
            r2 = r1;
        }
        BorderStroke r12 = BorderStrokeKt.m275BorderStrokecXLIe8U(r2, value);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r12;
    }

    public final SelectableChipColors elevatedFilterChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1082953289, "C(elevatedFilterChipColors)1430@69720L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1082953289, i, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1430)");
        }
        SelectableChipColors defaultElevatedFilterChipColors$material3_release = getDefaultElevatedFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedFilterChipColors$material3_release;
    }

    /* renamed from: elevatedFilterChipColors-XqyqHi0  reason: not valid java name */
    public final SelectableChipColors m2082elevatedFilterChipColorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, -915841711, "C(elevatedFilterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1465@71739L11:Chip.kt#uh7d8r");
        long r7 = (i4 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i4 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r11 = (i4 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r15 = (i4 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r17 = (i4 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r19 = (i4 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        long r21 = (i4 & 64) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j7;
        long r23 = (i4 & 128) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j8;
        long r25 = (i4 & 256) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j9;
        long r27 = (i4 & 512) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j10;
        long r29 = (i4 & 1024) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j11;
        long r31 = (i4 & 2048) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915841711, i, i2, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1465)");
        }
        SelectableChipColors r1 = getDefaultElevatedFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2445copydaRQuJA(r7, r9, r11, r11, r15, r17, r19, r21, r23, r25, r27, r29, r31);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SelectableChipColors defaultElevatedFilterChipColorsCached$material3_release = colorScheme2.getDefaultElevatedFilterChipColorsCached$material3_release();
        if (defaultElevatedFilterChipColorsCached$material3_release != null) {
            return defaultElevatedFilterChipColorsCached$material3_release;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultElevatedFilterChipColorsCached$material3_release(selectableChipColors);
        return selectableChipColors;
    }

    /* renamed from: elevatedFilterChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m2083elevatedFilterChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, 684803697, "C(elevatedFilterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilterChipTokens.INSTANCE.m3297getElevatedContainerElevationD9Ej5fM();
        }
        float f7 = f;
        if ((i2 & 2) != 0) {
            f2 = FilterChipTokens.INSTANCE.m3301getElevatedPressedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilterChipTokens.INSTANCE.m3299getElevatedFocusContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilterChipTokens.INSTANCE.m3300getElevatedHoverContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        float r8 = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m3296getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? FilterChipTokens.INSTANCE.m3298getElevatedDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(684803697, i, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:1536)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f7, f8, f9, f10, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return selectableChipElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1598643637, "C1547@76563L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598643637, i, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:1547)");
        }
        Shape value = ShapesKt.getValue(FilterChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }
}
