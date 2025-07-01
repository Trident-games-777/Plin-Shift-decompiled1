package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u000203H\u0016J\u000e\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u000206J\b\u00107\u001a\u00020\u0007H\u0002JN\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070\u0005J\u0018\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010'2\u0006\u0010>\u001a\u00020'J.\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002062\u0006\u0010F\u001a\u000206R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u00070\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020'@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "view", "Landroid/view/View;", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "cursorAnchorInfoController", "Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "focusedRect", "Landroid/graphics/Rect;", "getFocusedRect$foundation_release", "()Landroid/graphics/Rect;", "setFocusedRect$foundation_release", "(Landroid/graphics/Rect;)V", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "onEditCommand", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState", "()Landroidx/compose/ui/text/input/TextFieldValue;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "createInputConnection", "outAttributes", "Landroid/view/inputmethod/EditorInfo;", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "restartInputImmediately", "startInput", "value", "textInputNode", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;", "updateState", "oldValue", "newValue", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "decorationBoxBounds", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
public final class LegacyTextInputMethodRequest implements PlatformTextInputMethodRequest {
    public static final int $stable = 8;
    private final Lazy baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new LegacyTextInputMethodRequest$baseInputConnection$2(this));
    /* access modifiers changed from: private */
    public final LegacyCursorAnchorInfoController cursorAnchorInfoController;
    private Rect focusedRect;
    /* access modifiers changed from: private */
    public List<WeakReference<RecordingInputConnection>> ics = new ArrayList();
    private ImeOptions imeOptions = ImeOptions.Companion.getDefault();
    private final InputMethodManager inputMethodManager;
    private LegacyTextFieldState legacyTextFieldState;
    /* access modifiers changed from: private */
    public Function1<? super List<? extends EditCommand>, Unit> onEditCommand = LegacyTextInputMethodRequest$onEditCommand$1.INSTANCE;
    /* access modifiers changed from: private */
    public Function1<? super ImeAction, Unit> onImeActionPerformed = LegacyTextInputMethodRequest$onImeActionPerformed$1.INSTANCE;
    private TextFieldValue state = new TextFieldValue("", TextRange.Companion.m6569getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
    private TextFieldSelectionManager textFieldSelectionManager;
    private final View view;
    private ViewConfiguration viewConfiguration;

    public LegacyTextInputMethodRequest(View view2, Function1<? super Matrix, Unit> function1, InputMethodManager inputMethodManager2) {
        this.view = view2;
        this.inputMethodManager = inputMethodManager2;
        this.cursorAnchorInfoController = new LegacyCursorAnchorInfoController(function1, inputMethodManager2);
    }

    public final View getView() {
        return this.view;
    }

    public final TextFieldValue getState() {
        return this.state;
    }

    /* access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    public final Rect getFocusedRect$foundation_release() {
        return this.focusedRect;
    }

    public final void setFocusedRect$foundation_release(Rect rect) {
        this.focusedRect = rect;
    }

    public final void startInput(TextFieldValue textFieldValue, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, ImeOptions imeOptions2, Function1<? super List<? extends EditCommand>, Unit> function1, Function1<? super ImeAction, Unit> function12) {
        this.state = textFieldValue;
        this.imeOptions = imeOptions2;
        this.onEditCommand = function1;
        this.onImeActionPerformed = function12;
        ViewConfiguration viewConfiguration2 = null;
        this.legacyTextFieldState = legacyPlatformTextInputNode != null ? legacyPlatformTextInputNode.getLegacyTextFieldState() : null;
        this.textFieldSelectionManager = legacyPlatformTextInputNode != null ? legacyPlatformTextInputNode.getTextFieldSelectionManager() : null;
        if (legacyPlatformTextInputNode != null) {
            viewConfiguration2 = legacyPlatformTextInputNode.getViewConfiguration();
        }
        this.viewConfiguration = viewConfiguration2;
    }

    public RecordingInputConnection createInputConnection(EditorInfo editorInfo) {
        EditorInfo editorInfo2 = editorInfo;
        EditorInfo_androidKt.m1352updatepLxbY9I$default(editorInfo2, this.state.getText(), this.state.m6823getSelectiond9O1mEE(), this.imeOptions, (String[]) null, 8, (Object) null);
        LegacyPlatformTextInputServiceAdapter_androidKt.updateWithEmojiCompat(editorInfo2);
        TextFieldValue textFieldValue = this.state;
        boolean autoCorrect = this.imeOptions.getAutoCorrect();
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(textFieldValue, new LegacyTextInputMethodRequest$createInputConnection$1(this), autoCorrect, this.legacyTextFieldState, this.textFieldSelectionManager, this.viewConfiguration);
        this.ics.add(new WeakReference(recordingInputConnection));
        return recordingInputConnection;
    }

    public final void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        boolean z = !TextRange.m6557equalsimpl0(this.state.m6823getSelectiond9O1mEE(), textFieldValue2.m6823getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) this.state.m6822getCompositionMzsxiRA(), (Object) textFieldValue2.m6822getCompositionMzsxiRA());
        this.state = textFieldValue2;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = (RecordingInputConnection) this.ics.get(i).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setTextFieldValue$foundation_release(textFieldValue2);
            }
        }
        this.cursorAnchorInfoController.invalidate();
        if (Intrinsics.areEqual((Object) textFieldValue, (Object) textFieldValue2)) {
            if (z) {
                InputMethodManager inputMethodManager2 = this.inputMethodManager;
                int r0 = TextRange.m6562getMinimpl(textFieldValue2.m6823getSelectiond9O1mEE());
                int r8 = TextRange.m6561getMaximpl(textFieldValue2.m6823getSelectiond9O1mEE());
                TextRange r1 = this.state.m6822getCompositionMzsxiRA();
                int i2 = -1;
                int r12 = r1 != null ? TextRange.m6562getMinimpl(r1.m6568unboximpl()) : -1;
                TextRange r3 = this.state.m6822getCompositionMzsxiRA();
                if (r3 != null) {
                    i2 = TextRange.m6561getMaximpl(r3.m6568unboximpl());
                }
                inputMethodManager2.updateSelection(r0, r8, r12, i2);
            }
        } else if (textFieldValue == null || (Intrinsics.areEqual((Object) textFieldValue.getText(), (Object) textFieldValue2.getText()) && (!TextRange.m6557equalsimpl0(textFieldValue.m6823getSelectiond9O1mEE(), textFieldValue2.m6823getSelectiond9O1mEE()) || Intrinsics.areEqual((Object) textFieldValue.m6822getCompositionMzsxiRA(), (Object) textFieldValue2.m6822getCompositionMzsxiRA())))) {
            int size2 = this.ics.size();
            for (int i3 = 0; i3 < size2; i3++) {
                RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) this.ics.get(i3).get();
                if (recordingInputConnection2 != null) {
                    recordingInputConnection2.updateInputState(this.state, this.inputMethodManager);
                }
            }
        } else {
            restartInputImmediately();
        }
    }

    public final void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        this.focusedRect = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        if (this.ics.isEmpty() && (rect2 = this.focusedRect) != null) {
            this.view.requestRectangleOnScreen(new Rect(rect2));
        }
    }

    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, androidx.compose.ui.geometry.Rect rect, androidx.compose.ui.geometry.Rect rect2) {
        this.cursorAnchorInfoController.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, rect, rect2);
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }
}
