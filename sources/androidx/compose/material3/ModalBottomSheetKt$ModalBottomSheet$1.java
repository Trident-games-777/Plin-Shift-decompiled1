package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$ModalBottomSheet$1 extends Lambda implements Function2<Composer, Integer, WindowInsets> {
    public static final ModalBottomSheetKt$ModalBottomSheet$1 INSTANCE = new ModalBottomSheetKt$ModalBottomSheet$1();

    ModalBottomSheetKt$ModalBottomSheet$1() {
        super(2);
    }

    public final WindowInsets invoke(Composer composer, int i) {
        composer.startReplaceGroup(58488196);
        ComposerKt.sourceInformation(composer, "C129@6530L12:ModalBottomSheet.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(58488196, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:129)");
        }
        WindowInsets windowInsets = BottomSheetDefaults.INSTANCE.getWindowInsets(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return windowInsets;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((Composer) obj, ((Number) obj2).intValue());
    }
}
