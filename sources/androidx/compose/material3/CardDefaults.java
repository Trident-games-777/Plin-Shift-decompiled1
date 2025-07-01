package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0014\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0015J:\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJN\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0015J:\u0010(\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001cJN\u0010*\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010'J\u0017\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u00100J\r\u00101\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0015J:\u00101\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u001cJN\u00103\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010'R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\f*\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0012\u001a\u00020\f*\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Landroidx/compose/material3/CardDefaults;", "", "()V", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "defaultCardColors", "Landroidx/compose/material3/CardColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultCardColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CardColors;", "defaultElevatedCardColors", "getDefaultElevatedCardColors$material3_release", "defaultOutlinedCardColors", "getDefaultOutlinedCardColors$material3_release", "cardColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", "cardElevation", "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Card.kt */
public final class CardDefaults {
    public static final int $stable = 0;
    public static final CardDefaults INSTANCE = new CardDefaults();

    private CardDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1266660211, "C376@16530L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1266660211, i, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:376)");
        }
        Shape value = ShapesKt.getValue(FilledCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getElevatedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -133496185, "C380@16675L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-133496185, i, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:380)");
        }
        Shape value = ShapesKt.getValue(ElevatedCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1095404023, "C384@16820L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1095404023, i, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:384)");
        }
        Shape value = ShapesKt.getValue(OutlinedCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* renamed from: cardElevation-aqJV_2Y  reason: not valid java name */
    public final CardElevation m1782cardElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -574898487, "C(cardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilledCardTokens.INSTANCE.m3269getContainerElevationD9Ej5fM();
        }
        float f7 = f;
        if ((i2 & 2) != 0) {
            f2 = FilledCardTokens.INSTANCE.m3275getPressedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilledCardTokens.INSTANCE.m3272getFocusContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilledCardTokens.INSTANCE.m3273getHoverContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        float r8 = (i2 & 16) != 0 ? FilledCardTokens.INSTANCE.m3271getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? FilledCardTokens.INSTANCE.m3270getDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-574898487, i, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:405)");
        }
        CardElevation cardElevation = new CardElevation(f7, f8, f9, f10, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return cardElevation;
    }

    /* renamed from: elevatedCardElevation-aqJV_2Y  reason: not valid java name */
    public final CardElevation m1784elevatedCardElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, 1154241939, "C(elevatedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = ElevatedCardTokens.INSTANCE.m3188getContainerElevationD9Ej5fM();
        }
        float f7 = f;
        if ((i2 & 2) != 0) {
            f2 = ElevatedCardTokens.INSTANCE.m3194getPressedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 4) != 0) {
            f3 = ElevatedCardTokens.INSTANCE.m3191getFocusContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 8) != 0) {
            f4 = ElevatedCardTokens.INSTANCE.m3192getHoverContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        float r8 = (i2 & 16) != 0 ? ElevatedCardTokens.INSTANCE.m3190getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? ElevatedCardTokens.INSTANCE.m3189getDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1154241939, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:434)");
        }
        CardElevation cardElevation = new CardElevation(f7, f8, f9, f10, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return cardElevation;
    }

    /* renamed from: outlinedCardElevation-aqJV_2Y  reason: not valid java name */
    public final CardElevation m1786outlinedCardElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -97678773, "C(outlinedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = OutlinedCardTokens.INSTANCE.m3368getContainerElevationD9Ej5fM();
        }
        float f7 = f;
        float f8 = (i2 & 2) != 0 ? f7 : f2;
        float f9 = (i2 & 4) != 0 ? f7 : f3;
        float f10 = (i2 & 8) != 0 ? f7 : f4;
        float r8 = (i2 & 16) != 0 ? OutlinedCardTokens.INSTANCE.m3370getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? OutlinedCardTokens.INSTANCE.m3369getDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-97678773, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:463)");
        }
        CardElevation cardElevation = new CardElevation(f7, f8, f9, f10, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return cardElevation;
    }

    public final CardColors cardColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1876034303, "C(cardColors)476@21292L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1876034303, i, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:476)");
        }
        CardColors defaultCardColors$material3_release = getDefaultCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultCardColors$material3_release;
    }

    /* renamed from: cardColors-ro_MJ88  reason: not valid java name */
    public final CardColors m1781cardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -1589582123, "C(cardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)490@21903L31,494@22109L11:Card.kt#uh7d8r");
        long r7 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i2 & 2) != 0 ? ColorSchemeKt.m1886contentColorForek8zF_U(r7, composer2, i3 & 14) : j2;
        long r11 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i2 & 8) != 0 ? Color.m4238copywmQWz5c$default(r9, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589582123, i3, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:494)");
        }
        CardColors r1 = getDefaultCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1776copyjRlVdoo(r7, r9, r11, r13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final CardColors getDefaultCardColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        CardColors defaultCardColorsCached$material3_release = colorScheme2.getDefaultCardColorsCached$material3_release();
        if (defaultCardColorsCached$material3_release != null) {
            return defaultCardColorsCached$material3_release;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme2, FilledCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, FilledCardTokens.INSTANCE.getContainerColor())), ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledCardTokens.INSTANCE.getDisabledContainerColor()), FilledCardTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledCardTokens.INSTANCE.getContainerColor())), Color.m4238copywmQWz5c$default(ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, FilledCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultCardColorsCached$material3_release(cardColors);
        return cardColors;
    }

    public final CardColors elevatedCardColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1610137975, "C(elevatedCardColors)522@23477L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1610137975, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:522)");
        }
        CardColors defaultElevatedCardColors$material3_release = getDefaultElevatedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedCardColors$material3_release;
    }

    /* renamed from: elevatedCardColors-ro_MJ88  reason: not valid java name */
    public final CardColors m1783elevatedCardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, 139558303, "C(elevatedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)536@24145L31,540@24351L11:Card.kt#uh7d8r");
        long r7 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i2 & 2) != 0 ? ColorSchemeKt.m1886contentColorForek8zF_U(r7, composer2, i3 & 14) : j2;
        long r11 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i2 & 8) != 0 ? Color.m4238copywmQWz5c$default(r9, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(139558303, i3, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:540)");
        }
        CardColors r1 = getDefaultElevatedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1776copyjRlVdoo(r7, r9, r11, r13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final CardColors getDefaultElevatedCardColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        CardColors defaultElevatedCardColorsCached$material3_release = colorScheme2.getDefaultElevatedCardColorsCached$material3_release();
        if (defaultElevatedCardColorsCached$material3_release != null) {
            return defaultElevatedCardColorsCached$material3_release;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme2, ElevatedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, ElevatedCardTokens.INSTANCE.getContainerColor())), ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, ElevatedCardTokens.INSTANCE.getDisabledContainerColor()), ElevatedCardTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, ElevatedCardTokens.INSTANCE.getDisabledContainerColor())), Color.m4238copywmQWz5c$default(ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, ElevatedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultElevatedCardColorsCached$material3_release(cardColors);
        return cardColors;
    }

    public final CardColors outlinedCardColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1204388929, "C(outlinedCardColors)571@25869L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1204388929, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:571)");
        }
        CardColors defaultOutlinedCardColors$material3_release = getDefaultOutlinedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedCardColors$material3_release;
    }

    /* renamed from: outlinedCardColors-ro_MJ88  reason: not valid java name */
    public final CardColors m1785outlinedCardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -1112362409, "C(outlinedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)585@26537L31,587@26667L31,589@26762L11:Card.kt#uh7d8r");
        long r7 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i2 & 2) != 0 ? ColorSchemeKt.m1886contentColorForek8zF_U(r7, composer2, i3 & 14) : j2;
        long r11 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i2 & 8) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.m1886contentColorForek8zF_U(r7, composer2, i3 & 14), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1112362409, i3, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:589)");
        }
        CardColors r1 = getDefaultOutlinedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1776copyjRlVdoo(r7, r9, r11, r13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final CardColors getDefaultOutlinedCardColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        CardColors defaultOutlinedCardColorsCached$material3_release = colorScheme2.getDefaultOutlinedCardColorsCached$material3_release();
        if (defaultOutlinedCardColorsCached$material3_release != null) {
            return defaultOutlinedCardColorsCached$material3_release;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme2, OutlinedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, OutlinedCardTokens.INSTANCE.getContainerColor())), ColorSchemeKt.fromToken(colorScheme2, OutlinedCardTokens.INSTANCE.getContainerColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, OutlinedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultOutlinedCardColorsCached$material3_release(cardColors);
        return cardColors;
    }

    public final BorderStroke outlinedCardBorder(boolean z, Composer composer, int i, int i2) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, -392936593, "C(outlinedCardBorder)626@28402L72:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-392936593, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:617)");
        }
        if (z) {
            composer.startReplaceGroup(-134409770);
            ComposerKt.sourceInformation(composer, "620@28131L5");
            j = ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getOutlineColor(), composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-134330379);
            ComposerKt.sourceInformation(composer, "622@28214L5,624@28366L5");
            j = ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.getValue(ElevatedCardTokens.INSTANCE.getContainerColor(), composer, 6));
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart(composer, -974156849, "CC(remember):Card.kt#9igjgp");
        boolean changed = composer.changed(j);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = BorderStrokeKt.m275BorderStrokecXLIe8U(OutlinedCardTokens.INSTANCE.m3374getOutlineWidthD9Ej5fM(), j);
            composer.updateRememberedValue(rememberedValue);
        }
        BorderStroke borderStroke = (BorderStroke) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStroke;
    }
}
