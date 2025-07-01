package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"scrollIntoView", "", "Landroidx/compose/ui/node/DelegatableNode;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/foundation/relocation/ScrollIntoView")
/* compiled from: ScrollIntoViewRequester.kt */
final /* synthetic */ class ScrollIntoView__ScrollIntoViewRequesterKt {
    public static /* synthetic */ Object scrollIntoView$default(DelegatableNode delegatableNode, Rect rect, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return ScrollIntoView.scrollIntoView(delegatableNode, rect, continuation);
    }

    public static final Object scrollIntoView(DelegatableNode delegatableNode, Rect rect, Continuation<? super Unit> continuation) {
        if (!delegatableNode.getNode().isAttached()) {
            return Unit.INSTANCE;
        }
        LayoutCoordinates requireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(delegatableNode);
        BringIntoViewParent findBringIntoViewParent = BringIntoViewRequesterKt.findBringIntoViewParent(delegatableNode);
        if (findBringIntoViewParent == null) {
            return Unit.INSTANCE;
        }
        Object bringChildIntoView = findBringIntoViewParent.bringChildIntoView(requireLayoutCoordinates, new ScrollIntoView__ScrollIntoViewRequesterKt$scrollIntoView$2(rect, requireLayoutCoordinates), continuation);
        return bringChildIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringChildIntoView : Unit.INSTANCE;
    }
}
