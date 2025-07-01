package coil3.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil3.BitmapImage;
import coil3.Image;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.transform.Transformation;
import coil3.util.BitmapsKt;
import coil3.util.DrawableUtils;
import coil3.util.Logger;
import coil3.util.Utils_androidKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH@¢\u0006\u0002\u0010\u000b\u001a0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¨\u0006\u0017"}, d2 = {"transform", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "result", "request", "Lcoil3/request/ImageRequest;", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "logger", "Lcoil3/util/Logger;", "(Lcoil3/intercept/EngineInterceptor$ExecuteResult;Lcoil3/request/ImageRequest;Lcoil3/request/Options;Lcoil3/EventListener;Lcoil3/util/Logger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "transformations", "", "Lcoil3/transform/Transformation;", "prepareToDraw", "", "image", "Lcoil3/Image;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: EngineInterceptor.kt */
public final class EngineInterceptorKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object transform(coil3.intercept.EngineInterceptor.ExecuteResult r18, coil3.request.ImageRequest r19, coil3.request.Options r20, coil3.EventListener r21, coil3.util.Logger r22, kotlin.coroutines.Continuation<? super coil3.intercept.EngineInterceptor.ExecuteResult> r23) {
        /*
            r0 = r22
            r1 = r23
            boolean r2 = r1 instanceof coil3.intercept.EngineInterceptorKt$transform$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            coil3.intercept.EngineInterceptorKt$transform$1 r2 = (coil3.intercept.EngineInterceptorKt$transform$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            coil3.intercept.EngineInterceptorKt$transform$1 r2 = new coil3.intercept.EngineInterceptorKt$transform$1
            r2.<init>(r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0054
            if (r4 != r5) goto L_0x004c
            int r0 = r2.I$1
            int r4 = r2.I$0
            java.lang.Object r6 = r2.L$4
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r2.L$3
            coil3.EventListener r7 = (coil3.EventListener) r7
            java.lang.Object r8 = r2.L$2
            coil3.request.Options r8 = (coil3.request.Options) r8
            java.lang.Object r9 = r2.L$1
            coil3.request.ImageRequest r9 = (coil3.request.ImageRequest) r9
            java.lang.Object r10 = r2.L$0
            coil3.intercept.EngineInterceptor$ExecuteResult r10 = (coil3.intercept.EngineInterceptor.ExecuteResult) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r8
            r8 = r6
            r6 = r17
            goto L_0x00fc
        L_0x004c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r1)
            java.util.List r1 = coil3.request.ImageRequests_androidKt.getTransformations((coil3.request.ImageRequest) r19)
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x0062
            goto L_0x00b8
        L_0x0062:
            coil3.Image r4 = r18.getImage()
            android.content.Context r6 = r19.getContext()
            android.content.res.Resources r6 = r6.getResources()
            android.graphics.drawable.Drawable r4 = coil3.Image_androidKt.asDrawable(r4, r6)
            boolean r6 = r4 instanceof android.graphics.drawable.BitmapDrawable
            if (r6 != 0) goto L_0x00b9
            boolean r6 = coil3.request.ImageRequests_androidKt.getAllowConversionToBitmap((coil3.request.ImageRequest) r19)
            if (r6 != 0) goto L_0x00b9
            if (r0 == 0) goto L_0x00b8
            coil3.util.Logger$Level r1 = coil3.util.Logger.Level.Info
            coil3.util.Logger$Level r2 = r0.getMinLevel()
            r3 = r1
            java.lang.Enum r3 = (java.lang.Enum) r3
            int r2 = r2.compareTo(r3)
            if (r2 > 0) goto L_0x00b8
            coil3.Image r2 = r18.getImage()
            java.lang.Class r2 = r2.getClass()
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            java.lang.String r2 = r2.getQualifiedName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "allowConversionToBitmap=false, skipping transformations for type "
            r3.<init>(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            r3 = 46
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            java.lang.String r4 = "EngineInterceptor"
            r0.log(r4, r1, r2, r3)
        L_0x00b8:
            return r18
        L_0x00b9:
            r6 = r20
            android.graphics.Bitmap r0 = convertDrawableToBitmap(r4, r6, r1, r0)
            r4 = r19
            r7 = r21
            r7.transformStart(r4, r0)
            r8 = r1
            java.util.Collection r8 = (java.util.Collection) r8
            int r8 = r8.size()
            r9 = 0
            r10 = r1
            r1 = r0
            r0 = r8
            r8 = r10
            r10 = r18
        L_0x00d4:
            if (r9 >= r0) goto L_0x010c
            java.lang.Object r11 = r8.get(r9)
            coil3.transform.Transformation r11 = (coil3.transform.Transformation) r11
            coil3.size.Size r12 = r6.getSize()
            r2.L$0 = r10
            r2.L$1 = r4
            r2.L$2 = r6
            r2.L$3 = r7
            r2.L$4 = r8
            r2.I$0 = r9
            r2.I$1 = r0
            r2.label = r5
            java.lang.Object r1 = r11.transform(r1, r12, r2)
            if (r1 != r3) goto L_0x00f7
            return r3
        L_0x00f7:
            r17 = r9
            r9 = r4
            r4 = r17
        L_0x00fc:
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            kotlin.coroutines.CoroutineContext r11 = r2.getContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r11)
            int r4 = r4 + r5
            r17 = r9
            r9 = r4
            r4 = r17
            goto L_0x00d4
        L_0x010c:
            r7.transformEnd(r4, r1)
            android.content.Context r0 = r4.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            r2.<init>(r0, r1)
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            coil3.Image r11 = coil3.Image_androidKt.asImage((android.graphics.drawable.Drawable) r2)
            r15 = 14
            r16 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            coil3.intercept.EngineInterceptor$ExecuteResult r0 = coil3.intercept.EngineInterceptor.ExecuteResult.copy$default(r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptorKt.transform(coil3.intercept.EngineInterceptor$ExecuteResult, coil3.request.ImageRequest, coil3.request.Options, coil3.EventListener, coil3.util.Logger, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> list, Logger logger) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = BitmapsKt.getSafeConfig(bitmap);
            if (ArraysKt.contains((T[]) Utils_androidKt.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            if (logger != null) {
                Logger.Level level = Logger.Level.Info;
                if (logger.getMinLevel().compareTo(level) <= 0) {
                    logger.log(EngineInterceptor.TAG, level, "Converting bitmap with config " + safeConfig + " to apply transformations: " + list + '.', (Throwable) null);
                }
            }
        } else if (logger != null) {
            Logger.Level level2 = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level2) <= 0) {
                logger.log(EngineInterceptor.TAG, level2, "Converting drawable of type " + Reflection.getOrCreateKotlinClass(drawable.getClass()).getQualifiedName() + " to apply transformations: " + list + '.', (Throwable) null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, ImageRequests_androidKt.getBitmapConfig(options), options.getSize(), options.getScale(), options.getPrecision() == Precision.INEXACT);
    }

    public static final void prepareToDraw(Image image) {
        Bitmap bitmap;
        BitmapImage bitmapImage = image instanceof BitmapImage ? (BitmapImage) image : null;
        if (bitmapImage != null && (bitmap = bitmapImage.getBitmap()) != null) {
            bitmap.prepareToDraw();
        }
    }
}
