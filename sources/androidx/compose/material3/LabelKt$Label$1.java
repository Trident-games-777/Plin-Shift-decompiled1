package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Label.kt */
final class LabelKt$Label$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<TooltipScope, Composer, Integer, Unit> $label;
    final /* synthetic */ TooltipScopeImpl $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LabelKt$Label$1(Function3<? super TooltipScope, ? super Composer, ? super Integer, Unit> function3, TooltipScopeImpl tooltipScopeImpl) {
        super(2);
        this.$label = function3;
        this.$scope = tooltipScopeImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C88@3843L7:Label.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(784196780, i, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:88)");
            }
            this.$label.invoke(this.$scope, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
