package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSize.kt */
final class TextFieldSizeKt$textFieldMinSize$1$1$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ TextFieldSize $minSizeState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSizeKt$textFieldMinSize$1$1$1(TextFieldSize textFieldSize) {
        super(3);
        this.$minSizeState = textFieldSize;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m1285invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m7058unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m1285invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long r0 = this.$minSizeState.m1284getMinSizeYbymL2g();
        final Placeable r15 = measurable.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(j, RangesKt.coerceIn(IntSize.m7283getWidthimpl(r0), Constraints.m7054getMinWidthimpl(j), Constraints.m7052getMaxWidthimpl(j)), 0, RangesKt.coerceIn(IntSize.m7282getHeightimpl(r0), Constraints.m7053getMinHeightimpl(j), Constraints.m7051getMaxHeightimpl(j)), 0, 10, (Object) null));
        return MeasureScope.layout$default(measureScope, r15.getWidth(), r15.getHeight(), (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, r15, 0, 0, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
