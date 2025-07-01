package com.plinkofortune.cash.winspin;

import androidx.datastore.preferences.core.MutablePreferences;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "prefs", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$3", f = "GlobalRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GlobalRepo.kt */
final class GlobalRepoKt$makePream$3 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    GlobalRepoKt$makePream$3(Continuation<? super GlobalRepoKt$makePream$3> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GlobalRepoKt$makePream$3 globalRepoKt$makePream$3 = new GlobalRepoKt$makePream$3(continuation);
        globalRepoKt$makePream$3.L$0 = obj;
        return globalRepoKt$makePream$3;
    }

    public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
        return ((GlobalRepoKt$makePream$3) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.L$0).set(GlobalRepoKt.getPream(), StringFog.decrypt(new byte[]{45, Byte.MIN_VALUE, Base64.padSymbol, 57, -67}, new byte[]{93, -14, 82, 84, -46, 114, -8, 96}));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{53, -65, 112, -69, 92, Ascii.DC4, -10, -44, 113, -84, 121, -92, 9, Ascii.CR, -4, -45, 118, -68, 121, -79, 19, Ascii.DC2, -4, -44, 113, -73, 114, -95, 19, Ascii.VT, -4, -45, 118, -87, 117, -93, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, -6, -101, 36, -79, 105, -93, Ascii.NAK, Ascii.SO, -4}, new byte[]{86, -34, Ascii.FS, -41, 124, 96, -103, -12}));
    }
}
