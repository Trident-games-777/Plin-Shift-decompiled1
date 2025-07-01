package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", f = "AnchoredDraggable.kt", i = {}, l = {275, 277}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $velocity;
    Object L$0;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableNode$onDragStopped$1(AnchoredDraggableNode<T> anchoredDraggableNode, long j, Continuation<? super AnchoredDraggableNode$onDragStopped$1> continuation) {
        super(2, continuation);
        this.this$0 = anchoredDraggableNode;
        this.$velocity = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnchoredDraggableNode$onDragStopped$1(this.this$0, this.$velocity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableNode$onDragStopped$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007d, code lost:
        if (r8.m344applyToFlingBMRW4eQ(r3, new androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1.AnonymousClass1((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1.AnonymousClass1>) null), r7) == r0) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0080
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001a:
            java.lang.Object r0 = r7.L$0
            androidx.compose.foundation.gestures.AnchoredDraggableNode r0 = (androidx.compose.foundation.gestures.AnchoredDraggableNode) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004f
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r8 = r7.this$0
            androidx.compose.foundation.OverscrollEffect r8 = r8.overscrollEffect
            if (r8 != 0) goto L_0x0059
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r8 = r7.this$0
            androidx.compose.foundation.gestures.AnchoredDraggableState r1 = r8.state
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r2 = r7.this$0
            long r4 = r7.$velocity
            long r4 = r2.m413reverseIfNeededAH228Gc(r4)
            float r2 = r2.m415toFloatTH1AsA0(r4)
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r7.L$0 = r8
            r7.label = r3
            java.lang.Object r1 = r1.settle(r2, r4)
            if (r1 != r0) goto L_0x004d
            goto L_0x007f
        L_0x004d:
            r0 = r8
            r8 = r1
        L_0x004f:
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            long unused = r0.m418toVelocityadjELrA(r8)
            goto L_0x0080
        L_0x0059:
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r8 = r7.this$0
            androidx.compose.foundation.OverscrollEffect r8 = r8.overscrollEffect
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r1 = r7.this$0
            long r3 = r7.$velocity
            long r3 = r1.m413reverseIfNeededAH228Gc(r3)
            androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1 r1 = new androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r5 = r7.this$0
            r6 = 0
            r1.<init>(r5, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.label = r2
            java.lang.Object r8 = r8.m344applyToFlingBMRW4eQ(r3, r1, r5)
            if (r8 != r0) goto L_0x0080
        L_0x007f:
            return r0
        L_0x0080:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
