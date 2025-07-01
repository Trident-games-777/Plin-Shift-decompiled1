package coil3.memory;

import coil3.EventListener;
import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.intercept.EngineInterceptor;
import coil3.intercept.Interceptor;
import coil3.memory.MemoryCache;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.request.RequestService;
import coil3.request.SuccessResult;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.Logger;
import coil3.util.UtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J5\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001dJ0\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001f\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010&\u001a\u00020\u001b*\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcoil3/memory/MemoryCacheService;", "", "imageLoader", "Lcoil3/ImageLoader;", "requestService", "Lcoil3/request/RequestService;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/request/RequestService;Lcoil3/util/Logger;)V", "newCacheKey", "Lcoil3/memory/MemoryCache$Key;", "request", "Lcoil3/request/ImageRequest;", "mappedData", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "getCacheValue", "Lcoil3/memory/MemoryCache$Value;", "cacheKey", "size", "Lcoil3/size/Size;", "scale", "Lcoil3/size/Scale;", "isCacheValueValid", "", "cacheValue", "isCacheValueValid$coil_core_release", "isSizeValid", "setCacheValue", "result", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "newResult", "Lcoil3/request/SuccessResult;", "chain", "Lcoil3/intercept/Interceptor$Chain;", "isSampled", "(Lcoil3/memory/MemoryCache$Value;)Z", "diskCacheKey", "", "getDiskCacheKey", "(Lcoil3/memory/MemoryCache$Value;)Ljava/lang/String;", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MemoryCacheService.kt */
public final class MemoryCacheService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_DISK_CACHE_KEY = "coil#disk_cache_key";
    public static final String EXTRA_IS_SAMPLED = "coil#is_sampled";
    public static final String EXTRA_TRANSFORMATION_INDEX = "coil#transformation_";
    public static final String EXTRA_TRANSFORMATION_SIZE = "coil#transformation_size";
    private static final String TAG = "MemoryCacheService";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final RequestService requestService;

    public MemoryCacheService(ImageLoader imageLoader2, RequestService requestService2, Logger logger2) {
        this.imageLoader = imageLoader2;
        this.requestService = requestService2;
        this.logger = logger2;
    }

    public final MemoryCache.Key newCacheKey(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener) {
        if (imageRequest.getMemoryCacheKey() != null) {
            return new MemoryCache.Key(imageRequest.getMemoryCacheKey(), imageRequest.getMemoryCacheKeyExtras());
        }
        eventListener.keyStart(imageRequest, obj);
        String key = this.imageLoader.getComponents().key(obj, options);
        eventListener.keyEnd(imageRequest, key);
        if (key == null) {
            return null;
        }
        return new MemoryCache.Key(key, MemoryCacheServiceKt.createComplexMemoryCacheKeyExtras(imageRequest, options));
    }

    public final MemoryCache.Value getCacheValue(ImageRequest imageRequest, MemoryCache.Key key, Size size, Scale scale) {
        if (!imageRequest.getMemoryCachePolicy().getReadEnabled()) {
            return null;
        }
        MemoryCache memoryCache = this.imageLoader.getMemoryCache();
        MemoryCache.Value value = memoryCache != null ? memoryCache.get(key) : null;
        if (value == null || !isCacheValueValid$coil_core_release(imageRequest, key, value, size, scale)) {
            return null;
        }
        return value;
    }

    public final boolean isCacheValueValid$coil_core_release(ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value, Size size, Scale scale) {
        if (this.requestService.isCacheValueValidForHardware(imageRequest, value)) {
            return isSizeValid(imageRequest, key, value, size, scale);
        }
        Logger logger2 = this.logger;
        if (logger2 == null) {
            return false;
        }
        Logger.Level level = Logger.Level.Debug;
        if (logger2.getMinLevel().compareTo(level) > 0) {
            return false;
        }
        logger2.log(TAG, level, imageRequest.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", (Throwable) null);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d4, code lost:
        if (java.lang.Math.abs(r9 - r4) > 1) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e1, code lost:
        if (java.lang.Math.abs(r11 - r1) > 1) goto L_0x00e5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isSizeValid(coil3.request.ImageRequest r20, coil3.memory.MemoryCache.Key r21, coil3.memory.MemoryCache.Value r22, coil3.size.Size r23, coil3.size.Scale r24) {
        /*
            r19 = this;
            r0 = r19
            r1 = r22
            r2 = r24
            boolean r3 = r0.isSampled(r1)
            boolean r4 = coil3.size.SizeKt.isOriginal(r23)
            r5 = 0
            java.lang.String r6 = "MemoryCacheService"
            r7 = 0
            r8 = 1
            if (r4 == 0) goto L_0x0046
            if (r3 == 0) goto L_0x0045
            coil3.util.Logger r1 = r0.logger
            if (r1 == 0) goto L_0x0044
            coil3.util.Logger$Level r2 = coil3.util.Logger.Level.Debug
            coil3.util.Logger$Level r3 = r1.getMinLevel()
            r4 = r2
            java.lang.Enum r4 = (java.lang.Enum) r4
            int r3 = r3.compareTo(r4)
            if (r3 > 0) goto L_0x0044
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.Object r4 = r20.getData()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = ": Requested original size, but cached image is sampled."
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.log(r6, r2, r3, r5)
        L_0x0044:
            return r7
        L_0x0045:
            return r8
        L_0x0046:
            java.util.Map r4 = r21.getExtras()
            java.lang.String r9 = "coil#transformation_size"
            java.lang.Object r4 = r4.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x005d
            java.lang.String r1 = r23.toString()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            return r1
        L_0x005d:
            coil3.Image r4 = r1.getImage()
            int r4 = r4.getWidth()
            coil3.Image r1 = r1.getImage()
            int r1 = r1.getHeight()
            coil3.size.Dimension r9 = r23.getWidth()
            boolean r10 = r9 instanceof coil3.size.Dimension.Pixels
            r11 = 2147483647(0x7fffffff, float:NaN)
            if (r10 == 0) goto L_0x007f
            coil3.size.Dimension$Pixels r9 = (coil3.size.Dimension.Pixels) r9
            int r9 = r9.m7548unboximpl()
            goto L_0x0080
        L_0x007f:
            r9 = r11
        L_0x0080:
            coil3.size.Dimension r10 = r23.getHeight()
            boolean r12 = r10 instanceof coil3.size.Dimension.Pixels
            if (r12 == 0) goto L_0x008e
            coil3.size.Dimension$Pixels r10 = (coil3.size.Dimension.Pixels) r10
            int r11 = r10.m7548unboximpl()
        L_0x008e:
            double r12 = coil3.decode.DecodeUtils.computeSizeMultiplier((int) r4, (int) r1, (int) r9, (int) r11, (coil3.size.Scale) r2)
            coil3.size.Precision r10 = r20.getPrecision()
            coil3.size.Precision r14 = coil3.size.Precision.INEXACT
            if (r10 != r14) goto L_0x009c
            r10 = r8
            goto L_0x009d
        L_0x009c:
            r10 = r7
        L_0x009d:
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r10 == 0) goto L_0x00c5
            double r16 = kotlin.ranges.RangesKt.coerceAtMost((double) r12, (double) r14)
            r21 = r14
            double r14 = (double) r9
            r18 = r6
            double r5 = (double) r4
            double r5 = r5 * r16
            double r14 = r14 - r5
            double r5 = java.lang.Math.abs(r14)
            int r5 = (r5 > r21 ? 1 : (r5 == r21 ? 0 : -1))
            if (r5 <= 0) goto L_0x00c4
            double r5 = (double) r11
            double r14 = (double) r1
            double r16 = r16 * r14
            double r5 = r5 - r16
            double r5 = java.lang.Math.abs(r5)
            int r5 = (r5 > r21 ? 1 : (r5 == r21 ? 0 : -1))
            if (r5 > 0) goto L_0x00e5
        L_0x00c4:
            return r8
        L_0x00c5:
            r18 = r6
            r21 = r14
            boolean r5 = coil3.util.UtilsKt.isMinOrMax(r9)
            if (r5 != 0) goto L_0x00d6
            int r9 = r9 - r4
            int r5 = java.lang.Math.abs(r9)
            if (r5 > r8) goto L_0x00e5
        L_0x00d6:
            boolean r5 = coil3.util.UtilsKt.isMinOrMax(r11)
            if (r5 != 0) goto L_0x01ba
            int r11 = r11 - r1
            int r5 = java.lang.Math.abs(r11)
            if (r5 > r8) goto L_0x00e5
            goto L_0x01ba
        L_0x00e5:
            int r5 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
            java.lang.String r6 = ")."
            java.lang.String r9 = ": Cached image's request size ("
            java.lang.String r11 = ", "
            if (r5 != 0) goto L_0x00f2
        L_0x00ef:
            r10 = r18
            goto L_0x0155
        L_0x00f2:
            if (r10 != 0) goto L_0x00ef
            coil3.util.Logger r3 = r0.logger
            if (r3 == 0) goto L_0x0154
            coil3.util.Logger$Level r5 = coil3.util.Logger.Level.Debug
            coil3.util.Logger$Level r8 = r3.getMinLevel()
            r10 = r5
            java.lang.Enum r10 = (java.lang.Enum) r10
            int r8 = r8.compareTo(r10)
            if (r8 > 0) goto L_0x0154
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.Object r10 = r20.getData()
            java.lang.StringBuilder r8 = r8.append(r10)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r4 = r8.append(r4)
            java.lang.StringBuilder r4 = r4.append(r11)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r4 = ") does not exactly match the requested size ("
            java.lang.StringBuilder r1 = r1.append(r4)
            coil3.size.Dimension r4 = r23.getWidth()
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.StringBuilder r1 = r1.append(r11)
            coil3.size.Dimension r4 = r23.getHeight()
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            r10 = r18
            r2 = 0
            r3.log(r10, r5, r1, r2)
        L_0x0154:
            return r7
        L_0x0155:
            int r5 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
            if (r5 <= 0) goto L_0x01ba
            if (r3 == 0) goto L_0x01ba
            coil3.util.Logger r3 = r0.logger
            if (r3 == 0) goto L_0x01b9
            coil3.util.Logger$Level r5 = coil3.util.Logger.Level.Debug
            coil3.util.Logger$Level r8 = r3.getMinLevel()
            r12 = r5
            java.lang.Enum r12 = (java.lang.Enum) r12
            int r8 = r8.compareTo(r12)
            if (r8 > 0) goto L_0x01b9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.Object r12 = r20.getData()
            java.lang.StringBuilder r8 = r8.append(r12)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r4 = r8.append(r4)
            java.lang.StringBuilder r4 = r4.append(r11)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r4 = ") is smaller than the requested size ("
            java.lang.StringBuilder r1 = r1.append(r4)
            coil3.size.Dimension r4 = r23.getWidth()
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.StringBuilder r1 = r1.append(r11)
            coil3.size.Dimension r4 = r23.getHeight()
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            r2 = 0
            r3.log(r10, r5, r1, r2)
        L_0x01b9:
            return r7
        L_0x01ba:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.memory.MemoryCacheService.isSizeValid(coil3.request.ImageRequest, coil3.memory.MemoryCache$Key, coil3.memory.MemoryCache$Value, coil3.size.Size, coil3.size.Scale):boolean");
    }

    public final boolean setCacheValue(MemoryCache.Key key, ImageRequest imageRequest, EngineInterceptor.ExecuteResult executeResult) {
        MemoryCache memoryCache;
        if (key == null || !imageRequest.getMemoryCachePolicy().getWriteEnabled() || !executeResult.getImage().getShareable() || (memoryCache = this.imageLoader.getMemoryCache()) == null) {
            return false;
        }
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EXTRA_IS_SAMPLED, Boolean.valueOf(executeResult.isSampled()));
        String diskCacheKey = executeResult.getDiskCacheKey();
        if (diskCacheKey != null) {
            linkedHashMap.put(EXTRA_DISK_CACHE_KEY, diskCacheKey);
        }
        memoryCache.set(key, new MemoryCache.Value(executeResult.getImage(), linkedHashMap));
        return true;
    }

    public final SuccessResult newResult(Interceptor.Chain chain, ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value) {
        return new SuccessResult(value.getImage(), imageRequest, DataSource.MEMORY_CACHE, key, getDiskCacheKey(value), isSampled(value), UtilsKt.isPlaceholderCached(chain));
    }

    private final boolean isSampled(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_IS_SAMPLED);
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final String getDiskCacheKey(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_DISK_CACHE_KEY);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcoil3/memory/MemoryCacheService$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_TRANSFORMATION_INDEX", "EXTRA_TRANSFORMATION_SIZE", "EXTRA_IS_SAMPLED", "EXTRA_DISK_CACHE_KEY", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: MemoryCacheService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
