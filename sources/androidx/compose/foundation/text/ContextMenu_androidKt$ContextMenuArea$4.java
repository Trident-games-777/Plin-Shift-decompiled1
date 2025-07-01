package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenu.android.kt */
final class ContextMenu_androidKt$ContextMenuArea$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ TextFieldSelectionState $selectionState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextMenu_androidKt$ContextMenuArea$4(TextFieldSelectionState textFieldSelectionState, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$selectionState = textFieldSelectionState;
        this.$enabled = z;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ContextMenu_androidKt.ContextMenuArea(this.$selectionState, this.$enabled, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
