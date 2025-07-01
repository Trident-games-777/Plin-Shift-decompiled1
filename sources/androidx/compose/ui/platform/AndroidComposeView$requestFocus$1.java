package androidx.compose.ui.platform;

import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/focus/FocusTargetNode;", "invoke", "(Landroidx/compose/ui/focus/FocusTargetNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$requestFocus$1 extends Lambda implements Function1<FocusTargetNode, Boolean> {
    final /* synthetic */ int $focusDirection;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$requestFocus$1(int i) {
        super(1);
        this.$focusDirection = i;
    }

    public final Boolean invoke(FocusTargetNode focusTargetNode) {
        Boolean r2 = FocusTransactionsKt.m3938requestFocusMxy_nc0(focusTargetNode, this.$focusDirection);
        return Boolean.valueOf(r2 != null ? r2.booleanValue() : false);
    }
}
