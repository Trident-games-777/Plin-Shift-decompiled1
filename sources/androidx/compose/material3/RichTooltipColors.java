package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/RichTooltipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "titleContentColor", "actionContentColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActionContentColor-0d7_KjU", "()J", "J", "getContainerColor-0d7_KjU", "getContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RichTooltipColors;", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
public final class RichTooltipColors {
    public static final int $stable = 0;
    private final long actionContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long titleContentColor;

    public /* synthetic */ RichTooltipColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private RichTooltipColors(long j, long j2, long j3, long j4) {
        this.containerColor = j;
        this.contentColor = j2;
        this.titleContentColor = j3;
        this.actionContentColor = j4;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2381getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getContentColor-0d7_KjU  reason: not valid java name */
    public final long m2382getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU  reason: not valid java name */
    public final long m2383getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    /* renamed from: getActionContentColor-0d7_KjU  reason: not valid java name */
    public final long m2380getActionContentColor0d7_KjU() {
        return this.actionContentColor;
    }

    /* renamed from: copy-jRlVdoo$default  reason: not valid java name */
    public static /* synthetic */ RichTooltipColors m2378copyjRlVdoo$default(RichTooltipColors richTooltipColors, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = richTooltipColors.containerColor;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = richTooltipColors.contentColor;
        }
        long j6 = j2;
        if ((i & 4) != 0) {
            j3 = richTooltipColors.titleContentColor;
        }
        return richTooltipColors.m2379copyjRlVdoo(j5, j6, j3, (i & 8) != 0 ? richTooltipColors.actionContentColor : j4);
    }

    /* renamed from: copy-jRlVdoo  reason: not valid java name */
    public final RichTooltipColors m2379copyjRlVdoo(long j, long j2, long j3, long j4) {
        long j5;
        long j6;
        long j7;
        long j8 = j != 16 ? j : this.containerColor;
        if (j2 != 16) {
            j5 = j2;
        } else {
            j5 = this.contentColor;
        }
        if (j3 != 16) {
            j6 = j3;
        } else {
            j6 = this.titleContentColor;
        }
        if (j4 != 16) {
            j7 = j4;
        } else {
            j7 = this.actionContentColor;
        }
        return new RichTooltipColors(j8, j5, j6, j7, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RichTooltipColors)) {
            return false;
        }
        RichTooltipColors richTooltipColors = (RichTooltipColors) obj;
        return Color.m4240equalsimpl0(this.containerColor, richTooltipColors.containerColor) && Color.m4240equalsimpl0(this.contentColor, richTooltipColors.contentColor) && Color.m4240equalsimpl0(this.titleContentColor, richTooltipColors.titleContentColor) && Color.m4240equalsimpl0(this.actionContentColor, richTooltipColors.actionContentColor);
    }

    public int hashCode() {
        return (((((Color.m4246hashCodeimpl(this.containerColor) * 31) + Color.m4246hashCodeimpl(this.contentColor)) * 31) + Color.m4246hashCodeimpl(this.titleContentColor)) * 31) + Color.m4246hashCodeimpl(this.actionContentColor);
    }
}
