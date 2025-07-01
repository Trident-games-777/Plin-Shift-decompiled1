package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BÊ\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u00123\u0010\u0012\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u00180\u00170\u0013\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0002\u0010$J\t\u0010[\u001a\u00020LH\u0001J\u000e\u0010\\\u001a\u00020\b2\u0006\u0010]\u001a\u00020\u0006R\u0014\u0010\"\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00060(X\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010&R\u0011\u0010.\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00100\"\u0004\b2\u00103R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010&\"\u0004\b?\u0010@R\u0012\u0010A\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\bB\u0010&R\u0014\u0010#\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010&R\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER>\u0010\u0012\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u00180\u00170\u0013¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0014\u0010\u001f\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00100R'\u0010J\u001a\u0015\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L\u0018\u00010\u0013¢\u0006\u0002\bM8VX\u0005¢\u0006\u0006\u001a\u0004\bN\u0010GR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bO\u0010&R\u0014\u0010\u001e\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010&R\u0014\u0010\u001d\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010&R\u001a\u0010R\u001a\u00020S8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010\u001c\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010&R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0012\u0010Y\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010&\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006^"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "firstVisibleLineScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "remeasureNeeded", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "slotsPerLine", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "visibleItemsInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;IZFLandroidx/compose/ui/layout/MeasureResult;ZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function1;Ljava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;II)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleLine", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getFirstVisibleLineScrollOffset", "setFirstVisibleLineScrollOffset", "(I)V", "height", "getHeight", "getMainAxisItemSpacing", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getPrefetchInfoRetriever", "()Lkotlin/jvm/functions/Function1;", "getRemeasureNeeded", "getReverseLayout", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "getSlotsPerLine", "getTotalItemsCount", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasureResult.kt */
public final class LazyGridMeasureResult implements LazyGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final LazyGridMeasuredLine firstVisibleLine;
    private int firstVisibleLineScrollOffset;
    private final int mainAxisItemSpacing;
    private final Orientation orientation;
    private final Function1<Integer, List<Pair<Integer, Constraints>>> prefetchInfoRetriever;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final int slotsPerLine;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<LazyGridMeasuredItem> visibleItemsInfo;

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    public LazyGridMeasureResult(LazyGridMeasuredLine lazyGridMeasuredLine, int i, boolean z, float f, MeasureResult measureResult, boolean z2, CoroutineScope coroutineScope2, Density density2, int i2, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, List<LazyGridMeasuredItem> list, int i3, int i4, int i5, boolean z3, Orientation orientation2, int i6, int i7) {
        this.firstVisibleLine = lazyGridMeasuredLine;
        this.firstVisibleLineScrollOffset = i;
        this.canScrollForward = z;
        this.consumedScroll = f;
        this.remeasureNeeded = z2;
        this.coroutineScope = coroutineScope2;
        this.density = density2;
        this.slotsPerLine = i2;
        this.prefetchInfoRetriever = function1;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i3;
        this.viewportEndOffset = i4;
        this.totalItemsCount = i5;
        this.reverseLayout = z3;
        this.orientation = orientation2;
        this.afterContentPadding = i6;
        this.mainAxisItemSpacing = i7;
        this.$$delegate_0 = measureResult;
    }

    public final LazyGridMeasuredLine getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    public final int getFirstVisibleLineScrollOffset() {
        return this.firstVisibleLineScrollOffset;
    }

    public final void setFirstVisibleLineScrollOffset(int i) {
        this.firstVisibleLineScrollOffset = i;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final void setCanScrollForward(boolean z) {
        this.canScrollForward = z;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final void setConsumedScroll(float f) {
        this.consumedScroll = f;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final Function1<Integer, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever() {
        return this.prefetchInfoRetriever;
    }

    public List<LazyGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final boolean getCanScrollBackward() {
        LazyGridMeasuredLine lazyGridMeasuredLine = this.firstVisibleLine;
        return ((lazyGridMeasuredLine != null ? lazyGridMeasuredLine.getIndex() : 0) == 0 && this.firstVisibleLineScrollOffset == 0) ? false : true;
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m952getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean tryToApplyScrollWithoutRemeasure(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.remeasureNeeded
            r1 = 0
            if (r0 != 0) goto L_0x00bf
            java.util.List r0 = r5.getVisibleItemsInfo()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00bf
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r0 = r5.firstVisibleLine
            if (r0 == 0) goto L_0x00bf
            int r0 = r0.getMainAxisSizeWithSpacings()
            int r2 = r5.firstVisibleLineScrollOffset
            int r2 = r2 - r6
            if (r2 < 0) goto L_0x00bf
            if (r2 >= r0) goto L_0x00bf
            java.util.List r0 = r5.getVisibleItemsInfo()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r0)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r0 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r0
            java.util.List r2 = r5.getVisibleItemsInfo()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.last(r2)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r2 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r2
            boolean r3 = r0.getNonScrollableItem()
            if (r3 != 0) goto L_0x00bf
            boolean r3 = r2.getNonScrollableItem()
            if (r3 == 0) goto L_0x0040
            goto L_0x00bf
        L_0x0040:
            if (r6 >= 0) goto L_0x0074
            r3 = r0
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r3 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r3
            androidx.compose.foundation.gestures.Orientation r4 = r5.getOrientation()
            int r3 = androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r3, r4)
            int r0 = r0.getMainAxisSizeWithSpacings()
            int r3 = r3 + r0
            int r0 = r5.getViewportStartOffset()
            int r3 = r3 - r0
            r0 = r2
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r0 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r0
            androidx.compose.foundation.gestures.Orientation r4 = r5.getOrientation()
            int r0 = androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r0, r4)
            int r2 = r2.getMainAxisSizeWithSpacings()
            int r0 = r0 + r2
            int r2 = r5.getViewportEndOffset()
            int r0 = r0 - r2
            int r0 = java.lang.Math.min(r3, r0)
            int r2 = -r6
            if (r0 <= r2) goto L_0x00bf
            goto L_0x0098
        L_0x0074:
            int r3 = r5.getViewportStartOffset()
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r0 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r0
            androidx.compose.foundation.gestures.Orientation r4 = r5.getOrientation()
            int r0 = androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r0, r4)
            int r3 = r3 - r0
            int r0 = r5.getViewportEndOffset()
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r2 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r2
            androidx.compose.foundation.gestures.Orientation r4 = r5.getOrientation()
            int r2 = androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r2, r4)
            int r0 = r0 - r2
            int r0 = java.lang.Math.min(r3, r0)
            if (r0 <= r6) goto L_0x00bf
        L_0x0098:
            int r0 = r5.firstVisibleLineScrollOffset
            int r0 = r0 - r6
            r5.firstVisibleLineScrollOffset = r0
            java.util.List r0 = r5.getVisibleItemsInfo()
            int r2 = r0.size()
        L_0x00a5:
            if (r1 >= r2) goto L_0x00b3
            java.lang.Object r3 = r0.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r3 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r3
            r3.applyScrollDelta(r6)
            int r1 = r1 + 1
            goto L_0x00a5
        L_0x00b3:
            float r0 = (float) r6
            r5.consumedScroll = r0
            boolean r0 = r5.canScrollForward
            r1 = 1
            if (r0 != 0) goto L_0x00bf
            if (r6 <= 0) goto L_0x00bf
            r5.canScrollForward = r1
        L_0x00bf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureResult.tryToApplyScrollWithoutRemeasure(int):boolean");
    }
}
