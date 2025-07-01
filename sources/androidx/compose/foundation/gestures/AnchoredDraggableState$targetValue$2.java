package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableState$targetValue$2 extends Lambda implements Function0<T> {
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableState$targetValue$2(AnchoredDraggableState<T> anchoredDraggableState) {
        super(0);
        this.this$0 = anchoredDraggableState;
    }

    public final T invoke() {
        T access$getDragTarget = this.this$0.getDragTarget();
        if (access$getDragTarget != null) {
            return access$getDragTarget;
        }
        AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
        if (Float.isNaN(anchoredDraggableState.getOffset())) {
            return anchoredDraggableState.getCurrentValue();
        }
        T closestAnchor = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
        return closestAnchor == null ? anchoredDraggableState.getCurrentValue() : closestAnchor;
    }
}
