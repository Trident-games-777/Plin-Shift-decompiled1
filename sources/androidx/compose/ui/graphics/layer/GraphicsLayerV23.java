package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010k\u001a\u00020lH\u0002J\u001a\u0010m\u001a\u00020l2\u0006\u00102\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010\u001eJ\b\u0010o\u001a\u00020>H\u0016J\b\u0010p\u001a\u00020lH\u0016J\r\u0010q\u001a\u00020lH\u0000¢\u0006\u0002\brJ\u0010\u0010s\u001a\u00020l2\u0006\u0010t\u001a\u00020uH\u0016J\b\u0010v\u001a\u00020<H\u0002J;\u0010w\u001a\u00020l2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}2\u0019\u0010~\u001a\u0015\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020l0¢\u0006\u0003\b\u0001H\u0016J\t\u0010\u0001\u001a\u00020#H\u0002J\u0015\u0010\u0001\u001a\u00020l2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J1\u0010\u0001\u001a\u00020l2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010`\u001a\u00020aH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020lH\u0002J\u0011\u0010\u0001\u001a\u00020l2\u0006\u0010K\u001a\u00020LH\u0002R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0019@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R(\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u000b\u001a\u0004\u0018\u00010+@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R,\u00102\u001a\u0002012\u0006\u0010\u000b\u001a\u000201@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u0014\u00105\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010&R\u001a\u00107\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R\u0014\u00109\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0015R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0015R,\u0010B\u001a\u00020A2\u0006\u0010\u000b\u001a\u00020A@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020LX\u0004¢\u0006\u0002\n\u0000R$\u0010M\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u000f\"\u0004\bO\u0010\u0011R$\u0010P\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u000f\"\u0004\bR\u0010\u0011R$\u0010S\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u000f\"\u0004\bU\u0010\u0011R$\u0010V\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000f\"\u0004\bX\u0010\u0011R$\u0010Y\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000f\"\u0004\b[\u0010\u0011R$\u0010\\\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000f\"\u0004\b^\u0010\u0011R\u000e\u0010_\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010`\u001a\u00020aX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R,\u0010b\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\bc\u0010\u0015\"\u0004\bd\u0010\u0017R$\u0010e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u000f\"\u0004\bg\u0010\u0011R$\u0010h\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000f\"\u0004\bj\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "ownerView", "Landroid/view/View;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroid/view/View;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "hasDisplayList", "getHasDisplayList", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "getOwnerId", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/view/RenderNode;", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shouldManuallySetCenterPivot", "size", "Landroidx/compose/ui/unit/IntSize;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "applyClip", "", "applyCompositingStrategy", "applyCompositingStrategy-Wpw9cng", "calculateMatrix", "discardDisplayList", "discardDisplayListInternal", "discardDisplayListInternal$ui_graphics_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "obtainLayerPaint", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "requiresCompositingLayer", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "x", "", "y", "setPosition-H0pRuoY", "(IIJ)V", "updateLayerProperties", "verifyShadowColorProperties", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsLayerV23.android.kt */
public final class GraphicsLayerV23 implements GraphicsLayerImpl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final AtomicBoolean needToValidateAccess = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public static boolean testFailCreateRenderNode;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private boolean clip;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final long layerId;
    private Paint layerPaint;
    private Matrix matrix;
    private boolean outlineIsProvided;
    private final long ownerId;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
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

    public GraphicsLayerV23(View view, long j, CanvasHolder canvasHolder2, CanvasDrawScope canvasDrawScope2) {
        this.ownerId = j;
        this.canvasHolder = canvasHolder2;
        this.canvasDrawScope = canvasDrawScope2;
        RenderNode create = RenderNode.create("Compose", view);
        this.renderNode = create;
        this.size = IntSize.Companion.m7288getZeroYbymL2g();
        if (needToValidateAccess.getAndSet(false)) {
            create.setScaleX(create.getScaleX());
            create.setScaleY(create.getScaleY());
            create.setTranslationX(create.getTranslationX());
            create.setTranslationY(create.getTranslationY());
            create.setElevation(create.getElevation());
            create.setRotation(create.getRotation());
            create.setRotationX(create.getRotationX());
            create.setRotationY(create.getRotationY());
            create.setCameraDistance(create.getCameraDistance());
            create.setPivotX(create.getPivotX());
            create.setPivotY(create.getPivotY());
            create.setClipToOutline(create.getClipToOutline());
            create.setClipToBounds(false);
            create.setAlpha(create.getAlpha());
            create.isValid();
            create.setLeftTopRightBottom(0, 0, 0, 0);
            create.offsetLeftAndRight(0);
            create.offsetTopAndBottom(0);
            verifyShadowColorProperties(create);
            discardDisplayListInternal$ui_graphics_release();
            create.setLayerType(0);
            create.setHasOverlappingRendering(create.hasOverlappingRendering());
        }
        if (!testFailCreateRenderNode) {
            create.setClipToBounds(false);
            m4996applyCompositingStrategyWpw9cng(CompositingStrategy.Companion.m4962getAutoke2Ky5w());
            this.compositingStrategy = CompositingStrategy.Companion.m4962getAutoke2Ky5w();
            this.blendMode = BlendMode.Companion.m4170getSrcOver0nO6VwU();
            this.alpha = 1.0f;
            this.pivotOffset = Offset.Companion.m4002getUnspecifiedF1C5BW0();
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.ambientShadowColor = Color.Companion.m4265getBlack0d7_KjU();
            this.spotShadowColor = Color.Companion.m4265getBlack0d7_KjU();
            this.cameraDistance = 8.0f;
            this.isInvalidated = true;
            return;
        }
        throw new NoClassDefFoundError();
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GraphicsLayerV23(View view, long j, CanvasHolder canvasHolder2, CanvasDrawScope canvasDrawScope2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, j, (i & 4) != 0 ? new CanvasHolder() : canvasHolder2, (i & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope2);
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

    /* renamed from: getCompositingStrategy-ke2Ky5w  reason: not valid java name */
    public int m4999getCompositingStrategyke2Ky5w() {
        return this.compositingStrategy;
    }

    /* renamed from: setCompositingStrategy-Wpw9cng  reason: not valid java name */
    public void m5004setCompositingStrategyWpw9cng(int i) {
        this.compositingStrategy = i;
        updateLayerProperties();
    }

    /* renamed from: applyCompositingStrategy-Wpw9cng  reason: not valid java name */
    private final void m4996applyCompositingStrategyWpw9cng(int i) {
        RenderNode renderNode2 = this.renderNode;
        if (CompositingStrategy.m4958equalsimpl0(i, CompositingStrategy.Companion.m4964getOffscreenke2Ky5w())) {
            renderNode2.setLayerType(2);
            renderNode2.setLayerPaint(this.layerPaint);
            renderNode2.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m4958equalsimpl0(i, CompositingStrategy.Companion.m4963getModulateAlphake2Ky5w())) {
            renderNode2.setLayerType(0);
            renderNode2.setLayerPaint(this.layerPaint);
            renderNode2.setHasOverlappingRendering(false);
        } else {
            renderNode2.setLayerType(0);
            renderNode2.setLayerPaint(this.layerPaint);
            renderNode2.setHasOverlappingRendering(true);
        }
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public int m4998getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    public void m5003setBlendModes9anfk8(int i) {
        if (!BlendMode.m4139equalsimpl0(this.blendMode, i)) {
            this.blendMode = i;
            obtainLayerPaint().setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m4080toPorterDuffModes9anfk8(i)));
            updateLayerProperties();
        }
    }

    private final boolean requiresCompositingLayer() {
        return CompositingStrategy.m4958equalsimpl0(m4999getCompositingStrategyke2Ky5w(), CompositingStrategy.Companion.m4964getOffscreenke2Ky5w()) || !BlendMode.m4139equalsimpl0(m4998getBlendMode0nO6VwU(), BlendMode.Companion.m4170getSrcOver0nO6VwU()) || getColorFilter() != null;
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m4996applyCompositingStrategyWpw9cng(CompositingStrategy.Companion.m4964getOffscreenke2Ky5w());
        } else {
            m4996applyCompositingStrategyWpw9cng(m4999getCompositingStrategyke2Ky5w());
        }
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public void setColorFilter(ColorFilter colorFilter2) {
        this.colorFilter = colorFilter2;
        if (colorFilter2 != null) {
            m4996applyCompositingStrategyWpw9cng(CompositingStrategy.Companion.m4964getOffscreenke2Ky5w());
            RenderNode renderNode2 = this.renderNode;
            Paint obtainLayerPaint = obtainLayerPaint();
            obtainLayerPaint.setColorFilter(AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter2));
            renderNode2.setLayerPaint(obtainLayerPaint);
            return;
        }
        updateLayerProperties();
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(float f) {
        this.alpha = f;
        this.renderNode.setAlpha(f);
    }

    /* renamed from: getPivotOffset-F1C5BW0  reason: not valid java name */
    public long m5000getPivotOffsetF1C5BW0() {
        return this.pivotOffset;
    }

    /* renamed from: setPivotOffset-k-4lQ0M  reason: not valid java name */
    public void m5005setPivotOffsetk4lQ0M(long j) {
        this.pivotOffset = j;
        if (OffsetKt.m4008isUnspecifiedk4lQ0M(j)) {
            this.shouldManuallySetCenterPivot = true;
            this.renderNode.setPivotX(((float) IntSize.m7283getWidthimpl(this.size)) / 2.0f);
            this.renderNode.setPivotY(((float) IntSize.m7282getHeightimpl(this.size)) / 2.0f);
            return;
        }
        this.shouldManuallySetCenterPivot = false;
        this.renderNode.setPivotX(Offset.m3987getXimpl(j));
        this.renderNode.setPivotY(Offset.m3988getYimpl(j));
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float f) {
        this.scaleX = f;
        this.renderNode.setScaleX(f);
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float f) {
        this.scaleY = f;
        this.renderNode.setScaleY(f);
    }

    public float getTranslationX() {
        return this.translationX;
    }

    public void setTranslationX(float f) {
        this.translationX = f;
        this.renderNode.setTranslationX(f);
    }

    public float getTranslationY() {
        return this.translationY;
    }

    public void setTranslationY(float f) {
        this.translationY = f;
        this.renderNode.setTranslationY(f);
    }

    public float getShadowElevation() {
        return this.shadowElevation;
    }

    public void setShadowElevation(float f) {
        this.shadowElevation = f;
        this.renderNode.setElevation(f);
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    public long m4997getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
    public void m5002setAmbientShadowColor8_81llA(long j) {
        this.ambientShadowColor = j;
        RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, ColorKt.m4293toArgb8_81llA(j));
    }

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    public long m5001getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
    public void m5007setSpotShadowColor8_81llA(long j) {
        this.spotShadowColor = j;
        RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, ColorKt.m4293toArgb8_81llA(j));
    }

    public float getRotationX() {
        return this.rotationX;
    }

    public void setRotationX(float f) {
        this.rotationX = f;
        this.renderNode.setRotationX(f);
    }

    public float getRotationY() {
        return this.rotationY;
    }

    public void setRotationY(float f) {
        this.rotationY = f;
        this.renderNode.setRotationY(f);
    }

    public float getRotationZ() {
        return this.rotationZ;
    }

    public void setRotationZ(float f) {
        this.rotationZ = f;
        this.renderNode.setRotation(f);
    }

    public float getCameraDistance() {
        return this.cameraDistance;
    }

    public void setCameraDistance(float f) {
        this.cameraDistance = f;
        this.renderNode.setCameraDistance(-f);
    }

    public boolean getClip() {
        return this.clip;
    }

    public void setClip(boolean z) {
        this.clip = z;
        applyClip();
    }

    private final void applyClip() {
        boolean z = true;
        boolean z2 = getClip() && !this.outlineIsProvided;
        if (!getClip() || !this.outlineIsProvided) {
            z = false;
        }
        if (z2 != this.clipToBounds) {
            this.clipToBounds = z2;
            this.renderNode.setClipToBounds(z2);
        }
        if (z != this.clipToOutline) {
            this.clipToOutline = z;
            this.renderNode.setClipToOutline(z);
        }
    }

    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public void setRenderEffect(RenderEffect renderEffect2) {
        this.renderEffect = renderEffect2;
    }

    /* renamed from: setPosition-H0pRuoY  reason: not valid java name */
    public void m5006setPositionH0pRuoY(int i, int i2, long j) {
        this.renderNode.setLeftTopRightBottom(i, i2, IntSize.m7283getWidthimpl(j) + i, IntSize.m7282getHeightimpl(j) + i2);
        if (!IntSize.m7281equalsimpl0(this.size, j)) {
            if (this.shouldManuallySetCenterPivot) {
                this.renderNode.setPivotX(((float) IntSize.m7283getWidthimpl(j)) / 2.0f);
                this.renderNode.setPivotY(((float) IntSize.m7282getHeightimpl(j)) / 2.0f);
            }
            this.size = j;
        }
    }

    public void setOutline(Outline outline) {
        this.renderNode.setOutline(outline);
        this.outlineIsProvided = outline != null;
        applyClip();
    }

    public boolean isInvalidated() {
        return this.isInvalidated;
    }

    public void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    public void record(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1<? super DrawScope, Unit> function1) {
        Canvas androidCanvas;
        DrawScope drawScope;
        Density density2;
        LayoutDirection layoutDirection2;
        Canvas canvas;
        long r11;
        GraphicsLayer graphicsLayer2;
        android.graphics.Canvas start = this.renderNode.start(IntSize.m7283getWidthimpl(this.size), IntSize.m7282getHeightimpl(this.size));
        try {
            CanvasHolder canvasHolder2 = this.canvasHolder;
            android.graphics.Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
            canvasHolder2.getAndroidCanvas().setInternalCanvas(start);
            androidCanvas = canvasHolder2.getAndroidCanvas();
            drawScope = this.canvasDrawScope;
            long r6 = IntSizeKt.m7295toSizeozmzZPI(this.size);
            density2 = drawScope.getDrawContext().getDensity();
            layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
            canvas = drawScope.getDrawContext().getCanvas();
            r11 = drawScope.getDrawContext().m4806getSizeNHjbRc();
            graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
            DrawContext drawContext = drawScope.getDrawContext();
            drawContext.setDensity(density);
            drawContext.setLayoutDirection(layoutDirection);
            drawContext.setCanvas(androidCanvas);
            drawContext.m4807setSizeuvyYCjk(r6);
            drawContext.setGraphicsLayer(graphicsLayer);
            androidCanvas.save();
            function1.invoke(drawScope);
            androidCanvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas);
            drawContext2.m4807setSizeuvyYCjk(r11);
            drawContext2.setGraphicsLayer(graphicsLayer2);
            canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
            this.renderNode.end(start);
            setInvalidated(false);
        } catch (Throwable th) {
            this.renderNode.end(start);
            throw th;
        }
    }

    public void draw(Canvas canvas) {
        DisplayListCanvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        Intrinsics.checkNotNull(nativeCanvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        nativeCanvas.drawRenderNode(this.renderNode);
    }

    public Matrix calculateMatrix() {
        Matrix matrix2 = this.matrix;
        if (matrix2 == null) {
            matrix2 = new Matrix();
            this.matrix = matrix2;
        }
        this.renderNode.getMatrix(matrix2);
        return matrix2;
    }

    public void discardDisplayList() {
        discardDisplayListInternal$ui_graphics_release();
    }

    public long getLayerId() {
        return this.layerId;
    }

    private final void verifyShadowColorProperties(RenderNode renderNode2) {
        RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(renderNode2, RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(renderNode2));
        RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(renderNode2, RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(renderNode2));
    }

    public final void discardDisplayListInternal$ui_graphics_release() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23$Companion;", "", "()V", "needToValidateAccess", "Ljava/util/concurrent/atomic/AtomicBoolean;", "testFailCreateRenderNode", "", "getTestFailCreateRenderNode$ui_graphics_release", "()Z", "setTestFailCreateRenderNode$ui_graphics_release", "(Z)V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: GraphicsLayerV23.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getTestFailCreateRenderNode$ui_graphics_release() {
            return GraphicsLayerV23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_graphics_release(boolean z) {
            GraphicsLayerV23.testFailCreateRenderNode = z;
        }
    }
}
