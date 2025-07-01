package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.IntervalTree;
import androidx.compose.ui.graphics.PathIterator;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/PathHitTester;", "", "()V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "curves", "", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "path", "Landroidx/compose/ui/graphics/Path;", "roots", "tolerance", "", "contains", "", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "updatePath", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathHitTester.kt */
public final class PathHitTester {
    private Rect bounds = Rect.Companion.getZero();
    private final float[] curves = new float[20];
    private final IntervalTree<PathSegment> intervals = new IntervalTree<>();
    private Path path = PathHitTesterKt.EmptyPath;
    private final float[] roots = new float[2];
    private float tolerance = 0.5f;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PathHitTester.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.ui.graphics.PathSegment$Type[] r0 = androidx.compose.ui.graphics.PathSegment.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Line     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Quadratic     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Cubic     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Done     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.PathHitTester.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ void updatePath$default(PathHitTester pathHitTester, Path path2, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        pathHitTester.updatePath(path2, f);
    }

    public final void updatePath(Path path2, float f) {
        this.path = path2;
        this.tolerance = f;
        this.bounds = path2.getBounds();
        this.intervals.clear();
        PathIterator it = path2.iterator(PathIterator.ConicEvaluation.AsQuadratics, f);
        while (it.hasNext()) {
            PathSegment next = it.next();
            int i = WhenMappings.$EnumSwitchMapping$0[next.getType().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                long computeVerticalBounds$default = BezierKt.computeVerticalBounds$default(next, this.curves, 0, 4, (Object) null);
                this.intervals.addInterval(Float.intBitsToFloat((int) (computeVerticalBounds$default >> 32)), Float.intBitsToFloat((int) (computeVerticalBounds$default & 4294967295L)), next);
            } else if (i == 4) {
                return;
            }
        }
    }

    /* renamed from: contains-k-4lQ0M  reason: not valid java name */
    public final boolean m4545containsk4lQ0M(long j) {
        int i;
        int i2;
        if (!this.path.isEmpty() && this.bounds.m4013containsk4lQ0M(j)) {
            float r0 = Offset.m3987getXimpl(j);
            float r12 = Offset.m3988getYimpl(j);
            float[] fArr = this.curves;
            float[] fArr2 = this.roots;
            IntervalTree<PathSegment> intervalTree = this.intervals;
            if (intervalTree.root != intervalTree.terminator) {
                ArrayList access$getStack$p = intervalTree.stack;
                access$getStack$p.add(intervalTree.root);
                i = 0;
                while (access$getStack$p.size() > 0) {
                    IntervalTree.Node node = (IntervalTree.Node) CollectionsKt.removeLast(access$getStack$p);
                    if (node.overlaps(r12, r12)) {
                        Object data = node.getData();
                        Intrinsics.checkNotNull(data);
                        PathSegment pathSegment = (PathSegment) data;
                        float[] points = pathSegment.getPoints();
                        int i3 = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
                        if (i3 == 1) {
                            i2 = BezierKt.lineWinding(points, r0, r12);
                        } else if (i3 == 2) {
                            i2 = BezierKt.quadraticWinding(points, r0, r12, fArr, fArr2);
                        } else if (i3 == 3) {
                            i2 = BezierKt.cubicWinding(points, r0, r12, fArr, fArr2);
                        }
                        i += i2;
                    }
                    if (node.getLeft() != intervalTree.terminator && node.getLeft().getMax() >= r12) {
                        access$getStack$p.add(node.getLeft());
                    }
                    if (node.getRight() != intervalTree.terminator && node.getRight().getMin() <= r12) {
                        access$getStack$p.add(node.getRight());
                    }
                }
                access$getStack$p.clear();
            } else {
                i = 0;
            }
            if (PathFillType.m4539equalsimpl0(this.path.m4527getFillTypeRgk1Os(), PathFillType.Companion.m4543getEvenOddRgk1Os())) {
                i &= 1;
            }
            if (i != 0) {
                return true;
            }
        }
        return false;
    }
}
