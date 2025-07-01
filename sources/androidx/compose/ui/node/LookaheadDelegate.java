package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b \u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010L\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0011H\u0000¢\u0006\u0002\bNJ\u0010\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u0012H\u0016J\u0010\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H\u0016J\u0010\u0010S\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u0012H\u0016J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H\u0016J)\u0010U\u001a\u00020V2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00070XH\bø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ=\u0010[\u001a\u00020\\2\u0006\u0010C\u001a\u00020D2\u0006\u0010]\u001a\u00020#2\u0019\u0010^\u001a\u0015\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\\\u0018\u00010_¢\u0006\u0002\baH\u0004ø\u0001\u0000¢\u0006\u0004\bb\u0010cJ\b\u0010d\u001a\u00020\\H\u0014J\u001a\u0010e\u001a\u00020\\2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bf\u0010GJ\u001a\u0010g\u001a\u00020\\2\u0006\u0010C\u001a\u00020DH\u0000ø\u0001\u0000¢\u0006\u0004\bh\u0010GJ%\u0010i\u001a\u00020D2\u0006\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020)H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ\r\u0010n\u001a\u00020\\H\u0010¢\u0006\u0002\boR\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00198@X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020.8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u0002028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00078PX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001c\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0017R\u0016\u0010?\u001a\u0004\u0018\u00010@8VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\"\u0010C\u001a\u00020DX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bE\u0010\u001b\"\u0004\bF\u0010GR\u001a\u0010I\u001a\u00020J8@X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bK\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006p"}, d2 = {"Landroidx/compose/ui/node/LookaheadDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "result", "Landroidx/compose/ui/layout/MeasureResult;", "_measureResult", "set_measureResult", "(Landroidx/compose/ui/layout/MeasureResult;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "cachedAlignmentLinesMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getCachedAlignmentLinesMap", "()Ljava/util/Map;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk$ui_release", "()J", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "isLookingAhead", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "lookaheadLayoutCoordinates", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "getLookaheadLayoutCoordinates", "()Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "oldAlignmentLines", "parent", "getParent", "parentData", "", "getParentData", "()Ljava/lang/Object;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$ui_release", "getCachedAlignmentLine", "alignmentLine", "getCachedAlignmentLine$ui_release", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "block", "Lkotlin/Function0;", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "", "zIndex", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeChildren", "placeSelf", "placeSelf--gyyYBs", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset--gyyYBs$ui_release", "positionIn", "ancestor", "excludingAgnosticOffset", "positionIn-iSbpLlY$ui_release", "(Landroidx/compose/ui/node/LookaheadDelegate;Z)J", "replace", "replace$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadDelegate.kt */
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {
    public static final int $stable = 0;
    private MeasureResult _measureResult;
    private final Map<AlignmentLine, Integer> cachedAlignmentLinesMap = new LinkedHashMap();
    private final NodeCoordinator coordinator;
    private final LookaheadLayoutCoordinates lookaheadLayoutCoordinates = new LookaheadLayoutCoordinates(this);
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m7251getZeronOccac();

    public boolean isLookingAhead() {
        return true;
    }

    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    public LookaheadDelegate(NodeCoordinator nodeCoordinator) {
        this.coordinator = nodeCoordinator;
    }

    public LookaheadCapablePlaceable getChild() {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        return wrapped$ui_release != null ? wrapped$ui_release.getLookaheadDelegate() : null;
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m6066getPositionnOccac() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m6072setPositiongyyYBs(long j) {
        this.position = j;
    }

    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.".toString());
    }

    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    public float getDensity() {
        return this.coordinator.getDensity();
    }

    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    public LookaheadCapablePlaceable getParent() {
        NodeCoordinator wrappedBy$ui_release = this.coordinator.getWrappedBy$ui_release();
        return wrappedBy$ui_release != null ? wrappedBy$ui_release.getLookaheadDelegate() : null;
    }

    public LayoutNode getLayoutNode() {
        return this.coordinator.getLayoutNode();
    }

    public LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    /* renamed from: getSize-YbymL2g$ui_release  reason: not valid java name */
    public final long m6067getSizeYbymL2g$ui_release() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    /* renamed from: getConstraints-msEJaDk$ui_release  reason: not valid java name */
    public final long m6065getConstraintsmsEJaDk$ui_release() {
        return m5885getMeasurementConstraintsmsEJaDk();
    }

    public final LookaheadLayoutCoordinates getLookaheadLayoutCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = this.coordinator.getLayoutNode().getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
        Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
        return lookaheadAlignmentLinesOwner$ui_release;
    }

    /* access modifiers changed from: private */
    public final void set_measureResult(MeasureResult measureResult) {
        Unit unit;
        Map<AlignmentLine, Integer> map;
        if (measureResult != null) {
            m5888setMeasuredSizeozmzZPI(IntSizeKt.IntSize(measureResult.getWidth(), measureResult.getHeight()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LookaheadDelegate lookaheadDelegate = this;
            m5888setMeasuredSizeozmzZPI(IntSize.Companion.m7288getZeroYbymL2g());
        }
        if (!Intrinsics.areEqual((Object) this._measureResult, (Object) measureResult) && measureResult != null && ((((map = this.oldAlignmentLines) != null && !map.isEmpty()) || !measureResult.getAlignmentLines().isEmpty()) && !Intrinsics.areEqual((Object) measureResult.getAlignmentLines(), (Object) this.oldAlignmentLines))) {
            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            Map<AlignmentLine, Integer> map2 = this.oldAlignmentLines;
            if (map2 == null) {
                map2 = new LinkedHashMap<>();
                this.oldAlignmentLines = map2;
            }
            map2.clear();
            map2.putAll(measureResult.getAlignmentLines());
        }
        this._measureResult = measureResult;
    }

    /* access modifiers changed from: protected */
    public final Map<AlignmentLine, Integer> getCachedAlignmentLinesMap() {
        return this.cachedAlignmentLinesMap;
    }

    public final int getCachedAlignmentLine$ui_release(AlignmentLine alignmentLine) {
        Integer num = this.cachedAlignmentLinesMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    public void replace$ui_release() {
        m6069placeAtf8xVGno(m6066getPositionnOccac(), 0.0f, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public final void m6069placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        m6064placeSelfgyyYBs(j);
        if (!isShallowPlacing$ui_release()) {
            placeChildren();
        }
    }

    /* renamed from: placeSelf--gyyYBs  reason: not valid java name */
    private final void m6064placeSelfgyyYBs(long j) {
        if (!IntOffset.m7240equalsimpl0(m6066getPositionnOccac(), j)) {
            m6072setPositiongyyYBs(j);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }
            invalidateAlignmentLinesFromPositionChange(this.coordinator);
        }
        if (!isPlacingForAlignment$ui_release()) {
            captureRulers$ui_release(getMeasureResult$ui_release());
        }
    }

    /* renamed from: placeSelfApparentToRealOffset--gyyYBs$ui_release  reason: not valid java name */
    public final void m6070placeSelfApparentToRealOffsetgyyYBs$ui_release(long j) {
        m6064placeSelfgyyYBs(IntOffset.m7245plusqkQi6aY(j, m5883getApparentToRealOffsetnOccac()));
    }

    /* access modifiers changed from: protected */
    public void placeChildren() {
        getMeasureResult$ui_release().placeChildren();
    }

    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m6068performingMeasureK40F9xA(long j, Function0<? extends MeasureResult> function0) {
        m5889setMeasurementConstraintsBRTryo0(j);
        set_measureResult((MeasureResult) function0.invoke());
        return this;
    }

    public Object getParentData() {
        return this.coordinator.getParentData();
    }

    public int minIntrinsicWidth(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicHeight(i);
    }

    /* renamed from: positionIn-iSbpLlY$ui_release  reason: not valid java name */
    public final long m6071positionIniSbpLlY$ui_release(LookaheadDelegate lookaheadDelegate, boolean z) {
        long r0 = IntOffset.Companion.m7251getZeronOccac();
        LookaheadDelegate lookaheadDelegate2 = this;
        while (!Intrinsics.areEqual((Object) lookaheadDelegate2, (Object) lookaheadDelegate)) {
            if (!lookaheadDelegate2.isPlacedUnderMotionFrameOfReference() || !z) {
                r0 = IntOffset.m7245plusqkQi6aY(r0, lookaheadDelegate2.m6066getPositionnOccac());
            }
            NodeCoordinator wrappedBy$ui_release = lookaheadDelegate2.coordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            lookaheadDelegate2 = wrappedBy$ui_release.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
        }
        return r0;
    }
}
