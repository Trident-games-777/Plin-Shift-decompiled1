package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$TabRowWithSubcomposeImpl$1$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$TabRowWithSubcomposeImpl$1$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m2605invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m7058unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m2605invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        final SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        int r2 = Constraints.m7052getMaxWidthimpl(j);
        List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(TabSlots.Tabs, this.$tabs);
        int size = subcompose.size();
        final Ref.IntRef intRef = new Ref.IntRef();
        if (size > 0) {
            intRef.element = r2 / size;
        }
        int i = 0;
        int size2 = subcompose.size();
        for (int i2 = 0; i2 < size2; i2++) {
            i = Integer.valueOf(Math.max(subcompose.get(i2).maxIntrinsicHeight(intRef.element), i.intValue()));
        }
        int intValue = i.intValue();
        ArrayList arrayList = new ArrayList(subcompose.size());
        int size3 = subcompose.size();
        int i3 = 0;
        while (i3 < size3) {
            arrayList.add(subcompose.get(i3).m5848measureBRTryo0(Constraints.m7042copyZbe2FdA(j, intRef.element, intRef.element, intValue, intValue)));
            i3++;
            r2 = r2;
        }
        int i4 = r2;
        final List list = arrayList;
        ArrayList arrayList2 = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList2.add(new TabPosition(Dp.m7111constructorimpl(subcomposeMeasureScope2.m7088toDpu2uoSUM(intRef.element) * ((float) i5)), subcomposeMeasureScope2.m7088toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m7109boximpl(Dp.m7111constructorimpl(subcomposeMeasureScope2.m7088toDpu2uoSUM(Math.min(subcompose.get(i5).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m7111constructorimpl(TabKt.getHorizontalTextPadding() * ((float) 2)))), Dp.m7109boximpl(Dp.m7111constructorimpl((float) 24)))).m7125unboximpl(), (DefaultConstructorMarker) null));
        }
        final List list2 = arrayList2;
        final Function2<Composer, Integer, Unit> function2 = this.$divider;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        final long j2 = j;
        final int i6 = intValue;
        final int i7 = i4;
        return MeasureScope.layout$default(subcomposeMeasureScope2, i4, intValue, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                List<Placeable> list = list;
                Ref.IntRef intRef = intRef;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i), i * intRef.element, 0, 0.0f, 4, (Object) null);
                }
                List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(TabSlots.Divider, function2);
                long j = j2;
                int i2 = i6;
                int size2 = subcompose.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Placeable r15 = subcompose.get(i3).m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null));
                    Placeable.PlacementScope.placeRelative$default(placementScope, r15, 0, i2 - r15.getHeight(), 0.0f, 4, (Object) null);
                }
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                TabSlots tabSlots = TabSlots.Indicator;
                final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function3;
                final List<TabPosition> list2 = list2;
                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1621992604, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C994@43328L23:TabRow.kt#uh7d8r");
                        if ((i & 3) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1621992604, i, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:994)");
                            }
                            function3.invoke(list2, composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }
                }));
                int i4 = i7;
                int i5 = i6;
                int size3 = subcompose2.size();
                for (int i6 = 0; i6 < size3; i6++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose2.get(i6).m5848measureBRTryo0(Constraints.Companion.m7062fixedJhjzzOo(i4, i5)), 0, 0, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
