package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager;
import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager_androidKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandwritingHandler.android.kt */
final class HandwritingHandlerNode$composeImm$2 extends Lambda implements Function0<ComposeInputMethodManager> {
    final /* synthetic */ HandwritingHandlerNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandwritingHandlerNode$composeImm$2(HandwritingHandlerNode handwritingHandlerNode) {
        super(0);
        this.this$0 = handwritingHandlerNode;
    }

    public final ComposeInputMethodManager invoke() {
        return ComposeInputMethodManager_androidKt.ComposeInputMethodManager(DelegatableNode_androidKt.requireView(this.this$0));
    }
}
