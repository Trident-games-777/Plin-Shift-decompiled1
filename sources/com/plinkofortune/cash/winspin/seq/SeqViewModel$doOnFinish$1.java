package com.plinkofortune.cash.winspin.seq;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.seq.SeqViewModel", f = "SeqViewModel.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3}, l = {72, 82, 84, 85, 90}, m = "doOnFinish", n = {"this", "state", "this", "state", "this", "state", "this", "state", "$this$doOnFinish_u24lambda_u245"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$3"})
/* compiled from: SeqViewModel.kt */
final class SeqViewModel$doOnFinish$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SeqViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeqViewModel$doOnFinish$1(SeqViewModel seqViewModel, Continuation<? super SeqViewModel$doOnFinish$1> continuation) {
        super(continuation);
        this.this$0 = seqViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doOnFinish(this);
    }
}
