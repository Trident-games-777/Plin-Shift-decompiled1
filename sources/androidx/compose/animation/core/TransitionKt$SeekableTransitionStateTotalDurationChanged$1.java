package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/animation/core/SeekableTransitionState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class TransitionKt$SeekableTransitionStateTotalDurationChanged$1 extends Lambda implements Function1<SeekableTransitionState<?>, Unit> {
    public static final TransitionKt$SeekableTransitionStateTotalDurationChanged$1 INSTANCE = new TransitionKt$SeekableTransitionStateTotalDurationChanged$1();

    TransitionKt$SeekableTransitionStateTotalDurationChanged$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SeekableTransitionState<?>) (SeekableTransitionState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SeekableTransitionState<?> seekableTransitionState) {
        seekableTransitionState.onTotalDurationChanged$animation_core_release();
    }
}
