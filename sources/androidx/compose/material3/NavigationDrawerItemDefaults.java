package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/NavigationDrawerItemDefaults;", "", "()V", "ItemPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedContainerColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContainerColor", "selectedIconColor", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedBadgeColor", "unselectedBadgeColor", "colors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationDrawerItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
public final class NavigationDrawerItemDefaults {
    public static final int $stable = 0;
    public static final NavigationDrawerItemDefaults INSTANCE = new NavigationDrawerItemDefaults();
    private static final PaddingValues ItemPadding = PaddingKt.m770PaddingValuesYgX7TsA$default(Dp.m7111constructorimpl((float) 12), 0.0f, 2, (Object) null);

    private NavigationDrawerItemDefaults() {
    }

    /* renamed from: colors-oq7We08  reason: not valid java name */
    public final NavigationDrawerItemColors m2256colorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        ComposerKt.sourceInformationMarkerStart(composer2, -1574983348, "C(colors)P(1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.graphics.Color)1014@42017L5,1016@42159L5,1017@42244L5,1018@42330L5,1019@42420L5:NavigationDrawer.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorColor(), composer2, 6) : j;
        long r18 = (i3 & 2) != 0 ? Color.Companion.m4274getTransparent0d7_KjU() : j2;
        long value2 = (i3 & 4) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIconColor(), composer2, 6) : j3;
        long value3 = (i3 & 8) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getInactiveIconColor(), composer2, 6) : j4;
        long value4 = (i3 & 16) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveLabelTextColor(), composer2, 6) : j5;
        long value5 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getInactiveLabelTextColor(), composer2, 6) : j6;
        long j9 = (i3 & 64) != 0 ? value4 : j7;
        long j10 = (i3 & 128) != 0 ? value5 : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1574983348, i, -1, "androidx.compose.material3.NavigationDrawerItemDefaults.colors (NavigationDrawer.kt:1023)");
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = new DefaultDrawerItemsColor(value2, value3, value4, value5, value, r18, j9, j10, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return defaultDrawerItemsColor;
    }

    public final PaddingValues getItemPadding() {
        return ItemPadding;
    }
}
