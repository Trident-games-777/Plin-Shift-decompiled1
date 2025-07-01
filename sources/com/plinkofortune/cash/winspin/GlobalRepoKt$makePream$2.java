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
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "prefs", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$2", f = "GlobalRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GlobalRepo.kt */
final class GlobalRepoKt$makePream$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    GlobalRepoKt$makePream$2(Continuation<? super GlobalRepoKt$makePream$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GlobalRepoKt$makePream$2 globalRepoKt$makePream$2 = new GlobalRepoKt$makePream$2(continuation);
        globalRepoKt$makePream$2.L$0 = obj;
        return globalRepoKt$makePream$2;
    }

    public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
        return ((GlobalRepoKt$makePream$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.L$0).set(GlobalRepoKt.getPream(), StringFog.decrypt(new byte[]{-60, 124, 76, Ascii.SYN, Ascii.ETB, -121}, new byte[]{-78, Ascii.RS, 8, SignedBytes.MAX_POWER_OF_TWO, 117, -34, -50, 126}));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{38, 121, -14, -31, -91, 88, Ascii.DC4, 123, 98, 106, -5, -2, -16, 65, Ascii.RS, 124, 101, 122, -5, -21, -22, 94, Ascii.RS, 123, 98, 113, -16, -5, -22, 71, Ascii.RS, 124, 101, 111, -9, -7, -19, Ascii.FF, Ascii.CAN, 52, 55, 119, -21, -7, -20, 66, Ascii.RS}, new byte[]{69, Ascii.CAN, -98, -115, -123, 44, 123, 91}));
    }
}
