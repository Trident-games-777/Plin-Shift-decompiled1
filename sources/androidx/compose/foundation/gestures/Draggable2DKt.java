package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0001H\u0007\u001a!\u0010\u0015\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0001H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0001\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001b2#\b\u0002\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012#\b\u0002\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u00012\b\b\u0002\u0010!\u001a\u00020\u001bH\u0007\u001aÃ\u0001\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001b2>\b\u0002\u0010\u001f\u001a8\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\f2>\b\u0002\u0010 \u001a8\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\f2\b\b\u0002\u0010!\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\"\")\u0010\u0000\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000\"F\u0010\u0007\u001a8\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fX\u0004¢\u0006\u0004\n\u0002\u0010\r\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000\"F\u0010\u0011\u001a8\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fX\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006#"}, d2 = {"NoOpOnDragStart", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "", "NoOpOnDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "NoOpOnDragStop", "Landroidx/compose/ui/unit/Velocity;", "velocity", "NoOpOnDragStopped", "Draggable2DState", "Landroidx/compose/foundation/gestures/Draggable2DState;", "onDelta", "rememberDraggable2DState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/Draggable2DState;", "draggable2D", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "onDragStopped", "reverseDirection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/Draggable2DState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable2D.kt */
public final class Draggable2DKt {
    /* access modifiers changed from: private */
    public static final Function1<Offset, Unit> NoOpOnDragStart = Draggable2DKt$NoOpOnDragStart$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> NoOpOnDragStarted = new Draggable2DKt$NoOpOnDragStarted$1((Continuation<? super Draggable2DKt$NoOpOnDragStarted$1>) null);
    /* access modifiers changed from: private */
    public static final Function1<Velocity, Unit> NoOpOnDragStop = Draggable2DKt$NoOpOnDragStop$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> NoOpOnDragStopped = new Draggable2DKt$NoOpOnDragStopped$1((Continuation<? super Draggable2DKt$NoOpOnDragStopped$1>) null);

    public static final Draggable2DState Draggable2DState(Function1<? super Offset, Unit> function1) {
        return new DefaultDraggable2DState(function1);
    }

    public static final Draggable2DState rememberDraggable2DState(Function1<? super Offset, Unit> function1, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1150277615, "C(rememberDraggable2DState)121@4913L29,122@4954L63:Draggable2D.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1150277615, i, -1, "androidx.compose.foundation.gestures.rememberDraggable2DState (Draggable2D.kt:120)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, -428493944, "CC(remember):Draggable2D.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = Draggable2DState(new Draggable2DKt$rememberDraggable2DState$1$1(rememberUpdatedState));
            composer.updateRememberedValue(rememberedValue);
        }
        Draggable2DState draggable2DState = (Draggable2DState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return draggable2DState;
    }

    public static /* synthetic */ Modifier draggable2D$default(Modifier modifier, Draggable2DState draggable2DState, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function1 function1, Function1 function12, boolean z3, int i, Object obj) {
        Function1 function13;
        boolean z4 = (i & 2) != 0 ? true : z;
        MutableInteractionSource mutableInteractionSource2 = (i & 4) != 0 ? null : mutableInteractionSource;
        boolean z5 = (i & 8) != 0 ? false : z2;
        Function1 function14 = (i & 16) != 0 ? NoOpOnDragStart : function1;
        if ((i & 32) != 0) {
            function13 = NoOpOnDragStop;
        } else {
            function13 = function12;
        }
        return draggable2D(modifier, draggable2DState, z4, mutableInteractionSource2, z5, (Function1<? super Offset, Unit>) function14, (Function1<? super Velocity, Unit>) function13, (i & 64) != 0 ? false : z3);
    }

    public static final Modifier draggable2D(Modifier modifier, Draggable2DState draggable2DState, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function1<? super Offset, Unit> function1, Function1<? super Velocity, Unit> function12, boolean z3) {
        return modifier.then(new Draggable2DElement(draggable2DState, z, mutableInteractionSource, z2, function1, function12, z3));
    }

    public static /* synthetic */ Modifier draggable2D$default(Modifier modifier, Draggable2DState draggable2DState, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3 function3, Function3 function32, boolean z3, int i, Object obj) {
        Function3 function33;
        boolean z4 = (i & 2) != 0 ? true : z;
        MutableInteractionSource mutableInteractionSource2 = (i & 4) != 0 ? null : mutableInteractionSource;
        boolean z5 = (i & 8) != 0 ? false : z2;
        Function3 function34 = (i & 16) != 0 ? NoOpOnDragStarted : function3;
        if ((i & 32) != 0) {
            function33 = NoOpOnDragStopped;
        } else {
            function33 = function32;
        }
        return modifier.then(new Draggable2DCompatElement(draggable2DState, z4, mutableInteractionSource2, z5, function34, function33, (i & 64) != 0 ? false : z3));
    }
}
