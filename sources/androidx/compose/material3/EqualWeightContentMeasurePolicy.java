package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/material3/EqualWeightContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExpressiveNavigationBar.kt */
final class EqualWeightContentMeasurePolicy implements MeasurePolicy {
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2044measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        List list2;
        int r1 = Constraints.m7052getMaxWidthimpl(j);
        int r2 = Constraints.m7053getMinHeightimpl(j);
        int size = list.size();
        if (size < 1) {
            return MeasureScope.layout$default(measureScope, r1, r2, (Map) null, EqualWeightContentMeasurePolicy$measure$1.INSTANCE, 4, (Object) null);
        }
        int i = size;
        MeasureScope measureScope2 = measureScope;
        int i2 = i;
        int i3 = 0;
        if (!Constraints.m7048getHasBoundedWidthimpl(j)) {
            ArrayList arrayList = new ArrayList(list.size());
            int size2 = list.size();
            while (i3 < size2) {
                arrayList.add(((Measurable) list.get(i3)).m5848measureBRTryo0(ConstraintsKt.m7067constrainN9IONVI(j, Constraints.Companion.m7063fixedHeightOenEA2s(r2))));
                i3++;
            }
            list2 = arrayList;
        } else {
            int i4 = r1 / i2;
            int size3 = list.size();
            for (int i5 = 0; i5 < size3; i5++) {
                int maxIntrinsicHeight = ((Measurable) list.get(i5)).maxIntrinsicHeight(i4);
                if (r2 < maxIntrinsicHeight) {
                    r2 = RangesKt.coerceAtMost(maxIntrinsicHeight, Constraints.m7051getMaxHeightimpl(j));
                }
            }
            ArrayList arrayList2 = new ArrayList(list.size());
            int size4 = list.size();
            while (i3 < size4) {
                arrayList2.add(((Measurable) list.get(i3)).m5848measureBRTryo0(ConstraintsKt.m7067constrainN9IONVI(j, Constraints.Companion.m7062fixedJhjzzOo(i4, r2))));
                i3++;
            }
            list2 = arrayList2;
        }
        return MeasureScope.layout$default(measureScope2, r1, r2, (Map) null, new EqualWeightContentMeasurePolicy$measure$5(list2), 4, (Object) null);
    }
}
