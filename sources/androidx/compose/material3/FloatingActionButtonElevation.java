package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0014\u0010\rJ\u0015\u0010\u0015\u001a\u00020\u0003H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation-D9Ej5fM$material3_release", "()F", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
public class FloatingActionButtonElevation {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public final float defaultElevation;
    /* access modifiers changed from: private */
    public final float focusedElevation;
    /* access modifiers changed from: private */
    public final float hoveredElevation;
    /* access modifiers changed from: private */
    public final float pressedElevation;

    public /* synthetic */ FloatingActionButtonElevation(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private FloatingActionButtonElevation(float f, float f2, float f3, float f4) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.focusedElevation = f3;
        this.hoveredElevation = f4;
    }

    public final State<Dp> shadowElevation$material3_release(InteractionSource interactionSource, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -424810125, "C(shadowElevation)517@24051L55:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-424810125, i, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:516)");
        }
        State<Dp> animateElevation = animateElevation(interactionSource, composer, i & WebSocketProtocol.PAYLOAD_SHORT);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateElevation;
    }

    /* renamed from: tonalElevation-D9Ej5fM$material3_release  reason: not valid java name */
    public final float m2094tonalElevationD9Ej5fM$material3_release() {
        return this.defaultElevation;
    }

    private final State<Dp> animateElevation(InteractionSource interactionSource, Composer composer, int i) {
        InteractionSource interactionSource2 = interactionSource;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -1845106002, "C(animateElevation)527@24330L345,536@24706L276,536@24685L297,545@25026L1282,545@24992L1316:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1845106002, i2, -1, "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:525)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 1492982391, "CC(remember):FloatingActionButton.kt#9igjgp");
        int i3 = i2 & 14;
        int i4 = i3 ^ 6;
        boolean z = false;
        boolean z2 = (i4 > 4 && composer2.changed((Object) interactionSource2)) || (i2 & 6) == 4;
        Object rememberedValue = composer2.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = new FloatingActionButtonElevationAnimatable(this.defaultElevation, this.pressedElevation, this.hoveredElevation, this.focusedElevation, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(floatingActionButtonElevationAnimatable);
            rememberedValue = floatingActionButtonElevationAnimatable;
        }
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable2 = (FloatingActionButtonElevationAnimatable) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, 1492994354, "CC(remember):FloatingActionButton.kt#9igjgp");
        boolean changedInstance = composer2.changedInstance(floatingActionButtonElevationAnimatable2) | ((((i2 & 112) ^ 48) > 32 && composer2.changed((Object) this)) || (i2 & 48) == 32);
        Object rememberedValue2 = composer2.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new FloatingActionButtonElevation$animateElevation$1$1(floatingActionButtonElevationAnimatable2, this, (Continuation<? super FloatingActionButtonElevation$animateElevation$1$1>) null);
            composer2.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.LaunchedEffect((Object) this, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer2, (i2 >> 3) & 14);
        ComposerKt.sourceInformationMarkerStart(composer2, 1493005600, "CC(remember):FloatingActionButton.kt#9igjgp");
        if ((i4 > 4 && composer2.changed((Object) interactionSource2)) || (i2 & 6) == 4) {
            z = true;
        }
        boolean changedInstance2 = composer2.changedInstance(floatingActionButtonElevationAnimatable2) | z;
        Object rememberedValue3 = composer2.rememberedValue();
        if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new FloatingActionButtonElevation$animateElevation$2$1(interactionSource2, floatingActionButtonElevationAnimatable2, (Continuation<? super FloatingActionButtonElevation$animateElevation$2$1>) null);
            composer2.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.LaunchedEffect((Object) interactionSource2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue3, composer2, i3);
        State<Dp> asState = floatingActionButtonElevationAnimatable2.asState();
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
        if (obj == null || !(obj instanceof FloatingActionButtonElevation)) {
            return false;
        }
        FloatingActionButtonElevation floatingActionButtonElevation = (FloatingActionButtonElevation) obj;
        if (Dp.m7116equalsimpl0(this.defaultElevation, floatingActionButtonElevation.defaultElevation) && Dp.m7116equalsimpl0(this.pressedElevation, floatingActionButtonElevation.pressedElevation) && Dp.m7116equalsimpl0(this.focusedElevation, floatingActionButtonElevation.focusedElevation)) {
            return Dp.m7116equalsimpl0(this.hoveredElevation, floatingActionButtonElevation.hoveredElevation);
        }
        return false;
    }

    public int hashCode() {
        return (((((Dp.m7117hashCodeimpl(this.defaultElevation) * 31) + Dp.m7117hashCodeimpl(this.pressedElevation)) * 31) + Dp.m7117hashCodeimpl(this.focusedElevation)) * 31) + Dp.m7117hashCodeimpl(this.hoveredElevation);
    }
}
