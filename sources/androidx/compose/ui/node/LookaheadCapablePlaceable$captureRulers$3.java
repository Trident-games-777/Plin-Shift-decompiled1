package androidx.compose.ui.node;

import androidx.compose.ui.layout.RulerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadDelegate.kt */
final class LookaheadCapablePlaceable$captureRulers$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PlaceableResult $placeableResult;
    final /* synthetic */ LookaheadCapablePlaceable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LookaheadCapablePlaceable$captureRulers$3(PlaceableResult placeableResult, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        super(0);
        this.$placeableResult = placeableResult;
        this.this$0 = lookaheadCapablePlaceable;
    }

    public final void invoke() {
        Function1<RulerScope, Unit> rulers = this.$placeableResult.getResult().getRulers();
        if (rulers != null) {
            rulers.invoke(this.this$0.getRulerScope());
        }
    }
}
