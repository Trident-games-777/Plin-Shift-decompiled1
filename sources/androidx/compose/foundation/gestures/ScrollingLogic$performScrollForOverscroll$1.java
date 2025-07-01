package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "delta", "invoke-MK-Hz9U", "(J)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollingLogic$performScrollForOverscroll$1 extends Lambda implements Function1<Offset, Offset> {
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$performScrollForOverscroll$1(ScrollingLogic scrollingLogic) {
        super(1);
        this.this$0 = scrollingLogic;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.m3976boximpl(m560invokeMKHz9U(((Offset) obj).m3997unboximpl()));
    }

    /* renamed from: invoke-MK-Hz9U  reason: not valid java name */
    public final long m560invokeMKHz9U(long j) {
        ScrollScope access$getOuterStateScope$p = this.this$0.outerStateScope;
        ScrollingLogic scrollingLogic = this.this$0;
        return scrollingLogic.m546performScroll3eAAhYA(access$getOuterStateScope$p, j, scrollingLogic.latestScrollSource);
    }
}
