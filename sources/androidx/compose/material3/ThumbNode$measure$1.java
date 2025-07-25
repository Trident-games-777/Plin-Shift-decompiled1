package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.DurationBasedAnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ThumbNode$measure$1", f = "Switch.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Switch.kt */
final class ThumbNode$measure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $size;
    int label;
    final /* synthetic */ ThumbNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ThumbNode$measure$1(ThumbNode thumbNode, float f, Continuation<? super ThumbNode$measure$1> continuation) {
        super(2, continuation);
        this.this$0 = thumbNode;
        this.$size = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ThumbNode$measure$1(this.this$0, this.$size, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ThumbNode$measure$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable access$getSizeAnim$p = this.this$0.sizeAnim;
            if (access$getSizeAnim$p != null) {
                Float boxFloat = Boxing.boxFloat(this.$size);
                DurationBasedAnimationSpec access$getSnapSpec$p = this.this$0.isPressed ? SwitchKt.SnapSpec : SwitchKt.AnimationSpec;
                this.label = 1;
                obj = Animatable.animateTo$default(access$getSizeAnim$p, boxFloat, access$getSnapSpec$p, (Object) null, (Function1) null, this, 12, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimationResult animationResult = (AnimationResult) obj;
        return Unit.INSTANCE;
    }
}
