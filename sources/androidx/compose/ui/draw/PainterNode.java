package androidx.compose.ui.draw;

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
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00101J\b\u00106\u001a\u000207H\u0016J\f\u00108\u001a\u000209*\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0016\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J&\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PainterModifier.kt */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter2) {
        this.painter = painter2;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PainterNode(Painter painter2, boolean z, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter2, z, (i & 4) != 0 ? Alignment.Companion.getCenter() : alignment2, (i & 8) != 0 ? ContentScale.Companion.getInside() : contentScale2, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter2);
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

    public PainterNode(Painter painter2, boolean z, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2) {
        this.painter = painter2;
        this.sizeToIntrinsics = z;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = f;
        this.colorFilter = colorFilter2;
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.m5044getIntrinsicSizeNHjbRc() != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m3875measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable r9 = measurable.m5848measureBRTryo0(m3874modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new PainterNode$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        int i2 = i;
        long r0 = m3874modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i2, 7, (Object) null));
        return Math.max(Constraints.m7054getMinWidthimpl(r0), intrinsicMeasurable.minIntrinsicWidth(i2));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        int i2 = i;
        long r0 = m3874modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i2, 7, (Object) null));
        return Math.max(Constraints.m7054getMinWidthimpl(r0), intrinsicMeasurable.maxIntrinsicWidth(i2));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        int i2 = i;
        long r2 = m3874modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i2, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m7053getMinHeightimpl(r2), intrinsicMeasurable.minIntrinsicHeight(i2));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        int i2 = i;
        long r2 = m3874modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i2, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m7053getMinHeightimpl(r2), intrinsicMeasurable.maxIntrinsicHeight(i2));
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m3871calculateScaledSizeE7KxVPU(long j) {
        float f;
        float f2;
        if (!getUseIntrinsicSize()) {
            return j;
        }
        if (!m3873hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.m5044getIntrinsicSizeNHjbRc())) {
            f = Size.m4056getWidthimpl(j);
        } else {
            f = Size.m4056getWidthimpl(this.painter.m5044getIntrinsicSizeNHjbRc());
        }
        if (!m3872hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.m5044getIntrinsicSizeNHjbRc())) {
            f2 = Size.m4053getHeightimpl(j);
        } else {
            f2 = Size.m4053getHeightimpl(this.painter.m5044getIntrinsicSizeNHjbRc());
        }
        long Size = SizeKt.Size(f, f2);
        if (Size.m4056getWidthimpl(j) == 0.0f || Size.m4053getHeightimpl(j) == 0.0f) {
            return Size.Companion.m4065getZeroNHjbRc();
        }
        return ScaleFactorKt.m5931timesUQTWf7w(Size, this.contentScale.m5764computeScaleFactorH7hwNQA(Size, j));
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m3874modifyConstraintsZezNO4M(long j) {
        int i;
        int i2;
        boolean z = true;
        boolean z2 = Constraints.m7048getHasBoundedWidthimpl(j) && Constraints.m7047getHasBoundedHeightimpl(j);
        if (!Constraints.m7050getHasFixedWidthimpl(j) || !Constraints.m7049getHasFixedHeightimpl(j)) {
            z = false;
        }
        if ((getUseIntrinsicSize() || !z2) && !z) {
            long j2 = j;
            long r12 = this.painter.m5044getIntrinsicSizeNHjbRc();
            if (m3873hasSpecifiedAndFiniteWidthuvyYCjk(r12)) {
                i = Math.round(Size.m4056getWidthimpl(r12));
            } else {
                i = Constraints.m7054getMinWidthimpl(j2);
            }
            if (m3872hasSpecifiedAndFiniteHeightuvyYCjk(r12)) {
                i2 = Math.round(Size.m4053getHeightimpl(r12));
            } else {
                i2 = Constraints.m7053getMinHeightimpl(j2);
            }
            long r122 = m3871calculateScaledSizeE7KxVPU(SizeKt.Size((float) ConstraintsKt.m7069constrainWidthK40F9xA(j2, i), (float) ConstraintsKt.m7068constrainHeightK40F9xA(j2, i2)));
            return Constraints.m7043copyZbe2FdA$default(j2, ConstraintsKt.m7069constrainWidthK40F9xA(j2, Math.round(Size.m4056getWidthimpl(r122))), 0, ConstraintsKt.m7068constrainHeightK40F9xA(j2, Math.round(Size.m4053getHeightimpl(r122))), 0, 10, (Object) null);
        }
        return Constraints.m7043copyZbe2FdA$default(j, Constraints.m7052getMaxWidthimpl(j), 0, Constraints.m7051getMaxHeightimpl(j), 0, 10, (Object) null);
    }

    public void draw(ContentDrawScope contentDrawScope) {
        float f;
        float f2;
        long j;
        long r0 = this.painter.m5044getIntrinsicSizeNHjbRc();
        if (m3873hasSpecifiedAndFiniteWidthuvyYCjk(r0)) {
            f = Size.m4056getWidthimpl(r0);
        } else {
            f = Size.m4056getWidthimpl(contentDrawScope.m4865getSizeNHjbRc());
        }
        if (m3872hasSpecifiedAndFiniteHeightuvyYCjk(r0)) {
            f2 = Size.m4053getHeightimpl(r0);
        } else {
            f2 = Size.m4053getHeightimpl(contentDrawScope.m4865getSizeNHjbRc());
        }
        long Size = SizeKt.Size(f, f2);
        if (Size.m4056getWidthimpl(contentDrawScope.m4865getSizeNHjbRc()) == 0.0f || Size.m4053getHeightimpl(contentDrawScope.m4865getSizeNHjbRc()) == 0.0f) {
            j = Size.Companion.m4065getZeroNHjbRc();
        } else {
            j = ScaleFactorKt.m5931timesUQTWf7w(Size, this.contentScale.m5764computeScaleFactorH7hwNQA(Size, contentDrawScope.m4865getSizeNHjbRc()));
        }
        long j2 = j;
        long r02 = this.alignment.m3819alignKFBX0sM(IntSizeKt.IntSize(Math.round(Size.m4056getWidthimpl(j2)), Math.round(Size.m4053getHeightimpl(j2))), IntSizeKt.IntSize(Math.round(Size.m4056getWidthimpl(contentDrawScope.m4865getSizeNHjbRc())), Math.round(Size.m4053getHeightimpl(contentDrawScope.m4865getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float r8 = (float) IntOffset.m7241getXimpl(r02);
        float r1 = (float) IntOffset.m7242getYimpl(r02);
        DrawScope drawScope = contentDrawScope;
        drawScope.getDrawContext().getTransform().translate(r8, r1);
        try {
            this.painter.m5043drawx_KDEd0(drawScope, j2, this.alpha, this.colorFilter);
            drawScope.getDrawContext().getTransform().translate(-r8, -r1);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            Throwable th2 = th;
            drawScope.getDrawContext().getTransform().translate(-r8, -r1);
            throw th2;
        }
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk  reason: not valid java name */
    private final boolean m3873hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (Size.m4052equalsimpl0(j, Size.Companion.m4064getUnspecifiedNHjbRc())) {
            return false;
        }
        float r3 = Size.m4056getWidthimpl(j);
        return !Float.isInfinite(r3) && !Float.isNaN(r3);
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk  reason: not valid java name */
    private final boolean m3872hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (Size.m4052equalsimpl0(j, Size.Companion.m4064getUnspecifiedNHjbRc())) {
            return false;
        }
        float r3 = Size.m4053getHeightimpl(j);
        return !Float.isInfinite(r3) && !Float.isNaN(r3);
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
