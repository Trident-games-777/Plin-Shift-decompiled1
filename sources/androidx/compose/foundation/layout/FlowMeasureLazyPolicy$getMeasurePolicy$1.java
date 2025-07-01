package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "measureScope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextualFlowLayout.kt */
final class FlowMeasureLazyPolicy$getMeasurePolicy$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ FlowMeasureLazyPolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowMeasureLazyPolicy$getMeasurePolicy$1(FlowMeasureLazyPolicy flowMeasureLazyPolicy) {
        super(2);
        this.this$0 = flowMeasureLazyPolicy;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m712invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m7058unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m712invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        return this.this$0.m710measure0kLqBqw(subcomposeMeasureScope, j);
    }
}
