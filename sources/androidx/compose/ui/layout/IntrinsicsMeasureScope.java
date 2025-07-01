package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J`\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u00182\u0019\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b\u001e2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eH\u0016J\u0017\u0010!\u001a\u00020\u0015*\u00020\"H\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010!\u001a\u00020\u0015*\u00020%H\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\"*\u00020%H\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001a\u0010(\u001a\u00020\"*\u00020\bH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010(\u001a\u00020\"*\u00020\u0015H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010-J\u0017\u0010.\u001a\u00020/*\u000200H\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\b*\u00020\"H\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010,J\u0017\u00103\u001a\u00020\b*\u00020%H\u0001ø\u0001\u0000¢\u0006\u0004\b5\u0010*J\r\u00106\u001a\u000207*\u000208H\u0001J\u0017\u00109\u001a\u000200*\u00020/H\u0001ø\u0001\u0000¢\u0006\u0004\b:\u00102J\u0017\u0010;\u001a\u00020%*\u00020\"H\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001a\u0010;\u001a\u00020%*\u00020\bH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010=J\u001a\u0010;\u001a\u00020%*\u00020\u0015H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?R\u0014\u0010\u0007\u001a\u00020\b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8VX\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/ui/layout/IntrinsicsMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "intrinsicMeasureScope", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/unit/LayoutDirection;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
public final class IntrinsicsMeasureScope implements MeasureScope, IntrinsicMeasureScope {
    public static final int $stable = 0;
    private final /* synthetic */ IntrinsicMeasureScope $$delegate_0;
    private final LayoutDirection layoutDirection;

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public boolean isLookingAhead() {
        return this.$$delegate_0.isLookingAhead();
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m5782roundToPxR2X_6o(long j) {
        return this.$$delegate_0.m7085roundToPxR2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m5783roundToPx0680j_4(float f) {
        return this.$$delegate_0.m7086roundToPx0680j_4(f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m5784toDpGaN1DYA(long j) {
        return this.$$delegate_0.m7222toDpGaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m5785toDpu2uoSUM(float f) {
        return this.$$delegate_0.m7087toDpu2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m5786toDpu2uoSUM(int i) {
        return this.$$delegate_0.m7088toDpu2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m5787toDpSizekrfVVM(long j) {
        return this.$$delegate_0.m7089toDpSizekrfVVM(j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m5788toPxR2X_6o(long j) {
        return this.$$delegate_0.m7090toPxR2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m5789toPx0680j_4(float f) {
        return this.$$delegate_0.m7091toPx0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        return this.$$delegate_0.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m5790toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.m7092toSizeXkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m5791toSp0xMU5do(float f) {
        return this.$$delegate_0.m7223toSp0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m5792toSpkPz2Gy4(float f) {
        return this.$$delegate_0.m7093toSpkPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m5793toSpkPz2Gy4(int i) {
        return this.$$delegate_0.m7094toSpkPz2Gy4(i);
    }

    public IntrinsicsMeasureScope(IntrinsicMeasureScope intrinsicMeasureScope, LayoutDirection layoutDirection2) {
        this.layoutDirection = layoutDirection2;
        this.$$delegate_0 = intrinsicMeasureScope;
    }

    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super RulerScope, Unit> function1, Function1<? super Placeable.PlacementScope, Unit> function12) {
        boolean z = false;
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        int coerceAtLeast2 = RangesKt.coerceAtLeast(i2, 0);
        if ((coerceAtLeast & ViewCompat.MEASURED_STATE_MASK) == 0 && (-16777216 & coerceAtLeast2) == 0) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + coerceAtLeast + " x " + coerceAtLeast2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new IntrinsicsMeasureScope$layout$1(coerceAtLeast, coerceAtLeast2, map, function1);
    }
}
