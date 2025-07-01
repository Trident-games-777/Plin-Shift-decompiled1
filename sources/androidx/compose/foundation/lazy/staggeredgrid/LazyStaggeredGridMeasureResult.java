package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B£\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\t\u0010\\\u001a\u00020JH\u0001J\u000e\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020\u0014R\u0014\u0010\u001d\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00140%X\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010\u001c\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010*\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010,\"\u0004\b.\u0010/R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00109\"\u0004\b;\u0010<R\u0012\u0010=\u001a\u00020\u0014X\u0005¢\u0006\u0006\u001a\u0004\b>\u0010#R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010,R\u0014\u0010\u001e\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010#R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020CX\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R'\u0010G\u001a\u0015\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J\u0018\u00010H¢\u0006\u0002\bK8VX\u0005¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010#R\u0014\u0010\u001b\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010#R\u001c\u0010\u0018\u001a\u00020\u0019X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010V\u001a\u0004\bT\u0010UR\u0014\u0010\u001a\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010#R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0012\u0010Z\u001a\u00020\u0014X\u0005¢\u0006\u0006\u001a\u0004\b[\u0010#\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006_"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItemIndices", "", "firstVisibleItemScrollOffsets", "consumedScroll", "", "measureResult", "canScrollForward", "", "isVertical", "remeasureNeeded", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "density", "Landroidx/compose/ui/unit/Density;", "totalItemsCount", "", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "viewportStartOffset", "viewportEndOffset", "beforeContentPadding", "afterContentPadding", "mainAxisItemSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "([I[IFLandroidx/compose/ui/layout/MeasureResult;ZZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;Landroidx/compose/ui/unit/Density;ILjava/util/List;JIIIIILkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleItemIndices", "()[I", "getFirstVisibleItemScrollOffsets", "setFirstVisibleItemScrollOffsets", "([I)V", "height", "getHeight", "getMainAxisItemSpacing", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getRemeasureNeeded", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "getSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getSpanProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getTotalItemsCount", "getViewportEndOffset", "getViewportSize-YbymL2g", "()J", "J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasureResult.kt */
public final class LazyStaggeredGridMeasureResult implements LazyStaggeredGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final int[] firstVisibleItemIndices;
    private int[] firstVisibleItemScrollOffsets;
    private final boolean isVertical;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final LazyStaggeredGridSlots slots;
    private final LazyStaggeredGridSpanProvider spanProvider;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final long viewportSize;
    private final int viewportStartOffset;
    private final List<LazyStaggeredGridMeasuredItem> visibleItemsInfo;

    public /* synthetic */ LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f, MeasureResult measureResult2, boolean z, boolean z2, boolean z3, LazyStaggeredGridSlots lazyStaggeredGridSlots, LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider, Density density2, int i, List list, long j, int i2, int i3, int i4, int i5, int i6, CoroutineScope coroutineScope2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, iArr2, f, measureResult2, z, z2, z3, lazyStaggeredGridSlots, lazyStaggeredGridSpanProvider, density2, i, list, j, i2, i3, i4, i5, i6, coroutineScope2);
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    public int getHeight() {
        return this.measureResult.getHeight();
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.measureResult.getRulers();
    }

    public int getWidth() {
        return this.measureResult.getWidth();
    }

    public void placeChildren() {
        this.measureResult.placeChildren();
    }

    private LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f, MeasureResult measureResult2, boolean z, boolean z2, boolean z3, LazyStaggeredGridSlots lazyStaggeredGridSlots, LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider, Density density2, int i, List<LazyStaggeredGridMeasuredItem> list, long j, int i2, int i3, int i4, int i5, int i6, CoroutineScope coroutineScope2) {
        this.firstVisibleItemIndices = iArr;
        this.firstVisibleItemScrollOffsets = iArr2;
        this.consumedScroll = f;
        this.measureResult = measureResult2;
        this.canScrollForward = z;
        this.isVertical = z2;
        this.remeasureNeeded = z3;
        this.slots = lazyStaggeredGridSlots;
        this.spanProvider = lazyStaggeredGridSpanProvider;
        this.density = density2;
        this.totalItemsCount = i;
        this.visibleItemsInfo = list;
        this.viewportSize = j;
        this.viewportStartOffset = i2;
        this.viewportEndOffset = i3;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
        this.mainAxisItemSpacing = i6;
        this.coroutineScope = coroutineScope2;
        this.orientation = z2 ? Orientation.Vertical : Orientation.Horizontal;
    }

    public final int[] getFirstVisibleItemIndices() {
        return this.firstVisibleItemIndices;
    }

    public final int[] getFirstVisibleItemScrollOffsets() {
        return this.firstVisibleItemScrollOffsets;
    }

    public final void setFirstVisibleItemScrollOffsets(int[] iArr) {
        this.firstVisibleItemScrollOffsets = iArr;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final void setConsumedScroll(float f) {
        this.consumedScroll = f;
    }

    public final MeasureResult getMeasureResult() {
        return this.measureResult;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final void setCanScrollForward(boolean z) {
        this.canScrollForward = z;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public final LazyStaggeredGridSlots getSlots() {
        return this.slots;
    }

    public final LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.spanProvider;
    }

    public final Density getDensity() {
        return this.density;
    }

    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public List<LazyStaggeredGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m1063getViewportSizeYbymL2g() {
        return this.viewportSize;
    }

    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    public int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final boolean getCanScrollBackward() {
        return this.firstVisibleItemIndices[0] != 0 || this.firstVisibleItemScrollOffsets[0] > 0;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a9, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean tryToApplyScrollWithoutRemeasure(int r10) {
        /*
            r9 = this;
            boolean r0 = r9.remeasureNeeded
            r1 = 0
            if (r0 != 0) goto L_0x00e4
            java.util.List r0 = r9.getVisibleItemsInfo()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00e4
            int[] r0 = r9.firstVisibleItemIndices
            int r0 = r0.length
            if (r0 != 0) goto L_0x0016
            goto L_0x00e4
        L_0x0016:
            int[] r0 = r9.firstVisibleItemScrollOffsets
            int r0 = r0.length
            if (r0 != 0) goto L_0x001d
            goto L_0x00e4
        L_0x001d:
            int r0 = r9.getViewportEndOffset()
            int r2 = r9.getAfterContentPadding()
            int r0 = r0 - r2
            java.util.List r2 = r9.getVisibleItemsInfo()
            int r3 = r2.size()
            r4 = r1
        L_0x002f:
            r5 = 1
            if (r4 >= r3) goto L_0x00ae
            java.lang.Object r6 = r2.get(r4)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r6 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r6
            boolean r7 = r6.getNonScrollableItem()
            if (r7 != 0) goto L_0x00ad
            int r7 = r6.getMainAxisOffset()
            if (r7 > 0) goto L_0x0046
            r7 = r5
            goto L_0x0047
        L_0x0046:
            r7 = r1
        L_0x0047:
            int r8 = r6.getMainAxisOffset()
            int r8 = r8 + r10
            if (r8 > 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r5 = r1
        L_0x0050:
            if (r7 == r5) goto L_0x0053
            goto L_0x00ad
        L_0x0053:
            int r5 = r6.getMainAxisOffset()
            int r7 = r9.getViewportStartOffset()
            if (r5 > r7) goto L_0x007e
            if (r10 >= 0) goto L_0x0071
            int r5 = r6.getMainAxisOffset()
            int r7 = r6.getMainAxisSizeWithSpacings()
            int r5 = r5 + r7
            int r7 = r9.getViewportStartOffset()
            int r5 = r5 - r7
            int r7 = -r10
            if (r5 <= r7) goto L_0x007d
            goto L_0x007e
        L_0x0071:
            int r5 = r9.getViewportStartOffset()
            int r7 = r6.getMainAxisOffset()
            int r5 = r5 - r7
            if (r5 <= r10) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            return r1
        L_0x007e:
            int r5 = r6.getMainAxisOffset()
            int r7 = r6.getMainAxisSizeWithSpacings()
            int r5 = r5 + r7
            if (r5 < r0) goto L_0x00aa
            if (r10 >= 0) goto L_0x009d
            int r5 = r6.getMainAxisOffset()
            int r6 = r6.getMainAxisSizeWithSpacings()
            int r5 = r5 + r6
            int r6 = r9.getViewportEndOffset()
            int r5 = r5 - r6
            int r6 = -r10
            if (r5 <= r6) goto L_0x00a9
            goto L_0x00aa
        L_0x009d:
            int r5 = r9.getViewportEndOffset()
            int r6 = r6.getMainAxisOffset()
            int r5 = r5 - r6
            if (r5 <= r10) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            return r1
        L_0x00aa:
            int r4 = r4 + 1
            goto L_0x002f
        L_0x00ad:
            return r1
        L_0x00ae:
            int[] r0 = r9.firstVisibleItemScrollOffsets
            int r0 = r0.length
            int[] r2 = new int[r0]
            r3 = r1
        L_0x00b4:
            if (r3 >= r0) goto L_0x00c0
            int[] r4 = r9.firstVisibleItemScrollOffsets
            r4 = r4[r3]
            int r4 = r4 - r10
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x00b4
        L_0x00c0:
            r9.firstVisibleItemScrollOffsets = r2
            java.util.List r0 = r9.getVisibleItemsInfo()
            int r2 = r0.size()
        L_0x00ca:
            if (r1 >= r2) goto L_0x00d8
            java.lang.Object r3 = r0.get(r1)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r3 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r3
            r3.applyScrollDelta(r10)
            int r1 = r1 + 1
            goto L_0x00ca
        L_0x00d8:
            float r0 = (float) r10
            r9.consumedScroll = r0
            boolean r0 = r9.canScrollForward
            if (r0 != 0) goto L_0x00e3
            if (r10 <= 0) goto L_0x00e3
            r9.canScrollForward = r5
        L_0x00e3:
            return r5
        L_0x00e4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult.tryToApplyScrollWithoutRemeasure(int):boolean");
    }
}
