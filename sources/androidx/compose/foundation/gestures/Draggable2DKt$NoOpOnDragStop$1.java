package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/unit/Velocity;", "invoke-TH1AsA0", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable2D.kt */
final class Draggable2DKt$NoOpOnDragStop$1 extends Lambda implements Function1<Velocity, Unit> {
    public static final Draggable2DKt$NoOpOnDragStop$1 INSTANCE = new Draggable2DKt$NoOpOnDragStop$1();

    Draggable2DKt$NoOpOnDragStop$1() {
        super(1);
    }

    /* renamed from: invoke-TH1AsA0  reason: not valid java name */
    public final void m470invokeTH1AsA0(long j) {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m470invokeTH1AsA0(((Velocity) obj).m7359unboximpl());
        return Unit.INSTANCE;
    }
}
