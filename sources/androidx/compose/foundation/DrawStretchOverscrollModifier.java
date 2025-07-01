package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001c\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001c\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001c\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J$\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\f\u0010%\u001a\u00020\n*\u00020&H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006'"}, d2 = {"Landroidx/compose/foundation/DrawStretchOverscrollModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;Lkotlin/jvm/functions/Function1;)V", "_renderNode", "Landroid/graphics/RenderNode;", "renderNode", "getRenderNode", "()Landroid/graphics/RenderNode;", "drawBottomStretch", "", "bottom", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeftStretch", "left", "drawRightStretch", "right", "drawTopStretch", "top", "drawWithRotation", "rotationDegrees", "", "edgeEffect", "shouldDrawHorizontalStretch", "shouldDrawVerticalStretch", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidOverscroll.android.kt */
final class DrawStretchOverscrollModifier extends InspectorValueInfo implements DrawModifier {
    private RenderNode _renderNode;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public DrawStretchOverscrollModifier(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper2, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper2;
    }

    private final RenderNode getRenderNode() {
        RenderNode renderNode = this._renderNode;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNode2 = new RenderNode("AndroidEdgeEffectOverscrollEffect");
        this._renderNode = renderNode2;
        return renderNode2;
    }

    public void draw(ContentDrawScope contentDrawScope) {
        boolean z;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        this.overscrollEffect.m232updateSizeuvyYCjk$foundation_release(contentDrawScope2.m4865getSizeNHjbRc());
        if (Size.m4058isEmptyimpl(contentDrawScope2.m4865getSizeNHjbRc())) {
            contentDrawScope2.drawContent();
            return;
        }
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        float r2 = contentDrawScope2.m7091toPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope2.getDrawContext().getCanvas());
        EdgeEffectWrapper edgeEffectWrapper2 = this.edgeEffectWrapper;
        boolean shouldDrawVerticalStretch = shouldDrawVerticalStretch();
        boolean shouldDrawHorizontalStretch = shouldDrawHorizontalStretch();
        boolean z2 = false;
        if (shouldDrawVerticalStretch && shouldDrawHorizontalStretch) {
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight());
        } else if (shouldDrawVerticalStretch) {
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth() + (MathKt.roundToInt(r2) * 2), nativeCanvas.getHeight());
        } else if (shouldDrawHorizontalStretch) {
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight() + (MathKt.roundToInt(r2) * 2));
        } else {
            contentDrawScope.drawContent();
            return;
        }
        RecordingCanvas beginRecording = getRenderNode().beginRecording();
        if (edgeEffectWrapper2.isLeftNegationStretched()) {
            EdgeEffect orCreateLeftEffectNegation = edgeEffectWrapper2.getOrCreateLeftEffectNegation();
            drawRightStretch(orCreateLeftEffectNegation, beginRecording);
            orCreateLeftEffectNegation.finish();
        }
        if (edgeEffectWrapper2.isLeftAnimating()) {
            EdgeEffect orCreateLeftEffect = edgeEffectWrapper2.getOrCreateLeftEffect();
            z = drawLeftStretch(orCreateLeftEffect, beginRecording);
            if (edgeEffectWrapper2.isLeftStretched()) {
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper2.getOrCreateLeftEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateLeftEffect), ((float) 1) - Offset.m3988getYimpl(this.overscrollEffect.m231displacementF1C5BW0$foundation_release()));
            }
        } else {
            z = false;
        }
        if (edgeEffectWrapper2.isTopNegationStretched()) {
            EdgeEffect orCreateTopEffectNegation = edgeEffectWrapper2.getOrCreateTopEffectNegation();
            drawBottomStretch(orCreateTopEffectNegation, beginRecording);
            orCreateTopEffectNegation.finish();
        }
        if (edgeEffectWrapper2.isTopAnimating()) {
            EdgeEffect orCreateTopEffect = edgeEffectWrapper2.getOrCreateTopEffect();
            z = drawTopStretch(orCreateTopEffect, beginRecording) || z;
            if (edgeEffectWrapper2.isTopStretched()) {
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper2.getOrCreateTopEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect), Offset.m3987getXimpl(this.overscrollEffect.m231displacementF1C5BW0$foundation_release()));
            }
        }
        if (edgeEffectWrapper2.isRightNegationStretched()) {
            EdgeEffect orCreateRightEffectNegation = edgeEffectWrapper2.getOrCreateRightEffectNegation();
            drawLeftStretch(orCreateRightEffectNegation, beginRecording);
            orCreateRightEffectNegation.finish();
        }
        if (edgeEffectWrapper2.isRightAnimating()) {
            EdgeEffect orCreateRightEffect = edgeEffectWrapper2.getOrCreateRightEffect();
            z = drawRightStretch(orCreateRightEffect, beginRecording) || z;
            if (edgeEffectWrapper2.isRightStretched()) {
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper2.getOrCreateRightEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect), Offset.m3988getYimpl(this.overscrollEffect.m231displacementF1C5BW0$foundation_release()));
            }
        }
        if (edgeEffectWrapper2.isBottomNegationStretched()) {
            EdgeEffect orCreateBottomEffectNegation = edgeEffectWrapper2.getOrCreateBottomEffectNegation();
            drawTopStretch(orCreateBottomEffectNegation, beginRecording);
            orCreateBottomEffectNegation.finish();
        }
        if (edgeEffectWrapper2.isBottomAnimating()) {
            EdgeEffect orCreateBottomEffect = edgeEffectWrapper2.getOrCreateBottomEffect();
            if (drawBottomStretch(orCreateBottomEffect, beginRecording) || z) {
                z2 = true;
            }
            if (edgeEffectWrapper2.isBottomStretched()) {
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper2.getOrCreateBottomEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateBottomEffect), ((float) 1) - Offset.m3987getXimpl(this.overscrollEffect.m231displacementF1C5BW0$foundation_release()));
            }
            z = z2;
        }
        if (z) {
            this.overscrollEffect.invalidateOverscroll$foundation_release();
        }
        float f = shouldDrawHorizontalStretch ? 0.0f : r2;
        if (shouldDrawVerticalStretch) {
            r2 = 0.0f;
        }
        DrawScope drawScope = contentDrawScope2;
        LayoutDirection layoutDirection = contentDrawScope2.getLayoutDirection();
        androidx.compose.ui.graphics.Canvas Canvas = AndroidCanvas_androidKt.Canvas(beginRecording);
        long r8 = contentDrawScope2.m4865getSizeNHjbRc();
        Density density = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvas = drawScope.getDrawContext().getCanvas();
        long r13 = drawScope.getDrawContext().m4806getSizeNHjbRc();
        GraphicsLayer graphicsLayer = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(contentDrawScope);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(Canvas);
        drawContext.m4807setSizeuvyYCjk(r8);
        drawContext.setGraphicsLayer((GraphicsLayer) null);
        Canvas.save();
        try {
            drawScope.getDrawContext().getTransform().translate(f, r2);
            contentDrawScope.drawContent();
            float f2 = -f;
            float f3 = -r2;
            drawScope.getDrawContext().getTransform().translate(f2, f3);
            Canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas);
            drawContext2.m4807setSizeuvyYCjk(r13);
            drawContext2.setGraphicsLayer(graphicsLayer);
            getRenderNode().endRecording();
            int save = nativeCanvas.save();
            nativeCanvas.translate(f2, f3);
            nativeCanvas.drawRenderNode(getRenderNode());
            nativeCanvas.restoreToCount(save);
        } catch (Throwable th) {
            Canvas.restore();
            DrawContext drawContext3 = drawScope.getDrawContext();
            drawContext3.setDensity(density);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas);
            drawContext3.m4807setSizeuvyYCjk(r13);
            drawContext3.setGraphicsLayer(graphicsLayer);
            throw th;
        }
    }

    private final boolean shouldDrawVerticalStretch() {
        EdgeEffectWrapper edgeEffectWrapper2 = this.edgeEffectWrapper;
        return edgeEffectWrapper2.isTopAnimating() || edgeEffectWrapper2.isTopNegationStretched() || edgeEffectWrapper2.isBottomAnimating() || edgeEffectWrapper2.isBottomNegationStretched();
    }

    private final boolean shouldDrawHorizontalStretch() {
        EdgeEffectWrapper edgeEffectWrapper2 = this.edgeEffectWrapper;
        return edgeEffectWrapper2.isLeftAnimating() || edgeEffectWrapper2.isLeftNegationStretched() || edgeEffectWrapper2.isRightAnimating() || edgeEffectWrapper2.isRightNegationStretched();
    }

    private final boolean drawLeftStretch(EdgeEffect edgeEffect, Canvas canvas) {
        return drawWithRotation(270.0f, edgeEffect, canvas);
    }

    private final boolean drawTopStretch(EdgeEffect edgeEffect, Canvas canvas) {
        return drawWithRotation(0.0f, edgeEffect, canvas);
    }

    private final boolean drawRightStretch(EdgeEffect edgeEffect, Canvas canvas) {
        return drawWithRotation(90.0f, edgeEffect, canvas);
    }

    private final boolean drawBottomStretch(EdgeEffect edgeEffect, Canvas canvas) {
        return drawWithRotation(180.0f, edgeEffect, canvas);
    }

    private final boolean drawWithRotation(float f, EdgeEffect edgeEffect, Canvas canvas) {
        if (f == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int save = canvas.save();
        canvas.rotate(f);
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }
}
