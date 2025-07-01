package com.plinkofortune.cash.winspin.terms;

import androidx.fragment.app.FragmentActivity;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.terms.XwqWGZEeOAxxKt$tympsmAacFI$1", f = "XwqWGZEeOAxx.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: XwqWGZEeOAxx.kt */
final class XwqWGZEeOAxxKt$tympsmAacFI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $a7;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    XwqWGZEeOAxxKt$tympsmAacFI$1(FragmentActivity fragmentActivity, Continuation<? super XwqWGZEeOAxxKt$tympsmAacFI$1> continuation) {
        super(2, continuation);
        this.$a7 = fragmentActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XwqWGZEeOAxxKt$tympsmAacFI$1(this.$a7, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((XwqWGZEeOAxxKt$tympsmAacFI$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (EvUYlHumoDFUKt.zTpyAYOMXPnR(this.$a7.getActivityResultRegistry(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{Ascii.CAN, 86, Ascii.EM, 2, 80, 35, -59, -91, 92, 69, Ascii.DLE, Ascii.GS, 5, 58, -49, -94, 91, 85, Ascii.DLE, 8, Ascii.US, 37, -49, -91, 92, 94, Ascii.ESC, Ascii.CAN, Ascii.US, 60, -49, -94, 91, SignedBytes.MAX_POWER_OF_TWO, Ascii.FS, Ascii.SUB, Ascii.CAN, 119, -55, -22, 9, 88, 0, Ascii.SUB, Ascii.EM, 57, -49}, new byte[]{123, 55, 117, 110, 112, 87, -86, -123}));
        }
        return Unit.INSTANCE;
    }
}
