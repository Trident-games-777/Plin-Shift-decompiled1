package coil3.intercept;

import coil3.Image;
import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.memory.MemoryCacheService;
import coil3.request.RequestService;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 (2\u00020\u0001:\u0002'(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH@¢\u0006\u0002\u0010\u001dJ6\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH@¢\u0006\u0002\u0010\"J>\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH@¢\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcoil3/intercept/EngineInterceptor;", "Lcoil3/intercept/Interceptor;", "imageLoader", "Lcoil3/ImageLoader;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "requestService", "Lcoil3/request/RequestService;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/util/SystemCallbacks;Lcoil3/request/RequestService;Lcoil3/util/Logger;)V", "memoryCacheService", "Lcoil3/memory/MemoryCacheService;", "intercept", "Lcoil3/request/ImageResult;", "chain", "Lcoil3/intercept/Interceptor$Chain;", "(Lcoil3/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "request", "Lcoil3/request/ImageRequest;", "mappedData", "", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "(Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil3/fetch/FetchResult;", "components", "Lcoil3/ComponentRegistry;", "(Lcoil3/ComponentRegistry;Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decode", "fetchResult", "Lcoil3/fetch/SourceFetchResult;", "(Lcoil3/fetch/SourceFetchResult;Lcoil3/ComponentRegistry;Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ExecuteResult", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: EngineInterceptor.kt */
public final class EngineInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    /* access modifiers changed from: private */
    public final MemoryCacheService memoryCacheService;
    private final RequestService requestService;
    /* access modifiers changed from: private */
    public final SystemCallbacks systemCallbacks;

    public EngineInterceptor(ImageLoader imageLoader2, SystemCallbacks systemCallbacks2, RequestService requestService2, Logger logger2) {
        this.imageLoader = imageLoader2;
        this.systemCallbacks = systemCallbacks2;
        this.requestService = requestService2;
        this.logger = logger2;
        this.memoryCacheService = new MemoryCacheService(imageLoader2, requestService2, logger2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object intercept(coil3.intercept.Interceptor.Chain r14, kotlin.coroutines.Continuation<? super coil3.request.ImageResult> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof coil3.intercept.EngineInterceptor$intercept$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            coil3.intercept.EngineInterceptor$intercept$1 r0 = (coil3.intercept.EngineInterceptor$intercept$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            coil3.intercept.EngineInterceptor$intercept$1 r0 = new coil3.intercept.EngineInterceptor$intercept$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r14 = r0.L$0
            coil3.intercept.Interceptor$Chain r14 = (coil3.intercept.Interceptor.Chain) r14
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x002e }
            return r15
        L_0x002e:
            r0 = move-exception
            goto L_0x00a3
        L_0x0031:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r15)
            coil3.request.ImageRequest r6 = r14.getRequest()     // Catch:{ all -> 0x00a1 }
            java.lang.Object r15 = r6.getData()     // Catch:{ all -> 0x00a1 }
            coil3.size.Size r2 = r14.getSize()     // Catch:{ all -> 0x00a1 }
            coil3.size.SizeResolver r4 = coil3.util.UtilsKt.getSizeResolver(r14)     // Catch:{ all -> 0x00a1 }
            coil3.EventListener r9 = coil3.util.UtilsKt.getEventListener(r14)     // Catch:{ all -> 0x00a1 }
            coil3.request.RequestService r5 = r13.requestService     // Catch:{ all -> 0x00a1 }
            coil3.request.Options r8 = r5.options(r6, r4, r2)     // Catch:{ all -> 0x00a1 }
            coil3.size.Scale r4 = r8.getScale()     // Catch:{ all -> 0x00a1 }
            r9.mapStart(r6, r15)     // Catch:{ all -> 0x00a1 }
            coil3.ImageLoader r5 = r13.imageLoader     // Catch:{ all -> 0x00a1 }
            coil3.ComponentRegistry r5 = r5.getComponents()     // Catch:{ all -> 0x00a1 }
            java.lang.Object r7 = r5.map(r15, r8)     // Catch:{ all -> 0x00a1 }
            r9.mapEnd(r6, r7)     // Catch:{ all -> 0x00a1 }
            coil3.memory.MemoryCacheService r15 = r13.memoryCacheService     // Catch:{ all -> 0x00a1 }
            coil3.memory.MemoryCache$Key r10 = r15.newCacheKey(r6, r7, r8, r9)     // Catch:{ all -> 0x00a1 }
            if (r10 == 0) goto L_0x0079
            coil3.memory.MemoryCacheService r15 = r13.memoryCacheService     // Catch:{ all -> 0x002e }
            coil3.memory.MemoryCache$Value r15 = r15.getCacheValue(r6, r10, r2, r4)     // Catch:{ all -> 0x002e }
            goto L_0x007a
        L_0x0079:
            r15 = 0
        L_0x007a:
            if (r15 == 0) goto L_0x0083
            coil3.memory.MemoryCacheService r0 = r13.memoryCacheService     // Catch:{ all -> 0x002e }
            coil3.request.SuccessResult r14 = r0.newResult(r14, r6, r10, r15)     // Catch:{ all -> 0x002e }
            return r14
        L_0x0083:
            kotlin.coroutines.CoroutineContext r15 = r6.getFetcherCoroutineContext()     // Catch:{ all -> 0x00a1 }
            coil3.intercept.EngineInterceptor$intercept$2 r4 = new coil3.intercept.EngineInterceptor$intercept$2     // Catch:{ all -> 0x00a1 }
            r12 = 0
            r5 = r13
            r11 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x009d }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ all -> 0x009d }
            r0.L$0 = r11     // Catch:{ all -> 0x009d }
            r0.label = r3     // Catch:{ all -> 0x009d }
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r15, r4, r0)     // Catch:{ all -> 0x009d }
            if (r14 != r1) goto L_0x009c
            return r1
        L_0x009c:
            return r14
        L_0x009d:
            r0 = move-exception
            r15 = r0
            r14 = r11
            goto L_0x00a4
        L_0x00a1:
            r0 = move-exception
            r11 = r14
        L_0x00a3:
            r15 = r0
        L_0x00a4:
            boolean r0 = r15 instanceof java.util.concurrent.CancellationException
            if (r0 != 0) goto L_0x00b2
            coil3.request.ImageRequest r14 = r14.getRequest()
            coil3.request.ErrorResult r14 = coil3.util.UtilsKt.ErrorResult(r14, r15)
            return r14
        L_0x00b2:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.intercept(coil3.intercept.Interceptor$Chain, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0160, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0161, code lost:
        r2 = r16;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:16:0x0052, B:40:0x012f] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0125 A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0165 A[Catch:{ all -> 0x0160, all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01c9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ca A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object execute(coil3.request.ImageRequest r24, java.lang.Object r25, coil3.request.Options r26, coil3.EventListener r27, kotlin.coroutines.Continuation<? super coil3.intercept.EngineInterceptor.ExecuteResult> r28) {
        /*
            r23 = this;
            r1 = r23
            r0 = r28
            boolean r2 = r0 instanceof coil3.intercept.EngineInterceptor$execute$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            coil3.intercept.EngineInterceptor$execute$1 r2 = (coil3.intercept.EngineInterceptor$execute$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            coil3.intercept.EngineInterceptor$execute$1 r2 = new coil3.intercept.EngineInterceptor$execute$1
            r2.<init>(r1, r0)
        L_0x001d:
            r7 = r2
            java.lang.Object r0 = r7.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r8 = 3
            r10 = 2
            r3 = 1
            r11 = 0
            if (r2 == 0) goto L_0x008c
            if (r2 == r3) goto L_0x005a
            if (r2 == r10) goto L_0x003e
            if (r2 != r8) goto L_0x0036
            kotlin.ResultKt.throwOnFailure(r0)
            return r0
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003e:
            java.lang.Object r2 = r7.L$4
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r7.L$3
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r7.L$2
            coil3.EventListener r4 = (coil3.EventListener) r4
            java.lang.Object r5 = r7.L$1
            coil3.request.ImageRequest r5 = (coil3.request.ImageRequest) r5
            java.lang.Object r6 = r7.L$0
            coil3.intercept.EngineInterceptor r6 = (coil3.intercept.EngineInterceptor) r6
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0057 }
            goto L_0x0157
        L_0x0057:
            r0 = move-exception
            goto L_0x01d3
        L_0x005a:
            java.lang.Object r2 = r7.L$7
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r7.L$6
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r7.L$5
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r7.L$4
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r7.L$3
            coil3.EventListener r6 = (coil3.EventListener) r6
            java.lang.Object r12 = r7.L$2
            java.lang.Object r13 = r7.L$1
            coil3.request.ImageRequest r13 = (coil3.request.ImageRequest) r13
            java.lang.Object r14 = r7.L$0
            coil3.intercept.EngineInterceptor r14 = (coil3.intercept.EngineInterceptor) r14
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0088 }
            r17 = r4
            r20 = r5
            r21 = r6
            r19 = r12
            r18 = r13
            r15 = r14
            goto L_0x011b
        L_0x0088:
            r0 = move-exception
            r2 = r3
            goto L_0x01d3
        L_0x008c:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r2 = r26
            r0.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            coil3.ImageLoader r2 = r1.imageLoader
            coil3.ComponentRegistry r2 = r2.getComponents()
            r12.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            coil3.request.RequestService r2 = r1.requestService     // Catch:{ all -> 0x01d1 }
            T r4 = r0.element     // Catch:{ all -> 0x01d1 }
            coil3.request.Options r4 = (coil3.request.Options) r4     // Catch:{ all -> 0x01d1 }
            coil3.request.Options r2 = r2.updateOptionsOnWorkerThread(r4)     // Catch:{ all -> 0x01d1 }
            r0.element = r2     // Catch:{ all -> 0x01d1 }
            kotlin.Pair r2 = r24.getFetcherFactory()     // Catch:{ all -> 0x01d1 }
            if (r2 != 0) goto L_0x00c2
            coil3.decode.Decoder$Factory r2 = r24.getDecoderFactory()     // Catch:{ all -> 0x01d1 }
            if (r2 == 0) goto L_0x00e0
        L_0x00c2:
            T r2 = r12.element     // Catch:{ all -> 0x01d1 }
            coil3.ComponentRegistry r2 = (coil3.ComponentRegistry) r2     // Catch:{ all -> 0x01d1 }
            coil3.ComponentRegistry$Builder r2 = r2.newBuilder()     // Catch:{ all -> 0x01d1 }
            kotlin.Pair r4 = r24.getFetcherFactory()     // Catch:{ all -> 0x01d1 }
            coil3.ComponentRegistry$Builder r2 = coil3.util.UtilsKt.addFirst((coil3.ComponentRegistry.Builder) r2, (kotlin.Pair<? extends coil3.fetch.Fetcher.Factory<?>, ? extends kotlin.reflect.KClass<?>>) r4)     // Catch:{ all -> 0x01d1 }
            coil3.decode.Decoder$Factory r4 = r24.getDecoderFactory()     // Catch:{ all -> 0x01d1 }
            coil3.ComponentRegistry$Builder r2 = coil3.util.UtilsKt.addFirst((coil3.ComponentRegistry.Builder) r2, (coil3.decode.Decoder.Factory) r4)     // Catch:{ all -> 0x01d1 }
            coil3.ComponentRegistry r2 = r2.build()     // Catch:{ all -> 0x01d1 }
            r12.element = r2     // Catch:{ all -> 0x01d1 }
        L_0x00e0:
            T r2 = r12.element     // Catch:{ all -> 0x01d1 }
            coil3.ComponentRegistry r2 = (coil3.ComponentRegistry) r2     // Catch:{ all -> 0x01d1 }
            T r4 = r0.element     // Catch:{ all -> 0x01d1 }
            r5 = r4
            coil3.request.Options r5 = (coil3.request.Options) r5     // Catch:{ all -> 0x01d1 }
            r7.L$0 = r1     // Catch:{ all -> 0x01d1 }
            r4 = r24
            r7.L$1 = r4     // Catch:{ all -> 0x01d1 }
            r6 = r25
            r7.L$2 = r6     // Catch:{ all -> 0x01d1 }
            r14 = r27
            r7.L$3 = r14     // Catch:{ all -> 0x01d1 }
            r7.L$4 = r0     // Catch:{ all -> 0x01d1 }
            r7.L$5 = r12     // Catch:{ all -> 0x01d1 }
            r7.L$6 = r13     // Catch:{ all -> 0x01d1 }
            r7.L$7 = r13     // Catch:{ all -> 0x01d1 }
            r7.label = r3     // Catch:{ all -> 0x01d1 }
            r3 = r4
            r4 = r6
            r6 = r14
            java.lang.Object r2 = r1.fetch(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x01d1 }
            if (r2 != r9) goto L_0x010c
            goto L_0x01c9
        L_0x010c:
            r15 = r23
            r18 = r24
            r19 = r25
            r21 = r27
            r20 = r0
            r0 = r2
            r17 = r12
            r2 = r13
            r3 = r2
        L_0x011b:
            r2.element = r0     // Catch:{ all -> 0x0088 }
            T r0 = r3.element     // Catch:{ all -> 0x0088 }
            coil3.fetch.FetchResult r0 = (coil3.fetch.FetchResult) r0     // Catch:{ all -> 0x0088 }
            boolean r1 = r0 instanceof coil3.fetch.SourceFetchResult     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0165
            kotlin.coroutines.CoroutineContext r0 = r18.getDecoderCoroutineContext()     // Catch:{ all -> 0x0088 }
            coil3.intercept.EngineInterceptor$execute$executeResult$1 r14 = new coil3.intercept.EngineInterceptor$execute$executeResult$1     // Catch:{ all -> 0x0088 }
            r22 = 0
            r16 = r3
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0160 }
            r2 = r16
            r5 = r18
            r3 = r20
            r4 = r21
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14     // Catch:{ all -> 0x0057 }
            r7.L$0 = r15     // Catch:{ all -> 0x0057 }
            r7.L$1 = r5     // Catch:{ all -> 0x0057 }
            r7.L$2 = r4     // Catch:{ all -> 0x0057 }
            r7.L$3 = r3     // Catch:{ all -> 0x0057 }
            r7.L$4 = r2     // Catch:{ all -> 0x0057 }
            r7.L$5 = r11     // Catch:{ all -> 0x0057 }
            r7.L$6 = r11     // Catch:{ all -> 0x0057 }
            r7.L$7 = r11     // Catch:{ all -> 0x0057 }
            r7.label = r10     // Catch:{ all -> 0x0057 }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r14, r7)     // Catch:{ all -> 0x0057 }
            if (r0 != r9) goto L_0x0156
            goto L_0x01c9
        L_0x0156:
            r6 = r15
        L_0x0157:
            coil3.intercept.EngineInterceptor$ExecuteResult r0 = (coil3.intercept.EngineInterceptor.ExecuteResult) r0     // Catch:{ all -> 0x0057 }
            r15 = r3
            r3 = r0
            r0 = r15
            r15 = r6
        L_0x015d:
            r6 = r4
            r4 = r5
            goto L_0x0191
        L_0x0160:
            r0 = move-exception
            r2 = r16
            goto L_0x01d3
        L_0x0165:
            r2 = r3
            r5 = r18
            r3 = r20
            r4 = r21
            boolean r0 = r0 instanceof coil3.fetch.ImageFetchResult     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x01cb
            coil3.intercept.EngineInterceptor$ExecuteResult r0 = new coil3.intercept.EngineInterceptor$ExecuteResult     // Catch:{ all -> 0x0057 }
            T r1 = r2.element     // Catch:{ all -> 0x0057 }
            coil3.fetch.ImageFetchResult r1 = (coil3.fetch.ImageFetchResult) r1     // Catch:{ all -> 0x0057 }
            coil3.Image r1 = r1.getImage()     // Catch:{ all -> 0x0057 }
            T r6 = r2.element     // Catch:{ all -> 0x0057 }
            coil3.fetch.ImageFetchResult r6 = (coil3.fetch.ImageFetchResult) r6     // Catch:{ all -> 0x0057 }
            boolean r6 = r6.isSampled()     // Catch:{ all -> 0x0057 }
            T r10 = r2.element     // Catch:{ all -> 0x0057 }
            coil3.fetch.ImageFetchResult r10 = (coil3.fetch.ImageFetchResult) r10     // Catch:{ all -> 0x0057 }
            coil3.decode.DataSource r10 = r10.getDataSource()     // Catch:{ all -> 0x0057 }
            r0.<init>(r1, r6, r10, r11)     // Catch:{ all -> 0x0057 }
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x015d
        L_0x0191:
            T r1 = r2.element
            boolean r2 = r1 instanceof coil3.fetch.SourceFetchResult
            if (r2 == 0) goto L_0x019a
            coil3.fetch.SourceFetchResult r1 = (coil3.fetch.SourceFetchResult) r1
            goto L_0x019b
        L_0x019a:
            r1 = r11
        L_0x019b:
            if (r1 == 0) goto L_0x01a8
            coil3.decode.ImageSource r1 = r1.getSource()
            if (r1 == 0) goto L_0x01a8
            java.lang.AutoCloseable r1 = (java.lang.AutoCloseable) r1
            coil3.util.UtilsKt.closeQuietly((java.lang.AutoCloseable) r1)
        L_0x01a8:
            T r0 = r0.element
            r5 = r0
            coil3.request.Options r5 = (coil3.request.Options) r5
            coil3.util.Logger r0 = r15.logger
            r7.L$0 = r11
            r7.L$1 = r11
            r7.L$2 = r11
            r7.L$3 = r11
            r7.L$4 = r11
            r7.L$5 = r11
            r7.L$6 = r11
            r7.L$7 = r11
            r7.label = r8
            r8 = r7
            r7 = r0
            java.lang.Object r0 = coil3.intercept.EngineInterceptorKt.transform(r3, r4, r5, r6, r7, r8)
            if (r0 != r9) goto L_0x01ca
        L_0x01c9:
            return r9
        L_0x01ca:
            return r0
        L_0x01cb:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0057 }
            r0.<init>()     // Catch:{ all -> 0x0057 }
            throw r0     // Catch:{ all -> 0x0057 }
        L_0x01d1:
            r0 = move-exception
            r2 = r13
        L_0x01d3:
            T r1 = r2.element
            boolean r2 = r1 instanceof coil3.fetch.SourceFetchResult
            if (r2 == 0) goto L_0x01dc
            r11 = r1
            coil3.fetch.SourceFetchResult r11 = (coil3.fetch.SourceFetchResult) r11
        L_0x01dc:
            if (r11 == 0) goto L_0x01e9
            coil3.decode.ImageSource r1 = r11.getSource()
            if (r1 == 0) goto L_0x01e9
            java.lang.AutoCloseable r1 = (java.lang.AutoCloseable) r1
            coil3.util.UtilsKt.closeQuietly((java.lang.AutoCloseable) r1)
        L_0x01e9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.execute(coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetch(coil3.ComponentRegistry r8, coil3.request.ImageRequest r9, java.lang.Object r10, coil3.request.Options r11, coil3.EventListener r12, kotlin.coroutines.Continuation<? super coil3.fetch.FetchResult> r13) {
        /*
            r7 = this;
            boolean r0 = r13 instanceof coil3.intercept.EngineInterceptor$fetch$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            coil3.intercept.EngineInterceptor$fetch$1 r0 = (coil3.intercept.EngineInterceptor$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            coil3.intercept.EngineInterceptor$fetch$1 r0 = new coil3.intercept.EngineInterceptor$fetch$1
            r0.<init>(r7, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$6
            coil3.fetch.Fetcher r9 = (coil3.fetch.Fetcher) r9
            java.lang.Object r10 = r0.L$5
            coil3.EventListener r10 = (coil3.EventListener) r10
            java.lang.Object r11 = r0.L$4
            coil3.request.Options r11 = (coil3.request.Options) r11
            java.lang.Object r12 = r0.L$3
            java.lang.Object r2 = r0.L$2
            coil3.request.ImageRequest r2 = (coil3.request.ImageRequest) r2
            java.lang.Object r4 = r0.L$1
            coil3.ComponentRegistry r4 = (coil3.ComponentRegistry) r4
            java.lang.Object r5 = r0.L$0
            coil3.intercept.EngineInterceptor r5 = (coil3.intercept.EngineInterceptor) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r0
            r0 = r8
            r8 = r4
            r4 = r6
            r6 = r2
            r2 = r9
            r9 = r6
            r6 = r12
            r12 = r10
            r10 = r6
            goto L_0x0096
        L_0x0050:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = 0
            r5 = r7
        L_0x005d:
            coil3.ImageLoader r2 = r5.imageLoader
            kotlin.Pair r13 = r8.newFetcher(r10, r11, r2, r13)
            if (r13 == 0) goto L_0x00b8
            java.lang.Object r2 = r13.getFirst()
            coil3.fetch.Fetcher r2 = (coil3.fetch.Fetcher) r2
            java.lang.Object r13 = r13.getSecond()
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            int r13 = r13 + r3
            r12.fetchStart(r9, r2, r11)
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r11
            r0.L$5 = r12
            r0.L$6 = r2
            r0.I$0 = r13
            r0.label = r3
            java.lang.Object r4 = r2.fetch(r0)
            if (r4 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r6 = r0
            r0 = r13
            r13 = r4
            r4 = r6
        L_0x0096:
            coil3.fetch.FetchResult r13 = (coil3.fetch.FetchResult) r13
            r12.fetchEnd(r9, r2, r11, r13)     // Catch:{ all -> 0x00a1 }
            if (r13 == 0) goto L_0x009e
            return r13
        L_0x009e:
            r13 = r0
            r0 = r4
            goto L_0x005d
        L_0x00a1:
            r8 = move-exception
            boolean r9 = r13 instanceof coil3.fetch.SourceFetchResult
            if (r9 == 0) goto L_0x00a9
            coil3.fetch.SourceFetchResult r13 = (coil3.fetch.SourceFetchResult) r13
            goto L_0x00aa
        L_0x00a9:
            r13 = 0
        L_0x00aa:
            if (r13 == 0) goto L_0x00b7
            coil3.decode.ImageSource r9 = r13.getSource()
            if (r9 == 0) goto L_0x00b7
            java.lang.AutoCloseable r9 = (java.lang.AutoCloseable) r9
            coil3.util.UtilsKt.closeQuietly((java.lang.AutoCloseable) r9)
        L_0x00b7:
            throw r8
        L_0x00b8:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Unable to create a fetcher that supports: "
            r8.<init>(r9)
            java.lang.StringBuilder r8 = r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.fetch(coil3.ComponentRegistry, coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object decode(coil3.fetch.SourceFetchResult r8, coil3.ComponentRegistry r9, coil3.request.ImageRequest r10, java.lang.Object r11, coil3.request.Options r12, coil3.EventListener r13, kotlin.coroutines.Continuation<? super coil3.intercept.EngineInterceptor.ExecuteResult> r14) {
        /*
            r7 = this;
            boolean r0 = r14 instanceof coil3.intercept.EngineInterceptor$decode$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            coil3.intercept.EngineInterceptor$decode$1 r0 = (coil3.intercept.EngineInterceptor$decode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            coil3.intercept.EngineInterceptor$decode$1 r0 = new coil3.intercept.EngineInterceptor$decode$1
            r0.<init>(r7, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x005c
            if (r2 != r3) goto L_0x0054
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$7
            coil3.decode.Decoder r9 = (coil3.decode.Decoder) r9
            java.lang.Object r10 = r0.L$6
            coil3.EventListener r10 = (coil3.EventListener) r10
            java.lang.Object r11 = r0.L$5
            coil3.request.Options r11 = (coil3.request.Options) r11
            java.lang.Object r12 = r0.L$4
            java.lang.Object r13 = r0.L$3
            coil3.request.ImageRequest r13 = (coil3.request.ImageRequest) r13
            java.lang.Object r2 = r0.L$2
            coil3.ComponentRegistry r2 = (coil3.ComponentRegistry) r2
            java.lang.Object r4 = r0.L$1
            coil3.fetch.SourceFetchResult r4 = (coil3.fetch.SourceFetchResult) r4
            java.lang.Object r5 = r0.L$0
            coil3.intercept.EngineInterceptor r5 = (coil3.intercept.EngineInterceptor) r5
            kotlin.ResultKt.throwOnFailure(r14)
            r6 = r0
            r0 = r8
            r8 = r4
            r4 = r6
            r6 = r13
            r13 = r10
            r10 = r6
            r6 = r12
            r12 = r11
            r11 = r6
            goto L_0x009f
        L_0x0054:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x005c:
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = 0
            r5 = r7
        L_0x0061:
            coil3.ImageLoader r2 = r5.imageLoader
            kotlin.Pair r14 = r9.newDecoder(r8, r12, r2, r14)
            if (r14 == 0) goto L_0x00cf
            java.lang.Object r2 = r14.getFirst()
            coil3.decode.Decoder r2 = (coil3.decode.Decoder) r2
            java.lang.Object r14 = r14.getSecond()
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            int r14 = r14 + r3
            r13.decodeStart(r10, r2, r12)
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r11
            r0.L$5 = r12
            r0.L$6 = r13
            r0.L$7 = r2
            r0.I$0 = r14
            r0.label = r3
            java.lang.Object r4 = r2.decode(r0)
            if (r4 != r1) goto L_0x0098
            return r1
        L_0x0098:
            r6 = r2
            r2 = r9
            r9 = r6
            r6 = r0
            r0 = r14
            r14 = r4
            r4 = r6
        L_0x009f:
            coil3.decode.DecodeResult r14 = (coil3.decode.DecodeResult) r14
            r13.decodeEnd(r10, r9, r12, r14)
            if (r14 == 0) goto L_0x00cb
            coil3.intercept.EngineInterceptor$ExecuteResult r9 = new coil3.intercept.EngineInterceptor$ExecuteResult
            coil3.Image r10 = r14.getImage()
            boolean r11 = r14.isSampled()
            coil3.decode.DataSource r12 = r8.getDataSource()
            coil3.decode.ImageSource r8 = r8.getSource()
            boolean r13 = r8 instanceof coil3.decode.FileImageSource
            r14 = 0
            if (r13 == 0) goto L_0x00c0
            coil3.decode.FileImageSource r8 = (coil3.decode.FileImageSource) r8
            goto L_0x00c1
        L_0x00c0:
            r8 = r14
        L_0x00c1:
            if (r8 == 0) goto L_0x00c7
            java.lang.String r14 = r8.getDiskCacheKey$coil_core_release()
        L_0x00c7:
            r9.<init>(r10, r11, r12, r14)
            return r9
        L_0x00cb:
            r14 = r0
            r9 = r2
            r0 = r4
            goto L_0x0061
        L_0x00cf:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Unable to create a decoder that supports: "
            r8.<init>(r9)
            java.lang.StringBuilder r8 = r8.append(r11)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.decode(coil3.fetch.SourceFetchResult, coil3.ComponentRegistry, coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "", "image", "Lcoil3/Image;", "isSampled", "", "dataSource", "Lcoil3/decode/DataSource;", "diskCacheKey", "", "<init>", "(Lcoil3/Image;ZLcoil3/decode/DataSource;Ljava/lang/String;)V", "getImage", "()Lcoil3/Image;", "()Z", "getDataSource", "()Lcoil3/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: EngineInterceptor.kt */
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Image image;
        private final boolean isSampled;

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Image image2, boolean z, DataSource dataSource2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                image2 = executeResult.image;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource2 = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(image2, z, dataSource2, str);
        }

        public final Image component1() {
            return this.image;
        }

        public final boolean component2() {
            return this.isSampled;
        }

        public final DataSource component3() {
            return this.dataSource;
        }

        public final String component4() {
            return this.diskCacheKey;
        }

        public final ExecuteResult copy(Image image2, boolean z, DataSource dataSource2, String str) {
            return new ExecuteResult(image2, z, dataSource2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExecuteResult)) {
                return false;
            }
            ExecuteResult executeResult = (ExecuteResult) obj;
            return Intrinsics.areEqual((Object) this.image, (Object) executeResult.image) && this.isSampled == executeResult.isSampled && this.dataSource == executeResult.dataSource && Intrinsics.areEqual((Object) this.diskCacheKey, (Object) executeResult.diskCacheKey);
        }

        public int hashCode() {
            int hashCode = ((((this.image.hashCode() * 31) + Boolean.hashCode(this.isSampled)) * 31) + this.dataSource.hashCode()) * 31;
            String str = this.diskCacheKey;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ExecuteResult(image=" + this.image + ", isSampled=" + this.isSampled + ", dataSource=" + this.dataSource + ", diskCacheKey=" + this.diskCacheKey + ')';
        }

        public ExecuteResult(Image image2, boolean z, DataSource dataSource2, String str) {
            this.image = image2;
            this.isSampled = z;
            this.dataSource = dataSource2;
            this.diskCacheKey = str;
        }

        public final Image getImage() {
            return this.image;
        }

        public final boolean isSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/intercept/EngineInterceptor$Companion;", "", "<init>", "()V", "TAG", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: EngineInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
