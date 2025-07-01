package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0016\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u0010%\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u001eJ\r\u0010'\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010$J\r\u0010)\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u0010)\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010\u001eJ\r\u0010+\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010$J\u0015\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u00101J\r\u00102\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u00102\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001eJ\u001f\u00104\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00105\u001a\u000200H\u0007¢\u0006\u0002\u00106J\r\u00107\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u00107\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u0010$J\u001e\u00109\u001a\u00020\n*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001e\u0010=\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001e\u0010@\u001a\u00020\n*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\bA\u0010<J\u001e\u0010B\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\bC\u0010?R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\n*\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\u0014\u001a\u00020\u000f*\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "()V", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "defaultFilledIconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultFilledIconButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconButtonColors;", "defaultFilledIconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "getDefaultFilledIconToggleButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconToggleButtonColors;", "defaultFilledTonalIconButtonColors", "getDefaultFilledTonalIconButtonColors$material3_release", "defaultFilledTonalIconToggleButtonColors", "getDefaultFilledTonalIconToggleButtonColors$material3_release", "filledIconButtonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "filledIconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "filledIconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "iconButtonColors", "iconButtonColors-ro_MJ88", "iconToggleButtonColors", "iconToggleButtonColors-5tl4gsc", "outlinedIconButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "outlinedIconToggleButtonBorder", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "defaultIconButtonColors", "localContentColor", "defaultIconButtonColors-4WTKRHQ$material3_release", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconButtonColors;", "defaultIconToggleButtonColors", "defaultIconToggleButtonColors-4WTKRHQ$material3_release", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconToggleButtonColors;", "defaultOutlinedIconButtonColors", "defaultOutlinedIconButtonColors-4WTKRHQ$material3_release", "defaultOutlinedIconToggleButtonColors", "defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
public final class IconButtonDefaults {
    public static final int $stable = 0;
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    public final Shape getFilledShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1265841879, "C584@27553L5:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1265841879, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButton.kt:584)");
        }
        Shape value = ShapesKt.getValue(FilledIconButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1327125527, "C588@27711L5:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1327125527, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButton.kt:588)");
        }
        Shape value = ShapesKt.getValue(OutlinedIconButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final IconButtonColors iconButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(-1519621781);
        ComposerKt.sourceInformation(composer, "C(iconButtonColors)593@27925L7,594@27968L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1519621781, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:592)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer);
        long r0 = ((Color) consume).m4249unboximpl();
        IconButtonColors r13 = m2110defaultIconButtonColors4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), r0);
        if (Color.m4240equalsimpl0(r13.m2107getContentColor0d7_KjU(), r0)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return r13;
        }
        long j = r0;
        IconButtonColors r132 = IconButtonColors.m2102copyjRlVdoo$default(r13, 0, j, 0, Color.m4238copywmQWz5c$default(r0, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 5, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return r132;
    }

    /* renamed from: iconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m2118iconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        long j6;
        long j7;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, 999008085, "C(iconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)617@28950L7,622@29180L11,623@29247L7:IconButton.kt#uh7d8r");
        long r6 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            j5 = ((Color) consume).m4249unboximpl();
        } else {
            j5 = j2;
        }
        long r10 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = j5;
            j7 = Color.m4238copywmQWz5c$default(j8, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            j6 = j8;
        } else {
            j6 = j5;
            j7 = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(999008085, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:622)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer2, 6);
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer2.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        IconButtonColors r1 = m2110defaultIconButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) consume2).m4249unboximpl()).m2105copyjRlVdoo(r6, j6, r10, j7);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    /* renamed from: defaultIconButtonColors-4WTKRHQ$material3_release  reason: not valid java name */
    public final IconButtonColors m2110defaultIconButtonColors4WTKRHQ$material3_release(ColorScheme colorScheme, long j) {
        IconButtonColors defaultIconButtonColorsCached$material3_release = colorScheme.getDefaultIconButtonColorsCached$material3_release();
        if (defaultIconButtonColorsCached$material3_release != null) {
            return defaultIconButtonColorsCached$material3_release;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.Companion.m4274getTransparent0d7_KjU(), j, Color.Companion.m4274getTransparent0d7_KjU(), Color.m4238copywmQWz5c$default(j, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme.setDefaultIconButtonColorsCached$material3_release(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors iconToggleButtonColors(Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceGroup(-589987581);
        ComposerKt.sourceInformation(composer2, "C(iconToggleButtonColors)651@30397L7,652@30440L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-589987581, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:650)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        long r2 = ((Color) consume).m4249unboximpl();
        IconToggleButtonColors r1 = m2111defaultIconToggleButtonColors4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), r2);
        if (Color.m4240equalsimpl0(r1.m2132getContentColor0d7_KjU(), r2)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2.endReplaceGroup();
            return r1;
        }
        long j = r2;
        IconToggleButtonColors r12 = IconToggleButtonColors.m2127copytNS2XkQ$default(r1, 0, j, 0, Color.m4238copywmQWz5c$default(r2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0, 0, 53, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return r12;
    }

    /* renamed from: iconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m2119iconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long j7;
        long j8;
        long j9;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -2020719549, "C(iconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)678@31629L7,685@31979L11,686@32052L7:IconButton.kt#uh7d8r");
        long r6 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            j7 = ((Color) consume).m4249unboximpl();
        } else {
            j7 = j2;
        }
        long r10 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j10 = j7;
            j9 = Color.m4238copywmQWz5c$default(j10, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            j8 = j10;
        } else {
            j8 = j7;
            j9 = j4;
        }
        long r14 = (i2 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r16 = (i2 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020719549, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:685)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer2, 6);
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer2.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        IconToggleButtonColors r1 = m2111defaultIconToggleButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) consume2).m4249unboximpl()).m2128copytNS2XkQ(r6, j8, r10, j9, r14, r16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    /* renamed from: defaultIconToggleButtonColors-4WTKRHQ$material3_release  reason: not valid java name */
    public final IconToggleButtonColors m2111defaultIconToggleButtonColors4WTKRHQ$material3_release(ColorScheme colorScheme, long j) {
        ColorScheme colorScheme2 = colorScheme;
        IconToggleButtonColors defaultIconToggleButtonColorsCached$material3_release = colorScheme2.getDefaultIconToggleButtonColorsCached$material3_release();
        if (defaultIconToggleButtonColorsCached$material3_release != null) {
            return defaultIconToggleButtonColorsCached$material3_release;
        }
        long r3 = Color.Companion.m4274getTransparent0d7_KjU();
        long r7 = Color.Companion.m4274getTransparent0d7_KjU();
        long r9 = Color.m4238copywmQWz5c$default(j, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(r3, j, r7, r9, Color.Companion.m4274getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, IconButtonTokens.INSTANCE.getSelectedIconColor()), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultIconToggleButtonColorsCached$material3_release(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors filledIconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1857395287, "C(filledIconButtonColors)719@33486L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1857395287, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:719)");
        }
        IconButtonColors defaultFilledIconButtonColors$material3_release = getDefaultFilledIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledIconButtonColors$material3_release;
    }

    /* renamed from: filledIconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m2114filledIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -669858473, "C(filledIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)732@34130L31,736@34326L11:IconButton.kt#uh7d8r");
        long r7 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i2 & 2) != 0 ? ColorSchemeKt.m1886contentColorForek8zF_U(r7, composer2, i3 & 14) : j2;
        long r11 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i2 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-669858473, i3, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:736)");
        }
        IconButtonColors r1 = getDefaultFilledIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2105copyjRlVdoo(r7, r9, r11, r13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final IconButtonColors getDefaultFilledIconButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        IconButtonColors defaultFilledIconButtonColorsCached$material3_release = colorScheme2.getDefaultFilledIconButtonColorsCached$material3_release();
        if (defaultFilledIconButtonColorsCached$material3_release != null) {
            return defaultFilledIconButtonColorsCached$material3_release;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getContainerColor())), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultFilledIconButtonColorsCached$material3_release(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors filledIconToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1554706367, "C(filledIconToggleButtonColors)766@35781L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1554706367, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:766)");
        }
        IconToggleButtonColors defaultFilledIconToggleButtonColors$material3_release = getDefaultFilledIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledIconToggleButtonColors$material3_release;
    }

    /* renamed from: filledIconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m2115filledIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, 1887173701, "C(filledIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)788@36995L38,790@37088L11:IconButton.kt#uh7d8r");
        long r7 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i2 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r11 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i2 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r4 = (i2 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r17 = (i2 & 32) != 0 ? ColorSchemeKt.m1886contentColorForek8zF_U(r4, composer2, (i3 >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1887173701, i3, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:790)");
        }
        IconToggleButtonColors r1 = getDefaultFilledIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2128copytNS2XkQ(r7, r9, r11, r13, r4, r17);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        IconToggleButtonColors defaultFilledIconToggleButtonColorsCached$material3_release = colorScheme2.getDefaultFilledIconToggleButtonColorsCached$material3_release();
        if (defaultFilledIconToggleButtonColorsCached$material3_release != null) {
            return defaultFilledIconToggleButtonColorsCached$material3_release;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getToggleUnselectedColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor())), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultFilledIconToggleButtonColorsCached$material3_release(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors filledTonalIconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1099140437, "C(filledTonalIconButtonColors)830@39188L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1099140437, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:830)");
        }
        IconButtonColors defaultFilledTonalIconButtonColors$material3_release = getDefaultFilledTonalIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalIconButtonColors$material3_release;
    }

    /* renamed from: filledTonalIconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m2116filledTonalIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -18532843, "C(filledTonalIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)844@39854L31,848@40050L11:IconButton.kt#uh7d8r");
        long r7 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i2 & 2) != 0 ? ColorSchemeKt.m1886contentColorForek8zF_U(r7, composer2, i3 & 14) : j2;
        long r11 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i2 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-18532843, i3, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:848)");
        }
        IconButtonColors r1 = getDefaultFilledTonalIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2105copyjRlVdoo(r7, r9, r11, r13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        IconButtonColors defaultFilledTonalIconButtonColorsCached$material3_release = colorScheme2.getDefaultFilledTonalIconButtonColorsCached$material3_release();
        if (defaultFilledTonalIconButtonColorsCached$material3_release != null) {
            return defaultFilledTonalIconButtonColorsCached$material3_release;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getContainerColor())), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultFilledTonalIconButtonColorsCached$material3_release(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors filledTonalIconToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 434219587, "C(filledTonalIconToggleButtonColors)878@41565L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(434219587, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:878)");
        }
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColors$material3_release = getDefaultFilledTonalIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalIconToggleButtonColors$material3_release;
    }

    /* renamed from: filledTonalIconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m2117filledTonalIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -19426557, "C(filledTonalIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)894@42431L31,900@42747L11:IconButton.kt#uh7d8r");
        long r7 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r9 = (i2 & 2) != 0 ? ColorSchemeKt.m1886contentColorForek8zF_U(r7, composer2, i3 & 14) : j2;
        long r11 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r13 = (i2 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r15 = (i2 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r17 = (i2 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-19426557, i3, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:900)");
        }
        IconToggleButtonColors r1 = getDefaultFilledTonalIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2128copytNS2XkQ(r7, r9, r11, r13, r15, r17);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached$material3_release = colorScheme2.getDefaultFilledTonalIconToggleButtonColorsCached$material3_release();
        if (defaultFilledTonalIconToggleButtonColorsCached$material3_release != null) {
            return defaultFilledTonalIconToggleButtonColorsCached$material3_release;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor())), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTonalIconButtonTokens.INSTANCE.getToggleSelectedColor()), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultFilledTonalIconToggleButtonColorsCached$material3_release(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors outlinedIconButtonColors(Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceGroup(389287465);
        ComposerKt.sourceInformation(composer2, "C(outlinedIconButtonColors)940@44790L11,940@44852L7,941@44906L7:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(389287465, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:938)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer2, 6);
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        IconButtonColors r7 = m2112defaultOutlinedIconButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) consume).m4249unboximpl());
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer2.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        long r8 = ((Color) consume2).m4249unboximpl();
        if (Color.m4240equalsimpl0(r7.m2107getContentColor0d7_KjU(), r8)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2.endReplaceGroup();
            return r7;
        }
        IconButtonColors r1 = IconButtonColors.m2102copyjRlVdoo$default(r7, 0, r8, 0, Color.m4238copywmQWz5c$default(r8, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 5, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return r1;
    }

    /* renamed from: outlinedIconButtonColors-ro_MJ88  reason: not valid java name */
    public final IconButtonColors m2120outlinedIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        long j6;
        long j7;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -1030517545, "C(outlinedIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)965@45873L7,970@46107L11,971@46182L7:IconButton.kt#uh7d8r");
        long r6 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            j5 = ((Color) consume).m4249unboximpl();
        } else {
            j5 = j2;
        }
        long r10 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = j5;
            j7 = Color.m4238copywmQWz5c$default(j8, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            j6 = j8;
        } else {
            j6 = j5;
            j7 = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1030517545, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:970)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer2, 6);
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer2.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        IconButtonColors r1 = m2112defaultOutlinedIconButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) consume2).m4249unboximpl()).m2105copyjRlVdoo(r6, j6, r10, j7);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    /* renamed from: defaultOutlinedIconButtonColors-4WTKRHQ$material3_release  reason: not valid java name */
    public final IconButtonColors m2112defaultOutlinedIconButtonColors4WTKRHQ$material3_release(ColorScheme colorScheme, long j) {
        IconButtonColors defaultOutlinedIconButtonColorsCached$material3_release = colorScheme.getDefaultOutlinedIconButtonColorsCached$material3_release();
        if (defaultOutlinedIconButtonColorsCached$material3_release != null) {
            return defaultOutlinedIconButtonColorsCached$material3_release;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.Companion.m4274getTransparent0d7_KjU(), j, Color.Companion.m4274getTransparent0d7_KjU(), Color.m4238copywmQWz5c$default(j, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme.setDefaultOutlinedIconButtonColorsCached$material3_release(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonColors(Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceGroup(-779749183);
        ComposerKt.sourceInformation(composer2, "C(outlinedIconToggleButtonColors)1001@47390L7,1002@47433L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-779749183, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:1000)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        long r2 = ((Color) consume).m4249unboximpl();
        IconToggleButtonColors r1 = m2113defaultOutlinedIconToggleButtonColors4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), r2);
        if (Color.m4240equalsimpl0(r1.m2132getContentColor0d7_KjU(), r2)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2.endReplaceGroup();
            return r1;
        }
        long j = r2;
        IconToggleButtonColors r12 = IconToggleButtonColors.m2127copytNS2XkQ$default(r1, 0, j, 0, Color.m4238copywmQWz5c$default(r2, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0, 0, 53, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return r12;
    }

    /* renamed from: outlinedIconToggleButtonColors-5tl4gsc  reason: not valid java name */
    public final IconToggleButtonColors m2121outlinedIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long j7;
        long j8;
        long j9;
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, 2130592709, "C(outlinedIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)1028@48650L7,1033@48932L38,1035@49025L11,1036@49106L7:IconButton.kt#uh7d8r");
        long r7 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            j7 = ((Color) consume).m4249unboximpl();
        } else {
            j7 = j2;
        }
        long r11 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j10 = j7;
            j9 = Color.m4238copywmQWz5c$default(j10, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            j8 = j10;
        } else {
            j8 = j7;
            j9 = j4;
        }
        long r5 = (i2 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r17 = (i2 & 32) != 0 ? ColorSchemeKt.m1886contentColorForek8zF_U(r5, composer2, (i3 >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130592709, i3, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:1035)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer2, 6);
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer2.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        IconToggleButtonColors r1 = m2113defaultOutlinedIconToggleButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) consume2).m4249unboximpl()).m2128copytNS2XkQ(r7, j8, r11, j9, r5, r17);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    /* renamed from: defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release  reason: not valid java name */
    public final IconToggleButtonColors m2113defaultOutlinedIconToggleButtonColors4WTKRHQ$material3_release(ColorScheme colorScheme, long j) {
        ColorScheme colorScheme2 = colorScheme;
        IconToggleButtonColors defaultIconToggleButtonColorsCached$material3_release = colorScheme2.getDefaultIconToggleButtonColorsCached$material3_release();
        if (defaultIconToggleButtonColorsCached$material3_release != null) {
            return defaultIconToggleButtonColorsCached$material3_release;
        }
        long r3 = Color.Companion.m4274getTransparent0d7_KjU();
        long r7 = Color.Companion.m4274getTransparent0d7_KjU();
        long r5 = Color.m4238copywmQWz5c$default(j, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        long j2 = r5;
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(r3, j, r7, j2, ColorSchemeKt.fromToken(colorScheme2, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.m1885contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor())), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultOutlinedIconToggleButtonColorsCached$material3_release(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(1244729690);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonBorder)P(1)1082@51041L33:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1244729690, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButton.kt:1078)");
        }
        if (z2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        BorderStroke outlinedIconButtonBorder = outlinedIconButtonBorder(z, composer, (i & 14) | ((i >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return outlinedIconButtonBorder;
    }

    public final BorderStroke outlinedIconButtonBorder(boolean z, Composer composer, int i) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, -511461558, "C(outlinedIconButtonBorder)1100@51643L108:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511461558, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButton.kt:1091)");
        }
        if (z) {
            composer.startReplaceGroup(1186104514);
            ComposerKt.sourceInformation(composer, "1094@51433L7");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            j = ((Color) consume).m4249unboximpl();
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1186170420);
            ComposerKt.sourceInformation(composer, "1096@51496L7");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            j = Color.m4238copywmQWz5c$default(((Color) consume2).m4249unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart(composer, 176816691, "CC(remember):IconButton.kt#9igjgp");
        boolean changed = composer.changed(j);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = BorderStrokeKt.m275BorderStrokecXLIe8U(OutlinedIconButtonTokens.INSTANCE.m3378getUnselectedOutlineWidthD9Ej5fM(), j);
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
