package com.plinkofortune.cash.winspin;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.MortalKt$mortal$1$1$1", f = "Mortal.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Mortal.kt */
final class MortalKt$mortal$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interact;
    final /* synthetic */ MutableState<Boolean> $pressed$delegate;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MortalKt$mortal$1$1$1(MutableInteractionSource mutableInteractionSource, MutableState<Boolean> mutableState, Continuation<? super MortalKt$mortal$1$1$1> continuation) {
        super(2, continuation);
        this.$interact = mutableInteractionSource;
        this.$pressed$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MortalKt$mortal$1$1$1(this.$interact, this.$pressed$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MortalKt$mortal$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Interaction> interactions = this.$interact.getInteractions();
            final MutableState<Boolean> mutableState = this.$pressed$delegate;
            this.label = 1;
            if (interactions.collect(new FlowCollector() {
                public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
                    MortalKt$mortal$1.invoke$lambda$2(mutableState, interaction instanceof PressInteraction.Press);
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{-76, -79, 90, Ascii.VT, -32, -107, 112, -59, -16, -94, 83, Ascii.DC4, -75, -116, 122, -62, -9, -78, 83, 1, -81, -109, 122, -59, -16, -71, 88, 17, -81, -118, 122, -62, -9, -89, 95, 19, -88, -63, 124, -118, -91, -65, 67, 19, -87, -113, 122}, new byte[]{-41, -48, 54, 103, -64, -31, Ascii.US, -27}));
        }
        return Unit.INSTANCE;
    }
}
