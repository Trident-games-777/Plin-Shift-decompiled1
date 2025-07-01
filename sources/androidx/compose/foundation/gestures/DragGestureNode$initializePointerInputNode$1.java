package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1", f = "Draggable.kt", i = {}, l = {524}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Draggable.kt */
final class DragGestureNode$initializePointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureNode$initializePointerInputNode$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$initializePointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureNode$initializePointerInputNode$1 dragGestureNode$initializePointerInputNode$1 = new DragGestureNode$initializePointerInputNode$1(this.this$0, continuation);
        dragGestureNode$initializePointerInputNode$1.L$0 = obj;
        return dragGestureNode$initializePointerInputNode$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DragGestureNode$initializePointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            VelocityTracker velocityTracker = new VelocityTracker();
            final Function3 dragGestureNode$initializePointerInputNode$1$onDragStart$1 = new DragGestureNode$initializePointerInputNode$1$onDragStart$1(this.this$0, velocityTracker);
            final Function1 dragGestureNode$initializePointerInputNode$1$onDragEnd$1 = new DragGestureNode$initializePointerInputNode$1$onDragEnd$1(velocityTracker, this.this$0);
            final Function0 dragGestureNode$initializePointerInputNode$1$onDragCancel$1 = new DragGestureNode$initializePointerInputNode$1$onDragCancel$1(this.this$0);
            final Function0 dragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1 = new DragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1(this.this$0);
            final Function2 dragGestureNode$initializePointerInputNode$1$onDrag$1 = new DragGestureNode$initializePointerInputNode$1$onDrag$1(velocityTracker, this.this$0);
            final DragGestureNode dragGestureNode = this.this$0;
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {526}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1  reason: invalid class name */
    /* compiled from: Draggable.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(dragGestureNode, pointerInputScope, dragGestureNode$initializePointerInputNode$1$onDragStart$1, dragGestureNode$initializePointerInputNode$1$onDragEnd$1, dragGestureNode$initializePointerInputNode$1$onDragCancel$1, dragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1, dragGestureNode$initializePointerInputNode$1$onDrag$1, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 != r2) goto L_0x0014
                java.lang.Object r0 = r11.L$0
                r1 = r0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x0044 }
                goto L_0x005d
            L_0x0014:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001c:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                r1 = r12
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                androidx.compose.foundation.gestures.DragGestureNode r12 = r4     // Catch:{ CancellationException -> 0x0044 }
                androidx.compose.foundation.gestures.Orientation r8 = r12.orientationLock     // Catch:{ CancellationException -> 0x0044 }
                androidx.compose.ui.input.pointer.PointerInputScope r3 = r5     // Catch:{ CancellationException -> 0x0044 }
                kotlin.jvm.functions.Function3<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r6     // Catch:{ CancellationException -> 0x0044 }
                kotlin.jvm.functions.Function1<androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r5 = r7     // Catch:{ CancellationException -> 0x0044 }
                kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r8     // Catch:{ CancellationException -> 0x0044 }
                kotlin.jvm.functions.Function0<java.lang.Boolean> r7 = r9     // Catch:{ CancellationException -> 0x0044 }
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r9 = r10     // Catch:{ CancellationException -> 0x0044 }
                r10 = r11
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ CancellationException -> 0x0044 }
                r11.L$0 = r1     // Catch:{ CancellationException -> 0x0044 }
                r11.label = r2     // Catch:{ CancellationException -> 0x0044 }
                java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ CancellationException -> 0x0044 }
                if (r12 != r0) goto L_0x005d
                return r0
            L_0x0044:
                r0 = move-exception
                r12 = r0
                androidx.compose.foundation.gestures.DragGestureNode r0 = r4
                kotlinx.coroutines.channels.Channel r0 = r0.channel
                if (r0 == 0) goto L_0x0057
                androidx.compose.foundation.gestures.DragEvent$DragCancelled r2 = androidx.compose.foundation.gestures.DragEvent.DragCancelled.INSTANCE
                java.lang.Object r0 = r0.m9382trySendJP2dKIU(r2)
                kotlinx.coroutines.channels.ChannelResult.m9357boximpl(r0)
            L_0x0057:
                boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r0 == 0) goto L_0x0060
            L_0x005d:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            L_0x0060:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
