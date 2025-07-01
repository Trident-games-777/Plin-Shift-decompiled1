package androidx.compose.ui.window;

import android.window.OnBackInvokedCallback;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ Api33Impl$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    public final void onBackInvoked() {
        Api33Impl.createBackCallback$lambda$0(this.f$0);
    }
}
