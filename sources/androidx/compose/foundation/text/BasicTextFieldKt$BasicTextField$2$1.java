package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$BasicTextField$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ClipboardManager $currentClipboardManager;
    final /* synthetic */ HapticFeedback $currentHapticFeedback;
    final /* synthetic */ TextToolbar $currentTextToolbar;
    final /* synthetic */ Density $density;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InputTransformation $inputTransformation;
    final /* synthetic */ boolean $isPassword;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldSelectionState $textFieldSelectionState;
    final /* synthetic */ TransformedTextFieldState $transformedState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextFieldKt$BasicTextField$2$1(TransformedTextFieldState transformedTextFieldState, InputTransformation inputTransformation, TextFieldSelectionState textFieldSelectionState, HapticFeedback hapticFeedback, ClipboardManager clipboardManager, TextToolbar textToolbar, Density density, boolean z, boolean z2, boolean z3) {
        super(0);
        this.$transformedState = transformedTextFieldState;
        this.$inputTransformation = inputTransformation;
        this.$textFieldSelectionState = textFieldSelectionState;
        this.$currentHapticFeedback = hapticFeedback;
        this.$currentClipboardManager = clipboardManager;
        this.$currentTextToolbar = textToolbar;
        this.$density = density;
        this.$enabled = z;
        this.$readOnly = z2;
        this.$isPassword = z3;
    }

    public final void invoke() {
        this.$transformedState.update(this.$inputTransformation);
        this.$textFieldSelectionState.update(this.$currentHapticFeedback, this.$currentClipboardManager, this.$currentTextToolbar, this.$density, this.$enabled, this.$readOnly, this.$isPassword);
    }
}
