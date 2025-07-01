package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001ax\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\b\u0012\u001aV\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\b\u0017\u001aB\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\b\u0018\u001aA\u0010\u0019\u001a\u00020\u0014*\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001e\b\u0004\u0010\u001a\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00140\u001bH\b\u001a\u0001\u0010\u001c\u001a\u00020\u0014*\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\b\u001d\u001at\u0010\u001c\u001a\u00020\u0014*\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\b\u001e\u001a\u0001\u0010\u001f\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\b)\u001a\f\u0010*\u001a\u00020\u000e*\u00020+H\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"CombinedClickableNode", "Landroidx/compose/foundation/CombinedClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "CombinedClickableNode-nSzSaCc", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "clickable-O2vRcR0", "clickable-XHw0xAI", "clickableWithIndicationIfNeeded", "createClickable", "Lkotlin/Function2;", "combinedClickable", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-Kqv-Bsg", "hasScrollableContainer", "Landroidx/compose/ui/node/TraversableNode;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
public final class ClickableKt {
    /* renamed from: clickable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m281clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m280clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* renamed from: clickable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m279clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return m278clickableO2vRcR0(modifier, mutableInteractionSource, indication, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : role, function0);
    }

    /* renamed from: combinedClickable-cJG_KMw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m285combinedClickablecJG_KMw$default(Modifier modifier, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        Function0 function04;
        Function0 function05;
        Function0 function06;
        String str3;
        Role role2;
        String str4;
        Modifier modifier2;
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function0 = null;
        }
        if ((i & 32) != 0) {
            function05 = null;
            str3 = str2;
            function04 = function03;
            str4 = str;
            function06 = function0;
            modifier2 = modifier;
            role2 = role;
        } else {
            function05 = function02;
            function04 = function03;
            str3 = str2;
            function06 = function0;
            str4 = str;
            role2 = role;
            modifier2 = modifier;
        }
        return m284combinedClickablecJG_KMw(modifier2, z, str4, role2, str3, function06, function05, function04);
    }

    /* renamed from: combinedClickable-XVZzFYc$default  reason: not valid java name */
    public static /* synthetic */ Modifier m283combinedClickableXVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        Function0 function04;
        Function0 function05;
        Indication indication2;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier2;
        int i2 = i;
        if ((i2 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        String str3 = (i2 & 8) != 0 ? null : str;
        Role role2 = (i2 & 16) != 0 ? null : role;
        String str4 = (i2 & 32) != 0 ? null : str2;
        Function0 function06 = (i2 & 64) != 0 ? null : function0;
        if ((i2 & 128) != 0) {
            function05 = null;
            modifier2 = modifier;
            indication2 = indication;
            function04 = function03;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            function05 = function02;
            modifier2 = modifier;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            function04 = function03;
        }
        return m282combinedClickableXVZzFYc(modifier2, mutableInteractionSource2, indication2, z2, str3, role2, str4, function06, function05, function04);
    }

    public static final Modifier clickableWithIndicationIfNeeded(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, Function2<? super MutableInteractionSource, ? super IndicationNodeFactory, ? extends Modifier> function2) {
        Modifier modifier2;
        if (indication instanceof IndicationNodeFactory) {
            modifier2 = (Modifier) function2.invoke(mutableInteractionSource, indication);
        } else if (indication == null) {
            modifier2 = (Modifier) function2.invoke(mutableInteractionSource, null);
        } else if (mutableInteractionSource != null) {
            modifier2 = IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication).then((Modifier) function2.invoke(mutableInteractionSource, null));
        } else {
            modifier2 = ComposedModifierKt.composed$default(Modifier.Companion, (Function1) null, new ClickableKt$clickableWithIndicationIfNeeded$1(indication, function2), 1, (Object) null);
        }
        return modifier.then(modifier2);
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg$default  reason: not valid java name */
    public static /* synthetic */ Modifier m287genericClickableWithoutGestureKqvBsg$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map map, State state, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, int i, Object obj) {
        Function0 function03;
        Function0 function04;
        State state2;
        Map map2;
        CoroutineScope coroutineScope2;
        Indication indication2;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier2;
        int i2 = i;
        boolean z2 = (i2 & 32) != 0 ? true : z;
        String str3 = (i2 & 64) != 0 ? null : str;
        Role role2 = (i2 & 128) != 0 ? null : role;
        String str4 = (i2 & 256) != 0 ? null : str2;
        if ((i2 & 512) != 0) {
            function04 = null;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            coroutineScope2 = coroutineScope;
            map2 = map;
            state2 = state;
            function03 = function02;
            modifier2 = modifier;
        } else {
            function04 = function0;
            modifier2 = modifier;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            coroutineScope2 = coroutineScope;
            map2 = map;
            state2 = state;
            function03 = function02;
        }
        return m286genericClickableWithoutGestureKqvBsg(modifier2, mutableInteractionSource2, indication2, coroutineScope2, map2, state2, z2, str3, role2, str4, function04, function03);
    }

    private static final Modifier genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(Modifier modifier, boolean z, Map<Key, PressInteraction.Press> map, State<Offset> state, CoroutineScope coroutineScope, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifierKt.onKeyEvent(modifier, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1(z, map, state, coroutineScope, function0, mutableInteractionSource));
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg  reason: not valid java name */
    public static final Modifier m286genericClickableWithoutGestureKqvBsg(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map<Key, PressInteraction.Press> map, State<Offset> state, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02) {
        boolean z2 = z;
        return modifier.then(FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(new ClickableSemanticsElement(z2, role, str2, function0, str, function02, (DefaultConstructorMarker) null), z2, map, state, coroutineScope, function02, mutableInteractionSource), mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource));
    }

    /* renamed from: CombinedClickableNode-nSzSaCc  reason: not valid java name */
    public static final CombinedClickableNode m277CombinedClickableNodenSzSaCc(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str2, Role role) {
        return new CombinedClickableNodeImpl(function0, str, function02, function03, mutableInteractionSource, indicationNodeFactory, z, str2, role, (DefaultConstructorMarker) null);
    }

    public static final boolean hasScrollableContainer(TraversableNode traversableNode) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TraversableNodeKt.traverseAncestors(traversableNode, ScrollableContainerNode.TraverseKey, new ClickableKt$hasScrollableContainer$1(booleanRef));
        return booleanRef.element;
    }

    /* renamed from: clickable-XHw0xAI  reason: not valid java name */
    public static final Modifier m280clickableXHw0xAI(Modifier modifier, boolean z, String str, Role role, Function0<Unit> function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(z, str, role, function0) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$2(z, str, role, function0));
    }

    /* renamed from: clickable-O2vRcR0  reason: not valid java name */
    public static final Modifier m278clickableO2vRcR0(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0<Unit> function0) {
        return modifier.then(indication instanceof IndicationNodeFactory ? new ClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, z, str, role, function0, (DefaultConstructorMarker) null) : indication == null ? new ClickableElement(mutableInteractionSource, (IndicationNodeFactory) null, z, str, role, function0, (DefaultConstructorMarker) null) : mutableInteractionSource != null ? IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication).then(new ClickableElement(mutableInteractionSource, (IndicationNodeFactory) null, z, str, role, function0, (DefaultConstructorMarker) null)) : ComposedModifierKt.composed$default(Modifier.Companion, (Function1) null, new ClickableKt$clickableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(indication, z, str, role, function0), 1, (Object) null));
    }

    /* renamed from: combinedClickable-cJG_KMw  reason: not valid java name */
    public static final Modifier m284combinedClickablecJG_KMw(Modifier modifier, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Function1<InspectorInfo, Unit> function1;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            Function0<Unit> function04 = function02;
            Function0<Unit> function05 = function03;
            function1 = new ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(z, str, role, function05, function04, function0, str2);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new ClickableKt$combinedClickable$2(z, str, role, str2, function0, function02, function03));
    }

    /* renamed from: combinedClickable-XVZzFYc  reason: not valid java name */
    public static final Modifier m282combinedClickableXVZzFYc(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Modifier modifier2;
        if (indication instanceof IndicationNodeFactory) {
            modifier2 = new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, z, str, role, function03, str2, function0, function02, (DefaultConstructorMarker) null);
        } else if (indication == null) {
            modifier2 = new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) null, z, str, role, function03, str2, function0, function02, (DefaultConstructorMarker) null);
        } else if (mutableInteractionSource != null) {
            modifier2 = IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication).then(new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) null, z, str, role, function03, str2, function0, function02, (DefaultConstructorMarker) null));
        } else {
            modifier2 = ComposedModifierKt.composed$default(Modifier.Companion, (Function1) null, new ClickableKt$combinedClickableXVZzFYc$$inlined$clickableWithIndicationIfNeeded$1(indication, z, str, role, function03, str2, function0, function02), 1, (Object) null);
        }
        return modifier.then(modifier2);
    }
}
