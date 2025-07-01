package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a8\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\fH\u0007\u001a(\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a8\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a9\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aH\b\u001a\r\u0010\u001c\u001a\u00020\u001d*\u00020\u0004H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"MAX_LONG_MILLIS", "", "estimateAnimationDurationMillis", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "firstRoot", "Landroidx/compose/animation/core/ComplexDouble;", "p0", "v0", "estimateDurationInternal", "secondRoot", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpringEstimation.kt */
public final class SpringEstimationKt {
    private static final long MAX_LONG_MILLIS = 9223372036854L;

    public static final long estimateAnimationDurationMillis(float f, float f2, float f3, float f4, float f5) {
        return f2 == 0.0f ? MAX_LONG_MILLIS : estimateAnimationDurationMillis((double) f, (double) f2, (double) f3, (double) f4, (double) f5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5) {
        double sqrt = 2.0d * d2 * Math.sqrt(d);
        double d6 = (sqrt * sqrt) - (d * 4.0d);
        double d7 = -sqrt;
        ComplexDouble complexSqrt = ComplexDoubleKt.complexSqrt(d6);
        complexSqrt._real = complexSqrt._real + d7;
        complexSqrt._real = complexSqrt._real * 0.5d;
        complexSqrt._imaginary = complexSqrt._imaginary * 0.5d;
        ComplexDouble complexSqrt2 = ComplexDoubleKt.complexSqrt(d6);
        double d8 = (double) -1;
        complexSqrt2._real = complexSqrt2._real * d8;
        complexSqrt2._imaginary = complexSqrt2._imaginary * d8;
        complexSqrt2._real = complexSqrt2._real + d7;
        complexSqrt2._real = complexSqrt2._real * 0.5d;
        complexSqrt2._imaginary = complexSqrt2._imaginary * 0.5d;
        return estimateDurationInternal(complexSqrt, complexSqrt2, d2, d3, d4, d5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2;
        double sqrt = d7 / (Math.sqrt(d * d3) * 2.0d);
        double d8 = (d7 * d7) - ((4.0d * d3) * d);
        double d9 = -d7;
        double d10 = 1.0d / (2.0d * d3);
        ComplexDouble complexSqrt = ComplexDoubleKt.complexSqrt(d8);
        complexSqrt._real = complexSqrt._real + d9;
        complexSqrt._real = complexSqrt._real * d10;
        complexSqrt._imaginary = complexSqrt._imaginary * d10;
        ComplexDouble complexSqrt2 = ComplexDoubleKt.complexSqrt(d8);
        double d11 = (double) -1;
        complexSqrt2._real = complexSqrt2._real * d11;
        complexSqrt2._imaginary = complexSqrt2._imaginary * d11;
        complexSqrt2._real = complexSqrt2._real + d9;
        complexSqrt2._real = complexSqrt2._real * d10;
        complexSqrt2._imaginary = complexSqrt2._imaginary * d10;
        return estimateDurationInternal(complexSqrt, complexSqrt2, sqrt, d4, d5, d6);
    }

    private static final double estimateUnderDamped(ComplexDouble complexDouble, double d, double d2, double d3) {
        double real = complexDouble.getReal();
        double imaginary = (d2 - (real * d)) / complexDouble.getImaginary();
        return Math.log(d3 / Math.sqrt((d * d) + (imaginary * imaginary))) / real;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2 A[LOOP:1: B:36:0x00a5->B:40:0x00b2, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateCriticallyDamped(androidx.compose.animation.core.ComplexDouble r20, double r21, double r23, double r25) {
        /*
            r0 = r25
            double r2 = r20.getReal()
            double r4 = r2 * r21
            double r6 = r23 - r4
            double r8 = r0 / r21
            double r8 = java.lang.Math.abs(r8)
            double r8 = java.lang.Math.log(r8)
            double r8 = r8 / r2
            double r10 = r0 / r6
            double r10 = java.lang.Math.abs(r10)
            double r10 = java.lang.Math.log(r10)
            r14 = r10
            r13 = 0
        L_0x0021:
            r12 = 6
            if (r13 >= r12) goto L_0x0032
            double r14 = r14 / r2
            double r14 = java.lang.Math.abs(r14)
            double r14 = java.lang.Math.log(r14)
            double r14 = r10 - r14
            int r13 = r13 + 1
            goto L_0x0021
        L_0x0032:
            double r14 = r14 / r2
            boolean r10 = java.lang.Double.isInfinite(r8)
            r11 = 1
            if (r10 != 0) goto L_0x0042
            boolean r10 = java.lang.Double.isNaN(r8)
            if (r10 != 0) goto L_0x0042
            r10 = r11
            goto L_0x0043
        L_0x0042:
            r10 = 0
        L_0x0043:
            if (r10 != 0) goto L_0x0047
            r8 = r14
            goto L_0x005d
        L_0x0047:
            boolean r10 = java.lang.Double.isInfinite(r14)
            if (r10 != 0) goto L_0x0055
            boolean r10 = java.lang.Double.isNaN(r14)
            if (r10 != 0) goto L_0x0055
            r10 = r11
            goto L_0x0056
        L_0x0055:
            r10 = 0
        L_0x0056:
            if (r10 != 0) goto L_0x0059
            goto L_0x005d
        L_0x0059:
            double r8 = java.lang.Math.max(r8, r14)
        L_0x005d:
            double r12 = r4 + r6
            double r12 = -r12
            double r14 = r2 * r6
            double r12 = r12 / r14
            double r14 = r2 * r12
            double r16 = java.lang.Math.exp(r14)
            double r16 = r16 * r21
            double r18 = r6 * r12
            double r14 = java.lang.Math.exp(r14)
            double r18 = r18 * r14
            double r14 = r16 + r18
            boolean r10 = java.lang.Double.isNaN(r12)
            if (r10 != 0) goto L_0x009e
            r16 = 0
            int r10 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r10 > 0) goto L_0x0082
            goto L_0x009e
        L_0x0082:
            int r10 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x0096
            double r12 = -r14
            int r10 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r10 >= 0) goto L_0x0096
            int r10 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r10 >= 0) goto L_0x009e
            int r10 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x009e
            r8 = r16
            goto L_0x009e
        L_0x0096:
            r8 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = r8 / r2
            double r8 = -r8
            double r12 = r21 / r6
            double r8 = r8 - r12
            goto L_0x009f
        L_0x009e:
            double r0 = -r0
        L_0x009f:
            r12 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r10 = 0
        L_0x00a5:
            r14 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x00d8
            r12 = 100
            if (r10 >= r12) goto L_0x00d8
            int r10 = r10 + 1
            double r12 = r6 * r8
            double r12 = r21 + r12
            double r14 = r2 * r8
            double r16 = java.lang.Math.exp(r14)
            double r12 = r12 * r16
            double r12 = r12 + r0
            r23 = r0
            double r0 = (double) r11
            double r0 = r0 + r14
            double r0 = r0 * r6
            double r0 = r0 + r4
            double r14 = java.lang.Math.exp(r14)
            double r0 = r0 * r14
            double r12 = r12 / r0
            double r0 = r8 - r12
            double r8 = r8 - r0
            double r12 = java.lang.Math.abs(r8)
            r8 = r0
            r0 = r23
            goto L_0x00a5
        L_0x00d8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateCriticallyDamped(androidx.compose.animation.core.ComplexDouble, double, double, double):double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateOverDamped(androidx.compose.animation.core.ComplexDouble r26, androidx.compose.animation.core.ComplexDouble r27, double r28, double r30, double r32) {
        /*
            r0 = r32
            double r4 = r26.getReal()
            double r10 = r27.getReal()
            double r2 = r4 * r28
            double r2 = r2 - r30
            double r12 = r4 - r10
            double r8 = r2 / r12
            double r2 = r28 - r8
            double r6 = r0 / r2
            double r6 = java.lang.Math.abs(r6)
            double r6 = java.lang.Math.log(r6)
            double r6 = r6 / r4
            double r14 = r0 / r8
            double r14 = java.lang.Math.abs(r14)
            double r14 = java.lang.Math.log(r14)
            double r14 = r14 / r10
            boolean r16 = java.lang.Double.isInfinite(r6)
            r17 = 1
            r18 = 0
            if (r16 != 0) goto L_0x003d
            boolean r16 = java.lang.Double.isNaN(r6)
            if (r16 != 0) goto L_0x003d
            r16 = r17
            goto L_0x003f
        L_0x003d:
            r16 = r18
        L_0x003f:
            if (r16 != 0) goto L_0x0042
            goto L_0x0059
        L_0x0042:
            boolean r16 = java.lang.Double.isInfinite(r14)
            if (r16 != 0) goto L_0x004f
            boolean r16 = java.lang.Double.isNaN(r14)
            if (r16 != 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r17 = r18
        L_0x0051:
            if (r17 != 0) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            double r6 = java.lang.Math.max(r6, r14)
        L_0x0058:
            r14 = r6
        L_0x0059:
            double r16 = r2 * r4
            double r6 = -r8
            double r6 = r6 * r10
            double r6 = r16 / r6
            double r6 = java.lang.Math.log(r6)
            double r19 = r10 - r4
            double r6 = r6 / r19
            boolean r19 = java.lang.Double.isNaN(r6)
            if (r19 != 0) goto L_0x009a
            r19 = 0
            int r21 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r21 > 0) goto L_0x0074
            goto L_0x009a
        L_0x0074:
            int r21 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r21 <= 0) goto L_0x008c
            double r6 = estimateOverDamped$xInflection(r2, r4, r6, r8, r10)
            double r6 = -r6
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x008c
            int r6 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r6 <= 0) goto L_0x009a
            int r6 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r6 >= 0) goto L_0x009a
            r14 = r19
            goto L_0x009a
        L_0x008c:
            double r6 = r8 * r10
            double r6 = r6 * r10
            double r6 = -r6
            double r14 = r16 * r4
            double r6 = r6 / r14
            double r6 = java.lang.Math.log(r6)
            double r14 = r6 / r12
            goto L_0x009b
        L_0x009a:
            double r0 = -r0
        L_0x009b:
            double r6 = r4 * r14
            double r6 = java.lang.Math.exp(r6)
            double r6 = r6 * r16
            double r12 = r8 * r10
            double r19 = r10 * r14
            double r19 = java.lang.Math.exp(r19)
            double r19 = r19 * r12
            double r6 = r6 + r19
            double r6 = java.lang.Math.abs(r6)
            r19 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r6 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r6 >= 0) goto L_0x00bd
            return r14
        L_0x00bd:
            r6 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r26 = r0
            r0 = r18
        L_0x00c6:
            r18 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r1 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r1 <= 0) goto L_0x0106
            r1 = 100
            if (r0 >= r1) goto L_0x0106
            int r0 = r0 + 1
            double r6 = r4 * r14
            double r18 = java.lang.Math.exp(r6)
            double r18 = r18 * r2
            double r20 = r10 * r14
            double r22 = java.lang.Math.exp(r20)
            double r22 = r22 * r8
            double r18 = r18 + r22
            double r18 = r18 + r26
            double r6 = java.lang.Math.exp(r6)
            double r6 = r6 * r16
            double r20 = java.lang.Math.exp(r20)
            double r20 = r20 * r12
            double r6 = r6 + r20
            double r18 = r18 / r6
            double r6 = r14 - r18
            double r14 = r14 - r6
            double r14 = java.lang.Math.abs(r14)
            r24 = r14
            r14 = r6
            r6 = r24
            goto L_0x00c6
        L_0x0106:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble, double, double, double):double");
    }

    private static final double estimateOverDamped$xInflection(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final long estimateDurationInternal(ComplexDouble complexDouble, ComplexDouble complexDouble2, double d, double d2, double d3, double d4) {
        double d5;
        int i = (d3 > 0.0d ? 1 : (d3 == 0.0d ? 0 : -1));
        if (i == 0 && d2 == 0.0d) {
            return 0;
        }
        if (i < 0) {
            d2 = -d2;
        }
        double d6 = d2;
        double abs = Math.abs(d3);
        if (d > 1.0d) {
            double d7 = abs;
            ComplexDouble complexDouble3 = complexDouble2;
            d5 = estimateOverDamped(complexDouble, complexDouble3, d7, d6, d4);
        } else if (d < 1.0d) {
            d5 = estimateUnderDamped(complexDouble, abs, d6, d4);
        } else {
            d5 = estimateCriticallyDamped(complexDouble, abs, d6, d4);
        }
        return (long) (d5 * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double d, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
        return d - (function1.invoke(Double.valueOf(d)).doubleValue() / function12.invoke(Double.valueOf(d)).doubleValue());
    }

    private static final boolean isNotFinite(double d) {
        return !(!Double.isInfinite(d) && !Double.isNaN(d));
    }
}
