package coil3;

import android.content.Context;
import coil3.EventListener;
import coil3.ImageLoader;
import coil3.disk.DiskCache;
import coil3.intercept.EngineInterceptor;
import coil3.intercept.Interceptor;
import coil3.memory.MemoryCache;
import coil3.request.Disposable;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.RequestService;
import coil3.request.RequestService_androidKt;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.SystemCallbacksKt;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0016\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020&H@¢\u0006\u0002\u0010)J\u001e\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H@¢\u0006\u0002\u0010-J\b\u0010!\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016J\"\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\"\u00108\u001a\u00020.2\u0006\u00102\u001a\u0002092\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\u0018\u0010:\u001a\u00020.2\u0006\u0010%\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0002¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017*\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0002¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c*\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\t\u0010!\u001a\u00020\"X\u0004¨\u0006<"}, d2 = {"Lcoil3/RealImageLoader;", "Lcoil3/ImageLoader;", "options", "Lcoil3/RealImageLoader$Options;", "<init>", "(Lcoil3/RealImageLoader$Options;)V", "getOptions", "()Lcoil3/RealImageLoader$Options;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "requestService", "Lcoil3/request/RequestService;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "memoryCache", "Lcoil3/memory/MemoryCache;", "getMemoryCache$delegate", "(Lcoil3/RealImageLoader;)Ljava/lang/Object;", "getMemoryCache", "()Lcoil3/memory/MemoryCache;", "diskCache", "Lcoil3/disk/DiskCache;", "getDiskCache$delegate", "getDiskCache", "()Lcoil3/disk/DiskCache;", "components", "Lcoil3/ComponentRegistry;", "getComponents", "()Lcoil3/ComponentRegistry;", "shutdown", "Lkotlinx/atomicfu/AtomicBoolean;", "enqueue", "Lcoil3/request/Disposable;", "request", "Lcoil3/request/ImageRequest;", "execute", "Lcoil3/request/ImageResult;", "(Lcoil3/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialRequest", "type", "", "(Lcoil3/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "newBuilder", "Lcoil3/ImageLoader$Builder;", "onSuccess", "result", "Lcoil3/request/SuccessResult;", "target", "Lcoil3/target/Target;", "eventListener", "Lcoil3/EventListener;", "onError", "Lcoil3/request/ErrorResult;", "onCancel", "Options", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RealImageLoader.kt */
public final class RealImageLoader implements ImageLoader {
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicIntegerFieldUpdater shutdown$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(RealImageLoader.class, "shutdown$volatile");
    private final ComponentRegistry components;
    private final Options options;
    private final RequestService requestService;
    private final CoroutineScope scope;
    private volatile /* synthetic */ int shutdown$volatile = 0;
    private final SystemCallbacks systemCallbacks;

    private final /* synthetic */ int getShutdown$volatile() {
        return this.shutdown$volatile;
    }

    private final /* synthetic */ void setShutdown$volatile(int i) {
        this.shutdown$volatile = i;
    }

    public RealImageLoader(Options options2) {
        this.options = options2;
        this.scope = RealImageLoaderKt.CoroutineScope(options2.getLogger());
        SystemCallbacks SystemCallbacks = SystemCallbacksKt.SystemCallbacks(this);
        this.systemCallbacks = SystemCallbacks;
        ImageLoader imageLoader = this;
        RequestService RequestService = RequestService_androidKt.RequestService(imageLoader, SystemCallbacks, options2.getLogger());
        this.requestService = RequestService;
        options2.getMemoryCacheLazy();
        options2.getDiskCacheLazy();
        this.components = RealImageLoaderKt.addCommonComponents(RealImageLoader_nonNativeKt.addAppleComponents(RealImageLoader_jvmCommonKt.addJvmComponents(RealImageLoader_androidKt.addAndroidComponents(RealImageLoaderKt.addServiceLoaderComponents(options2.getComponentRegistry().newBuilder(), options2), options2), options2), options2)).add((Interceptor) new EngineInterceptor(imageLoader, SystemCallbacks, RequestService, options2.getLogger())).build();
    }

    public final Options getOptions() {
        return this.options;
    }

    public ImageRequest.Defaults getDefaults() {
        return this.options.getDefaults();
    }

    private static Object getMemoryCache$delegate(RealImageLoader realImageLoader) {
        return realImageLoader.options.getMemoryCacheLazy();
    }

    public MemoryCache getMemoryCache() {
        return this.options.getMemoryCacheLazy().getValue();
    }

    private static Object getDiskCache$delegate(RealImageLoader realImageLoader) {
        return realImageLoader.options.getDiskCacheLazy();
    }

    public DiskCache getDiskCache() {
        return this.options.getDiskCacheLazy().getValue();
    }

    public ComponentRegistry getComponents() {
        return this.components;
    }

    public Disposable enqueue(ImageRequest imageRequest) {
        return RealImageLoader_androidKt.getDisposable(imageRequest, BuildersKt__Builders_commonKt.async$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new RealImageLoader$enqueue$job$1(this, imageRequest, (Continuation<? super RealImageLoader$enqueue$job$1>) null), 3, (Object) null));
    }

    public Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        return RealImageLoader_androidKt.needsExecuteOnMainDispatcher(imageRequest) ? CoroutineScopeKt.coroutineScope(new RealImageLoader$execute$2(imageRequest, this, (Continuation<? super RealImageLoader$execute$2>) null), continuation) : execute(imageRequest, 1, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: coil3.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: coil3.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: coil3.request.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: coil3.RealImageLoader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v43, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: coil3.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: coil3.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v45, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: coil3.request.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: coil3.RealImageLoader} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0107, code lost:
        r0 = (r10 = r11.getMemoryCache()).get(r0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01d1 A[Catch:{ all -> 0x01e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01e0 A[SYNTHETIC, Splitter:B:110:0x01e0] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010d A[Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0112 A[Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0119 A[Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012d A[Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018d A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0198 A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object execute(coil3.request.ImageRequest r21, int r22, kotlin.coroutines.Continuation<? super coil3.request.ImageResult> r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r23
            boolean r3 = r2 instanceof coil3.RealImageLoader$execute$3
            if (r3 == 0) goto L_0x001a
            r3 = r2
            coil3.RealImageLoader$execute$3 r3 = (coil3.RealImageLoader$execute$3) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            coil3.RealImageLoader$execute$3 r3 = new coil3.RealImageLoader$execute$3
            r3.<init>(r1, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x009c
            if (r5 == r8) goto L_0x007d
            if (r5 == r7) goto L_0x0057
            if (r5 != r6) goto L_0x004f
            java.lang.Object r0 = r3.L$3
            r4 = r0
            coil3.EventListener r4 = (coil3.EventListener) r4
            java.lang.Object r0 = r3.L$2
            r5 = r0
            coil3.request.ImageRequest r5 = (coil3.request.ImageRequest) r5
            java.lang.Object r0 = r3.L$1
            r6 = r0
            coil3.request.RequestDelegate r6 = (coil3.request.RequestDelegate) r6
            java.lang.Object r0 = r3.L$0
            r3 = r0
            coil3.RealImageLoader r3 = (coil3.RealImageLoader) r3
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x004c }
            goto L_0x0187
        L_0x004c:
            r0 = move-exception
            goto L_0x01cd
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0057:
            java.lang.Object r0 = r3.L$5
            coil3.size.SizeResolver r0 = (coil3.size.SizeResolver) r0
            java.lang.Object r5 = r3.L$4
            coil3.Image r5 = (coil3.Image) r5
            java.lang.Object r7 = r3.L$3
            coil3.EventListener r7 = (coil3.EventListener) r7
            java.lang.Object r8 = r3.L$2
            coil3.request.ImageRequest r8 = (coil3.request.ImageRequest) r8
            java.lang.Object r10 = r3.L$1
            coil3.request.RequestDelegate r10 = (coil3.request.RequestDelegate) r10
            java.lang.Object r11 = r3.L$0
            coil3.RealImageLoader r11 = (coil3.RealImageLoader) r11
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x007a }
            r16 = r0
            r18 = r5
        L_0x0076:
            r13 = r8
            r14 = r11
            goto L_0x0157
        L_0x007a:
            r0 = move-exception
            r4 = r7
            goto L_0x0097
        L_0x007d:
            java.lang.Object r0 = r3.L$3
            r5 = r0
            coil3.EventListener r5 = (coil3.EventListener) r5
            java.lang.Object r0 = r3.L$2
            r8 = r0
            coil3.request.ImageRequest r8 = (coil3.request.ImageRequest) r8
            java.lang.Object r0 = r3.L$1
            r10 = r0
            coil3.request.RequestDelegate r10 = (coil3.request.RequestDelegate) r10
            java.lang.Object r0 = r3.L$0
            r11 = r0
            coil3.RealImageLoader r11 = (coil3.RealImageLoader) r11
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0095 }
            goto L_0x00f6
        L_0x0095:
            r0 = move-exception
            r4 = r5
        L_0x0097:
            r5 = r8
            r6 = r10
        L_0x0099:
            r3 = r11
            goto L_0x01cd
        L_0x009c:
            kotlin.ResultKt.throwOnFailure(r2)
            coil3.request.RequestService r2 = r1.requestService
            kotlin.coroutines.CoroutineContext r5 = r3.getContext()
            kotlinx.coroutines.Job r5 = kotlinx.coroutines.JobKt.getJob(r5)
            if (r22 != 0) goto L_0x00ad
            r10 = r8
            goto L_0x00ae
        L_0x00ad:
            r10 = 0
        L_0x00ae:
            coil3.request.RequestDelegate r2 = r2.requestDelegate(r0, r5, r10)
            r2.assertActive()
            coil3.request.ImageRequest$Builder r0 = coil3.request.ImageRequest.newBuilder$default(r0, r9, r8, r9)
            coil3.request.ImageRequest$Defaults r5 = r1.getDefaults()
            coil3.request.ImageRequest$Builder r0 = r0.defaults(r5)
            coil3.request.ImageRequest r5 = r0.build()
            coil3.RealImageLoader$Options r0 = r1.options
            coil3.EventListener$Factory r0 = r0.getEventListenerFactory()
            coil3.EventListener r10 = r0.create(r5)
            java.lang.Object r0 = r5.getData()     // Catch:{ all -> 0x01c9 }
            coil3.request.NullRequestData r11 = coil3.request.NullRequestData.INSTANCE     // Catch:{ all -> 0x01c9 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r11)     // Catch:{ all -> 0x01c9 }
            if (r0 != 0) goto L_0x01c3
            r2.start()     // Catch:{ all -> 0x01c9 }
            if (r22 != 0) goto L_0x00f8
            r3.L$0 = r1     // Catch:{ all -> 0x01c9 }
            r3.L$1 = r2     // Catch:{ all -> 0x01c9 }
            r3.L$2 = r5     // Catch:{ all -> 0x01c9 }
            r3.L$3 = r10     // Catch:{ all -> 0x01c9 }
            r3.label = r8     // Catch:{ all -> 0x01c9 }
            java.lang.Object r0 = r2.awaitStarted(r3)     // Catch:{ all -> 0x01c9 }
            if (r0 != r4) goto L_0x00f2
            goto L_0x0182
        L_0x00f2:
            r11 = r1
            r8 = r5
            r5 = r10
            r10 = r2
        L_0x00f6:
            r2 = r10
            goto L_0x00fb
        L_0x00f8:
            r11 = r1
            r8 = r5
            r5 = r10
        L_0x00fb:
            coil3.memory.MemoryCache$Key r0 = r8.getPlaceholderMemoryCacheKey()     // Catch:{ all -> 0x01bd }
            if (r0 == 0) goto L_0x0112
            coil3.memory.MemoryCache r10 = r11.getMemoryCache()     // Catch:{ all -> 0x01bd }
            if (r10 == 0) goto L_0x0112
            coil3.memory.MemoryCache$Value r0 = r10.get(r0)     // Catch:{ all -> 0x01bd }
            if (r0 == 0) goto L_0x0112
            coil3.Image r0 = r0.getImage()     // Catch:{ all -> 0x01bd }
            goto L_0x0113
        L_0x0112:
            r0 = r9
        L_0x0113:
            coil3.target.Target r10 = r8.getTarget()     // Catch:{ all -> 0x01bd }
            if (r10 == 0) goto L_0x0124
            if (r0 != 0) goto L_0x0120
            coil3.Image r12 = r8.placeholder()     // Catch:{ all -> 0x01bd }
            goto L_0x0121
        L_0x0120:
            r12 = r0
        L_0x0121:
            r10.onStart(r12)     // Catch:{ all -> 0x01bd }
        L_0x0124:
            r5.onStart(r8)     // Catch:{ all -> 0x01bd }
            coil3.request.ImageRequest$Listener r10 = r8.getListener()     // Catch:{ all -> 0x01bd }
            if (r10 == 0) goto L_0x0130
            r10.onStart(r8)     // Catch:{ all -> 0x01bd }
        L_0x0130:
            coil3.request.RequestService r10 = r11.requestService     // Catch:{ all -> 0x01bd }
            coil3.size.SizeResolver r10 = r10.sizeResolver(r8)     // Catch:{ all -> 0x01bd }
            r5.resolveSizeStart(r8, r10)     // Catch:{ all -> 0x01bd }
            r3.L$0 = r11     // Catch:{ all -> 0x01bd }
            r3.L$1 = r2     // Catch:{ all -> 0x01bd }
            r3.L$2 = r8     // Catch:{ all -> 0x01bd }
            r3.L$3 = r5     // Catch:{ all -> 0x01bd }
            r3.L$4 = r0     // Catch:{ all -> 0x01bd }
            r3.L$5 = r10     // Catch:{ all -> 0x01bd }
            r3.label = r7     // Catch:{ all -> 0x01bd }
            java.lang.Object r7 = r10.size(r3)     // Catch:{ all -> 0x01bd }
            if (r7 != r4) goto L_0x014e
            goto L_0x0182
        L_0x014e:
            r18 = r0
            r16 = r10
            r10 = r2
            r2 = r7
            r7 = r5
            goto L_0x0076
        L_0x0157:
            r15 = r2
            coil3.size.Size r15 = (coil3.size.Size) r15     // Catch:{ all -> 0x01b6 }
            r7.resolveSizeEnd(r13, r15)     // Catch:{ all -> 0x01b6 }
            kotlin.coroutines.CoroutineContext r0 = r13.getInterceptorCoroutineContext()     // Catch:{ all -> 0x01b6 }
            coil3.RealImageLoader$execute$result$1 r12 = new coil3.RealImageLoader$execute$result$1     // Catch:{ all -> 0x01b6 }
            r19 = 0
            r17 = r7
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x01b2 }
            r5 = r17
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12     // Catch:{ all -> 0x01b0 }
            r3.L$0 = r14     // Catch:{ all -> 0x01b0 }
            r3.L$1 = r10     // Catch:{ all -> 0x01b0 }
            r3.L$2 = r13     // Catch:{ all -> 0x01b0 }
            r3.L$3 = r5     // Catch:{ all -> 0x01b0 }
            r3.L$4 = r9     // Catch:{ all -> 0x01b0 }
            r3.L$5 = r9     // Catch:{ all -> 0x01b0 }
            r3.label = r6     // Catch:{ all -> 0x01b0 }
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r0, r12, r3)     // Catch:{ all -> 0x01b0 }
            if (r2 != r4) goto L_0x0183
        L_0x0182:
            return r4
        L_0x0183:
            r4 = r5
            r6 = r10
            r5 = r13
            r3 = r14
        L_0x0187:
            coil3.request.ImageResult r2 = (coil3.request.ImageResult) r2     // Catch:{ all -> 0x004c }
            boolean r0 = r2 instanceof coil3.request.SuccessResult     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0198
            r0 = r2
            coil3.request.SuccessResult r0 = (coil3.request.SuccessResult) r0     // Catch:{ all -> 0x004c }
            coil3.target.Target r7 = r5.getTarget()     // Catch:{ all -> 0x004c }
            r3.onSuccess(r0, r7, r4)     // Catch:{ all -> 0x004c }
            goto L_0x01a6
        L_0x0198:
            boolean r0 = r2 instanceof coil3.request.ErrorResult     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x01aa
            r0 = r2
            coil3.request.ErrorResult r0 = (coil3.request.ErrorResult) r0     // Catch:{ all -> 0x004c }
            coil3.target.Target r7 = r5.getTarget()     // Catch:{ all -> 0x004c }
            r3.onError(r0, r7, r4)     // Catch:{ all -> 0x004c }
        L_0x01a6:
            r6.complete()
            return r2
        L_0x01aa:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x004c }
            r0.<init>()     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x01b0:
            r0 = move-exception
            goto L_0x01b8
        L_0x01b2:
            r0 = move-exception
            r5 = r17
            goto L_0x01b8
        L_0x01b6:
            r0 = move-exception
            r5 = r7
        L_0x01b8:
            r4 = r5
            r6 = r10
            r5 = r13
            r3 = r14
            goto L_0x01cd
        L_0x01bd:
            r0 = move-exception
            r6 = r2
            r4 = r5
            r5 = r8
            goto L_0x0099
        L_0x01c3:
            coil3.request.NullRequestDataException r0 = new coil3.request.NullRequestDataException     // Catch:{ all -> 0x01c9 }
            r0.<init>()     // Catch:{ all -> 0x01c9 }
            throw r0     // Catch:{ all -> 0x01c9 }
        L_0x01c9:
            r0 = move-exception
            r3 = r1
            r6 = r2
            r4 = r10
        L_0x01cd:
            boolean r2 = r0 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x01e4 }
            if (r2 != 0) goto L_0x01e0
            coil3.request.ErrorResult r0 = coil3.util.UtilsKt.ErrorResult(r5, r0)     // Catch:{ all -> 0x01e4 }
            coil3.target.Target r2 = r5.getTarget()     // Catch:{ all -> 0x01e4 }
            r3.onError(r0, r2, r4)     // Catch:{ all -> 0x01e4 }
            r6.complete()
            return r0
        L_0x01e0:
            r3.onCancel(r5, r4)     // Catch:{ all -> 0x01e4 }
            throw r0     // Catch:{ all -> 0x01e4 }
        L_0x01e4:
            r0 = move-exception
            r6.complete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.RealImageLoader.execute(coil3.request.ImageRequest, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void shutdown() {
        if (shutdown$volatile$FU.getAndSet(this, 1) == 0) {
            CoroutineScopeKt.cancel$default(this.scope, (CancellationException) null, 1, (Object) null);
            this.systemCallbacks.shutdown();
            MemoryCache memoryCache = getMemoryCache();
            if (memoryCache != null) {
                memoryCache.clear();
            }
        }
    }

    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this.options);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0056, code lost:
        if (r8 != null) goto L_0x006f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onSuccess(coil3.request.SuccessResult r7, coil3.target.Target r8, coil3.EventListener r9) {
        /*
            r6 = this;
            coil3.request.ImageRequest r0 = r7.getRequest()
            coil3.decode.DataSource r1 = r7.getDataSource()
            coil3.RealImageLoader$Options r2 = r6.options
            coil3.util.Logger r2 = r2.getLogger()
            if (r2 == 0) goto L_0x0052
            coil3.util.Logger$Level r3 = coil3.util.Logger.Level.Info
            coil3.util.Logger$Level r4 = r2.getMinLevel()
            r5 = r3
            java.lang.Enum r5 = (java.lang.Enum) r5
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L_0x0052
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = coil3.util.UtilsKt.getEmoji(r1)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = " Successful ("
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r1 = r1.name()
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r4 = ") - "
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.Object r4 = r0.getData()
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r2.log(r5, r3, r1, r4)
        L_0x0052:
            boolean r1 = r8 instanceof coil3.transition.TransitionTarget
            if (r1 != 0) goto L_0x0059
            if (r8 == 0) goto L_0x0088
            goto L_0x006f
        L_0x0059:
            r1 = r7
            coil3.request.ImageResult r1 = (coil3.request.ImageResult) r1
            coil3.request.ImageRequest r2 = r1.getRequest()
            coil3.transition.Transition$Factory r2 = coil3.request.ImageRequests_androidKt.getTransitionFactory((coil3.request.ImageRequest) r2)
            r3 = r8
            coil3.transition.TransitionTarget r3 = (coil3.transition.TransitionTarget) r3
            coil3.transition.Transition r2 = r2.create(r3, r1)
            boolean r3 = r2 instanceof coil3.transition.NoneTransition
            if (r3 == 0) goto L_0x0077
        L_0x006f:
            coil3.Image r1 = r7.getImage()
            r8.onSuccess(r1)
            goto L_0x0088
        L_0x0077:
            coil3.request.ImageRequest r8 = r1.getRequest()
            r9.transitionStart(r8, r2)
            r2.transition()
            coil3.request.ImageRequest r8 = r1.getRequest()
            r9.transitionEnd(r8, r2)
        L_0x0088:
            r9.onSuccess(r0, r7)
            coil3.request.ImageRequest$Listener r8 = r0.getListener()
            if (r8 == 0) goto L_0x0094
            r8.onSuccess(r0, r7)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.RealImageLoader.onSuccess(coil3.request.SuccessResult, coil3.target.Target, coil3.EventListener):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0046, code lost:
        if (r8 != null) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onError(coil3.request.ErrorResult r7, coil3.target.Target r8, coil3.EventListener r9) {
        /*
            r6 = this;
            coil3.request.ImageRequest r0 = r7.getRequest()
            coil3.RealImageLoader$Options r1 = r6.options
            coil3.util.Logger r1 = r1.getLogger()
            if (r1 == 0) goto L_0x0042
            coil3.util.Logger$Level r2 = coil3.util.Logger.Level.Info
            coil3.util.Logger$Level r3 = r1.getMinLevel()
            r4 = r2
            java.lang.Enum r4 = (java.lang.Enum) r4
            int r3 = r3.compareTo(r4)
            if (r3 > 0) goto L_0x0042
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "🚨 Failed - "
            r3.<init>(r4)
            java.lang.Object r4 = r0.getData()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = " - "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.Throwable r4 = r7.getThrowable()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r1.log(r5, r2, r3, r4)
        L_0x0042:
            boolean r1 = r8 instanceof coil3.transition.TransitionTarget
            if (r1 != 0) goto L_0x0049
            if (r8 == 0) goto L_0x0078
            goto L_0x005f
        L_0x0049:
            r1 = r7
            coil3.request.ImageResult r1 = (coil3.request.ImageResult) r1
            coil3.request.ImageRequest r2 = r1.getRequest()
            coil3.transition.Transition$Factory r2 = coil3.request.ImageRequests_androidKt.getTransitionFactory((coil3.request.ImageRequest) r2)
            r3 = r8
            coil3.transition.TransitionTarget r3 = (coil3.transition.TransitionTarget) r3
            coil3.transition.Transition r2 = r2.create(r3, r1)
            boolean r3 = r2 instanceof coil3.transition.NoneTransition
            if (r3 == 0) goto L_0x0067
        L_0x005f:
            coil3.Image r1 = r7.getImage()
            r8.onError(r1)
            goto L_0x0078
        L_0x0067:
            coil3.request.ImageRequest r8 = r1.getRequest()
            r9.transitionStart(r8, r2)
            r2.transition()
            coil3.request.ImageRequest r8 = r1.getRequest()
            r9.transitionEnd(r8, r2)
        L_0x0078:
            r9.onError(r0, r7)
            coil3.request.ImageRequest$Listener r8 = r0.getListener()
            if (r8 == 0) goto L_0x0084
            r8.onError(r0, r7)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.RealImageLoader.onError(coil3.request.ErrorResult, coil3.target.Target, coil3.EventListener):void");
    }

    private final void onCancel(ImageRequest imageRequest, EventListener eventListener) {
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Logger.Level level = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, "🏗 Cancelled - " + imageRequest.getData(), (Throwable) null);
            }
        }
        eventListener.onCancel(imageRequest);
        ImageRequest.Listener listener = imageRequest.getListener();
        if (listener != null) {
            listener.onCancel(imageRequest);
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BU\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\"\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jj\u0010)\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcoil3/RealImageLoader$Options;", "", "application", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil3/memory/MemoryCache;", "diskCacheLazy", "Lcoil3/disk/DiskCache;", "eventListenerFactory", "Lcoil3/EventListener$Factory;", "componentRegistry", "Lcoil3/ComponentRegistry;", "logger", "Lcoil3/util/Logger;", "<init>", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)V", "getApplication", "()Landroid/content/Context;", "Landroid/content/Context;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "getMemoryCacheLazy", "()Lkotlin/Lazy;", "getDiskCacheLazy", "getEventListenerFactory", "()Lcoil3/EventListener$Factory;", "getComponentRegistry", "()Lcoil3/ComponentRegistry;", "getLogger", "()Lcoil3/util/Logger;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)Lcoil3/RealImageLoader$Options;", "equals", "", "other", "hashCode", "", "toString", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: RealImageLoader.kt */
    public static final class Options {
        private final Context application;
        private final ComponentRegistry componentRegistry;
        private final ImageRequest.Defaults defaults;
        private final Lazy<DiskCache> diskCacheLazy;
        private final EventListener.Factory eventListenerFactory;
        private final Logger logger;
        private final Lazy<MemoryCache> memoryCacheLazy;

        public static /* synthetic */ Options copy$default(Options options, Context context, ImageRequest.Defaults defaults2, Lazy<MemoryCache> lazy, Lazy<DiskCache> lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry2, Logger logger2, int i, Object obj) {
            if ((i & 1) != 0) {
                context = options.application;
            }
            if ((i & 2) != 0) {
                defaults2 = options.defaults;
            }
            if ((i & 4) != 0) {
                lazy = options.memoryCacheLazy;
            }
            if ((i & 8) != 0) {
                lazy2 = options.diskCacheLazy;
            }
            if ((i & 16) != 0) {
                factory = options.eventListenerFactory;
            }
            if ((i & 32) != 0) {
                componentRegistry2 = options.componentRegistry;
            }
            if ((i & 64) != 0) {
                logger2 = options.logger;
            }
            ComponentRegistry componentRegistry3 = componentRegistry2;
            Logger logger3 = logger2;
            Lazy<DiskCache> lazy3 = lazy2;
            EventListener.Factory factory2 = factory;
            return options.copy(context, defaults2, lazy, lazy3, factory2, componentRegistry3, logger3);
        }

        public final Context component1() {
            return this.application;
        }

        public final ImageRequest.Defaults component2() {
            return this.defaults;
        }

        public final Lazy<MemoryCache> component3() {
            return this.memoryCacheLazy;
        }

        public final Lazy<DiskCache> component4() {
            return this.diskCacheLazy;
        }

        public final EventListener.Factory component5() {
            return this.eventListenerFactory;
        }

        public final ComponentRegistry component6() {
            return this.componentRegistry;
        }

        public final Logger component7() {
            return this.logger;
        }

        public final Options copy(Context context, ImageRequest.Defaults defaults2, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry2, Logger logger2) {
            return new Options(context, defaults2, lazy, lazy2, factory, componentRegistry2, logger2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Options)) {
                return false;
            }
            Options options = (Options) obj;
            return Intrinsics.areEqual((Object) this.application, (Object) options.application) && Intrinsics.areEqual((Object) this.defaults, (Object) options.defaults) && Intrinsics.areEqual((Object) this.memoryCacheLazy, (Object) options.memoryCacheLazy) && Intrinsics.areEqual((Object) this.diskCacheLazy, (Object) options.diskCacheLazy) && Intrinsics.areEqual((Object) this.eventListenerFactory, (Object) options.eventListenerFactory) && Intrinsics.areEqual((Object) this.componentRegistry, (Object) options.componentRegistry) && Intrinsics.areEqual((Object) this.logger, (Object) options.logger);
        }

        public int hashCode() {
            int hashCode = ((((((((((this.application.hashCode() * 31) + this.defaults.hashCode()) * 31) + this.memoryCacheLazy.hashCode()) * 31) + this.diskCacheLazy.hashCode()) * 31) + this.eventListenerFactory.hashCode()) * 31) + this.componentRegistry.hashCode()) * 31;
            Logger logger2 = this.logger;
            return hashCode + (logger2 == null ? 0 : logger2.hashCode());
        }

        public String toString() {
            return "Options(application=" + this.application + ", defaults=" + this.defaults + ", memoryCacheLazy=" + this.memoryCacheLazy + ", diskCacheLazy=" + this.diskCacheLazy + ", eventListenerFactory=" + this.eventListenerFactory + ", componentRegistry=" + this.componentRegistry + ", logger=" + this.logger + ')';
        }

        public Options(Context context, ImageRequest.Defaults defaults2, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry2, Logger logger2) {
            this.application = context;
            this.defaults = defaults2;
            this.memoryCacheLazy = lazy;
            this.diskCacheLazy = lazy2;
            this.eventListenerFactory = factory;
            this.componentRegistry = componentRegistry2;
            this.logger = logger2;
        }

        public final Context getApplication() {
            return this.application;
        }

        public final ImageRequest.Defaults getDefaults() {
            return this.defaults;
        }

        public final Lazy<MemoryCache> getMemoryCacheLazy() {
            return this.memoryCacheLazy;
        }

        public final Lazy<DiskCache> getDiskCacheLazy() {
            return this.diskCacheLazy;
        }

        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        public final ComponentRegistry getComponentRegistry() {
            return this.componentRegistry;
        }

        public final Logger getLogger() {
            return this.logger;
        }
    }
}
