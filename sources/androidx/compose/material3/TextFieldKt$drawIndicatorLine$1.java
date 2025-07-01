package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$drawIndicatorLine$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ State<BorderStroke> $indicatorBorder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$drawIndicatorLine$1(State<BorderStroke> state) {
        super(1);
        this.$indicatorBorder = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        contentDrawScope2.drawContent();
        float r9 = contentDrawScope2.m7091toPx0680j_4(this.$indicatorBorder.getValue().m274getWidthD9Ej5fM());
        float r2 = Size.m4053getHeightimpl(contentDrawScope2.m4865getSizeNHjbRc()) - (r9 / ((float) 2));
        DrawScope.m4831drawLine1RTmtNc$default(contentDrawScope2, this.$indicatorBorder.getValue().getBrush(), OffsetKt.Offset(0.0f, r2), OffsetKt.Offset(Size.m4056getWidthimpl(contentDrawScope2.m4865getSizeNHjbRc()), r2), r9, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }
}
