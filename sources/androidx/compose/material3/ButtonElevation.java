package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/ButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Button.kt */
public final class ButtonElevation {
    public static final int $stable = 0;
    private final float defaultElevation;
    private final float disabledElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    public /* synthetic */ ButtonElevation(float f, float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5);
    }

    private ButtonElevation(float f, float f2, float f3, float f4, float f5) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.focusedElevation = f3;
        this.hoveredElevation = f4;
        this.disabledElevation = f5;
    }

    public final State<Dp> shadowElevation$material3_release(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2045116089, "C(shadowElevation)931@43193L74:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045116089, i, -1, "androidx.compose.material3.ButtonElevation.shadowElevation (Button.kt:930)");
        }
        State<Dp> animateElevation = animateElevation(z, interactionSource, composer, i & 1022);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateElevation;
    }

    private final State<Dp> animateElevation(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        float f;
        Animatable animatable;
        boolean z2 = z;
        InteractionSource interactionSource2 = interactionSource;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -1312510462, "C(animateElevation)939@43442L46,940@43531L1077,940@43497L1111,982@45105L51,984@45189L863,984@45166L886:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1312510462, i2, -1, "androidx.compose.material3.ButtonElevation.animateElevation (Button.kt:938)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -842871664, "CC(remember):Button.kt#9igjgp");
        Object rememberedValue = composer2.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateListOf();
            composer2.updateRememberedValue(rememberedValue);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, -842867785, "CC(remember):Button.kt#9igjgp");
        boolean z3 = true;
        boolean z4 = (((i2 & 112) ^ 48) > 32 && composer2.changed((Object) interactionSource2)) || (i2 & 48) == 32;
        Object rememberedValue2 = composer2.rememberedValue();
        if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ButtonElevation$animateElevation$1$1(interactionSource2, snapshotStateList, (Continuation<? super ButtonElevation$animateElevation$1$1>) null);
            composer2.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.LaunchedEffect((Object) interactionSource2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer2, (i2 >> 3) & 14);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
        if (!z2) {
            f = this.disabledElevation;
        } else if (interaction instanceof PressInteraction.Press) {
            f = this.pressedElevation;
        } else if (interaction instanceof HoverInteraction.Enter) {
            f = this.hoveredElevation;
        } else if (interaction instanceof FocusInteraction.Focus) {
            f = this.focusedElevation;
        } else {
            f = this.defaultElevation;
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -842818443, "CC(remember):Button.kt#9igjgp");
        Object rememberedValue3 = composer2.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            Animatable animatable2 = new Animatable(Dp.m7109boximpl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(animatable2);
            rememberedValue3 = animatable2;
        }
        Animatable animatable3 = (Animatable) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Dp r8 = Dp.m7109boximpl(f);
        ComposerKt.sourceInformationMarkerStart(composer2, -842814943, "CC(remember):Button.kt#9igjgp");
        boolean changedInstance = composer2.changedInstance(animatable3) | composer2.changed(f) | ((((i2 & 14) ^ 6) > 4 && composer2.changed(z2)) || (i2 & 6) == 4);
        if ((((i2 & 896) ^ 384) <= 256 || !composer2.changed((Object) this)) && (i2 & 384) != 256) {
            z3 = false;
        }
        boolean changedInstance2 = changedInstance | z3 | composer2.changedInstance(interaction);
        Object rememberedValue4 = composer2.rememberedValue();
        if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
            animatable = animatable3;
            rememberedValue4 = new ButtonElevation$animateElevation$2$1(animatable, f, z2, this, interaction, (Continuation<? super ButtonElevation$animateElevation$2$1>) null);
            composer2.updateRememberedValue(rememberedValue4);
        } else {
            animatable = animatable3;
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.LaunchedEffect((Object) r8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue4, composer2, 0);
        State<Dp> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return asState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ButtonElevation)) {
            return false;
        }
        ButtonElevation buttonElevation = (ButtonElevation) obj;
        return Dp.m7116equalsimpl0(this.defaultElevation, buttonElevation.defaultElevation) && Dp.m7116equalsimpl0(this.pressedElevation, buttonElevation.pressedElevation) && Dp.m7116equalsimpl0(this.focusedElevation, buttonElevation.focusedElevation) && Dp.m7116equalsimpl0(this.hoveredElevation, buttonElevation.hoveredElevation) && Dp.m7116equalsimpl0(this.disabledElevation, buttonElevation.disabledElevation);
    }

    public int hashCode() {
        return (((((((Dp.m7117hashCodeimpl(this.defaultElevation) * 31) + Dp.m7117hashCodeimpl(this.pressedElevation)) * 31) + Dp.m7117hashCodeimpl(this.focusedElevation)) * 31) + Dp.m7117hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m7117hashCodeimpl(this.disabledElevation);
    }
}
