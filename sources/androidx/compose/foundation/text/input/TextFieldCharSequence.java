package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001J\u0013\u0010\u001a\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001bH\u0002J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0006\u0010 \u001a\u00020\u0018J\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0016J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fJ\b\u0010+\u001a\u00020,H\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "text", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/Pair;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getHighlight", "()Lkotlin/Pair;", "length", "", "getLength", "()I", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/CharSequence;", "contentEquals", "", "other", "equals", "", "get", "", "index", "hashCode", "shouldShowSelection", "subSequence", "startIndex", "endIndex", "toCharArray", "", "destination", "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCharSequence.kt */
public final class TextFieldCharSequence implements CharSequence {
    public static final int $stable = 8;
    private final TextRange composition;
    private final Pair<TextHighlightType, TextRange> highlight;
    private final long selection;
    private final CharSequence text;

    public /* synthetic */ TextFieldCharSequence(CharSequence charSequence, long j, TextRange textRange, Pair pair, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, j, textRange, pair);
    }

    private TextFieldCharSequence(CharSequence charSequence, long j, TextRange textRange, Pair<TextHighlightType, TextRange> pair) {
        this.text = charSequence instanceof TextFieldCharSequence ? ((TextFieldCharSequence) charSequence).text : charSequence;
        this.selection = TextRangeKt.m6570coerceIn8ffj60Q(j, 0, charSequence.length());
        Pair<TextHighlightType, TextRange> pair2 = null;
        this.composition = textRange != null ? TextRange.m6552boximpl(TextRangeKt.m6570coerceIn8ffj60Q(textRange.m6568unboximpl(), 0, charSequence.length())) : null;
        this.highlight = pair != null ? Pair.copy$default(pair, (Object) null, TextRange.m6552boximpl(TextRangeKt.m6570coerceIn8ffj60Q(pair.getSecond().m6568unboximpl(), 0, charSequence.length())), 1, (Object) null) : pair2;
    }

    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final /* bridge */ int length() {
        return getLength();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldCharSequence(String str, long j, TextRange textRange, Pair pair, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? TextRange.Companion.m6569getZerod9O1mEE() : j, (i & 4) != 0 ? null : textRange, (i & 8) != 0 ? null : pair, (DefaultConstructorMarker) null);
    }

    public int getLength() {
        return this.text.length();
    }

    public final CharSequence getText() {
        return this.text;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m1312getSelectiond9O1mEE() {
        return this.selection;
    }

    /* renamed from: getComposition-MzsxiRA  reason: not valid java name */
    public final TextRange m1311getCompositionMzsxiRA() {
        return this.composition;
    }

    public final Pair<TextHighlightType, TextRange> getHighlight() {
        return this.highlight;
    }

    public char get(int i) {
        return this.text.charAt(i);
    }

    public CharSequence subSequence(int i, int i2) {
        return this.text.subSequence(i, i2);
    }

    public String toString() {
        return this.text.toString();
    }

    public final boolean contentEquals(CharSequence charSequence) {
        return StringsKt.contentEquals(this.text, charSequence);
    }

    public final void toCharArray(char[] cArr, int i, int i2, int i3) {
        ToCharArray_androidKt.toCharArray(this.text, cArr, i, i2, i3);
    }

    public final boolean shouldShowSelection() {
        return this.highlight == null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextFieldCharSequence textFieldCharSequence = (TextFieldCharSequence) obj;
        return TextRange.m6557equalsimpl0(this.selection, textFieldCharSequence.selection) && Intrinsics.areEqual((Object) this.composition, (Object) textFieldCharSequence.composition) && Intrinsics.areEqual((Object) this.highlight, (Object) textFieldCharSequence.highlight) && contentEquals(textFieldCharSequence.text);
    }

    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + TextRange.m6565hashCodeimpl(this.selection)) * 31;
        TextRange textRange = this.composition;
        int i = 0;
        int r0 = (hashCode + (textRange != null ? TextRange.m6565hashCodeimpl(textRange.m6568unboximpl()) : 0)) * 31;
        Pair<TextHighlightType, TextRange> pair = this.highlight;
        if (pair != null) {
            i = pair.hashCode();
        }
        return r0 + i;
    }
}
