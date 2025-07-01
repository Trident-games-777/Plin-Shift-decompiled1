package coil3;

import android.content.Context;
import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.Extras;
import coil3.RealImageLoader;
import coil3.disk.DiskCache;
import coil3.disk.UtilsKt;
import coil3.memory.MemoryCache;
import coil3.request.CachePolicy;
import coil3.request.Disposable;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.size.Precision;
import coil3.util.ContextsKt;
import coil3.util.Logger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okio.FileSystem;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Lcoil3/ImageLoader;", "", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "components", "Lcoil3/ComponentRegistry;", "getComponents", "()Lcoil3/ComponentRegistry;", "memoryCache", "Lcoil3/memory/MemoryCache;", "getMemoryCache", "()Lcoil3/memory/MemoryCache;", "diskCache", "Lcoil3/disk/DiskCache;", "getDiskCache", "()Lcoil3/disk/DiskCache;", "enqueue", "Lcoil3/request/Disposable;", "request", "Lcoil3/request/ImageRequest;", "execute", "Lcoil3/request/ImageResult;", "(Lcoil3/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "", "newBuilder", "Lcoil3/ImageLoader$Builder;", "Builder", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageLoader.kt */
public interface ImageLoader {
    Disposable enqueue(ImageRequest imageRequest);

    Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation);

    ComponentRegistry getComponents();

    ImageRequest.Defaults getDefaults();

    DiskCache getDiskCache();

    MemoryCache getMemoryCache();

    Builder newBuilder();

    void shutdown();

    @Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\"\u0010\u001d\u001a\u00020\u00002\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\b\"H\bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0016J\u0010\u0010#\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0010J\u0016\u0010#\u001a\u00020\u00002\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100%J\u0010\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0012J\u0016\u0010&\u001a\u00020\u00002\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120%J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0014J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u000200J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u000200J\u000e\u00102\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u000200J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u000200J\u0010\u00104\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u000106J\u001c\u00104\u001a\u00020\u00002\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0006\u0012\u0004\u0018\u0001060\u001fJ\u0010\u00108\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u000106J\u001c\u00108\u001a\u00020\u00002\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0006\u0012\u0004\u0018\u0001060\u001fJ\u0010\u00109\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u000106J\u001c\u00109\u001a\u00020\u00002\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0006\u0012\u0004\u0018\u0001060\u001fJ\u000e\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010?\u001a\u00020@R\u0014\u0010\n\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006A"}, d2 = {"Lcoil3/ImageLoader$Builder;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "<init>", "(Landroid/content/Context;)V", "options", "Lcoil3/RealImageLoader$Options;", "(Lcoil3/RealImageLoader$Options;)V", "application", "Landroid/content/Context;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil3/memory/MemoryCache;", "diskCacheLazy", "Lcoil3/disk/DiskCache;", "eventListenerFactory", "Lcoil3/EventListener$Factory;", "componentRegistry", "Lcoil3/ComponentRegistry;", "logger", "Lcoil3/util/Logger;", "extras", "Lcoil3/Extras$Builder;", "getExtras", "()Lcoil3/Extras$Builder;", "components", "builder", "Lkotlin/Function1;", "Lcoil3/ComponentRegistry$Builder;", "", "Lkotlin/ExtensionFunctionType;", "memoryCache", "initializer", "Lkotlin/Function0;", "diskCache", "fileSystem", "Lokio/FileSystem;", "eventListener", "listener", "Lcoil3/EventListener;", "factory", "precision", "Lcoil3/size/Precision;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "interceptorCoroutineContext", "fetcherCoroutineContext", "decoderCoroutineContext", "placeholder", "image", "Lcoil3/Image;", "Lcoil3/request/ImageRequest;", "error", "fallback", "memoryCachePolicy", "policy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "build", "Lcoil3/ImageLoader;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ImageLoader.kt */
    public static final class Builder {
        private final Context application;
        private ComponentRegistry componentRegistry;
        private ImageRequest.Defaults defaults;
        private Lazy<? extends DiskCache> diskCacheLazy;
        private EventListener.Factory eventListenerFactory;
        private final Extras.Builder extras;
        private Logger logger;
        private Lazy<? extends MemoryCache> memoryCacheLazy;

        /* access modifiers changed from: private */
        public static final Image error$lambda$15(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* access modifiers changed from: private */
        public static final EventListener eventListener$lambda$6(EventListener eventListener, ImageRequest imageRequest) {
            return eventListener;
        }

        /* access modifiers changed from: private */
        public static final Image fallback$lambda$17(Image image, ImageRequest imageRequest) {
            return image;
        }

        /* access modifiers changed from: private */
        public static final Image placeholder$lambda$13(Image image, ImageRequest imageRequest) {
            return image;
        }

        public final Extras.Builder getExtras() {
            return this.extras;
        }

        public Builder(Context context) {
            this.application = ContextsKt.getApplication(context);
            this.defaults = ImageRequest.Defaults.DEFAULT;
            this.memoryCacheLazy = null;
            this.diskCacheLazy = null;
            this.eventListenerFactory = null;
            this.componentRegistry = null;
            this.logger = null;
            this.extras = new Extras.Builder();
        }

        public Builder(RealImageLoader.Options options) {
            this.application = options.getApplication();
            this.defaults = options.getDefaults();
            this.memoryCacheLazy = options.getMemoryCacheLazy();
            this.diskCacheLazy = options.getDiskCacheLazy();
            this.eventListenerFactory = options.getEventListenerFactory();
            this.componentRegistry = options.getComponentRegistry();
            this.logger = options.getLogger();
            this.extras = options.getDefaults().getExtras().newBuilder();
        }

        public final /* synthetic */ Builder components(Function1<? super ComponentRegistry.Builder, Unit> function1) {
            ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
            function1.invoke(builder);
            return components(builder.build());
        }

        public final Builder components(ComponentRegistry componentRegistry2) {
            Builder builder = this;
            this.componentRegistry = componentRegistry2;
            return this;
        }

        public final Builder memoryCache(MemoryCache memoryCache) {
            Builder builder = this;
            this.memoryCacheLazy = LazyKt.lazyOf(memoryCache);
            return this;
        }

        public final Builder memoryCache(Function0<? extends MemoryCache> function0) {
            Builder builder = this;
            this.memoryCacheLazy = LazyKt.lazy(function0);
            return this;
        }

        public final Builder diskCache(DiskCache diskCache) {
            Builder builder = this;
            this.diskCacheLazy = LazyKt.lazyOf(diskCache);
            return this;
        }

        public final Builder diskCache(Function0<? extends DiskCache> function0) {
            Builder builder = this;
            this.diskCacheLazy = LazyKt.lazy(function0);
            return this;
        }

        public final Builder fileSystem(FileSystem fileSystem) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, fileSystem, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (Precision) null, (Extras) null, 4094, (Object) null);
            return this;
        }

        public final Builder eventListener(EventListener eventListener) {
            return eventListenerFactory(new ImageLoader$Builder$$ExternalSyntheticLambda5(eventListener));
        }

        public final Builder eventListenerFactory(EventListener.Factory factory) {
            Builder builder = this;
            this.eventListenerFactory = factory;
            return this;
        }

        public final Builder precision(Precision precision) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, precision, (Extras) null, 3071, (Object) null);
            return this;
        }

        public final Builder coroutineContext(CoroutineContext coroutineContext) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, coroutineContext, coroutineContext, coroutineContext, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (Precision) null, (Extras) null, 4081, (Object) null);
            return this;
        }

        public final Builder interceptorCoroutineContext(CoroutineContext coroutineContext) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, coroutineContext, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (Precision) null, (Extras) null, 4093, (Object) null);
            return this;
        }

        public final Builder fetcherCoroutineContext(CoroutineContext coroutineContext) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, coroutineContext, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (Precision) null, (Extras) null, 4091, (Object) null);
            return this;
        }

        public final Builder decoderCoroutineContext(CoroutineContext coroutineContext) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, coroutineContext, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (Precision) null, (Extras) null, 4087, (Object) null);
            return this;
        }

        public final Builder placeholder(Image image) {
            return placeholder((Function1<? super ImageRequest, ? extends Image>) new ImageLoader$Builder$$ExternalSyntheticLambda4(image));
        }

        public final Builder placeholder(Function1<? super ImageRequest, ? extends Image> function1) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, function1, (Function1) null, (Function1) null, (Precision) null, (Extras) null, 3967, (Object) null);
            return this;
        }

        public final Builder error(Image image) {
            return error((Function1<? super ImageRequest, ? extends Image>) new ImageLoader$Builder$$ExternalSyntheticLambda2(image));
        }

        public final Builder error(Function1<? super ImageRequest, ? extends Image> function1) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, function1, (Function1) null, (Precision) null, (Extras) null, 3839, (Object) null);
            return this;
        }

        public final Builder fallback(Image image) {
            return fallback((Function1<? super ImageRequest, ? extends Image>) new ImageLoader$Builder$$ExternalSyntheticLambda3(image));
        }

        public final Builder fallback(Function1<? super ImageRequest, ? extends Image> function1) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, function1, (Precision) null, (Extras) null, 3583, (Object) null);
            return this;
        }

        public final Builder memoryCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, cachePolicy, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (Precision) null, (Extras) null, 4079, (Object) null);
            return this;
        }

        public final Builder diskCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, cachePolicy, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (Precision) null, (Extras) null, 4063, (Object) null);
            return this;
        }

        public final Builder networkCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.defaults = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, cachePolicy, (Function1) null, (Function1) null, (Function1) null, (Precision) null, (Extras) null, 4031, (Object) null);
            return this;
        }

        public final Builder logger(Logger logger2) {
            Builder builder = this;
            this.logger = logger2;
            return this;
        }

        public final ImageLoader build() {
            Context context = this.application;
            ImageRequest.Defaults copy$default = ImageRequest.Defaults.copy$default(this.defaults, (FileSystem) null, (CoroutineContext) null, (CoroutineContext) null, (CoroutineContext) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, (Function1) null, (Function1) null, (Function1) null, (Precision) null, this.extras.build(), 2047, (Object) null);
            Lazy<? extends MemoryCache> lazy = this.memoryCacheLazy;
            if (lazy == null) {
                lazy = LazyKt.lazy(new ImageLoader$Builder$$ExternalSyntheticLambda0(this));
            }
            Lazy<? extends DiskCache> lazy2 = this.diskCacheLazy;
            if (lazy2 == null) {
                lazy2 = LazyKt.lazy(new ImageLoader$Builder$$ExternalSyntheticLambda1());
            }
            EventListener.Factory factory = this.eventListenerFactory;
            if (factory == null) {
                factory = EventListener.Factory.NONE;
            }
            ComponentRegistry componentRegistry2 = this.componentRegistry;
            if (componentRegistry2 == null) {
                componentRegistry2 = new ComponentRegistry();
            }
            return new RealImageLoader(new RealImageLoader.Options(context, copy$default, lazy, lazy2, factory, componentRegistry2, this.logger));
        }

        /* access modifiers changed from: private */
        public static final MemoryCache build$lambda$23(Builder builder) {
            return MemoryCache.Builder.maxSizePercent$default(new MemoryCache.Builder(), builder.application, 0.0d, 2, (Object) null).build();
        }

        /* access modifiers changed from: private */
        public static final DiskCache build$lambda$24() {
            return UtilsKt.singletonDiskCache();
        }
    }
}
