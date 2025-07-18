package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"collectIsDraggedAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragInteraction.kt */
public final class DragInteractionKt {
    public static final State<Boolean> collectIsDraggedAsState(InteractionSource interactionSource, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 101276833, "C(collectIsDraggedAsState)80@2766L34,81@2826L492,81@2805L513:DragInteraction.kt#ywyzhk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(101276833, i, -1, "androidx.compose.foundation.interaction.collectIsDraggedAsState (DragInteraction.kt:79)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1150053971, "CC(remember):DragInteraction.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        boolean z = false;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1150051593, "CC(remember):DragInteraction.kt#9igjgp");
        int i2 = i & 14;
        if (((i2 ^ 6) > 4 && composer.changed((Object) interactionSource)) || (i & 6) == 4) {
            z = true;
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new DragInteractionKt$collectIsDraggedAsState$1$1(interactionSource, mutableState, (Continuation<? super DragInteractionKt$collectIsDraggedAsState$1$1>) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect((Object) interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer, i2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState;
    }
}
