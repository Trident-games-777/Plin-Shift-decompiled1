package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "invoke-k-4lQ0M", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectTextFieldTapGestures$3 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ Function0<Unit> $requestFocus;
    final /* synthetic */ Function0<Unit> $showKeyboard;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectTextFieldTapGestures$3(Function0<Unit> function0, TextFieldSelectionState textFieldSelectionState, Function0<Unit> function02) {
        super(1);
        this.$requestFocus = function0;
        this.this$0 = textFieldSelectionState;
        this.$showKeyboard = function02;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1501invokek4lQ0M(((Offset) obj).m3997unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m1501invokek4lQ0M(long j) {
        TextFieldSelectionStateKt.logDebug(AnonymousClass1.INSTANCE);
        this.$requestFocus.invoke();
        if (this.this$0.enabled && this.this$0.isFocused()) {
            if (!this.this$0.readOnly) {
                this.$showKeyboard.invoke();
                if (this.this$0.textFieldState.getVisualText().length() > 0) {
                    this.this$0.setShowCursorHandle(true);
                }
            }
            this.this$0.updateTextToolbarState(TextToolbarState.None);
            long r3 = this.this$0.textLayoutState.m1430coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(j);
            TextFieldSelectionState textFieldSelectionState = this.this$0;
            boolean unused = textFieldSelectionState.m1480placeCursorAtNearestOffsetk4lQ0M(TextLayoutStateKt.m1437fromDecorationToTextLayoutUv8p0NA(textFieldSelectionState.textLayoutState, r3));
        }
    }
}
