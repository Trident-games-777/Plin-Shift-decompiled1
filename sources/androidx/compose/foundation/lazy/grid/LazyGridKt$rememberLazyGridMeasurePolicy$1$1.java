package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "containerConstraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyGridItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridSlotsProvider $slots;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1(LazyGridState lazyGridState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyGridItemProvider> function0, LazyGridSlotsProvider lazyGridSlotsProvider, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        super(2);
        this.$state = lazyGridState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$slots = lazyGridSlotsProvider;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m948invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m7058unboximpl());
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyGridMeasureResult m948invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long j2;
        int i5;
        int i6;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        ObservableScopeInvalidator.m1018attachToScopeimpl(this.$state.m965getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        CheckScrollableContainerConstraintsKt.m276checkScrollableContainerConstraintsK40F9xA(j3, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m790calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope2.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope2.getLayoutDirection()));
        }
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m791calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope2.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope2.getLayoutDirection()));
        }
        int r4 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m792calculateTopPaddingD9Ej5fM());
        int r5 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m789calculateBottomPaddingD9Ej5fM());
        int i7 = r4 + r5;
        int i8 = i + i2;
        boolean z = this.$isVertical;
        int i9 = z ? i7 : i8;
        if (z && !this.$reverseLayout) {
            i3 = r4;
        } else if (!z || !this.$reverseLayout) {
            i3 = (z || this.$reverseLayout) ? i2 : i;
        } else {
            i3 = r5;
        }
        int i10 = i9 - i3;
        long r26 = ConstraintsKt.m7071offsetNN6EwU(j3, -i8, -i7);
        LazyGridItemProvider invoke = this.$itemProviderLambda.invoke();
        LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
        Density density = lazyLayoutMeasureScope2;
        LazyGridSlots r30 = this.$slots.m964invoke0kLqBqw(density, j3);
        int length = r30.getSizes().length;
        spanLayoutProvider.setSlotsPerLine(length);
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                f = vertical.m645getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                f = horizontal.m631getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
            }
        }
        int r32 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(f);
        int itemCount = invoke.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.m7051getMaxHeightimpl(j3) - i7;
        } else {
            i4 = Constraints.m7052getMaxWidthimpl(j3) - i8;
        }
        int i11 = i4;
        if (!this.$reverseLayout || i11 > 0) {
            j2 = IntOffsetKt.IntOffset(i, r4);
        } else {
            boolean z2 = this.$isVertical;
            if (!z2) {
                i += i11;
            }
            if (z2) {
                r4 += i11;
            }
            j2 = IntOffsetKt.IntOffset(i, r4);
        }
        int i12 = i8;
        Density density2 = density;
        int i13 = length;
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = spanLayoutProvider;
        LazyGridItemProvider lazyGridItemProvider = invoke;
        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(lazyGridItemProvider, lazyLayoutMeasureScope2, r32, this.$state, this.$isVertical, this.$reverseLayout, i3, i10, j2);
        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(this.$isVertical, r30, itemCount, r32, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, lazyGridSpanLayoutProvider);
        int i14 = itemCount;
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider2 = lazyGridSpanLayoutProvider;
        Function1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1(lazyGridSpanLayoutProvider2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1);
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider, lazyGridState.getFirstVisibleItemIndex());
            if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= i14) {
                if (i14 > 0) {
                    i6 = lazyGridSpanLayoutProvider2.getLineIndexOfItem(i14 - 1);
                    i5 = 0;
                    int i15 = i6;
                    Unit unit = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
                    int i16 = i13;
                    Density density3 = density2;
                    int i17 = i14;
                    LazyGridMeasureResult r0 = LazyGridMeasureKt.m951measureLazyGridOZKpZRA(i17, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, i11, i3, i10, r32, i15, i5, this.$state.getScrollToBeConsumed$foundation_release(), r26, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, density3, this.$state.getItemAnimator$foundation_release(), i16, calculateLazyLayoutPinnedIndices, this.$coroutineScope, this.$state.m966getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1, new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1(lazyLayoutMeasureScope, j3, i12, i7));
                    LazyGridState.applyMeasureResult$foundation_release$default(this.$state, r0, false, 2, (Object) null);
                    return r0;
                }
            }
            i6 = lazyGridSpanLayoutProvider2.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
            i5 = lazyGridState.getFirstVisibleItemScrollOffset();
            int i152 = i6;
            Unit unit2 = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            List<Integer> calculateLazyLayoutPinnedIndices2 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
            int i162 = i13;
            Density density32 = density2;
            int i172 = i14;
            LazyGridMeasureResult r02 = LazyGridMeasureKt.m951measureLazyGridOZKpZRA(i172, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, i11, i3, i10, r32, i152, i5, this.$state.getScrollToBeConsumed$foundation_release(), r26, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, density32, this.$state.getItemAnimator$foundation_release(), i162, calculateLazyLayoutPinnedIndices2, this.$coroutineScope, this.$state.m966getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1, new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1(lazyLayoutMeasureScope, j3, i12, i7));
            LazyGridState.applyMeasureResult$foundation_release$default(this.$state, r02, false, 2, (Object) null);
            return r02;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
