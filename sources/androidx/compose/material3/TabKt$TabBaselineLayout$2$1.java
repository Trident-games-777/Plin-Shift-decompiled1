package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
final class TabKt$TabBaselineLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    TabKt$TabBaselineLayout$2$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.$text = function2;
        this.$icon = function22;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2576measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Placeable placeable;
        Placeable placeable2;
        float f;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Integer num = null;
        int i = 0;
        if (this.$text != null) {
            int size = list2.size();
            int i2 = 0;
            while (i2 < size) {
                Measurable measurable = (Measurable) list2.get(i2);
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "text")) {
                    placeable = measurable.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null));
                } else {
                    i2++;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        placeable = null;
        if (this.$icon != null) {
            int size2 = list2.size();
            int i3 = 0;
            while (i3 < size2) {
                Measurable measurable2 = (Measurable) list2.get(i3);
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "icon")) {
                    placeable2 = measurable2.m5848measureBRTryo0(j);
                } else {
                    long j2 = j;
                    i3++;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        placeable2 = null;
        int max = Math.max(placeable != null ? placeable.getWidth() : 0, placeable2 != null ? placeable2.getWidth() : 0);
        if (placeable == null || placeable2 == null) {
            f = TabKt.SmallTabHeight;
        } else {
            f = TabKt.LargeTabHeight;
        }
        int r7 = measureScope2.m7086roundToPx0680j_4(f);
        int height = placeable2 != null ? placeable2.getHeight() : 0;
        if (placeable != null) {
            i = placeable.getHeight();
        }
        final int max2 = Math.max(r7, height + i + measureScope2.m7085roundToPxR2X_6o(TabKt.IconDistanceFromBaseline));
        final Integer valueOf = placeable != null ? Integer.valueOf(placeable.get(AlignmentLineKt.getFirstBaseline())) : null;
        if (placeable != null) {
            num = Integer.valueOf(placeable.get(AlignmentLineKt.getLastBaseline()));
        }
        final Integer num2 = num;
        Placeable placeable3 = placeable;
        final Placeable placeable4 = placeable2;
        final Placeable placeable5 = placeable3;
        final int i4 = max;
        final MeasureScope measureScope3 = measureScope;
        return MeasureScope.layout$default(measureScope, i4, max2, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable placeable;
                Placeable placeable2 = placeable5;
                if (placeable2 == null || (placeable = placeable4) == null) {
                    Placeable.PlacementScope placementScope2 = placementScope;
                    if (placeable2 != null) {
                        TabKt.placeTextOrIcon(placementScope2, placeable2, max2);
                        return;
                    }
                    Placeable placeable3 = placeable4;
                    if (placeable3 != null) {
                        TabKt.placeTextOrIcon(placementScope2, placeable3, max2);
                        return;
                    }
                    return;
                }
                int i = i4;
                int i2 = max2;
                Integer num = valueOf;
                Intrinsics.checkNotNull(num);
                int intValue = num.intValue();
                Integer num2 = num2;
                Intrinsics.checkNotNull(num2);
                int intValue2 = num2.intValue();
                TabKt.placeTextAndIcon(placementScope, measureScope3, placeable2, placeable, i, i2, intValue, intValue2);
            }
        }, 4, (Object) null);
    }
}
