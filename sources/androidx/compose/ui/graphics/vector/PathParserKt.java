package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001aX\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u001a\u001a\u0010\u001a\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u001a\r\u0010\u001e\u001a\u00020\t*\u00020\tH\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001f"}, d2 = {"EmptyArray", "", "getEmptyArray", "()[F", "arcToBezier", "", "p", "Landroidx/compose/ui/graphics/Path;", "cx", "", "cy", "a", "b", "e1x", "e1y", "theta", "start", "sweep", "drawArc", "x0", "y0", "x1", "y1", "isMoreThanHalf", "", "isPositiveArc", "toPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "target", "toRadians", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathParser.kt */
public final class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    private static final double toRadians(double d) {
        return (d / ((double) 180)) * 3.141592653589793d;
    }

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    public static final Path toPath(List<? extends PathNode> list, Path path) {
        float f;
        int i;
        int i2;
        PathNode pathNode;
        float f2;
        float arcStartY;
        float f3;
        float f4;
        float f5;
        float dx;
        int i3;
        float f6;
        int i4;
        float x2;
        float y2;
        float dy2;
        float f7;
        float f8;
        float dx1;
        float dy1;
        float dy22;
        List<? extends PathNode> list2 = list;
        Path path2 = path;
        int r2 = path2.m4527getFillTypeRgk1Os();
        path2.rewind();
        path2.m4529setFillTypeoQ8Xj4U(r2);
        PathNode pathNode2 = (PathNode) (list2.isEmpty() ? PathNode.Close.INSTANCE : list2.get(0));
        int size = list2.size();
        float f9 = 0.0f;
        int i5 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        while (i5 < size) {
            PathNode pathNode3 = (PathNode) list2.get(i5);
            if (pathNode3 instanceof PathNode.Close) {
                path2.close();
                i = size;
                f = f9;
                i2 = i5;
                pathNode = pathNode3;
                f10 = f14;
                f2 = f10;
                arcStartY = f15;
            } else {
                if (pathNode3 instanceof PathNode.RelativeMoveTo) {
                    PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode3;
                    f12 += relativeMoveTo.getDx();
                    f13 += relativeMoveTo.getDy();
                    path2.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
                    i = size;
                    f = f9;
                    i2 = i5;
                    f14 = f12;
                    f15 = f13;
                } else {
                    if (pathNode3 instanceof PathNode.MoveTo) {
                        PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                        float x = moveTo.getX();
                        float y = moveTo.getY();
                        path2.moveTo(moveTo.getX(), moveTo.getY());
                        f12 = x;
                        f14 = f12;
                        f13 = y;
                        f15 = f13;
                    } else {
                        if (pathNode3 instanceof PathNode.RelativeLineTo) {
                            PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                            path2.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                            f12 += relativeLineTo.getDx();
                            dy2 = relativeLineTo.getDy();
                        } else {
                            if (pathNode3 instanceof PathNode.LineTo) {
                                PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                                path2.lineTo(lineTo.getX(), lineTo.getY());
                                x2 = lineTo.getX();
                                y2 = lineTo.getY();
                            } else if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                                PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode3;
                                path2.relativeLineTo(relativeHorizontalTo.getDx(), f9);
                                f12 += relativeHorizontalTo.getDx();
                            } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                                PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode3;
                                path2.lineTo(horizontalTo.getX(), f13);
                                f12 = horizontalTo.getX();
                            } else if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                                PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode3;
                                path2.relativeLineTo(f9, relativeVerticalTo.getDy());
                                dy2 = relativeVerticalTo.getDy();
                            } else if (pathNode3 instanceof PathNode.VerticalTo) {
                                PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode3;
                                path2.lineTo(f12, verticalTo.getY());
                                f13 = verticalTo.getY();
                            } else {
                                if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                                    PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                                    path2.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                                    dx1 = relativeCurveTo.getDx2() + f12;
                                    dy1 = relativeCurveTo.getDy2() + f13;
                                    f12 += relativeCurveTo.getDx3();
                                    dy22 = relativeCurveTo.getDy3();
                                } else {
                                    if (pathNode3 instanceof PathNode.CurveTo) {
                                        PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode3;
                                        path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                        float x22 = curveTo.getX2();
                                        float y22 = curveTo.getY2();
                                        float x3 = curveTo.getX3();
                                        float y3 = curveTo.getY3();
                                        f12 = x3;
                                        f13 = y3;
                                        i = size;
                                        f = f9;
                                        i2 = i5;
                                        pathNode = pathNode3;
                                        f10 = x22;
                                        f11 = y22;
                                    } else if (pathNode3 instanceof PathNode.RelativeReflectiveCurveTo) {
                                        if (pathNode2.isCurve()) {
                                            float f16 = f12 - f10;
                                            f7 = f13 - f11;
                                            f8 = f16;
                                        } else {
                                            f8 = f9;
                                            f7 = f8;
                                        }
                                        PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode3;
                                        path.relativeCubicTo(f8, f7, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                        dx1 = relativeReflectiveCurveTo.getDx1() + f12;
                                        dy1 = relativeReflectiveCurveTo.getDy1() + f13;
                                        f12 += relativeReflectiveCurveTo.getDx2();
                                        dy22 = relativeReflectiveCurveTo.getDy2();
                                    } else {
                                        if (pathNode3 instanceof PathNode.ReflectiveCurveTo) {
                                            if (pathNode2.isCurve()) {
                                                float f17 = (float) 2;
                                                f12 = (f12 * f17) - f10;
                                                f13 = (f17 * f13) - f11;
                                            }
                                            PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode3;
                                            path.cubicTo(f12, f13, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                            f5 = reflectiveCurveTo.getX1();
                                            float y1 = reflectiveCurveTo.getY1();
                                            float x23 = reflectiveCurveTo.getX2();
                                            float y23 = reflectiveCurveTo.getY2();
                                            dx = x23;
                                            f13 = y23;
                                            i3 = size;
                                            f6 = f9;
                                            i4 = i5;
                                            pathNode = pathNode3;
                                            f11 = y1;
                                        } else {
                                            Path path3 = path;
                                            if (pathNode3 instanceof PathNode.RelativeQuadTo) {
                                                PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode3;
                                                path3.relativeQuadraticTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
                                                f10 = relativeQuadTo.getDx1() + f12;
                                                f11 = relativeQuadTo.getDy1() + f13;
                                                f12 += relativeQuadTo.getDx2();
                                                dy2 = relativeQuadTo.getDy2();
                                            } else if (pathNode3 instanceof PathNode.QuadTo) {
                                                PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode3;
                                                path3.quadraticTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
                                                f10 = quadTo.getX1();
                                                f11 = quadTo.getY1();
                                                x2 = quadTo.getX2();
                                                y2 = quadTo.getY2();
                                            } else if (pathNode3 instanceof PathNode.RelativeReflectiveQuadTo) {
                                                if (pathNode2.isQuad()) {
                                                    f4 = f12 - f10;
                                                    f3 = f13 - f11;
                                                } else {
                                                    f4 = f9;
                                                    f3 = f4;
                                                }
                                                PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode3;
                                                path3.relativeQuadraticTo(f4, f3, relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
                                                f5 = f4 + f12;
                                                float f18 = f3 + f13;
                                                dx = f12 + relativeReflectiveQuadTo.getDx();
                                                f13 += relativeReflectiveQuadTo.getDy();
                                                f11 = f18;
                                                i3 = size;
                                                f6 = f9;
                                                i4 = i5;
                                                pathNode = pathNode3;
                                            } else if (pathNode3 instanceof PathNode.ReflectiveQuadTo) {
                                                if (pathNode2.isQuad()) {
                                                    float f19 = (float) 2;
                                                    f12 = (f12 * f19) - f10;
                                                    f13 = (f19 * f13) - f11;
                                                }
                                                PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode3;
                                                path3.quadraticTo(f12, f13, reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
                                                float f20 = f12;
                                                f12 = reflectiveQuadTo.getX();
                                                f10 = f20;
                                                i = size;
                                                f = f9;
                                                i2 = i5;
                                                f11 = f13;
                                                pathNode = pathNode3;
                                                f13 = reflectiveQuadTo.getY();
                                            } else if (pathNode3 instanceof PathNode.RelativeArcTo) {
                                                PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode3;
                                                float arcStartDx = relativeArcTo.getArcStartDx() + f12;
                                                float arcStartDy = relativeArcTo.getArcStartDy() + f13;
                                                double horizontalEllipseRadius = (double) relativeArcTo.getHorizontalEllipseRadius();
                                                double verticalEllipseRadius = (double) relativeArcTo.getVerticalEllipseRadius();
                                                boolean isMoreThanHalf = relativeArcTo.isMoreThanHalf();
                                                f = f9;
                                                boolean isPositiveArc = relativeArcTo.isPositiveArc();
                                                double theta = (double) relativeArcTo.getTheta();
                                                pathNode = pathNode3;
                                                double d = theta;
                                                double d2 = horizontalEllipseRadius;
                                                i = size;
                                                i2 = i5;
                                                drawArc(path, (double) f12, (double) f13, (double) arcStartDx, (double) arcStartDy, d2, verticalEllipseRadius, d, isMoreThanHalf, isPositiveArc);
                                                f10 = arcStartDx;
                                                f2 = f10;
                                                arcStartY = arcStartDy;
                                            } else {
                                                i = size;
                                                f = f9;
                                                i2 = i5;
                                                pathNode = pathNode3;
                                                if (pathNode instanceof PathNode.ArcTo) {
                                                    PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode;
                                                    drawArc(path, (double) f12, (double) f13, (double) arcTo.getArcStartX(), (double) arcTo.getArcStartY(), (double) arcTo.getHorizontalEllipseRadius(), (double) arcTo.getVerticalEllipseRadius(), (double) arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
                                                    f10 = arcTo.getArcStartX();
                                                    f2 = f10;
                                                    arcStartY = arcTo.getArcStartY();
                                                }
                                            }
                                        }
                                        f10 = f5;
                                    }
                                    i5 = i2 + 1;
                                    path2 = path;
                                    pathNode2 = pathNode;
                                    size = i;
                                    f9 = f;
                                    list2 = list;
                                }
                                f13 += dy22;
                                f10 = dx1;
                                f11 = dy1;
                            }
                            f13 = y2;
                            f12 = x2;
                        }
                        f13 += dy2;
                    }
                    i = size;
                    f = f9;
                    i2 = i5;
                }
                pathNode = pathNode3;
                i5 = i2 + 1;
                path2 = path;
                pathNode2 = pathNode;
                size = i;
                f9 = f;
                list2 = list;
            }
            f13 = f11;
            i5 = i2 + 1;
            path2 = path;
            pathNode2 = pathNode;
            size = i;
            f9 = f;
            list2 = list;
        }
        return path;
    }

    private static final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = d;
        double d11 = d3;
        double d12 = (d7 / ((double) 180)) * 3.141592653589793d;
        double cos = Math.cos(d12);
        double sin = Math.sin(d12);
        double d13 = ((d10 * cos) + (d2 * sin)) / d5;
        double d14 = (((-d10) * sin) + (d2 * cos)) / d6;
        double d15 = ((d11 * cos) + (d4 * sin)) / d5;
        double d16 = (((-d11) * sin) + (d4 * cos)) / d6;
        double d17 = d13 - d15;
        double d18 = d14 - d16;
        double d19 = d16;
        double d20 = (double) 2;
        double d21 = (d13 + d15) / d20;
        double d22 = (d14 + d19) / d20;
        double d23 = (d17 * d17) + (d18 * d18);
        if (d23 != 0.0d) {
            double d24 = (1.0d / d23) - 0.25d;
            if (d24 < 0.0d) {
                double sqrt = (double) ((float) (Math.sqrt(d23) / 1.99999d));
                drawArc(path, d, d2, d11, d4, d5 * sqrt, d6 * sqrt, d7, z, z2);
                return;
            }
            boolean z3 = z2;
            double sqrt2 = Math.sqrt(d24);
            double d25 = d17 * sqrt2;
            double d26 = sqrt2 * d18;
            if (z == z3) {
                d9 = d21 - d26;
                d8 = d22 + d25;
            } else {
                d9 = d21 + d26;
                d8 = d22 - d25;
            }
            double atan2 = Math.atan2(d14 - d8, d13 - d9);
            double atan22 = Math.atan2(d19 - d8, d15 - d9) - atan2;
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z3 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d27 = d9 * d5;
            double d28 = d8 * d6;
            double d29 = atan2;
            arcToBezier(path, (d27 * cos) - (d28 * sin), (d27 * sin) + (d28 * cos), d5, d6, d, d2, d12, d29, atan22);
        }
    }

    private static final void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = (double) 4;
        int ceil = (int) Math.ceil(Math.abs((d9 * d10) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d11 = -d3;
        double d12 = d11 * cos;
        double d13 = d4 * sin;
        double d14 = (d12 * sin2) - (d13 * cos2);
        double d15 = d11 * sin;
        double d16 = d4 * cos;
        double d17 = (sin2 * d15) + (cos2 * d16);
        double d18 = d9 / ((double) ceil);
        double d19 = d17;
        double d20 = d14;
        int i = 0;
        double d21 = d5;
        double d22 = d6;
        double d23 = d8;
        while (i < ceil) {
            double d24 = d23 + d18;
            double sin3 = Math.sin(d24);
            double cos3 = Math.cos(d24);
            int i2 = i;
            double d25 = (d + ((d3 * cos) * cos3)) - (d13 * sin3);
            double d26 = d10;
            double d27 = d2 + (d3 * sin * cos3) + (d16 * sin3);
            double d28 = (d12 * sin3) - (d13 * cos3);
            double d29 = (sin3 * d15) + (cos3 * d16);
            double d30 = d24 - d23;
            int i3 = ceil;
            double d31 = cos;
            double tan = Math.tan(d30 / ((double) 2));
            double sin4 = (Math.sin(d30) * (Math.sqrt(d26 + ((3.0d * tan) * tan)) - ((double) 1))) / ((double) 3);
            float f = (float) (d21 + (d20 * sin4));
            path.cubicTo(f, (float) (d22 + (d19 * sin4)), (float) (d25 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d25, (float) d27);
            sin = sin;
            d18 = d18;
            d21 = d25;
            d22 = d27;
            i = i2 + 1;
            d23 = d24;
            d19 = d29;
            ceil = i3;
            d20 = d28;
            cos = d31;
            d10 = d26;
        }
    }
}
