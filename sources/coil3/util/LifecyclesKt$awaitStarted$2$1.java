package coil3.util;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"coil3/util/LifecyclesKt$awaitStarted$2$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onStart", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: lifecycles.kt */
public final class LifecyclesKt$awaitStarted$2$1 implements DefaultLifecycleObserver {
    final /* synthetic */ CancellableContinuation<Unit> $continuation;

    LifecyclesKt$awaitStarted$2$1(CancellableContinuation<? super Unit> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        Result.Companion companion = Result.Companion;
        this.$continuation.resumeWith(Result.m7823constructorimpl(Unit.INSTANCE));
    }
}
