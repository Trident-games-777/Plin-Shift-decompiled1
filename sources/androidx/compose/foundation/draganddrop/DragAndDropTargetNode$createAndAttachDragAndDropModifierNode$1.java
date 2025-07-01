package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "invoke", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropTarget.kt */
final class DragAndDropTargetNode$createAndAttachDragAndDropModifierNode$1 extends Lambda implements Function1<DragAndDropEvent, Boolean> {
    final /* synthetic */ DragAndDropTargetNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragAndDropTargetNode$createAndAttachDragAndDropModifierNode$1(DragAndDropTargetNode dragAndDropTargetNode) {
        super(1);
        this.this$0 = dragAndDropTargetNode;
    }

    public final Boolean invoke(DragAndDropEvent dragAndDropEvent) {
        return (Boolean) this.this$0.shouldStartDragAndDrop.invoke(dragAndDropEvent);
    }
}
