package androidx.compose.ui.contentcapture;

import android.util.LongSparseArray;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AndroidContentCaptureManager f$0;
    public final /* synthetic */ LongSparseArray f$1;

    public /* synthetic */ AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticLambda0(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
        this.f$0 = androidContentCaptureManager;
        this.f$1 = longSparseArray;
    }

    public final void run() {
        AndroidContentCaptureManager.ViewTranslationHelperMethods.onVirtualViewTranslationResponses$lambda$1(this.f$0, this.f$1);
    }
}
