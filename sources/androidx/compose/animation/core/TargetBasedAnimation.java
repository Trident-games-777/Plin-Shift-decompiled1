package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004BE\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\fBE\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u000eJ\u0015\u0010.\u001a\u00028\u00002\u0006\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0002\u00100J\u0015\u00101\u001a\u00028\u00012\u0006\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u000204H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00028\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u00028\u0001X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000b\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010 R&\u0010\"\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0000@@X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010%R&\u0010'\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0000@@X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010%R\u0014\u0010\n\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u0010\u0010+\u001a\u00028\u0001X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00065"}, d2 = {"Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocityVector", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "_durationNanos", "", "_endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getAnimationSpec$animation_core_release", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "durationNanos", "getDurationNanos", "()J", "endVelocity", "getEndVelocity", "()Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "initialValueVector", "isInfinite", "", "()Z", "value", "mutableInitialValue", "getMutableInitialValue$animation_core_release", "setMutableInitialValue$animation_core_release", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "mutableTargetValue", "getMutableTargetValue$animation_core_release", "setMutableTargetValue$animation_core_release", "getTargetValue", "targetValueVector", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Animation.kt */
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 8;
    private long _durationNanos;
    private V _endVelocity;
    private final VectorizedAnimationSpec<V> animationSpec;
    private V initialValueVector;
    private final V initialVelocityVector;
    private T mutableInitialValue;
    private T mutableTargetValue;
    private V targetValueVector;
    private final TwoWayConverter<T, V> typeConverter;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002d, code lost:
        r1 = androidx.compose.animation.core.AnimationVectorsKt.copy(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TargetBasedAnimation(androidx.compose.animation.core.VectorizedAnimationSpec<V> r1, androidx.compose.animation.core.TwoWayConverter<T, V> r2, T r3, T r4, V r5) {
        /*
            r0 = this;
            r0.<init>()
            r0.animationSpec = r1
            r0.typeConverter = r2
            r0.mutableTargetValue = r4
            r0.mutableInitialValue = r3
            androidx.compose.animation.core.TwoWayConverter r1 = r0.getTypeConverter()
            kotlin.jvm.functions.Function1 r1 = r1.getConvertToVector()
            java.lang.Object r1 = r1.invoke(r3)
            androidx.compose.animation.core.AnimationVector r1 = (androidx.compose.animation.core.AnimationVector) r1
            r0.initialValueVector = r1
            androidx.compose.animation.core.TwoWayConverter r1 = r0.getTypeConverter()
            kotlin.jvm.functions.Function1 r1 = r1.getConvertToVector()
            java.lang.Object r1 = r1.invoke(r4)
            androidx.compose.animation.core.AnimationVector r1 = (androidx.compose.animation.core.AnimationVector) r1
            r0.targetValueVector = r1
            if (r5 == 0) goto L_0x0033
            androidx.compose.animation.core.AnimationVector r1 = androidx.compose.animation.core.AnimationVectorsKt.copy(r5)
            if (r1 != 0) goto L_0x0045
        L_0x0033:
            androidx.compose.animation.core.TwoWayConverter r1 = r0.getTypeConverter()
            kotlin.jvm.functions.Function1 r1 = r1.getConvertToVector()
            java.lang.Object r1 = r1.invoke(r3)
            androidx.compose.animation.core.AnimationVector r1 = (androidx.compose.animation.core.AnimationVector) r1
            androidx.compose.animation.core.AnimationVector r1 = androidx.compose.animation.core.AnimationVectorsKt.newInstance(r1)
        L_0x0045:
            r0.initialVelocityVector = r1
            r1 = -1
            r0._durationNanos = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.TargetBasedAnimation.<init>(androidx.compose.animation.core.VectorizedAnimationSpec, androidx.compose.animation.core.TwoWayConverter, java.lang.Object, java.lang.Object, androidx.compose.animation.core.AnimationVector):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TargetBasedAnimation(VectorizedAnimationSpec vectorizedAnimationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vectorizedAnimationSpec, twoWayConverter, obj, obj2, (i & 16) != 0 ? null : animationVector);
    }

    public final VectorizedAnimationSpec<V> getAnimationSpec$animation_core_release() {
        return this.animationSpec;
    }

    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final T getMutableTargetValue$animation_core_release() {
        return this.mutableTargetValue;
    }

    public final void setMutableTargetValue$animation_core_release(T t) {
        if (!Intrinsics.areEqual((Object) this.mutableTargetValue, (Object) t)) {
            this.mutableTargetValue = t;
            this.targetValueVector = (AnimationVector) getTypeConverter().getConvertToVector().invoke(t);
            this._endVelocity = null;
            this._durationNanos = -1;
        }
    }

    public final T getMutableInitialValue$animation_core_release() {
        return this.mutableInitialValue;
    }

    public final void setMutableInitialValue$animation_core_release(T t) {
        if (!Intrinsics.areEqual((Object) t, (Object) this.mutableInitialValue)) {
            this.mutableInitialValue = t;
            this.initialValueVector = (AnimationVector) getTypeConverter().getConvertToVector().invoke(t);
            this._endVelocity = null;
            this._durationNanos = -1;
        }
    }

    public final T getInitialValue() {
        return this.mutableInitialValue;
    }

    public T getTargetValue() {
        return this.mutableTargetValue;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec2, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationSpec2, twoWayConverter, obj, obj2, (i & 16) != 0 ? null : animationVector);
    }

    public TargetBasedAnimation(AnimationSpec<T> animationSpec2, TwoWayConverter<T, V> twoWayConverter, T t, T t2, V v) {
        this(animationSpec2.vectorize(twoWayConverter), twoWayConverter, t, t2, v);
    }

    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    public T getValueFromNanos(long j) {
        if (isFinishedFromNanos(j)) {
            return getTargetValue();
        }
        long j2 = j;
        V valueFromNanos = this.animationSpec.getValueFromNanos(j2, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        int size$animation_core_release = valueFromNanos.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            if (Float.isNaN(valueFromNanos.get$animation_core_release(i))) {
                PreconditionsKt.throwIllegalStateException("AnimationVector cannot contain a NaN. " + valueFromNanos + ". Animation: " + this + ", playTimeNanos: " + j2);
            }
        }
        return getTypeConverter().getConvertFromVector().invoke(valueFromNanos);
    }

    public long getDurationNanos() {
        if (this._durationNanos < 0) {
            this._durationNanos = this.animationSpec.getDurationNanos(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }
        return this._durationNanos;
    }

    private final V getEndVelocity() {
        V v = this._endVelocity;
        if (v != null) {
            return v;
        }
        V endVelocity = this.animationSpec.getEndVelocity(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        this._endVelocity = endVelocity;
        return endVelocity;
    }

    public V getVelocityVectorFromNanos(long j) {
        if (isFinishedFromNanos(j)) {
            return getEndVelocity();
        }
        return this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
    }

    public String toString() {
        return "TargetBasedAnimation: " + getInitialValue() + " -> " + getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms,animationSpec: " + this.animationSpec;
    }
}
