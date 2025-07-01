package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Fields;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002noB]\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00128\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\b\u0010>\u001a\u00020\u0010H\u0016J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020@H\u0014J\u001a\u0010A\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010B\u001a\u00020\u0010H\u0016J\b\u0010C\u001a\u00020 H\u0016J\b\u0010D\u001a\u00020\u0010H\u0016J\u001a\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u001a\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020LH\u0016ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u0018\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020 H\u0016J\"\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020L2\u0006\u0010R\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001a\u0010W\u001a\u00020\u00102\u0006\u0010K\u001a\u00020XH\u0016ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ0\u0010[\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020 2\u0006\u0010]\u001a\u0002072\u0006\u0010^\u001a\u0002072\u0006\u0010_\u001a\u0002072\u0006\u0010`\u001a\u000207H\u0014J\b\u0010a\u001a\u00020\u0010H\u0002J\u001a\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020dH\u0016ø\u0001\u0000¢\u0006\u0004\be\u0010ZJP\u0010f\u001a\u00020\u001028\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u001a\u0010g\u001a\u00020\u00102\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bh\u0010IJ\b\u0010i\u001a\u00020\u0010H\u0016J\u0010\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020\u0010H\u0002R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"RB\u0010\b\u001a6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020 @BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\u00020.X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018BX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u000105X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010+\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006p"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "container", "Landroidx/compose/ui/platform/DrawChildContainer;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "value", "", "cameraDistancePx", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipBoundsCache", "Landroid/graphics/Rect;", "clipToBounds", "", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "drawnWithZ", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "layerId", "", "getLayerId", "()J", "mHasOverlappingRendering", "mTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "manualClipPath", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "mutatedFields", "", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "destroy", "dispatchDraw", "Landroid/graphics/Canvas;", "drawLayer", "forceLayout", "hasOverlappingRendering", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "onLayout", "changed", "l", "t", "r", "b", "resetClipBounds", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "updateOutlineResolver", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewLayer.android.kt */
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ViewOutlineProvider OutlineProvider = new ViewLayer$Companion$OutlineProvider$1();
    private static final Function2<View, Matrix, Unit> getMatrix = ViewLayer$Companion$getMatrix$1.INSTANCE;
    /* access modifiers changed from: private */
    public static boolean hasRetrievedMethod;
    /* access modifiers changed from: private */
    public static Field recreateDisplayList;
    /* access modifiers changed from: private */
    public static boolean shouldUseDispatchDraw;
    /* access modifiers changed from: private */
    public static Method updateDisplayListIfDirtyMethod;
    private final CanvasHolder canvasHolder = new CanvasHolder();
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    private final DrawChildContainer container;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isInvalidated;
    private final long layerId;
    private boolean mHasOverlappingRendering = true;
    private long mTransformOrigin = TransformOrigin.Companion.m4673getCenterSzJe1aQ();
    private final LayerMatrixCache<View> matrixCache = new LayerMatrixCache<>(getMatrix);
    private int mutatedFields;
    /* access modifiers changed from: private */
    public final OutlineResolver outlineResolver = new OutlineResolver();
    private final AndroidComposeView ownerView;

    public void forceLayout() {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    public ViewLayer(AndroidComposeView androidComposeView, DrawChildContainer drawChildContainer, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        super(androidComposeView.getContext());
        this.ownerView = androidComposeView;
        this.container = drawChildContainer;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.layerId = (long) View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    private final void setInvalidated(boolean z) {
        if (z != this.isInvalidated) {
            this.isInvalidated = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    public long getLayerId() {
        return this.layerId;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewLayer.android.kt */
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return view.getUniqueDrawingId();
        }
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / ((float) getResources().getDisplayMetrics().densityDpi);
    }

    public final void setCameraDistancePx(float f) {
        setCameraDistance(f * ((float) getResources().getDisplayMetrics().densityDpi));
    }

    public void updateLayerProperties(ReusableGraphicsLayerScope reusableGraphicsLayerScope) {
        Function0<Unit> function0;
        int mutatedFields$ui_release = reusableGraphicsLayerScope.getMutatedFields$ui_release() | this.mutatedFields;
        if ((mutatedFields$ui_release & 4096) != 0) {
            long r1 = reusableGraphicsLayerScope.m4583getTransformOriginSzJe1aQ();
            this.mTransformOrigin = r1;
            setPivotX(TransformOrigin.m4668getPivotFractionXimpl(r1) * ((float) getWidth()));
            setPivotY(TransformOrigin.m4669getPivotFractionYimpl(this.mTransformOrigin) * ((float) getHeight()));
        }
        if ((mutatedFields$ui_release & 1) != 0) {
            setScaleX(reusableGraphicsLayerScope.getScaleX());
        }
        if ((mutatedFields$ui_release & 2) != 0) {
            setScaleY(reusableGraphicsLayerScope.getScaleY());
        }
        if ((mutatedFields$ui_release & 4) != 0) {
            setAlpha(reusableGraphicsLayerScope.getAlpha());
        }
        if ((mutatedFields$ui_release & 8) != 0) {
            setTranslationX(reusableGraphicsLayerScope.getTranslationX());
        }
        if ((mutatedFields$ui_release & 16) != 0) {
            setTranslationY(reusableGraphicsLayerScope.getTranslationY());
        }
        if ((mutatedFields$ui_release & 32) != 0) {
            setElevation(reusableGraphicsLayerScope.getShadowElevation());
        }
        if ((mutatedFields$ui_release & 1024) != 0) {
            setRotation(reusableGraphicsLayerScope.getRotationZ());
        }
        if ((mutatedFields$ui_release & 256) != 0) {
            setRotationX(reusableGraphicsLayerScope.getRotationX());
        }
        if ((mutatedFields$ui_release & 512) != 0) {
            setRotationY(reusableGraphicsLayerScope.getRotationY());
        }
        if ((mutatedFields$ui_release & 2048) != 0) {
            setCameraDistancePx(reusableGraphicsLayerScope.getCameraDistance());
        }
        boolean z = false;
        boolean z2 = getManualClipPath() != null;
        boolean z3 = reusableGraphicsLayerScope.getClip() && reusableGraphicsLayerScope.getShape() != RectangleShapeKt.getRectangleShape();
        if ((mutatedFields$ui_release & 24576) != 0) {
            this.clipToBounds = reusableGraphicsLayerScope.getClip() && reusableGraphicsLayerScope.getShape() == RectangleShapeKt.getRectangleShape();
            resetClipBounds();
            setClipToOutline(z3);
        }
        boolean r4 = this.outlineResolver.m6321updateS_szKao(reusableGraphicsLayerScope.getOutline$ui_release(), reusableGraphicsLayerScope.getAlpha(), z3, reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.m4581getSizeNHjbRc());
        if (this.outlineResolver.getCacheIsDirty$ui_release()) {
            updateOutlineResolver();
        }
        boolean z4 = getManualClipPath() != null;
        if (z2 != z4 || (z4 && r4)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((mutatedFields$ui_release & Fields.MatrixAffectingFields) != 0) {
            this.matrixCache.invalidate();
        }
        if ((mutatedFields$ui_release & 64) != 0) {
            ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this, ColorKt.m4293toArgb8_81llA(reusableGraphicsLayerScope.m4579getAmbientShadowColor0d7_KjU()));
        }
        if ((mutatedFields$ui_release & 128) != 0) {
            ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this, ColorKt.m4293toArgb8_81llA(reusableGraphicsLayerScope.m4582getSpotShadowColor0d7_KjU()));
        }
        if (Build.VERSION.SDK_INT >= 31 && (131072 & mutatedFields$ui_release) != 0) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this, reusableGraphicsLayerScope.getRenderEffect());
        }
        if ((mutatedFields$ui_release & 32768) != 0) {
            int r0 = reusableGraphicsLayerScope.m4580getCompositingStrategyNrFUSI();
            if (CompositingStrategy.m4325equalsimpl0(r0, CompositingStrategy.Companion.m4331getOffscreenNrFUSI())) {
                setLayerType(2, (Paint) null);
            } else if (CompositingStrategy.m4325equalsimpl0(r0, CompositingStrategy.Companion.m4330getModulateAlphaNrFUSI())) {
                setLayerType(0, (Paint) null);
                this.mHasOverlappingRendering = z;
            } else {
                setLayerType(0, (Paint) null);
            }
            z = true;
            this.mHasOverlappingRendering = z;
        }
        this.mutatedFields = reusableGraphicsLayerScope.getMutatedFields$ui_release();
    }

    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    public boolean m6340isInLayerk4lQ0M(long j) {
        float r0 = Offset.m3987getXimpl(j);
        float r1 = Offset.m3988getYimpl(j);
        if (this.clipToBounds) {
            if (0.0f > r0 || r0 >= ((float) getWidth()) || 0.0f > r1 || r1 >= ((float) getHeight())) {
                return false;
            }
            return true;
        } else if (getClipToOutline()) {
            return this.outlineResolver.m6320isInOutlinek4lQ0M(j);
        } else {
            return true;
        }
    }

    private final void updateOutlineResolver() {
        setOutlineProvider(this.outlineResolver.getAndroidOutline() != null ? OutlineProvider : null);
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    public void m6343resizeozmzZPI(long j) {
        int r0 = IntSize.m7283getWidthimpl(j);
        int r4 = IntSize.m7282getHeightimpl(j);
        if (r0 != getWidth() || r4 != getHeight()) {
            setPivotX(TransformOrigin.m4668getPivotFractionXimpl(this.mTransformOrigin) * ((float) r0));
            setPivotY(TransformOrigin.m4669getPivotFractionYimpl(this.mTransformOrigin) * ((float) r4));
            updateOutlineResolver();
            layout(getLeft(), getTop(), getLeft() + r0, getTop() + r4);
            resetClipBounds();
            this.matrixCache.invalidate();
        }
    }

    /* renamed from: move--gyyYBs  reason: not valid java name */
    public void m6342movegyyYBs(long j) {
        int r0 = IntOffset.m7241getXimpl(j);
        if (r0 != getLeft()) {
            offsetLeftAndRight(r0 - getLeft());
            this.matrixCache.invalidate();
        }
        int r3 = IntOffset.m7242getYimpl(j);
        if (r3 != getTop()) {
            offsetTopAndBottom(r3 - getTop());
            this.matrixCache.invalidate();
        }
    }

    public void drawLayer(Canvas canvas, GraphicsLayer graphicsLayer) {
        boolean z = getElevation() > 0.0f;
        this.drawnWithZ = z;
        if (z) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(android.graphics.Canvas canvas) {
        boolean z;
        CanvasHolder canvasHolder2 = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
        Canvas androidCanvas = canvasHolder2.getAndroidCanvas();
        if (getManualClipPath() != null || !canvas.isHardwareAccelerated()) {
            androidCanvas.save();
            this.outlineResolver.clipToOutline(androidCanvas);
            z = true;
        } else {
            z = false;
        }
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(androidCanvas, null);
        }
        if (z) {
            androidCanvas.restore();
        }
        canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
        setInvalidated(false);
    }

    public void invalidate() {
        if (!this.isInvalidated) {
            setInvalidated(true);
            super.invalidate();
            this.ownerView.invalidate();
        }
    }

    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    public void updateDisplayList() {
        if (this.isInvalidated && !shouldUseDispatchDraw) {
            Companion.updateDisplayList(this);
            setInvalidated(false);
        }
    }

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    public long m6341mapOffset8S9VItk(long j, boolean z) {
        if (!z) {
            return androidx.compose.ui.graphics.Matrix.m4480mapMKHz9U(this.matrixCache.m6294calculateMatrixGrdbGEg(this), j);
        }
        float[] r3 = this.matrixCache.m6293calculateInverseMatrixbWbORWo(this);
        return r3 != null ? androidx.compose.ui.graphics.Matrix.m4480mapMKHz9U(r3, j) : Offset.Companion.m4001getInfiniteF1C5BW0();
    }

    public void mapBounds(MutableRect mutableRect, boolean z) {
        if (z) {
            float[] r2 = this.matrixCache.m6293calculateInverseMatrixbWbORWo(this);
            if (r2 != null) {
                androidx.compose.ui.graphics.Matrix.m4482mapimpl(r2, mutableRect);
            } else {
                mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        } else {
            androidx.compose.ui.graphics.Matrix.m4482mapimpl(this.matrixCache.m6294calculateMatrixGrdbGEg(this), mutableRect);
        }
    }

    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.Companion.m4673getCenterSzJe1aQ();
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
    }

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    public void m6344transform58bKbWc(float[] fArr) {
        androidx.compose.ui.graphics.Matrix.m4491timesAssign58bKbWc(fArr, this.matrixCache.m6294calculateMatrixGrdbGEg(this));
    }

    /* renamed from: inverseTransform-58bKbWc  reason: not valid java name */
    public void m6339inverseTransform58bKbWc(float[] fArr) {
        float[] r0 = this.matrixCache.m6293calculateInverseMatrixbWbORWo(this);
        if (r0 != null) {
            androidx.compose.ui.graphics.Matrix.m4491timesAssign58bKbWc(fArr, r0);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$Companion;", "", "()V", "OutlineProvider", "Landroid/view/ViewOutlineProvider;", "getOutlineProvider", "()Landroid/view/ViewOutlineProvider;", "getMatrix", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/Matrix;", "", "<set-?>", "", "hasRetrievedMethod", "getHasRetrievedMethod", "()Z", "recreateDisplayList", "Ljava/lang/reflect/Field;", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui_release", "(Z)V", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "updateDisplayList", "view", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewLayer.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z) {
            ViewLayer.shouldUseDispatchDraw = z;
        }

        public final void updateDisplayList(View view) {
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()}).invoke(View.class, new Object[]{"updateDisplayListIfDirty", new Class[0]});
                    ViewLayer.recreateDisplayList = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(View.class, new Object[]{"mRecreateDisplayList"});
                    Method access$getUpdateDisplayListIfDirtyMethod$cp = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (access$getUpdateDisplayListIfDirtyMethod$cp != null) {
                        access$getUpdateDisplayListIfDirtyMethod$cp.setAccessible(true);
                    }
                    Field access$getRecreateDisplayList$cp = ViewLayer.recreateDisplayList;
                    if (access$getRecreateDisplayList$cp != null) {
                        access$getRecreateDisplayList$cp.setAccessible(true);
                    }
                }
                Field access$getRecreateDisplayList$cp2 = ViewLayer.recreateDisplayList;
                if (access$getRecreateDisplayList$cp2 != null) {
                    access$getRecreateDisplayList$cp2.setBoolean(view, true);
                }
                Method access$getUpdateDisplayListIfDirtyMethod$cp2 = ViewLayer.updateDisplayListIfDirtyMethod;
                if (access$getUpdateDisplayListIfDirtyMethod$cp2 != null) {
                    access$getUpdateDisplayListIfDirtyMethod$cp2.invoke(view, new Object[0]);
                }
            } catch (Throwable unused) {
                setShouldUseDispatchDraw$ui_release(true);
            }
        }
    }
}
