package androidx.lifecycle.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LifecycleEffect.kt */
final class LifecycleEffectKt$LifecycleEventEffect$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ State<Function0<Unit>> $currentOnEvent$delegate;
    final /* synthetic */ Lifecycle.Event $event;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleEffectKt$LifecycleEventEffect$1$1(LifecycleOwner lifecycleOwner, Lifecycle.Event event, State<? extends Function0<Unit>> state) {
        super(1);
        this.$lifecycleOwner = lifecycleOwner;
        this.$event = event;
        this.$currentOnEvent$delegate = state;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        LifecycleEffectKt$LifecycleEventEffect$1$1$$ExternalSyntheticLambda0 lifecycleEffectKt$LifecycleEventEffect$1$1$$ExternalSyntheticLambda0 = new LifecycleEffectKt$LifecycleEventEffect$1$1$$ExternalSyntheticLambda0(this.$event, this.$currentOnEvent$delegate);
        this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEffectKt$LifecycleEventEffect$1$1$$ExternalSyntheticLambda0);
        return new LifecycleEffectKt$LifecycleEventEffect$1$1$invoke$$inlined$onDispose$1(this.$lifecycleOwner, lifecycleEffectKt$LifecycleEventEffect$1$1$$ExternalSyntheticLambda0);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(Lifecycle.Event event, State state, LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
        if (event2 == event) {
            LifecycleEffectKt.LifecycleEventEffect$lambda$0(state).invoke();
        }
    }
}
