package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MaterialTheme.kt */
final class MaterialThemeKt$MaterialExpressiveTheme$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ColorScheme $colorScheme;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Shapes $shapes;
    final /* synthetic */ Typography $typography;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MaterialThemeKt$MaterialExpressiveTheme$1(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$colorScheme = colorScheme;
        this.$shapes = shapes;
        this.$typography = typography;
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2 = i;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C143@6152L388:MaterialTheme.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2050809758, i2, -1, "androidx.compose.material3.MaterialExpressiveTheme.<anonymous> (MaterialTheme.kt:143)");
            }
            ColorScheme colorScheme = this.$colorScheme;
            if (colorScheme == null) {
                colorScheme = ColorSchemeKt.expressiveLightColorScheme();
            }
            ColorScheme colorScheme2 = colorScheme;
            Shapes shapes = this.$shapes;
            Shapes shapes2 = shapes == null ? new Shapes((CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, 31, (DefaultConstructorMarker) null) : shapes;
            Typography typography = this.$typography;
            MaterialThemeKt.MaterialTheme(colorScheme2, shapes2, typography == null ? new Typography((TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, LayoutKt.LargeDimension, (DefaultConstructorMarker) null) : typography, this.$content, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
