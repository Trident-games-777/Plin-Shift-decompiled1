package androidx.compose.material3;

import androidx.compose.material3.ListItemType;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00072\u0006\u0010\t\u001a\u00020\u00042,\u0010\n\u001a(\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u000eH\u0002JV\u0010\u000f\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00072\u0006\u0010\u0010\u001a\u00020\u00042,\u0010\n\u001a(\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u000eH\u0002J(\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J(\u0010\u0012\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00072\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J2\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u001b\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J(\u0010\u001c\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00072\u0006\u0010\u0010\u001a\u00020\u0004H\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/ListItemMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "()V", "calculateIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "calculateIntrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemMeasurePolicy implements MultiContentMeasurePolicy {
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2178measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        long j2;
        Placeable placeable;
        long j3;
        Placeable placeable2;
        Placeable placeable3;
        Placeable placeable4;
        Placeable placeable5;
        MeasureScope measureScope2 = measureScope;
        List<? extends List<? extends Measurable>> list2 = list;
        List list3 = (List) list2.get(0);
        boolean z = true;
        List list4 = (List) list2.get(1);
        List list5 = (List) list2.get(2);
        List list6 = (List) list2.get(3);
        List list7 = (List) list2.get(4);
        long r11 = Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        float listItemStartPadding = ListItemKt.getListItemStartPadding();
        float listItemEndPadding = ListItemKt.getListItemEndPadding();
        int r13 = measureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(listItemStartPadding + listItemEndPadding));
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull(list6);
        int minIntrinsicWidth = measurable != null ? measurable.minIntrinsicWidth(Constraints.m7051getMaxHeightimpl(j)) : 0;
        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull(list7);
        int access$subtractConstraintSafely = ListItemKt.subtractConstraintSafely(Constraints.m7052getMaxWidthimpl(r11), minIntrinsicWidth + (measurable2 != null ? measurable2.minIntrinsicWidth(Constraints.m7051getMaxHeightimpl(j)) : 0) + r13);
        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull(list5);
        boolean access$isSupportingMultilineHeuristic = ListItemKt.isSupportingMultilineHeuristic(measureScope2, measurable3 != null ? measurable3.minIntrinsicHeight(access$subtractConstraintSafely) : 0);
        ListItemType.Companion companion = ListItemType.Companion;
        boolean z2 = CollectionsKt.firstOrNull(list4) != null;
        if (CollectionsKt.firstOrNull(list5) == null) {
            z = false;
        }
        float f = (float) 2;
        long r112 = ConstraintsKt.m7071offsetNN6EwU(r11, -r13, -measureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(ListItemKt.m2177verticalPaddingyh95HIg(companion.m2191invokeZLSjz4$material3_release(z2, z, access$isSupportingMultilineHeuristic)) * f)));
        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull(list6);
        Placeable r2 = measurable4 != null ? measurable4.m5848measureBRTryo0(r112) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(r2);
        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull(list7);
        if (measurable5 != null) {
            j2 = r112;
            placeable = measurable5.m5848measureBRTryo0(ConstraintsKt.m7072offsetNN6EwU$default(j2, -widthOrZero, 0, 2, (Object) null));
        } else {
            j2 = r112;
            placeable = null;
        }
        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(placeable);
        Measurable measurable6 = (Measurable) CollectionsKt.firstOrNull(list3);
        if (measurable6 != null) {
            j3 = j2;
            placeable2 = measurable6.m5848measureBRTryo0(ConstraintsKt.m7072offsetNN6EwU$default(j2, -widthOrZero2, 0, 2, (Object) null));
        } else {
            j3 = j2;
            placeable2 = null;
        }
        int heightOrZero = TextFieldImplKt.heightOrZero(placeable2);
        Measurable measurable7 = (Measurable) CollectionsKt.firstOrNull(list5);
        if (measurable7 != null) {
            placeable3 = placeable;
            placeable4 = r2;
            placeable5 = measurable7.m5848measureBRTryo0(ConstraintsKt.m7071offsetNN6EwU(j3, -widthOrZero2, -heightOrZero));
        } else {
            placeable3 = placeable;
            placeable4 = r2;
            placeable5 = null;
        }
        int heightOrZero2 = heightOrZero + TextFieldImplKt.heightOrZero(placeable5);
        boolean z3 = (placeable5 == null || placeable5.get(AlignmentLineKt.getFirstBaseline()) == placeable5.get(AlignmentLineKt.getLastBaseline())) ? false : true;
        Measurable measurable8 = (Measurable) CollectionsKt.firstOrNull(list4);
        Placeable r6 = measurable8 != null ? measurable8.m5848measureBRTryo0(ConstraintsKt.m7071offsetNN6EwU(j3, -widthOrZero2, -heightOrZero2)) : null;
        int r1 = ListItemType.Companion.m2191invokeZLSjz4$material3_release(r6 != null, placeable5 != null, z3);
        float r22 = ListItemKt.m2177verticalPaddingyh95HIg(r1);
        float r4 = Dp.m7111constructorimpl(f * r22);
        int i = r13;
        IntrinsicMeasureScope intrinsicMeasureScope = measureScope2;
        int r5 = ListItemKt.m2176calculateWidthyeHjK3Y(intrinsicMeasureScope, TextFieldImplKt.widthOrZero(placeable4), TextFieldImplKt.widthOrZero(placeable3), TextFieldImplKt.widthOrZero(placeable2), TextFieldImplKt.widthOrZero(r6), TextFieldImplKt.widthOrZero(placeable5), i, j);
        int i2 = r1;
        return ListItemKt.place(measureScope2, r5, ListItemKt.m2175calculateHeightN4Jib3Y(intrinsicMeasureScope, TextFieldImplKt.heightOrZero(placeable4), TextFieldImplKt.heightOrZero(placeable3), TextFieldImplKt.heightOrZero(placeable2), TextFieldImplKt.heightOrZero(r6), TextFieldImplKt.heightOrZero(placeable5), i2, measureScope2.m7086roundToPx0680j_4(r4), j), placeable4, placeable3, placeable2, r6, placeable5, ListItemType.m2183equalsimpl0(i2, ListItemType.Companion.m2189getThreeLineAlXitO8()), measureScope2.m7086roundToPx0680j_4(listItemStartPadding), measureScope2.m7086roundToPx0680j_4(listItemEndPadding), measureScope2.m7086roundToPx0680j_4(r22));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, list, i, ListItemMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(intrinsicMeasureScope, list, i, ListItemMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, list, i, ListItemMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(intrinsicMeasureScope, list, i, ListItemMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }

    private final int calculateIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        List<? extends List<? extends IntrinsicMeasurable>> list2 = list;
        Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22 = function2;
        int i2 = 0;
        List list3 = (List) list2.get(0);
        List list4 = (List) list2.get(1);
        List list5 = (List) list2.get(2);
        List list6 = (List) list2.get(4);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list2.get(3));
        int intValue = intrinsicMeasurable != null ? function22.invoke(intrinsicMeasurable, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list6);
        int intValue2 = intrinsicMeasurable2 != null ? function22.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3);
        int intValue3 = intrinsicMeasurable3 != null ? function22.invoke(intrinsicMeasurable3, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list4);
        int intValue4 = intrinsicMeasurable4 != null ? function22.invoke(intrinsicMeasurable4, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list5);
        if (intrinsicMeasurable5 != null) {
            i2 = function22.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue();
        }
        IntrinsicMeasureScope intrinsicMeasureScope2 = intrinsicMeasureScope;
        return ListItemKt.m2176calculateWidthyeHjK3Y(intrinsicMeasureScope2, intValue, intValue2, intValue3, intValue4, i2, intrinsicMeasureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null));
    }

    private final int calculateIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        int i2;
        int i3;
        IntrinsicMeasureScope intrinsicMeasureScope2 = intrinsicMeasureScope;
        List<? extends List<? extends IntrinsicMeasurable>> list2 = list;
        Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22 = function2;
        int i4 = 0;
        List list3 = (List) list2.get(0);
        boolean z = true;
        List list4 = (List) list2.get(1);
        List list5 = (List) list2.get(2);
        List list6 = (List) list2.get(4);
        int i5 = i;
        int access$subtractConstraintSafely = ListItemKt.subtractConstraintSafely(i5, intrinsicMeasureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())));
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list2.get(3));
        if (intrinsicMeasurable != null) {
            i2 = function22.invoke(intrinsicMeasurable, Integer.valueOf(access$subtractConstraintSafely)).intValue();
            access$subtractConstraintSafely = ListItemKt.subtractConstraintSafely(access$subtractConstraintSafely, intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i2 = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list6);
        if (intrinsicMeasurable2 != null) {
            i3 = function22.invoke(intrinsicMeasurable2, Integer.valueOf(access$subtractConstraintSafely)).intValue();
            access$subtractConstraintSafely = ListItemKt.subtractConstraintSafely(access$subtractConstraintSafely, intrinsicMeasurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i3 = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list4);
        int intValue = intrinsicMeasurable3 != null ? function22.invoke(intrinsicMeasurable3, Integer.valueOf(access$subtractConstraintSafely)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list5);
        int intValue2 = intrinsicMeasurable4 != null ? function22.invoke(intrinsicMeasurable4, Integer.valueOf(access$subtractConstraintSafely)).intValue() : 0;
        boolean access$isSupportingMultilineHeuristic = ListItemKt.isSupportingMultilineHeuristic(intrinsicMeasureScope2, intValue2);
        ListItemType.Companion companion = ListItemType.Companion;
        boolean z2 = intValue > 0;
        if (intValue2 <= 0) {
            z = false;
        }
        int r5 = companion.m2191invokeZLSjz4$material3_release(z2, z, access$isSupportingMultilineHeuristic);
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3);
        if (intrinsicMeasurable5 != null) {
            i4 = function22.invoke(intrinsicMeasurable5, Integer.valueOf(i5)).intValue();
        }
        return ListItemKt.m2175calculateHeightN4Jib3Y(intrinsicMeasureScope2, i2, i3, i4, intValue, intValue2, r5, intrinsicMeasureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(ListItemKt.m2177verticalPaddingyh95HIg(r5) * ((float) 2))), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null));
    }
}
