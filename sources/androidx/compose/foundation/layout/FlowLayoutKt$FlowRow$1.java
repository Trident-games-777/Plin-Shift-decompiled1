package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
final class FlowLayoutKt$FlowRow$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<FlowRowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ int $maxItemsInEachRow;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ FlowRowOverflow $overflow;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLayoutKt$FlowRow$1(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, int i2, FlowRowOverflow flowRowOverflow, Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, int i3, int i4) {
        super(2);
        this.$modifier = modifier;
        this.$horizontalArrangement = horizontal;
        this.$verticalArrangement = vertical;
        this.$maxItemsInEachRow = i;
        this.$maxLines = i2;
        this.$overflow = flowRowOverflow;
        this.$content = function3;
        this.$$changed = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        FlowLayoutKt.FlowRow(this.$modifier, this.$horizontalArrangement, this.$verticalArrangement, this.$maxItemsInEachRow, this.$maxLines, this.$overflow, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
