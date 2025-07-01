package androidx.compose.ui.graphics;

import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/ui/graphics/AndroidGraphicsContext$1$onTrimMemory$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidGraphicsContext.android.kt */
public final class AndroidGraphicsContext$1$onTrimMemory$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ AndroidGraphicsContext this$0;

    AndroidGraphicsContext$1$onTrimMemory$1(AndroidGraphicsContext androidGraphicsContext) {
        this.this$0 = androidGraphicsContext;
    }

    public boolean onPreDraw() {
        this.this$0.layerManager.updateLayerPersistence();
        this.this$0.ownerView.getViewTreeObserver().removeOnPreDrawListener(this);
        this.this$0.predrawListenerRegistered = false;
        return true;
    }
}
