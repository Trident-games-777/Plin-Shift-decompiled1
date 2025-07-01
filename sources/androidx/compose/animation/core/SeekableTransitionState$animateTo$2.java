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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H@"}, d2 = {"<anonymous>", "", "S"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", f = "Transition.kt", i = {}, l = {623}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Transition.kt */
final class SeekableTransitionState$animateTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
    final /* synthetic */ S $targetState;
    final /* synthetic */ Transition<S> $transition;
    int label;
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$animateTo$2(Transition<S> transition, SeekableTransitionState<S> seekableTransitionState, S s, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super SeekableTransitionState$animateTo$2> continuation) {
        super(1, continuation);
        this.$transition = transition;
        this.this$0 = seekableTransitionState;
        this.$targetState = s;
        this.$animationSpec = finiteAnimationSpec;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SeekableTransitionState$animateTo$2(this.$transition, this.this$0, this.$targetState, this.$animationSpec, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SeekableTransitionState$animateTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", f = "Transition.kt", i = {0}, l = {2191, 636, 638, 690, 692}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1  reason: invalid class name */
    /* compiled from: Transition.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(seekableTransitionState, s, transition, finiteAnimationSpec, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b1, code lost:
            if (androidx.compose.animation.core.SeekableTransitionState.access$doOneFrame(r4, r1) == r0) goto L_0x020b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c0, code lost:
            if (androidx.compose.animation.core.SeekableTransitionState.access$waitForCompositionAfterTargetStateChange(r4, r1) == r0) goto L_0x020b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x01f4, code lost:
            if (androidx.compose.animation.core.SeekableTransitionState.access$runAnimations(r4, r1) == r0) goto L_0x020b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0209, code lost:
            if (androidx.compose.animation.core.SeekableTransitionState.access$waitForComposition(r4, r1) == r0) goto L_0x020b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00d2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r1 = r18
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r1.label
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                r8 = 0
                r10 = 0
                r11 = 0
                if (r2 == 0) goto L_0x0045
                if (r2 == r7) goto L_0x0039
                if (r2 == r6) goto L_0x0034
                if (r2 == r5) goto L_0x002f
                if (r2 == r4) goto L_0x002a
                if (r2 != r3) goto L_0x0022
                kotlin.ResultKt.throwOnFailure(r19)
                goto L_0x020c
            L_0x0022:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x002a:
                kotlin.ResultKt.throwOnFailure(r19)
                goto L_0x01f7
            L_0x002f:
                kotlin.ResultKt.throwOnFailure(r19)
                goto L_0x00c4
            L_0x0034:
                kotlin.ResultKt.throwOnFailure(r19)
                goto L_0x00b5
            L_0x0039:
                java.lang.Object r2 = r1.L$1
                androidx.compose.animation.core.SeekableTransitionState r2 = (androidx.compose.animation.core.SeekableTransitionState) r2
                java.lang.Object r7 = r1.L$0
                kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
                kotlin.ResultKt.throwOnFailure(r19)
                goto L_0x0093
            L_0x0045:
                kotlin.ResultKt.throwOnFailure(r19)
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                java.lang.Object r2 = r2.getTargetState()
                S r12 = r5
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r2)
                if (r12 != 0) goto L_0x0078
                androidx.compose.animation.core.SeekableTransitionState<S> r12 = r4
                r12.moveAnimationToInitialState()
                androidx.compose.animation.core.SeekableTransitionState<S> r12 = r4
                r12.setFraction(r10)
                androidx.compose.animation.core.Transition<S> r12 = r6
                S r13 = r5
                r12.updateTarget$animation_core_release(r13)
                androidx.compose.animation.core.Transition<S> r12 = r6
                r12.setPlayTimeNanos(r8)
                androidx.compose.animation.core.SeekableTransitionState<S> r12 = r4
                r12.setCurrentState$animation_core_release(r2)
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                S r12 = r5
                r2.setTargetState$animation_core_release(r12)
            L_0x0078:
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                kotlinx.coroutines.sync.Mutex r2 = r2.getCompositionContinuationMutex$animation_core_release()
                androidx.compose.animation.core.SeekableTransitionState<S> r12 = r4
                r13 = r1
                kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
                r1.L$0 = r2
                r1.L$1 = r12
                r1.label = r7
                java.lang.Object r7 = r2.lock(r11, r13)
                if (r7 != r0) goto L_0x0091
                goto L_0x020b
            L_0x0091:
                r7 = r2
                r2 = r12
            L_0x0093:
                java.lang.Object r2 = r2.getComposedTargetState$animation_core_release()     // Catch:{ all -> 0x0214 }
                r7.unlock(r11)
                S r7 = r5
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r2)
                if (r2 != 0) goto L_0x00c4
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                r7 = r1
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r1.L$0 = r11
                r1.L$1 = r11
                r1.label = r6
                java.lang.Object r2 = r2.doOneFrame(r7)
                if (r2 != r0) goto L_0x00b5
                goto L_0x020b
            L_0x00b5:
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r1.label = r5
                java.lang.Object r2 = r2.waitForCompositionAfterTargetStateChange(r6)
                if (r2 != r0) goto L_0x00c4
                goto L_0x020b
            L_0x00c4:
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                java.lang.Object r2 = r2.getCurrentState()
                S r5 = r5
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
                if (r2 != 0) goto L_0x0211
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                float r2 = r2.getFraction()
                r5 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 >= 0) goto L_0x01e5
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r2 = r2.currentAnimation
                androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r6 = r7
                if (r6 == 0) goto L_0x00f3
                kotlin.jvm.internal.FloatCompanionObject r7 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
                androidx.compose.animation.core.TwoWayConverter r7 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r7)
                androidx.compose.animation.core.VectorizedFiniteAnimationSpec r6 = r6.vectorize(r7)
                goto L_0x00f4
            L_0x00f3:
                r6 = r11
            L_0x00f4:
                if (r2 == 0) goto L_0x0100
                androidx.compose.animation.core.VectorizedAnimationSpec r7 = r2.getAnimationSpec()
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
                if (r7 != 0) goto L_0x01e5
            L_0x0100:
                if (r2 == 0) goto L_0x0108
                androidx.compose.animation.core.VectorizedAnimationSpec r7 = r2.getAnimationSpec()
                r12 = r7
                goto L_0x0109
            L_0x0108:
                r12 = r11
            L_0x0109:
                if (r12 == 0) goto L_0x013b
                long r13 = r2.getProgressNanos()
                androidx.compose.animation.core.AnimationVector1D r5 = r2.getStart()
                r15 = r5
                androidx.compose.animation.core.AnimationVector r15 = (androidx.compose.animation.core.AnimationVector) r15
                androidx.compose.animation.core.SeekableTransitionState$Companion r5 = androidx.compose.animation.core.SeekableTransitionState.Companion
                androidx.compose.animation.core.AnimationVector1D r5 = r5.getTarget1()
                r16 = r5
                androidx.compose.animation.core.AnimationVector r16 = (androidx.compose.animation.core.AnimationVector) r16
                androidx.compose.animation.core.AnimationVector1D r5 = r2.getInitialVelocity()
                if (r5 != 0) goto L_0x0130
                androidx.compose.animation.core.SeekableTransitionState$Companion r5 = androidx.compose.animation.core.SeekableTransitionState.Companion
                androidx.compose.animation.core.AnimationVector1D r5 = r5.getZeroVelocity()
            L_0x0130:
                r17 = r5
                androidx.compose.animation.core.AnimationVector r17 = (androidx.compose.animation.core.AnimationVector) r17
                androidx.compose.animation.core.AnimationVector r5 = r12.getVelocityFromNanos(r13, r15, r16, r17)
                androidx.compose.animation.core.AnimationVector1D r5 = (androidx.compose.animation.core.AnimationVector1D) r5
                goto L_0x0178
            L_0x013b:
                if (r2 == 0) goto L_0x0170
                long r12 = r2.getProgressNanos()
                int r7 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
                if (r7 != 0) goto L_0x0146
                goto L_0x0170
            L_0x0146:
                long r12 = r2.getDurationNanos()
                r14 = -9223372036854775808
                int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r7 != 0) goto L_0x0156
                androidx.compose.animation.core.SeekableTransitionState<S> r7 = r4
                long r12 = r7.getTotalDurationNanos$animation_core_release()
            L_0x0156:
                float r7 = (float) r12
                r12 = 1315859240(0x4e6e6b28, float:1.0E9)
                float r7 = r7 / r12
                int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
                if (r12 > 0) goto L_0x0168
                androidx.compose.animation.core.SeekableTransitionState$Companion r5 = androidx.compose.animation.core.SeekableTransitionState.Companion
                androidx.compose.animation.core.AnimationVector1D r5 = r5.getZeroVelocity()
                goto L_0x0178
            L_0x0168:
                androidx.compose.animation.core.AnimationVector1D r12 = new androidx.compose.animation.core.AnimationVector1D
                float r5 = r5 / r7
                r12.<init>(r5)
                r5 = r12
                goto L_0x0178
            L_0x0170:
                androidx.compose.animation.core.SeekableTransitionState$Companion r5 = androidx.compose.animation.core.SeekableTransitionState.Companion
                androidx.compose.animation.core.AnimationVector1D r5 = r5.getZeroVelocity()
            L_0x0178:
                if (r2 != 0) goto L_0x017f
                androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r2 = new androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState
                r2.<init>()
            L_0x017f:
                r7 = r6
                androidx.compose.animation.core.VectorizedAnimationSpec r7 = (androidx.compose.animation.core.VectorizedAnimationSpec) r7
                r2.setAnimationSpec(r7)
                r7 = 0
                r2.setComplete(r7)
                androidx.compose.animation.core.SeekableTransitionState<S> r12 = r4
                float r12 = r12.getFraction()
                r2.setValue(r12)
                androidx.compose.animation.core.AnimationVector1D r12 = r2.getStart()
                androidx.compose.animation.core.SeekableTransitionState<S> r13 = r4
                float r13 = r13.getFraction()
                r12.set$animation_core_release(r7, r13)
                androidx.compose.animation.core.SeekableTransitionState<S> r7 = r4
                long r12 = r7.getTotalDurationNanos$animation_core_release()
                r2.setDurationNanos(r12)
                r2.setProgressNanos(r8)
                r2.setInitialVelocity(r5)
                if (r6 == 0) goto L_0x01c7
                androidx.compose.animation.core.AnimationVector1D r7 = r2.getStart()
                androidx.compose.animation.core.AnimationVector r7 = (androidx.compose.animation.core.AnimationVector) r7
                androidx.compose.animation.core.SeekableTransitionState$Companion r8 = androidx.compose.animation.core.SeekableTransitionState.Companion
                androidx.compose.animation.core.AnimationVector1D r8 = r8.getTarget1()
                androidx.compose.animation.core.AnimationVector r8 = (androidx.compose.animation.core.AnimationVector) r8
                androidx.compose.animation.core.AnimationVector r5 = (androidx.compose.animation.core.AnimationVector) r5
                long r5 = r6.getDurationNanos(r7, r8, r5)
                goto L_0x01dd
            L_0x01c7:
                androidx.compose.animation.core.SeekableTransitionState<S> r5 = r4
                long r5 = r5.getTotalDurationNanos$animation_core_release()
                double r5 = (double) r5
                androidx.compose.animation.core.SeekableTransitionState<S> r7 = r4
                float r7 = r7.getFraction()
                double r7 = (double) r7
                r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                double r12 = r12 - r7
                double r5 = r5 * r12
                long r5 = kotlin.math.MathKt.roundToLong((double) r5)
            L_0x01dd:
                r2.setAnimationSpecDuration(r5)
                androidx.compose.animation.core.SeekableTransitionState<S> r5 = r4
                r5.currentAnimation = r2
            L_0x01e5:
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r1.L$0 = r11
                r1.L$1 = r11
                r1.label = r4
                java.lang.Object r2 = r2.runAnimations(r5)
                if (r2 != r0) goto L_0x01f7
                goto L_0x020b
            L_0x01f7:
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                S r4 = r5
                r2.setCurrentState$animation_core_release(r4)
                androidx.compose.animation.core.SeekableTransitionState<S> r2 = r4
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r1.label = r3
                java.lang.Object r2 = r2.waitForComposition(r4)
                if (r2 != r0) goto L_0x020c
            L_0x020b:
                return r0
            L_0x020c:
                androidx.compose.animation.core.SeekableTransitionState<S> r0 = r4
                r0.setFraction(r10)
            L_0x0211:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x0214:
                r0 = move-exception
                r7.unlock(r11)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState$animateTo$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final SeekableTransitionState<S> seekableTransitionState = this.this$0;
            final S s = this.$targetState;
            final Transition<S> transition = this.$transition;
            final FiniteAnimationSpec<Float> finiteAnimationSpec = this.$animationSpec;
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$transition.onTransitionEnd$animation_core_release();
        return Unit.INSTANCE;
    }
}
