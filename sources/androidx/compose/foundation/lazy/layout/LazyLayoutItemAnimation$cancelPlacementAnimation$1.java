package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$cancelPlacementAnimation$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LazyLayoutItemAnimation.kt */
final class LazyLayoutItemAnimation$cancelPlacementAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemAnimation$cancelPlacementAnimation$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, Continuation<? super LazyLayoutItemAnimation$cancelPlacementAnimation$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutItemAnimation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$cancelPlacementAnimation$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutItemAnimation$cancelPlacementAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.placementDeltaAnimation.snapTo(IntOffset.m7232boximpl(IntOffset.Companion.m7251getZeronOccac()), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.m974setPlacementDeltagyyYBs(IntOffset.Companion.m7251getZeronOccac());
        this.this$0.setPlacementAnimationInProgress(false);
        return Unit.INSTANCE;
    }
}
