package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$ModalBottomSheetContent$7$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$ModalBottomSheetContent$7$1$1(Animatable<Float, AnimationVector1D> animatable) {
        super(1);
        this.$predictiveBackProgress = animatable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        float floatValue = this.$predictiveBackProgress.getValue().floatValue();
        float access$calculatePredictiveBackScaleX = ModalBottomSheetKt.calculatePredictiveBackScaleX(graphicsLayerScope, floatValue);
        float access$calculatePredictiveBackScaleY = ModalBottomSheetKt.calculatePredictiveBackScaleY(graphicsLayerScope, floatValue);
        graphicsLayerScope.setScaleY(access$calculatePredictiveBackScaleY == 0.0f ? 1.0f : access$calculatePredictiveBackScaleX / access$calculatePredictiveBackScaleY);
        graphicsLayerScope.m4433setTransformOrigin__ExYCQ(ModalBottomSheetKt.PredictiveBackChildTransformOrigin);
    }
}
