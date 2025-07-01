package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\nH\u0016J\"\u0010(\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b*\u0010+J*\u0010(\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001a\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001a\u00103\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00102J\u001a\u00105\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b6\u00102J\u001a\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u00102J\"\u0010:\u001a\u00020;2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010<\u001a\u00020=H\u0016ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001a\u0010@\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001a\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\bE\u00102R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00118BX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001f8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b \u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "introducesMotionFrameOfReference", "", "getIntroducesMotionFrameOfReference", "()Z", "isAttached", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "()J", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayoutCoordinates.kt */
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public static final int $stable = 0;
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate2) {
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m5835getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate2 = this.lookaheadDelegate;
        return IntSizeKt.IntSize(lookaheadDelegate2.getWidth(), lookaheadDelegate2.getHeight());
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate2;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy$ui_release = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null || (lookaheadDelegate2 = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate2.getCoordinates();
    }

    public LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate2;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy$ui_release = getCoordinator().getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null || (lookaheadDelegate2 = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate2.getCoordinates();
    }

    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    public boolean getIntroducesMotionFrameOfReference() {
        return this.lookaheadDelegate.isPlacedUnderMotionFrameOfReference();
    }

    /* renamed from: getLookaheadOffset-F1C5BW0  reason: not valid java name */
    private final long m5834getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m3991minusMKHz9U(m5836localPositionOfR5De75A(rootLookaheadDelegate.getCoordinates(), Offset.Companion.m4003getZeroF1C5BW0()), getCoordinator().m6113localPositionOfR5De75A(rootLookaheadDelegate.getCoordinator(), Offset.Companion.m4003getZeroF1C5BW0()));
    }

    /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
    public long m5841screenToLocalMKHz9U(long j) {
        return Offset.m3992plusMKHz9U(getCoordinator().m6122screenToLocalMKHz9U(j), m5834getLookaheadOffsetF1C5BW0());
    }

    /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
    public long m5839localToScreenMKHz9U(long j) {
        return getCoordinator().m6116localToScreenMKHz9U(Offset.m3992plusMKHz9U(j, m5834getLookaheadOffsetF1C5BW0()));
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m5844windowToLocalMKHz9U(long j) {
        return Offset.m3992plusMKHz9U(getCoordinator().m6128windowToLocalMKHz9U(j), m5834getLookaheadOffsetF1C5BW0());
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m5840localToWindowMKHz9U(long j) {
        return getCoordinator().m6117localToWindowMKHz9U(Offset.m3992plusMKHz9U(j, m5834getLookaheadOffsetF1C5BW0()));
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m5838localToRootMKHz9U(long j) {
        return getCoordinator().m6115localToRootMKHz9U(Offset.m3992plusMKHz9U(j, m5834getLookaheadOffsetF1C5BW0()));
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m5836localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return m5837localPositionOfS_NoaFU(layoutCoordinates, j, true);
    }

    /* renamed from: localPositionOf-S_NoaFU  reason: not valid java name */
    public long m5837localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j, boolean z) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            LookaheadDelegate lookaheadDelegate2 = ((LookaheadLayoutCoordinates) layoutCoordinates).lookaheadDelegate;
            lookaheadDelegate2.getCoordinator().onCoordinatesUsed$ui_release();
            LookaheadDelegate lookaheadDelegate3 = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate2.getCoordinator()).getLookaheadDelegate();
            if (lookaheadDelegate3 != null) {
                long r6 = IntOffset.m7244minusqkQi6aY(IntOffset.m7245plusqkQi6aY(lookaheadDelegate2.m6071positionIniSbpLlY$ui_release(lookaheadDelegate3, !z), IntOffsetKt.m7257roundk4lQ0M(j)), this.lookaheadDelegate.m6071positionIniSbpLlY$ui_release(lookaheadDelegate3, !z));
                return OffsetKt.Offset((float) IntOffset.m7241getXimpl(r6), (float) IntOffset.m7242getYimpl(r6));
            }
            LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate2);
            long r62 = IntOffset.m7245plusqkQi6aY(IntOffset.m7245plusqkQi6aY(lookaheadDelegate2.m6071positionIniSbpLlY$ui_release(rootLookaheadDelegate, !z), rootLookaheadDelegate.m6066getPositionnOccac()), IntOffsetKt.m7257roundk4lQ0M(j));
            LookaheadDelegate rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
            long r63 = IntOffset.m7244minusqkQi6aY(r62, IntOffset.m7245plusqkQi6aY(this.lookaheadDelegate.m6071positionIniSbpLlY$ui_release(rootLookaheadDelegate2, !z), rootLookaheadDelegate2.m6066getPositionnOccac()));
            long Offset = OffsetKt.Offset((float) IntOffset.m7241getXimpl(r63), (float) IntOffset.m7242getYimpl(r63));
            NodeCoordinator wrappedBy$ui_release = rootLookaheadDelegate2.getCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            NodeCoordinator wrappedBy$ui_release2 = rootLookaheadDelegate.getCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release2);
            return wrappedBy$ui_release.m6114localPositionOfS_NoaFU(wrappedBy$ui_release2, Offset, z);
        }
        LookaheadDelegate rootLookaheadDelegate3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m3992plusMKHz9U(m5837localPositionOfS_NoaFU(rootLookaheadDelegate3.getLookaheadLayoutCoordinates(), j, z), rootLookaheadDelegate3.getCoordinator().getCoordinates().m5802localPositionOfS_NoaFU(layoutCoordinates, Offset.Companion.m4003getZeroF1C5BW0(), z));
    }

    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        return getCoordinator().localBoundingBoxOf(layoutCoordinates, z);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m5842transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        getCoordinator().m6125transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    /* renamed from: transformToScreen-58bKbWc  reason: not valid java name */
    public void m5843transformToScreen58bKbWc(float[] fArr) {
        getCoordinator().m6126transformToScreen58bKbWc(fArr);
    }

    public int get(AlignmentLine alignmentLine) {
        return this.lookaheadDelegate.get(alignmentLine);
    }
}
