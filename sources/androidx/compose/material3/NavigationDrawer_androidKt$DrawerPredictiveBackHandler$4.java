package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.android.kt */
final class NavigationDrawer_androidKt$DrawerPredictiveBackHandler$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function3<DrawerPredictiveBackState, Composer, Integer, Unit> $content;
    final /* synthetic */ DrawerState $drawerState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawer_androidKt$DrawerPredictiveBackHandler$4(DrawerState drawerState, Function3<? super DrawerPredictiveBackState, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$drawerState = drawerState;
        this.$content = function3;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NavigationDrawer_androidKt.DrawerPredictiveBackHandler(this.$drawerState, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
