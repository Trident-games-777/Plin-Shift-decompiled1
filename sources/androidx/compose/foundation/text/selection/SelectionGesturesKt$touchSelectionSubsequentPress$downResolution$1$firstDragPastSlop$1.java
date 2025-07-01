package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "change", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "slop", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionGestures.kt */
final class SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1$firstDragPastSlop$1 extends Lambda implements Function2<PointerInputChange, Offset, Unit> {
    final /* synthetic */ Ref.LongRef $overSlop;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1$firstDragPastSlop$1(Ref.LongRef longRef) {
        super(2);
        this.$overSlop = longRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m1579invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m3997unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m1579invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
        pointerInputChange.consume();
        this.$overSlop.element = j;
    }
}
