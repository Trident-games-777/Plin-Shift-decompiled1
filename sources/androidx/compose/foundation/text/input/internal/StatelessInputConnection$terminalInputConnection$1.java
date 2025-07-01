package androidx.compose.foundation.text.input.internal;

import android.os.Bundle;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, d2 = {"androidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1", "Landroid/view/inputmethod/InputConnectionWrapper;", "commitContent", "", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "", "opts", "Landroid/os/Bundle;", "performPrivateCommand", "action", "", "data", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StatelessInputConnection.android.kt */
public final class StatelessInputConnection$terminalInputConnection$1 extends InputConnectionWrapper {
    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        return false;
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        return true;
    }

    StatelessInputConnection$terminalInputConnection$1(StatelessInputConnection statelessInputConnection) {
        super(statelessInputConnection, false);
    }
}
