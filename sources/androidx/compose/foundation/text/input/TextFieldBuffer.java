package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.OffsetMappingCalculator;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001TB1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0014\u0010/\u001a\u00060\u0001j\u0002`\u00022\u0006\u00100\u001a\u000201H\u0016J\u0016\u0010/\u001a\u00060\u0001j\u0002`\u00022\b\u00102\u001a\u0004\u0018\u00010#H\u0016J&\u0010/\u001a\u00060\u0001j\u0002`\u00022\b\u00102\u001a\u0004\u0018\u00010#2\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001bH\u0016J\u0006\u00105\u001a\u00020#J\u000e\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u001bJ\b\u00108\u001a\u000209H\u0002J \u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001bH\u0002J\u000e\u0010>\u001a\u0002092\u0006\u00107\u001a\u00020\u001bJ\u000e\u0010?\u001a\u0002092\u0006\u00107\u001a\u00020\u001bJ\u001e\u0010@\u001a\u0002092\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001b2\u0006\u00102\u001a\u00020#J9\u0010@\u001a\u0002092\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001b2\u0006\u00102\u001a\u00020#2\b\b\u0002\u0010A\u001a\u00020\u001b2\b\b\u0002\u0010B\u001a\u00020\u001bH\u0000¢\u0006\u0002\bCJ \u0010D\u001a\u0002092\u0006\u00107\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u0018H\u0002J\u001a\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\bI\u0010,J\u0006\u0010J\u001a\u000209J\u0015\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020#H\u0000¢\u0006\u0002\bMJ\b\u0010N\u001a\u00020OH\u0016J(\u0010P\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u001f2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\bR\u0010SR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128FX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\u00020\u001f8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R*\u0010)\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001f8F@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b*\u0010!\"\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u001fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010.\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006U"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialChanges", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "originalValue", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/ChangeTracker;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "backingChangeTracker", "buffer", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "changeTracker", "getChangeTracker", "()Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "getChanges$annotations", "()V", "getChanges", "()Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "hasSelection", "", "()Z", "length", "", "getLength", "()I", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "getOriginalSelection-d9O1mEE", "()J", "originalText", "", "getOriginalText", "()Ljava/lang/CharSequence;", "getOriginalValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "value", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "selectionInChars", "J", "append", "char", "", "text", "start", "end", "asCharSequence", "charAt", "index", "clearChangeList", "", "onTextWillChange", "replaceStart", "replaceEnd", "newLength", "placeCursorAfterCharAt", "placeCursorBeforeCharAt", "replace", "textStart", "textEnd", "replace$foundation_release", "requireValidIndex", "startExclusive", "endExclusive", "requireValidRange", "range", "requireValidRange-5zc-tL8", "revertAllChanges", "setTextIfChanged", "newText", "setTextIfChanged$foundation_release", "toString", "", "toTextFieldCharSequence", "composition", "toTextFieldCharSequence-udt6zUU$foundation_release", "(JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "ChangeList", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldBuffer.kt */
public final class TextFieldBuffer implements Appendable {
    public static final int $stable = 8;
    private ChangeTracker backingChangeTracker;
    private final PartialGapBuffer buffer;
    private final OffsetMappingCalculator offsetMappingCalculator;
    private final TextFieldCharSequence originalValue;
    private long selectionInChars;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "", "changeCount", "", "getChangeCount", "()I", "getOriginalRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getOriginalRange--jx7JFs", "(I)J", "getRange", "getRange--jx7JFs", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldBuffer.kt */
    public interface ChangeList {
        int getChangeCount();

        /* renamed from: getOriginalRange--jx7JFs  reason: not valid java name */
        long m1309getOriginalRangejx7JFs(int i);

        /* renamed from: getRange--jx7JFs  reason: not valid java name */
        long m1310getRangejx7JFs(int i);
    }

    public static /* synthetic */ void getChanges$annotations() {
    }

    public TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2, OffsetMappingCalculator offsetMappingCalculator2) {
        this.originalValue = textFieldCharSequence2;
        this.offsetMappingCalculator = offsetMappingCalculator2;
        this.buffer = new PartialGapBuffer(textFieldCharSequence);
        this.backingChangeTracker = changeTracker != null ? new ChangeTracker(changeTracker) : null;
        this.selectionInChars = textFieldCharSequence.m1312getSelectiond9O1mEE();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2, OffsetMappingCalculator offsetMappingCalculator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldCharSequence, (i & 2) != 0 ? null : changeTracker, (i & 4) != 0 ? textFieldCharSequence : textFieldCharSequence2, (i & 8) != 0 ? null : offsetMappingCalculator2);
    }

    public final TextFieldCharSequence getOriginalValue$foundation_release() {
        return this.originalValue;
    }

    private final ChangeTracker getChangeTracker() {
        ChangeTracker changeTracker = this.backingChangeTracker;
        if (changeTracker != null) {
            return changeTracker;
        }
        ChangeTracker changeTracker2 = new ChangeTracker((ChangeTracker) null, 1, (DefaultConstructorMarker) null);
        this.backingChangeTracker = changeTracker2;
        return changeTracker2;
    }

    public final int getLength() {
        return this.buffer.length();
    }

    public final CharSequence getOriginalText() {
        return this.originalValue.getText();
    }

    /* renamed from: getOriginalSelection-d9O1mEE  reason: not valid java name */
    public final long m1305getOriginalSelectiond9O1mEE() {
        return this.originalValue.m1312getSelectiond9O1mEE();
    }

    public final ChangeList getChanges() {
        return getChangeTracker();
    }

    public final boolean hasSelection() {
        return !TextRange.m6558getCollapsedimpl(m1306getSelectiond9O1mEE());
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m1306getSelectiond9O1mEE() {
        return this.selectionInChars;
    }

    /* renamed from: setSelection-5zc-tL8  reason: not valid java name */
    public final void m1307setSelection5zctL8(long j) {
        m1303requireValidRange5zctL8(j);
        this.selectionInChars = j;
    }

    public final void replace(int i, int i2, CharSequence charSequence) {
        replace$foundation_release(i, i2, charSequence, 0, charSequence.length());
    }

    public static /* synthetic */ void replace$foundation_release$default(TextFieldBuffer textFieldBuffer, int i, int i2, CharSequence charSequence, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = 0;
        }
        int i6 = i3;
        if ((i5 & 16) != 0) {
            i4 = charSequence.length();
        }
        textFieldBuffer.replace$foundation_release(i, i2, charSequence, i6, i4);
    }

    public final void replace$foundation_release(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (i > i2) {
            throw new IllegalArgumentException(("Expected start=" + i + " <= end=" + i2).toString());
        } else if (i3 <= i4) {
            onTextWillChange(i, i2, i4 - i3);
            this.buffer.replace(i, i2, charSequence, i3, i4);
        } else {
            throw new IllegalArgumentException(("Expected textStart=" + i3 + " <= textEnd=" + i4).toString());
        }
    }

    public final void setTextIfChanged$foundation_release(CharSequence charSequence) {
        int i;
        int i2;
        CharSequence charSequence2 = this.buffer;
        int length = charSequence2.length();
        int length2 = charSequence.length();
        boolean z = false;
        if (charSequence2.length() <= 0 || charSequence.length() <= 0) {
            i2 = 0;
            i = 0;
        } else {
            int i3 = 0;
            int i4 = 0;
            boolean z2 = false;
            while (true) {
                if (!z) {
                    if (charSequence2.charAt(i3) == charSequence.charAt(i4)) {
                        i3++;
                        i4++;
                    } else {
                        z = true;
                    }
                }
                if (!z2) {
                    if (charSequence2.charAt(length - 1) == charSequence.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z2 = true;
                    }
                }
                if (i3 >= length || i4 >= length2 || (z && z2)) {
                    i2 = i3;
                    i = i4;
                }
            }
            i2 = i3;
            i = i4;
        }
        int i5 = length;
        int i6 = length2;
        if (i2 < i5 || i < i6) {
            replace$foundation_release(i2, i5, charSequence, i, i6);
        }
    }

    public Appendable append(CharSequence charSequence) {
        TextFieldBuffer textFieldBuffer = this;
        if (charSequence != null) {
            onTextWillChange(getLength(), getLength(), charSequence.length());
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), charSequence, 0, 0, 24, (Object) null);
        }
        return this;
    }

    public Appendable append(CharSequence charSequence, int i, int i2) {
        TextFieldBuffer textFieldBuffer = this;
        if (charSequence != null) {
            onTextWillChange(getLength(), getLength(), i2 - i);
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), charSequence.subSequence(i, i2), 0, 0, 24, (Object) null);
        }
        return this;
    }

    public Appendable append(char c) {
        TextFieldBuffer textFieldBuffer = this;
        onTextWillChange(getLength(), getLength(), 1);
        PartialGapBuffer partialGapBuffer = this.buffer;
        PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), String.valueOf(c), 0, 0, 24, (Object) null);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        if (r5 == r1) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onTextWillChange(int r4, int r5, int r6) {
        /*
            r3 = this;
            androidx.compose.foundation.text.input.internal.ChangeTracker r0 = r3.getChangeTracker()
            r0.trackChange(r4, r5, r6)
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator r0 = r3.offsetMappingCalculator
            if (r0 == 0) goto L_0x000e
            r0.recordEditOperation(r4, r5, r6)
        L_0x000e:
            int r0 = java.lang.Math.min(r4, r5)
            int r4 = java.lang.Math.max(r4, r5)
            long r1 = r3.m1306getSelectiond9O1mEE()
            int r5 = androidx.compose.ui.text.TextRange.m6562getMinimpl(r1)
            long r1 = r3.m1306getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m6561getMaximpl(r1)
            if (r1 >= r0) goto L_0x0029
            return
        L_0x0029:
            if (r5 > r0) goto L_0x0032
            if (r4 > r1) goto L_0x0032
            int r4 = r4 - r0
            int r6 = r6 - r4
            if (r5 != r1) goto L_0x003e
            goto L_0x003d
        L_0x0032:
            if (r5 <= r0) goto L_0x0039
            if (r1 >= r4) goto L_0x0039
            int r0 = r0 + r6
            r5 = r0
            goto L_0x0048
        L_0x0039:
            if (r5 < r4) goto L_0x0041
            int r4 = r4 - r0
            int r6 = r6 - r4
        L_0x003d:
            int r5 = r5 + r6
        L_0x003e:
            int r0 = r1 + r6
            goto L_0x0048
        L_0x0041:
            if (r0 >= r5) goto L_0x0048
            int r5 = r0 + r6
            int r4 = r4 - r0
            int r6 = r6 - r4
            goto L_0x003e
        L_0x0048:
            long r4 = androidx.compose.ui.text.TextRangeKt.TextRange(r5, r0)
            r3.selectionInChars = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.TextFieldBuffer.onTextWillChange(int, int, int):void");
    }

    public final char charAt(int i) {
        return this.buffer.charAt(i);
    }

    public String toString() {
        return this.buffer.toString();
    }

    public final CharSequence asCharSequence() {
        return this.buffer;
    }

    private final void clearChangeList() {
        getChangeTracker().clearChanges();
    }

    public final void revertAllChanges() {
        replace(0, getLength(), this.originalValue.toString());
        m1307setSelection5zctL8(this.originalValue.m1312getSelectiond9O1mEE());
        clearChangeList();
    }

    public final void placeCursorBeforeCharAt(int i) {
        requireValidIndex(i, true, false);
        this.selectionInChars = TextRangeKt.TextRange(i);
    }

    public final void placeCursorAfterCharAt(int i) {
        requireValidIndex(i, false, true);
        this.selectionInChars = TextRangeKt.TextRange(RangesKt.coerceAtMost(i + 1, getLength()));
    }

    /* renamed from: toTextFieldCharSequence-udt6zUU$foundation_release$default  reason: not valid java name */
    public static /* synthetic */ TextFieldCharSequence m1304toTextFieldCharSequenceudt6zUU$foundation_release$default(TextFieldBuffer textFieldBuffer, long j, TextRange textRange, int i, Object obj) {
        if ((i & 1) != 0) {
            j = textFieldBuffer.m1306getSelectiond9O1mEE();
        }
        if ((i & 2) != 0) {
            textRange = null;
        }
        return textFieldBuffer.m1308toTextFieldCharSequenceudt6zUU$foundation_release(j, textRange);
    }

    /* renamed from: toTextFieldCharSequence-udt6zUU$foundation_release  reason: not valid java name */
    public final TextFieldCharSequence m1308toTextFieldCharSequenceudt6zUU$foundation_release(long j, TextRange textRange) {
        return new TextFieldCharSequence(this.buffer.toString(), j, textRange, (Pair) null, 8, (DefaultConstructorMarker) null);
    }

    private final void requireValidIndex(int i, boolean z, boolean z2) {
        int i2 = z ? 0 : -1;
        int length = z2 ? getLength() : getLength() + 1;
        if (i2 > i || i >= length) {
            throw new IllegalArgumentException(("Expected " + i + " to be in [" + i2 + ", " + length + ')').toString());
        }
    }

    /* renamed from: requireValidRange-5zc-tL8  reason: not valid java name */
    private final void m1303requireValidRange5zctL8(long j) {
        long TextRange = TextRangeKt.TextRange(0, getLength());
        if (!TextRange.m6554contains5zctL8(TextRange, j)) {
            throw new IllegalArgumentException(("Expected " + TextRange.m6567toStringimpl(j) + " to be in " + TextRange.m6567toStringimpl(TextRange)).toString());
        }
    }
}
