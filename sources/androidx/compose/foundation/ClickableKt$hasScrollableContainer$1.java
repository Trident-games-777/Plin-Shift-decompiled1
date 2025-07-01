package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "node", "Landroidx/compose/ui/node/TraversableNode;", "invoke", "(Landroidx/compose/ui/node/TraversableNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$hasScrollableContainer$1 extends Lambda implements Function1<TraversableNode, Boolean> {
    final /* synthetic */ Ref.BooleanRef $hasScrollable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$hasScrollableContainer$1(Ref.BooleanRef booleanRef) {
        super(1);
        this.$hasScrollable = booleanRef;
    }

    public final Boolean invoke(TraversableNode traversableNode) {
        boolean z;
        Ref.BooleanRef booleanRef = this.$hasScrollable;
        if (!booleanRef.element) {
            Intrinsics.checkNotNull(traversableNode, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode");
            if (!((ScrollableContainerNode) traversableNode).getEnabled()) {
                z = false;
                booleanRef.element = z;
                return Boolean.valueOf(!this.$hasScrollable.element);
            }
        }
        z = true;
        booleanRef.element = z;
        return Boolean.valueOf(!this.$hasScrollable.element);
    }
}
