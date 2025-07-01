package androidx.compose.material3;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipScopeImpl$drawCaret$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ Function2<CacheDrawScope, LayoutCoordinates, DrawResult> $draw;
    final /* synthetic */ TooltipScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipScopeImpl$drawCaret$1(Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function2, TooltipScopeImpl tooltipScopeImpl) {
        super(1);
        this.$draw = function2;
        this.this$0 = tooltipScopeImpl;
    }

    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        return this.$draw.invoke(cacheDrawScope, this.this$0.getGetAnchorBounds().invoke());
    }
}
