package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u001c\u0010\u000f\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/grid/DefaultLazyGridPrefetchStrategy;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "nestedPrefetchItemCount", "", "(I)V", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineToPrefetch", "wasScrollingForward", "", "onNestedPrefetch", "", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "onScroll", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "delta", "", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "onVisibleItemsUpdated", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridPrefetchStrategy.kt */
final class DefaultLazyGridPrefetchStrategy implements LazyGridPrefetchStrategy {
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;
    private int lineToPrefetch;
    private final int nestedPrefetchItemCount;
    private boolean wasScrollingForward;

    public DefaultLazyGridPrefetchStrategy() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public DefaultLazyGridPrefetchStrategy(int i) {
        this.nestedPrefetchItemCount = i;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector<>(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultLazyGridPrefetchStrategy(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i);
    }

    public void onScroll(LazyGridPrefetchScope lazyGridPrefetchScope, float f, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int i;
        int i2;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector;
        int size;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector2;
        int size2;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector3;
        int size3;
        if (!lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            int i3 = 0;
            boolean z = f < 0.0f;
            if (z) {
                LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo());
                i2 = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn()) + 1;
                i = ((LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo())).getIndex() + 1;
            } else {
                LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo());
                i2 = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo2.getRow() : lazyGridItemInfo2.getColumn()) - 1;
                i = ((LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo())).getIndex() - 1;
            }
            if (i >= 0 && i < lazyGridLayoutInfo.getTotalItemsCount()) {
                if (i2 != this.lineToPrefetch) {
                    if (this.wasScrollingForward == z || (size3 = mutableVector3.getSize()) <= 0) {
                        this.wasScrollingForward = z;
                        this.lineToPrefetch = i2;
                        this.currentLinePrefetchHandles.clear();
                        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector4 = this.currentLinePrefetchHandles;
                        mutableVector4.addAll(mutableVector4.getSize(), (List<? extends LazyLayoutPrefetchState.PrefetchHandle>) lazyGridPrefetchScope.scheduleLinePrefetch(i2));
                    } else {
                        Object[] content = (mutableVector3 = this.currentLinePrefetchHandles).getContent();
                        int i4 = 0;
                        do {
                            ((LazyLayoutPrefetchState.PrefetchHandle) content[i4]).cancel();
                            i4++;
                        } while (i4 < size3);
                        this.wasScrollingForward = z;
                        this.lineToPrefetch = i2;
                        this.currentLinePrefetchHandles.clear();
                        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector42 = this.currentLinePrefetchHandles;
                        mutableVector42.addAll(mutableVector42.getSize(), (List<? extends LazyLayoutPrefetchState.PrefetchHandle>) lazyGridPrefetchScope.scheduleLinePrefetch(i2));
                    }
                }
                if (z) {
                    LazyGridItemInfo lazyGridItemInfo3 = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo());
                    if (((float) (((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation()) + LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation())) + lazyGridLayoutInfo.getMainAxisItemSpacing()) - lazyGridLayoutInfo.getViewportEndOffset())) < (-f) && (size2 = mutableVector2.getSize()) > 0) {
                        Object[] content2 = (mutableVector2 = this.currentLinePrefetchHandles).getContent();
                        do {
                            ((LazyLayoutPrefetchState.PrefetchHandle) content2[i3]).markAsUrgent();
                            i3++;
                        } while (i3 < size2);
                    }
                } else if (((float) (lazyGridLayoutInfo.getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis((LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo()), lazyGridLayoutInfo.getOrientation()))) < f && (size = mutableVector.getSize()) > 0) {
                    Object[] content3 = (mutableVector = this.currentLinePrefetchHandles).getContent();
                    do {
                        ((LazyLayoutPrefetchState.PrefetchHandle) content3[i3]).markAsUrgent();
                        i3++;
                    } while (i3 < size);
                }
            }
        }
    }

    public void onVisibleItemsUpdated(LazyGridPrefetchScope lazyGridPrefetchScope, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int i;
        if (this.lineToPrefetch != -1 && !lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            if (this.wasScrollingForward) {
                LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo());
                i = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn()) + 1;
            } else {
                LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo());
                i = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo2.getRow() : lazyGridItemInfo2.getColumn()) - 1;
            }
            if (this.lineToPrefetch != i) {
                this.lineToPrefetch = -1;
                MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector = this.currentLinePrefetchHandles;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i2 = 0;
                    do {
                        ((LazyLayoutPrefetchState.PrefetchHandle) content[i2]).cancel();
                        i2++;
                    } while (i2 < size);
                }
                this.currentLinePrefetchHandles.clear();
            }
        }
    }

    public void onNestedPrefetch(NestedPrefetchScope nestedPrefetchScope, int i) {
        int i2 = this.nestedPrefetchItemCount;
        for (int i3 = 0; i3 < i2; i3++) {
            nestedPrefetchScope.schedulePrefetch(i + i3);
        }
    }
}
