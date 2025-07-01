package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/Color;", "invoke-0d7_KjU", "()J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.kt */
final class DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1 implements ColorProducer {
    final /* synthetic */ DelegatingThemeAwareRippleNode this$0;

    DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1(DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode) {
        this.this$0 = delegatingThemeAwareRippleNode;
    }

    /* renamed from: invoke-0d7_KjU  reason: not valid java name */
    public final long m2022invoke0d7_KjU() {
        long r0 = this.this$0.color.m4320invoke0d7_KjU();
        if (r0 != 16) {
            return r0;
        }
        RippleConfiguration rippleConfiguration = (RippleConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, RippleKt.getLocalRippleConfiguration());
        if (rippleConfiguration == null || rippleConfiguration.m2384getColor0d7_KjU() == 16) {
            return ((Color) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, ContentColorKt.getLocalContentColor())).m4249unboximpl();
        }
        return rippleConfiguration.m2384getColor0d7_KjU();
    }
}
