package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.graphics.GraphicsContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\b\u001a5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\b\u000fH\b¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0001H\b\u001a;\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\"\u001a\u001d\u0010#\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001dH\u0002¢\u0006\u0002\u0010$\u001a\u001c\u0010%\u001a\u00020\u0005*\u00020\u00142\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0003H\u0002\u001a7\u0010(\u001a\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00122\b\b\u0002\u0010)\u001a\u00020\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00050\u000eH\b\u001a\u001c\u0010+\u001a\u00020\u0003*\u00020\u00142\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a+\u0010.\u001a\u00020\u0005*\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eH\bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\f\u00102\u001a\u00020\u0003*\u00020 H\u0002\u001a2\u00103\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u001d2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00030\u000eH\b¢\u0006\u0002\u00104\u001a\u0016\u00105\u001a\u00020\u0003*\u00020 2\b\b\u0002\u00106\u001a\u00020\u0003H\u0000\u001a\u001e\u00107\u001a\u00020\u0003*\u00020 2\u0006\u00108\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a,\u0010;\u001a\u00020<*\u00020\u00142\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u0001H\u0003\u001a\u0001\u0010A\u001a\u00020<*\u00020\f2\u0006\u0010B\u001a\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00032\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\u0014\u0010Y\u001a\u00020\u0005*\u00020 2\u0006\u0010Z\u001a\u00020\u0003H\u0002\u001a!\u0010[\u001a\u00020 *\u00020 2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\\"}, d2 = {"DebugLoggingEnabled", "", "Unset", "", "debugLog", "", "message", "Lkotlin/Function0;", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "calculateVisibleItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[II)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "fastForEach", "reverse", "action", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-XtK8cYQ", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    /* renamed from: measureStaggeredGrid-XtK8cYQ  reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m1055measureStaggeredGridXtK8cYQ(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        int i5;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, graphicsContext, (DefaultConstructorMarker) null);
        LazyStaggeredGridState lazyStaggeredGridState2 = lazyStaggeredGridState;
        int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState2.getScrollPosition$foundation_release().getScrollOffsets();
        if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length || (i5 = updateScrollPositionIfTheFirstItemWasMoved$foundation_release[i6]) == -1) {
                    i5 = i6 == 0 ? 0 : m1054maxInRangejy6DScQ(iArr, SpanRange.m1074constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = i5;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            updateScrollPositionIfTheFirstItemWasMoved$foundation_release = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i7 = 0;
            while (i7 < laneCount2) {
                iArr2[i7] = i7 < scrollOffsets.length ? scrollOffsets[i7] : i7 == 0 ? 0 : iArr2[i7 - 1];
                i7++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState2.getScrollToBeConsumed$foundation_release()), updateScrollPositionIfTheFirstItemWasMoved$foundation_release, scrollOffsets, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02f0, code lost:
        r4 = indexOfMinValue$default(r8, 0, 1, (java.lang.Object) null);
        r5 = indexOfMaxValue(r29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02fb, code lost:
        if (r4 == r5) goto L_0x0306;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0301, code lost:
        if (r8[r4] != r8[r5]) goto L_0x0305;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0303, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0305, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0306, code lost:
        r5 = r29[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0309, code lost:
        if (r5 != -1) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x030b, code lost:
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x030c, code lost:
        r5 = findPreviousItemIndex(r0, r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0310, code lost:
        if (r5 >= 0) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0312, code lost:
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0314, code lost:
        if (r1 != false) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x031a, code lost:
        if (measure$lambda$38$misalignedStart(r7, r0, r8, r4) == false) goto L_0x03db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x031c, code lost:
        if (r47 == false) goto L_0x03db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x031e, code lost:
        r0.getLaneInfo().reset();
        r1 = r7.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0329, code lost:
        if (r3 >= r1) goto L_0x0332;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x032b, code lost:
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0332, code lost:
        r1 = r8.length;
        r3 = new int[r1];
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0336, code lost:
        if (r5 >= r1) goto L_0x033f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0338, code lost:
        r3[r5] = r8[r4];
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0346, code lost:
        return measure(r0, r30, r2, r3, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0347, code lost:
        r7 = r29;
        r10 = r30;
        r46 = r1;
        r45 = r2;
        r1 = r0.m1050getSpanRangelOCCd4c(r0.getItemProvider(), r5, r4);
        r4 = r0.getLaneInfo();
        r9 = r12;
        r26 = r13;
        r12 = (int) (r1 & 4294967295L);
        r29 = r14;
        r13 = (int) (r1 >> 32);
        r14 = r12 - r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0369, code lost:
        if (r14 == 1) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x036b, code lost:
        r23 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x036e, code lost:
        r23 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0370, code lost:
        if (r23 == false) goto L_0x0374;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0372, code lost:
        r15 = -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0374, code lost:
        r15 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0375, code lost:
        r4.setLane(r5, r15);
        r4 = r0.getMeasuredItemProvider().m1062getAndMeasurejy6DScQ(r5, r1);
        r1 = m1054maxInRangejy6DScQ(r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0385, code lost:
        if (r14 == 1) goto L_0x0389;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0387, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0389, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x038a, code lost:
        if (r2 == false) goto L_0x0395;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x038c, code lost:
        r2 = r0.getLaneInfo().getGaps(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0395, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0396, code lost:
        r14 = r13;
        r13 = r46;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0399, code lost:
        if (r14 >= r12) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x039d, code lost:
        if (r8[r14] == r1) goto L_0x03a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x039f, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03a0, code lost:
        r27[r14].addFirst(r4);
        r7[r14] = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03a7, code lost:
        if (r2 != null) goto L_0x03ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03a9, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03ab, code lost:
        r15 = r2[r14];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03ad, code lost:
        r8[r14] = (r1 + r4.getMainAxisSizeWithSpacings()) + r15;
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0548, code lost:
        if (r7[r15] > r13) goto L_0x054a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x05e3, code lost:
        if (r9[r14] < r13) goto L_0x05e5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0565  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0594  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x059b A[LOOP:24: B:245:0x052a->B:269:0x059b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x05fb  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x062c  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x05a4 A[EDGE_INSN: B:423:0x05a4->B:271:0x05a4 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r43, int r44, int[] r45, int[] r46, boolean r47) {
        /*
            r0 = r43
            r1 = r44
            r2 = r45
            r3 = r46
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope r4 = r0.getMeasureScope()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r5 = r0.getItemProvider()
            int r11 = r5.getItemCount()
            if (r11 <= 0) goto L_0x0842
            int r5 = r0.getLaneCount()
            if (r5 != 0) goto L_0x001e
            goto L_0x0842
        L_0x001e:
            int r5 = r2.length
            int[] r7 = java.util.Arrays.copyOf(r2, r5)
            java.lang.String r5 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            int r2 = r3.length
            int[] r8 = java.util.Arrays.copyOf(r3, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            ensureIndicesInRange(r0, r7, r11)
            int r2 = -r1
            offsetBy(r8, r2)
            int r6 = r0.getLaneCount()
            kotlin.collections.ArrayDeque[] r9 = new kotlin.collections.ArrayDeque[r6]
            r2 = 0
        L_0x003e:
            if (r2 >= r6) goto L_0x004c
            kotlin.collections.ArrayDeque r3 = new kotlin.collections.ArrayDeque
            r12 = 16
            r3.<init>((int) r12)
            r9[r2] = r3
            int r2 = r2 + 1
            goto L_0x003e
        L_0x004c:
            int r2 = r0.getBeforeContentPadding()
            int r2 = -r2
            offsetBy(r8, r2)
            r2 = 0
        L_0x0055:
            boolean r3 = measure$lambda$38$hasSpaceBeforeFirst(r7, r8, r0)
            r16 = 32
            r17 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r3 == 0) goto L_0x00e6
            int r3 = indexOfMaxValue(r7)
            r15 = r7[r3]
            int r12 = r8.length
            r10 = 0
            r21 = 0
        L_0x006c:
            if (r10 >= r12) goto L_0x007f
            r13 = r7[r10]
            r14 = r7[r3]
            if (r13 == r14) goto L_0x007c
            r13 = r8[r10]
            r14 = r8[r3]
            if (r13 >= r14) goto L_0x007c
            r8[r10] = r14
        L_0x007c:
            int r10 = r10 + 1
            goto L_0x006c
        L_0x007f:
            int r10 = findPreviousItemIndex(r0, r15, r3)
            if (r10 >= 0) goto L_0x0086
            goto L_0x00e9
        L_0x0086:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r12 = r0.getItemProvider()
            long r12 = r0.m1050getSpanRangelOCCd4c(r12, r10, r3)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r3 = r0.getLaneInfo()
            long r14 = r12 & r17
            int r14 = (int) r14
            r45 = r2
            long r1 = r12 >> r16
            int r1 = (int) r1
            int r2 = r14 - r1
            r15 = 1
            if (r2 == r15) goto L_0x00a1
            r15 = -2
            goto L_0x00a2
        L_0x00a1:
            r15 = r1
        L_0x00a2:
            r3.setLane(r10, r15)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r3 = r0.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r3 = r3.m1062getAndMeasurejy6DScQ(r10, r12)
            int r12 = m1054maxInRangejy6DScQ(r8, r12)
            r15 = 1
            if (r2 == r15) goto L_0x00bd
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r2 = r0.getLaneInfo()
            int[] r2 = r2.getGaps(r10)
            goto L_0x00be
        L_0x00bd:
            r2 = 0
        L_0x00be:
            r13 = r45
        L_0x00c0:
            if (r1 >= r14) goto L_0x00e1
            r7[r1] = r10
            if (r2 != 0) goto L_0x00c9
            r15 = r21
            goto L_0x00cb
        L_0x00c9:
            r15 = r2[r1]
        L_0x00cb:
            int r16 = r3.getMainAxisSizeWithSpacings()
            int r16 = r12 + r16
            int r16 = r16 + r15
            r8[r1] = r16
            int r15 = r0.getMainAxisAvailableSize()
            int r15 = r15 + r16
            if (r15 > 0) goto L_0x00de
            r13 = 1
        L_0x00de:
            int r1 = r1 + 1
            goto L_0x00c0
        L_0x00e1:
            r1 = r44
            r2 = r13
            goto L_0x0055
        L_0x00e6:
            r21 = 0
            r3 = -1
        L_0x00e9:
            r45 = r2
            int r1 = r0.getBeforeContentPadding()
            int r1 = -r1
            r2 = r8[r21]
            if (r2 >= r1) goto L_0x00fc
            int r10 = r44 + r2
            int r2 = r1 - r2
            offsetBy(r8, r2)
            goto L_0x00fe
        L_0x00fc:
            r10 = r44
        L_0x00fe:
            int r2 = r0.getBeforeContentPadding()
            offsetBy(r8, r2)
            r2 = -1
            if (r3 != r2) goto L_0x010e
            r12 = r21
            int r3 = kotlin.collections.ArraysKt.indexOf((int[]) r7, (int) r12)
        L_0x010e:
            if (r3 == r2) goto L_0x013e
            boolean r12 = measure$lambda$38$misalignedStart(r7, r0, r8, r3)
            if (r12 == 0) goto L_0x013e
            if (r47 == 0) goto L_0x013e
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r1 = r0.getLaneInfo()
            r1.reset()
            int r1 = r7.length
            int[] r4 = new int[r1]
            r5 = 0
        L_0x0123:
            if (r5 >= r1) goto L_0x012b
            r4[r5] = r2
            int r5 = r5 + 1
            r2 = -1
            goto L_0x0123
        L_0x012b:
            int r1 = r8.length
            int[] r2 = new int[r1]
            r5 = 0
        L_0x012f:
            if (r5 >= r1) goto L_0x0138
            r6 = r8[r3]
            r2[r5] = r6
            int r5 = r5 + 1
            goto L_0x012f
        L_0x0138:
            r12 = 0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r0 = measure(r0, r10, r4, r2, r12)
            return r0
        L_0x013e:
            int r2 = r7.length
            int[] r12 = java.util.Arrays.copyOf(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r5)
            int r13 = r8.length
            int[] r14 = new int[r13]
            r2 = 0
        L_0x014a:
            if (r2 >= r13) goto L_0x0154
            r3 = r8[r2]
            int r3 = -r3
            r14[r2] = r3
            int r2 = r2 + 1
            goto L_0x014a
        L_0x0154:
            int r2 = r0.getMainAxisSpacing()
            int r15 = r1 + r2
            int r2 = r0.getMainAxisAvailableSize()
            int r3 = r0.getAfterContentPadding()
            int r2 = r2 + r3
            r3 = 0
            int r2 = kotlin.ranges.RangesKt.coerceAtLeast((int) r2, (int) r3)
            r24 = r1
            r25 = r4
            r1 = 0
            r4 = 1
            int r26 = indexOfMinValue$default(r12, r3, r4, r1)
            r44 = r45
            r4 = r26
            r1 = -1
            r3 = 0
        L_0x0178:
            if (r4 == r1) goto L_0x0204
            int r1 = r0.getLaneCount()
            if (r3 >= r1) goto L_0x0204
            r1 = r12[r4]
            int r26 = indexOfMinValue(r12, r1)
            int r3 = r3 + 1
            r45 = r3
            if (r1 < 0) goto L_0x01ff
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r3 = r0.getItemProvider()
            long r3 = r0.m1050getSpanRangelOCCd4c(r3, r1, r4)
            r27 = r9
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r9 = r0.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r9 = r9.m1062getAndMeasurejy6DScQ(r1, r3)
            r28 = r5
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r5 = r0.getLaneInfo()
            r29 = r7
            r46 = r8
            long r7 = r3 & r17
            int r7 = (int) r7
            r30 = r10
            r8 = r11
            long r10 = r3 >> r16
            int r10 = (int) r10
            int r11 = r7 - r10
            r31 = r8
            r8 = 1
            if (r11 == r8) goto L_0x01ba
            r8 = -2
            goto L_0x01bb
        L_0x01ba:
            r8 = r10
        L_0x01bb:
            r5.setLane(r1, r8)
            int r3 = m1054maxInRangejy6DScQ(r14, r3)
            r4 = r10
        L_0x01c3:
            if (r4 >= r7) goto L_0x01d6
            int r5 = r9.getMainAxisSizeWithSpacings()
            int r5 = r5 + r3
            r14[r4] = r5
            r12[r4] = r1
            r5 = r27[r4]
            r5.addLast(r9)
            int r4 = r4 + 1
            goto L_0x01c3
        L_0x01d6:
            if (r3 >= r15) goto L_0x01e2
            r1 = r14[r10]
            if (r1 > r15) goto L_0x01e2
            r3 = 0
            r9.setVisible(r3)
            r1 = 1
            goto L_0x01e4
        L_0x01e2:
            r1 = r44
        L_0x01e4:
            r4 = 1
            if (r11 == r4) goto L_0x01ec
            int r3 = r0.getLaneCount()
            goto L_0x01ee
        L_0x01ec:
            r3 = r45
        L_0x01ee:
            r8 = r46
            r44 = r1
            r4 = r26
            r9 = r27
            r5 = r28
            r7 = r29
            r10 = r30
            r11 = r31
            goto L_0x0201
        L_0x01ff:
            r4 = r26
        L_0x0201:
            r1 = -1
            goto L_0x0178
        L_0x0204:
            r28 = r5
            r29 = r7
            r46 = r8
            r27 = r9
            r30 = r10
            r31 = r11
        L_0x0210:
            r1 = 0
        L_0x0211:
            if (r1 >= r13) goto L_0x0221
            r3 = r14[r1]
            if (r3 < r2) goto L_0x021d
            if (r3 > 0) goto L_0x021a
            goto L_0x021d
        L_0x021a:
            int r1 = r1 + 1
            goto L_0x0211
        L_0x021d:
            r1 = 0
            r3 = 0
            r4 = 1
            goto L_0x0233
        L_0x0221:
            r1 = 0
        L_0x0222:
            if (r1 >= r6) goto L_0x021d
            r3 = r27[r1]
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0230
            r11 = r31
            r4 = 1
            goto L_0x0240
        L_0x0230:
            int r1 = r1 + 1
            goto L_0x0222
        L_0x0233:
            int r5 = indexOfMinValue$default(r14, r3, r4, r1)
            int r1 = kotlin.collections.ArraysKt.maxOrThrow((int[]) r12)
            int r1 = r1 + r4
            r11 = r31
            if (r1 < r11) goto L_0x079e
        L_0x0240:
            r1 = 0
        L_0x0241:
            if (r1 >= r6) goto L_0x0297
            r3 = r27[r1]
        L_0x0245:
            int r5 = r3.size()
            if (r5 <= r4) goto L_0x0283
            java.lang.Object r5 = r3.first()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r5 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r5
            boolean r5 = r5.isVisible()
            if (r5 != 0) goto L_0x0283
            java.lang.Object r5 = r3.removeFirst()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r5 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r5
            int r7 = r5.getSpan()
            if (r7 == r4) goto L_0x0270
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r4 = r0.getLaneInfo()
            int r7 = r5.getIndex()
            int[] r4 = r4.getGaps(r7)
            goto L_0x0271
        L_0x0270:
            r4 = 0
        L_0x0271:
            r7 = r46[r1]
            int r5 = r5.getMainAxisSizeWithSpacings()
            if (r4 != 0) goto L_0x027b
            r4 = 0
            goto L_0x027d
        L_0x027b:
            r4 = r4[r1]
        L_0x027d:
            int r5 = r5 + r4
            int r7 = r7 - r5
            r46[r1] = r7
            r4 = 1
            goto L_0x0245
        L_0x0283:
            java.lang.Object r3 = r3.firstOrNull()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r3 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r3
            if (r3 == 0) goto L_0x0290
            int r3 = r3.getIndex()
            goto L_0x0291
        L_0x0290:
            r3 = -1
        L_0x0291:
            r29[r1] = r3
            int r1 = r1 + 1
            r4 = 1
            goto L_0x0241
        L_0x0297:
            int r1 = r12.length
            r3 = 0
        L_0x0299:
            if (r3 >= r1) goto L_0x02ad
            r4 = r12[r3]
            int r5 = r11 + -1
            if (r4 != r5) goto L_0x02aa
            int r1 = r0.getMainAxisSpacing()
            int r1 = -r1
            offsetBy(r14, r1)
            goto L_0x02ad
        L_0x02aa:
            int r3 = r3 + 1
            goto L_0x0299
        L_0x02ad:
            r1 = 0
        L_0x02ae:
            if (r1 >= r13) goto L_0x02ca
            r3 = r14[r1]
            int r4 = r0.getMainAxisAvailableSize()
            if (r3 >= r4) goto L_0x02bb
            int r1 = r1 + 1
            goto L_0x02ae
        L_0x02bb:
            r8 = r46
            r45 = r2
            r9 = r12
            r26 = r13
            r12 = r14
            r7 = r29
            r10 = r30
            r4 = 0
            goto L_0x040e
        L_0x02ca:
            int r1 = indexOfMaxValue(r14)
            int r3 = r0.getMainAxisAvailableSize()
            r1 = r14[r1]
            int r3 = r3 - r1
            int r1 = -r3
            r8 = r46
            offsetBy(r8, r1)
            offsetBy(r14, r3)
            r1 = 0
        L_0x02df:
            int r4 = r8.length
            r5 = 0
        L_0x02e1:
            if (r5 >= r4) goto L_0x03d9
            r7 = r8[r5]
            int r9 = r0.getBeforeContentPadding()
            if (r7 >= r9) goto L_0x02ed
            r7 = 1
            goto L_0x02ee
        L_0x02ed:
            r7 = 0
        L_0x02ee:
            if (r7 == 0) goto L_0x03c8
            r7 = 0
            r9 = 0
            r15 = 1
            int r4 = indexOfMinValue$default(r8, r9, r15, r7)
            int r5 = indexOfMaxValue(r29)
            if (r4 == r5) goto L_0x0306
            r7 = r8[r4]
            r9 = r8[r5]
            if (r7 != r9) goto L_0x0305
            r4 = r5
            goto L_0x0306
        L_0x0305:
            r1 = 1
        L_0x0306:
            r5 = r29[r4]
            r7 = -1
            if (r5 != r7) goto L_0x030c
            r5 = r11
        L_0x030c:
            int r5 = findPreviousItemIndex(r0, r5, r4)
            if (r5 >= 0) goto L_0x0347
            r7 = r29
            if (r1 != 0) goto L_0x031c
            boolean r5 = measure$lambda$38$misalignedStart(r7, r0, r8, r4)
            if (r5 == 0) goto L_0x03db
        L_0x031c:
            if (r47 == 0) goto L_0x03db
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r1 = r0.getLaneInfo()
            r1.reset()
            int r1 = r7.length
            int[] r2 = new int[r1]
            r3 = 0
        L_0x0329:
            if (r3 >= r1) goto L_0x0332
            r22 = -1
            r2[r3] = r22
            int r3 = r3 + 1
            goto L_0x0329
        L_0x0332:
            int r1 = r8.length
            int[] r3 = new int[r1]
            r5 = 0
        L_0x0336:
            if (r5 >= r1) goto L_0x033f
            r6 = r8[r4]
            r3[r5] = r6
            int r5 = r5 + 1
            goto L_0x0336
        L_0x033f:
            r10 = r30
            r12 = 0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r0 = measure(r0, r10, r2, r3, r12)
            return r0
        L_0x0347:
            r7 = r29
            r10 = r30
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r9 = r0.getItemProvider()
            r46 = r1
            r45 = r2
            long r1 = r0.m1050getSpanRangelOCCd4c(r9, r5, r4)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r4 = r0.getLaneInfo()
            r9 = r12
            r26 = r13
            long r12 = r1 & r17
            int r12 = (int) r12
            r29 = r14
            long r13 = r1 >> r16
            int r13 = (int) r13
            int r14 = r12 - r13
            r15 = 1
            if (r14 == r15) goto L_0x036e
            r23 = r15
            goto L_0x0370
        L_0x036e:
            r23 = 0
        L_0x0370:
            if (r23 == 0) goto L_0x0374
            r15 = -2
            goto L_0x0375
        L_0x0374:
            r15 = r13
        L_0x0375:
            r4.setLane(r5, r15)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r4 = r0.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r4 = r4.m1062getAndMeasurejy6DScQ(r5, r1)
            int r1 = m1054maxInRangejy6DScQ(r8, r1)
            r15 = 1
            if (r14 == r15) goto L_0x0389
            r2 = 1
            goto L_0x038a
        L_0x0389:
            r2 = 0
        L_0x038a:
            if (r2 == 0) goto L_0x0395
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r2 = r0.getLaneInfo()
            int[] r2 = r2.getGaps(r5)
            goto L_0x0396
        L_0x0395:
            r2 = 0
        L_0x0396:
            r14 = r13
            r13 = r46
        L_0x0399:
            if (r14 >= r12) goto L_0x03ba
            r15 = r8[r14]
            if (r15 == r1) goto L_0x03a0
            r13 = 1
        L_0x03a0:
            r15 = r27[r14]
            r15.addFirst(r4)
            r7[r14] = r5
            if (r2 != 0) goto L_0x03ab
            r15 = 0
            goto L_0x03ad
        L_0x03ab:
            r15 = r2[r14]
        L_0x03ad:
            int r30 = r4.getMainAxisSizeWithSpacings()
            int r30 = r1 + r30
            int r30 = r30 + r15
            r8[r14] = r30
            int r14 = r14 + 1
            goto L_0x0399
        L_0x03ba:
            r2 = r45
            r12 = r9
            r30 = r10
            r1 = r13
            r13 = r26
            r14 = r29
            r29 = r7
            goto L_0x02df
        L_0x03c8:
            r45 = r2
            r9 = r12
            r26 = r13
            r7 = r29
            r10 = r30
            r29 = r14
            int r5 = r5 + 1
            r29 = r7
            goto L_0x02e1
        L_0x03d9:
            r7 = r29
        L_0x03db:
            r10 = r30
            r45 = r2
            r9 = r12
            r26 = r13
            r29 = r14
            if (r1 == 0) goto L_0x03f5
            if (r47 == 0) goto L_0x03f5
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r1 = r0.getLaneInfo()
            r1.reset()
            r12 = 0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r0 = measure(r0, r10, r7, r8, r12)
            return r0
        L_0x03f5:
            r12 = 0
            int r10 = r10 + r3
            r4 = 0
            r15 = 1
            int r1 = indexOfMinValue$default(r8, r12, r15, r4)
            r1 = r8[r1]
            if (r1 >= 0) goto L_0x040c
            int r10 = r10 + r1
            r12 = r29
            offsetBy(r12, r1)
            int r1 = -r1
            offsetBy(r8, r1)
            goto L_0x040e
        L_0x040c:
            r12 = r29
        L_0x040e:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r1 = r0.getState()
            float r1 = r1.getScrollToBeConsumed$foundation_release()
            int r1 = java.lang.Math.round(r1)
            int r1 = kotlin.math.MathKt.getSign((int) r1)
            int r2 = kotlin.math.MathKt.getSign((int) r10)
            if (r1 != r2) goto L_0x043c
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r1 = r0.getState()
            float r1 = r1.getScrollToBeConsumed$foundation_release()
            int r1 = java.lang.Math.round(r1)
            int r1 = java.lang.Math.abs(r1)
            int r2 = java.lang.Math.abs(r10)
            if (r1 < r2) goto L_0x043c
            float r1 = (float) r10
            goto L_0x0444
        L_0x043c:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r1 = r0.getState()
            float r1 = r1.getScrollToBeConsumed$foundation_release()
        L_0x0444:
            int r2 = r8.length
            int[] r2 = java.util.Arrays.copyOf(r8, r2)
            r13 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r13)
            int r3 = r2.length
            r5 = 0
        L_0x0450:
            if (r5 >= r3) goto L_0x045a
            r10 = r2[r5]
            int r10 = -r10
            r2[r5] = r10
            int r5 = r5 + 1
            goto L_0x0450
        L_0x045a:
            int r3 = r0.getBeforeContentPadding()
            int r5 = r0.getMainAxisSpacing()
            if (r3 <= r5) goto L_0x04b3
            r3 = 0
        L_0x0465:
            if (r3 >= r6) goto L_0x04b3
            r5 = r27[r3]
            int r10 = r5.size()
            r13 = 0
        L_0x046e:
            if (r13 >= r10) goto L_0x04af
            java.lang.Object r14 = r5.get(r13)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r14 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r14
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r15 = r0.getLaneInfo()
            int r4 = r14.getIndex()
            int[] r4 = r15.getGaps(r4)
            int r14 = r14.getMainAxisSizeWithSpacings()
            if (r4 != 0) goto L_0x048a
            r4 = 0
            goto L_0x048c
        L_0x048a:
            r4 = r4[r3]
        L_0x048c:
            int r14 = r14 + r4
            r4 = r5
            java.util.List r4 = (java.util.List) r4
            int r4 = kotlin.collections.CollectionsKt.getLastIndex(r4)
            if (r13 == r4) goto L_0x04af
            r4 = r8[r3]
            if (r4 == 0) goto L_0x04af
            if (r4 < r14) goto L_0x04af
            int r4 = r4 - r14
            r8[r3] = r4
            int r13 = r13 + 1
            java.lang.Object r4 = r5.get(r13)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r4 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r4
            int r4 = r4.getIndex()
            r7[r3] = r4
            r4 = 0
            goto L_0x046e
        L_0x04af:
            int r3 = r3 + 1
            r4 = 0
            goto L_0x0465
        L_0x04b3:
            int r3 = r0.getBeforeContentPadding()
            int r4 = r0.getAfterContentPadding()
            int r3 = r3 + r4
            boolean r4 = r0.isVertical()
            if (r4 == 0) goto L_0x04cb
            long r4 = r0.m1047getConstraintsmsEJaDk()
            int r4 = androidx.compose.ui.unit.Constraints.m7052getMaxWidthimpl(r4)
            goto L_0x04d8
        L_0x04cb:
            long r4 = r0.m1047getConstraintsmsEJaDk()
            int r6 = kotlin.collections.ArraysKt.maxOrThrow((int[]) r12)
            int r6 = r6 + r3
            int r4 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r4, r6)
        L_0x04d8:
            r30 = r4
            boolean r4 = r0.isVertical()
            if (r4 == 0) goto L_0x04ee
            long r4 = r0.m1047getConstraintsmsEJaDk()
            int r6 = kotlin.collections.ArraysKt.maxOrThrow((int[]) r12)
            int r6 = r6 + r3
            int r4 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r4, r6)
            goto L_0x04f6
        L_0x04ee:
            long r4 = r0.m1047getConstraintsmsEJaDk()
            int r4 = androidx.compose.ui.unit.Constraints.m7051getMaxHeightimpl(r4)
        L_0x04f6:
            r31 = r4
            boolean r4 = r0.isVertical()
            if (r4 == 0) goto L_0x0501
            r4 = r31
            goto L_0x0503
        L_0x0501:
            r4 = r30
        L_0x0503:
            int r5 = r0.getMainAxisAvailableSize()
            int r4 = java.lang.Math.min(r4, r5)
            int r5 = r0.getBeforeContentPadding()
            int r4 = r4 - r5
            int r5 = r0.getAfterContentPadding()
            int r4 = r4 + r5
            r21 = 0
            r5 = r2[r21]
            java.util.List r6 = r0.getPinnedItems()
            int r10 = r6.size()
            r22 = -1
            int r10 = r10 + -1
            if (r10 < 0) goto L_0x05a1
            r13 = r10
            r10 = r5
            r5 = 0
        L_0x052a:
            int r14 = r13 + -1
            java.lang.Object r13 = r6.get(r13)
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r15 = r0.getLaneInfo()
            int r15 = r15.getLane(r13)
            r46 = r3
            r3 = -2
            if (r15 == r3) goto L_0x054e
            r3 = -1
            if (r15 == r3) goto L_0x054e
            r3 = r7[r15]
            if (r3 <= r13) goto L_0x054c
        L_0x054a:
            r3 = 1
            goto L_0x0563
        L_0x054c:
            r3 = 0
            goto L_0x0563
        L_0x054e:
            int r3 = r7.length
            r15 = 0
        L_0x0550:
            if (r15 >= r3) goto L_0x054a
            r16 = r3
            r3 = r7[r15]
            if (r3 <= r13) goto L_0x055a
            r3 = 1
            goto L_0x055b
        L_0x055a:
            r3 = 0
        L_0x055b:
            if (r3 != 0) goto L_0x055e
            goto L_0x054c
        L_0x055e:
            int r15 = r15 + 1
            r3 = r16
            goto L_0x0550
        L_0x0563:
            if (r3 == 0) goto L_0x0594
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r3 = r0.getItemProvider()
            r16 = r5
            r47 = r6
            r15 = 0
            long r5 = r0.m1050getSpanRangelOCCd4c(r3, r13, r15)
            if (r16 != 0) goto L_0x057c
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            goto L_0x057e
        L_0x057c:
            r3 = r16
        L_0x057e:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r15 = r0.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r5 = r15.m1062getAndMeasurejy6DScQ(r13, r5)
            int r6 = r5.getMainAxisSizeWithSpacings()
            int r10 = r10 - r6
            r15 = 0
            r5.position(r10, r15, r4)
            r3.add(r5)
            r5 = r3
            goto L_0x0598
        L_0x0594:
            r16 = r5
            r47 = r6
        L_0x0598:
            if (r14 >= 0) goto L_0x059b
            goto L_0x05a4
        L_0x059b:
            r3 = r46
            r6 = r47
            r13 = r14
            goto L_0x052a
        L_0x05a1:
            r46 = r3
            r5 = 0
        L_0x05a4:
            if (r5 != 0) goto L_0x05aa
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L_0x05aa:
            r14 = r27
            java.util.List r18 = calculateVisibleItems(r0, r14, r2, r4)
            r21 = 0
            r2 = r2[r21]
            java.util.List r3 = r0.getPinnedItems()
            int r6 = r3.size()
            r10 = 0
            r20 = 0
        L_0x05bf:
            if (r10 >= r6) goto L_0x063b
            java.lang.Object r13 = r3.get(r10)
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            if (r13 < r11) goto L_0x05d1
            r47 = r3
        L_0x05cf:
            r3 = 0
            goto L_0x05f9
        L_0x05d1:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r14 = r0.getLaneInfo()
            int r14 = r14.getLane(r13)
            r15 = -2
            r47 = r3
            r3 = -1
            if (r14 == r15) goto L_0x05e7
            if (r14 == r3) goto L_0x05e7
            r14 = r9[r14]
            if (r14 >= r13) goto L_0x05cf
        L_0x05e5:
            r3 = 1
            goto L_0x05f9
        L_0x05e7:
            int r14 = r9.length
            r3 = 0
        L_0x05e9:
            if (r3 >= r14) goto L_0x05e5
            r15 = r9[r3]
            if (r15 >= r13) goto L_0x05f1
            r15 = 1
            goto L_0x05f2
        L_0x05f1:
            r15 = 0
        L_0x05f2:
            if (r15 != 0) goto L_0x05f5
            goto L_0x05cf
        L_0x05f5:
            int r3 = r3 + 1
            r15 = -2
            goto L_0x05e9
        L_0x05f9:
            if (r3 == 0) goto L_0x062c
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r3 = r0.getItemProvider()
            r16 = r5
            r14 = r6
            r15 = 0
            long r5 = r0.m1050getSpanRangelOCCd4c(r3, r13, r15)
            if (r20 != 0) goto L_0x0612
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r20 = r3
            java.util.List r20 = (java.util.List) r20
        L_0x0612:
            r27 = r7
            r3 = r20
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r7 = r0.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r5 = r7.m1062getAndMeasurejy6DScQ(r13, r5)
            r5.position(r2, r15, r4)
            int r6 = r5.getMainAxisSizeWithSpacings()
            int r2 = r2 + r6
            r3.add(r5)
            r20 = r3
            goto L_0x0631
        L_0x062c:
            r16 = r5
            r14 = r6
            r27 = r7
        L_0x0631:
            int r10 = r10 + 1
            r3 = r47
            r6 = r14
            r5 = r16
            r7 = r27
            goto L_0x05bf
        L_0x063b:
            r16 = r5
            r27 = r7
            if (r20 != 0) goto L_0x0645
            java.util.List r20 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0645:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            r5 = r16
            java.util.Collection r5 = (java.util.Collection) r5
            r2.addAll(r5)
            r3 = r18
            java.util.Collection r3 = (java.util.Collection) r3
            r2.addAll(r3)
            r3 = r20
            java.util.Collection r3 = (java.util.Collection) r3
            r2.addAll(r3)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r3 = r0.getState()
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r28 = r3.getItemAnimator$foundation_release()
            int r3 = (int) r1
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r4 = r0.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r33 = r4.getKeyIndexMap()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r4 = r0.getMeasuredItemProvider()
            boolean r35 = r0.isVertical()
            int r37 = r0.getLaneCount()
            int r39 = kotlin.collections.ArraysKt.minOrThrow((int[]) r8)
            int r5 = kotlin.collections.ArraysKt.maxOrThrow((int[]) r12)
            int r40 = r5 + r46
            kotlinx.coroutines.CoroutineScope r41 = r0.getCoroutineScope()
            androidx.compose.ui.graphics.GraphicsContext r42 = r0.getGraphicsContext()
            r34 = r4
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider r34 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider) r34
            r36 = 0
            r38 = 0
            r32 = r2
            r29 = r3
            r28.onMeasured(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            r4 = r30
            r2 = r31
            r3 = r32
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r5 = r0.getState()
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r5 = r5.getItemAnimator$foundation_release()
            long r5 = r5.m984getMinSizeToFitDisappearingItemsYbymL2g()
            androidx.compose.ui.unit.IntSize$Companion r7 = androidx.compose.ui.unit.IntSize.Companion
            long r13 = r7.m7288getZeroYbymL2g()
            boolean r7 = androidx.compose.ui.unit.IntSize.m7281equalsimpl0(r5, r13)
            if (r7 != 0) goto L_0x070b
            boolean r7 = r0.isVertical()
            if (r7 == 0) goto L_0x06c5
            r7 = r2
            goto L_0x06c6
        L_0x06c5:
            r7 = r4
        L_0x06c6:
            long r13 = r0.m1047getConstraintsmsEJaDk()
            int r10 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r5)
            int r4 = java.lang.Math.max(r4, r10)
            int r30 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r13, r4)
            long r13 = r0.m1047getConstraintsmsEJaDk()
            int r4 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r5)
            int r2 = java.lang.Math.max(r2, r4)
            int r31 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r13, r2)
            boolean r2 = r0.isVertical()
            if (r2 == 0) goto L_0x06ef
            r2 = r31
            goto L_0x06f1
        L_0x06ef:
            r2 = r30
        L_0x06f1:
            if (r2 == r7) goto L_0x0706
            int r4 = r3.size()
            r5 = 0
        L_0x06f8:
            if (r5 >= r4) goto L_0x0706
            java.lang.Object r6 = r3.get(r5)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r6 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r6
            r6.updateMainAxisLayoutSize(r2)
            int r5 = r5 + 1
            goto L_0x06f8
        L_0x0706:
            r33 = r30
            r34 = r31
            goto L_0x070f
        L_0x070b:
            r34 = r2
            r33 = r4
        L_0x070f:
            r4 = r26
            r2 = 0
        L_0x0712:
            if (r2 >= r4) goto L_0x0726
            r5 = r12[r2]
            int r6 = r0.getMainAxisAvailableSize()
            if (r5 <= r6) goto L_0x071e
            r15 = 1
            goto L_0x071f
        L_0x071e:
            r15 = 0
        L_0x071f:
            if (r15 == 0) goto L_0x0723
            r15 = 1
            goto L_0x0727
        L_0x0723:
            int r2 = r2 + 1
            goto L_0x0712
        L_0x0726:
            r15 = 0
        L_0x0727:
            if (r15 != 0) goto L_0x0743
            int r2 = r9.length
            r12 = 0
        L_0x072b:
            if (r12 >= r2) goto L_0x073d
            r4 = r9[r12]
            int r5 = r11 + -1
            if (r4 >= r5) goto L_0x0735
            r15 = 1
            goto L_0x0736
        L_0x0735:
            r15 = 0
        L_0x0736:
            if (r15 != 0) goto L_0x073a
            r15 = 0
            goto L_0x073e
        L_0x073a:
            int r12 = r12 + 1
            goto L_0x072b
        L_0x073d:
            r15 = 1
        L_0x073e:
            if (r15 == 0) goto L_0x0741
            goto L_0x0743
        L_0x0741:
            r10 = 0
            goto L_0x0744
        L_0x0743:
            r10 = 1
        L_0x0744:
            r32 = r25
            androidx.compose.ui.layout.MeasureScope r32 = (androidx.compose.ui.layout.MeasureScope) r32
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$30 r2 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$30
            r2.<init>(r3, r0)
            r36 = r2
            kotlin.jvm.functions.Function1 r36 = (kotlin.jvm.functions.Function1) r36
            r37 = 4
            r38 = 0
            r35 = 0
            androidx.compose.ui.layout.MeasureResult r2 = androidx.compose.ui.layout.MeasureScope.layout$default(r32, r33, r34, r35, r36, r37, r38)
            r4 = r33
            r3 = r34
            boolean r12 = r0.isVertical()
            long r19 = androidx.compose.ui.unit.IntSizeKt.IntSize(r4, r3)
            int r23 = r0.getBeforeContentPadding()
            r21 = r24
            int r24 = r0.getAfterContentPadding()
            r3 = r25
            int r25 = r0.getMainAxisSpacing()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots r14 = r0.getResolvedSlots()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r4 = r0.getItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider r15 = r4.getSpanProvider()
            kotlinx.coroutines.CoroutineScope r26 = r0.getCoroutineScope()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r6 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult
            r16 = r3
            androidx.compose.ui.unit.Density r16 = (androidx.compose.ui.unit.Density) r16
            r7 = r27
            r27 = 0
            r13 = r44
            r22 = r45
            r9 = r1
            r17 = r11
            r11 = r10
            r10 = r2
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27)
            return r6
        L_0x079e:
            r8 = r46
            r19 = r2
            r9 = r12
            r4 = r13
            r12 = r14
            r3 = r25
            r14 = r27
            r13 = r28
            r7 = r29
            r10 = r30
            r26 = -2
            r25 = r44
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r2 = r0.getItemProvider()
            r44 = r3
            long r2 = r0.m1050getSpanRangelOCCd4c(r2, r1, r5)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r5 = r0.getLaneInfo()
            r27 = r6
            long r6 = r2 & r17
            int r6 = (int) r6
            r28 = r8
            long r7 = r2 >> r16
            int r7 = (int) r7
            int r8 = r6 - r7
            r0 = 1
            if (r8 == r0) goto L_0x07d3
            r0 = r26
            goto L_0x07d4
        L_0x07d3:
            r0 = r7
        L_0x07d4:
            r5.setLane(r1, r0)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r0 = r43.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r0 = r0.m1062getAndMeasurejy6DScQ(r1, r2)
            int r2 = m1054maxInRangejy6DScQ(r12, r2)
            r3 = 1
            if (r8 == r3) goto L_0x07f7
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r5 = r43.getLaneInfo()
            int[] r5 = r5.getGaps(r1)
            if (r5 != 0) goto L_0x07f8
            int r5 = r43.getLaneCount()
            int[] r5 = new int[r5]
            goto L_0x07f8
        L_0x07f7:
            r5 = 0
        L_0x07f8:
            r8 = r7
        L_0x07f9:
            if (r8 >= r6) goto L_0x0816
            if (r5 == 0) goto L_0x0803
            r23 = r12[r8]
            int r23 = r2 - r23
            r5[r8] = r23
        L_0x0803:
            r9[r8] = r1
            int r23 = r0.getMainAxisSizeWithSpacings()
            int r23 = r2 + r23
            r12[r8] = r23
            r3 = r14[r8]
            r3.addLast(r0)
            int r8 = r8 + 1
            r3 = 1
            goto L_0x07f9
        L_0x0816:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r3 = r43.getLaneInfo()
            r3.setGaps(r1, r5)
            if (r2 >= r15) goto L_0x0827
            r1 = r12[r7]
            if (r1 > r15) goto L_0x0827
            r3 = 0
            r0.setVisible(r3)
        L_0x0827:
            r46 = r25
            r25 = r44
            r44 = r46
            r0 = r43
            r30 = r10
            r31 = r11
            r2 = r19
            r6 = r27
            r46 = r28
            r28 = r13
            r27 = r14
            r13 = r4
            r14 = r12
            r12 = r9
            goto L_0x0210
        L_0x0842:
            r44 = r4
            long r0 = r43.m1047getConstraintsmsEJaDk()
            int r14 = androidx.compose.ui.unit.Constraints.m7054getMinWidthimpl(r0)
            long r0 = r43.m1047getConstraintsmsEJaDk()
            int r15 = androidx.compose.ui.unit.Constraints.m7053getMinHeightimpl(r0)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r0 = r43.getState()
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r12 = r0.getItemAnimator$foundation_release()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r16 = r0
            java.util.List r16 = (java.util.List) r16
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r0 = r43.getMeasuredItemProvider()
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r17 = r0.getKeyIndexMap()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r0 = r43.getMeasuredItemProvider()
            int r21 = r43.getLaneCount()
            boolean r19 = r43.isVertical()
            kotlinx.coroutines.CoroutineScope r25 = r43.getCoroutineScope()
            androidx.compose.ui.graphics.GraphicsContext r26 = r43.getGraphicsContext()
            r18 = r0
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider r18 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider) r18
            r23 = 0
            r24 = 0
            r13 = 0
            r20 = 0
            r22 = 0
            r12.onMeasured(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r0 = r43.getState()
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r0 = r0.getItemAnimator$foundation_release()
            long r0 = r0.m984getMinSizeToFitDisappearingItemsYbymL2g()
            androidx.compose.ui.unit.IntSize$Companion r3 = androidx.compose.ui.unit.IntSize.Companion
            long r3 = r3.m7288getZeroYbymL2g()
            boolean r3 = androidx.compose.ui.unit.IntSize.m7281equalsimpl0(r0, r3)
            if (r3 != 0) goto L_0x08c1
            long r3 = r43.m1047getConstraintsmsEJaDk()
            int r5 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r0)
            int r14 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r3, r5)
            long r3 = r43.m1047getConstraintsmsEJaDk()
            int r0 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r0)
            int r15 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r3, r0)
        L_0x08c1:
            r4 = r14
            r5 = r15
            r3 = r44
            androidx.compose.ui.layout.MeasureScope r3 = (androidx.compose.ui.layout.MeasureScope) r3
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1 r0 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1.INSTANCE
            r7 = r0
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8 = 4
            r9 = 0
            r6 = 0
            androidx.compose.ui.layout.MeasureResult r4 = androidx.compose.ui.layout.MeasureScope.layout$default(r3, r4, r5, r6, r7, r8, r9)
            boolean r6 = r43.isVertical()
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            long r0 = r43.m1047getConstraintsmsEJaDk()
            int r0 = androidx.compose.ui.unit.Constraints.m7054getMinWidthimpl(r0)
            long r7 = r43.m1047getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m7053getMinHeightimpl(r7)
            long r13 = androidx.compose.ui.unit.IntSizeKt.IntSize(r0, r1)
            int r0 = r43.getBeforeContentPadding()
            int r15 = -r0
            int r0 = r43.getMainAxisAvailableSize()
            int r1 = r43.getAfterContentPadding()
            int r16 = r0 + r1
            int r17 = r43.getBeforeContentPadding()
            int r18 = r43.getAfterContentPadding()
            int r19 = r43.getMainAxisSpacing()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots r8 = r43.getResolvedSlots()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r0 = r43.getItemProvider()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider r9 = r0.getSpanProvider()
            kotlinx.coroutines.CoroutineScope r20 = r43.getCoroutineScope()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r0 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult
            r10 = r44
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            r21 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            r1 = r2
            r2 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int, int[], int[], boolean):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult");
    }

    private static final boolean measure$lambda$38$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$38$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i) {
        int i2 = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> size : arrayDequeArr) {
            i2 += size.size();
        }
        ArrayList arrayList = new ArrayList(i2);
        while (true) {
            int length = arrayDequeArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (!arrayDequeArr[i3].isEmpty()) {
                    int length2 = arrayDequeArr.length;
                    int i4 = -1;
                    int i5 = Integer.MAX_VALUE;
                    for (int i6 = 0; i6 < length2; i6++) {
                        LazyStaggeredGridMeasuredItem firstOrNull = arrayDequeArr[i6].firstOrNull();
                        int index = firstOrNull != null ? firstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i5 > index) {
                            i4 = i6;
                            i5 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem removeFirst = arrayDequeArr[i4].removeFirst();
                    if (removeFirst.getLane() == i4) {
                        long r5 = SpanRange.m1074constructorimpl(removeFirst.getLane(), removeFirst.getSpan());
                        int r3 = m1054maxInRangejy6DScQ(iArr, r5);
                        removeFirst.position(r3, lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i4], i);
                        arrayList.add(removeFirst);
                        int i7 = (int) (r5 & 4294967295L);
                        for (int i8 = (int) (r5 >> 32); i8 < i7; i8++) {
                            iArr[i8] = removeFirst.getMainAxisSizeWithSpacings() + r3;
                        }
                    }
                } else {
                    i3++;
                }
            }
            return arrayList;
        }
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        List<LazyStaggeredGridMeasuredItem> list = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int intValue = pinnedItems.get(size).intValue();
                    if (function12.invoke(Integer.valueOf(intValue)).booleanValue()) {
                        long r4 = lazyStaggeredGridMeasureContext.m1050getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue, 0);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        LazyStaggeredGridMeasuredItem r11 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1062getAndMeasurejy6DScQ(intValue, r4);
                        function1.invoke(r11);
                        list.add(r11);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int intValue2 = pinnedItems.get(i2).intValue();
                if (function12.invoke(Integer.valueOf(intValue2)).booleanValue()) {
                    long r5 = lazyStaggeredGridMeasureContext.m1050getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue2, 0);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    LazyStaggeredGridMeasuredItem r42 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1062getAndMeasurejy6DScQ(intValue2, r5);
                    function1.invoke(r42);
                    list.add(r42);
                }
            }
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* renamed from: forEach-nIS5qE8  reason: not valid java name */
    private static final void m1053forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* renamed from: maxInRange-jy6DScQ  reason: not valid java name */
    private static final int m1054maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int i2 = Integer.MIN_VALUE;
        for (int i3 = (int) (j >> 32); i3 < i; i3++) {
            i2 = Math.max(i2, iArr[i3]);
        }
        return i2;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int intValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > intValue) {
                i = i3;
                i2 = intValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                while (true) {
                    if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                        break;
                    }
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
                if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), iArr[length])) {
                    lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[length], length);
                }
                if (i2 >= 0) {
                    length = i2;
                } else {
                    return;
                }
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    function1.invoke(list.get(size));
                    if (i >= 0) {
                        size = i;
                    } else {
                        return;
                    }
                }
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke(list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = size - 1;
                    function1.invoke(list.get(size));
                    if (i2 >= 0) {
                        size = i2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }
}
