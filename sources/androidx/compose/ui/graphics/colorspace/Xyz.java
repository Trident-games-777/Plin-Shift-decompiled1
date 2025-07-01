package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J%\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\u001bJ=\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Xyz;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "clamp", "", "x", "fromXyz", "", "v", "getMaxValue", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Xyz.kt */
public final class Xyz extends ColorSpace {
    private final float clamp(float f) {
        if (f < -2.0f) {
            f = -2.0f;
        }
        if (f > 2.0f) {
            return 2.0f;
        }
        return f;
    }

    public float getMaxValue(int i) {
        return 2.0f;
    }

    public float getMinValue(int i) {
        return -2.0f;
    }

    public boolean isWideGamut() {
        return true;
    }

    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        if (f3 < -2.0f) {
            f3 = -2.0f;
        }
        if (f3 > 2.0f) {
            return 2.0f;
        }
        return f3;
    }

    public Xyz(String str, int i) {
        super(str, ColorModel.Companion.m4697getXyzxdoWZVw(), i, (DefaultConstructorMarker) null);
    }

    public float[] toXyz(float[] fArr) {
        float f = fArr[0];
        float f2 = -2.0f;
        if (f < -2.0f) {
            f = -2.0f;
        }
        float f3 = 2.0f;
        if (f > 2.0f) {
            f = 2.0f;
        }
        fArr[0] = f;
        float f4 = fArr[1];
        if (f4 < -2.0f) {
            f4 = -2.0f;
        }
        if (f4 > 2.0f) {
            f4 = 2.0f;
        }
        fArr[1] = f4;
        float f5 = fArr[2];
        if (f5 >= -2.0f) {
            f2 = f5;
        }
        if (f2 <= 2.0f) {
            f3 = f2;
        }
        fArr[2] = f3;
        return fArr;
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release  reason: not valid java name */
    public long m4730xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        if (f < -2.0f) {
            f = -2.0f;
        }
        float f5 = 2.0f;
        if (f > 2.0f) {
            f = 2.0f;
        }
        if (f2 < -2.0f) {
            f2 = -2.0f;
        }
        if (f2 > 2.0f) {
            f2 = 2.0f;
        }
        if (f3 < -2.0f) {
            f3 = -2.0f;
        }
        if (f3 <= 2.0f) {
            f5 = f3;
        }
        return ColorKt.Color(f, f2, f5, f4, colorSpace);
    }

    public float[] fromXyz(float[] fArr) {
        float f = fArr[0];
        float f2 = -2.0f;
        if (f < -2.0f) {
            f = -2.0f;
        }
        float f3 = 2.0f;
        if (f > 2.0f) {
            f = 2.0f;
        }
        fArr[0] = f;
        float f4 = fArr[1];
        if (f4 < -2.0f) {
            f4 = -2.0f;
        }
        if (f4 > 2.0f) {
            f4 = 2.0f;
        }
        fArr[1] = f4;
        float f5 = fArr[2];
        if (f5 >= -2.0f) {
            f2 = f5;
        }
        if (f2 <= 2.0f) {
            f3 = f2;
        }
        fArr[2] = f3;
        return fArr;
    }

    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        if (f < -2.0f) {
            f = -2.0f;
        }
        float f4 = 2.0f;
        if (f > 2.0f) {
            f = 2.0f;
        }
        if (f2 < -2.0f) {
            f2 = -2.0f;
        }
        if (f2 <= 2.0f) {
            f4 = f2;
        }
        return (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L);
    }
}
