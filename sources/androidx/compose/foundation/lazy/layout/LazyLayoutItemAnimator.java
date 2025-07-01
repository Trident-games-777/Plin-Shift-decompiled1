package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003IJKB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000bJ1\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u000b2\u0012\b\u0002\u0010.\u001a\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u0010/J\u0001\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\r2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0006\u0010B\u001a\u00020,J\u001f\u0010C\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\b\b\u0002\u0010D\u001a\u00020#H\u0002¢\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u00020\u000b*\u00020G2\u0006\u0010-\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010HR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u00020\u00128Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020#*\u00028\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\u000b*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006L"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "()V", "disappearingItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "crossAxisOffset", "getCrossAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)Z", "mainAxisOffset", "getMainAxisOffset", "getAnimation", "key", "placeableIndex", "initializeAnimation", "", "item", "itemInfo", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;ILandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;)V", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "isVertical", "isLookingAhead", "laneCount", "hasLookaheadOccurred", "layoutMinOffset", "layoutMaxOffset", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "removeInfoForKey", "reset", "startPlacementAnimationsIfNeeded", "isMovingAway", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Z)V", "updateAndReturnOffsetFor", "", "([ILandroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "ItemInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemAnimator.kt */
public final class LazyLayoutItemAnimator<T extends LazyLayoutMeasuredItem> {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final List<LazyLayoutItemAnimation> disappearingItems = new ArrayList();
    /* access modifiers changed from: private */
    public DrawModifierNode displayingNode;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private final Modifier modifier = new DisplayingDisappearingItemsElement(this);
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<T> movingAwayToEndBound = new ArrayList();
    private final List<T> movingAwayToStartBound = new ArrayList();
    private final List<T> movingInFromEndBound = new ArrayList();
    private final List<T> movingInFromStartBound = new ArrayList();

    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0402, code lost:
        r34.updateAnimation(r35, r54, r55, r52, r53, r34.getCrossAxisOffset());
        r2 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0415, code lost:
        if (r5 >= r0.firstVisibleIndex) goto L_0x041d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0417, code lost:
        r0.movingAwayToStartBound.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x041d, code lost:
        r0.movingAwayToEndBound.add(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasured(int r42, int r43, int r44, java.util.List<T> r45, androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r46, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider<T> r47, boolean r48, boolean r49, int r50, boolean r51, int r52, int r53, kotlinx.coroutines.CoroutineScope r54, androidx.compose.ui.graphics.GraphicsContext r55) {
        /*
            r41 = this;
            r0 = r41
            r1 = r42
            r8 = r45
            r9 = r46
            r10 = r50
            androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r11 = r0.keyIndexMap
            r0.keyIndexMap = r9
            int r2 = r8.size()
            r12 = 0
            r3 = r12
        L_0x0014:
            if (r3 >= r2) goto L_0x0026
            java.lang.Object r4 = r8.get(r3)
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r4 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) r4
            boolean r4 = r0.getHasAnimations(r4)
            if (r4 == 0) goto L_0x0023
            goto L_0x0032
        L_0x0023:
            int r3 = r3 + 1
            goto L_0x0014
        L_0x0026:
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<T>$ItemInfo> r2 = r0.keyToItemInfoMap
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0032
            r0.reset()
            return
        L_0x0032:
            int r2 = r0.firstVisibleIndex
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r8)
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r3 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) r3
            if (r3 == 0) goto L_0x0041
            int r3 = r3.getIndex()
            goto L_0x0042
        L_0x0041:
            r3 = r12
        L_0x0042:
            r0.firstVisibleIndex = r3
            if (r48 == 0) goto L_0x004b
            long r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r12, r1)
            goto L_0x004f
        L_0x004b:
            long r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r1, r12)
        L_0x004f:
            if (r49 != 0) goto L_0x0056
            if (r51 != 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r14 = r12
            goto L_0x0057
        L_0x0056:
            r14 = 1
        L_0x0057:
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<T>$ItemInfo> r1 = r0.keyToItemInfoMap
            androidx.collection.ScatterMap r1 = (androidx.collection.ScatterMap) r1
            java.lang.Object[] r5 = r1.keys
            long[] r1 = r1.metadata
            int r15 = r1.length
            r42 = r5
            r5 = 2
            int r15 = r15 - r5
            r16 = 128(0x80, double:6.32E-322)
            r18 = 255(0xff, double:1.26E-321)
            r20 = 7
            r21 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            if (r15 < 0) goto L_0x00bb
            r5 = r12
        L_0x0072:
            r24 = 8
            r12 = r1[r5]
            long r6 = ~r12
            long r6 = r6 << r20
            long r6 = r6 & r12
            long r6 = r6 & r21
            int r6 = (r6 > r21 ? 1 : (r6 == r21 ? 0 : -1))
            if (r6 == 0) goto L_0x00b2
            int r6 = r5 - r15
            int r6 = ~r6
            int r6 = r6 >>> 31
            int r6 = 8 - r6
            r7 = 0
        L_0x0088:
            if (r7 >= r6) goto L_0x00ab
            long r25 = r12 & r18
            int r25 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r25 >= 0) goto L_0x00a0
            int r25 = r5 << 3
            int r25 = r25 + r7
            r26 = r1
            r1 = r42[r25]
            r25 = r7
            androidx.collection.MutableScatterSet<java.lang.Object> r7 = r0.movingAwayKeys
            r7.add(r1)
            goto L_0x00a4
        L_0x00a0:
            r26 = r1
            r25 = r7
        L_0x00a4:
            long r12 = r12 >> r24
            int r7 = r25 + 1
            r1 = r26
            goto L_0x0088
        L_0x00ab:
            r26 = r1
            r1 = r24
            if (r6 != r1) goto L_0x00bb
            goto L_0x00b4
        L_0x00b2:
            r26 = r1
        L_0x00b4:
            if (r5 == r15) goto L_0x00bb
            int r5 = r5 + 1
            r1 = r26
            goto L_0x0072
        L_0x00bb:
            int r1 = r8.size()
            r5 = 0
        L_0x00c0:
            r6 = -1
            if (r5 >= r1) goto L_0x020b
            java.lang.Object r12 = r8.get(r5)
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r12 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) r12
            androidx.collection.MutableScatterSet<java.lang.Object> r13 = r0.movingAwayKeys
            java.lang.Object r15 = r12.getKey()
            r13.remove(r15)
            boolean r13 = r0.getHasAnimations(r12)
            if (r13 == 0) goto L_0x01f5
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<T>$ItemInfo> r13 = r0.keyToItemInfoMap
            java.lang.Object r15 = r12.getKey()
            java.lang.Object r13 = r13.get(r15)
            r25 = r13
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo r25 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo) r25
            if (r11 == 0) goto L_0x00f1
            java.lang.Object r13 = r12.getKey()
            int r13 = r11.getIndex(r13)
            goto L_0x00f2
        L_0x00f1:
            r13 = r6
        L_0x00f2:
            if (r13 != r6) goto L_0x00f8
            if (r11 == 0) goto L_0x00f8
            r15 = 1
            goto L_0x00f9
        L_0x00f8:
            r15 = 0
        L_0x00f9:
            if (r25 != 0) goto L_0x0166
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo r7 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo
            r7.<init>()
            r32 = 32
            r33 = 0
            r31 = 0
            r29 = r52
            r30 = r53
            r27 = r54
            r28 = r55
            r25 = r7
            r26 = r12
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r25, r26, r27, r28, r29, r30, r31, r32, r33)
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<T>$ItemInfo> r6 = r0.keyToItemInfoMap
            r34 = r1
            java.lang.Object r1 = r12.getKey()
            r6.set(r1, r7)
            int r1 = r12.getIndex()
            if (r1 == r13) goto L_0x0139
            r1 = -1
            if (r13 == r1) goto L_0x0139
            if (r13 >= r2) goto L_0x0132
            java.util.List<T> r1 = r0.movingInFromStartBound
            r1.add(r12)
            goto L_0x01ef
        L_0x0132:
            java.util.List<T> r1 = r0.movingInFromEndBound
            r1.add(r12)
            goto L_0x01ef
        L_0x0139:
            r1 = 0
            long r25 = r12.m1013getOffsetBjo55l4(r1)
            boolean r1 = r12.isVertical()
            if (r1 == 0) goto L_0x0149
            int r1 = androidx.compose.ui.unit.IntOffset.m7242getYimpl(r25)
            goto L_0x014d
        L_0x0149:
            int r1 = androidx.compose.ui.unit.IntOffset.m7241getXimpl(r25)
        L_0x014d:
            r0.initializeAnimation(r12, r1, r7)
            if (r15 == 0) goto L_0x01ef
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] r1 = r7.getAnimations()
            int r6 = r1.length
            r7 = 0
        L_0x0158:
            if (r7 >= r6) goto L_0x01ef
            r12 = r1[r7]
            if (r12 == 0) goto L_0x0163
            r12.animateAppearance()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
        L_0x0163:
            int r7 = r7 + 1
            goto L_0x0158
        L_0x0166:
            r34 = r1
            if (r14 == 0) goto L_0x01ef
            r32 = 32
            r33 = 0
            r31 = 0
            r29 = r52
            r30 = r53
            r27 = r54
            r28 = r55
            r26 = r12
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r25, r26, r27, r28, r29, r30, r31, r32, r33)
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] r1 = r25.getAnimations()
            int r6 = r1.length
            r13 = 0
        L_0x0183:
            if (r13 >= r6) goto L_0x01bc
            r7 = r1[r13]
            r42 = r1
            r27 = r2
            if (r7 == 0) goto L_0x01ad
            long r1 = r7.m979getRawOffsetnOccac()
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$Companion r28 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.Companion
            r29 = r5
            r30 = r6
            long r5 = r28.m983getNotInitializednOccac()
            boolean r1 = androidx.compose.ui.unit.IntOffset.m7240equalsimpl0(r1, r5)
            if (r1 != 0) goto L_0x01b1
            long r1 = r7.m979getRawOffsetnOccac()
            long r1 = androidx.compose.ui.unit.IntOffset.m7245plusqkQi6aY(r1, r3)
            r7.m982setRawOffsetgyyYBs(r1)
            goto L_0x01b1
        L_0x01ad:
            r29 = r5
            r30 = r6
        L_0x01b1:
            int r13 = r13 + 1
            r1 = r42
            r2 = r27
            r5 = r29
            r6 = r30
            goto L_0x0183
        L_0x01bc:
            r27 = r2
            r29 = r5
            if (r15 == 0) goto L_0x01e8
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] r1 = r25.getAnimations()
            int r2 = r1.length
            r5 = 0
        L_0x01c8:
            if (r5 >= r2) goto L_0x01e8
            r6 = r1[r5]
            if (r6 == 0) goto L_0x01e5
            boolean r7 = r6.isDisappearanceAnimationInProgress()
            if (r7 == 0) goto L_0x01e2
            java.util.List<androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation> r7 = r0.disappearingItems
            r7.remove(r6)
            androidx.compose.ui.node.DrawModifierNode r7 = r0.displayingNode
            if (r7 == 0) goto L_0x01e2
            androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x01e2:
            r6.animateAppearance()
        L_0x01e5:
            int r5 = r5 + 1
            goto L_0x01c8
        L_0x01e8:
            r1 = 0
            r2 = 2
            r5 = 0
            startPlacementAnimationsIfNeeded$default(r0, r12, r5, r2, r1)
            goto L_0x0203
        L_0x01ef:
            r27 = r2
            r29 = r5
            r2 = 2
            goto L_0x0203
        L_0x01f5:
            r34 = r1
            r27 = r2
            r29 = r5
            r2 = 2
            java.lang.Object r1 = r12.getKey()
            r0.removeInfoForKey(r1)
        L_0x0203:
            int r5 = r29 + 1
            r2 = r27
            r1 = r34
            goto L_0x00c0
        L_0x020b:
            r2 = 2
            int[] r6 = new int[r10]
            r1 = 0
        L_0x020f:
            if (r1 >= r10) goto L_0x0218
            r23 = 0
            r6[r1] = r23
            int r1 = r1 + 1
            goto L_0x020f
        L_0x0218:
            if (r14 == 0) goto L_0x02c6
            if (r11 == 0) goto L_0x02c6
            java.util.List<T> r1 = r0.movingInFromStartBound
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0270
            java.util.List<T> r1 = r0.movingInFromStartBound
            int r3 = r1.size()
            r4 = 1
            if (r3 <= r4) goto L_0x0239
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1 r3 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1
            r3.<init>(r11)
            java.util.Comparator r3 = (java.util.Comparator) r3
            kotlin.collections.CollectionsKt.sortWith(r1, r3)
        L_0x0239:
            java.util.List<T> r7 = r0.movingInFromStartBound
            int r12 = r7.size()
            r13 = 0
        L_0x0240:
            if (r13 >= r12) goto L_0x025f
            java.lang.Object r1 = r7.get(r13)
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r1 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) r1
            int r3 = r0.updateAndReturnOffsetFor(r6, r1)
            int r3 = r52 - r3
            r4 = 4
            r5 = 0
            r15 = r2
            r2 = r3
            r3 = 0
            initializeAnimation$default(r0, r1, r2, r3, r4, r5)
            r2 = 0
            r5 = 0
            startPlacementAnimationsIfNeeded$default(r0, r1, r5, r15, r2)
            int r13 = r13 + 1
            r2 = r15
            goto L_0x0240
        L_0x025f:
            r15 = r2
            r32 = 6
            r33 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r28 = r6
            kotlin.collections.ArraysKt.fill$default((int[]) r28, (int) r29, (int) r30, (int) r31, (int) r32, (java.lang.Object) r33)
            goto L_0x0271
        L_0x0270:
            r15 = r2
        L_0x0271:
            java.util.List<T> r1 = r0.movingInFromEndBound
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x02c7
            java.util.List<T> r1 = r0.movingInFromEndBound
            int r2 = r1.size()
            r4 = 1
            if (r2 <= r4) goto L_0x028e
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1 r2 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1
            r2.<init>(r11)
            java.util.Comparator r2 = (java.util.Comparator) r2
            kotlin.collections.CollectionsKt.sortWith(r1, r2)
        L_0x028e:
            java.util.List<T> r7 = r0.movingInFromEndBound
            int r12 = r7.size()
            r13 = 0
        L_0x0295:
            if (r13 >= r12) goto L_0x02b6
            java.lang.Object r1 = r7.get(r13)
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r1 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) r1
            int r2 = r0.updateAndReturnOffsetFor(r6, r1)
            int r2 = r53 + r2
            int r3 = r1.getMainAxisSizeWithSpacings()
            int r2 = r2 - r3
            r4 = 4
            r5 = 0
            r3 = 0
            initializeAnimation$default(r0, r1, r2, r3, r4, r5)
            r2 = 0
            r5 = 0
            startPlacementAnimationsIfNeeded$default(r0, r1, r5, r15, r2)
            int r13 = r13 + 1
            goto L_0x0295
        L_0x02b6:
            r32 = 6
            r33 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r28 = r6
            kotlin.collections.ArraysKt.fill$default((int[]) r28, (int) r29, (int) r30, (int) r31, (int) r32, (java.lang.Object) r33)
            goto L_0x02c7
        L_0x02c6:
            r15 = r2
        L_0x02c7:
            androidx.collection.MutableScatterSet<java.lang.Object> r1 = r0.movingAwayKeys
            androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
            java.lang.Object[] r2 = r1.elements
            long[] r1 = r1.metadata
            int r3 = r1.length
            int r3 = r3 - r15
            if (r3 < 0) goto L_0x0458
            r4 = 0
        L_0x02d4:
            r12 = r1[r4]
            r7 = r1
            r5 = r2
            long r1 = ~r12
            long r1 = r1 << r20
            long r1 = r1 & r12
            long r1 = r1 & r21
            int r1 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r1 == 0) goto L_0x0444
            int r1 = r4 - r3
            int r1 = ~r1
            int r1 = r1 >>> 31
            r24 = 8
            int r1 = 8 - r1
            r2 = 0
        L_0x02ec:
            if (r2 >= r1) goto L_0x0439
            long r27 = r12 & r18
            int r15 = (r27 > r16 ? 1 : (r27 == r16 ? 0 : -1))
            if (r15 >= 0) goto L_0x0423
            int r15 = r4 << 3
            int r15 = r15 + r2
            r15 = r5[r15]
            r25 = r2
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<T>$ItemInfo> r2 = r0.keyToItemInfoMap
            java.lang.Object r2 = r2.get(r15)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo r2 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo) r2
            r51 = r5
            int r5 = r9.getIndex(r15)
            r33 = r7
            int r7 = r2.getSpan()
            int r7 = java.lang.Math.min(r10, r7)
            r2.setSpan(r7)
            int r7 = r2.getSpan()
            int r7 = r10 - r7
            int r10 = r2.getLane()
            int r7 = java.lang.Math.min(r7, r10)
            r2.setLane(r7)
            r7 = -1
            if (r5 != r7) goto L_0x03b2
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] r5 = r2.getAnimations()
            int r10 = r5.length
            r7 = 0
            r27 = 0
            r28 = 0
        L_0x0337:
            if (r7 >= r10) goto L_0x03a9
            r34 = r2
            r2 = r5[r7]
            int r29 = r28 + 1
            if (r2 == 0) goto L_0x039c
            boolean r30 = r2.isDisappearanceAnimationInProgress()
            if (r30 == 0) goto L_0x034e
            r30 = r5
        L_0x0349:
            r26 = 0
            r27 = 1
            goto L_0x03a0
        L_0x034e:
            boolean r30 = r2.isDisappearanceAnimationFinished()
            if (r30 == 0) goto L_0x0370
            r2.release()
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] r30 = r34.getAnimations()
            r26 = 0
            r30[r28] = r26
            r30 = r5
            java.util.List<androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation> r5 = r0.disappearingItems
            r5.remove(r2)
            androidx.compose.ui.node.DrawModifierNode r2 = r0.displayingNode
            if (r2 == 0) goto L_0x039e
            androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x039e
        L_0x0370:
            r30 = r5
            androidx.compose.ui.graphics.layer.GraphicsLayer r5 = r2.getLayer()
            if (r5 == 0) goto L_0x037b
            r2.animateDisappearance()
        L_0x037b:
            boolean r5 = r2.isDisappearanceAnimationInProgress()
            if (r5 == 0) goto L_0x0390
            java.util.List<androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation> r5 = r0.disappearingItems
            r5.add(r2)
            androidx.compose.ui.node.DrawModifierNode r2 = r0.displayingNode
            if (r2 == 0) goto L_0x0349
            androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x0349
        L_0x0390:
            r2.release()
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] r2 = r34.getAnimations()
            r26 = 0
            r2[r28] = r26
            goto L_0x03a0
        L_0x039c:
            r30 = r5
        L_0x039e:
            r26 = 0
        L_0x03a0:
            int r7 = r7 + 1
            r28 = r29
            r5 = r30
            r2 = r34
            goto L_0x0337
        L_0x03a9:
            r26 = 0
            if (r27 != 0) goto L_0x042b
            r0.removeInfoForKey(r15)
            goto L_0x042b
        L_0x03b2:
            r34 = r2
            r26 = 0
            androidx.compose.ui.unit.Constraints r2 = r34.m985getConstraintsDWUhwKw()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r31 = r2.m7058unboximpl()
            int r29 = r34.getLane()
            int r30 = r34.getSpan()
            r27 = r47
            r28 = r5
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r2 = r27.m1014getAndMeasurehBUhpc(r28, r29, r30, r31)
            r7 = 1
            r2.setNonScrollableItem(r7)
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] r10 = r34.getAnimations()
            int r7 = r10.length
            r35 = r2
            r2 = 0
        L_0x03dd:
            if (r2 >= r7) goto L_0x03f6
            r27 = r10[r2]
            r28 = r2
            if (r27 == 0) goto L_0x03ef
            boolean r2 = r27.isPlacementAnimationInProgress()
            r27 = r7
            r7 = 1
            if (r2 != r7) goto L_0x03f1
            goto L_0x0402
        L_0x03ef:
            r27 = r7
        L_0x03f1:
            int r2 = r28 + 1
            r7 = r27
            goto L_0x03dd
        L_0x03f6:
            if (r11 == 0) goto L_0x0402
            int r2 = r11.getIndex(r15)
            if (r5 != r2) goto L_0x0402
            r0.removeInfoForKey(r15)
            goto L_0x042b
        L_0x0402:
            int r40 = r34.getCrossAxisOffset()
            r38 = r52
            r39 = r53
            r36 = r54
            r37 = r55
            r34.updateAnimation(r35, r36, r37, r38, r39, r40)
            r2 = r35
            int r7 = r0.firstVisibleIndex
            if (r5 >= r7) goto L_0x041d
            java.util.List<T> r5 = r0.movingAwayToStartBound
            r5.add(r2)
            goto L_0x042b
        L_0x041d:
            java.util.List<T> r5 = r0.movingAwayToEndBound
            r5.add(r2)
            goto L_0x042b
        L_0x0423:
            r25 = r2
            r51 = r5
            r33 = r7
            r26 = 0
        L_0x042b:
            r2 = 8
            long r12 = r12 >> r2
            int r5 = r25 + 1
            r10 = r50
            r2 = r5
            r7 = r33
            r5 = r51
            goto L_0x02ec
        L_0x0439:
            r51 = r5
            r33 = r7
            r2 = 8
            r26 = 0
            if (r1 != r2) goto L_0x0458
            goto L_0x044c
        L_0x0444:
            r51 = r5
            r33 = r7
            r2 = 8
            r26 = 0
        L_0x044c:
            if (r4 == r3) goto L_0x0458
            int r4 = r4 + 1
            r10 = r50
            r2 = r51
            r1 = r33
            goto L_0x02d4
        L_0x0458:
            java.util.List<T> r1 = r0.movingAwayToStartBound
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x04d6
            java.util.List<T> r1 = r0.movingAwayToStartBound
            int r2 = r1.size()
            r4 = 1
            if (r2 <= r4) goto L_0x0475
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2 r2 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2
            r2.<init>(r9)
            java.util.Comparator r2 = (java.util.Comparator) r2
            kotlin.collections.CollectionsKt.sortWith(r1, r2)
        L_0x0475:
            java.util.List<T> r1 = r0.movingAwayToStartBound
            int r2 = r1.size()
            r3 = 0
        L_0x047c:
            if (r3 >= r2) goto L_0x04bd
            java.lang.Object r4 = r1.get(r3)
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r4 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) r4
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<T>$ItemInfo> r5 = r0.keyToItemInfoMap
            java.lang.Object r7 = r4.getKey()
            java.lang.Object r5 = r5.get(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo r5 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo) r5
            int r7 = r0.updateAndReturnOffsetFor(r6, r4)
            if (r49 == 0) goto L_0x04a4
            java.lang.Object r10 = kotlin.collections.CollectionsKt.first(r8)
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r10 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) r10
            int r10 = r0.getMainAxisOffset(r10)
            goto L_0x04a8
        L_0x04a4:
            int r10 = r5.getLayoutMinOffset()
        L_0x04a8:
            int r10 = r10 - r7
            int r5 = r5.getCrossAxisOffset()
            r7 = r43
            r11 = r44
            r4.position(r10, r5, r7, r11)
            if (r14 == 0) goto L_0x04ba
            r5 = 1
            r0.startPlacementAnimationsIfNeeded(r4, r5)
        L_0x04ba:
            int r3 = r3 + 1
            goto L_0x047c
        L_0x04bd:
            r7 = r43
            r11 = r44
            r1 = 6
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r54 = r1
            r55 = r2
            r51 = r3
            r52 = r4
            r53 = r5
            r50 = r6
            kotlin.collections.ArraysKt.fill$default((int[]) r50, (int) r51, (int) r52, (int) r53, (int) r54, (java.lang.Object) r55)
            goto L_0x04da
        L_0x04d6:
            r7 = r43
            r11 = r44
        L_0x04da:
            java.util.List<T> r1 = r0.movingAwayToEndBound
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0540
            java.util.List<T> r1 = r0.movingAwayToEndBound
            int r2 = r1.size()
            r4 = 1
            if (r2 <= r4) goto L_0x04f7
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2 r2 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2
            r2.<init>(r9)
            java.util.Comparator r2 = (java.util.Comparator) r2
            kotlin.collections.CollectionsKt.sortWith(r1, r2)
        L_0x04f7:
            java.util.List<T> r1 = r0.movingAwayToEndBound
            int r2 = r1.size()
            r3 = 0
        L_0x04fe:
            if (r3 >= r2) goto L_0x0540
            java.lang.Object r4 = r1.get(r3)
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r4 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) r4
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<T>$ItemInfo> r5 = r0.keyToItemInfoMap
            java.lang.Object r9 = r4.getKey()
            java.lang.Object r5 = r5.get(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo r5 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo) r5
            int r9 = r0.updateAndReturnOffsetFor(r6, r4)
            if (r49 == 0) goto L_0x0526
            java.lang.Object r10 = kotlin.collections.CollectionsKt.last(r8)
            androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem r10 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) r10
            int r10 = r0.getMainAxisOffset(r10)
            goto L_0x052f
        L_0x0526:
            int r10 = r5.getLayoutMaxOffset()
            int r12 = r4.getMainAxisSizeWithSpacings()
            int r10 = r10 - r12
        L_0x052f:
            int r10 = r10 + r9
            int r5 = r5.getCrossAxisOffset()
            r4.position(r10, r5, r7, r11)
            r5 = 1
            if (r14 == 0) goto L_0x053d
            r0.startPlacementAnimationsIfNeeded(r4, r5)
        L_0x053d:
            int r3 = r3 + 1
            goto L_0x04fe
        L_0x0540:
            java.util.List<T> r1 = r0.movingAwayToStartBound
            kotlin.collections.CollectionsKt.reverse(r1)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            java.util.Collection r1 = (java.util.Collection) r1
            r5 = 0
            r8.addAll(r5, r1)
            java.util.List<T> r1 = r0.movingAwayToEndBound
            java.util.Collection r1 = (java.util.Collection) r1
            r8.addAll(r1)
            java.util.List<T> r1 = r0.movingInFromStartBound
            r1.clear()
            java.util.List<T> r1 = r0.movingInFromEndBound
            r1.clear()
            java.util.List<T> r1 = r0.movingAwayToStartBound
            r1.clear()
            java.util.List<T> r1 = r0.movingAwayToEndBound
            r1.clear()
            androidx.collection.MutableScatterSet<java.lang.Object> r1 = r0.movingAwayKeys
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider, boolean, boolean, int, boolean, int, int, kotlinx.coroutines.CoroutineScope, androidx.compose.ui.graphics.GraphicsContext):void");
    }

    private final void removeInfoForKey(Object obj) {
        LazyLayoutItemAnimation[] animations;
        ItemInfo remove = this.keyToItemInfoMap.remove(obj);
        if (remove != null && (animations = remove.getAnimations()) != null) {
            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : animations) {
                if (lazyLayoutItemAnimation != null) {
                    lazyLayoutItemAnimation.release();
                }
            }
        }
    }

    public final void reset() {
        if (this.keyToItemInfoMap.isNotEmpty()) {
            ScatterMap scatterMap = this.keyToItemInfoMap;
            Object[] objArr = scatterMap.values;
            long[] jArr = scatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                for (LazyLayoutItemAnimation lazyLayoutItemAnimation : ((ItemInfo) objArr[(i << 3) + i3]).getAnimations()) {
                                    if (lazyLayoutItemAnimation != null) {
                                        lazyLayoutItemAnimation.release();
                                    }
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            this.keyToItemInfoMap.clear();
        }
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            LazyLayoutItemAnimator<T>.ItemInfo itemInfo2 = lazyLayoutItemAnimator.keyToItemInfoMap.get(lazyLayoutMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyLayoutItemAnimator.initializeAnimation(lazyLayoutMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(T t, int i, LazyLayoutItemAnimator<T>.ItemInfo itemInfo) {
        long j;
        int i2 = 0;
        long r1 = t.m1013getOffsetBjo55l4(0);
        if (t.isVertical()) {
            j = IntOffset.m7237copyiSbpLlY$default(r1, 0, i, 1, (Object) null);
        } else {
            j = IntOffset.m7237copyiSbpLlY$default(r1, i, 0, 2, (Object) null);
        }
        LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i3 = 0;
        while (i2 < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = animations[i2];
            int i4 = i3 + 1;
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.m982setRawOffsetgyyYBs(IntOffset.m7245plusqkQi6aY(j, IntOffset.m7244minusqkQi6aY(t.m1013getOffsetBjo55l4(i3), r1)));
            }
            i2++;
            i3 = i4;
        }
    }

    static /* synthetic */ void startPlacementAnimationsIfNeeded$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        lazyLayoutItemAnimator.startPlacementAnimationsIfNeeded(lazyLayoutMeasuredItem, z);
    }

    private final void startPlacementAnimationsIfNeeded(T t, boolean z) {
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(t.getKey());
        Intrinsics.checkNotNull(itemInfo);
        LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = animations[i];
            int i3 = i2 + 1;
            if (lazyLayoutItemAnimation != null) {
                long r6 = t.m1013getOffsetBjo55l4(i2);
                long r8 = lazyLayoutItemAnimation.m979getRawOffsetnOccac();
                if (!IntOffset.m7240equalsimpl0(r8, LazyLayoutItemAnimation.Companion.m983getNotInitializednOccac()) && !IntOffset.m7240equalsimpl0(r8, r6)) {
                    lazyLayoutItemAnimation.m975animatePlacementDeltaar5cAso(IntOffset.m7244minusqkQi6aY(r6, r8), z);
                }
                lazyLayoutItemAnimation.m982setRawOffsetgyyYBs(r6);
            }
            i++;
            i2 = i3;
        }
    }

    public final LazyLayoutItemAnimation getAnimation(Object obj, int i) {
        LazyLayoutItemAnimation[] animations;
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[i];
    }

    private final int updateAndReturnOffsetFor(int[] iArr, T t) {
        int lane = t.getLane();
        int span = t.getSpan() + lane;
        int i = 0;
        while (lane < span) {
            int mainAxisSizeWithSpacings = iArr[lane] + t.getMainAxisSizeWithSpacings();
            iArr[lane] = mainAxisSizeWithSpacings;
            i = Math.max(i, mainAxisSizeWithSpacings);
            lane++;
        }
        return i;
    }

    /* renamed from: getMinSizeToFitDisappearingItems-YbymL2g  reason: not valid java name */
    public final long m984getMinSizeToFitDisappearingItemsYbymL2g() {
        long r0 = IntSize.Companion.m7288getZeroYbymL2g();
        List<LazyLayoutItemAnimation> list = this.disappearingItems;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = list.get(i);
            GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
            if (layer != null) {
                r0 = IntSizeKt.IntSize(Math.max(IntSize.m7283getWidthimpl(r0), IntOffset.m7241getXimpl(lazyLayoutItemAnimation.m979getRawOffsetnOccac()) + IntSize.m7283getWidthimpl(layer.m4973getSizeYbymL2g())), Math.max(IntSize.m7282getHeightimpl(r0), IntOffset.m7242getYimpl(lazyLayoutItemAnimation.m979getRawOffsetnOccac()) + IntSize.m7282getHeightimpl(layer.m4973getSizeYbymL2g())));
            }
        }
        return r0;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    private final boolean getHasAnimations(T t) {
        int placeablesCount = t.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (LazyLayoutItemAnimatorKt.getSpecs(t.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    private final int getMainAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long r0 = lazyLayoutMeasuredItem.m1013getOffsetBjo55l4(0);
        return lazyLayoutMeasuredItem.isVertical() ? IntOffset.m7242getYimpl(r0) : IntOffset.m7241getXimpl(r0);
    }

    /* access modifiers changed from: private */
    public final int getCrossAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long r0 = lazyLayoutMeasuredItem.m1013getOffsetBjo55l4(0);
        return !lazyLayoutMeasuredItem.isVertical() ? IntOffset.m7242getYimpl(r0) : IntOffset.m7241getXimpl(r0);
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J=\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010*R0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004@BX\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "crossAxisOffset", "", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "isRunningPlacement", "", "()Z", "lane", "getLane", "setLane", "layoutMaxOffset", "getLayoutMaxOffset", "layoutMinOffset", "getLayoutMinOffset", "span", "getSpan", "setSpan", "updateAnimation", "", "positionedItem", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;III)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutItemAnimator.kt */
    private final class ItemInfo {
        private LazyLayoutItemAnimation[] animations = LazyLayoutItemAnimatorKt.EmptyArray;
        private Constraints constraints;
        private int crossAxisOffset;
        private int lane;
        private int layoutMaxOffset;
        private int layoutMinOffset;
        private int span = 1;

        public ItemInfo() {
        }

        public final LazyLayoutItemAnimation[] getAnimations() {
            return this.animations;
        }

        /* renamed from: getConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m985getConstraintsDWUhwKw() {
            return this.constraints;
        }

        /* renamed from: setConstraints-_Sx5XlM  reason: not valid java name */
        public final void m986setConstraints_Sx5XlM(Constraints constraints2) {
            this.constraints = constraints2;
        }

        public final int getCrossAxisOffset() {
            return this.crossAxisOffset;
        }

        public final void setCrossAxisOffset(int i) {
            this.crossAxisOffset = i;
        }

        public final int getLane() {
            return this.lane;
        }

        public final void setLane(int i) {
            this.lane = i;
        }

        public final int getSpan() {
            return this.span;
        }

        public final void setSpan(int i) {
            this.span = i;
        }

        private final boolean isRunningPlacement() {
            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : this.animations) {
                if (lazyLayoutItemAnimation != null && lazyLayoutItemAnimation.isRunningMovingAwayAnimation()) {
                    return true;
                }
            }
            return false;
        }

        public final int getLayoutMinOffset() {
            return this.layoutMinOffset;
        }

        public final int getLayoutMaxOffset() {
            return this.layoutMaxOffset;
        }

        public static /* synthetic */ void updateAnimation$default(ItemInfo itemInfo, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 32) != 0) {
                i3 = LazyLayoutItemAnimator.this.getCrossAxisOffset(lazyLayoutMeasuredItem);
            }
            itemInfo.updateAnimation(lazyLayoutMeasuredItem, coroutineScope, graphicsContext, i, i2, i3);
        }

        public final void updateAnimation(T t, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i, int i2, int i3) {
            if (!isRunningPlacement()) {
                this.layoutMinOffset = i;
                this.layoutMaxOffset = i2;
            }
            int length = this.animations.length;
            for (int placeablesCount = t.getPlaceablesCount(); placeablesCount < length; placeablesCount++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = this.animations[placeablesCount];
                if (lazyLayoutItemAnimation != null) {
                    lazyLayoutItemAnimation.release();
                }
            }
            if (this.animations.length != t.getPlaceablesCount()) {
                Object[] copyOf = Arrays.copyOf(this.animations, t.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.animations = (LazyLayoutItemAnimation[]) copyOf;
            }
            this.constraints = Constraints.m7040boximpl(t.m1012getConstraintsmsEJaDk());
            this.crossAxisOffset = i3;
            this.lane = t.getLane();
            this.span = t.getSpan();
            int placeablesCount2 = t.getPlaceablesCount();
            LazyLayoutItemAnimator<T> lazyLayoutItemAnimator = LazyLayoutItemAnimator.this;
            for (int i4 = 0; i4 < placeablesCount2; i4++) {
                LazyLayoutAnimationSpecsNode access$getSpecs = LazyLayoutItemAnimatorKt.getSpecs(t.getParentData(i4));
                if (access$getSpecs == null) {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.animations[i4];
                    if (lazyLayoutItemAnimation2 != null) {
                        lazyLayoutItemAnimation2.release();
                    }
                    this.animations[i4] = null;
                } else {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation3 = this.animations[i4];
                    if (lazyLayoutItemAnimation3 == null) {
                        lazyLayoutItemAnimation3 = new LazyLayoutItemAnimation(coroutineScope, graphicsContext, new LazyLayoutItemAnimator$ItemInfo$updateAnimation$1$animation$1(lazyLayoutItemAnimator));
                        this.animations[i4] = lazyLayoutItemAnimation3;
                    }
                    lazyLayoutItemAnimation3.setFadeInSpec(access$getSpecs.getFadeInSpec());
                    lazyLayoutItemAnimation3.setPlacementSpec(access$getSpecs.getPlacementSpec());
                    lazyLayoutItemAnimation3.setFadeOutSpec(access$getSpecs.getFadeOutSpec());
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutItemAnimator.kt */
    private static final class DisplayingDisappearingItemsElement extends ModifierNodeElement<DisplayingDisappearingItemsNode> {
        private final LazyLayoutItemAnimator<?> animator;

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        public static /* synthetic */ DisplayingDisappearingItemsElement copy$default(DisplayingDisappearingItemsElement displayingDisappearingItemsElement, LazyLayoutItemAnimator<?> lazyLayoutItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyLayoutItemAnimator = displayingDisappearingItemsElement.animator;
            }
            return displayingDisappearingItemsElement.copy(lazyLayoutItemAnimator);
        }

        public final DisplayingDisappearingItemsElement copy(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            return new DisplayingDisappearingItemsElement(lazyLayoutItemAnimator);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayingDisappearingItemsElement) && Intrinsics.areEqual((Object) this.animator, (Object) ((DisplayingDisappearingItemsElement) obj).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        public DisplayingDisappearingItemsNode create() {
            return new DisplayingDisappearingItemsNode(this.animator);
        }

        public void update(DisplayingDisappearingItemsNode displayingDisappearingItemsNode) {
            displayingDisappearingItemsNode.setAnimator(this.animator);
        }

        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("DisplayingDisappearingItemsElement");
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\f\u0010\u0014\u001a\u00020\u000f*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "onAttach", "", "onDetach", "setAnimator", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutItemAnimator.kt */
    private static final class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {
        private LazyLayoutItemAnimator<?> animator;

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        public static /* synthetic */ DisplayingDisappearingItemsNode copy$default(DisplayingDisappearingItemsNode displayingDisappearingItemsNode, LazyLayoutItemAnimator<?> lazyLayoutItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyLayoutItemAnimator = displayingDisappearingItemsNode.animator;
            }
            return displayingDisappearingItemsNode.copy(lazyLayoutItemAnimator);
        }

        public final DisplayingDisappearingItemsNode copy(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            return new DisplayingDisappearingItemsNode(lazyLayoutItemAnimator);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayingDisappearingItemsNode) && Intrinsics.areEqual((Object) this.animator, (Object) ((DisplayingDisappearingItemsNode) obj).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.animator + ')';
        }

        public DisplayingDisappearingItemsNode(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        public void draw(ContentDrawScope contentDrawScope) {
            List access$getDisappearingItems$p = this.animator.disappearingItems;
            int size = access$getDisappearingItems$p.size();
            for (int i = 0; i < size; i++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) access$getDisappearingItems$p.get(i);
                GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
                if (layer != null) {
                    DrawScope drawScope = contentDrawScope;
                    float r5 = ((float) IntOffset.m7241getXimpl(lazyLayoutItemAnimation.m976getFinalOffsetnOccac())) - ((float) IntOffset.m7241getXimpl(layer.m4975getTopLeftnOccac()));
                    float r3 = ((float) IntOffset.m7242getYimpl(lazyLayoutItemAnimation.m976getFinalOffsetnOccac())) - ((float) IntOffset.m7242getYimpl(layer.m4975getTopLeftnOccac()));
                    drawScope.getDrawContext().getTransform().translate(r5, r3);
                    try {
                        GraphicsLayerKt.drawLayer(drawScope, layer);
                    } finally {
                        drawScope.getDrawContext().getTransform().translate(-r5, -r3);
                    }
                }
            }
            contentDrawScope.drawContent();
        }

        public void onAttach() {
            this.animator.displayingNode = this;
        }

        public void onDetach() {
            this.animator.reset();
        }

        public final void setAnimator(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            if (!Intrinsics.areEqual((Object) this.animator, (Object) lazyLayoutItemAnimator) && getNode().isAttached()) {
                this.animator.reset();
                lazyLayoutItemAnimator.displayingNode = this;
                this.animator = lazyLayoutItemAnimator;
            }
        }
    }
}
