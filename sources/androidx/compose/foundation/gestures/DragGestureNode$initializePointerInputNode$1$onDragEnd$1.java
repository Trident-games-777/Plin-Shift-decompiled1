package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "upEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DragGestureNode$initializePointerInputNode$1$onDragEnd$1 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ VelocityTracker $velocityTracker;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureNode$initializePointerInputNode$1$onDragEnd$1(VelocityTracker velocityTracker, DragGestureNode dragGestureNode) {
        super(1);
        this.$velocityTracker = velocityTracker;
        this.this$0 = dragGestureNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PointerInputChange pointerInputChange) {
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, pointerInputChange);
        float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
        long r0 = this.$velocityTracker.m5707calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
        this.$velocityTracker.resetTracking();
        Channel access$getChannel$p = this.this$0.channel;
        if (access$getChannel$p != null) {
            ChannelResult.m9357boximpl(access$getChannel$p.m9382trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m485toValidVelocityTH1AsA0(r0), (DefaultConstructorMarker) null)));
        }
    }
}
