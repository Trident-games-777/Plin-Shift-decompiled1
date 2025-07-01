package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogFlowRow$1$1 implements MeasurePolicy {
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ float $mainAxisSpacing;

    AlertDialogKt$AlertDialogFlowRow$1$1(float f, float f2) {
        this.$mainAxisSpacing = f;
        this.$crossAxisSpacing = f2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1707measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        List arrayList4 = new ArrayList();
        Ref.IntRef intRef3 = new Ref.IntRef();
        Ref.IntRef intRef4 = new Ref.IntRef();
        float f = this.$mainAxisSpacing;
        float f2 = this.$crossAxisSpacing;
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = size;
            List list2 = arrayList;
            long j2 = j;
            Placeable r17 = ((Measurable) list.get(i2)).m5848measureBRTryo0(j2);
            Ref.IntRef intRef5 = intRef3;
            boolean measure_3p2s80s$canAddToCurrentSequence = measure_3p2s80s$canAddToCurrentSequence(arrayList4, intRef5, measureScope, f, j2, r17);
            intRef3 = intRef5;
            Placeable placeable = r17;
            if (!measure_3p2s80s$canAddToCurrentSequence) {
                i = i2;
                arrayList = list2;
                measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope, f2, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
            } else {
                i = i2;
                arrayList = list2;
            }
            if (!arrayList4.isEmpty()) {
                intRef3.element += measureScope.m7086roundToPx0680j_4(f);
            } else {
                MeasureScope measureScope2 = measureScope;
            }
            arrayList4.add(placeable);
            intRef3.element += placeable.getWidth();
            intRef4.element = Math.max(intRef4.element, placeable.getHeight());
            i2 = i + 1;
            size = i3;
        }
        MeasureScope measureScope3 = measureScope;
        if (!arrayList4.isEmpty()) {
            measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope3, this.$crossAxisSpacing, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
        }
        int max = Math.max(intRef.element, Constraints.m7054getMinWidthimpl(j));
        int max2 = Math.max(intRef2.element, Constraints.m7053getMinHeightimpl(j));
        final float f3 = this.$mainAxisSpacing;
        final MeasureScope measureScope4 = measureScope;
        final List list3 = arrayList3;
        final List list4 = arrayList;
        final int i4 = max;
        return MeasureScope.layout$default(measureScope, max, max2, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                List<List<Placeable>> list = list4;
                MeasureScope measureScope = measureScope4;
                float f = f3;
                int i = i4;
                List<Integer> list2 = list3;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    List list3 = list.get(i2);
                    int size2 = list3.size();
                    int[] iArr = new int[size2];
                    int i3 = 0;
                    while (i3 < size2) {
                        iArr[i3] = ((Placeable) list3.get(i3)).getWidth() + (i3 < CollectionsKt.getLastIndex(list3) ? measureScope.m7086roundToPx0680j_4(f) : 0);
                        i3++;
                    }
                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                    int[] iArr2 = new int[size2];
                    for (int i4 = 0; i4 < size2; i4++) {
                        iArr2[i4] = 0;
                    }
                    end.arrange(measureScope, i, iArr, measureScope.getLayoutDirection(), iArr2);
                    int size3 = list3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        Placeable.PlacementScope.place$default(placementScope, (Placeable) list3.get(i5), iArr2[i5], list2.get(i2).intValue(), 0.0f, 4, (Object) null);
                    }
                }
            }
        }, 4, (Object) null);
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f, long j, Placeable placeable) {
        return list.isEmpty() || (intRef.element + measureScope.m7086roundToPx0680j_4(f)) + placeable.getWidth() <= Constraints.m7052getMaxWidthimpl(j);
    }

    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
        if (!list.isEmpty()) {
            intRef.element += measureScope.m7086roundToPx0680j_4(f);
        }
        list.add(0, CollectionsKt.toList(list2));
        list3.add(Integer.valueOf(intRef2.element));
        list4.add(Integer.valueOf(intRef.element));
        intRef.element += intRef2.element;
        intRef3.element = Math.max(intRef3.element, intRef4.element);
        list2.clear();
        intRef4.element = 0;
        intRef2.element = 0;
    }
}
