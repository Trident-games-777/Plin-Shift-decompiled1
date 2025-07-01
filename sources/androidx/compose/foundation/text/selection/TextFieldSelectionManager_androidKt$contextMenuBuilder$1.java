package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.android.kt */
final class TextFieldSelectionManager_androidKt$contextMenuBuilder$1 extends Lambda implements Function1<ContextMenuScope, Unit> {
    final /* synthetic */ ContextMenuState $contextMenuState;
    final /* synthetic */ TextFieldSelectionManager $this_contextMenuBuilder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager_androidKt$contextMenuBuilder$1(TextFieldSelectionManager textFieldSelectionManager, ContextMenuState contextMenuState) {
        super(1);
        this.$this_contextMenuBuilder = textFieldSelectionManager;
        this.$contextMenuState = contextMenuState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContextMenuScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContextMenuScope contextMenuScope) {
        ClipboardManager clipboardManager$foundation_release;
        boolean z = this.$this_contextMenuBuilder.getVisualTransformation$foundation_release() instanceof PasswordVisualTransformation;
        boolean r2 = TextRange.m6558getCollapsedimpl(this.$this_contextMenuBuilder.getValue$foundation_release().m6823getSelectiond9O1mEE());
        ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(TextContextMenuItems.Cut), (Modifier) null, !r2 && this.$this_contextMenuBuilder.getEditable() && !z, (Function3) null, new TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$1(this.$contextMenuState, this.$this_contextMenuBuilder), 10, (Object) null);
        ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(TextContextMenuItems.Copy), (Modifier) null, !r2 && !z, (Function3) null, new TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$2(this.$contextMenuState, this.$this_contextMenuBuilder), 10, (Object) null);
        ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(TextContextMenuItems.Paste), (Modifier) null, this.$this_contextMenuBuilder.getEditable() && (clipboardManager$foundation_release = this.$this_contextMenuBuilder.getClipboardManager$foundation_release()) != null && clipboardManager$foundation_release.hasText(), (Function3) null, new TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$3(this.$contextMenuState, this.$this_contextMenuBuilder), 10, (Object) null);
        ContextMenuState contextMenuState = this.$contextMenuState;
        ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(TextContextMenuItems.SelectAll), (Modifier) null, TextRange.m6560getLengthimpl(this.$this_contextMenuBuilder.getValue$foundation_release().m6823getSelectiond9O1mEE()) != this.$this_contextMenuBuilder.getValue$foundation_release().getText().length(), (Function3) null, new TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$4(contextMenuState, this.$this_contextMenuBuilder), 10, (Object) null);
    }
}
