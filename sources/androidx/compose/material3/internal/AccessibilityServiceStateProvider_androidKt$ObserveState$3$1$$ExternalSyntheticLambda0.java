package androidx.compose.material3.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AccessibilityServiceStateProvider_androidKt$ObserveState$3$1$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ AccessibilityServiceStateProvider_androidKt$ObserveState$3$1$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        AccessibilityServiceStateProvider_androidKt$ObserveState$3$1.invoke$lambda$0(this.f$0, lifecycleOwner, event);
    }
}
