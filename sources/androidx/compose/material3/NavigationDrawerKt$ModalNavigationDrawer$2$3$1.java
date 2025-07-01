package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$ModalNavigationDrawer$2$3$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ MutableFloatState $minValue$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$ModalNavigationDrawer$2$3$1(float f, DrawerState drawerState, MutableFloatState mutableFloatState) {
        super(0);
        this.$maxValue = f;
        this.$drawerState = drawerState;
        this.$minValue$delegate = mutableFloatState;
    }

    public final Float invoke() {
        return Float.valueOf(NavigationDrawerKt.calculateFraction(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$5(this.$minValue$delegate), this.$maxValue, this.$drawerState.requireOffset$material3_release()));
    }
}
