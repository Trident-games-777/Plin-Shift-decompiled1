package androidx.compose.animation.core;

import androidx.collection.MutableObjectList;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 X*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002XYB\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010<\u001a\u00020\bH@¢\u0006\u0002\u0010=J*\u0010>\u001a\u00020\b2\b\b\u0002\u00101\u001a\u00028\u00002\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010@H@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020\bH@¢\u0006\u0002\u0010=J\b\u0010C\u001a\u00020\bH\u0002J\b\u0010D\u001a\u00020\bH\u0002J\r\u0010E\u001a\u00020\bH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\bH\u0000¢\u0006\u0002\bHJ\u0018\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u0007H\u0002J\u000e\u0010L\u001a\u00020\bH@¢\u0006\u0002\u0010=J\"\u0010M\u001a\u00020\b2\b\b\u0001\u0010#\u001a\u00020!2\b\b\u0002\u00101\u001a\u00028\u0000H@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020\bH\u0002J\u0016\u0010P\u001a\u00020\b2\u0006\u00101\u001a\u00028\u0000H@¢\u0006\u0002\u0010QJ\u001b\u0010R\u001a\u00020\b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0010¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020\bH\u0010¢\u0006\u0002\bUJ\u000e\u0010V\u001a\u00020\bH@¢\u0006\u0002\u0010=J\u000e\u0010W\u001a\u00020\bH@¢\u0006\u0002\u0010=R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\u0004R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R+\u0010#\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020!8G@BX\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\b00X\u0004¢\u0006\u0002\n\u0000R+\u00101\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001f\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010\u0004R\u001a\u00105\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "(Ljava/lang/Object;)V", "animateOneFrameLambda", "Lkotlin/Function1;", "", "", "composedTargetState", "getComposedTargetState$animation_core_release", "()Ljava/lang/Object;", "setComposedTargetState$animation_core_release", "Ljava/lang/Object;", "compositionContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "getCompositionContinuation$animation_core_release", "()Lkotlinx/coroutines/CancellableContinuation;", "setCompositionContinuation$animation_core_release", "(Lkotlinx/coroutines/CancellableContinuation;)V", "compositionContinuationMutex", "Lkotlinx/coroutines/sync/Mutex;", "getCompositionContinuationMutex$animation_core_release", "()Lkotlinx/coroutines/sync/Mutex;", "currentAnimation", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "<set-?>", "currentState", "getCurrentState", "setCurrentState$animation_core_release", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "durationScale", "", "firstFrameLambda", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "initialValueAnimations", "Landroidx/collection/MutableObjectList;", "lastFrameTimeNanos", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "recalculateTotalDurationNanos", "Lkotlin/Function0;", "targetState", "getTargetState", "setTargetState$animation_core_release", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos$animation_core_release", "()J", "setTotalDurationNanos$animation_core_release", "(J)V", "transition", "Landroidx/compose/animation/core/Transition;", "animateOneFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doOneFrame", "endAllAnimations", "moveAnimationToInitialState", "observeTotalDuration", "observeTotalDuration$animation_core_release", "onTotalDurationChanged", "onTotalDurationChanged$animation_core_release", "recalculateAnimationValue", "animation", "deltaPlayTimeNanos", "runAnimations", "seekTo", "(FLjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekToFraction", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transitionConfigured", "transitionConfigured$animation_core_release", "transitionRemoved", "transitionRemoved$animation_core_release", "waitForComposition", "waitForCompositionAfterTargetStateChange", "Companion", "SeekingAnimationState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public final class SeekableTransitionState<S> extends TransitionState<S> {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AnimationVector1D Target1 = new AnimationVector1D(1.0f);
    /* access modifiers changed from: private */
    public static final AnimationVector1D ZeroVelocity = new AnimationVector1D(0.0f);
    private final Function1<Long, Unit> animateOneFrameLambda = new SeekableTransitionState$animateOneFrameLambda$1(this);
    private S composedTargetState;
    private CancellableContinuation<? super S> compositionContinuation;
    private final Mutex compositionContinuationMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    /* access modifiers changed from: private */
    public SeekingAnimationState currentAnimation;
    private final MutableState currentState$delegate;
    /* access modifiers changed from: private */
    public float durationScale;
    private final Function1<Long, Unit> firstFrameLambda = new SeekableTransitionState$firstFrameLambda$1(this);
    private final MutableFloatState fraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    /* access modifiers changed from: private */
    public final MutableObjectList<SeekingAnimationState> initialValueAnimations = new MutableObjectList<>(0, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public long lastFrameTimeNanos = Long.MIN_VALUE;
    private final MutatorMutex mutatorMutex = new MutatorMutex();
    private final Function0<Unit> recalculateTotalDurationNanos = new SeekableTransitionState$recalculateTotalDurationNanos$1(this);
    private final MutableState targetState$delegate;
    private long totalDurationNanos;
    /* access modifiers changed from: private */
    public Transition<S> transition;

    public SeekableTransitionState(S s) {
        super((DefaultConstructorMarker) null);
        this.targetState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.composedTargetState = s;
    }

    public S getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public void setTargetState$animation_core_release(S s) {
        this.targetState$delegate.setValue(s);
    }

    public S getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    public void setCurrentState$animation_core_release(S s) {
        this.currentState$delegate.setValue(s);
    }

    public final S getComposedTargetState$animation_core_release() {
        return this.composedTargetState;
    }

    public final void setComposedTargetState$animation_core_release(S s) {
        this.composedTargetState = s;
    }

    public final long getTotalDurationNanos$animation_core_release() {
        return this.totalDurationNanos;
    }

    public final void setTotalDurationNanos$animation_core_release(long j) {
        this.totalDurationNanos = j;
    }

    /* access modifiers changed from: private */
    public final void setFraction(float f) {
        this.fraction$delegate.setFloatValue(f);
    }

    public final float getFraction() {
        return this.fraction$delegate.getFloatValue();
    }

    public final CancellableContinuation<S> getCompositionContinuation$animation_core_release() {
        return this.compositionContinuation;
    }

    public final void setCompositionContinuation$animation_core_release(CancellableContinuation<? super S> cancellableContinuation) {
        this.compositionContinuation = cancellableContinuation;
    }

    public final Mutex getCompositionContinuationMutex$animation_core_release() {
        return this.compositionContinuationMutex;
    }

    /* access modifiers changed from: private */
    public final void endAllAnimations() {
        Transition<S> transition2 = this.transition;
        if (transition2 != null) {
            transition2.clearInitialAnimations$animation_core_release();
        }
        this.initialValueAnimations.clear();
        if (this.currentAnimation != null) {
            this.currentAnimation = null;
            setFraction(1.0f);
            seekToFraction();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runAnimations(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.compose.animation.core.SeekableTransitionState$runAnimations$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 r0 = (androidx.compose.animation.core.SeekableTransitionState$runAnimations$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$runAnimations$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = -9223372036854775808
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            goto L_0x0034
        L_0x002c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0034:
            java.lang.Object r2 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r2 = (androidx.compose.animation.core.SeekableTransitionState) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0077
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.collection.MutableObjectList<androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState> r10 = r9.initialValueAnimations
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x004e
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r10 = r9.currentAnimation
            if (r10 != 0) goto L_0x004e
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x004e:
            kotlin.coroutines.CoroutineContext r10 = r0.getContext()
            float r10 = androidx.compose.animation.core.SuspendAnimationKt.getDurationScale(r10)
            r2 = 0
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 != 0) goto L_0x0063
            r9.endAllAnimations()
            r9.lastFrameTimeNanos = r5
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0063:
            long r7 = r9.lastFrameTimeNanos
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x0076
            kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit> r10 = r9.firstFrameLambda
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r10 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r10, r0)
            if (r10 != r1) goto L_0x0076
            goto L_0x0093
        L_0x0076:
            r2 = r9
        L_0x0077:
            androidx.collection.MutableObjectList<androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState> r10 = r2.initialValueAnimations
            boolean r10 = r10.isNotEmpty()
            if (r10 != 0) goto L_0x0089
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r10 = r2.currentAnimation
            if (r10 == 0) goto L_0x0084
            goto L_0x0089
        L_0x0084:
            r2.lastFrameTimeNanos = r5
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0089:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r10 = r2.animateOneFrame(r0)
            if (r10 != r1) goto L_0x0077
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.runAnimations(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object doOneFrame(Continuation<? super Unit> continuation) {
        if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
            Object withFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, continuation);
            return withFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withFrameNanos : Unit.INSTANCE;
        }
        Object animateOneFrame = animateOneFrame(continuation);
        return animateOneFrame == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateOneFrame : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object animateOneFrame(Continuation<? super Unit> continuation) {
        float durationScale2 = SuspendAnimationKt.getDurationScale(continuation.getContext());
        if (durationScale2 <= 0.0f) {
            endAllAnimations();
            return Unit.INSTANCE;
        }
        this.durationScale = durationScale2;
        Object withFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, continuation);
        return withFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withFrameNanos : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void recalculateAnimationValue(SeekingAnimationState seekingAnimationState, long j) {
        long progressNanos = seekingAnimationState.getProgressNanos() + j;
        seekingAnimationState.setProgressNanos(progressNanos);
        long animationSpecDuration = seekingAnimationState.getAnimationSpecDuration();
        if (progressNanos >= animationSpecDuration) {
            seekingAnimationState.setValue(1.0f);
            return;
        }
        VectorizedAnimationSpec<AnimationVector1D> animationSpec = seekingAnimationState.getAnimationSpec();
        if (animationSpec != null) {
            AnimationVector start = seekingAnimationState.getStart();
            AnimationVector animationVector = Target1;
            AnimationVector1D initialVelocity = seekingAnimationState.getInitialVelocity();
            if (initialVelocity == null) {
                initialVelocity = ZeroVelocity;
            }
            seekingAnimationState.setValue(RangesKt.coerceIn(animationSpec.getValueFromNanos(progressNanos, start, animationVector, initialVelocity).get$animation_core_release(0), 0.0f, 1.0f));
            return;
        }
        seekingAnimationState.setValue(VectorConvertersKt.lerp(seekingAnimationState.getStart().get$animation_core_release(0), 1.0f, ((float) progressNanos) / ((float) animationSpecDuration)));
    }

    public final Object snapTo(S s, Continuation<? super Unit> continuation) {
        Transition<S> transition2 = this.transition;
        if (transition2 == null) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(getCurrentState(), (Object) s) && Intrinsics.areEqual(getTargetState(), (Object) s)) {
            return Unit.INSTANCE;
        }
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, (MutatePriority) null, new SeekableTransitionState$snapTo$2(this, s, transition2, (Continuation<? super SeekableTransitionState$snapTo$2>) null), continuation, 1, (Object) null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object seekTo$default(SeekableTransitionState seekableTransitionState, float f, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        return seekableTransitionState.seekTo(f, obj, continuation);
    }

    public final Object seekTo(float f, S s, Continuation<? super Unit> continuation) {
        boolean z = false;
        if (0.0f <= f && f <= 1.0f) {
            z = true;
        }
        if (!z) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + f);
        }
        Transition<S> transition2 = this.transition;
        if (transition2 == null) {
            return Unit.INSTANCE;
        }
        Object targetState = getTargetState();
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, (MutatePriority) null, new SeekableTransitionState$seekTo$3(s, targetState, this, transition2, f, (Continuation<? super SeekableTransitionState$seekTo$3>) null), continuation, 1, (Object) null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object waitForCompositionAfterTargetStateChange(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 r0 = (androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r1 = r0.L$1
            java.lang.Object r0 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r0 = (androidx.compose.animation.core.SeekableTransitionState) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00a1
        L_0x0035:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003d:
            java.lang.Object r2 = r0.L$1
            java.lang.Object r6 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r6 = (androidx.compose.animation.core.SeekableTransitionState) r6
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r2
            goto L_0x005f
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.getTargetState()
            kotlinx.coroutines.sync.Mutex r2 = r7.compositionContinuationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r2 = kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r2, r4, r0, r5, r4)
            if (r2 != r1) goto L_0x005e
            goto L_0x009d
        L_0x005e:
            r6 = r7
        L_0x005f:
            S r2 = r6.composedTargetState
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x006d
            kotlinx.coroutines.sync.Mutex r8 = r6.compositionContinuationMutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r8, r4, r5, r4)
            goto L_0x00a7
        L_0x006d:
            r0.L$0 = r6
            r0.L$1 = r8
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r2.<init>(r3, r5)
            r2.initCancellability()
            r3 = r2
            kotlinx.coroutines.CancellableContinuation r3 = (kotlinx.coroutines.CancellableContinuation) r3
            r6.setCompositionContinuation$animation_core_release(r3)
            kotlinx.coroutines.sync.Mutex r3 = r6.getCompositionContinuationMutex$animation_core_release()
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r3, r4, r5, r4)
            java.lang.Object r2 = r2.getResult()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r2 != r3) goto L_0x009b
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x009b:
            if (r2 != r1) goto L_0x009e
        L_0x009d:
            return r1
        L_0x009e:
            r1 = r8
            r8 = r2
            r0 = r6
        L_0x00a1:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x00aa
        L_0x00a7:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00aa:
            r2 = -9223372036854775808
            r0.lastFrameTimeNanos = r2
            java.util.concurrent.CancellationException r0 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "snapTo() was canceled because state was changed to "
            r2.<init>(r3)
            java.lang.StringBuilder r8 = r2.append(r8)
            java.lang.String r2 = " instead of "
            java.lang.StringBuilder r8 = r8.append(r2)
            java.lang.StringBuilder r8 = r8.append(r1)
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.waitForCompositionAfterTargetStateChange(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object waitForComposition(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 r0 = (androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r5) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r1 = r0.L$1
            java.lang.Object r0 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r0 = (androidx.compose.animation.core.SeekableTransitionState) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0092
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003c:
            java.lang.Object r2 = r0.L$1
            java.lang.Object r6 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r6 = (androidx.compose.animation.core.SeekableTransitionState) r6
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r2
            goto L_0x005e
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.getTargetState()
            kotlinx.coroutines.sync.Mutex r2 = r7.compositionContinuationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r2 = kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r2, r4, r0, r5, r4)
            if (r2 != r1) goto L_0x005d
            goto L_0x008e
        L_0x005d:
            r6 = r7
        L_0x005e:
            r0.L$0 = r6
            r0.L$1 = r8
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r2.<init>(r3, r5)
            r2.initCancellability()
            r3 = r2
            kotlinx.coroutines.CancellableContinuation r3 = (kotlinx.coroutines.CancellableContinuation) r3
            r6.setCompositionContinuation$animation_core_release(r3)
            kotlinx.coroutines.sync.Mutex r3 = r6.getCompositionContinuationMutex$animation_core_release()
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r3, r4, r5, r4)
            java.lang.Object r2 = r2.getResult()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r2 != r3) goto L_0x008c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x008c:
            if (r2 != r1) goto L_0x008f
        L_0x008e:
            return r1
        L_0x008f:
            r1 = r8
            r8 = r2
            r0 = r6
        L_0x0092:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r1)
            if (r8 == 0) goto L_0x009b
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x009b:
            r1 = -9223372036854775808
            r0.lastFrameTimeNanos = r1
            java.util.concurrent.CancellationException r8 = new java.util.concurrent.CancellationException
            java.lang.String r0 = "targetState while waiting for composition"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.waitForComposition(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void moveAnimationToInitialState() {
        Transition<S> transition2 = this.transition;
        if (transition2 != null) {
            SeekingAnimationState seekingAnimationState = this.currentAnimation;
            if (seekingAnimationState == null) {
                if (this.totalDurationNanos <= 0 || getFraction() == 1.0f || Intrinsics.areEqual(getCurrentState(), getTargetState())) {
                    seekingAnimationState = null;
                } else {
                    seekingAnimationState = new SeekingAnimationState();
                    seekingAnimationState.setValue(getFraction());
                    long j = this.totalDurationNanos;
                    seekingAnimationState.setDurationNanos(j);
                    seekingAnimationState.setAnimationSpecDuration(MathKt.roundToLong(((double) j) * (1.0d - ((double) getFraction()))));
                    seekingAnimationState.getStart().set$animation_core_release(0, getFraction());
                }
            }
            if (seekingAnimationState != null) {
                seekingAnimationState.setDurationNanos(this.totalDurationNanos);
                this.initialValueAnimations.add(seekingAnimationState);
                transition2.setInitialAnimations$animation_core_release(seekingAnimationState);
            }
            this.currentAnimation = null;
        }
    }

    public static /* synthetic */ Object animateTo$default(SeekableTransitionState seekableTransitionState, Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec = null;
        }
        return seekableTransitionState.animateTo(obj, finiteAnimationSpec, continuation);
    }

    public final Object animateTo(S s, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super Unit> continuation) {
        Transition<S> transition2 = this.transition;
        if (transition2 == null) {
            return Unit.INSTANCE;
        }
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, (MutatePriority) null, new SeekableTransitionState$animateTo$2(transition2, this, s, finiteAnimationSpec, (Continuation<? super SeekableTransitionState$animateTo$2>) null), continuation, 1, (Object) null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    public void transitionConfigured$animation_core_release(Transition<S> transition2) {
        Transition<S> transition3 = this.transition;
        if (!(transition3 == null || Intrinsics.areEqual((Object) transition2, (Object) transition3))) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition2);
        }
        this.transition = transition2;
    }

    public void transitionRemoved$animation_core_release() {
        this.transition = null;
        TransitionKt.getSeekableStateObserver().clear(this);
    }

    public final void observeTotalDuration$animation_core_release() {
        TransitionKt.getSeekableStateObserver().observeReads(this, TransitionKt.SeekableTransitionStateTotalDurationChanged, this.recalculateTotalDurationNanos);
    }

    public final void onTotalDurationChanged$animation_core_release() {
        long j = this.totalDurationNanos;
        observeTotalDuration$animation_core_release();
        long j2 = this.totalDurationNanos;
        if (j != j2) {
            SeekingAnimationState seekingAnimationState = this.currentAnimation;
            if (seekingAnimationState != null) {
                seekingAnimationState.setDurationNanos(j2);
                if (seekingAnimationState.getAnimationSpec() == null) {
                    seekingAnimationState.setAnimationSpecDuration(MathKt.roundToLong((1.0d - ((double) seekingAnimationState.getStart().get$animation_core_release(0))) * ((double) this.totalDurationNanos)));
                }
            } else if (j2 != 0) {
                seekToFraction();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void seekToFraction() {
        Transition<S> transition2 = this.transition;
        if (transition2 != null) {
            transition2.seekAnimations$animation_core_release(MathKt.roundToLong(((double) getFraction()) * ((double) transition2.getTotalDurationNanos())));
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u001a\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "", "()V", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;)V", "animationSpecDuration", "", "getAnimationSpecDuration", "()J", "setAnimationSpecDuration", "(J)V", "durationNanos", "getDurationNanos", "setDurationNanos", "initialVelocity", "getInitialVelocity", "()Landroidx/compose/animation/core/AnimationVector1D;", "setInitialVelocity", "(Landroidx/compose/animation/core/AnimationVector1D;)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "progressNanos", "getProgressNanos", "setProgressNanos", "start", "getStart", "setStart", "value", "", "getValue", "()F", "setValue", "(F)V", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Transition.kt */
    public static final class SeekingAnimationState {
        public static final int $stable = 8;
        private VectorizedAnimationSpec<AnimationVector1D> animationSpec;
        private long animationSpecDuration;
        private long durationNanos;
        private AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;
        private AnimationVector1D start = new AnimationVector1D(0.0f);
        private float value;

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        public final void setProgressNanos(long j) {
            this.progressNanos = j;
        }

        public final VectorizedAnimationSpec<AnimationVector1D> getAnimationSpec() {
            return this.animationSpec;
        }

        public final void setAnimationSpec(VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpec) {
            this.animationSpec = vectorizedAnimationSpec;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        public final void setComplete(boolean z) {
            this.isComplete = z;
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float f) {
            this.value = f;
        }

        public final AnimationVector1D getStart() {
            return this.start;
        }

        public final void setStart(AnimationVector1D animationVector1D) {
            this.start = animationVector1D;
        }

        public final AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final void setInitialVelocity(AnimationVector1D animationVector1D) {
            this.initialVelocity = animationVector1D;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final void setDurationNanos(long j) {
            this.durationNanos = j;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final void setAnimationSpecDuration(long j) {
            this.animationSpecDuration = j;
        }

        public String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$Companion;", "", "()V", "Target1", "Landroidx/compose/animation/core/AnimationVector1D;", "getTarget1", "()Landroidx/compose/animation/core/AnimationVector1D;", "ZeroVelocity", "getZeroVelocity", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Transition.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.ZeroVelocity;
        }

        public final AnimationVector1D getTarget1() {
            return SeekableTransitionState.Target1;
        }
    }
}
