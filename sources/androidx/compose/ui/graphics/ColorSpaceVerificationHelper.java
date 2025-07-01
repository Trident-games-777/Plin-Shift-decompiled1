package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/ColorSpaceVerificationHelper;", "", "()V", "androidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "composeColorSpace", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidColorSpace.android.kt */
final class ColorSpaceVerificationHelper {
    public static final ColorSpaceVerificationHelper INSTANCE = new ColorSpaceVerificationHelper();

    private ColorSpaceVerificationHelper() {
    }

    @JvmStatic
    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpace.Rgb.TransferParameters transferParameters;
        ColorSpace.Rgb rgb;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace2 = colorSpace;
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getSrgb())) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getAces())) {
            return ColorSpace.get(ColorSpace.Named.ACES);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getAcescg())) {
            return ColorSpace.get(ColorSpace.Named.ACESCG);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getAdobeRgb())) {
            return ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getBt2020())) {
            return ColorSpace.get(ColorSpace.Named.BT2020);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getBt709())) {
            return ColorSpace.get(ColorSpace.Named.BT709);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getCieLab())) {
            return ColorSpace.get(ColorSpace.Named.CIE_LAB);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getCieXyz())) {
            return ColorSpace.get(ColorSpace.Named.CIE_XYZ);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getDciP3())) {
            return ColorSpace.get(ColorSpace.Named.DCI_P3);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getDisplayP3())) {
            return ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getExtendedSrgb())) {
            return ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getLinearExtendedSrgb())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getLinearSrgb())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getNtsc1953())) {
            return ColorSpace.get(ColorSpace.Named.NTSC_1953);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getProPhotoRgb())) {
            return ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getSmpteC())) {
            return ColorSpace.get(ColorSpace.Named.SMPTE_C);
        }
        if (!(colorSpace2 instanceof Rgb)) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Rgb rgb2 = (Rgb) colorSpace2;
        float[] xyz$ui_graphics_release = rgb2.getWhitePoint().toXyz$ui_graphics_release();
        TransferParameters transferParameters2 = rgb2.getTransferParameters();
        if (transferParameters2 != null) {
            transferParameters = new ColorSpace.Rgb.TransferParameters(transferParameters2.getA(), transferParameters2.getB(), transferParameters2.getC(), transferParameters2.getD(), transferParameters2.getE(), transferParameters2.getF(), transferParameters2.getGamma());
        } else {
            transferParameters = null;
        }
        if (transferParameters != null) {
            rgb = new ColorSpace.Rgb(colorSpace2.getName(), rgb2.getPrimaries$ui_graphics_release(), xyz$ui_graphics_release, transferParameters);
        } else {
            rgb = new ColorSpace.Rgb(colorSpace2.getName(), rgb2.getPrimaries$ui_graphics_release(), xyz$ui_graphics_release, new ColorSpaceVerificationHelper$$ExternalSyntheticLambda0(rgb2.getOetf()), new ColorSpaceVerificationHelper$$ExternalSyntheticLambda1(rgb2.getEotf()), colorSpace2.getMinValue(0), colorSpace2.getMaxValue(0));
        }
        return rgb;
    }

    /* access modifiers changed from: private */
    public static final double androidColorSpace$lambda$0(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* access modifiers changed from: private */
    public static final double androidColorSpace$lambda$1(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    @JvmStatic
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(ColorSpace colorSpace) {
        Rgb rgb;
        WhitePoint whitePoint;
        TransferParameters transferParameters;
        ColorSpace colorSpace2 = colorSpace;
        int id = colorSpace2.getId();
        if (id == ColorSpace.Named.SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        if (id == ColorSpace.Named.ACES.ordinal()) {
            return ColorSpaces.INSTANCE.getAces();
        }
        if (id == ColorSpace.Named.ACESCG.ordinal()) {
            return ColorSpaces.INSTANCE.getAcescg();
        }
        if (id == ColorSpace.Named.ADOBE_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getAdobeRgb();
        }
        if (id == ColorSpace.Named.BT2020.ordinal()) {
            return ColorSpaces.INSTANCE.getBt2020();
        }
        if (id == ColorSpace.Named.BT709.ordinal()) {
            return ColorSpaces.INSTANCE.getBt709();
        }
        if (id == ColorSpace.Named.CIE_LAB.ordinal()) {
            return ColorSpaces.INSTANCE.getCieLab();
        }
        if (id == ColorSpace.Named.CIE_XYZ.ordinal()) {
            return ColorSpaces.INSTANCE.getCieXyz();
        }
        if (id == ColorSpace.Named.DCI_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDciP3();
        }
        if (id == ColorSpace.Named.DISPLAY_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDisplayP3();
        }
        if (id == ColorSpace.Named.EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearSrgb();
        }
        if (id == ColorSpace.Named.NTSC_1953.ordinal()) {
            return ColorSpaces.INSTANCE.getNtsc1953();
        }
        if (id == ColorSpace.Named.PRO_PHOTO_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getProPhotoRgb();
        }
        if (id == ColorSpace.Named.SMPTE_C.ordinal()) {
            return ColorSpaces.INSTANCE.getSmpteC();
        }
        if (colorSpace2 instanceof ColorSpace.Rgb) {
            ColorSpace.Rgb rgb2 = (ColorSpace.Rgb) colorSpace2;
            ColorSpace.Rgb.TransferParameters transferParameters2 = rgb2.getTransferParameters();
            if (rgb2.getWhitePoint().length == 3) {
                whitePoint = new WhitePoint(rgb2.getWhitePoint()[0], rgb2.getWhitePoint()[1], rgb2.getWhitePoint()[2]);
            } else {
                whitePoint = new WhitePoint(rgb2.getWhitePoint()[0], rgb2.getWhitePoint()[1]);
            }
            WhitePoint whitePoint2 = whitePoint;
            if (transferParameters2 != null) {
                double d = transferParameters2.g;
                double d2 = transferParameters2.a;
                double d3 = transferParameters2.b;
                double d4 = d3;
                transferParameters = new TransferParameters(d, d2, d4, transferParameters2.c, transferParameters2.d, transferParameters2.e, transferParameters2.f);
            } else {
                transferParameters = null;
            }
            rgb = new Rgb(rgb2.getName(), rgb2.getPrimaries(), whitePoint2, rgb2.getTransform(), new ColorSpaceVerificationHelper$$ExternalSyntheticLambda2(colorSpace2), new ColorSpaceVerificationHelper$$ExternalSyntheticLambda3(colorSpace2), colorSpace2.getMinValue(0), colorSpace2.getMaxValue(0), transferParameters, rgb2.getId());
        } else {
            rgb = ColorSpaces.INSTANCE.getSrgb();
        }
        return rgb;
    }

    /* access modifiers changed from: private */
    public static final double composeColorSpace$lambda$2(ColorSpace colorSpace, double d) {
        return ((ColorSpace.Rgb) colorSpace).getOetf().applyAsDouble(d);
    }

    /* access modifiers changed from: private */
    public static final double composeColorSpace$lambda$3(ColorSpace colorSpace, double d) {
        return ((ColorSpace.Rgb) colorSpace).getEotf().applyAsDouble(d);
    }
}
