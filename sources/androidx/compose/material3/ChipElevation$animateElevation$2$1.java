package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ChipElevation$animateElevation$2$1", f = "Chip.kt", i = {}, l = {2241, 2243}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Chip.kt */
final class ChipElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ MutableState<Interaction> $lastInteraction$delegate;
    final /* synthetic */ float $target;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipElevation$animateElevation$2$1(Animatable<Dp, AnimationVector1D> animatable, float f, boolean z, Interaction interaction, MutableState<Interaction> mutableState, Continuation<? super ChipElevation$animateElevation$2$1> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z;
        this.$interaction = interaction;
        this.$lastInteraction$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChipElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.$interaction, this.$lastInteraction$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChipElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (r6.$animatable.snapTo(androidx.compose.ui.unit.Dp.m7109boximpl(r6.$target), r6) == r0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        if (androidx.compose.material3.internal.ElevationKt.m2916animateElevationrAjV9yQ(r6.$animatable, r6.$target, r7, r6.$interaction, r6) == r0) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 == r3) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0062
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r7 = r6.$animatable
            java.lang.Object r7 = r7.getTargetValue()
            androidx.compose.ui.unit.Dp r7 = (androidx.compose.ui.unit.Dp) r7
            float r7 = r7.m7125unboximpl()
            float r1 = r6.$target
            boolean r7 = androidx.compose.ui.unit.Dp.m7116equalsimpl0(r7, r1)
            if (r7 != 0) goto L_0x0069
            boolean r7 = r6.$enabled
            if (r7 != 0) goto L_0x004a
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r7 = r6.$animatable
            float r1 = r6.$target
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m7109boximpl(r1)
            r2 = r6
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r6.label = r3
            java.lang.Object r7 = r7.snapTo(r1, r2)
            if (r7 != r0) goto L_0x0062
            goto L_0x0061
        L_0x004a:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.Interaction> r7 = r6.$lastInteraction$delegate
            androidx.compose.foundation.interaction.Interaction r7 = androidx.compose.material3.ChipElevation.animateElevation$lambda$2(r7)
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r1 = r6.$animatable
            float r3 = r6.$target
            androidx.compose.foundation.interaction.Interaction r4 = r6.$interaction
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.label = r2
            java.lang.Object r7 = androidx.compose.material3.internal.ElevationKt.m2916animateElevationrAjV9yQ(r1, r3, r7, r4, r5)
            if (r7 != r0) goto L_0x0062
        L_0x0061:
            return r0
        L_0x0062:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.Interaction> r7 = r6.$lastInteraction$delegate
            androidx.compose.foundation.interaction.Interaction r0 = r6.$interaction
            androidx.compose.material3.ChipElevation.animateElevation$lambda$3(r7, r0)
        L_0x0069:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipElevation$animateElevation$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
