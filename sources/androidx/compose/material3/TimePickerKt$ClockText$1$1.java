package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$ClockText$1$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ MutableState<Offset> $center$delegate;
    final /* synthetic */ MutableState<IntOffset> $parentCenter$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ClockText$1$1(MutableState<IntOffset> mutableState, MutableState<Offset> mutableState2) {
        super(1);
        this.$parentCenter$delegate = mutableState;
        this.$center$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        MutableState<IntOffset> mutableState = this.$parentCenter$delegate;
        LayoutCoordinates parentCoordinates = layoutCoordinates.getParentCoordinates();
        TimePickerKt.ClockText$lambda$33(mutableState, parentCoordinates != null ? IntSizeKt.m7289getCenterozmzZPI(parentCoordinates.m5800getSizeYbymL2g()) : IntOffset.Companion.m7251getZeronOccac());
        TimePickerKt.ClockText$lambda$30(this.$center$delegate, LayoutCoordinatesKt.boundsInParent(layoutCoordinates).m4017getCenterF1C5BW0());
    }
}
