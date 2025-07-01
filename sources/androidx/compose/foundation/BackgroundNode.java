package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010%\u001a\u00020&H\u0016J\f\u0010'\u001a\u00020&*\u00020(H\u0016J\f\u0010)\u001a\u00020&*\u00020(H\u0002J\f\u0010*\u001a\u00020&*\u00020(H\u0002J\f\u0010+\u001a\u00020\u001d*\u00020(H\u0002R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u0005X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u00020 X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, d2 = {"Landroidx/compose/foundation/BackgroundNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastShape", "lastSize", "Landroidx/compose/ui/geometry/Size;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "onObservedReadsChanged", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawOutline", "drawRect", "getOutline", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Background.kt */
final class BackgroundNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode {
    private float alpha;
    private Brush brush;
    private long color;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private long lastSize;
    private Shape shape;

    public /* synthetic */ BackgroundNode(long j, Brush brush2, float f, Shape shape2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, brush2, f, shape2);
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m249getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public final void m250setColor8_81llA(long j) {
        this.color = j;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush2) {
        this.brush = brush2;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape2) {
        this.shape = shape2;
    }

    private BackgroundNode(long j, Brush brush2, float f, Shape shape2) {
        this.color = j;
        this.brush = brush2;
        this.alpha = f;
        this.shape = shape2;
        this.lastSize = Size.Companion.m4064getUnspecifiedNHjbRc();
    }

    public void draw(ContentDrawScope contentDrawScope) {
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect(contentDrawScope);
        } else {
            drawOutline(contentDrawScope);
        }
        contentDrawScope.drawContent();
    }

    public void onObservedReadsChanged() {
        this.lastSize = Size.Companion.m4064getUnspecifiedNHjbRc();
        this.lastLayoutDirection = null;
        this.lastOutline = null;
        this.lastShape = null;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private final void drawRect(ContentDrawScope contentDrawScope) {
        if (!Color.m4240equalsimpl0(this.color, Color.Companion.m4275getUnspecified0d7_KjU())) {
            DrawScope.m4840drawRectnJ9OG0$default(contentDrawScope, this.color, 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
        }
        Brush brush2 = this.brush;
        if (brush2 != null) {
            DrawScope.m4839drawRectAsUm42w$default(contentDrawScope, brush2, 0, 0, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
        }
    }

    private final void drawOutline(ContentDrawScope contentDrawScope) {
        Outline outline = getOutline(contentDrawScope);
        if (!Color.m4240equalsimpl0(this.color, Color.Companion.m4275getUnspecified0d7_KjU())) {
            OutlineKt.m4502drawOutlinewDX37Ww$default(contentDrawScope, outline, this.color, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        }
        Brush brush2 = this.brush;
        if (brush2 != null) {
            OutlineKt.m4500drawOutlinehn5TExg$default(contentDrawScope, outline, brush2, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        }
    }

    private final Outline getOutline(ContentDrawScope contentDrawScope) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (!Size.m4052equalsimpl0(contentDrawScope.m4865getSizeNHjbRc(), this.lastSize) || contentDrawScope.getLayoutDirection() != this.lastLayoutDirection || !Intrinsics.areEqual((Object) this.lastShape, (Object) this.shape)) {
            ObserverModifierNodeKt.observeReads(this, new BackgroundNode$getOutline$1(objectRef, this, contentDrawScope));
        } else {
            T t = this.lastOutline;
            Intrinsics.checkNotNull(t);
            objectRef.element = t;
        }
        this.lastOutline = (Outline) objectRef.element;
        this.lastSize = contentDrawScope.m4865getSizeNHjbRc();
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
        this.lastShape = this.shape;
        T t2 = objectRef.element;
        Intrinsics.checkNotNull(t2);
        return (Outline) t2;
    }
}
