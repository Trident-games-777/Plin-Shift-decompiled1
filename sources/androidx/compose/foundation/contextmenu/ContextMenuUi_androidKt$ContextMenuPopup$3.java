package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenuUi.android.kt */
final class ContextMenuUi_androidKt$ContextMenuPopup$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ ContextMenuColors $colors;
    final /* synthetic */ Function1<ContextMenuScope, Unit> $contextMenuBuilderBlock;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ PopupPositionProvider $popupPositionProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextMenuUi_androidKt$ContextMenuPopup$3(PopupPositionProvider popupPositionProvider, Function0<Unit> function0, Modifier modifier, ContextMenuColors contextMenuColors, Function1<? super ContextMenuScope, Unit> function1, int i, int i2) {
        super(2);
        this.$popupPositionProvider = popupPositionProvider;
        this.$onDismiss = function0;
        this.$modifier = modifier;
        this.$colors = contextMenuColors;
        this.$contextMenuBuilderBlock = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ContextMenuUi_androidKt.ContextMenuPopup(this.$popupPositionProvider, this.$onDismiss, this.$modifier, this.$colors, this.$contextMenuBuilderBlock, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
