package androidx.compose.ui.input.pointer;

import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u001e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "hitPointerIdsAndNodes", "Landroidx/collection/MutableLongObjectMap;", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/input/pointer/Node;", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputNodes", "", "Landroidx/compose/ui/Modifier$Node;", "prunePointerIdsAndChangesNotInNodesList", "", "addHitPath-QJqDSyo", "(JLjava/util/List;Z)V", "clearPreviouslyHitModifierNodeCache", "dispatchChanges", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "processCancel", "removeDetachedPointerInputNodes", "removeInvalidPointerIdsAndChanges", "", "hitNodes", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HitPathTracker.kt */
public final class HitPathTracker {
    public static final int $stable = 8;
    private final MutableLongObjectMap<MutableObjectList<Node>> hitPointerIdsAndNodes = new MutableLongObjectMap<>(10);
    private final NodeParent root = new NodeParent();
    private final LayoutCoordinates rootCoordinates;

    public HitPathTracker(LayoutCoordinates layoutCoordinates) {
        this.rootCoordinates = layoutCoordinates;
    }

    public final NodeParent getRoot$ui_release() {
        return this.root;
    }

    /* renamed from: addHitPath-QJqDSyo$default  reason: not valid java name */
    public static /* synthetic */ void m5513addHitPathQJqDSyo$default(HitPathTracker hitPathTracker, long j, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        hitPathTracker.m5514addHitPathQJqDSyo(j, list, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r15v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: addHitPath-QJqDSyo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m5514addHitPathQJqDSyo(long r18, java.util.List<? extends androidx.compose.ui.Modifier.Node> r20, boolean r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            androidx.compose.ui.input.pointer.NodeParent r3 = r0.root
            androidx.collection.MutableLongObjectMap<androidx.collection.MutableObjectList<androidx.compose.ui.input.pointer.Node>> r4 = r0.hitPointerIdsAndNodes
            r4.clear()
            int r4 = r20.size()
            r6 = 0
            r7 = r6
            r8 = 1
        L_0x0012:
            if (r7 >= r4) goto L_0x00a0
            r9 = r20
            java.lang.Object r10 = r9.get(r7)
            androidx.compose.ui.Modifier$Node r10 = (androidx.compose.ui.Modifier.Node) r10
            r11 = 0
            if (r8 == 0) goto L_0x006e
            androidx.compose.runtime.collection.MutableVector r12 = r3.getChildren()
            int r13 = r12.getSize()
            if (r13 <= 0) goto L_0x0043
            java.lang.Object[] r12 = r12.getContent()
            r14 = r6
        L_0x002e:
            r15 = r12[r14]
            r16 = r15
            androidx.compose.ui.input.pointer.Node r16 = (androidx.compose.ui.input.pointer.Node) r16
            androidx.compose.ui.Modifier$Node r5 = r16.getModifierNode()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r10)
            if (r5 == 0) goto L_0x003f
            goto L_0x0044
        L_0x003f:
            int r14 = r14 + 1
            if (r14 < r13) goto L_0x002e
        L_0x0043:
            r15 = r11
        L_0x0044:
            androidx.compose.ui.input.pointer.Node r15 = (androidx.compose.ui.input.pointer.Node) r15
            if (r15 == 0) goto L_0x006d
            r15.markIsIn()
            androidx.compose.ui.input.pointer.util.PointerIdArray r3 = r15.getPointerIds()
            r3.m5700add0FcD4WY(r1)
            androidx.collection.MutableLongObjectMap<androidx.collection.MutableObjectList<androidx.compose.ui.input.pointer.Node>> r3 = r0.hitPointerIdsAndNodes
            java.lang.Object r5 = r3.get(r1)
            if (r5 != 0) goto L_0x0063
            androidx.collection.MutableObjectList r5 = new androidx.collection.MutableObjectList
            r10 = 1
            r5.<init>(r6, r10, r11)
            r3.set(r1, r5)
        L_0x0063:
            androidx.collection.MutableObjectList r5 = (androidx.collection.MutableObjectList) r5
            r5.add(r15)
            androidx.compose.ui.input.pointer.NodeParent r15 = (androidx.compose.ui.input.pointer.NodeParent) r15
            r3 = r15
            r13 = 1
            goto L_0x009c
        L_0x006d:
            r8 = r6
        L_0x006e:
            androidx.compose.ui.input.pointer.Node r5 = new androidx.compose.ui.input.pointer.Node
            r5.<init>(r10)
            androidx.compose.ui.input.pointer.util.PointerIdArray r10 = r5.getPointerIds()
            r10.m5700add0FcD4WY(r1)
            androidx.collection.MutableLongObjectMap<androidx.collection.MutableObjectList<androidx.compose.ui.input.pointer.Node>> r10 = r0.hitPointerIdsAndNodes
            java.lang.Object r12 = r10.get(r1)
            if (r12 != 0) goto L_0x008c
            androidx.collection.MutableObjectList r12 = new androidx.collection.MutableObjectList
            r13 = 1
            r12.<init>(r6, r13, r11)
            r10.set(r1, r12)
            goto L_0x008d
        L_0x008c:
            r13 = 1
        L_0x008d:
            androidx.collection.MutableObjectList r12 = (androidx.collection.MutableObjectList) r12
            r12.add(r5)
            androidx.compose.runtime.collection.MutableVector r3 = r3.getChildren()
            r3.add(r5)
            androidx.compose.ui.input.pointer.NodeParent r5 = (androidx.compose.ui.input.pointer.NodeParent) r5
            r3 = r5
        L_0x009c:
            int r7 = r7 + 1
            goto L_0x0012
        L_0x00a0:
            if (r21 == 0) goto L_0x00ee
            androidx.collection.MutableLongObjectMap<androidx.collection.MutableObjectList<androidx.compose.ui.input.pointer.Node>> r1 = r0.hitPointerIdsAndNodes
            androidx.collection.LongObjectMap r1 = (androidx.collection.LongObjectMap) r1
            long[] r2 = r1.keys
            java.lang.Object[] r3 = r1.values
            long[] r1 = r1.metadata
            int r4 = r1.length
            int r4 = r4 + -2
            if (r4 < 0) goto L_0x00ee
            r5 = r6
        L_0x00b2:
            r7 = r1[r5]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x00e9
            int r9 = r5 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = r6
        L_0x00cc:
            if (r11 >= r9) goto L_0x00e7
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.32E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L_0x00e3
            int r12 = r5 << 3
            int r12 = r12 + r11
            r13 = r2[r12]
            r12 = r3[r12]
            androidx.collection.MutableObjectList r12 = (androidx.collection.MutableObjectList) r12
            r0.removeInvalidPointerIdsAndChanges(r13, r12)
        L_0x00e3:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L_0x00cc
        L_0x00e7:
            if (r9 != r10) goto L_0x00ee
        L_0x00e9:
            if (r5 == r4) goto L_0x00ee
            int r5 = r5 + 1
            goto L_0x00b2
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.HitPathTracker.m5514addHitPathQJqDSyo(long, java.util.List, boolean):void");
    }

    private final void removeInvalidPointerIdsAndChanges(long j, MutableObjectList<Node> mutableObjectList) {
        this.root.removeInvalidPointerIdsAndChanges(j, mutableObjectList);
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z);
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean z) {
        if (!this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z)) {
            return false;
        }
        boolean dispatchMainEventPass = this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z);
        if (this.root.dispatchFinalEventPass(internalPointerEvent) || dispatchMainEventPass) {
            return true;
        }
        return false;
    }

    public final void clearPreviouslyHitModifierNodeCache() {
        this.root.clear();
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        clearPreviouslyHitModifierNodeCache();
    }

    public final void removeDetachedPointerInputNodes() {
        this.root.removeDetachedPointerInputModifierNodes();
    }
}
