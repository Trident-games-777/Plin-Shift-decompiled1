package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: coil3.compose.ComposableSingletons$SubcomposeAsyncImageKt$lambda-1$1  reason: invalid class name */
/* compiled from: SubcomposeAsyncImage.kt */
final class ComposableSingletons$SubcomposeAsyncImageKt$lambda1$1 implements Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$SubcomposeAsyncImageKt$lambda1$1 INSTANCE = new ComposableSingletons$SubcomposeAsyncImageKt$lambda1$1();

    ComposableSingletons$SubcomposeAsyncImageKt$lambda1$1() {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SubcomposeAsyncImageScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
        int i2;
        if ((i & 6) == 0) {
            i2 = i | (composer.changed((Object) subcomposeAsyncImageScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1938077476, i2, -1, "coil3.compose.ComposableSingletons$SubcomposeAsyncImageKt.lambda-1.<anonymous> (SubcomposeAsyncImage.kt:313)");
            }
            SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, (Modifier) null, (Painter) null, (String) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, false, composer, i2 & 14, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
