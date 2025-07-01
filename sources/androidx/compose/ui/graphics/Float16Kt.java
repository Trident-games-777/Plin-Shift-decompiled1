package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.ShortCompanionObject;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\r\u001a\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\b\u001a\u0011\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0017H\b\u001a\"\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\"\u0010 \u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001f\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0017H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u0010\u0010\u0015\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Fp16Combined", "", "Fp16ExponentBias", "Fp16ExponentMask", "Fp16ExponentMax", "Fp16ExponentShift", "Fp16SignMask", "Fp16SignShift", "Fp16SignificandMask", "Fp32DenormalFloat", "", "Fp32DenormalMagic", "Fp32ExponentBias", "Fp32ExponentMask", "Fp32ExponentShift", "Fp32QNaNMask", "Fp32SignShift", "Fp32SignificandMask", "NegativeOne", "Landroidx/compose/ui/graphics/Float16;", "S", "One", "floatToHalf", "", "f", "halfToFloat", "h", "max", "x", "y", "max-AoSsdG0", "(SS)S", "min", "min-AoSsdG0", "toCompareValue", "value", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Float16.kt */
public final class Float16Kt {
    private static final int Fp16Combined = 32767;
    private static final int Fp16ExponentBias = 15;
    private static final int Fp16ExponentMask = 31;
    private static final int Fp16ExponentMax = 31744;
    private static final int Fp16ExponentShift = 10;
    private static final int Fp16SignMask = 32768;
    private static final int Fp16SignShift = 15;
    private static final int Fp16SignificandMask = 1023;
    /* access modifiers changed from: private */
    public static final float Fp32DenormalFloat = Float.intBitsToFloat(Fp32DenormalMagic);
    private static final int Fp32DenormalMagic = 1056964608;
    private static final int Fp32ExponentBias = 127;
    private static final int Fp32ExponentMask = 255;
    private static final int Fp32ExponentShift = 23;
    private static final int Fp32QNaNMask = 4194304;
    private static final int Fp32SignShift = 31;
    private static final int Fp32SignificandMask = 8388607;
    /* access modifiers changed from: private */
    public static final short NegativeOne = Float16.m4348constructorimpl(-1.0f);
    /* access modifiers changed from: private */
    public static final short One = Float16.m4348constructorimpl(1.0f);

    private static final int toCompareValue(short s) {
        return (s & ShortCompanionObject.MIN_VALUE) != 0 ? 32768 - (s & UShort.MAX_VALUE) : s & UShort.MAX_VALUE;
    }

    public static final short floatToHalf(float f) {
        int i;
        int i2;
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        int i3 = floatToRawIntBits >>> 31;
        int i4 = (floatToRawIntBits >>> 23) & 255;
        int i5 = Fp32SignificandMask & floatToRawIntBits;
        int i6 = 31;
        int i7 = 0;
        if (i4 == 255) {
            if (i5 != 0) {
                i2 = 512;
            }
            i = (i3 << 15) | (i6 << 10) | i7;
            return (short) i;
        }
        int i8 = i4 - 112;
        if (i8 >= 31) {
            i6 = 49;
        } else if (i8 > 0) {
            i7 = i5 >> 13;
            if ((floatToRawIntBits & 4096) != 0) {
                i = (((i8 << 10) | i7) + 1) | (i3 << 15);
                return (short) i;
            }
            i6 = i8;
        } else if (i8 >= -10) {
            int i9 = (8388608 | i5) >> (1 - i8);
            if ((i9 & 4096) != 0) {
                i9 += 8192;
            }
            i2 = i9 >> 13;
            i6 = 0;
        } else {
            i6 = 0;
        }
        i = (i3 << 15) | (i6 << 10) | i7;
        return (short) i;
        i7 = i2;
        i = (i3 << 15) | (i6 << 10) | i7;
        return (short) i;
    }

    /* renamed from: min-AoSsdG0  reason: not valid java name */
    public static final short m4387minAoSsdG0(short s, short s2) {
        if (Float16.m4359isNaNimpl(s) || Float16.m4359isNaNimpl(s2)) {
            return Float16.Companion.m4381getNaNslo4al4();
        }
        return Float16.m4346compareTo41bOqos(s, s2) <= 0 ? s : s2;
    }

    /* renamed from: max-AoSsdG0  reason: not valid java name */
    public static final short m4386maxAoSsdG0(short s, short s2) {
        if (Float16.m4359isNaNimpl(s) || Float16.m4359isNaNimpl(s2)) {
            return Float16.Companion.m4381getNaNslo4al4();
        }
        return Float16.m4346compareTo41bOqos(s, s2) >= 0 ? s : s2;
    }

    public static final float halfToFloat(short s) {
        int i;
        int i2;
        int i3;
        short s2 = 32768 & s;
        int i4 = ((65535 & s) >>> 10) & 31;
        short s3 = s & 1023;
        if (i4 != 0) {
            int i5 = s3 << 13;
            if (i4 == 31) {
                i3 = 255;
                if (i5 != 0) {
                    i5 |= 4194304;
                }
            } else {
                i3 = i4 + 112;
            }
            int i6 = i3;
            i2 = i5;
            i = i6;
        } else if (s3 != 0) {
            float intBitsToFloat = Float.intBitsToFloat(s3 + Fp32DenormalMagic) - Fp32DenormalFloat;
            return s2 == 0 ? intBitsToFloat : -intBitsToFloat;
        } else {
            i = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i << 23) | (s2 << 16) | i2);
    }
}
