package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
/* synthetic */ class AndroidComposeView$focusOwner$4 extends FunctionReferenceImpl implements Function0<Unit> {
    AndroidComposeView$focusOwner$4(Object obj) {
        super(0, obj, AndroidComposeView.class, "onClearFocusForOwner", "onClearFocusForOwner()V", 0);
    }

    public final void invoke() {
        ((AndroidComposeView) this.receiver).onClearFocusForOwner();
    }
}
