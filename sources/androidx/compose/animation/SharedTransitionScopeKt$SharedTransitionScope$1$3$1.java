package androidx.compose.animation;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SharedTransitionScopeKt$SharedTransitionScope$1$3$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ SharedTransitionScopeImpl $sharedScope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedTransitionScopeKt$SharedTransitionScope$1$3$1(SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        super(1);
        this.$sharedScope = sharedTransitionScopeImpl;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        return new SharedTransitionScopeKt$SharedTransitionScope$1$3$1$invoke$$inlined$onDispose$1(this.$sharedScope);
    }
}
