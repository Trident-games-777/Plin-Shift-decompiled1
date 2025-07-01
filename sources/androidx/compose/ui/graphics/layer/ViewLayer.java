package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J0\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020+H\u0014J9\u0010/\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017J\u0010\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u00010\u001bR$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Landroidx/compose/ui/graphics/layer/ViewLayer;", "Landroid/view/View;", "ownerView", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroid/view/View;Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "value", "", "canUseCompositingLayer", "getCanUseCompositingLayer$ui_graphics_release", "()Z", "setCanUseCompositingLayer$ui_graphics_release", "(Z)V", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "density", "Landroidx/compose/ui/unit/Density;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "isInvalidated", "setInvalidated", "layerOutline", "Landroid/graphics/Outline;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getOwnerView", "()Landroid/view/View;", "parentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "forceLayout", "hasOverlappingRendering", "invalidate", "onLayout", "changed", "l", "", "t", "r", "b", "setDrawParams", "setLayerOutline", "outline", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsViewLayer.android.kt */
public final class ViewLayer extends View {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ViewOutlineProvider LayerOutlineProvider = new ViewLayer$Companion$LayerOutlineProvider$1();
    private boolean canUseCompositingLayer;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private Density density;
    private Function1<? super DrawScope, Unit> drawBlock;
    private boolean isInvalidated;
    /* access modifiers changed from: private */
    public Outline layerOutline;
    private LayoutDirection layoutDirection;
    private final View ownerView;
    private GraphicsLayer parentLayer;

    public void forceLayout() {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public final View getOwnerView() {
        return this.ownerView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewLayer(View view, CanvasHolder canvasHolder2, CanvasDrawScope canvasDrawScope2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i & 2) != 0 ? new CanvasHolder() : canvasHolder2, (i & 4) != 0 ? new CanvasDrawScope() : canvasDrawScope2);
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public ViewLayer(View view, CanvasHolder canvasHolder2, CanvasDrawScope canvasDrawScope2) {
        super(view.getContext());
        this.ownerView = view;
        this.canvasHolder = canvasHolder2;
        this.canvasDrawScope = canvasDrawScope2;
        setOutlineProvider(LayerOutlineProvider);
        this.canUseCompositingLayer = true;
        this.density = DrawContextKt.getDefaultDensity();
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawBlock = GraphicsLayerImpl.Companion.getDefaultDrawBlock();
        setWillNotDraw(false);
        setClipBounds((Rect) null);
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    public final void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    public final boolean setLayerOutline(Outline outline) {
        this.layerOutline = outline;
        return OutlineUtils.INSTANCE.rebuildOutline(this);
    }

    public final boolean getCanUseCompositingLayer$ui_graphics_release() {
        return this.canUseCompositingLayer;
    }

    public final void setCanUseCompositingLayer$ui_graphics_release(boolean z) {
        if (this.canUseCompositingLayer != z) {
            this.canUseCompositingLayer = z;
            invalidate();
        }
    }

    public final void setDrawParams(Density density2, LayoutDirection layoutDirection2, GraphicsLayer graphicsLayer, Function1<? super DrawScope, Unit> function1) {
        this.density = density2;
        this.layoutDirection = layoutDirection2;
        this.drawBlock = function1;
        this.parentLayer = graphicsLayer;
    }

    public void invalidate() {
        if (!this.isInvalidated) {
            this.isInvalidated = true;
            super.invalidate();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.canUseCompositingLayer;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        CanvasHolder canvasHolder2 = this.canvasHolder;
        Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
        androidx.compose.ui.graphics.Canvas androidCanvas = canvasHolder2.getAndroidCanvas();
        DrawScope drawScope = this.canvasDrawScope;
        Density density2 = this.density;
        LayoutDirection layoutDirection2 = this.layoutDirection;
        long Size = SizeKt.Size((float) getWidth(), (float) getHeight());
        GraphicsLayer graphicsLayer = this.parentLayer;
        Function1<? super DrawScope, Unit> function1 = this.drawBlock;
        Density density3 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection3 = drawScope.getDrawContext().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long r14 = drawScope.getDrawContext().m4806getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        CanvasHolder canvasHolder3 = canvasHolder2;
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density2);
        drawContext.setLayoutDirection(layoutDirection2);
        drawContext.setCanvas(androidCanvas);
        drawContext.m4807setSizeuvyYCjk(Size);
        drawContext.setGraphicsLayer(graphicsLayer);
        androidCanvas.save();
        try {
            function1.invoke(drawScope);
            androidCanvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density3);
            drawContext2.setLayoutDirection(layoutDirection3);
            drawContext2.setCanvas(canvas2);
            drawContext2.m4807setSizeuvyYCjk(r14);
            drawContext2.setGraphicsLayer(graphicsLayer2);
            canvasHolder3.getAndroidCanvas().setInternalCanvas(internalCanvas);
            this.isInvalidated = false;
        } catch (Throwable th) {
            androidCanvas.restore();
            DrawContext drawContext3 = drawScope.getDrawContext();
            drawContext3.setDensity(density3);
            drawContext3.setLayoutDirection(layoutDirection3);
            drawContext3.setCanvas(canvas2);
            drawContext3.m4807setSizeuvyYCjk(r14);
            drawContext3.setGraphicsLayer(graphicsLayer2);
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/layer/ViewLayer$Companion;", "", "()V", "LayerOutlineProvider", "Landroid/view/ViewOutlineProvider;", "getLayerOutlineProvider$ui_graphics_release", "()Landroid/view/ViewOutlineProvider;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: GraphicsViewLayer.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewOutlineProvider getLayerOutlineProvider$ui_graphics_release() {
            return ViewLayer.LayerOutlineProvider;
        }
    }
}
