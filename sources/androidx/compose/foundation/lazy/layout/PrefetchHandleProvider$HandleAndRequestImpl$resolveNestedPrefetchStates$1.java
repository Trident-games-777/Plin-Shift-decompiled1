package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.node.TraversableNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "it", "Landroidx/compose/ui/node/TraversableNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPrefetchState.kt */
final class PrefetchHandleProvider$HandleAndRequestImpl$resolveNestedPrefetchStates$1 extends Lambda implements Function1<TraversableNode, TraversableNode.Companion.TraverseDescendantsAction> {
    final /* synthetic */ Ref.ObjectRef<List<LazyLayoutPrefetchState>> $nestedStates;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrefetchHandleProvider$HandleAndRequestImpl$resolveNestedPrefetchStates$1(Ref.ObjectRef<List<LazyLayoutPrefetchState>> objectRef) {
        super(1);
        this.$nestedStates = objectRef;
    }

    public final TraversableNode.Companion.TraverseDescendantsAction invoke(TraversableNode traversableNode) {
        Intrinsics.checkNotNull(traversableNode, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
        LazyLayoutPrefetchState prefetchState = ((TraversablePrefetchStateNode) traversableNode).getPrefetchState();
        Ref.ObjectRef<List<LazyLayoutPrefetchState>> objectRef = this.$nestedStates;
        T t = (List) objectRef.element;
        if (t != null) {
            t.add(prefetchState);
        } else {
            t = CollectionsKt.mutableListOf(prefetchState);
        }
        objectRef.element = t;
        return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
    }
}
