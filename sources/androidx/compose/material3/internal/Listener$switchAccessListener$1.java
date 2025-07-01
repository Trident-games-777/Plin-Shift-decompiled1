package androidx.compose.material3.internal;

import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R+\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"androidx/compose/material3/internal/Listener$switchAccessListener$1", "Landroid/view/accessibility/AccessibilityManager$AccessibilityServicesStateChangeListener;", "<set-?>", "", "enabled", "getEnabled", "()Z", "setEnabled", "(Z)V", "enabled$delegate", "Landroidx/compose/runtime/MutableState;", "onAccessibilityServicesStateChanged", "", "am", "Landroid/view/accessibility/AccessibilityManager;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccessibilityServiceStateProvider.android.kt */
public final class Listener$switchAccessListener$1 implements AccessibilityManager.AccessibilityServicesStateChangeListener {
    private final MutableState enabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    final /* synthetic */ Listener this$0;

    Listener$switchAccessListener$1(Listener listener) {
        this.this$0 = listener;
    }

    public final boolean getEnabled() {
        return ((Boolean) this.enabled$delegate.getValue()).booleanValue();
    }

    public final void setEnabled(boolean z) {
        this.enabled$delegate.setValue(Boolean.valueOf(z));
    }

    public void onAccessibilityServicesStateChanged(AccessibilityManager accessibilityManager) {
        setEnabled(this.this$0.getSwitchAccessEnabled(accessibilityManager));
    }
}
