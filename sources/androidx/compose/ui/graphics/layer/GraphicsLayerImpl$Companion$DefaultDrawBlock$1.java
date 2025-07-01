package androidx.compose.ui.graphics.layer;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidGraphicsLayer.android.kt */
final class GraphicsLayerImpl$Companion$DefaultDrawBlock$1 extends Lambda implements Function1<DrawScope, Unit> {
    public static final GraphicsLayerImpl$Companion$DefaultDrawBlock$1 INSTANCE = new GraphicsLayerImpl$Companion$DefaultDrawBlock$1();

    GraphicsLayerImpl$Companion$DefaultDrawBlock$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope.m4840drawRectnJ9OG0$default(drawScope, Color.Companion.m4274getTransparent0d7_KjU(), 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
    }
}
