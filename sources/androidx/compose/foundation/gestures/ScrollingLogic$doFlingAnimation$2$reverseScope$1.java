package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"androidx/compose/foundation/gestures/ScrollingLogic$doFlingAnimation$2$reverseScope$1", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollBy", "", "pixels", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class ScrollingLogic$doFlingAnimation$2$reverseScope$1 implements ScrollScope {
    final /* synthetic */ NestedScrollScope $nestedScrollScope;
    final /* synthetic */ ScrollingLogic this$0;

    ScrollingLogic$doFlingAnimation$2$reverseScope$1(ScrollingLogic scrollingLogic, NestedScrollScope nestedScrollScope) {
        this.this$0 = scrollingLogic;
        this.$nestedScrollScope = nestedScrollScope;
    }

    public float scrollBy(float f) {
        ScrollingLogic scrollingLogic = this.this$0;
        return scrollingLogic.reverseIfNeeded(scrollingLogic.m555toFloatk4lQ0M(this.$nestedScrollScope.m494scrollByWithOverscrollOzD1aCk(scrollingLogic.m553reverseIfNeededMKHz9U(scrollingLogic.m556toOffsettuRUvjQ(f)), NestedScrollSource.Companion.m5480getSideEffectWNlRxjI())));
    }
}
