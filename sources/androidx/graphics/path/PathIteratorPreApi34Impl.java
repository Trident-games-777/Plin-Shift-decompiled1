package androidx.graphics.path;

import android.graphics.Path;
import androidx.graphics.path.PathIterator;
import androidx.graphics.path.PathSegment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J!\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH J\b\u0010\u0012\u001a\u00020\u0011H\u0004J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0011\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH J!\u0010\u0015\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH J\u0011\u0010\u0019\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH J\u0011\u0010\u001a\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH J\u0011\u0010\u001b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/graphics/path/PathIteratorPreApi34Impl;", "Landroidx/graphics/path/PathIteratorImpl;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "internalPathIterator", "", "calculateSize", "", "includeConvertedConics", "", "createInternalPathIterator", "destroyInternalPathIterator", "", "finalize", "hasNext", "internalPathIteratorHasNext", "internalPathIteratorNext", "points", "", "offset", "internalPathIteratorPeek", "internalPathIteratorRawSize", "internalPathIteratorSize", "next", "Landroidx/graphics/path/PathSegment$Type;", "peek", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathIteratorImpl.kt */
public final class PathIteratorPreApi34Impl extends PathIteratorImpl {
    private final long internalPathIterator;

    private final native long createInternalPathIterator(Path path, int i, float f);

    private final native void destroyInternalPathIterator(long j);

    private final native boolean internalPathIteratorHasNext(long j);

    private final native int internalPathIteratorNext(long j, float[] fArr, int i);

    private final native int internalPathIteratorPeek(long j);

    private final native int internalPathIteratorRawSize(long j);

    private final native int internalPathIteratorSize(long j);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PathIteratorPreApi34Impl(Path path, PathIterator.ConicEvaluation conicEvaluation, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(path, (i & 2) != 0 ? PathIterator.ConicEvaluation.AsQuadratics : conicEvaluation, (i & 4) != 0 ? 0.25f : f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PathIteratorPreApi34Impl(Path path, PathIterator.ConicEvaluation conicEvaluation, float f) {
        super(path, conicEvaluation, f);
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        this.internalPathIterator = createInternalPathIterator(path, conicEvaluation.ordinal(), f);
    }

    public int calculateSize(boolean z) {
        if (!z || getConicEvaluation() == PathIterator.ConicEvaluation.AsConic) {
            return internalPathIteratorRawSize(this.internalPathIterator);
        }
        return internalPathIteratorSize(this.internalPathIterator);
    }

    public boolean hasNext() {
        return internalPathIteratorHasNext(this.internalPathIterator);
    }

    public PathSegment.Type peek() {
        return PathIteratorImplKt.PathSegmentTypes[internalPathIteratorPeek(this.internalPathIterator)];
    }

    public PathSegment.Type next(float[] fArr, int i) {
        Intrinsics.checkNotNullParameter(fArr, "points");
        return PathIteratorImplKt.PathSegmentTypes[internalPathIteratorNext(this.internalPathIterator, fArr, i)];
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        destroyInternalPathIterator(this.internalPathIterator);
    }
}
