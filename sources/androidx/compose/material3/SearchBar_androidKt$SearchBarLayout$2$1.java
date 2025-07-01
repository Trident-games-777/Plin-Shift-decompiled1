package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    SearchBar_androidKt$SearchBarLayout$2$1(Animatable<Float, AnimationVector1D> animatable, MutableWindowInsets mutableWindowInsets, MutableState<BackEventCompat> mutableState, MutableFloatState mutableFloatState, MutableState<BackEventCompat> mutableState2) {
        this.$animationProgress = animatable;
        this.$unconsumedInsets = mutableWindowInsets;
        this.$currentBackEvent = mutableState;
        this.$finalBackProgress = mutableFloatState;
        this.$firstBackEvent = mutableState2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2416measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        final Placeable placeable;
        int i;
        int i2;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        long j2 = j;
        final float floatValue = this.$animationProgress.getValue().floatValue();
        int size = list2.size();
        int i3 = 0;
        while (i3 < size) {
            Measurable measurable = (Measurable) list2.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "InputField")) {
                int size2 = list2.size();
                int i4 = 0;
                while (i4 < size2) {
                    Measurable measurable2 = (Measurable) list2.get(i4);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "Surface")) {
                        int size3 = list2.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size3) {
                                obj = null;
                                break;
                            }
                            obj = list2.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) "Content")) {
                                break;
                            }
                            i5++;
                        }
                        Measurable measurable3 = (Measurable) obj;
                        final int top = this.$unconsumedInsets.getTop(measureScope2) + measureScope2.m7086roundToPx0680j_4(SearchBar_androidKt.getSearchBarVerticalPadding());
                        int r2 = measureScope2.m7086roundToPx0680j_4(SearchBar_androidKt.getSearchBarVerticalPadding());
                        int r5 = ConstraintsKt.m7069constrainWidthK40F9xA(j2, measurable.maxIntrinsicWidth(Constraints.m7051getMaxHeightimpl(j2)));
                        int r8 = ConstraintsKt.m7068constrainHeightK40F9xA(j2, measurable.minIntrinsicHeight(Constraints.m7052getMaxWidthimpl(j2)));
                        int roundToInt = MathKt.roundToInt(((float) Constraints.m7052getMaxWidthimpl(j2)) * 0.9f);
                        int roundToInt2 = MathKt.roundToInt(((float) Constraints.m7051getMaxHeightimpl(j2)) * 0.9f);
                        final float access$calculatePredictiveBackMultiplier = SearchBar_androidKt.calculatePredictiveBackMultiplier(this.$currentBackEvent.getValue(), floatValue, this.$finalBackProgress.getFloatValue());
                        int lerp = MathHelpersKt.lerp(r5, roundToInt, access$calculatePredictiveBackMultiplier);
                        int i6 = top + r8;
                        int lerp2 = MathHelpersKt.lerp(i6, roundToInt2, access$calculatePredictiveBackMultiplier);
                        int r15 = Constraints.m7052getMaxWidthimpl(j2);
                        int r1 = Constraints.m7051getMaxHeightimpl(j2);
                        int lerp3 = MathHelpersKt.lerp(lerp, r15, floatValue);
                        final int lerp4 = MathHelpersKt.lerp(lerp2, r1, floatValue);
                        int lerp5 = MathHelpersKt.lerp(top, 0, floatValue);
                        int lerp6 = MathHelpersKt.lerp(0, r2, floatValue);
                        int i7 = r2;
                        Placeable r12 = measurable.m5848measureBRTryo0(ConstraintsKt.Constraints(lerp3, r15, r8, r8));
                        int width = r12.getWidth();
                        final Placeable r10 = measurable2.m5848measureBRTryo0(Constraints.Companion.m7062fixedJhjzzOo(width, lerp4 - lerp5));
                        if (measurable3 != null) {
                            if (Constraints.m7047getHasBoundedHeightimpl(j)) {
                                i = 0;
                                i2 = RangesKt.coerceAtLeast(Constraints.m7051getMaxHeightimpl(j) - (i6 + i7), 0);
                            } else {
                                i = 0;
                                i2 = Constraints.m7051getMaxHeightimpl(j);
                            }
                            placeable = measurable3.m5848measureBRTryo0(ConstraintsKt.Constraints(width, width, i, i2));
                        } else {
                            placeable = null;
                        }
                        final Placeable placeable2 = r12;
                        final MutableState<BackEventCompat> mutableState = this.$currentBackEvent;
                        final MutableState<BackEventCompat> mutableState2 = this.$firstBackEvent;
                        final long j3 = j;
                        int i8 = width;
                        final int i9 = lerp5;
                        final int i10 = lerp6;
                        final MeasureScope measureScope3 = measureScope;
                        AnonymousClass1 r13 = new Function1<Placeable.PlacementScope, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                int r5 = measureScope3.m7086roundToPx0680j_4(SearchBar_androidKt.SearchBarPredictiveBackMinMargin);
                                int r12 = SearchBar_androidKt.m2413calculatePredictiveBackOffsetXrOvwMX4(j3, r5, mutableState.getValue(), measureScope3.getLayoutDirection(), floatValue, access$calculatePredictiveBackMultiplier);
                                int r1 = SearchBar_androidKt.m2414calculatePredictiveBackOffsetYdzo92Q0(j3, r5, mutableState.getValue(), mutableState2.getValue(), lerp4, measureScope3.m7086roundToPx0680j_4(SearchBar_androidKt.SearchBarPredictiveBackMaxOffsetY), access$calculatePredictiveBackMultiplier);
                                Placeable.PlacementScope placementScope2 = placementScope;
                                Placeable.PlacementScope.placeRelative$default(placementScope2, r10, r12, r1 + i9, 0.0f, 4, (Object) null);
                                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, r12, r1 + top, 0.0f, 4, (Object) null);
                                Placeable placeable = placeable;
                                if (placeable != null) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, r12, r1 + top + placeable2.getHeight() + i10, 0.0f, 4, (Object) null);
                                }
                            }
                        };
                        return MeasureScope.layout$default(measureScope, i8, lerp4, (Map) null, r13, 4, (Object) null);
                    }
                    i4++;
                    measureScope2 = measureScope;
                    j2 = j;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i3++;
            measureScope2 = measureScope;
            j2 = j;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
