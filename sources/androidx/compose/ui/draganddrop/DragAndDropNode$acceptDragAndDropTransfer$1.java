package androidx.compose.ui.draganddrop;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "currentNode", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropNode.kt */
final class DragAndDropNode$acceptDragAndDropTransfer$1 extends Lambda implements Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction> {
    final /* synthetic */ Ref.BooleanRef $handled;
    final /* synthetic */ DragAndDropEvent $startEvent;
    final /* synthetic */ DragAndDropNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragAndDropNode$acceptDragAndDropTransfer$1(DragAndDropEvent dragAndDropEvent, DragAndDropNode dragAndDropNode, Ref.BooleanRef booleanRef) {
        super(1);
        this.$startEvent = dragAndDropEvent;
        this.this$0 = dragAndDropNode;
        this.$handled = booleanRef;
    }

    public final TraversableNode.Companion.TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
        if (!dragAndDropNode.isAttached()) {
            return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
        }
        boolean z = true;
        if (!(dragAndDropNode.thisDragAndDropTarget == null)) {
            InlineClassHelperKt.throwIllegalStateException("DragAndDropTarget self reference must be null at the start of a drag and drop session");
        }
        dragAndDropNode.thisDragAndDropTarget = (DragAndDropTarget) dragAndDropNode.onDragAndDropStart.invoke(this.$startEvent);
        boolean z2 = dragAndDropNode.thisDragAndDropTarget != null;
        if (z2) {
            DelegatableNodeKt.requireOwner(this.this$0).getDragAndDropManager().registerNodeInterest(dragAndDropNode);
        }
        Ref.BooleanRef booleanRef = this.$handled;
        if (!booleanRef.element && !z2) {
            z = false;
        }
        booleanRef.element = z;
        return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
    }
}
