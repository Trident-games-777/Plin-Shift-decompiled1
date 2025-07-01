package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b*\b\u0000\u0018\u0000 P2\u00020\u0001:\u0001PB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ,\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fH\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J\u001f\u0010#\u001a\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fJ\u001f\u0010%\u001a\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fJ\u0019\u0010&\u001a\u00020\u001e2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120'H\bJ\u0006\u0010(\u001a\u00020\u0000J\u0006\u0010)\u001a\u00020!J\u0006\u0010*\u001a\u00020!J\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020!J\u0006\u0010-\u001a\u00020!J\u0006\u0010.\u001a\u00020!J\b\u0010/\u001a\u00020\u0007H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020!H\u0002J\u0006\u00102\u001a\u00020\u0000J\u0006\u00103\u001a\u00020\u0000J\u0006\u00104\u001a\u00020\u0000J\u0006\u00105\u001a\u00020\u0000J\b\u00106\u001a\u00020\u0000H\u0002J\u0006\u00107\u001a\u00020\u0000J\b\u00108\u001a\u00020\u0000H\u0002J\b\u00109\u001a\u00020\u0000H\u0002J\u0006\u0010:\u001a\u00020\u0000J\b\u0010;\u001a\u00020\u0000H\u0002J\u0006\u0010<\u001a\u00020\u0000J\u0006\u0010=\u001a\u00020\u0000J\u0006\u0010>\u001a\u00020\u0000J\u0006\u0010?\u001a\u00020\u0000J\u0006\u0010@\u001a\u00020\u0000J\u0006\u0010A\u001a\u00020\u0000J\u0006\u0010B\u001a\u00020\u0000J\u0006\u0010C\u001a\u00020\u0000J\u0006\u0010D\u001a\u00020\u0000J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\u0010\u0010H\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!H\u0002J\u0016\u0010I\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010J\u001a\u00020!H\u0002J\u0016\u0010K\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010J\u001a\u00020!H\u0002J\u0017\u0010L\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010J\u001a\u00020!H\u0010J\u0017\u0010M\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010J\u001a\u00020!H\u0010J\u0014\u0010N\u001a\u00020!*\u00020\u00052\u0006\u0010O\u001a\u00020!H\u0002R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u00020\u0012X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isFromSoftKeyboard", "", "visibleTextLayoutHeight", "", "textPreparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextLayoutResult;ZFLandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;)V", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getInitialValue", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "selection", "Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "setSelection-5zc-tL8", "(J)V", "J", "text", "", "applyIfNotEmpty", "resetCachedX", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "charOffset", "", "offset", "collapseLeftOr", "or", "collapseRightOr", "deleteIfSelectedOr", "Lkotlin/Function0;", "deselect", "getLineEndByOffset", "getLineStartByOffset", "getNextCharacterIndex", "getNextWordOffset", "getPrecedingCharacterIndex", "getPreviousWordOffset", "isLtr", "jumpByPagesOffset", "pagesAmount", "moveCursorDownByLine", "moveCursorDownByPage", "moveCursorLeft", "moveCursorLeftByWord", "moveCursorNext", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrev", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRight", "moveCursorRightByWord", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "moveCursorUpByPage", "selectAll", "selectMovement", "setCursor", "getLineEndByOffsetForLayout", "currentOffset", "getLineStartByOffsetForLayout", "getNextWordOffsetForLayout", "getPrevWordOffsetForLayout", "jumpByLinesOffset", "linesAmount", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public final class TextFieldPreparedSelection {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NoCharacterFound = -1;
    private final TextFieldCharSequence initialValue;
    /* access modifiers changed from: private */
    public final boolean isFromSoftKeyboard;
    private long selection;
    /* access modifiers changed from: private */
    public final TransformedTextFieldState state;
    /* access modifiers changed from: private */
    public final String text;
    private final TextLayoutResult textLayoutResult;
    /* access modifiers changed from: private */
    public final TextFieldPreparedSelectionState textPreparedSelectionState;
    private final float visibleTextLayoutHeight;

    /* JADX INFO: finally extract failed */
    public TextFieldPreparedSelection(TransformedTextFieldState transformedTextFieldState, TextLayoutResult textLayoutResult2, boolean z, float f, TextFieldPreparedSelectionState textFieldPreparedSelectionState) {
        this.state = transformedTextFieldState;
        this.textLayoutResult = textLayoutResult2;
        this.isFromSoftKeyboard = z;
        this.visibleTextLayoutHeight = f;
        this.textPreparedSelectionState = textFieldPreparedSelectionState;
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextFieldCharSequence visualText = transformedTextFieldState.getVisualText();
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            this.initialValue = visualText;
            this.selection = visualText.m1312getSelectiond9O1mEE();
            this.text = visualText.toString();
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final TextFieldCharSequence getInitialValue() {
        return this.initialValue;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m1470getSelectiond9O1mEE() {
        return this.selection;
    }

    /* renamed from: setSelection-5zc-tL8  reason: not valid java name */
    public final void m1471setSelection5zctL8(long j) {
        this.selection = j;
    }

    public final void deleteIfSelectedOr(Function0<TextRange> function0) {
        if (!TextRange.m6558getCollapsedimpl(m1470getSelectiond9O1mEE())) {
            TransformedTextFieldState.m1442replaceTextM8tDOmk$default(this.state, "", m1470getSelectiond9O1mEE(), (TextFieldEditUndoBehavior) null, !this.isFromSoftKeyboard, 4, (Object) null);
            return;
        }
        TextRange invoke = function0.invoke();
        if (invoke != null) {
            TransformedTextFieldState.m1442replaceTextM8tDOmk$default(this.state, "", invoke.m6568unboximpl(), (TextFieldEditUndoBehavior) null, !this.isFromSoftKeyboard, 4, (Object) null);
        }
    }

    private final int jumpByPagesOffset(int i) {
        int r0 = TextRange.m6559getEndimpl(this.initialValue.m1312getSelectiond9O1mEE());
        if (this.textLayoutResult == null || Float.isNaN(this.visibleTextLayoutHeight)) {
            return r0;
        }
        Rect translate = this.textLayoutResult.getCursorRect(r0).translate(0.0f, this.visibleTextLayoutHeight * ((float) i));
        float lineBottom = this.textLayoutResult.getLineBottom(this.textLayoutResult.getLineForVerticalPosition(translate.getTop()));
        if (Math.abs(translate.getTop() - lineBottom) > Math.abs(translate.getBottom() - lineBottom)) {
            return this.textLayoutResult.m6536getOffsetForPositionk4lQ0M(translate.m4022getTopLeftF1C5BW0());
        }
        return this.textLayoutResult.m6536getOffsetForPositionk4lQ0M(translate.m4015getBottomLeftF1C5BW0());
    }

    private final TextFieldPreparedSelection applyIfNotEmpty(boolean z, Function1<? super TextFieldPreparedSelection, Unit> function1) {
        if (z) {
            this.textPreparedSelectionState.resetCachedX();
        }
        if (this.text.length() > 0) {
            function1.invoke(this);
        }
        return this;
    }

    static /* synthetic */ TextFieldPreparedSelection applyIfNotEmpty$default(TextFieldPreparedSelection textFieldPreparedSelection, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if (z) {
            textFieldPreparedSelection.textPreparedSelectionState.resetCachedX();
        }
        if (textFieldPreparedSelection.text.length() > 0) {
            function1.invoke(textFieldPreparedSelection);
        }
        return textFieldPreparedSelection;
    }

    private final void setCursor(int i) {
        this.selection = TextRangeKt.TextRange(i, i);
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.m6559getEndimpl(this.selection));
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.m6559getEndimpl(this.selection));
    }

    public final int getNextWordOffset() {
        TextLayoutResult textLayoutResult2 = this.textLayoutResult;
        return textLayoutResult2 != null ? getNextWordOffsetForLayout$default(this, textLayoutResult2, 0, 1, (Object) null) : this.text.length();
    }

    public final int getPreviousWordOffset() {
        TextLayoutResult textLayoutResult2 = this.textLayoutResult;
        if (textLayoutResult2 != null) {
            return getPrevWordOffsetForLayout$default(this, textLayoutResult2, 0, 1, (Object) null);
        }
        return 0;
    }

    public final TextFieldPreparedSelection moveCursorUpByLine() {
        if (this.textLayoutResult != null && this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            TextLayoutResult textLayoutResult2 = this.textLayoutResult;
            Intrinsics.checkNotNull(textLayoutResult2);
            setCursor(jumpByLinesOffset(textLayoutResult2, -1));
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorDownByLine() {
        if (this.textLayoutResult != null && this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            TextLayoutResult textLayoutResult2 = this.textLayoutResult;
            Intrinsics.checkNotNull(textLayoutResult2);
            setCursor(jumpByLinesOffset(textLayoutResult2, 1));
        }
        return this;
    }

    public final int getLineStartByOffset() {
        TextLayoutResult textLayoutResult2 = this.textLayoutResult;
        if (textLayoutResult2 != null) {
            return getLineStartByOffsetForLayout$default(this, textLayoutResult2, 0, 1, (Object) null);
        }
        return 0;
    }

    public final int getLineEndByOffset() {
        TextLayoutResult textLayoutResult2 = this.textLayoutResult;
        return textLayoutResult2 != null ? getLineEndByOffsetForLayout$default(this, textLayoutResult2, 0, 1, (Object) null) : this.text.length();
    }

    private final boolean isLtr() {
        ResolvedTextDirection paragraphDirection;
        TextLayoutResult textLayoutResult2 = this.textLayoutResult;
        if (textLayoutResult2 == null || (paragraphDirection = textLayoutResult2.getParagraphDirection(TextRange.m6559getEndimpl(this.selection))) == null || paragraphDirection == ResolvedTextDirection.Ltr) {
            return true;
        }
        return false;
    }

    static /* synthetic */ int getNextWordOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6559getEndimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getNextWordOffsetForLayout(textLayoutResult2, i);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult2, int i) {
        while (i < this.initialValue.length()) {
            long r0 = textLayoutResult2.m6538getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6559getEndimpl(r0) > i) {
                return TextRange.m6559getEndimpl(r0);
            }
            i++;
        }
        return this.initialValue.length();
    }

    static /* synthetic */ int getPrevWordOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6559getEndimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getPrevWordOffsetForLayout(textLayoutResult2, i);
    }

    private final int getPrevWordOffsetForLayout(TextLayoutResult textLayoutResult2, int i) {
        while (i > 0) {
            long r0 = textLayoutResult2.m6538getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6564getStartimpl(r0) < i) {
                return TextRange.m6564getStartimpl(r0);
            }
            i--;
        }
        return 0;
    }

    static /* synthetic */ int getLineStartByOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6562getMinimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult2, i);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult2, int i) {
        return textLayoutResult2.getLineStart(textLayoutResult2.getLineForOffset(i));
    }

    static /* synthetic */ int getLineEndByOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6561getMaximpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult2, i);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult2, int i) {
        return textLayoutResult2.getLineEnd(textLayoutResult2.getLineForOffset(i), true);
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult2, int i) {
        int r0 = TextRange.m6559getEndimpl(this.selection);
        if (Float.isNaN(this.textPreparedSelectionState.getCachedX())) {
            this.textPreparedSelectionState.setCachedX(textLayoutResult2.getCursorRect(r0).getLeft());
        }
        int lineForOffset = textLayoutResult2.getLineForOffset(r0) + i;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult2.getLineCount()) {
            return this.text.length();
        }
        float lineBottom = textLayoutResult2.getLineBottom(lineForOffset) - ((float) 1);
        float cachedX = this.textPreparedSelectionState.getCachedX();
        if ((!isLtr() || cachedX < textLayoutResult2.getLineRight(lineForOffset)) && (isLtr() || cachedX > textLayoutResult2.getLineLeft(lineForOffset))) {
            return textLayoutResult2.m6536getOffsetForPositionk4lQ0M(OffsetKt.Offset(cachedX, lineBottom));
        }
        return textLayoutResult2.getLineEnd(lineForOffset, true);
    }

    private final int charOffset(int i) {
        return RangesKt.coerceAtMost(i, this.text.length() - 1);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection$Companion;", "", "()V", "NoCharacterFound", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextPreparedSelection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final TextFieldPreparedSelection moveCursorUpByPage() {
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            setCursor(jumpByPagesOffset(-1));
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorDownByPage() {
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            setCursor(jumpByPagesOffset(1));
        }
        return this;
    }

    public final TextFieldPreparedSelection selectAll() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            this.selection = TextRangeKt.TextRange(0, this.text.length());
        }
        return this;
    }

    public final TextFieldPreparedSelection deselect() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            setCursor(TextRange.m6559getEndimpl(this.selection));
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorLeft() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            if (isLtr()) {
                moveCursorPrev();
                return this;
            }
            moveCursorNext();
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorRight() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            if (isLtr()) {
                moveCursorNext();
                return this;
            }
            moveCursorPrev();
        }
        return this;
    }

    public final TextFieldPreparedSelection collapseLeftOr(Function1<? super TextFieldPreparedSelection, Unit> function1) {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            if (TextRange.m6558getCollapsedimpl(this.selection)) {
                function1.invoke(this);
                return this;
            } else if (isLtr()) {
                setCursor(TextRange.m6562getMinimpl(this.selection));
                return this;
            } else {
                setCursor(TextRange.m6561getMaximpl(this.selection));
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection collapseRightOr(Function1<? super TextFieldPreparedSelection, Unit> function1) {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            if (TextRange.m6558getCollapsedimpl(this.selection)) {
                function1.invoke(this);
                return this;
            } else if (isLtr()) {
                setCursor(TextRange.m6561getMaximpl(this.selection));
                return this;
            } else {
                setCursor(TextRange.m6562getMinimpl(this.selection));
            }
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorPrev() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            int r0 = TextRange.m6559getEndimpl(this.selection);
            int calculateAdjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(this.text, r0, false, this.state);
            if (calculateAdjacentCursorPosition != r0) {
                setCursor(calculateAdjacentCursorPosition);
            }
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorNext() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            int r0 = TextRange.m6559getEndimpl(this.selection);
            int calculateAdjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(this.text, r0, true, this.state);
            if (calculateAdjacentCursorPosition != r0) {
                setCursor(calculateAdjacentCursorPosition);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToHome() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            setCursor(0);
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToEnd() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            setCursor(this.text.length());
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorLeftByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            if (isLtr()) {
                moveCursorPrevByWord();
                return this;
            }
            moveCursorNextByWord();
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorRightByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            if (isLtr()) {
                moveCursorNextByWord();
                return this;
            }
            moveCursorPrevByWord();
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorNextByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            setCursor(getNextWordOffset());
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorPrevByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            setCursor(getPreviousWordOffset());
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorPrevByParagraph() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            int findParagraphStart = StringHelpersKt.findParagraphStart(this.text, TextRange.m6562getMinimpl(this.selection));
            if (findParagraphStart == TextRange.m6562getMinimpl(this.selection) && findParagraphStart != 0) {
                findParagraphStart = StringHelpersKt.findParagraphStart(this.text, findParagraphStart - 1);
            }
            setCursor(findParagraphStart);
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorNextByParagraph() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            int findParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, TextRange.m6561getMaximpl(this.selection));
            if (findParagraphEnd == TextRange.m6561getMaximpl(this.selection) && findParagraphEnd != this.text.length()) {
                findParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, findParagraphEnd + 1);
            }
            setCursor(findParagraphEnd);
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineStart() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            setCursor(getLineStartByOffset());
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineEnd() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            setCursor(getLineEndByOffset());
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineLeftSide() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            if (isLtr()) {
                moveCursorToLineStart();
                return this;
            }
            moveCursorToLineEnd();
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineRightSide() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            if (isLtr()) {
                moveCursorToLineEnd();
                return this;
            }
            moveCursorToLineStart();
        }
        return this;
    }

    public final TextFieldPreparedSelection selectMovement() {
        if (this.text.length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            this.selection = TextRangeKt.TextRange(TextRange.m6564getStartimpl(this.initialValue.m1312getSelectiond9O1mEE()), TextRange.m6559getEndimpl(this.selection));
        }
        return this;
    }
}
