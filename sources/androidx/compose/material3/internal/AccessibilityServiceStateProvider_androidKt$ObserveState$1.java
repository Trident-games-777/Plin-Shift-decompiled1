package androidx.compose.material3.internal;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccessibilityServiceStateProvider.android.kt */
final class AccessibilityServiceStateProvider_androidKt$ObserveState$1 extends Lambda implements Function1<Lifecycle.Event, Unit> {
    public static final AccessibilityServiceStateProvider_androidKt$ObserveState$1 INSTANCE = new AccessibilityServiceStateProvider_androidKt$ObserveState$1();

    AccessibilityServiceStateProvider_androidKt$ObserveState$1() {
        super(1);
    }

    public final void invoke(Lifecycle.Event event) {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Lifecycle.Event) obj);
        return Unit.INSTANCE;
    }
}
