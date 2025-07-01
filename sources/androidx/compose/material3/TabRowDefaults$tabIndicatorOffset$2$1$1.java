package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/Density;", "invoke-Bjo55l4", "(Landroidx/compose/ui/unit/Density;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowDefaults$tabIndicatorOffset$2$1$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ State<Dp> $indicatorOffset$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowDefaults$tabIndicatorOffset$2$1$1(State<Dp> state) {
        super(1);
        this.$indicatorOffset$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m7232boximpl(m2585invokeBjo55l4((Density) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m2585invokeBjo55l4(Density density) {
        return IntOffsetKt.IntOffset(density.m7086roundToPx0680j_4(TabRowDefaults$tabIndicatorOffset$2.invoke$lambda$1(this.$indicatorOffset$delegate)), 0);
    }
}
