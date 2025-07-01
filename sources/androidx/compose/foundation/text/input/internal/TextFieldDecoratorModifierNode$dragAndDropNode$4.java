package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$dragAndDropNode$4 extends Lambda implements Function1<DragAndDropEvent, Unit> {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$dragAndDropNode$4(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        super(1);
        this.this$0 = textFieldDecoratorModifierNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DragAndDropEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DragAndDropEvent dragAndDropEvent) {
        ReceiveContentListener receiveContentListener;
        TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.this$0;
        HoverInteraction.Enter enter = new HoverInteraction.Enter();
        this.this$0.getInteractionSource().tryEmit(enter);
        textFieldDecoratorModifierNode.dragEnterEvent = enter;
        ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.this$0);
        if (receiveContentConfiguration != null && (receiveContentListener = receiveContentConfiguration.getReceiveContentListener()) != null) {
            receiveContentListener.onDragEnter();
        }
    }
}
