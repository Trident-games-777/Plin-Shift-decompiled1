package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;

public final class BitmapCompat {
    static int sizeAtStep(int i, int i2, int i3, int i4) {
        return i3 == 0 ? i2 : i3 > 0 ? i * (1 << (i4 - i3)) : i2 << ((-i3) - 1);
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        bitmap.setHasMipMap(z);
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static Bitmap createScaledBitmap(Bitmap bitmap, int i, int i2, Rect rect, boolean z) {
        int i3;
        double d;
        double d2;
        int i4;
        int i5;
        Bitmap bitmap2;
        Bitmap bitmap3 = bitmap;
        int i6 = i;
        int i7 = i2;
        Rect rect2 = rect;
        if (i6 <= 0 || i7 <= 0) {
            throw new IllegalArgumentException("dstW and dstH must be > 0!");
        } else if (rect2 == null || (!rect2.isEmpty() && rect2.left >= 0 && rect2.right <= bitmap3.getWidth() && rect2.top >= 0 && rect2.bottom <= bitmap3.getHeight())) {
            Bitmap copyBitmapIfHardware = Api27Impl.copyBitmapIfHardware(bitmap3);
            int width = rect2 != null ? rect2.width() : bitmap3.getWidth();
            int height = rect2 != null ? rect2.height() : bitmap3.getHeight();
            float f = ((float) i6) / ((float) width);
            float f2 = ((float) i7) / ((float) height);
            int i8 = rect2 != null ? rect2.left : 0;
            int i9 = rect2 != null ? rect2.top : 0;
            if (i8 == 0 && i9 == 0 && i6 == bitmap3.getWidth() && i7 == bitmap3.getHeight()) {
                return (!bitmap3.isMutable() || bitmap3 != copyBitmapIfHardware) ? copyBitmapIfHardware : bitmap3.copy(bitmap3.getConfig(), true);
            }
            Paint paint = new Paint(1);
            paint.setFilterBitmap(true);
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.setPaintBlendMode(paint);
            } else {
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            }
            if (width == i6 && height == i7) {
                Bitmap createBitmap = Bitmap.createBitmap(i6, i7, copyBitmapIfHardware.getConfig());
                new Canvas(createBitmap).drawBitmap(copyBitmapIfHardware, (float) (-i8), (float) (-i9), paint);
                return createBitmap;
            }
            double log = Math.log(2.0d);
            if (f > 1.0f) {
                i3 = i8;
                d = Math.ceil(Math.log((double) f) / log);
            } else {
                i3 = i8;
                d = Math.floor(Math.log((double) f) / log);
            }
            int i10 = (int) d;
            if (f2 > 1.0f) {
                d2 = Math.ceil(Math.log((double) f2) / log);
            } else {
                d2 = Math.floor(Math.log((double) f2) / log);
            }
            int i11 = (int) d2;
            if (!z || Api27Impl.isAlreadyF16AndLinear(bitmap3)) {
                bitmap2 = null;
                i5 = i3;
                i4 = 0;
            } else {
                Bitmap createBitmapWithSourceColorspace = Api27Impl.createBitmapWithSourceColorspace(i10 > 0 ? sizeAtStep(width, i6, 1, i10) : width, i11 > 0 ? sizeAtStep(height, i7, 1, i11) : height, bitmap3, true);
                new Canvas(createBitmapWithSourceColorspace).drawBitmap(copyBitmapIfHardware, (float) (-i3), (float) (-i9), paint);
                Bitmap bitmap4 = createBitmapWithSourceColorspace;
                bitmap2 = copyBitmapIfHardware;
                copyBitmapIfHardware = bitmap4;
                i4 = 1;
                i9 = 0;
                i5 = 0;
            }
            Rect rect3 = new Rect(i5, i9, width, height);
            Rect rect4 = new Rect();
            int i12 = i10;
            int i13 = i11;
            while (true) {
                if (i12 == 0 && i13 == 0) {
                    break;
                }
                if (i12 < 0) {
                    i12++;
                } else if (i12 > 0) {
                    i12--;
                }
                if (i13 < 0) {
                    i13++;
                } else if (i13 > 0) {
                    i13--;
                }
                int i14 = i12;
                int i15 = i4;
                rect4.set(0, 0, sizeAtStep(width, i6, i12, i10), sizeAtStep(height, i7, i13, i11));
                boolean z2 = i14 == 0 && i13 == 0;
                boolean z3 = bitmap2 != null && bitmap2.getWidth() == i6 && bitmap2.getHeight() == i7;
                if (bitmap2 == null || bitmap2 == bitmap3 || ((z && !Api27Impl.isAlreadyF16AndLinear(bitmap2)) || (z2 && (!z3 || i15 != 0)))) {
                    if (!(bitmap2 == bitmap3 || bitmap2 == null)) {
                        bitmap2.recycle();
                    }
                    bitmap2 = Api27Impl.createBitmapWithSourceColorspace(sizeAtStep(width, i6, i14 > 0 ? i15 : i14, i10), sizeAtStep(height, i7, i13 > 0 ? i15 : i13, i11), bitmap3, z && !z2);
                }
                new Canvas(bitmap2).drawBitmap(copyBitmapIfHardware, rect3, rect4, paint);
                rect3.set(rect4);
                Bitmap bitmap5 = bitmap2;
                bitmap2 = copyBitmapIfHardware;
                copyBitmapIfHardware = bitmap5;
                i12 = i14;
                i4 = i15;
            }
            if (!(bitmap2 == bitmap3 || bitmap2 == null)) {
                bitmap2.recycle();
            }
            return copyBitmapIfHardware;
        } else {
            throw new IllegalArgumentException("srcRect must be contained by srcBm!");
        }
    }

    private BitmapCompat() {
    }

    static class Api27Impl {
        private Api27Impl() {
        }

        static Bitmap createBitmapWithSourceColorspace(int i, int i2, Bitmap bitmap, boolean z) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
            }
            return Bitmap.createBitmap(i, i2, config, bitmap.hasAlpha(), colorSpace);
        }

        static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }

        static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                config = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return bitmap.copy(config, true);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            if (bitmap.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }
}
