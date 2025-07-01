package coil3.util;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil3.Uri;
import coil3.UriKt;
import coil3.request.ImageRequest;
import coil3.size.Scale;
import coil3.util.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0003H\u0002\u001a\b\u0010\u001f\u001a\u00020\u0012H\u0000\u001a3\u0010)\u001a\u0004\u0018\u00010\u0013*\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u00132\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\b2\b\u0010-\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\u0010.\u001a\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0000\"\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u00020\b*\u00020\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0011\u001a\u00020\u0012*\u00020\u00138@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0014\"\u0018\u0010\u0015\u001a\u00020\b*\u00020\u00138@X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0018\u0010\u0018\u001a\u00020\b*\u00020\u00138@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017\"\u0018\u0010\u001a\u001a\u00020\u001b*\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$\"\u0014\u0010&\u001a\u00020\"X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(\"\u000e\u0010/\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u0018\u00103\u001a\u000204*\u0002058@X\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00068"}, d2 = {"println", "", "level", "Lcoil3/util/Logger$Level;", "tag", "", "message", "toInt", "", "NULL_COLOR_SPACE", "Landroid/graphics/ColorSpace;", "getNULL_COLOR_SPACE", "()Landroid/graphics/ColorSpace;", "nightMode", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "isVector", "", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)Z", "width", "getWidth", "(Landroid/graphics/drawable/Drawable;)I", "height", "getHeight", "safeCacheDir", "Ljava/io/File;", "Landroid/content/Context;", "getSafeCacheDir", "(Landroid/content/Context;)Ljava/io/File;", "isMainThread", "VALID_TRANSFORMATION_CONFIGS", "", "Landroid/graphics/Bitmap$Config;", "getVALID_TRANSFORMATION_CONFIGS", "()[Landroid/graphics/Bitmap$Config;", "[Landroid/graphics/Bitmap$Config;", "DEFAULT_BITMAP_CONFIG", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "getDrawableCompat", "Lcoil3/request/ImageRequest;", "drawable", "resId", "default", "(Lcoil3/request/ImageRequest;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "ASSET_FILE_PATH_ROOT", "isAssetUri", "uri", "Lcoil3/Uri;", "scale", "Lcoil3/size/Scale;", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil3/size/Scale;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: utils.android.kt */
public final class Utils_androidKt {
    public static final String ASSET_FILE_PATH_ROOT = "android_asset";
    private static final Bitmap.Config DEFAULT_BITMAP_CONFIG = Bitmap.Config.HARDWARE;
    private static final ColorSpace NULL_COLOR_SPACE = null;
    private static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS = {Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16};

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* compiled from: utils.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|(2:15|16)|17|19|20|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0055 */
        static {
            /*
                coil3.util.Logger$Level[] r0 = coil3.util.Logger.Level.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                coil3.util.Logger$Level r2 = coil3.util.Logger.Level.Verbose     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                coil3.util.Logger$Level r3 = coil3.util.Logger.Level.Debug     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                coil3.util.Logger$Level r4 = coil3.util.Logger.Level.Info     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                coil3.util.Logger$Level r5 = coil3.util.Logger.Level.Warn     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                coil3.util.Logger$Level r5 = coil3.util.Logger.Level.Error     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r6 = 5
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x005d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.util.Utils_androidKt.WhenMappings.<clinit>():void");
        }
    }

    public static final void println(Logger.Level level, String str, String str2) {
        Log.println(toInt(level), str, str2);
    }

    private static final int toInt(Logger.Level level) {
        int i = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (i == 5) {
            return 6;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ColorSpace getNULL_COLOR_SPACE() {
        return NULL_COLOR_SPACE;
    }

    public static final int getNightMode(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    public static final boolean isVector(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof VectorDrawableCompat);
    }

    public static final int getWidth(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final int getHeight(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final File getSafeCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            cacheDir.mkdirs();
            return cacheDir;
        }
        throw new IllegalStateException("cacheDir == null".toString());
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper());
    }

    public static final Bitmap.Config[] getVALID_TRANSFORMATION_CONFIGS() {
        return VALID_TRANSFORMATION_CONFIGS;
    }

    public static final Bitmap.Config getDEFAULT_BITMAP_CONFIG() {
        return DEFAULT_BITMAP_CONFIG;
    }

    public static final Drawable getDrawableCompat(ImageRequest imageRequest, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() != 0) {
            return ContextsKt.getDrawableCompat(imageRequest.getContext(), num.intValue());
        }
        return null;
    }

    public static final boolean isAssetUri(Uri uri) {
        return Intrinsics.areEqual((Object) uri.getScheme(), (Object) UtilsKt.SCHEME_FILE) && Intrinsics.areEqual(CollectionsKt.firstOrNull(UriKt.getPathSegments(uri)), (Object) ASSET_FILE_PATH_ROOT);
    }

    public static final Scale getScale(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i = scaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[scaleType.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }
}
