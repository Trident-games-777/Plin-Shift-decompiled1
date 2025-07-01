package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"androidx/compose/foundation/content/internal/ReceiveContentDragAndDropNode_androidKt$ReceiveContentDragAndDropNode$2", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "onDrop", "", "event", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "onEnded", "", "onEntered", "onExited", "onStarted", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReceiveContentDragAndDropNode.android.kt */
public final class ReceiveContentDragAndDropNode_androidKt$ReceiveContentDragAndDropNode$2 implements DragAndDropTarget {
    final /* synthetic */ Function1<DragAndDropEvent, Unit> $dragAndDropRequestPermission;
    final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;

    ReceiveContentDragAndDropNode_androidKt$ReceiveContentDragAndDropNode$2(ReceiveContentConfiguration receiveContentConfiguration, Function1<? super DragAndDropEvent, Unit> function1) {
        this.$receiveContentConfiguration = receiveContentConfiguration;
        this.$dragAndDropRequestPermission = function1;
    }

    public void onStarted(DragAndDropEvent dragAndDropEvent) {
        this.$receiveContentConfiguration.getReceiveContentListener().onDragStart();
    }

    public void onEnded(DragAndDropEvent dragAndDropEvent) {
        this.$receiveContentConfiguration.getReceiveContentListener().onDragEnd();
    }

    public void onEntered(DragAndDropEvent dragAndDropEvent) {
        this.$receiveContentConfiguration.getReceiveContentListener().onDragEnter();
    }

    public void onExited(DragAndDropEvent dragAndDropEvent) {
        this.$receiveContentConfiguration.getReceiveContentListener().onDragExit();
    }

    public boolean onDrop(DragAndDropEvent dragAndDropEvent) {
        this.$dragAndDropRequestPermission.invoke(dragAndDropEvent);
        TransferableContent transferableContent = ReceiveContentDragAndDropNode_androidKt.toTransferableContent(dragAndDropEvent);
        return !Intrinsics.areEqual((Object) transferableContent, (Object) this.$receiveContentConfiguration.getReceiveContentListener().onReceive(transferableContent));
    }
}
