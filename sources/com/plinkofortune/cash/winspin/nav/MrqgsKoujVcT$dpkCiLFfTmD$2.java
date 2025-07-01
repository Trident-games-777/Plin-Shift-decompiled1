package com.plinkofortune.cash.winspin.nav;

import androidx.datastore.preferences.core.MutablePreferences;
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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "dvMhyWdaChq", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT$dpkCiLFfTmD$2", f = "MrqgsKoujVcT.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MrqgsKoujVcT.kt */
final class MrqgsKoujVcT$dpkCiLFfTmD$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $wSxFhMWFKBHQ;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MrqgsKoujVcT$dpkCiLFfTmD$2(String str, Continuation<? super MrqgsKoujVcT$dpkCiLFfTmD$2> continuation) {
        super(2, continuation);
        this.$wSxFhMWFKBHQ = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MrqgsKoujVcT$dpkCiLFfTmD$2 mrqgsKoujVcT$dpkCiLFfTmD$2 = new MrqgsKoujVcT$dpkCiLFfTmD$2(this.$wSxFhMWFKBHQ, continuation);
        mrqgsKoujVcT$dpkCiLFfTmD$2.L$0 = obj;
        return mrqgsKoujVcT$dpkCiLFfTmD$2;
    }

    public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
        return ((MrqgsKoujVcT$dpkCiLFfTmD$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.L$0).set(MrqgsKoujVcT.nUJiLDOUmnES, this.$wSxFhMWFKBHQ);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{47, 32, 103, 6, -114, 79, 107, -76, 107, 51, 110, Ascii.EM, -37, 86, 97, -77, 108, 35, 110, Ascii.FF, -63, 73, 97, -76, 107, 40, 101, Ascii.FS, -63, 80, 97, -77, 108, 54, 98, Ascii.RS, -58, Ascii.ESC, 103, -5, 62, 46, 126, Ascii.RS, -57, 85, 97}, new byte[]{76, 65, Ascii.VT, 106, -82, 59, 4, -108}));
    }
}
