package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010k\u001a\u00020lJ\r\u0010m\u001a\u00020lH\u0000¢\u0006\u0002\bnR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0014\u0010#\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0007R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR(\u00107\u001a\u0004\u0018\u0001062\b\u00105\u001a\u0004\u0018\u000106@AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R(\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u0003\u001a\u0004\u0018\u00010<@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\tR$\u0010E\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\tR$\u0010H\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\tR$\u0010K\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\tR$\u0010N\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0007\"\u0004\bP\u0010\tR$\u0010Q\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0007\"\u0004\bS\u0010\tR$\u0010U\u001a\u00020T2\u0006\u0010\u0003\u001a\u00020T@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010Z\u001a\u00020[X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\\\u0010\r\"\u0004\b]\u0010\u000fR,\u0010^\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b_\u0010\r\"\u0004\b`\u0010\u000fR,\u0010b\u001a\u00020a2\u0006\u0010\u0003\u001a\u00020a@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bc\u0010\r\"\u0004\bd\u0010\u000fR$\u0010e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0007\"\u0004\bg\u0010\tR$\u0010h\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0007\"\u0004\bj\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006o"}, d2 = {"Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "()V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "I", "density", "getDensity", "fontScale", "getFontScale", "graphicsDensity", "Landroidx/compose/ui/unit/Density;", "getGraphicsDensity$ui_release", "()Landroidx/compose/ui/unit/Density;", "setGraphicsDensity$ui_release", "(Landroidx/compose/ui/unit/Density;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection$ui_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection$ui_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "mutatedFields", "", "getMutatedFields$ui_release", "setMutatedFields$ui_release", "<set-?>", "Landroidx/compose/ui/graphics/Outline;", "outline", "getOutline$ui_release", "()Landroidx/compose/ui/graphics/Outline;", "setOutline$ui_release", "(Landroidx/compose/ui/graphics/Outline;)V", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Shape;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "setSize-uvyYCjk", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "reset", "", "updateOutline", "updateOutline$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsLayerScope.kt */
public final class ReusableGraphicsLayerScope implements GraphicsLayerScope {
    public static final int $stable = 0;
    private float alpha = 1.0f;
    private long ambientShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
    private float cameraDistance = 8.0f;
    private boolean clip;
    private int compositingStrategy = CompositingStrategy.Companion.m4329getAutoNrFUSI();
    private Density graphicsDensity = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private int mutatedFields;
    private Outline outline;
    private RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float shadowElevation;
    private Shape shape = RectangleShapeKt.getRectangleShape();
    private long size = Size.Companion.m4064getUnspecifiedNHjbRc();
    private long spotShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
    private long transformOrigin = TransformOrigin.Companion.m4673getCenterSzJe1aQ();
    private float translationX;
    private float translationY;

    public final int getMutatedFields$ui_release() {
        return this.mutatedFields;
    }

    public final void setMutatedFields$ui_release(int i) {
        this.mutatedFields = i;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float f) {
        if (this.scaleX != f) {
            this.mutatedFields |= 1;
            this.scaleX = f;
        }
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float f) {
        if (this.scaleY != f) {
            this.mutatedFields |= 2;
            this.scaleY = f;
        }
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(float f) {
        if (this.alpha != f) {
            this.mutatedFields |= 4;
            this.alpha = f;
        }
    }

    public float getTranslationX() {
        return this.translationX;
    }

    public void setTranslationX(float f) {
        if (this.translationX != f) {
            this.mutatedFields |= 8;
            this.translationX = f;
        }
    }

    public float getTranslationY() {
        return this.translationY;
    }

    public void setTranslationY(float f) {
        if (this.translationY != f) {
            this.mutatedFields |= 16;
            this.translationY = f;
        }
    }

    public float getShadowElevation() {
        return this.shadowElevation;
    }

    public void setShadowElevation(float f) {
        if (this.shadowElevation != f) {
            this.mutatedFields |= 32;
            this.shadowElevation = f;
        }
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    public long m4579getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
    public void m4584setAmbientShadowColor8_81llA(long j) {
        if (!Color.m4240equalsimpl0(this.ambientShadowColor, j)) {
            this.mutatedFields |= 64;
            this.ambientShadowColor = j;
        }
    }

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    public long m4582getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
    public void m4587setSpotShadowColor8_81llA(long j) {
        if (!Color.m4240equalsimpl0(this.spotShadowColor, j)) {
            this.mutatedFields |= 128;
            this.spotShadowColor = j;
        }
    }

    public float getRotationX() {
        return this.rotationX;
    }

    public void setRotationX(float f) {
        if (this.rotationX != f) {
            this.mutatedFields |= 256;
            this.rotationX = f;
        }
    }

    public float getRotationY() {
        return this.rotationY;
    }

    public void setRotationY(float f) {
        if (this.rotationY != f) {
            this.mutatedFields |= 512;
            this.rotationY = f;
        }
    }

    public float getRotationZ() {
        return this.rotationZ;
    }

    public void setRotationZ(float f) {
        if (this.rotationZ != f) {
            this.mutatedFields |= 1024;
            this.rotationZ = f;
        }
    }

    public float getCameraDistance() {
        return this.cameraDistance;
    }

    public void setCameraDistance(float f) {
        if (this.cameraDistance != f) {
            this.mutatedFields |= 2048;
            this.cameraDistance = f;
        }
    }

    /* renamed from: getTransformOrigin-SzJe1aQ  reason: not valid java name */
    public long m4583getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    /* renamed from: setTransformOrigin-__ExYCQ  reason: not valid java name */
    public void m4588setTransformOrigin__ExYCQ(long j) {
        if (!TransformOrigin.m4667equalsimpl0(this.transformOrigin, j)) {
            this.mutatedFields |= 4096;
            this.transformOrigin = j;
        }
    }

    public Shape getShape() {
        return this.shape;
    }

    public void setShape(Shape shape2) {
        if (!Intrinsics.areEqual((Object) this.shape, (Object) shape2)) {
            this.mutatedFields |= 8192;
            this.shape = shape2;
        }
    }

    public boolean getClip() {
        return this.clip;
    }

    public void setClip(boolean z) {
        if (this.clip != z) {
            this.mutatedFields |= 16384;
            this.clip = z;
        }
    }

    /* renamed from: getCompositingStrategy--NrFUSI  reason: not valid java name */
    public int m4580getCompositingStrategyNrFUSI() {
        return this.compositingStrategy;
    }

    /* renamed from: setCompositingStrategy-aDBOjCE  reason: not valid java name */
    public void m4585setCompositingStrategyaDBOjCE(int i) {
        if (!CompositingStrategy.m4325equalsimpl0(this.compositingStrategy, i)) {
            this.mutatedFields |= 32768;
            this.compositingStrategy = i;
        }
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m4581getSizeNHjbRc() {
        return this.size;
    }

    /* renamed from: setSize-uvyYCjk  reason: not valid java name */
    public void m4586setSizeuvyYCjk(long j) {
        this.size = j;
    }

    public final Density getGraphicsDensity$ui_release() {
        return this.graphicsDensity;
    }

    public final void setGraphicsDensity$ui_release(Density density) {
        this.graphicsDensity = density;
    }

    public final LayoutDirection getLayoutDirection$ui_release() {
        return this.layoutDirection;
    }

    public final void setLayoutDirection$ui_release(LayoutDirection layoutDirection2) {
        this.layoutDirection = layoutDirection2;
    }

    public float getDensity() {
        return this.graphicsDensity.getDensity();
    }

    public float getFontScale() {
        return this.graphicsDensity.getFontScale();
    }

    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public void setRenderEffect(RenderEffect renderEffect2) {
        if (!Intrinsics.areEqual((Object) this.renderEffect, (Object) renderEffect2)) {
            this.mutatedFields |= 131072;
            this.renderEffect = renderEffect2;
        }
    }

    public final Outline getOutline$ui_release() {
        return this.outline;
    }

    public final void setOutline$ui_release(Outline outline2) {
        this.outline = outline2;
    }

    public final void reset() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        setAlpha(1.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        setShadowElevation(0.0f);
        m4584setAmbientShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        m4587setSpotShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        setRotationX(0.0f);
        setRotationY(0.0f);
        setRotationZ(0.0f);
        setCameraDistance(8.0f);
        m4588setTransformOrigin__ExYCQ(TransformOrigin.Companion.m4673getCenterSzJe1aQ());
        setShape(RectangleShapeKt.getRectangleShape());
        setClip(false);
        setRenderEffect((RenderEffect) null);
        m4585setCompositingStrategyaDBOjCE(CompositingStrategy.Companion.m4329getAutoNrFUSI());
        m4586setSizeuvyYCjk(Size.Companion.m4064getUnspecifiedNHjbRc());
        this.outline = null;
        this.mutatedFields = 0;
    }

    public final void updateOutline$ui_release() {
        this.outline = getShape().m4605createOutlinePq9zytI(m4581getSizeNHjbRc(), this.layoutDirection, this.graphicsDensity);
    }
}
