package coil3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\u00060\u0001j\u0002`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a$\u0010\t\u001a\u00060\u0001j\u0002`\u0006*\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007\u001a&\u0010\t\u001a\u00060\u0001j\u0002`\u0006*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\n\u0010\u0004\u001a\u00020\n*\u00020\u0010\u001a\u0012\u0010\u0004\u001a\u00020\n*\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0011\u001a\u00020\u0010*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\n\u0010\u0002\"\u00020\u00032\u00020\u0003¨\u0006\u0014"}, d2 = {"Bitmap", "Landroid/graphics/Bitmap;", "Canvas", "Landroid/graphics/Canvas;", "asImage", "Lcoil3/BitmapImage;", "Lcoil3/Bitmap;", "shareable", "", "toBitmap", "Lcoil3/Image;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "Landroid/graphics/drawable/Drawable;", "asDrawable", "resources", "Landroid/content/res/Resources;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: Image.android.kt */
public final class Image_androidKt {
    public static final BitmapImage asImage(Bitmap bitmap) {
        return asImage$default(bitmap, false, 1, (Object) null);
    }

    public static final Bitmap toBitmap(Image image) {
        return toBitmap$default(image, 0, 0, 3, (Object) null);
    }

    public static final Bitmap toBitmap(Image image, int i) {
        return toBitmap$default(image, i, 0, 2, (Object) null);
    }

    public static /* synthetic */ BitmapImage asImage$default(Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return asImage(bitmap, z);
    }

    public static final BitmapImage asImage(Bitmap bitmap, boolean z) {
        return new BitmapImage(bitmap, z);
    }

    public static final Bitmap toBitmap(Image image, int i, int i2) {
        return toBitmap(image, i, i2, Bitmap.Config.ARGB_8888);
    }

    public static final Bitmap toBitmap(Image image, int i, int i2, Bitmap.Config config) {
        if (image instanceof BitmapImage) {
            BitmapImage bitmapImage = (BitmapImage) image;
            if (bitmapImage.getBitmap().getWidth() == i && bitmapImage.getBitmap().getHeight() == i2 && bitmapImage.getBitmap().getConfig() == config) {
                return bitmapImage.getBitmap();
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        image.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Image image, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = image.getWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = image.getHeight();
        }
        return toBitmap(image, i, i2);
    }

    public static final Image asImage(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return asImage$default(((BitmapDrawable) drawable).getBitmap(), false, 1, (Object) null);
        }
        return new DrawableImage(drawable, false);
    }

    public static final Image asImage(Drawable drawable, boolean z) {
        if (drawable instanceof BitmapDrawable) {
            return asImage(((BitmapDrawable) drawable).getBitmap(), z);
        }
        return new DrawableImage(drawable, z);
    }

    public static final Drawable asDrawable(Image image, Resources resources) {
        if (image instanceof DrawableImage) {
            return ((DrawableImage) image).getDrawable();
        }
        if (image instanceof BitmapImage) {
            return new BitmapDrawable(resources, ((BitmapImage) image).getBitmap());
        }
        return new ImageDrawable(image);
    }
}
