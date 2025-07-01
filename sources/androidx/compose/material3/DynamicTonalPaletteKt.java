package androidx.compose.material3;

import android.content.Context;
import android.os.Build;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.core.math.MathUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\u001a \u0010\u0012\u001a\u00020\u0013*\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"delinearized", "", "rgbComponent", "", "dynamicDarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "context", "Landroid/content/Context;", "dynamicDarkColorScheme31", "tonalPalette", "Landroidx/compose/material3/TonalPalette;", "dynamicDarkColorScheme34", "dynamicLightColorScheme", "dynamicLightColorScheme31", "dynamicLightColorScheme34", "dynamicTonalPalette", "labInvf", "ft", "setLuminance", "Landroidx/compose/ui/graphics/Color;", "newLuminance", "setLuminance-DxMtmZc", "(JF)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DynamicTonalPalette.android.kt */
public final class DynamicTonalPaletteKt {
    private static final float labInvf(float f) {
        float f2 = f * f * f;
        return f2 > 0.008856452f ? f2 : ((((float) 116) * f) - ((float) 16)) / 903.2963f;
    }

    public static final TonalPalette dynamicTonalPalette(Context context) {
        Context context2 = context;
        long r2 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170461);
        long r4 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170462);
        long r8 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 98.0f);
        long r10 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 96.0f);
        long r17 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170463);
        long r12 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 94.0f);
        long r14 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 92.0f);
        long r6 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170464);
        long j = r2;
        long j2 = r4;
        long r22 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 87.0f);
        long r42 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170465);
        long j3 = r22;
        long r31 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170466);
        long r33 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170467);
        long r35 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170468);
        long r37 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469);
        long r39 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170470);
        long r422 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 24.0f);
        long j4 = r42;
        long r3 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 22.0f);
        long r46 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170471);
        long j5 = r3;
        long r50 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 17.0f);
        long r32 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 12.0f);
        long r54 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170472);
        long j6 = r32;
        long r34 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 6.0f);
        long r60 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170469), 4.0f);
        long r62 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170473);
        long r64 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170474);
        long r66 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170475);
        long j7 = r34;
        long r23 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 98.0f);
        long r43 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 96.0f);
        long j8 = r23;
        long r72 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170476);
        long r74 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 94.0f);
        long r76 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 92.0f);
        long r78 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170477);
        long r80 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 87.0f);
        long r82 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170478);
        long r84 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170479);
        long r86 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170480);
        long r88 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170481);
        long r92 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170483);
        long r94 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 24.0f);
        long r21 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 22.0f);
        long r96 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170484);
        long r98 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 17.0f);
        long r52 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 12.0f);
        long r100 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170485);
        long r102 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 6.0f);
        long r19 = m2040setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), 4.0f);
        long r58 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170486);
        long r104 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170487);
        long r106 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170488);
        long r108 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170489);
        long r110 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170490);
        long r112 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170491);
        long r114 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170492);
        long r116 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170493);
        long r118 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170494);
        long r120 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170495);
        long r122 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170496);
        long r124 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170497);
        long r126 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170498);
        long r128 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170499);
        long r130 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170500);
        long r132 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170501);
        long r134 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170502);
        long r136 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170503);
        long r138 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170504);
        long r140 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170505);
        long r142 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170506);
        long r144 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170507);
        long r146 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170508);
        long r148 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170509);
        long r150 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170510);
        long r152 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170511);
        long r154 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170512);
        long r156 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170513);
        long r158 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170514);
        long r160 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170515);
        long r162 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170516);
        long r164 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170517);
        long r166 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170518);
        long r168 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170519);
        long r170 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170520);
        long r172 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170521);
        long r174 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170522);
        long r176 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170523);
        long r178 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170524);
        long r173 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170525);
        long j9 = r19;
        long j10 = r92;
        long j11 = r21;
        long j12 = r94;
        long j13 = r96;
        long j14 = r98;
        long j15 = r58;
        return new TonalPalette(j, j2, r8, r10, r17, r12, r14, r6, j3, j4, r31, r33, r35, r37, r39, r422, j5, r46, r50, j6, r54, j7, r60, r62, r64, r66, j8, r43, r72, r74, r76, r78, r80, r82, r84, r86, r88, ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170482), j10, j12, j11, j13, j14, r52, r100, r102, j9, j15, r104, r106, r108, r110, r112, r114, r116, r118, r120, r122, r124, r126, r128, r130, r132, r134, r136, r138, r140, r142, r144, r146, r148, r150, r152, r154, r156, r158, r160, r162, r164, r166, r168, r170, r172, r174, r176, r178, r173, (DefaultConstructorMarker) null);
    }

    public static final ColorScheme dynamicLightColorScheme(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return dynamicLightColorScheme34(context);
        }
        return dynamicLightColorScheme31(dynamicTonalPalette(context));
    }

    public static final ColorScheme dynamicDarkColorScheme(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return dynamicDarkColorScheme34(context);
        }
        return dynamicDarkColorScheme31(dynamicTonalPalette(context));
    }

    /* renamed from: setLuminance-DxMtmZc  reason: not valid java name */
    public static final long m2040setLuminanceDxMtmZc(long j, float f) {
        double d = (double) f;
        boolean z = true;
        boolean z2 = d < 1.0E-4d;
        if (d <= 99.9999d) {
            z = false;
        }
        if (z2 || z) {
            int delinearized = delinearized(((float) 100) * labInvf((f + ((float) 16)) / ((float) 116)));
            return ColorKt.Color$default(delinearized, delinearized, delinearized, 0, 8, (Object) null);
        }
        long r7 = Color.m4236convertvNxB06k(j, ColorSpaces.INSTANCE.getCieLab());
        return Color.m4236convertvNxB06k(ColorKt.Color$default(f, Color.m4244getGreenimpl(r7), Color.m4242getBlueimpl(r7), 0.0f, ColorSpaces.INSTANCE.getCieLab(), 8, (Object) null), ColorSpaces.INSTANCE.getSrgb());
    }

    private static final int delinearized(float f) {
        double d = (double) (f / ((float) 100));
        return MathUtils.clamp(MathKt.roundToInt((d <= 0.0031308d ? d * 12.92d : (Math.pow(d, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d), 0, 255);
    }

    public static final ColorScheme dynamicLightColorScheme31(TonalPalette tonalPalette) {
        long r1 = tonalPalette.m2813getPrimary400d7_KjU();
        long r3 = tonalPalette.m2810getPrimary1000d7_KjU();
        long r5 = tonalPalette.m2818getPrimary900d7_KjU();
        long r7 = tonalPalette.m2809getPrimary100d7_KjU();
        long r9 = tonalPalette.m2817getPrimary800d7_KjU();
        long r11 = tonalPalette.m2826getSecondary400d7_KjU();
        long r13 = tonalPalette.m2823getSecondary1000d7_KjU();
        long r15 = tonalPalette.m2831getSecondary900d7_KjU();
        long r17 = tonalPalette.m2822getSecondary100d7_KjU();
        long r19 = tonalPalette.m2839getTertiary400d7_KjU();
        long r21 = tonalPalette.m2836getTertiary1000d7_KjU();
        long r23 = tonalPalette.m2844getTertiary900d7_KjU();
        long r25 = tonalPalette.m2835getTertiary100d7_KjU();
        long r27 = tonalPalette.m2806getNeutralVariant980d7_KjU();
        long r29 = tonalPalette.m2785getNeutralVariant100d7_KjU();
        long r31 = tonalPalette.m2806getNeutralVariant980d7_KjU();
        long r33 = tonalPalette.m2785getNeutralVariant100d7_KjU();
        long r35 = tonalPalette.m2801getNeutralVariant900d7_KjU();
        long r37 = tonalPalette.m2792getNeutralVariant300d7_KjU();
        long r41 = tonalPalette.m2789getNeutralVariant200d7_KjU();
        long r43 = tonalPalette.m2804getNeutralVariant950d7_KjU();
        long r53 = tonalPalette.m2795getNeutralVariant500d7_KjU();
        long r55 = tonalPalette.m2799getNeutralVariant800d7_KjU();
        long r57 = tonalPalette.m2784getNeutralVariant00d7_KjU();
        long r59 = tonalPalette.m2806getNeutralVariant980d7_KjU();
        long r71 = tonalPalette.m2800getNeutralVariant870d7_KjU();
        return ColorSchemeKt.m1892lightColorSchemeCXl9yA$default(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, tonalPalette.m2813getPrimary400d7_KjU(), r41, r43, 0, 0, 0, 0, r53, r55, r57, r59, tonalPalette.m2803getNeutralVariant940d7_KjU(), tonalPalette.m2802getNeutralVariant920d7_KjU(), tonalPalette.m2801getNeutralVariant900d7_KjU(), tonalPalette.m2805getNeutralVariant960d7_KjU(), tonalPalette.m2786getNeutralVariant1000d7_KjU(), r71, 62914560, 0, (Object) null);
    }

    public static final ColorScheme dynamicLightColorScheme34(Context context) {
        Context context2 = context;
        long r3 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170528);
        long r5 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170529);
        long r7 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170526);
        long r9 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170527);
        long r11 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170571);
        long r13 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170532);
        long r15 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170533);
        long r18 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170530);
        long r20 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170531);
        long r22 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170536);
        long r24 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170537);
        long r26 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170534);
        long r28 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170535);
        long r30 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170538);
        long r32 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170539);
        long r34 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170540);
        long r36 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170541);
        long r38 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170549);
        long r40 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170550);
        long r43 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170583);
        long r45 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170584);
        long r55 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170551);
        long r57 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170624);
        long r61 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170547);
        long r73 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170548);
        return ColorSchemeKt.m1892lightColorSchemeCXl9yA$default(r3, r5, r7, r9, r11, r13, r15, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170528), r43, r45, 0, 0, 0, 0, r55, r57, 0, r61, ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170544), ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170545), ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170546), ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170542), ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170543), r73, 331350016, 0, (Object) null);
    }

    public static final ColorScheme dynamicDarkColorScheme31(TonalPalette tonalPalette) {
        long r1 = tonalPalette.m2817getPrimary800d7_KjU();
        long r3 = tonalPalette.m2811getPrimary200d7_KjU();
        long r5 = tonalPalette.m2812getPrimary300d7_KjU();
        long r7 = tonalPalette.m2818getPrimary900d7_KjU();
        long r9 = tonalPalette.m2813getPrimary400d7_KjU();
        long r11 = tonalPalette.m2830getSecondary800d7_KjU();
        long r13 = tonalPalette.m2824getSecondary200d7_KjU();
        long r15 = tonalPalette.m2825getSecondary300d7_KjU();
        long r17 = tonalPalette.m2831getSecondary900d7_KjU();
        long r19 = tonalPalette.m2843getTertiary800d7_KjU();
        long r21 = tonalPalette.m2837getTertiary200d7_KjU();
        long r23 = tonalPalette.m2838getTertiary300d7_KjU();
        long r25 = tonalPalette.m2844getTertiary900d7_KjU();
        long r27 = tonalPalette.m2796getNeutralVariant60d7_KjU();
        long r29 = tonalPalette.m2801getNeutralVariant900d7_KjU();
        long r31 = tonalPalette.m2796getNeutralVariant60d7_KjU();
        long r33 = tonalPalette.m2801getNeutralVariant900d7_KjU();
        long r35 = tonalPalette.m2792getNeutralVariant300d7_KjU();
        long r37 = tonalPalette.m2799getNeutralVariant800d7_KjU();
        long r41 = tonalPalette.m2801getNeutralVariant900d7_KjU();
        long r43 = tonalPalette.m2789getNeutralVariant200d7_KjU();
        long r53 = tonalPalette.m2797getNeutralVariant600d7_KjU();
        long r55 = tonalPalette.m2792getNeutralVariant300d7_KjU();
        long r57 = tonalPalette.m2784getNeutralVariant00d7_KjU();
        long r59 = tonalPalette.m2791getNeutralVariant240d7_KjU();
        long r71 = tonalPalette.m2796getNeutralVariant60d7_KjU();
        return ColorSchemeKt.m1888darkColorSchemeCXl9yA$default(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, tonalPalette.m2817getPrimary800d7_KjU(), r41, r43, 0, 0, 0, 0, r53, r55, r57, r59, tonalPalette.m2787getNeutralVariant120d7_KjU(), tonalPalette.m2788getNeutralVariant170d7_KjU(), tonalPalette.m2790getNeutralVariant220d7_KjU(), tonalPalette.m2785getNeutralVariant100d7_KjU(), tonalPalette.m2793getNeutralVariant40d7_KjU(), r71, 62914560, 0, (Object) null);
    }

    public static final ColorScheme dynamicDarkColorScheme34(Context context) {
        Context context2 = context;
        long r3 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170571);
        long r5 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170572);
        long r7 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170569);
        long r9 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170570);
        long r11 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170528);
        long r13 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170575);
        long r15 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170576);
        long r18 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170573);
        long r20 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170574);
        long r22 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170579);
        long r24 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170580);
        long r26 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170577);
        long r28 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170578);
        long r30 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170581);
        long r32 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170582);
        long r34 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170583);
        long r36 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170584);
        long r38 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170592);
        long r40 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170593);
        long r43 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170540);
        long r45 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170541);
        long r55 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170594);
        long r57 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170625);
        long r61 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170590);
        long r73 = ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170591);
        return ColorSchemeKt.m1888darkColorSchemeCXl9yA$default(r3, r5, r7, r9, r11, r13, r15, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170571), r43, r45, 0, 0, 0, 0, r55, r57, 0, r61, ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170587), ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170588), ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170589), ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170585), ColorResourceHelper.INSTANCE.m1843getColorWaAFU9c(context2, 17170586), r73, 331350016, 0, (Object) null);
    }
}
