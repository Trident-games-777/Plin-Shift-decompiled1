package com.plinkofortune.cash.winspin.profile;

import android.webkit.CookieManager;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd$flushCookies$1", f = "PcAtMNHQpJHd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PcAtMNHQpJHd.kt */
final class PcAtMNHQpJHd$flushCookies$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    PcAtMNHQpJHd$flushCookies$1(Continuation<? super PcAtMNHQpJHd$flushCookies$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PcAtMNHQpJHd$flushCookies$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PcAtMNHQpJHd$flushCookies$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                CookieManager.getInstance().flush();
            } catch (Throwable unused) {
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{45, -85, -81, -24, -121, 40, 51, -47, 105, -72, -90, -9, -46, 49, 57, -42, 110, -88, -90, -30, -56, 46, 57, -47, 105, -93, -83, -14, -56, 55, 57, -42, 110, -67, -86, -16, -49, 124, Utf8.REPLACEMENT_BYTE, -98, 60, -91, -74, -16, -50, 50, 57}, new byte[]{78, -54, -61, -124, -89, 92, 92, -15}));
    }
}
