package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002J\u0016\u0010(\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u0018\u0010*\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020)2\u0006\u0010#\u001a\u00020\u0003J\u0018\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u0010\u0017\u001a\u00020\u0003H\u0007R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR+\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001e\u0010#\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019¨\u00062"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "", "initialIndices", "", "initialOffsets", "fillIndices", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "targetIndex", "laneCount", "([I[ILkotlin/jvm/functions/Function2;)V", "hadFirstNotEmptyLayout", "", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "indices", "getIndices", "()[I", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "scrollOffsets", "getScrollOffsets", "calculateFirstVisibleIndex", "calculateFirstVisibleScrollOffset", "offsets", "requestPositionAndForgetLastKnownKey", "", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "updateScrollOffset", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridScrollPosition.kt */
public final class LazyStaggeredGridScrollPosition {
    public static final int $stable = 8;
    private final Function2<Integer, Integer, int[]> fillIndices;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private int[] indices;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;
    private int[] scrollOffsets;

    public LazyStaggeredGridScrollPosition(int[] iArr, int[] iArr2, Function2<? super Integer, ? super Integer, int[]> function2) {
        this.fillIndices = function2;
        this.indices = iArr;
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(calculateFirstVisibleIndex(iArr));
        this.scrollOffsets = iArr2;
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(calculateFirstVisibleScrollOffset(iArr, iArr2));
        Integer minOrNull = ArraysKt.minOrNull(iArr);
        this.nearestRangeState = new LazyLayoutNearestRangeState(minOrNull != null ? minOrNull.intValue() : 0, 90, 200);
    }

    public final int[] getIndices() {
        return this.indices;
    }

    private final void setIndex(int i) {
        this.index$delegate.setIntValue(i);
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    public final int[] getScrollOffsets() {
        return this.scrollOffsets;
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setIntValue(i);
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    private final int calculateFirstVisibleScrollOffset(int[] iArr, int[] iArr2) {
        int calculateFirstVisibleIndex = calculateFirstVisibleIndex(iArr);
        int length = iArr2.length;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < length; i2++) {
            if (iArr[i2] == calculateFirstVisibleIndex) {
                i = Math.min(i, iArr2[i2]);
            }
        }
        if (i == Integer.MAX_VALUE) {
            return 0;
        }
        return i;
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateFromMeasureResult(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r8) {
        /*
            r7 = this;
            int[] r0 = r8.getFirstVisibleItemIndices()
            int r0 = r7.calculateFirstVisibleIndex(r0)
            java.util.List r1 = r8.getVisibleItemsInfo()
            int r2 = r1.size()
            r3 = 0
        L_0x0011:
            r4 = 0
            if (r3 >= r2) goto L_0x0025
            java.lang.Object r5 = r1.get(r3)
            r6 = r5
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r6 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r6
            int r6 = r6.getIndex()
            if (r6 != r0) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x0025:
            r5 = r4
        L_0x0026:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r5 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r5
            if (r5 == 0) goto L_0x002f
            java.lang.Object r1 = r5.getKey()
            goto L_0x0030
        L_0x002f:
            r1 = r4
        L_0x0030:
            r7.lastKnownFirstItemKey = r1
            androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState r1 = r7.nearestRangeState
            r1.update(r0)
            boolean r0 = r7.hadFirstNotEmptyLayout
            if (r0 != 0) goto L_0x0043
            int r0 = r8.getTotalItemsCount()
            if (r0 <= 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            return
        L_0x0043:
            r0 = 1
            r7.hadFirstNotEmptyLayout = r0
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.snapshots.Snapshot r1 = r0.getCurrentThreadSnapshot()
            if (r1 == 0) goto L_0x0052
            kotlin.jvm.functions.Function1 r4 = r1.getReadObserver()
        L_0x0052:
            androidx.compose.runtime.snapshots.Snapshot r2 = r0.makeCurrentNonObservable(r1)
            int[] r3 = r8.getFirstVisibleItemIndices()     // Catch:{ all -> 0x0067 }
            int[] r8 = r8.getFirstVisibleItemScrollOffsets()     // Catch:{ all -> 0x0067 }
            r7.update(r3, r8)     // Catch:{ all -> 0x0067 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0067 }
            r0.restoreNonObservable(r1, r2, r4)
            return
        L_0x0067:
            r8 = move-exception
            r0.restoreNonObservable(r1, r2, r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScrollPosition.updateFromMeasureResult(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult):void");
    }

    public final void updateScrollOffset(int[] iArr) {
        this.scrollOffsets = iArr;
        setScrollOffset(calculateFirstVisibleScrollOffset(this.indices, iArr));
    }

    public final void requestPositionAndForgetLastKnownKey(int i, int i2) {
        int[] invoke = this.fillIndices.invoke(Integer.valueOf(i), Integer.valueOf(this.indices.length));
        int length = invoke.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = i2;
        }
        update(invoke, iArr);
        this.nearestRangeState.update(i);
        this.lastKnownFirstItemKey = null;
    }

    /* JADX INFO: finally extract failed */
    public final int[] updateScrollPositionIfTheFirstItemWasMoved(LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr) {
        Object obj = this.lastKnownFirstItemKey;
        int i = 0;
        Integer orNull = ArraysKt.getOrNull(iArr, 0);
        if (orNull != null) {
            i = orNull.intValue();
        }
        int findIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(lazyLayoutItemProvider, obj, i);
        if (ArraysKt.contains(iArr, findIndexByKey)) {
            return iArr;
        }
        this.nearestRangeState.update(findIndexByKey);
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int[] invoke = this.fillIndices.invoke(Integer.valueOf(findIndexByKey), Integer.valueOf(iArr.length));
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            this.indices = invoke;
            setIndex(calculateFirstVisibleIndex(invoke));
            return invoke;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    private final void update(int[] iArr, int[] iArr2) {
        this.indices = iArr;
        setIndex(calculateFirstVisibleIndex(iArr));
        this.scrollOffsets = iArr2;
        setScrollOffset(calculateFirstVisibleScrollOffset(iArr, iArr2));
    }

    private final int calculateFirstVisibleIndex(int[] iArr) {
        int i = Integer.MAX_VALUE;
        for (int i2 : iArr) {
            if (i2 <= 0) {
                return 0;
            }
            if (i > i2) {
                i = i2;
            }
        }
        if (i == Integer.MAX_VALUE) {
            return 0;
        }
        return i;
    }
}
