package androidx.compose.material.ripple;

import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.android.kt */
final class AndroidRippleNode$addRipple$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AndroidRippleNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidRippleNode$addRipple$1$1$1(AndroidRippleNode androidRippleNode) {
        super(0);
        this.this$0 = androidRippleNode;
    }

    public final void invoke() {
        DrawModifierNodeKt.invalidateDraw(this.this$0);
    }
}
