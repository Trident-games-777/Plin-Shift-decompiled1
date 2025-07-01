package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class LinksTextMeasurePolicy$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Measurable> $measurables;
    final /* synthetic */ LinksTextMeasurePolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinksTextMeasurePolicy$measure$1(List<? extends Measurable> list, LinksTextMeasurePolicy linksTextMeasurePolicy) {
        super(1);
        this.$measurables = list;
        this.this$0 = linksTextMeasurePolicy;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        List access$measureWithTextRangeMeasureConstraints = BasicTextKt.measureWithTextRangeMeasureConstraints(this.$measurables, this.this$0.shouldMeasureLinks);
        if (access$measureWithTextRangeMeasureConstraints != null) {
            int size = access$measureWithTextRangeMeasureConstraints.size();
            for (int i = 0; i < size; i++) {
                Pair pair = (Pair) access$measureWithTextRangeMeasureConstraints.get(i);
                Placeable placeable = (Placeable) pair.component1();
                Function0 function0 = (Function0) pair.component2();
                Placeable.PlacementScope.m5890place70tqf50$default(placementScope, placeable, function0 != null ? ((IntOffset) function0.invoke()).m7250unboximpl() : IntOffset.Companion.m7251getZeronOccac(), 0.0f, 2, (Object) null);
            }
        }
    }
}
