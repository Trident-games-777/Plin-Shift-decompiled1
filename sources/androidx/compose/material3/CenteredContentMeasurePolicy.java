package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/material3/CenteredContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExpressiveNavigationBar.kt */
final class CenteredContentMeasurePolicy implements MeasurePolicy {
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1787measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        List list2;
        int i;
        List<? extends Measurable> list3 = list;
        int r3 = Constraints.m7052getMaxWidthimpl(j);
        long j2 = j;
        int r2 = Constraints.m7053getMinHeightimpl(j2);
        int size = list3.size();
        if (size < 1) {
            return MeasureScope.layout$default(measureScope, r3, r2, (Map) null, CenteredContentMeasurePolicy$measure$1.INSTANCE, 4, (Object) null);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        int i2 = 0;
        if (!Constraints.m7048getHasBoundedWidthimpl(j2)) {
            ArrayList arrayList = new ArrayList(list3.size());
            int size2 = list3.size();
            while (i2 < size2) {
                arrayList.add(((Measurable) list3.get(i2)).m5848measureBRTryo0(ConstraintsKt.m7067constrainN9IONVI(j2, Constraints.Companion.m7063fixedHeightOenEA2s(r2))));
                i2++;
            }
            list2 = arrayList;
        } else {
            int i3 = r3 / size;
            intRef.element = ExpressiveNavigationBarKt.calculateCenteredContentHorizontalPadding(size, r3);
            int i4 = (r3 - (intRef.element * 2)) / size;
            int size3 = list3.size();
            for (int i5 = 0; i5 < size3; i5++) {
                int maxIntrinsicHeight = ((Measurable) list3.get(i5)).maxIntrinsicHeight(i4);
                if (r2 < maxIntrinsicHeight) {
                    r2 = RangesKt.coerceAtMost(maxIntrinsicHeight, Constraints.m7051getMaxHeightimpl(j2));
                }
            }
            ArrayList arrayList2 = new ArrayList(list3.size());
            int size4 = list3.size();
            while (i2 < size4) {
                Collection collection = arrayList2;
                Measurable measurable = (Measurable) list3.get(i2);
                int maxIntrinsicWidth = measurable.maxIntrinsicWidth(Constraints.m7053getMinHeightimpl(j2));
                if (i4 < maxIntrinsicWidth) {
                    i = RangesKt.coerceAtMost(maxIntrinsicWidth, i3);
                    intRef.element -= (i - i4) / 2;
                } else {
                    i = i4;
                }
                collection.add(measurable.m5848measureBRTryo0(ConstraintsKt.m7067constrainN9IONVI(j2, Constraints.Companion.m7062fixedJhjzzOo(i, r2))));
                i2++;
            }
            list2 = arrayList2;
        }
        return MeasureScope.layout$default(measureScope, r3, r2, (Map) null, new CenteredContentMeasurePolicy$measure$5(intRef, list2), 4, (Object) null);
    }
}
