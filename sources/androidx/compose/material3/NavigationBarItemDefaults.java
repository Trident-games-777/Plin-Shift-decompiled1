package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJD\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011JX\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/NavigationBarItemDefaults;", "", "()V", "defaultNavigationBarItemColors", "Landroidx/compose/material3/NavigationBarItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationBarItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationBarItemColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationBarItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
public final class NavigationBarItemDefaults {
    public static final int $stable = 0;
    public static final NavigationBarItemDefaults INSTANCE = new NavigationBarItemDefaults();

    private NavigationBarItemDefaults() {
    }

    public final NavigationBarItemColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1018883954, "C(colors)311@13475L11:NavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018883954, i, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:311)");
        }
        NavigationBarItemColors defaultNavigationBarItemColors$material3_release = getDefaultNavigationBarItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultNavigationBarItemColors$material3_release;
    }

    /* renamed from: colors-69fazGs  reason: not valid java name */
    public final NavigationBarItemColors m2247colors69fazGs(long j, long j2, long j3, long j4, long j5, long j6, long j7, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -1618564327, "C(colors)P(3:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)336@14859L11:NavigationBar.kt#uh7d8r");
        long r6 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r8 = (i2 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r10 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r12 = (i2 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r14 = (i2 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r16 = (i2 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        long r18 = (i2 & 64) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1618564327, i, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:336)");
        }
        NavigationBarItemColors r1 = getDefaultNavigationBarItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2236copy4JmcsL4(r6, r8, r10, r12, r14, r16, r18);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final NavigationBarItemColors getDefaultNavigationBarItemColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        NavigationBarItemColors defaultNavigationBarItemColorsCached$material3_release = colorScheme2.getDefaultNavigationBarItemColorsCached$material3_release();
        if (defaultNavigationBarItemColorsCached$material3_release != null) {
            return defaultNavigationBarItemColorsCached$material3_release;
        }
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(ColorSchemeKt.fromToken(colorScheme2, NavigationBarTokens.INSTANCE.getActiveIconColor()), ColorSchemeKt.fromToken(colorScheme2, NavigationBarTokens.INSTANCE.getActiveLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, NavigationBarTokens.INSTANCE.getActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme2, NavigationBarTokens.INSTANCE.getInactiveIconColor()), ColorSchemeKt.fromToken(colorScheme2, NavigationBarTokens.INSTANCE.getInactiveLabelTextColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, NavigationBarTokens.INSTANCE.getInactiveIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, NavigationBarTokens.INSTANCE.getInactiveLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultNavigationBarItemColorsCached$material3_release(navigationBarItemColors);
        return navigationBarItemColors;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with disabledIconColor and disabledTextColor")
    /* renamed from: colors-zjMxDiM  reason: not valid java name */
    public final /* synthetic */ NavigationBarItemColors m2248colorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -213647161, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)372@16714L5,373@16797L5,374@16877L5,375@16959L5,376@17046L5:NavigationBar.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getActiveIconColor(), composer2, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getActiveLabelTextColor(), composer2, 6) : j2;
        long value3 = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorColor(), composer2, 6) : j3;
        long value4 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getInactiveIconColor(), composer2, 6) : j4;
        long value5 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getInactiveLabelTextColor(), composer2, 6) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-213647161, i, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:378)");
        }
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(value, value2, value3, value4, value5, Color.m4238copywmQWz5c$default(value4, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(value5, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return navigationBarItemColors;
    }
}
