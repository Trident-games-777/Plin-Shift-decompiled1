package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingKt$padding$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $bottom;
    final /* synthetic */ float $end;
    final /* synthetic */ float $start;
    final /* synthetic */ float $top;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaddingKt$padding$1(float f, float f2, float f3, float f4) {
        super(1);
        this.$start = f;
        this.$top = f2;
        this.$end = f3;
        this.$bottom = f4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set("start", Dp.m7109boximpl(this.$start));
        inspectorInfo.getProperties().set("top", Dp.m7109boximpl(this.$top));
        inspectorInfo.getProperties().set("end", Dp.m7109boximpl(this.$end));
        inspectorInfo.getProperties().set("bottom", Dp.m7109boximpl(this.$bottom));
    }
}
