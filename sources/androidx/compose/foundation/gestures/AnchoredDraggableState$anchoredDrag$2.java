package androidx.compose.foundation.gestures;

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

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H@"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2", f = "AnchoredDraggable.kt", i = {}, l = {835}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableState$anchoredDrag$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
    int label;
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableState$anchoredDrag$2(AnchoredDraggableState<T> anchoredDraggableState, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnchoredDraggableState$anchoredDrag$2> continuation) {
        super(1, continuation);
        this.this$0 = anchoredDraggableState;
        this.$block = function3;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AnchoredDraggableState$anchoredDrag$2(this.this$0, this.$block, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableState$anchoredDrag$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "latestAnchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2", f = "AnchoredDraggable.kt", i = {}, l = {836}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2  reason: invalid class name */
    /* compiled from: AnchoredDraggable.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(function3, anchoredDraggableState2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(draggableAnchors, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> function3 = function3;
                AnchoredDraggableState$anchoredDragScope$1 access$getAnchoredDragScope$p = anchoredDraggableState2.anchoredDragScope;
                this.label = 1;
                if (function3.invoke(access$getAnchoredDragScope$p, (DraggableAnchors) this.L$0, this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
            final Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> function3 = this.$block;
            final AnchoredDraggableState<T> anchoredDraggableState2 = this.this$0;
            this.label = 1;
            if (AnchoredDraggableKt.restartable(new Function0<DraggableAnchors<T>>() {
                public final DraggableAnchors<T> invoke() {
                    return anchoredDraggableState.getAnchors();
                }
            }, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        T closestAnchor = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset());
        if (closestAnchor != null) {
            if (Math.abs(this.this$0.getOffset() - this.this$0.getAnchors().positionOf(closestAnchor)) < 0.5f && this.this$0.getConfirmValueChange$foundation_release().invoke(closestAnchor).booleanValue()) {
                this.this$0.setSettledValue(closestAnchor);
                this.this$0.setCurrentValue(closestAnchor);
            }
        }
        return Unit.INSTANCE;
    }
}
