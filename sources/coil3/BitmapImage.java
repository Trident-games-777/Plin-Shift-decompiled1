package coil3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import coil3.util.BitmapsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcoil3/BitmapImage;", "Lcoil3/Image;", "bitmap", "Landroid/graphics/Bitmap;", "Lcoil3/Bitmap;", "shareable", "", "<init>", "(Landroid/graphics/Bitmap;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getShareable", "()Z", "size", "", "getSize", "()J", "width", "", "getWidth", "()I", "height", "getHeight", "draw", "", "canvas", "Landroid/graphics/Canvas;", "Lcoil3/Canvas;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: Image.android.kt */
public final class BitmapImage implements Image {
    private final Bitmap bitmap;
    private final boolean shareable;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapImage)) {
            return false;
        }
        BitmapImage bitmapImage = (BitmapImage) obj;
        return Intrinsics.areEqual((Object) this.bitmap, (Object) bitmapImage.bitmap) && this.shareable == bitmapImage.shareable;
    }

    public int hashCode() {
        return (this.bitmap.hashCode() * 31) + Boolean.hashCode(this.shareable);
    }

    public String toString() {
        return "BitmapImage(bitmap=" + this.bitmap + ", shareable=" + this.shareable + ')';
    }

    public BitmapImage(Bitmap bitmap2, boolean z) {
        this.bitmap = bitmap2;
        this.shareable = z;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public boolean getShareable() {
        return this.shareable;
    }

    public long getSize() {
        return (long) BitmapsKt.getAllocationByteCountCompat(this.bitmap);
    }

    public int getWidth() {
        return this.bitmap.getWidth();
    }

    public int getHeight() {
        return this.bitmap.getHeight();
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
    }
}
