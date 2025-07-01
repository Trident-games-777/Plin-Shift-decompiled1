package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/material3/ThumbNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "checked", "", "(Landroidx/compose/foundation/interaction/InteractionSource;Z)V", "getChecked", "()Z", "setChecked", "(Z)V", "initialOffset", "", "initialSize", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "isPressed", "offsetAnim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "sizeAnim", "onAttach", "", "update", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class ThumbNode extends Modifier.Node implements LayoutModifierNode {
    private boolean checked;
    private float initialOffset = Float.NaN;
    private float initialSize = Float.NaN;
    private InteractionSource interactionSource;
    /* access modifiers changed from: private */
    public boolean isPressed;
    /* access modifiers changed from: private */
    public Animatable<Float, AnimationVector1D> offsetAnim;
    /* access modifiers changed from: private */
    public Animatable<Float, AnimationVector1D> sizeAnim;

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final void setInteractionSource(InteractionSource interactionSource2) {
        this.interactionSource = interactionSource2;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public ThumbNode(InteractionSource interactionSource2, boolean z) {
        this.interactionSource = interactionSource2;
        this.checked = z;
    }

    public void onAttach() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new ThumbNode$onAttach$1(this, (Continuation<? super ThumbNode$onAttach$1>) null), 3, (Object) null);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2695measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float f;
        boolean z = (measurable.maxIntrinsicHeight(Constraints.m7052getMaxWidthimpl(j)) == 0 || measurable.maxIntrinsicWidth(Constraints.m7051getMaxHeightimpl(j)) == 0) ? false : true;
        if (this.isPressed) {
            f = SwitchTokens.INSTANCE.m3541getPressedHandleWidthD9Ej5fM();
        } else if (z || this.checked) {
            f = SwitchKt.getThumbDiameter();
        } else {
            f = SwitchKt.getUncheckedThumbDiameter();
        }
        float r12 = measureScope.m7091toPx0680j_4(f);
        Animatable<Float, AnimationVector1D> animatable = this.sizeAnim;
        int floatValue = (int) (animatable != null ? animatable.getValue().floatValue() : r12);
        Placeable r11 = measurable.m5848measureBRTryo0(Constraints.Companion.m7062fixedJhjzzOo(floatValue, floatValue));
        float r13 = measureScope.m7091toPx0680j_4(Dp.m7111constructorimpl(Dp.m7111constructorimpl(SwitchKt.SwitchHeight - measureScope.m7087toDpu2uoSUM(r12)) / 2.0f));
        float r0 = measureScope.m7091toPx0680j_4(Dp.m7111constructorimpl(Dp.m7111constructorimpl(SwitchKt.SwitchWidth - SwitchKt.getThumbDiameter()) - SwitchKt.ThumbPadding));
        boolean z2 = this.isPressed;
        if (z2 && this.checked) {
            r13 = r0 - measureScope.m7091toPx0680j_4(SwitchTokens.INSTANCE.m3547getTrackOutlineWidthD9Ej5fM());
        } else if (z2 && !this.checked) {
            r13 = measureScope.m7091toPx0680j_4(SwitchTokens.INSTANCE.m3547getTrackOutlineWidthD9Ej5fM());
        } else if (this.checked) {
            r13 = r0;
        }
        Animatable<Float, AnimationVector1D> animatable2 = this.sizeAnim;
        if (!Intrinsics.areEqual(animatable2 != null ? animatable2.getTargetValue() : null, r12)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new ThumbNode$measure$1(this, r12, (Continuation<? super ThumbNode$measure$1>) null), 3, (Object) null);
        }
        Animatable<Float, AnimationVector1D> animatable3 = this.offsetAnim;
        if (!Intrinsics.areEqual(animatable3 != null ? animatable3.getTargetValue() : null, r13)) {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new ThumbNode$measure$2(this, r13, (Continuation<? super ThumbNode$measure$2>) null), 3, (Object) null);
        }
        if (Float.isNaN(this.initialSize) && Float.isNaN(this.initialOffset)) {
            this.initialSize = r12;
            this.initialOffset = r13;
        }
        return MeasureScope.layout$default(measureScope, floatValue, floatValue, (Map) null, new ThumbNode$measure$3(r11, this, r13), 4, (Object) null);
    }

    public final void update() {
        if (this.sizeAnim == null && !Float.isNaN(this.initialSize)) {
            this.sizeAnim = AnimatableKt.Animatable$default(this.initialSize, 0.0f, 2, (Object) null);
        }
        if (this.offsetAnim == null && !Float.isNaN(this.initialOffset)) {
            this.offsetAnim = AnimatableKt.Animatable$default(this.initialOffset, 0.0f, 2, (Object) null);
        }
    }
}
