package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1 extends Lambda implements Function0<TextLayoutResultProxy> {
    final /* synthetic */ LegacyTextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1(LegacyTextFieldState legacyTextFieldState) {
        super(0);
        this.$state = legacyTextFieldState;
    }

    public final TextLayoutResultProxy invoke() {
        return this.$state.getLayoutResult();
    }
}
