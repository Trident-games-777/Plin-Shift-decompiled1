package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005JJ\u0010\u0013\u001a\u00020\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bH@\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/animation/core/AnimationSpec;)V", "isRunning", "", "lastFrameTime", "", "lastVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "value", "getValue", "()F", "setValue", "(F)V", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UpdatableAnimationState.kt */
public final class UpdatableAnimationState {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final float VisibilityThreshold = 0.01f;
    /* access modifiers changed from: private */
    public static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);
    private boolean isRunning;
    /* access modifiers changed from: private */
    public long lastFrameTime = Long.MIN_VALUE;
    /* access modifiers changed from: private */
    public AnimationVector1D lastVelocity = ZeroVector;
    private float value;
    /* access modifiers changed from: private */
    public final VectorizedAnimationSpec<AnimationVector1D> vectorizedSpec;

    public UpdatableAnimationState(AnimationSpec<Float> animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ac, code lost:
        if (r12 != 0.0f) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d5, code lost:
        if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$5(r13, r14), r2) == r1) goto L_0x00d7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c0 A[Catch:{ all -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1 A[Catch:{ all -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateToZero(kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r12, kotlin.jvm.functions.Function0<kotlin.Unit> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1 r0 = (androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1 r0 = new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1
            r0.<init>(r11, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = -9223372036854775808
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L_0x0060
            if (r2 == r8) goto L_0x0045
            if (r2 != r7) goto L_0x003d
            java.lang.Object r12 = r0.L$1
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            java.lang.Object r13 = r0.L$0
            androidx.compose.foundation.gestures.UpdatableAnimationState r13 = (androidx.compose.foundation.gestures.UpdatableAnimationState) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x003a }
            goto L_0x00d8
        L_0x003a:
            r12 = move-exception
            goto L_0x00e6
        L_0x003d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0045:
            float r12 = r0.F$0
            java.lang.Object r13 = r0.L$2
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r9 = r0.L$0
            androidx.compose.foundation.gestures.UpdatableAnimationState r9 = (androidx.compose.foundation.gestures.UpdatableAnimationState) r9
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x005c }
            r14 = r0
            r0 = r13
            r13 = r2
            r2 = r14
            r14 = r9
            goto L_0x00a7
        L_0x005c:
            r12 = move-exception
            r13 = r9
            goto L_0x00e6
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r14)
            boolean r14 = r11.isRunning
            if (r14 != 0) goto L_0x00ef
            kotlin.coroutines.CoroutineContext r14 = r0.getContext()
            androidx.compose.ui.MotionDurationScale$Key r2 = androidx.compose.ui.MotionDurationScale.Key
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r14 = r14.get(r2)
            androidx.compose.ui.MotionDurationScale r14 = (androidx.compose.ui.MotionDurationScale) r14
            if (r14 == 0) goto L_0x007c
            float r14 = r14.getScaleFactor()
            goto L_0x007e
        L_0x007c:
            r14 = 1065353216(0x3f800000, float:1.0)
        L_0x007e:
            r11.isRunning = r8
            r2 = r0
            r0 = r13
            r13 = r12
            r12 = r14
            r14 = r11
        L_0x0085:
            androidx.compose.foundation.gestures.UpdatableAnimationState$Companion r9 = Companion     // Catch:{ all -> 0x00b3 }
            float r10 = r14.value     // Catch:{ all -> 0x00b3 }
            boolean r9 = r9.isZeroish(r10)     // Catch:{ all -> 0x00b3 }
            if (r9 != 0) goto L_0x00ae
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4 r9 = new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4     // Catch:{ all -> 0x00b3 }
            r9.<init>(r14, r12, r13)     // Catch:{ all -> 0x00b3 }
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9     // Catch:{ all -> 0x00b3 }
            r2.L$0 = r14     // Catch:{ all -> 0x00b3 }
            r2.L$1 = r13     // Catch:{ all -> 0x00b3 }
            r2.L$2 = r0     // Catch:{ all -> 0x00b3 }
            r2.F$0 = r12     // Catch:{ all -> 0x00b3 }
            r2.label = r8     // Catch:{ all -> 0x00b3 }
            java.lang.Object r9 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r9, r2)     // Catch:{ all -> 0x00b3 }
            if (r9 != r1) goto L_0x00a7
            goto L_0x00d7
        L_0x00a7:
            r0.invoke()     // Catch:{ all -> 0x00b3 }
            int r9 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x0085
        L_0x00ae:
            r12 = r14
            r14 = r13
            r13 = r12
            r12 = r0
            goto L_0x00b6
        L_0x00b3:
            r12 = move-exception
            r13 = r14
            goto L_0x00e6
        L_0x00b6:
            float r0 = r13.value     // Catch:{ all -> 0x003a }
            float r0 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x003a }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x00c1
            goto L_0x00db
        L_0x00c1:
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$5 r0 = new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$5     // Catch:{ all -> 0x003a }
            r0.<init>(r13, r14)     // Catch:{ all -> 0x003a }
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0     // Catch:{ all -> 0x003a }
            r2.L$0 = r13     // Catch:{ all -> 0x003a }
            r2.L$1 = r12     // Catch:{ all -> 0x003a }
            r14 = 0
            r2.L$2 = r14     // Catch:{ all -> 0x003a }
            r2.label = r7     // Catch:{ all -> 0x003a }
            java.lang.Object r14 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r0, r2)     // Catch:{ all -> 0x003a }
            if (r14 != r1) goto L_0x00d8
        L_0x00d7:
            return r1
        L_0x00d8:
            r12.invoke()     // Catch:{ all -> 0x003a }
        L_0x00db:
            r13.lastFrameTime = r5
            androidx.compose.animation.core.AnimationVector1D r12 = ZeroVector
            r13.lastVelocity = r12
            r13.isRunning = r4
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00e6:
            r13.lastFrameTime = r5
            androidx.compose.animation.core.AnimationVector1D r14 = ZeroVector
            r13.lastVelocity = r14
            r13.isRunning = r4
            throw r12
        L_0x00ef:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "animateToZero called while previous animation is running"
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u00020\n*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "()V", "VisibilityThreshold", "", "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UpdatableAnimationState.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final boolean isZeroish(float f) {
            return Math.abs(f) < 0.01f;
        }
    }
}
