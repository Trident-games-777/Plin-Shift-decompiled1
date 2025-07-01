package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
final class AndroidLegacyPlatformTextInputServiceAdapter$startInput$1 extends Lambda implements Function1<LegacyTextInputMethodRequest, Unit> {
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ Function1<List<? extends EditCommand>, Unit> $onEditCommand;
    final /* synthetic */ Function1<ImeAction, Unit> $onImeActionPerformed;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidLegacyPlatformTextInputServiceAdapter$startInput$1(TextFieldValue textFieldValue, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, ImeOptions imeOptions, Function1<? super List<? extends EditCommand>, Unit> function1, Function1<? super ImeAction, Unit> function12) {
        super(1);
        this.$value = textFieldValue;
        this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
        this.$imeOptions = imeOptions;
        this.$onEditCommand = function1;
        this.$onImeActionPerformed = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LegacyTextInputMethodRequest) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LegacyTextInputMethodRequest legacyTextInputMethodRequest) {
        legacyTextInputMethodRequest.startInput(this.$value, this.this$0.getTextInputModifierNode(), this.$imeOptions, this.$onEditCommand, this.$onImeActionPerformed);
    }
}
