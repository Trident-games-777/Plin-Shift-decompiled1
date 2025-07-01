package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/animation/core/FloatTweenSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "duration", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "getDelay", "()I", "delayNanos", "", "getDuration", "durationNanos", "clampPlayTimeNanos", "playTimeNanos", "getDurationNanos", "initialValue", "", "targetValue", "initialVelocity", "getValueFromNanos", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatAnimationSpec.kt */
public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable = 0;
    private final int delay;
    private final long delayNanos;
    private final int duration;
    private final long durationNanos;
    private final Easing easing;

    public FloatTweenSpec() {
        this(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null);
    }

    public FloatTweenSpec(int i, int i2, Easing easing2) {
        this.duration = i;
        this.delay = i2;
        this.easing = easing2;
        this.durationNanos = ((long) i) * AnimationKt.MillisToNanos;
        this.delayNanos = ((long) i2) * AnimationKt.MillisToNanos;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getDelay() {
        return this.delay;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatTweenSpec(int i, int i2, Easing easing2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing2);
    }

    public float getValueFromNanos(long j, float f, float f2, float f3) {
        float f4 = 1.0f;
        float clampPlayTimeNanos = this.duration == 0 ? 1.0f : ((float) clampPlayTimeNanos(j)) / ((float) this.durationNanos);
        Easing easing2 = this.easing;
        if (clampPlayTimeNanos < 0.0f) {
            clampPlayTimeNanos = 0.0f;
        }
        if (clampPlayTimeNanos <= 1.0f) {
            f4 = clampPlayTimeNanos;
        }
        return VectorConvertersKt.lerp(f, f2, easing2.transform(f4));
    }

    private final long clampPlayTimeNanos(long j) {
        return RangesKt.coerceIn(j - this.delayNanos, 0, this.durationNanos);
    }

    public long getDurationNanos(float f, float f2, float f3) {
        return ((long) (this.delay + this.duration)) * AnimationKt.MillisToNanos;
    }

    public float getVelocityFromNanos(long j, float f, float f2, float f3) {
        long clampPlayTimeNanos = clampPlayTimeNanos(j);
        int i = (clampPlayTimeNanos > 0 ? 1 : (clampPlayTimeNanos == 0 ? 0 : -1));
        if (i < 0) {
            return 0.0f;
        }
        if (i == 0) {
            return f3;
        }
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        return (getValueFromNanos(clampPlayTimeNanos, f4, f5, f6) - getValueFromNanos(clampPlayTimeNanos - AnimationKt.MillisToNanos, f4, f5, f6)) * 1000.0f;
    }
}
