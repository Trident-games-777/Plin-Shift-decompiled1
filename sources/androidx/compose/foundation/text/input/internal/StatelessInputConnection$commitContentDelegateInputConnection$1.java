package androidx.compose.foundation.text.input.internal;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"androidx/compose/foundation/text/input/internal/StatelessInputConnection$commitContentDelegateInputConnection$1", "Landroidx/core/view/inputmethod/InputConnectionCompat$OnCommitContentListener;", "onCommitContent", "", "inputContentInfo", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "flags", "", "opts", "Landroid/os/Bundle;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StatelessInputConnection.android.kt */
public final class StatelessInputConnection$commitContentDelegateInputConnection$1 implements InputConnectionCompat.OnCommitContentListener {
    final /* synthetic */ StatelessInputConnection this$0;

    StatelessInputConnection$commitContentDelegateInputConnection$1(StatelessInputConnection statelessInputConnection) {
        this.this$0 = statelessInputConnection;
    }

    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        if ((i & 1) != 0) {
            try {
                inputContentInfoCompat.requestPermission();
                Object unwrap = inputContentInfoCompat.unwrap();
                Intrinsics.checkNotNull(unwrap, "null cannot be cast to non-null type android.os.Parcelable");
                Parcelable parcelable = (Parcelable) unwrap;
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("EXTRA_INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                this.this$0.logDebug("Can't insert content from IME; requestPermission() failed, " + e);
                return false;
            }
        }
        return this.this$0.session.onCommitContent(StatelessInputConnection_androidKt.toTransferableContent(inputContentInfoCompat, bundle));
    }
}
