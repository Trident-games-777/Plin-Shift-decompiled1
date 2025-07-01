package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBarImpl$surface$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Shape $animatedShape;
    final /* synthetic */ SearchBarColors $colors;
    final /* synthetic */ float $shadowElevation;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBarImpl$surface$1(Shape shape, SearchBarColors searchBarColors, float f, float f2) {
        super(2);
        this.$animatedShape = shape;
        this.$colors = searchBarColors;
        this.$tonalElevation = f;
        this.$shadowElevation = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C896@40320L38,893@40194L309:SearchBar.android.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-170534294, i, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.android.kt:893)");
            }
            SurfaceKt.m2536SurfaceT9BRK9s((Modifier) null, this.$animatedShape, this.$colors.m2395getContainerColor0d7_KjU(), ColorSchemeKt.m1886contentColorForek8zF_U(this.$colors.m2395getContainerColor0d7_KjU(), composer, 0), this.$tonalElevation, this.$shadowElevation, (BorderStroke) null, ComposableSingletons$SearchBar_androidKt.INSTANCE.m1936getLambda2$material3_release(), composer, 12582912, 65);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
