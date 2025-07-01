package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B9\b\u0016\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bBC\b\u0000\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010&\u001a\u00020\u0006H\u0002J \u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J-\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J-\u00104\u001a\u00028\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J%\u00105\u001a\u0002062\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00107R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u0012X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010$\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "keyframes", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "delayMillis", "(Ljava/util/Map;II)V", "timestamps", "Landroidx/collection/IntList;", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "defaultEasing", "initialArcMode", "Landroidx/compose/animation/core/ArcMode;", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "getDelayMillis", "()I", "getDurationMillis", "I", "lastInitialValue", "Landroidx/compose/animation/core/AnimationVector;", "lastTargetValue", "modes", "", "posArray", "", "slopeArray", "times", "valueVector", "velocityVector", "findEntryForTimeMillis", "timeMillis", "getEasedTime", "", "getEasedTimeFromIndex", "index", "asFraction", "", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorizedAnimationSpec.kt */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private ArcSpline arcSpline;
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;
    private final IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i, int i2, Easing easing, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(intList, intObjectMap, i, i2, easing, i3);
    }

    private VectorizedKeyframesSpec(IntList intList, IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> intObjectMap, int i, int i2, Easing easing, int i3) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i2;
        this.defaultEasing = easing;
        this.initialArcMode = i3;
    }

    public int getDurationMillis() {
        return this.durationMillis;
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VectorizedKeyframesSpec(java.util.Map<java.lang.Integer, ? extends kotlin.Pair<? extends V, ? extends androidx.compose.animation.core.Easing>> r12, int r13, int r14) {
        /*
            r11 = this;
            androidx.collection.MutableIntList r0 = new androidx.collection.MutableIntList
            int r1 = r12.size()
            int r1 = r1 + 2
            r0.<init>(r1)
            java.util.Set r1 = r12.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0013:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getKey()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r0.add(r2)
            goto L_0x0013
        L_0x002d:
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            boolean r2 = r12.containsKey(r2)
            if (r2 != 0) goto L_0x003b
            r0.add(r1, r1)
        L_0x003b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            boolean r2 = r12.containsKey(r2)
            if (r2 != 0) goto L_0x0048
            r0.add(r13)
        L_0x0048:
            r0.sort()
            r4 = r0
            androidx.collection.IntList r4 = (androidx.collection.IntList) r4
            androidx.collection.MutableIntObjectMap r0 = new androidx.collection.MutableIntObjectMap
            r2 = 1
            r3 = 0
            r0.<init>(r1, r2, r3)
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x005d:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0094
            java.lang.Object r1 = r12.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.getValue()
            kotlin.Pair r1 = (kotlin.Pair) r1
            androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo r5 = new androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo
            java.lang.Object r6 = r1.getFirst()
            androidx.compose.animation.core.AnimationVector r6 = (androidx.compose.animation.core.AnimationVector) r6
            java.lang.Object r1 = r1.getSecond()
            androidx.compose.animation.core.Easing r1 = (androidx.compose.animation.core.Easing) r1
            androidx.compose.animation.core.ArcMode$Companion r7 = androidx.compose.animation.core.ArcMode.Companion
            int r7 = r7.m164getArcLinear9TMq4()
            r5.<init>(r6, r1, r7, r3)
            r0.set(r2, r5)
            goto L_0x005d
        L_0x0094:
            r5 = r0
            androidx.collection.IntObjectMap r5 = (androidx.collection.IntObjectMap) r5
            androidx.compose.animation.core.Easing r8 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.ArcMode$Companion r12 = androidx.compose.animation.core.ArcMode.Companion
            int r9 = r12.m164getArcLinear9TMq4()
            r10 = 0
            r3 = r11
            r6 = r13
            r7 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.VectorizedKeyframesSpec.<init>(java.util.Map, int, int):void");
    }

    private final void init(V v, V v2, V v3) {
        float[] fArr;
        float[] fArr2;
        boolean z = this.arcSpline != null;
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(v);
            this.velocityVector = AnimationVectorsKt.newInstance(v3);
            int size = this.timestamps.getSize();
            float[] fArr3 = new float[size];
            for (int i = 0; i < size; i++) {
                fArr3[i] = ((float) this.timestamps.get(i)) / ((float) 1000);
            }
            this.times = fArr3;
            int size2 = this.timestamps.getSize();
            int[] iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = this.keyframes.get(this.timestamps.get(i2));
                int r5 = vectorizedKeyframeSpecElementInfo != null ? vectorizedKeyframeSpecElementInfo.m218getArcMode9TMq4() : this.initialArcMode;
                if (!ArcMode.m158equalsimpl0(r5, ArcMode.Companion.m164getArcLinear9TMq4())) {
                    z = true;
                }
                iArr[i2] = r5;
            }
            this.modes = iArr;
        }
        if (z) {
            float[] fArr4 = null;
            if (this.arcSpline != null) {
                V v4 = this.lastInitialValue;
                if (v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastInitialValue");
                    v4 = null;
                }
                if (Intrinsics.areEqual((Object) v4, (Object) v)) {
                    V v5 = this.lastTargetValue;
                    if (v5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lastTargetValue");
                        v5 = null;
                    }
                    if (Intrinsics.areEqual((Object) v5, (Object) v2)) {
                        return;
                    }
                }
            }
            this.lastInitialValue = v;
            this.lastTargetValue = v2;
            int size$animation_core_release = (v.getSize$animation_core_release() % 2) + v.getSize$animation_core_release();
            this.posArray = new float[size$animation_core_release];
            this.slopeArray = new float[size$animation_core_release];
            int size3 = this.timestamps.getSize();
            float[][] fArr5 = new float[size3][];
            for (int i3 = 0; i3 < size3; i3++) {
                int i4 = this.timestamps.get(i3);
                if (i4 == 0) {
                    if (!this.keyframes.contains(i4)) {
                        fArr = new float[size$animation_core_release];
                        for (int i5 = 0; i5 < size$animation_core_release; i5++) {
                            fArr[i5] = v.get$animation_core_release(i5);
                        }
                        fArr5[i3] = fArr;
                    } else {
                        fArr2 = new float[size$animation_core_release];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i4);
                        Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                        AnimationVector vectorValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
                        for (int i6 = 0; i6 < size$animation_core_release; i6++) {
                            fArr2[i6] = vectorValue.get$animation_core_release(i6);
                        }
                    }
                } else if (i4 != getDurationMillis()) {
                    fArr2 = new float[size$animation_core_release];
                    VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i4);
                    Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
                    AnimationVector vectorValue2 = vectorizedKeyframeSpecElementInfo3.getVectorValue();
                    for (int i7 = 0; i7 < size$animation_core_release; i7++) {
                        fArr2[i7] = vectorValue2.get$animation_core_release(i7);
                    }
                } else if (!this.keyframes.contains(i4)) {
                    fArr = new float[size$animation_core_release];
                    for (int i8 = 0; i8 < size$animation_core_release; i8++) {
                        fArr[i8] = v2.get$animation_core_release(i8);
                    }
                    fArr5[i3] = fArr;
                } else {
                    fArr2 = new float[size$animation_core_release];
                    VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo4 = this.keyframes.get(i4);
                    Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo4);
                    AnimationVector vectorValue3 = vectorizedKeyframeSpecElementInfo4.getVectorValue();
                    for (int i9 = 0; i9 < size$animation_core_release; i9++) {
                        fArr2[i9] = vectorValue3.get$animation_core_release(i9);
                    }
                }
                fArr = fArr2;
                fArr5[i3] = fArr;
            }
            int[] iArr2 = this.modes;
            if (iArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modes");
                iArr2 = null;
            }
            float[] fArr6 = this.times;
            if (fArr6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("times");
            } else {
                fArr4 = fArr6;
            }
            this.arcSpline = new ArcSpline(iArr2, fArr4, fArr5);
        }
    }

    public V getValueFromNanos(long j, V v, V v2, V v3) {
        int clampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (this.keyframes.contains(clampPlayTime)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(clampPlayTime);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo);
            return vectorizedKeyframeSpecElementInfo.getVectorValue();
        } else if (clampPlayTime >= getDurationMillis()) {
            return v2;
        } else {
            if (clampPlayTime <= 0) {
                return v;
            }
            init(v, v2, v3);
            int i = 0;
            if (this.arcSpline != null) {
                float easedTime = getEasedTime(clampPlayTime);
                ArcSpline arcSpline2 = this.arcSpline;
                if (arcSpline2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                    arcSpline2 = null;
                }
                float[] fArr = this.posArray;
                if (fArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("posArray");
                    fArr = null;
                }
                arcSpline2.getPos(easedTime, fArr);
                float[] fArr2 = this.posArray;
                if (fArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("posArray");
                    fArr2 = null;
                }
                int length = fArr2.length;
                while (i < length) {
                    V v4 = this.valueVector;
                    if (v4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                        v4 = null;
                    }
                    float[] fArr3 = this.posArray;
                    if (fArr3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("posArray");
                        fArr3 = null;
                    }
                    v4.set$animation_core_release(i, fArr3[i]);
                    i++;
                }
                V v5 = this.valueVector;
                if (v5 != null) {
                    return v5;
                }
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                return null;
            }
            int findEntryForTimeMillis = findEntryForTimeMillis(clampPlayTime);
            float easedTimeFromIndex = getEasedTimeFromIndex(findEntryForTimeMillis, clampPlayTime, true);
            int i2 = this.timestamps.get(findEntryForTimeMillis);
            if (this.keyframes.contains(i2)) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i2);
                Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                v = vectorizedKeyframeSpecElementInfo2.getVectorValue();
            }
            int i3 = this.timestamps.get(findEntryForTimeMillis + 1);
            if (this.keyframes.contains(i3)) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i3);
                Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
                v2 = vectorizedKeyframeSpecElementInfo3.getVectorValue();
            }
            V v6 = this.valueVector;
            if (v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v6 = null;
            }
            int size$animation_core_release = v6.getSize$animation_core_release();
            while (i < size$animation_core_release) {
                V v7 = this.valueVector;
                if (v7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                    v7 = null;
                }
                v7.set$animation_core_release(i, VectorConvertersKt.lerp(v.get$animation_core_release(i), v2.get$animation_core_release(i), easedTimeFromIndex));
                i++;
            }
            V v8 = this.valueVector;
            if (v8 != null) {
                return v8;
            }
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
    }

    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        long clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (clampPlayTime < 0) {
            return v3;
        }
        init(v, v2, v3);
        int i = 0;
        if (this.arcSpline != null) {
            float easedTime = getEasedTime((int) clampPlayTime);
            ArcSpline arcSpline2 = this.arcSpline;
            if (arcSpline2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                arcSpline2 = null;
            }
            float[] fArr = this.slopeArray;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr = null;
            }
            arcSpline2.getSlope(easedTime, fArr);
            float[] fArr2 = this.slopeArray;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr2 = null;
            }
            int length = fArr2.length;
            while (i < length) {
                V v4 = this.velocityVector;
                if (v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                    v4 = null;
                }
                float[] fArr3 = this.slopeArray;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                    fArr3 = null;
                }
                v4.set$animation_core_release(i, fArr3[i]);
                i++;
            }
            V v5 = this.velocityVector;
            if (v5 != null) {
                return v5;
            }
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        VectorizedAnimationSpec vectorizedAnimationSpec = this;
        V v6 = v;
        V v7 = v2;
        V v8 = v3;
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(vectorizedAnimationSpec, clampPlayTime - 1, v6, v7, v8);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(vectorizedAnimationSpec, clampPlayTime, v6, v7, v8);
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        while (i < size$animation_core_release) {
            V v9 = this.velocityVector;
            if (v9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v9 = null;
            }
            v9.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
            i++;
        }
        V v10 = this.velocityVector;
        if (v10 != null) {
            return v10;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    private final float getEasedTime(int i) {
        return getEasedTimeFromIndex(findEntryForTimeMillis(i), i, false);
    }

    private final float getEasedTimeFromIndex(int i, int i2, boolean z) {
        Easing easing;
        float f;
        if (i >= this.timestamps._size - 1) {
            f = (float) i2;
        } else {
            int i3 = this.timestamps.get(i);
            int i4 = this.timestamps.get(i + 1);
            if (i2 == i3) {
                f = (float) i3;
            } else {
                int i5 = i4 - i3;
                VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = this.keyframes.get(i3);
                if (vectorizedKeyframeSpecElementInfo == null || (easing = vectorizedKeyframeSpecElementInfo.getEasing()) == null) {
                    easing = this.defaultEasing;
                }
                float f2 = (float) i5;
                float transform = easing.transform(((float) (i2 - i3)) / f2);
                if (z) {
                    return transform;
                }
                f = (f2 * transform) + ((float) i3);
            }
        }
        return f / ((float) 1000);
    }

    private final int findEntryForTimeMillis(int i) {
        int binarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, i, 0, 0, 6, (Object) null);
        return binarySearch$default < -1 ? -(binarySearch$default + 2) : binarySearch$default;
    }
}
