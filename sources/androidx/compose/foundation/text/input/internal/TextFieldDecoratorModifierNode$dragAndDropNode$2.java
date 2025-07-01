package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "clipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "clipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "invoke", "(Landroidx/compose/ui/platform/ClipEntry;Landroidx/compose/ui/platform/ClipMetadata;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$dragAndDropNode$2 extends Lambda implements Function2<ClipEntry, ClipMetadata, Boolean> {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$dragAndDropNode$2(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        super(2);
        this.this$0 = textFieldDecoratorModifierNode;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0037, code lost:
        r10 = r10.getClipEntry();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(androidx.compose.ui.platform.ClipEntry r10, androidx.compose.ui.platform.ClipMetadata r11) {
        /*
            r9 = this;
            androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r0 = r9.this$0
            r0.emitDragExitEvent()
            androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r0 = r9.this$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = r0.getTextFieldSelectionState()
            r0.clearHandleDragging()
            java.lang.String r0 = androidx.compose.foundation.content.TransferableContent_androidKt.readPlainText(r10)
            androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r1 = r9.this$0
            androidx.compose.ui.modifier.ModifierLocalModifierNode r1 = (androidx.compose.ui.modifier.ModifierLocalModifierNode) r1
            androidx.compose.foundation.content.internal.ReceiveContentConfiguration r1 = androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt.getReceiveContentConfiguration(r1)
            if (r1 == 0) goto L_0x0044
            androidx.compose.foundation.content.TransferableContent r2 = new androidx.compose.foundation.content.TransferableContent
            androidx.compose.foundation.content.TransferableContent$Source$Companion r0 = androidx.compose.foundation.content.TransferableContent.Source.Companion
            int r5 = r0.m366getDragAndDropkB6V9T0()
            r7 = 8
            r8 = 0
            r6 = 0
            r3 = r10
            r4 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            androidx.compose.foundation.content.ReceiveContentListener r10 = r1.getReceiveContentListener()
            androidx.compose.foundation.content.TransferableContent r10 = r10.onReceive(r2)
            if (r10 == 0) goto L_0x0042
            androidx.compose.ui.platform.ClipEntry r10 = r10.getClipEntry()
            if (r10 == 0) goto L_0x0042
            java.lang.String r10 = androidx.compose.foundation.content.TransferableContent_androidKt.readPlainText(r10)
            goto L_0x0043
        L_0x0042:
            r10 = 0
        L_0x0043:
            r0 = r10
        L_0x0044:
            if (r0 == 0) goto L_0x0056
            androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r10 = r9.this$0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r1 = r10.getTextFieldState()
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5 = 6
            r6 = 0
            r3 = 0
            r4 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.replaceSelectedText$default(r1, r2, r3, r4, r5, r6)
        L_0x0056:
            r10 = 1
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$2.invoke(androidx.compose.ui.platform.ClipEntry, androidx.compose.ui.platform.ClipMetadata):java.lang.Boolean");
    }
}
