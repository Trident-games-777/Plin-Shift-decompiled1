package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import java.text.BreakIterator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"minIntrinsicWidth", "", "text", "", "paint", "Landroid/text/TextPaint;", "shouldIncreaseMaxIntrinsic", "", "desiredWidth", "charSequence", "textPaint", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutIntrinsics.android.kt */
public final class LayoutIntrinsics_androidKt {
    public static final float minIntrinsicWidth(CharSequence charSequence, TextPaint textPaint) {
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        int i = 0;
        lineInstance.setText(new CharSequenceCharacterIterator(charSequence, 0, charSequence.length()));
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(10, new LayoutIntrinsics_androidKt$$ExternalSyntheticLambda0());
        int next = lineInstance.next();
        while (true) {
            int i2 = i;
            i = next;
            int i3 = i2;
            if (i == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new Pair(Integer.valueOf(i3), Integer.valueOf(i)));
            } else {
                Pair pair = (Pair) priorityQueue.peek();
                if (pair != null && ((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue() < i - i3) {
                    priorityQueue.poll();
                    priorityQueue.add(new Pair(Integer.valueOf(i3), Integer.valueOf(i)));
                }
            }
            next = lineInstance.next();
        }
        float f = 0.0f;
        for (Pair pair2 : priorityQueue) {
            f = Math.max(f, Layout.getDesiredWidth(charSequence, ((Number) pair2.component1()).intValue(), ((Number) pair2.component2()).intValue(), textPaint));
        }
        return f;
    }

    /* access modifiers changed from: private */
    public static final int minIntrinsicWidth$lambda$0(Pair pair, Pair pair2) {
        return (((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue()) - (((Number) pair2.getSecond()).intValue() - ((Number) pair2.getFirst()).intValue());
    }

    /* access modifiers changed from: private */
    public static final boolean shouldIncreaseMaxIntrinsic(float f, CharSequence charSequence, TextPaint textPaint) {
        if (f == 0.0f) {
            return false;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            if (SpannedExtensions_androidKt.hasSpan(spanned, LetterSpacingSpanPx.class) || SpannedExtensions_androidKt.hasSpan(spanned, LetterSpacingSpanEm.class)) {
                return true;
            }
        }
        return textPaint.getLetterSpacing() != 0.0f;
    }
}
