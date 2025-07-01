package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$TooltipBox$scope$1$1 extends Lambda implements Function0<LayoutCoordinates> {
    final /* synthetic */ MutableState<LayoutCoordinates> $anchorBounds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$TooltipBox$scope$1$1(MutableState<LayoutCoordinates> mutableState) {
        super(0);
        this.$anchorBounds = mutableState;
    }

    public final LayoutCoordinates invoke() {
        return this.$anchorBounds.getValue();
    }
}
