package androidx.compose.material3;

import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroidx/compose/material3/internal/DraggableAnchors;", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "size", "Landroidx/compose/ui/unit/IntSize;", "<anonymous parameter 1>", "Landroidx/compose/ui/unit/Constraints;", "invoke-GpV2Q24", "(JJ)Lkotlin/Pair;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
final class SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1 extends Lambda implements Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue>> {
    final /* synthetic */ boolean $enableDismissFromEndToStart;
    final /* synthetic */ boolean $enableDismissFromStartToEnd;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ SwipeToDismissBoxState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1(SwipeToDismissBoxState swipeToDismissBoxState, boolean z, boolean z2, boolean z3) {
        super(2);
        this.$state = swipeToDismissBoxState;
        this.$enableDismissFromStartToEnd = z;
        this.$isRtl = z2;
        this.$enableDismissFromEndToStart = z3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m2545invokeGpV2Q24(((IntSize) obj).m7287unboximpl(), ((Constraints) obj2).m7058unboximpl());
    }

    /* renamed from: invoke-GpV2Q24  reason: not valid java name */
    public final Pair<DraggableAnchors<SwipeToDismissBoxValue>, SwipeToDismissBoxValue> m2545invokeGpV2Q24(long j, long j2) {
        final float r2 = (float) IntSize.m7283getWidthimpl(j);
        final boolean z = this.$enableDismissFromStartToEnd;
        final boolean z2 = this.$isRtl;
        final boolean z3 = this.$enableDismissFromEndToStart;
        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DraggableAnchorsConfig<SwipeToDismissBoxValue>) (DraggableAnchorsConfig) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                draggableAnchorsConfig.at(SwipeToDismissBoxValue.Settled, 0.0f);
                if (z) {
                    draggableAnchorsConfig.at(SwipeToDismissBoxValue.StartToEnd, z2 ? -r2 : r2);
                }
                if (z3) {
                    draggableAnchorsConfig.at(SwipeToDismissBoxValue.EndToStart, z2 ? r2 : -r2);
                }
            }
        }), this.$state.getTargetValue());
    }
}
