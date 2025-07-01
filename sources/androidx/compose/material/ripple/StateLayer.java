package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J$\u0010\u0016\u001a\u00020\u0011*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLkotlin/jvm/functions/Function0;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", "", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handleInteraction$material_ripple_release", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.kt */
final class StateLayer {
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
    private final boolean bounded;
    private Interaction currentInteraction;
    private final List<Interaction> interactions = new ArrayList();
    private final Function0<RippleAlpha> rippleAlpha;

    public StateLayer(boolean z, Function0<RippleAlpha> function0) {
        this.bounded = z;
        this.rippleAlpha = function0;
    }

    public final void handleInteraction$material_ripple_release(Interaction interaction, CoroutineScope coroutineScope) {
        float f;
        Interaction interaction2 = interaction;
        boolean z = interaction2 instanceof HoverInteraction.Enter;
        if (z) {
            this.interactions.add(interaction2);
        } else if (interaction2 instanceof HoverInteraction.Exit) {
            this.interactions.remove(((HoverInteraction.Exit) interaction2).getEnter());
        } else if (interaction2 instanceof FocusInteraction.Focus) {
            this.interactions.add(interaction2);
        } else if (interaction2 instanceof FocusInteraction.Unfocus) {
            this.interactions.remove(((FocusInteraction.Unfocus) interaction2).getFocus());
        } else if (interaction2 instanceof DragInteraction.Start) {
            this.interactions.add(interaction2);
        } else if (interaction2 instanceof DragInteraction.Stop) {
            this.interactions.remove(((DragInteraction.Stop) interaction2).getStart());
        } else if (interaction2 instanceof DragInteraction.Cancel) {
            this.interactions.remove(((DragInteraction.Cancel) interaction2).getStart());
        } else {
            return;
        }
        Interaction interaction3 = (Interaction) CollectionsKt.lastOrNull(this.interactions);
        if (!Intrinsics.areEqual((Object) this.currentInteraction, (Object) interaction3)) {
            if (interaction3 != null) {
                RippleAlpha invoke = this.rippleAlpha.invoke();
                if (z) {
                    f = invoke.getHoveredAlpha();
                } else if (interaction2 instanceof FocusInteraction.Focus) {
                    f = invoke.getFocusedAlpha();
                } else {
                    f = interaction2 instanceof DragInteraction.Start ? invoke.getDraggedAlpha() : 0.0f;
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$1(this, f, RippleKt.incomingStateLayerAnimationSpecFor(interaction3), (Continuation<? super StateLayer$handleInteraction$1>) null), 3, (Object) null);
            } else {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$2(this, RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction), (Continuation<? super StateLayer$handleInteraction$2>) null), 3, (Object) null);
            }
            this.currentInteraction = interaction3;
        }
    }

    /* renamed from: drawStateLayer-mxwnekA  reason: not valid java name */
    public final void m1700drawStateLayermxwnekA(DrawScope drawScope, float f, long j) {
        float floatValue = this.animatedAlpha.getValue().floatValue();
        if (floatValue > 0.0f) {
            long r11 = Color.m4238copywmQWz5c$default(j, floatValue, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            if (this.bounded) {
                float r6 = Size.m4056getWidthimpl(drawScope.m4865getSizeNHjbRc());
                float r7 = Size.m4053getHeightimpl(drawScope.m4865getSizeNHjbRc());
                int r8 = ClipOp.Companion.m4228getIntersectrtfAjoo();
                DrawContext drawContext = drawScope.getDrawContext();
                long r9 = drawContext.m4806getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().m4926clipRectN_I0leg(0.0f, 0.0f, r6, r7, r8);
                DrawScope.m4827drawCircleVaOC9Bg$default(drawScope, r11, f, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
                drawContext.getCanvas().restore();
                drawContext.m4807setSizeuvyYCjk(r9);
                return;
            }
            DrawScope.m4827drawCircleVaOC9Bg$default(drawScope, r11, f, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
        }
    }
}
