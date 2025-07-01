package com.plinkofortune.cash.winspin;

import androidx.datastore.preferences.core.MutablePreferences;
import com.google.common.base.Ascii;
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
@DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$4", f = "GlobalRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GlobalRepo.kt */
final class GlobalRepoKt$makePream$4 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    GlobalRepoKt$makePream$4(Continuation<? super GlobalRepoKt$makePream$4> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GlobalRepoKt$makePream$4 globalRepoKt$makePream$4 = new GlobalRepoKt$makePream$4(continuation);
        globalRepoKt$makePream$4.L$0 = obj;
        return globalRepoKt$makePream$4;
    }

    public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
        return ((GlobalRepoKt$makePream$4) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.L$0).set(GlobalRepoKt.getPream(), StringFog.decrypt(new byte[]{109, 55, -46, Ascii.GS, -10, 91, -92, -39, 80, 47, -36, 44, -51, 122}, new byte[]{7, 109, -92, 91, -98, 54, -24, -75}));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{108, -92, 81, 58, 10, -111, 42, Ascii.VT, 40, -73, 88, 37, 95, -120, 32, Ascii.FF, 47, -89, 88, 48, 69, -105, 32, Ascii.VT, 40, -84, 83, 32, 69, -114, 32, Ascii.FF, 47, -78, 84, 34, 66, -59, 38, 68, 125, -86, 72, 34, 67, -117, 32}, new byte[]{Ascii.SI, -59, Base64.padSymbol, 86, 42, -27, 69, 43}));
    }
}
