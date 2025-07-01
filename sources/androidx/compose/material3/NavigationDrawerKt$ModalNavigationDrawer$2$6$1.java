package androidx.compose.material3;

import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$ModalNavigationDrawer$2$6$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<Boolean> $anchorsInitialized$delegate;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ MutableFloatState $minValue$delegate;

    NavigationDrawerKt$ModalNavigationDrawer$2$6$1(DrawerState drawerState, MutableState<Boolean> mutableState, MutableFloatState mutableFloatState, float f) {
        this.$drawerState = drawerState;
        this.$anchorsInitialized$delegate = mutableState;
        this.$minValue$delegate = mutableFloatState;
        this.$maxValue = f;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2268measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Comparable comparable;
        int i = 0;
        long r1 = Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        Collection arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((Measurable) list.get(i2)).m5848measureBRTryo0(r1));
        }
        final List list2 = (List) arrayList;
        Comparable comparable2 = null;
        int i3 = 1;
        if (list2.isEmpty()) {
            comparable = null;
        } else {
            comparable = Integer.valueOf(((Placeable) list2.get(0)).getWidth());
            int lastIndex = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex) {
                int i4 = 1;
                while (true) {
                    Comparable valueOf = Integer.valueOf(((Placeable) list2.get(i4)).getWidth());
                    if (valueOf.compareTo(comparable) > 0) {
                        comparable = valueOf;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
        }
        Integer num = (Integer) comparable;
        int intValue = num != null ? num.intValue() : 0;
        if (!list2.isEmpty()) {
            Comparable valueOf2 = Integer.valueOf(((Placeable) list2.get(0)).getHeight());
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                while (true) {
                    Comparable valueOf3 = Integer.valueOf(((Placeable) list2.get(i3)).getHeight());
                    if (valueOf3.compareTo(valueOf2) > 0) {
                        valueOf2 = valueOf3;
                    }
                    if (i3 == lastIndex2) {
                        break;
                    }
                    i3++;
                }
            }
            comparable2 = valueOf2;
        }
        Integer num2 = (Integer) comparable2;
        if (num2 != null) {
            i = num2.intValue();
        }
        final DrawerState drawerState = this.$drawerState;
        final MutableState<Boolean> mutableState = this.$anchorsInitialized$delegate;
        final int i5 = intValue;
        final MutableFloatState mutableFloatState = this.$minValue$delegate;
        final float f = this.$maxValue;
        return MeasureScope.layout$default(measureScope, i5, i, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                float positionOf = drawerState.getAnchoredDraggableState$material3_release().getAnchors().positionOf(DrawerValue.Closed);
                float f = -((float) i5);
                if (!NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$2(mutableState) || positionOf != f) {
                    if (!NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$2(mutableState)) {
                        NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$3(mutableState, true);
                    }
                    NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$6(mutableFloatState, f);
                    AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = drawerState.getAnchoredDraggableState$material3_release();
                    final float f2 = f;
                    final MutableFloatState mutableFloatState = mutableFloatState;
                    AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((DraggableAnchorsConfig<DrawerValue>) (DraggableAnchorsConfig) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                            draggableAnchorsConfig.at(DrawerValue.Closed, NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$5(mutableFloatState));
                            draggableAnchorsConfig.at(DrawerValue.Open, f2);
                        }
                    }), (Object) null, 2, (Object) null);
                }
                List<Placeable> list = list2;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i), 0, 0, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
