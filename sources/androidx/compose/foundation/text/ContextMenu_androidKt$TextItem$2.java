package androidx.compose.foundation.text;

import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: ContextMenu.android.kt */
public final class ContextMenu_androidKt$TextItem$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $operation;
    final /* synthetic */ ContextMenuState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextMenu_androidKt$TextItem$2(Function0<Unit> function0, ContextMenuState contextMenuState) {
        super(0);
        this.$operation = function0;
        this.$state = contextMenuState;
    }

    public final void invoke() {
        this.$operation.invoke();
        ContextMenuState_androidKt.close(this.$state);
    }
}
