package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ LegacyPlatformTextInputServiceAdapter $legacyTextInputServiceAdapter;
    final /* synthetic */ LegacyTextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, ImeOptions imeOptions, LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter) {
        super(0);
        this.$state = legacyTextFieldState;
        this.$focusRequester = focusRequester;
        this.$imeOptions = imeOptions;
        this.$legacyTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter;
    }

    public final Boolean invoke() {
        if (!this.$state.getHasFocus()) {
            this.$focusRequester.requestFocus();
        }
        if (!KeyboardType.m6794equalsimpl0(this.$imeOptions.m6771getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6813getPasswordPjHm6EE()) && !KeyboardType.m6794equalsimpl0(this.$imeOptions.m6771getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6812getNumberPasswordPjHm6EE())) {
            this.$legacyTextInputServiceAdapter.startStylusHandwriting();
        }
        return true;
    }
}
