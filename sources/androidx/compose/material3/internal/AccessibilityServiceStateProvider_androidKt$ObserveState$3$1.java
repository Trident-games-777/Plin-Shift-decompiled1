package androidx.compose.material3.internal;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccessibilityServiceStateProvider.android.kt */
final class AccessibilityServiceStateProvider_androidKt$ObserveState$3$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Function1<Lifecycle.Event, Unit> $handleEvent;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Function0<Unit> $onDispose;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccessibilityServiceStateProvider_androidKt$ObserveState$3$1(LifecycleOwner lifecycleOwner, Function1<? super Lifecycle.Event, Unit> function1, Function0<Unit> function0) {
        super(1);
        this.$lifecycleOwner = lifecycleOwner;
        this.$handleEvent = function1;
        this.$onDispose = function0;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        function1.invoke(event);
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        AccessibilityServiceStateProvider_androidKt$ObserveState$3$1$$ExternalSyntheticLambda0 accessibilityServiceStateProvider_androidKt$ObserveState$3$1$$ExternalSyntheticLambda0 = new AccessibilityServiceStateProvider_androidKt$ObserveState$3$1$$ExternalSyntheticLambda0(this.$handleEvent);
        this.$lifecycleOwner.getLifecycle().addObserver(accessibilityServiceStateProvider_androidKt$ObserveState$3$1$$ExternalSyntheticLambda0);
        return new AccessibilityServiceStateProvider_androidKt$ObserveState$3$1$invoke$$inlined$onDispose$1(this.$onDispose, this.$lifecycleOwner, accessibilityServiceStateProvider_androidKt$ObserveState$3$1$$ExternalSyntheticLambda0);
    }
}
