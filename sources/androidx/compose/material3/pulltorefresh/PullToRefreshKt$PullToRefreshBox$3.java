package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$PullToRefreshBox$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Alignment $contentAlignment;
    final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> $indicator;
    final /* synthetic */ boolean $isRefreshing;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onRefresh;
    final /* synthetic */ PullToRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshKt$PullToRefreshBox$3(boolean z, Function0<Unit> function0, Modifier modifier, PullToRefreshState pullToRefreshState, Alignment alignment, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32, int i, int i2) {
        super(2);
        this.$isRefreshing = z;
        this.$onRefresh = function0;
        this.$modifier = modifier;
        this.$state = pullToRefreshState;
        this.$contentAlignment = alignment;
        this.$indicator = function3;
        this.$content = function32;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PullToRefreshKt.PullToRefreshBox(this.$isRefreshing, this.$onRefresh, this.$modifier, this.$state, this.$contentAlignment, this.$indicator, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
