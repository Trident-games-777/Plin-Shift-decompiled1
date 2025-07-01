package coil3.fetch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.decode.ResourceMetadata;
import coil3.fetch.Fetcher;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.ContextsKt;
import coil3.util.DrawableUtils;
import coil3.util.MimeTypeMap;
import coil3.util.UtilsKt;
import coil3.util.Utils_androidKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Okio;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcoil3/fetch/ResourceUriFetcher;", "Lcoil3/fetch/Fetcher;", "data", "Lcoil3/Uri;", "options", "Lcoil3/request/Options;", "<init>", "(Lcoil3/Uri;Lcoil3/request/Options;)V", "fetch", "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "throwInvalidUriException", "", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ResourceUriFetcher.kt */
public final class ResourceUriFetcher implements Fetcher {
    private final Uri data;
    private final Options options;

    public ResourceUriFetcher(Uri uri, Options options2) {
        this.data = uri;
        this.options = options2;
    }

    public Object fetch(Continuation<? super FetchResult> continuation) {
        Integer intOrNull;
        Resources resources;
        Drawable drawable;
        String authority = this.data.getAuthority();
        if (authority != null) {
            if (StringsKt.isBlank(authority)) {
                authority = null;
            }
            if (authority != null) {
                String str = (String) CollectionsKt.lastOrNull(UriKt.getPathSegments(this.data));
                if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                    throwInvalidUriException(this.data);
                    throw new KotlinNothingValueException();
                }
                int intValue = intOrNull.intValue();
                Context context = this.options.getContext();
                if (Intrinsics.areEqual((Object) authority, (Object) context.getPackageName())) {
                    resources = context.getResources();
                } else {
                    resources = context.getPackageManager().getResourcesForApplication(authority);
                }
                TypedValue typedValue = new TypedValue();
                boolean z = true;
                resources.getValue(intValue, typedValue, true);
                CharSequence charSequence = typedValue.string;
                String mimeTypeFromUrl = MimeTypeMap.INSTANCE.getMimeTypeFromUrl(charSequence.subSequence(StringsKt.lastIndexOf$default(charSequence, '/', 0, false, 6, (Object) null), charSequence.length()).toString());
                if (Intrinsics.areEqual((Object) mimeTypeFromUrl, (Object) UtilsKt.MIME_TYPE_XML)) {
                    if (Intrinsics.areEqual((Object) authority, (Object) context.getPackageName())) {
                        drawable = ContextsKt.getDrawableCompat(context, intValue);
                    } else {
                        drawable = ContextsKt.getXmlDrawableCompat(context, resources, intValue);
                    }
                    Drawable drawable2 = drawable;
                    boolean isVector = Utils_androidKt.isVector(drawable2);
                    if (isVector) {
                        DrawableUtils drawableUtils = DrawableUtils.INSTANCE;
                        Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(this.options);
                        Size size = this.options.getSize();
                        Scale scale = this.options.getScale();
                        if (this.options.getPrecision() != Precision.INEXACT) {
                            z = false;
                        }
                        drawable2 = new BitmapDrawable(context.getResources(), drawableUtils.convertToBitmap(drawable2, bitmapConfig, size, scale, z));
                    }
                    return new ImageFetchResult(Image_androidKt.asImage(drawable2), isVector, DataSource.DISK);
                }
                TypedValue typedValue2 = new TypedValue();
                return new SourceFetchResult(ImageSourceKt.ImageSource(Okio.buffer(Okio.source(resources.openRawResource(intValue, typedValue2))), this.options.getFileSystem(), new ResourceMetadata(authority, intValue, typedValue2.density)), mimeTypeFromUrl, DataSource.DISK);
            }
        }
        throwInvalidUriException(this.data);
        throw new KotlinNothingValueException();
    }

    private final Void throwInvalidUriException(Uri uri) {
        throw new IllegalStateException("Invalid android.resource URI: " + uri);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcoil3/fetch/ResourceUriFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "<init>", "()V", "create", "Lcoil3/fetch/Fetcher;", "data", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ResourceUriFetcher.kt */
    public static final class Factory implements Fetcher.Factory<Uri> {
        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (!isApplicable(uri)) {
                return null;
            }
            return new ResourceUriFetcher(uri, options);
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.areEqual((Object) uri.getScheme(), (Object) "android.resource");
        }
    }
}
