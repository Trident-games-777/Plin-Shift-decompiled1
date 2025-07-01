package androidx.compose.foundation.pager;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "containerConstraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/pager/PagerMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasurePolicy.kt */
final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> {
    final /* synthetic */ int $beyondViewportPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ SnapPosition $snapPosition;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(PagerState pagerState, Orientation orientation, PaddingValues paddingValues, boolean z, float f, PageSize pageSize, Function0<PagerLazyLayoutItemProvider> function0, Function0<Integer> function02, Alignment.Vertical vertical, Alignment.Horizontal horizontal, int i, SnapPosition snapPosition, CoroutineScope coroutineScope) {
        super(2);
        this.$state = pagerState;
        this.$orientation = orientation;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$pageSpacing = f;
        this.$pageSize = pageSize;
        this.$itemProviderLambda = function0;
        this.$pageCount = function02;
        this.$verticalAlignment = vertical;
        this.$horizontalAlignment = horizontal;
        this.$beyondViewportPageCount = i;
        this.$snapPosition = snapPosition;
        this.$coroutineScope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1100invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m7058unboximpl());
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final PagerMeasureResult m1100invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        int i2;
        int i3;
        int i4;
        long j2;
        int i5;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        ObservableScopeInvalidator.m1018attachToScopeimpl(this.$state.m1102getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        boolean z = this.$orientation == Orientation.Vertical;
        CheckScrollableContainerConstraintsKt.m276checkScrollableContainerConstraintsK40F9xA(j3, z ? Orientation.Vertical : Orientation.Horizontal);
        if (z) {
            i = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m790calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope2.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope2.getLayoutDirection()));
        }
        if (z) {
            i2 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m791calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope2.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope2.getLayoutDirection()));
        }
        int r7 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m792calculateTopPaddingD9Ej5fM());
        int r9 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$contentPadding.m789calculateBottomPaddingD9Ej5fM());
        int i6 = r7 + r9;
        int i7 = i2;
        int i8 = i + i7;
        int i9 = z ? i6 : i8;
        if (z && !this.$reverseLayout) {
            i3 = r7;
        } else if (!z || !this.$reverseLayout) {
            i3 = (z || this.$reverseLayout) ? i7 : i;
        } else {
            i3 = r9;
        }
        int i10 = i9 - i3;
        long r11 = ConstraintsKt.m7071offsetNN6EwU(j3, -i8, -i6);
        Density density = lazyLayoutMeasureScope2;
        this.$state.setDensity$foundation_release(density);
        int r92 = lazyLayoutMeasureScope2.m7086roundToPx0680j_4(this.$pageSpacing);
        if (z) {
            i4 = Constraints.m7051getMaxHeightimpl(j3) - i6;
        } else {
            i4 = Constraints.m7052getMaxWidthimpl(j3) - i8;
        }
        if (!this.$reverseLayout || i4 > 0) {
            j2 = IntOffsetKt.IntOffset(i, r7);
        } else {
            if (!z) {
                i += i4;
            }
            if (z) {
                r7 += i4;
            }
            j2 = IntOffsetKt.IntOffset(i, r7);
        }
        long j4 = j2;
        int coerceAtLeast = RangesKt.coerceAtLeast(this.$pageSize.calculateMainAxisPageSize(density, i4, r92), 0);
        PagerState pagerState = this.$state;
        int r25 = this.$orientation == Orientation.Vertical ? Constraints.m7052getMaxWidthimpl(r11) : coerceAtLeast;
        if (this.$orientation != Orientation.Vertical) {
            i5 = Constraints.m7051getMaxHeightimpl(r11);
        } else {
            i5 = coerceAtLeast;
        }
        int i11 = r92;
        pagerState.m1106setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, r25, 0, i5, 5, (Object) null));
        PagerLazyLayoutItemProvider invoke = this.$itemProviderLambda.invoke();
        Snapshot.Companion companion = Snapshot.Companion;
        PagerState pagerState2 = this.$state;
        SnapPosition snapPosition = this.$snapPosition;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
            int currentPageOffset = PagerKt.currentPageOffset(snapPosition, i4, coerceAtLeast, i11, i3, i10, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, this.$state.getPinnedPages$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
            int intValue = this.$pageCount.invoke().intValue();
            int i12 = i11;
            int i13 = i4;
            LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
            PagerMeasureResult r2 = PagerMeasureKt.m1098measurePagerbmk8ZPk(lazyLayoutMeasureScope3, intValue, invoke, i13, i3, i10, i12, matchScrollPositionWithKey$foundation_release, currentPageOffset, r11, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, j4, coerceAtLeast, this.$beyondViewportPageCount, calculateLazyLayoutPinnedIndices, this.$snapPosition, this.$state.m1103getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$coroutineScope, new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1(lazyLayoutMeasureScope, j, i8, i6));
            PagerState.applyMeasureResult$foundation_release$default(this.$state, r2, false, 2, (Object) null);
            return r2;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
