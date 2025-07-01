package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\r\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "invoke", "(Landroidx/compose/foundation/layout/FlowLayoutOverflowState;)Lkotlin/jvm/functions/Function2;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayoutOverflow.kt */
final class ContextualFlowColumnOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1 extends Lambda implements Function1<FlowLayoutOverflowState, Function2<? super Composer, ? super Integer, ? extends Unit>> {
    final /* synthetic */ Function3<ContextualFlowColumnOverflowScope, Composer, Integer, Unit> $collapseIndicator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextualFlowColumnOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1(Function3<? super ContextualFlowColumnOverflowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(1);
        this.$collapseIndicator = function3;
    }

    public final Function2<Composer, Integer, Unit> invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
        final Function3<ContextualFlowColumnOverflowScope, Composer, Integer, Unit> function3 = this.$collapseIndicator;
        return ComposableLambdaKt.composableLambdaInstance(-2119675914, true, new Function2<Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C628@27495L19:FlowLayoutOverflow.kt#2w3rfo");
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2119675914, i, -1, "androidx.compose.foundation.layout.ContextualFlowColumnOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:627)");
                    }
                    function3.invoke(new ContextualFlowColumnOverflowScopeImpl(flowLayoutOverflowState), composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }
}
