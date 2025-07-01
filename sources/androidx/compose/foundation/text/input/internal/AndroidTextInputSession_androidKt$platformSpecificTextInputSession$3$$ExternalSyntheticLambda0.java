package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$$ExternalSyntheticLambda0 implements PlatformTextInputMethodRequest {
    public final /* synthetic */ TransformedTextFieldState f$0;
    public final /* synthetic */ ImeOptions f$1;
    public final /* synthetic */ ReceiveContentConfiguration f$2;
    public final /* synthetic */ ComposeInputMethodManager f$3;
    public final /* synthetic */ Function1 f$4;
    public final /* synthetic */ CursorAnchorInfoController f$5;
    public final /* synthetic */ TextLayoutState f$6;
    public final /* synthetic */ ViewConfiguration f$7;

    public /* synthetic */ AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$$ExternalSyntheticLambda0(TransformedTextFieldState transformedTextFieldState, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, ComposeInputMethodManager composeInputMethodManager, Function1 function1, CursorAnchorInfoController cursorAnchorInfoController, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        this.f$0 = transformedTextFieldState;
        this.f$1 = imeOptions;
        this.f$2 = receiveContentConfiguration;
        this.f$3 = composeInputMethodManager;
        this.f$4 = function1;
        this.f$5 = cursorAnchorInfoController;
        this.f$6 = textLayoutState;
        this.f$7 = viewConfiguration;
    }

    public final InputConnection createInputConnection(EditorInfo editorInfo) {
        return AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3.invokeSuspend$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, editorInfo);
    }
}
