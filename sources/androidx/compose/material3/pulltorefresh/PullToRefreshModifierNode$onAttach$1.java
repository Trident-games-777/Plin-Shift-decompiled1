package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1", f = "PullToRefresh.kt", i = {}, l = {287, 289}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PullToRefresh.kt */
final class PullToRefreshModifierNode$onAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PullToRefreshModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshModifierNode$onAttach$1(PullToRefreshModifierNode pullToRefreshModifierNode, Continuation<? super PullToRefreshModifierNode$onAttach$1> continuation) {
        super(2, continuation);
        this.this$0 = pullToRefreshModifierNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullToRefreshModifierNode$onAttach$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PullToRefreshModifierNode$onAttach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r4.this$0.getState().snapTo(1.0f, r4) == r0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if (r4.this$0.getState().snapTo(0.0f, r4) == r0) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 == r3) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004d
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = r4.this$0
            boolean r5 = r5.isRefreshing()
            if (r5 == 0) goto L_0x003a
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = r4.this$0
            androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r5.getState()
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            r2 = 1065353216(0x3f800000, float:1.0)
            java.lang.Object r5 = r5.snapTo(r2, r1)
            if (r5 != r0) goto L_0x004d
            goto L_0x004c
        L_0x003a:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = r4.this$0
            androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r5.getState()
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r2
            r2 = 0
            java.lang.Object r5 = r5.snapTo(r2, r1)
            if (r5 != r0) goto L_0x004d
        L_0x004c:
            return r0
        L_0x004d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
