package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0, 0, 1, 1, 1}, l = {548, 551}, m = "processDragStart", n = {"this", "event", "this", "event", "interaction"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* compiled from: Draggable.kt */
final class DragGestureNode$processDragStart$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureNode$processDragStart$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$processDragStart$1> continuation) {
        super(continuation);
        this.this$0 = dragGestureNode;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processDragStart((DragEvent.DragStarted) null, this);
    }
}
