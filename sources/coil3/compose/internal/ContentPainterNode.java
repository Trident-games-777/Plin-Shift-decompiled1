package coil3.compose.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import coil3.compose.AsyncImagePainter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u001c\u00101\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00105\u001a\u000202H\u0016J\u001c\u00106\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00105\u001a\u000202H\u0016J\u001c\u00107\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00108\u001a\u000202H\u0016J\u001c\u00109\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00108\u001a\u000202H\u0016J\u0017\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002¢\u0006\u0004\b@\u0010>J\f\u0010A\u001a\u00020B*\u00020CH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006D"}, d2 = {"Lcoil3/compose/internal/ContentPainterNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ContentPainterModifier.kt */
public final class ContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter2) {
        this.painter = painter2;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment2) {
        this.alignment = alignment2;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale2) {
        this.contentScale = contentScale2;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter2) {
        this.colorFilter = colorFilter2;
    }

    public ContentPainterNode(Painter painter2, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2) {
        this.painter = painter2;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = f;
        this.colorFilter = colorFilter2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m7489measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable r9 = measurable.m5848measureBRTryo0(m7488modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new ContentPainterNode$$ExternalSyntheticLambda0(r9), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.m5044getIntrinsicSizeNHjbRc() == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        int i2 = i;
        long r0 = m7488modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i2, 7, (Object) null));
        return Math.max(Constraints.m7054getMinWidthimpl(r0), intrinsicMeasurable.minIntrinsicWidth(i2));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.m5044getIntrinsicSizeNHjbRc() == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        int i2 = i;
        long r0 = m7488modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i2, 7, (Object) null));
        return Math.max(Constraints.m7054getMinWidthimpl(r0), intrinsicMeasurable.maxIntrinsicWidth(i2));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.m5044getIntrinsicSizeNHjbRc() == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        int i2 = i;
        long r2 = m7488modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i2, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m7053getMinHeightimpl(r2), intrinsicMeasurable.minIntrinsicHeight(i2));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.m5044getIntrinsicSizeNHjbRc() == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        int i2 = i;
        long r2 = m7488modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i2, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m7053getMinHeightimpl(r2), intrinsicMeasurable.maxIntrinsicHeight(i2));
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m7487calculateScaledSizeE7KxVPU(long j) {
        if (Size.m4058isEmptyimpl(j)) {
            return Size.Companion.m4065getZeroNHjbRc();
        }
        long r0 = this.painter.m5044getIntrinsicSizeNHjbRc();
        if (r0 == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return j;
        }
        float r2 = Size.m4056getWidthimpl(r0);
        if (Float.isInfinite(r2) || Float.isNaN(r2)) {
            r2 = Size.m4056getWidthimpl(j);
        }
        float r02 = Size.m4053getHeightimpl(r0);
        if (Float.isInfinite(r02) || Float.isNaN(r02)) {
            r02 = Size.m4053getHeightimpl(j);
        }
        long Size = SizeKt.Size(r2, r02);
        long r22 = this.contentScale.m5764computeScaleFactorH7hwNQA(Size, j);
        float r4 = ScaleFactor.m5916getScaleXimpl(r22);
        if (Float.isInfinite(r4) || Float.isNaN(r4)) {
            return j;
        }
        float r42 = ScaleFactor.m5917getScaleYimpl(r22);
        return (Float.isInfinite(r42) || Float.isNaN(r42)) ? j : ScaleFactorKt.m5932timesmw2e94(r22, Size);
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m7488modifyConstraintsZezNO4M(long j) {
        float f;
        float f2;
        int r1;
        boolean r0 = Constraints.m7050getHasFixedWidthimpl(j);
        boolean r12 = Constraints.m7049getHasFixedHeightimpl(j);
        if (r0 && r12) {
            return j;
        }
        Painter painter2 = this.painter;
        boolean z = Constraints.m7048getHasBoundedWidthimpl(j) && Constraints.m7047getHasBoundedHeightimpl(j);
        long r4 = painter2.m5044getIntrinsicSizeNHjbRc();
        if (r4 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            if (!z || (!r0 && !r12)) {
                float r02 = Size.m4056getWidthimpl(r4);
                float r13 = Size.m4053getHeightimpl(r4);
                if (Float.isInfinite(r02) || Float.isNaN(r02)) {
                    f2 = (float) Constraints.m7054getMinWidthimpl(j);
                } else {
                    f2 = UtilsKt.m7494constrainWidthK40F9xA(j, r02);
                }
                if (Float.isInfinite(r13) || Float.isNaN(r13)) {
                    r1 = Constraints.m7053getMinHeightimpl(j);
                } else {
                    f = UtilsKt.m7493constrainHeightK40F9xA(j, r13);
                    long r03 = m7487calculateScaledSizeE7KxVPU(SizeKt.Size(f2, f));
                    return Constraints.m7043copyZbe2FdA$default(j, ConstraintsKt.m7069constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m4056getWidthimpl(r03))), 0, ConstraintsKt.m7068constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m4053getHeightimpl(r03))), 0, 10, (Object) null);
                }
            } else {
                f2 = (float) Constraints.m7052getMaxWidthimpl(j);
                r1 = Constraints.m7051getMaxHeightimpl(j);
            }
            f = (float) r1;
            long r032 = m7487calculateScaledSizeE7KxVPU(SizeKt.Size(f2, f));
            return Constraints.m7043copyZbe2FdA$default(j, ConstraintsKt.m7069constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m4056getWidthimpl(r032))), 0, ConstraintsKt.m7068constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m4053getHeightimpl(r032))), 0, 10, (Object) null);
        } else if (!z) {
            return j;
        } else {
            if ((painter2 instanceof AsyncImagePainter) && ((AsyncImagePainter) painter2).getState().getValue().getPainter() == null) {
                return j;
            }
            return Constraints.m7043copyZbe2FdA$default(j, Constraints.m7052getMaxWidthimpl(j), 0, Constraints.m7051getMaxHeightimpl(j), 0, 10, (Object) null);
        }
    }

    public void draw(ContentDrawScope contentDrawScope) {
        long r4 = m7487calculateScaledSizeE7KxVPU(contentDrawScope.m4865getSizeNHjbRc());
        long r0 = this.alignment.m3819alignKFBX0sM(UtilsKt.m7496toIntSizeuvyYCjk(r4), UtilsKt.m7496toIntSizeuvyYCjk(contentDrawScope.m4865getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        DrawScope drawScope = contentDrawScope;
        float r1 = (float) IntOffset.m7241getXimpl(r0);
        float r8 = (float) IntOffset.m7242getYimpl(r0);
        drawScope.getDrawContext().getTransform().translate(r1, r8);
        try {
            this.painter.m5043drawx_KDEd0(drawScope, r4, this.alpha, this.colorFilter);
            drawScope.getDrawContext().getTransform().translate(-r1, -r8);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            Throwable th2 = th;
            drawScope.getDrawContext().getTransform().translate(-r1, -r8);
            throw th2;
        }
    }
}
