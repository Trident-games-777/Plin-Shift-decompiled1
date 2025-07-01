package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.android.kt */
final class TextFieldSelectionState_androidKt$contextMenuBuilder$1 extends Lambda implements Function1<ContextMenuScope, Unit> {
    final /* synthetic */ ContextMenuState $state;
    final /* synthetic */ TextFieldSelectionState $this_contextMenuBuilder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState_androidKt$contextMenuBuilder$1(ContextMenuState contextMenuState, TextFieldSelectionState textFieldSelectionState) {
        super(1);
        this.$state = contextMenuState;
        this.$this_contextMenuBuilder = textFieldSelectionState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContextMenuScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContextMenuScope contextMenuScope) {
        ContextMenuState contextMenuState = this.$state;
        TextContextMenuItems textContextMenuItems = TextContextMenuItems.Cut;
        ContextMenuScope contextMenuScope2 = contextMenuScope;
        ContextMenuScope.item$default(contextMenuScope2, new ContextMenu_androidKt$TextItem$1(textContextMenuItems), (Modifier) null, this.$this_contextMenuBuilder.canCut(), (Function3) null, new TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$1(contextMenuState, this.$this_contextMenuBuilder), 10, (Object) null);
        ContextMenuState contextMenuState2 = this.$state;
        TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.Copy;
        ContextMenuScope contextMenuScope3 = contextMenuScope;
        ContextMenuScope.item$default(contextMenuScope3, new ContextMenu_androidKt$TextItem$1(textContextMenuItems2), (Modifier) null, this.$this_contextMenuBuilder.canCopy(), (Function3) null, new TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$2(contextMenuState2, this.$this_contextMenuBuilder), 10, (Object) null);
        ContextMenuState contextMenuState3 = this.$state;
        TextContextMenuItems textContextMenuItems3 = TextContextMenuItems.Paste;
        ContextMenuScope.item$default(contextMenuScope3, new ContextMenu_androidKt$TextItem$1(textContextMenuItems3), (Modifier) null, this.$this_contextMenuBuilder.canPaste(), (Function3) null, new TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$3(contextMenuState3, this.$this_contextMenuBuilder), 10, (Object) null);
        ContextMenuState contextMenuState4 = this.$state;
        TextContextMenuItems textContextMenuItems4 = TextContextMenuItems.SelectAll;
        ContextMenuScope.item$default(contextMenuScope3, new ContextMenu_androidKt$TextItem$1(textContextMenuItems4), (Modifier) null, this.$this_contextMenuBuilder.canSelectAll(), (Function3) null, new TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$4(contextMenuState4, this.$this_contextMenuBuilder), 10, (Object) null);
    }
}
