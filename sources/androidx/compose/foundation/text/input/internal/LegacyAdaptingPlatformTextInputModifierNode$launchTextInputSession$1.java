package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.platform.PlatformTextInputModifierNodeKt;
import androidx.compose.ui.platform.PlatformTextInputSession;
import kotlin.KotlinNothingValueException;
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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode$launchTextInputSession$1", f = "LegacyAdaptingPlatformTextInputModifierNode.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LegacyAdaptingPlatformTextInputModifierNode.kt */
final class LegacyAdaptingPlatformTextInputModifierNode$launchTextInputSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PlatformTextInputSession, Continuation<?>, Object> $block;
    int label;
    final /* synthetic */ LegacyAdaptingPlatformTextInputModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyAdaptingPlatformTextInputModifierNode$launchTextInputSession$1(LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode, Function2<? super PlatformTextInputSession, ? super Continuation<?>, ? extends Object> function2, Continuation<? super LegacyAdaptingPlatformTextInputModifierNode$launchTextInputSession$1> continuation) {
        super(2, continuation);
        this.this$0 = legacyAdaptingPlatformTextInputModifierNode;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LegacyAdaptingPlatformTextInputModifierNode$launchTextInputSession$1(this.this$0, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LegacyAdaptingPlatformTextInputModifierNode$launchTextInputSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (PlatformTextInputModifierNodeKt.establishTextInputSession(this.this$0, this.$block, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
