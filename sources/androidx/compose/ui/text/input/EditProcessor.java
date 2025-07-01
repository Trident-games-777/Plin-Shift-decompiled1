package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ \u0010\u0010\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\f\u0010\u0019\u001a\u00020\u0011*\u00020\u000fH\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", "", "()V", "<set-?>", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "getMBuffer$ui_text_release", "()Landroidx/compose/ui/text/input/EditingBuffer;", "Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "getMBufferState$ui_text_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "apply", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "generateBatchErrorMessage", "", "failedCommand", "reset", "", "value", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "toTextFieldValue", "toStringForLog", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EditProcessor.kt */
public final class EditProcessor {
    public static final int $stable = 8;
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m6823getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m6569getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);

    public final TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    public final void reset(TextFieldValue textFieldValue, TextInputSession textInputSession) {
        boolean areEqual = Intrinsics.areEqual((Object) textFieldValue.m6822getCompositionMzsxiRA(), (Object) this.mBuffer.m6735getCompositionMzsxiRA$ui_text_release());
        boolean z = true;
        boolean z2 = false;
        if (!Intrinsics.areEqual((Object) this.mBufferState.getAnnotatedString(), (Object) textFieldValue.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(textFieldValue.getAnnotatedString(), textFieldValue.m6823getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
        } else if (!TextRange.m6557equalsimpl0(this.mBufferState.m6823getSelectiond9O1mEE(), textFieldValue.m6823getSelectiond9O1mEE())) {
            this.mBuffer.setSelection$ui_text_release(TextRange.m6562getMinimpl(textFieldValue.m6823getSelectiond9O1mEE()), TextRange.m6561getMaximpl(textFieldValue.m6823getSelectiond9O1mEE()));
            z2 = true;
            z = false;
        } else {
            z = false;
        }
        if (textFieldValue.m6822getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m6558getCollapsedimpl(textFieldValue.m6822getCompositionMzsxiRA().m6568unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m6562getMinimpl(textFieldValue.m6822getCompositionMzsxiRA().m6568unboximpl()), TextRange.m6561getMaximpl(textFieldValue.m6822getCompositionMzsxiRA().m6568unboximpl()));
        }
        if (z || (!z2 && !areEqual)) {
            this.mBuffer.commitComposition$ui_text_release();
            textFieldValue = TextFieldValue.m6818copy3r_uNRQ$default(textFieldValue, (AnnotatedString) null, 0, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue2 = this.mBufferState;
        this.mBufferState = textFieldValue;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue2, textFieldValue);
        }
    }

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }

    private final String generateBatchErrorMessage(List<? extends EditCommand> list, EditCommand editCommand) {
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m6735getCompositionMzsxiRA$ui_text_release() + ", selection=" + TextRange.m6567toStringimpl(this.mBuffer.m6736getSelectiond9O1mEE$ui_text_release()) + "):");
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append.append(10), "append('\\n')");
        CollectionsKt.joinTo$default(list, sb, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new EditProcessor$generateBatchErrorMessage$1$1(editCommand, this), 60, (Object) null);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* access modifiers changed from: private */
    public final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            return "CommitTextCommand(text.length=" + commitTextCommand.getText().length() + ", newCursorPosition=" + commitTextCommand.getNewCursorPosition() + ')';
        } else if (editCommand instanceof SetComposingTextCommand) {
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            return "SetComposingTextCommand(text.length=" + setComposingTextCommand.getText().length() + ", newCursorPosition=" + setComposingTextCommand.getNewCursorPosition() + ')';
        } else if (editCommand instanceof SetComposingRegionCommand) {
            return editCommand.toString();
        } else {
            if (editCommand instanceof DeleteSurroundingTextCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof DeleteSurroundingTextInCodePointsCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof SetSelectionCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof FinishComposingTextCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof BackspaceCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof MoveCursorCommand) {
                return editCommand.toString();
            }
            if (editCommand instanceof DeleteAllCommand) {
                return editCommand.toString();
            }
            StringBuilder sb = new StringBuilder("Unknown EditCommand: ");
            String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "{anonymous EditCommand}";
            }
            return sb.append(simpleName).toString();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.ui.text.TextRange} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [androidx.compose.ui.text.input.EditCommand] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.input.TextFieldValue apply(java.util.List<? extends androidx.compose.ui.text.input.EditCommand> r9) {
        /*
            r8 = this;
            r1 = 0
            int r0 = r9.size()     // Catch:{ Exception -> 0x0061 }
            r2 = 0
            r3 = r1
        L_0x0007:
            if (r2 >= r0) goto L_0x001e
            java.lang.Object r4 = r9.get(r2)     // Catch:{ Exception -> 0x001b }
            androidx.compose.ui.text.input.EditCommand r4 = (androidx.compose.ui.text.input.EditCommand) r4     // Catch:{ Exception -> 0x001b }
            androidx.compose.ui.text.input.EditingBuffer r3 = r8.mBuffer     // Catch:{ Exception -> 0x0018 }
            r4.applyTo(r3)     // Catch:{ Exception -> 0x0018 }
            int r2 = r2 + 1
            r3 = r4
            goto L_0x0007
        L_0x0018:
            r0 = move-exception
            r1 = r4
            goto L_0x0062
        L_0x001b:
            r0 = move-exception
            r1 = r3
            goto L_0x0062
        L_0x001e:
            androidx.compose.ui.text.input.EditingBuffer r9 = r8.mBuffer
            androidx.compose.ui.text.AnnotatedString r3 = r9.toAnnotatedString$ui_text_release()
            androidx.compose.ui.text.input.EditingBuffer r9 = r8.mBuffer
            long r4 = r9.m6736getSelectiond9O1mEE$ui_text_release()
            androidx.compose.ui.text.TextRange r9 = androidx.compose.ui.text.TextRange.m6552boximpl(r4)
            r9.m6568unboximpl()
            androidx.compose.ui.text.input.TextFieldValue r0 = r8.mBufferState
            long r6 = r0.m6823getSelectiond9O1mEE()
            boolean r0 = androidx.compose.ui.text.TextRange.m6563getReversedimpl(r6)
            if (r0 != 0) goto L_0x003e
            r1 = r9
        L_0x003e:
            if (r1 == 0) goto L_0x0045
            long r0 = r1.m6568unboximpl()
            goto L_0x0051
        L_0x0045:
            int r9 = androidx.compose.ui.text.TextRange.m6561getMaximpl(r4)
            int r0 = androidx.compose.ui.text.TextRange.m6562getMinimpl(r4)
            long r0 = androidx.compose.ui.text.TextRangeKt.TextRange(r9, r0)
        L_0x0051:
            r4 = r0
            androidx.compose.ui.text.input.EditingBuffer r9 = r8.mBuffer
            androidx.compose.ui.text.TextRange r6 = r9.m6735getCompositionMzsxiRA$ui_text_release()
            androidx.compose.ui.text.input.TextFieldValue r2 = new androidx.compose.ui.text.input.TextFieldValue
            r7 = 0
            r2.<init>((androidx.compose.ui.text.AnnotatedString) r3, (long) r4, (androidx.compose.ui.text.TextRange) r6, (kotlin.jvm.internal.DefaultConstructorMarker) r7)
            r8.mBufferState = r2
            return r2
        L_0x0061:
            r0 = move-exception
        L_0x0062:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r3 = r1
            androidx.compose.ui.text.input.EditCommand r3 = (androidx.compose.ui.text.input.EditCommand) r3
            java.lang.String r9 = r8.generateBatchErrorMessage(r9, r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r2.<init>(r9, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.EditProcessor.apply(java.util.List):androidx.compose.ui.text.input.TextFieldValue");
    }
}
