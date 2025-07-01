package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HandwritingGestureApi34$$ExternalSyntheticLambda0 implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ TextFieldSelectionManager f$0;

    public /* synthetic */ HandwritingGestureApi34$$ExternalSyntheticLambda0(TextFieldSelectionManager textFieldSelectionManager) {
        this.f$0 = textFieldSelectionManager;
    }

    public final void onCancel() {
        HandwritingGestureApi34.previewHandwritingGesture$lambda$9(this.f$0);
    }
}
