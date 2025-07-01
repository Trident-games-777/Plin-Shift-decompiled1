package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u000f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\n\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\u000b\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b¨\u0006\f"}, d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "positionOnScreen", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutCoordinates.kt */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.m5803localToRootMKHz9U(Offset.Companion.m4003getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.m5805localToWindowMKHz9U(Offset.Companion.m4003getZeroF1C5BW0());
    }

    public static final long positionOnScreen(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.m5804localToScreenMKHz9U(Offset.Companion.m4003getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, (Object) null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates findRootCoordinates = findRootCoordinates(layoutCoordinates);
        float r1 = (float) IntSize.m7283getWidthimpl(findRootCoordinates.m5800getSizeYbymL2g());
        float r2 = (float) IntSize.m7282getHeightimpl(findRootCoordinates.m5800getSizeYbymL2g());
        Rect boundsInRoot = boundsInRoot(layoutCoordinates);
        float left = boundsInRoot.getLeft();
        float f = 0.0f;
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > r1) {
            left = r1;
        }
        float top = boundsInRoot.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > r2) {
            top = r2;
        }
        float right = boundsInRoot.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= r1) {
            r1 = right;
        }
        float bottom = boundsInRoot.getBottom();
        if (bottom >= 0.0f) {
            f = bottom;
        }
        if (f <= r2) {
            r2 = f;
        }
        if (left == r1 || top == r2) {
            return Rect.Companion.getZero();
        }
        long r6 = findRootCoordinates.m5805localToWindowMKHz9U(OffsetKt.Offset(left, top));
        long r4 = findRootCoordinates.m5805localToWindowMKHz9U(OffsetKt.Offset(r1, top));
        long r8 = findRootCoordinates.m5805localToWindowMKHz9U(OffsetKt.Offset(r1, r2));
        long r0 = findRootCoordinates.m5805localToWindowMKHz9U(OffsetKt.Offset(left, r2));
        float r12 = Offset.m3987getXimpl(r6);
        float r22 = Offset.m3987getXimpl(r4);
        float r3 = Offset.m3987getXimpl(r0);
        float r10 = Offset.m3987getXimpl(r8);
        float min = Math.min(r12, Math.min(r22, Math.min(r3, r10)));
        float max = Math.max(r12, Math.max(r22, Math.max(r3, r10)));
        float r23 = Offset.m3988getYimpl(r6);
        float r32 = Offset.m3988getYimpl(r4);
        float r02 = Offset.m3988getYimpl(r0);
        float r13 = Offset.m3988getYimpl(r8);
        return new Rect(min, Math.min(r23, Math.min(r32, Math.min(r02, r13))), max, Math.max(r23, Math.max(r32, Math.max(r02, r13))));
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.m5801localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m4003getZeroF1C5BW0()) : Offset.Companion.m4003getZeroF1C5BW0();
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect localBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        if (parentLayoutCoordinates == null || (localBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, (Object) null)) == null) {
            return new Rect(0.0f, 0.0f, (float) IntSize.m7283getWidthimpl(layoutCoordinates.m5800getSizeYbymL2g()), (float) IntSize.m7282getHeightimpl(layoutCoordinates.m5800getSizeYbymL2g()));
        }
        return localBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy$ui_release;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        }
    }
}
