package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidOverscroll.android.kt */
public final class AndroidOverscroll_androidKt {
    public static final OverscrollEffect rememberOverscrollEffect(Composer composer, int i) {
        OverscrollEffect overscrollEffect;
        ComposerKt.sourceInformationMarkerStart(composer, -1476348564, "C(rememberOverscrollEffect)64@2834L7,65@2888L7:AndroidOverscroll.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1476348564, i, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.android.kt:63)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) consume2;
        if (overscrollConfiguration != null) {
            composer.startReplaceGroup(1586021609);
            ComposerKt.sourceInformation(composer, "67@2937L80");
            ComposerKt.sourceInformationMarkerStart(composer, 1852277609, "CC(remember):AndroidOverscroll.android.kt#9igjgp");
            boolean changed = composer.changed((Object) context) | composer.changed((Object) overscrollConfiguration);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AndroidEdgeEffectOverscrollEffect(context, overscrollConfiguration);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
            overscrollEffect = (AndroidEdgeEffectOverscrollEffect) rememberedValue;
        } else {
            composer.startReplaceGroup(1586120933);
            composer.endReplaceGroup();
            overscrollEffect = NoOpOverscrollEffect.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return overscrollEffect;
    }
}
