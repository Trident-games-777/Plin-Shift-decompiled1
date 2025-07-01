package coil3;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcoil3/DrawableImage;", "Lcoil3/Image;", "drawable", "Landroid/graphics/drawable/Drawable;", "shareable", "", "<init>", "(Landroid/graphics/drawable/Drawable;Z)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getShareable", "()Z", "size", "", "getSize", "()J", "width", "", "getWidth", "()I", "height", "getHeight", "draw", "", "canvas", "Landroid/graphics/Canvas;", "Lcoil3/Canvas;", "SizeProvider", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: Image.android.kt */
public final class DrawableImage implements Image {
    private final Drawable drawable;
    private final boolean shareable;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcoil3/DrawableImage$SizeProvider;", "", "size", "", "getSize", "()J", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: Image.android.kt */
    public interface SizeProvider {
        long getSize();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawableImage)) {
            return false;
        }
        DrawableImage drawableImage = (DrawableImage) obj;
        return Intrinsics.areEqual((Object) this.drawable, (Object) drawableImage.drawable) && this.shareable == drawableImage.shareable;
    }

    public int hashCode() {
        return (this.drawable.hashCode() * 31) + Boolean.hashCode(this.shareable);
    }

    public String toString() {
        return "DrawableImage(drawable=" + this.drawable + ", shareable=" + this.shareable + ')';
    }

    public DrawableImage(Drawable drawable2, boolean z) {
        this.drawable = drawable2;
        this.shareable = z;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public boolean getShareable() {
        return this.shareable;
    }

    public long getSize() {
        long j;
        Drawable drawable2 = this.drawable;
        if (drawable2 instanceof SizeProvider) {
            j = ((SizeProvider) drawable2).getSize();
        } else {
            j = ((long) Utils_androidKt.getWidth(drawable2)) * 4 * ((long) Utils_androidKt.getHeight(this.drawable));
        }
        return RangesKt.coerceAtLeast(j, 0);
    }

    public int getWidth() {
        return Utils_androidKt.getWidth(this.drawable);
    }

    public int getHeight() {
        return Utils_androidKt.getHeight(this.drawable);
    }

    public void draw(Canvas canvas) {
        this.drawable.draw(canvas);
    }
}
