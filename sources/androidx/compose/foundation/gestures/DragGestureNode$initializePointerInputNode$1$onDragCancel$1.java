package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DragGestureNode$initializePointerInputNode$1$onDragCancel$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureNode$initializePointerInputNode$1$onDragCancel$1(DragGestureNode dragGestureNode) {
        super(0);
        this.this$0 = dragGestureNode;
    }

    public final void invoke() {
        Channel access$getChannel$p = this.this$0.channel;
        if (access$getChannel$p != null) {
            ChannelResult.m9357boximpl(access$getChannel$p.m9382trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
        }
    }
}
