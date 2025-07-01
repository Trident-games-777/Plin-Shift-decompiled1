package androidx.compose.ui.node;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterSet;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010?\u001a\u00020@2\u0006\u0010!\u001a\u00020\"2\u0006\u0010A\u001a\u000205H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH&J\u0017\u0010F\u001a\u00020@2\b\u0010G\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\bHJ\u0010\u0010F\u001a\u00020@2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00002\u0006\u0010A\u001a\u000205H\u0002J\u0016\u0010L\u001a\u00020M2\u0006\u0010A\u001a\u0002052\u0006\u0010N\u001a\u00020MJ\u0011\u0010O\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010P\u001a\u00020@2\u0006\u0010A\u001a\u000205H\u0002J`\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020C2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020C0U2\u0019\u0010V\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020@\u0018\u00010W¢\u0006\u0002\bX2\u0017\u0010Y\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020@0W¢\u0006\u0002\bXH\u0016J&\u0010Z\u001a\u00020@2\u001c\u0010[\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"07j\b\u0012\u0004\u0012\u00020\"`806H\u0002J\u0016\u0010\\\u001a\u00020@2\u0006\u0010A\u001a\u0002052\u0006\u0010]\u001a\u00020MJ\u0016\u0010^\u001a\u00020@2\u0006\u0010A\u001a\u0002052\u0006\u0010]\u001a\u00020MJ\r\u0010_\u001a\u00020@H ¢\u0006\u0002\b`J\f\u0010a\u001a\u00020@*\u00020bH\u0004J\u0014\u0010c\u001a\u00020\u0013*\u00020\"2\u0006\u0010d\u001a\u00020\"H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00138VX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u001aR\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020&X \u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\rR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u000200X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u00102R2\u00103\u001a&\u0012\u0004\u0012\u000205\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"07j\b\u0012\u0004\u0012\u00020\"`806\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "()V", "_rulerScope", "Landroidx/compose/ui/layout/RulerScope;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "isLookingAhead", "isLookingAhead$annotations", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "(Z)V", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "parent", "getParent", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/node/WeakReference;", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/layout/RulerScope;", "rulerValues", "Landroidx/collection/MutableObjectFloatMap;", "rulerValuesCache", "addRulerReader", "", "ruler", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "captureRulers", "result", "captureRulers$ui_release", "placeableResult", "Landroidx/compose/ui/node/PlaceableResult;", "findAncestorRulerDefiner", "findRulerValue", "", "defaultValue", "get", "invalidateChildrenOfDefiningRuler", "layout", "width", "height", "alignmentLines", "", "rulers", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "placementBlock", "notifyRulerValueChange", "layoutNodes", "provideRelativeRulerValue", "value", "provideRulerValue", "replace", "replace$ui_release", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLayoutNodeAncestor", "ancestor", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadDelegate.kt */
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Function1<PlaceableResult, Unit> onCommitAffectingRuler = LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1.INSTANCE;
    private RulerScope _rulerScope;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;
    private MutableObjectFloatMap<Ruler> rulerValues;
    private MutableObjectFloatMap<Ruler> rulerValuesCache;

    public static /* synthetic */ void isLookingAhead$annotations() {
    }

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public abstract long m6062getPositionnOccac();

    public boolean isLookingAhead() {
        return false;
    }

    public abstract void replace$ui_release();

    public boolean isPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    public final RulerScope getRulerScope() {
        RulerScope rulerScope = this._rulerScope;
        return rulerScope == null ? new LookaheadCapablePlaceable$rulerScope$1(this) : rulerScope;
    }

    public final int get(AlignmentLine alignmentLine) {
        int calculateAlignmentLine;
        int i;
        if (!getHasMeasureResult() || (calculateAlignmentLine = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (alignmentLine instanceof VerticalAlignmentLine) {
            i = IntOffset.m7241getXimpl(m5883getApparentToRealOffsetnOccac());
        } else {
            i = IntOffset.m7242getYimpl(m5883getApparentToRealOffsetnOccac());
        }
        return calculateAlignmentLine + i;
    }

    public final boolean isShallowPlacing$ui_release() {
        return this.isShallowPlacing;
    }

    public final void setShallowPlacing$ui_release(boolean z) {
        this.isShallowPlacing = z;
    }

    public final boolean isPlacingForAlignment$ui_release() {
        return this.isPlacingForAlignment;
    }

    public final void setPlacingForAlignment$ui_release(boolean z) {
        this.isPlacingForAlignment = z;
    }

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    /* access modifiers changed from: protected */
    public final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped$ui_release = nodeCoordinator.getWrapped$ui_release();
        if (!Intrinsics.areEqual((Object) wrapped$ui_release != null ? wrapped$ui_release.getLayoutNode() : null, (Object) nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner != null && (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) != null) {
            alignmentLines.onAlignmentsChanged();
        }
    }

    public final float findRulerValue(Ruler ruler, float f) {
        if (this.isPlacingForAlignment) {
            return f;
        }
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = lookaheadCapablePlaceable.rulerValues;
            float f2 = Float.NaN;
            if (mutableObjectFloatMap != null) {
                f2 = mutableObjectFloatMap.getOrDefault(ruler, Float.NaN);
            }
            if (!Float.isNaN(f2)) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return ruler.calculateCoordinate$ui_release(f2, lookaheadCapablePlaceable.getCoordinates(), getCoordinates());
            }
            LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
            if (parent == null) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return f;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00a2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addRulerReader(androidx.compose.ui.node.LayoutNode r32, androidx.compose.ui.layout.Ruler r33) {
        /*
            r31 = this;
            r0 = r31
            r1 = r33
            androidx.collection.MutableScatterMap<androidx.compose.ui.layout.Ruler, androidx.collection.MutableScatterSet<java.lang.ref.WeakReference<androidx.compose.ui.node.LayoutNode>>> r2 = r0.rulerReaders
            r7 = 7
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r10 = 8
            if (r2 == 0) goto L_0x0102
            androidx.collection.ScatterMap r2 = (androidx.collection.ScatterMap) r2
            java.lang.Object[] r13 = r2.values
            long[] r2 = r2.metadata
            int r14 = r2.length
            int r14 = r14 + -2
            if (r14 < 0) goto L_0x0102
            r15 = 0
            r16 = 128(0x80, double:6.32E-322)
        L_0x001e:
            r3 = r2[r15]
            r18 = 255(0xff, double:1.26E-321)
            long r5 = ~r3
            long r5 = r5 << r7
            long r5 = r5 & r3
            long r5 = r5 & r8
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x00ee
            int r5 = r15 - r14
            int r5 = ~r5
            int r5 = r5 >>> 31
            int r5 = 8 - r5
            r6 = 0
        L_0x0032:
            if (r6 >= r5) goto L_0x00e4
            long r20 = r3 & r18
            int r20 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            if (r20 >= 0) goto L_0x00ca
            int r20 = r15 << 3
            int r20 = r20 + r6
            r20 = r13[r20]
            r21 = r7
            r7 = r20
            androidx.collection.MutableScatterSet r7 = (androidx.collection.MutableScatterSet) r7
            r22 = r8
            java.lang.Object[] r8 = r7.elements
            r9 = r7
            androidx.collection.ScatterSet r9 = (androidx.collection.ScatterSet) r9
            long[] r9 = r9.metadata
            int r12 = r9.length
            int r12 = r12 + -2
            if (r12 < 0) goto L_0x00c1
            r24 = r10
            r10 = 0
        L_0x0057:
            r25 = r12
            r11 = r9[r10]
            r26 = r2
            r27 = r3
            long r2 = ~r11
            long r2 = r2 << r21
            long r2 = r2 & r11
            long r2 = r2 & r22
            int r2 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r2 == 0) goto L_0x00b0
            int r2 = r10 - r25
            int r2 = ~r2
            int r2 = r2 >>> 31
            int r2 = 8 - r2
            r3 = 0
        L_0x0071:
            if (r3 >= r2) goto L_0x00a9
            long r29 = r11 & r18
            int r4 = (r29 > r16 ? 1 : (r29 == r16 ? 0 : -1))
            if (r4 >= 0) goto L_0x009e
            int r4 = r10 << 3
            int r4 = r4 + r3
            r29 = r8[r4]
            java.lang.ref.WeakReference r29 = (java.lang.ref.WeakReference) r29
            java.lang.Object r29 = r29.get()
            androidx.compose.ui.node.LayoutNode r29 = (androidx.compose.ui.node.LayoutNode) r29
            r30 = r3
            if (r29 == 0) goto L_0x0095
            boolean r3 = r29.isAttached()
            r29 = r6
            r6 = 1
            if (r3 != r6) goto L_0x0097
            r6 = 1
            goto L_0x0098
        L_0x0095:
            r29 = r6
        L_0x0097:
            r6 = 0
        L_0x0098:
            if (r6 != 0) goto L_0x00a2
            r7.removeElementAt(r4)
            goto L_0x00a2
        L_0x009e:
            r30 = r3
            r29 = r6
        L_0x00a2:
            long r11 = r11 >> r24
            int r3 = r30 + 1
            r6 = r29
            goto L_0x0071
        L_0x00a9:
            r29 = r6
            r3 = r24
            if (r2 != r3) goto L_0x00c7
            goto L_0x00b2
        L_0x00b0:
            r29 = r6
        L_0x00b2:
            r12 = r25
            if (r10 == r12) goto L_0x00c7
            int r10 = r10 + 1
            r2 = r26
            r3 = r27
            r6 = r29
            r24 = 8
            goto L_0x0057
        L_0x00c1:
            r26 = r2
            r27 = r3
            r29 = r6
        L_0x00c7:
            r3 = 8
            goto L_0x00d5
        L_0x00ca:
            r26 = r2
            r27 = r3
            r29 = r6
            r21 = r7
            r22 = r8
            r3 = r10
        L_0x00d5:
            long r6 = r27 >> r3
            int r2 = r29 + 1
            r10 = r3
            r3 = r6
            r7 = r21
            r8 = r22
            r6 = r2
            r2 = r26
            goto L_0x0032
        L_0x00e4:
            r26 = r2
            r21 = r7
            r22 = r8
            r3 = r10
            if (r5 != r3) goto L_0x010a
            goto L_0x00f4
        L_0x00ee:
            r26 = r2
            r21 = r7
            r22 = r8
        L_0x00f4:
            if (r15 == r14) goto L_0x010a
            int r15 = r15 + 1
            r7 = r21
            r8 = r22
            r2 = r26
            r10 = 8
            goto L_0x001e
        L_0x0102:
            r21 = r7
            r22 = r8
            r16 = 128(0x80, double:6.32E-322)
            r18 = 255(0xff, double:1.26E-321)
        L_0x010a:
            androidx.collection.MutableScatterMap<androidx.compose.ui.layout.Ruler, androidx.collection.MutableScatterSet<java.lang.ref.WeakReference<androidx.compose.ui.node.LayoutNode>>> r2 = r0.rulerReaders
            if (r2 == 0) goto L_0x0161
            r3 = r2
            androidx.collection.ScatterMap r3 = (androidx.collection.ScatterMap) r3
            long[] r3 = r3.metadata
            int r4 = r3.length
            int r4 = r4 + -2
            if (r4 < 0) goto L_0x0161
            r5 = 0
        L_0x0119:
            r6 = r3[r5]
            long r8 = ~r6
            long r8 = r8 << r21
            long r8 = r8 & r6
            long r8 = r8 & r22
            int r8 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1))
            if (r8 == 0) goto L_0x015a
            int r8 = r5 - r4
            int r8 = ~r8
            int r8 = r8 >>> 31
            r24 = 8
            int r10 = 8 - r8
            r8 = 0
        L_0x012f:
            if (r8 >= r10) goto L_0x0155
            long r11 = r6 & r18
            int r9 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r9 >= 0) goto L_0x014f
            int r9 = r5 << 3
            int r9 = r9 + r8
            java.lang.Object[] r11 = r2.keys
            r11 = r11[r9]
            java.lang.Object[] r12 = r2.values
            r12 = r12[r9]
            androidx.collection.MutableScatterSet r12 = (androidx.collection.MutableScatterSet) r12
            androidx.compose.ui.layout.Ruler r11 = (androidx.compose.ui.layout.Ruler) r11
            boolean r11 = r12.isEmpty()
            if (r11 == 0) goto L_0x014f
            r2.removeValueAt(r9)
        L_0x014f:
            r9 = 8
            long r6 = r6 >> r9
            int r8 = r8 + 1
            goto L_0x012f
        L_0x0155:
            r9 = 8
            if (r10 != r9) goto L_0x0161
            goto L_0x015c
        L_0x015a:
            r9 = 8
        L_0x015c:
            if (r5 == r4) goto L_0x0161
            int r5 = r5 + 1
            goto L_0x0119
        L_0x0161:
            androidx.collection.MutableScatterMap<androidx.compose.ui.layout.Ruler, androidx.collection.MutableScatterSet<java.lang.ref.WeakReference<androidx.compose.ui.node.LayoutNode>>> r2 = r0.rulerReaders
            r3 = 0
            if (r2 != 0) goto L_0x0170
            androidx.collection.MutableScatterMap r2 = new androidx.collection.MutableScatterMap
            r4 = 0
            r6 = 1
            r2.<init>(r4, r6, r3)
            r0.rulerReaders = r2
            goto L_0x0172
        L_0x0170:
            r4 = 0
            r6 = 1
        L_0x0172:
            java.lang.Object r5 = r2.get(r1)
            if (r5 != 0) goto L_0x0180
            androidx.collection.MutableScatterSet r5 = new androidx.collection.MutableScatterSet
            r5.<init>(r4, r6, r3)
            r2.set(r1, r5)
        L_0x0180:
            androidx.collection.MutableScatterSet r5 = (androidx.collection.MutableScatterSet) r5
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r2 = r32
            r1.<init>(r2)
            r5.plusAssign(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.addRulerReader(androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.Ruler):void");
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable parent;
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = lookaheadCapablePlaceable.rulerValues;
            if ((mutableObjectFloatMap != null && mutableObjectFloatMap.contains(ruler)) || (parent = lookaheadCapablePlaceable.getParent()) == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    private final boolean isLayoutNodeAncestor(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode == layoutNode2) {
            return true;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            return isLayoutNodeAncestor(parent$ui_release, layoutNode2);
        }
        return false;
    }

    private final void invalidateChildrenOfDefiningRuler(Ruler ruler) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = findAncestorRulerDefiner(ruler).rulerReaders;
        MutableScatterSet remove = mutableScatterMap != null ? mutableScatterMap.remove(ruler) : null;
        if (remove != null) {
            notifyRulerValueChange(remove);
        }
    }

    public final void captureRulers$ui_release(MeasureResult measureResult) {
        if (measureResult != null) {
            captureRulers(new PlaceableResult(measureResult, this));
            return;
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        if (mutableScatterMap != null) {
            ScatterMap scatterMap = mutableScatterMap;
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
                                notifyRulerValueChange((MutableScatterSet) objArr[(i << 3) + i3]);
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
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap2 = this.rulerReaders;
        if (mutableScatterMap2 != null) {
            mutableScatterMap2.clear();
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap != null) {
            mutableObjectFloatMap.clear();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void captureRulers(androidx.compose.ui.node.PlaceableResult r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            boolean r2 = r0.isPlacingForAlignment
            if (r2 == 0) goto L_0x000a
            goto L_0x0075
        L_0x000a:
            androidx.compose.ui.layout.MeasureResult r2 = r1.getResult()
            kotlin.jvm.functions.Function1 r2 = r2.getRulers()
            androidx.collection.MutableScatterMap<androidx.compose.ui.layout.Ruler, androidx.collection.MutableScatterSet<java.lang.ref.WeakReference<androidx.compose.ui.node.LayoutNode>>> r3 = r0.rulerReaders
            r8 = 7
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r11 = 0
            r12 = 8
            if (r2 != 0) goto L_0x0076
            if (r3 == 0) goto L_0x0075
            r1 = r3
            androidx.collection.ScatterMap r1 = (androidx.collection.ScatterMap) r1
            java.lang.Object[] r2 = r1.values
            long[] r1 = r1.metadata
            int r13 = r1.length
            int r13 = r13 + -2
            if (r13 < 0) goto L_0x0072
            r14 = r11
            r15 = 128(0x80, double:6.32E-322)
        L_0x0030:
            r4 = r1[r14]
            r17 = 255(0xff, double:1.26E-321)
            long r6 = ~r4
            long r6 = r6 << r8
            long r6 = r6 & r4
            long r6 = r6 & r9
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 == 0) goto L_0x0069
            int r6 = r14 - r13
            int r6 = ~r6
            int r6 = r6 >>> 31
            int r6 = 8 - r6
            r7 = r11
        L_0x0044:
            if (r7 >= r6) goto L_0x0064
            long r19 = r4 & r17
            int r19 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r19 >= 0) goto L_0x005c
            int r19 = r14 << 3
            int r19 = r19 + r7
            r19 = r2[r19]
            r20 = r8
            r8 = r19
            androidx.collection.MutableScatterSet r8 = (androidx.collection.MutableScatterSet) r8
            r0.notifyRulerValueChange(r8)
            goto L_0x005e
        L_0x005c:
            r20 = r8
        L_0x005e:
            long r4 = r4 >> r12
            int r7 = r7 + 1
            r8 = r20
            goto L_0x0044
        L_0x0064:
            r20 = r8
            if (r6 != r12) goto L_0x0072
            goto L_0x006b
        L_0x0069:
            r20 = r8
        L_0x006b:
            if (r14 == r13) goto L_0x0072
            int r14 = r14 + 1
            r8 = r20
            goto L_0x0030
        L_0x0072:
            r3.clear()
        L_0x0075:
            return
        L_0x0076:
            r20 = r8
            r15 = 128(0x80, double:6.32E-322)
            r17 = 255(0xff, double:1.26E-321)
            androidx.collection.MutableObjectFloatMap<androidx.compose.ui.layout.Ruler> r2 = r0.rulerValuesCache
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x0089
            androidx.collection.MutableObjectFloatMap r2 = new androidx.collection.MutableObjectFloatMap
            r2.<init>(r11, r5, r4)
            r0.rulerValuesCache = r2
        L_0x0089:
            androidx.collection.MutableObjectFloatMap<androidx.compose.ui.layout.Ruler> r6 = r0.rulerValues
            if (r6 != 0) goto L_0x0094
            androidx.collection.MutableObjectFloatMap r6 = new androidx.collection.MutableObjectFloatMap
            r6.<init>(r11, r5, r4)
            r0.rulerValues = r6
        L_0x0094:
            r4 = r6
            androidx.collection.ObjectFloatMap r4 = (androidx.collection.ObjectFloatMap) r4
            r2.putAll(r4)
            r6.clear()
            androidx.compose.ui.node.LayoutNode r5 = r0.getLayoutNode()
            androidx.compose.ui.node.Owner r5 = r5.getOwner$ui_release()
            if (r5 == 0) goto L_0x00bc
            androidx.compose.ui.node.OwnerSnapshotObserver r5 = r5.getSnapshotObserver()
            if (r5 == 0) goto L_0x00bc
            r7 = r1
            androidx.compose.ui.node.OwnerScope r7 = (androidx.compose.ui.node.OwnerScope) r7
            kotlin.jvm.functions.Function1<androidx.compose.ui.node.PlaceableResult, kotlin.Unit> r8 = onCommitAffectingRuler
            androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$3 r13 = new androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$3
            r13.<init>(r1, r0)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r5.observeReads$ui_release(r7, r8, r13)
        L_0x00bc:
            if (r3 == 0) goto L_0x012e
            r1 = r2
            androidx.collection.ObjectFloatMap r1 = (androidx.collection.ObjectFloatMap) r1
            java.lang.Object[] r5 = r1.keys
            float[] r7 = r1.values
            long[] r1 = r1.metadata
            int r8 = r1.length
            int r8 = r8 + -2
            if (r8 < 0) goto L_0x012e
            r21 = r9
            r13 = r11
        L_0x00cf:
            r9 = r1[r13]
            r19 = r12
            long r11 = ~r9
            long r11 = r11 << r20
            long r11 = r11 & r9
            long r11 = r11 & r21
            int r11 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r11 == 0) goto L_0x0122
            int r11 = r13 - r8
            int r11 = ~r11
            int r11 = r11 >>> 31
            int r12 = 8 - r11
            r11 = 0
        L_0x00e5:
            if (r11 >= r12) goto L_0x011b
            long r23 = r9 & r17
            int r23 = (r23 > r15 ? 1 : (r23 == r15 ? 0 : -1))
            if (r23 >= 0) goto L_0x0112
            int r23 = r13 << 3
            int r23 = r23 + r11
            r24 = r5[r23]
            r23 = r7[r23]
            r14 = r24
            androidx.compose.ui.layout.Ruler r14 = (androidx.compose.ui.layout.Ruler) r14
            r24 = r15
            r15 = 2143289344(0x7fc00000, float:NaN)
            float r15 = r6.getOrDefault(r14, r15)
            int r15 = (r15 > r23 ? 1 : (r15 == r23 ? 0 : -1))
            if (r15 != 0) goto L_0x0106
            goto L_0x0114
        L_0x0106:
            java.lang.Object r14 = r3.remove(r14)
            androidx.collection.MutableScatterSet r14 = (androidx.collection.MutableScatterSet) r14
            if (r14 == 0) goto L_0x0114
            r0.notifyRulerValueChange(r14)
            goto L_0x0114
        L_0x0112:
            r24 = r15
        L_0x0114:
            long r9 = r9 >> r19
            int r11 = r11 + 1
            r15 = r24
            goto L_0x00e5
        L_0x011b:
            r24 = r15
            r9 = r19
            if (r12 != r9) goto L_0x0132
            goto L_0x0124
        L_0x0122:
            r24 = r15
        L_0x0124:
            if (r13 == r8) goto L_0x0132
            int r13 = r13 + 1
            r15 = r24
            r11 = 0
            r12 = 8
            goto L_0x00cf
        L_0x012e:
            r21 = r9
            r24 = r15
        L_0x0132:
            java.lang.Object[] r1 = r4.keys
            long[] r3 = r4.metadata
            int r4 = r3.length
            int r4 = r4 + -2
            if (r4 < 0) goto L_0x0182
            r5 = 0
        L_0x013c:
            r6 = r3[r5]
            long r8 = ~r6
            long r8 = r8 << r20
            long r8 = r8 & r6
            long r8 = r8 & r21
            int r8 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r8 == 0) goto L_0x017b
            int r8 = r5 - r4
            int r8 = ~r8
            int r8 = r8 >>> 31
            r19 = 8
            int r12 = 8 - r8
            r8 = 0
        L_0x0152:
            if (r8 >= r12) goto L_0x0176
            long r9 = r6 & r17
            int r9 = (r9 > r24 ? 1 : (r9 == r24 ? 0 : -1))
            if (r9 >= 0) goto L_0x0170
            int r9 = r5 << 3
            int r9 = r9 + r8
            r9 = r1[r9]
            androidx.compose.ui.layout.Ruler r9 = (androidx.compose.ui.layout.Ruler) r9
            boolean r10 = r2.contains(r9)
            if (r10 != 0) goto L_0x0170
            androidx.compose.ui.node.LookaheadCapablePlaceable r10 = r0.getParent()
            if (r10 == 0) goto L_0x0170
            r10.invalidateChildrenOfDefiningRuler(r9)
        L_0x0170:
            r9 = 8
            long r6 = r6 >> r9
            int r8 = r8 + 1
            goto L_0x0152
        L_0x0176:
            r9 = 8
            if (r12 != r9) goto L_0x0182
            goto L_0x017d
        L_0x017b:
            r9 = 8
        L_0x017d:
            if (r5 == r4) goto L_0x0182
            int r5 = r5 + 1
            goto L_0x013c
        L_0x0182:
            r2.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulers(androidx.compose.ui.node.PlaceableResult):void");
    }

    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSet) {
        LayoutNode layoutNode;
        ScatterSet scatterSet = mutableScatterSet;
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i << 3) + i3]).get()) != null) {
                            if (isLookingAhead()) {
                                layoutNode.requestLookaheadRelayout$ui_release(false);
                            } else {
                                layoutNode.requestRelayout$ui_release(false);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void provideRulerValue(Ruler ruler, float f) {
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, (DefaultConstructorMarker) null);
            this.rulerValues = mutableObjectFloatMap;
        }
        mutableObjectFloatMap.set(ruler, f);
    }

    public final void provideRelativeRulerValue(Ruler ruler, float f) {
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, (DefaultConstructorMarker) null);
            this.rulerValues = mutableObjectFloatMap;
        }
        if (getLayoutDirection() != LayoutDirection.Ltr) {
            f = ((float) getWidth()) - f;
        }
        mutableObjectFloatMap.set(ruler, f);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable$Companion;", "", "()V", "onCommitAffectingRuler", "Lkotlin/Function1;", "Landroidx/compose/ui/node/PlaceableResult;", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LookaheadDelegate.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super RulerScope, Unit> function1, Function1<? super Placeable.PlacementScope, Unit> function12) {
        if (!((i & ViewCompat.MEASURED_STATE_MASK) == 0 && (-16777216 & i2) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new LookaheadCapablePlaceable$layout$1(i, i2, map, function1, function12, this);
    }
}
