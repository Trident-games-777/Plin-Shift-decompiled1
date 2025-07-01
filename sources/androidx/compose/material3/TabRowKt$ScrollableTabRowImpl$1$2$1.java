package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "<name for destructuring parameter 0>", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$ScrollableTabRowImpl$1$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ TabRowKt$ScrollableTabRowImpl$1$scope$1$1 $scope;
    final /* synthetic */ ScrollableTabData $scrollableTabData;
    final /* synthetic */ int $selectedTabIndex;

    TabRowKt$ScrollableTabRowImpl$1$2$1(float f, TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1, int i, ScrollableTabData scrollableTabData) {
        this.$edgePadding = f;
        this.$scope = tabRowKt$ScrollableTabRowImpl$1$scope$1$1;
        this.$selectedTabIndex = i;
        this.$scrollableTabData = scrollableTabData;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2600measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        MeasureScope measureScope2 = measureScope;
        List<? extends List<? extends Measurable>> list2 = list;
        List list3 = (List) list2.get(0);
        List list4 = (List) list2.get(1);
        List list5 = (List) list2.get(2);
        final int r9 = measureScope2.m7086roundToPx0680j_4(this.$edgePadding);
        int size = list3.size();
        int r12 = measureScope2.m7086roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
        int i = 0;
        int size2 = list3.size();
        for (int i2 = 0; i2 < size2; i2++) {
            i = Integer.valueOf(Math.max(i.intValue(), ((Measurable) list3.get(i2)).maxIntrinsicHeight(Integer.MAX_VALUE)));
        }
        int intValue = i.intValue();
        int i3 = r9 * 2;
        long r122 = Constraints.m7043copyZbe2FdA$default(j, r12, 0, intValue, intValue, 2, (Object) null);
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = this.$edgePadding;
        ArrayList arrayList = new ArrayList(list3.size());
        int size3 = list3.size();
        for (int i4 = 0; i4 < size3; i4++) {
            arrayList.add(((Measurable) list3.get(i4)).m5848measureBRTryo0(r122));
        }
        List list6 = arrayList;
        ArrayList arrayList2 = new ArrayList(size);
        int i5 = 0;
        while (i5 < size) {
            float r11 = ((Dp) ComparisonsKt.maxOf(Dp.m7109boximpl(TabRowKt.ScrollableTabRowMinimumTabWidth), Dp.m7109boximpl(measureScope2.m7088toDpu2uoSUM(((Placeable) list6.get(i5)).getWidth())))).m7125unboximpl();
            i3 += measureScope2.m7086roundToPx0680j_4(r11);
            TabPosition tabPosition = new TabPosition(floatRef.element, r11, ((Dp) ComparisonsKt.maxOf(Dp.m7109boximpl(Dp.m7111constructorimpl(r11 - Dp.m7111constructorimpl(TabKt.getHorizontalTextPadding() * ((float) 2)))), Dp.m7109boximpl(Dp.m7111constructorimpl((float) 24)))).m7125unboximpl(), (DefaultConstructorMarker) null);
            floatRef.element = Dp.m7111constructorimpl(floatRef.element + r11);
            arrayList2.add(tabPosition);
            i5++;
            list6 = list6;
        }
        List list7 = list6;
        List list8 = arrayList2;
        this.$scope.setTabPositions(list8);
        ArrayList arrayList3 = new ArrayList(list4.size());
        int size4 = list4.size();
        int i6 = 0;
        while (i6 < size4) {
            int i7 = i3;
            arrayList3.add(((Measurable) list4.get(i6)).m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(j, i7, i3, 0, 0, 8, (Object) null)));
            i6++;
            list4 = list4;
            arrayList3 = arrayList3;
            i3 = i7;
        }
        int i8 = i3;
        final List list9 = arrayList3;
        int i9 = this.$selectedTabIndex;
        ArrayList arrayList4 = new ArrayList(list5.size());
        int size5 = list5.size();
        int i10 = 0;
        while (i10 < size5) {
            int i11 = intValue;
            intValue = i11;
            arrayList4.add(((Measurable) list5.get(i10)).m5848measureBRTryo0(Constraints.m7042copyZbe2FdA(j, 0, measureScope2.m7086roundToPx0680j_4(((TabPosition) list8.get(i9)).m2580getWidthD9Ej5fM()), 0, i11)));
            i10++;
            measureScope2 = measureScope;
            list5 = list5;
        }
        final List list10 = arrayList4;
        final Ref.FloatRef floatRef2 = floatRef;
        final List list11 = list8;
        final float f = this.$edgePadding;
        final ScrollableTabData scrollableTabData = this.$scrollableTabData;
        final int i12 = this.$selectedTabIndex;
        final MeasureScope measureScope3 = measureScope;
        final List list12 = list7;
        final int i13 = intValue;
        return MeasureScope.layout$default(measureScope, i8, intValue, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                floatRef2.element = f;
                List<Placeable> list = list12;
                MeasureScope measureScope = measureScope3;
                Ref.FloatRef floatRef = floatRef2;
                List<TabPosition> list2 = list11;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i), measureScope.m7086roundToPx0680j_4(floatRef.element), 0, 0.0f, 4, (Object) null);
                    floatRef.element = Dp.m7111constructorimpl(floatRef.element + list2.get(i).m2580getWidthD9Ej5fM());
                }
                List<Placeable> list3 = list9;
                int i2 = i13;
                int size2 = list3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Placeable placeable = list3.get(i3);
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i2 - placeable.getHeight(), 0.0f, 4, (Object) null);
                }
                List<Placeable> list4 = list10;
                MeasureScope measureScope2 = measureScope3;
                List<TabPosition> list5 = list11;
                int i4 = i12;
                int i5 = i13;
                int size3 = list4.size();
                for (int i6 = 0; i6 < size3; i6++) {
                    Placeable placeable2 = list4.get(i6);
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, Math.max(0, (measureScope2.m7086roundToPx0680j_4(list5.get(i4).m2580getWidthD9Ej5fM()) - placeable2.getWidth()) / 2), i5 - placeable2.getHeight(), 0.0f, 4, (Object) null);
                }
                scrollableTabData.onLaidOut(measureScope3, r9, list11, i12);
            }
        }, 4, (Object) null);
    }
}
