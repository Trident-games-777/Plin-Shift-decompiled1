package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"dropUnlessResumed", "Lkotlin/Function0;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "block", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function0;", "dropUnlessStarted", "dropUnlessStateIsAtLeast", "state", "Landroidx/lifecycle/Lifecycle$State;", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function0;", "lifecycle-runtime-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DropUnlessLifecycle.kt */
public final class DropUnlessLifecycleKt {
    private static final Function0<Unit> dropUnlessStateIsAtLeast(Lifecycle.State state, LifecycleOwner lifecycleOwner, Function0<Unit> function0, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2057956404, "C(dropUnlessStateIsAtLeast)P(2,1)48@1927L7,56@2225L107:DropUnlessLifecycle.kt#2vxrgp");
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(composer);
            lifecycleOwner = (LifecycleOwner) consume;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2057956404, i, -1, "androidx.lifecycle.compose.dropUnlessStateIsAtLeast (DropUnlessLifecycle.kt:50)");
        }
        if (state != Lifecycle.State.DESTROYED) {
            ComposerKt.sourceInformationMarkerStart(composer, 565432844, "CC(remember):DropUnlessLifecycle.kt#9igjgp");
            boolean z = false;
            boolean changedInstance = composer.changedInstance(lifecycleOwner) | ((((i & 14) ^ 6) > 4 && composer.changed((Object) state)) || (i & 6) == 4);
            if ((((i & 896) ^ 384) > 256 && composer.changed((Object) function0)) || (i & 384) == 256) {
                z = true;
            }
            boolean z2 = changedInstance | z;
            Object rememberedValue = composer.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DropUnlessLifecycleKt$dropUnlessStateIsAtLeast$2$1(lifecycleOwner, state, function0);
                composer.updateRememberedValue(rememberedValue);
            }
            Function0<Unit> function02 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function02;
        }
        throw new IllegalArgumentException("Target state is not allowed to be `Lifecycle.State.DESTROYED` because Compose disposes of the composition before `Lifecycle.Event.ON_DESTROY` observers are invoked.".toString());
    }

    public static final Function0<Unit> dropUnlessStarted(LifecycleOwner lifecycleOwner, Function0<Unit> function0, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1207869935, "C(dropUnlessStarted)P(1)80@3057L7,82@3105L62:DropUnlessLifecycle.kt#2vxrgp");
        if ((i2 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(composer);
            lifecycleOwner = (LifecycleOwner) consume;
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1207869935, i, -1, "androidx.lifecycle.compose.dropUnlessStarted (DropUnlessLifecycle.kt:82)");
        }
        int i3 = i << 3;
        Composer composer2 = composer;
        Function0<Unit> dropUnlessStateIsAtLeast = dropUnlessStateIsAtLeast(Lifecycle.State.STARTED, lifecycleOwner2, function0, composer2, (i3 & 112) | 6 | (i3 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return dropUnlessStateIsAtLeast;
    }

    public static final Function0<Unit> dropUnlessResumed(LifecycleOwner lifecycleOwner, Function0<Unit> function0, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1331131589, "C(dropUnlessResumed)P(1)104@4047L7,106@4095L62:DropUnlessLifecycle.kt#2vxrgp");
        if ((i2 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(composer);
            lifecycleOwner = (LifecycleOwner) consume;
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1331131589, i, -1, "androidx.lifecycle.compose.dropUnlessResumed (DropUnlessLifecycle.kt:106)");
        }
        int i3 = i << 3;
        Composer composer2 = composer;
        Function0<Unit> dropUnlessStateIsAtLeast = dropUnlessStateIsAtLeast(Lifecycle.State.RESUMED, lifecycleOwner2, function0, composer2, (i3 & 112) | 6 | (i3 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return dropUnlessStateIsAtLeast;
    }
}
