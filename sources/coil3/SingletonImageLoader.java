package coil3;

import android.content.Context;
import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u0011\u001a\u00020\fH\u0007J\u0014\u0010\u0012\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0002R\u0011\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0004¨\u0006\u0014"}, d2 = {"Lcoil3/SingletonImageLoader;", "", "<init>", "()V", "reference", "Lkotlinx/atomicfu/AtomicRef;", "get", "Lcoil3/ImageLoader;", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "setSafe", "", "factory", "Lcoil3/SingletonImageLoader$Factory;", "setUnsafe", "imageLoader", "reset", "newImageLoader", "Factory", "coil_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SingletonImageLoader.kt */
public final class SingletonImageLoader {
    public static final SingletonImageLoader INSTANCE = new SingletonImageLoader();
    /* access modifiers changed from: private */
    public static final /* synthetic */ SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private singletonImageLoader$VolatileWrapper$atomicfu$private = new SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcoil3/SingletonImageLoader$Factory;", "", "newImageLoader", "Lcoil3/ImageLoader;", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "coil_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SingletonImageLoader.kt */
    public interface Factory {
        ImageLoader newImageLoader(Context context);
    }

    private final /* synthetic */ Object updateAndGet$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        Object invoke;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
            invoke = function1.invoke(obj2);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, obj2, invoke));
        return invoke;
    }

    private SingletonImageLoader() {
    }

    @JvmStatic
    public static final ImageLoader get(Context context) {
        Object obj = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.get(singletonImageLoader$VolatileWrapper$atomicfu$private);
        ImageLoader imageLoader = obj instanceof ImageLoader ? (ImageLoader) obj : null;
        return imageLoader == null ? INSTANCE.newImageLoader(context) : imageLoader;
    }

    @JvmStatic
    public static final void setSafe(Factory factory) {
        Object obj = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.get(singletonImageLoader$VolatileWrapper$atomicfu$private);
        if (!(obj instanceof ImageLoader)) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU, singletonImageLoader$VolatileWrapper$atomicfu$private, obj, factory);
        } else if (SingletonImageLoaderKt.isDefault((ImageLoader) obj)) {
            throw new IllegalStateException("The singleton image loader has already been created. This indicates that\n                    'setSafe' is being called after the first 'get' call. Ensure that 'setSafe' is\n                    called before any Coil API usages (e.g. `load`, `AsyncImage`,\n                    `rememberAsyncImagePainter`, etc.).".toString());
        }
    }

    @JvmStatic
    public static final void setUnsafe(ImageLoader imageLoader) {
        SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.set(singletonImageLoader$VolatileWrapper$atomicfu$private, imageLoader);
    }

    @JvmStatic
    public static final void setUnsafe(Factory factory) {
        SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.set(singletonImageLoader$VolatileWrapper$atomicfu$private, factory);
    }

    @JvmStatic
    public static final void reset() {
        SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU.set(singletonImageLoader$VolatileWrapper$atomicfu$private, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: coil3.SingletonImageLoader$Factory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: coil3.ImageLoader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final coil3.ImageLoader newImageLoader(android.content.Context r8) {
        /*
            r7 = this;
            coil3.SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private r0 = singletonImageLoader$VolatileWrapper$atomicfu$private
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = coil3.SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU
            r2 = 0
            r3 = r2
        L_0x000a:
            java.lang.Object r4 = r1.get(r0)
            boolean r5 = r4 instanceof coil3.ImageLoader
            if (r5 == 0) goto L_0x0019
            r5 = r4
            coil3.ImageLoader r5 = (coil3.ImageLoader) r5
            r6 = r5
            r5 = r3
            r3 = r6
            goto L_0x0040
        L_0x0019:
            if (r3 != 0) goto L_0x003f
            boolean r3 = r4 instanceof coil3.SingletonImageLoader.Factory
            if (r3 == 0) goto L_0x0023
            r3 = r4
            coil3.SingletonImageLoader$Factory r3 = (coil3.SingletonImageLoader.Factory) r3
            goto L_0x0024
        L_0x0023:
            r3 = r2
        L_0x0024:
            if (r3 == 0) goto L_0x002c
            coil3.ImageLoader r3 = r3.newImageLoader(r8)
            if (r3 != 0) goto L_0x003f
        L_0x002c:
            coil3.SingletonImageLoader$Factory r3 = coil3.SingletonImageLoader_androidKt.applicationImageLoaderFactory(r8)
            if (r3 == 0) goto L_0x0037
            coil3.ImageLoader r3 = r3.newImageLoader(r8)
            goto L_0x003f
        L_0x0037:
            coil3.SingletonImageLoader$Factory r3 = coil3.SingletonImageLoaderKt.DefaultSingletonImageLoaderFactory
            coil3.ImageLoader r3 = r3.newImageLoader(r8)
        L_0x003f:
            r5 = r3
        L_0x0040:
            boolean r4 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(r1, r0, r4, r3)
            if (r4 == 0) goto L_0x004c
            java.lang.String r8 = "null cannot be cast to non-null type coil3.ImageLoader"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r8)
            return r3
        L_0x004c:
            r3 = r5
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.SingletonImageLoader.newImageLoader(android.content.Context):coil3.ImageLoader");
    }
}
