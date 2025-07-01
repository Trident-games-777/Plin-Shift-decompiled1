package androidx.compose.material3;

import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.kt */
final class DelegatingThemeAwareRippleNode$updateConfiguration$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DelegatingThemeAwareRippleNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelegatingThemeAwareRippleNode$updateConfiguration$1(DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode) {
        super(0);
        this.this$0 = delegatingThemeAwareRippleNode;
    }

    public final void invoke() {
        if (((RippleConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, RippleKt.getLocalRippleConfiguration())) == null) {
            this.this$0.removeRipple();
        } else if (this.this$0.rippleNode == null) {
            this.this$0.attachNewRipple();
        }
    }
}
