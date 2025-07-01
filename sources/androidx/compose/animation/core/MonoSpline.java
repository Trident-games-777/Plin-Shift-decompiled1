package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001cJ \u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0003J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J8\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J#\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010$R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006%"}, d2 = {"Landroidx/compose/animation/core/MonoSpline;", "", "time", "", "y", "", "periodicBias", "", "([F[[FF)V", "isExtrapolate", "", "slopeTemp", "tangents", "[[F", "timePoints", "values", "diff", "h", "x", "y1", "y2", "t1", "t2", "getPos", "", "v", "Landroidx/compose/animation/core/AnimationVector;", "index", "", "t", "j", "getSlope", "interpolate", "makeFloatArray", "a", "b", "(II)[[F", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MonoSpline.kt */
public final class MonoSpline {
    public static final int $stable = 8;
    private final boolean isExtrapolate = true;
    private final float[] slopeTemp;
    private final float[][] tangents;
    private final float[] timePoints;
    private final float[][] values;

    private final float diff(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 * f2;
        float f8 = (float) 6;
        float f9 = f8 * f2;
        float f10 = ((float) 3) * f;
        return (((((((((((float) -6) * f7) * f4) + (f4 * f9)) + ((f8 * f7) * f3)) - (f9 * f3)) + ((f10 * f6) * f7)) + ((f10 * f5) * f7)) - (((((float) 2) * f) * f6) * f2)) - (((((float) 4) * f) * f5) * f2)) + (f * f5);
    }

    private final float interpolate(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 * f2;
        float f8 = f7 * f2;
        float f9 = ((float) 3) * f7;
        float f10 = (((float) -2) * f8 * f4) + (f4 * f9);
        float f11 = (float) 2;
        float f12 = f6 * f;
        float f13 = ((f10 + ((f11 * f8) * f3)) - (f9 * f3)) + f3 + (f12 * f8);
        float f14 = f * f5;
        return (((f13 + (f8 * f14)) - (f12 * f7)) - (((f11 * f) * f5) * f7)) + (f14 * f2);
    }

    public MonoSpline(float[] fArr, float[][] fArr2, float f) {
        int i;
        float[] fArr3 = fArr;
        float[][] fArr4 = fArr2;
        int length = fArr3.length;
        int i2 = 0;
        int length2 = fArr4[0].length;
        this.slopeTemp = new float[length2];
        int i3 = length - 1;
        float[][] makeFloatArray = makeFloatArray(i3, length2);
        float[][] makeFloatArray2 = makeFloatArray(length, length2);
        for (int i4 = 0; i4 < length2; i4++) {
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i5 + 1;
                float f2 = fArr3[i6] - fArr3[i5];
                float[] fArr5 = makeFloatArray[i5];
                float f3 = (fArr4[i6][i4] - fArr4[i5][i4]) / f2;
                fArr5[i4] = f3;
                if (i5 == 0) {
                    makeFloatArray2[i5][i4] = f3;
                } else {
                    makeFloatArray2[i5][i4] = (makeFloatArray[i5 - 1][i4] + f3) * 0.5f;
                }
                i5 = i6;
            }
            makeFloatArray2[i3][i4] = makeFloatArray[length - 2][i4];
        }
        if (!Float.isNaN(f)) {
            for (int i7 = 0; i7 < length2; i7++) {
                float[] fArr6 = makeFloatArray[length - 2];
                float f4 = fArr6[i7] * (((float) 1) - f);
                float[] fArr7 = makeFloatArray[0];
                float f5 = f4 + (fArr7[i7] * f);
                fArr7[i7] = f5;
                fArr6[i7] = f5;
                makeFloatArray2[i3][i7] = f5;
                makeFloatArray2[0][i7] = f5;
            }
        }
        int i8 = 0;
        while (i8 < i3) {
            int i9 = i2;
            while (i9 < length2) {
                float f6 = makeFloatArray[i8][i9];
                if (f6 == 0.0f) {
                    makeFloatArray2[i8][i9] = 0.0f;
                    makeFloatArray2[i8 + 1][i9] = 0.0f;
                    i = length2;
                } else {
                    float f7 = makeFloatArray2[i8][i9] / f6;
                    int i10 = i8 + 1;
                    float f8 = makeFloatArray2[i10][i9] / f6;
                    i = length2;
                    float hypot = (float) Math.hypot((double) f7, (double) f8);
                    if (((double) hypot) > 9.0d) {
                        float f9 = 3.0f / hypot;
                        float[] fArr8 = makeFloatArray2[i8];
                        float[] fArr9 = makeFloatArray[i8];
                        fArr8[i9] = f7 * f9 * fArr9[i9];
                        makeFloatArray2[i10][i9] = f9 * f8 * fArr9[i9];
                    }
                }
                i9++;
                length2 = i;
            }
            int i11 = length2;
            i8++;
            i2 = 0;
        }
        this.timePoints = fArr3;
        this.values = fArr4;
        this.tangents = makeFloatArray2;
    }

    private final float[][] makeFloatArray(int i, int i2) {
        float[][] fArr = new float[i][];
        for (int i3 = 0; i3 < i; i3++) {
            fArr[i3] = new float[i2];
        }
        return fArr;
    }

    public final float getPos(float f, int i) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i2 = 0;
        if (this.isExtrapolate) {
            float f2 = fArr[0];
            if (f <= f2) {
                return this.values[0][i] + ((f - f2) * getSlope(f2, i));
            }
            int i3 = length - 1;
            float f3 = fArr[i3];
            if (f >= f3) {
                return this.values[i3][i] + ((f - f3) * getSlope(f3, i));
            }
        } else if (f <= fArr[0]) {
            return this.values[0][i];
        } else {
            int i4 = length - 1;
            if (f >= fArr[i4]) {
                return this.values[i4][i];
            }
        }
        int i5 = length - 1;
        while (i2 < i5) {
            float[] fArr2 = this.timePoints;
            float f4 = fArr2[i2];
            if (f == f4) {
                return this.values[i2][i];
            }
            int i6 = i2 + 1;
            float f5 = fArr2[i6];
            if (f < f5) {
                float f6 = f5 - f4;
                float f7 = (f - f4) / f6;
                float[][] fArr3 = this.values;
                float f8 = fArr3[i2][i];
                float f9 = fArr3[i6][i];
                float[][] fArr4 = this.tangents;
                return interpolate(f6, f7, f8, f9, fArr4[i2][i], fArr4[i6][i]);
            }
            i2 = i6;
        }
        return 0.0f;
    }

    public static /* synthetic */ void getPos$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        monoSpline.getPos(f, animationVector, i);
    }

    public final void getPos(float f, AnimationVector animationVector, int i) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i2 = 0;
        int length2 = this.values[0].length;
        if (this.isExtrapolate) {
            float f2 = fArr[0];
            if (f <= f2) {
                getSlope(f2, this.slopeTemp);
                for (int i3 = 0; i3 < length2; i3++) {
                    animationVector.set$animation_core_release(i3, this.values[0][i3] + ((f - this.timePoints[0]) * this.slopeTemp[i3]));
                }
                return;
            }
            int i4 = length - 1;
            float f3 = fArr[i4];
            if (f >= f3) {
                getSlope(f3, this.slopeTemp);
                while (i2 < length2) {
                    animationVector.set$animation_core_release(i2, this.values[i4][i2] + ((f - this.timePoints[i4]) * this.slopeTemp[i2]));
                    i2++;
                }
                return;
            }
        } else if (f <= fArr[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                animationVector.set$animation_core_release(i5, this.values[0][i5]);
            }
            return;
        } else {
            int i6 = length - 1;
            if (f >= fArr[i6]) {
                while (i2 < length2) {
                    animationVector.set$animation_core_release(i2, this.values[i6][i2]);
                    i2++;
                }
                return;
            }
        }
        int i7 = length - 1;
        int i8 = i;
        while (i8 < i7) {
            if (f == this.timePoints[i8]) {
                for (int i9 = 0; i9 < length2; i9++) {
                    animationVector.set$animation_core_release(i9, this.values[i8][i9]);
                }
            }
            float[] fArr2 = this.timePoints;
            int i10 = i8 + 1;
            float f4 = fArr2[i10];
            if (f < f4) {
                float f5 = fArr2[i8];
                float f6 = f4 - f5;
                float f7 = (f - f5) / f6;
                int i11 = 0;
                while (i11 < length2) {
                    float[][] fArr3 = this.values;
                    float f8 = fArr3[i8][i11];
                    float f9 = fArr3[i10][i11];
                    float[][] fArr4 = this.tangents;
                    float f10 = f8;
                    float f11 = f9;
                    float f12 = f6;
                    animationVector.set$animation_core_release(i11, interpolate(f12, f7, f10, f11, fArr4[i8][i11], fArr4[i10][i11]));
                    i11++;
                    f6 = f12;
                }
                return;
            }
            i8 = i10;
        }
    }

    public final void getSlope(float f, float[] fArr) {
        float f2;
        float[] fArr2 = this.timePoints;
        int length = fArr2.length;
        int length2 = this.values[0].length;
        float f3 = fArr2[0];
        if (f <= f3) {
            f2 = f3;
        } else {
            f2 = fArr2[length - 1];
            if (f < f2) {
                f2 = f;
            }
        }
        int i = length - 1;
        int i2 = 0;
        while (i2 < i) {
            float[] fArr3 = this.timePoints;
            int i3 = i2 + 1;
            float f4 = fArr3[i3];
            if (f2 <= f4) {
                float f5 = fArr3[i2];
                float f6 = f4 - f5;
                float f7 = (f2 - f5) / f6;
                int i4 = 0;
                while (i4 < length2) {
                    float[][] fArr4 = this.values;
                    float f8 = fArr4[i2][i4];
                    float f9 = fArr4[i3][i4];
                    float[][] fArr5 = this.tangents;
                    float f10 = fArr5[i2][i4];
                    float f11 = fArr5[i3][i4];
                    float f12 = f6;
                    fArr[i4] = diff(f12, f7, f8, f9, f10, f11) / f12;
                    i4++;
                    f6 = f12;
                }
                return;
            }
            i2 = i3;
        }
    }

    public static /* synthetic */ void getSlope$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        monoSpline.getSlope(f, animationVector, i);
    }

    public final void getSlope(float f, AnimationVector animationVector, int i) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int length2 = this.values[0].length;
        if (f <= fArr[0]) {
            for (int i2 = 0; i2 < length2; i2++) {
                animationVector.set$animation_core_release(i2, this.tangents[0][i2]);
            }
            return;
        }
        int i3 = length - 1;
        if (f >= fArr[i3]) {
            for (int i4 = 0; i4 < length2; i4++) {
                animationVector.set$animation_core_release(i4, this.tangents[i3][i4]);
            }
            return;
        }
        int i5 = i;
        while (i5 < i3) {
            float[] fArr2 = this.timePoints;
            int i6 = i5 + 1;
            float f2 = fArr2[i6];
            if (f <= f2) {
                float f3 = fArr2[i5];
                float f4 = f2 - f3;
                float f5 = (f - f3) / f4;
                int i7 = 0;
                while (i7 < length2) {
                    float[][] fArr3 = this.values;
                    float f6 = fArr3[i5][i7];
                    float f7 = fArr3[i6][i7];
                    float[][] fArr4 = this.tangents;
                    float f8 = f6;
                    float f9 = f7;
                    float f10 = f4;
                    animationVector.set$animation_core_release(i7, diff(f10, f5, f8, f9, fArr4[i5][i7], fArr4[i6][i7]) / f10);
                    i7++;
                    f4 = f10;
                }
                return;
            }
            i5 = i6;
        }
    }

    private final float getSlope(float f, int i) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i2 = 0;
        float f2 = fArr[0];
        if (f < f2) {
            f = f2;
        } else {
            float f3 = fArr[length - 1];
            if (f >= f3) {
                f = f3;
            }
        }
        int i3 = length - 1;
        while (i2 < i3) {
            float[] fArr2 = this.timePoints;
            int i4 = i2 + 1;
            float f4 = fArr2[i4];
            if (f <= f4) {
                float f5 = fArr2[i2];
                float f6 = f4 - f5;
                float f7 = (f - f5) / f6;
                float[][] fArr3 = this.values;
                float f8 = fArr3[i2][i];
                float f9 = fArr3[i4][i];
                float[][] fArr4 = this.tangents;
                return diff(f6, f7, f8, f9, fArr4[i2][i], fArr4[i4][i]) / f6;
            }
            i2 = i4;
        }
        return 0.0f;
    }
}
