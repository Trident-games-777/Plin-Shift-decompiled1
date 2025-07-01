package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.CancellationSignal;
import android.view.KeyEvent;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000]\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J!\u0010\u001a\u001a\u00020\u000b2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000b0\u001c¢\u0006\u0002\b\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"androidx/compose/foundation/text/input/internal/AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "onCommitContent", "", "transferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "onImeAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeAction-KlQnJC8", "(I)V", "performHandwritingGesture", "", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "requestCursorUpdates", "cursorUpdateMode", "requestEdit", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "Lkotlin/ExtensionFunctionType;", "sendKeyEvent", "keyEvent", "Landroid/view/KeyEvent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextInputSession.android.kt */
public final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1 implements TextInputSession {
    final /* synthetic */ ComposeInputMethodManager $composeImm;
    final /* synthetic */ CursorAnchorInfoController $cursorUpdatesController;
    final /* synthetic */ TextLayoutState $layoutState;
    final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
    final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
    final /* synthetic */ TransformedTextFieldState $state;
    final /* synthetic */ ViewConfiguration $viewConfiguration;

    AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1(TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, Function1<? super ImeAction, Unit> function1, ReceiveContentConfiguration receiveContentConfiguration, CursorAnchorInfoController cursorAnchorInfoController, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        this.$state = transformedTextFieldState;
        this.$composeImm = composeInputMethodManager;
        this.$onImeAction = function1;
        this.$receiveContentConfiguration = receiveContentConfiguration;
        this.$cursorUpdatesController = cursorAnchorInfoController;
        this.$layoutState = textLayoutState;
        this.$viewConfiguration = viewConfiguration;
    }

    public TextFieldCharSequence getText() {
        return this.$state.getVisualText();
    }

    public void requestEdit(Function1<? super EditingBuffer, Unit> function1) {
        TransformedTextFieldState transformedTextFieldState = this.$state;
        TextFieldState access$getTextFieldState$p = transformedTextFieldState.textFieldState;
        InputTransformation access$getInputTransformation$p = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(access$getTextFieldState$p.getMainBuffer$foundation_release());
        access$getTextFieldState$p.commitEditAsUser(access$getInputTransformation$p, false, textFieldEditUndoBehavior);
    }

    public void sendKeyEvent(KeyEvent keyEvent) {
        this.$composeImm.sendKeyEvent(keyEvent);
    }

    /* renamed from: onImeAction-KlQnJC8  reason: not valid java name */
    public void m1340onImeActionKlQnJC8(int i) {
        Function1<ImeAction, Unit> function1 = this.$onImeAction;
        if (function1 != null) {
            function1.invoke(ImeAction.m6738boximpl(i));
        }
    }

    public boolean onCommitContent(TransferableContent transferableContent) {
        ReceiveContentConfiguration receiveContentConfiguration = this.$receiveContentConfiguration;
        if (receiveContentConfiguration != null) {
            return receiveContentConfiguration.onCommitContent(transferableContent);
        }
        return false;
    }

    public void requestCursorUpdates(int i) {
        this.$cursorUpdatesController.requestUpdates(i);
    }

    public int performHandwritingGesture(HandwritingGesture handwritingGesture) {
        if (Build.VERSION.SDK_INT >= 34) {
            return HandwritingGestureApi34.INSTANCE.performHandwritingGesture$foundation_release(this.$state, handwritingGesture, this.$layoutState, this.$viewConfiguration);
        }
        return 2;
    }

    public boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        if (Build.VERSION.SDK_INT >= 34) {
            return HandwritingGestureApi34.INSTANCE.previewHandwritingGesture$foundation_release(this.$state, previewableHandwritingGesture, this.$layoutState, cancellationSignal);
        }
        return false;
    }
}
