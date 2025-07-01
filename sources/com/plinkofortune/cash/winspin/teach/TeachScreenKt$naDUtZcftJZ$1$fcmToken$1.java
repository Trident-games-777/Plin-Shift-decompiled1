package com.plinkofortune.cash.winspin.teach;

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
@DebugMetadata(c = "com.plinkofortune.cash.winspin.teach.TeachScreenKt$naDUtZcftJZ$1$fcmToken$1", f = "TeachScreen.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TeachScreen.kt */
final class TeachScreenKt$naDUtZcftJZ$1$fcmToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    TeachScreenKt$naDUtZcftJZ$1$fcmToken$1(Continuation<? super TeachScreenKt$naDUtZcftJZ$1$fcmToken$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeachScreenKt$naDUtZcftJZ$1$fcmToken$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((TeachScreenKt$naDUtZcftJZ$1$fcmToken$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Task<String> token = FirebaseMessaging.getInstance().getToken();
            Intrinsics.checkNotNullExpressionValue(token, StringFog.decrypt(new byte[]{-1, -4, -74, 68, -58, 82, -82, 36, -80, -73, -20, 62, Byte.MIN_VALUE}, new byte[]{-104, -103, -62, Ascii.DLE, -87, 57, -53, 74}));
            this.label = 1;
            Object await = TasksKt.await(token, this);
            return await == coroutine_suspended ? coroutine_suspended : await;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{-36, -115, 71, -79, 101, 69, 114, 91, -104, -98, 78, -82, 48, 92, 120, 92, -97, -114, 78, -69, 42, 67, 120, 91, -104, -123, 69, -85, 42, 90, 120, 92, -97, -101, 66, -87, 45, 17, 126, Ascii.DC4, -51, -125, 94, -87, 44, 95, 120}, new byte[]{-65, -20, 43, -35, 69, 49, Ascii.GS, 123}));
        }
    }
}
