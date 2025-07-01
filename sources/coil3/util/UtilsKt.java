package coil3.util;

import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.Image;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.intercept.Interceptor;
import coil3.intercept.RealInterceptorChain;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.NullRequestDataException;
import coil3.size.SizeResolver;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\u00060\u0007j\u0002`\bH\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\u00060\tj\u0002`\nH\u0000\u001a*\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\u0014H\u0000\u001a\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000\u001a\f\u0010*\u001a\u00020\u001f*\u00020+H\u0000\u001a\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0000\u001a\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u000204H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u001e\u001a\u00020\u001f*\u00020 8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010!\"\u0018\u0010\"\u001a\u00020#*\u00020 8@X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u0018\u0010&\u001a\u00020'*\u00020 8@X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)\"\u000e\u0010,\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"emoji", "", "Lcoil3/decode/DataSource;", "getEmoji", "(Lcoil3/decode/DataSource;)Ljava/lang/String;", "closeQuietly", "", "Ljava/io/Closeable;", "Lokio/Closeable;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "EMPTY_IMAGE_FACTORY", "Lkotlin/Function1;", "Lcoil3/request/ImageRequest;", "Lcoil3/Image;", "getEMPTY_IMAGE_FACTORY", "()Lkotlin/jvm/functions/Function1;", "addFirst", "Lcoil3/ComponentRegistry$Builder;", "pair", "Lkotlin/Pair;", "Lcoil3/fetch/Fetcher$Factory;", "Lkotlin/reflect/KClass;", "factory", "Lcoil3/decode/Decoder$Factory;", "MIME_TYPE_JPEG", "MIME_TYPE_WEBP", "MIME_TYPE_HEIC", "MIME_TYPE_HEIF", "MIME_TYPE_XML", "isPlaceholderCached", "", "Lcoil3/intercept/Interceptor$Chain;", "(Lcoil3/intercept/Interceptor$Chain;)Z", "eventListener", "Lcoil3/EventListener;", "getEventListener", "(Lcoil3/intercept/Interceptor$Chain;)Lcoil3/EventListener;", "sizeResolver", "Lcoil3/size/SizeResolver;", "getSizeResolver", "(Lcoil3/intercept/Interceptor$Chain;)Lcoil3/size/SizeResolver;", "isMinOrMax", "", "SCHEME_FILE", "isFileUri", "uri", "Lcoil3/Uri;", "ErrorResult", "Lcoil3/request/ErrorResult;", "request", "throwable", "", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: utils.kt */
public final class UtilsKt {
    private static final Function1<ImageRequest, Image> EMPTY_IMAGE_FACTORY = UtilsKt$EMPTY_IMAGE_FACTORY$1.INSTANCE;
    public static final String MIME_TYPE_HEIC = "image/heic";
    public static final String MIME_TYPE_HEIF = "image/heif";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_WEBP = "image/webp";
    public static final String MIME_TYPE_XML = "text/xml";
    public static final String SCHEME_FILE = "file";

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* compiled from: utils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                coil3.decode.DataSource[] r0 = coil3.decode.DataSource.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                coil3.decode.DataSource r1 = coil3.decode.DataSource.MEMORY_CACHE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                coil3.decode.DataSource r1 = coil3.decode.DataSource.MEMORY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                coil3.decode.DataSource r1 = coil3.decode.DataSource.DISK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                coil3.decode.DataSource r1 = coil3.decode.DataSource.NETWORK     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.util.UtilsKt.WhenMappings.<clinit>():void");
        }
    }

    public static final boolean isMinOrMax(int i) {
        return i == Integer.MIN_VALUE || i == Integer.MAX_VALUE;
    }

    public static final String getEmoji(DataSource dataSource) {
        int i = WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()];
        if (i == 1 || i == 2) {
            return "🧠";
        }
        if (i == 3) {
            return "💾";
        }
        if (i == 4) {
            return "☁️";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final Function1<ImageRequest, Image> getEMPTY_IMAGE_FACTORY() {
        return EMPTY_IMAGE_FACTORY;
    }

    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder builder, Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair) {
        if (pair != null) {
            builder.getLazyFetcherFactories$coil_core_release().add(0, new UtilsKt$$ExternalSyntheticLambda0(pair));
        }
        return builder;
    }

    /* access modifiers changed from: private */
    public static final List addFirst$lambda$1$lambda$0(Pair pair) {
        return CollectionsKt.listOf(pair);
    }

    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder builder, Decoder.Factory factory) {
        if (factory != null) {
            builder.getLazyDecoderFactories$coil_core_release().add(0, new UtilsKt$$ExternalSyntheticLambda1(factory));
        }
        return builder;
    }

    /* access modifiers changed from: private */
    public static final List addFirst$lambda$3$lambda$2(Decoder.Factory factory) {
        return CollectionsKt.listOf(factory);
    }

    public static final boolean isPlaceholderCached(Interceptor.Chain chain) {
        return (chain instanceof RealInterceptorChain) && ((RealInterceptorChain) chain).isPlaceholderCached();
    }

    public static final EventListener getEventListener(Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getEventListener() : EventListener.NONE;
    }

    public static final SizeResolver getSizeResolver(Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getSizeResolver() : chain.getRequest().getSizeResolver();
    }

    public static final boolean isFileUri(Uri uri) {
        return (uri.getScheme() == null || Intrinsics.areEqual((Object) uri.getScheme(), (Object) SCHEME_FILE)) && uri.getPath() != null && !Utils_androidKt.isAssetUri(uri);
    }

    public static final ErrorResult ErrorResult(ImageRequest imageRequest, Throwable th) {
        Image image;
        if (th instanceof NullRequestDataException) {
            image = imageRequest.fallback();
            if (image == null) {
                image = imageRequest.error();
            }
        } else {
            image = imageRequest.error();
        }
        return new ErrorResult(image, imageRequest, th);
    }
}
