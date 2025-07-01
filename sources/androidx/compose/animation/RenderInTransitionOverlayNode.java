package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\u0010\u0010J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0016J\f\u00101\u001a\u00020/*\u000202H\u0016R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00064"}, d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "sharedScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "renderInOverlay", "Lkotlin/Function0;", "", "zIndexInOverlay", "", "clipInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/animation/SharedTransitionScopeImpl;Lkotlin/jvm/functions/Function0;FLkotlin/jvm/functions/Function2;)V", "getClipInOverlay", "()Lkotlin/jvm/functions/Function2;", "setClipInOverlay", "(Lkotlin/jvm/functions/Function2;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layerWithRenderer", "Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "getRenderInOverlay", "()Lkotlin/jvm/functions/Function0;", "setRenderInOverlay", "(Lkotlin/jvm/functions/Function0;)V", "getSharedScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedScope", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "<set-?>", "getZIndexInOverlay", "()F", "setZIndexInOverlay", "(F)V", "zIndexInOverlay$delegate", "Landroidx/compose/runtime/MutableFloatState;", "onAttach", "", "onDetach", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "LayerWithRenderer", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RenderInTransitionOverlayNodeElement.kt */
public final class RenderInTransitionOverlayNode extends Modifier.Node implements DrawModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private Function2<? super LayoutDirection, ? super Density, ? extends Path> clipInOverlay;
    private LayerWithRenderer layerWithRenderer;
    private Function0<Boolean> renderInOverlay;
    private SharedTransitionScopeImpl sharedScope;
    private final MutableFloatState zIndexInOverlay$delegate;

    public final SharedTransitionScopeImpl getSharedScope() {
        return this.sharedScope;
    }

    public final void setSharedScope(SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.sharedScope = sharedTransitionScopeImpl;
    }

    public final Function0<Boolean> getRenderInOverlay() {
        return this.renderInOverlay;
    }

    public final void setRenderInOverlay(Function0<Boolean> function0) {
        this.renderInOverlay = function0;
    }

    public final Function2<LayoutDirection, Density, Path> getClipInOverlay() {
        return this.clipInOverlay;
    }

    public final void setClipInOverlay(Function2<? super LayoutDirection, ? super Density, ? extends Path> function2) {
        this.clipInOverlay = function2;
    }

    public RenderInTransitionOverlayNode(SharedTransitionScopeImpl sharedTransitionScopeImpl, Function0<Boolean> function0, float f, Function2<? super LayoutDirection, ? super Density, ? extends Path> function2) {
        this.sharedScope = sharedTransitionScopeImpl;
        this.renderInOverlay = function0;
        this.clipInOverlay = function2;
        this.zIndexInOverlay$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
    }

    public final float getZIndexInOverlay() {
        return this.zIndexInOverlay$delegate.getFloatValue();
    }

    public final void setZIndexInOverlay(float f) {
        this.zIndexInOverlay$delegate.setFloatValue(f);
    }

    public final SharedElementInternalState getParentState() {
        return (SharedElementInternalState) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState());
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "Landroidx/compose/animation/LayerRenderer;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/animation/RenderInTransitionOverlayNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "zIndex", "", "getZIndex", "()F", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RenderInTransitionOverlayNodeElement.kt */
    private final class LayerWithRenderer implements LayerRenderer {
        private final GraphicsLayer layer;

        public LayerWithRenderer(GraphicsLayer graphicsLayer) {
            this.layer = graphicsLayer;
        }

        public final GraphicsLayer getLayer() {
            return this.layer;
        }

        public SharedElementInternalState getParentState() {
            return RenderInTransitionOverlayNode.this.getParentState();
        }

        public float getZIndex() {
            return RenderInTransitionOverlayNode.this.getZIndexInOverlay();
        }

        public void drawInOverlay(DrawScope drawScope) {
            if (RenderInTransitionOverlayNode.this.getRenderInOverlay().invoke().booleanValue()) {
                RenderInTransitionOverlayNode renderInTransitionOverlayNode = RenderInTransitionOverlayNode.this;
                DelegatableNode delegatableNode = renderInTransitionOverlayNode;
                long r3 = renderInTransitionOverlayNode.getSharedScope().getRoot$animation_release().m5801localPositionOfR5De75A(DelegatableNodeKt.requireLayoutCoordinates(delegatableNode), Offset.Companion.m4003getZeroF1C5BW0());
                float r1 = Offset.m3987getXimpl(r3);
                float r32 = Offset.m3988getYimpl(r3);
                Path invoke = renderInTransitionOverlayNode.getClipInOverlay().invoke(drawScope.getLayoutDirection(), DelegatableNodeKt.requireDensity(delegatableNode));
                if (invoke != null) {
                    int r2 = ClipOp.Companion.m4228getIntersectrtfAjoo();
                    DrawContext drawContext = drawScope.getDrawContext();
                    long r5 = drawContext.m4806getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    try {
                        drawContext.getTransform().m4925clipPathmtrdDE(invoke, r2);
                        drawScope.getDrawContext().getTransform().translate(r1, r32);
                        GraphicsLayerKt.drawLayer(drawScope, this.layer);
                        drawScope.getDrawContext().getTransform().translate(-r1, -r32);
                        drawContext.getCanvas().restore();
                        drawContext.m4807setSizeuvyYCjk(r5);
                    } catch (Throwable th) {
                        drawContext.getCanvas().restore();
                        drawContext.m4807setSizeuvyYCjk(r5);
                        throw th;
                    }
                } else {
                    drawScope.getDrawContext().getTransform().translate(r1, r32);
                    try {
                        GraphicsLayerKt.drawLayer(drawScope, this.layer);
                    } finally {
                        drawScope.getDrawContext().getTransform().translate(-r1, -r32);
                    }
                }
            }
        }
    }

    public void draw(ContentDrawScope contentDrawScope) {
        GraphicsLayer layer = getLayer();
        if (layer != null) {
            DrawScope drawScope = contentDrawScope;
            DrawScope.m4844recordJVtK1S4$default(drawScope, layer, 0, new RenderInTransitionOverlayNode$draw$1(contentDrawScope), 1, (Object) null);
            if (!this.renderInOverlay.invoke().booleanValue()) {
                GraphicsLayerKt.drawLayer(drawScope, layer);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Error: layer never initialized".toString());
    }

    public final GraphicsLayer getLayer() {
        LayerWithRenderer layerWithRenderer2 = this.layerWithRenderer;
        if (layerWithRenderer2 != null) {
            return layerWithRenderer2.getLayer();
        }
        return null;
    }

    public void onAttach() {
        LayerWithRenderer layerWithRenderer2 = new LayerWithRenderer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.sharedScope.onLayerRendererCreated$animation_release(layerWithRenderer2);
        this.layerWithRenderer = layerWithRenderer2;
    }

    public void onDetach() {
        LayerWithRenderer layerWithRenderer2 = this.layerWithRenderer;
        if (layerWithRenderer2 != null) {
            this.sharedScope.onLayerRendererRemoved$animation_release(layerWithRenderer2);
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(layerWithRenderer2.getLayer());
        }
    }
}
