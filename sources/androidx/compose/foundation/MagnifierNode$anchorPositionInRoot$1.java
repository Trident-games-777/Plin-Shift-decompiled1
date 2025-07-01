package androidx.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "invoke-F1C5BW0", "()J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.android.kt */
final class MagnifierNode$anchorPositionInRoot$1 extends Lambda implements Function0<Offset> {
    final /* synthetic */ MagnifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MagnifierNode$anchorPositionInRoot$1(MagnifierNode magnifierNode) {
        super(0);
        this.this$0 = magnifierNode;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m3976boximpl(m317invokeF1C5BW0());
    }

    /* renamed from: invoke-F1C5BW0  reason: not valid java name */
    public final long m317invokeF1C5BW0() {
        LayoutCoordinates access$getLayoutCoordinates = this.this$0.getLayoutCoordinates();
        return access$getLayoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(access$getLayoutCoordinates) : Offset.Companion.m4002getUnspecifiedF1C5BW0();
    }
}
