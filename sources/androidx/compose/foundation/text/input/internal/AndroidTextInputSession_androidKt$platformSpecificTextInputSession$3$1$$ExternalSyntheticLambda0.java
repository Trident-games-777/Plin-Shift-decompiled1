package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1$$ExternalSyntheticLambda0 implements TextFieldState.NotifyImeListener {
    public final /* synthetic */ ComposeInputMethodManager f$0;

    public /* synthetic */ AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1$$ExternalSyntheticLambda0(ComposeInputMethodManager composeInputMethodManager) {
        this.f$0 = composeInputMethodManager;
    }

    public final void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3.AnonymousClass1.invokeSuspend$lambda$0(this.f$0, textFieldCharSequence, textFieldCharSequence2, z);
    }
}
