package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001Jb\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"androidx/compose/foundation/lazy/grid/LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "createItem", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "index", "", "key", "", "contentType", "crossAxisSize", "mainAxisSpacing", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lane", "span", "createItem-O3s9Psw", "(ILjava/lang/Object;Ljava/lang/Object;IILjava/util/List;JII)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 extends LazyGridMeasuredItemProvider {
    final /* synthetic */ int $afterContentPadding;
    final /* synthetic */ int $beforeContentPadding;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ LazyLayoutMeasureScope $this_null;
    final /* synthetic */ long $visualItemOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(LazyGridItemProvider lazyGridItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, LazyGridState lazyGridState, boolean z, boolean z2, int i2, int i3, long j) {
        super(lazyGridItemProvider, lazyLayoutMeasureScope, i);
        this.$this_null = lazyLayoutMeasureScope;
        this.$state = lazyGridState;
        this.$isVertical = z;
        this.$reverseLayout = z2;
        this.$beforeContentPadding = i2;
        this.$afterContentPadding = i3;
        this.$visualItemOffset = j;
    }

    /* renamed from: createItem-O3s9Psw  reason: not valid java name */
    public LazyGridMeasuredItem m949createItemO3s9Psw(int i, Object obj, Object obj2, int i2, int i3, List<? extends Placeable> list, long j, int i4, int i5) {
        return new LazyGridMeasuredItem(i, obj, this.$isVertical, i2, i3, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, list, this.$visualItemOffset, obj2, this.$state.getItemAnimator$foundation_release(), j, i4, i5, (DefaultConstructorMarker) null);
    }
}
