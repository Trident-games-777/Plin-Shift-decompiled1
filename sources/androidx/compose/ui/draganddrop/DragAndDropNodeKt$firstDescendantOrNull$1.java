package androidx.compose.ui.draganddrop;

import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "T", "Landroidx/compose/ui/node/TraversableNode;", "child", "invoke", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropNode.kt */
public final class DragAndDropNodeKt$firstDescendantOrNull$1 extends Lambda implements Function1<T, TraversableNode.Companion.TraverseDescendantsAction> {
    final /* synthetic */ Ref.ObjectRef<T> $match;
    final /* synthetic */ Function1<T, Boolean> $predicate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragAndDropNodeKt$firstDescendantOrNull$1(Function1<? super T, Boolean> function1, Ref.ObjectRef<T> objectRef) {
        super(1);
        this.$predicate = function1;
        this.$match = objectRef;
    }

    public final TraversableNode.Companion.TraverseDescendantsAction invoke(T t) {
        if (!this.$predicate.invoke(t).booleanValue()) {
            return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
        }
        this.$match.element = t;
        return TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal;
    }
}
