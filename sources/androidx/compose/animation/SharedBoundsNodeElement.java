package androidx.compose.animation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Landroidx/compose/animation/SharedBoundsNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SharedBoundsNode;", "sharedElementState", "Landroidx/compose/animation/SharedElementInternalState;", "(Landroidx/compose/animation/SharedElementInternalState;)V", "getSharedElementState", "()Landroidx/compose/animation/SharedElementInternalState;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedContentNode.kt */
public final class SharedBoundsNodeElement extends ModifierNodeElement<SharedBoundsNode> {
    public static final int $stable = 0;
    private final SharedElementInternalState sharedElementState;

    public static /* synthetic */ SharedBoundsNodeElement copy$default(SharedBoundsNodeElement sharedBoundsNodeElement, SharedElementInternalState sharedElementInternalState, int i, Object obj) {
        if ((i & 1) != 0) {
            sharedElementInternalState = sharedBoundsNodeElement.sharedElementState;
        }
        return sharedBoundsNodeElement.copy(sharedElementInternalState);
    }

    public final SharedElementInternalState component1() {
        return this.sharedElementState;
    }

    public final SharedBoundsNodeElement copy(SharedElementInternalState sharedElementInternalState) {
        return new SharedBoundsNodeElement(sharedElementInternalState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SharedBoundsNodeElement) && Intrinsics.areEqual((Object) this.sharedElementState, (Object) ((SharedBoundsNodeElement) obj).sharedElementState);
    }

    public int hashCode() {
        return this.sharedElementState.hashCode();
    }

    public String toString() {
        return "SharedBoundsNodeElement(sharedElementState=" + this.sharedElementState + ')';
    }

    public final SharedElementInternalState getSharedElementState() {
        return this.sharedElementState;
    }

    public SharedBoundsNodeElement(SharedElementInternalState sharedElementInternalState) {
        this.sharedElementState = sharedElementInternalState;
    }

    public SharedBoundsNode create() {
        return new SharedBoundsNode(this.sharedElementState);
    }

    public void update(SharedBoundsNode sharedBoundsNode) {
        sharedBoundsNode.setState$animation_release(this.sharedElementState);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("sharedBounds");
        inspectorInfo.getProperties().set("sharedElementState", this.sharedElementState);
    }
}
