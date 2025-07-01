package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "invoke-k-4lQ0M", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$pointerModifier$2$1 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ LegacyTextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$pointerModifier$2$1(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z, boolean z2, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping) {
        super(1);
        this.$state = legacyTextFieldState;
        this.$focusRequester = focusRequester;
        this.$readOnly = z;
        this.$enabled = z2;
        this.$manager = textFieldSelectionManager;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1182invokek4lQ0M(((Offset) obj).m3997unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m1182invokek4lQ0M(long j) {
        CoreTextFieldKt.tapToFocus(this.$state, this.$focusRequester, !this.$readOnly);
        if (this.$state.getHasFocus() && this.$enabled) {
            if (this.$state.getHandleState() != HandleState.Selection) {
                TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
                if (layoutResult != null) {
                    LegacyTextFieldState legacyTextFieldState = this.$state;
                    long j2 = j;
                    TextFieldDelegate.Companion.m1267setCursorOffsetULxng0E$foundation_release(j2, layoutResult, legacyTextFieldState.getProcessor(), this.$offsetMapping, legacyTextFieldState.getOnValueChange());
                    if (legacyTextFieldState.getTextDelegate().getText().length() > 0) {
                        legacyTextFieldState.setHandleState(HandleState.Cursor);
                        return;
                    }
                    return;
                }
                return;
            }
            this.$manager.m1648deselect_kEHs6E$foundation_release(Offset.m3976boximpl(j));
        }
    }
}
