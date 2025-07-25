package androidx.compose.material3.internal;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0002\u0010\u0013\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\"B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0003*\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Landroidx/compose/material3/internal/Listener;", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroidx/compose/runtime/State;", "", "listenToTouchExplorationState", "listenToSwitchAccessState", "(ZZ)V", "<set-?>", "accessibilityEnabled", "getAccessibilityEnabled", "()Z", "setAccessibilityEnabled", "(Z)V", "accessibilityEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "switchAccessListener", "androidx/compose/material3/internal/Listener$switchAccessListener$1", "Landroidx/compose/material3/internal/Listener$switchAccessListener$1;", "touchExplorationListener", "androidx/compose/material3/internal/Listener$touchExplorationListener$1", "Landroidx/compose/material3/internal/Listener$touchExplorationListener$1;", "value", "getValue", "()Ljava/lang/Boolean;", "switchAccessEnabled", "Landroid/view/accessibility/AccessibilityManager;", "getSwitchAccessEnabled", "(Landroid/view/accessibility/AccessibilityManager;)Z", "onAccessibilityStateChanged", "", "enabled", "register", "am", "unregister", "Api33Impl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccessibilityServiceStateProvider.android.kt */
final class Listener implements AccessibilityManager.AccessibilityStateChangeListener, State<Boolean> {
    private final MutableState accessibilityEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Listener$switchAccessListener$1 switchAccessListener;
    private final Listener$touchExplorationListener$1 touchExplorationListener;

    public Listener(boolean z, boolean z2) {
        Listener$switchAccessListener$1 listener$switchAccessListener$1 = null;
        this.touchExplorationListener = z ? new Listener$touchExplorationListener$1() : null;
        if (z2 && Build.VERSION.SDK_INT >= 33) {
            listener$switchAccessListener$1 = new Listener$switchAccessListener$1(this);
        }
        this.switchAccessListener = listener$switchAccessListener$1;
    }

    private final boolean getAccessibilityEnabled() {
        return ((Boolean) this.accessibilityEnabled$delegate.getValue()).booleanValue();
    }

    private final void setAccessibilityEnabled(boolean z) {
        this.accessibilityEnabled$delegate.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final boolean getSwitchAccessEnabled(AccessibilityManager accessibilityManager) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16);
        int size = enabledAccessibilityServiceList.size();
        for (int i = 0; i < size; i++) {
            String settingsActivityName = enabledAccessibilityServiceList.get(i).getSettingsActivityName();
            if (settingsActivityName != null && StringsKt.contains$default((CharSequence) settingsActivityName, (CharSequence) "SwitchAccess", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if ((r0 != null ? r0.getEnabled() : false) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean getValue() {
        /*
            r2 = this;
            boolean r0 = r2.getAccessibilityEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0020
            androidx.compose.material3.internal.Listener$touchExplorationListener$1 r0 = r2.touchExplorationListener
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.getEnabled()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 != 0) goto L_0x001f
            androidx.compose.material3.internal.Listener$switchAccessListener$1 r0 = r2.switchAccessListener
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.getEnabled()
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            if (r0 == 0) goto L_0x0020
        L_0x001f:
            r1 = 1
        L_0x0020:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.Listener.getValue():java.lang.Boolean");
    }

    public void onAccessibilityStateChanged(boolean z) {
        setAccessibilityEnabled(z);
    }

    public final void register(AccessibilityManager accessibilityManager) {
        AccessibilityManager.AccessibilityServicesStateChangeListener accessibilityServicesStateChangeListener;
        setAccessibilityEnabled(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 listener$touchExplorationListener$1 = this.touchExplorationListener;
        if (listener$touchExplorationListener$1 != null) {
            listener$touchExplorationListener$1.setEnabled(accessibilityManager.isTouchExplorationEnabled());
            accessibilityManager.addTouchExplorationStateChangeListener(listener$touchExplorationListener$1);
        }
        if (Build.VERSION.SDK_INT >= 33 && (accessibilityServicesStateChangeListener = this.switchAccessListener) != null) {
            accessibilityServicesStateChangeListener.setEnabled(getSwitchAccessEnabled(accessibilityManager));
            Api33Impl.addAccessibilityServicesStateChangeListener(accessibilityManager, accessibilityServicesStateChangeListener);
        }
    }

    public final void unregister(AccessibilityManager accessibilityManager) {
        AccessibilityManager.AccessibilityServicesStateChangeListener accessibilityServicesStateChangeListener;
        accessibilityManager.removeAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 listener$touchExplorationListener$1 = this.touchExplorationListener;
        if (listener$touchExplorationListener$1 != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(listener$touchExplorationListener$1);
        }
        if (Build.VERSION.SDK_INT >= 33 && (accessibilityServicesStateChangeListener = this.switchAccessListener) != null) {
            Api33Impl.removeAccessibilityServicesStateChangeListener(accessibilityManager, accessibilityServicesStateChangeListener);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/material3/internal/Listener$Api33Impl;", "", "()V", "addAccessibilityServicesStateChangeListener", "", "am", "Landroid/view/accessibility/AccessibilityManager;", "listener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityServicesStateChangeListener;", "removeAccessibilityServicesStateChangeListener", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AccessibilityServiceStateProvider.android.kt */
    private static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @JvmStatic
        public static final void addAccessibilityServicesStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityManager.AccessibilityServicesStateChangeListener accessibilityServicesStateChangeListener) {
            accessibilityManager.addAccessibilityServicesStateChangeListener(accessibilityServicesStateChangeListener);
        }

        @JvmStatic
        public static final void removeAccessibilityServicesStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityManager.AccessibilityServicesStateChangeListener accessibilityServicesStateChangeListener) {
            accessibilityManager.removeAccessibilityServicesStateChangeListener(accessibilityServicesStateChangeListener);
        }
    }
}
