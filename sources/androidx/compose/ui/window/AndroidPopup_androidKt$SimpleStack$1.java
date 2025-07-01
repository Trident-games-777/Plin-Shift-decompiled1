package androidx.compose.ui.window;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class AndroidPopup_androidKt$SimpleStack$1 implements MeasurePolicy {
    public static final AndroidPopup_androidKt$SimpleStack$1 INSTANCE = new AndroidPopup_androidKt$SimpleStack$1();

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m7374measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        int i2;
        int size = list.size();
        if (size == 0) {
            return MeasureScope.layout$default(measureScope, 0, 0, (Map) null, AnonymousClass1.INSTANCE, 4, (Object) null);
        }
        int i3 = 0;
        if (size != 1) {
            ArrayList arrayList = new ArrayList(list.size());
            int size2 = list.size();
            for (int i4 = 0; i4 < size2; i4++) {
                arrayList.add(((Measurable) list.get(i4)).m5848measureBRTryo0(j));
            }
            final List list2 = arrayList;
            int lastIndex = CollectionsKt.getLastIndex(list2);
            if (lastIndex >= 0) {
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    Placeable placeable = (Placeable) list2.get(i3);
                    i5 = Math.max(i5, placeable.getWidth());
                    i6 = Math.max(i6, placeable.getHeight());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
                i2 = i5;
                i = i6;
            } else {
                i2 = 0;
                i = 0;
            }
            return MeasureScope.layout$default(measureScope, i2, i, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    int lastIndex = CollectionsKt.getLastIndex(list2);
                    if (lastIndex >= 0) {
                        int i = 0;
                        while (true) {
                            Placeable.PlacementScope placementScope2 = placementScope;
                            Placeable.PlacementScope.placeRelative$default(placementScope2, list2.get(i), 0, 0, 0.0f, 4, (Object) null);
                            if (i != lastIndex) {
                                i++;
                                placementScope = placementScope2;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }, 4, (Object) null);
        }
        MeasureScope measureScope2 = measureScope;
        final Placeable r11 = ((Measurable) list.get(0)).m5848measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope2, r11.getWidth(), r11.getHeight(), (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, r11, 0, 0, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
