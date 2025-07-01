package androidx.compose.material3.internal;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$textFieldBackground$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ ColorProducer $color;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$textFieldBackground$1(Shape shape, ColorProducer colorProducer) {
        super(1);
        this.$shape = shape;
        this.$color = colorProducer;
    }

    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        final Outline r0 = this.$shape.m4605createOutlinePq9zytI(cacheDrawScope.m3868getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        final ColorProducer colorProducer = this.$color;
        return cacheDrawScope.onDrawBehind(new Function1<DrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope drawScope) {
                OutlineKt.m4502drawOutlinewDX37Ww$default(drawScope, r0, colorProducer.m4320invoke0d7_KjU(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
            }
        });
    }
}
