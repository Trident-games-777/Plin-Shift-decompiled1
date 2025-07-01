package androidx.compose.material3;

import androidx.compose.material.ripple.RippleAlpha;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material/ripple/RippleAlpha;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.kt */
final class DelegatingThemeAwareRippleNode$attachNewRipple$calculateRippleAlpha$1 extends Lambda implements Function0<RippleAlpha> {
    final /* synthetic */ DelegatingThemeAwareRippleNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelegatingThemeAwareRippleNode$attachNewRipple$calculateRippleAlpha$1(DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode) {
        super(0);
        this.this$0 = delegatingThemeAwareRippleNode;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = r0.getRippleAlpha();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material.ripple.RippleAlpha invoke() {
        /*
            r2 = this;
            androidx.compose.material3.DelegatingThemeAwareRippleNode r0 = r2.this$0
            androidx.compose.ui.node.CompositionLocalConsumerModifierNode r0 = (androidx.compose.ui.node.CompositionLocalConsumerModifierNode) r0
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material3.RippleKt.getLocalRippleConfiguration()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            java.lang.Object r0 = androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt.currentValueOf(r0, r1)
            androidx.compose.material3.RippleConfiguration r0 = (androidx.compose.material3.RippleConfiguration) r0
            if (r0 == 0) goto L_0x001a
            androidx.compose.material.ripple.RippleAlpha r0 = r0.getRippleAlpha()
            if (r0 != 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            return r0
        L_0x001a:
            androidx.compose.material3.RippleDefaults r0 = androidx.compose.material3.RippleDefaults.INSTANCE
            androidx.compose.material.ripple.RippleAlpha r0 = r0.getRippleAlpha()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DelegatingThemeAwareRippleNode$attachNewRipple$calculateRippleAlpha$1.invoke():androidx.compose.material.ripple.RippleAlpha");
    }
}
