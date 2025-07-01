package androidx.compose.ui.text.android.selection;

import android.text.TextPaint;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinderApi29;", "Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "text", "", "textPaint", "Landroid/text/TextPaint;", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;)V", "next", "", "offset", "previous", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentFinder.android.kt */
public final class GraphemeClusterSegmentFinderApi29 extends GraphemeClusterSegmentFinder {
    public static final int $stable = 8;
    private final CharSequence text;
    private final TextPaint textPaint;

    public GraphemeClusterSegmentFinderApi29(CharSequence charSequence, TextPaint textPaint2) {
        this.text = charSequence;
        this.textPaint = textPaint2;
    }

    public int previous(int i) {
        TextPaint textPaint2 = this.textPaint;
        CharSequence charSequence = this.text;
        return textPaint2.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 2);
    }

    public int next(int i) {
        TextPaint textPaint2 = this.textPaint;
        CharSequence charSequence = this.text;
        return textPaint2.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 0);
    }
}
