package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LifecycleEffect.kt */
final class LifecycleEffectKt$LifecycleStartEffect$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<LifecycleStartStopEffectScope, LifecycleStopOrDisposeEffectResult> $effects;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleEffectKt$LifecycleStartEffect$5(LifecycleOwner lifecycleOwner, Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, int i, int i2) {
        super(2);
        this.$lifecycleOwner = lifecycleOwner;
        this.$effects = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LifecycleEffectKt.LifecycleStartEffect(this.$lifecycleOwner, this.$effects, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
