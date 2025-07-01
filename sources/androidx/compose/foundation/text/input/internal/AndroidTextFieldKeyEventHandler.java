package androidx.compose.foundation.text.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "()V", "onKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "", "onKeyEvent-6ptp14s", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZZLkotlin/jvm/functions/Function0;)Z", "onPreKeyEvent", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldKeyEventHandler.android.kt */
public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    public static final int $stable = 0;

    /* renamed from: onPreKeyEvent-MyFupTE  reason: not valid java name */
    public boolean m1338onPreKeyEventMyFupTE(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController softwareKeyboardController) {
        if (super.m1417onPreKeyEventMyFupTE(keyEvent, transformedTextFieldState, textFieldSelectionState, focusManager, softwareKeyboardController)) {
            return true;
        }
        InputDevice device = keyEvent.getDevice();
        if (device == null || !device.supportsSource(InputDeviceCompat.SOURCE_DPAD) || device.isVirtual() || !KeyEventType.m5423equalsimpl0(KeyEvent_androidKt.m5431getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5427getKeyDownCS__XNY()) || keyEvent.getSource() == 257) {
            return false;
        }
        if (TextFieldKeyEventHandler_androidKt.m1420isKeyCodeYhN2O0w(keyEvent, 19)) {
            return focusManager.m3907moveFocus3ESFkO8(FocusDirection.Companion.m3905getUpdhqQ8s());
        }
        if (TextFieldKeyEventHandler_androidKt.m1420isKeyCodeYhN2O0w(keyEvent, 20)) {
            return focusManager.m3907moveFocus3ESFkO8(FocusDirection.Companion.m3898getDowndhqQ8s());
        }
        if (TextFieldKeyEventHandler_androidKt.m1420isKeyCodeYhN2O0w(keyEvent, 21)) {
            return focusManager.m3907moveFocus3ESFkO8(FocusDirection.Companion.m3901getLeftdhqQ8s());
        }
        if (TextFieldKeyEventHandler_androidKt.m1420isKeyCodeYhN2O0w(keyEvent, 22)) {
            return focusManager.m3907moveFocus3ESFkO8(FocusDirection.Companion.m3904getRightdhqQ8s());
        }
        if (!TextFieldKeyEventHandler_androidKt.m1420isKeyCodeYhN2O0w(keyEvent, 23)) {
            return false;
        }
        softwareKeyboardController.show();
        return true;
    }

    /* renamed from: onKeyEvent-6ptp14s  reason: not valid java name */
    public boolean m1337onKeyEvent6ptp14s(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, boolean z, boolean z2, Function0<Unit> function0) {
        if (KeyEventType.m5423equalsimpl0(KeyEvent_androidKt.m5431getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5427getKeyDownCS__XNY()) && keyEvent.isFromSource(InputDeviceCompat.SOURCE_KEYBOARD) && !TextFieldKeyEventHandler_androidKt.m1419isFromSoftKeyboardZmokQxo(keyEvent)) {
            textFieldSelectionState.setInTouchMode(false);
        }
        return super.m1416onKeyEvent6ptp14s(keyEvent, transformedTextFieldState, textLayoutState, textFieldSelectionState, z, z2, function0);
    }
}
