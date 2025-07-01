package androidx.compose.material3;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheetDialog$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ModalBottomSheetDialogWrapper $dialog;
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ ModalBottomSheetProperties $properties;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheetDialog$2$1(ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper, Function0<Unit> function0, ModalBottomSheetProperties modalBottomSheetProperties, LayoutDirection layoutDirection) {
        super(0);
        this.$dialog = modalBottomSheetDialogWrapper;
        this.$onDismissRequest = function0;
        this.$properties = modalBottomSheetProperties;
        this.$layoutDirection = layoutDirection;
    }

    public final void invoke() {
        this.$dialog.updateParameters(this.$onDismissRequest, this.$properties, this.$layoutDirection);
    }
}
