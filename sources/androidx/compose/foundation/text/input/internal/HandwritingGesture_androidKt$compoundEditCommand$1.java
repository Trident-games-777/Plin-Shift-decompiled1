package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditingBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/text/input/internal/HandwritingGesture_androidKt$compoundEditCommand$1", "Landroidx/compose/ui/text/input/EditCommand;", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandwritingGesture.android.kt */
public final class HandwritingGesture_androidKt$compoundEditCommand$1 implements EditCommand {
    final /* synthetic */ EditCommand[] $editCommands;

    HandwritingGesture_androidKt$compoundEditCommand$1(EditCommand[] editCommandArr) {
        this.$editCommands = editCommandArr;
    }

    public void applyTo(EditingBuffer editingBuffer) {
        for (EditCommand applyTo : this.$editCommands) {
            applyTo.applyTo(editingBuffer);
        }
    }
}
