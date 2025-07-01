package androidx.graphics.path;

import android.graphics.Path;
import android.graphics.PathIterator;
import androidx.graphics.path.PathIterator;
import androidx.graphics.path.PathSegment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/graphics/path/PathIteratorApi34Impl;", "Landroidx/graphics/path/PathIteratorImpl;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "conicConverter", "Landroidx/graphics/path/ConicConverter;", "platformIterator", "Landroid/graphics/PathIterator;", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/graphics/path/PathSegment$Type;", "points", "", "offset", "peek", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathIteratorImpl.kt */
public final class PathIteratorApi34Impl extends PathIteratorImpl {
    private final ConicConverter conicConverter;
    private final PathIterator platformIterator;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PathIteratorApi34Impl(Path path, PathIterator.ConicEvaluation conicEvaluation, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(path, (i & 2) != 0 ? PathIterator.ConicEvaluation.AsQuadratics : conicEvaluation, (i & 4) != 0 ? 0.25f : f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PathIteratorApi34Impl(Path path, PathIterator.ConicEvaluation conicEvaluation, float f) {
        super(path, conicEvaluation, f);
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        android.graphics.PathIterator pathIterator = path.getPathIterator();
        Intrinsics.checkNotNullExpressionValue(pathIterator, "path.pathIterator");
        this.platformIterator = pathIterator;
        this.conicConverter = new ConicConverter();
    }

    public int calculateSize(boolean z) {
        boolean z2 = z && getConicEvaluation() == PathIterator.ConicEvaluation.AsQuadratics;
        android.graphics.PathIterator pathIterator = getPath().getPathIterator();
        Intrinsics.checkNotNullExpressionValue(pathIterator, "path.pathIterator");
        float[] fArr = new float[8];
        int i = 0;
        while (pathIterator.hasNext()) {
            if (pathIterator.next(fArr, 0) != 3 || !z2) {
                i++;
            } else {
                ConicConverter conicConverter2 = this.conicConverter;
                ConicConverter.convert$default(conicConverter2, fArr, fArr[6], getTolerance(), 0, 8, (Object) null);
                i += conicConverter2.getQuadraticCount();
            }
        }
        return i;
    }

    public PathSegment.Type next(float[] fArr, int i) {
        Intrinsics.checkNotNullParameter(fArr, "points");
        if (this.conicConverter.getCurrentQuadratic() < this.conicConverter.getQuadraticCount()) {
            this.conicConverter.nextQuadratic(fArr, i);
            return PathSegment.Type.Quadratic;
        }
        PathSegment.Type access$platformToAndroidXSegmentType = PathIteratorImplKt.platformToAndroidXSegmentType(this.platformIterator.next(fArr, i));
        if (access$platformToAndroidXSegmentType != PathSegment.Type.Conic || getConicEvaluation() != PathIterator.ConicEvaluation.AsQuadratics) {
            return access$platformToAndroidXSegmentType;
        }
        ConicConverter conicConverter2 = this.conicConverter;
        conicConverter2.convert(fArr, fArr[i + 6], getTolerance(), i);
        if (conicConverter2.getQuadraticCount() > 0) {
            conicConverter2.nextQuadratic(fArr, i);
        }
        return PathSegment.Type.Quadratic;
    }

    public boolean hasNext() {
        return this.platformIterator.hasNext();
    }

    public PathSegment.Type peek() {
        return PathIteratorImplKt.platformToAndroidXSegmentType(this.platformIterator.peek());
    }
}
