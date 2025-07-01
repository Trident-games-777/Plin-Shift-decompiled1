package androidx.compose.material3;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Icon.kt */
final class IconKt$Icon$4$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ Painter $painter;
    final /* synthetic */ ColorProducer $tint;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconKt$Icon$4$1(Painter painter, ColorProducer colorProducer) {
        super(1);
        this.$painter = painter;
        this.$tint = colorProducer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        ColorFilter colorFilter;
        Painter painter = this.$painter;
        ColorProducer colorProducer = this.$tint;
        long r2 = drawScope.m4865getSizeNHjbRc();
        if (colorProducer != null) {
            colorFilter = ColorFilter.Companion.m4280tintxETnrds$default(ColorFilter.Companion, colorProducer.m4320invoke0d7_KjU(), 0, 2, (Object) null);
        } else {
            colorFilter = null;
        }
        Painter.m5042drawx_KDEd0$default(painter, drawScope, r2, 0.0f, colorFilter, 2, (Object) null);
    }
}
