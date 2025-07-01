package androidx.lifecycle.compose;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/lifecycle/compose/LifecycleResumePauseEffectScope$onPauseOrDispose$1", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "runPauseOrOnDisposeEffect", "", "lifecycle-runtime-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
/* compiled from: LifecycleEffect.kt */
public final class LifecycleResumePauseEffectScope$onPauseOrDispose$1 implements LifecyclePauseOrDisposeEffectResult {
    final /* synthetic */ Function1<LifecycleOwner, Unit> $onPauseOrDisposeEffect;
    final /* synthetic */ LifecycleResumePauseEffectScope this$0;

    public LifecycleResumePauseEffectScope$onPauseOrDispose$1(Function1<? super LifecycleOwner, Unit> function1, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope) {
        this.$onPauseOrDisposeEffect = function1;
        this.this$0 = lifecycleResumePauseEffectScope;
    }

    public void runPauseOrOnDisposeEffect() {
        this.$onPauseOrDisposeEffect.invoke(this.this$0);
    }
}
