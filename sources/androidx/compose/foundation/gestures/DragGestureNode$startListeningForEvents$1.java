package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {431, 433, 435, 442, 444, 447}, m = "invokeSuspend", n = {"$this$launch", "event", "$this$launch", "event", "$this$launch", "event", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
/* compiled from: Draggable.kt */
final class DragGestureNode$startListeningForEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureNode$startListeningForEvents$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$startListeningForEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureNode$startListeningForEvents$1 dragGestureNode$startListeningForEvents$1 = new DragGestureNode$startListeningForEvents$1(this.this$0, continuation);
        dragGestureNode$startListeningForEvents$1.L$0 = obj;
        return dragGestureNode$startListeningForEvents$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DragGestureNode$startListeningForEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        if (kotlinx.coroutines.CoroutineScopeKt.isActive(r4) == false) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        r1 = new kotlin.jvm.internal.Ref.ObjectRef();
        r8 = r7.this$0.channel;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        if (r8 == null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        r7.L$0 = r4;
        r7.L$1 = r1;
        r7.L$2 = r1;
        r7.label = 1;
        r8 = r8.receive(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        if (r8 != r0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
        r8 = (androidx.compose.foundation.gestures.DragEvent) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008a, code lost:
        r3 = r1;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        r1.element = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        if ((r3.element instanceof androidx.compose.foundation.gestures.DragEvent.DragStarted) == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0094, code lost:
        r7.L$0 = r4;
        r7.L$1 = r3;
        r7.L$2 = null;
        r7.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00aa, code lost:
        if (r7.this$0.processDragStart((androidx.compose.foundation.gestures.DragEvent.DragStarted) r3.element, r7) != r0) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ae, code lost:
        r1 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r8 = r7.this$0;
        r5 = r7.this$0;
        r7.L$0 = r3;
        r7.L$1 = r1;
        r7.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c9, code lost:
        if (r8.drag(new androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1.AnonymousClass1((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1.AnonymousClass1>) null), r7) != r0) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d0, code lost:
        if ((r1.element instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped) == false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d2, code lost:
        r8 = r7.this$0;
        r1 = r1.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DragEvent.DragStopped");
        r7.L$0 = r4;
        r7.L$1 = null;
        r7.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00eb, code lost:
        if (r8.processDragStop((androidx.compose.foundation.gestures.DragEvent.DragStopped) r1, r7) != r0) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f2, code lost:
        if ((r1.element instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled) == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f4, code lost:
        r7.L$0 = r4;
        r7.L$1 = null;
        r7.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0104, code lost:
        if (r7.this$0.processDragCancel(r7) != r0) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0107, code lost:
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0118, code lost:
        if (r7.this$0.processDragCancel(r7) == r0) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011d, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        kotlin.ResultKt.throwOnFailure(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        r4 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(T r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0057;
                case 1: goto L_0x0047;
                case 2: goto L_0x003a;
                case 3: goto L_0x0029;
                case 4: goto L_0x0022;
                case 5: goto L_0x001a;
                case 6: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0012:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0027
        L_0x001a:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ CancellationException -> 0x0108 }
            goto L_0x0027
        L_0x0022:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            goto L_0x001e
        L_0x0027:
            r4 = r1
            goto L_0x005f
        L_0x0029:
            java.lang.Object r1 = r7.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r3 = r7.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ CancellationException -> 0x0037 }
        L_0x0034:
            r4 = r3
            goto L_0x00cc
        L_0x0037:
            r1 = r3
            goto L_0x0108
        L_0x003a:
            java.lang.Object r1 = r7.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r3 = r7.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00b0
        L_0x0047:
            java.lang.Object r1 = r7.L$2
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r3 = r7.L$1
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0087
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            r4 = r8
        L_0x005f:
            boolean r8 = kotlinx.coroutines.CoroutineScopeKt.isActive(r4)
            if (r8 == 0) goto L_0x011b
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            androidx.compose.foundation.gestures.DragGestureNode r8 = r7.this$0
            kotlinx.coroutines.channels.Channel r8 = r8.channel
            if (r8 == 0) goto L_0x008a
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.L$0 = r4
            r7.L$1 = r1
            r7.L$2 = r1
            r5 = 1
            r7.label = r5
            java.lang.Object r8 = r8.receive(r3)
            if (r8 != r0) goto L_0x0086
            goto L_0x011a
        L_0x0086:
            r3 = r1
        L_0x0087:
            androidx.compose.foundation.gestures.DragEvent r8 = (androidx.compose.foundation.gestures.DragEvent) r8
            goto L_0x008c
        L_0x008a:
            r3 = r1
            r8 = r2
        L_0x008c:
            r1.element = r8
            T r8 = r3.element
            boolean r8 = r8 instanceof androidx.compose.foundation.gestures.DragEvent.DragStarted
            if (r8 == 0) goto L_0x005f
            androidx.compose.foundation.gestures.DragGestureNode r8 = r7.this$0
            T r1 = r3.element
            androidx.compose.foundation.gestures.DragEvent$DragStarted r1 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r1
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.L$0 = r4
            r7.L$1 = r3
            r7.L$2 = r2
            r6 = 2
            r7.label = r6
            java.lang.Object r8 = r8.processDragStart(r1, r5)
            if (r8 != r0) goto L_0x00ae
            goto L_0x011a
        L_0x00ae:
            r1 = r3
            r3 = r4
        L_0x00b0:
            androidx.compose.foundation.gestures.DragGestureNode r8 = r7.this$0     // Catch:{ CancellationException -> 0x0037 }
            androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1 r4 = new androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1     // Catch:{ CancellationException -> 0x0037 }
            androidx.compose.foundation.gestures.DragGestureNode r5 = r7.this$0     // Catch:{ CancellationException -> 0x0037 }
            r4.<init>(r1, r5, r2)     // Catch:{ CancellationException -> 0x0037 }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ CancellationException -> 0x0037 }
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ CancellationException -> 0x0037 }
            r7.L$0 = r3     // Catch:{ CancellationException -> 0x0037 }
            r7.L$1 = r1     // Catch:{ CancellationException -> 0x0037 }
            r6 = 3
            r7.label = r6     // Catch:{ CancellationException -> 0x0037 }
            java.lang.Object r8 = r8.drag(r4, r5)     // Catch:{ CancellationException -> 0x0037 }
            if (r8 != r0) goto L_0x0034
            goto L_0x011a
        L_0x00cc:
            T r8 = r1.element     // Catch:{ CancellationException -> 0x0107 }
            boolean r8 = r8 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped     // Catch:{ CancellationException -> 0x0107 }
            if (r8 == 0) goto L_0x00ee
            androidx.compose.foundation.gestures.DragGestureNode r8 = r7.this$0     // Catch:{ CancellationException -> 0x0107 }
            T r1 = r1.element     // Catch:{ CancellationException -> 0x0107 }
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.foundation.gestures.DragEvent.DragStopped"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r3)     // Catch:{ CancellationException -> 0x0107 }
            androidx.compose.foundation.gestures.DragEvent$DragStopped r1 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r1     // Catch:{ CancellationException -> 0x0107 }
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ CancellationException -> 0x0107 }
            r7.L$0 = r4     // Catch:{ CancellationException -> 0x0107 }
            r7.L$1 = r2     // Catch:{ CancellationException -> 0x0107 }
            r5 = 4
            r7.label = r5     // Catch:{ CancellationException -> 0x0107 }
            java.lang.Object r8 = r8.processDragStop(r1, r3)     // Catch:{ CancellationException -> 0x0107 }
            if (r8 != r0) goto L_0x005f
            goto L_0x011a
        L_0x00ee:
            T r8 = r1.element     // Catch:{ CancellationException -> 0x0107 }
            boolean r8 = r8 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled     // Catch:{ CancellationException -> 0x0107 }
            if (r8 == 0) goto L_0x005f
            androidx.compose.foundation.gestures.DragGestureNode r8 = r7.this$0     // Catch:{ CancellationException -> 0x0107 }
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ CancellationException -> 0x0107 }
            r7.L$0 = r4     // Catch:{ CancellationException -> 0x0107 }
            r7.L$1 = r2     // Catch:{ CancellationException -> 0x0107 }
            r3 = 5
            r7.label = r3     // Catch:{ CancellationException -> 0x0107 }
            java.lang.Object r8 = r8.processDragCancel(r1)     // Catch:{ CancellationException -> 0x0107 }
            if (r8 != r0) goto L_0x005f
            goto L_0x011a
        L_0x0107:
            r1 = r4
        L_0x0108:
            androidx.compose.foundation.gestures.DragGestureNode r8 = r7.this$0
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.L$0 = r1
            r7.L$1 = r2
            r4 = 6
            r7.label = r4
            java.lang.Object r8 = r8.processDragCancel(r3)
            if (r8 != r0) goto L_0x0027
        L_0x011a:
            return r0
        L_0x011b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
