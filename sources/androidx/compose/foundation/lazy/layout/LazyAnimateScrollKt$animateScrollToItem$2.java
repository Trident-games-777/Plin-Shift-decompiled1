package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {174, 272}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$scroll"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "F$2", "I$0", "L$0"})
/* compiled from: LazyAnimateScroll.kt */
final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Density $density;
    final /* synthetic */ int $index;
    final /* synthetic */ int $numOfItemsForTeleport;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToItem;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyAnimateScrollKt$animateScrollToItem$2(int i, Density density, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i2, int i3, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$density = density;
        this.$this_animateScrollToItem = lazyLayoutAnimateScrollScope;
        this.$scrollOffset = i2;
        this.$numOfItemsForTeleport = i3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$density, this.$this_animateScrollToItem, this.$scrollOffset, this.$numOfItemsForTeleport, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: androidx.compose.foundation.gestures.ScrollScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e1 A[Catch:{ ItemFoundInScroll -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ee A[Catch:{ ItemFoundInScroll -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0130 A[Catch:{ ItemFoundInScroll -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0134 A[Catch:{ ItemFoundInScroll -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x018c A[Catch:{ ItemFoundInScroll -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0218  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r37) {
        /*
            r36 = this;
            r1 = r36
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 2
            r4 = 0
            r6 = 1
            if (r0 == 0) goto L_0x004a
            if (r0 == r6) goto L_0x0022
            if (r0 != r3) goto L_0x001a
            java.lang.Object r0 = r1.L$0
            androidx.compose.foundation.gestures.ScrollScope r0 = (androidx.compose.foundation.gestures.ScrollScope) r0
            kotlin.ResultKt.throwOnFailure(r37)
            goto L_0x0219
        L_0x001a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0022:
            int r0 = r1.I$0
            float r7 = r1.F$2
            float r8 = r1.F$1
            float r9 = r1.F$0
            java.lang.Object r10 = r1.L$3
            kotlin.jvm.internal.Ref$IntRef r10 = (kotlin.jvm.internal.Ref.IntRef) r10
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$1
            kotlin.jvm.internal.Ref$BooleanRef r12 = (kotlin.jvm.internal.Ref.BooleanRef) r12
            java.lang.Object r13 = r1.L$0
            androidx.compose.foundation.gestures.ScrollScope r13 = (androidx.compose.foundation.gestures.ScrollScope) r13
            kotlin.ResultKt.throwOnFailure(r37)     // Catch:{ ItemFoundInScroll -> 0x0045 }
            r26 = r4
            r16 = r8
            r8 = r9
            r14 = r12
            goto L_0x018f
        L_0x0045:
            r0 = move-exception
            r26 = r4
            goto L_0x01ba
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r37)
            java.lang.Object r0 = r1.L$0
            r7 = r0
            androidx.compose.foundation.gestures.ScrollScope r7 = (androidx.compose.foundation.gestures.ScrollScope) r7
            int r0 = r1.$index
            float r8 = (float) r0
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x005b
            r8 = r6
            goto L_0x005c
        L_0x005b:
            r8 = 0
        L_0x005c:
            if (r8 == 0) goto L_0x0225
            androidx.compose.ui.unit.Density r0 = r1.$density     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            float r8 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.TargetDistance     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            float r0 = r0.m7091toPx0680j_4(r8)     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            androidx.compose.ui.unit.Density r8 = r1.$density     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            float r9 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.BoundDistance     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            float r8 = r8.m7091toPx0680j_4(r9)     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            androidx.compose.ui.unit.Density r9 = r1.$density     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            float r10 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.MinimumDistance     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            float r9 = r9.m7091toPx0680j_4(r10)     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            kotlin.jvm.internal.Ref$BooleanRef r10 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r10.<init>()     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r10.element = r6     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r11.<init>()     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r19 = 30
            r20 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            androidx.compose.animation.core.AnimationState r12 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r12, r13, r14, r16, r18, r19, r20)     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r11.element = r12     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r12 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            int r13 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            boolean r12 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.isItemVisible(r12, r13)     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            if (r12 != 0) goto L_0x019c
            int r12 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r13 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            int r13 = r13.getFirstVisibleItemIndex()     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            if (r12 <= r13) goto L_0x00b0
            r12 = r6
            goto L_0x00b1
        L_0x00b0:
            r12 = 0
        L_0x00b1:
            kotlin.jvm.internal.Ref$IntRef r13 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r13.<init>()     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r13.element = r6     // Catch:{ ItemFoundInScroll -> 0x01b6 }
            r16 = r8
            r14 = r10
            r17 = r13
            r8 = r0
            r13 = r7
            r7 = r9
            r0 = r12
        L_0x00c1:
            boolean r9 = r14.element     // Catch:{ ItemFoundInScroll -> 0x0045 }
            if (r9 == 0) goto L_0x0222
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r9 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0045 }
            int r9 = r9.getItemCount()     // Catch:{ ItemFoundInScroll -> 0x0045 }
            if (r9 <= 0) goto L_0x0222
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r9 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0045 }
            int r10 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x0045 }
            float r9 = r9.calculateDistanceTo(r10)     // Catch:{ ItemFoundInScroll -> 0x0045 }
            int r10 = r1.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x0045 }
            float r10 = (float) r10     // Catch:{ ItemFoundInScroll -> 0x0045 }
            float r9 = r9 + r10
            float r10 = java.lang.Math.abs(r9)     // Catch:{ ItemFoundInScroll -> 0x0045 }
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x00ee
            float r9 = java.lang.Math.abs(r9)     // Catch:{ ItemFoundInScroll -> 0x0045 }
            float r9 = java.lang.Math.max(r9, r7)     // Catch:{ ItemFoundInScroll -> 0x0045 }
            if (r0 == 0) goto L_0x00ec
            goto L_0x00f3
        L_0x00ec:
            float r9 = -r9
            goto L_0x00f3
        L_0x00ee:
            if (r0 == 0) goto L_0x00f2
            r9 = r8
            goto L_0x00f3
        L_0x00f2:
            float r9 = -r8
        L_0x00f3:
            T r10 = r11.element     // Catch:{ ItemFoundInScroll -> 0x0045 }
            r18 = r10
            androidx.compose.animation.core.AnimationState r18 = (androidx.compose.animation.core.AnimationState) r18     // Catch:{ ItemFoundInScroll -> 0x0045 }
            r26 = 30
            r27 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            androidx.compose.animation.core.AnimationState r10 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r18, (float) r19, (float) r20, (long) r21, (long) r23, (boolean) r25, (int) r26, (java.lang.Object) r27)     // Catch:{ ItemFoundInScroll -> 0x0045 }
            r11.element = r10     // Catch:{ ItemFoundInScroll -> 0x0045 }
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef     // Catch:{ ItemFoundInScroll -> 0x0045 }
            r12.<init>()     // Catch:{ ItemFoundInScroll -> 0x0045 }
            T r10 = r11.element     // Catch:{ ItemFoundInScroll -> 0x0045 }
            r21 = r10
            androidx.compose.animation.core.AnimationState r21 = (androidx.compose.animation.core.AnimationState) r21     // Catch:{ ItemFoundInScroll -> 0x0045 }
            java.lang.Float r22 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)     // Catch:{ ItemFoundInScroll -> 0x0045 }
            T r10 = r11.element     // Catch:{ ItemFoundInScroll -> 0x0045 }
            androidx.compose.animation.core.AnimationState r10 = (androidx.compose.animation.core.AnimationState) r10     // Catch:{ ItemFoundInScroll -> 0x0045 }
            java.lang.Object r10 = r10.getVelocity()     // Catch:{ ItemFoundInScroll -> 0x0045 }
            java.lang.Number r10 = (java.lang.Number) r10     // Catch:{ ItemFoundInScroll -> 0x0045 }
            float r10 = r10.floatValue()     // Catch:{ ItemFoundInScroll -> 0x0045 }
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r23 = r21
            if (r10 != 0) goto L_0x0134
            r21 = 0
        L_0x0132:
            r10 = r8
            goto L_0x0137
        L_0x0134:
            r21 = r6
            goto L_0x0132
        L_0x0137:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3 r8 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3     // Catch:{ ItemFoundInScroll -> 0x0045 }
            r20 = r11
            r11 = r9
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r9 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x0045 }
            r15 = r10
            int r10 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x0045 }
            r18 = r15
            if (r0 == 0) goto L_0x0147
            r15 = r6
            goto L_0x0148
        L_0x0147:
            r15 = 0
        L_0x0148:
            r26 = r4
            int r4 = r1.$numOfItemsForTeleport     // Catch:{ ItemFoundInScroll -> 0x019a }
            int r5 = r1.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x019a }
            r19 = r18
            r18 = r4
            r4 = r19
            r19 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ ItemFoundInScroll -> 0x019a }
            r5 = r8
            r8 = r16
            r10 = r17
            r11 = r20
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ ItemFoundInScroll -> 0x019a }
            r18 = r23
            r23 = r1
            kotlin.coroutines.Continuation r23 = (kotlin.coroutines.Continuation) r23     // Catch:{ ItemFoundInScroll -> 0x019a }
            r1.L$0 = r13     // Catch:{ ItemFoundInScroll -> 0x019a }
            r1.L$1 = r14     // Catch:{ ItemFoundInScroll -> 0x019a }
            r1.L$2 = r11     // Catch:{ ItemFoundInScroll -> 0x019a }
            r1.L$3 = r10     // Catch:{ ItemFoundInScroll -> 0x019a }
            r1.F$0 = r4     // Catch:{ ItemFoundInScroll -> 0x019a }
            r1.F$1 = r8     // Catch:{ ItemFoundInScroll -> 0x019a }
            r1.F$2 = r7     // Catch:{ ItemFoundInScroll -> 0x019a }
            r1.I$0 = r0     // Catch:{ ItemFoundInScroll -> 0x019a }
            r1.label = r6     // Catch:{ ItemFoundInScroll -> 0x019a }
            r20 = 0
            r24 = 2
            r25 = 0
            r19 = r22
            r22 = r5
            java.lang.Object r5 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ ItemFoundInScroll -> 0x019a }
            if (r5 != r2) goto L_0x018c
            goto L_0x0217
        L_0x018c:
            r16 = r8
            r8 = r4
        L_0x018f:
            int r4 = r10.element     // Catch:{ ItemFoundInScroll -> 0x019a }
            int r4 = r4 + r6
            r10.element = r4     // Catch:{ ItemFoundInScroll -> 0x019a }
            r17 = r10
            r4 = r26
            goto L_0x00c1
        L_0x019a:
            r0 = move-exception
            goto L_0x01ba
        L_0x019c:
            r26 = r4
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r0 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01b4 }
            int r4 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01b4 }
            float r0 = r0.calculateDistanceTo(r4)     // Catch:{ ItemFoundInScroll -> 0x01b4 }
            int r0 = kotlin.math.MathKt.roundToInt((float) r0)     // Catch:{ ItemFoundInScroll -> 0x01b4 }
            androidx.compose.foundation.lazy.layout.ItemFoundInScroll r4 = new androidx.compose.foundation.lazy.layout.ItemFoundInScroll     // Catch:{ ItemFoundInScroll -> 0x01b4 }
            T r5 = r11.element     // Catch:{ ItemFoundInScroll -> 0x01b4 }
            androidx.compose.animation.core.AnimationState r5 = (androidx.compose.animation.core.AnimationState) r5     // Catch:{ ItemFoundInScroll -> 0x01b4 }
            r4.<init>(r0, r5)     // Catch:{ ItemFoundInScroll -> 0x01b4 }
            throw r4     // Catch:{ ItemFoundInScroll -> 0x01b4 }
        L_0x01b4:
            r0 = move-exception
            goto L_0x01b9
        L_0x01b6:
            r0 = move-exception
            r26 = r4
        L_0x01b9:
            r13 = r7
        L_0x01ba:
            androidx.compose.animation.core.AnimationState r14 = r0.getPreviousAnimation()
            r22 = 30
            r23 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            androidx.compose.animation.core.AnimationState r28 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r14, (float) r15, (float) r16, (long) r17, (long) r19, (boolean) r21, (int) r22, (java.lang.Object) r23)
            int r0 = r0.getItemOffset()
            int r4 = r1.$scrollOffset
            int r0 = r0 + r4
            float r0 = (float) r0
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            java.lang.Float r29 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r0)
            java.lang.Object r5 = r28.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            int r5 = (r5 > r26 ? 1 : (r5 == r26 ? 0 : -1))
            if (r5 != 0) goto L_0x01f0
            r5 = r6
            goto L_0x01f1
        L_0x01f0:
            r5 = 0
        L_0x01f1:
            r31 = r5 ^ 1
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5 r5 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5
            r5.<init>(r0, r4, r13)
            r32 = r5
            kotlin.jvm.functions.Function1 r32 = (kotlin.jvm.functions.Function1) r32
            r33 = r1
            kotlin.coroutines.Continuation r33 = (kotlin.coroutines.Continuation) r33
            r1.L$0 = r13
            r0 = 0
            r1.L$1 = r0
            r1.L$2 = r0
            r1.L$3 = r0
            r1.label = r3
            r30 = 0
            r34 = 2
            r35 = 0
            java.lang.Object r0 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r28, r29, r30, r31, r32, r33, r34, r35)
            if (r0 != r2) goto L_0x0218
        L_0x0217:
            return r2
        L_0x0218:
            r0 = r13
        L_0x0219:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r2 = r1.$this_animateScrollToItem
            int r3 = r1.$index
            int r4 = r1.$scrollOffset
            r2.snapToItem(r0, r3, r4)
        L_0x0222:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0225:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Index should be non-negative ("
            r2.<init>(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            r2 = 41
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean z, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, int i2) {
        if (z) {
            if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() > i) {
                return true;
            }
            return lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() > i2;
        } else if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() < i) {
            return true;
        } else {
            return lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() < i2;
        }
    }
}
