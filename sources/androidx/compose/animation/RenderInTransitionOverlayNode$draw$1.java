package androidx.compose.animation;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RenderInTransitionOverlayNodeElement.kt */
final class RenderInTransitionOverlayNode$draw$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ ContentDrawScope $this_draw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderInTransitionOverlayNode$draw$1(ContentDrawScope contentDrawScope) {
        super(1);
        this.$this_draw = contentDrawScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        this.$this_draw.drawContent();
    }
}
