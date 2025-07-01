package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a>\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"horizontal", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "alignmentLine", "before", "Landroidx/compose/ui/unit/Dp;", "after", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "paddingFrom", "Landroidx/compose/ui/Modifier;", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlignmentLine.kt */
public final class AlignmentLineKt {
    /* renamed from: paddingFrom-4j6BHR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m592paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.Companion.m7131getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.Companion.m7131getUnspecifiedD9Ej5fM();
        }
        return m591paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* renamed from: paddingFrom-4j6BHR0  reason: not valid java name */
    public static final Modifier m591paddingFrom4j6BHR0(Modifier modifier, AlignmentLine alignmentLine, float f, float f2) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1(alignmentLine, f, f2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: paddingFrom-Y_r0B1c$default  reason: not valid java name */
    public static /* synthetic */ Modifier m594paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TextUnit.Companion.m7317getUnspecifiedXSAIIZE();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = TextUnit.Companion.m7317getUnspecifiedXSAIIZE();
        }
        return m593paddingFromY_r0B1c(modifier, alignmentLine, j3, j2);
    }

    /* renamed from: paddingFrom-Y_r0B1c  reason: not valid java name */
    public static final Modifier m593paddingFromY_r0B1c(Modifier modifier, AlignmentLine alignmentLine, long j, long j2) {
        Function1<InspectorInfo, Unit> function1;
        long j3;
        long j4;
        AlignmentLine alignmentLine2;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            AlignmentLine alignmentLine3 = alignmentLine;
            long j5 = j;
            long j6 = j2;
            AlignmentLineKt$paddingFromY_r0B1c$$inlined$debugInspectorInfo$1 r9 = new AlignmentLineKt$paddingFromY_r0B1c$$inlined$debugInspectorInfo$1(alignmentLine3, j5, j6);
            alignmentLine2 = alignmentLine3;
            j4 = j5;
            j3 = j6;
            function1 = r9;
        } else {
            alignmentLine2 = alignmentLine;
            j4 = j;
            j3 = j2;
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AlignmentLineOffsetTextUnitElement(alignmentLine2, j4, j3, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: paddingFromBaseline-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m596paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m7131getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m7131getUnspecifiedD9Ej5fM();
        }
        return m595paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    /* renamed from: paddingFromBaseline-VpY3zN4  reason: not valid java name */
    public static final Modifier m595paddingFromBaselineVpY3zN4(Modifier modifier, float f, float f2) {
        Modifier modifier2;
        Modifier modifier3;
        if (!Dp.m7116equalsimpl0(f, Dp.Companion.m7131getUnspecifiedD9Ej5fM())) {
            modifier2 = m592paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        Modifier then = modifier.then(modifier2);
        if (!Dp.m7116equalsimpl0(f2, Dp.Companion.m7131getUnspecifiedD9Ej5fM())) {
            modifier3 = m592paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, (Object) null);
        } else {
            modifier3 = Modifier.Companion;
        }
        return then.then(modifier3);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m598paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.Companion.m7317getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.Companion.m7317getUnspecifiedXSAIIZE();
        }
        return m597paddingFromBaselinewCyjxdI(modifier, j, j2);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI  reason: not valid java name */
    public static final Modifier m597paddingFromBaselinewCyjxdI(Modifier modifier, long j, long j2) {
        return modifier.then(!TextUnitKt.m7324isUnspecifiedR2X_6o(j) ? m594paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), j, 0, 4, (Object) null) : Modifier.Companion).then(!TextUnitKt.m7324isUnspecifiedR2X_6o(j2) ? m594paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0, j2, 2, (Object) null) : Modifier.Companion);
    }

    /* access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA  reason: not valid java name */
    public static final MeasureResult m590alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, AlignmentLine alignmentLine, float f, float f2, Measurable measurable, long j) {
        long j2;
        int i;
        int i2;
        MeasureScope measureScope2 = measureScope;
        float f3 = f;
        float f4 = f2;
        if (getHorizontal(alignmentLine)) {
            j2 = Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null);
        } else {
            j2 = Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 14, (Object) null);
        }
        Placeable r7 = measurable.m5848measureBRTryo0(j2);
        AlignmentLine alignmentLine2 = alignmentLine;
        int i3 = r7.get(alignmentLine2);
        if (i3 == Integer.MIN_VALUE) {
            i3 = 0;
        }
        int height = getHorizontal(alignmentLine2) ? r7.getHeight() : r7.getWidth();
        int r8 = (getHorizontal(alignmentLine2) ? Constraints.m7051getMaxHeightimpl(j) : Constraints.m7052getMaxWidthimpl(j)) - height;
        int coerceIn = RangesKt.coerceIn((!Dp.m7116equalsimpl0(f3, Dp.Companion.m7131getUnspecifiedD9Ej5fM()) ? measureScope2.m7086roundToPx0680j_4(f3) : 0) - i3, 0, r8);
        int coerceIn2 = RangesKt.coerceIn(((!Dp.m7116equalsimpl0(f4, Dp.Companion.m7131getUnspecifiedD9Ej5fM()) ? measureScope2.m7086roundToPx0680j_4(f4) : 0) - height) + i3, 0, r8 - coerceIn);
        if (getHorizontal(alignmentLine2)) {
            i = r7.getWidth();
        } else {
            i = Math.max(r7.getWidth() + coerceIn + coerceIn2, Constraints.m7054getMinWidthimpl(j));
        }
        if (getHorizontal(alignmentLine2)) {
            i2 = Math.max(r7.getHeight() + coerceIn + coerceIn2, Constraints.m7053getMinHeightimpl(j));
        } else {
            i2 = r7.getHeight();
        }
        int i4 = i;
        int i5 = i2;
        return MeasureScope.layout$default(measureScope2, i4, i5, (Map) null, new AlignmentLineKt$alignmentLineOffsetMeasure$1(alignmentLine2, f3, coerceIn, i4, coerceIn2, r7, i5), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }
}
