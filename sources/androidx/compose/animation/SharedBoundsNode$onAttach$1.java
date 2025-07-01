package androidx.compose.animation;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedContentNode.kt */
final class SharedBoundsNode$onAttach$1 extends Lambda implements Function0<LayoutCoordinates> {
    final /* synthetic */ SharedBoundsNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedBoundsNode$onAttach$1(SharedBoundsNode sharedBoundsNode) {
        super(0);
        this.this$0 = sharedBoundsNode;
    }

    public final LayoutCoordinates invoke() {
        return this.this$0.requireLookaheadLayoutCoordinates();
    }
}
