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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001e\u0010\u0018R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f²\u0006\f\u0010 \u001a\u0004\u0018\u00010!X\u0002"}, d2 = {"Landroidx/compose/material3/SelectableChipElevation;", "", "elevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledElevation-D9Ej5fM", "()F", "F", "getDraggedElevation-D9Ej5fM", "getElevation-D9Ej5fM", "getFocusedElevation-D9Ej5fM", "getHoveredElevation-D9Ej5fM", "getPressedElevation-D9Ej5fM", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "material3_release", "lastInteraction", "Landroidx/compose/foundation/interaction/Interaction;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class SelectableChipElevation {
    public static final int $stable = 0;
    private final float disabledElevation;
    private final float draggedElevation;
    private final float elevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ SelectableChipElevation(float f, float f2, float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6);
    }

    private SelectableChipElevation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.elevation = f;
        this.pressedElevation = f2;
        this.focusedElevation = f3;
        this.hoveredElevation = f4;
        this.draggedElevation = f5;
        this.disabledElevation = f6;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m2451getElevationD9Ej5fM() {
        return this.elevation;
    }

    /* renamed from: getPressedElevation-D9Ej5fM  reason: not valid java name */
    public final float m2454getPressedElevationD9Ej5fM() {
        return this.pressedElevation;
    }

    /* renamed from: getFocusedElevation-D9Ej5fM  reason: not valid java name */
    public final float m2452getFocusedElevationD9Ej5fM() {
        return this.focusedElevation;
    }

    /* renamed from: getHoveredElevation-D9Ej5fM  reason: not valid java name */
    public final float m2453getHoveredElevationD9Ej5fM() {
        return this.hoveredElevation;
    }

    /* renamed from: getDraggedElevation-D9Ej5fM  reason: not valid java name */
    public final float m2450getDraggedElevationD9Ej5fM() {
        return this.draggedElevation;
    }

    /* renamed from: getDisabledElevation-D9Ej5fM  reason: not valid java name */
    public final float m2449getDisabledElevationD9Ej5fM() {
        return this.disabledElevation;
    }

    public final State<Dp> shadowElevation$material3_release(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1888175651, "C(shadowElevation)2311@110081L74:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1888175651, i, -1, "androidx.compose.material3.SelectableChipElevation.shadowElevation (Chip.kt:2310)");
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
        ComposerKt.sourceInformationMarkerStart(composer2, 664514136, "C(animateElevation)2319@110330L46,2320@110408L47,2321@110498L1473,2321@110464L1507,2373@112526L51,2375@112610L514,2375@112587L537:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(664514136, i2, -1, "androidx.compose.material3.SelectableChipElevation.animateElevation (Chip.kt:2318)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -208085728, "CC(remember):Chip.kt#9igjgp");
        Object rememberedValue = composer2.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateListOf();
            composer2.updateRememberedValue(rememberedValue);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, -208083231, "CC(remember):Chip.kt#9igjgp");
        Object rememberedValue2 = composer2.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue2);
        }
        MutableState mutableState = (MutableState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, -208078925, "CC(remember):Chip.kt#9igjgp");
        boolean z3 = true;
        boolean z4 = (((i2 & 112) ^ 48) > 32 && composer2.changed((Object) interactionSource2)) || (i2 & 48) == 32;
        Object rememberedValue3 = composer2.rememberedValue();
        if (z4 || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new SelectableChipElevation$animateElevation$1$1(interactionSource2, snapshotStateList, (Continuation<? super SelectableChipElevation$animateElevation$1$1>) null);
            composer2.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.LaunchedEffect((Object) interactionSource2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue3, composer2, (i2 >> 3) & 14);
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
            f = this.elevation;
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -208015451, "CC(remember):Chip.kt#9igjgp");
        Object rememberedValue4 = composer2.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            Animatable animatable2 = new Animatable(Dp.m7109boximpl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(animatable2);
            rememberedValue4 = animatable2;
        }
        Animatable animatable3 = (Animatable) rememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Dp r9 = Dp.m7109boximpl(f);
        ComposerKt.sourceInformationMarkerStart(composer2, -208012300, "CC(remember):Chip.kt#9igjgp");
        boolean changedInstance = composer2.changedInstance(animatable3) | composer2.changed(f);
        if ((((i2 & 14) ^ 6) <= 4 || !composer2.changed(z2)) && (i2 & 6) != 4) {
            z3 = false;
        }
        boolean changedInstance2 = changedInstance | z3 | composer2.changedInstance(interaction);
        Object rememberedValue5 = composer2.rememberedValue();
        if (changedInstance2 || rememberedValue5 == Composer.Companion.getEmpty()) {
            animatable = animatable3;
            rememberedValue5 = new SelectableChipElevation$animateElevation$2$1(animatable, f, z2, interaction, mutableState, (Continuation<? super SelectableChipElevation$animateElevation$2$1>) null);
            composer2.updateRememberedValue(rememberedValue5);
        } else {
            animatable = animatable3;
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.LaunchedEffect((Object) r9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue5, composer2, 0);
        State<Dp> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return asState;
    }

    /* access modifiers changed from: private */
    public static final Interaction animateElevation$lambda$2(MutableState<Interaction> mutableState) {
        return (Interaction) mutableState.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SelectableChipElevation)) {
            return false;
        }
        SelectableChipElevation selectableChipElevation = (SelectableChipElevation) obj;
        return Dp.m7116equalsimpl0(this.elevation, selectableChipElevation.elevation) && Dp.m7116equalsimpl0(this.pressedElevation, selectableChipElevation.pressedElevation) && Dp.m7116equalsimpl0(this.focusedElevation, selectableChipElevation.focusedElevation) && Dp.m7116equalsimpl0(this.hoveredElevation, selectableChipElevation.hoveredElevation) && Dp.m7116equalsimpl0(this.disabledElevation, selectableChipElevation.disabledElevation);
    }

    public int hashCode() {
        return (((((((Dp.m7117hashCodeimpl(this.elevation) * 31) + Dp.m7117hashCodeimpl(this.pressedElevation)) * 31) + Dp.m7117hashCodeimpl(this.focusedElevation)) * 31) + Dp.m7117hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m7117hashCodeimpl(this.disabledElevation);
    }

    /* access modifiers changed from: private */
    public static final void animateElevation$lambda$3(MutableState<Interaction> mutableState, Interaction interaction) {
        mutableState.setValue(interaction);
    }
}
