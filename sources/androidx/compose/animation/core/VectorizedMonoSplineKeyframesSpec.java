package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000bH\u0002J-\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J-\u0010+\u001a\u00028\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J%\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010.R\u0014\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u001cX.¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006/"}, d2 = {"Landroidx/compose/animation/core/VectorizedMonoSplineKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "timestamps", "Landroidx/collection/IntList;", "keyframes", "Landroidx/collection/IntObjectMap;", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "", "delayMillis", "periodicBias", "", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IIF)V", "getDelayMillis", "()I", "getDurationMillis", "lastInitialValue", "Landroidx/compose/animation/core/AnimationVector;", "lastTargetValue", "monoSpline", "Landroidx/compose/animation/core/MonoSpline;", "times", "", "valueVector", "values", "", "[[F", "velocityVector", "findEntryForTimeMillis", "timeMillis", "getEasedTimeFromIndex", "index", "getEasing", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorizedMonoSplineKeyframesSpec.kt */
public final class VectorizedMonoSplineKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final IntObjectMap<Pair<V, Easing>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private MonoSpline monoSpline;
    private final float periodicBias;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private float[][] values;
    private V velocityVector;

    public VectorizedMonoSplineKeyframesSpec(IntList intList, IntObjectMap<Pair<V, Easing>> intObjectMap, int i, int i2, float f) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i2;
        this.periodicBias = f;
    }

    public int getDurationMillis() {
        return this.durationMillis;
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    private final void init(V v, V v2, V v3) {
        float[] fArr;
        float[] fArr2;
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(v);
            this.velocityVector = AnimationVectorsKt.newInstance(v3);
            int size = this.timestamps.getSize();
            float[] fArr3 = new float[size];
            for (int i = 0; i < size; i++) {
                fArr3[i] = ((float) this.timestamps.get(i)) / ((float) 1000);
            }
            this.times = fArr3;
        }
        if (this.monoSpline == null || !Intrinsics.areEqual((Object) this.lastInitialValue, (Object) v) || !Intrinsics.areEqual((Object) this.lastTargetValue, (Object) v2)) {
            boolean areEqual = Intrinsics.areEqual((Object) this.lastInitialValue, (Object) v);
            boolean areEqual2 = Intrinsics.areEqual((Object) this.lastTargetValue, (Object) v2);
            this.lastInitialValue = v;
            this.lastTargetValue = v2;
            int size$animation_core_release = v.getSize$animation_core_release();
            float[][] fArr4 = null;
            if (this.values == null) {
                int size2 = this.timestamps.getSize();
                float[][] fArr5 = new float[size2][];
                for (int i2 = 0; i2 < size2; i2++) {
                    int i3 = this.timestamps.get(i2);
                    if (i3 == 0) {
                        if (!this.keyframes.contains(i3)) {
                            fArr = new float[size$animation_core_release];
                            for (int i4 = 0; i4 < size$animation_core_release; i4++) {
                                fArr[i4] = v.get$animation_core_release(i4);
                            }
                            fArr5[i2] = fArr;
                        } else {
                            fArr2 = new float[size$animation_core_release];
                            Pair<V, Easing> pair = this.keyframes.get(i3);
                            Intrinsics.checkNotNull(pair);
                            AnimationVector animationVector = (AnimationVector) pair.getFirst();
                            for (int i5 = 0; i5 < size$animation_core_release; i5++) {
                                fArr2[i5] = animationVector.get$animation_core_release(i5);
                            }
                        }
                    } else if (i3 != getDurationMillis()) {
                        fArr2 = new float[size$animation_core_release];
                        Pair<V, Easing> pair2 = this.keyframes.get(i3);
                        Intrinsics.checkNotNull(pair2);
                        AnimationVector animationVector2 = (AnimationVector) pair2.getFirst();
                        for (int i6 = 0; i6 < size$animation_core_release; i6++) {
                            fArr2[i6] = animationVector2.get$animation_core_release(i6);
                        }
                    } else if (!this.keyframes.contains(i3)) {
                        fArr = new float[size$animation_core_release];
                        for (int i7 = 0; i7 < size$animation_core_release; i7++) {
                            fArr[i7] = v2.get$animation_core_release(i7);
                        }
                        fArr5[i2] = fArr;
                    } else {
                        fArr2 = new float[size$animation_core_release];
                        Pair<V, Easing> pair3 = this.keyframes.get(i3);
                        Intrinsics.checkNotNull(pair3);
                        AnimationVector animationVector3 = (AnimationVector) pair3.getFirst();
                        for (int i8 = 0; i8 < size$animation_core_release; i8++) {
                            fArr2[i8] = animationVector3.get$animation_core_release(i8);
                        }
                    }
                    fArr = fArr2;
                    fArr5[i2] = fArr;
                }
                this.values = fArr5;
            } else {
                if (!areEqual && !this.keyframes.contains(0)) {
                    float[][] fArr6 = this.values;
                    if (fArr6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("values");
                        fArr6 = null;
                    }
                    int binarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, 0, 0, 0, 6, (Object) null);
                    float[] fArr7 = new float[size$animation_core_release];
                    for (int i9 = 0; i9 < size$animation_core_release; i9++) {
                        fArr7[i9] = v.get$animation_core_release(i9);
                    }
                    fArr6[binarySearch$default] = fArr7;
                }
                if (!areEqual2 && !this.keyframes.contains(getDurationMillis())) {
                    float[][] fArr8 = this.values;
                    if (fArr8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("values");
                        fArr8 = null;
                    }
                    int binarySearch$default2 = IntListExtensionKt.binarySearch$default(this.timestamps, getDurationMillis(), 0, 0, 6, (Object) null);
                    float[] fArr9 = new float[size$animation_core_release];
                    for (int i10 = 0; i10 < size$animation_core_release; i10++) {
                        fArr9[i10] = v2.get$animation_core_release(i10);
                    }
                    fArr8[binarySearch$default2] = fArr9;
                }
            }
            float[] fArr10 = this.times;
            if (fArr10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("times");
                fArr10 = null;
            }
            float[][] fArr11 = this.values;
            if (fArr11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("values");
            } else {
                fArr4 = fArr11;
            }
            this.monoSpline = new MonoSpline(fArr10, fArr4, this.periodicBias);
        }
    }

    public V getValueFromNanos(long j, V v, V v2, V v3) {
        int clampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (this.keyframes.containsKey(clampPlayTime)) {
            Pair<V, Easing> pair = this.keyframes.get(clampPlayTime);
            Intrinsics.checkNotNull(pair);
            return (AnimationVector) pair.getFirst();
        } else if (clampPlayTime >= getDurationMillis()) {
            return v2;
        } else {
            if (clampPlayTime <= 0) {
                return v;
            }
            init(v, v2, v3);
            int findEntryForTimeMillis = findEntryForTimeMillis(clampPlayTime);
            MonoSpline monoSpline2 = this.monoSpline;
            if (monoSpline2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("monoSpline");
                monoSpline2 = null;
            }
            float easedTimeFromIndex = getEasedTimeFromIndex(findEntryForTimeMillis, clampPlayTime);
            V v4 = this.valueVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v4 = null;
            }
            monoSpline2.getPos(easedTimeFromIndex, v4, findEntryForTimeMillis);
            V v5 = this.valueVector;
            if (v5 != null) {
                return v5;
            }
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
    }

    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        int clampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (clampPlayTime < 0) {
            return v3;
        }
        init(v, v2, v3);
        int findEntryForTimeMillis = findEntryForTimeMillis(clampPlayTime);
        MonoSpline monoSpline2 = this.monoSpline;
        if (monoSpline2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("monoSpline");
            monoSpline2 = null;
        }
        float easedTimeFromIndex = getEasedTimeFromIndex(findEntryForTimeMillis, clampPlayTime);
        V v4 = this.velocityVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v4 = null;
        }
        monoSpline2.getSlope(easedTimeFromIndex, v4, findEntryForTimeMillis);
        V v5 = this.velocityVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r2 = (androidx.compose.animation.core.Easing) r2.getSecond();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.animation.core.Easing getEasing(int r2) {
        /*
            r1 = this;
            androidx.collection.IntList r0 = r1.timestamps
            int r2 = r0.get(r2)
            androidx.collection.IntObjectMap<kotlin.Pair<V, androidx.compose.animation.core.Easing>> r0 = r1.keyframes
            java.lang.Object r2 = r0.get(r2)
            kotlin.Pair r2 = (kotlin.Pair) r2
            if (r2 == 0) goto L_0x001a
            java.lang.Object r2 = r2.getSecond()
            androidx.compose.animation.core.Easing r2 = (androidx.compose.animation.core.Easing) r2
            if (r2 != 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            return r2
        L_0x001a:
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.VectorizedMonoSplineKeyframesSpec.getEasing(int):androidx.compose.animation.core.Easing");
    }

    private final float getEasedTimeFromIndex(int i, int i2) {
        float f;
        if (i >= this.timestamps._size - 1) {
            f = (float) i2;
        } else {
            int i3 = this.timestamps.get(i);
            int i4 = this.timestamps.get(i + 1);
            if (i2 == i3) {
                f = (float) i3;
            } else {
                float f2 = (float) (i4 - i3);
                return ((f2 * getEasing(i).transform(((float) (i2 - i3)) / f2)) + ((float) i3)) / ((float) 1000);
            }
        }
        return f / ((float) 1000);
    }

    private final int findEntryForTimeMillis(int i) {
        int binarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, i, 0, 0, 6, (Object) null);
        return binarySearch$default < -1 ? -(binarySearch$default + 2) : binarySearch$default;
    }
}
