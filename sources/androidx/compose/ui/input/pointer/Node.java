package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0017\u0010!\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0#H\bJ.\u0010$\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u001a\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020\rH\u0002J\u0006\u0010(\u001a\u00020\u001dJ\u001e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000-H\u0016J\b\u0010.\u001a\u00020/H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "removeInvalidPointerIdsAndChanges", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HitPathTracker.kt */
public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private boolean hasExited = true;
    private boolean isIn = true;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean wasIn;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    public void removeInvalidPointerIdsAndChanges(long j, MutableObjectList<Node> mutableObjectList) {
        if (this.pointerIds.contains(j) && !mutableObjectList.contains(this)) {
            this.pointerIds.remove(j);
            this.relevantChanges.remove(j);
        }
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Object[] content = children.getContent();
            int i = 0;
            do {
                ((Node) content[i]).removeInvalidPointerIdsAndChanges(j, mutableObjectList);
                i++;
            } while (i < size);
        }
    }

    public boolean buildCache(LongSparseArray<PointerInputChange> longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        PointerInputChange pointerInputChange;
        boolean z2;
        int i;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        int i4;
        LongSparseArray<PointerInputChange> longSparseArray2 = longSparseArray;
        LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
        InternalPointerEvent internalPointerEvent2 = internalPointerEvent;
        boolean buildCache = super.buildCache(longSparseArray, layoutCoordinates, internalPointerEvent, z);
        boolean z5 = true;
        if (!this.modifierNode.isAttached()) {
            return true;
        }
        Modifier.Node node = this.modifierNode;
        int r8 = NodeKind.m6139constructorimpl(16);
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) node);
            } else if ((node.getKindSet$ui_release() & r8) != 0 && (node instanceof DelegatingNode)) {
                int i5 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                    if ((delegate$ui_release.getKindSet$ui_release() & r8) != 0) {
                        i5++;
                        if (i5 == 1) {
                            node = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i5 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
        int size = longSparseArray2.size();
        int i6 = 0;
        while (i6 < size) {
            long keyAt = longSparseArray2.keyAt(i6);
            PointerInputChange valueAt = longSparseArray2.valueAt(i6);
            if (this.pointerIds.contains(keyAt)) {
                boolean z6 = z5;
                int i7 = i6;
                long r6 = valueAt.m5588getPreviousPositionF1C5BW0();
                z4 = z6;
                long r82 = valueAt.m5587getPositionF1C5BW0();
                if (!Offset.m3990isValidimpl(r6) || !Offset.m3990isValidimpl(r82)) {
                    z3 = buildCache;
                    i3 = size;
                    i2 = i7;
                } else {
                    ArrayList arrayList = new ArrayList(valueAt.getHistorical().size());
                    List<HistoricalChange> historical = valueAt.getHistorical();
                    z3 = buildCache;
                    int size2 = historical.size();
                    i3 = size;
                    int i8 = 0;
                    while (i8 < size2) {
                        HistoricalChange historicalChange = historical.get(i8);
                        int i9 = size2;
                        int i10 = i8;
                        long r4 = historicalChange.m5512getPositionF1C5BW0();
                        if (Offset.m3990isValidimpl(r4)) {
                            long uptimeMillis = historicalChange.getUptimeMillis();
                            i4 = i7;
                            LayoutCoordinates layoutCoordinates3 = this.coordinates;
                            Intrinsics.checkNotNull(layoutCoordinates3);
                            arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates3.m5801localPositionOfR5De75A(layoutCoordinates2, r4), historicalChange.m5511getOriginalEventPositionF1C5BW0$ui_release(), (DefaultConstructorMarker) null));
                        } else {
                            i4 = i7;
                        }
                        i8 = i10 + 1;
                        size2 = i9;
                        i7 = i4;
                    }
                    i2 = i7;
                    LongSparseArray<PointerInputChange> longSparseArray3 = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates4 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates4);
                    long r24 = layoutCoordinates4.m5801localPositionOfR5De75A(layoutCoordinates2, r6);
                    LayoutCoordinates layoutCoordinates5 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates5);
                    longSparseArray3.put(keyAt, PointerInputChange.m5576copyOHpmEuE$default(valueAt, 0, 0, layoutCoordinates5.m5801localPositionOfR5De75A(layoutCoordinates2, r82), false, 0, r24, false, 0, arrayList, 0, 731, (Object) null));
                }
            } else {
                z3 = buildCache;
                i3 = size;
                z4 = z5;
                i2 = i6;
            }
            i6 = i2 + 1;
            z5 = z4;
            buildCache = z3;
            size = i3;
        }
        boolean z7 = buildCache;
        boolean z8 = z5;
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return z8;
        }
        int size3 = this.pointerIds.getSize();
        while (true) {
            size3--;
            if (-1 >= size3) {
                break;
            } else if (!longSparseArray2.containsKey(this.pointerIds.m5702get_I2yYro(size3))) {
                this.pointerIds.removeAt(size3);
            }
        }
        ArrayList arrayList2 = new ArrayList(this.relevantChanges.size());
        int size4 = this.relevantChanges.size();
        for (int i11 = 0; i11 < size4; i11++) {
            arrayList2.add(this.relevantChanges.valueAt(i11));
        }
        PointerEvent pointerEvent2 = new PointerEvent(arrayList2, internalPointerEvent2);
        List<PointerInputChange> changes = pointerEvent2.getChanges();
        int size5 = changes.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size5) {
                pointerInputChange = null;
                break;
            }
            PointerInputChange pointerInputChange2 = changes.get(i12);
            if (internalPointerEvent2.m5515activeHoverEvent0FcD4WY(pointerInputChange2.m5585getIdJ3iCeTQ())) {
                pointerInputChange = pointerInputChange2;
                break;
            }
            i12++;
        }
        PointerInputChange pointerInputChange3 = pointerInputChange;
        if (pointerInputChange3 != null) {
            if (!z) {
                z2 = false;
                this.isIn = false;
            } else {
                z2 = false;
                if (!this.isIn && (pointerInputChange3.getPressed() || pointerInputChange3.getPreviousPressed())) {
                    LayoutCoordinates layoutCoordinates6 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates6);
                    this.isIn = !PointerEventKt.m5530isOutOfBoundsO0kMr_c(pointerInputChange3, layoutCoordinates6.m5800getSizeYbymL2g());
                }
            }
            if (this.isIn != this.wasIn && (PointerEventType.m5535equalsimpl0(pointerEvent2.m5528getType7fucELk(), PointerEventType.Companion.m5541getMove7fucELk()) || PointerEventType.m5535equalsimpl0(pointerEvent2.m5528getType7fucELk(), PointerEventType.Companion.m5539getEnter7fucELk()) || PointerEventType.m5535equalsimpl0(pointerEvent2.m5528getType7fucELk(), PointerEventType.Companion.m5540getExit7fucELk()))) {
                if (this.isIn) {
                    i = PointerEventType.Companion.m5539getEnter7fucELk();
                } else {
                    i = PointerEventType.Companion.m5540getExit7fucELk();
                }
                pointerEvent2.m5529setTypeEhbLWgg$ui_release(i);
            } else if (PointerEventType.m5535equalsimpl0(pointerEvent2.m5528getType7fucELk(), PointerEventType.Companion.m5539getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                pointerEvent2.m5529setTypeEhbLWgg$ui_release(PointerEventType.Companion.m5541getMove7fucELk());
            } else if (PointerEventType.m5535equalsimpl0(pointerEvent2.m5528getType7fucELk(), PointerEventType.Companion.m5540getExit7fucELk()) && this.isIn && pointerInputChange3.getPressed()) {
                pointerEvent2.m5529setTypeEhbLWgg$ui_release(PointerEventType.Companion.m5541getMove7fucELk());
            }
        } else {
            z2 = false;
        }
        boolean z9 = (z7 || !PointerEventType.m5535equalsimpl0(pointerEvent2.m5528getType7fucELk(), PointerEventType.Companion.m5541getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent2)) ? z8 : z2;
        this.pointerEvent = pointerEvent2;
        return z9;
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent2, PointerEvent pointerEvent3) {
        if (pointerEvent2 == null || pointerEvent2.getChanges().size() != pointerEvent3.getChanges().size()) {
            return true;
        }
        int size = pointerEvent3.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m3984equalsimpl0(pointerEvent2.getChanges().get(i).m5587getPositionF1C5BW0(), pointerEvent3.getChanges().get(i).m5587getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> function0) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.isAttached()) {
            return false;
        }
        function0.invoke();
        return true;
    }

    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Object[] content = children.getContent();
            int i = 0;
            do {
                ((Node) content[i]).dispatchCancel();
                i++;
            } while (i < size);
        }
        Modifier.Node node = this.modifierNode;
        int r4 = NodeKind.m6139constructorimpl(16);
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) node).onCancelPointerInput();
            } else if ((node.getKindSet$ui_release() & r4) != 0 && (node instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                    if ((delegate$ui_release.getKindSet$ui_release() & r4) != 0) {
                        i2++;
                        if (i2 == 1) {
                            node = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent2 = this.pointerEvent;
        if (pointerEvent2 != null) {
            this.wasIn = this.isIn;
            List<PointerInputChange> changes = pointerEvent2.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChange = changes.get(i);
                boolean pressed = pointerInputChange.getPressed();
                boolean r7 = internalPointerEvent.m5515activeHoverEvent0FcD4WY(pointerInputChange.m5585getIdJ3iCeTQ());
                boolean z = this.isIn;
                if ((!pressed && !r7) || (!pressed && !z)) {
                    this.pointerIds.m5703remove0FcD4WY(pointerInputChange.m5585getIdJ3iCeTQ());
                }
            }
            this.isIn = false;
            this.hasExited = PointerEventType.m5535equalsimpl0(pointerEvent2.m5528getType7fucELk(), PointerEventType.Companion.m5540getExit7fucELk());
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchMainEventPass(androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r12, androidx.compose.ui.layout.LayoutCoordinates r13, androidx.compose.ui.input.pointer.InternalPointerEvent r14, boolean r15) {
        /*
            r11 = this;
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r12 = r11.relevantChanges
            boolean r12 = r12.isEmpty()
            r13 = 0
            if (r12 == 0) goto L_0x000a
            return r13
        L_0x000a:
            androidx.compose.ui.Modifier$Node r12 = r11.modifierNode
            boolean r12 = r12.isAttached()
            if (r12 != 0) goto L_0x0013
            return r13
        L_0x0013:
            androidx.compose.ui.input.pointer.PointerEvent r12 = r11.pointerEvent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            androidx.compose.ui.layout.LayoutCoordinates r0 = r11.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            long r0 = r0.m5800getSizeYbymL2g()
            androidx.compose.ui.Modifier$Node r2 = r11.modifierNode
            r3 = 16
            int r4 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r3)
            r5 = 0
            r6 = r5
        L_0x002b:
            r7 = 1
            if (r2 == 0) goto L_0x007f
            boolean r8 = r2 instanceof androidx.compose.ui.node.PointerInputModifierNode
            if (r8 == 0) goto L_0x003a
            androidx.compose.ui.node.PointerInputModifierNode r2 = (androidx.compose.ui.node.PointerInputModifierNode) r2
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r2.m6200onPointerEventH0pRuoY(r12, r7, r0)
            goto L_0x007a
        L_0x003a:
            int r8 = r2.getKindSet$ui_release()
            r8 = r8 & r4
            if (r8 == 0) goto L_0x007a
            boolean r8 = r2 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x007a
            r8 = r2
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = r13
        L_0x004d:
            if (r8 == 0) goto L_0x0077
            int r10 = r8.getKindSet$ui_release()
            r10 = r10 & r4
            if (r10 == 0) goto L_0x0072
            int r9 = r9 + 1
            if (r9 != r7) goto L_0x005c
            r2 = r8
            goto L_0x0072
        L_0x005c:
            if (r6 != 0) goto L_0x0065
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r3]
            r6.<init>(r10, r13)
        L_0x0065:
            if (r2 == 0) goto L_0x006d
            if (r6 == 0) goto L_0x006c
            r6.add(r2)
        L_0x006c:
            r2 = r5
        L_0x006d:
            if (r6 == 0) goto L_0x0072
            r6.add(r8)
        L_0x0072:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x004d
        L_0x0077:
            if (r9 != r7) goto L_0x007a
            goto L_0x002b
        L_0x007a:
            androidx.compose.ui.Modifier$Node r2 = androidx.compose.ui.node.DelegatableNodeKt.pop(r6)
            goto L_0x002b
        L_0x007f:
            androidx.compose.ui.Modifier$Node r2 = r11.modifierNode
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x00a7
            androidx.compose.runtime.collection.MutableVector r2 = r11.getChildren()
            int r4 = r2.getSize()
            if (r4 <= 0) goto L_0x00a7
            java.lang.Object[] r2 = r2.getContent()
            r6 = r13
        L_0x0096:
            r8 = r2[r6]
            androidx.compose.ui.input.pointer.Node r8 = (androidx.compose.ui.input.pointer.Node) r8
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r9 = r11.relevantChanges
            androidx.compose.ui.layout.LayoutCoordinates r10 = r11.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r8.dispatchMainEventPass(r9, r10, r14, r15)
            int r6 = r6 + r7
            if (r6 < r4) goto L_0x0096
        L_0x00a7:
            androidx.compose.ui.Modifier$Node r14 = r11.modifierNode
            boolean r14 = r14.isAttached()
            if (r14 == 0) goto L_0x0109
            androidx.compose.ui.Modifier$Node r14 = r11.modifierNode
            int r15 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r3)
            r2 = r5
        L_0x00b6:
            if (r14 == 0) goto L_0x0109
            boolean r4 = r14 instanceof androidx.compose.ui.node.PointerInputModifierNode
            if (r4 == 0) goto L_0x00c4
            androidx.compose.ui.node.PointerInputModifierNode r14 = (androidx.compose.ui.node.PointerInputModifierNode) r14
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r14.m6200onPointerEventH0pRuoY(r12, r4, r0)
            goto L_0x0104
        L_0x00c4:
            int r4 = r14.getKindSet$ui_release()
            r4 = r4 & r15
            if (r4 == 0) goto L_0x0104
            boolean r4 = r14 instanceof androidx.compose.ui.node.DelegatingNode
            if (r4 == 0) goto L_0x0104
            r4 = r14
            androidx.compose.ui.node.DelegatingNode r4 = (androidx.compose.ui.node.DelegatingNode) r4
            androidx.compose.ui.Modifier$Node r4 = r4.getDelegate$ui_release()
            r6 = r13
        L_0x00d7:
            if (r4 == 0) goto L_0x0101
            int r8 = r4.getKindSet$ui_release()
            r8 = r8 & r15
            if (r8 == 0) goto L_0x00fc
            int r6 = r6 + 1
            if (r6 != r7) goto L_0x00e6
            r14 = r4
            goto L_0x00fc
        L_0x00e6:
            if (r2 != 0) goto L_0x00ef
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r8, r13)
        L_0x00ef:
            if (r14 == 0) goto L_0x00f7
            if (r2 == 0) goto L_0x00f6
            r2.add(r14)
        L_0x00f6:
            r14 = r5
        L_0x00f7:
            if (r2 == 0) goto L_0x00fc
            r2.add(r4)
        L_0x00fc:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()
            goto L_0x00d7
        L_0x0101:
            if (r6 != r7) goto L_0x0104
            goto L_0x00b6
        L_0x0104:
            androidx.compose.ui.Modifier$Node r14 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x00b6
        L_0x0109:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(androidx.collection.LongSparseArray, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent r14) {
        /*
            r13 = this;
            androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r0 = r13.relevantChanges
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x000b
            goto L_0x00a2
        L_0x000b:
            androidx.compose.ui.Modifier$Node r0 = r13.modifierNode
            boolean r0 = r0.isAttached()
            if (r0 != 0) goto L_0x0015
            goto L_0x00a2
        L_0x0015:
            androidx.compose.ui.input.pointer.PointerEvent r0 = r13.pointerEvent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.layout.LayoutCoordinates r2 = r13.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r2 = r2.m5800getSizeYbymL2g()
            androidx.compose.ui.Modifier$Node r4 = r13.modifierNode
            r5 = 16
            int r6 = androidx.compose.ui.node.NodeKind.m6139constructorimpl(r5)
            r7 = 0
            r8 = r7
        L_0x002d:
            r9 = 1
            if (r4 == 0) goto L_0x0081
            boolean r10 = r4 instanceof androidx.compose.ui.node.PointerInputModifierNode
            if (r10 == 0) goto L_0x003c
            androidx.compose.ui.node.PointerInputModifierNode r4 = (androidx.compose.ui.node.PointerInputModifierNode) r4
            androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r4.m6200onPointerEventH0pRuoY(r0, r9, r2)
            goto L_0x007c
        L_0x003c:
            int r10 = r4.getKindSet$ui_release()
            r10 = r10 & r6
            if (r10 == 0) goto L_0x007c
            boolean r10 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r10 == 0) goto L_0x007c
            r10 = r4
            androidx.compose.ui.node.DelegatingNode r10 = (androidx.compose.ui.node.DelegatingNode) r10
            androidx.compose.ui.Modifier$Node r10 = r10.getDelegate$ui_release()
            r11 = r1
        L_0x004f:
            if (r10 == 0) goto L_0x0079
            int r12 = r10.getKindSet$ui_release()
            r12 = r12 & r6
            if (r12 == 0) goto L_0x0074
            int r11 = r11 + 1
            if (r11 != r9) goto L_0x005e
            r4 = r10
            goto L_0x0074
        L_0x005e:
            if (r8 != 0) goto L_0x0067
            androidx.compose.runtime.collection.MutableVector r8 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r12 = new androidx.compose.ui.Modifier.Node[r5]
            r8.<init>(r12, r1)
        L_0x0067:
            if (r4 == 0) goto L_0x006f
            if (r8 == 0) goto L_0x006e
            r8.add(r4)
        L_0x006e:
            r4 = r7
        L_0x006f:
            if (r8 == 0) goto L_0x0074
            r8.add(r10)
        L_0x0074:
            androidx.compose.ui.Modifier$Node r10 = r10.getChild$ui_release()
            goto L_0x004f
        L_0x0079:
            if (r11 != r9) goto L_0x007c
            goto L_0x002d
        L_0x007c:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.pop(r8)
            goto L_0x002d
        L_0x0081:
            androidx.compose.ui.Modifier$Node r0 = r13.modifierNode
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L_0x00a1
            androidx.compose.runtime.collection.MutableVector r0 = r13.getChildren()
            int r2 = r0.getSize()
            if (r2 <= 0) goto L_0x00a1
            java.lang.Object[] r0 = r0.getContent()
        L_0x0097:
            r3 = r0[r1]
            androidx.compose.ui.input.pointer.Node r3 = (androidx.compose.ui.input.pointer.Node) r3
            r3.dispatchFinalEventPass(r14)
            int r1 = r1 + r9
            if (r1 < r2) goto L_0x0097
        L_0x00a1:
            r1 = r9
        L_0x00a2:
            r13.cleanUpHits(r14)
            r13.clearCache()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent):boolean");
    }
}
