package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J%\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J-\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Landroidx/compose/animation/core/StartDelayVectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "vectorizedAnimationSpec", "startDelayNanos", "", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;J)V", "isInfinite", "", "()Z", "getStartDelayNanos", "()J", "getVectorizedAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "equals", "other", "", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "hashCode", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationSpec.kt */
final class StartDelayVectorizedAnimationSpec<V extends AnimationVector> implements VectorizedAnimationSpec<V> {
    private final long startDelayNanos;
    private final VectorizedAnimationSpec<V> vectorizedAnimationSpec;

    public StartDelayVectorizedAnimationSpec(VectorizedAnimationSpec<V> vectorizedAnimationSpec2, long j) {
        this.vectorizedAnimationSpec = vectorizedAnimationSpec2;
        this.startDelayNanos = j;
    }

    public final VectorizedAnimationSpec<V> getVectorizedAnimationSpec() {
        return this.vectorizedAnimationSpec;
    }

    public final long getStartDelayNanos() {
        return this.startDelayNanos;
    }

    public boolean isInfinite() {
        return this.vectorizedAnimationSpec.isInfinite();
    }

    public long getDurationNanos(V v, V v2, V v3) {
        return this.vectorizedAnimationSpec.getDurationNanos(v, v2, v3) + this.startDelayNanos;
    }

    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        long j2 = this.startDelayNanos;
        if (j < j2) {
            return v3;
        }
        return this.vectorizedAnimationSpec.getVelocityFromNanos(j - j2, v, v2, v3);
    }

    public V getValueFromNanos(long j, V v, V v2, V v3) {
        long j2 = this.startDelayNanos;
        if (j < j2) {
            return v;
        }
        return this.vectorizedAnimationSpec.getValueFromNanos(j - j2, v, v2, v3);
    }

    public int hashCode() {
        return (this.vectorizedAnimationSpec.hashCode() * 31) + Long.hashCode(this.startDelayNanos);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StartDelayVectorizedAnimationSpec)) {
            return false;
        }
        StartDelayVectorizedAnimationSpec startDelayVectorizedAnimationSpec = (StartDelayVectorizedAnimationSpec) obj;
        if (startDelayVectorizedAnimationSpec.startDelayNanos != this.startDelayNanos || !Intrinsics.areEqual((Object) startDelayVectorizedAnimationSpec.vectorizedAnimationSpec, (Object) this.vectorizedAnimationSpec)) {
            return false;
        }
        return true;
    }
}
