package androidx.navigation;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavController.kt */
final class NavController$executePopOperations$2 extends Lambda implements Function1<NavDestination, NavDestination> {
    public static final NavController$executePopOperations$2 INSTANCE = new NavController$executePopOperations$2();

    NavController$executePopOperations$2() {
        super(1);
    }

    public final NavDestination invoke(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, FirebaseAnalytics.Param.DESTINATION);
        NavGraph parent = navDestination.getParent();
        if (parent == null || parent.getStartDestinationId() != navDestination.getId()) {
            return null;
        }
        return navDestination.getParent();
    }
}
