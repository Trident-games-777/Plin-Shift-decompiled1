package androidx.compose.ui.platform;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
/* synthetic */ class AndroidComposeView$focusOwner$6 extends MutablePropertyReference0Impl {
    AndroidComposeView$focusOwner$6(Object obj) {
        super(obj, AndroidComposeView.class, "layoutDirection", "getLayoutDirection()Landroidx/compose/ui/unit/LayoutDirection;", 0);
    }

    public Object get() {
        return ((AndroidComposeView) this.receiver).getLayoutDirection();
    }

    public void set(Object obj) {
        ((AndroidComposeView) this.receiver).setLayoutDirection((LayoutDirection) obj);
    }
}
