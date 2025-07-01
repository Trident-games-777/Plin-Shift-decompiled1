package coil3.intercept;

import coil3.EventListener;
import coil3.intercept.Interceptor;
import coil3.request.ImageRequest;
import coil3.request.NullRequestData;
import coil3.size.Size;
import coil3.size.SizeResolver;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010$\u001a\u00020%H@¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u00020(2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0006H\u0002J&\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010!¨\u0006+"}, d2 = {"Lcoil3/intercept/RealInterceptorChain;", "Lcoil3/intercept/Interceptor$Chain;", "initialRequest", "Lcoil3/request/ImageRequest;", "interceptors", "", "Lcoil3/intercept/Interceptor;", "index", "", "request", "size", "Lcoil3/size/Size;", "sizeResolver", "Lcoil3/size/SizeResolver;", "eventListener", "Lcoil3/EventListener;", "isPlaceholderCached", "", "<init>", "(Lcoil3/request/ImageRequest;Ljava/util/List;ILcoil3/request/ImageRequest;Lcoil3/size/Size;Lcoil3/size/SizeResolver;Lcoil3/EventListener;Z)V", "getInitialRequest", "()Lcoil3/request/ImageRequest;", "getInterceptors", "()Ljava/util/List;", "getIndex", "()I", "getRequest", "getSize", "()Lcoil3/size/Size;", "getSizeResolver", "()Lcoil3/size/SizeResolver;", "getEventListener", "()Lcoil3/EventListener;", "()Z", "withRequest", "withSize", "proceed", "Lcoil3/request/ImageResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkRequest", "", "interceptor", "copy", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RealInterceptorChain.kt */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final EventListener eventListener;
    private final int index;
    private final ImageRequest initialRequest;
    private final List<Interceptor> interceptors;
    private final boolean isPlaceholderCached;
    private final ImageRequest request;
    private final Size size;
    private final SizeResolver sizeResolver;

    public RealInterceptorChain(ImageRequest imageRequest, List<? extends Interceptor> list, int i, ImageRequest imageRequest2, Size size2, SizeResolver sizeResolver2, EventListener eventListener2, boolean z) {
        this.initialRequest = imageRequest;
        this.interceptors = list;
        this.index = i;
        this.request = imageRequest2;
        this.size = size2;
        this.sizeResolver = sizeResolver2;
        this.eventListener = eventListener2;
        this.isPlaceholderCached = z;
    }

    public final ImageRequest getInitialRequest() {
        return this.initialRequest;
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final int getIndex() {
        return this.index;
    }

    public ImageRequest getRequest() {
        return this.request;
    }

    public Size getSize() {
        return this.size;
    }

    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final EventListener getEventListener() {
        return this.eventListener;
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    public Interceptor.Chain withRequest(ImageRequest imageRequest) {
        int i = this.index;
        if (i > 0) {
            checkRequest(imageRequest, this.interceptors.get(i - 1));
        }
        return copy$default(this, 0, imageRequest, (Size) null, 5, (Object) null);
    }

    public Interceptor.Chain withSize(Size size2) {
        return copy$default(this, 0, (ImageRequest) null, size2, 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object proceed(kotlin.coroutines.Continuation<? super coil3.request.ImageResult> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof coil3.intercept.RealInterceptorChain$proceed$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            coil3.intercept.RealInterceptorChain$proceed$1 r0 = (coil3.intercept.RealInterceptorChain$proceed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            coil3.intercept.RealInterceptorChain$proceed$1 r0 = new coil3.intercept.RealInterceptorChain$proceed$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r1 = r0.L$1
            coil3.intercept.Interceptor r1 = (coil3.intercept.Interceptor) r1
            java.lang.Object r0 = r0.L$0
            coil3.intercept.RealInterceptorChain r0 = (coil3.intercept.RealInterceptorChain) r0
            kotlin.ResultKt.throwOnFailure(r11)
            r4 = r10
            goto L_0x0067
        L_0x0033:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List<coil3.intercept.Interceptor> r11 = r10.interceptors
            int r2 = r10.index
            java.lang.Object r11 = r11.get(r2)
            coil3.intercept.Interceptor r11 = (coil3.intercept.Interceptor) r11
            int r2 = r10.index
            int r5 = r2 + 1
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            r4 = r10
            coil3.intercept.RealInterceptorChain r2 = copy$default(r4, r5, r6, r7, r8, r9)
            coil3.intercept.Interceptor$Chain r2 = (coil3.intercept.Interceptor.Chain) r2
            r0.L$0 = r4
            r0.L$1 = r11
            r0.label = r3
            java.lang.Object r0 = r11.intercept(r2, r0)
            if (r0 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r1 = r11
            r11 = r0
            r0 = r4
        L_0x0067:
            coil3.request.ImageResult r11 = (coil3.request.ImageResult) r11
            coil3.request.ImageRequest r2 = r11.getRequest()
            r0.checkRequest(r2, r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.RealInterceptorChain.proceed(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void checkRequest(ImageRequest imageRequest, Interceptor interceptor) {
        if (imageRequest.getContext() != this.initialRequest.getContext()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
        } else if (imageRequest.getData() == NullRequestData.INSTANCE) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        } else if (imageRequest.getTarget() != this.initialRequest.getTarget()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
        } else if (imageRequest.getSizeResolver() != this.initialRequest.getSizeResolver()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
        }
    }

    static /* synthetic */ RealInterceptorChain copy$default(RealInterceptorChain realInterceptorChain, int i, ImageRequest imageRequest, Size size2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        if ((i2 & 2) != 0) {
            imageRequest = realInterceptorChain.getRequest();
        }
        if ((i2 & 4) != 0) {
            size2 = realInterceptorChain.getSize();
        }
        return realInterceptorChain.copy(i, imageRequest, size2);
    }

    private final RealInterceptorChain copy(int i, ImageRequest imageRequest, Size size2) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, i, imageRequest, size2, this.sizeResolver, this.eventListener, this.isPlaceholderCached);
    }
}
