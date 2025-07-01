package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "composedVisibleItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "headerIndexes", "", "", "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListHeaders.kt */
public final class LazyListHeadersKt {
    public static final LazyListMeasuredItem findOrComposeLazyListHeader(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, List<Integer> list2, int i, int i2, int i3) {
        List<LazyListMeasuredItem> list3 = list;
        List<Integer> list4 = list2;
        int i4 = i;
        int index = ((LazyListMeasuredItem) CollectionsKt.first(list3)).getIndex();
        int size = list4.size();
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        while (i7 < size && list4.get(i7).intValue() <= index) {
            i6 = list4.get(i7).intValue();
            i7++;
            i5 = ((i7 < 0 || i7 > CollectionsKt.getLastIndex(list4)) ? -1 : list4.get(i7)).intValue();
        }
        int size2 = list3.size();
        int i8 = Integer.MIN_VALUE;
        int i9 = Integer.MIN_VALUE;
        int i10 = -1;
        for (int i11 = 0; i11 < size2; i11++) {
            LazyListMeasuredItem lazyListMeasuredItem = list3.get(i11);
            if (lazyListMeasuredItem.getIndex() == i6) {
                i8 = lazyListMeasuredItem.getOffset();
                i10 = i11;
            } else if (lazyListMeasuredItem.getIndex() == i5) {
                i9 = lazyListMeasuredItem.getOffset();
            }
        }
        if (i6 == -1) {
            return null;
        }
        LazyListMeasuredItem r1 = LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i6, 0, 2, (Object) null);
        r1.setNonScrollableItem(true);
        int max = i8 != Integer.MIN_VALUE ? Math.max(-i4, i8) : -i4;
        if (i9 != Integer.MIN_VALUE) {
            max = Math.min(max, i9 - r1.getSize());
        }
        r1.position(max, i2, i3);
        if (i10 != -1) {
            list3.set(i10, r1);
            return r1;
        }
        list3.add(0, r1);
        return r1;
    }
}
