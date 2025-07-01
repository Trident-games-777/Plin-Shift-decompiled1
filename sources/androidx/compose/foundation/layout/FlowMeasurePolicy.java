package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u0016\u0010+\u001a\u00020\nHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\t\u0010.\u001a\u00020\fHÆ\u0003J\u0016\u0010/\u001a\u00020\nHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010-J\t\u00101\u001a\u00020\u000fHÂ\u0003J\t\u00102\u001a\u00020\u000fHÂ\u0003J\t\u00103\u001a\u00020\u0012HÂ\u0003Jm\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u000fHÖ\u0001JD\u0010;\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J$\u0010@\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fJD\u0010C\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010E\u001a\u00020FHÖ\u0001J(\u0010G\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010I\u001a\u00020\u000fH\u0016J(\u0010J\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010A\u001a\u00020\u000fH\u0016J2\u0010K\u001a\u00020L*\u00020M2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0=0=2\u0006\u0010O\u001a\u00020PH\u0016ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ(\u0010S\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010I\u001a\u00020\u000fH\u0016J(\u0010T\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010A\u001a\u00020\u000fH\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\r\u001a\u00020\nX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0019R\u0016\u0010\t\u001a\u00020\nX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R.\u0010\u001a\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R.\u0010 \u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR.\u0010\"\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR.\u0010$\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006U"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "maxItemsInMainAxis", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "F", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "()Z", "maxCrossAxisIntrinsicItemSize", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "Lkotlin/ExtensionFunctionType;", "getMaxCrossAxisIntrinsicItemSize", "()Lkotlin/jvm/functions/Function3;", "maxMainAxisIntrinsicItemSize", "getMaxMainAxisIntrinsicItemSize", "minCrossAxisIntrinsicItemSize", "getMinCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "getMinMainAxisIntrinsicItemSize", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "copy", "copy-QuyCDyQ", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "equals", "other", "", "hashCode", "intrinsicCrossAxisSize", "measurables", "", "mainAxisAvailable", "crossAxisSpacing", "maxIntrinsicMainAxisSize", "height", "arrangementSpacing", "minIntrinsicMainAxisSize", "crossAxisAvailable", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
final class FlowMeasurePolicy implements MultiContentMeasurePolicy, FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final float mainAxisSpacing;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;
    private final FlowLayoutOverflowState overflow;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasurePolicy(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment2, float f2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, horizontal, vertical, f, crossAxisAlignment2, f2, i, i2, flowLayoutOverflowState);
    }

    /* renamed from: component4-D9Ej5fM  reason: not valid java name */
    private final float m713component4D9Ej5fM() {
        return this.mainAxisSpacing;
    }

    /* renamed from: component6-D9Ej5fM  reason: not valid java name */
    private final float m714component6D9Ej5fM() {
        return this.crossAxisArrangementSpacing;
    }

    private final int component7() {
        return this.maxItemsInMainAxis;
    }

    private final int component8() {
        return this.maxLines;
    }

    private final FlowLayoutOverflowState component9() {
        return this.overflow;
    }

    /* renamed from: copy-QuyCDyQ$default  reason: not valid java name */
    public static /* synthetic */ FlowMeasurePolicy m715copyQuyCDyQ$default(FlowMeasurePolicy flowMeasurePolicy, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment2, float f2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = flowMeasurePolicy.isHorizontal;
        }
        if ((i3 & 2) != 0) {
            horizontal = flowMeasurePolicy.horizontalArrangement;
        }
        if ((i3 & 4) != 0) {
            vertical = flowMeasurePolicy.verticalArrangement;
        }
        if ((i3 & 8) != 0) {
            f = flowMeasurePolicy.mainAxisSpacing;
        }
        if ((i3 & 16) != 0) {
            crossAxisAlignment2 = flowMeasurePolicy.crossAxisAlignment;
        }
        if ((i3 & 32) != 0) {
            f2 = flowMeasurePolicy.crossAxisArrangementSpacing;
        }
        if ((i3 & 64) != 0) {
            i = flowMeasurePolicy.maxItemsInMainAxis;
        }
        if ((i3 & 128) != 0) {
            i2 = flowMeasurePolicy.maxLines;
        }
        if ((i3 & 256) != 0) {
            flowLayoutOverflowState = flowMeasurePolicy.overflow;
        }
        int i4 = i2;
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
        float f3 = f2;
        int i5 = i;
        float f4 = f;
        CrossAxisAlignment crossAxisAlignment3 = crossAxisAlignment2;
        return flowMeasurePolicy.m716copyQuyCDyQ(z, horizontal, vertical, f4, crossAxisAlignment3, f3, i5, i4, flowLayoutOverflowState2);
    }

    public final boolean component1() {
        return this.isHorizontal;
    }

    public final Arrangement.Horizontal component2() {
        return this.horizontalArrangement;
    }

    public final Arrangement.Vertical component3() {
        return this.verticalArrangement;
    }

    public final CrossAxisAlignment component5() {
        return this.crossAxisAlignment;
    }

    /* renamed from: copy-QuyCDyQ  reason: not valid java name */
    public final FlowMeasurePolicy m716copyQuyCDyQ(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment2, float f2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState) {
        return new FlowMeasurePolicy(z, horizontal, vertical, f, crossAxisAlignment2, f2, i, i2, flowLayoutOverflowState, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowMeasurePolicy)) {
            return false;
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) obj;
        return this.isHorizontal == flowMeasurePolicy.isHorizontal && Intrinsics.areEqual((Object) this.horizontalArrangement, (Object) flowMeasurePolicy.horizontalArrangement) && Intrinsics.areEqual((Object) this.verticalArrangement, (Object) flowMeasurePolicy.verticalArrangement) && Dp.m7116equalsimpl0(this.mainAxisSpacing, flowMeasurePolicy.mainAxisSpacing) && Intrinsics.areEqual((Object) this.crossAxisAlignment, (Object) flowMeasurePolicy.crossAxisAlignment) && Dp.m7116equalsimpl0(this.crossAxisArrangementSpacing, flowMeasurePolicy.crossAxisArrangementSpacing) && this.maxItemsInMainAxis == flowMeasurePolicy.maxItemsInMainAxis && this.maxLines == flowMeasurePolicy.maxLines && Intrinsics.areEqual((Object) this.overflow, (Object) flowMeasurePolicy.overflow);
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.isHorizontal) * 31) + this.horizontalArrangement.hashCode()) * 31) + this.verticalArrangement.hashCode()) * 31) + Dp.m7117hashCodeimpl(this.mainAxisSpacing)) * 31) + this.crossAxisAlignment.hashCode()) * 31) + Dp.m7117hashCodeimpl(this.crossAxisArrangementSpacing)) * 31) + Integer.hashCode(this.maxItemsInMainAxis)) * 31) + Integer.hashCode(this.maxLines)) * 31) + this.overflow.hashCode();
    }

    public String toString() {
        return "FlowMeasurePolicy(isHorizontal=" + this.isHorizontal + ", horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", mainAxisSpacing=" + Dp.m7122toStringimpl(this.mainAxisSpacing) + ", crossAxisAlignment=" + this.crossAxisAlignment + ", crossAxisArrangementSpacing=" + Dp.m7122toStringimpl(this.crossAxisArrangementSpacing) + ", maxItemsInMainAxis=" + this.maxItemsInMainAxis + ", maxLines=" + this.maxLines + ", overflow=" + this.overflow + ')';
    }

    private FlowMeasurePolicy(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment2, float f2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState) {
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function3;
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function32;
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function33;
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function34;
        this.isHorizontal = z;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.mainAxisSpacing = f;
        this.crossAxisAlignment = crossAxisAlignment2;
        this.crossAxisArrangementSpacing = f2;
        this.maxItemsInMainAxis = i;
        this.maxLines = i2;
        this.overflow = flowLayoutOverflowState;
        if (isHorizontal()) {
            function3 = FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function3 = FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.maxMainAxisIntrinsicItemSize = function3;
        if (isHorizontal()) {
            function32 = FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function32 = FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.maxCrossAxisIntrinsicItemSize = function32;
        if (isHorizontal()) {
            function33 = FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function33 = FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.minCrossAxisIntrinsicItemSize = function33;
        if (isHorizontal()) {
            function34 = FlowMeasurePolicy$minMainAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function34 = FlowMeasurePolicy$minMainAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.minMainAxisIntrinsicItemSize = function34;
    }

    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    public Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m717measure3p2s80s(androidx.compose.ui.layout.MeasureScope r12, java.util.List<? extends java.util.List<? extends androidx.compose.ui.layout.Measurable>> r13, long r14) {
        /*
            r11 = this;
            int r0 = r11.maxLines
            if (r0 == 0) goto L_0x0098
            int r0 = r11.maxItemsInMainAxis
            if (r0 == 0) goto L_0x0098
            boolean r0 = r13.isEmpty()
            if (r0 != 0) goto L_0x0098
            int r0 = androidx.compose.ui.unit.Constraints.m7051getMaxHeightimpl(r14)
            if (r0 != 0) goto L_0x0020
            androidx.compose.foundation.layout.FlowLayoutOverflowState r0 = r11.overflow
            androidx.compose.foundation.layout.FlowLayoutOverflow$OverflowType r0 = r0.getType$foundation_layout_release()
            androidx.compose.foundation.layout.FlowLayoutOverflow$OverflowType r1 = androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType.Visible
            if (r0 == r1) goto L_0x0020
            goto L_0x0098
        L_0x0020:
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r13)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x003c
            androidx.compose.foundation.layout.FlowMeasurePolicy$measure$2 r13 = androidx.compose.foundation.layout.FlowMeasurePolicy$measure$2.INSTANCE
            r4 = r13
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 4
            r6 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r0 = r12
            androidx.compose.ui.layout.MeasureResult r12 = androidx.compose.ui.layout.MeasureScope.layout$default(r0, r1, r2, r3, r4, r5, r6)
            return r12
        L_0x003c:
            r10 = r0
            r0 = r12
            r12 = r10
            r1 = 1
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r13, r1)
            java.util.List r1 = (java.util.List) r1
            r2 = 0
            if (r1 == 0) goto L_0x0051
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            r5 = r1
            goto L_0x0052
        L_0x0051:
            r5 = r2
        L_0x0052:
            r1 = 2
            java.lang.Object r13 = kotlin.collections.CollectionsKt.getOrNull(r13, r1)
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L_0x0062
            java.lang.Object r13 = kotlin.collections.CollectionsKt.firstOrNull(r13)
            r2 = r13
            androidx.compose.ui.layout.Measurable r2 = (androidx.compose.ui.layout.Measurable) r2
        L_0x0062:
            r6 = r2
            androidx.compose.foundation.layout.FlowLayoutOverflowState r13 = r11.overflow
            int r1 = r12.size()
            r13.setItemCount$foundation_layout_release(r1)
            androidx.compose.foundation.layout.FlowLayoutOverflowState r3 = r11.overflow
            r1 = r11
            androidx.compose.foundation.layout.FlowLineMeasurePolicy r1 = (androidx.compose.foundation.layout.FlowLineMeasurePolicy) r1
            r7 = r14
            r4 = r1
            r3.m697setOverflowMeasurableshBUhpc$foundation_layout_release((androidx.compose.foundation.layout.FlowLineMeasurePolicy) r4, (androidx.compose.ui.layout.Measurable) r5, (androidx.compose.ui.layout.Measurable) r6, (long) r7)
            java.util.Iterator r2 = r12.iterator()
            float r3 = r11.mainAxisSpacing
            float r4 = r11.crossAxisArrangementSpacing
            boolean r12 = r11.isHorizontal()
            if (r12 == 0) goto L_0x0087
            androidx.compose.foundation.layout.LayoutOrientation r12 = androidx.compose.foundation.layout.LayoutOrientation.Horizontal
            goto L_0x0089
        L_0x0087:
            androidx.compose.foundation.layout.LayoutOrientation r12 = androidx.compose.foundation.layout.LayoutOrientation.Vertical
        L_0x0089:
            long r5 = androidx.compose.foundation.layout.OrientationIndependentConstraints.m744constructorimpl(r7, r12)
            int r7 = r11.maxItemsInMainAxis
            int r8 = r11.maxLines
            androidx.compose.foundation.layout.FlowLayoutOverflowState r9 = r11.overflow
            androidx.compose.ui.layout.MeasureResult r12 = androidx.compose.foundation.layout.FlowLayoutKt.m691breakDownItemsdi9J0FM(r0, r1, r2, r3, r4, r5, r7, r8, r9)
            return r12
        L_0x0098:
            r0 = r12
            androidx.compose.foundation.layout.FlowMeasurePolicy$measure$1 r12 = androidx.compose.foundation.layout.FlowMeasurePolicy$measure$1.INSTANCE
            r4 = r12
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 4
            r6 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            androidx.compose.ui.layout.MeasureResult r12 = androidx.compose.ui.layout.MeasureScope.layout$default(r0, r1, r2, r3, r4, r5, r6)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowMeasurePolicy.m717measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = null;
        IntrinsicMeasurable intrinsicMeasurable2 = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        if (list3 != null) {
            intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3);
        }
        flowLayoutOverflowState.m698setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable2, intrinsicMeasurable, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null));
        if (isHorizontal()) {
            List list4 = (List) CollectionsKt.firstOrNull(list);
            if (list4 == null) {
                list4 = CollectionsKt.emptyList();
            }
            return minIntrinsicMainAxisSize(list4, i, intrinsicMeasureScope.m7086roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.m7086roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List list5 = (List) CollectionsKt.firstOrNull(list);
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        return intrinsicCrossAxisSize(list5, i, intrinsicMeasureScope.m7086roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.m7086roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = null;
        IntrinsicMeasurable intrinsicMeasurable2 = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        if (list3 != null) {
            intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3);
        }
        flowLayoutOverflowState.m698setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable2, intrinsicMeasurable, isHorizontal(), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null));
        if (isHorizontal()) {
            List list4 = (List) CollectionsKt.firstOrNull(list);
            if (list4 == null) {
                list4 = CollectionsKt.emptyList();
            }
            return intrinsicCrossAxisSize(list4, i, intrinsicMeasureScope.m7086roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.m7086roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List list5 = (List) CollectionsKt.firstOrNull(list);
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        return minIntrinsicMainAxisSize(list5, i, intrinsicMeasureScope.m7086roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.m7086roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = null;
        IntrinsicMeasurable intrinsicMeasurable2 = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        if (list3 != null) {
            intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3);
        }
        flowLayoutOverflowState.m698setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable2, intrinsicMeasurable, isHorizontal(), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null));
        if (isHorizontal()) {
            List list4 = (List) CollectionsKt.firstOrNull(list);
            if (list4 == null) {
                list4 = CollectionsKt.emptyList();
            }
            return intrinsicCrossAxisSize(list4, i, intrinsicMeasureScope.m7086roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.m7086roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List list5 = (List) CollectionsKt.firstOrNull(list);
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        return maxIntrinsicMainAxisSize(list5, i, intrinsicMeasureScope.m7086roundToPx0680j_4(this.mainAxisSpacing));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = null;
        IntrinsicMeasurable intrinsicMeasurable2 = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        if (list3 != null) {
            intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3);
        }
        flowLayoutOverflowState.m698setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable2, intrinsicMeasurable, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null));
        if (isHorizontal()) {
            List list4 = (List) CollectionsKt.firstOrNull(list);
            if (list4 == null) {
                list4 = CollectionsKt.emptyList();
            }
            return maxIntrinsicMainAxisSize(list4, i, intrinsicMeasureScope.m7086roundToPx0680j_4(this.mainAxisSpacing));
        }
        int i2 = i;
        List list5 = (List) CollectionsKt.firstOrNull(list);
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        return intrinsicCrossAxisSize(list5, i2, intrinsicMeasureScope.m7086roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.m7086roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        return FlowLayoutKt.minIntrinsicMainAxisSize(list, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, i, i2, i3, i4, i5, flowLayoutOverflowState);
    }

    public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        return FlowLayoutKt.maxIntrinsicMainAxisSize(list, this.maxMainAxisIntrinsicItemSize, i, i2, this.maxItemsInMainAxis);
    }

    public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        return IntIntPair.m33getFirstimpl(FlowLayoutKt.intrinsicCrossAxisSize(list, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minMainAxisIntrinsicItemSize, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minCrossAxisIntrinsicItemSize, i, i2, i3, i4, i5, flowLayoutOverflowState));
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
        return this.maxMainAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
        return this.maxCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
        return this.minCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
        return this.minMainAxisIntrinsicItemSize;
    }
}
