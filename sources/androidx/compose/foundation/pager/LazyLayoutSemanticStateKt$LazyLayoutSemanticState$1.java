package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u0014"}, d2 = {"androidx/compose/foundation/pager/LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "contentPadding", "", "getContentPadding", "()I", "maxScrollOffset", "", "getMaxScrollOffset", "()F", "scrollOffset", "getScrollOffset", "viewport", "getViewport", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "scrollToItem", "", "index", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemanticState.kt */
public final class LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 implements LazyLayoutSemanticState {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ PagerState $state;

    LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1(PagerState pagerState, boolean z) {
        this.$state = pagerState;
        this.$isVertical = z;
    }

    public float getScrollOffset() {
        return (float) PagerScrollPositionKt.currentAbsoluteScrollOffset(this.$state);
    }

    public float getMaxScrollOffset() {
        return (float) PagerStateKt.calculateNewMaxScrollOffset(this.$state.getLayoutInfo(), this.$state.getPageCount());
    }

    public Object scrollToItem(int i, Continuation<? super Unit> continuation) {
        Object scrollToPage$default = PagerState.scrollToPage$default(this.$state, i, 0.0f, continuation, 2, (Object) null);
        return scrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToPage$default : Unit.INSTANCE;
    }

    public CollectionInfo collectionInfo() {
        if (this.$isVertical) {
            return new CollectionInfo(this.$state.getPageCount(), 1);
        }
        return new CollectionInfo(1, this.$state.getPageCount());
    }

    public int getViewport() {
        if (this.$state.getLayoutInfo().getOrientation() == Orientation.Vertical) {
            return IntSize.m7282getHeightimpl(this.$state.getLayoutInfo().m1095getViewportSizeYbymL2g());
        }
        return IntSize.m7283getWidthimpl(this.$state.getLayoutInfo().m1095getViewportSizeYbymL2g());
    }

    public int getContentPadding() {
        return this.$state.getLayoutInfo().getBeforeContentPadding() + this.$state.getLayoutInfo().getAfterContentPadding();
    }
}
