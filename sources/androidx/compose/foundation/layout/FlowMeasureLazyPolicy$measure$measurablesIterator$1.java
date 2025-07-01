package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Measurable;", "index", "", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextualFlowLayout.kt */
final class FlowMeasureLazyPolicy$measure$measurablesIterator$1 extends Lambda implements Function2<Integer, FlowLineInfo, List<? extends Measurable>> {
    final /* synthetic */ SubcomposeMeasureScope $this_measure;
    final /* synthetic */ FlowMeasureLazyPolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowMeasureLazyPolicy$measure$measurablesIterator$1(SubcomposeMeasureScope subcomposeMeasureScope, FlowMeasureLazyPolicy flowMeasureLazyPolicy) {
        super(2);
        this.$this_measure = subcomposeMeasureScope;
        this.this$0 = flowMeasureLazyPolicy;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (FlowLineInfo) obj2);
    }

    public final List<Measurable> invoke(final int i, final FlowLineInfo flowLineInfo) {
        SubcomposeMeasureScope subcomposeMeasureScope = this.$this_measure;
        Integer valueOf = Integer.valueOf(i);
        final FlowMeasureLazyPolicy flowMeasureLazyPolicy = this.this$0;
        return subcomposeMeasureScope.subcompose(valueOf, ComposableLambdaKt.composableLambdaInstance(-195060736, true, new Function2<Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C452@17604L26:ContextualFlowLayout.kt#2w3rfo");
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-195060736, i, -1, "androidx.compose.foundation.layout.FlowMeasureLazyPolicy.measure.<anonymous>.<anonymous> (ContextualFlowLayout.kt:452)");
                    }
                    flowMeasureLazyPolicy.getComposable.invoke(Integer.valueOf(i), flowLineInfo, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }));
    }
}
