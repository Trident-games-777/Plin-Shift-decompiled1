package androidx.compose.foundation;

import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Background.kt */
final class BackgroundNode$getOutline$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<Outline> $outline;
    final /* synthetic */ ContentDrawScope $this_getOutline;
    final /* synthetic */ BackgroundNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackgroundNode$getOutline$1(Ref.ObjectRef<Outline> objectRef, BackgroundNode backgroundNode, ContentDrawScope contentDrawScope) {
        super(0);
        this.$outline = objectRef;
        this.this$0 = backgroundNode;
        this.$this_getOutline = contentDrawScope;
    }

    public final void invoke() {
        this.$outline.element = this.this$0.getShape().m4605createOutlinePq9zytI(this.$this_getOutline.m4865getSizeNHjbRc(), this.$this_getOutline.getLayoutDirection(), this.$this_getOutline);
    }
}
