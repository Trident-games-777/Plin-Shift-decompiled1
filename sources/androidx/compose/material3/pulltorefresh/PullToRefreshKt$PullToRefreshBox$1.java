package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$PullToRefreshBox$1 extends Lambda implements Function3<BoxScope, Composer, Integer, Unit> {
    final /* synthetic */ boolean $isRefreshing;
    final /* synthetic */ PullToRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshKt$PullToRefreshBox$1(PullToRefreshState pullToRefreshState, boolean z) {
        super(3);
        this.$state = pullToRefreshState;
        this.$isRefreshing = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxScope boxScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C127@5723L147:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = (composer.changed((Object) boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1989171225, i2, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox.<anonymous> (PullToRefresh.kt:127)");
            }
            PullToRefreshDefaults.INSTANCE.m3003Indicator2poqoh4(this.$state, this.$isRefreshing, boxScope.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0, 0, 0.0f, composer, 1572864, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
