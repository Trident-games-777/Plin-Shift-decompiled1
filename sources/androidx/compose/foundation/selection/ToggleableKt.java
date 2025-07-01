package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000¢\u0006\u0002\b\u000e\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000¢\u0006\u0002\b\u000f\u001aR\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000¢\u0006\u0002\b\u0015\u001a>\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000¢\u0006\u0002\b\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"toggleable", "Landroidx/compose/ui/Modifier;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "toggleable-O2vRcR0", "toggleable-XHw0xAI", "triStateToggleable", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "triStateToggleable-O2vRcR0", "triStateToggleable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Toggleable.kt */
public final class ToggleableKt {
    /* renamed from: toggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1116toggleableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1115toggleableXHw0xAI(modifier, z, z2, role, function1);
    }

    /* renamed from: toggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1114toggleableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            role = null;
        }
        return m1113toggleableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, role, function1);
    }

    /* renamed from: triStateToggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1120triStateToggleableXHw0xAI$default(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1119triStateToggleableXHw0xAI(modifier, toggleableState, z, role, function0);
    }

    /* renamed from: triStateToggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1118triStateToggleableO2vRcR0$default(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            role = null;
        }
        return m1117triStateToggleableO2vRcR0(modifier, toggleableState, mutableInteractionSource, indication, z2, role, function0);
    }

    /* renamed from: toggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m1115toggleableXHw0xAI(Modifier modifier, boolean z, boolean z2, Role role, Function1<? super Boolean, Unit> function1) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1(z, z2, role, function1) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$toggleable$2(z, z2, role, function1));
    }

    /* renamed from: toggleable-O2vRcR0  reason: not valid java name */
    public static final Modifier m1113toggleableO2vRcR0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function1<? super Boolean, Unit> function1) {
        Modifier modifier2;
        if (indication instanceof IndicationNodeFactory) {
            modifier2 = new ToggleableElement(z, mutableInteractionSource, (IndicationNodeFactory) indication, z2, role, function1, (DefaultConstructorMarker) null);
        } else if (indication == null) {
            modifier2 = new ToggleableElement(z, mutableInteractionSource, (IndicationNodeFactory) null, z2, role, function1, (DefaultConstructorMarker) null);
        } else if (mutableInteractionSource != null) {
            modifier2 = IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication).then(new ToggleableElement(z, mutableInteractionSource, (IndicationNodeFactory) null, z2, role, function1, (DefaultConstructorMarker) null));
        } else {
            modifier2 = ComposedModifierKt.composed$default(Modifier.Companion, (Function1) null, new ToggleableKt$toggleableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(indication, z, z2, role, function1), 1, (Object) null);
        }
        return modifier.then(modifier2);
    }

    /* renamed from: triStateToggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m1119triStateToggleableXHw0xAI(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, Function0<Unit> function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableXHw0xAI$$inlined$debugInspectorInfo$1(toggleableState, z, role, function0) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$triStateToggleable$2(toggleableState, z, role, function0));
    }

    /* renamed from: triStateToggleable-O2vRcR0  reason: not valid java name */
    public static final Modifier m1117triStateToggleableO2vRcR0(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, Function0<Unit> function0) {
        Modifier modifier2;
        if (indication instanceof IndicationNodeFactory) {
            modifier2 = new TriStateToggleableElement(toggleableState, mutableInteractionSource, (IndicationNodeFactory) indication, z, role, function0, (DefaultConstructorMarker) null);
        } else if (indication == null) {
            modifier2 = new TriStateToggleableElement(toggleableState, mutableInteractionSource, (IndicationNodeFactory) null, z, role, function0, (DefaultConstructorMarker) null);
        } else if (mutableInteractionSource != null) {
            modifier2 = IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication).then(new TriStateToggleableElement(toggleableState, mutableInteractionSource, (IndicationNodeFactory) null, z, role, function0, (DefaultConstructorMarker) null));
        } else {
            modifier2 = ComposedModifierKt.composed$default(Modifier.Companion, (Function1) null, new ToggleableKt$triStateToggleableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(indication, toggleableState, z, role, function0), 1, (Object) null);
        }
        return modifier.then(modifier2);
    }
}
