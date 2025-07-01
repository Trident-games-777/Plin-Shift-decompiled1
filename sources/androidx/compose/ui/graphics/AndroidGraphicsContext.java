package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerV23;
import androidx.compose.ui.graphics.layer.GraphicsLayerV29;
import androidx.compose.ui.graphics.layer.GraphicsViewLayer;
import androidx.compose.ui.graphics.layer.LayerManager;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext;", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "componentCallback", "Landroid/content/ComponentCallbacks2;", "componentCallbackRegistered", "", "layerManager", "Landroidx/compose/ui/graphics/layer/LayerManager;", "lock", "", "predrawListenerRegistered", "viewLayerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "createGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "isLayerManagerInitialized", "obtainViewLayerContainer", "registerComponentCallback", "", "context", "Landroid/content/Context;", "releaseGraphicsLayer", "layer", "unregisterComponentCallback", "Companion", "UniqueDrawingIdApi29", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidGraphicsContext.android.kt */
final class AndroidGraphicsContext implements GraphicsContext {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final boolean enableLayerPersistence = false;
    /* access modifiers changed from: private */
    public static boolean isRenderNodeCompatible = true;
    private final ComponentCallbacks2 componentCallback = null;
    private boolean componentCallbackRegistered;
    /* access modifiers changed from: private */
    public final LayerManager layerManager = null;
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final ViewGroup ownerView;
    /* access modifiers changed from: private */
    public boolean predrawListenerRegistered;
    private DrawChildContainer viewLayerContainer;

    public AndroidGraphicsContext(ViewGroup viewGroup) {
        this.ownerView = viewGroup;
    }

    public final boolean isLayerManagerInitialized() {
        LayerManager layerManager2 = this.layerManager;
        if (layerManager2 != null) {
            return layerManager2.hasImageReader();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void registerComponentCallback(Context context) {
        if (!this.componentCallbackRegistered) {
            context.getApplicationContext().registerComponentCallbacks(this.componentCallback);
            this.componentCallbackRegistered = true;
        }
    }

    /* access modifiers changed from: private */
    public final void unregisterComponentCallback(Context context) {
        if (this.componentCallbackRegistered) {
            context.getApplicationContext().unregisterComponentCallbacks(this.componentCallback);
            this.componentCallbackRegistered = false;
        }
    }

    public GraphicsLayer createGraphicsLayer() {
        GraphicsLayerImpl graphicsLayerImpl;
        GraphicsLayer graphicsLayer;
        synchronized (this.lock) {
            long uniqueDrawingId = getUniqueDrawingId(this.ownerView);
            if (Build.VERSION.SDK_INT >= 29) {
                graphicsLayerImpl = new GraphicsLayerV29(uniqueDrawingId, (CanvasHolder) null, (CanvasDrawScope) null, 6, (DefaultConstructorMarker) null);
            } else if (isRenderNodeCompatible) {
                try {
                    graphicsLayerImpl = new GraphicsLayerV23(this.ownerView, uniqueDrawingId, (CanvasHolder) null, (CanvasDrawScope) null, 12, (DefaultConstructorMarker) null);
                } catch (Throwable unused) {
                    isRenderNodeCompatible = false;
                    graphicsLayerImpl = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView), uniqueDrawingId, (CanvasHolder) null, (CanvasDrawScope) null, 12, (DefaultConstructorMarker) null);
                }
            } else {
                graphicsLayerImpl = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView), uniqueDrawingId, (CanvasHolder) null, (CanvasDrawScope) null, 12, (DefaultConstructorMarker) null);
            }
            graphicsLayer = new GraphicsLayer(graphicsLayerImpl, this.layerManager);
        }
        return graphicsLayer;
    }

    public void releaseGraphicsLayer(GraphicsLayer graphicsLayer) {
        synchronized (this.lock) {
            graphicsLayer.release$ui_graphics_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final DrawChildContainer obtainViewLayerContainer(ViewGroup viewGroup) {
        DrawChildContainer drawChildContainer = this.viewLayerContainer;
        if (drawChildContainer != null) {
            return drawChildContainer;
        }
        DrawChildContainer viewLayerContainer2 = new ViewLayerContainer(viewGroup.getContext());
        viewGroup.addView(viewLayerContainer2);
        this.viewLayerContainer = viewLayerContainer2;
        return viewLayerContainer2;
    }

    private final long getUniqueDrawingId(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(view);
        }
        return -1;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext$Companion;", "", "()V", "enableLayerPersistence", "", "isRenderNodeCompatible", "()Z", "setRenderNodeCompatible", "(Z)V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidGraphicsContext.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isRenderNodeCompatible() {
            return AndroidGraphicsContext.isRenderNodeCompatible;
        }

        public final void setRenderNodeCompatible(boolean z) {
            AndroidGraphicsContext.isRenderNodeCompatible = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidGraphicsContext.android.kt */
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return view.getUniqueDrawingId();
        }
    }
}
