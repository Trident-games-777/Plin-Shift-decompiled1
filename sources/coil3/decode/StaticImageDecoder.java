package coil3.decode;

import android.graphics.ImageDecoder;
import coil3.ImageLoader;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.util.BitmapsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH@¢\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcoil3/decode/StaticImageDecoder;", "Lcoil3/decode/Decoder;", "source", "Landroid/graphics/ImageDecoder$Source;", "closeable", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "options", "Lcoil3/request/Options;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "<init>", "(Landroid/graphics/ImageDecoder$Source;Ljava/lang/AutoCloseable;Lcoil3/request/Options;Lkotlinx/coroutines/sync/Semaphore;)V", "decode", "Lcoil3/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureImageDecoderProperties", "", "Landroid/graphics/ImageDecoder;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: StaticImageDecoder.kt */
public final class StaticImageDecoder implements Decoder {
    private final AutoCloseable closeable;
    /* access modifiers changed from: private */
    public final Options options;
    private final Semaphore parallelismLock;
    private final ImageDecoder.Source source;

    public StaticImageDecoder(ImageDecoder.Source source2, AutoCloseable autoCloseable, Options options2, Semaphore semaphore) {
        this.source = source2;
        this.closeable = autoCloseable;
        this.options = options2;
        this.parallelismLock = semaphore;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.jdk7.AutoCloseableKt.closeFinally(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        throw r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(kotlin.coroutines.Continuation<? super coil3.decode.DecodeResult> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil3.decode.StaticImageDecoder$decode$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            coil3.decode.StaticImageDecoder$decode$1 r0 = (coil3.decode.StaticImageDecoder$decode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            coil3.decode.StaticImageDecoder$decode$1 r0 = new coil3.decode.StaticImageDecoder$decode$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Semaphore r1 = (kotlinx.coroutines.sync.Semaphore) r1
            java.lang.Object r0 = r0.L$0
            coil3.decode.StaticImageDecoder r0 = (coil3.decode.StaticImageDecoder) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004e
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Semaphore r8 = r7.parallelismLock
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r0 = r8.acquire(r0)
            if (r0 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r0 = r7
            r1 = r8
        L_0x004e:
            java.lang.AutoCloseable r8 = r0.closeable     // Catch:{ all -> 0x007f }
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ all -> 0x0078 }
            r2.<init>()     // Catch:{ all -> 0x0078 }
            android.graphics.ImageDecoder$Source r4 = r0.source     // Catch:{ all -> 0x0078 }
            coil3.decode.StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1 r5 = new coil3.decode.StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1     // Catch:{ all -> 0x0078 }
            r5.<init>(r0, r2)     // Catch:{ all -> 0x0078 }
            android.graphics.ImageDecoder$OnHeaderDecodedListener r5 = (android.graphics.ImageDecoder.OnHeaderDecodedListener) r5     // Catch:{ all -> 0x0078 }
            android.graphics.Bitmap r0 = android.graphics.ImageDecoder.decodeBitmap(r4, r5)     // Catch:{ all -> 0x0078 }
            coil3.decode.DecodeResult r4 = new coil3.decode.DecodeResult     // Catch:{ all -> 0x0078 }
            r5 = 0
            r6 = 0
            coil3.BitmapImage r0 = coil3.Image_androidKt.asImage$default(r0, r5, r3, r6)     // Catch:{ all -> 0x0078 }
            coil3.Image r0 = (coil3.Image) r0     // Catch:{ all -> 0x0078 }
            boolean r2 = r2.element     // Catch:{ all -> 0x0078 }
            r4.<init>(r0, r2)     // Catch:{ all -> 0x0078 }
            kotlin.jdk7.AutoCloseableKt.closeFinally(r8, r6)     // Catch:{ all -> 0x007f }
            r1.release()
            return r4
        L_0x0078:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x007a }
        L_0x007a:
            r2 = move-exception
            kotlin.jdk7.AutoCloseableKt.closeFinally(r8, r0)     // Catch:{ all -> 0x007f }
            throw r2     // Catch:{ all -> 0x007f }
        L_0x007f:
            r8 = move-exception
            r1.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.decode.StaticImageDecoder.decode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void configureImageDecoderProperties(ImageDecoder imageDecoder) {
        imageDecoder.setAllocator(BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(this.options)) ? 3 : 1);
        imageDecoder.setMemorySizePolicy(ImageRequests_androidKt.getAllowRgb565(this.options) ^ true ? 1 : 0);
        if (ImageRequests_androidKt.getColorSpace(this.options) != null) {
            imageDecoder.setTargetColorSpace(ImageRequests_androidKt.getColorSpace(this.options));
        }
        imageDecoder.setUnpremultipliedRequired(!ImageRequests_androidKt.getPremultipliedAlpha(this.options));
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcoil3/decode/StaticImageDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "<init>", "(Lkotlinx/coroutines/sync/Semaphore;)V", "create", "Lcoil3/decode/Decoder;", "result", "Lcoil3/fetch/SourceFetchResult;", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: StaticImageDecoder.kt */
    public static final class Factory implements Decoder.Factory {
        private final Semaphore parallelismLock;

        public Factory() {
            this((Semaphore) null, 1, (DefaultConstructorMarker) null);
        }

        public Factory(Semaphore semaphore) {
            this.parallelismLock = semaphore;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(Semaphore semaphore, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SemaphoreKt.Semaphore$default(4, 0, 2, (Object) null) : semaphore);
        }

        public Decoder create(SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader) {
            ImageDecoder.Source imageDecoderSourceOrNull = StaticImageDecoderKt.toImageDecoderSourceOrNull(sourceFetchResult.getSource(), options, false);
            if (imageDecoderSourceOrNull == null) {
                return null;
            }
            return new StaticImageDecoder(imageDecoderSourceOrNull, sourceFetchResult.getSource(), options, this.parallelismLock);
        }
    }
}
