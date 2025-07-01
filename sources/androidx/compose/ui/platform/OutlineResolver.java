package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b,\u0010-J:\u0010.\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010/\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020'H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u000eH\u0002J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020#H\u0002J0\u0010<\u001a\u00020\b*\u0004\u0018\u00010#2\u0006\u0010=\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR\u000e\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u00020\u001aX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u001dX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006A"}, d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", "()V", "androidOutline", "Landroid/graphics/Outline;", "getAndroidOutline", "()Landroid/graphics/Outline;", "<set-?>", "", "cacheIsDirty", "getCacheIsDirty$ui_release", "()Z", "cachedOutline", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "isSupportedOutline", "outline", "Landroidx/compose/ui/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "outlineNeeded", "outlinePath", "rectSize", "Landroidx/compose/ui/geometry/Size;", "J", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "roundedCornerRadius", "", "tmpOpPath", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "tmpTouchPointPath", "usePathForClip", "clipToOutline", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", "update", "alpha", "elevation", "size", "update-S_szKao", "(Landroidx/compose/ui/graphics/Outline;FZFJ)Z", "updateCache", "updateCacheWithPath", "composePath", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "isSameBounds", "offset", "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlineResolver.android.kt */
public final class OutlineResolver {
    public static final int $stable = 8;
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private boolean isSupportedOutline = true;
    private androidx.compose.ui.graphics.Outline outline;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver() {
        Outline outline2 = new Outline();
        outline2.setAlpha(1.0f);
        this.cachedOutline = outline2;
        this.rectTopLeft = Offset.Companion.m4003getZeroF1C5BW0();
        this.rectSize = Size.Companion.m4065getZeroNHjbRc();
    }

    public final boolean getCacheIsDirty$ui_release() {
        return this.cacheIsDirty;
    }

    public final Outline getAndroidOutline() {
        updateCache();
        if (!this.outlineNeeded || !this.isSupportedOutline) {
            return null;
        }
        return this.cachedOutline;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    /* renamed from: update-S_szKao  reason: not valid java name */
    public final boolean m6321updateS_szKao(androidx.compose.ui.graphics.Outline outline2, float f, boolean z, float f2, long j) {
        this.cachedOutline.setAlpha(f);
        boolean areEqual = Intrinsics.areEqual((Object) this.outline, (Object) outline2);
        boolean z2 = !areEqual;
        if (!areEqual) {
            this.outline = outline2;
            this.cacheIsDirty = true;
        }
        this.rectSize = j;
        boolean z3 = outline2 != null && (z || f2 > 0.0f);
        if (this.outlineNeeded != z3) {
            this.outlineNeeded = z3;
            this.cacheIsDirty = true;
        }
        return z2;
    }

    /* renamed from: isInOutline-k-4lQ0M  reason: not valid java name */
    public final boolean m6320isInOutlinek4lQ0M(long j) {
        androidx.compose.ui.graphics.Outline outline2;
        if (this.outlineNeeded && (outline2 = this.outline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline2, Offset.m3987getXimpl(j), Offset.m3988getYimpl(j), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (m6319isSameBounds4L21HEs(r1, r0.rectTopLeft, r0.rectSize, r6) == false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clipToOutline(androidx.compose.ui.graphics.Canvas r21) {
        /*
            r20 = this;
            r0 = r20
            r7 = r21
            androidx.compose.ui.graphics.Path r1 = r0.getClipPath()
            r8 = 0
            r9 = 2
            r10 = 0
            if (r1 == 0) goto L_0x0011
            androidx.compose.ui.graphics.Canvas.m4200clipPathmtrdDE$default(r7, r1, r8, r9, r10)
            return
        L_0x0011:
            float r6 = r0.roundedCornerRadius
            r11 = 0
            int r1 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0072
            androidx.compose.ui.graphics.Path r12 = r0.tmpPath
            androidx.compose.ui.geometry.RoundRect r1 = r0.tmpRoundRect
            if (r12 == 0) goto L_0x002a
            long r2 = r0.rectTopLeft
            long r4 = r0.rectSize
            boolean r1 = r0.m6319isSameBounds4L21HEs(r1, r2, r4, r6)
            r13 = r0
            if (r1 != 0) goto L_0x006e
            goto L_0x002b
        L_0x002a:
            r13 = r0
        L_0x002b:
            long r0 = r13.rectTopLeft
            float r14 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r0)
            long r0 = r13.rectTopLeft
            float r15 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r0)
            long r0 = r13.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r0)
            long r1 = r13.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m4056getWidthimpl(r1)
            float r16 = r0 + r1
            long r0 = r13.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r0)
            long r1 = r13.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m4053getHeightimpl(r1)
            float r17 = r0 + r1
            float r0 = r13.roundedCornerRadius
            long r18 = androidx.compose.ui.geometry.CornerRadiusKt.CornerRadius$default(r0, r11, r9, r10)
            androidx.compose.ui.geometry.RoundRect r0 = androidx.compose.ui.geometry.RoundRectKt.m4041RoundRectgG7oq9Y(r14, r15, r16, r17, r18)
            if (r12 != 0) goto L_0x0064
            androidx.compose.ui.graphics.Path r12 = androidx.compose.ui.graphics.AndroidPath_androidKt.Path()
            goto L_0x0067
        L_0x0064:
            r12.reset()
        L_0x0067:
            androidx.compose.ui.graphics.Path.addRoundRect$default(r12, r0, r10, r9, r10)
            r13.tmpRoundRect = r0
            r13.tmpPath = r12
        L_0x006e:
            androidx.compose.ui.graphics.Canvas.m4200clipPathmtrdDE$default(r7, r12, r8, r9, r10)
            return
        L_0x0072:
            r13 = r0
            long r0 = r13.rectTopLeft
            float r1 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r0)
            long r2 = r13.rectTopLeft
            float r2 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r2)
            long r3 = r13.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r3)
            long r3 = r13.rectSize
            float r3 = androidx.compose.ui.geometry.Size.m4056getWidthimpl(r3)
            float r3 = r3 + r0
            long r4 = r13.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r4)
            long r4 = r13.rectSize
            float r4 = androidx.compose.ui.geometry.Size.m4053getHeightimpl(r4)
            float r4 = r4 + r0
            r6 = 16
            r7 = 0
            r5 = 0
            r0 = r21
            androidx.compose.ui.graphics.Canvas.m4201clipRectN_I0leg$default(r0, r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.OutlineResolver.clipToOutline(androidx.compose.ui.graphics.Canvas):void");
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m4003getZeroF1C5BW0();
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            androidx.compose.ui.graphics.Outline outline2 = this.outline;
            if (outline2 == null || !this.outlineNeeded || Size.m4056getWidthimpl(this.rectSize) <= 0.0f || Size.m4053getHeightimpl(this.rectSize) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            if (outline2 instanceof Outline.Rectangle) {
                updateCacheWithRect(((Outline.Rectangle) outline2).getRect());
            } else if (outline2 instanceof Outline.Rounded) {
                updateCacheWithRoundRect(((Outline.Rounded) outline2).getRoundRect());
            } else if (outline2 instanceof Outline.Generic) {
                updateCacheWithPath(((Outline.Generic) outline2).getPath());
            }
        }
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float r7 = CornerRadius.m3962getXimpl(roundRect.m4037getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(Math.round(roundRect.getLeft()), Math.round(roundRect.getTop()), Math.round(roundRect.getRight()), Math.round(roundRect.getBottom()), r7);
            this.roundedCornerRadius = r7;
            return;
        }
        Path path = this.cachedRrectPath;
        if (path == null) {
            path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = path;
        }
        path.reset();
        Path.addRoundRect$default(path, roundRect, (Path.Direction) null, 2, (Object) null);
        updateCacheWithPath(path);
    }

    private final void updateCacheWithPath(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            android.graphics.Outline outline2 = this.cachedOutline;
            if (path instanceof AndroidPath) {
                outline2.setConvexPath(((AndroidPath) path).getInternalPath());
                this.usePathForClip = !this.cachedOutline.canClip();
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = path;
    }

    /* renamed from: isSameBounds-4L21HEs  reason: not valid java name */
    private final boolean m6319isSameBounds4L21HEs(RoundRect roundRect, long j, long j2, float f) {
        if (roundRect != null && RoundRectKt.isSimple(roundRect) && roundRect.getLeft() == Offset.m3987getXimpl(j) && roundRect.getTop() == Offset.m3988getYimpl(j) && roundRect.getRight() == Offset.m3987getXimpl(j) + Size.m4056getWidthimpl(j2) && roundRect.getBottom() == Offset.m3988getYimpl(j) + Size.m4053getHeightimpl(j2) && CornerRadius.m3962getXimpl(roundRect.m4037getTopLeftCornerRadiuskKHJgLs()) == f) {
            return true;
        }
        return false;
    }
}
