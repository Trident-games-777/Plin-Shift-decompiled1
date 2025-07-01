package androidx.compose.animation;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SharedTransitionScopeKt$SharedTransitionObserver$2 extends Lambda implements Function0<SnapshotStateObserver> {
    public static final SharedTransitionScopeKt$SharedTransitionObserver$2 INSTANCE = new SharedTransitionScopeKt$SharedTransitionObserver$2();

    SharedTransitionScopeKt$SharedTransitionObserver$2() {
        super(0);
    }

    public final SnapshotStateObserver invoke() {
        SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(AnonymousClass1.INSTANCE);
        snapshotStateObserver.start();
        return snapshotStateObserver;
    }
}
