package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.BaseInputConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/inputmethod/BaseInputConnection;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
final class LegacyTextInputMethodRequest$baseInputConnection$2 extends Lambda implements Function0<BaseInputConnection> {
    final /* synthetic */ LegacyTextInputMethodRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyTextInputMethodRequest$baseInputConnection$2(LegacyTextInputMethodRequest legacyTextInputMethodRequest) {
        super(0);
        this.this$0 = legacyTextInputMethodRequest;
    }

    public final BaseInputConnection invoke() {
        return new BaseInputConnection(this.this$0.getView(), false);
    }
}
