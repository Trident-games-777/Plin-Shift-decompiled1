package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "value", "", "velocity", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableKt$animateTo$2$2 extends Lambda implements Function2<Float, Float, Unit> {
    final /* synthetic */ Ref.FloatRef $prev;
    final /* synthetic */ AnchoredDragScope $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$animateTo$2$2(AnchoredDragScope anchoredDragScope, Ref.FloatRef floatRef) {
        super(2);
        this.$this_with = anchoredDragScope;
        this.$prev = floatRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, float f2) {
        this.$this_with.dragTo(f, f2);
        this.$prev.element = f;
    }
}
