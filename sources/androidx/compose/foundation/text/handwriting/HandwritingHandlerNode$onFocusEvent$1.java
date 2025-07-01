package androidx.compose.foundation.text.handwriting;

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
@DebugMetadata(c = "androidx.compose.foundation.text.handwriting.HandwritingHandlerNode$onFocusEvent$1", f = "HandwritingHandler.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HandwritingHandler.android.kt */
final class HandwritingHandlerNode$onFocusEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HandwritingHandlerNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandwritingHandlerNode$onFocusEvent$1(HandwritingHandlerNode handwritingHandlerNode, Continuation<? super HandwritingHandlerNode$onFocusEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = handwritingHandlerNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HandwritingHandlerNode$onFocusEvent$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HandwritingHandlerNode$onFocusEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getComposeImm().acceptStylusHandwritingDelegation();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
