package androidx.compose.material3;

import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<Boolean> $anchorsInitialized$delegate;
    final /* synthetic */ DrawerState $drawerState;

    NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1(DrawerState drawerState, MutableState<Boolean> mutableState) {
        this.$drawerState = drawerState;
        this.$anchorsInitialized$delegate = mutableState;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2266measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final Placeable r0 = ((Measurable) list.get(0)).m5848measureBRTryo0(j);
        final Placeable r10 = ((Measurable) list.get(1)).m5848measureBRTryo0(j);
        int width = r10.getWidth();
        int height = r10.getHeight();
        final DrawerState drawerState = this.$drawerState;
        final MutableState<Boolean> mutableState = this.$anchorsInitialized$delegate;
        return MeasureScope.layout$default(measureScope, width, height, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                float positionOf = drawerState.getAnchoredDraggableState$material3_release().getAnchors().positionOf(DrawerValue.Closed);
                final float f = -((float) r0.getWidth());
                if (!NavigationDrawerKt.DismissibleNavigationDrawer$lambda$16(mutableState) || positionOf != f) {
                    if (!NavigationDrawerKt.DismissibleNavigationDrawer$lambda$16(mutableState)) {
                        NavigationDrawerKt.DismissibleNavigationDrawer$lambda$17(mutableState, true);
                    }
                    AnchoredDraggableState.updateAnchors$default(drawerState.getAnchoredDraggableState$material3_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((DraggableAnchorsConfig<DrawerValue>) (DraggableAnchorsConfig) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                            draggableAnchorsConfig.at(DrawerValue.Closed, f);
                            draggableAnchorsConfig.at(DrawerValue.Open, 0.0f);
                        }
                    }), (Object) null, 2, (Object) null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, r10, r0.getWidth() + MathKt.roundToInt(drawerState.requireOffset$material3_release()), 0, 0.0f, 4, (Object) null);
                Placeable.PlacementScope.placeRelative$default(placementScope, r0, MathKt.roundToInt(drawerState.requireOffset$material3_release()), 0, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
