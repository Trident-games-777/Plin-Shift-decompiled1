package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\bJ\b\u0010\f\u001a\u00020\u0003H\u0002J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\bJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$touchSelectionObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onEnd", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$touchSelectionObserver$1 implements TextDragObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1664onDownk4lQ0M(long j) {
    }

    public void onUp() {
    }

    TextFieldSelectionManager$touchSelectionObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.this$0 = textFieldSelectionManager;
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1666onStartk4lQ0M(long j) {
        long j2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResultProxy layoutResult2;
        if (this.this$0.getEnabled() && this.this$0.getDraggingHandle() == null) {
            this.this$0.setDraggingHandle(Handle.SelectionEnd);
            this.this$0.previousRawDragOffset = -1;
            this.this$0.hideSelectionToolbar$foundation_release();
            LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
            if (state$foundation_release == null || (layoutResult2 = state$foundation_release.getLayoutResult()) == null || !layoutResult2.m1290isPositionOnTextk4lQ0M(j)) {
                j2 = j;
                LegacyTextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
                if (!(state$foundation_release2 == null || (layoutResult = state$foundation_release2.getLayoutResult()) == null)) {
                    TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                    int transformedToOriginal = textFieldSelectionManager.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.m1288getOffsetForPosition3MmeM6k$default(layoutResult, j2, false, 2, (Object) null));
                    TextFieldValue r12 = textFieldSelectionManager.m1643createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
                    textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                    HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                    if (hapticFeedBack != null) {
                        hapticFeedBack.m5090performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m5099getTextHandleMove5zf0vsI());
                    }
                    textFieldSelectionManager.getOnValueChange$foundation_release().invoke(r12);
                }
            } else if (this.this$0.getValue$foundation_release().getText().length() != 0) {
                this.this$0.enterSelectionMode$foundation_release(false);
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                long j3 = j;
                j2 = j3;
                this.this$0.dragBeginOffsetInText = Integer.valueOf(TextRange.m6564getStartimpl(textFieldSelectionManager2.m1646updateSelection8UEBfa8(TextFieldValue.m6818copy3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation_release(), (AnnotatedString) null, TextRange.Companion.m6569getZerod9O1mEE(), (TextRange) null, 5, (Object) null), j3, true, false, SelectionAdjustment.Companion.getWord(), true)));
            } else {
                return;
            }
            this.this$0.setHandleState(HandleState.None);
            this.this$0.dragBeginPosition = j2;
            TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
            textFieldSelectionManager3.m1645setCurrentDragPosition_kEHs6E(Offset.m3976boximpl(textFieldSelectionManager3.dragBeginPosition));
            this.this$0.dragTotalDistance = Offset.Companion.m4003getZeroF1C5BW0();
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1665onDragk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        long j2;
        SelectionAdjustment selectionAdjustment;
        if (this.this$0.getEnabled() && this.this$0.getValue$foundation_release().getText().length() != 0) {
            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
            textFieldSelectionManager.dragTotalDistance = Offset.m3992plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
            LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null)) {
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m1645setCurrentDragPosition_kEHs6E(Offset.m3976boximpl(Offset.m3992plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                if (textFieldSelectionManager2.dragBeginOffsetInText == null) {
                    Offset r1 = textFieldSelectionManager2.m1649getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(r1);
                    if (!layoutResult.m1290isPositionOnTextk4lQ0M(r1.m3997unboximpl())) {
                        int transformedToOriginal = textFieldSelectionManager2.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.m1288getOffsetForPosition3MmeM6k$default(layoutResult, textFieldSelectionManager2.dragBeginPosition, false, 2, (Object) null));
                        OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
                        Offset r12 = textFieldSelectionManager2.m1649getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(r12);
                        if (transformedToOriginal == offsetMapping$foundation_release.transformedToOriginal(TextLayoutResultProxy.m1288getOffsetForPosition3MmeM6k$default(layoutResult, r12.m3997unboximpl(), false, 2, (Object) null))) {
                            selectionAdjustment = SelectionAdjustment.Companion.getNone();
                        } else {
                            selectionAdjustment = SelectionAdjustment.Companion.getWord();
                        }
                        SelectionAdjustment selectionAdjustment2 = selectionAdjustment;
                        TextFieldValue value$foundation_release = textFieldSelectionManager2.getValue$foundation_release();
                        Offset r0 = textFieldSelectionManager2.m1649getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(r0);
                        j2 = textFieldSelectionManager2.m1646updateSelection8UEBfa8(value$foundation_release, r0.m3997unboximpl(), false, false, selectionAdjustment2, true);
                        TextRange.m6552boximpl(j2);
                    }
                }
                TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                Integer access$getDragBeginOffsetInText$p = textFieldSelectionManager3.dragBeginOffsetInText;
                int intValue = access$getDragBeginOffsetInText$p != null ? access$getDragBeginOffsetInText$p.intValue() : layoutResult.m1289getOffsetForPosition3MmeM6k(textFieldSelectionManager3.dragBeginPosition, false);
                Offset r2 = textFieldSelectionManager3.m1649getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r2);
                int r02 = layoutResult.m1289getOffsetForPosition3MmeM6k(r2.m3997unboximpl(), false);
                if (textFieldSelectionManager3.dragBeginOffsetInText != null || intValue != r02) {
                    TextFieldValue value$foundation_release2 = textFieldSelectionManager3.getValue$foundation_release();
                    Offset r10 = textFieldSelectionManager3.m1649getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(r10);
                    j2 = textFieldSelectionManager3.m1646updateSelection8UEBfa8(value$foundation_release2, r10.m3997unboximpl(), false, false, SelectionAdjustment.Companion.getWord(), true);
                    TextRange.m6552boximpl(j2);
                } else {
                    return;
                }
            }
            this.this$0.updateFloatingToolbar(false);
        }
    }

    public void onStop() {
        onEnd();
    }

    public void onCancel() {
        onEnd();
    }

    private final void onEnd() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1645setCurrentDragPosition_kEHs6E((Offset) null);
        boolean z = true;
        this.this$0.updateFloatingToolbar(true);
        this.this$0.dragBeginOffsetInText = null;
        boolean r0 = TextRange.m6558getCollapsedimpl(this.this$0.getValue$foundation_release().m6823getSelectiond9O1mEE());
        this.this$0.setHandleState(r0 ? HandleState.Cursor : HandleState.Selection);
        LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowSelectionHandleStart(!r0 && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.this$0, true));
        }
        LegacyTextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
        if (state$foundation_release2 != null) {
            state$foundation_release2.setShowSelectionHandleEnd(!r0 && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.this$0, false));
        }
        LegacyTextFieldState state$foundation_release3 = this.this$0.getState$foundation_release();
        if (state$foundation_release3 != null) {
            if (!r0 || !TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.this$0, true)) {
                z = false;
            }
            state$foundation_release3.setShowCursorHandle(z);
        }
    }
}
