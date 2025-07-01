package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.PathSegment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b*\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006¨\u0006\f"}, d2 = {"floatCountForType", "", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "computeDirection", "Landroidx/compose/ui/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path;", "divide", "", "contours", "reverse", "destination", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathGeometry.kt */
public final class PathGeometryKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PathGeometry.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.PathGeometryKt.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00cd, code lost:
        r5 = androidx.compose.ui.graphics.PathIterator.next$default(r0, r1, 0, 2, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.Path.Direction computeDirection(androidx.compose.ui.graphics.Path r32) {
        /*
            androidx.compose.ui.graphics.PathIterator r0 = r32.iterator()
            r1 = 8
            float[] r1 = new float[r1]
            r2 = 0
            r3 = 2
            r4 = 0
            androidx.compose.ui.graphics.PathSegment$Type r5 = androidx.compose.ui.graphics.PathIterator.next$default(r0, r1, r2, r3, r4)
            r6 = 1
            r7 = 0
            r8 = r6
            r9 = r7
            r10 = r9
            r11 = r10
            r14 = r11
            r15 = r14
        L_0x0017:
            androidx.compose.ui.graphics.PathSegment$Type r12 = androidx.compose.ui.graphics.PathSegment.Type.Done
            if (r5 == r12) goto L_0x00d3
            int[] r12 = androidx.compose.ui.graphics.PathGeometryKt.WhenMappings.$EnumSwitchMapping$0
            int r13 = r5.ordinal()
            r12 = r12[r13]
            r13 = 5
            r16 = 4
            r17 = 3
            switch(r12) {
                case 1: goto L_0x00c3;
                case 2: goto L_0x00a7;
                case 3: goto L_0x0076;
                case 4: goto L_0x0017;
                case 5: goto L_0x0054;
                case 6: goto L_0x002d;
                case 7: goto L_0x00d3;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x00cd
        L_0x002d:
            float r5 = r10 - r14
            float r5 = java.lang.Math.abs(r5)
            r12 = 895483904(0x35600000, float:8.34465E-7)
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 >= 0) goto L_0x0045
            float r5 = r11 - r15
            float r5 = java.lang.Math.abs(r5)
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 >= 0) goto L_0x0045
            goto L_0x00cd
        L_0x0045:
            r12 = r10
            r13 = r11
            r16 = r14
            r17 = r15
            float r5 = androidx.compose.ui.graphics.BezierKt.cubicArea(r10, r11, r12, r13, r14, r15, r16, r17)
            float r9 = r9 + r5
            r10 = r14
            r11 = r15
            goto L_0x00cd
        L_0x0054:
            r5 = r16
            r16 = r1[r2]
            r10 = r17
            r17 = r1[r6]
            r18 = r1[r3]
            r19 = r1[r10]
            r20 = r1[r5]
            r21 = r1[r13]
            r5 = 6
            r22 = r1[r5]
            r10 = 7
            r23 = r1[r10]
            float r11 = androidx.compose.ui.graphics.BezierKt.cubicArea(r16, r17, r18, r19, r20, r21, r22, r23)
            float r9 = r9 + r11
            r5 = r1[r5]
            r10 = r1[r10]
            r11 = r10
            r10 = r5
            goto L_0x00cd
        L_0x0076:
            r5 = r16
            r10 = r17
            r16 = r1[r2]
            r17 = r1[r6]
            r11 = r1[r3]
            r10 = r1[r10]
            r22 = r1[r5]
            r23 = r1[r13]
            float r5 = r11 - r16
            r12 = 1059760811(0x3f2aaaab, float:0.6666667)
            float r5 = r5 * r12
            float r18 = r16 + r5
            float r5 = r10 - r17
            float r5 = r5 * r12
            float r19 = r17 + r5
            float r11 = r11 - r22
            float r11 = r11 * r12
            float r20 = r22 + r11
            float r10 = r10 - r23
            float r10 = r10 * r12
            float r21 = r23 + r10
            float r5 = androidx.compose.ui.graphics.BezierKt.cubicArea(r16, r17, r18, r19, r20, r21, r22, r23)
            float r9 = r9 + r5
            r10 = r22
            r11 = r23
            goto L_0x00cd
        L_0x00a7:
            r10 = r17
            r24 = r1[r2]
            r25 = r1[r6]
            r28 = r1[r3]
            r29 = r1[r10]
            r26 = r24
            r27 = r25
            r30 = r28
            r31 = r29
            float r5 = androidx.compose.ui.graphics.BezierKt.cubicArea(r24, r25, r26, r27, r28, r29, r30, r31)
            float r9 = r9 + r5
            r10 = r28
            r11 = r29
            goto L_0x00cd
        L_0x00c3:
            if (r8 != 0) goto L_0x00c6
            goto L_0x00d3
        L_0x00c6:
            r5 = r1[r2]
            r8 = r1[r6]
            r14 = r5
            r15 = r8
            r8 = r2
        L_0x00cd:
            androidx.compose.ui.graphics.PathSegment$Type r5 = androidx.compose.ui.graphics.PathIterator.next$default(r0, r1, r2, r3, r4)
            goto L_0x0017
        L_0x00d3:
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x00da
            androidx.compose.ui.graphics.Path$Direction r0 = androidx.compose.ui.graphics.Path.Direction.Clockwise
            return r0
        L_0x00da:
            androidx.compose.ui.graphics.Path$Direction r0 = androidx.compose.ui.graphics.Path.Direction.CounterClockwise
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.PathGeometryKt.computeDirection(androidx.compose.ui.graphics.Path):androidx.compose.ui.graphics.Path$Direction");
    }

    public static /* synthetic */ List divide$default(Path path, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return divide(path, list);
    }

    public static final List<Path> divide(Path path, List<Path> list) {
        Path Path = AndroidPath_androidKt.Path();
        PathIterator it = path.iterator();
        float[] fArr = new float[8];
        PathSegment.Type next$default = PathIterator.next$default(it, fArr, 0, 2, (Object) null);
        Path path2 = Path;
        boolean z = true;
        boolean z2 = true;
        while (next$default != PathSegment.Type.Done) {
            switch (WhenMappings.$EnumSwitchMapping$0[next$default.ordinal()]) {
                case 1:
                    if (!z && !z2) {
                        list.add(path2);
                        path2 = AndroidPath_androidKt.Path();
                    }
                    path2.moveTo(fArr[0], fArr[1]);
                    z = false;
                    z2 = true;
                    break;
                case 2:
                    path2.lineTo(fArr[2], fArr[3]);
                    break;
                case 3:
                    path2.quadraticTo(fArr[2], fArr[3], fArr[4], fArr[5]);
                    break;
                case 4:
                case 7:
                    break;
                case 5:
                    path2.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
                    break;
                case 6:
                    path2.close();
                    break;
            }
            z2 = false;
            next$default = PathIterator.next$default(it, fArr, 0, 2, (Object) null);
            continue;
        }
        if (!z && !z2) {
            list.add(path2);
        }
        return list;
    }

    public static /* synthetic */ Path reverse$default(Path path, Path path2, int i, Object obj) {
        if ((i & 1) != 0) {
            path2 = AndroidPath_androidKt.Path();
        }
        return reverse(path, path2);
    }

    public static final Path reverse(Path path, Path path2) {
        boolean z;
        float[] fArr;
        Path path3 = path2;
        PathIterator it = path.iterator();
        int calculateSize = it.calculateSize(false);
        ArrayList arrayList = new ArrayList(calculateSize);
        ArrayList arrayList2 = new ArrayList(calculateSize);
        float[] fArr2 = new float[8];
        for (PathSegment.Type next$default = PathIterator.next$default(it, fArr2, 0, 2, (Object) null); next$default != PathSegment.Type.Done; next$default = PathIterator.next$default(it, fArr2, 0, 2, (Object) null)) {
            arrayList.add(next$default);
            if (next$default != PathSegment.Type.Close) {
                float[] copyOf = Arrays.copyOf(fArr2, floatCountForType(next$default));
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                arrayList2.add(copyOf);
            }
        }
        int size = arrayList2.size();
        boolean z2 = false;
        boolean z3 = true;
        for (int size2 = arrayList.size() - 1; -1 < size2; size2--) {
            if (z3) {
                size--;
                fArr = (float[]) arrayList2.get(size);
                int lastIndex = ArraysKt.getLastIndex(fArr);
                path3.moveTo(fArr[lastIndex - 1], fArr[lastIndex]);
                z = false;
            } else {
                z = z3;
                fArr = (float[]) arrayList2.get(size);
            }
            int i = size;
            int i2 = WhenMappings.$EnumSwitchMapping$0[((PathSegment.Type) arrayList.get(size2)).ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        float[] fArr3 = fArr;
                        path3.quadraticTo(fArr3[2], fArr3[3], fArr3[0], fArr3[1]);
                    } else if (i2 == 5) {
                        float[] fArr4 = fArr;
                        path3.cubicTo(fArr[4], fArr[5], fArr[2], fArr4[3], fArr4[0], fArr4[1]);
                    } else if (i2 == 6) {
                        z2 = true;
                    }
                    i--;
                } else {
                    float[] fArr5 = fArr;
                    path3.lineTo(fArr5[0], fArr5[1]);
                    i--;
                }
                size = i;
                z3 = z;
            } else {
                if (z2) {
                    path3.close();
                    z2 = false;
                }
                z3 = true;
                size = i;
            }
        }
        if (z2) {
            path3.close();
        }
        return path3;
    }

    private static final int floatCountForType(PathSegment.Type type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 6;
            case 4:
            case 5:
                return 8;
            case 6:
            case 7:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
