package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J7\u0010\u0015\u001a\u00020\u00162'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0018¢\u0006\u0002\b\u001cH@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u0016*\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "calculateDistanceTo", "", "targetIndex", "calculateLineAverageMainAxisSize", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "index", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridAnimateScrollScope.kt */
public final class LazyGridAnimateScrollScope implements LazyLayoutAnimateScrollScope {
    public static final int $stable = 0;
    private final LazyGridState state;

    public LazyGridAnimateScrollScope(LazyGridState lazyGridState) {
        this.state = lazyGridState;
    }

    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    public int getLastVisibleItemIndex() {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return 0;
    }

    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    public void snapToItem(ScrollScope scrollScope, int i, int i2) {
        this.state.snapToItemIndexInternal$foundation_release(i, i2, true);
    }

    public float calculateDistanceTo(int i) {
        LazyGridItemInfo lazyGridItemInfo;
        int i2;
        LazyGridLayoutInfo layoutInfo = this.state.getLayoutInfo();
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        List<LazyGridItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                lazyGridItemInfo = null;
                break;
            }
            lazyGridItemInfo = visibleItemsInfo.get(i3);
            if (lazyGridItemInfo.getIndex() == i) {
                break;
            }
            i3++;
        }
        LazyGridItemInfo lazyGridItemInfo2 = lazyGridItemInfo;
        if (lazyGridItemInfo2 == null) {
            int slotsPerLine$foundation_release = this.state.getSlotsPerLine$foundation_release();
            int calculateLineAverageMainAxisSize = calculateLineAverageMainAxisSize(layoutInfo);
            int i4 = 1;
            if (i < getFirstVisibleItemIndex()) {
                z = true;
            }
            int firstVisibleItemIndex = i - getFirstVisibleItemIndex();
            int i5 = slotsPerLine$foundation_release - 1;
            if (z) {
                i4 = -1;
            }
            return ((float) (calculateLineAverageMainAxisSize * ((firstVisibleItemIndex + (i5 * i4)) / slotsPerLine$foundation_release))) - ((float) getFirstVisibleItemScrollOffset());
        }
        if (layoutInfo.getOrientation() == Orientation.Vertical) {
            i2 = IntOffset.m7242getYimpl(lazyGridItemInfo2.m946getOffsetnOccac());
        } else {
            i2 = IntOffset.m7241getXimpl(lazyGridItemInfo2.m946getOffsetnOccac());
        }
        return (float) i2;
    }

    private final int calculateLineAverageMainAxisSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        int i;
        boolean z = lazyGridLayoutInfo.getOrientation() == Orientation.Vertical;
        List<LazyGridItemInfo> visibleItemsInfo = lazyGridLayoutInfo.getVisibleItemsInfo();
        Function1 lazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1 = new LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1(z, visibleItemsInfo);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < visibleItemsInfo.size()) {
            int intValue = ((Number) lazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1.invoke(Integer.valueOf(i2))).intValue();
            if (intValue == -1) {
                i2++;
            } else {
                int i5 = 0;
                while (i2 < visibleItemsInfo.size() && ((Number) lazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1.invoke(Integer.valueOf(i2))).intValue() == intValue) {
                    if (z) {
                        i = IntSize.m7282getHeightimpl(visibleItemsInfo.get(i2).m947getSizeYbymL2g());
                    } else {
                        i = IntSize.m7283getWidthimpl(visibleItemsInfo.get(i2).m947getSizeYbymL2g());
                    }
                    i5 = Math.max(i5, i);
                    i2++;
                }
                i3 += i5;
                i4++;
            }
        }
        return (i3 / i4) + lazyGridLayoutInfo.getMainAxisItemSpacing();
    }

    public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this.state, (MutatePriority) null, function2, continuation, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }
}
