package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayoutOverflow.kt */
final class FlowLayoutOverflowState$setOverflowMeasurables$3$1 extends Lambda implements Function1<Placeable, Unit> {
    final /* synthetic */ FlowLineMeasurePolicy $measurePolicy;
    final /* synthetic */ FlowLayoutOverflowState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLayoutOverflowState$setOverflowMeasurables$3$1(FlowLayoutOverflowState flowLayoutOverflowState, FlowLineMeasurePolicy flowLineMeasurePolicy) {
        super(1);
        this.this$0 = flowLayoutOverflowState;
        this.$measurePolicy = flowLineMeasurePolicy;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable placeable) {
        int i;
        int i2;
        if (placeable != null) {
            FlowLineMeasurePolicy flowLineMeasurePolicy = this.$measurePolicy;
            i = flowLineMeasurePolicy.mainAxisSize(placeable);
            i2 = flowLineMeasurePolicy.crossAxisSize(placeable);
        } else {
            i = 0;
            i2 = 0;
        }
        this.this$0.seeMoreSize = IntIntPair.m26boximpl(IntIntPair.m29constructorimpl(i, i2));
        this.this$0.seeMorePlaceable = placeable;
    }
}
