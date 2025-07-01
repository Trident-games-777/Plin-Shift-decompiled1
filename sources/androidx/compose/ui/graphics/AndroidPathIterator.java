package androidx.compose.ui.graphics;

import android.graphics.Path;
import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathSegment;
import androidx.graphics.path.PathIterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0016H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPathIterator;", "Landroidx/compose/ui/graphics/PathIterator;", "path", "Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;F)V", "getConicEvaluation", "()Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "implementation", "Landroidx/graphics/path/PathIterator;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "segmentPoints", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/compose/ui/graphics/PathSegment;", "Landroidx/compose/ui/graphics/PathSegment$Type;", "outPoints", "offset", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPathIterator.android.kt */
final class AndroidPathIterator implements PathIterator {
    private final PathIterator.ConicEvaluation conicEvaluation;
    private final androidx.graphics.path.PathIterator implementation;
    private final Path path;
    private final float[] segmentPoints = new float[8];
    private final float tolerance;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidPathIterator.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        static {
            /*
                androidx.compose.ui.graphics.PathIterator$ConicEvaluation[] r0 = androidx.compose.ui.graphics.PathIterator.ConicEvaluation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                androidx.compose.ui.graphics.PathIterator$ConicEvaluation r2 = androidx.compose.ui.graphics.PathIterator.ConicEvaluation.AsConic     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                androidx.compose.ui.graphics.PathIterator$ConicEvaluation r3 = androidx.compose.ui.graphics.PathIterator.ConicEvaluation.AsQuadratics     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                androidx.compose.ui.graphics.PathSegment$Type[] r0 = androidx.compose.ui.graphics.PathSegment.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.graphics.PathSegment$Type r3 = androidx.compose.ui.graphics.PathSegment.Type.Move     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Line     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Quadratic     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Conic     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Cubic     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidPathIterator.WhenMappings.<clinit>():void");
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public AndroidPathIterator(Path path2, PathIterator.ConicEvaluation conicEvaluation2, float f) {
        PathIterator.ConicEvaluation conicEvaluation3;
        this.path = path2;
        this.conicEvaluation = conicEvaluation2;
        this.tolerance = f;
        Path path3 = getPath();
        if (path3 instanceof AndroidPath) {
            Path internalPath = ((AndroidPath) path3).getInternalPath();
            int i = WhenMappings.$EnumSwitchMapping$0[getConicEvaluation().ordinal()];
            if (i == 1) {
                conicEvaluation3 = PathIterator.ConicEvaluation.AsConic;
            } else if (i == 2) {
                conicEvaluation3 = PathIterator.ConicEvaluation.AsQuadratics;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.implementation = new androidx.graphics.path.PathIterator(internalPath, conicEvaluation3, getTolerance());
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public Path getPath() {
        return this.path;
    }

    public PathIterator.ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    public float getTolerance() {
        return this.tolerance;
    }

    public int calculateSize(boolean z) {
        return this.implementation.calculateSize(z);
    }

    public boolean hasNext() {
        return this.implementation.hasNext();
    }

    public PathSegment.Type next(float[] fArr, int i) {
        return AndroidPathIterator_androidKt.toPathSegmentType(this.implementation.next(fArr, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.graphics.PathSegment next() {
        /*
            r11 = this;
            float[] r0 = r11.segmentPoints
            androidx.graphics.path.PathIterator r1 = r11.implementation
            r2 = 0
            androidx.graphics.path.PathSegment$Type r1 = r1.next(r0, r2)
            androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.AndroidPathIterator_androidKt.toPathSegmentType(r1)
            androidx.compose.ui.graphics.PathSegment$Type r3 = androidx.compose.ui.graphics.PathSegment.Type.Done
            if (r1 != r3) goto L_0x0016
            androidx.compose.ui.graphics.PathSegment r0 = androidx.compose.ui.graphics.PathSegmentKt.getDoneSegment()
            return r0
        L_0x0016:
            androidx.compose.ui.graphics.PathSegment$Type r3 = androidx.compose.ui.graphics.PathSegment.Type.Close
            if (r1 != r3) goto L_0x001f
            androidx.compose.ui.graphics.PathSegment r0 = androidx.compose.ui.graphics.PathSegmentKt.getCloseSegment()
            return r0
        L_0x001f:
            int[] r3 = androidx.compose.ui.graphics.AndroidPathIterator.WhenMappings.$EnumSwitchMapping$1
            int r4 = r1.ordinal()
            r3 = r3[r4]
            r4 = 6
            r5 = 2
            r6 = 1
            if (r3 == r6) goto L_0x00aa
            r7 = 4
            r8 = 3
            if (r3 == r5) goto L_0x0097
            r9 = 5
            if (r3 == r8) goto L_0x007c
            if (r3 == r7) goto L_0x0061
            if (r3 == r9) goto L_0x003b
            float[] r2 = new float[r2]
            goto L_0x00b5
        L_0x003b:
            r3 = 8
            float[] r3 = new float[r3]
            r10 = r0[r2]
            r3[r2] = r10
            r2 = r0[r6]
            r3[r6] = r2
            r2 = r0[r5]
            r3[r5] = r2
            r2 = r0[r8]
            r3[r8] = r2
            r2 = r0[r7]
            r3[r7] = r2
            r2 = r0[r9]
            r3[r9] = r2
            r2 = r0[r4]
            r3[r4] = r2
            r2 = 7
            r5 = r0[r2]
            r3[r2] = r5
            goto L_0x00b4
        L_0x0061:
            float[] r3 = new float[r4]
            r10 = r0[r2]
            r3[r2] = r10
            r2 = r0[r6]
            r3[r6] = r2
            r2 = r0[r5]
            r3[r5] = r2
            r2 = r0[r8]
            r3[r8] = r2
            r2 = r0[r7]
            r3[r7] = r2
            r2 = r0[r9]
            r3[r9] = r2
            goto L_0x00b4
        L_0x007c:
            float[] r3 = new float[r4]
            r10 = r0[r2]
            r3[r2] = r10
            r2 = r0[r6]
            r3[r6] = r2
            r2 = r0[r5]
            r3[r5] = r2
            r2 = r0[r8]
            r3[r8] = r2
            r2 = r0[r7]
            r3[r7] = r2
            r2 = r0[r9]
            r3[r9] = r2
            goto L_0x00b4
        L_0x0097:
            float[] r3 = new float[r7]
            r7 = r0[r2]
            r3[r2] = r7
            r2 = r0[r6]
            r3[r6] = r2
            r2 = r0[r5]
            r3[r5] = r2
            r2 = r0[r8]
            r3[r8] = r2
            goto L_0x00b4
        L_0x00aa:
            float[] r3 = new float[r5]
            r5 = r0[r2]
            r3[r2] = r5
            r2 = r0[r6]
            r3[r6] = r2
        L_0x00b4:
            r2 = r3
        L_0x00b5:
            androidx.compose.ui.graphics.PathSegment r3 = new androidx.compose.ui.graphics.PathSegment
            androidx.compose.ui.graphics.PathSegment$Type r5 = androidx.compose.ui.graphics.PathSegment.Type.Conic
            if (r1 != r5) goto L_0x00be
            r0 = r0[r4]
            goto L_0x00bf
        L_0x00be:
            r0 = 0
        L_0x00bf:
            r3.<init>(r1, r2, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidPathIterator.next():androidx.compose.ui.graphics.PathSegment");
    }
}
