package androidx.compose.foundation;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÂ\u0003J9\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\tJ\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J@\u0010\u0018\u001a\u00020\u0003*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\b\"H\bø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/foundation/BorderCache;", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "borderPath", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;Landroidx/compose/ui/graphics/Path;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "obtainPath", "toString", "", "drawBorderCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "borderSize", "Landroidx/compose/ui/unit/IntSize;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBorderCache-EMwLDEs", "(Landroidx/compose/ui/draw/CacheDrawScope;JILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/ImageBitmap;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderCache {
    private Path borderPath;
    /* access modifiers changed from: private */
    public Canvas canvas;
    /* access modifiers changed from: private */
    public CanvasDrawScope canvasDrawScope;
    /* access modifiers changed from: private */
    public ImageBitmap imageBitmap;

    public BorderCache() {
        this((ImageBitmap) null, (Canvas) null, (CanvasDrawScope) null, (Path) null, 15, (DefaultConstructorMarker) null);
    }

    private final ImageBitmap component1() {
        return this.imageBitmap;
    }

    private final Canvas component2() {
        return this.canvas;
    }

    private final CanvasDrawScope component3() {
        return this.canvasDrawScope;
    }

    private final Path component4() {
        return this.borderPath;
    }

    public static /* synthetic */ BorderCache copy$default(BorderCache borderCache, ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            imageBitmap2 = borderCache.imageBitmap;
        }
        if ((i & 2) != 0) {
            canvas2 = borderCache.canvas;
        }
        if ((i & 4) != 0) {
            canvasDrawScope2 = borderCache.canvasDrawScope;
        }
        if ((i & 8) != 0) {
            path = borderCache.borderPath;
        }
        return borderCache.copy(imageBitmap2, canvas2, canvasDrawScope2, path);
    }

    public final BorderCache copy(ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path) {
        return new BorderCache(imageBitmap2, canvas2, canvasDrawScope2, path);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderCache)) {
            return false;
        }
        BorderCache borderCache = (BorderCache) obj;
        return Intrinsics.areEqual((Object) this.imageBitmap, (Object) borderCache.imageBitmap) && Intrinsics.areEqual((Object) this.canvas, (Object) borderCache.canvas) && Intrinsics.areEqual((Object) this.canvasDrawScope, (Object) borderCache.canvasDrawScope) && Intrinsics.areEqual((Object) this.borderPath, (Object) borderCache.borderPath);
    }

    public int hashCode() {
        ImageBitmap imageBitmap2 = this.imageBitmap;
        int i = 0;
        int hashCode = (imageBitmap2 == null ? 0 : imageBitmap2.hashCode()) * 31;
        Canvas canvas2 = this.canvas;
        int hashCode2 = (hashCode + (canvas2 == null ? 0 : canvas2.hashCode())) * 31;
        CanvasDrawScope canvasDrawScope2 = this.canvasDrawScope;
        int hashCode3 = (hashCode2 + (canvasDrawScope2 == null ? 0 : canvasDrawScope2.hashCode())) * 31;
        Path path = this.borderPath;
        if (path != null) {
            i = path.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + ')';
    }

    public BorderCache(ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path) {
        this.imageBitmap = imageBitmap2;
        this.canvas = canvas2;
        this.canvasDrawScope = canvasDrawScope2;
        this.borderPath = path;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BorderCache(ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageBitmap2, (i & 2) != 0 ? null : canvas2, (i & 4) != 0 ? null : canvasDrawScope2, (i & 8) != 0 ? null : path);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m4456equalsimpl(r9, r3) != false) goto L_0x0041;
     */
    /* renamed from: drawBorderCache-EMwLDEs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.graphics.ImageBitmap m256drawBorderCacheEMwLDEs(androidx.compose.ui.draw.CacheDrawScope r27, long r28, int r30, kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit> r31) {
        /*
            r26 = this;
            r0 = r26
            androidx.compose.ui.graphics.ImageBitmap r1 = r0.imageBitmap
            androidx.compose.ui.graphics.Canvas r2 = r0.canvas
            r3 = 0
            if (r1 == 0) goto L_0x0016
            int r4 = r1.m4453getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r4 = androidx.compose.ui.graphics.ImageBitmapConfig.m4454boximpl(r4)
            goto L_0x0017
        L_0x0016:
            r4 = r3
        L_0x0017:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r5 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r5 = r5.m4462getArgb8888_sVssgQ()
            r6 = 0
            if (r4 != 0) goto L_0x0022
            r4 = r6
            goto L_0x002a
        L_0x0022:
            int r4 = r4.m4460unboximpl()
            boolean r4 = androidx.compose.ui.graphics.ImageBitmapConfig.m4457equalsimpl0(r4, r5)
        L_0x002a:
            if (r4 != 0) goto L_0x003f
            if (r1 == 0) goto L_0x0036
            int r3 = r1.m4453getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r3 = androidx.compose.ui.graphics.ImageBitmapConfig.m4454boximpl(r3)
        L_0x0036:
            r9 = r30
            boolean r3 = androidx.compose.ui.graphics.ImageBitmapConfig.m4456equalsimpl(r9, r3)
            if (r3 == 0) goto L_0x0042
            goto L_0x0041
        L_0x003f:
            r9 = r30
        L_0x0041:
            r6 = 1
        L_0x0042:
            if (r1 == 0) goto L_0x006a
            if (r2 == 0) goto L_0x006a
            long r3 = r27.m3868getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m4056getWidthimpl(r3)
            int r4 = r1.getWidth()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x006a
            long r3 = r27.m3868getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m4053getHeightimpl(r3)
            int r4 = r1.getHeight()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x006a
            if (r6 != 0) goto L_0x0085
        L_0x006a:
            int r7 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r28)
            int r8 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r28)
            r12 = 24
            r13 = 0
            r10 = 0
            r11 = 0
            androidx.compose.ui.graphics.ImageBitmap r1 = androidx.compose.ui.graphics.ImageBitmapKt.m4467ImageBitmapx__hDU$default(r7, r8, r9, r10, r11, r12, r13)
            r0.imageBitmap = r1
            androidx.compose.ui.graphics.Canvas r2 = androidx.compose.ui.graphics.CanvasKt.Canvas(r1)
            r0.canvas = r2
        L_0x0085:
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r3 = r0.canvasDrawScope
            if (r3 != 0) goto L_0x0093
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r3 = new androidx.compose.ui.graphics.drawscope.CanvasDrawScope
            r3.<init>()
            r0.canvasDrawScope = r3
        L_0x0093:
            long r9 = androidx.compose.ui.unit.IntSizeKt.m7295toSizeozmzZPI(r28)
            androidx.compose.ui.unit.LayoutDirection r4 = r27.getLayoutDirection()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r5 = r3.getDrawParams()
            androidx.compose.ui.unit.Density r6 = r5.component1()
            androidx.compose.ui.unit.LayoutDirection r7 = r5.component2()
            androidx.compose.ui.graphics.Canvas r8 = r5.component3()
            long r11 = r5.m4761component4NHjbRc()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r5 = r3.getDrawParams()
            r13 = r27
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            r5.setDensity(r13)
            r5.setLayoutDirection(r4)
            r5.setCanvas(r2)
            r5.m4764setSizeuvyYCjk(r9)
            r2.save()
            r4 = r3
            androidx.compose.ui.graphics.drawscope.DrawScope r4 = (androidx.compose.ui.graphics.drawscope.DrawScope) r4
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r5.m4265getBlack0d7_KjU()
            androidx.compose.ui.graphics.BlendMode$Companion r5 = androidx.compose.ui.graphics.BlendMode.Companion
            int r5 = r5.m4143getClear0nO6VwU()
            r15 = 58
            r16 = 0
            r17 = r7
            r18 = r8
            r7 = 0
            r19 = r11
            r11 = 0
            r12 = 0
            r21 = r5
            r24 = r13
            r14 = r6
            r5 = r24
            r13 = 0
            r30 = r1
            r0 = r14
            r1 = r17
            r22 = r19
            r14 = r21
            r17 = r2
            r2 = r18
            androidx.compose.ui.graphics.drawscope.DrawScope.m4840drawRectnJ9OG0$default(r4, r5, r7, r9, r11, r12, r13, r14, r15, r16)
            r5 = r4
            r4 = r31
            r4.invoke(r5)
            r17.restore()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r3 = r3.getDrawParams()
            r3.setDensity(r0)
            r3.setLayoutDirection(r1)
            r3.setCanvas(r2)
            r0 = r22
            r3.m4764setSizeuvyYCjk(r0)
            r30.prepareToDraw()
            return r30
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderCache.m256drawBorderCacheEMwLDEs(androidx.compose.ui.draw.CacheDrawScope, long, int, kotlin.jvm.functions.Function1):androidx.compose.ui.graphics.ImageBitmap");
    }

    public final Path obtainPath() {
        Path path = this.borderPath;
        if (path != null) {
            return path;
        }
        Path Path = AndroidPath_androidKt.Path();
        this.borderPath = Path;
        return Path;
    }
}
