package androidx.compose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.LookaheadScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/LookaheadScope;", "invoke", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SharedTransitionScopeKt$SharedTransitionScope$1 extends Lambda implements Function3<LookaheadScope, Composer, Integer, Unit> {
    final /* synthetic */ Function4<SharedTransitionScope, Modifier, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedTransitionScopeKt$SharedTransitionScope$1(Function4<? super SharedTransitionScope, ? super Modifier, ? super Composer, ? super Integer, Unit> function4) {
        super(3);
        this.$content = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((LookaheadScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LookaheadScope lookaheadScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C140@6644L24,141@6695L60,144@6830L586,158@7450L105,142@6776L789,163@7597L109,163@7574L132:SharedTransitionScope.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-863967934, i, -1, "androidx.compose.animation.SharedTransitionScope.<anonymous> (SharedTransitionScope.kt:140)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, -954367824, "CC(remember):Effects.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -538772662, "CC(remember):SharedTransitionScope.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new SharedTransitionScopeImpl(lookaheadScope, coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        SharedTransitionScopeImpl sharedTransitionScopeImpl = (SharedTransitionScopeImpl) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Function4<SharedTransitionScope, Modifier, Composer, Integer, Unit> function4 = this.$content;
        Modifier modifier = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, -538767816, "CC(remember):SharedTransitionScope.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new SharedTransitionScopeKt$SharedTransitionScope$1$1$1(sharedTransitionScopeImpl);
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier layout = LayoutModifierKt.layout(modifier, (Function3) rememberedValue3);
        ComposerKt.sourceInformationMarkerStart(composer, -538748457, "CC(remember):SharedTransitionScope.kt#9igjgp");
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new SharedTransitionScopeKt$SharedTransitionScope$1$2$1(sharedTransitionScopeImpl);
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        function4.invoke(sharedTransitionScopeImpl, DrawModifierKt.drawWithContent(layout, (Function1) rememberedValue4), composer, 6);
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -538743749, "CC(remember):SharedTransitionScope.kt#9igjgp");
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = new SharedTransitionScopeKt$SharedTransitionScope$1$3$1(sharedTransitionScopeImpl);
            composer.updateRememberedValue(rememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect((Object) unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue5, composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
