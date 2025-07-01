package com.plinkofortune.cash.winspin.pream;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableFloatState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1", f = "PreamAnim.kt", i = {}, l = {55, 62, 69}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PreamAnim.kt */
final class PreamAnimKt$progressUpdatable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animka;
    final /* synthetic */ MutableFloatState $progress;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreamAnimKt$progressUpdatable$1$1(MutableFloatState mutableFloatState, Animatable<Float, AnimationVector1D> animatable, Continuation<? super PreamAnimKt$progressUpdatable$1$1> continuation) {
        super(2, continuation);
        this.$progress = mutableFloatState;
        this.$animka = animatable;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreamAnimKt$progressUpdatable$1$1(this.$progress, this.$animka, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PreamAnimKt$progressUpdatable$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0070, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0.$animka, kotlin.coroutines.jvm.internal.Boxing.boxFloat(50.0f), androidx.compose.animation.core.AnimationSpecKt.tween$default(11000, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), 2, (java.lang.Object) null), (java.lang.Object) null, new com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1$$ExternalSyntheticLambda0(r0.$progress), r0, 4, (java.lang.Object) null) == r1) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a5, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0.$animka, kotlin.coroutines.jvm.internal.Boxing.boxFloat(75.0f), androidx.compose.animation.core.AnimationSpecKt.tween$default(18000, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), 2, (java.lang.Object) null), (java.lang.Object) null, new com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1$$ExternalSyntheticLambda1(r0.$progress), r0, 4, (java.lang.Object) null) == r1) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00db, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0.$animka, kotlin.coroutines.jvm.internal.Boxing.boxFloat(99.0f), androidx.compose.animation.core.AnimationSpecKt.tween$default(170000, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), 2, (java.lang.Object) null), (java.lang.Object) null, new com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1$$ExternalSyntheticLambda2(r0.$progress), r0, 4, (java.lang.Object) null) == r1) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00dd, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 1
            r5 = 0
            r6 = 0
            r7 = 2
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0036
            if (r2 == r7) goto L_0x0032
            if (r2 != r3) goto L_0x001a
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x00de
        L_0x001a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r2 = 47
            byte[] r2 = new byte[r2]
            r2 = {-107, -121, 92, -104, -108, -50, 78, -116, -47, -108, 85, -121, -63, -41, 68, -117, -42, -124, 85, -110, -37, -56, 68, -116, -47, -113, 94, -126, -37, -47, 68, -117, -42, -111, 89, -128, -36, -102, 66, -61, -124, -119, 69, -128, -35, -44, 68} // fill-array
            r3 = 8
            byte[] r3 = new byte[r3]
            r3 = {-10, -26, 48, -12, -76, -70, 33, -84} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x00a8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x0073
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r18)
            androidx.compose.runtime.MutableFloatState r2 = r0.$progress
            float r2 = r2.getFloatValue()
            r8 = 1112014848(0x42480000, float:50.0)
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0073
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r9 = r0.$animka
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            r2 = 11000(0x2af8, float:1.5414E-41)
            androidx.compose.animation.core.Easing r8 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r6, r8, r7, r5)
            r11 = r2
            androidx.compose.animation.core.AnimationSpec r11 = (androidx.compose.animation.core.AnimationSpec) r11
            androidx.compose.runtime.MutableFloatState r2 = r0.$progress
            com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1$$ExternalSyntheticLambda0 r13 = new com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1$$ExternalSyntheticLambda0
            r13.<init>(r2)
            r14 = r0
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r0.label = r4
            r12 = 0
            r15 = 4
            r16 = 0
            java.lang.Object r2 = androidx.compose.animation.core.Animatable.animateTo$default(r9, r10, r11, r12, r13, r14, r15, r16)
            if (r2 != r1) goto L_0x0073
            goto L_0x00dd
        L_0x0073:
            androidx.compose.runtime.MutableFloatState r2 = r0.$progress
            float r2 = r2.getFloatValue()
            r4 = 1117126656(0x42960000, float:75.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x00a8
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r8 = r0.$animka
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            r2 = 18000(0x4650, float:2.5223E-41)
            androidx.compose.animation.core.Easing r4 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r6, r4, r7, r5)
            r10 = r2
            androidx.compose.animation.core.AnimationSpec r10 = (androidx.compose.animation.core.AnimationSpec) r10
            androidx.compose.runtime.MutableFloatState r2 = r0.$progress
            com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1$$ExternalSyntheticLambda1 r12 = new com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1$$ExternalSyntheticLambda1
            r12.<init>(r2)
            r13 = r0
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r0.label = r7
            r11 = 0
            r14 = 4
            r15 = 0
            java.lang.Object r2 = androidx.compose.animation.core.Animatable.animateTo$default(r8, r9, r10, r11, r12, r13, r14, r15)
            if (r2 != r1) goto L_0x00a8
            goto L_0x00dd
        L_0x00a8:
            androidx.compose.runtime.MutableFloatState r2 = r0.$progress
            float r2 = r2.getFloatValue()
            r4 = 1120272384(0x42c60000, float:99.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x00de
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r8 = r0.$animka
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            r2 = 170000(0x29810, float:2.38221E-40)
            androidx.compose.animation.core.Easing r4 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r6, r4, r7, r5)
            r10 = r2
            androidx.compose.animation.core.AnimationSpec r10 = (androidx.compose.animation.core.AnimationSpec) r10
            androidx.compose.runtime.MutableFloatState r2 = r0.$progress
            com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1$$ExternalSyntheticLambda2 r12 = new com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1$$ExternalSyntheticLambda2
            r12.<init>(r2)
            r13 = r0
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r0.label = r3
            r11 = 0
            r14 = 4
            r15 = 0
            java.lang.Object r2 = androidx.compose.animation.core.Animatable.animateTo$default(r8, r9, r10, r11, r12, r13, r14, r15)
            if (r2 != r1) goto L_0x00de
        L_0x00dd:
            return r1
        L_0x00de:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.pream.PreamAnimKt$progressUpdatable$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(MutableFloatState mutableFloatState, Animatable animatable) {
        mutableFloatState.setFloatValue(((Number) animatable.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(MutableFloatState mutableFloatState, Animatable animatable) {
        mutableFloatState.setFloatValue(((Number) animatable.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(MutableFloatState mutableFloatState, Animatable animatable) {
        mutableFloatState.setFloatValue(((Number) animatable.getValue()).floatValue());
        return Unit.INSTANCE;
    }
}
