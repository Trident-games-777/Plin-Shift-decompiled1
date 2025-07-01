package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "executor", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "createNestedPrefetchRequest", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "createNestedPrefetchRequest-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "schedulePrefetch-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "HandleAndRequestImpl", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPrefetchState.kt */
public final class PrefetchHandleProvider {
    public static final int $stable = 8;
    private final PrefetchScheduler executor;
    /* access modifiers changed from: private */
    public final LazyLayoutItemContentFactory itemContentFactory;
    /* access modifiers changed from: private */
    public final SubcomposeLayoutState subcomposeLayoutState;

    public PrefetchHandleProvider(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState2, PrefetchScheduler prefetchScheduler) {
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeLayoutState = subcomposeLayoutState2;
        this.executor = prefetchScheduler;
    }

    /* renamed from: schedulePrefetch-VKLhPVY  reason: not valid java name */
    public final LazyLayoutPrefetchState.PrefetchHandle m1029schedulePrefetchVKLhPVY(int i, long j, PrefetchMetrics prefetchMetrics) {
        HandleAndRequestImpl handleAndRequestImpl = new HandleAndRequestImpl(this, i, j, prefetchMetrics, (DefaultConstructorMarker) null);
        this.executor.schedulePrefetch(handleAndRequestImpl);
        return handleAndRequestImpl;
    }

    /* renamed from: createNestedPrefetchRequest-VKLhPVY  reason: not valid java name */
    public final PrefetchRequest m1028createNestedPrefetchRequestVKLhPVY(int i, long j, PrefetchMetrics prefetchMetrics) {
        return new HandleAndRequestImpl(this, i, j, prefetchMetrics, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001'B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\f\u0018\u00010\u0014R\u00060\u0000R\u00020\u0015H\u0002J\b\u0010 \u001a\u00020!H\u0016J\f\u0010\"\u001a\u00020\f*\u00020#H\u0016J\u0014\u0010$\u001a\u00020\f*\u00020#2\u0006\u0010%\u001a\u00020&H\u0002R\u0016\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0013\u001a\f\u0018\u00010\u0014R\u00060\u0000R\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "hasResolvedNestedPrefetches", "", "isCanceled", "isComposed", "()Z", "isMeasured", "isUrgent", "isValid", "nestedPrefetchController", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "cancel", "", "markAsUrgent", "performComposition", "performMeasure", "performMeasure-BRTryo0", "(J)V", "resolveNestedPrefetchStates", "toString", "", "execute", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "shouldExecute", "average", "", "NestedPrefetchController", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutPrefetchState.kt */
    private final class HandleAndRequestImpl implements LazyLayoutPrefetchState.PrefetchHandle, PrefetchRequest {
        private final long constraints;
        private boolean hasResolvedNestedPrefetches;
        private final int index;
        /* access modifiers changed from: private */
        public boolean isCanceled;
        private boolean isMeasured;
        private boolean isUrgent;
        private NestedPrefetchController nestedPrefetchController;
        private SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;
        private final PrefetchMetrics prefetchMetrics;

        public /* synthetic */ HandleAndRequestImpl(PrefetchHandleProvider prefetchHandleProvider, int i, long j, PrefetchMetrics prefetchMetrics2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, j, prefetchMetrics2);
        }

        private HandleAndRequestImpl(int i, long j, PrefetchMetrics prefetchMetrics2) {
            this.index = i;
            this.constraints = j;
            this.prefetchMetrics = prefetchMetrics2;
        }

        private final boolean isComposed() {
            return this.precomposeHandle != null;
        }

        private final boolean isValid() {
            if (this.isCanceled) {
                return false;
            }
            int itemCount = PrefetchHandleProvider.this.itemContentFactory.getItemProvider().invoke().getItemCount();
            int i = this.index;
            return i >= 0 && i < itemCount;
        }

        public void cancel() {
            if (!this.isCanceled) {
                this.isCanceled = true;
                SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
                if (precomposedSlotHandle != null) {
                    precomposedSlotHandle.dispose();
                }
                this.precomposeHandle = null;
            }
        }

        public void markAsUrgent() {
            this.isUrgent = true;
        }

        private final boolean shouldExecute(PrefetchRequestScope prefetchRequestScope, long j) {
            long availableTimeNanos = prefetchRequestScope.availableTimeNanos();
            return (this.isUrgent && availableTimeNanos > 0) || j < availableTimeNanos;
        }

        /* JADX INFO: finally extract failed */
        public boolean execute(PrefetchRequestScope prefetchRequestScope) {
            long j;
            long j2;
            if (!isValid()) {
                return false;
            }
            Object contentType = PrefetchHandleProvider.this.itemContentFactory.getItemProvider().invoke().getContentType(this.index);
            if (!isComposed()) {
                if (contentType == null || !this.prefetchMetrics.getAverageCompositionTimeNanosByContentType().contains(contentType)) {
                    j2 = this.prefetchMetrics.getAverageCompositionTimeNanos();
                } else {
                    j2 = this.prefetchMetrics.getAverageCompositionTimeNanosByContentType().get(contentType);
                }
                if (!shouldExecute(prefetchRequestScope, j2)) {
                    return true;
                }
                PrefetchMetrics prefetchMetrics2 = this.prefetchMetrics;
                long nanoTime = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:compose");
                try {
                    performComposition();
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    if (contentType != null) {
                        prefetchMetrics2.getAverageCompositionTimeNanosByContentType().set(contentType, prefetchMetrics2.calculateAverageTime(nanoTime2, prefetchMetrics2.getAverageCompositionTimeNanosByContentType().getOrDefault(contentType, 0)));
                    }
                    prefetchMetrics2.averageCompositionTimeNanos = prefetchMetrics2.calculateAverageTime(nanoTime2, prefetchMetrics2.getAverageCompositionTimeNanos());
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            if (!this.isUrgent) {
                if (!this.hasResolvedNestedPrefetches) {
                    if (prefetchRequestScope.availableTimeNanos() <= 0) {
                        return true;
                    }
                    Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                    try {
                        this.nestedPrefetchController = resolveNestedPrefetchStates();
                        this.hasResolvedNestedPrefetches = true;
                        Unit unit2 = Unit.INSTANCE;
                    } finally {
                        Trace.endSection();
                    }
                }
                NestedPrefetchController nestedPrefetchController2 = this.nestedPrefetchController;
                if (nestedPrefetchController2 != null ? nestedPrefetchController2.executeNestedPrefetches(prefetchRequestScope) : false) {
                    return true;
                }
            }
            if (!this.isMeasured && !Constraints.m7056isZeroimpl(this.constraints)) {
                if (contentType == null || !this.prefetchMetrics.getAverageMeasureTimeNanosByContentType().contains(contentType)) {
                    j = this.prefetchMetrics.getAverageMeasureTimeNanos();
                } else {
                    j = this.prefetchMetrics.getAverageMeasureTimeNanosByContentType().get(contentType);
                }
                if (!shouldExecute(prefetchRequestScope, j)) {
                    return true;
                }
                PrefetchMetrics prefetchMetrics3 = this.prefetchMetrics;
                long nanoTime3 = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:measure");
                try {
                    m1030performMeasureBRTryo0(this.constraints);
                    Unit unit3 = Unit.INSTANCE;
                    Trace.endSection();
                    long nanoTime4 = System.nanoTime() - nanoTime3;
                    if (contentType != null) {
                        prefetchMetrics3.getAverageMeasureTimeNanosByContentType().set(contentType, prefetchMetrics3.calculateAverageTime(nanoTime4, prefetchMetrics3.getAverageMeasureTimeNanosByContentType().getOrDefault(contentType, 0)));
                    }
                    prefetchMetrics3.averageMeasureTimeNanos = prefetchMetrics3.calculateAverageTime(nanoTime4, prefetchMetrics3.getAverageMeasureTimeNanos());
                } catch (Throwable th2) {
                    Trace.endSection();
                    throw th2;
                }
            }
            return false;
        }

        private final void performComposition() {
            if (!isValid()) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performComposition()".toString());
            } else if (this.precomposeHandle == null) {
                LazyLayoutItemProvider invoke = PrefetchHandleProvider.this.itemContentFactory.getItemProvider().invoke();
                Object key = invoke.getKey(this.index);
                this.precomposeHandle = PrefetchHandleProvider.this.subcomposeLayoutState.precompose(key, PrefetchHandleProvider.this.itemContentFactory.getContent(this.index, key, invoke.getContentType(this.index)));
            } else {
                throw new IllegalArgumentException("Request was already composed!".toString());
            }
        }

        /* renamed from: performMeasure-BRTryo0  reason: not valid java name */
        private final void m1030performMeasureBRTryo0(long j) {
            if (this.isCanceled) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()".toString());
            } else if (!this.isMeasured) {
                this.isMeasured = true;
                SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
                if (precomposedSlotHandle != null) {
                    int placeablesCount = precomposedSlotHandle.getPlaceablesCount();
                    for (int i = 0; i < placeablesCount; i++) {
                        precomposedSlotHandle.m5933premeasure0kLqBqw(i, j);
                    }
                    return;
                }
                throw new IllegalArgumentException("performComposition() must be called before performMeasure()".toString());
            } else {
                throw new IllegalArgumentException("Request was already measured!".toString());
            }
        }

        private final NestedPrefetchController resolveNestedPrefetchStates() {
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
            if (precomposedSlotHandle != null) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                precomposedSlotHandle.traverseDescendants("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new PrefetchHandleProvider$HandleAndRequestImpl$resolveNestedPrefetchStates$1(objectRef));
                List list = (List) objectRef.element;
                if (list != null) {
                    return new NestedPrefetchController(list);
                }
                return null;
            }
            throw new IllegalArgumentException("Should precompose before resolving nested prefetch states".toString());
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + this.index + ", constraints = " + Constraints.m7057toStringimpl(this.constraints) + ", isComposed = " + isComposed() + ", isMeasured = " + this.isMeasured + ", isCanceled = " + this.isCanceled + " }";
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\n\u0010\r\u001a\u00020\u000e*\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00030\tX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "", "states", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;Ljava/util/List;)V", "requestIndex", "", "requestsByState", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "[Ljava/util/List;", "stateIndex", "executeNestedPrefetches", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LazyLayoutPrefetchState.kt */
        private final class NestedPrefetchController {
            private int requestIndex;
            private final List<PrefetchRequest>[] requestsByState;
            private int stateIndex;
            private final List<LazyLayoutPrefetchState> states;

            public NestedPrefetchController(List<LazyLayoutPrefetchState> list) {
                this.states = list;
                this.requestsByState = new List[list.size()];
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("NestedPrefetchController shouldn't be created with no states".toString());
                }
            }

            public final boolean executeNestedPrefetches(PrefetchRequestScope prefetchRequestScope) {
                if (this.stateIndex >= this.states.size()) {
                    return false;
                }
                if (!HandleAndRequestImpl.this.isCanceled) {
                    Trace.beginSection("compose:lazy:prefetch:nested");
                    while (this.stateIndex < this.states.size()) {
                        try {
                            if (this.requestsByState[this.stateIndex] == null) {
                                if (prefetchRequestScope.availableTimeNanos() <= 0) {
                                    Trace.endSection();
                                    return true;
                                }
                                List<PrefetchRequest>[] listArr = this.requestsByState;
                                int i = this.stateIndex;
                                listArr[i] = this.states.get(i).collectNestedPrefetchRequests$foundation_release();
                            }
                            List<PrefetchRequest> list = this.requestsByState[this.stateIndex];
                            Intrinsics.checkNotNull(list);
                            while (this.requestIndex < list.size()) {
                                if (list.get(this.requestIndex).execute(prefetchRequestScope)) {
                                    return true;
                                }
                                this.requestIndex++;
                            }
                            this.requestIndex = 0;
                            this.stateIndex++;
                        } finally {
                            Trace.endSection();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                    return false;
                }
                throw new IllegalStateException("Should not execute nested prefetch on canceled request".toString());
            }
        }
    }
}
