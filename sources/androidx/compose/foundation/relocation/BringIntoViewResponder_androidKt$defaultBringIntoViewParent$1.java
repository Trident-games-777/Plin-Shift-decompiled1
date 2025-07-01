package androidx.compose.foundation.relocation;

import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "bringChildIntoView", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewResponder.android.kt */
final class BringIntoViewResponder_androidKt$defaultBringIntoViewParent$1 implements BringIntoViewParent {
    final /* synthetic */ DelegatableNode $this_defaultBringIntoViewParent;

    BringIntoViewResponder_androidKt$defaultBringIntoViewParent$1(DelegatableNode delegatableNode) {
        this.$this_defaultBringIntoViewParent = delegatableNode;
    }

    public final Object bringChildIntoView(LayoutCoordinates layoutCoordinates, Function0<Rect> function0, Continuation<? super Unit> continuation) {
        View requireView = DelegatableNode_androidKt.requireView(this.$this_defaultBringIntoViewParent);
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutCoordinates);
        Rect invoke = function0.invoke();
        Rect r3 = invoke != null ? invoke.m4024translatek4lQ0M(positionInRoot) : null;
        if (r3 != null) {
            requireView.requestRectangleOnScreen(BringIntoViewResponder_androidKt.toRect(r3), false);
        }
        return Unit.INSTANCE;
    }
}
