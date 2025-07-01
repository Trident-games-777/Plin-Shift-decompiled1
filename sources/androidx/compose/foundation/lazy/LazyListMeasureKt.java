package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\\\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002\u001a4\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001a£\u0002\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u0002012\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u00102\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092/\u0010:\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<¢\u0006\u0002\b?\u0012\u0004\u0012\u00020@0;H\u0000ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "items", "", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "consumedScroll", "", "isLookingAhead", "lastPostLookaheadLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "createItemsBeforeList", "currentFirstItemIndex", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "hasLookaheadPassOccurred", "postLookaheadLayoutInfo", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-x0Ok8Vo", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasure.kt */
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:133:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03cf  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0417  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x041a  */
    /* renamed from: measureLazyList-x0Ok8Vo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.LazyListMeasureResult m913measureLazyListx0Ok8Vo(int r41, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r42, int r43, int r44, int r45, int r46, int r47, int r48, float r49, long r50, boolean r52, java.util.List<java.lang.Integer> r53, androidx.compose.foundation.layout.Arrangement.Vertical r54, androidx.compose.foundation.layout.Arrangement.Horizontal r55, boolean r56, androidx.compose.ui.unit.Density r57, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<androidx.compose.foundation.lazy.LazyListMeasuredItem> r58, int r59, java.util.List<java.lang.Integer> r60, boolean r61, boolean r62, androidx.compose.foundation.lazy.LazyListLayoutInfo r63, kotlinx.coroutines.CoroutineScope r64, androidx.compose.runtime.MutableState<kotlin.Unit> r65, androidx.compose.ui.graphics.GraphicsContext r66, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r67) {
        /*
            r15 = r41
            r8 = r43
            r13 = r44
            r9 = r50
            r11 = r67
            if (r13 < 0) goto L_0x045c
            if (r45 < 0) goto L_0x0450
            if (r15 > 0) goto L_0x00a9
            int r16 = androidx.compose.ui.unit.Constraints.m7054getMinWidthimpl(r9)
            int r17 = androidx.compose.ui.unit.Constraints.m7053getMinHeightimpl(r9)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r18 = r0
            java.util.List r18 = (java.util.List) r18
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r19 = r42.getKeyIndexMap()
            r20 = r42
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider r20 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider) r20
            r25 = 0
            r26 = 0
            r15 = 0
            r23 = 1
            r21 = r52
            r14 = r58
            r24 = r61
            r22 = r62
            r27 = r64
            r28 = r66
            r14.onMeasured(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            if (r62 != 0) goto L_0x0061
            long r0 = r58.m984getMinSizeToFitDisappearingItemsYbymL2g()
            androidx.compose.ui.unit.IntSize$Companion r2 = androidx.compose.ui.unit.IntSize.Companion
            long r2 = r2.m7288getZeroYbymL2g()
            boolean r2 = androidx.compose.ui.unit.IntSize.m7281equalsimpl0(r0, r2)
            if (r2 != 0) goto L_0x0061
            int r2 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r0)
            int r16 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r9, r2)
            int r0 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r0)
            int r17 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r9, r0)
        L_0x0061:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3 r2 = androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3.INSTANCE
            java.lang.Object r0 = r11.invoke(r0, r1, r2)
            r23 = r0
            androidx.compose.ui.layout.MeasureResult r23 = (androidx.compose.ui.layout.MeasureResult) r23
            java.util.List r30 = kotlin.collections.CollectionsKt.emptyList()
            int r0 = -r13
            int r32 = r8 + r45
            if (r52 == 0) goto L_0x007f
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0081
        L_0x007f:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0081:
            r35 = r1
            long r28 = r42.m925getChildConstraintsmsEJaDk()
            androidx.compose.foundation.lazy.LazyListMeasureResult r18 = new androidx.compose.foundation.lazy.LazyListMeasureResult
            r33 = 0
            r38 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r36 = r45
            r37 = r46
            r34 = r56
            r27 = r57
            r26 = r64
            r31 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return r18
        L_0x00a9:
            r14 = 0
            r0 = r47
            if (r0 < r15) goto L_0x00b2
            int r0 = r15 + -1
            r1 = r14
            goto L_0x00b4
        L_0x00b2:
            r1 = r48
        L_0x00b4:
            int r2 = java.lang.Math.round(r49)
            int r1 = r1 - r2
            if (r0 != 0) goto L_0x00bf
            if (r1 >= 0) goto L_0x00bf
            int r2 = r2 + r1
            r1 = r14
        L_0x00bf:
            r6 = r2
            kotlin.collections.ArrayDeque r12 = new kotlin.collections.ArrayDeque
            r12.<init>()
            int r7 = -r13
            if (r46 >= 0) goto L_0x00cb
            r2 = r46
            goto L_0x00cc
        L_0x00cb:
            r2 = r14
        L_0x00cc:
            int r2 = r2 + r7
            int r1 = r1 + r2
            r3 = r14
        L_0x00cf:
            if (r1 >= 0) goto L_0x0108
            if (r0 <= 0) goto L_0x0108
            int r0 = r0 + -1
            r4 = 2
            r5 = 0
            r16 = r2
            r17 = r3
            r2 = 0
            r11 = r1
            r47 = r6
            r6 = r16
            r1 = r0
            r16 = r7
            r7 = r17
            r0 = r42
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = androidx.compose.foundation.lazy.LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(r0, r1, r2, r4, r5)
            r12.add(r14, r2)
            int r0 = r2.getCrossAxisSize()
            int r3 = java.lang.Math.max(r7, r0)
            int r0 = r2.getMainAxisSizeWithSpacings()
            int r0 = r0 + r11
            r2 = r1
            r1 = r0
            r0 = r2
            r11 = r67
            r2 = r6
            r7 = r16
            r6 = r47
            goto L_0x00cf
        L_0x0108:
            r11 = r1
            r47 = r6
            r16 = r7
            r6 = r2
            r7 = r3
            if (r11 >= r6) goto L_0x0116
            int r1 = r47 + r11
            r11 = r1
            r2 = r6
            goto L_0x0119
        L_0x0116:
            r2 = r11
            r11 = r47
        L_0x0119:
            int r2 = r2 - r6
            int r1 = r8 + r45
            int r3 = kotlin.ranges.RangesKt.coerceAtLeast((int) r1, (int) r14)
            int r4 = -r2
            r17 = r0
            r5 = r14
            r18 = r5
        L_0x0126:
            int r14 = r12.size()
            r29 = 1
            if (r5 >= r14) goto L_0x0146
            if (r4 < r3) goto L_0x0136
            r12.remove(r5)
            r18 = r29
            goto L_0x0126
        L_0x0136:
            int r17 = r17 + 1
            java.lang.Object r14 = r12.get(r5)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r14 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r14
            int r14 = r14.getMainAxisSizeWithSpacings()
            int r4 = r4 + r14
            int r5 = r5 + 1
            goto L_0x0126
        L_0x0146:
            r14 = r7
            r7 = r0
            r0 = r14
            r14 = r2
            r2 = r4
            r30 = r18
            r4 = r1
            r1 = r17
        L_0x0150:
            if (r1 >= r15) goto L_0x01a8
            if (r2 < r3) goto L_0x015c
            if (r2 <= 0) goto L_0x015c
            boolean r5 = r12.isEmpty()
            if (r5 == 0) goto L_0x01a8
        L_0x015c:
            r5 = r4
            r4 = 2
            r17 = r5
            r5 = 0
            r20 = r2
            r18 = r3
            r2 = 0
            r47 = r7
            r48 = r14
            r31 = r17
            r14 = r20
            r7 = r0
            r0 = r42
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = androidx.compose.foundation.lazy.LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(r0, r1, r2, r4, r5)
            r0 = r1
            int r1 = r2.getMainAxisSizeWithSpacings()
            int r1 = r1 + r14
            if (r1 > r6) goto L_0x018d
            int r3 = r15 + -1
            if (r0 == r3) goto L_0x018d
            int r3 = r0 + 1
            int r2 = r2.getMainAxisSizeWithSpacings()
            int r14 = r48 - r2
            r30 = r29
            goto L_0x019d
        L_0x018d:
            int r3 = r2.getCrossAxisSize()
            int r3 = java.lang.Math.max(r7, r3)
            r12.add(r2)
            r14 = r48
            r7 = r3
            r3 = r47
        L_0x019d:
            int r0 = r0 + 1
            r2 = r1
            r4 = r31
            r1 = r0
            r0 = r7
            r7 = r3
            r3 = r18
            goto L_0x0150
        L_0x01a8:
            r31 = r4
            r47 = r7
            r48 = r14
            r7 = r0
            r0 = r1
            r14 = r2
            if (r14 >= r8) goto L_0x01fa
            int r6 = r8 - r14
            int r1 = r48 - r6
            int r14 = r14 + r6
            r2 = r1
            r1 = r47
        L_0x01bb:
            if (r2 >= r13) goto L_0x01e4
            if (r1 <= 0) goto L_0x01e4
            int r1 = r1 + -1
            r4 = 2
            r5 = 0
            r17 = r2
            r2 = 0
            r13 = r0
            r0 = r42
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = androidx.compose.foundation.lazy.LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(r0, r1, r2, r4, r5)
            r3 = 0
            r12.add(r3, r2)
            int r4 = r2.getCrossAxisSize()
            int r7 = java.lang.Math.max(r7, r4)
            int r2 = r2.getMainAxisSizeWithSpacings()
            int r2 = r17 + r2
            r0 = r13
            r13 = r44
            goto L_0x01bb
        L_0x01e4:
            r13 = r0
            r17 = r2
            r3 = 0
            r0 = r42
            int r6 = r6 + r11
            if (r17 >= 0) goto L_0x01f5
            int r6 = r6 + r17
            int r2 = r14 + r17
            r26 = r2
            r14 = r3
            goto L_0x0205
        L_0x01f5:
            r26 = r14
            r14 = r17
            goto L_0x0205
        L_0x01fa:
            r13 = r0
            r3 = 0
            r0 = r42
            r1 = r47
            r6 = r11
            r26 = r14
            r14 = r48
        L_0x0205:
            int r2 = java.lang.Math.round(r49)
            int r2 = kotlin.math.MathKt.getSign((int) r2)
            int r4 = kotlin.math.MathKt.getSign((int) r6)
            if (r2 != r4) goto L_0x0224
            int r2 = java.lang.Math.round(r49)
            int r2 = java.lang.Math.abs(r2)
            int r4 = java.lang.Math.abs(r6)
            if (r2 < r4) goto L_0x0224
            float r2 = (float) r6
            r5 = r2
            goto L_0x0226
        L_0x0224:
            r5 = r49
        L_0x0226:
            float r2 = r49 - r5
            r4 = 0
            if (r62 == 0) goto L_0x0234
            if (r6 <= r11) goto L_0x0234
            int r17 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r17 > 0) goto L_0x0234
            int r6 = r6 - r11
            float r4 = (float) r6
            float r4 = r4 + r2
        L_0x0234:
            r32 = r4
            if (r14 < 0) goto L_0x0444
            int r11 = -r14
            java.lang.Object r2 = r12.first()
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r2
            if (r44 > 0) goto L_0x024c
            if (r46 >= 0) goto L_0x0244
            goto L_0x024c
        L_0x0244:
            r25 = r14
            r14 = r2
        L_0x0247:
            r3 = r59
            r4 = r60
            goto L_0x027f
        L_0x024c:
            int r4 = r12.size()
            r6 = r3
        L_0x0251:
            if (r6 >= r4) goto L_0x0278
            java.lang.Object r17 = r12.get(r6)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r17 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r17
            int r3 = r17.getMainAxisSizeWithSpacings()
            if (r14 == 0) goto L_0x0278
            if (r3 > r14) goto L_0x0278
            r17 = r12
            java.util.List r17 = (java.util.List) r17
            r47 = r2
            int r2 = kotlin.collections.CollectionsKt.getLastIndex(r17)
            if (r6 == r2) goto L_0x027a
            int r14 = r14 - r3
            int r6 = r6 + 1
            java.lang.Object r2 = r12.get(r6)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r2
            r3 = 0
            goto L_0x0251
        L_0x0278:
            r47 = r2
        L_0x027a:
            r25 = r14
            r14 = r47
            goto L_0x0247
        L_0x027f:
            java.util.List r1 = createItemsBeforeList(r1, r0, r3, r4)
            int r2 = r1.size()
            r6 = r7
            r7 = 0
        L_0x0289:
            if (r7 >= r2) goto L_0x029e
            java.lang.Object r17 = r1.get(r7)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r17 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r17
            int r0 = r17.getCrossAxisSize()
            int r6 = java.lang.Math.max(r6, r0)
            int r7 = r7 + 1
            r0 = r42
            goto L_0x0289
        L_0x029e:
            r0 = r12
            java.util.List r0 = (java.util.List) r0
            r7 = r63
            r2 = r15
            r33 = r16
            r19 = 0
            r16 = r1
            r15 = r6
            r1 = r42
            r6 = r62
            java.util.List r3 = createItemsAfterList(r0, r1, r2, r3, r4, r5, r6, r7)
            int r1 = r3.size()
            r6 = r15
            r2 = r19
        L_0x02ba:
            if (r2 >= r1) goto L_0x02cd
            java.lang.Object r4 = r3.get(r2)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r4 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r4
            int r4 = r4.getCrossAxisSize()
            int r6 = java.lang.Math.max(r6, r4)
            int r2 = r2 + 1
            goto L_0x02ba
        L_0x02cd:
            java.lang.Object r1 = r12.first()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x02e6
            boolean r1 = r16.isEmpty()
            if (r1 == 0) goto L_0x02e6
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto L_0x02e6
            r34 = r29
            goto L_0x02e8
        L_0x02e6:
            r34 = r19
        L_0x02e8:
            if (r52 == 0) goto L_0x02ec
            r1 = r6
            goto L_0x02ee
        L_0x02ec:
            r1 = r26
        L_0x02ee:
            int r1 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r9, r1)
            if (r52 == 0) goto L_0x02f6
            r6 = r26
        L_0x02f6:
            int r17 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r9, r6)
            r9 = r54
            r10 = r55
            r2 = r3
            r15 = r5
            r6 = r8
            r7 = r11
            r35 = r12
            r4 = r17
            r5 = r26
            r8 = r52
            r11 = r56
            r12 = r57
            r3 = r1
            r1 = r16
            java.util.List r0 = calculateItemsOffsets(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r16 = r3
            r4 = r15
            int r15 = (int) r4
            r3 = r19
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r19 = r42.getKeyIndexMap()
            r20 = r42
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider r20 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider) r20
            r23 = 1
            r21 = r52
            r24 = r61
            r22 = r62
            r27 = r64
            r28 = r66
            r11 = r67
            r18 = r0
            r7 = r3
            r9 = r4
            r10 = r14
            r14 = r58
            r14.onMeasured(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r3 = r16
            r4 = r17
            r12 = r22
            r14 = r26
            if (r12 != 0) goto L_0x0392
            long r1 = r58.m984getMinSizeToFitDisappearingItemsYbymL2g()
            androidx.compose.ui.unit.IntSize$Companion r5 = androidx.compose.ui.unit.IntSize.Companion
            long r7 = r5.m7288getZeroYbymL2g()
            boolean r5 = androidx.compose.ui.unit.IntSize.m7281equalsimpl0(r1, r7)
            if (r5 != 0) goto L_0x0392
            if (r52 == 0) goto L_0x0359
            r5 = r4
            goto L_0x035a
        L_0x0359:
            r5 = r3
        L_0x035a:
            int r7 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r1)
            int r3 = java.lang.Math.max(r3, r7)
            r7 = r50
            int r3 = androidx.compose.ui.unit.ConstraintsKt.m7069constrainWidthK40F9xA(r7, r3)
            int r1 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r1)
            int r1 = java.lang.Math.max(r4, r1)
            int r17 = androidx.compose.ui.unit.ConstraintsKt.m7068constrainHeightK40F9xA(r7, r1)
            if (r52 == 0) goto L_0x0379
            r1 = r17
            goto L_0x037a
        L_0x0379:
            r1 = r3
        L_0x037a:
            if (r1 == r5) goto L_0x038f
            int r2 = r0.size()
            r4 = 0
        L_0x0381:
            if (r4 >= r2) goto L_0x038f
            java.lang.Object r5 = r0.get(r4)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r5 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r5
            r5.updateMainAxisLayoutSize(r1)
            int r4 = r4 + 1
            goto L_0x0381
        L_0x038f:
            r5 = r17
            goto L_0x0393
        L_0x0392:
            r5 = r4
        L_0x0393:
            r4 = r3
            r1 = r53
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x03a9
            r1 = r42
            r3 = r44
            r2 = r53
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = androidx.compose.foundation.lazy.LazyListHeadersKt.findOrComposeLazyListHeader(r0, r1, r2, r3, r4, r5)
            goto L_0x03aa
        L_0x03a9:
            r2 = 0
        L_0x03aa:
            r15 = r41
            if (r13 < r15) goto L_0x03b3
            if (r14 <= r6) goto L_0x03b1
            goto L_0x03b3
        L_0x03b1:
            r3 = 0
            goto L_0x03b5
        L_0x03b3:
            r3 = r29
        L_0x03b5:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8 r5 = new androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8
            r6 = r65
            r5.<init>(r0, r2, r12, r6)
            java.lang.Object r1 = r11.invoke(r1, r4, r5)
            r5 = r1
            androidx.compose.ui.layout.MeasureResult r5 = (androidx.compose.ui.layout.MeasureResult) r5
            if (r34 == 0) goto L_0x03cf
        L_0x03cd:
            r12 = r0
            goto L_0x0415
        L_0x03cf:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r4 = r0.size()
            r1.<init>(r4)
            int r4 = r0.size()
            r14 = 0
        L_0x03dd:
            if (r14 >= r4) goto L_0x0411
            java.lang.Object r6 = r0.get(r14)
            r7 = r6
            androidx.compose.foundation.lazy.LazyListMeasuredItem r7 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r7
            int r8 = r7.getIndex()
            java.lang.Object r11 = r35.first()
            androidx.compose.foundation.lazy.LazyListMeasuredItem r11 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r11
            int r11 = r11.getIndex()
            if (r8 < r11) goto L_0x0406
            int r8 = r7.getIndex()
            java.lang.Object r11 = r35.last()
            androidx.compose.foundation.lazy.LazyListMeasuredItem r11 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r11
            int r11 = r11.getIndex()
            if (r8 <= r11) goto L_0x0408
        L_0x0406:
            if (r7 != r2) goto L_0x040e
        L_0x0408:
            r7 = r1
            java.util.Collection r7 = (java.util.Collection) r7
            r7.add(r6)
        L_0x040e:
            int r14 = r14 + 1
            goto L_0x03dd
        L_0x0411:
            r0 = r1
            java.util.List r0 = (java.util.List) r0
            goto L_0x03cd
        L_0x0415:
            if (r52 == 0) goto L_0x041a
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x041c
        L_0x041a:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x041c:
            r17 = r0
            long r0 = r42.m925getChildConstraintsmsEJaDk()
            r39 = r0
            r1 = r10
            r10 = r39
            androidx.compose.foundation.lazy.LazyListMeasureResult r0 = new androidx.compose.foundation.lazy.LazyListMeasureResult
            r20 = 0
            r18 = r45
            r19 = r46
            r16 = r56
            r8 = r64
            r4 = r9
            r2 = r25
            r7 = r30
            r14 = r31
            r6 = r32
            r13 = r33
            r9 = r57
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x0444:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative currentFirstItemScrollOffset"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0450:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "invalid afterContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x045c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "invalid beforeContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.m913measureLazyListx0Ok8Vo(int, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, boolean, boolean, androidx.compose.foundation.lazy.LazyListLayoutInfo, kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MutableState, androidx.compose.ui.graphics.GraphicsContext, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.LazyListMeasureResult");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        r6 = r6.get(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> createItemsAfterList(java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r14, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r15, int r16, int r17, java.util.List<java.lang.Integer> r18, float r19, boolean r20, androidx.compose.foundation.lazy.LazyListLayoutInfo r21) {
        /*
            r0 = r16
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r14)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r1 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r1
            int r1 = r1.getIndex()
            int r1 = r1 + r17
            int r2 = r0 + -1
            int r1 = java.lang.Math.min(r1, r2)
            java.lang.Object r3 = kotlin.collections.CollectionsKt.last(r14)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r3 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r3
            int r3 = r3.getIndex()
            int r3 = r3 + 1
            r4 = 0
            if (r3 > r1) goto L_0x003f
            r6 = r3
            r3 = r4
        L_0x0025:
            if (r3 != 0) goto L_0x002e
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
        L_0x002e:
            r9 = 2
            r10 = 0
            r7 = 0
            r5 = r15
            androidx.compose.foundation.lazy.LazyListMeasuredItem r7 = androidx.compose.foundation.lazy.LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(r5, r6, r7, r9, r10)
            r3.add(r7)
            if (r6 == r1) goto L_0x0040
            int r6 = r6 + 1
            goto L_0x0025
        L_0x003f:
            r3 = r4
        L_0x0040:
            r5 = 0
            if (r20 == 0) goto L_0x0169
            if (r21 == 0) goto L_0x0169
            java.util.List r6 = r21.getVisibleItemsInfo()
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0169
            java.util.List r6 = r21.getVisibleItemsInfo()
            int r7 = r6.size()
            int r7 = r7 + -1
        L_0x005b:
            r8 = -1
            if (r8 >= r7) goto L_0x0084
            java.lang.Object r8 = r6.get(r7)
            androidx.compose.foundation.lazy.LazyListItemInfo r8 = (androidx.compose.foundation.lazy.LazyListItemInfo) r8
            int r8 = r8.getIndex()
            if (r8 <= r1) goto L_0x0081
            if (r7 == 0) goto L_0x007a
            int r8 = r7 + -1
            java.lang.Object r8 = r6.get(r8)
            androidx.compose.foundation.lazy.LazyListItemInfo r8 = (androidx.compose.foundation.lazy.LazyListItemInfo) r8
            int r8 = r8.getIndex()
            if (r8 > r1) goto L_0x0081
        L_0x007a:
            java.lang.Object r6 = r6.get(r7)
            androidx.compose.foundation.lazy.LazyListItemInfo r6 = (androidx.compose.foundation.lazy.LazyListItemInfo) r6
            goto L_0x0085
        L_0x0081:
            int r7 = r7 + -1
            goto L_0x005b
        L_0x0084:
            r6 = r4
        L_0x0085:
            java.util.List r7 = r21.getVisibleItemsInfo()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.last(r7)
            androidx.compose.foundation.lazy.LazyListItemInfo r7 = (androidx.compose.foundation.lazy.LazyListItemInfo) r7
            if (r6 == 0) goto L_0x00db
            int r6 = r6.getIndex()
            int r8 = r7.getIndex()
            int r2 = java.lang.Math.min(r8, r2)
            if (r6 > r2) goto L_0x00db
            r9 = r6
        L_0x00a0:
            if (r3 == 0) goto L_0x00be
            int r6 = r3.size()
            r8 = r5
        L_0x00a7:
            if (r8 >= r6) goto L_0x00ba
            java.lang.Object r10 = r3.get(r8)
            r11 = r10
            androidx.compose.foundation.lazy.LazyListMeasuredItem r11 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r11
            int r11 = r11.getIndex()
            if (r11 != r9) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            int r8 = r8 + 1
            goto L_0x00a7
        L_0x00ba:
            r10 = r4
        L_0x00bb:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r10 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r10
            goto L_0x00bf
        L_0x00be:
            r10 = r4
        L_0x00bf:
            if (r10 != 0) goto L_0x00d6
            if (r3 != 0) goto L_0x00ca
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
        L_0x00ca:
            r12 = 2
            r13 = 0
            r10 = 0
            r8 = r15
            androidx.compose.foundation.lazy.LazyListMeasuredItem r6 = androidx.compose.foundation.lazy.LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(r8, r9, r10, r12, r13)
            r3.add(r6)
        L_0x00d6:
            if (r9 == r2) goto L_0x00db
            int r9 = r9 + 1
            goto L_0x00a0
        L_0x00db:
            int r2 = r21.getViewportEndOffset()
            int r6 = r7.getOffset()
            int r2 = r2 - r6
            int r6 = r7.getSize()
            int r2 = r2 - r6
            float r2 = (float) r2
            float r2 = r2 - r19
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0169
            int r6 = r7.getIndex()
            int r6 = r6 + 1
            r9 = r6
            r6 = r5
        L_0x00f9:
            if (r9 >= r0) goto L_0x0169
            float r7 = (float) r6
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0169
            if (r9 > r1) goto L_0x011e
            int r7 = r14.size()
            r8 = r5
        L_0x0107:
            if (r8 >= r7) goto L_0x011a
            java.lang.Object r10 = r14.get(r8)
            r11 = r10
            androidx.compose.foundation.lazy.LazyListMeasuredItem r11 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r11
            int r11 = r11.getIndex()
            if (r11 != r9) goto L_0x0117
            goto L_0x011b
        L_0x0117:
            int r8 = r8 + 1
            goto L_0x0107
        L_0x011a:
            r10 = r4
        L_0x011b:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r10 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r10
            goto L_0x013d
        L_0x011e:
            if (r3 == 0) goto L_0x013c
            int r7 = r3.size()
            r8 = r5
        L_0x0125:
            if (r8 >= r7) goto L_0x0138
            java.lang.Object r10 = r3.get(r8)
            r11 = r10
            androidx.compose.foundation.lazy.LazyListMeasuredItem r11 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r11
            int r11 = r11.getIndex()
            if (r11 != r9) goto L_0x0135
            goto L_0x0139
        L_0x0135:
            int r8 = r8 + 1
            goto L_0x0125
        L_0x0138:
            r10 = r4
        L_0x0139:
            androidx.compose.foundation.lazy.LazyListMeasuredItem r10 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r10
            goto L_0x013d
        L_0x013c:
            r10 = r4
        L_0x013d:
            if (r10 == 0) goto L_0x0147
            int r9 = r9 + 1
            int r7 = r10.getMainAxisSizeWithSpacings()
        L_0x0145:
            int r6 = r6 + r7
            goto L_0x00f9
        L_0x0147:
            if (r3 != 0) goto L_0x0150
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
        L_0x0150:
            r12 = 2
            r13 = 0
            r10 = 0
            r8 = r15
            androidx.compose.foundation.lazy.LazyListMeasuredItem r7 = androidx.compose.foundation.lazy.LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(r8, r9, r10, r12, r13)
            r3.add(r7)
            int r9 = r9 + 1
            java.lang.Object r7 = kotlin.collections.CollectionsKt.last(r3)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r7 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r7
            int r7 = r7.getMainAxisSizeWithSpacings()
            goto L_0x0145
        L_0x0169:
            if (r3 == 0) goto L_0x0181
            java.lang.Object r14 = kotlin.collections.CollectionsKt.last(r3)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r14 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r14
            int r14 = r14.getIndex()
            if (r14 <= r1) goto L_0x0181
            java.lang.Object r14 = kotlin.collections.CollectionsKt.last(r3)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r14 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r14
            int r1 = r14.getIndex()
        L_0x0181:
            int r14 = r18.size()
        L_0x0185:
            if (r5 >= r14) goto L_0x01ae
            r0 = r18
            java.lang.Object r2 = r0.get(r5)
            java.lang.Number r2 = (java.lang.Number) r2
            int r9 = r2.intValue()
            if (r9 <= r1) goto L_0x01ab
            if (r3 != 0) goto L_0x019f
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = r2
            java.util.List r3 = (java.util.List) r3
        L_0x019f:
            r12 = 2
            r13 = 0
            r10 = 0
            r8 = r15
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = androidx.compose.foundation.lazy.LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(r8, r9, r10, r12, r13)
            r3.add(r2)
        L_0x01ab:
            int r5 = r5 + 1
            goto L_0x0185
        L_0x01ae:
            if (r3 != 0) goto L_0x01b5
            java.util.List r14 = kotlin.collections.CollectionsKt.emptyList()
            return r14
        L_0x01b5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.createItemsAfterList(java.util.List, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, int, int, java.util.List, float, boolean, androidx.compose.foundation.lazy.LazyListLayoutInfo):java.util.List");
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        List<LazyListMeasuredItem> list2 = null;
        if (max <= i3) {
            int i4 = i3;
            while (true) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                list2.add(LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i4, 0, 2, (Object) null));
                if (i4 == max) {
                    break;
                }
                i4--;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i5 = size - 1;
                int intValue = list.get(size).intValue();
                if (intValue < max) {
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                    }
                    list2.add(LazyListMeasuredItemProvider.m920getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, intValue, 0, 2, (Object) null));
                }
                if (i5 < 0) {
                    break;
                }
                size = i5;
            }
        }
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        Arrangement.Vertical vertical2 = vertical;
        boolean z3 = z2;
        int i6 = z ? i2 : i;
        boolean z4 = i3 < Math.min(i6, i4);
        if (!z4 || i5 == 0) {
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
            if (!z4) {
                int size = list2.size();
                int i7 = i5;
                for (int i8 = 0; i8 < size; i8++) {
                    LazyListMeasuredItem lazyListMeasuredItem = list2.get(i8);
                    i7 -= lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyListMeasuredItem.position(i7, i, i2);
                    arrayList.add(lazyListMeasuredItem);
                }
                int size2 = list.size();
                int i9 = i5;
                for (int i10 = 0; i10 < size2; i10++) {
                    LazyListMeasuredItem lazyListMeasuredItem2 = list.get(i10);
                    lazyListMeasuredItem2.position(i9, i, i2);
                    arrayList.add(lazyListMeasuredItem2);
                    i9 += lazyListMeasuredItem2.getMainAxisSizeWithSpacings();
                }
                int size3 = list3.size();
                for (int i11 = 0; i11 < size3; i11++) {
                    LazyListMeasuredItem lazyListMeasuredItem3 = list3.get(i11);
                    lazyListMeasuredItem3.position(i9, i, i2);
                    arrayList.add(lazyListMeasuredItem3);
                    i9 += lazyListMeasuredItem3.getMainAxisSizeWithSpacings();
                }
            } else if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no extra items".toString());
            } else {
                int size4 = list.size();
                int[] iArr = new int[size4];
                for (int i12 = 0; i12 < size4; i12++) {
                    iArr[i12] = list.get(calculateItemsOffsets$reverseAware(i12, z3, size4)).getSize();
                }
                int[] iArr2 = new int[size4];
                for (int i13 = 0; i13 < size4; i13++) {
                    iArr2[i13] = 0;
                }
                if (!z) {
                    Density density2 = density;
                    if (horizontal != null) {
                        horizontal.arrange(density2, i6, iArr, LayoutDirection.Ltr, iArr2);
                    } else {
                        throw new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
                    }
                } else if (vertical2 != null) {
                    vertical2.arrange(density, i6, iArr, iArr2);
                } else {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
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
                        int i14 = iArr2[first];
                        LazyListMeasuredItem lazyListMeasuredItem4 = list.get(calculateItemsOffsets$reverseAware(first, z3, size4));
                        if (z3) {
                            i14 = (i6 - i14) - lazyListMeasuredItem4.getSize();
                        }
                        lazyListMeasuredItem4.position(i14, i, i2);
                        arrayList.add(lazyListMeasuredItem4);
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("non-zero itemsScrollOffset".toString());
    }
}
