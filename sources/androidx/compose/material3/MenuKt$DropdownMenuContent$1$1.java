package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
final class MenuKt$DropdownMenuContent$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ State<Float> $alpha$delegate;
    final /* synthetic */ MutableTransitionState<Boolean> $expandedState;
    final /* synthetic */ boolean $isInspecting;
    final /* synthetic */ State<Float> $scale$delegate;
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MenuKt$DropdownMenuContent$1$1(boolean z, MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, State<Float> state, State<Float> state2) {
        super(1);
        this.$isInspecting = z;
        this.$expandedState = mutableTransitionState;
        this.$transformOriginState = mutableState;
        this.$scale$delegate = state;
        this.$alpha$delegate = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        float f;
        float f2 = 0.8f;
        float f3 = 1.0f;
        if (!this.$isInspecting) {
            f = MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$1(this.$scale$delegate);
        } else {
            f = this.$expandedState.getTargetState().booleanValue() ? 1.0f : 0.8f;
        }
        graphicsLayerScope.setScaleX(f);
        if (!this.$isInspecting) {
            f2 = MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$1(this.$scale$delegate);
        } else if (this.$expandedState.getTargetState().booleanValue()) {
            f2 = 1.0f;
        }
        graphicsLayerScope.setScaleY(f2);
        if (!this.$isInspecting) {
            f3 = MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$3(this.$alpha$delegate);
        } else if (!this.$expandedState.getTargetState().booleanValue()) {
            f3 = 0.0f;
        }
        graphicsLayerScope.setAlpha(f3);
        graphicsLayerScope.m4433setTransformOrigin__ExYCQ(this.$transformOriginState.getValue().m4672unboximpl());
    }
}
