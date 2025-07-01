package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "scrollBy", "Landroidx/compose/ui/geometry/Offset;", "offset", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "scrollBy-OzD1aCk", "(JI)J", "scrollByWithOverscroll", "scrollByWithOverscroll-OzD1aCk", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class ScrollingLogic$nestedScrollScope$1 implements NestedScrollScope {
    final /* synthetic */ ScrollingLogic this$0;

    ScrollingLogic$nestedScrollScope$1(ScrollingLogic scrollingLogic) {
        this.this$0 = scrollingLogic;
    }

    /* renamed from: scrollBy-OzD1aCk  reason: not valid java name */
    public long m557scrollByOzD1aCk(long j, int i) {
        return this.this$0.m546performScroll3eAAhYA(this.this$0.outerStateScope, j, i);
    }

    /* renamed from: scrollByWithOverscroll-OzD1aCk  reason: not valid java name */
    public long m558scrollByWithOverscrollOzD1aCk(long j, int i) {
        this.this$0.latestScrollSource = i;
        OverscrollEffect access$getOverscrollEffect$p = this.this$0.overscrollEffect;
        if (access$getOverscrollEffect$p != null && this.this$0.getShouldDispatchOverscroll()) {
            return access$getOverscrollEffect$p.m345applyToScrollRhakbz0(j, this.this$0.latestScrollSource, this.this$0.performScrollForOverscroll);
        }
        return this.this$0.m546performScroll3eAAhYA(this.this$0.outerStateScope, j, i);
    }
}
