package com.plinkofortune.cash.winspin;

import android.content.Intent;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.teach.TeachScreenKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.Soleq$onCreate$2", f = "Soleq.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Soleq.kt */
final class Soleq$onCreate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Soleq this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Soleq$onCreate$2(Soleq soleq, Continuation<? super Soleq$onCreate$2> continuation) {
        super(2, continuation);
        this.this$0 = soleq;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Soleq$onCreate$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Soleq$onCreate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(504, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{110, -70, -20, -106, -72, -5, 79, -109, 42, -87, -27, -119, -19, -30, 69, -108, 45, -71, -27, -100, -9, -3, 69, -109, 42, -78, -18, -116, -9, -28, 69, -108, 45, -84, -23, -114, -16, -81, 67, -36, Byte.MAX_VALUE, -76, -11, -114, -15, -31, 69}, new byte[]{Ascii.CR, -37, Byte.MIN_VALUE, -6, -104, -113, 32, -77}));
        }
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, StringFog.decrypt(new byte[]{-17, -98, 68, 54, -48, 17, -75, -52, -4, -45, Ascii.RS, 81, -112, 76}, new byte[]{-120, -5, 48, Byte.MAX_VALUE, -66, 101, -48, -94}));
        TeachScreenKt.naDUtZcftJZ(intent);
        this.this$0.skc = false;
        return Unit.INSTANCE;
    }
}
