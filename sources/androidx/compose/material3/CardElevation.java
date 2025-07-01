package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/CardElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Card.kt */
public final class CardElevation {
    public static final int $stable = 0;
    private final float defaultElevation;
    private final float disabledElevation;
    /* access modifiers changed from: private */
    public final float draggedElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    public /* synthetic */ CardElevation(float f, float f2, float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6);
    }

    private CardElevation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.focusedElevation = f3;
        this.hoveredElevation = f4;
        this.draggedElevation = f5;
        this.disabledElevation = f6;
    }

    public final State<Dp> shadowElevation$material3_release(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        composer.startReplaceGroup(-1763481333);
        ComposerKt.sourceInformation(composer, "C(shadowElevation)663@29753L74:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763481333, i, -1, "androidx.compose.material3.CardElevation.shadowElevation (Card.kt:659)");
        }
        composer.startReplaceGroup(-734838460);
        ComposerKt.sourceInformation(composer, "661@29682L45");
        if (interactionSource == null) {
            ComposerKt.sourceInformationMarkerStart(composer, -734836858, "CC(remember):Card.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m7109boximpl(this.defaultElevation), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return mutableState;
        }
        composer.endReplaceGroup();
        State<Dp> animateElevation = animateElevation(z, interactionSource, composer, i & 1022);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return animateElevation;
    }

    private final State<Dp> animateElevation(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        float f;
        Animatable animatable;
        boolean z2 = z;
        InteractionSource interactionSource2 = interactionSource;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -1421890746, "C(animateElevation)671@30002L46,672@30091L1473,672@30057L1507,724@32126L51,726@32210L936,726@32187L959:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1421890746, i2, -1, "androidx.compose.material3.CardElevation.animateElevation (Card.kt:670)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -1719589842, "CC(remember):Card.kt#9igjgp");
        Object rememberedValue = composer2.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateListOf();
            composer2.updateRememberedValue(rememberedValue);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, -1719585567, "CC(remember):Card.kt#9igjgp");
        boolean z3 = true;
        boolean z4 = (((i2 & 112) ^ 48) > 32 && composer2.changed((Object) interactionSource2)) || (i2 & 48) == 32;
        Object rememberedValue2 = composer2.rememberedValue();
        if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new CardElevation$animateElevation$1$1(interactionSource2, snapshotStateList, (Continuation<? super CardElevation$animateElevation$1$1>) null);
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
        } else if (interaction instanceof DragInteraction.Start) {
            f = this.draggedElevation;
        } else {
            f = this.defaultElevation;
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -1719521869, "CC(remember):Card.kt#9igjgp");
        Object rememberedValue3 = composer2.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            Animatable animatable2 = new Animatable(Dp.m7109boximpl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(animatable2);
            rememberedValue3 = animatable2;
        }
        Animatable animatable3 = (Animatable) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Dp r8 = Dp.m7109boximpl(f);
        ComposerKt.sourceInformationMarkerStart(composer2, -1719518296, "CC(remember):Card.kt#9igjgp");
        boolean changedInstance = composer2.changedInstance(animatable3) | composer2.changed(f) | ((((i2 & 14) ^ 6) > 4 && composer2.changed(z2)) || (i2 & 6) == 4);
        if ((((i2 & 896) ^ 384) <= 256 || !composer2.changed((Object) this)) && (i2 & 384) != 256) {
            z3 = false;
        }
        boolean changedInstance2 = changedInstance | z3 | composer2.changedInstance(interaction);
        Object rememberedValue4 = composer2.rememberedValue();
        if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
            animatable = animatable3;
            rememberedValue4 = new CardElevation$animateElevation$2$1(animatable, f, z2, this, interaction, (Continuation<? super CardElevation$animateElevation$2$1>) null);
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
        if (obj == null || !(obj instanceof CardElevation)) {
            return false;
        }
        CardElevation cardElevation = (CardElevation) obj;
        return Dp.m7116equalsimpl0(this.defaultElevation, cardElevation.defaultElevation) && Dp.m7116equalsimpl0(this.pressedElevation, cardElevation.pressedElevation) && Dp.m7116equalsimpl0(this.focusedElevation, cardElevation.focusedElevation) && Dp.m7116equalsimpl0(this.hoveredElevation, cardElevation.hoveredElevation) && Dp.m7116equalsimpl0(this.disabledElevation, cardElevation.disabledElevation);
    }

    public int hashCode() {
        return (((((((Dp.m7117hashCodeimpl(this.defaultElevation) * 31) + Dp.m7117hashCodeimpl(this.pressedElevation)) * 31) + Dp.m7117hashCodeimpl(this.focusedElevation)) * 31) + Dp.m7117hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m7117hashCodeimpl(this.disabledElevation);
    }
}
