package androidx.compose.material3;

import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroidx/compose/material3/internal/DraggableAnchors;", "Landroidx/compose/material3/SheetValue;", "sheetSize", "Landroidx/compose/ui/unit/IntSize;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-GpV2Q24", "(JJ)Lkotlin/Pair;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$StandardBottomSheet$1$1 extends Lambda implements Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SheetValue>, ? extends SheetValue>> {
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ SheetState $state;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BottomSheetScaffold.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.material3.SheetValue[] r0 = androidx.compose.material3.SheetValue.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Hidden     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.PartiallyExpanded     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Expanded     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$StandardBottomSheet$1$1(SheetState sheetState, float f) {
        super(2);
        this.$state = sheetState;
        this.$peekHeightPx = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1752invokeGpV2Q24(((IntSize) obj).m7287unboximpl(), ((Constraints) obj2).m7058unboximpl());
    }

    /* renamed from: invoke-GpV2Q24  reason: not valid java name */
    public final Pair<DraggableAnchors<SheetValue>, SheetValue> m1752invokeGpV2Q24(long j, long j2) {
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new BottomSheetScaffoldKt$StandardBottomSheet$1$1$newAnchors$1(this.$state, (float) Constraints.m7051getMaxHeightimpl(j2), this.$peekHeightPx, (float) IntSize.m7282getHeightimpl(j)));
        SheetValue targetValue = this.$state.getAnchoredDraggableState$material3_release().getTargetValue();
        int i = WhenMappings.$EnumSwitchMapping$0[targetValue.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                } else if (DraggableAnchors.hasAnchorFor(SheetValue.Expanded)) {
                    targetValue = SheetValue.Expanded;
                } else if (DraggableAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
                    targetValue = SheetValue.PartiallyExpanded;
                } else if (DraggableAnchors.hasAnchorFor(SheetValue.Hidden)) {
                    targetValue = SheetValue.Hidden;
                }
            } else if (DraggableAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
                targetValue = SheetValue.PartiallyExpanded;
            } else if (DraggableAnchors.hasAnchorFor(SheetValue.Expanded)) {
                targetValue = SheetValue.Expanded;
            } else if (DraggableAnchors.hasAnchorFor(SheetValue.Hidden)) {
                targetValue = SheetValue.Hidden;
            }
        } else if (DraggableAnchors.hasAnchorFor(SheetValue.Hidden)) {
            targetValue = SheetValue.Hidden;
        }
        return TuplesKt.to(DraggableAnchors, targetValue);
    }
}
