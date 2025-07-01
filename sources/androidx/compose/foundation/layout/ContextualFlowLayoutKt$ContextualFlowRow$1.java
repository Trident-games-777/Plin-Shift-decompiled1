package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextualFlowLayout.kt */
final class ContextualFlowLayoutKt$ContextualFlowRow$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function4<ContextualFlowRowScope, Integer, Composer, Integer, Unit> $content;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ int $itemCount;
    final /* synthetic */ int $maxItemsInEachRow;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ ContextualFlowRowOverflow $overflow;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextualFlowLayoutKt$ContextualFlowRow$1(int i, Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i2, int i3, ContextualFlowRowOverflow contextualFlowRowOverflow, Function4<? super ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, int i4, int i5) {
        super(2);
        this.$itemCount = i;
        this.$modifier = modifier;
        this.$horizontalArrangement = horizontal;
        this.$verticalArrangement = vertical;
        this.$maxItemsInEachRow = i2;
        this.$maxLines = i3;
        this.$overflow = contextualFlowRowOverflow;
        this.$content = function4;
        this.$$changed = i4;
        this.$$default = i5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ContextualFlowLayoutKt.ContextualFlowRow(this.$itemCount, this.$modifier, this.$horizontalArrangement, this.$verticalArrangement, this.$maxItemsInEachRow, this.$maxLines, this.$overflow, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
