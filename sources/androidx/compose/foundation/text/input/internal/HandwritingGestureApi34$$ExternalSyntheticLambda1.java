package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HandwritingGestureApi34$$ExternalSyntheticLambda1 implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ TransformedTextFieldState f$0;

    public /* synthetic */ HandwritingGestureApi34$$ExternalSyntheticLambda1(TransformedTextFieldState transformedTextFieldState) {
        this.f$0 = transformedTextFieldState;
    }

    public final void onCancel() {
        HandwritingGestureApi34.previewHandwritingGesture$lambda$1(this.f$0);
    }
}
