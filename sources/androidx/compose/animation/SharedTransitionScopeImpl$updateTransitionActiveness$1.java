package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/animation/SharedTransitionScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SharedTransitionScopeImpl$updateTransitionActiveness$1 extends Lambda implements Function1<SharedTransitionScope, Unit> {
    final /* synthetic */ SharedTransitionScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedTransitionScopeImpl$updateTransitionActiveness$1(SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        super(1);
        this.this$0 = sharedTransitionScopeImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SharedTransitionScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SharedTransitionScope sharedTransitionScope) {
        this.this$0.updateTransitionActiveness();
    }
}
