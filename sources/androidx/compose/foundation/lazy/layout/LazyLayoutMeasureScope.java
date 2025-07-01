package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u0016\u0010\u001b\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001b\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001dJ\u0019\u0010\u001b\u001a\u00020\r*\u00020\u0006H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u0001\u0001 ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "measure", "", "Landroidx/compose/ui/layout/Placeable;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutMeasureScope.kt */
public interface LazyLayoutMeasureScope extends MeasureScope {
    /* renamed from: measure-0kLqBqw  reason: not valid java name */
    List<Placeable> m990measure0kLqBqw(int i, long j);

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    float m991toDpGaN1DYA(long j) {
        if (TextUnitType.m7334equalsimpl0(TextUnit.m7305getTypeUIouoOA(j), TextUnitType.Companion.m7339getSpUIouoOA())) {
            return Dp.m7111constructorimpl(TextUnit.m7306getValueimpl(j) * getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m993toDpu2uoSUM(int i) {
        return Dp.m7111constructorimpl(((float) i) / getDensity());
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m992toDpu2uoSUM(float f) {
        return Dp.m7111constructorimpl(f / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m997toSpkPz2Gy4(float f) {
        return TextUnitKt.getSp(f / (getFontScale() * getDensity()));
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m998toSpkPz2Gy4(int i) {
        return TextUnitKt.getSp(((float) i) / (getFontScale() * getDensity()));
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    long m996toSp0xMU5do(float f) {
        return TextUnitKt.getSp(f / getFontScale());
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    long m995toSizeXkaWNTQ(long j) {
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return SizeKt.Size(m7091toPx0680j_4(DpSize.m7209getWidthD9Ej5fM(j)), m7091toPx0680j_4(DpSize.m7207getHeightD9Ej5fM(j)));
        }
        return Size.Companion.m4064getUnspecifiedNHjbRc();
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    long m994toDpSizekrfVVM(long j) {
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return DpKt.m7133DpSizeYgX7TsA(m992toDpu2uoSUM(Size.m4056getWidthimpl(j)), m992toDpu2uoSUM(Size.m4053getHeightimpl(j)));
        }
        return DpSize.Companion.m7218getUnspecifiedMYxV2XQ();
    }
}
