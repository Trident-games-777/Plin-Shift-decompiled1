package coil3.compose;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: SubcomposeAsyncImage.kt */
final class SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2$1 implements MeasurePolicy {
    public static final SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2$1 INSTANCE = new SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2$1();

    SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2$1() {
    }

    /* access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m7485measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        return MeasureScope.layout$default(measureScope, Constraints.m7054getMinWidthimpl(j), Constraints.m7053getMinHeightimpl(j), (Map) null, new SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2$1$$ExternalSyntheticLambda0(), 4, (Object) null);
    }
}
