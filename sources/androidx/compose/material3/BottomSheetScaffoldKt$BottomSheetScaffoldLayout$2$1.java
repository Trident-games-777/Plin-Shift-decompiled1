package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "<name for destructuring parameter 0>", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ SheetState $sheetState;

    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1(SheetState sheetState, Function0<Float> function0) {
        this.$sheetState = sheetState;
        this.$sheetOffset = function0;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1751measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Comparable comparable;
        List<? extends List<? extends Measurable>> list2 = list;
        List list3 = (List) list2.get(0);
        int i = 1;
        List list4 = (List) list2.get(1);
        List list5 = (List) list2.get(2);
        List list6 = (List) list2.get(3);
        int r8 = Constraints.m7052getMaxWidthimpl(j);
        final int r13 = Constraints.m7051getMaxHeightimpl(j);
        long r9 = Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        ArrayList arrayList = new ArrayList(list5.size());
        int size = list5.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((Measurable) list5.get(i2)).m5848measureBRTryo0(r9));
        }
        List list7 = arrayList;
        ArrayList arrayList2 = new ArrayList(list3.size());
        int size2 = list3.size();
        for (int i3 = 0; i3 < size2; i3++) {
            arrayList2.add(((Measurable) list3.get(i3)).m5848measureBRTryo0(r9));
        }
        final List list8 = arrayList2;
        if (list8.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((Placeable) list8.get(0)).getHeight());
            int lastIndex = CollectionsKt.getLastIndex(list8);
            if (1 <= lastIndex) {
                while (true) {
                    Comparable valueOf = Integer.valueOf(((Placeable) list8.get(i)).getHeight());
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        Integer num = (Integer) comparable;
        final int intValue = num != null ? num.intValue() : 0;
        long r3 = Constraints.m7043copyZbe2FdA$default(r9, 0, 0, 0, r13 - intValue, 7, (Object) null);
        ArrayList arrayList3 = new ArrayList(list4.size());
        int size3 = list4.size();
        for (int i4 = 0; i4 < size3; i4++) {
            arrayList3.add(((Measurable) list4.get(i4)).m5848measureBRTryo0(r3));
        }
        final List list9 = arrayList3;
        ArrayList arrayList4 = new ArrayList(list6.size());
        int size4 = list6.size();
        for (int i5 = 0; i5 < size4; i5++) {
            arrayList4.add(((Measurable) list6.get(i5)).m5848measureBRTryo0(r9));
        }
        final List list10 = arrayList4;
        final int i6 = r8;
        final List list11 = list7;
        final SheetState sheetState = this.$sheetState;
        final Function0<Float> function0 = this.$sheetOffset;
        return MeasureScope.layout$default(measureScope, i6, r13, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$1$WhenMappings */
            /* compiled from: BottomSheetScaffold.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                static {
                    /*
                        androidx.compose.material3.SheetValue[] r0 = androidx.compose.material3.SheetValue.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.PartiallyExpanded     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Expanded     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Hidden     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        $EnumSwitchMapping$0 = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1.AnonymousClass1.WhenMappings.<clinit>():void");
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Comparable comparable;
                Comparable comparable2;
                int i;
                List<Placeable> list = list11;
                Comparable comparable3 = null;
                if (list.isEmpty()) {
                    comparable = null;
                } else {
                    comparable = Integer.valueOf(list.get(0).getWidth());
                    int lastIndex = CollectionsKt.getLastIndex(list);
                    if (1 <= lastIndex) {
                        int i2 = 1;
                        while (true) {
                            Comparable valueOf = Integer.valueOf(list.get(i2).getWidth());
                            if (valueOf.compareTo(comparable) > 0) {
                                comparable = valueOf;
                            }
                            if (i2 == lastIndex) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
                Integer num = (Integer) comparable;
                int max = Integer.max(0, (i6 - (num != null ? num.intValue() : 0)) / 2);
                List<Placeable> list2 = list10;
                if (list2.isEmpty()) {
                    comparable2 = null;
                } else {
                    comparable2 = Integer.valueOf(list2.get(0).getWidth());
                    int lastIndex2 = CollectionsKt.getLastIndex(list2);
                    if (1 <= lastIndex2) {
                        int i3 = 1;
                        while (true) {
                            Comparable valueOf2 = Integer.valueOf(list2.get(i3).getWidth());
                            if (valueOf2.compareTo(comparable2) > 0) {
                                comparable2 = valueOf2;
                            }
                            if (i3 == lastIndex2) {
                                break;
                            }
                            i3++;
                        }
                    }
                }
                Integer num2 = (Integer) comparable2;
                int intValue = num2 != null ? num2.intValue() : 0;
                List<Placeable> list3 = list10;
                if (!list3.isEmpty()) {
                    comparable3 = Integer.valueOf(list3.get(0).getHeight());
                    int lastIndex3 = CollectionsKt.getLastIndex(list3);
                    if (1 <= lastIndex3) {
                        int i4 = 1;
                        while (true) {
                            Comparable valueOf3 = Integer.valueOf(list3.get(i4).getHeight());
                            if (valueOf3.compareTo(comparable3) > 0) {
                                comparable3 = valueOf3;
                            }
                            if (i4 == lastIndex3) {
                                break;
                            }
                            i4++;
                        }
                    }
                }
                Integer num3 = (Integer) comparable3;
                int intValue2 = num3 != null ? num3.intValue() : 0;
                int i5 = (i6 - intValue) / 2;
                int i6 = WhenMappings.$EnumSwitchMapping$0[sheetState.getCurrentValue().ordinal()];
                if (i6 == 1) {
                    i = MathKt.roundToInt(function0.invoke().floatValue());
                } else if (i6 == 2 || i6 == 3) {
                    i = r13;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                int i7 = i - intValue2;
                List<Placeable> list4 = list9;
                int i8 = intValue;
                int size = list4.size();
                for (int i9 = 0; i9 < size; i9++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list4.get(i9), 0, i8, 0.0f, 4, (Object) null);
                }
                List<Placeable> list5 = list8;
                int size2 = list5.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i10), 0, 0, 0.0f, 4, (Object) null);
                }
                List<Placeable> list6 = list11;
                int size3 = list6.size();
                for (int i11 = 0; i11 < size3; i11++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list6.get(i11), max, 0, 0.0f, 4, (Object) null);
                }
                List<Placeable> list7 = list10;
                int size4 = list7.size();
                for (int i12 = 0; i12 < size4; i12++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list7.get(i12), i5, i7, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
