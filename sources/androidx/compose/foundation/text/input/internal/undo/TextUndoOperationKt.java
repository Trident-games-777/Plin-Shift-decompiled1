package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.EditingBuffer;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0006"}, d2 = {"redo", "", "Landroidx/compose/foundation/text/input/TextFieldState;", "op", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "undo", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextUndoOperation.kt */
public final class TextUndoOperationKt {
    public static final void undo(TextFieldState textFieldState, TextUndoOperation textUndoOperation) {
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.replace(textUndoOperation.getIndex(), textUndoOperation.getIndex() + textUndoOperation.getPostText().length(), textUndoOperation.getPreText());
        mainBuffer$foundation_release.setSelection(TextRange.m6564getStartimpl(textUndoOperation.m1506getPreSelectiond9O1mEE()), TextRange.m6559getEndimpl(textUndoOperation.m1506getPreSelectiond9O1mEE()));
        textFieldState.updateValueAndNotifyListeners(textFieldState.getValue$foundation_release(), new TextFieldCharSequence(textFieldState.getMainBuffer$foundation_release().toString(), textFieldState.getMainBuffer$foundation_release().m1348getSelectiond9O1mEE(), textFieldState.getMainBuffer$foundation_release().m1347getCompositionMzsxiRA(), (Pair) null, 8, (DefaultConstructorMarker) null), true);
    }

    public static final void redo(TextFieldState textFieldState, TextUndoOperation textUndoOperation) {
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.replace(textUndoOperation.getIndex(), textUndoOperation.getIndex() + textUndoOperation.getPreText().length(), textUndoOperation.getPostText());
        mainBuffer$foundation_release.setSelection(TextRange.m6564getStartimpl(textUndoOperation.m1505getPostSelectiond9O1mEE()), TextRange.m6559getEndimpl(textUndoOperation.m1505getPostSelectiond9O1mEE()));
        textFieldState.updateValueAndNotifyListeners(textFieldState.getValue$foundation_release(), new TextFieldCharSequence(textFieldState.getMainBuffer$foundation_release().toString(), textFieldState.getMainBuffer$foundation_release().m1348getSelectiond9O1mEE(), textFieldState.getMainBuffer$foundation_release().m1347getCompositionMzsxiRA(), (Pair) null, 8, (DefaultConstructorMarker) null), true);
    }
}
