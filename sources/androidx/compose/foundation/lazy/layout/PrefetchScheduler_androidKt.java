package androidx.compose.foundation.lazy.layout;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberDefaultPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PrefetchScheduler.android.kt */
public final class PrefetchScheduler_androidKt {
    public static final PrefetchScheduler rememberDefaultPrefetchScheduler(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1141871251, "C(rememberDefaultPrefetchScheduler)32@1216L7,33@1235L61:PrefetchScheduler.android.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1141871251, i, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:31)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(composer);
        View view = (View) consume;
        ComposerKt.sourceInformationMarkerStart(composer, -930674095, "CC(remember):PrefetchScheduler.android.kt#9igjgp");
        boolean changed = composer.changed((Object) view);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new AndroidPrefetchScheduler(view);
            composer.updateRememberedValue(rememberedValue);
        }
        AndroidPrefetchScheduler androidPrefetchScheduler = (AndroidPrefetchScheduler) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidPrefetchScheduler;
    }
}
