package androidx.lifecycle.compose;

import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LifecycleEffectKt$LifecycleEventEffect$1$1$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ Lifecycle.Event f$0;
    public final /* synthetic */ State f$1;

    public /* synthetic */ LifecycleEffectKt$LifecycleEventEffect$1$1$$ExternalSyntheticLambda0(Lifecycle.Event event, State state) {
        this.f$0 = event;
        this.f$1 = state;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleEffectKt$LifecycleEventEffect$1$1.invoke$lambda$0(this.f$0, this.f$1, lifecycleOwner, event);
    }
}
