package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0017\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a5\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00192\b\b\u0001\u0010\u0012\u001a\u00020\u00192\b\b\u0001\u0010\u0013\u001a\u00020\u00192\b\b\u0003\u0010\u0014\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a9\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\u0010\u0017\u001a1\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\b\u001a,\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0001\u0010(\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u001e\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0016\u0010/\u001a\u000200*\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u0016\u00103\u001a\u00020\u0011*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a%\u00106\u001a\u00020\u0007*\u00020\u00072\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000708H\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0016\u0010;\u001a\u00020\u0019*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\"\u0018\u0010\u0000\u001a\u00020\u00018\u0000XT¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u001f\u0010\u0005\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001f\u0010\f\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "UncheckedColor", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Color.kt */
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    /* renamed from: isSpecified-8_81llA  reason: not valid java name */
    public static final boolean m4286isSpecified8_81llA(long j) {
        return j != 16;
    }

    /* renamed from: isSpecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m4287isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA  reason: not valid java name */
    public static final boolean m4288isUnspecified8_81llA(long j) {
        return j == 16;
    }

    /* renamed from: isUnspecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m4289isUnspecified8_81llA$annotations(long j) {
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long Color(float r20, float r21, float r22, float r23, androidx.compose.ui.graphics.colorspace.ColorSpace r24) {
        /*
            r0 = r24
            boolean r1 = r0.isSrgb()
            r2 = 16
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            if (r1 == 0) goto L_0x006b
            int r0 = (r23 > r5 ? 1 : (r23 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0015
            r0 = r5
            goto L_0x0017
        L_0x0015:
            r0 = r23
        L_0x0017:
            int r1 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x001c
            r0 = r4
        L_0x001c:
            r1 = 1132396544(0x437f0000, float:255.0)
            float r0 = r0 * r1
            float r0 = r0 + r3
            int r0 = (int) r0
            int r0 = r0 << 24
            int r6 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r6 >= 0) goto L_0x0029
            r6 = r5
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            int r7 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x0030
            r6 = r4
        L_0x0030:
            float r6 = r6 * r1
            float r6 = r6 + r3
            int r6 = (int) r6
            int r2 = r6 << 16
            r0 = r0 | r2
            int r2 = (r21 > r5 ? 1 : (r21 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x003c
            r2 = r5
            goto L_0x003e
        L_0x003c:
            r2 = r21
        L_0x003e:
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0043
            r2 = r4
        L_0x0043:
            float r2 = r2 * r1
            float r2 = r2 + r3
            int r2 = (int) r2
            int r2 = r2 << 8
            r0 = r0 | r2
            int r2 = (r22 > r5 ? 1 : (r22 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r5 = r22
        L_0x0050:
            int r2 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r4 = r5
        L_0x0056:
            float r4 = r4 * r1
            float r4 = r4 + r3
            int r1 = (int) r4
            r0 = r0 | r1
            long r0 = (long) r0
            long r0 = kotlin.ULong.m7997constructorimpl(r0)
            r2 = 32
            long r0 = r0 << r2
            long r0 = kotlin.ULong.m7997constructorimpl(r0)
            long r0 = androidx.compose.ui.graphics.Color.m4235constructorimpl(r0)
            return r0
        L_0x006b:
            int r1 = r0.getComponentCount()
            r6 = 3
            r7 = 1
            r8 = 0
            if (r1 != r6) goto L_0x0076
            r1 = r7
            goto L_0x0077
        L_0x0076:
            r1 = r8
        L_0x0077:
            if (r1 != 0) goto L_0x007e
            java.lang.String r1 = "Color only works with ColorSpaces with 3 components"
            androidx.compose.ui.graphics.InlineClassHelperKt.throwIllegalArgumentException(r1)
        L_0x007e:
            int r1 = r0.getId$ui_graphics_release()
            r6 = -1
            if (r1 == r6) goto L_0x0087
            r6 = r7
            goto L_0x0088
        L_0x0087:
            r6 = r8
        L_0x0088:
            if (r6 != 0) goto L_0x008f
            java.lang.String r6 = "Unknown color space, please use a color space in ColorSpaces"
            androidx.compose.ui.graphics.InlineClassHelperKt.throwIllegalArgumentException(r6)
        L_0x008f:
            float r6 = r0.getMinValue(r8)
            float r9 = r0.getMaxValue(r8)
            int r10 = (r20 > r6 ? 1 : (r20 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r6 = r20
        L_0x009e:
            int r10 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r9 = r6
        L_0x00a4:
            int r6 = java.lang.Float.floatToRawIntBits(r9)
            int r9 = r6 >>> 31
            int r10 = r6 >>> 23
            r11 = 255(0xff, float:3.57E-43)
            r10 = r10 & r11
            r12 = 8388607(0x7fffff, float:1.1754942E-38)
            r13 = r6 & r12
            r14 = 8388608(0x800000, float:1.17549435E-38)
            r15 = -10
            r16 = 512(0x200, float:7.175E-43)
            r17 = 49
            r18 = r2
            r2 = 31
            if (r10 != r11) goto L_0x00ca
            if (r13 == 0) goto L_0x00c7
            r6 = r16
            goto L_0x00c8
        L_0x00c7:
            r6 = r8
        L_0x00c8:
            r10 = r2
            goto L_0x00f7
        L_0x00ca:
            int r10 = r10 + -112
            if (r10 < r2) goto L_0x00d2
            r6 = r8
            r10 = r17
            goto L_0x00f7
        L_0x00d2:
            if (r10 > 0) goto L_0x00e8
            if (r10 < r15) goto L_0x00e5
            r6 = r13 | r14
            int r10 = 1 - r10
            int r6 = r6 >> r10
            r10 = r6 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x00e1
            int r6 = r6 + 8192
        L_0x00e1:
            int r6 = r6 >> 13
            r10 = r8
            goto L_0x00f7
        L_0x00e5:
            r6 = r8
            r10 = r6
            goto L_0x00f7
        L_0x00e8:
            int r13 = r13 >> 13
            r6 = r6 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x00f6
            int r6 = r10 << 10
            r6 = r6 | r13
            int r6 = r6 + r7
            int r9 = r9 << 15
            r6 = r6 | r9
            goto L_0x00fd
        L_0x00f6:
            r6 = r13
        L_0x00f7:
            int r9 = r9 << 15
            int r10 = r10 << 10
            r9 = r9 | r10
            r6 = r6 | r9
        L_0x00fd:
            short r6 = (short) r6
            float r9 = r0.getMinValue(r7)
            float r10 = r0.getMaxValue(r7)
            int r13 = (r21 > r9 ? 1 : (r21 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x010b
            goto L_0x010d
        L_0x010b:
            r9 = r21
        L_0x010d:
            int r13 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r13 <= 0) goto L_0x0112
            goto L_0x0113
        L_0x0112:
            r10 = r9
        L_0x0113:
            int r9 = java.lang.Float.floatToRawIntBits(r10)
            int r10 = r9 >>> 31
            int r13 = r9 >>> 23
            r13 = r13 & r11
            r19 = r9 & r12
            if (r13 != r11) goto L_0x0128
            if (r19 == 0) goto L_0x0125
            r9 = r16
            goto L_0x0126
        L_0x0125:
            r9 = r8
        L_0x0126:
            r13 = r2
            goto L_0x0157
        L_0x0128:
            int r13 = r13 + -112
            if (r13 < r2) goto L_0x0130
            r9 = r8
            r13 = r17
            goto L_0x0157
        L_0x0130:
            if (r13 > 0) goto L_0x0146
            if (r13 < r15) goto L_0x0143
            r9 = r19 | r14
            int r13 = 1 - r13
            int r9 = r9 >> r13
            r13 = r9 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x013f
            int r9 = r9 + 8192
        L_0x013f:
            int r9 = r9 >> 13
            r13 = r8
            goto L_0x0157
        L_0x0143:
            r9 = r8
            r13 = r9
            goto L_0x0157
        L_0x0146:
            int r19 = r19 >> 13
            r9 = r9 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0155
            int r9 = r13 << 10
            r9 = r9 | r19
            int r9 = r9 + r7
            int r10 = r10 << 15
            r9 = r9 | r10
            goto L_0x015d
        L_0x0155:
            r9 = r19
        L_0x0157:
            int r10 = r10 << 15
            int r13 = r13 << 10
            r10 = r10 | r13
            r9 = r9 | r10
        L_0x015d:
            short r9 = (short) r9
            r10 = 2
            float r10 = r0.getMinValue(r10)
            r13 = 2
            float r0 = r0.getMaxValue(r13)
            int r13 = (r22 > r10 ? 1 : (r22 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r10 = r22
        L_0x016f:
            int r13 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r13 <= 0) goto L_0x0174
            goto L_0x0175
        L_0x0174:
            r0 = r10
        L_0x0175:
            int r0 = java.lang.Float.floatToRawIntBits(r0)
            int r10 = r0 >>> 31
            int r13 = r0 >>> 23
            r13 = r13 & r11
            r12 = r12 & r0
            if (r13 != r11) goto L_0x0188
            if (r12 == 0) goto L_0x0185
            r8 = r16
        L_0x0185:
            r0 = r8
            r8 = r2
            goto L_0x01b4
        L_0x0188:
            int r13 = r13 + -112
            if (r13 < r2) goto L_0x0190
            r0 = r8
            r8 = r17
            goto L_0x01b4
        L_0x0190:
            if (r13 > 0) goto L_0x01a4
            if (r13 < r15) goto L_0x01a2
            r0 = r12 | r14
            int r2 = 1 - r13
            int r0 = r0 >> r2
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x019f
            int r0 = r0 + 8192
        L_0x019f:
            int r0 = r0 >> 13
            goto L_0x01b4
        L_0x01a2:
            r0 = r8
            goto L_0x01b4
        L_0x01a4:
            int r8 = r12 >> 13
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01b2
            int r0 = r13 << 10
            r0 = r0 | r8
            int r0 = r0 + r7
            int r2 = r10 << 15
            r0 = r0 | r2
            goto L_0x01ba
        L_0x01b2:
            r0 = r8
            r8 = r13
        L_0x01b4:
            int r2 = r10 << 15
            int r7 = r8 << 10
            r2 = r2 | r7
            r0 = r0 | r2
        L_0x01ba:
            short r0 = (short) r0
            int r2 = (r23 > r5 ? 1 : (r23 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x01c0
            goto L_0x01c2
        L_0x01c0:
            r5 = r23
        L_0x01c2:
            int r2 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x01c7
            goto L_0x01c8
        L_0x01c7:
            r4 = r5
        L_0x01c8:
            r2 = 1149222912(0x447fc000, float:1023.0)
            float r4 = r4 * r2
            float r4 = r4 + r3
            int r2 = (int) r4
            long r3 = (long) r6
            r5 = 65535(0xffff, double:3.23786E-319)
            long r3 = r3 & r5
            r7 = 48
            long r3 = r3 << r7
            long r7 = (long) r9
            long r7 = r7 & r5
            r9 = 32
            long r7 = r7 << r9
            long r3 = r3 | r7
            long r7 = (long) r0
            long r5 = r5 & r7
            long r5 = r5 << r18
            long r3 = r3 | r5
            long r5 = (long) r2
            r7 = 1023(0x3ff, double:5.054E-321)
            long r5 = r5 & r7
            r0 = 6
            long r5 = r5 << r0
            long r2 = r3 | r5
            long r0 = (long) r1
            r4 = 63
            long r0 = r0 & r4
            long r0 = r0 | r2
            long r0 = kotlin.ULong.m7997constructorimpl(r0)
            long r0 = androidx.compose.ui.graphics.Color.m4235constructorimpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static /* synthetic */ long UncheckedColor$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return UncheckedColor(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long UncheckedColor(float r17, float r18, float r19, float r20, androidx.compose.ui.graphics.colorspace.ColorSpace r21) {
        /*
            r0 = r20
            boolean r1 = r21.isSrgb()
            r2 = 32
            r3 = 16
            r4 = 1056964608(0x3f000000, float:0.5)
            if (r1 == 0) goto L_0x0037
            r1 = 1132396544(0x437f0000, float:255.0)
            float r0 = r0 * r1
            float r0 = r0 + r4
            int r0 = (int) r0
            int r0 = r0 << 24
            float r5 = r17 * r1
            float r5 = r5 + r4
            int r5 = (int) r5
            int r3 = r5 << 16
            r0 = r0 | r3
            float r3 = r18 * r1
            float r3 = r3 + r4
            int r3 = (int) r3
            int r3 = r3 << 8
            r0 = r0 | r3
            float r1 = r1 * r19
            float r1 = r1 + r4
            int r1 = (int) r1
            r0 = r0 | r1
            long r0 = (long) r0
            long r0 = kotlin.ULong.m7997constructorimpl(r0)
            long r0 = r0 << r2
            long r0 = kotlin.ULong.m7997constructorimpl(r0)
            long r0 = androidx.compose.ui.graphics.Color.m4235constructorimpl(r0)
            return r0
        L_0x0037:
            int r1 = java.lang.Float.floatToRawIntBits(r17)
            int r5 = r1 >>> 31
            int r6 = r1 >>> 23
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            r8 = 8388607(0x7fffff, float:1.1754942E-38)
            r9 = r1 & r8
            r10 = 8388608(0x800000, float:1.17549435E-38)
            r11 = -10
            r12 = 512(0x200, float:7.175E-43)
            r13 = 49
            r14 = 0
            r15 = 31
            if (r6 != r7) goto L_0x005b
            if (r9 == 0) goto L_0x0058
            r1 = r12
            goto L_0x0059
        L_0x0058:
            r1 = r14
        L_0x0059:
            r6 = r15
            goto L_0x0088
        L_0x005b:
            int r6 = r6 + -112
            if (r6 < r15) goto L_0x0062
            r6 = r13
            r1 = r14
            goto L_0x0088
        L_0x0062:
            if (r6 > 0) goto L_0x0078
            if (r6 < r11) goto L_0x0075
            r1 = r9 | r10
            int r6 = 1 - r6
            int r1 = r1 >> r6
            r6 = r1 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0071
            int r1 = r1 + 8192
        L_0x0071:
            int r1 = r1 >> 13
            r6 = r14
            goto L_0x0088
        L_0x0075:
            r1 = r14
            r6 = r1
            goto L_0x0088
        L_0x0078:
            int r9 = r9 >> 13
            r1 = r1 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0087
            int r1 = r6 << 10
            r1 = r1 | r9
            int r1 = r1 + 1
            int r5 = r5 << 15
            r1 = r1 | r5
            goto L_0x008e
        L_0x0087:
            r1 = r9
        L_0x0088:
            int r5 = r5 << 15
            int r6 = r6 << 10
            r5 = r5 | r6
            r1 = r1 | r5
        L_0x008e:
            short r1 = (short) r1
            int r5 = java.lang.Float.floatToRawIntBits(r18)
            int r6 = r5 >>> 31
            int r9 = r5 >>> 23
            r9 = r9 & r7
            r16 = r5 & r8
            if (r9 != r7) goto L_0x00a3
            if (r16 == 0) goto L_0x00a0
            r5 = r12
            goto L_0x00a1
        L_0x00a0:
            r5 = r14
        L_0x00a1:
            r9 = r15
            goto L_0x00d2
        L_0x00a3:
            int r9 = r9 + -112
            if (r9 < r15) goto L_0x00aa
            r9 = r13
            r5 = r14
            goto L_0x00d2
        L_0x00aa:
            if (r9 > 0) goto L_0x00c0
            if (r9 < r11) goto L_0x00bd
            r5 = r16 | r10
            int r9 = 1 - r9
            int r5 = r5 >> r9
            r9 = r5 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x00b9
            int r5 = r5 + 8192
        L_0x00b9:
            int r5 = r5 >> 13
            r9 = r14
            goto L_0x00d2
        L_0x00bd:
            r5 = r14
            r9 = r5
            goto L_0x00d2
        L_0x00c0:
            int r16 = r16 >> 13
            r5 = r5 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x00d0
            int r5 = r9 << 10
            r5 = r5 | r16
            int r5 = r5 + 1
            int r6 = r6 << 15
            r5 = r5 | r6
            goto L_0x00d8
        L_0x00d0:
            r5 = r16
        L_0x00d2:
            int r6 = r6 << 15
            int r9 = r9 << 10
            r6 = r6 | r9
            r5 = r5 | r6
        L_0x00d8:
            short r5 = (short) r5
            int r6 = java.lang.Float.floatToRawIntBits(r19)
            int r9 = r6 >>> 31
            r16 = r2
            int r2 = r6 >>> 23
            r2 = r2 & r7
            r8 = r8 & r6
            if (r2 != r7) goto L_0x00ee
            if (r8 == 0) goto L_0x00ea
            goto L_0x00eb
        L_0x00ea:
            r12 = r14
        L_0x00eb:
            r14 = r12
            r13 = r15
            goto L_0x011a
        L_0x00ee:
            int r2 = r2 + -112
            if (r2 < r15) goto L_0x00f3
            goto L_0x011a
        L_0x00f3:
            if (r2 > 0) goto L_0x010a
            if (r2 < r11) goto L_0x0108
            r6 = r8 | r10
            int r2 = 1 - r2
            int r2 = r6 >> r2
            r6 = r2 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0103
            int r2 = r2 + 8192
        L_0x0103:
            int r2 = r2 >> 13
            r13 = r14
            r14 = r2
            goto L_0x011a
        L_0x0108:
            r13 = r14
            goto L_0x011a
        L_0x010a:
            int r14 = r8 >> 13
            r6 = r6 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0119
            int r2 = r2 << 10
            r2 = r2 | r14
            int r2 = r2 + 1
            int r6 = r9 << 15
            r2 = r2 | r6
            goto L_0x0120
        L_0x0119:
            r13 = r2
        L_0x011a:
            int r2 = r9 << 15
            int r6 = r13 << 10
            r2 = r2 | r6
            r2 = r2 | r14
        L_0x0120:
            short r2 = (short) r2
            r6 = 1065353216(0x3f800000, float:1.0)
            float r0 = java.lang.Math.min(r0, r6)
            r6 = 0
            float r0 = java.lang.Math.max(r6, r0)
            r6 = 1149222912(0x447fc000, float:1023.0)
            float r0 = r0 * r6
            float r0 = r0 + r4
            int r0 = (int) r0
            int r4 = r21.getId$ui_graphics_release()
            long r6 = (long) r1
            r8 = 65535(0xffff, double:3.23786E-319)
            long r6 = r6 & r8
            r1 = 48
            long r6 = r6 << r1
            long r10 = (long) r5
            long r10 = r10 & r8
            long r10 = r10 << r16
            long r5 = r6 | r10
            long r1 = (long) r2
            long r1 = r1 & r8
            long r1 = r1 << r3
            long r1 = r1 | r5
            long r5 = (long) r0
            r7 = 1023(0x3ff, double:5.054E-321)
            long r5 = r5 & r7
            r0 = 6
            long r5 = r5 << r0
            long r0 = r1 | r5
            long r2 = (long) r4
            r4 = 63
            long r2 = r2 & r4
            long r0 = r0 | r2
            long r0 = kotlin.ULong.m7997constructorimpl(r0)
            long r0 = androidx.compose.ui.graphics.Color.m4235constructorimpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.UncheckedColor(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long Color(int i) {
        return Color.m4235constructorimpl(ULong.m7997constructorimpl(ULong.m7997constructorimpl((long) i) << 32));
    }

    public static final long Color(long j) {
        return Color.m4235constructorimpl(ULong.m7997constructorimpl(j << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* renamed from: lerp-jxsXWHM  reason: not valid java name */
    public static final long m4290lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long r9 = Color.m4236convertvNxB06k(j, oklab);
        long r1 = Color.m4236convertvNxB06k(j2, oklab);
        float r3 = Color.m4241getAlphaimpl(r9);
        float r4 = Color.m4245getRedimpl(r9);
        float r5 = Color.m4244getGreenimpl(r9);
        float r92 = Color.m4242getBlueimpl(r9);
        float r10 = Color.m4241getAlphaimpl(r1);
        float r6 = Color.m4245getRedimpl(r1);
        float r7 = Color.m4244getGreenimpl(r1);
        float r12 = Color.m4242getBlueimpl(r1);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.m4236convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(r4, r6, f), MathHelpersKt.lerp(r5, r7, f), MathHelpersKt.lerp(r92, r12, f), MathHelpersKt.lerp(r3, r10, f), oklab), Color.m4243getColorSpaceimpl(j2));
    }

    /* renamed from: compositeOver--OWjLjI  reason: not valid java name */
    public static final long m4284compositeOverOWjLjI(long j, long j2) {
        long r9 = Color.m4236convertvNxB06k(j, Color.m4243getColorSpaceimpl(j2));
        float r0 = Color.m4241getAlphaimpl(j2);
        float r1 = Color.m4241getAlphaimpl(r9);
        float f = 1.0f - r1;
        float f2 = (r0 * f) + r1;
        float f3 = 0.0f;
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        float r4 = i == 0 ? 0.0f : ((Color.m4245getRedimpl(r9) * r1) + ((Color.m4245getRedimpl(j2) * r0) * f)) / f2;
        float r5 = i == 0 ? 0.0f : ((Color.m4244getGreenimpl(r9) * r1) + ((Color.m4244getGreenimpl(j2) * r0) * f)) / f2;
        float r92 = Color.m4242getBlueimpl(r9);
        float r10 = Color.m4242getBlueimpl(j2);
        if (i != 0) {
            f3 = ((r92 * r1) + ((r10 * r0) * f)) / f2;
        }
        return UncheckedColor(r4, r5, f3, f2, Color.m4243getColorSpaceimpl(j2));
    }

    /* renamed from: getComponents-8_81llA  reason: not valid java name */
    private static final float[] m4285getComponents8_81llA(long j) {
        return new float[]{Color.m4245getRedimpl(j), Color.m4244getGreenimpl(j), Color.m4242getBlueimpl(j), Color.m4241getAlphaimpl(j)};
    }

    /* renamed from: luminance-8_81llA  reason: not valid java name */
    public static final float m4291luminance8_81llA(long j) {
        ColorSpace r0 = Color.m4243getColorSpaceimpl(j);
        if (!ColorModel.m4689equalsimpl0(r0.m4698getModelxdoWZVw(), ColorModel.Companion.m4696getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ColorModel.m4692toStringimpl(r0.m4698getModelxdoWZVw()));
        }
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) r0).getEotfFunc$ui_graphics_release();
        float invoke = (float) ((eotfFunc$ui_graphics_release.invoke((double) Color.m4245getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke((double) Color.m4244getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke((double) Color.m4242getBlueimpl(j)) * 0.0722d));
        if (invoke < 0.0f) {
            invoke = 0.0f;
        }
        if (invoke > 1.0f) {
            return 1.0f;
        }
        return invoke;
    }

    /* renamed from: toArgb-8_81llA  reason: not valid java name */
    public static final int m4293toArgb8_81llA(long j) {
        return (int) ULong.m7997constructorimpl(Color.m4236convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* renamed from: takeOrElse-DxMtmZc  reason: not valid java name */
    public static final long m4292takeOrElseDxMtmZc(long j, Function0<Color> function0) {
        return j != 16 ? j : function0.invoke().m4249unboximpl();
    }
}
