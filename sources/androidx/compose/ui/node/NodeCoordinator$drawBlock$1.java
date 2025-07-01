package androidx.compose.ui.node;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
final class NodeCoordinator$drawBlock$1 extends Lambda implements Function2<Canvas, GraphicsLayer, Unit> {
    final /* synthetic */ NodeCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NodeCoordinator$drawBlock$1(NodeCoordinator nodeCoordinator) {
        super(2);
        this.this$0 = nodeCoordinator;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Canvas) obj, (GraphicsLayer) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(final Canvas canvas, final GraphicsLayer graphicsLayer) {
        if (this.this$0.getLayoutNode().isPlaced()) {
            Function1 access$getOnCommitAffectingLayer$cp = NodeCoordinator.onCommitAffectingLayer;
            final NodeCoordinator nodeCoordinator = this.this$0;
            this.this$0.getSnapshotObserver().observeReads$ui_release(this.this$0, access$getOnCommitAffectingLayer$cp, new Function0<Unit>() {
                public final void invoke() {
                    nodeCoordinator.drawContainedDrawModifiers(canvas, graphicsLayer);
                }
            });
            this.this$0.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.this$0.lastLayerDrawingWasSkipped = true;
    }
}
