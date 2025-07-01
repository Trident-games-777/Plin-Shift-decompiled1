package androidx.navigation.compose;

import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DialogHost.kt */
final class DialogHostKt$DialogHost$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NavBackStackEntry $backStackEntry;
    final /* synthetic */ DialogNavigator $dialogNavigator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogHostKt$DialogHost$1$1$1(DialogNavigator dialogNavigator, NavBackStackEntry navBackStackEntry) {
        super(0);
        this.$dialogNavigator = dialogNavigator;
        this.$backStackEntry = navBackStackEntry;
    }

    public final void invoke() {
        this.$dialogNavigator.dismiss$navigation_compose_release(this.$backStackEntry);
    }
}
