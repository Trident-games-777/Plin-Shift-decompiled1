package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$NavigationBarItemLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ Function0<Float> $animationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;

    NavigationBarKt$NavigationBarItemLayout$2$1(Function0<Float> function0, Function2<? super Composer, ? super Integer, Unit> function2, boolean z) {
        this.$animationProgress = function0;
        this.$label = function2;
        this.$alwaysShowLabel = z;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2255measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        Placeable placeable;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        float floatValue = this.$animationProgress.invoke().floatValue();
        long r3 = Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        int size = list2.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = (Measurable) list2.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "icon")) {
                Placeable r5 = measurable.m5848measureBRTryo0(r3);
                float f = (float) 2;
                int width = r5.getWidth() + measureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(NavigationBarKt.IndicatorHorizontalPadding * f));
                int roundToInt = MathKt.roundToInt(((float) width) * floatValue);
                int height = r5.getHeight() + measureScope2.m7086roundToPx0680j_4(Dp.m7111constructorimpl(NavigationBarKt.getIndicatorVerticalPadding() * f));
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = (Measurable) list2.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "indicatorRipple")) {
                        Placeable r6 = measurable2.m5848measureBRTryo0(Constraints.Companion.m7062fixedJhjzzOo(width, height));
                        int size3 = list2.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                obj = null;
                                break;
                            }
                            obj = list2.get(i3);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) "indicator")) {
                                break;
                            }
                            i3++;
                        }
                        Measurable measurable3 = (Measurable) obj;
                        Placeable r7 = measurable3 != null ? measurable3.m5848measureBRTryo0(Constraints.Companion.m7062fixedJhjzzOo(roundToInt, height)) : null;
                        if (this.$label != null) {
                            int size4 = list2.size();
                            int i4 = 0;
                            while (i4 < size4) {
                                Measurable measurable4 = (Measurable) list2.get(i4);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), (Object) Constants.ScionAnalytics.PARAM_LABEL)) {
                                    placeable = measurable4.m5848measureBRTryo0(r3);
                                } else {
                                    i4++;
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeable = null;
                        if (this.$label == null) {
                            return NavigationBarKt.m2252placeIconX9ElhV4(measureScope2, r5, r6, r7, j);
                        }
                        Intrinsics.checkNotNull(placeable);
                        return NavigationBarKt.m2253placeLabelAndIconzUg2_y0(measureScope, placeable, r5, r6, r7, j, this.$alwaysShowLabel, floatValue);
                    }
                    Placeable placeable2 = r5;
                    i2++;
                    measureScope2 = measureScope;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i++;
            measureScope2 = measureScope;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
