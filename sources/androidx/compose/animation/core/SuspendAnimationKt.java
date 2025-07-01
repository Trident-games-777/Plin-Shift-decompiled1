package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u0001\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u000b2\u0006\u0010\f\u001a\u0002H\u00072\u0006\u0010\r\u001a\u0002H\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H@¢\u0006\u0002\u0010\u0017\u001ap\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H@¢\u0006\u0002\u0010\u0018\u001a^\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u001a26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H@¢\u0006\u0002\u0010\u001b\u001as\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H@¢\u0006\u0002\u0010$\u001am\u0010\u0019\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070%2\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H@¢\u0006\u0002\u0010(\u001aw\u0010)\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0006\u0010\r\u001a\u0002H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00102\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H@¢\u0006\u0002\u0010*\u001aW\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\u0007\"\b\b\u0002\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H,0!H@¢\u0006\u0002\u0010/\u001a\u0001\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a\u0001\u00104\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u0010\u0000\u001a\u00020\u00012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a<\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001cH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u00066"}, d2 = {"durationScale", "", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "animate", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "velocity", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "sequentialAnimation", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnimationFrame", "playTimeNanos", "anim", "state", "doAnimationFrameWithScale", "updateState", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SuspendAnimation.kt */
public final class SuspendAnimationKt {
    public static /* synthetic */ Object animate$default(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        return animate(f, f2, f3, animationSpec, function2, continuation);
    }

    public static final Object animate(float f, float f2, float f3, AnimationSpec<Float> animationSpec, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object animate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(f), Boxing.boxFloat(f2), Boxing.boxFloat(f3), animationSpec, function2, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static final Object animateDecay(float f, float f2, FloatDecayAnimationSpec floatDecayAnimationSpec, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        float f3 = f;
        float f4 = f2;
        Object animate$default = animate$default(AnimationStateKt.AnimationState$default(f3, f4, 0, 0, false, 28, (Object) null), AnimationKt.DecayAnimation(floatDecayAnimationSpec, f3, f4), 0, new SuspendAnimationKt$animateDecay$2(function2), continuation, 2, (Object) null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj4) {
        if ((i & 8) != 0) {
            obj3 = null;
        }
        if ((i & 16) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        return animate(twoWayConverter, obj, obj2, obj3, animationSpec, function2, continuation);
    }

    public static final <T, V extends AnimationVector> Object animate(TwoWayConverter<T, V> twoWayConverter, T t, T t2, T t3, AnimationSpec<T> animationSpec, Function2<? super T, ? super T, Unit> function2, Continuation<? super Unit> continuation) {
        AnimationVector animationVector;
        T t4 = t3;
        if (t4 == null || (animationVector = (AnimationVector) twoWayConverter.getConvertToVector().invoke(t4)) == null) {
            animationVector = AnimationVectorsKt.newInstance((AnimationVector) twoWayConverter.getConvertToVector().invoke(t));
        }
        AnimationVector animationVector2 = animationVector;
        Object animate$default = animate$default(new AnimationState(twoWayConverter, t, animationVector2, 0, 0, false, 56, (DefaultConstructorMarker) null), new TargetBasedAnimation(animationSpec, twoWayConverter, t, t2, animationVector2), 0, new SuspendAnimationKt$animate$3(function2, twoWayConverter), continuation, 2, (Object) null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = SuspendAnimationKt$animateTo$2.INSTANCE;
        }
        return animateTo(animationState, obj, animationSpec2, z2, function1, continuation);
    }

    public static final <T, V extends AnimationVector> Object animateTo(AnimationState<T, V> animationState, T t, AnimationSpec<T> animationSpec, boolean z, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), t, animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = SuspendAnimationKt$animateDecay$4.INSTANCE;
        }
        return animateDecay(animationState, decayAnimationSpec, z, function1, (Continuation<? super Unit>) continuation);
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> animationState, DecayAnimationSpec<T> decayAnimationSpec, boolean z, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new DecayAnimation(decayAnimationSpec, animationState.getTypeConverter(), animationState.getValue(), animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f9 A[Catch:{ CancellationException -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0136 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> java.lang.Object animate(androidx.compose.animation.core.AnimationState<T, V> r23, androidx.compose.animation.core.Animation<T, V> r24, long r25, kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            r3 = r24
            r0 = r28
            boolean r1 = r0 instanceof androidx.compose.animation.core.SuspendAnimationKt$animate$4
            if (r1 == 0) goto L_0x0018
            r1 = r0
            androidx.compose.animation.core.SuspendAnimationKt$animate$4 r1 = (androidx.compose.animation.core.SuspendAnimationKt$animate$4) r1
            int r2 = r1.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r4
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r4
            r1.label = r0
            goto L_0x001d
        L_0x0018:
            androidx.compose.animation.core.SuspendAnimationKt$animate$4 r1 = new androidx.compose.animation.core.SuspendAnimationKt$animate$4
            r1.<init>(r0)
        L_0x001d:
            r8 = r1
            java.lang.Object r0 = r8.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r10 = 2
            r11 = 1
            if (r1 == 0) goto L_0x005f
            if (r1 == r11) goto L_0x0047
            if (r1 != r10) goto L_0x003f
            java.lang.Object r1 = r8.L$3
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r2 = r8.L$2
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r3 = r8.L$1
            androidx.compose.animation.core.Animation r3 = (androidx.compose.animation.core.Animation) r3
            java.lang.Object r4 = r8.L$0
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4
            goto L_0x0057
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0047:
            java.lang.Object r1 = r8.L$3
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r2 = r8.L$2
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r3 = r8.L$1
            androidx.compose.animation.core.Animation r3 = (androidx.compose.animation.core.Animation) r3
            java.lang.Object r4 = r8.L$0
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x005c }
            goto L_0x00ec
        L_0x005c:
            r0 = move-exception
            goto L_0x013d
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = 0
            java.lang.Object r13 = r3.getValueFromNanos(r0)
            androidx.compose.animation.core.AnimationVector r15 = r3.getVelocityVectorFromNanos(r0)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            r4 = -9223372036854775808
            int r0 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00b1
            kotlin.coroutines.CoroutineContext r0 = r8.getContext()     // Catch:{ CancellationException -> 0x00aa }
            float r6 = getDurationScale(r0)     // Catch:{ CancellationException -> 0x00aa }
            androidx.compose.animation.core.SuspendAnimationKt$animate$6 r0 = new androidx.compose.animation.core.SuspendAnimationKt$animate$6     // Catch:{ CancellationException -> 0x00aa }
            r5 = r23
            r7 = r27
            r2 = r13
            r4 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ CancellationException -> 0x00a8 }
            r7 = r1
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0     // Catch:{ CancellationException -> 0x00a4 }
            r8.L$0 = r5     // Catch:{ CancellationException -> 0x00a4 }
            r8.L$1 = r3     // Catch:{ CancellationException -> 0x00a4 }
            r6 = r27
            r8.L$2 = r6     // Catch:{ CancellationException -> 0x00a4 }
            r8.L$3 = r7     // Catch:{ CancellationException -> 0x00a4 }
            r8.label = r11     // Catch:{ CancellationException -> 0x00a4 }
            java.lang.Object r0 = callWithFrameNanos(r3, r0, r8)     // Catch:{ CancellationException -> 0x00a4 }
            if (r0 != r9) goto L_0x00a1
            goto L_0x012f
        L_0x00a1:
            r4 = r5
            r2 = r6
            goto L_0x00eb
        L_0x00a4:
            r0 = move-exception
            r4 = r5
            goto L_0x013c
        L_0x00a8:
            r0 = move-exception
            goto L_0x00ad
        L_0x00aa:
            r0 = move-exception
            r5 = r23
        L_0x00ad:
            r7 = r1
            r4 = r5
            goto L_0x013d
        L_0x00b1:
            r5 = r23
            r6 = r27
            r7 = r1
            androidx.compose.animation.core.AnimationScope r12 = new androidx.compose.animation.core.AnimationScope     // Catch:{ CancellationException -> 0x0139 }
            androidx.compose.animation.core.TwoWayConverter r14 = r3.getTypeConverter()     // Catch:{ CancellationException -> 0x0139 }
            java.lang.Object r18 = r3.getTargetValue()     // Catch:{ CancellationException -> 0x0139 }
            androidx.compose.animation.core.SuspendAnimationKt$animate$7 r0 = new androidx.compose.animation.core.SuspendAnimationKt$animate$7     // Catch:{ CancellationException -> 0x0139 }
            r0.<init>(r5)     // Catch:{ CancellationException -> 0x0139 }
            r22 = r0
            kotlin.jvm.functions.Function0 r22 = (kotlin.jvm.functions.Function0) r22     // Catch:{ CancellationException -> 0x0139 }
            r21 = 1
            r19 = r25
            r16 = r25
            r12.<init>(r13, r14, r15, r16, r18, r19, r21, r22)     // Catch:{ CancellationException -> 0x0139 }
            kotlin.coroutines.CoroutineContext r0 = r8.getContext()     // Catch:{ CancellationException -> 0x0139 }
            float r0 = getDurationScale(r0)     // Catch:{ CancellationException -> 0x0139 }
            r1 = r25
            r4 = r3
            r3 = r0
            r0 = r12
            doAnimationFrameWithScale(r0, r1, r3, r4, r5, r6)     // Catch:{ CancellationException -> 0x0139 }
            r12 = r0
            r7.element = r12     // Catch:{ CancellationException -> 0x0139 }
            r4 = r23
            r3 = r24
            r2 = r27
        L_0x00eb:
            r1 = r7
        L_0x00ec:
            T r0 = r1.element     // Catch:{ CancellationException -> 0x005c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ CancellationException -> 0x005c }
            androidx.compose.animation.core.AnimationScope r0 = (androidx.compose.animation.core.AnimationScope) r0     // Catch:{ CancellationException -> 0x005c }
            boolean r0 = r0.isRunning()     // Catch:{ CancellationException -> 0x005c }
            if (r0 == 0) goto L_0x0136
            kotlin.coroutines.CoroutineContext r0 = r8.getContext()     // Catch:{ CancellationException -> 0x005c }
            float r0 = getDurationScale(r0)     // Catch:{ CancellationException -> 0x005c }
            androidx.compose.animation.core.SuspendAnimationKt$animate$9 r5 = new androidx.compose.animation.core.SuspendAnimationKt$animate$9     // Catch:{ CancellationException -> 0x005c }
            r25 = r0
            r24 = r1
            r28 = r2
            r26 = r3
            r27 = r4
            r23 = r5
            r23.<init>(r24, r25, r26, r27, r28)     // Catch:{ CancellationException -> 0x0130 }
            r0 = r23
            r1 = r24
            r3 = r26
            r4 = r27
            r2 = r28
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ CancellationException -> 0x005c }
            r8.L$0 = r4     // Catch:{ CancellationException -> 0x005c }
            r8.L$1 = r3     // Catch:{ CancellationException -> 0x005c }
            r8.L$2 = r2     // Catch:{ CancellationException -> 0x005c }
            r8.L$3 = r1     // Catch:{ CancellationException -> 0x005c }
            r8.label = r10     // Catch:{ CancellationException -> 0x005c }
            java.lang.Object r0 = callWithFrameNanos(r3, r5, r8)     // Catch:{ CancellationException -> 0x005c }
            if (r0 != r9) goto L_0x00ec
        L_0x012f:
            return r9
        L_0x0130:
            r0 = move-exception
            r1 = r24
            r4 = r27
            goto L_0x013d
        L_0x0136:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0139:
            r0 = move-exception
            r4 = r23
        L_0x013c:
            r1 = r7
        L_0x013d:
            T r2 = r1.element
            androidx.compose.animation.core.AnimationScope r2 = (androidx.compose.animation.core.AnimationScope) r2
            r3 = 0
            if (r2 != 0) goto L_0x0145
            goto L_0x0148
        L_0x0145:
            r2.setRunning$animation_core_release(r3)
        L_0x0148:
            T r1 = r1.element
            androidx.compose.animation.core.AnimationScope r1 = (androidx.compose.animation.core.AnimationScope) r1
            if (r1 == 0) goto L_0x015d
            long r1 = r1.getLastFrameTimeNanos()
            long r5 = r4.getLastFrameTimeNanos()
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x015d
            r4.setRunning$animation_core_release(r3)
        L_0x015d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.animate(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MIN_VALUE;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            function1 = SuspendAnimationKt$animate$5.INSTANCE;
        }
        return animate(animationState, animation, j2, function1, continuation);
    }

    /* access modifiers changed from: private */
    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        if (animation.isInfinite()) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, continuation);
        }
        return MonotonicFrameClockKt.withFrameNanos(new SuspendAnimationKt$callWithFrameNanos$2(function1), continuation);
    }

    public static final float getDurationScale(CoroutineContext coroutineContext) {
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(MotionDurationScale.Key);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (!(scaleFactor >= 0.0f)) {
            PreconditionsKt.throwIllegalStateException("negative scale factor");
        }
        return scaleFactor;
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> animationScope, AnimationState<T, V> animationState) {
        animationState.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(animationState.getVelocityVector(), animationScope.getVelocityVector());
        animationState.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        animationState.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        animationState.setRunning$animation_core_release(animationScope.isRunning());
    }

    /* access modifiers changed from: private */
    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long j, float f, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        long j2;
        if (f == 0.0f) {
            j2 = animation.getDurationNanos();
        } else {
            j2 = (long) (((float) (j - animationScope.getStartTimeNanos())) / f);
        }
        doAnimationFrame(animationScope, j, j2, animation, animationState, function1);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long j, long j2, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        animationScope.setLastFrameTimeNanos$animation_core_release(j);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(j2));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(j2));
        if (animation.isFinishedFromNanos(j2)) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }
}
