package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCoreModifier.kt */
final class TextFieldCoreModifierNode$measureHorizontalScroll$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measureHorizontalScroll;
    final /* synthetic */ int $width;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldCoreModifierNode$measureHorizontalScroll$1(TextFieldCoreModifierNode textFieldCoreModifierNode, MeasureScope measureScope, int i, Placeable placeable) {
        super(1);
        this.this$0 = textFieldCoreModifierNode;
        this.$this_measureHorizontalScroll = measureScope;
        this.$width = i;
        this.$placeable = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        this.this$0.m1406updateScrollStatetIlFzwE(this.$this_measureHorizontalScroll, this.$width, this.$placeable.getWidth(), this.this$0.textFieldState.getVisualText().m1312getSelectiond9O1mEE(), this.$this_measureHorizontalScroll.getLayoutDirection());
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$placeable, -this.this$0.scrollState.getValue(), 0, 0.0f, 4, (Object) null);
    }
}
