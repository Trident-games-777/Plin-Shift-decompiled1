package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J,\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final float animationProgress;
    /* access modifiers changed from: private */
    public final PaddingValues paddingValues;
    /* access modifiers changed from: private */
    public final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z, float f, PaddingValues paddingValues2) {
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2690measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        Object obj2;
        long j2;
        Placeable placeable;
        Object obj3;
        Object obj4;
        int i;
        Placeable placeable2;
        Placeable placeable3;
        long j3;
        Placeable placeable4;
        Placeable placeable5;
        Object obj5;
        Placeable placeable6;
        Object obj6;
        Placeable placeable7;
        Object obj7;
        TextFieldMeasurePolicy textFieldMeasurePolicy = this;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        int r13 = measureScope2.m7086roundToPx0680j_4(textFieldMeasurePolicy.paddingValues.m792calculateTopPaddingD9Ej5fM());
        int r1 = measureScope2.m7086roundToPx0680j_4(textFieldMeasurePolicy.paddingValues.m789calculateBottomPaddingD9Ej5fM());
        long r4 = Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        int size = list2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                obj = null;
                break;
            }
            obj = list2.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) TextFieldImplKt.LeadingId)) {
                break;
            }
            i2++;
        }
        Measurable measurable = (Measurable) obj;
        Placeable r6 = measurable != null ? measurable.m5848measureBRTryo0(r4) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(r6);
        int max = Math.max(0, TextFieldImplKt.heightOrZero(r6));
        int size2 = list2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), (Object) TextFieldImplKt.TrailingId)) {
                break;
            }
            i3++;
        }
        Measurable measurable2 = (Measurable) obj2;
        if (measurable2 != null) {
            j2 = r4;
            placeable = measurable2.m5848measureBRTryo0(ConstraintsKt.m7072offsetNN6EwU$default(j2, -widthOrZero, 0, 2, (Object) null));
        } else {
            j2 = r4;
            placeable = null;
        }
        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(placeable);
        int max2 = Math.max(max, TextFieldImplKt.heightOrZero(placeable));
        int size3 = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list2.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj3), (Object) TextFieldImplKt.PrefixId)) {
                break;
            }
            i4++;
        }
        Measurable measurable3 = (Measurable) obj3;
        Placeable r8 = measurable3 != null ? measurable3.m5848measureBRTryo0(ConstraintsKt.m7072offsetNN6EwU$default(j2, -widthOrZero2, 0, 2, (Object) null)) : null;
        int widthOrZero3 = widthOrZero2 + TextFieldImplKt.widthOrZero(r8);
        int max3 = Math.max(max2, TextFieldImplKt.heightOrZero(r8));
        int size4 = list2.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list2.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), (Object) TextFieldImplKt.SuffixId)) {
                break;
            }
            i5++;
        }
        Measurable measurable4 = (Measurable) obj4;
        if (measurable4 != null) {
            placeable3 = placeable;
            i = widthOrZero3;
            placeable2 = r6;
            j3 = j2;
            placeable4 = measurable4.m5848measureBRTryo0(ConstraintsKt.m7072offsetNN6EwU$default(j2, -widthOrZero3, 0, 2, (Object) null));
        } else {
            i = widthOrZero3;
            placeable3 = placeable;
            placeable2 = r6;
            j3 = j2;
            placeable4 = null;
        }
        int max4 = Math.max(max3, TextFieldImplKt.heightOrZero(placeable4));
        int i6 = -(TextFieldImplKt.widthOrZero(placeable4) + i);
        long r10 = ConstraintsKt.m7071offsetNN6EwU(j3, i6, -r1);
        int size5 = list2.size();
        int i7 = r1;
        int i8 = 0;
        while (true) {
            if (i8 >= size5) {
                placeable5 = placeable4;
                obj5 = null;
                break;
            }
            obj5 = list2.get(i8);
            int i9 = i8;
            placeable5 = placeable4;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj5), (Object) TextFieldImplKt.LabelId)) {
                break;
            }
            i8 = i9 + 1;
            placeable4 = placeable5;
        }
        Measurable measurable5 = (Measurable) obj5;
        Placeable r12 = measurable5 != null ? measurable5.m5848measureBRTryo0(r10) : null;
        int size6 = list2.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size6) {
                placeable6 = r12;
                obj6 = null;
                break;
            }
            obj6 = list2.get(i10);
            placeable6 = r12;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj6), (Object) TextFieldImplKt.SupportingId)) {
                break;
            }
            i10++;
            r12 = placeable6;
        }
        Measurable measurable6 = (Measurable) obj6;
        int minIntrinsicHeight = measurable6 != null ? measurable6.minIntrinsicHeight(Constraints.m7054getMinWidthimpl(j)) : 0;
        int heightOrZero = TextFieldImplKt.heightOrZero(placeable6) + r13;
        long j4 = j3;
        long r5 = ConstraintsKt.m7071offsetNN6EwU(Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null), i6, ((-heightOrZero) - i7) - minIntrinsicHeight);
        int size7 = list2.size();
        int i11 = 0;
        while (i11 < size7) {
            Measurable measurable7 = (Measurable) list2.get(i11);
            int i12 = size7;
            int i13 = heightOrZero;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable7), (Object) TextFieldImplKt.TextFieldId)) {
                Placeable r14 = measurable7.m5848measureBRTryo0(r5);
                long r2 = Constraints.m7043copyZbe2FdA$default(r5, 0, 0, 0, 0, 14, (Object) null);
                int size8 = list2.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size8) {
                        placeable7 = r14;
                        obj7 = null;
                        break;
                    }
                    obj7 = list2.get(i14);
                    placeable7 = r14;
                    int i15 = size8;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj7), (Object) TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i14++;
                    size8 = i15;
                    r14 = placeable7;
                }
                Measurable measurable8 = (Measurable) obj7;
                Placeable r52 = measurable8 != null ? measurable8.m5848measureBRTryo0(r2) : null;
                int max5 = Math.max(max4, Math.max(TextFieldImplKt.heightOrZero(placeable7), TextFieldImplKt.heightOrZero(r52)) + i13 + i7);
                int r34 = TextFieldKt.m2689calculateWidthyeHjK3Y(TextFieldImplKt.widthOrZero(placeable2), TextFieldImplKt.widthOrZero(placeable3), TextFieldImplKt.widthOrZero(r8), TextFieldImplKt.widthOrZero(placeable5), placeable7.getWidth(), TextFieldImplKt.widthOrZero(placeable6), TextFieldImplKt.widthOrZero(r52), j);
                int i16 = r34;
                Placeable r11 = measurable6 != null ? measurable6.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(ConstraintsKt.m7072offsetNN6EwU$default(j4, 0, -max5, 1, (Object) null), 0, r34, 0, 0, 9, (Object) null)) : null;
                int heightOrZero2 = TextFieldImplKt.heightOrZero(r11);
                int r22 = TextFieldKt.m2688calculateHeightmKXJcVc(placeable7.getHeight(), TextFieldImplKt.heightOrZero(placeable6), TextFieldImplKt.heightOrZero(placeable2), TextFieldImplKt.heightOrZero(placeable3), TextFieldImplKt.heightOrZero(r8), TextFieldImplKt.heightOrZero(placeable5), TextFieldImplKt.heightOrZero(r52), TextFieldImplKt.heightOrZero(r11), textFieldMeasurePolicy.animationProgress, j, measureScope2.getDensity(), textFieldMeasurePolicy.paddingValues);
                int i17 = r22 - heightOrZero2;
                int size9 = list2.size();
                int i18 = 0;
                while (i18 < size9) {
                    Measurable measurable9 = (Measurable) list2.get(i18);
                    int i19 = r22;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable9), (Object) TextFieldImplKt.ContainerId)) {
                        int i20 = i16 != Integer.MAX_VALUE ? i16 : 0;
                        int i21 = i16;
                        int i22 = i19;
                        return MeasureScope.layout$default(measureScope, i21, i22, (Map) null, new TextFieldMeasurePolicy$measure$1(placeable6, i21, i22, placeable7, r52, placeable2, placeable3, r8, placeable5, measurable9.m5848measureBRTryo0(ConstraintsKt.Constraints(i20, i16, i17 != Integer.MAX_VALUE ? i17 : 0, i17)), r11, textFieldMeasurePolicy, r13, measureScope2), 4, (Object) null);
                    }
                    i18++;
                    i16 = i16;
                    r22 = i19;
                    textFieldMeasurePolicy = this;
                    measureScope2 = measureScope;
                    list2 = list;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            long j5 = r5;
            long j6 = j4;
            i11++;
            textFieldMeasurePolicy = this;
            measureScope2 = measureScope;
            heightOrZero = i13;
            r5 = j5;
            size7 = i12;
            list2 = list;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, TextFieldMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, TextFieldMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(list, i, TextFieldMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(list, i, TextFieldMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        List<? extends IntrinsicMeasurable> list2 = list;
        Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22 = function2;
        int size = list2.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj6 = list2.get(i3);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj6), (Object) TextFieldImplKt.TextFieldId)) {
                int intValue = function22.invoke(obj6, Integer.valueOf(i)).intValue();
                int size2 = list2.size();
                int i4 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i4 >= size2) {
                        obj = null;
                        break;
                    }
                    obj = list2.get(i4);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj), (Object) TextFieldImplKt.LabelId)) {
                        break;
                    }
                    i4++;
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj;
                int intValue2 = intrinsicMeasurable2 != null ? function22.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue() : 0;
                int size3 = list2.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size3) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list2.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), (Object) TextFieldImplKt.TrailingId)) {
                        break;
                    }
                    i5++;
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj2;
                int intValue3 = intrinsicMeasurable3 != null ? function22.invoke(intrinsicMeasurable3, Integer.valueOf(i)).intValue() : 0;
                int size4 = list2.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size4) {
                        obj3 = null;
                        break;
                    }
                    obj3 = list2.get(i6);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), (Object) TextFieldImplKt.PrefixId)) {
                        break;
                    }
                    i6++;
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj3;
                int intValue4 = intrinsicMeasurable4 != null ? function22.invoke(intrinsicMeasurable4, Integer.valueOf(i)).intValue() : 0;
                int size5 = list2.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size5) {
                        obj4 = null;
                        break;
                    }
                    obj4 = list2.get(i7);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), (Object) TextFieldImplKt.SuffixId)) {
                        break;
                    }
                    i7++;
                }
                IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) obj4;
                int intValue5 = intrinsicMeasurable5 != null ? function22.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue() : 0;
                int size6 = list2.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size6) {
                        obj5 = null;
                        break;
                    }
                    obj5 = list2.get(i8);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), (Object) TextFieldImplKt.LeadingId)) {
                        break;
                    }
                    i8++;
                }
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj5;
                int intValue6 = intrinsicMeasurable6 != null ? function22.invoke(intrinsicMeasurable6, Integer.valueOf(i)).intValue() : 0;
                int size7 = list2.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size7) {
                        break;
                    }
                    Object obj7 = list2.get(i9);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj7), (Object) TextFieldImplKt.PlaceholderId)) {
                        intrinsicMeasurable = obj7;
                        break;
                    }
                    i9++;
                }
                IntrinsicMeasurable intrinsicMeasurable7 = intrinsicMeasurable;
                if (intrinsicMeasurable7 != null) {
                    i2 = function22.invoke(intrinsicMeasurable7, Integer.valueOf(i)).intValue();
                }
                return TextFieldKt.m2689calculateWidthyeHjK3Y(intValue6, intValue3, intValue4, intValue5, intValue, intValue2, i2, TextFieldImplKt.getZeroConstraints());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        int i2;
        int i3;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        Object obj4;
        int i6;
        Object obj5;
        int i7;
        Object obj6;
        Object obj7;
        List<? extends IntrinsicMeasurable> list2 = list;
        Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22 = function2;
        int size = list2.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                obj = null;
                break;
            }
            obj = list2.get(i8);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj), (Object) TextFieldImplKt.LeadingId)) {
                break;
            }
            i8++;
        }
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj;
        if (intrinsicMeasurable != null) {
            i3 = i;
            i4 = TextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE));
            i2 = function22.invoke(intrinsicMeasurable, Integer.valueOf(i3)).intValue();
        } else {
            i3 = i;
            i4 = i3;
            i2 = 0;
        }
        int size2 = list2.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i9);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), (Object) TextFieldImplKt.TrailingId)) {
                break;
            }
            i9++;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj2;
        if (intrinsicMeasurable2 != null) {
            i4 = TextFieldKt.substractConstraintSafely(i4, intrinsicMeasurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
            i5 = function22.invoke(intrinsicMeasurable2, Integer.valueOf(i3)).intValue();
        } else {
            i5 = 0;
        }
        int size3 = list2.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list2.get(i10);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), (Object) TextFieldImplKt.LabelId)) {
                break;
            }
            i10++;
        }
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj3;
        int intValue = intrinsicMeasurable3 != null ? function22.invoke(intrinsicMeasurable3, Integer.valueOf(i4)).intValue() : 0;
        int size4 = list2.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list2.get(i11);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), (Object) TextFieldImplKt.PrefixId)) {
                break;
            }
            i11++;
        }
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj4;
        if (intrinsicMeasurable4 != null) {
            i6 = function22.invoke(intrinsicMeasurable4, Integer.valueOf(i4)).intValue();
            i4 = TextFieldKt.substractConstraintSafely(i4, intrinsicMeasurable4.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i6 = 0;
        }
        int size5 = list2.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size5) {
                obj5 = null;
                break;
            }
            obj5 = list2.get(i12);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), (Object) TextFieldImplKt.SuffixId)) {
                break;
            }
            i12++;
        }
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) obj5;
        if (intrinsicMeasurable5 != null) {
            int intValue2 = function22.invoke(intrinsicMeasurable5, Integer.valueOf(i4)).intValue();
            i4 = TextFieldKt.substractConstraintSafely(i4, intrinsicMeasurable5.maxIntrinsicWidth(Integer.MAX_VALUE));
            i7 = intValue2;
        } else {
            i7 = 0;
        }
        int size6 = list2.size();
        for (int i13 = 0; i13 < size6; i13++) {
            Object obj8 = list2.get(i13);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj8), (Object) TextFieldImplKt.TextFieldId)) {
                int intValue3 = function22.invoke(obj8, Integer.valueOf(i4)).intValue();
                int size7 = list2.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size7) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list2.get(i14);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj6), (Object) TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i14++;
                }
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj6;
                int intValue4 = intrinsicMeasurable6 != null ? function22.invoke(intrinsicMeasurable6, Integer.valueOf(i4)).intValue() : 0;
                int size8 = list2.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list2.get(i15);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj7), (Object) TextFieldImplKt.SupportingId)) {
                        break;
                    }
                    i15++;
                }
                IntrinsicMeasurable intrinsicMeasurable7 = (IntrinsicMeasurable) obj7;
                return TextFieldKt.m2688calculateHeightmKXJcVc(intValue3, intValue, i2, i5, i6, i7, intValue4, intrinsicMeasurable7 != null ? function22.invoke(intrinsicMeasurable7, Integer.valueOf(i3)).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
