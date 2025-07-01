package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J%\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0019J=\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Lab.kt */
public final class Lab extends ColorSpace {
    private static final float A = 0.008856452f;
    private static final float B = 7.787037f;
    private static final float C = 0.13793103f;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float D = 0.20689656f;

    public float getMaxValue(int i) {
        return i == 0 ? 100.0f : 128.0f;
    }

    public float getMinValue(int i) {
        return i == 0 ? 0.0f : -128.0f;
    }

    public boolean isWideGamut() {
        return true;
    }

    public Lab(String str, int i) {
        super(str, ColorModel.Companion.m4695getLabxdoWZVw(), i, (DefaultConstructorMarker) null);
    }

    public float[] toXyz(float[] fArr) {
        float f = fArr[0];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        fArr[0] = f;
        float f2 = fArr[1];
        float f3 = -128.0f;
        if (f2 < -128.0f) {
            f2 = -128.0f;
        }
        float f4 = 128.0f;
        if (f2 > 128.0f) {
            f2 = 128.0f;
        }
        fArr[1] = f2;
        float f5 = fArr[2];
        if (f5 >= -128.0f) {
            f3 = f5;
        }
        if (f3 <= 128.0f) {
            f4 = f3;
        }
        fArr[2] = f4;
        float f6 = (f + 16.0f) / 116.0f;
        float f7 = (f2 * 0.002f) + f6;
        float f8 = f6 - (f4 * 0.005f);
        float f9 = f7 > D ? f7 * f7 * f7 : (f7 - C) * 0.12841855f;
        float f10 = f6 > D ? f6 * f6 * f6 : (f6 - C) * 0.12841855f;
        float f11 = f8 > D ? f8 * f8 * f8 : (f8 - C) * 0.12841855f;
        fArr[0] = f9 * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        fArr[1] = f10 * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1];
        fArr[2] = f11 * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
        return fArr;
    }

    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        if (f2 < -128.0f) {
            f2 = -128.0f;
        }
        if (f2 > 128.0f) {
            f2 = 128.0f;
        }
        float f4 = (f + 16.0f) / 116.0f;
        float f5 = (f2 * 0.002f) + f4;
        return (((long) Float.floatToRawIntBits((f4 > D ? f4 * f4 * f4 : (f4 - C) * 0.12841855f) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1])) & 4294967295L) | (((long) Float.floatToRawIntBits((f5 > D ? (f5 * f5) * f5 : (f5 - C) * 0.12841855f) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0])) << 32);
    }

    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        if (f3 < -128.0f) {
            f3 = -128.0f;
        }
        if (f3 > 128.0f) {
            f3 = 128.0f;
        }
        float f4 = ((f + 16.0f) / 116.0f) - (f3 * 0.005f);
        return (f4 > D ? f4 * f4 * f4 : 0.12841855f * (f4 - C)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release  reason: not valid java name */
    public long m4711xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float f5 = f / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        float f6 = f2 / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1];
        float f7 = f3 / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
        float cbrt = f5 > A ? (float) Math.cbrt((double) f5) : (f5 * B) + C;
        float cbrt2 = f6 > A ? (float) Math.cbrt((double) f6) : (f6 * B) + C;
        float f8 = (116.0f * cbrt2) - 16.0f;
        float f9 = (cbrt - cbrt2) * 500.0f;
        float cbrt3 = (cbrt2 - (f7 > A ? (float) Math.cbrt((double) f7) : (f7 * B) + C)) * 200.0f;
        if (f8 < 0.0f) {
            f8 = 0.0f;
        }
        if (f8 > 100.0f) {
            f8 = 100.0f;
        }
        if (f9 < -128.0f) {
            f9 = -128.0f;
        }
        float f10 = 128.0f;
        if (f9 > 128.0f) {
            f9 = 128.0f;
        }
        if (cbrt3 < -128.0f) {
            cbrt3 = -128.0f;
        }
        if (cbrt3 <= 128.0f) {
            f10 = cbrt3;
        }
        return ColorKt.Color(f8, f9, f10, f4, colorSpace);
    }

    public float[] fromXyz(float[] fArr) {
        float f = fArr[0] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        float f2 = fArr[1] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1];
        float f3 = fArr[2] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
        float cbrt = f > A ? (float) Math.cbrt((double) f) : (f * B) + C;
        float cbrt2 = f2 > A ? (float) Math.cbrt((double) f2) : (f2 * B) + C;
        float f4 = (116.0f * cbrt2) - 16.0f;
        float f5 = (cbrt - cbrt2) * 500.0f;
        float cbrt3 = (cbrt2 - (f3 > A ? (float) Math.cbrt((double) f3) : (f3 * B) + C)) * 200.0f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 > 100.0f) {
            f4 = 100.0f;
        }
        fArr[0] = f4;
        if (f5 < -128.0f) {
            f5 = -128.0f;
        }
        float f6 = 128.0f;
        if (f5 > 128.0f) {
            f5 = 128.0f;
        }
        fArr[1] = f5;
        if (cbrt3 < -128.0f) {
            cbrt3 = -128.0f;
        }
        if (cbrt3 <= 128.0f) {
            f6 = cbrt3;
        }
        fArr[2] = f6;
        return fArr;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab$Companion;", "", "()V", "A", "", "B", "C", "D", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Lab.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
