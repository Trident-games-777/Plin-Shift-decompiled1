package androidx.fragment.compose;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFragment.kt */
final class AndroidFragmentKt$AndroidFragment$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Bundle $arguments;
    final /* synthetic */ Class<T> $clazz;
    final /* synthetic */ FragmentState $fragmentState;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<T, Unit> $onUpdate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidFragmentKt$AndroidFragment$4(Class<T> cls, Modifier modifier, FragmentState fragmentState, Bundle bundle, Function1<? super T, Unit> function1, int i, int i2) {
        super(2);
        this.$clazz = cls;
        this.$modifier = modifier;
        this.$fragmentState = fragmentState;
        this.$arguments = bundle;
        this.$onUpdate = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AndroidFragmentKt.AndroidFragment(this.$clazz, this.$modifier, this.$fragmentState, this.$arguments, this.$onUpdate, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
