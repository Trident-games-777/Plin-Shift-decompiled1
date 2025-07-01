package androidx.compose.ui.graphics;

import androidx.collection.FloatFloatPair;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\t\u001a\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\b\u001a?\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001e\u001a'\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0010\u001e\u001aH\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0000\u001a \u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0002\u001a0\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0000\u001a \u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0007\u001a0\u00103\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a \u00109\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a(\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010;\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010<\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0003H\u0007\u001a\u0018\u0010=\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\u0018H\u0002\u001a(\u0010?\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a(\u0010B\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0007\u001a\u0019\u0010C\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\b\u001a \u0010D\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002\u001a\u0018\u0010E\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0003H\u0007\u001a+\u0010G\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\b\u001a2\u0010H\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002\u001a \u0010I\u001a\u00020A2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0002\u001a \u0010J\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0000\u001a(\u0010K\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002\u001a0\u0010M\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0018H\u0002\u001a\u0018\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0002\u001a0\u0010P\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0000\u001a0\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00182\u0006\u0010U\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u0003H\u0002\u001a \u0010W\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010X\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002\u001a \u0010Y\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0015\u0010Z\u001a\u00020A*\u00020\u00012\u0006\u0010[\u001a\u00020\u0001H\b\u001a\u0015\u0010Z\u001a\u00020A*\u00020\u00032\u0006\u0010[\u001a\u00020\u0003H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0005\u001a\u00020\u0003*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\u0003*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0019\u0010\u000b\u001a\u00020\u0003*\u00020\u00068Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b\"\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00068Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\\"}, d2 = {"Epsilon", "", "FloatEpsilon", "", "Tau", "endX", "Landroidx/compose/ui/graphics/PathSegment;", "getEndX", "(Landroidx/compose/ui/graphics/PathSegment;)F", "endY", "getEndY", "startX", "getStartX", "startY", "getStartY", "clampValidRootInUnitRange", "r", "computeCubicVerticalBounds", "Landroidx/collection/FloatFloatPair;", "p0y", "p1y", "p2y", "p3y", "roots", "", "index", "", "(FFFF[FI)J", "computeHorizontalBounds", "segment", "(Landroidx/compose/ui/graphics/PathSegment;[FI)J", "computeVerticalBounds", "cubicArea", "x0", "y0", "x1", "y1", "x2", "y2", "x3", "y3", "cubicToMonotonicCubics", "cubic", "dst", "tmpRoot", "cubicWinding", "points", "x", "y", "tmpCubics", "tmpRoots", "evaluateCubic", "p1", "p2", "t", "p0", "p3", "evaluateLine", "evaluateQuadratic", "evaluateX", "evaluateY", "findCubicExtremaY", "dstRoots", "findDerivativeRoots", "horizontal", "", "findFirstCubicRoot", "findFirstLineRoot", "findFirstQuadraticRoot", "findFirstRoot", "fraction", "findLineRoot", "findQuadraticRoots", "isQuadraticMonotonic", "lineWinding", "monotonicCubicWinding", "offset", "monotonicQuadraticWinding", "quadraticToMonotonicQuadratics", "quadratic", "quadraticWinding", "tmpQuadratics", "splitCubicAt", "", "src", "srcOffset", "dstOffset", "splitQuadraticAt", "unitDivide", "writeValidRootInUnitRange", "closeTo", "b", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Bezier.kt */
public final class BezierKt {
    private static final double Epsilon = 1.0E-7d;
    private static final float FloatEpsilon = 8.34465E-7f;
    private static final double Tau = 6.283185307179586d;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Bezier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.compose.ui.graphics.PathSegment$Type[] r0 = androidx.compose.ui.graphics.PathSegment.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Move     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Line     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Quadratic     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Conic     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Cubic     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Close     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.compose.ui.graphics.PathSegment$Type r1 = androidx.compose.ui.graphics.PathSegment.Type.Done     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.BezierKt.WhenMappings.<clinit>():void");
        }
    }

    private static final float clampValidRootInUnitRange(float f) {
        return f < 0.0f ? f >= -8.34465E-7f ? 0.0f : Float.NaN : f > 1.0f ? f <= 1.0000008f ? 1.0f : Float.NaN : f;
    }

    public static final float cubicArea(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return ((((((((f8 - f2) * (f3 + f5)) - ((f7 - f) * (f4 + f6))) + (f4 * (f - f5))) - (f3 * (f2 - f6))) + (f8 * (f5 + (f / 3.0f)))) - (f7 * (f6 + (f2 / 3.0f)))) * 3.0f) / 20.0f;
    }

    public static final float evaluateCubic(float f, float f2, float f3) {
        return ((((((f - f2) + 0.33333334f) * f3) + (f2 - (2.0f * f))) * f3) + f) * 3.0f * f3;
    }

    private static final float evaluateCubic(float f, float f2, float f3, float f4, float f5) {
        return (((((((f4 + ((f2 - f3) * 3.0f)) - f) * f5) + (((f3 - (2.0f * f2)) + f) * 3.0f)) * f5) + ((f2 - f) * 3.0f)) * f5) + f;
    }

    private static final float evaluateLine(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    private static final float evaluateQuadratic(float f, float f2, float f3, float f4) {
        return (((((f3 - (f2 * 2.0f)) + f) * f4) + ((f2 - f) * 2.0f)) * f4) + f;
    }

    private static final float findFirstLineRoot(float f, float f2) {
        float f3 = (-f) / (f2 - f);
        return f3 < 0.0f ? f3 >= -8.34465E-7f ? 0.0f : Float.NaN : f3 > 1.0f ? f3 <= 1.0000008f ? 1.0f : Float.NaN : f3;
    }

    private static final float unitDivide(float f, float f2) {
        if (f < 0.0f) {
            f = -f;
            f2 = -f2;
        }
        if (f2 == 0.0f || f == 0.0f || f >= f2) {
            return Float.NaN;
        }
        float f3 = f / f2;
        if (f3 == 0.0f) {
            return Float.NaN;
        }
        return f3;
    }

    private static final float evaluateX(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
                return points[0];
            case 2:
                return evaluateLine(points[0], points[2], f);
            case 3:
                return evaluateQuadratic(points[0], points[2], points[4], f);
            case 4:
                return Float.NaN;
            case 5:
                return evaluateCubic(points[0], points[2], points[4], points[6], f);
            case 6:
            case 7:
                return Float.NaN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final float evaluateY(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
                return points[1];
            case 2:
                return evaluateLine(points[1], points[3], f);
            case 3:
                return evaluateQuadratic(points[1], points[3], points[5], f);
            case 4:
                return Float.NaN;
            case 5:
                return evaluateCubic(points[1], points[3], points[5], points[7], f);
            case 6:
            case 7:
                return Float.NaN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final float findFirstRoot(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
                return Float.NaN;
            case 2:
                float f2 = points[0] - f;
                float f3 = (-f2) / ((points[2] - f) - f2);
                if (f3 < 0.0f) {
                    if (f3 >= -8.34465E-7f) {
                        return 0.0f;
                    }
                    return Float.NaN;
                } else if (f3 <= 1.0f) {
                    return f3;
                } else {
                    if (f3 <= 1.0000008f) {
                        return 1.0f;
                    }
                    return Float.NaN;
                }
            case 3:
                return findFirstQuadraticRoot(points[0] - f, points[2] - f, points[4] - f);
            case 4:
                return Float.NaN;
            case 5:
                return findFirstCubicRoot(points[0] - f, points[2] - f, points[4] - f, points[6] - f);
            case 6:
            case 7:
                return Float.NaN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final float findFirstQuadraticRoot(float r18, float r19, float r20) {
        /*
            r0 = r18
            double r0 = (double) r0
            r2 = r19
            double r2 = (double) r2
            r4 = r20
            double r4 = (double) r4
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = r2 * r6
            double r10 = r0 - r8
            double r10 = r10 + r4
            r12 = 0
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            r13 = 1065353223(0x3f800007, float:1.0000008)
            r14 = -1251999744(0xffffffffb5600000, float:-8.34465E-7)
            r15 = 1065353216(0x3f800000, float:1.0)
            r16 = 0
            r17 = 2143289344(0x7fc00000, float:NaN)
            if (r12 != 0) goto L_0x0041
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0026
            return r17
        L_0x0026:
            double r0 = r8 - r4
            double r4 = r4 * r6
            double r8 = r8 - r4
            double r0 = r0 / r8
            float r0 = (float) r0
            int r1 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r1 >= 0) goto L_0x0036
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 < 0) goto L_0x0035
            return r16
        L_0x0035:
            return r17
        L_0x0036:
            int r1 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r1 <= 0) goto L_0x0040
            int r0 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x003f
            return r15
        L_0x003f:
            return r17
        L_0x0040:
            return r0
        L_0x0041:
            double r6 = r2 * r2
            double r4 = r4 * r0
            double r6 = r6 - r4
            double r4 = java.lang.Math.sqrt(r6)
            double r4 = -r4
            double r0 = -r0
            double r0 = r0 + r2
            double r2 = r4 + r0
            double r2 = -r2
            double r2 = r2 / r10
            float r2 = (float) r2
            int r3 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x005f
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 < 0) goto L_0x005c
            r2 = r16
            goto L_0x0068
        L_0x005c:
            r2 = r17
            goto L_0x0068
        L_0x005f:
            int r3 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r3 <= 0) goto L_0x0068
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 > 0) goto L_0x005c
            r2 = r15
        L_0x0068:
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 != 0) goto L_0x006f
            return r2
        L_0x006f:
            double r4 = r4 - r0
            double r4 = r4 / r10
            float r0 = (float) r4
            int r1 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r1 >= 0) goto L_0x007c
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 < 0) goto L_0x007b
            return r16
        L_0x007b:
            return r17
        L_0x007c:
            int r1 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r1 <= 0) goto L_0x0086
            int r0 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x0085
            return r15
        L_0x0085:
            return r17
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.BezierKt.findFirstQuadraticRoot(float, float, float):float");
    }

    private static final int findLineRoot(float f, float f2, float[] fArr, int i) {
        return writeValidRootInUnitRange((-f) / (f2 - f), fArr, i);
    }

    static /* synthetic */ int findLineRoot$default(float f, float f2, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return writeValidRootInUnitRange((-f) / (f2 - f), fArr, i);
    }

    static /* synthetic */ int findQuadraticRoots$default(float f, float f2, float f3, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            i = 0;
        }
        return findQuadraticRoots(f, f2, f3, fArr, i);
    }

    private static final int findQuadraticRoots(float f, float f2, float f3, float[] fArr, int i) {
        float[] fArr2 = fArr;
        int i2 = i;
        double d = (double) f;
        double d2 = (double) f2;
        double d3 = (double) f3;
        double d4 = d2 * 2.0d;
        double d5 = (d - d4) + d3;
        if (d5 != 0.0d) {
            double d6 = -Math.sqrt((d2 * d2) - (d3 * d));
            double d7 = (-d) + d2;
            int writeValidRootInUnitRange = writeValidRootInUnitRange((float) ((-(d6 + d7)) / d5), fArr2, i2);
            int writeValidRootInUnitRange2 = writeValidRootInUnitRange + writeValidRootInUnitRange((float) ((d6 - d7) / d5), fArr2, i2 + writeValidRootInUnitRange);
            if (writeValidRootInUnitRange2 <= 1) {
                return writeValidRootInUnitRange2;
            }
            float f4 = fArr2[i2];
            int i3 = i2 + 1;
            float f5 = fArr2[i3];
            if (f4 <= f5) {
                return f4 == f5 ? writeValidRootInUnitRange2 - 1 : writeValidRootInUnitRange2;
            }
            fArr2[i2] = f5;
            fArr2[i3] = f4;
            return writeValidRootInUnitRange2;
        } else if (d2 == d3) {
            return 0;
        } else {
            return writeValidRootInUnitRange((float) ((d4 - d3) / (d4 - (d3 * 2.0d))), fArr2, i2);
        }
    }

    private static final int findDerivativeRoots(PathSegment pathSegment, boolean z, float[] fArr, int i) {
        int i2 = !z;
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
            case 2:
                return 0;
            case 3:
                float f = (float) 2;
                float f2 = points[i2 + 2];
                float f3 = (f2 - points[i2]) * f;
                return writeValidRootInUnitRange((-f3) / ((f * (points[i2 + 4] - f2)) - f3), fArr, i);
            case 4:
                return 0;
            case 5:
                float f4 = points[i2 + 2];
                float f5 = (f4 - points[i2]) * 3.0f;
                float f6 = points[i2 + 4];
                float f7 = (f6 - f4) * 3.0f;
                float f8 = (points[i2 + 6] - f6) * 3.0f;
                int findQuadraticRoots = findQuadraticRoots(f5, f7, f8, fArr, i);
                float f9 = (f7 - f5) * 2.0f;
                return findQuadraticRoots + writeValidRootInUnitRange((-f9) / (((f8 - f7) * 2.0f) - f9), fArr, i + findQuadraticRoots);
            case 6:
            case 7:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ long computeHorizontalBounds$default(PathSegment pathSegment, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return computeHorizontalBounds(pathSegment, fArr, i);
    }

    public static final long computeHorizontalBounds(PathSegment pathSegment, float[] fArr, int i) {
        int findDerivativeRoots = findDerivativeRoots(pathSegment, true, fArr, i);
        float min = Math.min(pathSegment.getPoints()[0], getEndX(pathSegment));
        float max = Math.max(pathSegment.getPoints()[0], getEndX(pathSegment));
        for (int i2 = 0; i2 < findDerivativeRoots; i2++) {
            float evaluateX = evaluateX(pathSegment, fArr[i2]);
            min = Math.min(min, evaluateX);
            max = Math.max(max, evaluateX);
        }
        return FloatFloatPair.m17constructorimpl(min, max);
    }

    public static /* synthetic */ long computeVerticalBounds$default(PathSegment pathSegment, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return computeVerticalBounds(pathSegment, fArr, i);
    }

    public static final long computeVerticalBounds(PathSegment pathSegment, float[] fArr, int i) {
        int findDerivativeRoots = findDerivativeRoots(pathSegment, false, fArr, i);
        float min = Math.min(pathSegment.getPoints()[1], getEndY(pathSegment));
        float max = Math.max(pathSegment.getPoints()[1], getEndY(pathSegment));
        for (int i2 = 0; i2 < findDerivativeRoots; i2++) {
            float evaluateY = evaluateY(pathSegment, fArr[i2]);
            min = Math.min(min, evaluateY);
            max = Math.max(max, evaluateY);
        }
        return FloatFloatPair.m17constructorimpl(min, max);
    }

    public static /* synthetic */ long computeCubicVerticalBounds$default(float f, float f2, float f3, float f4, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            i = 0;
        }
        return computeCubicVerticalBounds(f, f2, f3, f4, fArr, i);
    }

    public static final long computeCubicVerticalBounds(float f, float f2, float f3, float f4, float[] fArr, int i) {
        float f5 = (f2 - f) * 3.0f;
        float f6 = (f3 - f2) * 3.0f;
        float f7 = (f4 - f3) * 3.0f;
        int findQuadraticRoots = findQuadraticRoots(f5, f6, f7, fArr, i);
        float f8 = (f6 - f5) * 2.0f;
        int access$writeValidRootInUnitRange = findQuadraticRoots + writeValidRootInUnitRange((-f8) / (((f7 - f6) * 2.0f) - f8), fArr, i + findQuadraticRoots);
        float min = Math.min(f, f4);
        float max = Math.max(f, f4);
        for (int i2 = 0; i2 < access$writeValidRootInUnitRange; i2++) {
            float evaluateCubic = evaluateCubic(f, f2, f3, f4, fArr[i2]);
            min = Math.min(min, evaluateCubic);
            max = Math.max(max, evaluateCubic);
        }
        return FloatFloatPair.m17constructorimpl(min, max);
    }

    public static final boolean closeTo(double d, double d2) {
        return Math.abs(d - d2) < Epsilon;
    }

    public static final boolean closeTo(float f, float f2) {
        return Math.abs(f - f2) < FloatEpsilon;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (r3 >= -8.34465E-7f) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r3 = Float.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r3 <= 1.0000008f) goto L_0x000d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int writeValidRootInUnitRange(float r3, float[] r4, int r5) {
        /*
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            r2 = 2143289344(0x7fc00000, float:NaN)
            if (r1 >= 0) goto L_0x0011
            r1 = -1251999744(0xffffffffb5600000, float:-8.34465E-7)
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x000f
        L_0x000d:
            r3 = r0
            goto L_0x001f
        L_0x000f:
            r3 = r2
            goto L_0x001f
        L_0x0011:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x001f
            r1 = 1065353223(0x3f800007, float:1.0000008)
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x000f
            goto L_0x000d
        L_0x001f:
            r4[r5] = r3
            boolean r3 = java.lang.Float.isNaN(r3)
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.BezierKt.writeValidRootInUnitRange(float, float[], int):int");
    }

    public static final int lineWinding(float[] fArr, float f, float f2) {
        int i;
        float f3;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[2];
        float f7 = fArr[3];
        float f8 = f7 - f5;
        if (f5 > f7) {
            i = -1;
            f3 = f5;
        } else {
            i = 1;
            f3 = f7;
            f7 = f5;
        }
        if (f2 < f7 || f2 >= f3) {
            return 0;
        }
        float f9 = ((f6 - f4) * (f2 - f5)) - (f8 * (f - f4));
        if (f9 == 0.0f || ((int) Math.signum(f9)) == i) {
            return 0;
        }
        return i;
    }

    private static final boolean isQuadraticMonotonic(float f, float f2, float f3) {
        return !(Math.signum(f - f2) + Math.signum(f2 - f3) == 0.0f);
    }

    public static final int quadraticWinding(float[] fArr, float f, float f2, float[] fArr2, float[] fArr3) {
        if (isQuadraticMonotonic(fArr[1], fArr[3], fArr[5])) {
            return monotonicQuadraticWinding(fArr, 0, f, f2, fArr3);
        }
        int quadraticToMonotonicQuadratics = quadraticToMonotonicQuadratics(fArr, fArr2);
        int monotonicQuadraticWinding = monotonicQuadraticWinding(fArr2, 0, f, f2, fArr3);
        return quadraticToMonotonicQuadratics > 0 ? monotonicQuadraticWinding + monotonicQuadraticWinding(fArr2, 4, f, f2, fArr3) : monotonicQuadraticWinding;
    }

    private static final int monotonicQuadraticWinding(float[] fArr, int i, float f, float f2, float[] fArr2) {
        float f3;
        float f4;
        int i2;
        float f5;
        float f6 = fArr[i + 1];
        float f7 = fArr[i + 5];
        if (f6 > f7) {
            i2 = -1;
            f3 = f6;
            f4 = f7;
        } else {
            i2 = 1;
            f4 = f6;
            f3 = f7;
        }
        if (f2 >= f4 && f2 < f3) {
            float f8 = fArr[i + 3];
            if (findQuadraticRoots$default((f6 - (f8 * 2.0f)) + f7, (f8 - f6) * 2.0f, f6 - f2, fArr2, 0, 16, (Object) null) == 0) {
                f5 = fArr[(1 - i2) * 2];
            } else {
                f5 = evaluateQuadratic(fArr[0], fArr[2], fArr[4], fArr2[0]);
            }
            if ((Math.abs(f5 - f) >= FloatEpsilon || (f == fArr[4] && f2 == f7)) && f5 < f) {
                return i2;
            }
        }
        return 0;
    }

    private static final int quadraticToMonotonicQuadratics(float[] fArr, float[] fArr2) {
        float f = fArr[1];
        float f2 = fArr[3];
        float f3 = fArr[5];
        if (!isQuadraticMonotonic(f, f2, f3)) {
            float f4 = f - f2;
            float unitDivide = unitDivide(f4, (f4 - f2) + f3);
            if (!Float.isNaN(unitDivide)) {
                splitQuadraticAt(fArr, fArr2, unitDivide);
                return 1;
            }
            if (Math.abs(f4) >= Math.abs(f2 - f3)) {
                f = f3;
            }
            f2 = f;
        }
        ArraysKt.copyInto(fArr, fArr2, 0, 0, 6);
        fArr2[3] = f2;
        return 0;
    }

    private static final void splitQuadraticAt(float[] fArr, float[] fArr2, float f) {
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float f5 = fArr[3];
        float f6 = fArr[4];
        float f7 = fArr[5];
        float lerp = MathHelpersKt.lerp(f2, f4, f);
        float lerp2 = MathHelpersKt.lerp(f3, f5, f);
        fArr2[0] = f2;
        fArr2[1] = f3;
        fArr2[2] = lerp;
        fArr2[3] = lerp2;
        float lerp3 = MathHelpersKt.lerp(f4, f6, f);
        float lerp4 = MathHelpersKt.lerp(f5, f7, f);
        float lerp5 = MathHelpersKt.lerp(lerp, lerp3, f);
        float lerp6 = MathHelpersKt.lerp(lerp2, lerp4, f);
        fArr2[4] = lerp5;
        fArr2[5] = lerp6;
        fArr2[6] = lerp3;
        fArr2[7] = lerp4;
        fArr2[8] = f6;
        fArr2[9] = f7;
    }

    public static final int cubicWinding(float[] fArr, float f, float f2, float[] fArr2, float[] fArr3) {
        int cubicToMonotonicCubics = cubicToMonotonicCubics(fArr, fArr2, fArr3);
        int i = 0;
        if (cubicToMonotonicCubics >= 0) {
            int i2 = 0;
            while (true) {
                i += monotonicCubicWinding(fArr2, i2 * 6, f, f2);
                if (i2 == cubicToMonotonicCubics) {
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    private static final int monotonicCubicWinding(float[] fArr, int i, float f, float f2) {
        int i2;
        int i3 = i + 1;
        float f3 = fArr[i3];
        int i4 = i + 7;
        float f4 = fArr[i4];
        if (f3 > f4) {
            i2 = -1;
            float f5 = f4;
            f4 = f3;
            f3 = f5;
        } else {
            i2 = 1;
        }
        if (f2 >= f3 && f2 < f4) {
            float f6 = fArr[i];
            float f7 = fArr[i + 2];
            float f8 = fArr[i + 4];
            float f9 = fArr[i + 6];
            if (f < Math.min(f6, Math.min(f7, Math.min(f8, f9)))) {
                return 0;
            }
            if (f <= Math.max(f6, Math.max(f7, Math.max(f8, f9)))) {
                float f10 = fArr[i3];
                float f11 = fArr[i + 3];
                float f12 = fArr[i + 5];
                float f13 = fArr[i4];
                float findFirstCubicRoot = findFirstCubicRoot(f10 - f2, f11 - f2, f12 - f2, f13 - f2);
                if (Float.isNaN(findFirstCubicRoot)) {
                    return 0;
                }
                float evaluateCubic = evaluateCubic(f6, f7, f8, f9, findFirstCubicRoot);
                if ((Math.abs(evaluateCubic - f) >= FloatEpsilon || (f == f9 && f2 == f13)) && evaluateCubic < f) {
                    return i2;
                }
            }
            return i2;
        }
        return 0;
    }

    private static final int cubicToMonotonicCubics(float[] fArr, float[] fArr2, float[] fArr3) {
        int findCubicExtremaY = findCubicExtremaY(fArr, fArr3);
        int i = 0;
        if (findCubicExtremaY == 0) {
            ArraysKt.copyInto(fArr, fArr2, 0, 0, 8);
            return findCubicExtremaY;
        }
        int i2 = 0;
        float f = 0.0f;
        while (i < findCubicExtremaY) {
            float f2 = (fArr3[i] - f) / (1.0f - f);
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            f = f2 > 1.0f ? 1.0f : f2;
            splitCubicAt(fArr, i2, fArr2, i2, f);
            i2 += 6;
            i++;
            fArr = fArr2;
        }
        return findCubicExtremaY;
    }

    private static final int findCubicExtremaY(float[] fArr, float[] fArr2) {
        float f = fArr[1];
        float f2 = fArr[3];
        float f3 = fArr[5];
        return findQuadraticRoots((fArr[7] - f) + ((f2 - f3) * 3.0f), (((f - f2) - f2) - f3) * 2.0f, f2 - f, fArr2, 0);
    }

    private static final void splitCubicAt(float[] fArr, int i, float[] fArr2, int i2, float f) {
        if (f >= 1.0f) {
            ArraysKt.copyInto(fArr, fArr2, i2, i, 8);
            float f2 = fArr[i + 6];
            float f3 = fArr[i + 7];
            fArr2[i2 + 8] = f2;
            fArr2[i2 + 9] = f3;
            fArr2[i2 + 10] = f2;
            fArr2[i2 + 11] = f3;
            fArr2[i2 + 12] = f2;
            fArr2[i2 + 13] = f3;
            return;
        }
        float f4 = fArr[i];
        float f5 = fArr[i + 1];
        fArr2[i2] = f4;
        fArr2[i2 + 1] = f5;
        float f6 = fArr[i + 2];
        float f7 = fArr[i + 3];
        float lerp = MathHelpersKt.lerp(f4, f6, f);
        float lerp2 = MathHelpersKt.lerp(f5, f7, f);
        fArr2[i2 + 2] = lerp;
        fArr2[i2 + 3] = lerp2;
        float f8 = fArr[i + 4];
        float f9 = fArr[i + 5];
        float lerp3 = MathHelpersKt.lerp(f6, f8, f);
        float lerp4 = MathHelpersKt.lerp(f7, f9, f);
        float lerp5 = MathHelpersKt.lerp(lerp, lerp3, f);
        float lerp6 = MathHelpersKt.lerp(lerp2, lerp4, f);
        fArr2[i2 + 4] = lerp5;
        fArr2[i2 + 5] = lerp6;
        float f10 = fArr[i + 6];
        float f11 = fArr[i + 7];
        float lerp7 = MathHelpersKt.lerp(f8, f10, f);
        float lerp8 = MathHelpersKt.lerp(f9, f11, f);
        float lerp9 = MathHelpersKt.lerp(lerp3, lerp7, f);
        float lerp10 = MathHelpersKt.lerp(lerp4, lerp8, f);
        float lerp11 = MathHelpersKt.lerp(lerp5, lerp9, f);
        float lerp12 = MathHelpersKt.lerp(lerp6, lerp10, f);
        fArr2[i2 + 6] = lerp11;
        fArr2[i2 + 7] = lerp12;
        fArr2[i2 + 8] = lerp9;
        fArr2[i2 + 9] = lerp10;
        fArr2[i2 + 10] = lerp7;
        fArr2[i2 + 11] = lerp8;
        fArr2[i2 + 12] = f10;
        fArr2[i2 + 13] = f11;
    }

    private static final float getStartX(PathSegment pathSegment) {
        return pathSegment.getPoints()[0];
    }

    private static final float getEndX(PathSegment pathSegment) {
        float[] points = pathSegment.getPoints();
        char c = 4;
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
            case 6:
            case 7:
                c = 0;
                break;
            case 2:
                c = 2;
                break;
            case 3:
            case 4:
                break;
            case 5:
                c = 6;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return points[c];
    }

    private static final float getStartY(PathSegment pathSegment) {
        return pathSegment.getPoints()[1];
    }

    private static final float getEndY(PathSegment pathSegment) {
        float[] points = pathSegment.getPoints();
        char c = 5;
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
            case 6:
            case 7:
                c = 0;
                break;
            case 2:
                c = 3;
                break;
            case 3:
            case 4:
                break;
            case 5:
                c = 7;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return points[c];
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x019d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0123 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0150 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final float findFirstCubicRoot(float r22, float r23, float r24, float r25) {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            double r3 = (double) r0
            double r5 = (double) r1
            r7 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r5 = r5 * r7
            double r5 = r3 - r5
            double r9 = (double) r2
            double r5 = r5 + r9
            r9 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r5 = r5 * r9
            float r11 = r1 - r0
            double r11 = (double) r11
            double r11 = r11 * r9
            float r0 = -r0
            double r13 = (double) r0
            float r0 = r1 - r2
            double r0 = (double) r0
            double r0 = r0 * r9
            double r13 = r13 + r0
            r0 = r25
            double r0 = (double) r0
            double r13 = r13 + r0
            r0 = 0
            double r15 = r13 - r0
            double r15 = java.lang.Math.abs(r15)
            r17 = 4502148214488346440(0x3e7ad7f29abcaf48, double:1.0E-7)
            int r2 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            r15 = 1065353223(0x3f800007, float:1.0000008)
            r16 = -1251999744(0xffffffffb5600000, float:-8.34465E-7)
            r19 = 1065353216(0x3f800000, float:1.0)
            r20 = 0
            r21 = 2143289344(0x7fc00000, float:NaN)
            if (r2 >= 0) goto L_0x00b2
            double r9 = r5 - r0
            double r9 = java.lang.Math.abs(r9)
            int r2 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r2 >= 0) goto L_0x006a
            double r0 = r11 - r0
            double r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 >= 0) goto L_0x0052
            return r21
        L_0x0052:
            double r0 = -r3
            double r0 = r0 / r11
            float r0 = (float) r0
            int r1 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r1 >= 0) goto L_0x005f
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 < 0) goto L_0x005e
            return r20
        L_0x005e:
            return r21
        L_0x005f:
            int r1 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r1 <= 0) goto L_0x0069
            int r0 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r0 > 0) goto L_0x0068
            return r19
        L_0x0068:
            return r21
        L_0x0069:
            return r0
        L_0x006a:
            double r0 = r11 * r11
            r9 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r9 = r9 * r5
            double r9 = r9 * r3
            double r0 = r0 - r9
            double r0 = java.lang.Math.sqrt(r0)
            double r5 = r5 * r7
            double r2 = r0 - r11
            double r2 = r2 / r5
            float r2 = (float) r2
            int r3 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r3 >= 0) goto L_0x0088
            int r2 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r2 < 0) goto L_0x0085
            r2 = r20
            goto L_0x0092
        L_0x0085:
            r2 = r21
            goto L_0x0092
        L_0x0088:
            int r3 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x0092
            int r2 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r2 > 0) goto L_0x0085
            r2 = r19
        L_0x0092:
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 != 0) goto L_0x0099
            return r2
        L_0x0099:
            double r2 = -r11
            double r2 = r2 - r0
            double r2 = r2 / r5
            float r0 = (float) r2
            int r1 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a7
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 < 0) goto L_0x00a6
            return r20
        L_0x00a6:
            return r21
        L_0x00a7:
            int r1 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b1
            int r0 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r0 > 0) goto L_0x00b0
            return r19
        L_0x00b0:
            return r21
        L_0x00b1:
            return r0
        L_0x00b2:
            double r5 = r5 / r13
            double r11 = r11 / r13
            double r3 = r3 / r13
            double r13 = r11 * r9
            double r17 = r5 * r5
            double r13 = r13 - r17
            r17 = 4621256167635550208(0x4022000000000000, double:9.0)
            double r13 = r13 / r17
            double r7 = r7 * r5
            double r7 = r7 * r5
            double r7 = r7 * r5
            double r17 = r17 * r5
            double r17 = r17 * r11
            double r7 = r7 - r17
            r11 = 4628293042053316608(0x403b000000000000, double:27.0)
            double r3 = r3 * r11
            double r7 = r7 + r3
            r2 = 4632796641680687104(0x404b000000000000, double:54.0)
            double r7 = r7 / r2
            double r2 = r7 * r7
            double r11 = r13 * r13
            double r11 = r11 * r13
            double r2 = r2 + r11
            double r5 = r5 / r9
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 >= 0) goto L_0x0174
            double r2 = -r11
            double r2 = java.lang.Math.sqrt(r2)
            double r7 = -r7
            double r7 = r7 / r2
            r11 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ea
            r7 = r11
        L_0x00ea:
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f1
            r7 = r11
        L_0x00f1:
            double r7 = java.lang.Math.acos(r7)
            float r0 = (float) r2
            float r0 = androidx.compose.ui.util.MathHelpersKt.fastCbrt(r0)
            float r0 = r0 * r1
            double r0 = (double) r0
            double r2 = r7 / r9
            double r2 = java.lang.Math.cos(r2)
            double r2 = r2 * r0
            double r2 = r2 - r5
            float r2 = (float) r2
            int r3 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r3 >= 0) goto L_0x0113
            int r2 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r2 < 0) goto L_0x0110
            r2 = r20
            goto L_0x011d
        L_0x0110:
            r2 = r21
            goto L_0x011d
        L_0x0113:
            int r3 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x011d
            int r2 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r2 > 0) goto L_0x0110
            r2 = r19
        L_0x011d:
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 != 0) goto L_0x0124
            return r2
        L_0x0124:
            r2 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            double r2 = r2 + r7
            double r2 = r2 / r9
            double r2 = java.lang.Math.cos(r2)
            double r2 = r2 * r0
            double r2 = r2 - r5
            float r2 = (float) r2
            int r3 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r3 >= 0) goto L_0x0140
            int r2 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r2 < 0) goto L_0x013d
            r2 = r20
            goto L_0x014a
        L_0x013d:
            r2 = r21
            goto L_0x014a
        L_0x0140:
            int r3 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x014a
            int r2 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r2 > 0) goto L_0x013d
            r2 = r19
        L_0x014a:
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 != 0) goto L_0x0151
            return r2
        L_0x0151:
            r2 = 4623263855806786840(0x402921fb54442d18, double:12.566370614359172)
            double r7 = r7 + r2
            double r7 = r7 / r9
            double r2 = java.lang.Math.cos(r7)
            double r0 = r0 * r2
            double r0 = r0 - r5
            float r0 = (float) r0
            int r1 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r1 >= 0) goto L_0x0169
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 < 0) goto L_0x0168
            return r20
        L_0x0168:
            return r21
        L_0x0169:
            int r1 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r1 <= 0) goto L_0x0173
            int r0 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r0 > 0) goto L_0x0172
            return r19
        L_0x0172:
            return r21
        L_0x0173:
            return r0
        L_0x0174:
            if (r0 != 0) goto L_0x01b5
            float r0 = (float) r7
            float r0 = androidx.compose.ui.util.MathHelpersKt.fastCbrt(r0)
            float r0 = -r0
            float r1 = r1 * r0
            float r2 = (float) r5
            float r1 = r1 - r2
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 >= 0) goto L_0x018d
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 < 0) goto L_0x018a
            r1 = r20
            goto L_0x0197
        L_0x018a:
            r1 = r21
            goto L_0x0197
        L_0x018d:
            int r3 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x0197
            int r1 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r1 > 0) goto L_0x018a
            r1 = r19
        L_0x0197:
            boolean r3 = java.lang.Float.isNaN(r1)
            if (r3 != 0) goto L_0x019e
            return r1
        L_0x019e:
            float r0 = -r0
            float r0 = r0 - r2
            int r1 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r1 >= 0) goto L_0x01aa
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 < 0) goto L_0x01a9
            return r20
        L_0x01a9:
            return r21
        L_0x01aa:
            int r1 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r1 <= 0) goto L_0x01b4
            int r0 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r0 > 0) goto L_0x01b3
            return r19
        L_0x01b3:
            return r21
        L_0x01b4:
            return r0
        L_0x01b5:
            double r0 = java.lang.Math.sqrt(r2)
            double r2 = -r7
            double r2 = r2 + r0
            float r2 = (float) r2
            float r2 = androidx.compose.ui.util.MathHelpersKt.fastCbrt(r2)
            double r7 = r7 + r0
            float r0 = (float) r7
            float r0 = androidx.compose.ui.util.MathHelpersKt.fastCbrt(r0)
            float r2 = r2 - r0
            double r0 = (double) r2
            double r0 = r0 - r5
            float r0 = (float) r0
            int r1 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r1 >= 0) goto L_0x01d4
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 < 0) goto L_0x01d3
            return r20
        L_0x01d3:
            return r21
        L_0x01d4:
            int r1 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r1 <= 0) goto L_0x01de
            int r0 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r0 > 0) goto L_0x01dd
            return r19
        L_0x01dd:
            return r21
        L_0x01de:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.BezierKt.findFirstCubicRoot(float, float, float, float):float");
    }
}
