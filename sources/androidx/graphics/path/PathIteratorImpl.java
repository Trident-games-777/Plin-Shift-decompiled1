package androidx.graphics.path;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.graphics.path.PathIterator;
import androidx.graphics.path.PathSegment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000 !2\u00020\u0001:\u0001!B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0014H&J\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u0012H&J\b\u0010 \u001a\u00020\u0019H&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Landroidx/graphics/path/PathIteratorImpl;", "", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "getConicEvaluation", "()Landroidx/graphics/path/PathIterator$ConicEvaluation;", "getPath", "()Landroid/graphics/Path;", "pointsData", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "floatsToPoints", "", "Landroid/graphics/PointF;", "type", "Landroidx/graphics/path/PathSegment$Type;", "([FLandroidx/graphics/path/PathSegment$Type;)[Landroid/graphics/PointF;", "hasNext", "next", "Landroidx/graphics/path/PathSegment;", "points", "offset", "peek", "Companion", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathIteratorImpl.kt */
public abstract class PathIteratorImpl {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final PathIterator.ConicEvaluation conicEvaluation;
    private final Path path;
    private final float[] pointsData;
    private final float tolerance;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PathIteratorImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.graphics.path.PathSegment$Type[] r0 = androidx.graphics.path.PathSegment.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Move     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Line     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Quadratic     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Conic     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.graphics.path.PathSegment$Type r1 = androidx.graphics.path.PathSegment.Type.Cubic     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.path.PathIteratorImpl.WhenMappings.<clinit>():void");
        }
    }

    public abstract int calculateSize(boolean z);

    public abstract boolean hasNext();

    public abstract PathSegment.Type next(float[] fArr, int i);

    public abstract PathSegment.Type peek();

    public PathIteratorImpl(Path path2, PathIterator.ConicEvaluation conicEvaluation2, float f) {
        Intrinsics.checkNotNullParameter(path2, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation2, "conicEvaluation");
        this.path = path2;
        this.conicEvaluation = conicEvaluation2;
        this.tolerance = f;
        this.pointsData = new float[8];
    }

    public final Path getPath() {
        return this.path;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PathIteratorImpl(Path path2, PathIterator.ConicEvaluation conicEvaluation2, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(path2, (i & 2) != 0 ? PathIterator.ConicEvaluation.AsQuadratics : conicEvaluation2, (i & 4) != 0 ? 0.25f : f);
    }

    public final PathIterator.ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    public final float getTolerance() {
        return this.tolerance;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/graphics/path/PathIteratorImpl$Companion;", "", "()V", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PathIteratorImpl.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        System.loadLibrary("androidx.graphics.path");
    }

    public static /* synthetic */ PathSegment.Type next$default(PathIteratorImpl pathIteratorImpl, float[] fArr, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return pathIteratorImpl.next(fArr, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: next");
    }

    public final PathSegment next() {
        PathSegment.Type next = next(this.pointsData, 0);
        if (next == PathSegment.Type.Done) {
            return PathSegmentUtilities.getDoneSegment();
        }
        if (next == PathSegment.Type.Close) {
            return PathSegmentUtilities.getCloseSegment();
        }
        return new PathSegment(next, floatsToPoints(this.pointsData, next), next == PathSegment.Type.Conic ? this.pointsData[6] : 0.0f);
    }

    private final PointF[] floatsToPoints(float[] fArr, PathSegment.Type type) {
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return new PointF[]{new PointF(fArr[0], fArr[1])};
        } else if (i == 2) {
            return new PointF[]{new PointF(fArr[0], fArr[1]), new PointF(fArr[2], fArr[3])};
        } else if (i == 3 || i == 4) {
            return new PointF[]{new PointF(fArr[0], fArr[1]), new PointF(fArr[2], fArr[3]), new PointF(fArr[4], fArr[5])};
        } else if (i != 5) {
            return new PointF[0];
        } else {
            return new PointF[]{new PointF(fArr[0], fArr[1]), new PointF(fArr[2], fArr[3]), new PointF(fArr[4], fArr[5]), new PointF(fArr[6], fArr[7])};
        }
    }
}
