package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollSemanticsModifierNode$applySemantics$accessibilityScrollState$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ ScrollSemanticsModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollSemanticsModifierNode$applySemantics$accessibilityScrollState$2(ScrollSemanticsModifierNode scrollSemanticsModifierNode) {
        super(0);
        this.this$0 = scrollSemanticsModifierNode;
    }

    public final Float invoke() {
        return Float.valueOf((float) this.this$0.getState().getMaxValue());
    }
}
