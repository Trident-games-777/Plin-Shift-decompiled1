package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$ScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$ScaffoldLayout$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$topBar = function2;
        this.$snackbar = function22;
        this.$fab = function23;
        this.$fabPosition = i;
        this.$contentWindowInsets = windowInsets;
        this.$bottomBar = function24;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m2394invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m7058unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m2394invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        List list;
        FabPlacement fabPlacement;
        Object obj4;
        Integer num;
        int i;
        int i2;
        int i3;
        Object obj5;
        Object obj6;
        int i4;
        boolean z;
        int r4;
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        int r9 = Constraints.m7052getMaxWidthimpl(j);
        final int r11 = Constraints.m7051getMaxHeightimpl(j);
        long r12 = Constraints.m7043copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.TopBar, this.$topBar);
        ArrayList arrayList = new ArrayList(subcompose.size());
        int size = subcompose.size();
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(subcompose.get(i5).m5848measureBRTryo0(r12));
        }
        List list2 = arrayList;
        if (list2.isEmpty()) {
            obj = null;
        } else {
            obj = list2.get(0);
            int height = ((Placeable) obj).getHeight();
            int lastIndex = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex) {
                int i6 = 1;
                while (true) {
                    Object obj7 = list2.get(i6);
                    int height2 = ((Placeable) obj7).getHeight();
                    if (height < height2) {
                        obj = obj7;
                        height = height2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        int height3 = placeable != null ? placeable.getHeight() : 0;
        List<Measurable> subcompose2 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Snackbar, this.$snackbar);
        WindowInsets windowInsets = this.$contentWindowInsets;
        ArrayList arrayList2 = new ArrayList(subcompose2.size());
        int size2 = subcompose2.size();
        int i7 = 0;
        while (i7 < size2) {
            Density density = subcomposeMeasureScope2;
            arrayList2.add(subcompose2.get(i7).m5848measureBRTryo0(ConstraintsKt.m7071offsetNN6EwU(r12, (-windowInsets.getLeft(density, subcomposeMeasureScope2.getLayoutDirection())) - windowInsets.getRight(density, subcomposeMeasureScope2.getLayoutDirection()), -windowInsets.getBottom(density))));
            i7++;
            height3 = height3;
            subcompose2 = subcompose2;
            list2 = list2;
        }
        List list3 = list2;
        int i8 = height3;
        List list4 = arrayList2;
        if (list4.isEmpty()) {
            obj2 = null;
        } else {
            obj2 = list4.get(0);
            int height4 = ((Placeable) obj2).getHeight();
            int lastIndex2 = CollectionsKt.getLastIndex(list4);
            if (1 <= lastIndex2) {
                Object obj8 = obj2;
                int i9 = height4;
                int i10 = 1;
                while (true) {
                    Object obj9 = list4.get(i10);
                    int height5 = ((Placeable) obj9).getHeight();
                    if (i9 < height5) {
                        obj8 = obj9;
                        i9 = height5;
                    }
                    if (i10 == lastIndex2) {
                        break;
                    }
                    i10++;
                }
                obj2 = obj8;
            }
        }
        Placeable placeable2 = (Placeable) obj2;
        int height6 = placeable2 != null ? placeable2.getHeight() : 0;
        if (list4.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = list4.get(0);
            int width = ((Placeable) obj3).getWidth();
            int lastIndex3 = CollectionsKt.getLastIndex(list4);
            if (1 <= lastIndex3) {
                Object obj10 = obj3;
                int i11 = width;
                int i12 = 1;
                while (true) {
                    Object obj11 = list4.get(i12);
                    int width2 = ((Placeable) obj11).getWidth();
                    if (i11 < width2) {
                        obj10 = obj11;
                        i11 = width2;
                    }
                    if (i12 == lastIndex3) {
                        break;
                    }
                    i12++;
                }
                obj3 = obj10;
            }
        }
        Placeable placeable3 = (Placeable) obj3;
        int width3 = placeable3 != null ? placeable3.getWidth() : 0;
        List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Fab, this.$fab);
        WindowInsets windowInsets2 = this.$contentWindowInsets;
        ArrayList arrayList3 = new ArrayList(subcompose3.size());
        int size3 = subcompose3.size();
        int i13 = 0;
        while (i13 < size3) {
            int i14 = height6;
            Density density2 = subcomposeMeasureScope2;
            List<Measurable> list5 = subcompose3;
            ArrayList arrayList4 = arrayList3;
            Placeable r1 = subcompose3.get(i13).m5848measureBRTryo0(ConstraintsKt.m7071offsetNN6EwU(r12, (-windowInsets2.getLeft(density2, subcomposeMeasureScope2.getLayoutDirection())) - windowInsets2.getRight(density2, subcomposeMeasureScope2.getLayoutDirection()), -windowInsets2.getBottom(density2)));
            if (r1.getHeight() == 0 || r1.getWidth() == 0) {
                r1 = null;
            }
            if (r1 != null) {
                arrayList4.add(r1);
            }
            i13++;
            height6 = i14;
            subcompose3 = list5;
            arrayList3 = arrayList4;
        }
        int i15 = height6;
        List list6 = arrayList3;
        if (!list6.isEmpty()) {
            if (list6.isEmpty()) {
                obj5 = null;
            } else {
                obj5 = list6.get(0);
                int width4 = ((Placeable) obj5).getWidth();
                int lastIndex4 = CollectionsKt.getLastIndex(list6);
                if (1 <= lastIndex4) {
                    Object obj12 = obj5;
                    int i16 = width4;
                    int i17 = 1;
                    while (true) {
                        Object obj13 = list6.get(i17);
                        int width5 = ((Placeable) obj13).getWidth();
                        if (i16 < width5) {
                            obj12 = obj13;
                            i16 = width5;
                        }
                        if (i17 == lastIndex4) {
                            break;
                        }
                        i17++;
                    }
                    obj5 = obj12;
                }
            }
            Intrinsics.checkNotNull(obj5);
            int width6 = ((Placeable) obj5).getWidth();
            if (list6.isEmpty()) {
                list = list6;
                obj6 = null;
            } else {
                obj6 = list6.get(0);
                int height7 = ((Placeable) obj6).getHeight();
                int lastIndex5 = CollectionsKt.getLastIndex(list6);
                if (1 <= lastIndex5) {
                    Object obj14 = obj6;
                    int i18 = height7;
                    int i19 = 1;
                    while (true) {
                        Object obj15 = list6.get(i19);
                        list = list6;
                        int height8 = ((Placeable) obj15).getHeight();
                        if (i18 < height8) {
                            i18 = height8;
                            obj14 = obj15;
                        }
                        if (i19 == lastIndex5) {
                            break;
                        }
                        i19++;
                        list6 = list;
                    }
                    obj6 = obj14;
                } else {
                    list = list6;
                }
            }
            Intrinsics.checkNotNull(obj6);
            int height9 = ((Placeable) obj6).getHeight();
            int i20 = this.$fabPosition;
            if (!FabPosition.m2074equalsimpl0(i20, FabPosition.Companion.m2081getStartERTFSPs())) {
                if (FabPosition.m2074equalsimpl0(i20, FabPosition.Companion.m2079getEndERTFSPs())) {
                    z = true;
                } else {
                    z = FabPosition.m2074equalsimpl0(i20, FabPosition.Companion.m2080getEndOverlayERTFSPs());
                }
                if (!z) {
                    i4 = (r9 - width6) / 2;
                } else if (subcomposeMeasureScope2.getLayoutDirection() == LayoutDirection.Ltr) {
                    r4 = subcomposeMeasureScope2.m7086roundToPx0680j_4(ScaffoldKt.FabSpacing);
                } else {
                    i4 = subcomposeMeasureScope2.m7086roundToPx0680j_4(ScaffoldKt.FabSpacing);
                }
                fabPlacement = new FabPlacement(i4, width6, height9);
            } else if (subcomposeMeasureScope2.getLayoutDirection() == LayoutDirection.Ltr) {
                i4 = subcomposeMeasureScope2.m7086roundToPx0680j_4(ScaffoldKt.FabSpacing);
                fabPlacement = new FabPlacement(i4, width6, height9);
            } else {
                r4 = subcomposeMeasureScope2.m7086roundToPx0680j_4(ScaffoldKt.FabSpacing);
            }
            i4 = (r9 - r4) - width6;
            fabPlacement = new FabPlacement(i4, width6, height9);
        } else {
            list = list6;
            fabPlacement = null;
        }
        List<Measurable> subcompose4 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(-2146438447, true, new ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1(this.$bottomBar)));
        ArrayList arrayList5 = new ArrayList(subcompose4.size());
        int size4 = subcompose4.size();
        for (int i21 = 0; i21 < size4; i21++) {
            arrayList5.add(subcompose4.get(i21).m5848measureBRTryo0(r12));
        }
        List list7 = arrayList5;
        if (list7.isEmpty()) {
            obj4 = null;
        } else {
            obj4 = list7.get(0);
            int height10 = ((Placeable) obj4).getHeight();
            int lastIndex6 = CollectionsKt.getLastIndex(list7);
            if (1 <= lastIndex6) {
                int i22 = 1;
                while (true) {
                    Object obj16 = list7.get(i22);
                    int height11 = ((Placeable) obj16).getHeight();
                    if (height10 < height11) {
                        height10 = height11;
                        obj4 = obj16;
                    }
                    if (i22 == lastIndex6) {
                        break;
                    }
                    i22++;
                }
            }
        }
        Placeable placeable4 = (Placeable) obj4;
        Integer valueOf = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
        if (fabPlacement != null) {
            int i23 = this.$fabPosition;
            WindowInsets windowInsets3 = this.$contentWindowInsets;
            if (valueOf == null || FabPosition.m2074equalsimpl0(i23, FabPosition.Companion.m2080getEndOverlayERTFSPs())) {
                i3 = fabPlacement.getHeight() + subcomposeMeasureScope2.m7086roundToPx0680j_4(ScaffoldKt.FabSpacing);
                i2 = windowInsets3.getBottom(subcomposeMeasureScope2);
            } else {
                i3 = valueOf.intValue() + fabPlacement.getHeight();
                i2 = subcomposeMeasureScope2.m7086roundToPx0680j_4(ScaffoldKt.FabSpacing);
            }
            num = Integer.valueOf(i3 + i2);
        } else {
            num = null;
        }
        if (i15 != 0) {
            i = i15 + (num != null ? num.intValue() : valueOf != null ? valueOf.intValue() : this.$contentWindowInsets.getBottom(subcomposeMeasureScope2));
        } else {
            i = 0;
        }
        List list8 = list7;
        int i24 = i8;
        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.MainContent;
        ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1 scaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1 = new ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1(this.$contentWindowInsets, subcomposeMeasureScope2, list3, i24, list8, valueOf, this.$content);
        final List list9 = list8;
        List<Measurable> subcompose5 = subcomposeMeasureScope2.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-1213360416, true, scaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1));
        ArrayList arrayList6 = new ArrayList(subcompose5.size());
        int size5 = subcompose5.size();
        for (int i25 = 0; i25 < size5; i25++) {
            arrayList6.add(subcompose5.get(i25).m5848measureBRTryo0(r12));
        }
        final List list10 = arrayList6;
        final Integer num2 = valueOf;
        final int i26 = r9;
        final WindowInsets windowInsets4 = this.$contentWindowInsets;
        final SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope2;
        final List list11 = list4;
        final int i27 = width3;
        final Integer num3 = num;
        final int i28 = i;
        final List list12 = list3;
        final FabPlacement fabPlacement2 = fabPlacement;
        final List list13 = list;
        return MeasureScope.layout$default(subcomposeMeasureScope2, i26, r11, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                List<Placeable> list = list10;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Placeable.PlacementScope.place$default(placementScope, list.get(i), 0, 0, 0.0f, 4, (Object) null);
                }
                List<Placeable> list2 = list12;
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Placeable.PlacementScope.place$default(placementScope, list2.get(i2), 0, 0, 0.0f, 4, (Object) null);
                }
                List<Placeable> list3 = list11;
                int i3 = i26;
                int i4 = i27;
                WindowInsets windowInsets = windowInsets4;
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope3;
                int i5 = r11;
                int i6 = i28;
                int size3 = list3.size();
                for (int i7 = 0; i7 < size3; i7++) {
                    Placeable.PlacementScope.place$default(placementScope, list3.get(i7), ((i3 - i4) / 2) + windowInsets.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), i5 - i6, 0.0f, 4, (Object) null);
                }
                List<Placeable> list4 = list9;
                int i8 = r11;
                Integer num = num2;
                int size4 = list4.size();
                for (int i9 = 0; i9 < size4; i9++) {
                    Placeable.PlacementScope.place$default(placementScope, list4.get(i9), 0, i8 - (num != null ? num.intValue() : 0), 0.0f, 4, (Object) null);
                }
                FabPlacement fabPlacement = fabPlacement2;
                if (fabPlacement != null) {
                    List<Placeable> list5 = list13;
                    int i10 = r11;
                    Integer num2 = num3;
                    int size5 = list5.size();
                    for (int i11 = 0; i11 < size5; i11++) {
                        int left = fabPlacement.getLeft();
                        Intrinsics.checkNotNull(num2);
                        Placeable.PlacementScope.place$default(placementScope, list5.get(i11), left, i10 - num2.intValue(), 0.0f, 4, (Object) null);
                    }
                }
            }
        }, 4, (Object) null);
    }
}
