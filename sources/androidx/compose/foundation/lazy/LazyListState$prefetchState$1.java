package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListState.kt */
final class LazyListState$prefetchState$1 extends Lambda implements Function1<NestedPrefetchScope, Unit> {
    final /* synthetic */ int $firstVisibleItemIndex;
    final /* synthetic */ LazyListState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListState$prefetchState$1(LazyListState lazyListState, int i) {
        super(1);
        this.this$0 = lazyListState;
        this.$firstVisibleItemIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NestedPrefetchScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NestedPrefetchScope nestedPrefetchScope) {
        LazyListPrefetchStrategy access$getPrefetchStrategy$p = this.this$0.prefetchStrategy;
        int i = this.$firstVisibleItemIndex;
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null);
        access$getPrefetchStrategy$p.onNestedPrefetch(nestedPrefetchScope, i);
    }
}
