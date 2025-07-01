package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LifecycleEffect.kt */
final class LifecycleEffectKt$LifecycleEventEffect$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Lifecycle.Event $event;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Function0<Unit> $onEvent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleEffectKt$LifecycleEventEffect$2(Lifecycle.Event event, LifecycleOwner lifecycleOwner, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$event = event;
        this.$lifecycleOwner = lifecycleOwner;
        this.$onEvent = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LifecycleEffectKt.LifecycleEventEffect(this.$event, this.$lifecycleOwner, this.$onEvent, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
