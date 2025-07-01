package com.plinkofortune.cash.winspin.teach;

import android.content.Intent;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import java.io.IOException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.teach.TeachScreenKt$naDUtZcftJZ$1", f = "TeachScreen.kt", i = {0}, l = {45}, m = "invokeSuspend", n = {"trackingId"}, s = {"L$0"})
/* compiled from: TeachScreen.kt */
final class TeachScreenKt$naDUtZcftJZ$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $intent;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeachScreenKt$naDUtZcftJZ$1(Intent intent, Continuation<? super TeachScreenKt$naDUtZcftJZ$1> continuation) {
        super(2, continuation);
        this.$intent = intent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeachScreenKt$naDUtZcftJZ$1(this.$intent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TeachScreenKt$naDUtZcftJZ$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String stringExtra = this.$intent.getStringExtra(StringFog.decrypt(new byte[]{53, Ascii.DC2, -23, Ascii.FF, -45, -68, -87, -52, 8, 4}, new byte[]{65, 96, -120, 111, -72, -43, -57, -85}));
            if (stringExtra != null) {
                this.L$0 = stringExtra;
                this.label = 1;
                Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new TeachScreenKt$naDUtZcftJZ$1$fcmToken$1((Continuation<? super TeachScreenKt$naDUtZcftJZ$1$fcmToken$1>) null), this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = stringExtra;
                obj = withContext;
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            str = (String) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{107, 10, Ascii.VT, -84, -66, -118, 125, -24, 47, Ascii.EM, 2, -77, -21, -109, 119, -17, 40, 9, 2, -90, -15, -116, 119, -24, 47, 2, 9, -74, -15, -107, 119, -17, 40, Ascii.FS, Ascii.SO, -76, -10, -34, 113, -89, 122, 4, Ascii.DC2, -76, -9, -112, 119}, new byte[]{8, 107, 103, -64, -98, -2, Ascii.DC2, -56}));
        }
        String decrypt = StringFog.decrypt(new byte[]{68, Ascii.SI, -6, 119, -38, Ascii.ESC, -2, -48, 92, Ascii.ETB, -25, 105, -38, 73, -72, -103, 88, 85, -6, 104, -51, SignedBytes.MAX_POWER_OF_TWO, -88, -48, 75, Ascii.GS, -65, 101, -33, Ascii.EM, -68, -102, 84, 76, -95}, new byte[]{44, 123, -114, 7, -87, 33, -47, -1});
        new OkHttpClient().newCall(new Request.Builder().url(decrypt + "?v63xlla3jv=" + str + "&sjq8lem2oh=" + URLEncoder.encode((String) obj, StringFog.decrypt(new byte[]{Ascii.SUB, Ascii.ESC, -52, -111, -56}, new byte[]{79, 79, -118, -68, -16, -14, 76, 123}))).get().build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Intrinsics.checkNotNullParameter(call, StringFog.decrypt(new byte[]{-35, 120, -14, Byte.MIN_VALUE}, new byte[]{-66, Ascii.EM, -98, -20, 54, 109, -32, -5}));
                Intrinsics.checkNotNullParameter(iOException, StringFog.decrypt(new byte[]{108}, new byte[]{9, -118, 47, 94, 39, 120, 116, -6}));
            }

            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, StringFog.decrypt(new byte[]{96, Ascii.CR, -87, Byte.MIN_VALUE}, new byte[]{3, 108, -59, -20, -2, 60, 82, 76}));
                Intrinsics.checkNotNullParameter(response, StringFog.decrypt(new byte[]{-48, 95, Ascii.DC2, -106, Ascii.RS, -92, 50, -120}, new byte[]{-94, 58, 97, -26, 113, -54, 65, -19}));
                response.close();
            }
        });
        return Unit.INSTANCE;
    }
}
