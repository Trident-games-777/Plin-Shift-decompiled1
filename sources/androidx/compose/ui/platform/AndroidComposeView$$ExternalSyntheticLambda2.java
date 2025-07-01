package androidx.compose.ui.platform;

import android.view.ViewTreeObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda2 implements ViewTreeObserver.OnTouchModeChangeListener {
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda2(AndroidComposeView androidComposeView) {
        this.f$0 = androidComposeView;
    }

    public final void onTouchModeChanged(boolean z) {
        AndroidComposeView.touchModeChangeListener$lambda$6(this.f$0, z);
    }
}
