package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "it", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavDestination.kt */
final class NavDestination$Companion$hierarchy$1 extends Lambda implements Function1<NavDestination, NavDestination> {
    public static final NavDestination$Companion$hierarchy$1 INSTANCE = new NavDestination$Companion$hierarchy$1();

    NavDestination$Companion$hierarchy$1() {
        super(1);
    }

    public final NavDestination invoke(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "it");
        return navDestination.getParent();
    }
}
