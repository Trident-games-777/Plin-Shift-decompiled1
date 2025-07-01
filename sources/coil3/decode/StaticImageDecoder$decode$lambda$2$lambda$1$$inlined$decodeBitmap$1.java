package coil3.decode;

import android.graphics.ImageDecoder;
import android.util.Size;
import coil3.request.ImageRequestsKt;
import coil3.size.Precision;
import coil3.util.IntPair;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"<anonymous>", "", "decoder", "Landroid/graphics/ImageDecoder;", "info", "Landroid/graphics/ImageDecoder$ImageInfo;", "source", "Landroid/graphics/ImageDecoder$Source;", "onHeaderDecoded", "androidx/core/graphics/ImageDecoderKt$decodeBitmap$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageDecoder.kt */
public final class StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1 implements ImageDecoder.OnHeaderDecodedListener {
    final /* synthetic */ Ref.BooleanRef $isSampled$inlined;
    final /* synthetic */ StaticImageDecoder this$0;

    public StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1(StaticImageDecoder staticImageDecoder, Ref.BooleanRef booleanRef) {
        this.this$0 = staticImageDecoder;
        this.$isSampled$inlined = booleanRef;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Size size = imageInfo.getSize();
        int width = size.getWidth();
        int height = size.getHeight();
        long r0 = DecodeUtils.m7499computeDstSizesEdh43o(width, height, this.this$0.options.getSize(), this.this$0.options.getScale(), ImageRequestsKt.getMaxBitmapSize(this.this$0.options));
        int r2 = IntPair.m7557getFirstimpl(r0);
        int r02 = IntPair.m7558getSecondimpl(r0);
        if (width > 0 && height > 0 && !(width == r2 && height == r02)) {
            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, r2, r02, this.this$0.options.getScale());
            this.$isSampled$inlined.element = computeSizeMultiplier < 1.0d;
            if (this.$isSampled$inlined.element || this.this$0.options.getPrecision() == Precision.EXACT) {
                imageDecoder.setTargetSize(MathKt.roundToInt(((double) width) * computeSizeMultiplier), MathKt.roundToInt(computeSizeMultiplier * ((double) height)));
            }
        }
        this.this$0.configureImageDecoderProperties(imageDecoder);
    }
}
