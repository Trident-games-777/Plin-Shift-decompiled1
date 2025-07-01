package androidx.compose.ui.graphics.layer;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/graphics/layer/ViewLayer$Companion$LayerOutlineProvider$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsViewLayer.android.kt */
public final class ViewLayer$Companion$LayerOutlineProvider$1 extends ViewOutlineProvider {
    ViewLayer$Companion$LayerOutlineProvider$1() {
    }

    public void getOutline(View view, Outline outline) {
        Outline access$getLayerOutline$p;
        if ((view instanceof ViewLayer) && (access$getLayerOutline$p = ((ViewLayer) view).layerOutline) != null) {
            outline.set(access$getLayerOutline$p);
        }
    }
}
