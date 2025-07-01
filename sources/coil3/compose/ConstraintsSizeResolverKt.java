package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberConstraintsSizeResolver", "Lcoil3/compose/ConstraintsSizeResolver;", "(Landroidx/compose/runtime/Composer;I)Lcoil3/compose/ConstraintsSizeResolver;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: ConstraintsSizeResolver.kt */
public final class ConstraintsSizeResolverKt {
    public static final ConstraintsSizeResolver rememberConstraintsSizeResolver(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-34261202, i, -1, "coil3.compose.rememberConstraintsSizeResolver (ConstraintsSizeResolver.kt:21)");
        }
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ConstraintsSizeResolver();
            composer.updateRememberedValue(rememberedValue);
        }
        ConstraintsSizeResolver constraintsSizeResolver = (ConstraintsSizeResolver) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return constraintsSizeResolver;
    }
}
