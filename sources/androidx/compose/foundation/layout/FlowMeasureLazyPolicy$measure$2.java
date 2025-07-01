package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/Measurable;", "canExpand", "", "noOfItemsShown", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextualFlowLayout.kt */
final class FlowMeasureLazyPolicy$measure$2 extends Lambda implements Function2<Boolean, Integer, Measurable> {
    final /* synthetic */ SubcomposeMeasureScope $this_measure;
    final /* synthetic */ FlowMeasureLazyPolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowMeasureLazyPolicy$measure$2(FlowMeasureLazyPolicy flowMeasureLazyPolicy, SubcomposeMeasureScope subcomposeMeasureScope) {
        super(2);
        this.this$0 = flowMeasureLazyPolicy;
        this.$this_measure = subcomposeMeasureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
    }

    public final Measurable invoke(boolean z, int i) {
        Function2 function2 = (Function2) CollectionsKt.getOrNull(this.this$0.overflowComposables, z ^ true ? 1 : 0);
        if (function2 == null) {
            return null;
        }
        return (Measurable) CollectionsKt.getOrNull(this.$this_measure.subcompose(new StringBuilder().append(z).append(this.this$0.itemCount).append(i).toString(), function2), 0);
    }
}
