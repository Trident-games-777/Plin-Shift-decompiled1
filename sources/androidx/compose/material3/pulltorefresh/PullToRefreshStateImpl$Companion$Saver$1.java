package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl;", "invoke", "(Landroidx/compose/runtime/saveable/SaverScope;Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl;)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshStateImpl$Companion$Saver$1 extends Lambda implements Function2<SaverScope, PullToRefreshStateImpl, Float> {
    public static final PullToRefreshStateImpl$Companion$Saver$1 INSTANCE = new PullToRefreshStateImpl$Companion$Saver$1();

    PullToRefreshStateImpl$Companion$Saver$1() {
        super(2);
    }

    public final Float invoke(SaverScope saverScope, PullToRefreshStateImpl pullToRefreshStateImpl) {
        return (Float) pullToRefreshStateImpl.anim.getValue();
    }
}
