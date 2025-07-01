package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "S", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class SeekableTransitionState$recalculateTotalDurationNanos$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$recalculateTotalDurationNanos$1(SeekableTransitionState<S> seekableTransitionState) {
        super(0);
        this.this$0 = seekableTransitionState;
    }

    public final void invoke() {
        SeekableTransitionState<S> seekableTransitionState = this.this$0;
        Transition access$getTransition$p = seekableTransitionState.transition;
        seekableTransitionState.setTotalDurationNanos$animation_core_release(access$getTransition$p != null ? access$getTransition$p.getTotalDurationNanos() : 0);
    }
}
