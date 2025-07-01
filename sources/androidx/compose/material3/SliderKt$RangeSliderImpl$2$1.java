package androidx.compose.material3;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSliderImpl$2$1 implements MeasurePolicy {
    final /* synthetic */ RangeSliderState $state;

    SliderKt$RangeSliderImpl$2$1(RangeSliderState rangeSliderState) {
        this.$state = rangeSliderState;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2500measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        List<? extends Measurable> list2 = list;
        long j2 = j;
        int size = list2.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Measurable measurable = (Measurable) list2.get(i2);
            if (LayoutIdKt.getLayoutId(measurable) == RangeSliderComponents.STARTTHUMB) {
                final Placeable r15 = measurable.m5848measureBRTryo0(j2);
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable2 = (Measurable) list2.get(i3);
                    if (LayoutIdKt.getLayoutId(measurable2) == RangeSliderComponents.ENDTHUMB) {
                        final Placeable r18 = measurable2.m5848measureBRTryo0(j2);
                        int size3 = list2.size();
                        while (i < size3) {
                            Measurable measurable3 = (Measurable) list2.get(i);
                            if (LayoutIdKt.getLayoutId(measurable3) == RangeSliderComponents.TRACK) {
                                final Placeable r12 = measurable3.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(ConstraintsKt.m7072offsetNN6EwU$default(j2, (-(r15.getWidth() + r18.getWidth())) / 2, 0, 2, (Object) null), 0, 0, 0, 0, 11, (Object) null));
                                int width = r12.getWidth() + ((r15.getWidth() + r18.getWidth()) / 2);
                                int max = Math.max(r12.getHeight(), Math.max(r15.getHeight(), r18.getHeight()));
                                this.$state.setTrackHeight$material3_release((float) r12.getHeight());
                                this.$state.setTotalWidth$material3_release(width);
                                this.$state.updateMinMaxPx$material3_release();
                                final int width2 = r15.getWidth() / 2;
                                final int roundToInt = MathKt.roundToInt(((float) r12.getWidth()) * this.$state.getCoercedActiveRangeStartAsFraction$material3_release());
                                final int roundToInt2 = MathKt.roundToInt((((float) r12.getWidth()) * this.$state.getCoercedActiveRangeEndAsFraction$material3_release()) + ((float) ((r15.getWidth() - r18.getWidth()) / 2)));
                                final int height = (max - r12.getHeight()) / 2;
                                final int height2 = (max - r15.getHeight()) / 2;
                                final int height3 = (max - r18.getHeight()) / 2;
                                return MeasureScope.layout$default(measureScope, width, max, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Placeable.PlacementScope placementScope2 = placementScope;
                                        Placeable.PlacementScope.placeRelative$default(placementScope2, r12, width2, height, 0.0f, 4, (Object) null);
                                        Placeable.PlacementScope placementScope3 = placementScope2;
                                        Placeable.PlacementScope.placeRelative$default(placementScope3, r15, roundToInt, height2, 0.0f, 4, (Object) null);
                                        Placeable.PlacementScope.placeRelative$default(placementScope3, r18, roundToInt2, height3, 0.0f, 4, (Object) null);
                                    }
                                }, 4, (Object) null);
                            }
                            i++;
                            j2 = j;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    i3++;
                    j2 = j;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i2++;
            j2 = j;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
