package androidx.compose.foundation.text.input.internal;

import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0004J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J(\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImpl;", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "imm", "Landroid/view/inputmethod/InputMethodManager;", "softwareKeyboardControllerCompat", "Landroidx/core/view/SoftwareKeyboardControllerCompat;", "getView", "()Landroid/view/View;", "acceptStylusHandwritingDelegation", "", "createImm", "hideSoftInput", "prepareStylusHandwritingDelegation", "requireImm", "restartInput", "showSoftInput", "startStylusHandwriting", "updateCursorAnchorInfo", "info", "Landroid/view/inputmethod/CursorAnchorInfo;", "updateExtractedText", "token", "", "extractedText", "Landroid/view/inputmethod/ExtractedText;", "updateSelection", "selectionStart", "selectionEnd", "compositionStart", "compositionEnd", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeInputMethodManager.android.kt */
abstract class ComposeInputMethodManagerImpl implements ComposeInputMethodManager {
    private InputMethodManager imm;
    private final SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat;
    private final View view;

    public void acceptStylusHandwritingDelegation() {
    }

    public void prepareStylusHandwritingDelegation() {
    }

    public void startStylusHandwriting() {
    }

    public ComposeInputMethodManagerImpl(View view2) {
        this.view = view2;
        this.softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view2);
    }

    /* access modifiers changed from: protected */
    public final View getView() {
        return this.view;
    }

    public void restartInput() {
        requireImm().restartInput(this.view);
    }

    public void showSoftInput() {
        this.softwareKeyboardControllerCompat.show();
    }

    public void hideSoftInput() {
        this.softwareKeyboardControllerCompat.hide();
    }

    public void updateExtractedText(int i, ExtractedText extractedText) {
        requireImm().updateExtractedText(this.view, i, extractedText);
    }

    public void updateSelection(int i, int i2, int i3, int i4) {
        requireImm().updateSelection(this.view, i, i2, i3, i4);
    }

    public void updateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo) {
        requireImm().updateCursorAnchorInfo(this.view, cursorAnchorInfo);
    }

    /* access modifiers changed from: protected */
    public final InputMethodManager requireImm() {
        InputMethodManager inputMethodManager = this.imm;
        if (inputMethodManager != null) {
            return inputMethodManager;
        }
        InputMethodManager createImm = createImm();
        this.imm = createImm;
        return createImm;
    }

    private final InputMethodManager createImm() {
        Object systemService = this.view.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager) systemService;
    }
}
