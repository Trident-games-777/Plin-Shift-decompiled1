package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", i = {0}, l = {406}, m = "animateToHidden", n = {"this"}, s = {"L$0"})
/* compiled from: PullToRefresh.kt */
final class PullToRefreshModifierNode$animateToHidden$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PullToRefreshModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshModifierNode$animateToHidden$1(PullToRefreshModifierNode pullToRefreshModifierNode, Continuation<? super PullToRefreshModifierNode$animateToHidden$1> continuation) {
        super(continuation);
        this.this$0 = pullToRefreshModifierNode;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.animateToHidden(this);
    }
}
