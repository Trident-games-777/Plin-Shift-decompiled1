package com.plinkofortune.cash.winspin;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepoKt", f = "GlobalRepo.kt", i = {0, 0, 0, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 7}, l = {148, 171, 173, 202, 208, 216, 226, 229, 230}, m = "makePream", n = {"root", "ogNFEsnlSFL", "mrqgsKoujVcT", "root", "ogNFEsnlSFL", "mrqgsKoujVcT", "true4", "false7", "root", "ogNFEsnlSFL", "mrqgsKoujVcT", "false7", "zvSyKlNrddQ", "root", "ogNFEsnlSFL", "mrqgsKoujVcT", "false7", "zvSyKlNrddQ", "iQLhOuiIOxLa", "root", "ogNFEsnlSFL", "mrqgsKoujVcT", "false7", "root"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0"})
/* compiled from: GlobalRepo.kt */
final class GlobalRepoKt$makePream$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    GlobalRepoKt$makePream$1(Continuation<? super GlobalRepoKt$makePream$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GlobalRepoKt.makePream((FragmentActivity) null, this);
    }
}
