package androidx.compose.ui.platform;

import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00128\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010<\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010=\u001a\u00020\u0010H\u0016J\u001a\u0010>\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0017\u0010?\u001a\u0004\u0018\u00010\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010AJ\b\u0010D\u001a\u00020\u0010H\u0016J\u001a\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001a\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020KH\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u0018\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0017H\u0016J\"\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020K2\u0006\u0010Q\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u001a\u0010V\u001a\u00020\u00102\u0006\u0010J\u001a\u00020WH\u0016ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ\u001a\u0010Z\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\b[\u0010YJP\u0010\\\u001a\u00020\u001028\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u001a\u0010]\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b^\u0010HJ\b\u0010_\u001a\u00020\u0010H\u0002J\b\u0010`\u001a\u00020\u0010H\u0016J\u0010\u0010a\u001a\u00020\u00102\u0006\u00101\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020\u0010H\u0002J\b\u0010d\u001a\u00020\u0010H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u00020\u0019X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010#R\u001f\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00100.¢\u0006\u0002\b0X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\u000204X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\u00020;X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "context", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "density", "Landroidx/compose/ui/unit/Density;", "drawnWithEnabledZ", "", "inverseMatrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "matrixCache", "mutatedFields", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "ownerViewId", "getOwnerViewId", "recordLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "scope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "tmpPath", "Landroidx/compose/ui/graphics/Path;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "clipManually", "destroy", "drawLayer", "getInverseMatrix", "getInverseMatrix-3i98HWw", "()[F", "getMatrix", "getMatrix-sQKQjiQ", "invalidate", "inverseTransform", "matrix", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "updateMatrix", "updateOutline", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsLayerOwnerLayer.android.kt */
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    private final GraphicsContext context;
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
    /* access modifiers changed from: private */
    public Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithEnabledZ;
    private GraphicsLayer graphicsLayer;
    private Function0<Unit> invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final float[] matrixCache = Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    private int mutatedFields;
    private Outline outline;
    private final AndroidComposeView ownerView;
    private final Function1<DrawScope, Unit> recordLambda = new GraphicsLayerOwnerLayer$recordLambda$1(this);
    private final CanvasDrawScope scope = new CanvasDrawScope();
    private long size = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private Paint softwareLayerPaint;
    private Path tmpPath;
    private long transformOrigin = TransformOrigin.Companion.m4673getCenterSzJe1aQ();

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer2, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.graphicsLayer = graphicsLayer2;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    public void updateLayerProperties(ReusableGraphicsLayerScope reusableGraphicsLayerScope) {
        boolean z;
        int i;
        Function0<Unit> function0;
        int mutatedFields$ui_release = reusableGraphicsLayerScope.getMutatedFields$ui_release() | this.mutatedFields;
        this.layoutDirection = reusableGraphicsLayerScope.getLayoutDirection$ui_release();
        this.density = reusableGraphicsLayerScope.getGraphicsDensity$ui_release();
        int i2 = mutatedFields$ui_release & 4096;
        if (i2 != 0) {
            this.transformOrigin = reusableGraphicsLayerScope.m4583getTransformOriginSzJe1aQ();
        }
        if ((mutatedFields$ui_release & 1) != 0) {
            this.graphicsLayer.setScaleX(reusableGraphicsLayerScope.getScaleX());
        }
        if ((mutatedFields$ui_release & 2) != 0) {
            this.graphicsLayer.setScaleY(reusableGraphicsLayerScope.getScaleY());
        }
        if ((mutatedFields$ui_release & 4) != 0) {
            this.graphicsLayer.setAlpha(reusableGraphicsLayerScope.getAlpha());
        }
        if ((mutatedFields$ui_release & 8) != 0) {
            this.graphicsLayer.setTranslationX(reusableGraphicsLayerScope.getTranslationX());
        }
        if ((mutatedFields$ui_release & 16) != 0) {
            this.graphicsLayer.setTranslationY(reusableGraphicsLayerScope.getTranslationY());
        }
        if ((mutatedFields$ui_release & 32) != 0) {
            this.graphicsLayer.setShadowElevation(reusableGraphicsLayerScope.getShadowElevation());
            if (reusableGraphicsLayerScope.getShadowElevation() > 0.0f && !this.drawnWithEnabledZ && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
        if ((mutatedFields$ui_release & 64) != 0) {
            this.graphicsLayer.m4977setAmbientShadowColor8_81llA(reusableGraphicsLayerScope.m4579getAmbientShadowColor0d7_KjU());
        }
        if ((mutatedFields$ui_release & 128) != 0) {
            this.graphicsLayer.m4983setSpotShadowColor8_81llA(reusableGraphicsLayerScope.m4582getSpotShadowColor0d7_KjU());
        }
        if ((mutatedFields$ui_release & 1024) != 0) {
            this.graphicsLayer.setRotationZ(reusableGraphicsLayerScope.getRotationZ());
        }
        if ((mutatedFields$ui_release & 256) != 0) {
            this.graphicsLayer.setRotationX(reusableGraphicsLayerScope.getRotationX());
        }
        if ((mutatedFields$ui_release & 512) != 0) {
            this.graphicsLayer.setRotationY(reusableGraphicsLayerScope.getRotationY());
        }
        if ((mutatedFields$ui_release & 2048) != 0) {
            this.graphicsLayer.setCameraDistance(reusableGraphicsLayerScope.getCameraDistance());
        }
        if (i2 != 0) {
            if (TransformOrigin.m4667equalsimpl0(this.transformOrigin, TransformOrigin.Companion.m4673getCenterSzJe1aQ())) {
                this.graphicsLayer.m4980setPivotOffsetk4lQ0M(Offset.Companion.m4002getUnspecifiedF1C5BW0());
            } else {
                this.graphicsLayer.m4980setPivotOffsetk4lQ0M(OffsetKt.Offset(TransformOrigin.m4668getPivotFractionXimpl(this.transformOrigin) * ((float) IntSize.m7283getWidthimpl(this.size)), TransformOrigin.m4669getPivotFractionYimpl(this.transformOrigin) * ((float) IntSize.m7282getHeightimpl(this.size))));
            }
        }
        if ((mutatedFields$ui_release & 16384) != 0) {
            this.graphicsLayer.setClip(reusableGraphicsLayerScope.getClip());
        }
        if ((131072 & mutatedFields$ui_release) != 0) {
            this.graphicsLayer.setRenderEffect(reusableGraphicsLayerScope.getRenderEffect());
        }
        if ((32768 & mutatedFields$ui_release) != 0) {
            GraphicsLayer graphicsLayer2 = this.graphicsLayer;
            int r2 = reusableGraphicsLayerScope.m4580getCompositingStrategyNrFUSI();
            if (CompositingStrategy.m4325equalsimpl0(r2, CompositingStrategy.Companion.m4329getAutoNrFUSI())) {
                i = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.m4962getAutoke2Ky5w();
            } else if (CompositingStrategy.m4325equalsimpl0(r2, CompositingStrategy.Companion.m4331getOffscreenNrFUSI())) {
                i = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.m4964getOffscreenke2Ky5w();
            } else if (CompositingStrategy.m4325equalsimpl0(r2, CompositingStrategy.Companion.m4330getModulateAlphaNrFUSI())) {
                i = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.m4963getModulateAlphake2Ky5w();
            } else {
                throw new IllegalStateException("Not supported composition strategy");
            }
            graphicsLayer2.m4979setCompositingStrategyWpw9cng(i);
        }
        if (!Intrinsics.areEqual((Object) this.outline, (Object) reusableGraphicsLayerScope.getOutline$ui_release())) {
            this.outline = reusableGraphicsLayerScope.getOutline$ui_release();
            updateOutline();
            z = true;
        } else {
            z = false;
        }
        this.mutatedFields = reusableGraphicsLayerScope.getMutatedFields$ui_release();
        if (mutatedFields$ui_release != 0 || z) {
            triggerRepaint();
        }
    }

    private final void triggerRepaint() {
        WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
    }

    private final void updateOutline() {
        Function0<Unit> function0;
        Outline outline2 = this.outline;
        if (outline2 != null) {
            GraphicsLayerKt.setOutline(this.graphicsLayer, outline2);
            if ((outline2 instanceof Outline.Generic) && Build.VERSION.SDK_INT < 33 && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
    }

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    public boolean m6286isInLayerk4lQ0M(long j) {
        float r1 = Offset.m3987getXimpl(j);
        float r2 = Offset.m3988getYimpl(j);
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), r1, r2, (Path) null, (Path) null, 24, (Object) null);
        }
        return true;
    }

    /* renamed from: move--gyyYBs  reason: not valid java name */
    public void m6288movegyyYBs(long j) {
        this.graphicsLayer.m4984setTopLeftgyyYBs(j);
        triggerRepaint();
    }

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    public void m6289resizeozmzZPI(long j) {
        if (!IntSize.m7281equalsimpl0(j, this.size)) {
            this.size = j;
            invalidate();
        }
    }

    public void drawLayer(Canvas canvas, GraphicsLayer graphicsLayer2) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            this.drawnWithEnabledZ = this.graphicsLayer.getShadowElevation() > 0.0f;
            DrawContext drawContext = this.scope.getDrawContext();
            drawContext.setCanvas(canvas);
            drawContext.setGraphicsLayer(graphicsLayer2);
            GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
            return;
        }
        float r1 = (float) IntOffset.m7241getXimpl(this.graphicsLayer.m4975getTopLeftnOccac());
        float r2 = (float) IntOffset.m7242getYimpl(this.graphicsLayer.m4975getTopLeftnOccac());
        float r3 = r1 + ((float) IntSize.m7283getWidthimpl(this.size));
        float r4 = r2 + ((float) IntSize.m7282getHeightimpl(this.size));
        if (this.graphicsLayer.getAlpha() < 1.0f) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(this.graphicsLayer.getAlpha());
            nativeCanvas.saveLayer(r1, r2, r3, r4, paint.asFrameworkPaint());
        } else {
            canvas.save();
        }
        canvas.translate(r1, r2);
        canvas.m4207concat58bKbWc(m6284getMatrixsQKQjiQ());
        if (this.graphicsLayer.getClip()) {
            clipManually(canvas);
        }
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(canvas, null);
        }
        canvas.restore();
    }

    public void updateDisplayList() {
        if (this.isDirty) {
            if (!TransformOrigin.m4667equalsimpl0(this.transformOrigin, TransformOrigin.Companion.m4673getCenterSzJe1aQ()) && !IntSize.m7281equalsimpl0(this.graphicsLayer.m4973getSizeYbymL2g(), this.size)) {
                this.graphicsLayer.m4980setPivotOffsetk4lQ0M(OffsetKt.Offset(TransformOrigin.m4668getPivotFractionXimpl(this.transformOrigin) * ((float) IntSize.m7283getWidthimpl(this.size)), TransformOrigin.m4669getPivotFractionYimpl(this.transformOrigin) * ((float) IntSize.m7282getHeightimpl(this.size))));
            }
            this.graphicsLayer.m4976recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }

    public void invalidate() {
        if (!this.isDirty && !this.isDestroyed) {
            this.ownerView.invalidate();
            setDirty(true);
        }
    }

    public void destroy() {
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui_release(this);
        }
    }

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    public long m6287mapOffset8S9VItk(long j, boolean z) {
        if (!z) {
            return Matrix.m4480mapMKHz9U(m6284getMatrixsQKQjiQ(), j);
        }
        float[] r3 = m6283getInverseMatrix3i98HWw();
        return r3 != null ? Matrix.m4480mapMKHz9U(r3, j) : Offset.Companion.m4001getInfiniteF1C5BW0();
    }

    public void mapBounds(MutableRect mutableRect, boolean z) {
        if (z) {
            float[] r2 = m6283getInverseMatrix3i98HWw();
            if (r2 == null) {
                mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                Matrix.m4482mapimpl(r2, mutableRect);
            }
        } else {
            Matrix.m4482mapimpl(m6284getMatrixsQKQjiQ(), mutableRect);
        }
    }

    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext == null) {
            throw new IllegalArgumentException("currently reuse is only supported when we manage the layer lifecycle".toString());
        } else if (this.graphicsLayer.isReleased()) {
            this.graphicsLayer = graphicsContext.createGraphicsLayer();
            this.isDestroyed = false;
            this.drawBlock = function2;
            this.invalidateParentLayer = function0;
            this.transformOrigin = TransformOrigin.Companion.m4673getCenterSzJe1aQ();
            this.drawnWithEnabledZ = false;
            this.size = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
            this.outline = null;
            this.mutatedFields = 0;
        } else {
            throw new IllegalArgumentException("layer should have been released before reuse".toString());
        }
    }

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    public void m6290transform58bKbWc(float[] fArr) {
        Matrix.m4491timesAssign58bKbWc(fArr, m6284getMatrixsQKQjiQ());
    }

    /* renamed from: inverseTransform-58bKbWc  reason: not valid java name */
    public void m6285inverseTransform58bKbWc(float[] fArr) {
        float[] r0 = m6283getInverseMatrix3i98HWw();
        if (r0 != null) {
            Matrix.m4491timesAssign58bKbWc(fArr, r0);
        }
    }

    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    /* renamed from: getMatrix-sQKQjiQ  reason: not valid java name */
    private final float[] m6284getMatrixsQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
    }

    /* renamed from: getInverseMatrix-3i98HWw  reason: not valid java name */
    private final float[] m6283getInverseMatrix3i98HWw() {
        float[] r0 = m6284getMatrixsQKQjiQ();
        float[] fArr = this.inverseMatrixCache;
        if (fArr == null) {
            fArr = Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
            this.inverseMatrixCache = fArr;
        }
        if (InvertMatrixKt.m6291invertToJiSxe2E(r0, fArr)) {
            return fArr;
        }
        return null;
    }

    private final void updateMatrix() {
        long j;
        GraphicsLayer graphicsLayer2 = this.graphicsLayer;
        if (OffsetKt.m4008isUnspecifiedk4lQ0M(graphicsLayer2.m4972getPivotOffsetF1C5BW0())) {
            j = SizeKt.m4066getCenteruvyYCjk(IntSizeKt.m7295toSizeozmzZPI(this.size));
        } else {
            j = graphicsLayer2.m4972getPivotOffsetF1C5BW0();
        }
        Matrix.m4483resetimpl(this.matrixCache);
        float[] fArr = this.matrixCache;
        float[] r6 = Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        Matrix.m4494translateimpl$default(r6, -Offset.m3987getXimpl(j), -Offset.m3988getYimpl(j), 0.0f, 4, (Object) null);
        Matrix.m4491timesAssign58bKbWc(fArr, r6);
        float[] fArr2 = this.matrixCache;
        float[] r62 = Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        Matrix.m4494translateimpl$default(r62, graphicsLayer2.getTranslationX(), graphicsLayer2.getTranslationY(), 0.0f, 4, (Object) null);
        Matrix.m4484rotateXimpl(r62, graphicsLayer2.getRotationX());
        Matrix.m4485rotateYimpl(r62, graphicsLayer2.getRotationY());
        Matrix.m4486rotateZimpl(r62, graphicsLayer2.getRotationZ());
        Matrix.m4488scaleimpl$default(r62, graphicsLayer2.getScaleX(), graphicsLayer2.getScaleY(), 0.0f, 4, (Object) null);
        Matrix.m4491timesAssign58bKbWc(fArr2, r62);
        float[] fArr3 = this.matrixCache;
        float[] r63 = Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        Matrix.m4494translateimpl$default(r63, Offset.m3987getXimpl(j), Offset.m3988getYimpl(j), 0.0f, 4, (Object) null);
        Matrix.m4491timesAssign58bKbWc(fArr3, r63);
    }

    private final void clipManually(Canvas canvas) {
        if (this.graphicsLayer.getClip()) {
            Outline outline2 = this.graphicsLayer.getOutline();
            if (outline2 instanceof Outline.Rectangle) {
                Canvas.m4202clipRectmtrdDE$default(canvas, ((Outline.Rectangle) outline2).getRect(), 0, 2, (Object) null);
            } else if (outline2 instanceof Outline.Rounded) {
                Path path = this.tmpPath;
                if (path == null) {
                    path = AndroidPath_androidKt.Path();
                    this.tmpPath = path;
                }
                path.reset();
                Path.addRoundRect$default(path, ((Outline.Rounded) outline2).getRoundRect(), (Path.Direction) null, 2, (Object) null);
                Canvas.m4200clipPathmtrdDE$default(canvas, path, 0, 2, (Object) null);
            } else if (outline2 instanceof Outline.Generic) {
                Canvas.m4200clipPathmtrdDE$default(canvas, ((Outline.Generic) outline2).getPath(), 0, 2, (Object) null);
            }
        }
    }
}
