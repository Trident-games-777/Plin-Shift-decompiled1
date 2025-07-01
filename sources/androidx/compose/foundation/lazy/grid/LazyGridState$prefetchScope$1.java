package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/foundation/lazy/grid/LazyGridState$prefetchScope$1", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "scheduleLinePrefetch", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineIndex", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridState.kt */
public final class LazyGridState$prefetchScope$1 implements LazyGridPrefetchScope {
    final /* synthetic */ LazyGridState this$0;

    LazyGridState$prefetchScope$1(LazyGridState lazyGridState) {
        this.this$0 = lazyGridState;
    }

    public List<LazyLayoutPrefetchState.PrefetchHandle> scheduleLinePrefetch(int i) {
        List<LazyLayoutPrefetchState.PrefetchHandle> arrayList = new ArrayList<>();
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState = this.this$0;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            List invoke = ((LazyGridMeasureResult) lazyGridState.layoutInfoState.getValue()).getPrefetchInfoRetriever().invoke(Integer.valueOf(i));
            int size = invoke.size();
            for (int i2 = 0; i2 < size; i2++) {
                Pair pair = (Pair) invoke.get(i2);
                arrayList.add(lazyGridState.getPrefetchState$foundation_release().m1015schedulePrefetch0kLqBqw(((Number) pair.getFirst()).intValue(), ((Constraints) pair.getSecond()).m7058unboximpl()));
            }
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }
}
