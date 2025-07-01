package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.DeferredTargetAnimation$updateTarget$1", f = "DeferredTargetAnimation.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeferredTargetAnimation.kt */
final class DeferredTargetAnimation$updateTarget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<T, V> $anim;
    final /* synthetic */ FiniteAnimationSpec<T> $animationSpec;
    final /* synthetic */ T $target;
    int label;
    final /* synthetic */ DeferredTargetAnimation<T, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeferredTargetAnimation$updateTarget$1(Animatable<T, V> animatable, DeferredTargetAnimation<T, V> deferredTargetAnimation, T t, FiniteAnimationSpec<T> finiteAnimationSpec, Continuation<? super DeferredTargetAnimation$updateTarget$1> continuation) {
        super(2, continuation);
        this.$anim = animatable;
        this.this$0 = deferredTargetAnimation;
        this.$target = t;
        this.$animationSpec = finiteAnimationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeferredTargetAnimation$updateTarget$1(this.$anim, this.this$0, this.$target, this.$animationSpec, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeferredTargetAnimation$updateTarget$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual((Object) this.$anim.getTargetValue(), this.this$0.get_pendingTarget())) {
                this.label = 1;
                if (Animatable.animateTo$default(this.$anim, this.$target, this.$animationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
