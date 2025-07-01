package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "flingVelocity", "lowerBound", "upperBound", "invoke", "(FFF)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
final class PagerDefaults$flingBehavior$2$snapLayoutInfoProvider$1 extends Lambda implements Function3<Float, Float, Float, Float> {
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ float $snapPositionalThreshold;
    final /* synthetic */ PagerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerDefaults$flingBehavior$2$snapLayoutInfoProvider$1(PagerState pagerState, LayoutDirection layoutDirection, float f) {
        super(3);
        this.$state = pagerState;
        this.$layoutDirection = layoutDirection;
        this.$snapPositionalThreshold = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue(), ((Number) obj3).floatValue());
    }

    public final Float invoke(float f, float f2, float f3) {
        return Float.valueOf(PagerSnapLayoutInfoProviderKt.calculateFinalSnappingBound(this.$state, this.$layoutDirection, this.$snapPositionalThreshold, f, f2, f3));
    }
}
