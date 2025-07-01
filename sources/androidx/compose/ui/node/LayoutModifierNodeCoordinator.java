package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScopeImpl;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 G2\u00020\u0001:\u0002GHB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020$H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020$2\u0006\u0010*\u001a\u00020$H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u0010,\u001a\u00020$H\u0016J\b\u00104\u001a\u00020(H\u0002J\u001a\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J=\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0019\u0010?\u001a\u0015\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020(\u0018\u00010@¢\u0006\u0002\bBH\u0014ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ*\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010E\u001a\u000209H\u0014ø\u0001\u0000¢\u0006\u0004\bC\u0010FR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006I"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "measureNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "approachMeasureScope", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "value", "layoutModifierNode", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui_release", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw$ui_release", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM$ui_release", "(Landroidx/compose/ui/unit/Constraints;)V", "<set-?>", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrappedNonNull", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ensureLookaheadDelegateCreated", "", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "onAfterPlaceAt", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Companion", "LookaheadDelegateForLayoutModifierNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutModifierNodeCoordinator.kt */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Paint modifierBoundsPaint;
    /* access modifiers changed from: private */
    public ApproachMeasureScopeImpl approachMeasureScope;
    private LayoutModifierNode layoutModifierNode;
    private Constraints lookaheadConstraints;
    private LookaheadDelegate lookaheadDelegate;

    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode layoutModifierNode2) {
        super(layoutNode);
        this.layoutModifierNode = layoutModifierNode2;
        ApproachMeasureScopeImpl approachMeasureScopeImpl = null;
        this.lookaheadDelegate = layoutNode.getLookaheadRoot$ui_release() != null ? new LookaheadDelegateForLayoutModifierNode() : null;
        if ((layoutModifierNode2.getNode().getKindSet$ui_release() & NodeKind.m6139constructorimpl(512)) != 0) {
            Intrinsics.checkNotNull(layoutModifierNode2, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
            approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, (ApproachLayoutModifierNode) layoutModifierNode2);
        }
        this.approachMeasureScope = approachMeasureScopeImpl;
    }

    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    public final void setLayoutModifierNode$ui_release(LayoutModifierNode layoutModifierNode2) {
        if (!Intrinsics.areEqual((Object) layoutModifierNode2, (Object) this.layoutModifierNode)) {
            Modifier.Node node = layoutModifierNode2.getNode();
            if ((node.getKindSet$ui_release() & NodeKind.m6139constructorimpl(512)) != 0) {
                Intrinsics.checkNotNull(layoutModifierNode2, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
                ApproachLayoutModifierNode approachLayoutModifierNode = (ApproachLayoutModifierNode) layoutModifierNode2;
                ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
                if (approachMeasureScopeImpl != null) {
                    approachMeasureScopeImpl.setApproachNode(approachLayoutModifierNode);
                } else {
                    approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, approachLayoutModifierNode);
                }
                this.approachMeasureScope = approachMeasureScopeImpl;
            } else {
                this.approachMeasureScope = null;
            }
        }
        this.layoutModifierNode = layoutModifierNode2;
    }

    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped$ui_release = getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    /* renamed from: getLookaheadConstraints-DWUhwKw$ui_release  reason: not valid java name */
    public final Constraints m5987getLookaheadConstraintsDWUhwKw$ui_release() {
        return this.lookaheadConstraints;
    }

    /* renamed from: setLookaheadConstraints-_Sx5XlM$ui_release  reason: not valid java name */
    public final void m5991setLookaheadConstraints_Sx5XlM$ui_release(Constraints constraints) {
        this.lookaheadConstraints = constraints;
    }

    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    /* access modifiers changed from: protected */
    public void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate2) {
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutModifierNodeCoordinator.kt */
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m5992measureBRTryo0(long j) {
            LookaheadDelegate lookaheadDelegate = this;
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            lookaheadDelegate.m5889setMeasurementConstraintsBRTryo0(j);
            layoutModifierNodeCoordinator.m5991setLookaheadConstraints_Sx5XlM$ui_release(Constraints.m7040boximpl(j));
            LookaheadDelegate lookaheadDelegate2 = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            lookaheadDelegate.set_measureResult(layoutModifierNodeCoordinator.getLayoutModifierNode().m5982measure3p2s80s(this, lookaheadDelegate2, j));
            return lookaheadDelegate;
        }

        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int access$calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(access$calculateAlignmentAndPlaceChildAsNeeded));
            return access$calculateAlignmentAndPlaceChildAsNeeded;
        }

        public int minIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate, i);
        }

        public int maxIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate, i);
        }

        public int minIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate, i);
        }

        public int maxIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate, i);
        }
    }

    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00be, code lost:
        if (r1 == null) goto L_0x00c0;
     */
    /* renamed from: measure-BRTryo0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.Placeable m5988measureBRTryo0(long r9) {
        /*
            r8 = this;
            boolean r0 = r8.getForceMeasureWithLookaheadConstraints$ui_release()
            if (r0 == 0) goto L_0x001b
            androidx.compose.ui.unit.Constraints r9 = r8.lookaheadConstraints
            if (r9 == 0) goto L_0x000f
            long r9 = r9.m7058unboximpl()
            goto L_0x001b
        L_0x000f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Lookahead constraints cannot be null in approach pass."
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x001b:
            r0 = r8
            androidx.compose.ui.node.NodeCoordinator r0 = (androidx.compose.ui.node.NodeCoordinator) r0
            r0.m5889setMeasurementConstraintsBRTryo0(r9)
            androidx.compose.ui.layout.ApproachMeasureScopeImpl r0 = r8.approachMeasureScope
            if (r0 == 0) goto L_0x00c0
            androidx.compose.ui.layout.ApproachLayoutModifierNode r1 = r0.getApproachNode()
            long r2 = r0.m5736getLookaheadSizeYbymL2g()
            boolean r2 = r1.m5727isMeasurementApproachInProgressozmzZPI(r2)
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x0044
            androidx.compose.ui.unit.Constraints r2 = r8.m5987getLookaheadConstraintsDWUhwKw$ui_release()
            boolean r2 = androidx.compose.ui.unit.Constraints.m7044equalsimpl(r9, r2)
            if (r2 != 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r2 = r3
            goto L_0x0045
        L_0x0044:
            r2 = r4
        L_0x0045:
            r0.setApproachMeasureRequired$ui_release(r2)
            boolean r2 = r0.getApproachMeasureRequired$ui_release()
            if (r2 != 0) goto L_0x0055
            androidx.compose.ui.node.NodeCoordinator r2 = r8.getWrappedNonNull()
            r2.setForceMeasureWithLookaheadConstraints$ui_release(r4)
        L_0x0055:
            r2 = r0
            androidx.compose.ui.layout.ApproachMeasureScope r2 = (androidx.compose.ui.layout.ApproachMeasureScope) r2
            androidx.compose.ui.node.NodeCoordinator r5 = r8.getWrappedNonNull()
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            androidx.compose.ui.layout.MeasureResult r1 = r1.m5726approachMeasure3p2s80s(r2, r5, r9)
            androidx.compose.ui.node.NodeCoordinator r2 = r8.getWrappedNonNull()
            r2.setForceMeasureWithLookaheadConstraints$ui_release(r3)
            int r2 = r1.getWidth()
            androidx.compose.ui.node.LookaheadDelegate r5 = r8.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.getWidth()
            if (r2 != r5) goto L_0x008c
            int r2 = r1.getHeight()
            androidx.compose.ui.node.LookaheadDelegate r5 = r8.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.getHeight()
            if (r2 != r5) goto L_0x008c
            r3 = r4
        L_0x008c:
            boolean r0 = r0.getApproachMeasureRequired$ui_release()
            if (r0 != 0) goto L_0x00be
            androidx.compose.ui.node.NodeCoordinator r0 = r8.getWrappedNonNull()
            long r4 = r0.m6108getSizeYbymL2g()
            androidx.compose.ui.node.NodeCoordinator r0 = r8.getWrappedNonNull()
            androidx.compose.ui.node.LookaheadDelegate r0 = r0.getLookaheadDelegate()
            if (r0 == 0) goto L_0x00ad
            long r6 = r0.m6067getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r0 = androidx.compose.ui.unit.IntSize.m7275boximpl(r6)
            goto L_0x00ae
        L_0x00ad:
            r0 = 0
        L_0x00ae:
            boolean r0 = androidx.compose.ui.unit.IntSize.m7280equalsimpl(r4, r0)
            if (r0 == 0) goto L_0x00be
            if (r3 != 0) goto L_0x00be
            androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1 r0 = new androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1
            r0.<init>(r1, r8)
            r1 = r0
            androidx.compose.ui.layout.MeasureResult r1 = (androidx.compose.ui.layout.MeasureResult) r1
        L_0x00be:
            if (r1 != 0) goto L_0x00d1
        L_0x00c0:
            androidx.compose.ui.node.LayoutModifierNode r0 = r8.getLayoutModifierNode()
            r1 = r8
            androidx.compose.ui.layout.MeasureScope r1 = (androidx.compose.ui.layout.MeasureScope) r1
            androidx.compose.ui.node.NodeCoordinator r2 = r8.getWrappedNonNull()
            androidx.compose.ui.layout.Measurable r2 = (androidx.compose.ui.layout.Measurable) r2
            androidx.compose.ui.layout.MeasureResult r1 = r0.m5982measure3p2s80s(r1, r2, r9)
        L_0x00d1:
            r8.setMeasureResult$ui_release(r1)
            r9 = r8
            androidx.compose.ui.layout.Placeable r9 = (androidx.compose.ui.layout.Placeable) r9
            r8.onMeasured()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutModifierNodeCoordinator.m5988measureBRTryo0(long):androidx.compose.ui.layout.Placeable");
    }

    public int minIntrinsicWidth(int i) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), i);
        }
        return this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    public int maxIntrinsicWidth(int i) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), i);
        }
        return this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    public int minIntrinsicHeight(int i) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), i);
        }
        return this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    public int maxIntrinsicHeight(int i) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), i);
        }
        return this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m5989placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) {
        super.m6119placeAtf8xVGno(j, f, graphicsLayer);
        onAfterPlaceAt();
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m5990placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        super.m6120placeAtf8xVGno(j, f, function1);
        onAfterPlaceAt();
    }

    private final void onAfterPlaceAt() {
        boolean z;
        if (!isShallowPlacing$ui_release()) {
            onPlaced();
            ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
            if (approachMeasureScopeImpl != null) {
                ApproachLayoutModifierNode approachNode = approachMeasureScopeImpl.getApproachNode();
                Placeable.PlacementScope placementScope = getPlacementScope();
                LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate2);
                if (!approachNode.isPlacementApproachInProgress(placementScope, lookaheadDelegate2.getLookaheadLayoutCoordinates()) && !approachMeasureScopeImpl.getApproachMeasureRequired$ui_release()) {
                    long r2 = m6108getSizeYbymL2g();
                    LookaheadDelegate lookaheadDelegate3 = getLookaheadDelegate();
                    IntSize intSize = null;
                    if (IntSize.m7280equalsimpl(r2, lookaheadDelegate3 != null ? IntSize.m7275boximpl(lookaheadDelegate3.m6067getSizeYbymL2g$ui_release()) : null)) {
                        long r22 = getWrappedNonNull().m6108getSizeYbymL2g();
                        LookaheadDelegate lookaheadDelegate4 = getWrappedNonNull().getLookaheadDelegate();
                        if (lookaheadDelegate4 != null) {
                            intSize = IntSize.m7275boximpl(lookaheadDelegate4.m6067getSizeYbymL2g$ui_release());
                        }
                        if (IntSize.m7280equalsimpl(r22, intSize)) {
                            z = true;
                            getWrappedNonNull().setForcePlaceWithLookaheadOffset$ui_release(z);
                        }
                    }
                }
                z = false;
                getWrappedNonNull().setForcePlaceWithLookaheadOffset$ui_release(z);
            }
            getMeasureResult$ui_release().placeChildren();
            getWrappedNonNull().setForcePlaceWithLookaheadOffset$ui_release(false);
        }
    }

    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
        if (lookaheadDelegate2 != null) {
            return lookaheadDelegate2.getCachedAlignmentLine$ui_release(alignmentLine);
        }
        return LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        getWrappedNonNull().draw(canvas, graphicsLayer);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutModifierNodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m4510setColor8_81llA(Color.Companion.m4266getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.m4514setStylek9PVt8s(PaintingStyle.Companion.m4523getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }
}
