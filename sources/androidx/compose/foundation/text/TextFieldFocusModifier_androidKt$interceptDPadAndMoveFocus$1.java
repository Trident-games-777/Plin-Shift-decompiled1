package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldFocusModifier.android.kt */
final class TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ LegacyTextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1(FocusManager focusManager, LegacyTextFieldState legacyTextFieldState) {
        super(1);
        this.$focusManager = focusManager;
        this.$state = legacyTextFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m1271invokeZmokQxo(((KeyEvent) obj).m5419unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m1271invokeZmokQxo(android.view.KeyEvent keyEvent) {
        InputDevice device = keyEvent.getDevice();
        boolean z = false;
        if (device != null && device.supportsSource(InputDeviceCompat.SOURCE_DPAD) && !device.isVirtual() && KeyEventType.m5423equalsimpl0(KeyEvent_androidKt.m5431getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5427getKeyDownCS__XNY()) && keyEvent.getSource() != 257) {
            if (TextFieldFocusModifier_androidKt.m1270isKeyCodeYhN2O0w(keyEvent, 19)) {
                z = this.$focusManager.m3907moveFocus3ESFkO8(FocusDirection.Companion.m3905getUpdhqQ8s());
            } else if (TextFieldFocusModifier_androidKt.m1270isKeyCodeYhN2O0w(keyEvent, 20)) {
                z = this.$focusManager.m3907moveFocus3ESFkO8(FocusDirection.Companion.m3898getDowndhqQ8s());
            } else if (TextFieldFocusModifier_androidKt.m1270isKeyCodeYhN2O0w(keyEvent, 21)) {
                z = this.$focusManager.m3907moveFocus3ESFkO8(FocusDirection.Companion.m3901getLeftdhqQ8s());
            } else if (TextFieldFocusModifier_androidKt.m1270isKeyCodeYhN2O0w(keyEvent, 22)) {
                z = this.$focusManager.m3907moveFocus3ESFkO8(FocusDirection.Companion.m3904getRightdhqQ8s());
            } else if (TextFieldFocusModifier_androidKt.m1270isKeyCodeYhN2O0w(keyEvent, 23)) {
                SoftwareKeyboardController keyboardController = this.$state.getKeyboardController();
                if (keyboardController != null) {
                    keyboardController.show();
                }
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }
}
