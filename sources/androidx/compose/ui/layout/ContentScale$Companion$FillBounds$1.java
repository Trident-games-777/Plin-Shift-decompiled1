package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"androidx/compose/ui/layout/ContentScale$Companion$FillBounds$1", "Landroidx/compose/ui/layout/ContentScale;", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentScale.kt */
public final class ContentScale$Companion$FillBounds$1 implements ContentScale {
    ContentScale$Companion$FillBounds$1() {
    }

    /* renamed from: computeScaleFactor-H7hwNQA  reason: not valid java name */
    public long m5766computeScaleFactorH7hwNQA(long j, long j2) {
        return ScaleFactorKt.ScaleFactor(ContentScaleKt.m5778computeFillWidthiLBOSCw(j, j2), ContentScaleKt.m5775computeFillHeightiLBOSCw(j, j2));
    }
}
