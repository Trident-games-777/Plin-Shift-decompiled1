package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ExitTransition;
import androidx.compose.runtime.MutableState;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.ComposeNavigator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavHost.kt */
final class NavHostKt$NavHost$finalExit$1$1 extends Lambda implements Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> {
    final /* synthetic */ ComposeNavigator $composeNavigator;
    final /* synthetic */ Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> $exitTransition;
    final /* synthetic */ MutableState<Boolean> $inPredictiveBack$delegate;
    final /* synthetic */ Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> $popExitTransition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$finalExit$1$1(ComposeNavigator composeNavigator, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, MutableState<Boolean> mutableState) {
        super(1);
        this.$composeNavigator = composeNavigator;
        this.$popExitTransition = function1;
        this.$exitTransition = function12;
        this.$inPredictiveBack$delegate = mutableState;
    }

    public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        NavDestination destination = animatedContentTransitionScope.getInitialState().getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
        ExitTransition exitTransition = null;
        if (this.$composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHostKt.NavHost$lambda$11(this.$inPredictiveBack$delegate)) {
            Iterator<NavDestination> it = NavDestination.Companion.getHierarchy(destination2).iterator();
            while (true) {
                if (it.hasNext()) {
                    ExitTransition access$createPopExitTransition = NavHostKt.createPopExitTransition(it.next(), animatedContentTransitionScope);
                    if (access$createPopExitTransition != null) {
                        exitTransition = access$createPopExitTransition;
                        break;
                    }
                } else {
                    break;
                }
            }
            return exitTransition == null ? this.$popExitTransition.invoke(animatedContentTransitionScope) : exitTransition;
        }
        Iterator<NavDestination> it2 = NavDestination.Companion.getHierarchy(destination2).iterator();
        while (true) {
            if (it2.hasNext()) {
                ExitTransition access$createExitTransition = NavHostKt.createExitTransition(it2.next(), animatedContentTransitionScope);
                if (access$createExitTransition != null) {
                    exitTransition = access$createExitTransition;
                    break;
                }
            } else {
                break;
            }
        }
        return exitTransition == null ? this.$exitTransition.invoke(animatedContentTransitionScope) : exitTransition;
    }
}
