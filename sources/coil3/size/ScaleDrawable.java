package coil3.size;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import coil3.decode.DecodeUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0017J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016H\u0014J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0001H\u0016J \u0010.\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0016H\u0016J\u0012\u00103\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u00106\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010;H\u0017J\b\u0010<\u001a\u00020\"H\u0016J\b\u0010=\u001a\u00020\u0012H\u0016J\b\u0010>\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcoil3/size/ScaleDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Animatable;", "child", "scale", "Lcoil3/size/Scale;", "<init>", "(Landroid/graphics/drawable/Drawable;Lcoil3/size/Scale;)V", "getChild", "()Landroid/graphics/drawable/Drawable;", "getScale", "()Lcoil3/size/Scale;", "childDx", "", "childDy", "childScale", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "", "setAlpha", "alpha", "getOpacity", "getColorFilter", "Landroid/graphics/ColorFilter;", "setColorFilter", "colorFilter", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "onLevelChange", "", "level", "onStateChange", "state", "", "getIntrinsicWidth", "getIntrinsicHeight", "unscheduleDrawable", "who", "what", "Ljava/lang/Runnable;", "invalidateDrawable", "scheduleDrawable", "when", "", "setTint", "tintColor", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "setTintBlendMode", "blendMode", "Landroid/graphics/BlendMode;", "isRunning", "start", "stop", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ScaleDrawable.kt */
public final class ScaleDrawable extends Drawable implements Drawable.Callback, Animatable {
    private final Drawable child;
    private float childDx;
    private float childDy;
    private float childScale;
    private final Scale scale;

    public ScaleDrawable(Drawable drawable) {
        this(drawable, (Scale) null, 2, (DefaultConstructorMarker) null);
    }

    public final Drawable getChild() {
        return this.child;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScaleDrawable(Drawable drawable, Scale scale2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, (i & 2) != 0 ? Scale.FIT : scale2);
    }

    public final Scale getScale() {
        return this.scale;
    }

    public ScaleDrawable(Drawable drawable, Scale scale2) {
        this.child = drawable;
        this.scale = scale2;
        this.childScale = 1.0f;
        drawable.setCallback(this);
    }

    public int getAlpha() {
        return this.child.getAlpha();
    }

    public void setAlpha(int i) {
        this.child.setAlpha(i);
    }

    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return this.child.getOpacity();
    }

    public ColorFilter getColorFilter() {
        return this.child.getColorFilter();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.child.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        int intrinsicWidth = this.child.getIntrinsicWidth();
        int intrinsicHeight = this.child.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            this.child.setBounds(rect);
            this.childDx = 0.0f;
            this.childDy = 0.0f;
            this.childScale = 1.0f;
            return;
        }
        int width = rect.width();
        int height = rect.height();
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(intrinsicWidth, intrinsicHeight, width, height, this.scale);
        double d = (double) 2;
        int roundToInt = MathKt.roundToInt((((double) width) - (((double) intrinsicWidth) * computeSizeMultiplier)) / d);
        int roundToInt2 = MathKt.roundToInt((((double) height) - (((double) intrinsicHeight) * computeSizeMultiplier)) / d);
        this.child.setBounds(roundToInt, roundToInt2, intrinsicWidth + roundToInt, intrinsicHeight + roundToInt2);
        this.childDx = (float) rect.left;
        this.childDy = (float) rect.top;
        this.childScale = (float) computeSizeMultiplier;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.child.setLevel(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return this.child.setState(iArr);
    }

    public int getIntrinsicWidth() {
        return this.child.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.child.getIntrinsicHeight();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setTint(int i) {
        this.child.setTint(i);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.child.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.child.setTintMode(mode);
    }

    public void setTintBlendMode(BlendMode blendMode) {
        this.child.setTintBlendMode(blendMode);
    }

    public boolean isRunning() {
        Drawable drawable = this.child;
        return (drawable instanceof Animatable) && ((Animatable) drawable).isRunning();
    }

    public void start() {
        Drawable drawable = this.child;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    public void stop() {
        Drawable drawable = this.child;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        try {
            canvas.translate(this.childDx, this.childDy);
            float f = this.childScale;
            canvas.scale(f, f);
            this.child.draw(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }
}
