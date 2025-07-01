package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H@"}, d2 = {"<anonymous>", "", "S"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3", f = "Transition.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Transition.kt */
final class SeekableTransitionState$seekTo$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ float $fraction;
    final /* synthetic */ S $oldTargetState;
    final /* synthetic */ S $targetState;
    final /* synthetic */ Transition<S> $transition;
    int label;
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$seekTo$3(S s, S s2, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, Continuation<? super SeekableTransitionState$seekTo$3> continuation) {
        super(1, continuation);
        this.$targetState = s;
        this.$oldTargetState = s2;
        this.this$0 = seekableTransitionState;
        this.$transition = transition;
        this.$fraction = f;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SeekableTransitionState$seekTo$3(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SeekableTransitionState$seekTo$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1", f = "Transition.kt", i = {}, l = {531}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1  reason: invalid class name */
    /* compiled from: Transition.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(s, s2, seekableTransitionState, transition, f, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                if (!Intrinsics.areEqual((Object) s, (Object) s2)) {
                    seekableTransitionState.moveAnimationToInitialState();
                } else {
                    seekableTransitionState.currentAnimation = null;
                    if (Intrinsics.areEqual((Object) seekableTransitionState.getCurrentState(), (Object) s)) {
                        return Unit.INSTANCE;
                    }
                }
                if (!Intrinsics.areEqual((Object) s, (Object) s2)) {
                    transition.updateTarget$animation_core_release(s);
                    transition.setPlayTimeNanos(0);
                    seekableTransitionState.setTargetState$animation_core_release(s);
                    transition.resetAnimationFraction$animation_core_release(f);
                }
                seekableTransitionState.setFraction(f);
                if (seekableTransitionState.initialValueAnimations.isNotEmpty()) {
                    final SeekableTransitionState<S> seekableTransitionState = seekableTransitionState;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                        int label;

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return 

                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    final S s = this.$targetState;
                                    final S s2 = this.$oldTargetState;
                                    final SeekableTransitionState<S> seekableTransitionState = this.this$0;
                                    final Transition<S> transition = this.$transition;
                                    final float f = this.$fraction;
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
                        }
