package com.plinkofortune.cash.winspin.seq.models;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.common.base.Ascii;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.seq.models.ZcTgPSXUgvzR$bFIlzUavKeP$2", f = "ZcTgPSXUgvzR.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ZcTgPSXUgvzR.kt */
final class ZcTgPSXUgvzR$bFIlzUavKeP$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZcTgPSXUgvzR$bFIlzUavKeP$2(Context context, Continuation<? super ZcTgPSXUgvzR$bFIlzUavKeP$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZcTgPSXUgvzR$bFIlzUavKeP$2(this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ZcTgPSXUgvzR$bFIlzUavKeP$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                return String.valueOf(AdvertisingIdClient.getAdvertisingIdInfo(this.$context).getId());
            } catch (Exception unused) {
                return StringFog.decrypt(new byte[]{-5, 79, 103, -89, -80, 67, Ascii.SUB, 107, -26, 79, 103, -89, -80, 94, Ascii.SUB, 107, -5, 79, 122, -89, -80, 67, Ascii.SUB, 118, -5, 79, 103, -89, -80, 67, Ascii.SUB, 107, -5, 79, 103, -89}, new byte[]{-53, Byte.MAX_VALUE, 87, -105, Byte.MIN_VALUE, 115, 42, 91});
            }
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{7, Ascii.GS, Ascii.RS, -87, 44, -52, -106, -57, 67, Ascii.SO, Ascii.ETB, -74, 121, -43, -100, -64, 68, Ascii.RS, Ascii.ETB, -93, 99, -54, -100, -57, 67, Ascii.NAK, Ascii.FS, -77, 99, -45, -100, -64, 68, Ascii.VT, Ascii.ESC, -79, 100, -104, -102, -120, Ascii.SYN, 19, 7, -79, 101, -42, -100}, new byte[]{100, 124, 114, -59, Ascii.FF, -72, -7, -25}));
        }
    }
}
