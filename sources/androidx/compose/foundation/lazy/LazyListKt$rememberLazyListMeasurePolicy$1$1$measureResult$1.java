package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "placement", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1 extends Lambda implements Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult> {
    final /* synthetic */ long $containerConstraints;
    final /* synthetic */ LazyLayoutMeasureScope $this_null;
    final /* synthetic */ int $totalHorizontalPadding;
    final /* synthetic */ int $totalVerticalPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2) {
        super(3);
        this.$this_null = lazyLayoutMeasureScope;
        this.$containerConstraints = j;
        this.$totalHorizontalPadding = i;
        this.$totalVerticalPadding = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
    }

    public final MeasureResult invoke(int i, int i2, Function1<? super Placeable.PlacementScope, Unit> function1) {
        return this.$this_null.layout(ConstraintsKt.m7069constrainWidthK40F9xA(this.$containerConstraints, i + this.$totalHorizontalPadding), ConstraintsKt.m7068constrainHeightK40F9xA(this.$containerConstraints, i2 + this.$totalVerticalPadding), MapsKt.emptyMap(), function1);
    }
}
