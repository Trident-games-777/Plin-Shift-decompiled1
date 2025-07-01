package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Rect;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScrollIntoViewRequester.kt */
final class ScrollIntoView__ScrollIntoViewRequesterKt$scrollIntoView$2 extends Lambda implements Function0<Rect> {
    final /* synthetic */ LayoutCoordinates $layoutCoordinates;
    final /* synthetic */ Rect $rect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollIntoView__ScrollIntoViewRequesterKt$scrollIntoView$2(Rect rect, LayoutCoordinates layoutCoordinates) {
        super(0);
        this.$rect = rect;
        this.$layoutCoordinates = layoutCoordinates;
    }

    public final Rect invoke() {
        Rect rect = this.$rect;
        if (rect != null) {
            return rect;
        }
        LayoutCoordinates layoutCoordinates = this.$layoutCoordinates;
        if (!layoutCoordinates.isAttached()) {
            layoutCoordinates = null;
        }
        if (layoutCoordinates != null) {
            return SizeKt.m4077toRectuvyYCjk(IntSizeKt.m7295toSizeozmzZPI(layoutCoordinates.m5800getSizeYbymL2g()));
        }
        return null;
    }
}
