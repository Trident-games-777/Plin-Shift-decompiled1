package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
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
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J,\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final float animationProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    /* access modifiers changed from: private */
    public final PaddingValues paddingValues;
    /* access modifiers changed from: private */
    public final boolean singleLine;

    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> function1, boolean z, float f, PaddingValues paddingValues2) {
        this.onLabelMeasured = function1;
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2333measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Placeable placeable;
        Object obj5;
        Object obj6;
        Object obj7;
        OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = this;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        int r1 = measureScope2.m7086roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.m789calculateBottomPaddingD9Ej5fM());
        long r14 = Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        int size = list2.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list2.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) TextFieldImplKt.LeadingId)) {
                break;
            }
            i++;
        }
        Measurable measurable = (Measurable) obj;
        Placeable r2 = measurable != null ? measurable.m5848measureBRTryo0(r14) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(r2);
        int max = Math.max(0, TextFieldImplKt.heightOrZero(r2));
        int size2 = list2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), (Object) TextFieldImplKt.TrailingId)) {
                break;
            }
            i2++;
        }
        Measurable measurable2 = (Measurable) obj2;
        Placeable r7 = measurable2 != null ? measurable2.m5848measureBRTryo0(ConstraintsKt.m7072offsetNN6EwU$default(r14, -widthOrZero, 0, 2, (Object) null)) : null;
        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(r7);
        int max2 = Math.max(max, TextFieldImplKt.heightOrZero(r7));
        int size3 = list2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list2.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj3), (Object) TextFieldImplKt.PrefixId)) {
                break;
            }
            i3++;
        }
        Measurable measurable3 = (Measurable) obj3;
        Placeable r3 = measurable3 != null ? measurable3.m5848measureBRTryo0(ConstraintsKt.m7072offsetNN6EwU$default(r14, -widthOrZero2, 0, 2, (Object) null)) : null;
        int widthOrZero3 = widthOrZero2 + TextFieldImplKt.widthOrZero(r3);
        int max3 = Math.max(max2, TextFieldImplKt.heightOrZero(r3));
        int size4 = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list2.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), (Object) TextFieldImplKt.SuffixId)) {
                break;
            }
            i4++;
        }
        Measurable measurable4 = (Measurable) obj4;
        Placeable r5 = measurable4 != null ? measurable4.m5848measureBRTryo0(ConstraintsKt.m7072offsetNN6EwU$default(r14, -widthOrZero3, 0, 2, (Object) null)) : null;
        int widthOrZero4 = widthOrZero3 + TextFieldImplKt.widthOrZero(r5);
        int max4 = Math.max(max3, TextFieldImplKt.heightOrZero(r5));
        int r8 = measureScope2.m7086roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.m790calculateLeftPaddingu2uoSUM(measureScope2.getLayoutDirection())) + measureScope2.m7086roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.m791calculateRightPaddingu2uoSUM(measureScope2.getLayoutDirection()));
        int i5 = -widthOrZero4;
        int i6 = -r1;
        long r10 = ConstraintsKt.m7071offsetNN6EwU(r14, MathHelpersKt.lerp(i5 - r8, -r8, outlinedTextFieldMeasurePolicy.animationProgress), i6);
        int size5 = list2.size();
        int i7 = r1;
        int i8 = 0;
        while (true) {
            if (i8 >= size5) {
                placeable = r2;
                obj5 = null;
                break;
            }
            obj5 = list2.get(i8);
            int i9 = i8;
            placeable = r2;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj5), (Object) TextFieldImplKt.LabelId)) {
                break;
            }
            i8 = i9 + 1;
            r2 = placeable;
        }
        Measurable measurable5 = (Measurable) obj5;
        Placeable r82 = measurable5 != null ? measurable5.m5848measureBRTryo0(r10) : null;
        outlinedTextFieldMeasurePolicy.onLabelMeasured.invoke(Size.m4044boximpl(r82 != null ? SizeKt.Size((float) r82.getWidth(), (float) r82.getHeight()) : Size.Companion.m4065getZeroNHjbRc()));
        int size6 = list2.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size6) {
                obj6 = null;
                break;
            }
            obj6 = list2.get(i10);
            int i11 = size6;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj6), (Object) TextFieldImplKt.SupportingId)) {
                break;
            }
            i10++;
            size6 = i11;
        }
        Measurable measurable6 = (Measurable) obj6;
        int minIntrinsicHeight = measurable6 != null ? measurable6.minIntrinsicHeight(Constraints.m7054getMinWidthimpl(j)) : 0;
        int max5 = Math.max(TextFieldImplKt.heightOrZero(r82) / 2, measureScope2.m7086roundToPx0680j_4(outlinedTextFieldMeasurePolicy.paddingValues.m792calculateTopPaddingD9Ej5fM()));
        int i12 = max5;
        long r12 = Constraints.m7043copyZbe2FdA$default(ConstraintsKt.m7071offsetNN6EwU(j, i5, (i6 - max5) - minIntrinsicHeight), 0, 0, 0, 0, 11, (Object) null);
        int size7 = list2.size();
        Placeable placeable2 = r3;
        int i13 = 0;
        while (i13 < size7) {
            int i14 = size7;
            Measurable measurable7 = (Measurable) list2.get(i13);
            Placeable placeable3 = r5;
            Placeable placeable4 = r7;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable7), (Object) TextFieldImplKt.TextFieldId)) {
                Placeable r72 = measurable7.m5848measureBRTryo0(r12);
                long r13 = Constraints.m7043copyZbe2FdA$default(r12, 0, 0, 0, 0, 14, (Object) null);
                int size8 = list2.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list2.get(i15);
                    int i16 = size8;
                    int i17 = i15;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj7), (Object) TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i15 = i17 + 1;
                    size8 = i16;
                }
                Measurable measurable8 = (Measurable) obj7;
                Placeable r9 = measurable8 != null ? measurable8.m5848measureBRTryo0(r13) : null;
                int max6 = Math.max(max4, Math.max(TextFieldImplKt.heightOrZero(r72), TextFieldImplKt.heightOrZero(r9)) + i12 + i7);
                int r33 = OutlinedTextFieldKt.m2332calculateWidthDHJA7U0(TextFieldImplKt.widthOrZero(placeable), TextFieldImplKt.widthOrZero(placeable4), TextFieldImplKt.widthOrZero(placeable2), TextFieldImplKt.widthOrZero(placeable3), r72.getWidth(), TextFieldImplKt.widthOrZero(r82), TextFieldImplKt.widthOrZero(r9), outlinedTextFieldMeasurePolicy.animationProgress, j, measureScope2.getDensity(), outlinedTextFieldMeasurePolicy.paddingValues);
                int i18 = r33;
                Placeable r11 = measurable6 != null ? measurable6.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(ConstraintsKt.m7072offsetNN6EwU$default(r14, 0, -max6, 1, (Object) null), 0, r33, 0, 0, 9, (Object) null)) : null;
                int heightOrZero = TextFieldImplKt.heightOrZero(r11);
                int r22 = OutlinedTextFieldKt.m2331calculateHeightmKXJcVc(TextFieldImplKt.heightOrZero(placeable), TextFieldImplKt.heightOrZero(placeable4), TextFieldImplKt.heightOrZero(placeable2), TextFieldImplKt.heightOrZero(placeable3), r72.getHeight(), TextFieldImplKt.heightOrZero(r82), TextFieldImplKt.heightOrZero(r9), TextFieldImplKt.heightOrZero(r11), outlinedTextFieldMeasurePolicy.animationProgress, j, measureScope2.getDensity(), outlinedTextFieldMeasurePolicy.paddingValues);
                int i19 = r22 - heightOrZero;
                int size9 = list2.size();
                int i20 = 0;
                while (i20 < size9) {
                    Measurable measurable9 = (Measurable) list2.get(i20);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable9), (Object) TextFieldImplKt.ContainerId)) {
                        int i21 = i18 != Integer.MAX_VALUE ? i18 : 0;
                        int i22 = i19 != Integer.MAX_VALUE ? i19 : 0;
                        int i23 = r22;
                        int i24 = i18;
                        return MeasureScope.layout$default(measureScope, i24, i23, (Map) null, new OutlinedTextFieldMeasurePolicy$measure$1(i23, i24, placeable, placeable4, placeable2, placeable3, r72, r82, r9, measurable9.m5848measureBRTryo0(ConstraintsKt.Constraints(i21, i18, i22, i19)), r11, outlinedTextFieldMeasurePolicy, measureScope2), 4, (Object) null);
                    }
                    int i25 = i18;
                    Placeable placeable5 = placeable4;
                    i20++;
                    outlinedTextFieldMeasurePolicy = this;
                    measureScope2 = measureScope;
                    i18 = i25;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            long j2 = r12;
            i13++;
            outlinedTextFieldMeasurePolicy = this;
            measureScope2 = measureScope;
            r7 = placeable4;
            size7 = i14;
            r5 = placeable3;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }

    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), (Object) TextFieldImplKt.LeadingId)) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), (Object) TextFieldImplKt.PrefixId)) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), (Object) TextFieldImplKt.SuffixId)) {
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
                return OutlinedTextFieldKt.m2332calculateWidthDHJA7U0(intValue4, intValue3, intValue5, intValue6, intValue, intValue2, i2, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        int i2;
        int i3;
        Object obj2;
        int i4;
        Object obj3;
        Object obj4;
        int i5;
        Object obj5;
        int i6;
        Object obj6;
        IntrinsicMeasurable intrinsicMeasurable;
        List<? extends IntrinsicMeasurable> list2 = list;
        int i7 = i;
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
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj;
        if (intrinsicMeasurable2 != null) {
            i3 = OutlinedTextFieldKt.substractConstraintSafely(i7, intrinsicMeasurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
            i2 = function22.invoke(intrinsicMeasurable2, Integer.valueOf(i7)).intValue();
        } else {
            i3 = i7;
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
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj2;
        if (intrinsicMeasurable3 != null) {
            i3 = OutlinedTextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable3.maxIntrinsicWidth(Integer.MAX_VALUE));
            i4 = function22.invoke(intrinsicMeasurable3, Integer.valueOf(i7)).intValue();
        } else {
            i4 = 0;
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
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj3;
        int intValue = intrinsicMeasurable4 != null ? function22.invoke(intrinsicMeasurable4, Integer.valueOf(MathHelpersKt.lerp(i3, i7, this.animationProgress))).intValue() : 0;
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
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) obj4;
        if (intrinsicMeasurable5 != null) {
            i5 = function22.invoke(intrinsicMeasurable5, Integer.valueOf(i3)).intValue();
            i3 = OutlinedTextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable5.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i5 = 0;
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
        IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj5;
        if (intrinsicMeasurable6 != null) {
            int intValue2 = function22.invoke(intrinsicMeasurable6, Integer.valueOf(i3)).intValue();
            i3 = OutlinedTextFieldKt.substractConstraintSafely(i3, intrinsicMeasurable6.maxIntrinsicWidth(Integer.MAX_VALUE));
            i6 = intValue2;
        } else {
            i6 = 0;
        }
        int size6 = list2.size();
        for (int i13 = 0; i13 < size6; i13++) {
            Object obj7 = list2.get(i13);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj7), (Object) TextFieldImplKt.TextFieldId)) {
                int intValue3 = function22.invoke(obj7, Integer.valueOf(i3)).intValue();
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
                IntrinsicMeasurable intrinsicMeasurable7 = (IntrinsicMeasurable) obj6;
                int intValue4 = intrinsicMeasurable7 != null ? function22.invoke(intrinsicMeasurable7, Integer.valueOf(i3)).intValue() : 0;
                int size8 = list2.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size8) {
                        intrinsicMeasurable = null;
                        break;
                    }
                    Object obj8 = list2.get(i15);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj8), (Object) TextFieldImplKt.SupportingId)) {
                        intrinsicMeasurable = obj8;
                        break;
                    }
                    i15++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable;
                return OutlinedTextFieldKt.m2331calculateHeightmKXJcVc(i2, i4, i5, i6, intValue3, intValue, intValue4, intrinsicMeasurable8 != null ? function22.invoke(intrinsicMeasurable8, Integer.valueOf(i7)).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
