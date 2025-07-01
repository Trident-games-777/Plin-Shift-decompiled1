package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.SizeTransform;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.ComposeNavigator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/animation/SizeTransform;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavHost.kt */
final class NavHostKt$NavHost$finalSizeTransform$1$1 extends Lambda implements Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> {
    final /* synthetic */ Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> $sizeTransform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$finalSizeTransform$1$1(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1) {
        super(1);
        this.$sizeTransform = function1;
    }

    public final SizeTransform invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        SizeTransform sizeTransform;
        NavDestination destination = animatedContentTransitionScope.getTargetState().getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        Iterator<NavDestination> it = NavDestination.Companion.getHierarchy((ComposeNavigator.Destination) destination).iterator();
        while (true) {
            if (!it.hasNext()) {
                sizeTransform = null;
                break;
            }
            sizeTransform = NavHostKt.createSizeTransform(it.next(), animatedContentTransitionScope);
            if (sizeTransform != null) {
                break;
            }
        }
        if (sizeTransform != null) {
            return sizeTransform;
        }
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1 = this.$sizeTransform;
        if (function1 != null) {
            return function1.invoke(animatedContentTransitionScope);
        }
        return null;
    }
}
