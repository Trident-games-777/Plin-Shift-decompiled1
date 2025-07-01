package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TopAppBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ ScrolledOffset $scrolledOffset;
    final /* synthetic */ int $titleBottomPadding;
    final /* synthetic */ Arrangement.Horizontal $titleHorizontalArrangement;
    final /* synthetic */ Arrangement.Vertical $titleVerticalArrangement;

    AppBarKt$TopAppBarLayout$2$1(ScrolledOffset scrolledOffset, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i) {
        this.$scrolledOffset = scrolledOffset;
        this.$titleHorizontalArrangement = horizontal;
        this.$titleVerticalArrangement = vertical;
        this.$titleBottomPadding = i;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1729measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        int i2;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Measurable measurable = (Measurable) list2.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "navigationIcon")) {
                Placeable r2 = measurable.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 14, (Object) null));
                int size2 = list2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    Measurable measurable2 = (Measurable) list2.get(i5);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "actionIcons")) {
                        Placeable r4 = measurable2.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 14, (Object) null));
                        if (Constraints.m7052getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                            i = Constraints.m7052getMaxWidthimpl(j);
                        } else {
                            i = RangesKt.coerceAtLeast((Constraints.m7052getMaxWidthimpl(j) - r2.getWidth()) - r4.getWidth(), 0);
                        }
                        int i6 = i;
                        int size3 = list2.size();
                        for (int i7 = 0; i7 < size3; i7++) {
                            Measurable measurable3 = (Measurable) list2.get(i7);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), (Object) "title")) {
                                final Placeable r15 = measurable3.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(j, 0, i6, 0, 0, 12, (Object) null));
                                final int i8 = r15.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? r15.get(AlignmentLineKt.getLastBaseline()) : 0;
                                float offset = this.$scrolledOffset.offset();
                                if (!Float.isNaN(offset)) {
                                    i3 = MathKt.roundToInt(offset);
                                }
                                if (Constraints.m7051getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                                    i2 = Constraints.m7051getMaxHeightimpl(j);
                                } else {
                                    i2 = Constraints.m7051getMaxHeightimpl(j) + i3;
                                }
                                final int i9 = i2;
                                int r6 = Constraints.m7052getMaxWidthimpl(j);
                                final MeasureScope measureScope2 = measureScope;
                                final long j2 = j;
                                final Arrangement.Horizontal horizontal = this.$titleHorizontalArrangement;
                                final Placeable placeable = r2;
                                final Arrangement.Vertical vertical = this.$titleVerticalArrangement;
                                final Placeable placeable2 = r4;
                                final int i10 = this.$titleBottomPadding;
                                return MeasureScope.layout$default(measureScope, r6, i9, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        int i;
                                        int i2;
                                        int height;
                                        int r0;
                                        Placeable placeable = placeable;
                                        Placeable.PlacementScope placementScope2 = placementScope;
                                        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, 0, (i9 - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
                                        Placeable.PlacementScope placementScope3 = placementScope2;
                                        Placeable placeable2 = r15;
                                        Arrangement.Horizontal horizontal = horizontal;
                                        if (Intrinsics.areEqual((Object) horizontal, (Object) Arrangement.INSTANCE.getCenter())) {
                                            i = (Constraints.m7052getMaxWidthimpl(j2) - r15.getWidth()) / 2;
                                            if (i < placeable.getWidth()) {
                                                r0 = placeable.getWidth() - i;
                                            } else if (r15.getWidth() + i > Constraints.m7052getMaxWidthimpl(j2) - placeable2.getWidth()) {
                                                r0 = (Constraints.m7052getMaxWidthimpl(j2) - placeable2.getWidth()) - (r15.getWidth() + i);
                                            }
                                            i += r0;
                                        } else if (Intrinsics.areEqual((Object) horizontal, (Object) Arrangement.INSTANCE.getEnd())) {
                                            i = (Constraints.m7052getMaxWidthimpl(j2) - r15.getWidth()) - placeable2.getWidth();
                                        } else {
                                            i = Math.max(measureScope2.m7086roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), placeable.getWidth());
                                        }
                                        int i3 = i;
                                        Arrangement.Vertical vertical = vertical;
                                        if (Intrinsics.areEqual((Object) vertical, (Object) Arrangement.INSTANCE.getCenter())) {
                                            height = (i9 - r15.getHeight()) / 2;
                                        } else if (Intrinsics.areEqual((Object) vertical, (Object) Arrangement.INSTANCE.getBottom())) {
                                            int i4 = i10;
                                            if (i4 == 0) {
                                                height = i9 - r15.getHeight();
                                            } else {
                                                int height2 = i4 - (r15.getHeight() - i8);
                                                int height3 = r15.getHeight() + height2;
                                                if (height3 > Constraints.m7051getMaxHeightimpl(j2)) {
                                                    height2 -= height3 - Constraints.m7051getMaxHeightimpl(j2);
                                                }
                                                height = (i9 - r15.getHeight()) - Math.max(0, height2);
                                            }
                                        } else {
                                            i2 = 0;
                                            Placeable.PlacementScope.placeRelative$default(placementScope3, placeable2, i3, i2, 0.0f, 4, (Object) null);
                                            Placeable.PlacementScope.placeRelative$default(placementScope3, placeable2, Constraints.m7052getMaxWidthimpl(j2) - placeable2.getWidth(), (i9 - placeable2.getHeight()) / 2, 0.0f, 4, (Object) null);
                                        }
                                        i2 = height;
                                        Placeable.PlacementScope.placeRelative$default(placementScope3, placeable2, i3, i2, 0.0f, 4, (Object) null);
                                        Placeable.PlacementScope.placeRelative$default(placementScope3, placeable2, Constraints.m7052getMaxWidthimpl(j2) - placeable2.getWidth(), (i9 - placeable2.getHeight()) / 2, 0.0f, 4, (Object) null);
                                    }
                                }, 4, (Object) null);
                            }
                            Placeable placeable3 = r2;
                            Placeable placeable4 = r4;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    Placeable placeable5 = r2;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
