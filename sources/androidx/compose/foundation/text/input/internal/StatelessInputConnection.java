package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.core.view.inputmethod.InputConnectionCompat;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0013\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0019\u001a\u00020\u00102\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\bH\u0016J\u0018\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0016J\u0018\u00102\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\u001cH\u0016J\b\u00104\u001a\u00020\u001cH\u0002J\b\u00105\u001a\u00020\u001cH\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0016J\u001a\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010&\u001a\u00020\bH\u0016J\n\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010>\u001a\u0004\u0018\u00010-2\u0006\u0010&\u001a\u00020\bH\u0016J\u0018\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016J\u0018\u0010A\u001a\u00020-2\u0006\u0010@\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\bH\u0016J\u0010\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\bH\u0016J$\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u001c\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010D2\b\u0010R\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010S\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010W\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020\u001cH\u0016J\u0010\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\bH\u0016J\u0010\u0010[\u001a\u00020\u001c2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020\u00102\u0006\u0010_\u001a\u00020\bH\u0002J\u0018\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0016J\u001a\u0010c\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\bH\u0016J\u0018\u0010d\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR%\u0010\f\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00110\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006e"}, d2 = {"Landroidx/compose/foundation/text/input/internal/StatelessInputConnection;", "Landroid/view/inputmethod/InputConnection;", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "(Landroidx/compose/foundation/text/input/internal/TextInputSession;Landroid/view/inputmethod/EditorInfo;)V", "batchDepth", "", "commitContentDelegateInputConnection", "getCommitContentDelegateInputConnection$annotations", "()V", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "", "Lkotlin/ExtensionFunctionType;", "terminalInputConnection", "androidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1", "Landroidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1;", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "addEditCommandWithBatch", "editCommand", "beginBatchEdit", "", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "performPrivateCommand", "action", "data", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "sendSynthesizedKeyEvent", "code", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StatelessInputConnection.android.kt */
public final class StatelessInputConnection implements InputConnection {
    public static final int $stable = 8;
    private int batchDepth;
    private final InputConnection commitContentDelegateInputConnection;
    /* access modifiers changed from: private */
    public final MutableVector<Function1<EditingBuffer, Unit>> editCommands = new MutableVector<>(new Function1[16], 0);
    /* access modifiers changed from: private */
    public final TextInputSession session;
    private final StatelessInputConnection$terminalInputConnection$1 terminalInputConnection;

    private static /* synthetic */ void getCommitContentDelegateInputConnection$annotations() {
    }

    /* access modifiers changed from: private */
    public final void logDebug(String str) {
    }

    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return true;
    }

    public StatelessInputConnection(TextInputSession textInputSession, EditorInfo editorInfo) {
        this.session = textInputSession;
        StatelessInputConnection$terminalInputConnection$1 statelessInputConnection$terminalInputConnection$1 = new StatelessInputConnection$terminalInputConnection$1(this);
        this.terminalInputConnection = statelessInputConnection$terminalInputConnection$1;
        this.commitContentDelegateInputConnection = InputConnectionCompat.createWrapper((InputConnection) statelessInputConnection$terminalInputConnection$1, editorInfo, (InputConnectionCompat.OnCommitContentListener) new StatelessInputConnection$commitContentDelegateInputConnection$1(this));
    }

    /* access modifiers changed from: private */
    public final TextFieldCharSequence getText() {
        return this.session.getText();
    }

    private final void addEditCommandWithBatch(Function1<? super EditingBuffer, Unit> function1) {
        beginBatchEditInternal();
        try {
            this.editCommands.add(function1);
        } finally {
            endBatchEditInternal();
        }
    }

    public boolean beginBatchEdit() {
        logDebug("beginBatchEdit()");
        return beginBatchEditInternal();
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    public boolean endBatchEdit() {
        logDebug("endBatchEdit()");
        return endBatchEditInternal();
    }

    private final boolean endBatchEditInternal() {
        int i = this.batchDepth - 1;
        this.batchDepth = i;
        if (i == 0 && this.editCommands.isNotEmpty()) {
            this.session.requestEdit(new StatelessInputConnection$endBatchEditInternal$1(this));
            this.editCommands.clear();
        }
        return this.batchDepth > 0;
    }

    public void closeConnection() {
        logDebug("closeConnection()");
        this.editCommands.clear();
        this.batchDepth = 0;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        logDebug("commitText(\"" + charSequence + "\", " + i + ')');
        addEditCommandWithBatch(new StatelessInputConnection$commitText$1(charSequence, i));
        return true;
    }

    public boolean setComposingRegion(int i, int i2) {
        logDebug("setComposingRegion(" + i + ", " + i2 + ')');
        addEditCommandWithBatch(new StatelessInputConnection$setComposingRegion$1(i, i2));
        return true;
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        logDebug("setComposingText(\"" + charSequence + "\", " + i + ')');
        addEditCommandWithBatch(new StatelessInputConnection$setComposingText$1(charSequence, i));
        return true;
    }

    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        logDebug("deleteSurroundingTextInCodePoints(" + i + ", " + i2 + ')');
        addEditCommandWithBatch(new StatelessInputConnection$deleteSurroundingTextInCodePoints$1(i, i2));
        return true;
    }

    public boolean deleteSurroundingText(int i, int i2) {
        logDebug("deleteSurroundingText(" + i + ", " + i2 + ')');
        addEditCommandWithBatch(new StatelessInputConnection$deleteSurroundingText$1(i, i2));
        return true;
    }

    public boolean setSelection(int i, int i2) {
        logDebug("setSelection(" + i + ", " + i2 + ')');
        addEditCommandWithBatch(new StatelessInputConnection$setSelection$1(i, i2));
        return true;
    }

    public boolean finishComposingText() {
        logDebug("finishComposingText()");
        addEditCommandWithBatch(StatelessInputConnection$finishComposingText$1.INSTANCE);
        return true;
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        logDebug("sendKeyEvent(" + keyEvent + ')');
        this.session.sendKeyEvent(keyEvent);
        return true;
    }

    public CharSequence getTextBeforeCursor(int i, int i2) {
        String obj = TextFieldCharSequenceKt.getTextBeforeSelection(getText(), i).toString();
        logDebug("getTextBeforeCursor(" + i + ", " + i2 + "): " + obj);
        return obj;
    }

    public CharSequence getTextAfterCursor(int i, int i2) {
        String obj = TextFieldCharSequenceKt.getTextAfterSelection(getText(), i).toString();
        logDebug("getTextAfterCursor(" + i + ", " + i2 + "): " + obj);
        return obj;
    }

    public CharSequence getSelectedText(int i) {
        CharSequence charSequence;
        if (TextRange.m6558getCollapsedimpl(getText().m1312getSelectiond9O1mEE())) {
            charSequence = null;
        } else {
            charSequence = TextFieldCharSequenceKt.getSelectedText(getText()).toString();
        }
        logDebug("getSelectedText(" + i + "): " + charSequence);
        return charSequence;
    }

    public boolean requestCursorUpdates(int i) {
        logDebug("requestCursorUpdates(" + i + ')');
        this.session.requestCursorUpdates(i);
        return true;
    }

    public void performHandwritingGesture(HandwritingGesture handwritingGesture, Executor executor, IntConsumer intConsumer) {
        logDebug("performHandwritingGesture(" + handwritingGesture + ", " + executor + ", " + intConsumer + ')');
        if (Build.VERSION.SDK_INT >= 34) {
            Api34PerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.session, handwritingGesture, executor, intConsumer);
        }
    }

    public boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        logDebug("previewHandwritingGesture(" + previewableHandwritingGesture + ", " + cancellationSignal + ')');
        if (Build.VERSION.SDK_INT < 34) {
            return false;
        }
        return Api34PerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.session, previewableHandwritingGesture, cancellationSignal);
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        logDebug("getExtractedText(" + extractedTextRequest + ", " + i + ')');
        return StatelessInputConnection_androidKt.toExtractedText(getText());
    }

    public int getCursorCapsMode(int i) {
        logDebug("getCursorCapsMode(" + i + ')');
        return TextUtils.getCapsMode(getText(), TextRange.m6562getMinimpl(getText().m1312getSelectiond9O1mEE()), i);
    }

    public boolean performContextMenuAction(int i) {
        logDebug("performContextMenuAction(" + i + ')');
        switch (i) {
            case 16908319:
                addEditCommandWithBatch(new StatelessInputConnection$performContextMenuAction$1(this));
                return false;
            case 16908320:
                sendSynthesizedKeyEvent(277);
                return false;
            case 16908321:
                sendSynthesizedKeyEvent(278);
                return false;
            case 16908322:
                sendSynthesizedKeyEvent(279);
                return false;
            default:
                return false;
        }
    }

    private final void sendSynthesizedKeyEvent(int i) {
        sendKeyEvent(new KeyEvent(0, i));
        sendKeyEvent(new KeyEvent(1, i));
    }

    public boolean performEditorAction(int i) {
        int i2;
        logDebug("performEditorAction(" + i + ')');
        if (i != 0) {
            switch (i) {
                case 2:
                    i2 = ImeAction.Companion.m6756getGoeUduSuo();
                    break;
                case 3:
                    i2 = ImeAction.Companion.m6760getSearcheUduSuo();
                    break;
                case 4:
                    i2 = ImeAction.Companion.m6761getSendeUduSuo();
                    break;
                case 5:
                    i2 = ImeAction.Companion.m6757getNexteUduSuo();
                    break;
                case 6:
                    i2 = ImeAction.Companion.m6755getDoneeUduSuo();
                    break;
                case 7:
                    i2 = ImeAction.Companion.m6759getPreviouseUduSuo();
                    break;
                default:
                    logDebug("IME sent an unrecognized editor action: " + i);
                    i2 = ImeAction.Companion.m6754getDefaulteUduSuo();
                    break;
            }
        } else {
            i2 = ImeAction.Companion.m6754getDefaulteUduSuo();
        }
        this.session.m1428onImeActionKlQnJC8(i2);
        return true;
    }

    public boolean commitCompletion(CompletionInfo completionInfo) {
        logDebug("commitCompletion(" + (completionInfo != null ? completionInfo.getText() : null) + ')');
        return false;
    }

    public Handler getHandler() {
        logDebug("getHandler()");
        return null;
    }

    public boolean clearMetaKeyStates(int i) {
        logDebug("clearMetaKeyStates(" + i + ')');
        return false;
    }

    public boolean reportFullscreenMode(boolean z) {
        logDebug("reportFullscreenMode(" + z + ')');
        return false;
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        logDebug("performPrivateCommand(" + str + ", " + bundle + ')');
        return this.commitContentDelegateInputConnection.performPrivateCommand(str, bundle);
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        logDebug("commitContent(" + inputContentInfo + ", " + i + ", " + bundle + ')');
        return Api25CommitContentImpl.INSTANCE.commitContent(this.commitContentDelegateInputConnection, inputContentInfo, i, bundle);
    }
}
