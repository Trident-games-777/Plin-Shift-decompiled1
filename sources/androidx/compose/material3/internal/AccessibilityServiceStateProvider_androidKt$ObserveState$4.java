package androidx.compose.material3.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccessibilityServiceStateProvider.android.kt */
final class AccessibilityServiceStateProvider_androidKt$ObserveState$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<Lifecycle.Event, Unit> $handleEvent;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Function0<Unit> $onDispose;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccessibilityServiceStateProvider_androidKt$ObserveState$4(LifecycleOwner lifecycleOwner, Function1<? super Lifecycle.Event, Unit> function1, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$lifecycleOwner = lifecycleOwner;
        this.$handleEvent = function1;
        this.$onDispose = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AccessibilityServiceStateProvider_androidKt.ObserveState(this.$lifecycleOwner, this.$handleEvent, this.$onDispose, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
