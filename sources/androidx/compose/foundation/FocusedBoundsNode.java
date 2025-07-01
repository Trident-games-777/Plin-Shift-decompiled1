package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/FocusedBoundsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "()V", "isFocused", "", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "observer", "Landroidx/compose/foundation/FocusedBoundsObserverNode;", "getObserver", "()Landroidx/compose/foundation/FocusedBoundsObserverNode;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "notifyObserverWhenAttached", "", "onGloballyPositioned", "coordinates", "setFocus", "focused", "TraverseKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusedBounds.kt */
public final class FocusedBoundsNode extends Modifier.Node implements TraversableNode, GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    public static final TraverseKey TraverseKey = new TraverseKey((DefaultConstructorMarker) null);
    private boolean isFocused;
    private LayoutCoordinates layoutCoordinates;
    private final boolean shouldAutoInvalidate;

    public Object getTraverseKey() {
        return TraverseKey;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    private final FocusedBoundsObserverNode getObserver() {
        if (isAttached()) {
            TraversableNode findNearestAncestor = TraversableNodeKt.findNearestAncestor(this, FocusedBoundsObserverNode.TraverseKey);
            if (findNearestAncestor instanceof FocusedBoundsObserverNode) {
                return (FocusedBoundsObserverNode) findNearestAncestor;
            }
        }
        return null;
    }

    public final void setFocus(boolean z) {
        if (z != this.isFocused) {
            if (!z) {
                FocusedBoundsObserverNode observer = getObserver();
                if (observer != null) {
                    observer.onFocusBoundsChanged((LayoutCoordinates) null);
                }
            } else {
                notifyObserverWhenAttached();
            }
            this.isFocused = z;
        }
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates2) {
        this.layoutCoordinates = layoutCoordinates2;
        if (this.isFocused) {
            if (layoutCoordinates2.isAttached()) {
                notifyObserverWhenAttached();
                return;
            }
            FocusedBoundsObserverNode observer = getObserver();
            if (observer != null) {
                observer.onFocusBoundsChanged((LayoutCoordinates) null);
            }
        }
    }

    private final void notifyObserverWhenAttached() {
        FocusedBoundsObserverNode observer;
        LayoutCoordinates layoutCoordinates2 = this.layoutCoordinates;
        if (layoutCoordinates2 != null) {
            Intrinsics.checkNotNull(layoutCoordinates2);
            if (layoutCoordinates2.isAttached() && (observer = getObserver()) != null) {
                observer.onFocusBoundsChanged(this.layoutCoordinates);
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/FocusedBoundsNode$TraverseKey;", "", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusedBounds.kt */
    public static final class TraverseKey {
        public /* synthetic */ TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TraverseKey() {
        }
    }
}
