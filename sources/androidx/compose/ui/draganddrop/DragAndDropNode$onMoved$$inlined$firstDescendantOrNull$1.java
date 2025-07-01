package androidx.compose.ui.draganddrop;

import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "T", "Landroidx/compose/ui/node/TraversableNode;", "child", "invoke", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "androidx/compose/ui/draganddrop/DragAndDropNodeKt$firstDescendantOrNull$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropNode.kt */
public final class DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1 extends Lambda implements Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction> {
    final /* synthetic */ DragAndDropEvent $event$inlined;
    final /* synthetic */ Ref.ObjectRef $match;
    final /* synthetic */ DragAndDropNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1(Ref.ObjectRef objectRef, DragAndDropNode dragAndDropNode, DragAndDropEvent dragAndDropEvent) {
        super(1);
        this.$match = objectRef;
        this.this$0 = dragAndDropNode;
        this.$event$inlined = dragAndDropEvent;
    }

    public final TraversableNode.Companion.TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
        DragAndDropModifierNode dragAndDropModifierNode = dragAndDropNode;
        if (!DelegatableNodeKt.requireOwner(this.this$0).getDragAndDropManager().isInterestedNode(dragAndDropModifierNode) || !DragAndDropNodeKt.m3851containsUv8p0NA(dragAndDropModifierNode, DragAndDrop_androidKt.getPositionInRoot(this.$event$inlined))) {
            return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
        }
        this.$match.element = dragAndDropNode;
        return TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal;
    }
}
