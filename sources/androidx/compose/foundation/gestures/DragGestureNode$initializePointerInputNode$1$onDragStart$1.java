package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "down", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "slopTriggerChange", "postSlopOffset", "Landroidx/compose/ui/geometry/Offset;", "invoke-0AR0LA0", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DragGestureNode$initializePointerInputNode$1$onDragStart$1 extends Lambda implements Function3<PointerInputChange, PointerInputChange, Offset, Unit> {
    final /* synthetic */ VelocityTracker $velocityTracker;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureNode$initializePointerInputNode$1$onDragStart$1(DragGestureNode dragGestureNode, VelocityTracker velocityTracker) {
        super(3);
        this.this$0 = dragGestureNode;
        this.$velocityTracker = velocityTracker;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m467invoke0AR0LA0((PointerInputChange) obj, (PointerInputChange) obj2, ((Offset) obj3).m3997unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-0AR0LA0  reason: not valid java name */
    public final void m467invoke0AR0LA0(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j) {
        if (this.this$0.getCanDrag().invoke(pointerInputChange).booleanValue()) {
            if (!this.this$0.isListeningForEvents) {
                if (this.this$0.channel == null) {
                    this.this$0.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                }
                this.this$0.startListeningForEvents();
            }
            VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, pointerInputChange);
            long r5 = Offset.m3991minusMKHz9U(pointerInputChange2.m5587getPositionF1C5BW0(), j);
            Channel access$getChannel$p = this.this$0.channel;
            if (access$getChannel$p != null) {
                ChannelResult.m9357boximpl(access$getChannel$p.m9382trySendJP2dKIU(new DragEvent.DragStarted(r5, (DefaultConstructorMarker) null)));
            }
        }
    }
}
