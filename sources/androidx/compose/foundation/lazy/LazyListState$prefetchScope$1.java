package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/lazy/LazyListState$prefetchScope$1", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListState.kt */
public final class LazyListState$prefetchScope$1 implements LazyListPrefetchScope {
    final /* synthetic */ LazyListState this$0;

    LazyListState$prefetchScope$1(LazyListState lazyListState) {
        this.this$0 = lazyListState;
    }

    /* JADX INFO: finally extract failed */
    public LazyLayoutPrefetchState.PrefetchHandle schedulePrefetch(int i) {
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState = this.this$0;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            long r5 = ((LazyListMeasureResult) lazyListState.layoutInfoState.getValue()).m914getChildConstraintsmsEJaDk();
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            return this.this$0.getPrefetchState$foundation_release().m1015schedulePrefetch0kLqBqw(i, r5);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
