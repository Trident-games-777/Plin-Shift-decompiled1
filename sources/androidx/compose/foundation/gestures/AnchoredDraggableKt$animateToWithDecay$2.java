package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2", f = "AnchoredDraggable.kt", i = {}, l = {1059, 1077, 1092}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableKt$animateToWithDecay$2 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.FloatRef $remainingVelocity;
    final /* synthetic */ AnchoredDraggableState<T> $this_animateToWithDecay;
    final /* synthetic */ float $velocity;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$animateToWithDecay$2(AnchoredDraggableState<T> anchoredDraggableState, float f, Ref.FloatRef floatRef, Continuation<? super AnchoredDraggableKt$animateToWithDecay$2> continuation) {
        super(4, continuation);
        this.$this_animateToWithDecay = anchoredDraggableState;
        this.$velocity = f;
        this.$remainingVelocity = floatRef;
    }

    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
        AnchoredDraggableKt$animateToWithDecay$2 anchoredDraggableKt$animateToWithDecay$2 = new AnchoredDraggableKt$animateToWithDecay$2(this.$this_animateToWithDecay, this.$velocity, this.$remainingVelocity, continuation);
        anchoredDraggableKt$animateToWithDecay$2.L$0 = anchoredDragScope;
        anchoredDraggableKt$animateToWithDecay$2.L$1 = draggableAnchors;
        anchoredDraggableKt$animateToWithDecay$2.L$2 = t;
        return anchoredDraggableKt$animateToWithDecay$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cf, code lost:
        if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r22, r23, false, new androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2.AnonymousClass3(), r0, 2, (java.lang.Object) null) == r1) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e2, code lost:
        if (androidx.compose.foundation.gestures.AnchoredDraggableKt.access$animateTo(r7, r8, r9, r10, r11, r0) == r1) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fc, code lost:
        if (androidx.compose.foundation.gestures.AnchoredDraggableKt.access$animateTo(r7, r8, r9, r10, r11, r0) == r1) goto L_0x00fe;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            r29 = this;
            r0 = r29
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x002b
            if (r2 == r5) goto L_0x0026
            if (r2 == r4) goto L_0x0021
            if (r2 != r3) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r30)
            goto L_0x00e5
        L_0x0019:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r30)
            goto L_0x0103
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r30)
            goto L_0x00ff
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r30)
            java.lang.Object r2 = r0.L$0
            r9 = r2
            androidx.compose.foundation.gestures.AnchoredDragScope r9 = (androidx.compose.foundation.gestures.AnchoredDragScope) r9
            java.lang.Object r2 = r0.L$1
            r10 = r2
            androidx.compose.foundation.gestures.DraggableAnchors r10 = (androidx.compose.foundation.gestures.DraggableAnchors) r10
            java.lang.Object r11 = r0.L$2
            float r2 = r10.positionOf(r11)
            boolean r7 = java.lang.Float.isNaN(r2)
            if (r7 != 0) goto L_0x0103
            kotlin.jvm.internal.Ref$FloatRef r7 = new kotlin.jvm.internal.Ref$FloatRef
            r7.<init>()
            androidx.compose.foundation.gestures.AnchoredDraggableState<T> r8 = r0.$this_animateToWithDecay
            float r8 = r8.getOffset()
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x0057
            r8 = r6
            goto L_0x005d
        L_0x0057:
            androidx.compose.foundation.gestures.AnchoredDraggableState<T> r8 = r0.$this_animateToWithDecay
            float r8 = r8.getOffset()
        L_0x005d:
            r7.element = r8
            float r8 = r7.element
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0067
            goto L_0x0103
        L_0x0067:
            float r8 = r0.$velocity
            float r12 = r7.element
            float r12 = r2 - r12
            float r8 = r8 * r12
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            r12 = 0
            if (r8 < 0) goto L_0x00ea
            float r8 = r0.$velocity
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x007b
            goto L_0x00ea
        L_0x007b:
            androidx.compose.foundation.gestures.AnchoredDraggableState<T> r5 = r0.$this_animateToWithDecay
            androidx.compose.animation.core.DecayAnimationSpec r5 = r5.getDecayAnimationSpec()
            float r8 = r7.element
            float r13 = r0.$velocity
            float r5 = androidx.compose.animation.core.DecayAnimationSpecKt.calculateTargetValue(r5, r8, r13)
            float r8 = r0.$velocity
            int r13 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r13 <= 0) goto L_0x0094
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x00d2
            goto L_0x0098
        L_0x0094:
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x00d2
        L_0x0098:
            float r13 = r7.element
            float r14 = r0.$velocity
            r20 = 28
            r21 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            androidx.compose.animation.core.AnimationState r22 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)
            androidx.compose.foundation.gestures.AnchoredDraggableState<T> r3 = r0.$this_animateToWithDecay
            androidx.compose.animation.core.DecayAnimationSpec r23 = r3.getDecayAnimationSpec()
            androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2$3 r3 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2$3
            kotlin.jvm.internal.Ref$FloatRef r5 = r0.$remainingVelocity
            r3.<init>(r2, r9, r5, r7)
            r25 = r3
            kotlin.jvm.functions.Function1 r25 = (kotlin.jvm.functions.Function1) r25
            r26 = r0
            kotlin.coroutines.Continuation r26 = (kotlin.coroutines.Continuation) r26
            r0.L$0 = r12
            r0.L$1 = r12
            r0.label = r4
            r24 = 0
            r27 = 2
            r28 = 0
            java.lang.Object r2 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r22, r23, r24, r25, r26, r27, r28)
            if (r2 != r1) goto L_0x0103
            goto L_0x00fe
        L_0x00d2:
            androidx.compose.foundation.gestures.AnchoredDraggableState<T> r7 = r0.$this_animateToWithDecay
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.L$0 = r12
            r0.L$1 = r12
            r0.label = r3
            r12 = r2
            java.lang.Object r2 = androidx.compose.foundation.gestures.AnchoredDraggableKt.animateTo(r7, r8, r9, r10, r11, r12)
            if (r2 != r1) goto L_0x00e5
            goto L_0x00fe
        L_0x00e5:
            kotlin.jvm.internal.Ref$FloatRef r1 = r0.$remainingVelocity
            r1.element = r6
            goto L_0x0103
        L_0x00ea:
            androidx.compose.foundation.gestures.AnchoredDraggableState<T> r7 = r0.$this_animateToWithDecay
            float r8 = r0.$velocity
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.L$0 = r12
            r0.L$1 = r12
            r0.label = r5
            r12 = r2
            java.lang.Object r2 = androidx.compose.foundation.gestures.AnchoredDraggableKt.animateTo(r7, r8, r9, r10, r11, r12)
            if (r2 != r1) goto L_0x00ff
        L_0x00fe:
            return r1
        L_0x00ff:
            kotlin.jvm.internal.Ref$FloatRef r1 = r0.$remainingVelocity
            r1.element = r6
        L_0x0103:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
