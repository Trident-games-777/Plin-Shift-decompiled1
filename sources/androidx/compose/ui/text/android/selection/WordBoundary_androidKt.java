package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"getWordEnd", "", "Landroidx/compose/ui/text/android/selection/WordIterator;", "offset", "getWordStart", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WordBoundary.android.kt */
public final class WordBoundary_androidKt {
    public static final int getWordStart(WordIterator wordIterator, int i) {
        int i2;
        if (wordIterator.isOnPunctuation(wordIterator.prevBoundary(i))) {
            i2 = wordIterator.getPunctuationBeginning(i);
        } else {
            i2 = wordIterator.getPrevWordBeginningOnTwoWordsBoundary(i);
        }
        return i2 == -1 ? i : i2;
    }

    public static final int getWordEnd(WordIterator wordIterator, int i) {
        int i2;
        if (wordIterator.isAfterPunctuation(wordIterator.nextBoundary(i))) {
            i2 = wordIterator.getPunctuationEnd(i);
        } else {
            i2 = wordIterator.getNextWordEndOnTwoWordBoundary(i);
        }
        return i2 == -1 ? i : i2;
    }
}
