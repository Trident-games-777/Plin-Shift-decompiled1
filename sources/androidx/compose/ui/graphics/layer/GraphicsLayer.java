package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ¶\u00012\u00020\u0001:\u0002¶\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0001\u001a\u0002082\u0007\u0010\u0001\u001a\u00020\u0000H\u0002J\t\u0010\u0001\u001a\u000208H\u0002J\t\u0010\u0001\u001a\u000208H\u0002J\u000f\u0010\u0001\u001a\u000208H\u0000¢\u0006\u0003\b\u0001J$\u0010\u0001\u001a\u0002082\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0003\b\u0001J\u0019\u0010\u0001\u001a\u0002082\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u000208H\u0001¢\u0006\u0003\b\u0001J\t\u0010\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0001\u001a\u000208H\u0002J\t\u0010\u0001\u001a\u000208H\u0002JE\u0010\u0001\u001a\u0002082\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u00020D2\u0006\u0010r\u001a\u00020q2\u0018\u0010\u0001\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\b9ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u000208H\u0002J\t\u0010\u0001\u001a\u000208H\u0002J\u000f\u0010\u0001\u001a\u000208H\u0000¢\u0006\u0003\b\u0001J\t\u0010\u0001\u001a\u000208H\u0002J5\u0010 \u0001\u001a\u0003H¡\u0001\"\u0005\b\u0000\u0010¡\u00012\u001b\u0010\u0001\u001a\u0016\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020f\u0012\u0005\u0012\u0003H¡\u00010¢\u0001H\b¢\u0006\u0003\u0010£\u0001J\u0010\u0010¤\u0001\u001a\u0002082\u0007\u0010¥\u0001\u001a\u00020JJ%\u0010¦\u0001\u001a\u0002082\u0006\u0010{\u001a\u00020z2\u0006\u0010r\u001a\u00020qH\u0002ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J'\u0010©\u0001\u001a\u0002082\b\b\u0002\u0010{\u001a\u00020O2\b\b\u0002\u0010r\u001a\u00020fø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010¨\u0001J2\u0010«\u0001\u001a\u0002082\b\b\u0002\u0010{\u001a\u00020O2\b\b\u0002\u0010r\u001a\u00020f2\t\b\u0002\u0010¬\u0001\u001a\u00020\bø\u0001\u0000¢\u0006\u0006\b­\u0001\u0010®\u0001J\u0011\u0010¯\u0001\u001a\u00030°\u0001H@¢\u0006\u0003\u0010±\u0001J\u0013\u0010²\u0001\u001a\u0002082\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\u0012\u0010µ\u0001\u001a\u00020\u00152\u0007\u0010¥\u0001\u001a\u00020JH\u0002R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8F@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020!8F@FX\u000e¢\u0006\u0012\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0007\u001a\u0004\u0018\u00010)8F@FX\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00100\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020/8F@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u001f\u00105\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\b9X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010?\u001a\u00020!2\u0006\u0010>\u001a\u00020!@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0011\u0010@\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\bB\u0010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010E\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\bL\u0010\u0011R\u000e\u0010M\u001a\u00020NX\u000e¢\u0006\u0002\n\u0000R,\u0010P\u001a\u00020O2\u0006\u0010\u0007\u001a\u00020O@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R(\u0010U\u001a\u0004\u0018\u00010T2\b\u0010\u0007\u001a\u0004\u0018\u00010T8F@FX\u000e¢\u0006\f\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010Z\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b[\u0010\u000b\"\u0004\b\\\u0010\rR$\u0010]\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b^\u0010\u000b\"\u0004\b_\u0010\rR$\u0010`\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\ba\u0010\u000b\"\u0004\bb\u0010\rR\u0010\u0010c\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010e\u001a\u00020fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010SR\u0016\u0010g\u001a\u00020OX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010SR$\u0010h\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\bi\u0010\u000b\"\u0004\bj\u0010\rR$\u0010k\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010\rR$\u0010n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\bo\u0010\u000b\"\u0004\bp\u0010\rR,\u0010r\u001a\u00020q2\u0006\u0010\u0007\u001a\u00020q@BX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bs\u0010\u0011\"\u0004\bt\u0010\u0013R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u000e¢\u0006\u0002\n\u0000R*\u0010w\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8F@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bx\u0010\u0011\"\u0004\by\u0010\u0013R,\u0010{\u001a\u00020z2\u0006\u0010\u0007\u001a\u00020z@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\b|\u0010\u0011\"\u0004\b}\u0010\u0013R%\u0010~\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\r\u001a\u0004\b\u0010\u000b\"\u0005\b\u0001\u0010\rR'\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010\u000b\"\u0005\b\u0001\u0010\rR\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006·\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "impl", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "layerManager", "Landroidx/compose/ui/graphics/layer/LayerManager;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;Landroidx/compose/ui/graphics/layer/LayerManager;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "androidOutline", "Landroid/graphics/Outline;", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "clip", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "density", "Landroidx/compose/ui/unit/Density;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "getImpl$ui_graphics_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "<set-?>", "isReleased", "layerId", "", "getLayerId", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "outlineDirty", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "ownerViewId", "getOwnerViewId", "parentLayerUsages", "", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "J", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "roundRectClipPath", "roundRectCornerRadius", "roundRectOutlineSize", "Landroidx/compose/ui/geometry/Size;", "roundRectOutlineTopLeft", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "setSize-ozmzZPI", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "Landroidx/compose/ui/unit/IntOffset;", "topLeft", "getTopLeft-nOcc-ac", "setTopLeft--gyyYBs", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "usePathForClip", "addSubLayer", "graphicsLayer", "configureOutline", "discardContentIfReleasedAndHaveNoParentLayerUsages", "discardDisplayList", "discardDisplayList$ui_graphics_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "draw$ui_graphics_release", "drawForPersistence", "drawForPersistence$ui_graphics_release", "emulateTrimMemory", "emulateTrimMemory$ui_graphics_release", "obtainAndroidOutline", "onAddedToParentLayer", "onRemovedFromParentLayer", "record", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "recordInternal", "recreateDisplayListIfNeeded", "release", "release$ui_graphics_release", "resetOutlineParams", "resolveOutlinePosition", "T", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "setPathOutline", "path", "setPosition", "setPosition-VbeCjmY", "(JJ)V", "setRectOutline", "setRectOutline-tz77jQw", "setRoundRectOutline", "cornerRadius", "setRoundRectOutline-TNW_H78", "(JJF)V", "toImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformCanvas", "androidCanvas", "Landroid/graphics/Canvas;", "updatePathOutline", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidGraphicsLayer.android.kt */
public final class GraphicsLayer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final LayerSnapshotImpl SnapshotImpl = LayerSnapshotV28.INSTANCE;
    private Outline androidOutline;
    private final ChildLayerDependenciesTracker childDependenciesTracker = new ChildLayerDependenciesTracker();
    private Density density = DrawContextKt.getDefaultDensity();
    private Function1<? super DrawScope, Unit> drawBlock = GraphicsLayer$drawBlock$1.INSTANCE;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private final LayerManager layerManager;
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private boolean outlineDirty = true;
    private Path outlinePath;
    private int parentLayerUsages;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long roundRectOutlineSize = Size.Companion.m4064getUnspecifiedNHjbRc();
    private long roundRectOutlineTopLeft = Offset.Companion.m4003getZeroF1C5BW0();
    private long size;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;

    public static /* synthetic */ void getClip$annotations() {
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl, LayerManager layerManager2) {
        this.impl = graphicsLayerImpl;
        this.layerManager = layerManager2;
        graphicsLayerImpl.setClip(false);
        this.topLeft = IntOffset.Companion.m7251getZeronOccac();
        this.size = IntSize.Companion.m7288getZeroYbymL2g();
        this.pivotOffset = Offset.Companion.m4002getUnspecifiedF1C5BW0();
    }

    public final GraphicsLayerImpl getImpl$ui_graphics_release() {
        return this.impl;
    }

    public final boolean isReleased() {
        return this.isReleased;
    }

    /* renamed from: getCompositingStrategy-ke2Ky5w  reason: not valid java name */
    public final int m4971getCompositingStrategyke2Ky5w() {
        return this.impl.m4987getCompositingStrategyke2Ky5w();
    }

    /* renamed from: setCompositingStrategy-Wpw9cng  reason: not valid java name */
    public final void m4979setCompositingStrategyWpw9cng(int i) {
        if (!CompositingStrategy.m4958equalsimpl0(this.impl.m4987getCompositingStrategyke2Ky5w(), i)) {
            this.impl.m4992setCompositingStrategyWpw9cng(i);
        }
    }

    /* renamed from: getTopLeft-nOcc-ac  reason: not valid java name */
    public final long m4975getTopLeftnOccac() {
        return this.topLeft;
    }

    /* renamed from: setTopLeft--gyyYBs  reason: not valid java name */
    public final void m4984setTopLeftgyyYBs(long j) {
        if (!IntOffset.m7240equalsimpl0(this.topLeft, j)) {
            this.topLeft = j;
            m4965setPositionVbeCjmY(j, this.size);
        }
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m4973getSizeYbymL2g() {
        return this.size;
    }

    /* renamed from: setSize-ozmzZPI  reason: not valid java name */
    private final void m4968setSizeozmzZPI(long j) {
        if (!IntSize.m7281equalsimpl0(this.size, j)) {
            this.size = j;
            m4965setPositionVbeCjmY(this.topLeft, j);
            if (this.roundRectOutlineSize == InlineClassHelperKt.UnspecifiedPackedFloats) {
                this.outlineDirty = true;
                configureOutline();
            }
        }
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    public final void setAlpha(float f) {
        if (this.impl.getAlpha() != f) {
            this.impl.setAlpha(f);
        }
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public final int m4970getBlendMode0nO6VwU() {
        return this.impl.m4986getBlendMode0nO6VwU();
    }

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    public final void m4978setBlendModes9anfk8(int i) {
        if (!BlendMode.m4139equalsimpl0(this.impl.m4986getBlendMode0nO6VwU(), i)) {
            this.impl.m4991setBlendModes9anfk8(i);
        }
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (!Intrinsics.areEqual((Object) this.impl.getColorFilter(), (Object) colorFilter)) {
            this.impl.setColorFilter(colorFilter);
        }
    }

    /* renamed from: getPivotOffset-F1C5BW0  reason: not valid java name */
    public final long m4972getPivotOffsetF1C5BW0() {
        return this.pivotOffset;
    }

    /* renamed from: setPivotOffset-k-4lQ0M  reason: not valid java name */
    public final void m4980setPivotOffsetk4lQ0M(long j) {
        if (!Offset.m3984equalsimpl0(this.pivotOffset, j)) {
            this.pivotOffset = j;
            this.impl.m4993setPivotOffsetk4lQ0M(j);
        }
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final void setScaleX(float f) {
        if (this.impl.getScaleX() != f) {
            this.impl.setScaleX(f);
        }
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final void setScaleY(float f) {
        if (this.impl.getScaleY() != f) {
            this.impl.setScaleY(f);
        }
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final void setTranslationX(float f) {
        if (this.impl.getTranslationX() != f) {
            this.impl.setTranslationX(f);
        }
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final void setTranslationY(float f) {
        if (this.impl.getTranslationY() != f) {
            this.impl.setTranslationY(f);
        }
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    public final void setShadowElevation(float f) {
        if (this.impl.getShadowElevation() != f) {
            this.impl.setShadowElevation(f);
            this.impl.setClip(getClip() || f > 0.0f);
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final void setRotationX(float f) {
        if (this.impl.getRotationX() != f) {
            this.impl.setRotationX(f);
        }
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final void setRotationY(float f) {
        if (this.impl.getRotationY() != f) {
            this.impl.setRotationY(f);
        }
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final void setRotationZ(float f) {
        if (this.impl.getRotationZ() != f) {
            this.impl.setRotationZ(f);
        }
    }

    /* renamed from: setRoundRectOutline-TNW_H78$default  reason: not valid java name */
    public static /* synthetic */ void m4967setRoundRectOutlineTNW_H78$default(GraphicsLayer graphicsLayer, long j, long j2, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.Companion.m4003getZeroF1C5BW0();
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = Size.Companion.m4064getUnspecifiedNHjbRc();
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        graphicsLayer.m4982setRoundRectOutlineTNW_H78(j3, j4, f);
    }

    /* renamed from: setRectOutline-tz77jQw$default  reason: not valid java name */
    public static /* synthetic */ void m4966setRectOutlinetz77jQw$default(GraphicsLayer graphicsLayer, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.Companion.m4003getZeroF1C5BW0();
        }
        if ((i & 2) != 0) {
            j2 = Size.Companion.m4064getUnspecifiedNHjbRc();
        }
        graphicsLayer.m4981setRectOutlinetz77jQw(j, j2);
    }

    public final float getCameraDistance() {
        return this.impl.getCameraDistance();
    }

    public final void setCameraDistance(float f) {
        if (this.impl.getCameraDistance() != f) {
            this.impl.setCameraDistance(f);
        }
    }

    public final boolean getClip() {
        return this.impl.getClip();
    }

    public final void setClip(boolean z) {
        if (this.impl.getClip() != z) {
            this.impl.setClip(z);
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final RenderEffect getRenderEffect() {
        return this.impl.getRenderEffect();
    }

    public final void setRenderEffect(RenderEffect renderEffect) {
        if (!Intrinsics.areEqual((Object) this.impl.getRenderEffect(), (Object) renderEffect)) {
            this.impl.setRenderEffect(renderEffect);
        }
    }

    /* renamed from: setPosition-VbeCjmY  reason: not valid java name */
    private final void m4965setPositionVbeCjmY(long j, long j2) {
        this.impl.m4994setPositionH0pRuoY(IntOffset.m7241getXimpl(j), IntOffset.m7242getYimpl(j), j2);
    }

    /* renamed from: record-mL-hObY  reason: not valid java name */
    public final void m4976recordmLhObY(Density density2, LayoutDirection layoutDirection2, long j, Function1<? super DrawScope, Unit> function1) {
        m4968setSizeozmzZPI(j);
        this.density = density2;
        this.layoutDirection = layoutDirection2;
        this.drawBlock = function1;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    private final void recordInternal() {
        ChildLayerDependenciesTracker childLayerDependenciesTracker = this.childDependenciesTracker;
        childLayerDependenciesTracker.oldDependency = childLayerDependenciesTracker.dependency;
        MutableScatterSet access$getDependenciesSet$p = childLayerDependenciesTracker.dependenciesSet;
        if (access$getDependenciesSet$p != null && access$getDependenciesSet$p.isNotEmpty()) {
            MutableScatterSet access$getOldDependenciesSet$p = childLayerDependenciesTracker.oldDependenciesSet;
            if (access$getOldDependenciesSet$p == null) {
                access$getOldDependenciesSet$p = ScatterSetKt.mutableScatterSetOf();
                childLayerDependenciesTracker.oldDependenciesSet = access$getOldDependenciesSet$p;
            }
            access$getOldDependenciesSet$p.addAll(access$getDependenciesSet$p);
            access$getDependenciesSet$p.clear();
        }
        childLayerDependenciesTracker.trackingInProgress = true;
        this.impl.record(this.density, this.layoutDirection, this, this.drawBlock);
        childLayerDependenciesTracker.trackingInProgress = false;
        GraphicsLayer access$getOldDependency$p = childLayerDependenciesTracker.oldDependency;
        if (access$getOldDependency$p != null) {
            access$getOldDependency$p.onRemovedFromParentLayer();
        }
        MutableScatterSet access$getOldDependenciesSet$p2 = childLayerDependenciesTracker.oldDependenciesSet;
        if (access$getOldDependenciesSet$p2 != null && access$getOldDependenciesSet$p2.isNotEmpty()) {
            ScatterSet scatterSet = access$getOldDependenciesSet$p2;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                ((GraphicsLayer) objArr[(i << 3) + i3]).onRemovedFromParentLayer();
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            access$getOldDependenciesSet$p2.clear();
        }
    }

    private final void addSubLayer(GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void transformCanvas(Canvas canvas) {
        Canvas canvas2;
        float r2 = (float) IntOffset.m7241getXimpl(this.topLeft);
        float r3 = (float) IntOffset.m7242getYimpl(this.topLeft);
        float r4 = ((float) IntOffset.m7241getXimpl(this.topLeft)) + ((float) IntSize.m7283getWidthimpl(this.size));
        float r5 = ((float) IntOffset.m7242getYimpl(this.topLeft)) + ((float) IntSize.m7282getHeightimpl(this.size));
        float alpha = getAlpha();
        ColorFilter colorFilter = getColorFilter();
        int r6 = m4970getBlendMode0nO6VwU();
        if (alpha < 1.0f || !BlendMode.m4139equalsimpl0(r6, BlendMode.Companion.m4170getSrcOver0nO6VwU()) || colorFilter != null || CompositingStrategy.m4958equalsimpl0(m4971getCompositingStrategyke2Ky5w(), CompositingStrategy.Companion.m4964getOffscreenke2Ky5w())) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(alpha);
            paint.m4509setBlendModes9anfk8(r6);
            paint.setColorFilter(colorFilter);
            canvas2 = canvas;
            canvas2.saveLayer(r2, r3, r4, r5, paint.asFrameworkPaint());
        } else {
            canvas.save();
            canvas2 = canvas;
        }
        canvas2.translate(r2, r3);
        canvas2.concat(this.impl.calculateMatrix());
    }

    public final void drawForPersistence$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas) {
        if (AndroidCanvas_androidKt.getNativeCanvas(canvas).isHardwareAccelerated()) {
            recreateDisplayListIfNeeded();
            this.impl.draw(canvas);
        }
    }

    private final void recreateDisplayListIfNeeded() {
        if (!this.impl.getHasDisplayList()) {
            try {
                recordInternal();
            } catch (Throwable unused) {
            }
        }
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer graphicsLayer) {
        if (!this.isReleased) {
            recreateDisplayListIfNeeded();
            configureOutline();
            boolean z = true;
            boolean z2 = getShadowElevation() > 0.0f;
            if (z2) {
                canvas.enableZ();
            }
            Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
            boolean isHardwareAccelerated = nativeCanvas.isHardwareAccelerated();
            if (!isHardwareAccelerated) {
                nativeCanvas.save();
                transformCanvas(nativeCanvas);
            }
            if (!this.usePathForClip && (isHardwareAccelerated || !getClip())) {
                z = false;
            }
            if (z) {
                canvas.save();
                androidx.compose.ui.graphics.Outline outline = getOutline();
                if (outline instanceof Outline.Rectangle) {
                    androidx.compose.ui.graphics.Canvas.m4202clipRectmtrdDE$default(canvas, outline.getBounds(), 0, 2, (Object) null);
                } else if (outline instanceof Outline.Rounded) {
                    Path path = this.roundRectClipPath;
                    if (path != null) {
                        path.rewind();
                    } else {
                        path = AndroidPath_androidKt.Path();
                        this.roundRectClipPath = path;
                    }
                    Path.addRoundRect$default(path, ((Outline.Rounded) outline).getRoundRect(), (Path.Direction) null, 2, (Object) null);
                    androidx.compose.ui.graphics.Canvas.m4200clipPathmtrdDE$default(canvas, path, 0, 2, (Object) null);
                } else if (outline instanceof Outline.Generic) {
                    androidx.compose.ui.graphics.Canvas.m4200clipPathmtrdDE$default(canvas, ((Outline.Generic) outline).getPath(), 0, 2, (Object) null);
                }
            }
            if (graphicsLayer != null) {
                graphicsLayer.addSubLayer(this);
            }
            this.impl.draw(canvas);
            if (z) {
                canvas.restore();
            }
            if (z2) {
                canvas.disableZ();
            }
            if (!isHardwareAccelerated) {
                nativeCanvas.restore();
            }
        }
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void configureOutline() {
        if (this.outlineDirty) {
            if (getClip() || getShadowElevation() > 0.0f) {
                Path path = this.outlinePath;
                if (path != null) {
                    android.graphics.Outline updatePathOutline = updatePathOutline(path);
                    updatePathOutline.setAlpha(getAlpha());
                    this.impl.setOutline(updatePathOutline);
                } else {
                    android.graphics.Outline obtainAndroidOutline = obtainAndroidOutline();
                    long r0 = IntSizeKt.m7295toSizeozmzZPI(this.size);
                    long j = this.roundRectOutlineTopLeft;
                    long j2 = this.roundRectOutlineSize;
                    if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
                        r0 = j2;
                    }
                    int round = Math.round(Offset.m3987getXimpl(j));
                    int round2 = Math.round(Offset.m3988getYimpl(j));
                    int i = round2;
                    obtainAndroidOutline.setRoundRect(round, i, Math.round(Offset.m3987getXimpl(j) + Size.m4056getWidthimpl(r0)), Math.round(Offset.m3988getYimpl(j) + Size.m4053getHeightimpl(r0)), this.roundRectCornerRadius);
                    obtainAndroidOutline.setAlpha(getAlpha());
                    this.impl.setOutline(obtainAndroidOutline);
                }
            } else {
                this.impl.setOutline((android.graphics.Outline) null);
            }
        }
        this.outlineDirty = false;
    }

    private final <T> T resolveOutlinePosition(Function2<? super Offset, ? super Size, ? extends T> function2) {
        long r0 = IntSizeKt.m7295toSizeozmzZPI(this.size);
        long j = this.roundRectOutlineTopLeft;
        long j2 = this.roundRectOutlineSize;
        if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            r0 = j2;
        }
        return function2.invoke(Offset.m3976boximpl(j), Size.m4044boximpl(r0));
    }

    private final android.graphics.Outline updatePathOutline(Path path) {
        android.graphics.Outline obtainAndroidOutline = obtainAndroidOutline();
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            if (Build.VERSION.SDK_INT > 30) {
                OutlineVerificationHelper.INSTANCE.setPath(obtainAndroidOutline, path);
            } else if (path instanceof AndroidPath) {
                obtainAndroidOutline.setConvexPath(((AndroidPath) path).getInternalPath());
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            this.usePathForClip = !obtainAndroidOutline.canClip();
        } else {
            android.graphics.Outline outline = this.androidOutline;
            if (outline != null) {
                outline.setEmpty();
            }
            this.usePathForClip = true;
            this.impl.setInvalidated(true);
        }
        this.outlinePath = path;
        return obtainAndroidOutline;
    }

    private final android.graphics.Outline obtainAndroidOutline() {
        android.graphics.Outline outline = this.androidOutline;
        if (outline != null) {
            return outline;
        }
        android.graphics.Outline outline2 = new android.graphics.Outline();
        this.androidOutline = outline2;
        return outline2;
    }

    public final void release$ui_graphics_release() {
        if (!this.isReleased) {
            this.isReleased = true;
            discardContentIfReleasedAndHaveNoParentLayerUsages();
        }
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            LayerManager layerManager2 = this.layerManager;
            if (layerManager2 != null) {
                layerManager2.release(this);
            } else {
                discardDisplayList$ui_graphics_release();
            }
        }
    }

    public final void discardDisplayList$ui_graphics_release() {
        ChildLayerDependenciesTracker childLayerDependenciesTracker = this.childDependenciesTracker;
        GraphicsLayer access$getDependency$p = childLayerDependenciesTracker.dependency;
        if (access$getDependency$p != null) {
            access$getDependency$p.onRemovedFromParentLayer();
            childLayerDependenciesTracker.dependency = null;
        }
        MutableScatterSet access$getDependenciesSet$p = childLayerDependenciesTracker.dependenciesSet;
        if (access$getDependenciesSet$p != null) {
            ScatterSet scatterSet = access$getDependenciesSet$p;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                ((GraphicsLayer) objArr[(i << 3) + i3]).onRemovedFromParentLayer();
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            access$getDependenciesSet$p.clear();
        }
        this.impl.discardDisplayList();
    }

    public final void emulateTrimMemory$ui_graphics_release() {
        this.impl.discardDisplayList();
    }

    public final long getLayerId() {
        return this.impl.getLayerId();
    }

    public final long getOwnerViewId() {
        return this.impl.getOwnerId();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        androidx.compose.ui.graphics.Outline outline;
        androidx.compose.ui.graphics.Outline outline2 = this.internalOutline;
        Path path = this.outlinePath;
        if (outline2 != null) {
            return outline2;
        }
        if (path != null) {
            androidx.compose.ui.graphics.Outline generic = new Outline.Generic(path);
            this.internalOutline = generic;
            return generic;
        }
        long r0 = IntSizeKt.m7295toSizeozmzZPI(this.size);
        long j = this.roundRectOutlineTopLeft;
        long j2 = this.roundRectOutlineSize;
        if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            r0 = j2;
        }
        float r4 = Offset.m3987getXimpl(j);
        float r5 = Offset.m3988getYimpl(j);
        float r6 = r4 + Size.m4056getWidthimpl(r0);
        float r7 = r5 + Size.m4053getHeightimpl(r0);
        float f = this.roundRectCornerRadius;
        if (f > 0.0f) {
            outline = new Outline.Rounded(RoundRectKt.m4041RoundRectgG7oq9Y(r4, r5, r6, r7, CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, (Object) null)));
        } else {
            outline = new Outline.Rectangle(new Rect(r4, r5, r6, r7));
        }
        this.internalOutline = outline;
        return outline;
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.Companion.m4064getUnspecifiedNHjbRc();
        this.roundRectOutlineTopLeft = Offset.Companion.m4003getZeroF1C5BW0();
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
        configureOutline();
    }

    /* renamed from: setRoundRectOutline-TNW_H78  reason: not valid java name */
    public final void m4982setRoundRectOutlineTNW_H78(long j, long j2, float f) {
        if (!Offset.m3984equalsimpl0(this.roundRectOutlineTopLeft, j) || !Size.m4052equalsimpl0(this.roundRectOutlineSize, j2) || this.roundRectCornerRadius != f || this.outlinePath != null) {
            resetOutlineParams();
            this.roundRectOutlineTopLeft = j;
            this.roundRectOutlineSize = j2;
            this.roundRectCornerRadius = f;
            configureOutline();
        }
    }

    /* renamed from: setRectOutline-tz77jQw  reason: not valid java name */
    public final void m4981setRectOutlinetz77jQw(long j, long j2) {
        m4982setRoundRectOutlineTNW_H78(j, j2, 0.0f);
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    public final long m4969getAmbientShadowColor0d7_KjU() {
        return this.impl.m4985getAmbientShadowColor0d7_KjU();
    }

    /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
    public final void m4977setAmbientShadowColor8_81llA(long j) {
        if (!Color.m4240equalsimpl0(j, this.impl.m4985getAmbientShadowColor0d7_KjU())) {
            this.impl.m4990setAmbientShadowColor8_81llA(j);
        }
    }

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    public final long m4974getSpotShadowColor0d7_KjU() {
        return this.impl.m4989getSpotShadowColor0d7_KjU();
    }

    /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
    public final void m4983setSpotShadowColor8_81llA(long j) {
        if (!Color.m4240equalsimpl0(j, this.impl.m4989getSpotShadowColor0d7_KjU())) {
            this.impl.m4995setSpotShadowColor8_81llA(j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object toImageBitmap(kotlin.coroutines.Continuation<? super androidx.compose.ui.graphics.ImageBitmap> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = (androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = new androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.ui.graphics.layer.LayerSnapshotImpl r5 = SnapshotImpl
            r0.label = r3
            java.lang.Object r5 = r5.toBitmap(r4, r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            androidx.compose.ui.graphics.ImageBitmap r5 = androidx.compose.ui.graphics.AndroidImageBitmap_androidKt.asImageBitmap(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.toImageBitmap(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer$Companion;", "", "()V", "SnapshotImpl", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidGraphicsLayer.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
