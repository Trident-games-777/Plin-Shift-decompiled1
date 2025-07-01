package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\u00020\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "placements", "", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0<List<Rect>> placements;
    private final Function0<Boolean> shouldMeasureLinks;

    public TextMeasurePolicy(Function0<Boolean> function0, Function0<? extends List<Rect>> function02) {
        this.shouldMeasureLinks = function0;
        this.placements = function02;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1298measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Pair pair;
        List<? extends Measurable> list2 = list;
        ArrayList arrayList = new ArrayList(list2.size());
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Object obj = list2.get(i);
            if (!(((Measurable) obj).getParentData() instanceof TextRangeLayoutModifier)) {
                arrayList.add(obj);
            }
        }
        List list3 = arrayList;
        List invoke = this.placements.invoke();
        List list4 = null;
        if (invoke != null) {
            ArrayList arrayList2 = new ArrayList(invoke.size());
            int size2 = invoke.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Rect rect = (Rect) invoke.get(i2);
                if (rect != null) {
                    pair = new Pair(((Measurable) list3.get(i2)).m5848measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) ((float) Math.floor((double) rect.getWidth())), 0, (int) ((float) Math.floor((double) rect.getHeight())), 5, (Object) null)), IntOffset.m7232boximpl(IntOffsetKt.IntOffset(Math.round(rect.getLeft()), Math.round(rect.getTop()))));
                } else {
                    pair = null;
                }
                if (pair != null) {
                    arrayList2.add(pair);
                }
            }
            list4 = arrayList2;
        }
        ArrayList arrayList3 = new ArrayList(list2.size());
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Object obj2 = list2.get(i3);
            if (((Measurable) obj2).getParentData() instanceof TextRangeLayoutModifier) {
                arrayList3.add(obj2);
            }
        }
        return MeasureScope.layout$default(measureScope, Constraints.m7052getMaxWidthimpl(j), Constraints.m7051getMaxHeightimpl(j), (Map) null, new TextMeasurePolicy$measure$1(list4, BasicTextKt.measureWithTextRangeMeasureConstraints(arrayList3, this.shouldMeasureLinks)), 4, (Object) null);
    }
}
