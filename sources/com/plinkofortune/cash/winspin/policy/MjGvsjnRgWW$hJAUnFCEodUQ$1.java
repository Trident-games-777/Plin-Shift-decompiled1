package com.plinkofortune.cash.winspin.policy;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;
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
@DebugMetadata(c = "com.plinkofortune.cash.winspin.policy.MjGvsjnRgWW$hJAUnFCEodUQ$1", f = "MjGvsjnRgWW.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MjGvsjnRgWW.kt */
final class MjGvsjnRgWW$hJAUnFCEodUQ$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MjGvsjnRgWW$hJAUnFCEodUQ$1(String str, Continuation<? super MjGvsjnRgWW$hJAUnFCEodUQ$1> continuation) {
        super(2, continuation);
        this.$id = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MjGvsjnRgWW$hJAUnFCEodUQ$1(this.$id, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MjGvsjnRgWW$hJAUnFCEodUQ$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new MjGvsjnRgWW$hJAUnFCEodUQ$1$fcmToken$1((Continuation<? super MjGvsjnRgWW$hJAUnFCEodUQ$1$fcmToken$1>) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{-98, Ascii.DC4, -19, 115, -68, 46, Ascii.US, -77, -38, 7, -28, 108, -23, 55, Ascii.NAK, -76, -35, Ascii.ETB, -28, 121, -13, 40, Ascii.NAK, -77, -38, Ascii.FS, -17, 105, -13, 49, Ascii.NAK, -76, -35, 2, -24, 107, -12, 122, 19, -4, -113, Ascii.SUB, -12, 107, -11, 52, Ascii.NAK}, new byte[]{-3, 117, -127, Ascii.US, -100, 90, 112, -109}));
        }
        String languageTag = Locale.getDefault().toLanguageTag();
        String decrypt = StringFog.decrypt(new byte[]{-126, -26, 3, -119, 46, -41, -92, -44, -102, -2, Ascii.RS, -105, 46, -123, -30, -99, -98, -68, 3, -106, 57, -116, -14, -44, -46, -90, 79, -63, 104, -103, -15, -120, -101, -31, 88}, new byte[]{-22, -110, 119, -7, 93, -19, -117, -5});
        OkHttpClient okHttpClient = new OkHttpClient();
        String str = this.$id;
        Request.Builder url = new Request.Builder().url(decrypt + "?jvs44odlf3=" + str + "&vwjibbhneb=" + URLEncoder.encode((String) obj, StringFog.decrypt(new byte[]{-10, 50, -32, 40, 115}, new byte[]{-93, 102, -90, 5, 75, -106, -51, -78})));
        String decrypt2 = StringFog.decrypt(new byte[]{-82, -18, -60, SignedBytes.MAX_POWER_OF_TWO, -39, -1, 71, -100, -114, -29, -64, 80, -56, -20, Ascii.SI}, new byte[]{-17, -115, -89, 37, -87, -117, 106, -48});
        Intrinsics.checkNotNull(languageTag);
        okHttpClient.newCall(url.addHeader(decrypt2, languageTag).get().build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Intrinsics.checkNotNullParameter(call, StringFog.decrypt(new byte[]{-55, 48, -24, -94}, new byte[]{-86, 81, -124, -50, -117, Ascii.NAK, 105, -55}));
                Intrinsics.checkNotNullParameter(iOException, StringFog.decrypt(new byte[]{-83}, new byte[]{-56, -106, 68, 33, 55, 57, 118, -95}));
            }

            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, StringFog.decrypt(new byte[]{-57, -11, 35, 3}, new byte[]{-92, -108, 79, 111, 58, -78, -63, -109}));
                Intrinsics.checkNotNullParameter(response, StringFog.decrypt(new byte[]{-35, 39, Ascii.FS, 118, Ascii.GS, 97, -28, 120}, new byte[]{-81, 66, 111, 6, 114, Ascii.SI, -105, Ascii.GS}));
                response.close();
            }
        });
        return Unit.INSTANCE;
    }
}
