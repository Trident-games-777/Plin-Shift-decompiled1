package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010%\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b&J\u000e\u0010'\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b(J\u000e\u0010)\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b*J'\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J'\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0000¢\u0006\u0002\b1J-\u00102\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b3J\u0013\u00104\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J6\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010 \u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020<H\u0000ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\\\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<28\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(?\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ6\u00107\u001a\u0002082\b\u0010 \u001a\u0004\u0018\u00010B2\b\u0010\b\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010;\u001a\u00020<H\u0000ø\u0001\u0000¢\u0006\u0004\b=\u0010DJ\t\u0010E\u001a\u00020FHÖ\u0001R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000RB\u0010\u000e\u001a6\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0014\u0010\u0014\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0010\u0010 \u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u0004\u0018\u00010\rX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;II)V", "collapseMeasurable", "Landroidx/compose/ui/layout/Measurable;", "collapsePlaceable", "Landroidx/compose/ui/layout/Placeable;", "collapseSize", "Landroidx/collection/IntIntPair;", "getOverflowMeasurable", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isExpandable", "noOfItemsShown", "itemCount", "getItemCount$foundation_layout_release", "()I", "setItemCount$foundation_layout_release", "(I)V", "itemShown", "getItemShown$foundation_layout_release", "setItemShown$foundation_layout_release", "getMinCrossAxisSizeToShowCollapse$foundation_layout_release", "getMinLinesToShowCollapse$foundation_layout_release", "getNoOfItemsShown$foundation_layout_release", "seeMoreMeasurable", "seeMorePlaceable", "seeMoreSize", "getType$foundation_layout_release", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "component1", "component1$foundation_layout_release", "component2", "component2$foundation_layout_release", "component3", "component3$foundation_layout_release", "copy", "ellipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "hasNext", "lineIndex", "totalCrossAxisSize", "ellipsisInfo$foundation_layout_release", "ellipsisSize", "ellipsisSize-F35zm-w$foundation_layout_release", "equals", "other", "hashCode", "setOverflowMeasurables", "", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "setOverflowMeasurables--hBUhpc$foundation_layout_release", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Measurable;J)V", "numberOfItemsShown", "setOverflowMeasurables-VKLhPVY$foundation_layout_release", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function2;)V", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "isHorizontal", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMeasurable;ZJ)V", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayoutOverflow.kt */
public final class FlowLayoutOverflowState {
    public static final int $stable = 8;
    private Measurable collapseMeasurable;
    /* access modifiers changed from: private */
    public Placeable collapsePlaceable;
    /* access modifiers changed from: private */
    public IntIntPair collapseSize;
    private Function2<? super Boolean, ? super Integer, ? extends Measurable> getOverflowMeasurable;
    private int itemCount;
    private int itemShown = -1;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private Measurable seeMoreMeasurable;
    /* access modifiers changed from: private */
    public Placeable seeMorePlaceable;
    /* access modifiers changed from: private */
    public IntIntPair seeMoreSize;
    private final FlowLayoutOverflow.OverflowType type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FlowLayoutOverflow.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.foundation.layout.FlowLayoutOverflow$OverflowType[] r0 = androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.layout.FlowLayoutOverflow$OverflowType r1 = androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType.Visible     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.layout.FlowLayoutOverflow$OverflowType r1 = androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType.Clip     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.layout.FlowLayoutOverflow$OverflowType r1 = androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType.ExpandIndicator     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.foundation.layout.FlowLayoutOverflow$OverflowType r1 = androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutOverflowState.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ FlowLayoutOverflowState copy$default(FlowLayoutOverflowState flowLayoutOverflowState, FlowLayoutOverflow.OverflowType overflowType, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            overflowType = flowLayoutOverflowState.type;
        }
        if ((i3 & 2) != 0) {
            i = flowLayoutOverflowState.minLinesToShowCollapse;
        }
        if ((i3 & 4) != 0) {
            i2 = flowLayoutOverflowState.minCrossAxisSizeToShowCollapse;
        }
        return flowLayoutOverflowState.copy(overflowType, i, i2);
    }

    public final FlowLayoutOverflow.OverflowType component1$foundation_layout_release() {
        return this.type;
    }

    public final int component2$foundation_layout_release() {
        return this.minLinesToShowCollapse;
    }

    public final int component3$foundation_layout_release() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final FlowLayoutOverflowState copy(FlowLayoutOverflow.OverflowType overflowType, int i, int i2) {
        return new FlowLayoutOverflowState(overflowType, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowLayoutOverflowState)) {
            return false;
        }
        FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) obj;
        return this.type == flowLayoutOverflowState.type && this.minLinesToShowCollapse == flowLayoutOverflowState.minLinesToShowCollapse && this.minCrossAxisSizeToShowCollapse == flowLayoutOverflowState.minCrossAxisSizeToShowCollapse;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Integer.hashCode(this.minLinesToShowCollapse)) * 31) + Integer.hashCode(this.minCrossAxisSizeToShowCollapse);
    }

    public String toString() {
        return "FlowLayoutOverflowState(type=" + this.type + ", minLinesToShowCollapse=" + this.minLinesToShowCollapse + ", minCrossAxisSizeToShowCollapse=" + this.minCrossAxisSizeToShowCollapse + ')';
    }

    public FlowLayoutOverflowState(FlowLayoutOverflow.OverflowType overflowType, int i, int i2) {
        this.type = overflowType;
        this.minLinesToShowCollapse = i;
        this.minCrossAxisSizeToShowCollapse = i2;
    }

    public final FlowLayoutOverflow.OverflowType getType$foundation_layout_release() {
        return this.type;
    }

    public final int getMinLinesToShowCollapse$foundation_layout_release() {
        return this.minLinesToShowCollapse;
    }

    public final int getMinCrossAxisSizeToShowCollapse$foundation_layout_release() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final int getNoOfItemsShown$foundation_layout_release() {
        int i = this.itemShown;
        if (i != -1) {
            return i;
        }
        throw new IllegalStateException("Accessing noOfItemsShown before it is set. Are you calling this in the Composition phase, rather than in the draw phase? Consider our samples on how to use it during the draw phase or consider using ContextualFlowRow/ContextualFlowColumn which initializes this method in the composition phase.");
    }

    public final int getItemShown$foundation_layout_release() {
        return this.itemShown;
    }

    public final void setItemShown$foundation_layout_release(int i) {
        this.itemShown = i;
    }

    public final int getItemCount$foundation_layout_release() {
        return this.itemCount;
    }

    public final void setItemCount$foundation_layout_release(int i) {
        this.itemCount = i;
    }

    /* renamed from: ellipsisSize-F35zm-w$foundation_layout_release  reason: not valid java name */
    public final IntIntPair m696ellipsisSizeF35zmw$foundation_layout_release(boolean z, int i, int i2) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (!(i3 == 1 || i3 == 2)) {
            if (i3 != 3) {
                if (i3 != 4) {
                    throw new NoWhenBranchMatchedException();
                } else if (z) {
                    return this.seeMoreSize;
                } else {
                    if (i + 1 < this.minLinesToShowCollapse || i2 < this.minCrossAxisSizeToShowCollapse) {
                        return null;
                    }
                    return this.collapseSize;
                }
            } else if (z) {
                return this.seeMoreSize;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapEllipsisInfo ellipsisInfo$foundation_layout_release(boolean r12, int r13, int r14) {
        /*
            r11 = this;
            androidx.compose.foundation.layout.FlowLayoutOverflow$OverflowType r0 = r11.type
            int[] r1 = androidx.compose.foundation.layout.FlowLayoutOverflowState.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x008a
            r3 = 2
            if (r0 == r3) goto L_0x008a
            r3 = 3
            if (r0 == r3) goto L_0x001e
            r3 = 4
            if (r0 != r3) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        L_0x001e:
            if (r12 == 0) goto L_0x0043
            kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Integer, ? extends androidx.compose.ui.layout.Measurable> r12 = r11.getOverflowMeasurable
            if (r12 == 0) goto L_0x0038
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r1)
            int r14 = r11.getNoOfItemsShown$foundation_layout_release()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object r12 = r12.invoke(r13, r14)
            androidx.compose.ui.layout.Measurable r12 = (androidx.compose.ui.layout.Measurable) r12
            if (r12 != 0) goto L_0x003a
        L_0x0038:
            androidx.compose.ui.layout.Measurable r12 = r11.seeMoreMeasurable
        L_0x003a:
            androidx.collection.IntIntPair r13 = r11.seeMoreSize
            kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Integer, ? extends androidx.compose.ui.layout.Measurable> r14 = r11.getOverflowMeasurable
            if (r14 != 0) goto L_0x0074
            androidx.compose.ui.layout.Placeable r14 = r11.seeMorePlaceable
            goto L_0x0071
        L_0x0043:
            int r12 = r11.minLinesToShowCollapse
            int r12 = r12 - r1
            if (r13 < r12) goto L_0x0068
            int r12 = r11.minCrossAxisSizeToShowCollapse
            if (r14 < r12) goto L_0x0068
            kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Integer, ? extends androidx.compose.ui.layout.Measurable> r12 = r11.getOverflowMeasurable
            if (r12 == 0) goto L_0x0065
            r13 = 0
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            int r14 = r11.getNoOfItemsShown$foundation_layout_release()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object r12 = r12.invoke(r13, r14)
            androidx.compose.ui.layout.Measurable r12 = (androidx.compose.ui.layout.Measurable) r12
            if (r12 != 0) goto L_0x0069
        L_0x0065:
            androidx.compose.ui.layout.Measurable r12 = r11.collapseMeasurable
            goto L_0x0069
        L_0x0068:
            r12 = r2
        L_0x0069:
            androidx.collection.IntIntPair r13 = r11.collapseSize
            kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Integer, ? extends androidx.compose.ui.layout.Measurable> r14 = r11.getOverflowMeasurable
            if (r14 != 0) goto L_0x0074
            androidx.compose.ui.layout.Placeable r14 = r11.collapsePlaceable
        L_0x0071:
            r4 = r12
            r5 = r14
            goto L_0x0076
        L_0x0074:
            r4 = r12
            r5 = r2
        L_0x0076:
            if (r4 != 0) goto L_0x0079
            return r2
        L_0x0079:
            androidx.compose.foundation.layout.FlowLayoutBuildingBlocks$WrapEllipsisInfo r3 = new androidx.compose.foundation.layout.FlowLayoutBuildingBlocks$WrapEllipsisInfo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            long r6 = r13.m37unboximpl()
            r9 = 8
            r10 = 0
            r8 = 0
            r3.<init>(r4, r5, r6, r8, r9, r10)
            return r3
        L_0x008a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutOverflowState.ellipsisInfo$foundation_layout_release(boolean, int, int):androidx.compose.foundation.layout.FlowLayoutBuildingBlocks$WrapEllipsisInfo");
    }

    /* renamed from: setOverflowMeasurables--hBUhpc$foundation_layout_release  reason: not valid java name */
    public final void m698setOverflowMeasurableshBUhpc$foundation_layout_release(IntrinsicMeasurable intrinsicMeasurable, IntrinsicMeasurable intrinsicMeasurable2, boolean z, long j) {
        long r7 = OrientationIndependentConstraints.m744constructorimpl(j, z ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        if (intrinsicMeasurable != null) {
            int mainAxisMin = FlowLayoutKt.mainAxisMin(intrinsicMeasurable, z, Constraints.m7051getMaxHeightimpl(r7));
            this.seeMoreSize = IntIntPair.m26boximpl(IntIntPair.m29constructorimpl(mainAxisMin, FlowLayoutKt.crossAxisMin(intrinsicMeasurable, z, mainAxisMin)));
            this.seeMoreMeasurable = intrinsicMeasurable instanceof Measurable ? (Measurable) intrinsicMeasurable : null;
            this.seeMorePlaceable = null;
        }
        if (intrinsicMeasurable2 != null) {
            int mainAxisMin2 = FlowLayoutKt.mainAxisMin(intrinsicMeasurable2, z, Constraints.m7051getMaxHeightimpl(r7));
            this.collapseSize = IntIntPair.m26boximpl(IntIntPair.m29constructorimpl(mainAxisMin2, FlowLayoutKt.crossAxisMin(intrinsicMeasurable2, z, mainAxisMin2)));
            this.collapseMeasurable = intrinsicMeasurable2 instanceof Measurable ? (Measurable) intrinsicMeasurable2 : null;
            this.collapsePlaceable = null;
        }
    }

    /* renamed from: setOverflowMeasurables--hBUhpc$foundation_layout_release  reason: not valid java name */
    public final void m697setOverflowMeasurableshBUhpc$foundation_layout_release(FlowLineMeasurePolicy flowLineMeasurePolicy, Measurable measurable, Measurable measurable2, long j) {
        LayoutOrientation layoutOrientation = flowLineMeasurePolicy.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
        long r13 = OrientationIndependentConstraints.m757toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m746copyyUG9Ft0$default(OrientationIndependentConstraints.m744constructorimpl(j, layoutOrientation), 0, 0, 0, 0, 10, (Object) null), layoutOrientation);
        if (measurable != null) {
            FlowLayoutKt.m692measureAndCacherqJ1uqs(measurable, flowLineMeasurePolicy, r13, new FlowLayoutOverflowState$setOverflowMeasurables$3$1(this, flowLineMeasurePolicy));
            this.seeMoreMeasurable = measurable;
        }
        if (measurable2 != null) {
            FlowLayoutKt.m692measureAndCacherqJ1uqs(measurable2, flowLineMeasurePolicy, r13, new FlowLayoutOverflowState$setOverflowMeasurables$4$1(this, flowLineMeasurePolicy));
            this.collapseMeasurable = measurable2;
        }
    }

    /* renamed from: setOverflowMeasurables-VKLhPVY$foundation_layout_release  reason: not valid java name */
    public final void m699setOverflowMeasurablesVKLhPVY$foundation_layout_release(FlowLineMeasurePolicy flowLineMeasurePolicy, long j, Function2<? super Boolean, ? super Integer, ? extends Measurable> function2) {
        this.itemShown = 0;
        this.getOverflowMeasurable = function2;
        m697setOverflowMeasurableshBUhpc$foundation_layout_release(flowLineMeasurePolicy, (Measurable) function2.invoke(true, 0), (Measurable) function2.invoke(false, 0), j);
    }
}
