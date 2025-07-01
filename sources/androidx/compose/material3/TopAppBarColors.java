package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/TopAppBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActionIconContentColor-0d7_KjU", "()J", "J", "getContainerColor-0d7_KjU", "getNavigationIconContentColor-0d7_KjU", "getScrolledContainerColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "colorTransitionFraction", "", "containerColor-vNxB06k$material3_release", "(F)J", "copy", "copy-t635Npw", "(JJJJJ)Landroidx/compose/material3/TopAppBarColors;", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
public final class TopAppBarColors {
    public static final int $stable = 0;
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long titleContentColor;

    public /* synthetic */ TopAppBarColors(long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5);
    }

    private TopAppBarColors(long j, long j2, long j3, long j4, long j5) {
        this.containerColor = j;
        this.scrolledContainerColor = j2;
        this.navigationIconContentColor = j3;
        this.titleContentColor = j4;
        this.actionIconContentColor = j5;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2861getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getScrolledContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2863getScrolledContainerColor0d7_KjU() {
        return this.scrolledContainerColor;
    }

    /* renamed from: getNavigationIconContentColor-0d7_KjU  reason: not valid java name */
    public final long m2862getNavigationIconContentColor0d7_KjU() {
        return this.navigationIconContentColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU  reason: not valid java name */
    public final long m2864getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    /* renamed from: getActionIconContentColor-0d7_KjU  reason: not valid java name */
    public final long m2860getActionIconContentColor0d7_KjU() {
        return this.actionIconContentColor;
    }

    /* renamed from: copy-t635Npw$default  reason: not valid java name */
    public static /* synthetic */ TopAppBarColors m2857copyt635Npw$default(TopAppBarColors topAppBarColors, long j, long j2, long j3, long j4, long j5, int i, Object obj) {
        long j6;
        if ((i & 1) != 0) {
            j = topAppBarColors.containerColor;
        }
        long j7 = j;
        if ((i & 2) != 0) {
            j2 = topAppBarColors.scrolledContainerColor;
        }
        long j8 = j2;
        long j9 = (i & 4) != 0 ? topAppBarColors.navigationIconContentColor : j3;
        long j10 = (i & 8) != 0 ? topAppBarColors.titleContentColor : j4;
        if ((i & 16) != 0) {
            j6 = topAppBarColors.actionIconContentColor;
        } else {
            j6 = j5;
        }
        return topAppBarColors.m2859copyt635Npw(j7, j8, j9, j10, j6);
    }

    /* renamed from: copy-t635Npw  reason: not valid java name */
    public final TopAppBarColors m2859copyt635Npw(long j, long j2, long j3, long j4, long j5) {
        long j6;
        long j7;
        long j8;
        long j9;
        long j10 = j != 16 ? j : this.containerColor;
        if (j2 != 16) {
            j6 = j2;
        } else {
            j6 = this.scrolledContainerColor;
        }
        if (j3 != 16) {
            j7 = j3;
        } else {
            j7 = this.navigationIconContentColor;
        }
        if (j4 != 16) {
            j8 = j4;
        } else {
            j8 = this.titleContentColor;
        }
        if (j5 != 16) {
            j9 = j5;
        } else {
            j9 = this.actionIconContentColor;
        }
        return new TopAppBarColors(j10, j6, j7, j8, j9, (DefaultConstructorMarker) null);
    }

    /* renamed from: containerColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m2858containerColorvNxB06k$material3_release(float f) {
        return ColorKt.m4290lerpjxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(f));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) obj;
        return Color.m4240equalsimpl0(this.containerColor, topAppBarColors.containerColor) && Color.m4240equalsimpl0(this.scrolledContainerColor, topAppBarColors.scrolledContainerColor) && Color.m4240equalsimpl0(this.navigationIconContentColor, topAppBarColors.navigationIconContentColor) && Color.m4240equalsimpl0(this.titleContentColor, topAppBarColors.titleContentColor) && Color.m4240equalsimpl0(this.actionIconContentColor, topAppBarColors.actionIconContentColor);
    }

    public int hashCode() {
        return (((((((Color.m4246hashCodeimpl(this.containerColor) * 31) + Color.m4246hashCodeimpl(this.scrolledContainerColor)) * 31) + Color.m4246hashCodeimpl(this.navigationIconContentColor)) * 31) + Color.m4246hashCodeimpl(this.titleContentColor)) * 31) + Color.m4246hashCodeimpl(this.actionIconContentColor);
    }
}
