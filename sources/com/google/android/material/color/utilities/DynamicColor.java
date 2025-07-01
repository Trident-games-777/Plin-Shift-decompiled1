package com.google.android.material.color.utilities;

import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.function.Function;

public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final ContrastCurve contrastCurve;
    private final HashMap<DynamicScheme, Hct> hctCache = new HashMap<>();
    public final boolean isBackground;
    public final String name;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, TonalPalette> palette;
    public final Function<DynamicScheme, DynamicColor> secondBackground;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaPair> toneDeltaPair;

    static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }

    public DynamicColor(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, boolean z, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, DynamicColor> function4, ContrastCurve contrastCurve2, Function<DynamicScheme, ToneDeltaPair> function5) {
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve2;
        this.toneDeltaPair = function5;
        this.opacity = null;
    }

    public DynamicColor(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, boolean z, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, DynamicColor> function4, ContrastCurve contrastCurve2, Function<DynamicScheme, ToneDeltaPair> function5, Function<DynamicScheme, Double> function6) {
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve2;
        this.toneDeltaPair = function5;
        this.opacity = function6;
    }

    public static DynamicColor fromPalette(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2) {
        return new DynamicColor(str, function, function2, false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public static DynamicColor fromPalette(String str, Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, boolean z) {
        return new DynamicColor(str, function, function2, z, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public static DynamicColor fromArgb(String str, int i) {
        return fromPalette(str, new DynamicColor$$ExternalSyntheticLambda0(TonalPalette.fromInt(i)), new DynamicColor$$ExternalSyntheticLambda1(Hct.fromInt(i)));
    }

    public int getArgb(DynamicScheme dynamicScheme) {
        int i = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(function.apply(dynamicScheme).doubleValue() * 255.0d)) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK);
    }

    public Hct getHct(DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hct2 = this.palette.apply(dynamicScheme).getHct(getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hct2);
        return hct2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0145 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0146 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double getTone(com.google.android.material.color.utilities.DynamicScheme r39) {
        /*
            r38 = this;
            r0 = r38
            r1 = r39
            double r2 = r1.contrastLevel
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 1
            r6 = 0
            if (r2 >= 0) goto L_0x0010
            r2 = r3
            goto L_0x0011
        L_0x0010:
            r2 = r6
        L_0x0011:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.ToneDeltaPair> r7 = r0.toneDeltaPair
            if (r7 == 0) goto L_0x0147
            java.lang.Object r7 = r7.apply(r1)
            com.google.android.material.color.utilities.ToneDeltaPair r7 = (com.google.android.material.color.utilities.ToneDeltaPair) r7
            com.google.android.material.color.utilities.DynamicColor r16 = r7.getRoleA()
            com.google.android.material.color.utilities.DynamicColor r17 = r7.getRoleB()
            double r18 = r7.getDelta()
            r20 = r4
            com.google.android.material.color.utilities.TonePolarity r4 = r7.getPolarity()
            boolean r5 = r7.getStayTogether()
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r7 = r0.background
            java.lang.Object r7 = r7.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r7 = (com.google.android.material.color.utilities.DynamicColor) r7
            r22 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            double r8 = r7.getTone(r1)
            com.google.android.material.color.utilities.TonePolarity r7 = com.google.android.material.color.utilities.TonePolarity.NEARER
            if (r4 == r7) goto L_0x0055
            com.google.android.material.color.utilities.TonePolarity r7 = com.google.android.material.color.utilities.TonePolarity.LIGHTER
            if (r4 != r7) goto L_0x004b
            boolean r7 = r1.isDark
            if (r7 == 0) goto L_0x0055
        L_0x004b:
            com.google.android.material.color.utilities.TonePolarity r7 = com.google.android.material.color.utilities.TonePolarity.DARKER
            if (r4 != r7) goto L_0x0054
            boolean r4 = r1.isDark
            if (r4 == 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r3 = r6
        L_0x0055:
            if (r3 == 0) goto L_0x005a
            r4 = r16
            goto L_0x005c
        L_0x005a:
            r4 = r17
        L_0x005c:
            if (r3 == 0) goto L_0x0061
            r3 = r17
            goto L_0x0063
        L_0x0061:
            r3 = r16
        L_0x0063:
            java.lang.String r6 = r0.name
            java.lang.String r7 = r4.name
            boolean r6 = r6.equals(r7)
            boolean r7 = r1.isDark
            if (r7 == 0) goto L_0x0072
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0074
        L_0x0072:
            r16 = r22
        L_0x0074:
            com.google.android.material.color.utilities.ContrastCurve r7 = r4.contrastCurve
            r24 = 4632233691727265792(0x4049000000000000, double:50.0)
            double r10 = r1.contrastLevel
            double r10 = r7.getContrast(r10)
            com.google.android.material.color.utilities.ContrastCurve r7 = r3.contrastCurve
            r26 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r14 = r1.contrastLevel
            double r14 = r7.getContrast(r14)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r4 = r4.tone
            java.lang.Object r4 = r4.apply(r1)
            java.lang.Double r4 = (java.lang.Double) r4
            r28 = 4632092954238910464(0x4048800000000000, double:49.0)
            double r12 = r4.doubleValue()
            double r22 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r8, r12)
            int r4 = (r22 > r10 ? 1 : (r22 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x00a2
            goto L_0x00a6
        L_0x00a2:
            double r12 = foregroundTone(r8, r10)
        L_0x00a6:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r3 = r3.tone
            java.lang.Object r1 = r3.apply(r1)
            java.lang.Double r1 = (java.lang.Double) r1
            double r3 = r1.doubleValue()
            double r22 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r8, r3)
            int r1 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r1 < 0) goto L_0x00bb
            goto L_0x00bf
        L_0x00bb:
            double r3 = foregroundTone(r8, r14)
        L_0x00bf:
            if (r2 == 0) goto L_0x00c9
            double r12 = foregroundTone(r8, r10)
            double r3 = foregroundTone(r8, r14)
        L_0x00c9:
            double r1 = r3 - r12
            double r1 = r1 * r16
            int r1 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ef
            double r1 = r18 * r16
            double r34 = r12 + r1
            r30 = 0
            r32 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r3 = com.google.android.material.color.utilities.MathUtils.clampDouble(r30, r32, r34)
            double r7 = r3 - r12
            double r7 = r7 * r16
            int r7 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ef
            r32 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r34 = r3 - r1
            r30 = 0
            double r12 = com.google.android.material.color.utilities.MathUtils.clampDouble(r30, r32, r34)
        L_0x00ef:
            int r1 = (r24 > r12 ? 1 : (r24 == r12 ? 0 : -1))
            if (r1 > 0) goto L_0x0110
            int r1 = (r12 > r26 ? 1 : (r12 == r26 ? 0 : -1))
            if (r1 >= 0) goto L_0x0110
            int r1 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x0104
            double r18 = r18 * r16
            double r1 = r18 + r26
            double r12 = java.lang.Math.max(r3, r1)
            goto L_0x0143
        L_0x0104:
            double r18 = r18 * r16
            double r1 = r18 + r28
            double r1 = java.lang.Math.min(r3, r1)
        L_0x010c:
            r12 = r1
            r26 = r28
            goto L_0x0143
        L_0x0110:
            int r1 = (r24 > r3 ? 1 : (r24 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0140
            int r1 = (r3 > r26 ? 1 : (r3 == r26 ? 0 : -1))
            if (r1 >= 0) goto L_0x0140
            if (r5 == 0) goto L_0x0130
            int r1 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x0127
            double r18 = r18 * r16
            double r1 = r18 + r26
            double r12 = java.lang.Math.max(r3, r1)
            goto L_0x0143
        L_0x0127:
            double r18 = r18 * r16
            double r1 = r18 + r28
            double r1 = java.lang.Math.min(r3, r1)
            goto L_0x010c
        L_0x0130:
            int r1 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x013b
            r36 = r26
            r26 = r12
            r12 = r36
            goto L_0x0143
        L_0x013b:
            r26 = r12
            r12 = r28
            goto L_0x0143
        L_0x0140:
            r26 = r12
            r12 = r3
        L_0x0143:
            if (r6 == 0) goto L_0x0146
            return r26
        L_0x0146:
            return r12
        L_0x0147:
            r20 = r4
            r22 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r24 = 4632233691727265792(0x4049000000000000, double:50.0)
            r26 = 4633641066610819072(0x404e000000000000, double:60.0)
            r28 = 4632092954238910464(0x4048800000000000, double:49.0)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r4 = r0.tone
            java.lang.Object r4 = r4.apply(r1)
            java.lang.Double r4 = (java.lang.Double) r4
            double r4 = r4.doubleValue()
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r7 = r0.background
            if (r7 != 0) goto L_0x0165
            return r4
        L_0x0165:
            java.lang.Object r7 = r7.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r7 = (com.google.android.material.color.utilities.DynamicColor) r7
            double r7 = r7.getTone(r1)
            com.google.android.material.color.utilities.ContrastCurve r9 = r0.contrastCurve
            double r10 = r1.contrastLevel
            double r9 = r9.getContrast(r10)
            double r11 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r7, r4)
            int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0180
            goto L_0x0184
        L_0x0180:
            double r4 = foregroundTone(r7, r9)
        L_0x0184:
            if (r2 == 0) goto L_0x018a
            double r4 = foregroundTone(r7, r9)
        L_0x018a:
            boolean r2 = r0.isBackground
            if (r2 == 0) goto L_0x01a5
            int r2 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x01a5
            int r2 = (r4 > r26 ? 1 : (r4 == r26 ? 0 : -1))
            if (r2 >= 0) goto L_0x01a5
            r11 = r28
            double r4 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r11, r7)
            int r2 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r2 < 0) goto L_0x01a2
            r12 = r11
            goto L_0x01a6
        L_0x01a2:
            r12 = r26
            goto L_0x01a6
        L_0x01a5:
            r12 = r4
        L_0x01a6:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r2 = r0.secondBackground
            if (r2 == 0) goto L_0x0226
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r2 = r0.background
            java.lang.Object r2 = r2.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r2 = (com.google.android.material.color.utilities.DynamicColor) r2
            double r4 = r2.getTone(r1)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r2 = r0.secondBackground
            java.lang.Object r2 = r2.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r2 = (com.google.android.material.color.utilities.DynamicColor) r2
            double r1 = r2.getTone(r1)
            double r7 = java.lang.Math.max(r4, r1)
            double r14 = java.lang.Math.min(r4, r1)
            double r16 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r7, r12)
            int r11 = (r16 > r9 ? 1 : (r16 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x01db
            double r16 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r14, r12)
            int r11 = (r16 > r9 ? 1 : (r16 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x01db
            goto L_0x0226
        L_0x01db:
            double r7 = com.google.android.material.color.utilities.Contrast.lighter(r7, r9)
            double r9 = com.google.android.material.color.utilities.Contrast.darker(r14, r9)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            int r12 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r12 == 0) goto L_0x01f3
            java.lang.Double r13 = java.lang.Double.valueOf(r7)
            r11.add(r13)
        L_0x01f3:
            int r13 = (r9 > r22 ? 1 : (r9 == r22 ? 0 : -1))
            if (r13 == 0) goto L_0x01fe
            java.lang.Double r14 = java.lang.Double.valueOf(r9)
            r11.add(r14)
        L_0x01fe:
            boolean r4 = tonePrefersLightForeground(r4)
            if (r4 != 0) goto L_0x0220
            boolean r1 = tonePrefersLightForeground(r1)
            if (r1 == 0) goto L_0x020b
            goto L_0x0220
        L_0x020b:
            int r1 = r11.size()
            if (r1 != r3) goto L_0x021c
            java.lang.Object r1 = r11.get(r6)
            java.lang.Double r1 = (java.lang.Double) r1
            double r1 = r1.doubleValue()
            return r1
        L_0x021c:
            if (r13 != 0) goto L_0x021f
            return r20
        L_0x021f:
            return r9
        L_0x0220:
            if (r12 != 0) goto L_0x0225
            r1 = 4636737291354636288(0x4059000000000000, double:100.0)
            return r1
        L_0x0225:
            return r7
        L_0x0226:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.getTone(com.google.android.material.color.utilities.DynamicScheme):double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double foregroundTone(double r10, double r12) {
        /*
            double r0 = com.google.android.material.color.utilities.Contrast.lighterUnsafe(r10, r12)
            double r2 = com.google.android.material.color.utilities.Contrast.darkerUnsafe(r10, r12)
            double r4 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r0, r10)
            double r6 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r2, r10)
            boolean r10 = tonePrefersLightForeground(r10)
            if (r10 == 0) goto L_0x003b
            double r10 = r4 - r6
            double r10 = java.lang.Math.abs(r10)
            r8 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x002f
            int r10 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x002f
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x002f
            r10 = 1
            goto L_0x0030
        L_0x002f:
            r10 = 0
        L_0x0030:
            int r11 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x0044
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 >= 0) goto L_0x0044
            if (r10 == 0) goto L_0x0045
            goto L_0x0044
        L_0x003b:
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x0045
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 < 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            return r0
        L_0x0045:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.foregroundTone(double, double):double");
    }

    public static double enableLightForeground(double d) {
        if (!tonePrefersLightForeground(d) || toneAllowsLightForeground(d)) {
            return d;
        }
        return 49.0d;
    }

    public static boolean tonePrefersLightForeground(double d) {
        return Math.round(d) < 60;
    }

    public static boolean toneAllowsLightForeground(double d) {
        return Math.round(d) <= 49;
    }
}
