package com.plinkofortune.cash.winspin.rounds;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke", "androidx/compose/foundation/lazy/grid/LazyGridDslKt$items$4"}, k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
public final class RoundsScreenKt$RoundsScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$4 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ Function1 $contentType;
    final /* synthetic */ List $items;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundsScreenKt$RoundsScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$4(Function1 function1, List list) {
        super(1);
        this.$contentType = function1;
        this.$items = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Object invoke(int i) {
        return this.$contentType.invoke(this.$items.get(i));
    }
}
