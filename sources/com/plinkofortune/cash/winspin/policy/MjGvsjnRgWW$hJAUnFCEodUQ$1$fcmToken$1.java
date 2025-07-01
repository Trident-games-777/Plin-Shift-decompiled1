package com.plinkofortune.cash.winspin.policy;

import com.google.android.gms.tasks.Task;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.FirebaseMessaging;
import com.plinkofortune.cash.winspin.StringFog;
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
import kotlinx.coroutines.tasks.TasksKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.policy.MjGvsjnRgWW$hJAUnFCEodUQ$1$fcmToken$1", f = "MjGvsjnRgWW.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MjGvsjnRgWW.kt */
final class MjGvsjnRgWW$hJAUnFCEodUQ$1$fcmToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    MjGvsjnRgWW$hJAUnFCEodUQ$1$fcmToken$1(Continuation<? super MjGvsjnRgWW$hJAUnFCEodUQ$1$fcmToken$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MjGvsjnRgWW$hJAUnFCEodUQ$1$fcmToken$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((MjGvsjnRgWW$hJAUnFCEodUQ$1$fcmToken$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Task<String> token = FirebaseMessaging.getInstance().getToken();
            Intrinsics.checkNotNullExpressionValue(token, StringFog.decrypt(new byte[]{-35, 19, -24, -60, -80, -26, -61, -94, -110, 88, -78, -66, -10}, new byte[]{-70, 118, -100, -112, -33, -115, -90, -52}));
            this.label = 1;
            Object await = TasksKt.await(token, this);
            return await == coroutine_suspended ? coroutine_suspended : await;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{Ascii.ESC, -31, Ascii.SO, -36, -115, -126, -46, -80, 95, -14, 7, -61, -40, -101, -40, -73, 88, -30, 7, -42, -62, -124, -40, -80, 95, -23, Ascii.FF, -58, -62, -99, -40, -73, 88, -9, Ascii.VT, -60, -59, -42, -34, -1, 10, -17, Ascii.ETB, -60, -60, -104, -40}, new byte[]{120, Byte.MIN_VALUE, 98, -80, -83, -10, -67, -112}));
        }
    }
}
