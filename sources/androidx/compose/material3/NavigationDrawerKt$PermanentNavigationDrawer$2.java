package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$PermanentNavigationDrawer$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$PermanentNavigationDrawer$2(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, int i, int i2) {
        super(2);
        this.$drawerContent = function2;
        this.$modifier = modifier;
        this.$content = function22;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NavigationDrawerKt.PermanentNavigationDrawer(this.$drawerContent, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
