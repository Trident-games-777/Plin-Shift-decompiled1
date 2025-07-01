package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001aH\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a@\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a\u0017\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\b\u001a\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002\u001aj\u0010\u0014\u001a\u00020\u0004*\u00020\u001f2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001añ\u0001\u0010?\u001a\u00020@*\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u0002022\u0006\u0010(\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010*\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2/\u0010I\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0002\bL\u0012\u0004\u0012\u00020M0JH\u0000ø\u0001\u0000¢\u0006\u0004\bN\u0010O\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageCount", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondViewportPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-bmk8ZPk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasure.kt */
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: androidx.compose.foundation.pager.MeasuredPage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measurePager-bmk8ZPk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.pager.PagerMeasureResult m1098measurePagerbmk8ZPk(androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope r32, int r33, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider r34, int r35, int r36, int r37, int r38, int r39, int r40, long r41, androidx.compose.foundation.gestures.Orientation r43, androidx.compose.ui.Alignment.Vertical r44, androidx.compose.ui.Alignment.Horizontal r45, boolean r46, long r47, int r49, int r50, java.util.List<java.lang.Integer> r51, androidx.compose.foundation.gestures.snapping.SnapPosition r52, androidx.compose.runtime.MutableState<kotlin.Unit> r53, kotlinx.coroutines.CoroutineScope r54, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r55) {
        /*
            r6 = r33
            r14 = r35
            r2 = r36
            r3 = r51
            r4 = r55
            if (r2 < 0) goto L_0x0461
            if (r37 < 0) goto L_0x0455
            int r5 = r49 + r38
            r7 = 0
            int r5 = kotlin.ranges.RangesKt.coerceAtLeast((int) r5, (int) r7)
            if (r6 > 0) goto L_0x005e
            r8 = r41
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            int r6 = -r2
            int r7 = r14 + r37
            int r0 = androidx.compose.ui.unit.Constraints.m7054getMinWidthimpl(r8)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r2 = androidx.compose.ui.unit.Constraints.m7053getMinHeightimpl(r8)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4 r3 = androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4.INSTANCE
            java.lang.Object r0 = r4.invoke(r0, r2, r3)
            r16 = r0
            androidx.compose.ui.layout.MeasureResult r16 = (androidx.compose.ui.layout.MeasureResult) r16
            androidx.compose.foundation.pager.PagerMeasureResult r0 = new androidx.compose.foundation.pager.PagerMeasureResult
            r21 = 393216(0x60000, float:5.51013E-40)
            r22 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r4 = r37
            r3 = r38
            r5 = r43
            r2 = r49
            r9 = r50
            r15 = r52
            r20 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        L_0x005e:
            r8 = r41
            r0 = r43
            r1 = r50
            androidx.compose.foundation.gestures.Orientation r10 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r0 != r10) goto L_0x006f
            int r10 = androidx.compose.ui.unit.Constraints.m7052getMaxWidthimpl(r8)
            r16 = r10
            goto L_0x0071
        L_0x006f:
            r16 = r49
        L_0x0071:
            androidx.compose.foundation.gestures.Orientation r10 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r0 == r10) goto L_0x007c
            int r10 = androidx.compose.ui.unit.Constraints.m7051getMaxHeightimpl(r8)
            r18 = r10
            goto L_0x007e
        L_0x007c:
            r18 = r49
        L_0x007e:
            r19 = 5
            r20 = 0
            r15 = 0
            r17 = 0
            long r17 = androidx.compose.ui.unit.ConstraintsKt.Constraints$default(r15, r16, r17, r18, r19, r20)
            r10 = r39
            r11 = r40
        L_0x008d:
            if (r10 <= 0) goto L_0x0095
            if (r11 <= 0) goto L_0x0095
            int r10 = r10 + -1
            int r11 = r11 - r5
            goto L_0x008d
        L_0x0095:
            int r11 = r11 * -1
            if (r10 < r6) goto L_0x009c
            int r10 = r6 + -1
            r11 = r7
        L_0x009c:
            kotlin.collections.ArrayDeque r12 = new kotlin.collections.ArrayDeque
            r12.<init>()
            int r13 = -r2
            if (r38 >= 0) goto L_0x00a7
            r15 = r38
            goto L_0x00a8
        L_0x00a7:
            r15 = r7
        L_0x00a8:
            int r15 = r15 + r13
            int r11 = r11 + r15
            r28 = r7
        L_0x00ac:
            if (r11 >= 0) goto L_0x00df
            if (r10 <= 0) goto L_0x00df
            int r16 = r10 + -1
            androidx.compose.ui.unit.LayoutDirection r25 = r32.getLayoutDirection()
            r19 = r34
            r24 = r44
            r23 = r45
            r26 = r46
            r20 = r47
            r27 = r49
            r22 = r0
            r0 = r15
            r15 = r32
            androidx.compose.foundation.pager.MeasuredPage r10 = m1097getAndMeasureSGf7dI0(r15, r16, r17, r19, r20, r22, r23, r24, r25, r26, r27)
            r12.add(r7, r10)
            int r10 = r10.getCrossAxisSize()
            r15 = r28
            int r28 = java.lang.Math.max(r15, r10)
            int r11 = r11 + r5
            r15 = r0
            r10 = r16
            r0 = r43
            goto L_0x00ac
        L_0x00df:
            r0 = r15
            r15 = r28
            if (r11 >= r0) goto L_0x00e5
            r11 = r0
        L_0x00e5:
            int r11 = r11 - r0
            int r4 = r14 + r37
            r39 = r10
            int r10 = kotlin.ranges.RangesKt.coerceAtLeast((int) r4, (int) r7)
            int r7 = -r11
            r16 = r39
            r40 = r4
            r20 = r11
            r4 = 0
            r19 = 0
        L_0x00f8:
            int r11 = r12.size()
            r29 = 1
            if (r4 >= r11) goto L_0x010e
            if (r7 < r10) goto L_0x0108
            r12.remove(r4)
            r19 = r29
            goto L_0x00f8
        L_0x0108:
            int r16 = r16 + 1
            int r7 = r7 + r5
            int r4 = r4 + 1
            goto L_0x00f8
        L_0x010e:
            r4 = r15
            r15 = r16
            r30 = r19
            r11 = r20
        L_0x0115:
            if (r15 >= r6) goto L_0x016d
            if (r7 < r10) goto L_0x0121
            if (r7 <= 0) goto L_0x0121
            boolean r16 = r12.isEmpty()
            if (r16 == 0) goto L_0x016d
        L_0x0121:
            androidx.compose.ui.unit.LayoutDirection r25 = r32.getLayoutDirection()
            r19 = r34
            r22 = r43
            r24 = r44
            r23 = r45
            r26 = r46
            r20 = r47
            r27 = r49
            r31 = r10
            r16 = r15
            r15 = r32
            androidx.compose.foundation.pager.MeasuredPage r10 = m1097getAndMeasureSGf7dI0(r15, r16, r17, r19, r20, r22, r23, r24, r25, r26, r27)
            r15 = r16
            r16 = r11
            int r11 = r6 + -1
            if (r15 != r11) goto L_0x0148
            r19 = r49
            goto L_0x014a
        L_0x0148:
            r19 = r5
        L_0x014a:
            int r7 = r7 + r19
            if (r7 > r0) goto L_0x0157
            if (r15 == r11) goto L_0x0157
            int r10 = r15 + 1
            int r11 = r16 - r5
            r30 = r29
            goto L_0x0166
        L_0x0157:
            int r11 = r10.getCrossAxisSize()
            int r4 = java.lang.Math.max(r4, r11)
            r12.add(r10)
            r10 = r39
            r11 = r16
        L_0x0166:
            int r15 = r15 + 1
            r39 = r10
            r10 = r31
            goto L_0x0115
        L_0x016d:
            r16 = r11
            if (r7 >= r14) goto L_0x01b0
            int r0 = r14 - r7
            int r11 = r16 - r0
            int r7 = r7 + r0
            r0 = r4
            r4 = r39
        L_0x0179:
            if (r11 >= r2) goto L_0x01a9
            if (r4 <= 0) goto L_0x01a9
            int r16 = r4 + -1
            androidx.compose.ui.unit.LayoutDirection r25 = r32.getLayoutDirection()
            r19 = r34
            r22 = r43
            r24 = r44
            r23 = r45
            r26 = r46
            r20 = r47
            r27 = r49
            r10 = r15
            r15 = r32
            androidx.compose.foundation.pager.MeasuredPage r4 = m1097getAndMeasureSGf7dI0(r15, r16, r17, r19, r20, r22, r23, r24, r25, r26, r27)
            r15 = 0
            r12.add(r15, r4)
            int r4 = r4.getCrossAxisSize()
            int r0 = java.lang.Math.max(r0, r4)
            int r11 = r11 + r5
            r15 = r10
            r4 = r16
            goto L_0x0179
        L_0x01a9:
            r10 = r15
            r15 = 0
            if (r11 >= 0) goto L_0x01b7
            int r7 = r7 + r11
            r11 = r15
            goto L_0x01b7
        L_0x01b0:
            r10 = r15
            r15 = 0
            r0 = r4
            r11 = r16
            r4 = r39
        L_0x01b7:
            if (r11 < 0) goto L_0x0449
            r39 = r0
            int r0 = -r11
            java.lang.Object r16 = r12.first()
            androidx.compose.foundation.pager.MeasuredPage r16 = (androidx.compose.foundation.pager.MeasuredPage) r16
            if (r2 > 0) goto L_0x01ce
            if (r38 >= 0) goto L_0x01c7
            goto L_0x01ce
        L_0x01c7:
            r27 = r0
        L_0x01c9:
            r31 = r11
            r0 = r16
            goto L_0x01f3
        L_0x01ce:
            int r15 = r12.size()
            r27 = r0
            r0 = 0
        L_0x01d5:
            if (r0 >= r15) goto L_0x01c9
            if (r11 == 0) goto L_0x01c9
            if (r5 > r11) goto L_0x01c9
            r19 = r12
            java.util.List r19 = (java.util.List) r19
            int r2 = kotlin.collections.CollectionsKt.getLastIndex(r19)
            if (r0 == r2) goto L_0x01c9
            int r11 = r11 - r5
            int r0 = r0 + 1
            java.lang.Object r2 = r12.get(r0)
            r16 = r2
            androidx.compose.foundation.pager.MeasuredPage r16 = (androidx.compose.foundation.pager.MeasuredPage) r16
            r2 = r36
            goto L_0x01d5
        L_0x01f3:
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1 r15 = new androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            r16 = r32
            r19 = r34
            r22 = r43
            r24 = r44
            r23 = r45
            r25 = r46
            r20 = r47
            r26 = r49
            r28 = 0
            r15.<init>(r16, r17, r19, r20, r22, r23, r24, r25, r26)
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            java.util.List r2 = createPagesBeforeList(r4, r1, r3, r15)
            int r4 = r2.size()
            r11 = r39
            r15 = r28
        L_0x0218:
            if (r15 >= r4) goto L_0x022f
            java.lang.Object r16 = r2.get(r15)
            androidx.compose.foundation.pager.MeasuredPage r16 = (androidx.compose.foundation.pager.MeasuredPage) r16
            r39 = r2
            int r2 = r16.getCrossAxisSize()
            int r11 = java.lang.Math.max(r11, r2)
            int r15 = r15 + 1
            r2 = r39
            goto L_0x0218
        L_0x022f:
            r39 = r2
            java.lang.Object r2 = r12.last()
            androidx.compose.foundation.pager.MeasuredPage r2 = (androidx.compose.foundation.pager.MeasuredPage) r2
            int r2 = r2.getIndex()
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1 r15 = new androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            r16 = r32
            r19 = r34
            r22 = r43
            r24 = r44
            r23 = r45
            r25 = r46
            r20 = r47
            r26 = r49
            r15.<init>(r16, r17, r19, r20, r22, r23, r24, r25, r26)
            r4 = r22
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            java.util.List r2 = createPagesAfterList(r2, r6, r1, r3, r15)
            int r3 = r2.size()
            r15 = r28
        L_0x025e:
            if (r15 >= r3) goto L_0x0273
            java.lang.Object r16 = r2.get(r15)
            androidx.compose.foundation.pager.MeasuredPage r16 = (androidx.compose.foundation.pager.MeasuredPage) r16
            int r1 = r16.getCrossAxisSize()
            int r11 = java.lang.Math.max(r11, r1)
            int r15 = r15 + 1
            r1 = r50
            goto L_0x025e
        L_0x0273:
            java.lang.Object r1 = r12.first()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x028c
            boolean r1 = r39.isEmpty()
            if (r1 == 0) goto L_0x028c
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x028c
            r1 = r29
            goto L_0x028e
        L_0x028c:
            r1 = r28
        L_0x028e:
            androidx.compose.foundation.gestures.Orientation r3 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r4 != r3) goto L_0x0294
            r3 = r11
            goto L_0x0295
        L_0x0294:
            r3 = r7
        L_0x0295:
            int r3 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r8, r3)
            androidx.compose.foundation.gestures.Orientation r15 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r4 != r15) goto L_0x029e
            r11 = r7
        L_0x029e:
            int r8 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r8, r11)
            r9 = r12
            r12 = r8
            r8 = r9
            java.util.List r8 = (java.util.List) r8
            r18 = r32
            androidx.compose.ui.unit.Density r18 = (androidx.compose.ui.unit.Density) r18
            r19 = r38
            r17 = r46
            r20 = r49
            r11 = r3
            r16 = r4
            r3 = r10
            r21 = r13
            r15 = r27
            r10 = r2
            r13 = r7
            r2 = r9
            r7 = r32
            r9 = r39
            java.util.List r7 = calculatePagesOffsets(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r8 = r16
            if (r1 == 0) goto L_0x02cc
            r17 = r0
            r1 = r7
            goto L_0x031f
        L_0x02cc:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r4 = r7.size()
            r1.<init>(r4)
            int r4 = r7.size()
            r14 = r28
        L_0x02db:
            if (r14 >= r4) goto L_0x0317
            java.lang.Object r15 = r7.get(r14)
            r16 = r15
            androidx.compose.foundation.pager.MeasuredPage r16 = (androidx.compose.foundation.pager.MeasuredPage) r16
            r17 = r0
            int r0 = r16.getIndex()
            java.lang.Object r18 = r2.first()
            androidx.compose.foundation.pager.MeasuredPage r18 = (androidx.compose.foundation.pager.MeasuredPage) r18
            r32 = r1
            int r1 = r18.getIndex()
            if (r0 < r1) goto L_0x0310
            int r0 = r16.getIndex()
            java.lang.Object r1 = r2.last()
            androidx.compose.foundation.pager.MeasuredPage r1 = (androidx.compose.foundation.pager.MeasuredPage) r1
            int r1 = r1.getIndex()
            if (r0 > r1) goto L_0x0310
            r1 = r32
            java.util.Collection r1 = (java.util.Collection) r1
            r1.add(r15)
        L_0x0310:
            int r14 = r14 + 1
            r1 = r32
            r0 = r17
            goto L_0x02db
        L_0x0317:
            r17 = r0
            r32 = r1
            r1 = r32
            java.util.List r1 = (java.util.List) r1
        L_0x031f:
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x032c
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0329:
            r18 = r0
            goto L_0x0369
        L_0x032c:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r4 = r7.size()
            r0.<init>(r4)
            int r4 = r7.size()
            r9 = r28
        L_0x033b:
            if (r9 >= r4) goto L_0x0362
            java.lang.Object r14 = r7.get(r9)
            r15 = r14
            androidx.compose.foundation.pager.MeasuredPage r15 = (androidx.compose.foundation.pager.MeasuredPage) r15
            int r15 = r15.getIndex()
            java.lang.Object r16 = r2.first()
            androidx.compose.foundation.pager.MeasuredPage r16 = (androidx.compose.foundation.pager.MeasuredPage) r16
            r32 = r0
            int r0 = r16.getIndex()
            if (r15 >= r0) goto L_0x035d
            r0 = r32
            java.util.Collection r0 = (java.util.Collection) r0
            r0.add(r14)
        L_0x035d:
            int r9 = r9 + 1
            r0 = r32
            goto L_0x033b
        L_0x0362:
            r32 = r0
            r0 = r32
            java.util.List r0 = (java.util.List) r0
            goto L_0x0329
        L_0x0369:
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x0376
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0373:
            r19 = r0
            goto L_0x03aa
        L_0x0376:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r4 = r7.size()
            r0.<init>(r4)
            int r4 = r7.size()
            r9 = r28
        L_0x0385:
            if (r9 >= r4) goto L_0x03a7
            java.lang.Object r10 = r7.get(r9)
            r14 = r10
            androidx.compose.foundation.pager.MeasuredPage r14 = (androidx.compose.foundation.pager.MeasuredPage) r14
            int r14 = r14.getIndex()
            java.lang.Object r15 = r2.last()
            androidx.compose.foundation.pager.MeasuredPage r15 = (androidx.compose.foundation.pager.MeasuredPage) r15
            int r15 = r15.getIndex()
            if (r14 <= r15) goto L_0x03a4
            r14 = r0
            java.util.Collection r14 = (java.util.Collection) r14
            r14.add(r10)
        L_0x03a4:
            int r9 = r9 + 1
            goto L_0x0385
        L_0x03a7:
            java.util.List r0 = (java.util.List) r0
            goto L_0x0373
        L_0x03aa:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r8 != r0) goto L_0x03b0
            r0 = r12
            goto L_0x03b1
        L_0x03b0:
            r0 = r11
        L_0x03b1:
            r2 = r36
            r10 = r40
            r9 = r55
            r15 = r3
            r4 = r5
            r3 = r37
            r5 = r52
            androidx.compose.foundation.pager.MeasuredPage r14 = calculateNewCurrentPage(r0, r1, r2, r3, r4, r5, r6)
            r16 = r1
            if (r14 == 0) goto L_0x03d8
            int r0 = r14.getIndex()
            r5 = r0
            r6 = r33
            r1 = r35
            r3 = r36
            r2 = r49
            r8 = r4
            r4 = r37
            r0 = r52
            goto L_0x03e7
        L_0x03d8:
            r5 = r28
            r6 = r33
            r1 = r35
            r3 = r36
            r2 = r49
            r0 = r52
            r8 = r4
            r4 = r37
        L_0x03e7:
            int r3 = r0.position(r1, r2, r3, r4, r5, r6)
            if (r14 == 0) goto L_0x03f2
            int r0 = r14.getOffset()
            goto L_0x03f4
        L_0x03f2:
            r0 = r28
        L_0x03f4:
            if (r8 != 0) goto L_0x03f8
            r0 = 0
            goto L_0x0404
        L_0x03f8:
            int r3 = r3 - r0
            float r0 = (float) r3
            float r2 = (float) r8
            float r0 = r0 / r2
            r2 = -1090519040(0xffffffffbf000000, float:-0.5)
            r3 = 1056964608(0x3f000000, float:0.5)
            float r0 = kotlin.ranges.RangesKt.coerceIn((float) r0, (float) r2, (float) r3)
        L_0x0404:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14 r4 = new androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
            r5 = r53
            r4.<init>(r7, r5)
            java.lang.Object r2 = r9.invoke(r2, r3, r4)
            androidx.compose.ui.layout.MeasureResult r2 = (androidx.compose.ui.layout.MeasureResult) r2
            if (r15 < r6) goto L_0x0421
            if (r13 <= r1) goto L_0x041e
            goto L_0x0421
        L_0x041e:
            r7 = r28
            goto L_0x0423
        L_0x0421:
            r7 = r29
        L_0x0423:
            r12 = r0
            androidx.compose.foundation.pager.PagerMeasureResult r0 = new androidx.compose.foundation.pager.PagerMeasureResult
            r4 = r37
            r3 = r38
            r5 = r43
            r8 = r46
            r9 = r50
            r15 = r52
            r20 = r54
            r11 = r14
            r1 = r16
            r6 = r21
            r13 = r31
            r16 = r2
            r14 = r7
            r7 = r10
            r10 = r17
            r17 = r30
            r2 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x0449:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "invalid currentFirstPageScrollOffset"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0455:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative afterContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0461:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative beforeContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerMeasureKt.m1098measurePagerbmk8ZPk(androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, int, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider, int, int, int, int, int, int, long, androidx.compose.foundation.gestures.Orientation, androidx.compose.ui.Alignment$Vertical, androidx.compose.ui.Alignment$Horizontal, boolean, long, int, int, java.util.List, androidx.compose.foundation.gestures.snapping.SnapPosition, androidx.compose.runtime.MutableState, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function3):androidx.compose.foundation.pager.PagerMeasureResult");
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int min = Math.min(i3 + i, i2 - 1);
        int i4 = i + 1;
        List<MeasuredPage> list2 = null;
        if (i4 <= min) {
            while (true) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == min) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = list.get(i5).intValue();
            if (min + 1 <= intValue && intValue < i2) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        List<MeasuredPage> list2 = null;
        if (max <= i3) {
            while (true) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(function1.invoke(Integer.valueOf(i3)));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = list.get(i4).intValue();
            if (intValue < max) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0  reason: not valid java name */
    public static final MeasuredPage m1097getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        Object key = pagerLazyLayoutItemProvider.getKey(i);
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.m990measure0kLqBqw(i, j), j2, key, orientation, horizontal, vertical, layoutDirection, z, (DefaultConstructorMarker) null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        List<MeasuredPage> list4 = list;
        int i8 = i;
        int i9 = i2;
        int i10 = i5;
        Orientation orientation2 = orientation;
        boolean z2 = z;
        int i11 = i6;
        int i12 = i7 + i11;
        int i13 = orientation2 == Orientation.Vertical ? i9 : i8;
        boolean z3 = i3 < Math.min(i13, i4);
        if (!z3 || i10 == 0) {
            ArrayList arrayList = new ArrayList(list4.size() + list2.size() + list3.size());
            if (!z3) {
                int size = list2.size();
                int i14 = i10;
                for (int i15 = 0; i15 < size; i15++) {
                    MeasuredPage measuredPage = list2.get(i15);
                    i14 -= i12;
                    measuredPage.position(i14, i8, i9);
                    arrayList.add(measuredPage);
                }
                int size2 = list4.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    MeasuredPage measuredPage2 = list4.get(i16);
                    measuredPage2.position(i10, i8, i9);
                    arrayList.add(measuredPage2);
                    i10 += i12;
                }
                int size3 = list3.size();
                for (int i17 = 0; i17 < size3; i17++) {
                    MeasuredPage measuredPage3 = list3.get(i17);
                    measuredPage3.position(i10, i8, i9);
                    arrayList.add(measuredPage3);
                    i10 += i12;
                }
            } else if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("No extra pages".toString());
            } else {
                int size4 = list4.size();
                int[] iArr = new int[size4];
                for (int i18 = 0; i18 < size4; i18++) {
                    iArr[i18] = i7;
                }
                int[] iArr2 = new int[size4];
                for (int i19 = 0; i19 < size4; i19++) {
                    iArr2[i19] = 0;
                }
                Arrangement.HorizontalOrVertical r8 = Arrangement.Absolute.INSTANCE.m626spacedBy0680j_4(lazyLayoutMeasureScope.m993toDpu2uoSUM(i11));
                if (orientation2 == Orientation.Vertical) {
                    r8.arrange(density, i13, iArr, iArr2);
                } else {
                    r8.arrange(density, i13, iArr, LayoutDirection.Ltr, iArr2);
                }
                IntProgression indices = ArraysKt.getIndices(iArr2);
                if (z2) {
                    indices = RangesKt.reversed(indices);
                }
                int first = indices.getFirst();
                int last = indices.getLast();
                int step = indices.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        int i20 = iArr2[first];
                        MeasuredPage measuredPage4 = list4.get(calculatePagesOffsets$reverseAware(first, z2, size4));
                        if (z2) {
                            i20 = (i13 - i20) - measuredPage4.getSize();
                        }
                        measuredPage4.position(i20, i8, i9);
                        arrayList.add(measuredPage4);
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            }
            return arrayList;
        }
        throw new IllegalStateException(("non-zero pagesScrollOffset=" + i10).toString());
    }

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i2, int i3, int i4, SnapPosition snapPosition, int i5) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPosition, i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i6 = 1;
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i6);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f2 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPosition, i5));
                    if (Float.compare(f, f2) < 0) {
                        f = f2;
                        measuredPage2 = measuredPage4;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }
}
