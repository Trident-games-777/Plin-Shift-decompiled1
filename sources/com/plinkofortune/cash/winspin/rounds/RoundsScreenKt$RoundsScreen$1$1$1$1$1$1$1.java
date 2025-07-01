package com.plinkofortune.cash.winspin.rounds;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: RoundsScreen.kt */
final class RoundsScreenKt$RoundsScreen$1$1$1$1$1$1$1 implements Function0<Unit> {
    final /* synthetic */ Function1<Integer, Unit> $mortal;
    final /* synthetic */ RoundModel $round;

    RoundsScreenKt$RoundsScreen$1$1$1$1$1$1$1(RoundModel roundModel, Function1<? super Integer, Unit> function1) {
        this.$round = roundModel;
        this.$mortal = function1;
    }

    public final void invoke() {
        if (this.$round.getUnlocked()) {
            this.$mortal.invoke(Integer.valueOf(this.$round.getNum()));
        }
    }
}
