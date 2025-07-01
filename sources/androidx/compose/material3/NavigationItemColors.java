package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J%\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J%\u0010!\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010 R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/material3/NavigationItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "(JJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledIconColor-0d7_KjU", "()J", "J", "getDisabledTextColor-0d7_KjU", "getSelectedIconColor-0d7_KjU", "getSelectedIndicatorColor-0d7_KjU", "getSelectedTextColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "copy", "copy-4JmcsL4", "(JJJJJJJ)Landroidx/compose/material3/NavigationItemColors;", "equals", "", "other", "hashCode", "", "iconColor", "selected", "enabled", "iconColor-WaAFU9c", "(ZZ)J", "textColor", "textColor-WaAFU9c", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationItem.kt */
public final class NavigationItemColors {
    public static final int $stable = 0;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7);
    }

    private NavigationItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.selectedIconColor = j;
        this.selectedTextColor = j2;
        this.selectedIndicatorColor = j3;
        this.unselectedIconColor = j4;
        this.unselectedTextColor = j5;
        this.disabledIconColor = j6;
        this.disabledTextColor = j7;
    }

    /* renamed from: getSelectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2274getSelectedIconColor0d7_KjU() {
        return this.selectedIconColor;
    }

    /* renamed from: getSelectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2276getSelectedTextColor0d7_KjU() {
        return this.selectedTextColor;
    }

    /* renamed from: getSelectedIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2275getSelectedIndicatorColor0d7_KjU() {
        return this.selectedIndicatorColor;
    }

    /* renamed from: getUnselectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2277getUnselectedIconColor0d7_KjU() {
        return this.unselectedIconColor;
    }

    /* renamed from: getUnselectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2278getUnselectedTextColor0d7_KjU() {
        return this.unselectedTextColor;
    }

    /* renamed from: getDisabledIconColor-0d7_KjU  reason: not valid java name */
    public final long m2272getDisabledIconColor0d7_KjU() {
        return this.disabledIconColor;
    }

    /* renamed from: getDisabledTextColor-0d7_KjU  reason: not valid java name */
    public final long m2273getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* renamed from: copy-4JmcsL4$default  reason: not valid java name */
    public static /* synthetic */ NavigationItemColors m2270copy4JmcsL4$default(NavigationItemColors navigationItemColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, int i, Object obj) {
        long j8;
        long j9 = (i & 1) != 0 ? navigationItemColors.selectedIconColor : j;
        long j10 = (i & 2) != 0 ? navigationItemColors.selectedTextColor : j2;
        long j11 = (i & 4) != 0 ? navigationItemColors.selectedIndicatorColor : j3;
        long j12 = (i & 8) != 0 ? navigationItemColors.unselectedIconColor : j4;
        long j13 = (i & 16) != 0 ? navigationItemColors.unselectedTextColor : j5;
        long j14 = (i & 32) != 0 ? navigationItemColors.disabledIconColor : j6;
        if ((i & 64) != 0) {
            j8 = navigationItemColors.disabledTextColor;
        } else {
            j8 = j7;
        }
        return navigationItemColors.m2271copy4JmcsL4(j9, j10, j11, j12, j13, j14, j8);
    }

    /* renamed from: copy-4JmcsL4  reason: not valid java name */
    public final NavigationItemColors m2271copy4JmcsL4(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14 = j != 16 ? j : this.selectedIconColor;
        if (j2 != 16) {
            j8 = j2;
        } else {
            j8 = this.selectedTextColor;
        }
        if (j3 != 16) {
            j9 = j3;
        } else {
            j9 = this.selectedIndicatorColor;
        }
        if (j4 != 16) {
            j10 = j4;
        } else {
            j10 = this.unselectedIconColor;
        }
        if (j5 != 16) {
            j11 = j5;
        } else {
            j11 = this.unselectedTextColor;
        }
        if (j6 != 16) {
            j12 = j6;
        } else {
            j12 = this.disabledIconColor;
        }
        if (j7 != 16) {
            j13 = j7;
        } else {
            j13 = this.disabledTextColor;
        }
        return new NavigationItemColors(j14, j8, j9, j10, j11, j12, j13, (DefaultConstructorMarker) null);
    }

    /* renamed from: iconColor-WaAFU9c  reason: not valid java name */
    public final long m2279iconColorWaAFU9c(boolean z, boolean z2) {
        if (!z2) {
            return this.disabledIconColor;
        }
        if (z) {
            return this.selectedIconColor;
        }
        return this.unselectedIconColor;
    }

    /* renamed from: textColor-WaAFU9c  reason: not valid java name */
    public final long m2280textColorWaAFU9c(boolean z, boolean z2) {
        if (!z2) {
            return this.disabledTextColor;
        }
        if (z) {
            return this.selectedTextColor;
        }
        return this.unselectedTextColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationItemColors)) {
            return false;
        }
        NavigationItemColors navigationItemColors = (NavigationItemColors) obj;
        return Color.m4240equalsimpl0(this.selectedIconColor, navigationItemColors.selectedIconColor) && Color.m4240equalsimpl0(this.unselectedIconColor, navigationItemColors.unselectedIconColor) && Color.m4240equalsimpl0(this.selectedTextColor, navigationItemColors.selectedTextColor) && Color.m4240equalsimpl0(this.unselectedTextColor, navigationItemColors.unselectedTextColor) && Color.m4240equalsimpl0(this.selectedIndicatorColor, navigationItemColors.selectedIndicatorColor) && Color.m4240equalsimpl0(this.disabledIconColor, navigationItemColors.disabledIconColor) && Color.m4240equalsimpl0(this.disabledTextColor, navigationItemColors.disabledTextColor);
    }

    public int hashCode() {
        return (((((((((((Color.m4246hashCodeimpl(this.selectedIconColor) * 31) + Color.m4246hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m4246hashCodeimpl(this.selectedTextColor)) * 31) + Color.m4246hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m4246hashCodeimpl(this.selectedIndicatorColor)) * 31) + Color.m4246hashCodeimpl(this.disabledIconColor)) * 31) + Color.m4246hashCodeimpl(this.disabledTextColor);
    }
}
