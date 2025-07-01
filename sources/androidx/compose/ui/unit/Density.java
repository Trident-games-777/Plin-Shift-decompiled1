package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Density.kt */
public interface Density extends FontScaling {
    float getDensity();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Density.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m7097toDpGaN1DYA(Density density, long j) {
            return Density.super.m7222toDpGaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m7104toSp0xMU5do(Density density, float f) {
            return Density.super.m7223toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m7102toPx0680j_4(Density density, float f) {
            return Density.super.m7091toPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m7096roundToPx0680j_4(Density density, float f) {
            return Density.super.m7086roundToPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m7101toPxR2X_6o(Density density, long j) {
            return Density.super.m7090toPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m7095roundToPxR2X_6o(Density density, long j) {
            return Density.super.m7085roundToPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m7099toDpu2uoSUM(Density density, int i) {
            return Density.super.m7088toDpu2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m7106toSpkPz2Gy4(Density density, int i) {
            return Density.super.m7094toSpkPz2Gy4(i);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m7098toDpu2uoSUM(Density density, float f) {
            return Density.super.m7087toDpu2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m7105toSpkPz2Gy4(Density density, float f) {
            return Density.super.m7093toSpkPz2Gy4(f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return Density.super.toRect(dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m7103toSizeXkaWNTQ(Density density, long j) {
            return Density.super.m7092toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m7100toDpSizekrfVVM(Density density, long j) {
            return Density.super.m7089toDpSizekrfVVM(j);
        }
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    float m7091toPx0680j_4(float f) {
        return f * getDensity();
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    int m7086roundToPx0680j_4(float f) {
        float r2 = m7091toPx0680j_4(f);
        if (Float.isInfinite(r2)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(r2);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    float m7090toPxR2X_6o(long j) {
        if (TextUnitType.m7334equalsimpl0(TextUnit.m7305getTypeUIouoOA(j), TextUnitType.Companion.m7339getSpUIouoOA())) {
            return m7091toPx0680j_4(m7222toDpGaN1DYA(j));
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    int m7085roundToPxR2X_6o(long j) {
        return Math.round(m7090toPxR2X_6o(j));
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m7088toDpu2uoSUM(int i) {
        return Dp.m7111constructorimpl(((float) i) / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m7094toSpkPz2Gy4(int i) {
        return m7223toSp0xMU5do(m7088toDpu2uoSUM(i));
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m7087toDpu2uoSUM(float f) {
        return Dp.m7111constructorimpl(f / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m7093toSpkPz2Gy4(float f) {
        return m7223toSp0xMU5do(m7087toDpu2uoSUM(f));
    }

    Rect toRect(DpRect dpRect) {
        return new Rect(m7091toPx0680j_4(dpRect.m7194getLeftD9Ej5fM()), m7091toPx0680j_4(dpRect.m7196getTopD9Ej5fM()), m7091toPx0680j_4(dpRect.m7195getRightD9Ej5fM()), m7091toPx0680j_4(dpRect.m7193getBottomD9Ej5fM()));
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    long m7092toSizeXkaWNTQ(long j) {
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return SizeKt.Size(m7091toPx0680j_4(DpSize.m7209getWidthD9Ej5fM(j)), m7091toPx0680j_4(DpSize.m7207getHeightD9Ej5fM(j)));
        }
        return Size.Companion.m4064getUnspecifiedNHjbRc();
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    long m7089toDpSizekrfVVM(long j) {
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return DpKt.m7133DpSizeYgX7TsA(m7087toDpu2uoSUM(Size.m4056getWidthimpl(j)), m7087toDpu2uoSUM(Size.m4053getHeightimpl(j)));
        }
        return DpSize.Companion.m7218getUnspecifiedMYxV2XQ();
    }
}
