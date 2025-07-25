package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u001b\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u001cJN\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0017\u0010\u000e\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/material3/MenuDefaults;", "", "()V", "DropdownMenuItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDropdownMenuItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ShadowElevation", "Landroidx/compose/ui/unit/Dp;", "getShadowElevation-D9Ej5fM", "()F", "F", "TonalElevation", "getTonalElevation-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultMenuItemColors", "Landroidx/compose/material3/MenuItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultMenuItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/MenuItemColors;", "itemColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemColors;", "textColor", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "itemColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class MenuDefaults {
    public static final int $stable = 0;
    private static final PaddingValues DropdownMenuItemContentPadding = PaddingKt.m769PaddingValuesYgX7TsA(MenuKt.DropdownMenuItemHorizontalPadding, Dp.m7111constructorimpl((float) 0));
    public static final MenuDefaults INSTANCE = new MenuDefaults();
    private static final float ShadowElevation = MenuTokens.INSTANCE.m3339getContainerElevationD9Ej5fM();
    private static final float TonalElevation = ElevationTokens.INSTANCE.m3195getLevel0D9Ej5fM();

    private MenuDefaults() {
    }

    /* renamed from: getTonalElevation-D9Ej5fM  reason: not valid java name */
    public final float m2203getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* renamed from: getShadowElevation-D9Ej5fM  reason: not valid java name */
    public final float m2202getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 218702739, "C194@9499L5:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(218702739, i, -1, "androidx.compose.material3.MenuDefaults.<get-shape> (Menu.kt:194)");
        }
        Shape value = ShapesKt.getValue(MenuTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1787427929, "C198@9634L5:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1787427929, i, -1, "androidx.compose.material3.MenuDefaults.<get-containerColor> (Menu.kt:198)");
        }
        long value = ColorSchemeKt.getValue(MenuTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final MenuItemColors itemColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1326531516, "C(itemColors)204@9833L11:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1326531516, i, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:204)");
        }
        MenuItemColors defaultMenuItemColors$material3_release = getDefaultMenuItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultMenuItemColors$material3_release;
    }

    /* renamed from: itemColors-5tl4gsc  reason: not valid java name */
    public final MenuItemColors m2204itemColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -1278543580, "C(itemColors)P(4:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)229@11073L11:Menu.kt#uh7d8r");
        long r6 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r8 = (i2 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r10 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r12 = (i2 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r14 = (i2 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r16 = (i2 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1278543580, i, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:229)");
        }
        MenuItemColors r1 = getDefaultMenuItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2206copytNS2XkQ(r6, r8, r10, r12, r14, r16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final MenuItemColors getDefaultMenuItemColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        MenuItemColors defaultMenuItemColorsCached$material3_release = colorScheme2.getDefaultMenuItemColorsCached$material3_release();
        if (defaultMenuItemColorsCached$material3_release != null) {
            return defaultMenuItemColorsCached$material3_release;
        }
        MenuItemColors menuItemColors = new MenuItemColors(ColorSchemeKt.fromToken(colorScheme2, ListTokens.INSTANCE.getListItemLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, ListTokens.INSTANCE.getListItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, ListTokens.INSTANCE.getListItemTrailingIconColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, ListTokens.INSTANCE.getListItemDisabledLabelTextColor()), ListTokens.INSTANCE.getListItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, ListTokens.INSTANCE.getListItemDisabledLeadingIconColor()), ListTokens.INSTANCE.getListItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, ListTokens.INSTANCE.getListItemDisabledTrailingIconColor()), ListTokens.INSTANCE.getListItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultMenuItemColorsCached$material3_release(menuItemColors);
        return menuItemColors;
    }

    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }
}
