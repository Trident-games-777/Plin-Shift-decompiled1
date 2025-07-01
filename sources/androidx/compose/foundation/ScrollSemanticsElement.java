package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016J\f\u0010#\u001a\u00020!*\u00020$H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Landroidx/compose/foundation/ScrollSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "state", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "isScrollable", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZZ)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "()Z", "getReverseScrolling", "getState", "()Landroidx/compose/foundation/ScrollState;", "component1", "component2", "component3", "component4", "component5", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollSemanticsElement extends ModifierNodeElement<ScrollSemanticsModifierNode> {
    private final FlingBehavior flingBehavior;
    private final boolean isScrollable;
    private final boolean isVertical;
    private final boolean reverseScrolling;
    private final ScrollState state;

    public static /* synthetic */ ScrollSemanticsElement copy$default(ScrollSemanticsElement scrollSemanticsElement, ScrollState scrollState, boolean z, FlingBehavior flingBehavior2, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            scrollState = scrollSemanticsElement.state;
        }
        if ((i & 2) != 0) {
            z = scrollSemanticsElement.reverseScrolling;
        }
        if ((i & 4) != 0) {
            flingBehavior2 = scrollSemanticsElement.flingBehavior;
        }
        if ((i & 8) != 0) {
            z2 = scrollSemanticsElement.isScrollable;
        }
        if ((i & 16) != 0) {
            z3 = scrollSemanticsElement.isVertical;
        }
        boolean z4 = z2;
        boolean z5 = z3;
        return scrollSemanticsElement.copy(scrollState, z, flingBehavior2, z4, z5);
    }

    public final ScrollState component1() {
        return this.state;
    }

    public final boolean component2() {
        return this.reverseScrolling;
    }

    public final FlingBehavior component3() {
        return this.flingBehavior;
    }

    public final boolean component4() {
        return this.isScrollable;
    }

    public final boolean component5() {
        return this.isVertical;
    }

    public final ScrollSemanticsElement copy(ScrollState scrollState, boolean z, FlingBehavior flingBehavior2, boolean z2, boolean z3) {
        return new ScrollSemanticsElement(scrollState, z, flingBehavior2, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollSemanticsElement)) {
            return false;
        }
        ScrollSemanticsElement scrollSemanticsElement = (ScrollSemanticsElement) obj;
        return Intrinsics.areEqual((Object) this.state, (Object) scrollSemanticsElement.state) && this.reverseScrolling == scrollSemanticsElement.reverseScrolling && Intrinsics.areEqual((Object) this.flingBehavior, (Object) scrollSemanticsElement.flingBehavior) && this.isScrollable == scrollSemanticsElement.isScrollable && this.isVertical == scrollSemanticsElement.isVertical;
    }

    public int hashCode() {
        int hashCode = ((this.state.hashCode() * 31) + Boolean.hashCode(this.reverseScrolling)) * 31;
        FlingBehavior flingBehavior2 = this.flingBehavior;
        return ((((hashCode + (flingBehavior2 == null ? 0 : flingBehavior2.hashCode())) * 31) + Boolean.hashCode(this.isScrollable)) * 31) + Boolean.hashCode(this.isVertical);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "ScrollSemanticsElement(state=" + this.state + ", reverseScrolling=" + this.reverseScrolling + ", flingBehavior=" + this.flingBehavior + ", isScrollable=" + this.isScrollable + ", isVertical=" + this.isVertical + ')';
    }

    public final ScrollState getState() {
        return this.state;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final boolean isScrollable() {
        return this.isScrollable;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public ScrollSemanticsElement(ScrollState scrollState, boolean z, FlingBehavior flingBehavior2, boolean z2, boolean z3) {
        this.state = scrollState;
        this.reverseScrolling = z;
        this.flingBehavior = flingBehavior2;
        this.isScrollable = z2;
        this.isVertical = z3;
    }

    public ScrollSemanticsModifierNode create() {
        return new ScrollSemanticsModifierNode(this.state, this.reverseScrolling, this.flingBehavior, this.isScrollable, this.isVertical);
    }

    public void update(ScrollSemanticsModifierNode scrollSemanticsModifierNode) {
        scrollSemanticsModifierNode.setState(this.state);
        scrollSemanticsModifierNode.setReverseScrolling(this.reverseScrolling);
        scrollSemanticsModifierNode.setFlingBehavior(this.flingBehavior);
        scrollSemanticsModifierNode.setScrollable(this.isScrollable);
        scrollSemanticsModifierNode.setVertical(this.isVertical);
    }
}
