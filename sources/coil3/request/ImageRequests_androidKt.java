package coil3.request;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.Extras;
import coil3.ExtrasKt;
import coil3.Image;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.request.ImageRequest;
import coil3.target.ImageViewTarget;
import coil3.transform.Transformation;
import coil3.transition.CrossfadeTransition;
import coil3.transition.Transition;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.ContextsKt;
import coil3.util.Utils_androidKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a#\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\r¢\u0006\u0002\u0010\u000e\u001a\u0018\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0006\u001a\u0012\u0010\u0019\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0006\u001a\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002\u001a\u0012\u0010!\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\"\u001a\u00020\u001d\u001a\u0012\u0010!\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001d\u001a\u0012\u0010&\u001a\u00020\u0001*\u00020\u00012\u0006\u0010'\u001a\u00020(\u001a\u0012\u0010&\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010'\u001a\u00020(\u001a\u0014\u0010-\u001a\u00020\u0001*\u00020\u00012\u0006\u0010-\u001a\u00020.H\u0007\u001a\u0014\u0010-\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0007\u001a\u0012\u00103\u001a\u00020\u0001*\u00020\u00012\u0006\u00104\u001a\u000205\u001a\u0012\u00103\u001a\u00020\u001b*\u00020\u001b2\u0006\u00104\u001a\u000205\u001a\u0014\u0010:\u001a\u00020\u0001*\u00020\u00012\b\u0010;\u001a\u0004\u0018\u00010<\u001a\u0014\u0010:\u001a\u00020\u0001*\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010=\u001a\u0012\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u00104\u001a\u000205\u001a\u0012\u0010B\u001a\u00020\u001b*\u00020\u001b2\u0006\u00104\u001a\u000205\u001a\u0012\u0010E\u001a\u00020\u0001*\u00020\u00012\u0006\u00104\u001a\u000205\u001a\u0012\u0010E\u001a\u00020\u001b*\u00020\u001b2\u0006\u00104\u001a\u000205\u001a\u0012\u0010H\u001a\u00020\u0001*\u00020\u00012\u0006\u00104\u001a\u000205\u001a\u0012\u0010H\u001a\u00020\u001b*\u00020\u001b2\u0006\u00104\u001a\u000205\"\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\u000f*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\u000f*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0014\"!\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000f0\u0015*\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0017\"\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000f0\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010\u001e\u001a\u00020\u0006*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0015\u0010!\u001a\u00020\u001d*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0015*\u00020\u00168F¢\u0006\u0006\u001a\u0004\b#\u0010\u0017\"\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010&\u001a\u00020(*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b)\u0010*\"\u0015\u0010&\u001a\u00020(*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b)\u0010+\"\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020(0\u0015*\u00020\u00168F¢\u0006\u0006\u001a\u0004\b)\u0010\u0017\"\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020(0\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010-\u001a\u0004\u0018\u00010.*\u00020\u00108G¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0017\u0010-\u001a\u0004\u0018\u00010.*\u00020\u00138G¢\u0006\u0006\u001a\u0004\b/\u00101\"\u001d\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u0015*\u00020\u00168G¢\u0006\u0006\u001a\u0004\b/\u0010\u0017\"\u0016\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0015\u00103\u001a\u000205*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b6\u00107\"\u0015\u00103\u001a\u000205*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b6\u00108\"\u001b\u00103\u001a\b\u0012\u0004\u0012\u0002050\u0015*\u00020\u00168F¢\u0006\u0006\u001a\u0004\b6\u0010\u0017\"\u0014\u00109\u001a\b\u0012\u0004\u0012\u0002050\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010:\u001a\u0004\u0018\u00010=*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b>\u0010?\"\u0017\u0010:\u001a\u0004\u0018\u00010=*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b>\u0010@\"\u001d\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0\u0015*\u00020\u00168F¢\u0006\u0006\u001a\u0004\b>\u0010\u0017\"\u0016\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010B\u001a\u000205*\u00020\u00108F¢\u0006\u0006\u001a\u0004\bC\u00107\"\u0015\u0010B\u001a\u000205*\u00020\u00138F¢\u0006\u0006\u001a\u0004\bC\u00108\"\u001b\u0010B\u001a\b\u0012\u0004\u0012\u0002050\u0015*\u00020\u00168F¢\u0006\u0006\u001a\u0004\bC\u0010\u0017\"\u0014\u0010D\u001a\b\u0012\u0004\u0012\u0002050\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010E\u001a\u000205*\u00020\u00108F¢\u0006\u0006\u001a\u0004\bF\u00107\"\u0015\u0010E\u001a\u000205*\u00020\u00138F¢\u0006\u0006\u001a\u0004\bF\u00108\"\u001b\u0010E\u001a\b\u0012\u0004\u0012\u0002050\u0015*\u00020\u00168F¢\u0006\u0006\u001a\u0004\bF\u0010\u0017\"\u0014\u0010G\u001a\b\u0012\u0004\u0012\u0002050\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010H\u001a\u000205*\u00020\u00108F¢\u0006\u0006\u001a\u0004\bI\u00107\"\u0015\u0010H\u001a\u000205*\u00020\u00138F¢\u0006\u0006\u001a\u0004\bI\u00108\"\u001b\u0010H\u001a\b\u0012\u0004\u0012\u0002050\u0015*\u00020\u00168F¢\u0006\u0006\u001a\u0004\bI\u0010\u0017\"\u0014\u0010J\u001a\b\u0012\u0004\u0012\u0002050\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"target", "Lcoil3/request/ImageRequest$Builder;", "imageView", "Landroid/widget/ImageView;", "placeholder", "drawableResId", "", "drawable", "Landroid/graphics/drawable/Drawable;", "error", "fallback", "transformations", "", "Lcoil3/transform/Transformation;", "(Lcoil3/request/ImageRequest$Builder;[Lcoil3/transform/Transformation;)Lcoil3/request/ImageRequest$Builder;", "", "Lcoil3/request/ImageRequest;", "getTransformations", "(Lcoil3/request/ImageRequest;)Ljava/util/List;", "Lcoil3/request/Options;", "(Lcoil3/request/Options;)Ljava/util/List;", "Lcoil3/Extras$Key;", "Lcoil3/Extras$Key$Companion;", "(Lcoil3/Extras$Key$Companion;)Lcoil3/Extras$Key;", "transformationsKey", "crossfade", "durationMillis", "Lcoil3/ImageLoader$Builder;", "newCrossfadeTransitionFactory", "Lcoil3/transition/Transition$Factory;", "crossfadeMillis", "getCrossfadeMillis", "(Lcoil3/request/ImageRequest;)I", "transitionFactory", "factory", "getTransitionFactory", "(Lcoil3/request/ImageRequest;)Lcoil3/transition/Transition$Factory;", "transitionFactoryKey", "bitmapConfig", "config", "Landroid/graphics/Bitmap$Config;", "getBitmapConfig", "(Lcoil3/request/ImageRequest;)Landroid/graphics/Bitmap$Config;", "(Lcoil3/request/Options;)Landroid/graphics/Bitmap$Config;", "bitmapConfigKey", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(Lcoil3/request/ImageRequest;)Landroid/graphics/ColorSpace;", "(Lcoil3/request/Options;)Landroid/graphics/ColorSpace;", "colorSpaceKey", "premultipliedAlpha", "enable", "", "getPremultipliedAlpha", "(Lcoil3/request/ImageRequest;)Z", "(Lcoil3/request/Options;)Z", "premultipliedAlphaKey", "lifecycle", "owner", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "(Lcoil3/request/ImageRequest;)Landroidx/lifecycle/Lifecycle;", "(Lcoil3/request/Options;)Landroidx/lifecycle/Lifecycle;", "lifecycleKey", "allowConversionToBitmap", "getAllowConversionToBitmap", "allowConversionToBitmapKey", "allowHardware", "getAllowHardware", "allowHardwareKey", "allowRgb565", "getAllowRgb565", "allowRgb565Key", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: imageRequests.android.kt */
public final class ImageRequests_androidKt {
    private static final Extras.Key<Boolean> allowConversionToBitmapKey = new Extras.Key<>(true);
    private static final Extras.Key<Boolean> allowHardwareKey = new Extras.Key<>(true);
    private static final Extras.Key<Boolean> allowRgb565Key = new Extras.Key<>(false);
    private static final Extras.Key<Bitmap.Config> bitmapConfigKey = new Extras.Key<>(Utils_androidKt.getDEFAULT_BITMAP_CONFIG());
    private static final Extras.Key<ColorSpace> colorSpaceKey = new Extras.Key<>(Utils_androidKt.getNULL_COLOR_SPACE());
    private static final Extras.Key<Lifecycle> lifecycleKey = new Extras.Key<>(null);
    private static final Extras.Key<Boolean> premultipliedAlphaKey = new Extras.Key<>(true);
    private static final Extras.Key<List<Transformation>> transformationsKey = new Extras.Key<>(CollectionsKt.emptyList());
    private static final Extras.Key<Transition.Factory> transitionFactoryKey = new Extras.Key<>(Transition.Factory.NONE);

    public static final ImageRequest.Builder target(ImageRequest.Builder builder, ImageView imageView) {
        return builder.target(new ImageViewTarget(imageView));
    }

    public static final ImageRequest.Builder placeholder(ImageRequest.Builder builder, int i) {
        return builder.placeholder((Function1<? super ImageRequest, ? extends Image>) new ImageRequests_androidKt$$ExternalSyntheticLambda2(i));
    }

    /* access modifiers changed from: private */
    public static final Image placeholder$lambda$0(int i, ImageRequest imageRequest) {
        return Image_androidKt.asImage(ContextsKt.getDrawableCompat(imageRequest.getContext(), i));
    }

    public static final ImageRequest.Builder placeholder(ImageRequest.Builder builder, Drawable drawable) {
        return builder.placeholder(drawable != null ? Image_androidKt.asImage(drawable) : null);
    }

    public static final ImageRequest.Builder error(ImageRequest.Builder builder, int i) {
        return builder.error((Function1<? super ImageRequest, ? extends Image>) new ImageRequests_androidKt$$ExternalSyntheticLambda1(i));
    }

    /* access modifiers changed from: private */
    public static final Image error$lambda$1(int i, ImageRequest imageRequest) {
        return Image_androidKt.asImage(ContextsKt.getDrawableCompat(imageRequest.getContext(), i));
    }

    public static final ImageRequest.Builder error(ImageRequest.Builder builder, Drawable drawable) {
        return builder.error(drawable != null ? Image_androidKt.asImage(drawable) : null);
    }

    public static final ImageRequest.Builder fallback(ImageRequest.Builder builder, int i) {
        return builder.fallback((Function1<? super ImageRequest, ? extends Image>) new ImageRequests_androidKt$$ExternalSyntheticLambda0(i));
    }

    /* access modifiers changed from: private */
    public static final Image fallback$lambda$2(int i, ImageRequest imageRequest) {
        return Image_androidKt.asImage(ContextsKt.getDrawableCompat(imageRequest.getContext(), i));
    }

    public static final ImageRequest.Builder fallback(ImageRequest.Builder builder, Drawable drawable) {
        return builder.fallback(drawable != null ? Image_androidKt.asImage(drawable) : null);
    }

    public static final ImageRequest.Builder transformations(ImageRequest.Builder builder, Transformation... transformationArr) {
        return transformations(builder, (List<? extends Transformation>) ArraysKt.toList((T[]) transformationArr));
    }

    public static final ImageRequest.Builder transformations(ImageRequest.Builder builder, List<? extends Transformation> list) {
        builder.getExtras().set(transformationsKey, Collections_jvmCommonKt.toImmutableList(list));
        return builder;
    }

    public static final List<Transformation> getTransformations(ImageRequest imageRequest) {
        return (List) ExtrasKt.getExtra(imageRequest, transformationsKey);
    }

    public static final List<Transformation> getTransformations(Options options) {
        return (List) ExtrasKt.getExtra(options, transformationsKey);
    }

    public static final Extras.Key<List<Transformation>> getTransformations(Extras.Key.Companion companion) {
        return transformationsKey;
    }

    public static final ImageRequest.Builder crossfade(ImageRequest.Builder builder, int i) {
        return transitionFactory(builder, newCrossfadeTransitionFactory(i));
    }

    public static final ImageLoader.Builder crossfade(ImageLoader.Builder builder, int i) {
        return transitionFactory(builder, newCrossfadeTransitionFactory(i));
    }

    private static final Transition.Factory newCrossfadeTransitionFactory(int i) {
        if (i > 0) {
            return new CrossfadeTransition.Factory(i, false, 2, (DefaultConstructorMarker) null);
        }
        return Transition.Factory.NONE;
    }

    public static final int getCrossfadeMillis(ImageRequest imageRequest) {
        Transition.Factory transitionFactory = getTransitionFactory(imageRequest);
        CrossfadeTransition.Factory factory = transitionFactory instanceof CrossfadeTransition.Factory ? (CrossfadeTransition.Factory) transitionFactory : null;
        if (factory != null) {
            return factory.getDurationMillis();
        }
        return 0;
    }

    public static final ImageRequest.Builder transitionFactory(ImageRequest.Builder builder, Transition.Factory factory) {
        builder.getExtras().set(transitionFactoryKey, factory);
        return builder;
    }

    public static final ImageLoader.Builder transitionFactory(ImageLoader.Builder builder, Transition.Factory factory) {
        builder.getExtras().set(transitionFactoryKey, factory);
        return builder;
    }

    public static final Transition.Factory getTransitionFactory(ImageRequest imageRequest) {
        return (Transition.Factory) ExtrasKt.getExtra(imageRequest, transitionFactoryKey);
    }

    public static final Extras.Key<Transition.Factory> getTransitionFactory(Extras.Key.Companion companion) {
        return transitionFactoryKey;
    }

    public static final ImageRequest.Builder bitmapConfig(ImageRequest.Builder builder, Bitmap.Config config) {
        builder.getExtras().set(bitmapConfigKey, config);
        return builder;
    }

    public static final ImageLoader.Builder bitmapConfig(ImageLoader.Builder builder, Bitmap.Config config) {
        builder.getExtras().set(bitmapConfigKey, config);
        return builder;
    }

    public static final Bitmap.Config getBitmapConfig(ImageRequest imageRequest) {
        return (Bitmap.Config) ExtrasKt.getExtra(imageRequest, bitmapConfigKey);
    }

    public static final Bitmap.Config getBitmapConfig(Options options) {
        return (Bitmap.Config) ExtrasKt.getExtra(options, bitmapConfigKey);
    }

    public static final Extras.Key<Bitmap.Config> getBitmapConfig(Extras.Key.Companion companion) {
        return bitmapConfigKey;
    }

    public static final ImageRequest.Builder colorSpace(ImageRequest.Builder builder, ColorSpace colorSpace) {
        builder.getExtras().set(colorSpaceKey, colorSpace);
        return builder;
    }

    public static final ImageLoader.Builder colorSpace(ImageLoader.Builder builder, ColorSpace colorSpace) {
        builder.getExtras().set(colorSpaceKey, colorSpace);
        return builder;
    }

    public static final ColorSpace getColorSpace(ImageRequest imageRequest) {
        return (ColorSpace) ExtrasKt.getExtra(imageRequest, colorSpaceKey);
    }

    public static final ColorSpace getColorSpace(Options options) {
        return (ColorSpace) ExtrasKt.getExtra(options, colorSpaceKey);
    }

    public static final Extras.Key<ColorSpace> getColorSpace(Extras.Key.Companion companion) {
        return colorSpaceKey;
    }

    public static final ImageRequest.Builder premultipliedAlpha(ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(premultipliedAlphaKey, Boolean.valueOf(z));
        return builder;
    }

    public static final ImageLoader.Builder premultipliedAlpha(ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(premultipliedAlphaKey, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getPremultipliedAlpha(ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, premultipliedAlphaKey)).booleanValue();
    }

    public static final boolean getPremultipliedAlpha(Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, premultipliedAlphaKey)).booleanValue();
    }

    public static final Extras.Key<Boolean> getPremultipliedAlpha(Extras.Key.Companion companion) {
        return premultipliedAlphaKey;
    }

    public static final ImageRequest.Builder lifecycle(ImageRequest.Builder builder, LifecycleOwner lifecycleOwner) {
        return lifecycle(builder, lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null);
    }

    public static final ImageRequest.Builder lifecycle(ImageRequest.Builder builder, Lifecycle lifecycle) {
        builder.getExtras().set(lifecycleKey, lifecycle);
        return builder;
    }

    public static final Lifecycle getLifecycle(ImageRequest imageRequest) {
        return (Lifecycle) ExtrasKt.getExtra(imageRequest, lifecycleKey);
    }

    public static final Lifecycle getLifecycle(Options options) {
        return (Lifecycle) ExtrasKt.getExtra(options, lifecycleKey);
    }

    public static final Extras.Key<Lifecycle> getLifecycle(Extras.Key.Companion companion) {
        return lifecycleKey;
    }

    public static final ImageRequest.Builder allowConversionToBitmap(ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowConversionToBitmapKey, Boolean.valueOf(z));
        return builder;
    }

    public static final ImageLoader.Builder allowConversionToBitmap(ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowConversionToBitmapKey, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getAllowConversionToBitmap(ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowConversionToBitmapKey)).booleanValue();
    }

    public static final boolean getAllowConversionToBitmap(Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowConversionToBitmapKey)).booleanValue();
    }

    public static final Extras.Key<Boolean> getAllowConversionToBitmap(Extras.Key.Companion companion) {
        return allowConversionToBitmapKey;
    }

    public static final ImageRequest.Builder allowHardware(ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowHardwareKey, Boolean.valueOf(z));
        return builder;
    }

    public static final ImageLoader.Builder allowHardware(ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowHardwareKey, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getAllowHardware(ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowHardwareKey)).booleanValue();
    }

    public static final boolean getAllowHardware(Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowHardwareKey)).booleanValue();
    }

    public static final Extras.Key<Boolean> getAllowHardware(Extras.Key.Companion companion) {
        return allowHardwareKey;
    }

    public static final ImageRequest.Builder allowRgb565(ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowRgb565Key, Boolean.valueOf(z));
        return builder;
    }

    public static final ImageLoader.Builder allowRgb565(ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowRgb565Key, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getAllowRgb565(ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowRgb565Key)).booleanValue();
    }

    public static final boolean getAllowRgb565(Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowRgb565Key)).booleanValue();
    }

    public static final Extras.Key<Boolean> getAllowRgb565(Extras.Key.Companion companion) {
        return allowRgb565Key;
    }
}
