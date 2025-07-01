package androidx.compose.ui.text.android.selection;

import android.text.SegmentFinder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/text/android/selection/Api34SegmentFinder$toAndroidSegmentFinder$1", "Landroid/text/SegmentFinder;", "nextEndBoundary", "", "offset", "nextStartBoundary", "previousEndBoundary", "previousStartBoundary", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentFinder.android.kt */
public final class Api34SegmentFinder$toAndroidSegmentFinder$1 extends SegmentFinder {
    final /* synthetic */ SegmentFinder $this_toAndroidSegmentFinder;

    Api34SegmentFinder$toAndroidSegmentFinder$1(SegmentFinder segmentFinder) {
        this.$this_toAndroidSegmentFinder = segmentFinder;
    }

    public int previousStartBoundary(int i) {
        return this.$this_toAndroidSegmentFinder.previousStartBoundary(i);
    }

    public int previousEndBoundary(int i) {
        return this.$this_toAndroidSegmentFinder.previousEndBoundary(i);
    }

    public int nextStartBoundary(int i) {
        return this.$this_toAndroidSegmentFinder.nextStartBoundary(i);
    }

    public int nextEndBoundary(int i) {
        return this.$this_toAndroidSegmentFinder.nextEndBoundary(i);
    }
}
