package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/focus/FocusTargetNode;", "invoke", "(Landroidx/compose/ui/focus/FocusTargetNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
final class FocusOwnerImpl$moveFocus$focusSearchSuccess$1 extends Lambda implements Function1<FocusTargetNode, Boolean> {
    final /* synthetic */ int $focusDirection;
    final /* synthetic */ Ref.ObjectRef<Boolean> $requestFocusSuccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusOwnerImpl$moveFocus$focusSearchSuccess$1(Ref.ObjectRef<Boolean> objectRef, int i) {
        super(1);
        this.$requestFocusSuccess = objectRef;
        this.$focusDirection = i;
    }

    public final Boolean invoke(FocusTargetNode focusTargetNode) {
        this.$requestFocusSuccess.element = FocusTransactionsKt.m3938requestFocusMxy_nc0(focusTargetNode, this.$focusDirection);
        Boolean bool = (Boolean) this.$requestFocusSuccess.element;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }
}
