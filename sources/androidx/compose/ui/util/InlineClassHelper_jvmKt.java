package androidx.compose.ui.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u001a\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0006H\b\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0001H\b\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\b¨\u0006\b"}, d2 = {"doubleFromBits", "", "bits", "", "floatFromBits", "", "", "fastRoundToInt", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: InlineClassHelper.jvm.kt */
public final class InlineClassHelper_jvmKt {
    public static final float floatFromBits(int i) {
        return Float.intBitsToFloat(i);
    }

    public static final double doubleFromBits(long j) {
        return Double.longBitsToDouble(j);
    }

    public static final int fastRoundToInt(float f) {
        return Math.round(f);
    }

    public static final int fastRoundToInt(double d) {
        return (int) Math.round(d);
    }
}
