package androidx.compose.animation;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SkipToLookaheadNode$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ long $constrainedSize;
    final /* synthetic */ long $contentSize;
    final /* synthetic */ Placeable $p;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ SkipToLookaheadNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SkipToLookaheadNode$measure$1(SkipToLookaheadNode skipToLookaheadNode, Placeable placeable, long j, long j2, MeasureScope measureScope) {
        super(1);
        this.this$0 = skipToLookaheadNode;
        this.$p = placeable;
        this.$contentSize = j;
        this.$constrainedSize = j2;
        this.$this_measure = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        final long j;
        ScaleToBoundsImpl scaleToBounds = this.this$0.getScaleToBounds();
        if (!this.this$0.isEnabled().invoke().booleanValue() || scaleToBounds == null) {
            Placeable.PlacementScope.place$default(placementScope, this.$p, 0, 0, 0.0f, 4, (Object) null);
            return;
        }
        ContentScale contentScale = scaleToBounds.getContentScale();
        if (IntSize.m7283getWidthimpl(this.$contentSize) == 0 || IntSize.m7282getHeightimpl(this.$contentSize) == 0) {
            j = ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
        } else {
            j = contentScale.m5764computeScaleFactorH7hwNQA(IntSizeKt.m7295toSizeozmzZPI(this.$contentSize), IntSizeKt.m7295toSizeozmzZPI(this.$constrainedSize));
        }
        long r4 = scaleToBounds.getAlignment().m3819alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(((float) IntSize.m7283getWidthimpl(this.$contentSize)) * ScaleFactor.m5916getScaleXimpl(j)), MathKt.roundToInt(((float) IntSize.m7282getHeightimpl(this.$contentSize)) * ScaleFactor.m5917getScaleYimpl(j))), this.$constrainedSize, this.$this_measure.getLayoutDirection());
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeWithLayer$default(placementScope2, this.$p, IntOffset.m7241getXimpl(r4), IntOffset.m7242getYimpl(r4), 0.0f, (Function1) new Function1<GraphicsLayerScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                graphicsLayerScope.setScaleX(ScaleFactor.m5916getScaleXimpl(j));
                graphicsLayerScope.setScaleY(ScaleFactor.m5917getScaleYimpl(j));
                graphicsLayerScope.m4433setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.0f, 0.0f));
            }
        }, 4, (Object) null);
    }
}
