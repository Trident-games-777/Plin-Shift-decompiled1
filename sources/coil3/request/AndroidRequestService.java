package coil3.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.FrameMetricsAggregator;
import androidx.lifecycle.Lifecycle;
import coil3.BitmapImage;
import coil3.Extras;
import coil3.Image;
import coil3.ImageLoader;
import coil3.memory.MemoryCache;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.size.ViewSizeResolver;
import coil3.size.ViewSizeResolverKt;
import coil3.target.Target;
import coil3.target.ViewTarget;
import coil3.util.BitmapsKt;
import coil3.util.ContextsKt;
import coil3.util.HardwareBitmapService;
import coil3.util.HardwareBitmapsKt;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.Utils_androidKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import okio.FileSystem;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0014*\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u001f\u001a\u00020 *\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0002J\u0016\u0010(\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010)\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcoil3/request/AndroidRequestService;", "Lcoil3/request/RequestService;", "imageLoader", "Lcoil3/ImageLoader;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/util/SystemCallbacks;Lcoil3/util/Logger;)V", "hardwareBitmapService", "Lcoil3/util/HardwareBitmapService;", "requestDelegate", "Lcoil3/request/RequestDelegate;", "request", "Lcoil3/request/ImageRequest;", "job", "Lkotlinx/coroutines/Job;", "findLifecycle", "", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil3/size/SizeResolver;", "options", "Lcoil3/request/Options;", "size", "Lcoil3/size/Size;", "resolveScale", "Lcoil3/size/Scale;", "resolvePrecision", "Lcoil3/size/Precision;", "resolveExtras", "Lcoil3/Extras;", "updateOptionsOnWorkerThread", "isCacheValueValidForHardware", "cacheValue", "Lcoil3/memory/MemoryCache$Value;", "isConfigValidForHardware", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isBitmapConfigValidMainThread", "isBitmapConfigValidWorkerThread", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RequestService.android.kt */
public final class AndroidRequestService implements RequestService {
    private final HardwareBitmapService hardwareBitmapService;
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final SystemCallbacks systemCallbacks;

    public AndroidRequestService(ImageLoader imageLoader2, SystemCallbacks systemCallbacks2, Logger logger2) {
        this.imageLoader = imageLoader2;
        this.systemCallbacks = systemCallbacks2;
        this.logger = logger2;
        this.hardwareBitmapService = HardwareBitmapsKt.HardwareBitmapService(logger2);
    }

    public RequestDelegate requestDelegate(ImageRequest imageRequest, Job job, boolean z) {
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            Lifecycle lifecycle = ImageRequests_androidKt.getLifecycle(imageRequest);
            if (lifecycle == null) {
                lifecycle = findLifecycle(imageRequest);
            }
            return new ViewTargetRequestDelegate(this.imageLoader, imageRequest, (ViewTarget) target, lifecycle, job);
        }
        ImageRequest imageRequest2 = imageRequest;
        Job job2 = job;
        Lifecycle lifecycle2 = ImageRequests_androidKt.getLifecycle(imageRequest2);
        if (lifecycle2 == null) {
            lifecycle2 = z ? findLifecycle(imageRequest2) : null;
        }
        if (lifecycle2 != null) {
            return new LifecycleRequestDelegate(lifecycle2, job2);
        }
        return BaseRequestDelegate.m7532boximpl(BaseRequestDelegate.m7533constructorimpl(job2));
    }

    private final Lifecycle findLifecycle(ImageRequest imageRequest) {
        Target target = imageRequest.getTarget();
        return ContextsKt.getLifecycle(target instanceof ViewTarget ? ((ViewTarget) target).getView().getContext() : imageRequest.getContext());
    }

    public SizeResolver sizeResolver(ImageRequest imageRequest) {
        ImageView.ScaleType scaleType;
        if (imageRequest.getDefined().getSizeResolver() != null) {
            return imageRequest.getDefined().getSizeResolver();
        }
        Target target = imageRequest.getTarget();
        if (!(target instanceof ViewTarget)) {
            return SizeResolver.ORIGINAL;
        }
        View view = ((ViewTarget) target).getView();
        if (!(view instanceof ImageView) || ((scaleType = ((ImageView) view).getScaleType()) != ImageView.ScaleType.CENTER && scaleType != ImageView.ScaleType.MATRIX)) {
            return ViewSizeResolverKt.ViewSizeResolver$default(view, false, 2, (Object) null);
        }
        return SizeResolver.ORIGINAL;
    }

    public Options options(ImageRequest imageRequest, SizeResolver sizeResolver, Size size) {
        return new Options(imageRequest.getContext(), size, resolveScale(imageRequest, size), resolvePrecision(imageRequest, sizeResolver), imageRequest.getDiskCacheKey(), imageRequest.getFileSystem(), imageRequest.getMemoryCachePolicy(), imageRequest.getDiskCachePolicy(), imageRequest.getNetworkCachePolicy(), resolveExtras(imageRequest, size));
    }

    private final Scale resolveScale(ImageRequest imageRequest, Size size) {
        if (Intrinsics.areEqual((Object) size.getWidth(), (Object) Dimension.Undefined.INSTANCE) || Intrinsics.areEqual((Object) size.getHeight(), (Object) Dimension.Undefined.INSTANCE)) {
            return Scale.FIT;
        }
        return imageRequest.getScale();
    }

    private final Precision resolvePrecision(ImageRequest imageRequest, SizeResolver sizeResolver) {
        if (imageRequest.getDefined().getPrecision() != null) {
            return imageRequest.getDefined().getPrecision();
        }
        if (imageRequest.getDefined().getSizeResolver() == null && Intrinsics.areEqual((Object) sizeResolver, (Object) SizeResolver.ORIGINAL)) {
            return Precision.INEXACT;
        }
        if (!(imageRequest.getTarget() instanceof ViewTarget) || !(sizeResolver instanceof ViewSizeResolver) || !(((ViewTarget) imageRequest.getTarget()).getView() instanceof ImageView) || ((ViewTarget) imageRequest.getTarget()).getView() != ((ViewSizeResolver) sizeResolver).getView()) {
            return Precision.EXACT;
        }
        return Precision.INEXACT;
    }

    private final Extras resolveExtras(ImageRequest imageRequest, Size size) {
        Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(imageRequest);
        boolean allowRgb565 = ImageRequests_androidKt.getAllowRgb565(imageRequest);
        if (!isBitmapConfigValidMainThread(imageRequest, size)) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        boolean z = allowRgb565 && ImageRequests_androidKt.getTransformations(imageRequest).isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8;
        Extras.Builder builder = new Extras.Builder((Map<Extras.Key<?>, ? extends Object>) MapsKt.plus(imageRequest.getDefaults().getExtras().asMap(), imageRequest.getExtras().asMap()));
        if (bitmapConfig != ImageRequests_androidKt.getBitmapConfig(imageRequest)) {
            builder = builder.set(ImageRequests_androidKt.getBitmapConfig(Extras.Key.Companion), bitmapConfig);
        }
        if (z != ImageRequests_androidKt.getAllowRgb565(imageRequest)) {
            builder = builder.set(ImageRequests_androidKt.getAllowRgb565(Extras.Key.Companion), Boolean.valueOf(z));
        }
        return builder.build();
    }

    public Options updateOptionsOnWorkerThread(Options options) {
        boolean z;
        Extras extras = options.getExtras();
        if (!isBitmapConfigValidWorkerThread(options)) {
            extras = extras.newBuilder().set(ImageRequests_androidKt.getBitmapConfig(Extras.Key.Companion), Bitmap.Config.ARGB_8888).build();
            z = true;
        } else {
            z = false;
        }
        return z ? Options.copy$default(options, (Context) null, (Size) null, (Scale) null, (Precision) null, (String) null, (FileSystem) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, extras, FrameMetricsAggregator.EVERY_DURATION, (Object) null) : options;
    }

    public boolean isCacheValueValidForHardware(ImageRequest imageRequest, MemoryCache.Value value) {
        Image image = value.getImage();
        BitmapImage bitmapImage = image instanceof BitmapImage ? (BitmapImage) image : null;
        if (bitmapImage == null) {
            return true;
        }
        return isConfigValidForHardware(imageRequest, BitmapsKt.getSafeConfig(bitmapImage.getBitmap()));
    }

    private final boolean isConfigValidForHardware(ImageRequest imageRequest, Bitmap.Config config) {
        if (!BitmapsKt.isHardware(config)) {
            return true;
        }
        if (!ImageRequests_androidKt.getAllowHardware(imageRequest)) {
            return false;
        }
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            View view = ((ViewTarget) target).getView();
            if (!view.isAttachedToWindow() || view.isHardwareAccelerated()) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean isBitmapConfigValidMainThread(ImageRequest imageRequest, Size size) {
        return (ImageRequests_androidKt.getTransformations(imageRequest).isEmpty() || ArraysKt.contains((T[]) Utils_androidKt.getVALID_TRANSFORMATION_CONFIGS(), ImageRequests_androidKt.getBitmapConfig(imageRequest))) && (!BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(imageRequest)) || (isConfigValidForHardware(imageRequest, ImageRequests_androidKt.getBitmapConfig(imageRequest)) && this.hardwareBitmapService.allowHardwareMainThread(size)));
    }

    public final boolean isBitmapConfigValidWorkerThread(Options options) {
        return !BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(options)) || this.hardwareBitmapService.allowHardwareWorkerThread();
    }
}
