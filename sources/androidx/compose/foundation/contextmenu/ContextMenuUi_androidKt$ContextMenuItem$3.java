package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenuUi.android.kt */
final class ContextMenuUi_androidKt$ContextMenuItem$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ ContextMenuColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ String $label;
    final /* synthetic */ Function3<Color, Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextMenuUi_androidKt$ContextMenuItem$3(String str, boolean z, ContextMenuColors contextMenuColors, Modifier modifier, Function3<? super Color, ? super Composer, ? super Integer, Unit> function3, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$label = str;
        this.$enabled = z;
        this.$colors = contextMenuColors;
        this.$modifier = modifier;
        this.$leadingIcon = function3;
        this.$onClick = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ContextMenuUi_androidKt.ContextMenuItem(this.$label, this.$enabled, this.$colors, this.$modifier, this.$leadingIcon, this.$onClick, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
