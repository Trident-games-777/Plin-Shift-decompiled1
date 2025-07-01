package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2", f = "LazyLayoutItemAnimation.kt", i = {}, l = {195, 197}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LazyLayoutItemAnimation.kt */
final class LazyLayoutItemAnimation$animateAppearance$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GraphicsLayer $layer;
    final /* synthetic */ boolean $shouldResetValue;
    final /* synthetic */ FiniteAnimationSpec<Float> $spec;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemAnimation$animateAppearance$2(boolean z, LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<Float> finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation<? super LazyLayoutItemAnimation$animateAppearance$2> continuation) {
        super(2, continuation);
        this.$shouldResetValue = z;
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = finiteAnimationSpec;
        this.$layer = graphicsLayer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$animateAppearance$2(this.$shouldResetValue, this.this$0, this.$spec, this.$layer, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutItemAnimation$animateAppearance$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r12.this$0.visibilityAnimation, kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f), r12.$spec, (java.lang.Object) null, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2.AnonymousClass1(), r12, 4, (java.lang.Object) null) == r0) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x001f }
            goto L_0x006c
        L_0x0013:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x001f }
            goto L_0x0040
        L_0x001f:
            r0 = move-exception
            r13 = r0
            goto L_0x0074
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r13)
            boolean r13 = r12.$shouldResetValue     // Catch:{ all -> 0x001f }
            if (r13 == 0) goto L_0x0040
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r13 = r12.this$0     // Catch:{ all -> 0x001f }
            androidx.compose.animation.core.Animatable r13 = r13.visibilityAnimation     // Catch:{ all -> 0x001f }
            r1 = 0
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)     // Catch:{ all -> 0x001f }
            r5 = r12
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ all -> 0x001f }
            r12.label = r4     // Catch:{ all -> 0x001f }
            java.lang.Object r13 = r13.snapTo(r1, r5)     // Catch:{ all -> 0x001f }
            if (r13 != r0) goto L_0x0040
            goto L_0x006b
        L_0x0040:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r13 = r12.this$0     // Catch:{ all -> 0x001f }
            androidx.compose.animation.core.Animatable r4 = r13.visibilityAnimation     // Catch:{ all -> 0x001f }
            r13 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)     // Catch:{ all -> 0x001f }
            androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r13 = r12.$spec     // Catch:{ all -> 0x001f }
            r6 = r13
            androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6     // Catch:{ all -> 0x001f }
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2$1 r13 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2$1     // Catch:{ all -> 0x001f }
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = r12.$layer     // Catch:{ all -> 0x001f }
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r7 = r12.this$0     // Catch:{ all -> 0x001f }
            r13.<init>(r1, r7)     // Catch:{ all -> 0x001f }
            r8 = r13
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch:{ all -> 0x001f }
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x001f }
            r12.label = r3     // Catch:{ all -> 0x001f }
            r7 = 0
            r10 = 4
            r11 = 0
            java.lang.Object r13 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x001f }
            if (r13 != r0) goto L_0x006c
        L_0x006b:
            return r0
        L_0x006c:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r13 = r12.this$0
            r13.setAppearanceAnimationInProgress(r2)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0074:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r0 = r12.this$0
            r0.setAppearanceAnimationInProgress(r2)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
