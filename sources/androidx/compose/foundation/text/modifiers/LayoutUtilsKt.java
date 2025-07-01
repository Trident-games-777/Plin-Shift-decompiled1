package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", "", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutUtils.kt */
public final class LayoutUtilsKt {
    /* renamed from: finalConstraints-tfFHcEY  reason: not valid java name */
    public static final long m1519finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        return Constraints.Companion.m7061fitPrioritizingWidthZbe2FdA(0, m1521finalMaxWidthtfFHcEY(j, z, i, f), 0, Constraints.m7051getMaxHeightimpl(j));
    }

    /* renamed from: finalMaxWidth-tfFHcEY  reason: not valid java name */
    public static final int m1521finalMaxWidthtfFHcEY(long j, boolean z, int i, float f) {
        int i2;
        if ((z || TextOverflow.m7030equalsimpl0(i, TextOverflow.Companion.m7038getEllipsisgIe3tQ8())) && Constraints.m7048getHasBoundedWidthimpl(j)) {
            i2 = Constraints.m7052getMaxWidthimpl(j);
        } else {
            i2 = Integer.MAX_VALUE;
        }
        if (Constraints.m7054getMinWidthimpl(j) == i2) {
            return i2;
        }
        return RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f), Constraints.m7054getMinWidthimpl(j), i2);
    }

    /* renamed from: finalMaxLines-xdlQI24  reason: not valid java name */
    public static final int m1520finalMaxLinesxdlQI24(boolean z, int i, int i2) {
        if (z || !TextOverflow.m7030equalsimpl0(i, TextOverflow.Companion.m7038getEllipsisgIe3tQ8())) {
            return RangesKt.coerceAtLeast(i2, 1);
        }
        return 1;
    }
}
