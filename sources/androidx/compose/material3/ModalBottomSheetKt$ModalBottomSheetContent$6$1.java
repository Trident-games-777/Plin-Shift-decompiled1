package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$ModalBottomSheetContent$6$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    final /* synthetic */ SheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$ModalBottomSheetContent$6$1(SheetState sheetState, Animatable<Float, AnimationVector1D> animatable) {
        super(1);
        this.$sheetState = sheetState;
        this.$predictiveBackProgress = animatable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        float offset = this.$sheetState.getAnchoredDraggableState$material3_release().getOffset();
        float r1 = Size.m4053getHeightimpl(graphicsLayerScope.m4427getSizeNHjbRc());
        if (!Float.isNaN(offset) && !Float.isNaN(r1) && r1 != 0.0f) {
            float floatValue = this.$predictiveBackProgress.getValue().floatValue();
            graphicsLayerScope.setScaleX(ModalBottomSheetKt.calculatePredictiveBackScaleX(graphicsLayerScope, floatValue));
            graphicsLayerScope.setScaleY(ModalBottomSheetKt.calculatePredictiveBackScaleY(graphicsLayerScope, floatValue));
            graphicsLayerScope.m4433setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, (offset + r1) / r1));
        }
    }
}
