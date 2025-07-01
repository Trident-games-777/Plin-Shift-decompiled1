package androidx.lifecycle.compose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LifecycleEffectKt$LifecycleStartEffectImpl$1$1$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ LifecycleStartStopEffectScope f$0;
    public final /* synthetic */ Ref.ObjectRef f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ LifecycleEffectKt$LifecycleStartEffectImpl$1$1$$ExternalSyntheticLambda0(LifecycleStartStopEffectScope lifecycleStartStopEffectScope, Ref.ObjectRef objectRef, Function1 function1) {
        this.f$0 = lifecycleStartStopEffectScope;
        this.f$1 = objectRef;
        this.f$2 = function1;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleEffectKt$LifecycleStartEffectImpl$1$1.invoke$lambda$1(this.f$0, this.f$1, this.f$2, lifecycleOwner, event);
    }
}
