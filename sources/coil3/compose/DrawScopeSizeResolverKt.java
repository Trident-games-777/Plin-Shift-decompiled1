package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\b\u0010\u0003\u001a\u00020\u0001H\u0007¨\u0006\u0004"}, d2 = {"rememberDrawScopeSizeResolver", "Lcoil3/compose/DrawScopeSizeResolver;", "(Landroidx/compose/runtime/Composer;I)Lcoil3/compose/DrawScopeSizeResolver;", "DrawScopeSizeResolver", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: DrawScopeSizeResolver.kt */
public final class DrawScopeSizeResolverKt {
    public static final DrawScopeSizeResolver rememberDrawScopeSizeResolver(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2057132148, i, -1, "coil3.compose.rememberDrawScopeSizeResolver (DrawScopeSizeResolver.kt:26)");
        }
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = DrawScopeSizeResolver();
            composer.updateRememberedValue(rememberedValue);
        }
        DrawScopeSizeResolver drawScopeSizeResolver = (DrawScopeSizeResolver) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return drawScopeSizeResolver;
    }

    public static final DrawScopeSizeResolver DrawScopeSizeResolver() {
        return new RealDrawScopeSizeResolver();
    }
}
