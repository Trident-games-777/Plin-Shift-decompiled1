package androidx.compose.material.ripple;

import android.view.View;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\f\u0010$\u001a\u00020\u0017*\u00020%H\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0014\u0010\u0015\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/material/ripple/AndroidRippleNode;", "Landroidx/compose/material/ripple/RippleNode;", "Landroidx/compose/material/ripple/RippleHostKey;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "rippleContainer", "Landroidx/compose/material/ripple/RippleContainer;", "value", "Landroidx/compose/material/ripple/RippleHostView;", "rippleHostView", "setRippleHostView", "(Landroidx/compose/material/ripple/RippleHostView;)V", "addRipple", "", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "targetRadius", "", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "getOrCreateRippleContainer", "onDetach", "onResetRippleHostView", "removeRipple", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.android.kt */
public final class AndroidRippleNode extends RippleNode implements RippleHostKey {
    public static final int $stable = 8;
    private RippleContainer rippleContainer;
    private RippleHostView rippleHostView;

    public /* synthetic */ AndroidRippleNode(InteractionSource interactionSource, boolean z, float f, ColorProducer colorProducer, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z, f, colorProducer, function0);
    }

    private AndroidRippleNode(InteractionSource interactionSource, boolean z, float f, ColorProducer colorProducer, Function0<RippleAlpha> function0) {
        super(interactionSource, z, f, colorProducer, function0, (DefaultConstructorMarker) null);
    }

    private final void setRippleHostView(RippleHostView rippleHostView2) {
        this.rippleHostView = rippleHostView2;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    /* renamed from: addRipple-12SF9DM  reason: not valid java name */
    public void m1676addRipple12SF9DM(PressInteraction.Press press, long j, float f) {
        RippleHostView rippleHostView2 = getOrCreateRippleContainer().getRippleHostView(this);
        rippleHostView2.m1687addRippleKOepWvA(press, getBounded(), j, MathKt.roundToInt(f), m1693getRippleColor0d7_KjU(), getRippleAlpha().invoke().getPressedAlpha(), new AndroidRippleNode$addRipple$1$1$1(this));
        setRippleHostView(rippleHostView2);
    }

    public void removeRipple(PressInteraction.Press press) {
        RippleHostView rippleHostView2 = this.rippleHostView;
        if (rippleHostView2 != null) {
            rippleHostView2.removeRipple();
        }
    }

    public void onDetach() {
        RippleContainer rippleContainer2 = this.rippleContainer;
        if (rippleContainer2 != null) {
            rippleContainer2.disposeRippleIfNeeded(this);
        }
    }

    public void onResetRippleHostView() {
        setRippleHostView((RippleHostView) null);
    }

    private final RippleContainer getOrCreateRippleContainer() {
        RippleContainer rippleContainer2 = this.rippleContainer;
        if (rippleContainer2 != null) {
            Intrinsics.checkNotNull(rippleContainer2);
            return rippleContainer2;
        }
        RippleContainer access$createAndAttachRippleContainerIfNeeded = Ripple_androidKt.createAndAttachRippleContainerIfNeeded(Ripple_androidKt.findNearestViewGroup((View) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, AndroidCompositionLocals_androidKt.getLocalView())));
        this.rippleContainer = access$createAndAttachRippleContainerIfNeeded;
        Intrinsics.checkNotNull(access$createAndAttachRippleContainerIfNeeded);
        return access$createAndAttachRippleContainerIfNeeded;
    }

    public void drawRipples(DrawScope drawScope) {
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        RippleHostView rippleHostView2 = this.rippleHostView;
        if (rippleHostView2 != null) {
            rippleHostView2.m1688setRippleProperties07v42R4(m1694getRippleSizeNHjbRc(), m1693getRippleColor0d7_KjU(), getRippleAlpha().invoke().getPressedAlpha());
            rippleHostView2.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        }
    }
}
