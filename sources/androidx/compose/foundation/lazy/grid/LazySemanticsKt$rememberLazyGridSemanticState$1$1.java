package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u0014"}, d2 = {"androidx/compose/foundation/lazy/grid/LazySemanticsKt$rememberLazyGridSemanticState$1$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "contentPadding", "", "getContentPadding", "()I", "maxScrollOffset", "", "getMaxScrollOffset", "()F", "scrollOffset", "getScrollOffset", "viewport", "getViewport", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "scrollToItem", "", "index", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySemantics.kt */
public final class LazySemanticsKt$rememberLazyGridSemanticState$1$1 implements LazyLayoutSemanticState {
    final /* synthetic */ LazyGridState $state;

    LazySemanticsKt$rememberLazyGridSemanticState$1$1(LazyGridState lazyGridState) {
        this.$state = lazyGridState;
    }

    public float getScrollOffset() {
        return LazyLayoutSemanticsKt.estimatedLazyScrollOffset(this.$state.getFirstVisibleItemIndex(), this.$state.getFirstVisibleItemScrollOffset());
    }

    public float getMaxScrollOffset() {
        return LazyLayoutSemanticsKt.estimatedLazyMaxScrollOffset(this.$state.getFirstVisibleItemIndex(), this.$state.getFirstVisibleItemScrollOffset(), this.$state.getCanScrollForward());
    }

    public Object scrollToItem(int i, Continuation<? super Unit> continuation) {
        Object scrollToItem$default = LazyGridState.scrollToItem$default(this.$state, i, 0, continuation, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }

    public CollectionInfo collectionInfo() {
        return new CollectionInfo(-1, -1);
    }

    public int getViewport() {
        if (this.$state.getLayoutInfo().getOrientation() == Orientation.Vertical) {
            return IntSize.m7282getHeightimpl(this.$state.getLayoutInfo().m950getViewportSizeYbymL2g());
        }
        return IntSize.m7283getWidthimpl(this.$state.getLayoutInfo().m950getViewportSizeYbymL2g());
    }

    public int getContentPadding() {
        return this.$state.getLayoutInfo().getBeforeContentPadding() + this.$state.getLayoutInfo().getAfterContentPadding();
    }
}
