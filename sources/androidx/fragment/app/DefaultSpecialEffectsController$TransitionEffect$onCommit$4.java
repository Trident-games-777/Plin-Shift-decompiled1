package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultSpecialEffectsController.kt */
final class DefaultSpecialEffectsController$TransitionEffect$onCommit$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ Object $mergedTransition;
    final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultSpecialEffectsController$TransitionEffect$onCommit$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup, Object obj) {
        super(0);
        this.this$0 = transitionEffect;
        this.$container = viewGroup;
        this.$mergedTransition = obj;
    }

    public final void invoke() {
        this.this$0.getTransitionImpl().beginDelayedTransition(this.$container, this.$mergedTransition);
    }
}
