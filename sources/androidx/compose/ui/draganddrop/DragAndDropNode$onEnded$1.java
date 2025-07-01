package androidx.compose.ui.draganddrop;

import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "currentNode", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropNode.kt */
final class DragAndDropNode$onEnded$1 extends Lambda implements Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction> {
    final /* synthetic */ DragAndDropEvent $event;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragAndDropNode$onEnded$1(DragAndDropEvent dragAndDropEvent) {
        super(1);
        this.$event = dragAndDropEvent;
    }

    public final TraversableNode.Companion.TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
        if (!dragAndDropNode.getNode().isAttached()) {
            return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
        }
        DragAndDropTarget access$getThisDragAndDropTarget$p = dragAndDropNode.thisDragAndDropTarget;
        if (access$getThisDragAndDropTarget$p != null) {
            access$getThisDragAndDropTarget$p.onEnded(this.$event);
        }
        dragAndDropNode.thisDragAndDropTarget = null;
        dragAndDropNode.lastChildDragAndDropModifierNode = null;
        return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
    }
}
