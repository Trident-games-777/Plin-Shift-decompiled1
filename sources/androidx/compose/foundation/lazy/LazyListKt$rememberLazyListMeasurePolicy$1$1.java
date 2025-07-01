package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "containerConstraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/lazy/LazyListMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> {
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyListItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ boolean $stickyHeadersEnabled;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1(LazyListState lazyListState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyListItemProvider> function0, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z3, int i, CoroutineScope coroutineScope, GraphicsContext graphicsContext, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2) {
        super(2);
        this.$state = lazyListState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$stickyHeadersEnabled = z3;
        this.$beyondBoundsItemCount = i;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m908invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m7058unboximpl());
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyListMeasureResult m908invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long j2;
        float f2;
        List<Integer> list;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        ObservableScopeInvalidator.m1018attachToScopeimpl(this.$state.m926getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        boolean z = this.$state.getHasLookaheadPassOccurred$foundation_release() || lazyLayoutMeasureScope2.isLookingAhead();
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
        int r6 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m792calculateTopPaddingD9Ej5fM());
        int r7 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m789calculateBottomPaddingD9Ej5fM());
        int i5 = r6 + r7;
        int i6 = i + i2;
        boolean z2 = this.$isVertical;
        int i7 = z2 ? i5 : i6;
        if (z2 && !this.$reverseLayout) {
            i3 = r6;
        } else if (!z2 || !this.$reverseLayout) {
            i3 = (z2 || this.$reverseLayout) ? i2 : i;
        } else {
            i3 = r7;
        }
        int i8 = i7 - i3;
        long r11 = ConstraintsKt.m7071offsetNN6EwU(j3, -i6, -i5);
        LazyListItemProvider invoke = this.$itemProviderLambda.invoke();
        invoke.getItemScope().setMaxSize(Constraints.m7052getMaxWidthimpl(r11), Constraints.m7051getMaxHeightimpl(r11));
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
                throw new IllegalArgumentException("null horizontalAlignment when isVertical == false".toString());
            }
        }
        int r72 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(f);
        int i9 = i5;
        int itemCount = invoke.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.m7051getMaxHeightimpl(j3) - i9;
        } else {
            i4 = Constraints.m7052getMaxWidthimpl(j3) - i6;
        }
        int i10 = i4;
        if (!this.$reverseLayout || i10 > 0) {
            j2 = IntOffsetKt.IntOffset(i, r6);
        } else {
            boolean z3 = this.$isVertical;
            if (!z3) {
                i += i10;
            }
            if (z3) {
                r6 += i10;
            }
            j2 = IntOffsetKt.IntOffset(i, r6);
        }
        LazyListItemProvider lazyListItemProvider = invoke;
        long j4 = r11;
        int i11 = i9;
        int i12 = i6;
        int i13 = r72;
        LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(j4, this.$isVertical, lazyListItemProvider, lazyLayoutMeasureScope, itemCount, i13, this.$horizontalAlignment, this.$verticalAlignment, this.$reverseLayout, i3, i8, j2, this.$state);
        long j5 = j4;
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider, lazyListState.getFirstVisibleItemIndex());
            int firstVisibleItemScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
            if (lazyLayoutMeasureScope.isLookingAhead() || !z) {
                f2 = this.$state.getScrollToBeConsumed$foundation_release();
            } else {
                f2 = this.$state.getScrollDeltaBetweenPasses$foundation_release();
            }
            float f3 = f2;
            if (this.$stickyHeadersEnabled) {
                list = lazyListItemProvider.getHeaderIndexes();
            } else {
                list = CollectionsKt.emptyList();
            }
            int i14 = i3;
            boolean z4 = this.$isVertical;
            int i15 = itemCount;
            int i16 = updateScrollPositionIfTheFirstItemWasMoved$foundation_release;
            LazyListMeasuredItemProvider lazyListMeasuredItemProvider = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
            int i17 = i15;
            LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            int i18 = i10;
            int i19 = i14;
            LazyListMeasureResult r34 = LazyListMeasureKt.m913measureLazyListx0Ok8Vo(i17, lazyListMeasuredItemProvider2, i18, i19, i8, i13, i16, firstVisibleItemScrollOffset, f3, j5, z4, list, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$state.getItemAnimator$foundation_release(), this.$beyondBoundsItemCount, calculateLazyLayoutPinnedIndices, z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getPostLookaheadLayoutInfo$foundation_release(), this.$coroutineScope, this.$state.m927getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, new LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1(lazyLayoutMeasureScope, j, i12, i11));
            LazyListState.applyMeasureResult$foundation_release$default(this.$state, r34, lazyLayoutMeasureScope.isLookingAhead(), false, 4, (Object) null);
            return r34;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
