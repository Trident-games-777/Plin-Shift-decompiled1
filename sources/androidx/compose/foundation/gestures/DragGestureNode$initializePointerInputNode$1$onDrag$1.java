package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "change", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "delta", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DragGestureNode$initializePointerInputNode$1$onDrag$1 extends Lambda implements Function2<PointerInputChange, Offset, Unit> {
    final /* synthetic */ VelocityTracker $velocityTracker;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureNode$initializePointerInputNode$1$onDrag$1(VelocityTracker velocityTracker, DragGestureNode dragGestureNode) {
        super(2);
        this.$velocityTracker = velocityTracker;
        this.this$0 = dragGestureNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m466invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m3997unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m466invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, pointerInputChange);
        Channel access$getChannel$p = this.this$0.channel;
        if (access$getChannel$p != null) {
            ChannelResult.m9357boximpl(access$getChannel$p.m9382trySendJP2dKIU(new DragEvent.DragDelta(j, (DefaultConstructorMarker) null)));
        }
    }
}
