package androidx.compose.ui.graphics.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010u\u001a\u00020v2\u0006\u00106\u001a\u000205H\u0002ø\u0001\u0000¢\u0006\u0004\bw\u0010\u001eJ\b\u0010x\u001a\u00020yH\u0016J\b\u0010z\u001a\u00020vH\u0016J\u0010\u0010{\u001a\u00020v2\u0006\u0010|\u001a\u00020}H\u0016J\b\u0010~\u001a\u00020>H\u0002JC\u0010\u001a\u00020v2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u001b\u0010\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020v0\u0001¢\u0006\u0003\b\u0001H\u0016J\t\u0010\u0001\u001a\u00020vH\u0002J\t\u0010\u0001\u001a\u00020%H\u0002J\t\u0010\u0001\u001a\u00020%H\u0002J\u0015\u0010\u0001\u001a\u00020v2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J-\u0010\u0001\u001a\u00020v2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020s2\u0006\u0010e\u001a\u00020fH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020vH\u0002J\t\u0010\u0001\u001a\u00020vH\u0002R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0019@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R$\u0010&\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020%8V@VX\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R(\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u000b\u001a\u0004\u0018\u00010/@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R,\u00106\u001a\u0002052\u0006\u0010\u000b\u001a\u000205@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR\u001a\u00109\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0015R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0015R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R,\u0010F\u001a\u00020E2\u0006\u0010\u000b\u001a\u00020E@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\bG\u0010\u0015\"\u0004\bH\u0010\u0017R(\u0010J\u001a\u0004\u0018\u00010I2\b\u0010\u000b\u001a\u0004\u0018\u00010I@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0016\u0010O\u001a\n Q*\u0004\u0018\u00010P0PX\u0004¢\u0006\u0002\n\u0000R$\u0010R\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u000f\"\u0004\bT\u0010\u0011R$\u0010U\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000f\"\u0004\bW\u0010\u0011R$\u0010X\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000f\"\u0004\bZ\u0010\u0011R$\u0010[\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000f\"\u0004\b]\u0010\u0011R$\u0010^\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u000f\"\u0004\b`\u0010\u0011R$\u0010a\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u000f\"\u0004\bc\u0010\u0011R\u000e\u0010d\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010e\u001a\u00020fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R,\u0010g\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\bh\u0010\u0015\"\u0004\bi\u0010\u0017R$\u0010j\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u000f\"\u0004\bl\u0010\u0011R$\u0010m\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u000f\"\u0004\bo\u0010\u0011R\u000e\u0010p\u001a\u00020qX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020sX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020sX\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "layerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "cameraDistance", "getCameraDistance", "setCameraDistance", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "clipBoundsInvalidated", "clipRect", "Landroid/graphics/Rect;", "clipToBounds", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "layerPaint", "Landroid/graphics/Paint;", "outlineIsProvided", "getOwnerId", "picture", "Landroid/graphics/Picture;", "pictureCanvasHolder", "pictureDrawScope", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "resources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shouldManuallySetCenterPivot", "size", "Landroidx/compose/ui/unit/IntSize;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "viewLayer", "Landroidx/compose/ui/graphics/layer/ViewLayer;", "x", "", "y", "applyCompositingLayer", "", "applyCompositingLayer-Wpw9cng", "calculateMatrix", "Landroid/graphics/Matrix;", "discardDisplayList", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "obtainLayerPaint", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "recordDrawingOperations", "requiresCompositingLayer", "requiresLayerPaint", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "setPosition-H0pRuoY", "(IIJ)V", "updateClipBounds", "updateLayerProperties", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsViewLayer.android.kt */
public final class GraphicsViewLayer implements GraphicsLayerImpl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Canvas PlaceholderCanvas = new GraphicsViewLayer$Companion$PlaceholderCanvas$1();
    /* access modifiers changed from: private */
    public static final boolean mayRenderInSoftware = (!SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable());
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private final CanvasHolder canvasHolder;
    private boolean clipBoundsInvalidated;
    private final Rect clipRect;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final DrawChildContainer layerContainer;
    private final long layerId;
    private Paint layerPaint;
    private boolean outlineIsProvided;
    private final long ownerId;
    private final Picture picture;
    private final CanvasHolder pictureCanvasHolder;
    private final CanvasDrawScope pictureDrawScope;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final Resources resources;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;
    private final ViewLayer viewLayer;
    private int x;
    private int y;

    public GraphicsViewLayer(DrawChildContainer drawChildContainer, long j, CanvasHolder canvasHolder2, CanvasDrawScope canvasDrawScope) {
        this.layerContainer = drawChildContainer;
        this.ownerId = j;
        this.canvasHolder = canvasHolder2;
        ViewLayer viewLayer2 = new ViewLayer(drawChildContainer, canvasHolder2, canvasDrawScope);
        this.viewLayer = viewLayer2;
        this.resources = drawChildContainer.getResources();
        this.clipRect = new Rect();
        boolean z = mayRenderInSoftware;
        this.picture = z ? new Picture() : null;
        this.pictureDrawScope = z ? new CanvasDrawScope() : null;
        this.pictureCanvasHolder = z ? new CanvasHolder() : null;
        drawChildContainer.addView(viewLayer2);
        viewLayer2.setClipBounds((Rect) null);
        this.size = IntSize.Companion.m7288getZeroYbymL2g();
        this.isInvalidated = true;
        this.layerId = (long) View.generateViewId();
        this.blendMode = BlendMode.Companion.m4170getSrcOver0nO6VwU();
        this.compositingStrategy = CompositingStrategy.Companion.m4962getAutoke2Ky5w();
        this.alpha = 1.0f;
        this.pivotOffset = Offset.Companion.m4003getZeroF1C5BW0();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.ambientShadowColor = Color.Companion.m4265getBlack0d7_KjU();
        this.spotShadowColor = Color.Companion.m4265getBlack0d7_KjU();
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GraphicsViewLayer(DrawChildContainer drawChildContainer, long j, CanvasHolder canvasHolder2, CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawChildContainer, j, (i & 4) != 0 ? new CanvasHolder() : canvasHolder2, (i & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public boolean isInvalidated() {
        return this.isInvalidated;
    }

    public void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    public long getLayerId() {
        return this.layerId;
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public int m5022getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    public void m5027setBlendModes9anfk8(int i) {
        this.blendMode = i;
        obtainLayerPaint().setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m4080toPorterDuffModes9anfk8(i)));
        updateLayerProperties();
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public void setColorFilter(ColorFilter colorFilter2) {
        this.colorFilter = colorFilter2;
        obtainLayerPaint().setColorFilter(colorFilter2 != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter2) : null);
        updateLayerProperties();
    }

    /* renamed from: getCompositingStrategy-ke2Ky5w  reason: not valid java name */
    public int m5023getCompositingStrategyke2Ky5w() {
        return this.compositingStrategy;
    }

    /* renamed from: setCompositingStrategy-Wpw9cng  reason: not valid java name */
    public void m5028setCompositingStrategyWpw9cng(int i) {
        this.compositingStrategy = i;
        updateLayerProperties();
    }

    /* renamed from: applyCompositingLayer-Wpw9cng  reason: not valid java name */
    private final void m5020applyCompositingLayerWpw9cng(int i) {
        ViewLayer viewLayer2 = this.viewLayer;
        boolean z = true;
        if (CompositingStrategy.m4958equalsimpl0(i, CompositingStrategy.Companion.m4964getOffscreenke2Ky5w())) {
            this.viewLayer.setLayerType(2, this.layerPaint);
        } else if (CompositingStrategy.m4958equalsimpl0(i, CompositingStrategy.Companion.m4963getModulateAlphake2Ky5w())) {
            this.viewLayer.setLayerType(0, this.layerPaint);
            z = false;
        } else {
            this.viewLayer.setLayerType(0, this.layerPaint);
        }
        viewLayer2.setCanUseCompositingLayer$ui_graphics_release(z);
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m5020applyCompositingLayerWpw9cng(CompositingStrategy.Companion.m4964getOffscreenke2Ky5w());
        } else {
            m5020applyCompositingLayerWpw9cng(m5023getCompositingStrategyke2Ky5w());
        }
    }

    private final Paint obtainLayerPaint() {
        Paint paint = this.layerPaint;
        if (paint != null) {
            return paint;
        }
        Paint paint2 = new Paint();
        this.layerPaint = paint2;
        return paint2;
    }

    private final boolean requiresCompositingLayer() {
        return CompositingStrategy.m4958equalsimpl0(m5023getCompositingStrategyke2Ky5w(), CompositingStrategy.Companion.m4964getOffscreenke2Ky5w()) || requiresLayerPaint();
    }

    private final boolean requiresLayerPaint() {
        return !BlendMode.m4139equalsimpl0(m5022getBlendMode0nO6VwU(), BlendMode.Companion.m4170getSrcOver0nO6VwU()) || getColorFilter() != null;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(float f) {
        this.alpha = f;
        this.viewLayer.setAlpha(f);
    }

    /* renamed from: getPivotOffset-F1C5BW0  reason: not valid java name */
    public long m5024getPivotOffsetF1C5BW0() {
        return this.pivotOffset;
    }

    /* renamed from: setPivotOffset-k-4lQ0M  reason: not valid java name */
    public void m5029setPivotOffsetk4lQ0M(long j) {
        this.pivotOffset = j;
        if (OffsetKt.m4008isUnspecifiedk4lQ0M(j)) {
            ViewLayerVerificationHelper28.INSTANCE.resetPivot(this.viewLayer);
            return;
        }
        this.shouldManuallySetCenterPivot = false;
        this.viewLayer.setPivotX(Offset.m3987getXimpl(j));
        this.viewLayer.setPivotY(Offset.m3988getYimpl(j));
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float f) {
        this.scaleX = f;
        this.viewLayer.setScaleX(f);
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float f) {
        this.scaleY = f;
        this.viewLayer.setScaleY(f);
    }

    public float getTranslationX() {
        return this.translationX;
    }

    public void setTranslationX(float f) {
        this.translationX = f;
        this.viewLayer.setTranslationX(f);
    }

    public float getTranslationY() {
        return this.translationY;
    }

    public void setTranslationY(float f) {
        this.translationY = f;
        this.viewLayer.setTranslationY(f);
    }

    public float getShadowElevation() {
        return this.shadowElevation;
    }

    public void setShadowElevation(float f) {
        this.shadowElevation = f;
        this.viewLayer.setElevation(f);
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    public long m5021getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
    public void m5026setAmbientShadowColor8_81llA(long j) {
        this.ambientShadowColor = j;
        ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this.viewLayer, ColorKt.m4293toArgb8_81llA(j));
    }

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    public long m5025getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
    public void m5031setSpotShadowColor8_81llA(long j) {
        this.spotShadowColor = j;
        ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this.viewLayer, ColorKt.m4293toArgb8_81llA(j));
    }

    public float getRotationX() {
        return this.rotationX;
    }

    public void setRotationX(float f) {
        this.rotationX = f;
        this.viewLayer.setRotationX(f);
    }

    public float getRotationY() {
        return this.rotationY;
    }

    public void setRotationY(float f) {
        this.rotationY = f;
        this.viewLayer.setRotationY(f);
    }

    public float getRotationZ() {
        return this.rotationZ;
    }

    public void setRotationZ(float f) {
        this.rotationZ = f;
        this.viewLayer.setRotation(f);
    }

    public float getCameraDistance() {
        return this.viewLayer.getCameraDistance() / ((float) this.resources.getDisplayMetrics().densityDpi);
    }

    public void setCameraDistance(float f) {
        this.viewLayer.setCameraDistance(f * ((float) this.resources.getDisplayMetrics().densityDpi));
    }

    public boolean getClip() {
        return this.clipToBounds || this.viewLayer.getClipToOutline();
    }

    public void setClip(boolean z) {
        boolean z2 = false;
        this.clipToBounds = z && !this.outlineIsProvided;
        this.clipBoundsInvalidated = true;
        ViewLayer viewLayer2 = this.viewLayer;
        if (z && this.outlineIsProvided) {
            z2 = true;
        }
        viewLayer2.setClipToOutline(z2);
    }

    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public void setRenderEffect(RenderEffect renderEffect2) {
        this.renderEffect = renderEffect2;
        if (Build.VERSION.SDK_INT >= 31) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this.viewLayer, renderEffect2);
        }
    }

    /* renamed from: setPosition-H0pRuoY  reason: not valid java name */
    public void m5030setPositionH0pRuoY(int i, int i2, long j) {
        if (!IntSize.m7281equalsimpl0(this.size, j)) {
            if (getClip()) {
                this.clipBoundsInvalidated = true;
            }
            this.viewLayer.layout(i, i2, IntSize.m7283getWidthimpl(j) + i, IntSize.m7282getHeightimpl(j) + i2);
            this.size = j;
            if (this.shouldManuallySetCenterPivot) {
                this.viewLayer.setPivotX(((float) IntSize.m7283getWidthimpl(j)) / 2.0f);
                this.viewLayer.setPivotY(((float) IntSize.m7282getHeightimpl(j)) / 2.0f);
            }
        } else {
            int i3 = this.x;
            if (i3 != i) {
                this.viewLayer.offsetLeftAndRight(i - i3);
            }
            int i4 = this.y;
            if (i4 != i2) {
                this.viewLayer.offsetTopAndBottom(i2 - i4);
            }
        }
        this.x = i;
        this.y = i2;
    }

    public void setOutline(Outline outline) {
        boolean layerOutline = this.viewLayer.setLayerOutline(outline);
        boolean z = false;
        if (getClip() && outline != null) {
            this.viewLayer.setClipToOutline(true);
            if (this.clipToBounds) {
                this.clipToBounds = false;
                this.clipBoundsInvalidated = true;
            }
        }
        if (outline != null) {
            z = true;
        }
        this.outlineIsProvided = z;
        if (!layerOutline) {
            this.viewLayer.invalidate();
            recordDrawingOperations();
        }
    }

    public void record(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1<? super DrawScope, Unit> function1) {
        CanvasHolder canvasHolder2;
        Canvas canvas;
        Density density2 = density;
        LayoutDirection layoutDirection2 = layoutDirection;
        Function1<? super DrawScope, Unit> function12 = function1;
        if (this.viewLayer.getParent() == null) {
            this.layerContainer.addView(this.viewLayer);
        }
        this.viewLayer.setDrawParams(density2, layoutDirection2, graphicsLayer, function12);
        if (this.viewLayer.isAttachedToWindow()) {
            this.viewLayer.setVisibility(4);
            this.viewLayer.setVisibility(0);
            recordDrawingOperations();
            Picture picture2 = this.picture;
            if (picture2 != null) {
                Canvas beginRecording = picture2.beginRecording(IntSize.m7283getWidthimpl(this.size), IntSize.m7282getHeightimpl(this.size));
                try {
                    CanvasHolder canvasHolder3 = this.pictureCanvasHolder;
                    if (canvasHolder3 != null) {
                        Canvas internalCanvas = canvasHolder3.getAndroidCanvas().getInternalCanvas();
                        canvasHolder3.getAndroidCanvas().setInternalCanvas(beginRecording);
                        androidx.compose.ui.graphics.Canvas androidCanvas = canvasHolder3.getAndroidCanvas();
                        CanvasDrawScope canvasDrawScope = this.pictureDrawScope;
                        if (canvasDrawScope != null) {
                            long r9 = IntSizeKt.m7295toSizeozmzZPI(this.size);
                            CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
                            Density component1 = drawParams.component1();
                            LayoutDirection component2 = drawParams.component2();
                            androidx.compose.ui.graphics.Canvas component3 = drawParams.component3();
                            canvasHolder2 = canvasHolder3;
                            canvas = internalCanvas;
                            long r6 = drawParams.m4761component4NHjbRc();
                            CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
                            drawParams2.setDensity(density2);
                            drawParams2.setLayoutDirection(layoutDirection2);
                            drawParams2.setCanvas(androidCanvas);
                            drawParams2.m4764setSizeuvyYCjk(r9);
                            androidCanvas.save();
                            function12.invoke(canvasDrawScope);
                            androidCanvas.restore();
                            CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
                            drawParams3.setDensity(component1);
                            drawParams3.setLayoutDirection(component2);
                            drawParams3.setCanvas(component3);
                            drawParams3.m4764setSizeuvyYCjk(r6);
                        } else {
                            canvasHolder2 = canvasHolder3;
                            canvas = internalCanvas;
                        }
                        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
                        Unit unit = Unit.INSTANCE;
                    }
                } finally {
                    picture2.endRecording();
                }
            }
        }
    }

    private final void recordDrawingOperations() {
        try {
            CanvasHolder canvasHolder2 = this.canvasHolder;
            Canvas canvas = PlaceholderCanvas;
            Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
            canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
            DrawChildContainer drawChildContainer = this.layerContainer;
            ViewLayer viewLayer2 = this.viewLayer;
            drawChildContainer.drawChild$ui_graphics_release(canvasHolder2.getAndroidCanvas(), viewLayer2, viewLayer2.getDrawingTime());
            canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
        } catch (Throwable unused) {
        }
    }

    public void draw(androidx.compose.ui.graphics.Canvas canvas) {
        updateClipBounds();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            DrawChildContainer drawChildContainer = this.layerContainer;
            ViewLayer viewLayer2 = this.viewLayer;
            drawChildContainer.drawChild$ui_graphics_release(canvas, viewLayer2, viewLayer2.getDrawingTime());
            return;
        }
        Picture picture2 = this.picture;
        if (picture2 != null) {
            nativeCanvas.drawPicture(picture2);
        }
    }

    public Matrix calculateMatrix() {
        return this.viewLayer.getMatrix();
    }

    private final void updateClipBounds() {
        Rect rect;
        if (this.clipBoundsInvalidated) {
            ViewLayer viewLayer2 = this.viewLayer;
            if (!getClip() || this.outlineIsProvided) {
                rect = null;
            } else {
                rect = this.clipRect;
                rect.left = 0;
                rect.top = 0;
                rect.right = this.viewLayer.getWidth();
                rect.bottom = this.viewLayer.getHeight();
            }
            viewLayer2.setClipBounds(rect);
        }
    }

    public void discardDisplayList() {
        this.layerContainer.removeViewInLayout(this.viewLayer);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer$Companion;", "", "()V", "PlaceholderCanvas", "Landroid/graphics/Canvas;", "getPlaceholderCanvas", "()Landroid/graphics/Canvas;", "mayRenderInSoftware", "", "getMayRenderInSoftware", "()Z", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: GraphicsViewLayer.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getMayRenderInSoftware() {
            return GraphicsViewLayer.mayRenderInSoftware;
        }

        public final Canvas getPlaceholderCanvas() {
            return GraphicsViewLayer.PlaceholderCanvas;
        }
    }
}
