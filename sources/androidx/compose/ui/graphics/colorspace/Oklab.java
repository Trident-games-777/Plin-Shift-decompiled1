package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J%\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0019J=\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Oklab.kt */
public final class Oklab extends ColorSpace {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float[] InverseM1;
    private static final float[] InverseM2;
    private static final float[] M1;
    private static final float[] M2;

    public float getMaxValue(int i) {
        return i == 0 ? 1.0f : 0.5f;
    }

    public float getMinValue(int i) {
        return i == 0 ? 0.0f : -0.5f;
    }

    public boolean isWideGamut() {
        return true;
    }

    public Oklab(String str, int i) {
        super(str, ColorModel.Companion.m4695getLabxdoWZVw(), i, (DefaultConstructorMarker) null);
    }

    public float[] toXyz(float[] fArr) {
        float f = fArr[0];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        fArr[0] = f;
        float f2 = fArr[1];
        float f3 = -0.5f;
        if (f2 < -0.5f) {
            f2 = -0.5f;
        }
        float f4 = 0.5f;
        if (f2 > 0.5f) {
            f2 = 0.5f;
        }
        fArr[1] = f2;
        float f5 = fArr[2];
        if (f5 >= -0.5f) {
            f3 = f5;
        }
        if (f3 <= 0.5f) {
            f4 = f3;
        }
        fArr[2] = f4;
        ColorSpaceKt.mul3x3Float3(InverseM2, fArr);
        float f6 = fArr[0];
        fArr[0] = f6 * f6 * f6;
        float f7 = fArr[1];
        fArr[1] = f7 * f7 * f7;
        float f8 = fArr[2];
        fArr[2] = f8 * f8 * f8;
        ColorSpaceKt.mul3x3Float3(InverseM1, fArr);
        return fArr;
    }

    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < -0.5f) {
            f2 = -0.5f;
        }
        float f4 = 0.5f;
        if (f2 > 0.5f) {
            f2 = 0.5f;
        }
        if (f3 < -0.5f) {
            f3 = -0.5f;
        }
        if (f3 <= 0.5f) {
            f4 = f3;
        }
        float[] fArr = InverseM2;
        float f5 = (fArr[0] * f) + (fArr[3] * f2) + (fArr[6] * f4);
        float f6 = (fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f4);
        float f7 = (fArr[2] * f) + (fArr[5] * f2) + (fArr[8] * f4);
        float f8 = f5 * f5 * f5;
        float f9 = f6 * f6 * f6;
        float f10 = f7 * f7 * f7;
        float[] fArr2 = InverseM1;
        return (((long) Float.floatToRawIntBits(((fArr2[0] * f8) + (fArr2[3] * f9)) + (fArr2[6] * f10))) << 32) | (((long) Float.floatToRawIntBits((fArr2[1] * f8) + (fArr2[4] * f9) + (fArr2[7] * f10))) & 4294967295L);
    }

    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < -0.5f) {
            f2 = -0.5f;
        }
        float f4 = 0.5f;
        if (f2 > 0.5f) {
            f2 = 0.5f;
        }
        if (f3 < -0.5f) {
            f3 = -0.5f;
        }
        if (f3 <= 0.5f) {
            f4 = f3;
        }
        float[] fArr = InverseM2;
        float f5 = (fArr[0] * f) + (fArr[3] * f2) + (fArr[6] * f4);
        float f6 = (fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f4);
        float f7 = (fArr[2] * f) + (fArr[5] * f2) + (fArr[8] * f4);
        float f8 = f5 * f5 * f5;
        float f9 = f6 * f6 * f6;
        float[] fArr2 = InverseM1;
        return (fArr2[2] * f8) + (fArr2[5] * f9) + (fArr2[8] * f7 * f7 * f7);
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release  reason: not valid java name */
    public long m4712xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float[] fArr = M1;
        float f5 = (fArr[2] * f) + (fArr[5] * f2) + (fArr[8] * f3);
        float fastCbrt = MathHelpersKt.fastCbrt((fArr[0] * f) + (fArr[3] * f2) + (fArr[6] * f3));
        float fastCbrt2 = MathHelpersKt.fastCbrt((fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f3));
        float fastCbrt3 = MathHelpersKt.fastCbrt(f5);
        float[] fArr2 = M2;
        return ColorKt.Color((fArr2[0] * fastCbrt) + (fArr2[3] * fastCbrt2) + (fArr2[6] * fastCbrt3), (fArr2[1] * fastCbrt) + (fArr2[4] * fastCbrt2) + (fArr2[7] * fastCbrt3), (fArr2[2] * fastCbrt) + (fArr2[5] * fastCbrt2) + (fArr2[8] * fastCbrt3), f4, colorSpace);
    }

    public float[] fromXyz(float[] fArr) {
        ColorSpaceKt.mul3x3Float3(M1, fArr);
        fArr[0] = MathHelpersKt.fastCbrt(fArr[0]);
        fArr[1] = MathHelpersKt.fastCbrt(fArr[1]);
        fArr[2] = MathHelpersKt.fastCbrt(fArr[2]);
        ColorSpaceKt.mul3x3Float3(M2, fArr);
        return fArr;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab$Companion;", "", "()V", "InverseM1", "", "InverseM2", "M1", "M2", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Oklab.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        float[] mul3x3 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(Adaptation.Companion.getBradford().getTransform$ui_graphics_release(), Illuminant.INSTANCE.getD50().toXyz$ui_graphics_release(), Illuminant.INSTANCE.getD65().toXyz$ui_graphics_release()));
        M1 = mul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        M2 = fArr;
        InverseM1 = ColorSpaceKt.inverse3x3(mul3x3);
        InverseM2 = ColorSpaceKt.inverse3x3(fArr);
    }
}
