package coil3.decode;

import coil3.size.Dimension;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.util.IntPair;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J0\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J0\u0010\f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0007J0\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007J7\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u0005*\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0018"}, d2 = {"Lcoil3/decode/DecodeUtils;", "", "<init>", "()V", "calculateInSampleSize", "", "srcWidth", "srcHeight", "dstWidth", "dstHeight", "scale", "Lcoil3/size/Scale;", "computeSizeMultiplier", "", "", "computeDstSize", "Lcoil3/util/IntPair;", "targetSize", "Lcoil3/size/Size;", "maxSize", "computeDstSize-sEdh43o", "(IILcoil3/size/Size;Lcoil3/size/Scale;Lcoil3/size/Size;)J", "toPx", "Lcoil3/size/Dimension;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: DecodeUtils.kt */
public final class DecodeUtils {
    public static final DecodeUtils INSTANCE = new DecodeUtils();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* compiled from: DecodeUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                coil3.size.Scale[] r0 = coil3.size.Scale.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                coil3.size.Scale r1 = coil3.size.Scale.FILL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                coil3.size.Scale r1 = coil3.size.Scale.FIT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.decode.DecodeUtils.WhenMappings.<clinit>():void");
        }
    }

    private DecodeUtils() {
    }

    @JvmStatic
    public static final int calculateInSampleSize(int i, int i2, int i3, int i4, Scale scale) {
        int i5;
        int highestOneBit = Integer.highestOneBit(i / i3);
        int highestOneBit2 = Integer.highestOneBit(i2 / i4);
        int i6 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i6 == 1) {
            i5 = Math.min(highestOneBit, highestOneBit2);
        } else if (i6 == 2) {
            i5 = Math.max(highestOneBit, highestOneBit2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return RangesKt.coerceAtLeast(i5, 1);
    }

    @JvmStatic
    public static final double computeSizeMultiplier(int i, int i2, int i3, int i4, Scale scale) {
        double d = ((double) i3) / ((double) i);
        double d2 = ((double) i4) / ((double) i2);
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            return Math.max(d, d2);
        }
        if (i5 == 2) {
            return Math.min(d, d2);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final float computeSizeMultiplier(float f, float f2, float f3, float f4, Scale scale) {
        float f5 = f3 / f;
        float f6 = f4 / f2;
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i == 1) {
            return Math.max(f5, f6);
        }
        if (i == 2) {
            return Math.min(f5, f6);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final double computeSizeMultiplier(double d, double d2, double d3, double d4, Scale scale) {
        double d5 = d3 / d;
        double d6 = d4 / d2;
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i == 1) {
            return Math.max(d5, d6);
        }
        if (i == 2) {
            return Math.min(d5, d6);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    /* renamed from: computeDstSize-sEdh43o  reason: not valid java name */
    public static final long m7499computeDstSizesEdh43o(int i, int i2, Size size, Scale scale, Size size2) {
        if (!SizeKt.isOriginal(size)) {
            DecodeUtils decodeUtils = INSTANCE;
            int px = decodeUtils.toPx(size.getWidth(), scale);
            i2 = decodeUtils.toPx(size.getHeight(), scale);
            i = px;
        }
        if ((size2.getWidth() instanceof Dimension.Pixels) && !UtilsKt.isMinOrMax(i)) {
            i = RangesKt.coerceAtMost(i, ((Dimension.Pixels) size2.getWidth()).m7548unboximpl());
        }
        if ((size2.getHeight() instanceof Dimension.Pixels) && !UtilsKt.isMinOrMax(i2)) {
            i2 = RangesKt.coerceAtMost(i2, ((Dimension.Pixels) size2.getHeight()).m7548unboximpl());
        }
        return IntPair.m7553constructorimpl(i, i2);
    }

    private final int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).m7548unboximpl();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i == 1) {
            return Integer.MIN_VALUE;
        }
        if (i == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
