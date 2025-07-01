package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nH\b\u001a\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001a¸\u0002\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020-2\u0006\u0010.\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020423\u00105\u001a/\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+090\u00010\n2/\u0010:\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0\n¢\u0006\u0002\b>\u0012\u0004\u0012\u00020?0;H\u0000ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a+\u0010B\u001a\u00020=\"\u0004\b\u0000\u0010C*\b\u0012\u0004\u0012\u0002HC0\r2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002HC0EH\u0002¢\u0006\u0002\u0010F\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "filter", "Lkotlin/Function1;", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "slotsPerLine", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/ParameterName;", "name", "line", "Lkotlin/Pair;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-OZKpZRA", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "addAllFromArray", "T", "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasure.kt */
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measureLazyGrid-OZKpZRA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult m951measureLazyGridOZKpZRA(int r38, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider r39, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider r40, int r41, int r42, int r43, int r44, int r45, int r46, float r47, long r48, boolean r50, androidx.compose.foundation.layout.Arrangement.Vertical r51, androidx.compose.foundation.layout.Arrangement.Horizontal r52, boolean r53, androidx.compose.ui.unit.Density r54, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r55, int r56, java.util.List<java.lang.Integer> r57, kotlinx.coroutines.CoroutineScope r58, androidx.compose.runtime.MutableState<kotlin.Unit> r59, androidx.compose.ui.graphics.GraphicsContext r60, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.util.List<kotlin.Pair<java.lang.Integer, androidx.compose.ui.unit.Constraints>>> r61, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r62) {
        /*
            r14 = r38
            r0 = r39
            r6 = r41
            r1 = r42
            r2 = r48
            r4 = r57
            r13 = r62
            if (r1 < 0) goto L_0x040b
            if (r43 < 0) goto L_0x03ff
            if (r14 > 0) goto L_0x00a7
            int r16 = androidx.compose.ui.unit.Constraints.m7054getMinWidthimpl(r2)
            int r17 = androidx.compose.ui.unit.Constraints.m7053getMinHeightimpl(r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r18 = r0
            java.util.List r18 = (java.util.List) r18
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r19 = r40.getKeyIndexMap()
            r20 = r40
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider r20 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider) r20
            r25 = 0
            r26 = 0
            r15 = 0
            r22 = 0
            r24 = 0
            r21 = r50
            r14 = r55
            r23 = r56
            r27 = r58
            r28 = r60
            r14.onMeasured(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            long r4 = r55.m984getMinSizeToFitDisappearingItemsYbymL2g()
            androidx.compose.ui.unit.IntSize$Companion r0 = androidx.compose.ui.unit.IntSize.Companion
            long r7 = r0.m7288getZeroYbymL2g()
            boolean r0 = androidx.compose.ui.unit.IntSize.m7281equalsimpl0(r4, r7)
            if (r0 != 0) goto L_0x0063
            int r0 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r4)
            int r16 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r2, r0)
            int r0 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r4)
            int r17 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r2, r0)
        L_0x0063:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3 r3 = androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3.INSTANCE
            java.lang.Object r0 = r13.invoke(r0, r2, r3)
            r23 = r0
            androidx.compose.ui.layout.MeasureResult r23 = (androidx.compose.ui.layout.MeasureResult) r23
            java.util.List r29 = kotlin.collections.CollectionsKt.emptyList()
            int r0 = -r1
            int r31 = r6 + r43
            if (r50 == 0) goto L_0x0081
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0083
        L_0x0081:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0083:
            r34 = r1
            androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r18 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureResult
            r24 = 0
            r32 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r35 = r43
            r36 = r44
            r33 = r53
            r26 = r54
            r27 = r56
            r25 = r58
            r28 = r61
            r30 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return r18
        L_0x00a7:
            int r5 = java.lang.Math.round(r47)
            int r7 = r46 - r5
            r15 = 0
            if (r45 != 0) goto L_0x00b4
            if (r7 >= 0) goto L_0x00b4
            int r5 = r5 + r7
            r7 = r15
        L_0x00b4:
            kotlin.collections.ArrayDeque r8 = new kotlin.collections.ArrayDeque
            r8.<init>()
            int r9 = -r1
            if (r44 >= 0) goto L_0x00bf
            r10 = r44
            goto L_0x00c0
        L_0x00bf:
            r10 = r15
        L_0x00c0:
            int r10 = r10 + r9
            int r7 = r7 + r10
            r11 = r7
            r7 = r45
        L_0x00c5:
            if (r11 >= 0) goto L_0x00d8
            if (r7 <= 0) goto L_0x00d8
            int r7 = r7 + -1
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r12 = r0.getAndMeasure(r7)
            r8.add(r15, r12)
            int r12 = r12.getMainAxisSizeWithSpacings()
            int r11 = r11 + r12
            goto L_0x00c5
        L_0x00d8:
            if (r11 >= r10) goto L_0x00dc
            int r5 = r5 + r11
            r11 = r10
        L_0x00dc:
            int r11 = r11 - r10
            int r12 = r6 + r43
            r45 = r5
            int r5 = kotlin.ranges.RangesKt.coerceAtLeast((int) r12, (int) r15)
            int r15 = -r11
            r17 = r7
            r18 = r17
            r19 = r9
            r7 = r15
            r15 = 0
            r16 = 0
        L_0x00f0:
            int r9 = r8.size()
            r33 = 1
            if (r15 >= r9) goto L_0x0110
            if (r7 < r5) goto L_0x0100
            r8.remove(r15)
            r16 = r33
            goto L_0x00f0
        L_0x0100:
            int r18 = r18 + 1
            java.lang.Object r9 = r8.get(r15)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r9 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r9
            int r9 = r9.getMainAxisSizeWithSpacings()
            int r7 = r7 + r9
            int r15 = r15 + 1
            goto L_0x00f0
        L_0x0110:
            r9 = r18
        L_0x0112:
            if (r9 >= r14) goto L_0x0161
            if (r7 < r5) goto L_0x011e
            if (r7 <= 0) goto L_0x011e
            boolean r15 = r8.isEmpty()
            if (r15 == 0) goto L_0x0161
        L_0x011e:
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r15 = r0.getAndMeasure(r9)
            boolean r18 = r15.isEmpty()
            if (r18 == 0) goto L_0x0129
            goto L_0x0161
        L_0x0129:
            int r18 = r15.getMainAxisSizeWithSpacings()
            int r7 = r7 + r18
            if (r7 > r10) goto L_0x0153
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r18 = r15.getItems()
            java.lang.Object r18 = kotlin.collections.ArraysKt.last((T[]) r18)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r18 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r18
            r20 = r5
            int r5 = r18.getIndex()
            r18 = r7
            int r7 = r14 + -1
            if (r5 == r7) goto L_0x0157
            int r5 = r9 + 1
            int r7 = r15.getMainAxisSizeWithSpacings()
            int r11 = r11 - r7
            r17 = r5
            r16 = r33
            goto L_0x015a
        L_0x0153:
            r20 = r5
            r18 = r7
        L_0x0157:
            r8.add(r15)
        L_0x015a:
            int r9 = r9 + 1
            r7 = r18
            r5 = r20
            goto L_0x0112
        L_0x0161:
            if (r7 >= r6) goto L_0x0185
            int r5 = r6 - r7
            int r11 = r11 - r5
            int r7 = r7 + r5
        L_0x0167:
            if (r11 >= r1) goto L_0x017d
            if (r17 <= 0) goto L_0x017d
            int r9 = r17 + -1
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r10 = r0.getAndMeasure(r9)
            r15 = 0
            r8.add(r15, r10)
            int r10 = r10.getMainAxisSizeWithSpacings()
            int r11 = r11 + r10
            r17 = r9
            goto L_0x0167
        L_0x017d:
            int r5 = r45 + r5
            if (r11 >= 0) goto L_0x0187
            int r5 = r5 + r11
            int r7 = r7 + r11
            r11 = 0
            goto L_0x0187
        L_0x0185:
            r5 = r45
        L_0x0187:
            int r9 = java.lang.Math.round(r47)
            int r9 = kotlin.math.MathKt.getSign((int) r9)
            int r10 = kotlin.math.MathKt.getSign((int) r5)
            if (r9 != r10) goto L_0x01a6
            int r9 = java.lang.Math.round(r47)
            int r9 = java.lang.Math.abs(r9)
            int r10 = java.lang.Math.abs(r5)
            if (r9 < r10) goto L_0x01a6
            float r5 = (float) r5
            r15 = r5
            goto L_0x01a8
        L_0x01a6:
            r15 = r47
        L_0x01a8:
            if (r11 < 0) goto L_0x03f3
            int r5 = -r11
            java.lang.Object r9 = r8.first()
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r9 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r9
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r10 = r9.getItems()
            java.lang.Object r10 = kotlin.collections.ArraysKt.firstOrNull((T[]) r10)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r10 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r10
            if (r10 == 0) goto L_0x01c2
            int r10 = r10.getIndex()
            goto L_0x01c3
        L_0x01c2:
            r10 = 0
        L_0x01c3:
            java.lang.Object r17 = r8.lastOrNull()
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r17 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r17
            if (r17 == 0) goto L_0x01e0
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r17 = r17.getItems()
            if (r17 == 0) goto L_0x01e0
            java.lang.Object r17 = kotlin.collections.ArraysKt.lastOrNull((T[]) r17)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r17 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r17
            if (r17 == 0) goto L_0x01e0
            int r17 = r17.getIndex()
            r13 = r17
            goto L_0x01e1
        L_0x01e0:
            r13 = 0
        L_0x01e1:
            int r1 = r4.size()
            r17 = 0
            r18 = r5
            r20 = r17
            r5 = 0
        L_0x01ec:
            if (r5 >= r1) goto L_0x022e
            java.lang.Object r21 = r4.get(r5)
            java.lang.Number r21 = (java.lang.Number) r21
            r45 = r1
            int r1 = r21.intValue()
            if (r1 < 0) goto L_0x0227
            if (r1 >= r10) goto L_0x0227
            r21 = r5
            int r5 = r0.spanOf(r1)
            r23 = r1
            r1 = 0
            long r26 = r0.m963childConstraintsJhjzzOo$foundation_release(r1, r5)
            r24 = 0
            r22 = r40
            r25 = r5
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r1 = r22.m961getAndMeasurehBUhpc((int) r23, (int) r24, (int) r25, (long) r26)
            if (r20 != 0) goto L_0x021f
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            goto L_0x0221
        L_0x021f:
            r5 = r20
        L_0x0221:
            r5.add(r1)
            r20 = r5
            goto L_0x0229
        L_0x0227:
            r21 = r5
        L_0x0229:
            int r5 = r21 + 1
            r1 = r45
            goto L_0x01ec
        L_0x022e:
            if (r20 != 0) goto L_0x0234
            java.util.List r20 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0234:
            r1 = r20
            int r5 = r4.size()
            r45 = r1
            r1 = 0
        L_0x023d:
            if (r1 >= r5) goto L_0x0281
            java.lang.Object r20 = r4.get(r1)
            java.lang.Number r20 = (java.lang.Number) r20
            r21 = r1
            int r1 = r20.intValue()
            int r4 = r13 + 1
            if (r4 > r1) goto L_0x0279
            if (r1 >= r14) goto L_0x0279
            int r4 = r0.spanOf(r1)
            r14 = 0
            long r26 = r0.m963childConstraintsJhjzzOo$foundation_release(r14, r4)
            r24 = 0
            r22 = r40
            r23 = r1
            r25 = r4
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r1 = r22.m961getAndMeasurehBUhpc((int) r23, (int) r24, (int) r25, (long) r26)
            if (r17 != 0) goto L_0x0271
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r17 = r4
            java.util.List r17 = (java.util.List) r17
        L_0x0271:
            r4 = r17
            r4.add(r1)
            r17 = r4
            goto L_0x027a
        L_0x0279:
            r14 = 0
        L_0x027a:
            int r1 = r21 + 1
            r14 = r38
            r4 = r57
            goto L_0x023d
        L_0x0281:
            r14 = 0
            if (r17 != 0) goto L_0x0288
            java.util.List r17 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0288:
            if (r42 > 0) goto L_0x0292
            if (r44 >= 0) goto L_0x028d
            goto L_0x0292
        L_0x028d:
            r34 = r9
            r29 = r11
            goto L_0x02bb
        L_0x0292:
            int r0 = r8.size()
            r1 = r14
        L_0x0297:
            if (r1 >= r0) goto L_0x028d
            java.lang.Object r4 = r8.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r4 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r4
            int r4 = r4.getMainAxisSizeWithSpacings()
            if (r11 == 0) goto L_0x028d
            if (r4 > r11) goto L_0x028d
            r5 = r8
            java.util.List r5 = (java.util.List) r5
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r5)
            if (r1 == r5) goto L_0x028d
            int r11 = r11 - r4
            int r1 = r1 + 1
            java.lang.Object r4 = r8.get(r1)
            r9 = r4
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r9 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r9
            goto L_0x0297
        L_0x02bb:
            if (r50 == 0) goto L_0x02c2
            int r0 = androidx.compose.ui.unit.Constraints.m7052getMaxWidthimpl(r2)
            goto L_0x02c6
        L_0x02c2:
            int r0 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r2, r7)
        L_0x02c6:
            r20 = r0
            if (r50 == 0) goto L_0x02cf
            int r0 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r2, r7)
            goto L_0x02d3
        L_0x02cf:
            int r0 = androidx.compose.ui.unit.Constraints.m7051getMaxHeightimpl(r2)
        L_0x02d3:
            r4 = r0
            r0 = r8
            java.util.List r0 = (java.util.List) r0
            r1 = r45
            r8 = r50
            r9 = r51
            r11 = r53
            r5 = r7
            r37 = r10
            r36 = r12
            r46 = r13
            r7 = r18
            r10 = r52
            r12 = r54
            r13 = r2
            r2 = r17
            r17 = r19
            r3 = r20
            java.util.List r22 = calculateItemsOffsets(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r30 = r5
            int r0 = (int) r15
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r23 = r40.getKeyIndexMap()
            r24 = r40
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider r24 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider) r24
            r26 = 0
            r28 = 0
            r25 = r50
            r18 = r55
            r27 = r56
            r31 = r58
            r32 = r60
            r19 = r0
            r21 = r4
            r18.onMeasured(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r0 = r22
            long r7 = r55.m984getMinSizeToFitDisappearingItemsYbymL2g()
            androidx.compose.ui.unit.IntSize$Companion r9 = androidx.compose.ui.unit.IntSize.Companion
            long r9 = r9.m7288getZeroYbymL2g()
            boolean r9 = androidx.compose.ui.unit.IntSize.m7281equalsimpl0(r7, r9)
            if (r9 != 0) goto L_0x0361
            if (r50 == 0) goto L_0x032d
            r9 = r4
            goto L_0x032e
        L_0x032d:
            r9 = r3
        L_0x032e:
            int r10 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r7)
            int r3 = java.lang.Math.max(r3, r10)
            int r20 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r13, r3)
            int r3 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r7)
            int r3 = java.lang.Math.max(r4, r3)
            int r4 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r13, r3)
            if (r50 == 0) goto L_0x034a
            r3 = r4
            goto L_0x034c
        L_0x034a:
            r3 = r20
        L_0x034c:
            if (r3 == r9) goto L_0x0363
            int r7 = r0.size()
            r8 = 0
        L_0x0353:
            if (r8 >= r7) goto L_0x0363
            java.lang.Object r9 = r0.get(r8)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r9 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r9
            r9.updateMainAxisLayoutSize(r3)
            int r8 = r8 + 1
            goto L_0x0353
        L_0x0361:
            r20 = r3
        L_0x0363:
            int r3 = r38 + -1
            r7 = r46
            if (r7 != r3) goto L_0x036e
            if (r5 <= r6) goto L_0x036c
            goto L_0x036e
        L_0x036c:
            r3 = 0
            goto L_0x0370
        L_0x036e:
            r3 = r33
        L_0x0370:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r20)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$6 r6 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$6
            r8 = r59
            r6.<init>(r0, r8)
            r13 = r62
            java.lang.Object r4 = r13.invoke(r5, r4, r6)
            r5 = r4
            androidx.compose.ui.layout.MeasureResult r5 = (androidx.compose.ui.layout.MeasureResult) r5
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0396
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x0396
            r11 = r0
            goto L_0x03c8
        L_0x0396:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            r1.<init>(r2)
            int r2 = r0.size()
            r4 = 0
        L_0x03a4:
            if (r4 >= r2) goto L_0x03c2
            java.lang.Object r6 = r0.get(r4)
            r8 = r6
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r8 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r8
            int r8 = r8.getIndex()
            r10 = r37
            if (r10 > r8) goto L_0x03bd
            if (r8 > r7) goto L_0x03bd
            r8 = r1
            java.util.Collection r8 = (java.util.Collection) r8
            r8.add(r6)
        L_0x03bd:
            int r4 = r4 + 1
            r37 = r10
            goto L_0x03a4
        L_0x03c2:
            r22 = r1
            java.util.List r22 = (java.util.List) r22
            r11 = r22
        L_0x03c8:
            if (r50 == 0) goto L_0x03cd
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x03cf
        L_0x03cd:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x03cf:
            androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r1 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureResult
            r14 = r38
            r18 = r44
            r8 = r54
            r9 = r56
            r7 = r58
            r10 = r61
            r4 = r15
            r6 = r16
            r12 = r17
            r2 = r29
            r13 = r36
            r17 = r43
            r15 = r53
            r16 = r0
            r0 = r1
            r1 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x03f3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative initial offset"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03ff:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative afterContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x040b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative beforeContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.m951measureLazyGridOZKpZRA(int, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MutableState, androidx.compose.ui.graphics.GraphicsContext, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.grid.LazyGridMeasureResult");
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        Arrangement.Vertical vertical2 = vertical;
        boolean z3 = z2;
        int i6 = z ? i2 : i;
        boolean z4 = i3 < Math.min(i6, i4);
        if (!z4 || i5 == 0) {
            int size = list.size();
            int i7 = 0;
            for (int i8 = 0; i8 < size; i8++) {
                i7 += list.get(i8).getItems().length;
            }
            ArrayList arrayList = new ArrayList(i7);
            if (!z4) {
                int size2 = list2.size() - 1;
                if (size2 >= 0) {
                    int i9 = i5;
                    while (true) {
                        int i10 = size2 - 1;
                        LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size2);
                        i9 -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                        lazyGridMeasuredItem.position(i9, 0, i, i2);
                        arrayList.add(lazyGridMeasuredItem);
                        if (i10 < 0) {
                            break;
                        }
                        size2 = i10;
                    }
                }
                int size3 = list.size();
                int i11 = i5;
                for (int i12 = 0; i12 < size3; i12++) {
                    LazyGridMeasuredLine lazyGridMeasuredLine = list.get(i12);
                    addAllFromArray(arrayList, lazyGridMeasuredLine.position(i11, i, i2));
                    i11 += lazyGridMeasuredLine.getMainAxisSizeWithSpacings();
                }
                int size4 = list3.size();
                for (int i13 = 0; i13 < size4; i13++) {
                    LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i13);
                    lazyGridMeasuredItem2.position(i11, 0, i, i2);
                    arrayList.add(lazyGridMeasuredItem2);
                    i11 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
                }
            } else if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no items".toString());
            } else {
                int size5 = list.size();
                int[] iArr = new int[size5];
                for (int i14 = 0; i14 < size5; i14++) {
                    iArr[i14] = list.get(calculateItemsOffsets$reverseAware(i14, z3, size5)).getMainAxisSize();
                }
                int[] iArr2 = new int[size5];
                for (int i15 = 0; i15 < size5; i15++) {
                    iArr2[i15] = 0;
                }
                if (!z) {
                    Density density2 = density;
                    if (horizontal != null) {
                        horizontal.arrange(density2, i6, iArr, LayoutDirection.Ltr, iArr2);
                    } else {
                        throw new IllegalArgumentException("null horizontalArrangement".toString());
                    }
                } else if (vertical2 != null) {
                    vertical2.arrange(density, i6, iArr, iArr2);
                } else {
                    throw new IllegalArgumentException("null verticalArrangement".toString());
                }
                IntProgression indices = ArraysKt.getIndices(iArr2);
                if (z3) {
                    indices = RangesKt.reversed(indices);
                }
                int first = indices.getFirst();
                int last = indices.getLast();
                int step = indices.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        int i16 = iArr2[first];
                        LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(calculateItemsOffsets$reverseAware(first, z3, size5));
                        if (z3) {
                            i16 = (i6 - i16) - lazyGridMeasuredLine2.getMainAxisSize();
                        }
                        addAllFromArray(arrayList, lazyGridMeasuredLine2.position(i16, i, i2));
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("non-zero firstLineScrollOffset".toString());
    }

    private static final <T> void addAllFromArray(List<T> list, T[] tArr) {
        for (T add : tArr) {
            list.add(add);
        }
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, Function1<? super Integer, Boolean> function1) {
        LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider2;
        int size = list.size();
        List<LazyGridMeasuredItem> list2 = null;
        int i = 0;
        while (i < size) {
            int intValue = list.get(i).intValue();
            if (function1.invoke(Integer.valueOf(intValue)).booleanValue()) {
                int spanOf = lazyGridMeasuredLineProvider.spanOf(intValue);
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                LazyGridMeasuredItem r12 = lazyGridMeasuredItemProvider2.m961getAndMeasurehBUhpc(intValue, 0, spanOf, lazyGridMeasuredLineProvider.m963childConstraintsJhjzzOo$foundation_release(0, spanOf));
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(r12);
            } else {
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
            }
            i++;
            lazyGridMeasuredItemProvider = lazyGridMeasuredItemProvider2;
        }
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }
}
