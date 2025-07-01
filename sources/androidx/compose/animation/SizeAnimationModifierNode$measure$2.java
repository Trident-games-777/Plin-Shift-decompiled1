package androidx.compose.animation;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationModifier.kt */
final class SizeAnimationModifierNode$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $height;
    final /* synthetic */ long $measuredSize;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ int $width;
    final /* synthetic */ SizeAnimationModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SizeAnimationModifierNode$measure$2(SizeAnimationModifierNode sizeAnimationModifierNode, long j, int i, int i2, MeasureScope measureScope, Placeable placeable) {
        super(1);
        this.this$0 = sizeAnimationModifierNode;
        this.$measuredSize = j;
        this.$width = i;
        this.$height = i2;
        this.$this_measure = measureScope;
        this.$placeable = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.m5891placeRelative70tqf50$default(placementScope2, this.$placeable, this.this$0.getAlignment().m3819alignKFBX0sM(this.$measuredSize, IntSizeKt.IntSize(this.$width, this.$height), this.$this_measure.getLayoutDirection()), 0.0f, 2, (Object) null);
    }
}
