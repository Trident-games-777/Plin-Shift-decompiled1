package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JF\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
public final class BorderModifierNode extends DelegatingNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush2, Shape shape2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush2, shape2);
    }

    private BorderModifierNode(float f, Brush brush2, Shape shape2) {
        this.width = f;
        this.brush = brush2;
        this.shape = shape2;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new BorderModifierNode$drawWithCacheModifierNode$1(this)));
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m266getWidthD9Ej5fM() {
        return this.width;
    }

    /* renamed from: setWidth-0680j_4  reason: not valid java name */
    public final void m267setWidth0680j_4(float f) {
        if (!Dp.m7116equalsimpl0(this.width, f)) {
            this.width = f;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush2) {
        if (!Intrinsics.areEqual((Object) this.brush, (Object) brush2)) {
            this.brush = brush2;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape2) {
        if (!Intrinsics.areEqual((Object) this.shape, (Object) shape2)) {
            this.shape = shape2;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d7, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m4456equalsimpl(r8, r5) != false) goto L_0x00d9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r37, androidx.compose.ui.graphics.Brush r38, androidx.compose.ui.graphics.Outline.Generic r39, boolean r40, float r41) {
        /*
            r36 = this;
            r1 = r36
            r0 = r37
            r4 = r38
            if (r40 == 0) goto L_0x0016
            androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1 r2 = new androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1
            r3 = r39
            r2.<init>(r3, r4)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.draw.DrawResult r0 = r0.onDrawWithContent(r2)
            return r0
        L_0x0016:
            r3 = r39
            boolean r2 = r4 instanceof androidx.compose.ui.graphics.SolidColor
            r5 = 0
            if (r2 == 0) goto L_0x0035
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r2 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r2 = r2.m4461getAlpha8_sVssgQ()
            androidx.compose.ui.graphics.ColorFilter$Companion r6 = androidx.compose.ui.graphics.ColorFilter.Companion
            r7 = r4
            androidx.compose.ui.graphics.SolidColor r7 = (androidx.compose.ui.graphics.SolidColor) r7
            long r7 = r7.m4616getValue0d7_KjU()
            r10 = 2
            r11 = 0
            r9 = 0
            androidx.compose.ui.graphics.ColorFilter r6 = androidx.compose.ui.graphics.ColorFilter.Companion.m4280tintxETnrds$default(r6, r7, r9, r10, r11)
            r14 = r6
            goto L_0x003c
        L_0x0035:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r2 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r2 = r2.m4462getArgb8888_sVssgQ()
            r14 = r5
        L_0x003c:
            r8 = r2
            androidx.compose.ui.graphics.Path r2 = r3.getPath()
            androidx.compose.ui.geometry.Rect r13 = r2.getBounds()
            androidx.compose.foundation.BorderCache r2 = r1.borderCache
            if (r2 != 0) goto L_0x005c
            androidx.compose.foundation.BorderCache r15 = new androidx.compose.foundation.BorderCache
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r15.<init>(r16, r17, r18, r19, r20, r21)
            r1.borderCache = r15
        L_0x005c:
            androidx.compose.foundation.BorderCache r2 = r1.borderCache
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.compose.ui.graphics.Path r15 = r2.obtainPath()
            r15.reset()
            r2 = 2
            androidx.compose.ui.graphics.Path.addRect$default(r15, r13, r5, r2, r5)
            androidx.compose.ui.graphics.Path r6 = r3.getPath()
            androidx.compose.ui.graphics.PathOperation$Companion r7 = androidx.compose.ui.graphics.PathOperation.Companion
            int r7 = r7.m4555getDifferenceb3I0S0c()
            r15.m4528opN5in7k0(r15, r6, r7)
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            float r6 = r13.getWidth()
            double r6 = (double) r6
            double r6 = java.lang.Math.ceil(r6)
            float r6 = (float) r6
            int r6 = (int) r6
            float r7 = r13.getHeight()
            double r9 = (double) r7
            double r9 = java.lang.Math.ceil(r9)
            float r7 = (float) r9
            int r7 = (int) r7
            long r16 = androidx.compose.ui.unit.IntSizeKt.IntSize(r6, r7)
            androidx.compose.foundation.BorderCache r6 = r1.borderCache
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            androidx.compose.ui.graphics.ImageBitmap r7 = r6.imageBitmap
            androidx.compose.ui.graphics.Canvas r9 = r6.canvas
            if (r7 == 0) goto L_0x00b0
            int r10 = r7.m4453getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r10 = androidx.compose.ui.graphics.ImageBitmapConfig.m4454boximpl(r10)
            goto L_0x00b1
        L_0x00b0:
            r10 = r5
        L_0x00b1:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r12 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r12 = r12.m4462getArgb8888_sVssgQ()
            r18 = 0
            if (r10 != 0) goto L_0x00be
            r10 = r18
            goto L_0x00c6
        L_0x00be:
            int r10 = r10.m4460unboximpl()
            boolean r10 = androidx.compose.ui.graphics.ImageBitmapConfig.m4457equalsimpl0(r10, r12)
        L_0x00c6:
            r12 = 1
            if (r10 != 0) goto L_0x00d9
            if (r7 == 0) goto L_0x00d3
            int r5 = r7.m4453getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r5 = androidx.compose.ui.graphics.ImageBitmapConfig.m4454boximpl(r5)
        L_0x00d3:
            boolean r5 = androidx.compose.ui.graphics.ImageBitmapConfig.m4456equalsimpl(r8, r5)
            if (r5 == 0) goto L_0x00db
        L_0x00d9:
            r18 = r12
        L_0x00db:
            if (r7 == 0) goto L_0x010a
            if (r9 == 0) goto L_0x010a
            long r19 = r0.m3868getSizeNHjbRc()
            float r5 = androidx.compose.ui.geometry.Size.m4056getWidthimpl(r19)
            int r10 = r7.getWidth()
            float r10 = (float) r10
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 > 0) goto L_0x010a
            long r19 = r0.m3868getSizeNHjbRc()
            float r5 = androidx.compose.ui.geometry.Size.m4053getHeightimpl(r19)
            int r10 = r7.getHeight()
            float r10 = (float) r10
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 > 0) goto L_0x010a
            if (r18 != 0) goto L_0x0104
            goto L_0x010a
        L_0x0104:
            r5 = r6
            r18 = r11
            r12 = r9
            r11 = r7
            goto L_0x012e
        L_0x010a:
            r5 = r6
            int r6 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r16)
            int r7 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r16)
            r9 = r11
            r11 = 24
            r10 = r12
            r12 = 0
            r18 = r9
            r9 = 0
            r19 = r10
            r10 = 0
            androidx.compose.ui.graphics.ImageBitmap r7 = androidx.compose.ui.graphics.ImageBitmapKt.m4467ImageBitmapx__hDU$default(r6, r7, r8, r9, r10, r11, r12)
            r5.imageBitmap = r7
            androidx.compose.ui.graphics.Canvas r9 = androidx.compose.ui.graphics.CanvasKt.Canvas(r7)
            r5.canvas = r9
            r11 = r7
            r12 = r9
        L_0x012e:
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r6 = r5.canvasDrawScope
            if (r6 != 0) goto L_0x013c
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r6 = new androidx.compose.ui.graphics.drawscope.CanvasDrawScope
            r6.<init>()
            r5.canvasDrawScope = r6
        L_0x013c:
            r19 = r6
            long r5 = androidx.compose.ui.unit.IntSizeKt.m7295toSizeozmzZPI(r16)
            androidx.compose.ui.unit.LayoutDirection r7 = r0.getLayoutDirection()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r8 = r19.getDrawParams()
            androidx.compose.ui.unit.Density r9 = r8.component1()
            androidx.compose.ui.unit.LayoutDirection r10 = r8.component2()
            r40 = r8
            androidx.compose.ui.graphics.Canvas r8 = r40.component3()
            r21 = r8
            r20 = r9
            long r8 = r40.m4761component4NHjbRc()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r2 = r19.getDrawParams()
            r1 = r0
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            r2.setDensity(r1)
            r2.setLayoutDirection(r7)
            r2.setCanvas(r12)
            r2.m4764setSizeuvyYCjk(r5)
            r12.save()
            r2 = r19
            androidx.compose.ui.graphics.drawscope.DrawScope r2 = (androidx.compose.ui.graphics.drawscope.DrawScope) r2
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r24 = r1.m4265getBlack0d7_KjU()
            androidx.compose.ui.graphics.BlendMode$Companion r1 = androidx.compose.ui.graphics.BlendMode.Companion
            int r33 = r1.m4143getClear0nO6VwU()
            r34 = 58
            r35 = 0
            r26 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r23 = r2
            r28 = r5
            androidx.compose.ui.graphics.drawscope.DrawScope.m4840drawRectnJ9OG0$default(r23, r24, r26, r28, r30, r31, r32, r33, r34, r35)
            float r1 = r13.getLeft()
            float r1 = -r1
            float r5 = r13.getTop()
            float r5 = -r5
            androidx.compose.ui.graphics.drawscope.DrawContext r6 = r2.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r6 = r6.getTransform()
            r6.translate(r1, r5)
            androidx.compose.ui.graphics.Path r3 = r3.getPath()     // Catch:{ all -> 0x02ac }
            androidx.compose.ui.graphics.drawscope.Stroke r23 = new androidx.compose.ui.graphics.drawscope.Stroke     // Catch:{ all -> 0x02ac }
            r6 = 2
            float r6 = (float) r6     // Catch:{ all -> 0x02ac }
            float r24 = r41 * r6
            r29 = 30
            r30 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r23.<init>(r24, r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x02ac }
            r6 = r23
            androidx.compose.ui.graphics.drawscope.DrawStyle r6 = (androidx.compose.ui.graphics.drawscope.DrawStyle) r6     // Catch:{ all -> 0x02ac }
            r7 = r8
            r9 = 52
            r23 = r10
            r10 = 0
            r24 = r5
            r5 = 0
            r25 = r7
            r7 = 0
            r8 = 0
            r40 = r18
            r18 = r14
            r14 = r23
            r23 = r40
            r27 = r12
            r40 = r13
            r13 = r20
            r20 = r15
            r15 = r21
            r21 = r11
            r11 = r24
            androidx.compose.ui.graphics.drawscope.DrawScope.m4835drawPathGBMwjPU$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x02aa }
            long r3 = r2.m4865getSizeNHjbRc()     // Catch:{ all -> 0x02aa }
            float r3 = androidx.compose.ui.geometry.Size.m4056getWidthimpl(r3)     // Catch:{ all -> 0x02aa }
            r10 = 1
            float r4 = (float) r10     // Catch:{ all -> 0x02aa }
            float r3 = r3 + r4
            long r5 = r2.m4865getSizeNHjbRc()     // Catch:{ all -> 0x02aa }
            float r5 = androidx.compose.ui.geometry.Size.m4056getWidthimpl(r5)     // Catch:{ all -> 0x02aa }
            float r3 = r3 / r5
            long r5 = r2.m4865getSizeNHjbRc()     // Catch:{ all -> 0x02aa }
            float r5 = androidx.compose.ui.geometry.Size.m4053getHeightimpl(r5)     // Catch:{ all -> 0x02aa }
            float r5 = r5 + r4
            long r6 = r2.m4865getSizeNHjbRc()     // Catch:{ all -> 0x02aa }
            float r4 = androidx.compose.ui.geometry.Size.m4053getHeightimpl(r6)     // Catch:{ all -> 0x02aa }
            float r5 = r5 / r4
            long r6 = r2.m4864getCenterF1C5BW0()     // Catch:{ all -> 0x02aa }
            androidx.compose.ui.graphics.drawscope.DrawContext r12 = r2.getDrawContext()     // Catch:{ all -> 0x02aa }
            long r8 = r12.m4806getSizeNHjbRc()     // Catch:{ all -> 0x02aa }
            androidx.compose.ui.graphics.Canvas r4 = r12.getCanvas()     // Catch:{ all -> 0x02aa }
            r4.save()     // Catch:{ all -> 0x02aa }
            androidx.compose.ui.graphics.drawscope.DrawTransform r4 = r12.getTransform()     // Catch:{ all -> 0x029d }
            r4.m4930scale0AR0LA0(r3, r5, r6)     // Catch:{ all -> 0x029d }
            androidx.compose.ui.graphics.BlendMode$Companion r3 = androidx.compose.ui.graphics.BlendMode.Companion     // Catch:{ all -> 0x029d }
            int r3 = r3.m4143getClear0nO6VwU()     // Catch:{ all -> 0x029d }
            r4 = r8
            r9 = 28
            r10 = 0
            r6 = r4
            r5 = 0
            r7 = r6
            r6 = 0
            r28 = r7
            r7 = 0
            r4 = r38
            r8 = r3
            r22 = r14
            r24 = r15
            r3 = r20
            r14 = r28
            androidx.compose.ui.graphics.drawscope.DrawScope.m4835drawPathGBMwjPU$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x029b }
            androidx.compose.ui.graphics.Canvas r3 = r12.getCanvas()     // Catch:{ all -> 0x02aa }
            r3.restore()     // Catch:{ all -> 0x02aa }
            r12.m4807setSizeuvyYCjk(r14)     // Catch:{ all -> 0x02aa }
            androidx.compose.ui.graphics.drawscope.DrawContext r2 = r2.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r2 = r2.getTransform()
            float r1 = -r1
            float r3 = -r11
            r2.translate(r1, r3)
            r27.restore()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r1 = r19.getDrawParams()
            r1.setDensity(r13)
            r14 = r22
            r1.setLayoutDirection(r14)
            r15 = r24
            r1.setCanvas(r15)
            r7 = r25
            r1.m4764setSizeuvyYCjk(r7)
            r21.prepareToDraw()
            r7 = r21
            r11 = r23
            r11.element = r7
            androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3 r9 = new androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3
            r10 = r40
            r12 = r16
            r14 = r18
            r9.<init>(r10, r11, r12, r14)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.ui.draw.DrawResult r0 = r0.onDrawWithContent(r9)
            return r0
        L_0x029b:
            r0 = move-exception
            goto L_0x029f
        L_0x029d:
            r0 = move-exception
            r14 = r8
        L_0x029f:
            androidx.compose.ui.graphics.Canvas r3 = r12.getCanvas()     // Catch:{ all -> 0x02aa }
            r3.restore()     // Catch:{ all -> 0x02aa }
            r12.m4807setSizeuvyYCjk(r14)     // Catch:{ all -> 0x02aa }
            throw r0     // Catch:{ all -> 0x02aa }
        L_0x02aa:
            r0 = move-exception
            goto L_0x02ae
        L_0x02ac:
            r0 = move-exception
            r11 = r5
        L_0x02ae:
            androidx.compose.ui.graphics.drawscope.DrawContext r2 = r2.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r2 = r2.getTransform()
            float r1 = -r1
            float r3 = -r11
            r2.translate(r1, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-JqoCqck  reason: not valid java name */
    public final DrawResult m265drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, Brush brush2, Outline.Rounded rounded, long j, long j2, boolean z, float f) {
        CacheDrawScope cacheDrawScope2 = cacheDrawScope;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            long r10 = rounded.getRoundRect().m4037getTopLeftCornerRadiuskKHJgLs();
            return cacheDrawScope2.onDrawWithContent(new BorderModifierNode$drawRoundRectBorder$1(z, brush2, r10, f / ((float) 2), f, j, j2, new Stroke(f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null)));
        }
        float f2 = f;
        if (this.borderCache == null) {
            this.borderCache = new BorderCache((ImageBitmap) null, (Canvas) null, (CanvasDrawScope) null, (Path) null, 15, (DefaultConstructorMarker) null);
        }
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        return cacheDrawScope2.onDrawWithContent(new BorderModifierNode$drawRoundRectBorder$2(BorderKt.createRoundRectPath(borderCache2.obtainPath(), rounded.getRoundRect(), f2, z), brush2));
    }
}
