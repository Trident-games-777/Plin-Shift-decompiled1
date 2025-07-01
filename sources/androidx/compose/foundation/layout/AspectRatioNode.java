package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010&\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)J \u0010,\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010)J \u0010.\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AspectRatio.kt */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m656measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long r0 = m647findSizeToXhtMw(j);
        if (!IntSize.m7281equalsimpl0(r0, IntSize.Companion.m7288getZeroYbymL2g())) {
            j = Constraints.Companion.m7062fixedJhjzzOo(IntSize.m7283getWidthimpl(r0), IntSize.m7282getHeightimpl(r0));
        }
        Placeable r9 = measurable.m5848measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new AspectRatioNode$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return Math.round(((float) i) * this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return Math.round(((float) i) * this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return Math.round(((float) i) / this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return Math.round(((float) i) / this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: findSize-ToXhtMw  reason: not valid java name */
    private final long m647findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long j2 = j;
            long r9 = m651tryMaxWidthJN0ABg$default(this, j2, false, 1, (Object) null);
            if (!IntSize.m7281equalsimpl0(r9, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r9;
            }
            long r92 = m649tryMaxHeightJN0ABg$default(this, j2, false, 1, (Object) null);
            if (!IntSize.m7281equalsimpl0(r92, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r92;
            }
            long r93 = m655tryMinWidthJN0ABg$default(this, j2, false, 1, (Object) null);
            if (!IntSize.m7281equalsimpl0(r93, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r93;
            }
            long r94 = m653tryMinHeightJN0ABg$default(this, j2, false, 1, (Object) null);
            if (!IntSize.m7281equalsimpl0(r94, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r94;
            }
            long r95 = m650tryMaxWidthJN0ABg(j2, false);
            if (!IntSize.m7281equalsimpl0(r95, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r95;
            }
            long r96 = m648tryMaxHeightJN0ABg(j2, false);
            if (!IntSize.m7281equalsimpl0(r96, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r96;
            }
            long r97 = m654tryMinWidthJN0ABg(j2, false);
            if (!IntSize.m7281equalsimpl0(r97, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r97;
            }
            long r98 = m652tryMinHeightJN0ABg(j2, false);
            if (!IntSize.m7281equalsimpl0(r98, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r98;
            }
        } else {
            long j3 = j;
            long r99 = m649tryMaxHeightJN0ABg$default(this, j3, false, 1, (Object) null);
            if (!IntSize.m7281equalsimpl0(r99, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r99;
            }
            long r910 = m651tryMaxWidthJN0ABg$default(this, j3, false, 1, (Object) null);
            if (!IntSize.m7281equalsimpl0(r910, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r910;
            }
            long r911 = m653tryMinHeightJN0ABg$default(this, j3, false, 1, (Object) null);
            if (!IntSize.m7281equalsimpl0(r911, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r911;
            }
            long r912 = m655tryMinWidthJN0ABg$default(this, j3, false, 1, (Object) null);
            if (!IntSize.m7281equalsimpl0(r912, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r912;
            }
            long r913 = m648tryMaxHeightJN0ABg(j3, false);
            if (!IntSize.m7281equalsimpl0(r913, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r913;
            }
            long r914 = m650tryMaxWidthJN0ABg(j3, false);
            if (!IntSize.m7281equalsimpl0(r914, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r914;
            }
            long r915 = m652tryMinHeightJN0ABg(j3, false);
            if (!IntSize.m7281equalsimpl0(r915, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r915;
            }
            long r916 = m654tryMinWidthJN0ABg(j3, false);
            if (!IntSize.m7281equalsimpl0(r916, IntSize.Companion.m7288getZeroYbymL2g())) {
                return r916;
            }
        }
        return IntSize.Companion.m7288getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m651tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m650tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg  reason: not valid java name */
    private final long m650tryMaxWidthJN0ABg(long j, boolean z) {
        int round;
        int r0 = Constraints.m7052getMaxWidthimpl(j);
        if (r0 != Integer.MAX_VALUE && (round = Math.round(((float) r0) / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(r0, round);
            if (!z || ConstraintsKt.m7070isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m7288getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m649tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m648tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg  reason: not valid java name */
    private final long m648tryMaxHeightJN0ABg(long j, boolean z) {
        int round;
        int r0 = Constraints.m7051getMaxHeightimpl(j);
        if (r0 != Integer.MAX_VALUE && (round = Math.round(((float) r0) * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(round, r0);
            if (!z || ConstraintsKt.m7070isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m7288getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m655tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m654tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg  reason: not valid java name */
    private final long m654tryMinWidthJN0ABg(long j, boolean z) {
        int r0 = Constraints.m7054getMinWidthimpl(j);
        int round = Math.round(((float) r0) / this.aspectRatio);
        if (round > 0) {
            long IntSize = IntSizeKt.IntSize(r0, round);
            if (!z || ConstraintsKt.m7070isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m7288getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m653tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m652tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg  reason: not valid java name */
    private final long m652tryMinHeightJN0ABg(long j, boolean z) {
        int r0 = Constraints.m7053getMinHeightimpl(j);
        int round = Math.round(((float) r0) * this.aspectRatio);
        if (round > 0) {
            long IntSize = IntSizeKt.IntSize(round, r0);
            if (!z || ConstraintsKt.m7070isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m7288getZeroYbymL2g();
    }
}
