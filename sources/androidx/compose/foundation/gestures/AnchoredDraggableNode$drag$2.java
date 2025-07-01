package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", f = "AnchoredDraggable.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableNode$drag$2 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableNode$drag$2(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super AnchoredDraggableNode$drag$2> continuation) {
        super(3, continuation);
        this.$forEachDelta = function2;
        this.this$0 = anchoredDraggableNode;
    }

    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
        AnchoredDraggableNode$drag$2 anchoredDraggableNode$drag$2 = new AnchoredDraggableNode$drag$2(this.$forEachDelta, this.this$0, continuation);
        anchoredDraggableNode$drag$2.L$0 = anchoredDragScope;
        return anchoredDraggableNode$drag$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
            Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> function2 = this.$forEachDelta;
            final AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
            AnonymousClass1 r3 = new Function1<DragEvent.DragDelta, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((DragEvent.DragDelta) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(DragEvent.DragDelta dragDelta) {
                    if (anchoredDraggableNode.overscrollEffect == null) {
                        AnchoredDragScope anchoredDragScope = anchoredDragScope;
                        AnchoredDraggableState access$getState$p = anchoredDraggableNode.state;
                        AnchoredDraggableNode<T> anchoredDraggableNode = anchoredDraggableNode;
                        AnchoredDragScope.dragTo$default(anchoredDragScope, access$getState$p.newOffsetForDelta$foundation_release(anchoredDraggableNode.m416toFloatk4lQ0M(anchoredDraggableNode.m414reverseIfNeededMKHz9U(dragDelta.m436getDeltaF1C5BW0()))), 0.0f, 2, (Object) null);
                        return;
                    }
                    OverscrollEffect access$getOverscrollEffect$p = anchoredDraggableNode.overscrollEffect;
                    Intrinsics.checkNotNull(access$getOverscrollEffect$p);
                    long r1 = anchoredDraggableNode.m414reverseIfNeededMKHz9U(dragDelta.m436getDeltaF1C5BW0());
                    int r7 = NestedScrollSource.Companion.m5481getUserInputWNlRxjI();
                    final AnchoredDraggableNode<T> anchoredDraggableNode2 = anchoredDraggableNode;
                    final AnchoredDragScope anchoredDragScope2 = anchoredDragScope;
                    access$getOverscrollEffect$p.m345applyToScrollRhakbz0(r1, r7, new Function1<Offset, Offset>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return Offset.m3976boximpl(m421invokeMKHz9U(((Offset) obj).m3997unboximpl()));
                        }

                        /* renamed from: invoke-MK-Hz9U  reason: not valid java name */
                        public final long m421invokeMKHz9U(long j) {
                            float newOffsetForDelta$foundation_release = anchoredDraggableNode2.state.newOffsetForDelta$foundation_release(anchoredDraggableNode2.m416toFloatk4lQ0M(j));
                            AnchoredDraggableNode<T> anchoredDraggableNode = anchoredDraggableNode2;
                            long r0 = anchoredDraggableNode.m417toOffsettuRUvjQ(newOffsetForDelta$foundation_release - anchoredDraggableNode.state.requireOffset());
                            AnchoredDragScope.dragTo$default(anchoredDragScope2, newOffsetForDelta$foundation_release, 0.0f, 2, (Object) null);
                            return r0;
                        }
                    });
                }
            };
            this.label = 1;
            if (function2.invoke(r3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
