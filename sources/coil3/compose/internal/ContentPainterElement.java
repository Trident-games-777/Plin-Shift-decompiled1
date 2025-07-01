package coil3.compose.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\f\u0010\u0013\u001a\u00020\u0011*\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0017\u001a\u00020\bHÂ\u0003J\t\u0010\u0018\u001a\u00020\nHÂ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\fHÂ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcoil3/compose/internal/ContentPainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcoil3/compose/internal/ContentPainterNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ContentPainterModifier.kt */
public final class ContentPainterElement extends ModifierNodeElement<ContentPainterNode> {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;

    private final Painter component1() {
        return this.painter;
    }

    private final Alignment component2() {
        return this.alignment;
    }

    private final ContentScale component3() {
        return this.contentScale;
    }

    private final float component4() {
        return this.alpha;
    }

    private final ColorFilter component5() {
        return this.colorFilter;
    }

    public static /* synthetic */ ContentPainterElement copy$default(ContentPainterElement contentPainterElement, Painter painter2, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2, int i, Object obj) {
        if ((i & 1) != 0) {
            painter2 = contentPainterElement.painter;
        }
        if ((i & 2) != 0) {
            alignment2 = contentPainterElement.alignment;
        }
        if ((i & 4) != 0) {
            contentScale2 = contentPainterElement.contentScale;
        }
        if ((i & 8) != 0) {
            f = contentPainterElement.alpha;
        }
        if ((i & 16) != 0) {
            colorFilter2 = contentPainterElement.colorFilter;
        }
        float f2 = f;
        ColorFilter colorFilter3 = colorFilter2;
        return contentPainterElement.copy(painter2, alignment2, contentScale2, f2, colorFilter3);
    }

    public final ContentPainterElement copy(Painter painter2, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2) {
        return new ContentPainterElement(painter2, alignment2, contentScale2, f, colorFilter2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentPainterElement)) {
            return false;
        }
        ContentPainterElement contentPainterElement = (ContentPainterElement) obj;
        return Intrinsics.areEqual((Object) this.painter, (Object) contentPainterElement.painter) && Intrinsics.areEqual((Object) this.alignment, (Object) contentPainterElement.alignment) && Intrinsics.areEqual((Object) this.contentScale, (Object) contentPainterElement.contentScale) && Float.compare(this.alpha, contentPainterElement.alpha) == 0 && Intrinsics.areEqual((Object) this.colorFilter, (Object) contentPainterElement.colorFilter);
    }

    public int hashCode() {
        int hashCode = ((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter2 = this.colorFilter;
        return hashCode + (colorFilter2 == null ? 0 : colorFilter2.hashCode());
    }

    public String toString() {
        return "ContentPainterElement(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    public ContentPainterElement(Painter painter2, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2) {
        this.painter = painter2;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = f;
        this.colorFilter = colorFilter2;
    }

    public ContentPainterNode create() {
        return new ContentPainterNode(this.painter, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    public void update(ContentPainterNode contentPainterNode) {
        boolean r0 = Size.m4052equalsimpl0(contentPainterNode.getPainter().m5044getIntrinsicSizeNHjbRc(), this.painter.m5044getIntrinsicSizeNHjbRc());
        contentPainterNode.setPainter(this.painter);
        contentPainterNode.setAlignment(this.alignment);
        contentPainterNode.setContentScale(this.contentScale);
        contentPainterNode.setAlpha(this.alpha);
        contentPainterNode.setColorFilter(this.colorFilter);
        if (!r0) {
            LayoutModifierNodeKt.invalidateMeasurement(contentPainterNode);
        }
        DrawModifierNodeKt.invalidateDraw(contentPainterNode);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName(FirebaseAnalytics.Param.CONTENT);
        inspectorInfo.getProperties().set("painter", this.painter);
        inspectorInfo.getProperties().set("alignment", this.alignment);
        inspectorInfo.getProperties().set("contentScale", this.contentScale);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
    }
}
