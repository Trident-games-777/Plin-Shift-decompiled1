package androidx.compose.ui.scrollcapture;

import android.os.CancellationSignal;
import kotlinx.coroutines.Job;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ComposeScrollCaptureCallback_androidKt$$ExternalSyntheticLambda0 implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ Job f$0;

    public /* synthetic */ ComposeScrollCaptureCallback_androidKt$$ExternalSyntheticLambda0(Job job) {
        this.f$0 = job;
    }

    public final void onCancel() {
        ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal$lambda$0(this.f$0);
    }
}
