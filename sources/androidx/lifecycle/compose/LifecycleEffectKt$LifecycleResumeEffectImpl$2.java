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
final class LifecycleEffectKt$LifecycleResumeEffectImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function1<LifecycleResumePauseEffectScope, LifecyclePauseOrDisposeEffectResult> $effects;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ LifecycleResumePauseEffectScope $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleEffectKt$LifecycleResumeEffectImpl$2(LifecycleOwner lifecycleOwner, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, int i) {
        super(2);
        this.$lifecycleOwner = lifecycleOwner;
        this.$scope = lifecycleResumePauseEffectScope;
        this.$effects = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LifecycleEffectKt.LifecycleResumeEffectImpl(this.$lifecycleOwner, this.$scope, this.$effects, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
