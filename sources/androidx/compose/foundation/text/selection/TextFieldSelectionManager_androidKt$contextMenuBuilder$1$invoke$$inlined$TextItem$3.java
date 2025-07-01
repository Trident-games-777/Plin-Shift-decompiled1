package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "androidx/compose/foundation/text/ContextMenu_androidKt$TextItem$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenu.android.kt */
public final class TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ContextMenuState $state;
    final /* synthetic */ TextFieldSelectionManager $this_contextMenuBuilder$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$3(ContextMenuState contextMenuState, TextFieldSelectionManager textFieldSelectionManager) {
        super(0);
        this.$state = contextMenuState;
        this.$this_contextMenuBuilder$inlined = textFieldSelectionManager;
    }

    public final void invoke() {
        this.$this_contextMenuBuilder$inlined.paste$foundation_release();
        ContextMenuState_androidKt.close(this.$state);
    }
}
