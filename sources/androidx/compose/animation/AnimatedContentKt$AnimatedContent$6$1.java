package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "S", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentKt$AnimatedContent$6$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function4<AnimatedContentScope, S, Composer, Integer, Unit> $content;
    final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S> $rootScope;
    final /* synthetic */ S $stateForContent;
    final /* synthetic */ Transition<S> $this_AnimatedContent;
    final /* synthetic */ Function1<AnimatedContentTransitionScope<S>, ContentTransform> $transitionSpec;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentKt$AnimatedContent$6$1(Transition<S> transition, S s, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl, SnapshotStateList<S> snapshotStateList, Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4) {
        super(2);
        this.$this_AnimatedContent = transition;
        this.$stateForContent = s;
        this.$transitionSpec = function1;
        this.$rootScope = animatedContentTransitionScopeImpl;
        this.$currentlyVisible = snapshotStateList;
        this.$content = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ExitTransition exitTransition;
        ComposerKt.sourceInformation(composer, "C757@36814L38,761@37028L323,768@37384L125,779@37953L328,775@37761L25,786@38417L233,791@38669L660,773@37692L1637:AnimatedContent.kt#xbi5r1");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(885640742, i, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:757)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1908224079, "CC(remember):AnimatedContent.kt#9igjgp");
            Function1<AnimatedContentTransitionScope<S>, ContentTransform> function1 = this.$transitionSpec;
            AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = this.$rootScope;
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = function1.invoke(animatedContentTransitionScopeImpl);
                composer.updateRememberedValue(rememberedValue);
            }
            ContentTransform contentTransform = (ContentTransform) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean areEqual = Intrinsics.areEqual((Object) this.$this_AnimatedContent.getSegment().getTargetState(), (Object) this.$stateForContent);
            ComposerKt.sourceInformationMarkerStart(composer, 1908231212, "CC(remember):AnimatedContent.kt#9igjgp");
            boolean changed = composer.changed(areEqual);
            Transition<S> transition = this.$this_AnimatedContent;
            S s = this.$stateForContent;
            Function1<AnimatedContentTransitionScope<S>, ContentTransform> function12 = this.$transitionSpec;
            AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl2 = this.$rootScope;
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                if (Intrinsics.areEqual((Object) transition.getSegment().getTargetState(), (Object) s)) {
                    exitTransition = ExitTransition.Companion.getNone();
                } else {
                    exitTransition = function12.invoke(animatedContentTransitionScopeImpl2).getInitialContentExit();
                }
                rememberedValue2 = exitTransition;
                composer.updateRememberedValue(rememberedValue2);
            }
            ExitTransition exitTransition2 = (ExitTransition) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1908242406, "CC(remember):AnimatedContent.kt#9igjgp");
            S s2 = this.$stateForContent;
            Transition<S> transition2 = this.$this_AnimatedContent;
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual((Object) s2, (Object) transition2.getTargetState()));
                composer.updateRememberedValue(rememberedValue3);
            }
            AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            EnterTransition targetContentEnter = contentTransform.getTargetContentEnter();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 1908260817, "CC(remember):AnimatedContent.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(contentTransform);
            Object rememberedValue4 = composer.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new AnimatedContentKt$AnimatedContent$6$1$1$1(contentTransform);
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier layout = LayoutModifierKt.layout(modifier, (Function3) rememberedValue4);
            childData.setTarget(Intrinsics.areEqual((Object) this.$stateForContent, (Object) this.$this_AnimatedContent.getTargetState()));
            Modifier then = layout.then(childData);
            EnterTransition enterTransition = targetContentEnter;
            Transition<S> transition3 = this.$this_AnimatedContent;
            ComposerKt.sourceInformationMarkerStart(composer, 1908254370, "CC(remember):AnimatedContent.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(this.$stateForContent);
            S s3 = this.$stateForContent;
            Object rememberedValue5 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new AnimatedContentKt$AnimatedContent$6$1$3$1(s3);
                composer.updateRememberedValue(rememberedValue5);
            }
            Function1 function13 = (Function1) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1908275570, "CC(remember):AnimatedContent.kt#9igjgp");
            boolean changed2 = composer.changed((Object) exitTransition2);
            Object rememberedValue6 = composer.rememberedValue();
            if (changed2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new AnimatedContentKt$AnimatedContent$6$1$4$1(exitTransition2);
                composer.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final SnapshotStateList<S> snapshotStateList = this.$currentlyVisible;
            final S s4 = this.$stateForContent;
            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl3 = this.$rootScope;
            final Function4<AnimatedContentScope, S, Composer, Integer, Unit> function4 = this.$content;
            Function1 function14 = function13;
            Function1 function15 = function14;
            AnimatedVisibilityKt.AnimatedEnterExitImpl(transition3, function15, then, enterTransition, exitTransition2, (Function2) rememberedValue6, (OnLookaheadMeasured) null, ComposableLambdaKt.rememberComposableLambda(-616195562, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C793@38802L230,793@38779L253,*801@39194L43,802@39265L24:AnimatedContent.kt#xbi5r1");
                    if ((i & 6) == 0) {
                        i |= (i & 8) == 0 ? composer.changed((Object) animatedVisibilityScope) : composer.changedInstance(animatedVisibilityScope) ? 4 : 2;
                    }
                    if ((i & 19) != 18 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-616195562, i, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous>.<anonymous> (AnimatedContent.kt:793)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer, 641996302, "CC(remember):AnimatedContent.kt#9igjgp");
                        boolean changed = composer.changed((Object) snapshotStateList) | composer.changedInstance(s4) | composer.changedInstance(animatedContentTransitionScopeImpl3);
                        SnapshotStateList<S> snapshotStateList = snapshotStateList;
                        S s = s4;
                        AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl3;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new AnimatedContentKt$AnimatedContent$6$1$5$1$1(snapshotStateList, s, animatedContentTransitionScopeImpl);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        EffectsKt.DisposableEffect((Object) animatedVisibilityScope, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, composer, i & 14);
                        MutableScatterMap<S, State<IntSize>> targetSizeMap$animation_release = animatedContentTransitionScopeImpl3.getTargetSizeMap$animation_release();
                        S s2 = s4;
                        Intrinsics.checkNotNull(animatedVisibilityScope, "null cannot be cast to non-null type androidx.compose.animation.AnimatedVisibilityScopeImpl");
                        targetSizeMap$animation_release.set(s2, ((AnimatedVisibilityScopeImpl) animatedVisibilityScope).getTargetSize$animation_release());
                        ComposerKt.sourceInformationMarkerStart(composer, 642008659, "CC(remember):AnimatedContent.kt#9igjgp");
                        Object rememberedValue2 = composer.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new AnimatedContentScopeImpl(animatedVisibilityScope);
                            composer.updateRememberedValue(rememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        function4.invoke((AnimatedContentScopeImpl) rememberedValue2, s4, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }, composer, 54), composer, 12582912, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
