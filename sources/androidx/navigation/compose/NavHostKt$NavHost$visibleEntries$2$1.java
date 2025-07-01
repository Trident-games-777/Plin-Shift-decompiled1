package androidx.navigation.compose;

import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavHost.kt */
final class NavHostKt$NavHost$visibleEntries$2$1 extends Lambda implements Function0<List<? extends NavBackStackEntry>> {
    final /* synthetic */ State<List<NavBackStackEntry>> $allVisibleEntries$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$visibleEntries$2$1(State<? extends List<NavBackStackEntry>> state) {
        super(0);
        this.$allVisibleEntries$delegate = state;
    }

    public final List<NavBackStackEntry> invoke() {
        Collection arrayList = new ArrayList();
        for (Object next : NavHostKt.NavHost$lambda$15(this.$allVisibleEntries$delegate)) {
            if (Intrinsics.areEqual((Object) ((NavBackStackEntry) next).getDestination().getNavigatorName(), (Object) ComposeNavigator.NAME)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
