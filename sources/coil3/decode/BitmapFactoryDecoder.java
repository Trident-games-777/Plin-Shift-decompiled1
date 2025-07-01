package coil3.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import coil3.ImageLoader;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.util.BitmapsKt;
import coil3.util.IntPair;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0003\u0015\u0016\u0017B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH@¢\u0006\u0002\u0010\u000eJ\f\u0010\f\u001a\u00020\r*\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder;", "Lcoil3/decode/Decoder;", "source", "Lcoil3/decode/ImageSource;", "options", "Lcoil3/request/Options;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "exifOrientationStrategy", "Lcoil3/decode/ExifOrientationStrategy;", "<init>", "(Lcoil3/decode/ImageSource;Lcoil3/request/Options;Lkotlinx/coroutines/sync/Semaphore;Lcoil3/decode/ExifOrientationStrategy;)V", "decode", "Lcoil3/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/BitmapFactory$Options;", "configureConfig", "", "exifData", "Lcoil3/decode/ExifData;", "configureScale", "Factory", "ExceptionCatchingSource", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: BitmapFactoryDecoder.kt */
public final class BitmapFactoryDecoder implements Decoder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_MAX_PARALLELISM = 4;
    private final ExifOrientationStrategy exifOrientationStrategy;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageSource source;

    public BitmapFactoryDecoder(ImageSource imageSource, Options options2, Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy2) {
        this.source = imageSource;
        this.options = options2;
        this.parallelismLock = semaphore;
        this.exifOrientationStrategy = exifOrientationStrategy2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options2, Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options2, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, (Object) null) : semaphore, (i & 8) != 0 ? ExifOrientationStrategy.RESPECT_PERFORMANCE : exifOrientationStrategy2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(kotlin.coroutines.Continuation<? super coil3.decode.DecodeResult> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil3.decode.BitmapFactoryDecoder$decode$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            coil3.decode.BitmapFactoryDecoder$decode$1 r0 = (coil3.decode.BitmapFactoryDecoder$decode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            coil3.decode.BitmapFactoryDecoder$decode$1 r0 = new coil3.decode.BitmapFactoryDecoder$decode$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Semaphore r0 = (kotlinx.coroutines.sync.Semaphore) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0031 }
            goto L_0x0071
        L_0x0031:
            r8 = move-exception
            goto L_0x007b
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003b:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Semaphore r2 = (kotlinx.coroutines.sync.Semaphore) r2
            java.lang.Object r5 = r0.L$0
            coil3.decode.BitmapFactoryDecoder r5 = (coil3.decode.BitmapFactoryDecoder) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r2
            goto L_0x005b
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Semaphore r8 = r7.parallelismLock
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.acquire(r0)
            if (r2 != r1) goto L_0x005a
            goto L_0x006d
        L_0x005a:
            r5 = r7
        L_0x005b:
            coil3.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda0 r2 = new coil3.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda0     // Catch:{ all -> 0x0077 }
            r2.<init>(r5)     // Catch:{ all -> 0x0077 }
            r0.L$0 = r8     // Catch:{ all -> 0x0077 }
            r5 = 0
            r0.L$1 = r5     // Catch:{ all -> 0x0077 }
            r0.label = r3     // Catch:{ all -> 0x0077 }
            java.lang.Object r0 = kotlinx.coroutines.InterruptibleKt.runInterruptible$default(r5, r2, r0, r4, r5)     // Catch:{ all -> 0x0077 }
            if (r0 != r1) goto L_0x006e
        L_0x006d:
            return r1
        L_0x006e:
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x0071:
            coil3.decode.DecodeResult r8 = (coil3.decode.DecodeResult) r8     // Catch:{ all -> 0x0031 }
            r0.release()
            return r8
        L_0x0077:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x007b:
            r0.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.decode.BitmapFactoryDecoder.decode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final DecodeResult decode$lambda$1$lambda$0(BitmapFactoryDecoder bitmapFactoryDecoder) {
        return bitmapFactoryDecoder.decode(new BitmapFactory.Options());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c2, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c5, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final coil3.decode.DecodeResult decode(android.graphics.BitmapFactory.Options r9) {
        /*
            r8 = this;
            coil3.decode.BitmapFactoryDecoder$ExceptionCatchingSource r0 = new coil3.decode.BitmapFactoryDecoder$ExceptionCatchingSource
            coil3.decode.ImageSource r1 = r8.source
            okio.BufferedSource r1 = r1.source()
            okio.Source r1 = (okio.Source) r1
            r0.<init>(r1)
            r1 = r0
            okio.Source r1 = (okio.Source) r1
            okio.BufferedSource r1 = okio.Okio.buffer((okio.Source) r1)
            r2 = 1
            r9.inJustDecodeBounds = r2
            okio.BufferedSource r3 = r1.peek()
            java.io.InputStream r3 = r3.inputStream()
            r4 = 0
            android.graphics.BitmapFactory.decodeStream(r3, r4, r9)
            java.lang.Exception r3 = r0.getException()
            if (r3 != 0) goto L_0x00c7
            r3 = 0
            r9.inJustDecodeBounds = r3
            coil3.decode.ExifUtils r5 = coil3.decode.ExifUtils.INSTANCE
            java.lang.String r6 = r9.outMimeType
            coil3.decode.ExifOrientationStrategy r7 = r8.exifOrientationStrategy
            coil3.decode.ExifData r5 = r5.getExifData(r6, r1, r7)
            java.lang.Exception r6 = r0.getException()
            if (r6 != 0) goto L_0x00c6
            r9.inMutable = r3
            coil3.request.Options r6 = r8.options
            android.graphics.ColorSpace r6 = coil3.request.ImageRequests_androidKt.getColorSpace((coil3.request.Options) r6)
            if (r6 == 0) goto L_0x004e
            coil3.request.Options r6 = r8.options
            android.graphics.ColorSpace r6 = coil3.request.ImageRequests_androidKt.getColorSpace((coil3.request.Options) r6)
            r9.inPreferredColorSpace = r6
        L_0x004e:
            coil3.request.Options r6 = r8.options
            boolean r6 = coil3.request.ImageRequests_androidKt.getPremultipliedAlpha((coil3.request.Options) r6)
            r9.inPremultiplied = r6
            r8.configureConfig(r9, r5)
            r8.configureScale(r9, r5)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r6 = r1
            okio.BufferedSource r6 = (okio.BufferedSource) r6     // Catch:{ all -> 0x00bf }
            java.io.InputStream r6 = r6.inputStream()     // Catch:{ all -> 0x00bf }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r6, r4, r9)     // Catch:{ all -> 0x00bf }
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            java.lang.Exception r0 = r0.getException()
            if (r0 != 0) goto L_0x00be
            if (r6 == 0) goto L_0x00b2
            coil3.request.Options r0 = r8.options
            android.content.Context r0 = r0.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.densityDpi
            r6.setDensity(r0)
            coil3.decode.ExifUtils r0 = coil3.decode.ExifUtils.INSTANCE
            android.graphics.Bitmap r0 = r0.reverseTransformations(r6, r5)
            coil3.decode.DecodeResult r1 = new coil3.decode.DecodeResult
            coil3.request.Options r4 = r8.options
            android.content.Context r4 = r4.getContext()
            android.content.res.Resources r4 = r4.getResources()
            android.graphics.drawable.BitmapDrawable r5 = new android.graphics.drawable.BitmapDrawable
            r5.<init>(r4, r0)
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
            coil3.Image r0 = coil3.Image_androidKt.asImage((android.graphics.drawable.Drawable) r5)
            int r4 = r9.inSampleSize
            if (r4 > r2) goto L_0x00ae
            boolean r9 = r9.inScaled
            if (r9 == 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r2 = r3
        L_0x00ae:
            r1.<init>(r0, r2)
            return r1
        L_0x00b2:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the image source (e.g. network, disk, or memory) as it's not encoded as a valid image format."
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x00be:
            throw r0
        L_0x00bf:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r9)
            throw r0
        L_0x00c6:
            throw r6
        L_0x00c7:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.decode.BitmapFactoryDecoder.decode(android.graphics.BitmapFactory$Options):coil3.decode.DecodeResult");
    }

    private final void configureConfig(BitmapFactory.Options options2, ExifData exifData) {
        Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(this.options);
        if (exifData.isFlipped() || ExifUtilsKt.isRotated(exifData)) {
            bitmapConfig = BitmapsKt.toSoftware(bitmapConfig);
        }
        if (ImageRequests_androidKt.getAllowRgb565(this.options) && bitmapConfig == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual((Object) options2.outMimeType, (Object) UtilsKt.MIME_TYPE_JPEG)) {
            bitmapConfig = Bitmap.Config.RGB_565;
        }
        if (options2.outConfig == Bitmap.Config.RGBA_F16 && bitmapConfig != Bitmap.Config.HARDWARE) {
            bitmapConfig = Bitmap.Config.RGBA_F16;
        }
        options2.inPreferredConfig = bitmapConfig;
    }

    private final void configureScale(BitmapFactory.Options options2, ExifData exifData) {
        BitmapFactory.Options options3 = options2;
        boolean z = false;
        if (options3.outWidth <= 0 || options3.outHeight <= 0) {
            options3.inSampleSize = 1;
            options3.inScaled = false;
            return;
        }
        int i = ExifUtilsKt.isSwapped(exifData) ? options3.outHeight : options3.outWidth;
        int i2 = ExifUtilsKt.isSwapped(exifData) ? options3.outWidth : options3.outHeight;
        long r6 = DecodeUtils.m7499computeDstSizesEdh43o(i, i2, this.options.getSize(), this.options.getScale(), ImageRequestsKt.getMaxBitmapSize(this.options));
        int r8 = IntPair.m7557getFirstimpl(r6);
        int r62 = IntPair.m7558getSecondimpl(r6);
        options3.inSampleSize = DecodeUtils.calculateInSampleSize(i, i2, r8, r62, this.options.getScale());
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(((double) i) / ((double) options3.inSampleSize), ((double) i2) / ((double) options3.inSampleSize), (double) r8, (double) r62, this.options.getScale());
        if (this.options.getPrecision() == Precision.INEXACT) {
            computeSizeMultiplier = RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
        }
        if (computeSizeMultiplier == 1.0d) {
            z = true;
        }
        options3.inScaled = !z;
        if (!options3.inScaled) {
            return;
        }
        if (computeSizeMultiplier > 1.0d) {
            options3.inDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) / computeSizeMultiplier);
            options3.inTargetDensity = Integer.MAX_VALUE;
            return;
        }
        options3.inDensity = Integer.MAX_VALUE;
        options3.inTargetDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) * computeSizeMultiplier);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "exifOrientationStrategy", "Lcoil3/decode/ExifOrientationStrategy;", "<init>", "(Lkotlinx/coroutines/sync/Semaphore;Lcoil3/decode/ExifOrientationStrategy;)V", "create", "Lcoil3/decode/Decoder;", "result", "Lcoil3/fetch/SourceFetchResult;", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: BitmapFactoryDecoder.kt */
    public static final class Factory implements Decoder.Factory {
        private final ExifOrientationStrategy exifOrientationStrategy;
        private final Semaphore parallelismLock;

        public Factory() {
            this((Semaphore) null, (ExifOrientationStrategy) null, 3, (DefaultConstructorMarker) null);
        }

        public Factory(Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy2) {
            this.parallelismLock = semaphore;
            this.exifOrientationStrategy = exifOrientationStrategy2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SemaphoreKt.Semaphore$default(4, 0, 2, (Object) null) : semaphore, (i & 2) != 0 ? ExifOrientationStrategy.RESPECT_PERFORMANCE : exifOrientationStrategy2);
        }

        public Decoder create(SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(sourceFetchResult.getSource(), options, this.parallelismLock, this.exifOrientationStrategy);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016R.\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "<init>", "(Lokio/Source;)V", "value", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: BitmapFactoryDecoder.kt */
    private static final class ExceptionCatchingSource extends ForwardingSource {
        private Exception exception;

        public ExceptionCatchingSource(Source source) {
            super(source);
        }

        public final Exception getException() {
            return this.exception;
        }

        public long read(Buffer buffer, long j) {
            try {
                return super.read(buffer, j);
            } catch (Exception e) {
                this.exception = e;
                throw e;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder$Companion;", "", "<init>", "()V", "DEFAULT_MAX_PARALLELISM", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: BitmapFactoryDecoder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
