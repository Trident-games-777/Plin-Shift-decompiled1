package androidx.compose.material3;

import androidx.compose.material3.internal.DraggableAnchorsConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/internal/DraggableAnchorsConfig;", "Landroidx/compose/material3/SheetValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$StandardBottomSheet$1$1$newAnchors$1 extends Lambda implements Function1<DraggableAnchorsConfig<SheetValue>, Unit> {
    final /* synthetic */ float $layoutHeight;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ float $sheetHeight;
    final /* synthetic */ SheetState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$StandardBottomSheet$1$1$newAnchors$1(SheetState sheetState, float f, float f2, float f3) {
        super(1);
        this.$state = sheetState;
        this.$layoutHeight = f;
        this.$peekHeightPx = f2;
        this.$sheetHeight = f3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DraggableAnchorsConfig<SheetValue>) (DraggableAnchorsConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
        if (!this.$state.getSkipPartiallyExpanded$material3_release()) {
            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, this.$layoutHeight - this.$peekHeightPx);
        }
        if (this.$sheetHeight != this.$peekHeightPx) {
            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(this.$layoutHeight - this.$sheetHeight, 0.0f));
        }
        if (!this.$state.getSkipHiddenState$material3_release()) {
            draggableAnchorsConfig.at(SheetValue.Hidden, this.$layoutHeight);
        }
    }
}
