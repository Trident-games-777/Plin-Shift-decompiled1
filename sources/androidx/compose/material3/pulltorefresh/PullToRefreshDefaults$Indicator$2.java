package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshDefaults$Indicator$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ boolean $isRefreshing;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ PullToRefreshState $state;
    final /* synthetic */ float $threshold;
    final /* synthetic */ PullToRefreshDefaults $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshDefaults$Indicator$2(PullToRefreshDefaults pullToRefreshDefaults, PullToRefreshState pullToRefreshState, boolean z, Modifier modifier, long j, long j2, float f, int i, int i2) {
        super(2);
        this.$tmp0_rcvr = pullToRefreshDefaults;
        this.$state = pullToRefreshState;
        this.$isRefreshing = z;
        this.$modifier = modifier;
        this.$containerColor = j;
        this.$color = j2;
        this.$threshold = f;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.m3003Indicator2poqoh4(this.$state, this.$isRefreshing, this.$modifier, this.$containerColor, this.$color, this.$threshold, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
