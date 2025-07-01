package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "colors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "invoke", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenuUi.android.kt */
final class ContextMenuScope$item$1 extends Lambda implements Function3<ContextMenuColors, Composer, Integer, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, String> $label;
    final /* synthetic */ Function3<Color, Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextMenuScope$item$1(Function2<? super Composer, ? super Integer, String> function2, boolean z, Modifier modifier, Function3<? super Color, ? super Composer, ? super Integer, Unit> function3, Function0<Unit> function0) {
        super(3);
        this.$label = function2;
        this.$enabled = z;
        this.$modifier = modifier;
        this.$leadingIcon = function3;
        this.$onClick = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ContextMenuColors) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ContextMenuColors contextMenuColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C275@10323L7,277@10419L251:ContextMenuUi.android.kt#3xeu6s");
        if ((i & 6) == 0) {
            i |= composer.changed((Object) contextMenuColors) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(262103052, i, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.item.<anonymous> (ContextMenuUi.android.kt:275)");
            }
            String invoke = this.$label.invoke(composer, 0);
            if (!StringsKt.isBlank(invoke)) {
                ContextMenuUi_androidKt.ContextMenuItem(invoke, this.$enabled, contextMenuColors, this.$modifier, this.$leadingIcon, this.$onClick, composer, (i << 6) & 896, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Label must not be blank".toString());
        }
        composer.skipToGroupEnd();
    }
}
