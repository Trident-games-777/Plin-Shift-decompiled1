package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
final class LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Function0<LazyStaggeredGridItemProvider> $itemProviderLambda;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridStaggeredGridSlotsProvider $slots;
    final /* synthetic */ LazyStaggeredGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Function0<? extends LazyStaggeredGridItemProvider> function0, PaddingValues paddingValues, boolean z, float f, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        super(2);
        this.$state = lazyStaggeredGridState;
        this.$orientation = orientation;
        this.$slots = lazyGridStaggeredGridSlotsProvider;
        this.$itemProviderLambda = function0;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$mainAxisSpacing = f;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1057invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m7058unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyStaggeredGridMeasureResult m1057invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        long j2;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        ObservableScopeInvalidator.m1018attachToScopeimpl(this.$state.m1071getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        CheckScrollableContainerConstraintsKt.m276checkScrollableContainerConstraintsK40F9xA(j3, this.$orientation);
        LazyStaggeredGridSlots r10 = this.$slots.m1038invoke0kLqBqw(lazyLayoutMeasureScope2, j3);
        boolean z = this.$orientation == Orientation.Vertical;
        LazyStaggeredGridItemProvider invoke = this.$itemProviderLambda.invoke();
        int r14 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(this.$contentPadding, this.$orientation, this.$reverseLayout, lazyLayoutMeasureScope2.getLayoutDirection()));
        int r15 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(this.$contentPadding, this.$orientation, this.$reverseLayout, lazyLayoutMeasureScope2.getLayoutDirection()));
        int r4 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(this.$contentPadding, this.$orientation, lazyLayoutMeasureScope2.getLayoutDirection()));
        int r16 = ((z ? Constraints.m7051getMaxHeightimpl(j3) : Constraints.m7052getMaxWidthimpl(j3)) - r14) - r15;
        if (z) {
            j2 = IntOffsetKt.IntOffset(r4, r14);
        } else {
            j2 = IntOffsetKt.IntOffset(r14, r4);
        }
        long j4 = j2;
        PaddingValues paddingValues = this.$contentPadding;
        int r42 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope2.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope2.getLayoutDirection())));
        PaddingValues paddingValues2 = this.$contentPadding;
        int r5 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(paddingValues2.m792calculateTopPaddingD9Ej5fM() + paddingValues2.m789calculateBottomPaddingD9Ej5fM()));
        List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
        long r6 = Constraints.m7043copyZbe2FdA$default(j3, ConstraintsKt.m7069constrainWidthK40F9xA(j3, r42), 0, ConstraintsKt.m7068constrainHeightK40F9xA(j3, r5), 0, 10, (Object) null);
        LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider = invoke;
        int r13 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$mainAxisSpacing);
        boolean z2 = z;
        LazyStaggeredGridMeasureResult r1 = LazyStaggeredGridMeasureKt.m1055measureStaggeredGridXtK8cYQ(lazyLayoutMeasureScope2, this.$state, calculateLazyLayoutPinnedIndices, lazyStaggeredGridItemProvider, r10, r6, z2, this.$reverseLayout, j4, r16, r13, r14, r15, this.$coroutineScope, this.$graphicsContext);
        LazyStaggeredGridState.applyMeasureResult$foundation_release$default(this.$state, r1, false, 2, (Object) null);
        return r1;
    }
}
