package coil3.request;

import android.content.Context;
import coil3.Extras;
import coil3.Image;
import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.memory.MemoryCache;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.size.SizeResolver;
import coil3.size.SizeResolverKt;
import coil3.target.Target;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.UtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import okio.FileSystem;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004hijkBµ\u0002\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u001c\u0010\u0011\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u0012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u0012\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u0012\u0006\u00100\u001a\u000201¢\u0006\u0004\b2\u00103J\b\u0010b\u001a\u0004\u0018\u00010#J\b\u0010c\u001a\u0004\u0018\u00010#J\b\u0010d\u001a\u0004\u0018\u00010#J\u001b\u0010e\u001a\u00020f2\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0007¢\u0006\u0002\u0010gR\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010>R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR'\u0010\u0011\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010IR\u0011\u0010\u001a\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bK\u0010IR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u001d\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bN\u0010MR\u0011\u0010\u001e\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bO\u0010MR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u001f\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001f\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\bT\u0010SR\u001f\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\bU\u0010SR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b`\u0010a¨\u0006l"}, d2 = {"Lcoil3/request/ImageRequest;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "data", "target", "Lcoil3/target/Target;", "listener", "Lcoil3/request/ImageRequest$Listener;", "memoryCacheKey", "", "memoryCacheKeyExtras", "", "diskCacheKey", "fileSystem", "Lokio/FileSystem;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil3/fetch/Fetcher$Factory;", "Lkotlin/reflect/KClass;", "decoderFactory", "Lcoil3/decode/Decoder$Factory;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderMemoryCacheKey", "Lcoil3/memory/MemoryCache$Key;", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "extras", "Lcoil3/Extras;", "defined", "Lcoil3/request/ImageRequest$Defined;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "<init>", "(Landroid/content/Context;Ljava/lang/Object;Lcoil3/target/Target;Lcoil3/request/ImageRequest$Listener;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lokio/FileSystem;Lkotlin/Pair;Lcoil3/decode/Decoder$Factory;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/memory/MemoryCache$Key;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcoil3/size/SizeResolver;Lcoil3/size/Scale;Lcoil3/size/Precision;Lcoil3/Extras;Lcoil3/request/ImageRequest$Defined;Lcoil3/request/ImageRequest$Defaults;)V", "getContext", "()Landroid/content/Context;", "Landroid/content/Context;", "getData", "()Ljava/lang/Object;", "getTarget", "()Lcoil3/target/Target;", "getListener", "()Lcoil3/request/ImageRequest$Listener;", "getMemoryCacheKey", "()Ljava/lang/String;", "getMemoryCacheKeyExtras", "()Ljava/util/Map;", "getDiskCacheKey", "getFileSystem", "()Lokio/FileSystem;", "getFetcherFactory", "()Lkotlin/Pair;", "getDecoderFactory", "()Lcoil3/decode/Decoder$Factory;", "getInterceptorCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getFetcherCoroutineContext", "getDecoderCoroutineContext", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getPlaceholderMemoryCacheKey", "()Lcoil3/memory/MemoryCache$Key;", "getPlaceholderFactory", "()Lkotlin/jvm/functions/Function1;", "getErrorFactory", "getFallbackFactory", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "getExtras", "()Lcoil3/Extras;", "getDefined", "()Lcoil3/request/ImageRequest$Defined;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "placeholder", "error", "fallback", "newBuilder", "Lcoil3/request/ImageRequest$Builder;", "(Landroid/content/Context;)Lcoil3/request/ImageRequest$Builder;", "Listener", "Defined", "Defaults", "Builder", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageRequest.kt */
public final class ImageRequest {
    private final Context context;
    private final Object data;
    private final CoroutineContext decoderCoroutineContext;
    private final Decoder.Factory decoderFactory;
    private final Defaults defaults;
    private final Defined defined;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Function1<ImageRequest, Image> errorFactory;
    private final Extras extras;
    private final Function1<ImageRequest, Image> fallbackFactory;
    private final CoroutineContext fetcherCoroutineContext;
    private final Pair<Fetcher.Factory<?>, KClass<?>> fetcherFactory;
    private final FileSystem fileSystem;
    private final CoroutineContext interceptorCoroutineContext;
    private final Listener listener;
    private final String memoryCacheKey;
    private final Map<String, String> memoryCacheKeyExtras;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Function1<ImageRequest, Image> placeholderFactory;
    private final MemoryCache.Key placeholderMemoryCacheKey;
    private final Precision precision;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Target target;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000bH\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcoil3/request/ImageRequest$Listener;", "", "onStart", "", "request", "Lcoil3/request/ImageRequest;", "onCancel", "onError", "result", "Lcoil3/request/ErrorResult;", "onSuccess", "Lcoil3/request/SuccessResult;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ImageRequest.kt */
    public interface Listener {
        void onCancel(ImageRequest imageRequest) {
        }

        void onError(ImageRequest imageRequest, ErrorResult errorResult) {
        }

        void onStart(ImageRequest imageRequest) {
        }

        void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
        }
    }

    public /* synthetic */ ImageRequest(Context context2, Object obj, Target target2, Listener listener2, String str, Map map, String str2, FileSystem fileSystem2, Pair pair, Decoder.Factory factory, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, MemoryCache.Key key, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver2, Scale scale2, Precision precision2, Extras extras2, Defined defined2, Defaults defaults2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, obj, target2, listener2, str, map, str2, fileSystem2, pair, factory, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, key, function1, function12, function13, sizeResolver2, scale2, precision2, extras2, defined2, defaults2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        return Intrinsics.areEqual((Object) this.context, (Object) imageRequest.context) && Intrinsics.areEqual(this.data, imageRequest.data) && Intrinsics.areEqual((Object) this.target, (Object) imageRequest.target) && Intrinsics.areEqual((Object) this.listener, (Object) imageRequest.listener) && Intrinsics.areEqual((Object) this.memoryCacheKey, (Object) imageRequest.memoryCacheKey) && Intrinsics.areEqual((Object) this.memoryCacheKeyExtras, (Object) imageRequest.memoryCacheKeyExtras) && Intrinsics.areEqual((Object) this.diskCacheKey, (Object) imageRequest.diskCacheKey) && Intrinsics.areEqual((Object) this.fileSystem, (Object) imageRequest.fileSystem) && Intrinsics.areEqual((Object) this.fetcherFactory, (Object) imageRequest.fetcherFactory) && Intrinsics.areEqual((Object) this.decoderFactory, (Object) imageRequest.decoderFactory) && Intrinsics.areEqual((Object) this.interceptorCoroutineContext, (Object) imageRequest.interceptorCoroutineContext) && Intrinsics.areEqual((Object) this.fetcherCoroutineContext, (Object) imageRequest.fetcherCoroutineContext) && Intrinsics.areEqual((Object) this.decoderCoroutineContext, (Object) imageRequest.decoderCoroutineContext) && this.memoryCachePolicy == imageRequest.memoryCachePolicy && this.diskCachePolicy == imageRequest.diskCachePolicy && this.networkCachePolicy == imageRequest.networkCachePolicy && Intrinsics.areEqual((Object) this.placeholderMemoryCacheKey, (Object) imageRequest.placeholderMemoryCacheKey) && Intrinsics.areEqual((Object) this.placeholderFactory, (Object) imageRequest.placeholderFactory) && Intrinsics.areEqual((Object) this.errorFactory, (Object) imageRequest.errorFactory) && Intrinsics.areEqual((Object) this.fallbackFactory, (Object) imageRequest.fallbackFactory) && Intrinsics.areEqual((Object) this.sizeResolver, (Object) imageRequest.sizeResolver) && this.scale == imageRequest.scale && this.precision == imageRequest.precision && Intrinsics.areEqual((Object) this.extras, (Object) imageRequest.extras) && Intrinsics.areEqual((Object) this.defined, (Object) imageRequest.defined) && Intrinsics.areEqual((Object) this.defaults, (Object) imageRequest.defaults);
    }

    public int hashCode() {
        int hashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target target2 = this.target;
        int i = 0;
        int hashCode2 = (hashCode + (target2 == null ? 0 : target2.hashCode())) * 31;
        Listener listener2 = this.listener;
        int hashCode3 = (hashCode2 + (listener2 == null ? 0 : listener2.hashCode())) * 31;
        String str = this.memoryCacheKey;
        int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.memoryCacheKeyExtras.hashCode()) * 31;
        String str2 = this.diskCacheKey;
        int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.fileSystem.hashCode()) * 31;
        Pair<Fetcher.Factory<?>, KClass<?>> pair = this.fetcherFactory;
        int hashCode6 = (hashCode5 + (pair == null ? 0 : pair.hashCode())) * 31;
        Decoder.Factory factory = this.decoderFactory;
        int hashCode7 = (((((((((((((hashCode6 + (factory == null ? 0 : factory.hashCode())) * 31) + this.interceptorCoroutineContext.hashCode()) * 31) + this.fetcherCoroutineContext.hashCode()) * 31) + this.decoderCoroutineContext.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31;
        MemoryCache.Key key = this.placeholderMemoryCacheKey;
        if (key != null) {
            i = key.hashCode();
        }
        return ((((((((((((((((((hashCode7 + i) * 31) + this.placeholderFactory.hashCode()) * 31) + this.errorFactory.hashCode()) * 31) + this.fallbackFactory.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.extras.hashCode()) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    public final Builder newBuilder() {
        return newBuilder$default(this, (Context) null, 1, (Object) null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImageRequest(context=");
        sb.append(this.context).append(", data=").append(this.data).append(", target=").append(this.target).append(", listener=").append(this.listener).append(", memoryCacheKey=").append(this.memoryCacheKey).append(", memoryCacheKeyExtras=").append(this.memoryCacheKeyExtras).append(", diskCacheKey=").append(this.diskCacheKey).append(", fileSystem=").append(this.fileSystem).append(", fetcherFactory=").append(this.fetcherFactory).append(", decoderFactory=").append(this.decoderFactory).append(", interceptorCoroutineContext=").append(this.interceptorCoroutineContext).append(", fetcherCoroutineContext=");
        sb.append(this.fetcherCoroutineContext).append(", decoderCoroutineContext=").append(this.decoderCoroutineContext).append(", memoryCachePolicy=").append(this.memoryCachePolicy).append(", diskCachePolicy=").append(this.diskCachePolicy).append(", networkCachePolicy=").append(this.networkCachePolicy).append(", placeholderMemoryCacheKey=").append(this.placeholderMemoryCacheKey).append(", placeholderFactory=").append(this.placeholderFactory).append(", errorFactory=").append(this.errorFactory).append(", fallbackFactory=").append(this.fallbackFactory).append(", sizeResolver=").append(this.sizeResolver).append(", scale=").append(this.scale).append(", precision=").append(this.precision);
        sb.append(", extras=").append(this.extras).append(", defined=").append(this.defined).append(", defaults=").append(this.defaults).append(')');
        return sb.toString();
    }

    private ImageRequest(Context context2, Object obj, Target target2, Listener listener2, String str, Map<String, String> map, String str2, FileSystem fileSystem2, Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair, Decoder.Factory factory, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, MemoryCache.Key key, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver2, Scale scale2, Precision precision2, Extras extras2, Defined defined2, Defaults defaults2) {
        this.context = context2;
        this.data = obj;
        this.target = target2;
        this.listener = listener2;
        this.memoryCacheKey = str;
        this.memoryCacheKeyExtras = map;
        this.diskCacheKey = str2;
        this.fileSystem = fileSystem2;
        this.fetcherFactory = pair;
        this.decoderFactory = factory;
        this.interceptorCoroutineContext = coroutineContext;
        this.fetcherCoroutineContext = coroutineContext2;
        this.decoderCoroutineContext = coroutineContext3;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.placeholderMemoryCacheKey = key;
        this.placeholderFactory = function1;
        this.errorFactory = function12;
        this.fallbackFactory = function13;
        this.sizeResolver = sizeResolver2;
        this.scale = scale2;
        this.precision = precision2;
        this.extras = extras2;
        this.defined = defined2;
        this.defaults = defaults2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getData() {
        return this.data;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final String getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final Map<String, String> getMemoryCacheKeyExtras() {
        return this.memoryCacheKeyExtras;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    public final Pair<Fetcher.Factory<?>, KClass<?>> getFetcherFactory() {
        return this.fetcherFactory;
    }

    public final Decoder.Factory getDecoderFactory() {
        return this.decoderFactory;
    }

    public final CoroutineContext getInterceptorCoroutineContext() {
        return this.interceptorCoroutineContext;
    }

    public final CoroutineContext getFetcherCoroutineContext() {
        return this.fetcherCoroutineContext;
    }

    public final CoroutineContext getDecoderCoroutineContext() {
        return this.decoderCoroutineContext;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    public final Function1<ImageRequest, Image> getPlaceholderFactory() {
        return this.placeholderFactory;
    }

    public final Function1<ImageRequest, Image> getErrorFactory() {
        return this.errorFactory;
    }

    public final Function1<ImageRequest, Image> getFallbackFactory() {
        return this.fallbackFactory;
    }

    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final Defined getDefined() {
        return this.defined;
    }

    public final Defaults getDefaults() {
        return this.defaults;
    }

    public final Image placeholder() {
        Image invoke = this.placeholderFactory.invoke(this);
        return invoke == null ? this.defaults.getPlaceholderFactory().invoke(this) : invoke;
    }

    public final Image error() {
        Image invoke = this.errorFactory.invoke(this);
        return invoke == null ? this.defaults.getErrorFactory().invoke(this) : invoke;
    }

    public final Image fallback() {
        Image invoke = this.fallbackFactory.invoke(this);
        return invoke == null ? this.defaults.getFallbackFactory().invoke(this) : invoke;
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context2, int i, Object obj) {
        if ((i & 1) != 0) {
            context2 = imageRequest.context;
        }
        return imageRequest.newBuilder(context2);
    }

    public final Builder newBuilder(Context context2) {
        return new Builder(this, context2);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B³\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019JÌ\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcoil3/request/ImageRequest$Defined;", "", "fileSystem", "Lokio/FileSystem;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/request/ImageRequest;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "<init>", "(Lokio/FileSystem;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcoil3/size/SizeResolver;Lcoil3/size/Scale;Lcoil3/size/Precision;)V", "getFileSystem", "()Lokio/FileSystem;", "getInterceptorCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getFetcherCoroutineContext", "getDecoderCoroutineContext", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getPlaceholderFactory", "()Lkotlin/jvm/functions/Function1;", "getErrorFactory", "getFallbackFactory", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "copy", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ImageRequest.kt */
    public static final class Defined {
        private final CoroutineContext decoderCoroutineContext;
        private final CachePolicy diskCachePolicy;
        private final Function1<ImageRequest, Image> errorFactory;
        private final Function1<ImageRequest, Image> fallbackFactory;
        private final CoroutineContext fetcherCoroutineContext;
        private final FileSystem fileSystem;
        private final CoroutineContext interceptorCoroutineContext;
        private final CachePolicy memoryCachePolicy;
        private final CachePolicy networkCachePolicy;
        private final Function1<ImageRequest, Image> placeholderFactory;
        private final Precision precision;
        private final Scale scale;
        private final SizeResolver sizeResolver;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defined)) {
                return false;
            }
            Defined defined = (Defined) obj;
            return Intrinsics.areEqual((Object) this.fileSystem, (Object) defined.fileSystem) && Intrinsics.areEqual((Object) this.interceptorCoroutineContext, (Object) defined.interceptorCoroutineContext) && Intrinsics.areEqual((Object) this.fetcherCoroutineContext, (Object) defined.fetcherCoroutineContext) && Intrinsics.areEqual((Object) this.decoderCoroutineContext, (Object) defined.decoderCoroutineContext) && this.memoryCachePolicy == defined.memoryCachePolicy && this.diskCachePolicy == defined.diskCachePolicy && this.networkCachePolicy == defined.networkCachePolicy && Intrinsics.areEqual((Object) this.placeholderFactory, (Object) defined.placeholderFactory) && Intrinsics.areEqual((Object) this.errorFactory, (Object) defined.errorFactory) && Intrinsics.areEqual((Object) this.fallbackFactory, (Object) defined.fallbackFactory) && Intrinsics.areEqual((Object) this.sizeResolver, (Object) defined.sizeResolver) && this.scale == defined.scale && this.precision == defined.precision;
        }

        public int hashCode() {
            FileSystem fileSystem2 = this.fileSystem;
            int i = 0;
            int hashCode = (fileSystem2 == null ? 0 : fileSystem2.hashCode()) * 31;
            CoroutineContext coroutineContext = this.interceptorCoroutineContext;
            int hashCode2 = (hashCode + (coroutineContext == null ? 0 : coroutineContext.hashCode())) * 31;
            CoroutineContext coroutineContext2 = this.fetcherCoroutineContext;
            int hashCode3 = (hashCode2 + (coroutineContext2 == null ? 0 : coroutineContext2.hashCode())) * 31;
            CoroutineContext coroutineContext3 = this.decoderCoroutineContext;
            int hashCode4 = (hashCode3 + (coroutineContext3 == null ? 0 : coroutineContext3.hashCode())) * 31;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            int hashCode5 = (hashCode4 + (cachePolicy == null ? 0 : cachePolicy.hashCode())) * 31;
            CachePolicy cachePolicy2 = this.diskCachePolicy;
            int hashCode6 = (hashCode5 + (cachePolicy2 == null ? 0 : cachePolicy2.hashCode())) * 31;
            CachePolicy cachePolicy3 = this.networkCachePolicy;
            int hashCode7 = (hashCode6 + (cachePolicy3 == null ? 0 : cachePolicy3.hashCode())) * 31;
            Function1<ImageRequest, Image> function1 = this.placeholderFactory;
            int hashCode8 = (hashCode7 + (function1 == null ? 0 : function1.hashCode())) * 31;
            Function1<ImageRequest, Image> function12 = this.errorFactory;
            int hashCode9 = (hashCode8 + (function12 == null ? 0 : function12.hashCode())) * 31;
            Function1<ImageRequest, Image> function13 = this.fallbackFactory;
            int hashCode10 = (hashCode9 + (function13 == null ? 0 : function13.hashCode())) * 31;
            SizeResolver sizeResolver2 = this.sizeResolver;
            int hashCode11 = (hashCode10 + (sizeResolver2 == null ? 0 : sizeResolver2.hashCode())) * 31;
            Scale scale2 = this.scale;
            int hashCode12 = (hashCode11 + (scale2 == null ? 0 : scale2.hashCode())) * 31;
            Precision precision2 = this.precision;
            if (precision2 != null) {
                i = precision2.hashCode();
            }
            return hashCode12 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Defined(fileSystem=");
            sb.append(this.fileSystem).append(", interceptorCoroutineContext=").append(this.interceptorCoroutineContext).append(", fetcherCoroutineContext=").append(this.fetcherCoroutineContext).append(", decoderCoroutineContext=").append(this.decoderCoroutineContext).append(", memoryCachePolicy=").append(this.memoryCachePolicy).append(", diskCachePolicy=").append(this.diskCachePolicy).append(", networkCachePolicy=").append(this.networkCachePolicy).append(", placeholderFactory=").append(this.placeholderFactory).append(", errorFactory=").append(this.errorFactory).append(", fallbackFactory=").append(this.fallbackFactory).append(", sizeResolver=").append(this.sizeResolver).append(", scale=");
            sb.append(this.scale).append(", precision=").append(this.precision).append(')');
            return sb.toString();
        }

        public Defined(FileSystem fileSystem2, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver2, Scale scale2, Precision precision2) {
            this.fileSystem = fileSystem2;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.placeholderFactory = function1;
            this.errorFactory = function12;
            this.fallbackFactory = function13;
            this.sizeResolver = sizeResolver2;
            this.scale = scale2;
            this.precision = precision2;
        }

        public final FileSystem getFileSystem() {
            return this.fileSystem;
        }

        public final CoroutineContext getInterceptorCoroutineContext() {
            return this.interceptorCoroutineContext;
        }

        public final CoroutineContext getFetcherCoroutineContext() {
            return this.fetcherCoroutineContext;
        }

        public final CoroutineContext getDecoderCoroutineContext() {
            return this.decoderCoroutineContext;
        }

        public final CachePolicy getMemoryCachePolicy() {
            return this.memoryCachePolicy;
        }

        public final CachePolicy getDiskCachePolicy() {
            return this.diskCachePolicy;
        }

        public final CachePolicy getNetworkCachePolicy() {
            return this.networkCachePolicy;
        }

        public final Function1<ImageRequest, Image> getPlaceholderFactory() {
            return this.placeholderFactory;
        }

        public final Function1<ImageRequest, Image> getErrorFactory() {
            return this.errorFactory;
        }

        public final Function1<ImageRequest, Image> getFallbackFactory() {
            return this.fallbackFactory;
        }

        public final SizeResolver getSizeResolver() {
            return this.sizeResolver;
        }

        public final Scale getScale() {
            return this.scale;
        }

        public final Precision getPrecision() {
            return this.precision;
        }

        public static /* synthetic */ Defined copy$default(Defined defined, FileSystem fileSystem2, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver2, Scale scale2, Precision precision2, int i, Object obj) {
            Precision precision3;
            int i2 = i;
            if ((i2 & 1) != 0) {
                fileSystem2 = defined.fileSystem;
            }
            CoroutineContext coroutineContext4 = (i2 & 2) != 0 ? defined.interceptorCoroutineContext : coroutineContext;
            CoroutineContext coroutineContext5 = (i2 & 4) != 0 ? defined.fetcherCoroutineContext : coroutineContext2;
            CoroutineContext coroutineContext6 = (i2 & 8) != 0 ? defined.decoderCoroutineContext : coroutineContext3;
            CachePolicy cachePolicy4 = (i2 & 16) != 0 ? defined.memoryCachePolicy : cachePolicy;
            CachePolicy cachePolicy5 = (i2 & 32) != 0 ? defined.diskCachePolicy : cachePolicy2;
            CachePolicy cachePolicy6 = (i2 & 64) != 0 ? defined.networkCachePolicy : cachePolicy3;
            Function1 function14 = (i2 & 128) != 0 ? defined.placeholderFactory : function1;
            Function1 function15 = (i2 & 256) != 0 ? defined.errorFactory : function12;
            Function1 function16 = (i2 & 512) != 0 ? defined.fallbackFactory : function13;
            SizeResolver sizeResolver3 = (i2 & 1024) != 0 ? defined.sizeResolver : sizeResolver2;
            Scale scale3 = (i2 & 2048) != 0 ? defined.scale : scale2;
            if ((i2 & 4096) != 0) {
                precision3 = defined.precision;
            } else {
                precision3 = precision2;
            }
            return defined.copy(fileSystem2, coroutineContext4, coroutineContext5, coroutineContext6, cachePolicy4, cachePolicy5, cachePolicy6, function14, function15, function16, sizeResolver3, scale3, precision3);
        }

        public final Defined copy(FileSystem fileSystem2, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver2, Scale scale2, Precision precision2) {
            return new Defined(fileSystem2, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, function1, function12, function13, sizeResolver2, scale2, precision2);
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 32\u00020\u0001:\u00013B½\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ¨\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u001f\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcoil3/request/ImageRequest$Defaults;", "", "fileSystem", "Lokio/FileSystem;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/request/ImageRequest;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "extras", "Lcoil3/Extras;", "<init>", "(Lokio/FileSystem;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcoil3/size/SizeResolver;Lcoil3/size/Scale;Lcoil3/size/Precision;Lcoil3/Extras;)V", "getFileSystem", "()Lokio/FileSystem;", "getInterceptorCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getFetcherCoroutineContext", "getDecoderCoroutineContext", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getPlaceholderFactory", "()Lkotlin/jvm/functions/Function1;", "getErrorFactory", "getFallbackFactory", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "getExtras", "()Lcoil3/Extras;", "copy", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ImageRequest.kt */
    public static final class Defaults {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final Defaults DEFAULT = new Defaults((FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (SizeResolver) null, (Scale) null, (Precision) null, (Extras) null, 16383, (DefaultConstructorMarker) null);
        private final CoroutineContext decoderCoroutineContext;
        private final CachePolicy diskCachePolicy;
        private final Function1<ImageRequest, Image> errorFactory;
        private final Extras extras;
        private final Function1<ImageRequest, Image> fallbackFactory;
        private final CoroutineContext fetcherCoroutineContext;
        private final FileSystem fileSystem;
        private final CoroutineContext interceptorCoroutineContext;
        private final CachePolicy memoryCachePolicy;
        private final CachePolicy networkCachePolicy;
        private final Function1<ImageRequest, Image> placeholderFactory;
        private final Precision precision;
        private final Scale scale;
        private final SizeResolver sizeResolver;

        public Defaults() {
            this((FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (SizeResolver) null, (Scale) null, (Precision) null, (Extras) null, 16383, (DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defaults)) {
                return false;
            }
            Defaults defaults = (Defaults) obj;
            return Intrinsics.areEqual((Object) this.fileSystem, (Object) defaults.fileSystem) && Intrinsics.areEqual((Object) this.interceptorCoroutineContext, (Object) defaults.interceptorCoroutineContext) && Intrinsics.areEqual((Object) this.fetcherCoroutineContext, (Object) defaults.fetcherCoroutineContext) && Intrinsics.areEqual((Object) this.decoderCoroutineContext, (Object) defaults.decoderCoroutineContext) && this.memoryCachePolicy == defaults.memoryCachePolicy && this.diskCachePolicy == defaults.diskCachePolicy && this.networkCachePolicy == defaults.networkCachePolicy && Intrinsics.areEqual((Object) this.placeholderFactory, (Object) defaults.placeholderFactory) && Intrinsics.areEqual((Object) this.errorFactory, (Object) defaults.errorFactory) && Intrinsics.areEqual((Object) this.fallbackFactory, (Object) defaults.fallbackFactory) && Intrinsics.areEqual((Object) this.sizeResolver, (Object) defaults.sizeResolver) && this.scale == defaults.scale && this.precision == defaults.precision && Intrinsics.areEqual((Object) this.extras, (Object) defaults.extras);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((this.fileSystem.hashCode() * 31) + this.interceptorCoroutineContext.hashCode()) * 31) + this.fetcherCoroutineContext.hashCode()) * 31) + this.decoderCoroutineContext.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.placeholderFactory.hashCode()) * 31) + this.errorFactory.hashCode()) * 31) + this.fallbackFactory.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.extras.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Defaults(fileSystem=");
            sb.append(this.fileSystem).append(", interceptorCoroutineContext=").append(this.interceptorCoroutineContext).append(", fetcherCoroutineContext=").append(this.fetcherCoroutineContext).append(", decoderCoroutineContext=").append(this.decoderCoroutineContext).append(", memoryCachePolicy=").append(this.memoryCachePolicy).append(", diskCachePolicy=").append(this.diskCachePolicy).append(", networkCachePolicy=").append(this.networkCachePolicy).append(", placeholderFactory=").append(this.placeholderFactory).append(", errorFactory=").append(this.errorFactory).append(", fallbackFactory=").append(this.fallbackFactory).append(", sizeResolver=").append(this.sizeResolver).append(", scale=");
            sb.append(this.scale).append(", precision=").append(this.precision).append(", extras=").append(this.extras).append(')');
            return sb.toString();
        }

        public Defaults(FileSystem fileSystem2, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, SizeResolver sizeResolver2, Scale scale2, Precision precision2, Extras extras2) {
            this.fileSystem = fileSystem2;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.placeholderFactory = function1;
            this.errorFactory = function12;
            this.fallbackFactory = function13;
            this.sizeResolver = sizeResolver2;
            this.scale = scale2;
            this.precision = precision2;
            this.extras = extras2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Defaults(okio.FileSystem r14, kotlin.coroutines.CoroutineContext r15, kotlin.coroutines.CoroutineContext r16, kotlin.coroutines.CoroutineContext r17, coil3.request.CachePolicy r18, coil3.request.CachePolicy r19, coil3.request.CachePolicy r20, kotlin.jvm.functions.Function1 r21, kotlin.jvm.functions.Function1 r22, kotlin.jvm.functions.Function1 r23, coil3.size.SizeResolver r24, coil3.size.Scale r25, coil3.size.Precision r26, coil3.Extras r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
            /*
                r13 = this;
                r0 = r28
                r1 = r0 & 1
                if (r1 == 0) goto L_0x000a
                okio.FileSystem r14 = coil3.util.FileSystems_nonJsCommonKt.defaultFileSystem()
            L_0x000a:
                r1 = r0 & 2
                if (r1 == 0) goto L_0x0013
                kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                goto L_0x0014
            L_0x0013:
                r1 = r15
            L_0x0014:
                r2 = r0 & 4
                if (r2 == 0) goto L_0x001f
                kotlinx.coroutines.CoroutineDispatcher r2 = coil3.util.Coroutines_nonJsCommonKt.ioCoroutineDispatcher()
                kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
                goto L_0x0021
            L_0x001f:
                r2 = r16
            L_0x0021:
                r3 = r0 & 8
                if (r3 == 0) goto L_0x002c
                kotlinx.coroutines.CoroutineDispatcher r3 = coil3.util.Coroutines_nonJsCommonKt.ioCoroutineDispatcher()
                kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
                goto L_0x002e
            L_0x002c:
                r3 = r17
            L_0x002e:
                r4 = r0 & 16
                if (r4 == 0) goto L_0x0035
                coil3.request.CachePolicy r4 = coil3.request.CachePolicy.ENABLED
                goto L_0x0037
            L_0x0035:
                r4 = r18
            L_0x0037:
                r5 = r0 & 32
                if (r5 == 0) goto L_0x003e
                coil3.request.CachePolicy r5 = coil3.request.CachePolicy.ENABLED
                goto L_0x0040
            L_0x003e:
                r5 = r19
            L_0x0040:
                r6 = r0 & 64
                if (r6 == 0) goto L_0x0047
                coil3.request.CachePolicy r6 = coil3.request.CachePolicy.ENABLED
                goto L_0x0049
            L_0x0047:
                r6 = r20
            L_0x0049:
                r7 = r0 & 128(0x80, float:1.794E-43)
                if (r7 == 0) goto L_0x0052
                kotlin.jvm.functions.Function1 r7 = coil3.util.UtilsKt.getEMPTY_IMAGE_FACTORY()
                goto L_0x0054
            L_0x0052:
                r7 = r21
            L_0x0054:
                r8 = r0 & 256(0x100, float:3.59E-43)
                if (r8 == 0) goto L_0x005d
                kotlin.jvm.functions.Function1 r8 = coil3.util.UtilsKt.getEMPTY_IMAGE_FACTORY()
                goto L_0x005f
            L_0x005d:
                r8 = r22
            L_0x005f:
                r9 = r0 & 512(0x200, float:7.175E-43)
                if (r9 == 0) goto L_0x0068
                kotlin.jvm.functions.Function1 r9 = coil3.util.UtilsKt.getEMPTY_IMAGE_FACTORY()
                goto L_0x006a
            L_0x0068:
                r9 = r23
            L_0x006a:
                r10 = r0 & 1024(0x400, float:1.435E-42)
                if (r10 == 0) goto L_0x0071
                coil3.size.SizeResolver r10 = coil3.size.SizeResolver.ORIGINAL
                goto L_0x0073
            L_0x0071:
                r10 = r24
            L_0x0073:
                r11 = r0 & 2048(0x800, float:2.87E-42)
                if (r11 == 0) goto L_0x007a
                coil3.size.Scale r11 = coil3.size.Scale.FIT
                goto L_0x007c
            L_0x007a:
                r11 = r25
            L_0x007c:
                r12 = r0 & 4096(0x1000, float:5.74E-42)
                if (r12 == 0) goto L_0x0083
                coil3.size.Precision r12 = coil3.size.Precision.EXACT
                goto L_0x0085
            L_0x0083:
                r12 = r26
            L_0x0085:
                r0 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r0 == 0) goto L_0x008e
                coil3.Extras r0 = coil3.Extras.EMPTY
                r29 = r0
                goto L_0x0090
            L_0x008e:
                r29 = r27
            L_0x0090:
                r15 = r13
                r16 = r14
                r17 = r1
                r18 = r2
                r19 = r3
                r20 = r4
                r21 = r5
                r22 = r6
                r23 = r7
                r24 = r8
                r25 = r9
                r26 = r10
                r27 = r11
                r28 = r12
                r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.request.ImageRequest.Defaults.<init>(okio.FileSystem, kotlin.coroutines.CoroutineContext, kotlin.coroutines.CoroutineContext, kotlin.coroutines.CoroutineContext, coil3.request.CachePolicy, coil3.request.CachePolicy, coil3.request.CachePolicy, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, coil3.size.SizeResolver, coil3.size.Scale, coil3.size.Precision, coil3.Extras, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final FileSystem getFileSystem() {
            return this.fileSystem;
        }

        public final CoroutineContext getInterceptorCoroutineContext() {
            return this.interceptorCoroutineContext;
        }

        public final CoroutineContext getFetcherCoroutineContext() {
            return this.fetcherCoroutineContext;
        }

        public final CoroutineContext getDecoderCoroutineContext() {
            return this.decoderCoroutineContext;
        }

        public final CachePolicy getMemoryCachePolicy() {
            return this.memoryCachePolicy;
        }

        public final CachePolicy getDiskCachePolicy() {
            return this.diskCachePolicy;
        }

        public final CachePolicy getNetworkCachePolicy() {
            return this.networkCachePolicy;
        }

        public final Function1<ImageRequest, Image> getPlaceholderFactory() {
            return this.placeholderFactory;
        }

        public final Function1<ImageRequest, Image> getErrorFactory() {
            return this.errorFactory;
        }

        public final Function1<ImageRequest, Image> getFallbackFactory() {
            return this.fallbackFactory;
        }

        public final SizeResolver getSizeResolver() {
            return this.sizeResolver;
        }

        public final Scale getScale() {
            return this.scale;
        }

        public final Precision getPrecision() {
            return this.precision;
        }

        public final Extras getExtras() {
            return this.extras;
        }

        public static /* synthetic */ Defaults copy$default(Defaults defaults, FileSystem fileSystem2, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1<ImageRequest, Image> function1, Function1<ImageRequest, Image> function12, Function1<ImageRequest, Image> function13, Precision precision2, Extras extras2, int i, Object obj) {
            if ((i & 1) != 0) {
                fileSystem2 = defaults.fileSystem;
            }
            if ((i & 2) != 0) {
                coroutineContext = defaults.interceptorCoroutineContext;
            }
            if ((i & 4) != 0) {
                coroutineContext2 = defaults.fetcherCoroutineContext;
            }
            if ((i & 8) != 0) {
                coroutineContext3 = defaults.decoderCoroutineContext;
            }
            if ((i & 16) != 0) {
                cachePolicy = defaults.memoryCachePolicy;
            }
            if ((i & 32) != 0) {
                cachePolicy2 = defaults.diskCachePolicy;
            }
            if ((i & 64) != 0) {
                cachePolicy3 = defaults.networkCachePolicy;
            }
            if ((i & 128) != 0) {
                function1 = defaults.placeholderFactory;
            }
            if ((i & 256) != 0) {
                function12 = defaults.errorFactory;
            }
            if ((i & 512) != 0) {
                function13 = defaults.fallbackFactory;
            }
            if ((i & 1024) != 0) {
                precision2 = defaults.precision;
            }
            if ((i & 2048) != 0) {
                extras2 = defaults.extras;
            }
            Precision precision3 = precision2;
            Extras extras3 = extras2;
            Function1<ImageRequest, Image> function14 = function12;
            Function1<ImageRequest, Image> function15 = function13;
            CachePolicy cachePolicy4 = cachePolicy3;
            Function1<ImageRequest, Image> function16 = function1;
            CachePolicy cachePolicy5 = cachePolicy;
            CachePolicy cachePolicy6 = cachePolicy2;
            CoroutineContext coroutineContext4 = coroutineContext3;
            CoroutineContext coroutineContext5 = coroutineContext;
            return defaults.copy(fileSystem2, coroutineContext5, coroutineContext2, coroutineContext4, cachePolicy5, cachePolicy6, cachePolicy4, function16, function14, function15, precision3, extras3);
        }

        public final Defaults copy(FileSystem fileSystem2, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1<? super ImageRequest, ? extends Image> function1, Function1<? super ImageRequest, ? extends Image> function12, Function1<? super ImageRequest, ? extends Image> function13, Precision precision2, Extras extras2) {
            return new Defaults(fileSystem2, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy3, function1, function12, function13, (SizeResolver) null, (Scale) null, precision2, extras2, 3072, (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/request/ImageRequest$Defaults$Companion;", "", "<init>", "()V", "DEFAULT", "Lcoil3/request/ImageRequest$Defaults;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: ImageRequest.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001f\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0001J|\u0010\u000e\u001a\u00020\u00002%\b\u0006\u0010>\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020B0/2%\b\u0006\u0010C\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020B0/2#\b\u0006\u0010E\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020B0/H\bJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010-J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130HJ\u0018\u0010I\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u00132\b\u0010J\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJÇ\u0001\u0010\u0010\u001a\u00020\u00002#\b\u0006\u0010>\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020B0/2#\b\u0006\u0010K\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020B0/28\b\u0006\u0010C\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110M¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020B0L28\b\u0006\u0010E\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110N¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020B0LH\bJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020%J\u000e\u0010P\u001a\u00020\u00002\u0006\u0010P\u001a\u00020QJ\u0016\u0010P\u001a\u00020\u00002\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020QJ\u0016\u0010P\u001a\u00020\u00002\u0006\u0010R\u001a\u00020T2\u0006\u0010S\u001a\u00020TJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010P\u001a\u00020UJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010V\u001a\u000204J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020\u00002\u0006\u00107\u001a\u000208J#\u0010\u001e\u001a\u00020\u0000\"\n\b\u0000\u0010W\u0018\u0001*\u00020\u00012\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0 H\bJ,\u0010\u001e\u001a\u00020\u0000\"\b\b\u0000\u0010W*\u00020\u00012\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0 2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0!J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010X\u001a\u00020#J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020)J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020)J\u0010\u0010,\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u0010\u0010,\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010-J\u0010\u0010A\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u000100J\u001c\u0010A\u001a\u00020\u00002\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001000/J\u0010\u0010D\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u000100J\u001c\u0010D\u001a\u00020\u00002\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001000/J\u0010\u0010\\\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u000100J\u001c\u0010\\\u001a\u00020\u00002\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001000/J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010]\u001a\u00020\bR\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006^"}, d2 = {"Lcoil3/request/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "<init>", "(Landroid/content/Context;)V", "request", "Lcoil3/request/ImageRequest;", "(Lcoil3/request/ImageRequest;Landroid/content/Context;)V", "Landroid/content/Context;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "data", "target", "Lcoil3/target/Target;", "listener", "Lcoil3/request/ImageRequest$Listener;", "memoryCacheKey", "", "memoryCacheKeyExtrasAreMutable", "", "lazyMemoryCacheKeyExtras", "memoryCacheKeyExtras", "", "getMemoryCacheKeyExtras", "()Ljava/util/Map;", "diskCacheKey", "fileSystem", "Lokio/FileSystem;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil3/fetch/Fetcher$Factory;", "Lkotlin/reflect/KClass;", "decoderFactory", "Lcoil3/decode/Decoder$Factory;", "interceptorCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "fetcherCoroutineContext", "decoderCoroutineContext", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderMemoryCacheKey", "Lcoil3/memory/MemoryCache$Key;", "placeholderFactory", "Lkotlin/Function1;", "Lcoil3/Image;", "errorFactory", "fallbackFactory", "sizeResolver", "Lcoil3/size/SizeResolver;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "lazyExtras", "extras", "Lcoil3/Extras$Builder;", "getExtras", "()Lcoil3/Extras$Builder;", "onStart", "Lkotlin/ParameterName;", "name", "placeholder", "", "onError", "error", "onSuccess", "result", "key", "", "memoryCacheKeyExtra", "value", "onCancel", "Lkotlin/Function2;", "Lcoil3/request/ErrorResult;", "Lcoil3/request/SuccessResult;", "coroutineContext", "size", "", "width", "height", "Lcoil3/size/Dimension;", "Lcoil3/size/Size;", "resolver", "T", "factory", "type", "policy", "image", "fallback", "build", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ImageRequest.kt */
    public static final class Builder {
        private final Context context;
        private Object data;
        private CoroutineContext decoderCoroutineContext;
        private Decoder.Factory decoderFactory;
        private Defaults defaults;
        private String diskCacheKey;
        private CachePolicy diskCachePolicy;
        private Function1<? super ImageRequest, ? extends Image> errorFactory;
        private Function1<? super ImageRequest, ? extends Image> fallbackFactory;
        private CoroutineContext fetcherCoroutineContext;
        private Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> fetcherFactory;
        private FileSystem fileSystem;
        private CoroutineContext interceptorCoroutineContext;
        private Object lazyExtras;
        private Object lazyMemoryCacheKeyExtras;
        private Listener listener;
        private String memoryCacheKey;
        private boolean memoryCacheKeyExtrasAreMutable;
        private CachePolicy memoryCachePolicy;
        private CachePolicy networkCachePolicy;
        private Function1<? super ImageRequest, ? extends Image> placeholderFactory;
        private MemoryCache.Key placeholderMemoryCacheKey;
        private Precision precision;
        private Scale scale;
        private SizeResolver sizeResolver;
        private Target target;

        public Builder(ImageRequest imageRequest) {
            this(imageRequest, (Context) null, 2, (DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: private */
        public static final Image error$lambda$27(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* access modifiers changed from: private */
        public static final Image fallback$lambda$29(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* access modifiers changed from: private */
        public static final Image placeholder$lambda$25(Image image, ImageRequest imageRequest) {
            return image;
        }

        private final Map<String, String> getMemoryCacheKeyExtras() {
            Object obj = this.lazyMemoryCacheKeyExtras;
            if (!Intrinsics.areEqual(obj, (Object) Boolean.valueOf(this.memoryCacheKeyExtrasAreMutable))) {
                if (obj instanceof Map) {
                    obj = MapsKt.toMutableMap((Map) obj);
                    this.lazyMemoryCacheKeyExtras = obj;
                    this.memoryCacheKeyExtrasAreMutable = true;
                } else {
                    throw new AssertionError();
                }
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            return TypeIntrinsics.asMutableMap(obj);
        }

        public final Extras.Builder getExtras() {
            Object obj = this.lazyExtras;
            if (obj instanceof Extras.Builder) {
                return (Extras.Builder) obj;
            }
            if (obj instanceof Extras) {
                Extras.Builder newBuilder = ((Extras) obj).newBuilder();
                this.lazyExtras = newBuilder;
                return newBuilder;
            }
            throw new AssertionError();
        }

        public Builder(Context context2) {
            this.context = context2;
            this.defaults = Defaults.DEFAULT;
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.lazyMemoryCacheKeyExtras = MapsKt.emptyMap();
            this.diskCacheKey = null;
            this.fileSystem = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.interceptorCoroutineContext = null;
            this.fetcherCoroutineContext = null;
            this.decoderCoroutineContext = null;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.errorFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.fallbackFactory = UtilsKt.getEMPTY_IMAGE_FACTORY();
            this.sizeResolver = null;
            this.scale = null;
            this.precision = null;
            this.lazyExtras = Extras.EMPTY;
        }

        public Builder(ImageRequest imageRequest, Context context2) {
            this.context = context2;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.lazyMemoryCacheKeyExtras = imageRequest.getMemoryCacheKeyExtras();
            this.diskCacheKey = imageRequest.getDiskCacheKey();
            this.fileSystem = imageRequest.getDefined().getFileSystem();
            this.fetcherFactory = imageRequest.getFetcherFactory();
            this.decoderFactory = imageRequest.getDecoderFactory();
            this.interceptorCoroutineContext = imageRequest.getDefined().getInterceptorCoroutineContext();
            this.fetcherCoroutineContext = imageRequest.getDefined().getFetcherCoroutineContext();
            this.decoderCoroutineContext = imageRequest.getDefined().getDecoderCoroutineContext();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            this.placeholderFactory = imageRequest.getDefined().getPlaceholderFactory();
            this.errorFactory = imageRequest.getDefined().getErrorFactory();
            this.fallbackFactory = imageRequest.getDefined().getFallbackFactory();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            this.precision = imageRequest.getDefined().getPrecision();
            this.lazyExtras = imageRequest.getExtras();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ImageRequest imageRequest, Context context2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageRequest, (i & 2) != 0 ? imageRequest.getContext() : context2);
        }

        public final Builder data(Object obj) {
            Builder builder = this;
            this.data = obj;
            return this;
        }

        public static /* synthetic */ Builder target$default(Builder builder, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = ImageRequest$Builder$target$1.INSTANCE;
            }
            if ((i & 2) != 0) {
                function12 = ImageRequest$Builder$target$2.INSTANCE;
            }
            if ((i & 4) != 0) {
                function13 = ImageRequest$Builder$target$3.INSTANCE;
            }
            return builder.target(new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        public final Builder target(Function1<? super Image, Unit> function1, Function1<? super Image, Unit> function12, Function1<? super Image, Unit> function13) {
            return target(new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        public final Builder target(Target target2) {
            Builder builder = this;
            this.target = target2;
            return this;
        }

        public final Builder memoryCacheKey(MemoryCache.Key key) {
            Builder builder = this;
            Map<String, String> map = null;
            memoryCacheKey(key != null ? key.getKey() : null);
            if (key != null) {
                map = key.getExtras();
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            memoryCacheKeyExtras(map);
            return this;
        }

        public final Builder memoryCacheKey(String str) {
            Builder builder = this;
            this.memoryCacheKey = str;
            return this;
        }

        public final Builder memoryCacheKeyExtras(Map<String, String> map) {
            Builder builder = this;
            this.lazyMemoryCacheKeyExtras = MapsKt.toMutableMap(map);
            this.memoryCacheKeyExtrasAreMutable = true;
            return this;
        }

        public final Builder memoryCacheKeyExtra(String str, String str2) {
            Builder builder = this;
            if (str2 != null) {
                getMemoryCacheKeyExtras().put(str, str2);
                return this;
            }
            getMemoryCacheKeyExtras().remove(str);
            return this;
        }

        public final Builder diskCacheKey(String str) {
            Builder builder = this;
            this.diskCacheKey = str;
            return this;
        }

        public final Builder fileSystem(FileSystem fileSystem2) {
            Builder builder = this;
            this.fileSystem = fileSystem2;
            return this;
        }

        public static /* synthetic */ Builder listener$default(Builder builder, Function1 function1, Function1 function12, Function2 function2, Function2 function22, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = ImageRequest$Builder$listener$1.INSTANCE;
            }
            if ((i & 2) != 0) {
                function12 = ImageRequest$Builder$listener$2.INSTANCE;
            }
            if ((i & 4) != 0) {
                function2 = ImageRequest$Builder$listener$3.INSTANCE;
            }
            if ((i & 8) != 0) {
                function22 = ImageRequest$Builder$listener$4.INSTANCE;
            }
            return builder.listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        public final Builder listener(Function1<? super ImageRequest, Unit> function1, Function1<? super ImageRequest, Unit> function12, Function2<? super ImageRequest, ? super ErrorResult, Unit> function2, Function2<? super ImageRequest, ? super SuccessResult, Unit> function22) {
            return listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        public final Builder listener(Listener listener2) {
            Builder builder = this;
            this.listener = listener2;
            return this;
        }

        public final Builder coroutineContext(CoroutineContext coroutineContext) {
            Builder builder = this;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext;
            this.decoderCoroutineContext = coroutineContext;
            return this;
        }

        public final Builder interceptorCoroutineContext(CoroutineContext coroutineContext) {
            Builder builder = this;
            this.interceptorCoroutineContext = coroutineContext;
            return this;
        }

        public final Builder fetcherCoroutineContext(CoroutineContext coroutineContext) {
            Builder builder = this;
            this.fetcherCoroutineContext = coroutineContext;
            return this;
        }

        public final Builder decoderCoroutineContext(CoroutineContext coroutineContext) {
            Builder builder = this;
            this.decoderCoroutineContext = coroutineContext;
            return this;
        }

        public final Builder size(int i) {
            return size(SizeKt.Size(i, i));
        }

        public final Builder size(int i, int i2) {
            return size(SizeKt.Size(i, i2));
        }

        public final Builder size(Dimension dimension, Dimension dimension2) {
            return size(new Size(dimension, dimension2));
        }

        public final Builder size(Size size) {
            return size(SizeResolverKt.SizeResolver(size));
        }

        public final Builder size(SizeResolver sizeResolver2) {
            Builder builder = this;
            this.sizeResolver = sizeResolver2;
            return this;
        }

        public final Builder scale(Scale scale2) {
            Builder builder = this;
            this.scale = scale2;
            return this;
        }

        public final Builder precision(Precision precision2) {
            Builder builder = this;
            this.precision = precision2;
            return this;
        }

        public final /* synthetic */ <T> Builder fetcherFactory(Fetcher.Factory<T> factory) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return fetcherFactory(factory, Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final <T> Builder fetcherFactory(Fetcher.Factory<T> factory, KClass<T> kClass) {
            Builder builder = this;
            this.fetcherFactory = TuplesKt.to(factory, kClass);
            return this;
        }

        public final Builder decoderFactory(Decoder.Factory factory) {
            Builder builder = this;
            this.decoderFactory = factory;
            return this;
        }

        public final Builder memoryCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.memoryCachePolicy = cachePolicy;
            return this;
        }

        public final Builder diskCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.diskCachePolicy = cachePolicy;
            return this;
        }

        public final Builder networkCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.networkCachePolicy = cachePolicy;
            return this;
        }

        public final Builder placeholderMemoryCacheKey(String str) {
            MemoryCache.Key key = null;
            if (str != null) {
                key = new MemoryCache.Key(str, (Map) null, 2, (DefaultConstructorMarker) null);
            }
            return placeholderMemoryCacheKey(key);
        }

        public final Builder placeholderMemoryCacheKey(MemoryCache.Key key) {
            Builder builder = this;
            this.placeholderMemoryCacheKey = key;
            return this;
        }

        public final Builder placeholder(Image image) {
            return placeholder((Function1<? super ImageRequest, ? extends Image>) new ImageRequest$Builder$$ExternalSyntheticLambda2(image));
        }

        public final Builder placeholder(Function1<? super ImageRequest, ? extends Image> function1) {
            Builder builder = this;
            this.placeholderFactory = function1;
            return this;
        }

        public final Builder error(Image image) {
            return error((Function1<? super ImageRequest, ? extends Image>) new ImageRequest$Builder$$ExternalSyntheticLambda1(image));
        }

        public final Builder error(Function1<? super ImageRequest, ? extends Image> function1) {
            Builder builder = this;
            this.errorFactory = function1;
            return this;
        }

        public final Builder fallback(Image image) {
            return fallback((Function1<? super ImageRequest, ? extends Image>) new ImageRequest$Builder$$ExternalSyntheticLambda0(image));
        }

        public final Builder fallback(Function1<? super ImageRequest, ? extends Image> function1) {
            Builder builder = this;
            this.fallbackFactory = function1;
            return this;
        }

        public final Builder defaults(Defaults defaults2) {
            Builder builder = this;
            this.defaults = defaults2;
            return this;
        }

        public final ImageRequest build() {
            Map map;
            Extras extras;
            Context context2 = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target2 = this.target;
            Listener listener2 = this.listener;
            String str = this.memoryCacheKey;
            Object obj3 = this.lazyMemoryCacheKeyExtras;
            if (Intrinsics.areEqual(obj3, (Object) Boolean.valueOf(this.memoryCacheKeyExtrasAreMutable))) {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
                map = Collections_jvmCommonKt.toImmutableMap(TypeIntrinsics.asMutableMap(obj3));
            } else if (obj3 instanceof Map) {
                map = (Map) obj3;
            } else {
                throw new AssertionError();
            }
            Map map2 = map;
            Intrinsics.checkNotNull(map2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            String str2 = this.diskCacheKey;
            FileSystem fileSystem2 = this.fileSystem;
            if (fileSystem2 == null) {
                fileSystem2 = this.defaults.getFileSystem();
            }
            FileSystem fileSystem3 = fileSystem2;
            Pair<? extends Fetcher.Factory<?>, ? extends KClass<?>> pair = this.fetcherFactory;
            Decoder.Factory factory = this.decoderFactory;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            if (cachePolicy == null) {
                cachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy2 = cachePolicy;
            CachePolicy cachePolicy3 = this.diskCachePolicy;
            if (cachePolicy3 == null) {
                cachePolicy3 = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy4 = cachePolicy3;
            CachePolicy cachePolicy5 = this.networkCachePolicy;
            if (cachePolicy5 == null) {
                cachePolicy5 = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy6 = cachePolicy5;
            CoroutineContext coroutineContext = this.interceptorCoroutineContext;
            if (coroutineContext == null) {
                coroutineContext = this.defaults.getInterceptorCoroutineContext();
            }
            CoroutineContext coroutineContext2 = coroutineContext;
            CoroutineContext coroutineContext3 = this.fetcherCoroutineContext;
            if (coroutineContext3 == null) {
                coroutineContext3 = this.defaults.getFetcherCoroutineContext();
            }
            CoroutineContext coroutineContext4 = coroutineContext3;
            CoroutineContext coroutineContext5 = this.decoderCoroutineContext;
            if (coroutineContext5 == null) {
                coroutineContext5 = this.defaults.getDecoderCoroutineContext();
            }
            CoroutineContext coroutineContext6 = coroutineContext5;
            MemoryCache.Key key = this.placeholderMemoryCacheKey;
            Function1 function1 = this.placeholderFactory;
            if (function1 == null) {
                function1 = this.defaults.getPlaceholderFactory();
            }
            Function1 function12 = function1;
            Function1 function13 = this.errorFactory;
            if (function13 == null) {
                function13 = this.defaults.getErrorFactory();
            }
            Function1 function14 = function13;
            Function1 function15 = this.fallbackFactory;
            if (function15 == null) {
                function15 = this.defaults.getFallbackFactory();
            }
            Function1 function16 = function15;
            SizeResolver sizeResolver2 = this.sizeResolver;
            if (sizeResolver2 == null) {
                sizeResolver2 = this.defaults.getSizeResolver();
            }
            SizeResolver sizeResolver3 = sizeResolver2;
            Scale scale2 = this.scale;
            if (scale2 == null) {
                scale2 = this.defaults.getScale();
            }
            Scale scale3 = scale2;
            Precision precision2 = this.precision;
            if (precision2 == null) {
                precision2 = this.defaults.getPrecision();
            }
            Precision precision3 = precision2;
            Object obj4 = this.lazyExtras;
            Context context3 = context2;
            if (obj4 instanceof Extras.Builder) {
                extras = ((Extras.Builder) obj4).build();
            } else if (obj4 instanceof Extras) {
                extras = (Extras) obj4;
            } else {
                throw new AssertionError();
            }
            FileSystem fileSystem4 = this.fileSystem;
            FileSystem fileSystem5 = fileSystem4;
            return new ImageRequest(context3, obj2, target2, listener2, str, map2, str2, fileSystem3, pair, factory, coroutineContext2, coroutineContext4, coroutineContext6, cachePolicy2, cachePolicy4, cachePolicy6, key, function12, function14, function16, sizeResolver3, scale3, precision3, extras, new Defined(fileSystem5, this.interceptorCoroutineContext, this.fetcherCoroutineContext, this.decoderCoroutineContext, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy, this.placeholderFactory, this.errorFactory, this.fallbackFactory, this.sizeResolver, this.scale, this.precision), this.defaults, (DefaultConstructorMarker) null);
        }
    }
}
