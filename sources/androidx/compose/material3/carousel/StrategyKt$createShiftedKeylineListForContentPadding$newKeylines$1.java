package androidx.compose.material3.carousel;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/carousel/KeylineListScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Strategy.kt */
final class StrategyKt$createShiftedKeylineListForContentPadding$newKeylines$1 extends Lambda implements Function1<KeylineListScope, Unit> {
    final /* synthetic */ KeylineList $from;
    final /* synthetic */ float $sizeReduction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StrategyKt$createShiftedKeylineListForContentPadding$newKeylines$1(KeylineList keylineList, float f) {
        super(1);
        this.$from = keylineList;
        this.$sizeReduction = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeylineListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeylineListScope keylineListScope) {
        List list = this.$from;
        float f = this.$sizeReduction;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Keyline keyline = (Keyline) list.get(i);
            keylineListScope.add(keyline.getSize() - Math.abs(f), keyline.isAnchor());
        }
    }
}
