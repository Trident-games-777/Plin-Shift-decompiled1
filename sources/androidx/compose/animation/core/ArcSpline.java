package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/ArcSpline;", "", "arcModes", "", "timePoints", "", "y", "", "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", "", "getPos", "", "time", "", "v", "getSlope", "Arc", "Companion", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ArcSpline.kt */
public final class ArcSpline {
    public static final int $stable = 8;
    public static final int ArcAbove = 5;
    public static final int ArcBelow = 4;
    public static final int ArcStartFlip = 3;
    public static final int ArcStartHorizontal = 2;
    public static final int ArcStartLinear = 0;
    public static final int ArcStartVertical = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DownArc = 4;
    private static final int StartHorizontal = 2;
    private static final int StartLinear = 3;
    private static final int StartVertical = 1;
    private static final int UpArc = 5;
    private final Arc[][] arcs;
    private final boolean isExtrapolate = true;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r7 == 1) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c A[LOOP:1: B:18:0x003a->B:19:0x003c, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ArcSpline(int[] r21, float[] r22, float[][] r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            r0.<init>()
            r2 = 1
            r0.isExtrapolate = r2
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = new androidx.compose.animation.core.ArcSpline.Arc[r3][]
            r5 = 0
            r7 = r2
            r8 = r7
            r6 = r5
        L_0x0012:
            if (r6 >= r3) goto L_0x0068
            r9 = r21[r6]
            r10 = 3
            r11 = 2
            if (r9 == 0) goto L_0x002f
            if (r9 == r2) goto L_0x002c
            if (r9 == r11) goto L_0x002a
            if (r9 == r10) goto L_0x0028
            r10 = 4
            if (r9 == r10) goto L_0x002f
            r10 = 5
            if (r9 == r10) goto L_0x002f
            r13 = r8
            goto L_0x0030
        L_0x0028:
            if (r7 != r2) goto L_0x002c
        L_0x002a:
            r7 = r11
            goto L_0x002d
        L_0x002c:
            r7 = r2
        L_0x002d:
            r13 = r7
            goto L_0x0030
        L_0x002f:
            r13 = r10
        L_0x0030:
            r8 = r23[r6]
            int r9 = r8.length
            int r9 = r9 / r11
            int r8 = r8.length
            int r8 = r8 % r11
            int r9 = r9 + r8
            androidx.compose.animation.core.ArcSpline$Arc[] r8 = new androidx.compose.animation.core.ArcSpline.Arc[r9]
            r10 = r5
        L_0x003a:
            if (r10 >= r9) goto L_0x0062
            int r11 = r10 * 2
            androidx.compose.animation.core.ArcSpline$Arc r12 = new androidx.compose.animation.core.ArcSpline$Arc
            r14 = r1[r6]
            int r15 = r6 + 1
            r16 = r15
            r15 = r1[r16]
            r17 = r23[r6]
            r18 = r16
            r16 = r17[r11]
            int r19 = r11 + 1
            r17 = r17[r19]
            r18 = r23[r18]
            r11 = r18[r11]
            r19 = r18[r19]
            r18 = r11
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            r8[r10] = r12
            int r10 = r10 + 1
            goto L_0x003a
        L_0x0062:
            r4[r6] = r8
            int r6 = r6 + 1
            r8 = r13
            goto L_0x0012
        L_0x0068:
            r0.arcs = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.ArcSpline.<init>(int[], float[], float[][]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
        if (r9 > r0[((java.lang.Object[]) r0).length - 1][0].getTime2()) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getPos(float r9, float[] r10) {
        /*
            r8 = this;
            boolean r0 = r8.isExtrapolate
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x00df
            androidx.compose.animation.core.ArcSpline$Arc[][] r0 = r8.arcs
            r0 = r0[r2]
            r0 = r0[r2]
            float r0 = r0.getTime1()
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0027
            androidx.compose.animation.core.ArcSpline$Arc[][] r0 = r8.arcs
            r3 = r0
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            int r3 = r3.length
            int r3 = r3 - r1
            r0 = r0[r3]
            r0 = r0[r2]
            float r0 = r0.getTime2()
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0119
        L_0x0027:
            androidx.compose.animation.core.ArcSpline$Arc[][] r0 = r8.arcs
            r3 = r0
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            int r3 = r3.length
            int r3 = r3 - r1
            r0 = r0[r3]
            r0 = r0[r2]
            float r0 = r0.getTime2()
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x004f
            androidx.compose.animation.core.ArcSpline$Arc[][] r0 = r8.arcs
            r3 = r0
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            int r3 = r3.length
            int r3 = r3 - r1
            r4 = r0
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            int r4 = r4.length
            int r4 = r4 - r1
            r0 = r0[r4]
            r0 = r0[r2]
            float r0 = r0.getTime2()
            goto L_0x005a
        L_0x004f:
            androidx.compose.animation.core.ArcSpline$Arc[][] r0 = r8.arcs
            r0 = r0[r2]
            r0 = r0[r2]
            float r0 = r0.getTime1()
            r3 = r2
        L_0x005a:
            float r9 = r9 - r0
            r1 = r2
        L_0x005c:
            int r4 = r10.length
            if (r2 >= r4) goto L_0x018b
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = r8.arcs
            r4 = r4[r3]
            r4 = r4[r1]
            boolean r4 = r4.isLinear()
            if (r4 == 0) goto L_0x009e
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = r8.arcs
            r4 = r4[r3]
            r4 = r4[r1]
            float r4 = r4.getLinearX(r0)
            androidx.compose.animation.core.ArcSpline$Arc[][] r5 = r8.arcs
            r5 = r5[r3]
            r5 = r5[r1]
            float r5 = r5.getLinearDX()
            float r5 = r5 * r9
            float r4 = r4 + r5
            r10[r2] = r4
            int r4 = r2 + 1
            androidx.compose.animation.core.ArcSpline$Arc[][] r5 = r8.arcs
            r5 = r5[r3]
            r5 = r5[r1]
            float r5 = r5.getLinearY(r0)
            androidx.compose.animation.core.ArcSpline$Arc[][] r6 = r8.arcs
            r6 = r6[r3]
            r6 = r6[r1]
            float r6 = r6.getLinearDY()
            float r6 = r6 * r9
            float r5 = r5 + r6
            r10[r4] = r5
            goto L_0x00d9
        L_0x009e:
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = r8.arcs
            r4 = r4[r3]
            r4 = r4[r1]
            r4.setPoint(r0)
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = r8.arcs
            r4 = r4[r3]
            r4 = r4[r1]
            float r4 = r4.calcX()
            androidx.compose.animation.core.ArcSpline$Arc[][] r5 = r8.arcs
            r5 = r5[r3]
            r5 = r5[r1]
            float r5 = r5.calcDX()
            float r5 = r5 * r9
            float r4 = r4 + r5
            r10[r2] = r4
            int r4 = r2 + 1
            androidx.compose.animation.core.ArcSpline$Arc[][] r5 = r8.arcs
            r5 = r5[r3]
            r5 = r5[r1]
            float r5 = r5.calcY()
            androidx.compose.animation.core.ArcSpline$Arc[][] r6 = r8.arcs
            r6 = r6[r3]
            r6 = r6[r1]
            float r6 = r6.calcDY()
            float r6 = r6 * r9
            float r5 = r5 + r6
            r10[r4] = r5
        L_0x00d9:
            int r2 = r2 + 2
            int r1 = r1 + 1
            goto L_0x005c
        L_0x00df:
            androidx.compose.animation.core.ArcSpline$Arc[][] r0 = r8.arcs
            r0 = r0[r2]
            r0 = r0[r2]
            float r0 = r0.getTime1()
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00f7
            androidx.compose.animation.core.ArcSpline$Arc[][] r9 = r8.arcs
            r9 = r9[r2]
            r9 = r9[r2]
            float r9 = r9.getTime1()
        L_0x00f7:
            androidx.compose.animation.core.ArcSpline$Arc[][] r0 = r8.arcs
            r3 = r0
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            int r3 = r3.length
            int r3 = r3 - r1
            r0 = r0[r3]
            r0 = r0[r2]
            float r0 = r0.getTime2()
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0119
            androidx.compose.animation.core.ArcSpline$Arc[][] r9 = r8.arcs
            r0 = r9
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            int r0 = r0.length
            int r0 = r0 - r1
            r9 = r9[r0]
            r9 = r9[r2]
            float r9 = r9.getTime2()
        L_0x0119:
            androidx.compose.animation.core.ArcSpline$Arc[][] r0 = r8.arcs
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            int r0 = r0.length
            r3 = r2
            r4 = r3
        L_0x0120:
            if (r3 >= r0) goto L_0x018b
            r5 = r2
            r6 = r5
        L_0x0124:
            int r7 = r10.length
            if (r5 >= r7) goto L_0x0185
            androidx.compose.animation.core.ArcSpline$Arc[][] r7 = r8.arcs
            r7 = r7[r3]
            r7 = r7[r6]
            float r7 = r7.getTime2()
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0180
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = r8.arcs
            r4 = r4[r3]
            r4 = r4[r6]
            boolean r4 = r4.isLinear()
            if (r4 == 0) goto L_0x015c
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = r8.arcs
            r4 = r4[r3]
            r4 = r4[r6]
            float r4 = r4.getLinearX(r9)
            r10[r5] = r4
            int r4 = r5 + 1
            androidx.compose.animation.core.ArcSpline$Arc[][] r7 = r8.arcs
            r7 = r7[r3]
            r7 = r7[r6]
            float r7 = r7.getLinearY(r9)
            r10[r4] = r7
            goto L_0x017f
        L_0x015c:
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = r8.arcs
            r4 = r4[r3]
            r4 = r4[r6]
            r4.setPoint(r9)
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = r8.arcs
            r4 = r4[r3]
            r4 = r4[r6]
            float r4 = r4.calcX()
            r10[r5] = r4
            int r4 = r5 + 1
            androidx.compose.animation.core.ArcSpline$Arc[][] r7 = r8.arcs
            r7 = r7[r3]
            r7 = r7[r6]
            float r7 = r7.calcY()
            r10[r4] = r7
        L_0x017f:
            r4 = r1
        L_0x0180:
            int r5 = r5 + 2
            int r6 = r6 + 1
            goto L_0x0124
        L_0x0185:
            if (r4 == 0) goto L_0x0188
            goto L_0x018b
        L_0x0188:
            int r3 = r3 + 1
            goto L_0x0120
        L_0x018b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.ArcSpline.getPos(float, float[]):void");
    }

    public final void getSlope(float f, float[] fArr) {
        if (f < this.arcs[0][0].getTime1()) {
            f = this.arcs[0][0].getTime1();
        } else {
            Arc[][] arcArr = this.arcs;
            if (f > arcArr[((Object[]) arcArr).length - 1][0].getTime2()) {
                Arc[][] arcArr2 = this.arcs;
                f = arcArr2[((Object[]) arcArr2).length - 1][0].getTime2();
            }
        }
        int length = ((Object[]) this.arcs).length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < fArr.length) {
                if (f <= this.arcs[i][i3].getTime2()) {
                    if (this.arcs[i][i3].isLinear()) {
                        fArr[i2] = this.arcs[i][i3].getLinearDX();
                        fArr[i2 + 1] = this.arcs[i][i3].getLinearDY();
                    } else {
                        this.arcs[i][i3].setPoint(f);
                        fArr[i2] = this.arcs[i][i3].calcDX();
                        fArr[i2 + 1] = this.arcs[i][i3].calcDY();
                    }
                    z = true;
                }
                i2 += 2;
                i3++;
            }
            if (!z) {
                i++;
            } else {
                return;
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B?\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0005R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", "", "mode", "", "time1", "", "time2", "x1", "y1", "x2", "y2", "(IFFFFFF)V", "arcDistance", "arcVelocity", "ellipseA", "ellipseB", "ellipseCenterX", "ellipseCenterY", "isLinear", "", "()Z", "isVertical", "lut", "", "oneOverDeltaTime", "getTime1", "()F", "getTime2", "tmpCosAngle", "tmpSinAngle", "buildTable", "", "calcDX", "calcDY", "calcX", "calcY", "getLinearDX", "getLinearDY", "getLinearX", "time", "getLinearY", "lookup", "v", "setPoint", "Companion", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ArcSpline.kt */
    public static final class Arc {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final float Epsilon = 0.001f;
        /* access modifiers changed from: private */
        public static float[] _ourPercent;
        private float arcDistance;
        private final float arcVelocity;
        private final float ellipseA;
        private final float ellipseB;
        private final float ellipseCenterX;
        private final float ellipseCenterY;
        private final boolean isLinear;
        private final boolean isVertical;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        public Arc(int i, float f, float f2, float f3, float f4, float f5, float f6) {
            this.time1 = f;
            this.time2 = f2;
            this.x1 = f3;
            this.y1 = f4;
            this.x2 = f5;
            this.y2 = f6;
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            boolean z = false;
            boolean z2 = true;
            boolean z3 = i == 1 || (i == 4 ? f8 > 0.0f : !(i != 5 || f8 >= 0.0f));
            this.isVertical = z3;
            float f9 = ((float) 1) / (f2 - f);
            this.oneOverDeltaTime = f9;
            z = 3 == i ? true : z;
            if (z || Math.abs(f7) < Epsilon || Math.abs(f8) < Epsilon) {
                float hypot = (float) Math.hypot((double) f8, (double) f7);
                this.arcDistance = hypot;
                this.arcVelocity = hypot * f9;
                this.ellipseCenterX = f7 / (f2 - f);
                this.ellipseCenterY = f8 / (f2 - f);
                this.lut = new float[101];
                this.ellipseA = Float.NaN;
                this.ellipseB = Float.NaN;
            } else {
                this.lut = new float[101];
                this.ellipseA = f7 * ((float) (z3 ? -1 : 1));
                this.ellipseB = f8 * (!z3 ? true : z2 ? 1.0f : 0.0f);
                this.ellipseCenterX = z3 ? f5 : f3;
                this.ellipseCenterY = z3 ? f4 : f6;
                buildTable(f3, f4, f5, f6);
                this.arcVelocity = this.arcDistance * f9;
                z2 = z;
            }
            this.isLinear = z2;
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        public final boolean isLinear() {
            return this.isLinear;
        }

        public final void setPoint(float f) {
            double lookup = (double) (lookup((this.isVertical ? this.time2 - f : f - this.time1) * this.oneOverDeltaTime) * 1.5707964f);
            this.tmpSinAngle = (float) Math.sin(lookup);
            this.tmpCosAngle = (float) Math.cos(lookup);
        }

        public final float calcX() {
            return this.ellipseCenterX + (this.ellipseA * this.tmpSinAngle);
        }

        public final float calcY() {
            return this.ellipseCenterY + (this.ellipseB * this.tmpCosAngle);
        }

        public final float calcDX() {
            float f = this.ellipseA * this.tmpCosAngle;
            float hypot = this.arcVelocity / ((float) Math.hypot((double) f, (double) ((-this.ellipseB) * this.tmpSinAngle)));
            return this.isVertical ? (-f) * hypot : f * hypot;
        }

        public final float calcDY() {
            float f = this.ellipseA * this.tmpCosAngle;
            float f2 = (-this.ellipseB) * this.tmpSinAngle;
            float hypot = this.arcVelocity / ((float) Math.hypot((double) f, (double) f2));
            return this.isVertical ? (-f2) * hypot : f2 * hypot;
        }

        public final float getLinearX(float f) {
            float f2 = (f - this.time1) * this.oneOverDeltaTime;
            float f3 = this.x1;
            return f3 + (f2 * (this.x2 - f3));
        }

        public final float getLinearY(float f) {
            float f2 = (f - this.time1) * this.oneOverDeltaTime;
            float f3 = this.y1;
            return f3 + (f2 * (this.y2 - f3));
        }

        public final float getLinearDX() {
            return this.ellipseCenterX;
        }

        public final float getLinearDY() {
            return this.ellipseCenterY;
        }

        private final float lookup(float f) {
            if (f <= 0.0f) {
                return 0.0f;
            }
            if (f >= 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.lut;
            float length = f * ((float) (fArr.length - 1));
            int i = (int) length;
            float f2 = length - ((float) i);
            float f3 = fArr[i];
            return f3 + (f2 * (fArr[i + 1] - f3));
        }

        private final void buildTable(float f, float f2, float f3, float f4) {
            float f5 = f3 - f;
            float f6 = f2 - f4;
            int length = Companion.getOurPercent().length;
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            int i = 0;
            while (i < length) {
                Companion companion = Companion;
                double radians = (double) ((float) Math.toRadians((((double) i) * 90.0d) / ((double) (companion.getOurPercent().length - 1))));
                float sin = ((float) Math.sin(radians)) * f5;
                float cos = ((float) Math.cos(radians)) * f6;
                if (i > 0) {
                    f7 += (float) Math.hypot((double) (sin - f8), (double) (cos - f9));
                    companion.getOurPercent()[i] = f7;
                }
                i++;
                f9 = cos;
                f8 = sin;
            }
            this.arcDistance = f7;
            int length2 = Companion.getOurPercent().length;
            for (int i2 = 0; i2 < length2; i2++) {
                float[] access$getOurPercent = Companion.getOurPercent();
                access$getOurPercent[i2] = access$getOurPercent[i2] / f7;
            }
            int length3 = this.lut.length;
            for (int i3 = 0; i3 < length3; i3++) {
                float length4 = ((float) i3) / ((float) (this.lut.length - 1));
                Companion companion2 = Companion;
                int binarySearch$default = ArraysKt.binarySearch$default(companion2.getOurPercent(), length4, 0, 0, 6, (Object) null);
                if (binarySearch$default >= 0) {
                    this.lut[i3] = ((float) binarySearch$default) / ((float) (companion2.getOurPercent().length - 1));
                } else if (binarySearch$default == -1) {
                    this.lut[i3] = 0.0f;
                } else {
                    int i4 = -binarySearch$default;
                    int i5 = i4 - 2;
                    this.lut[i3] = (((float) i5) + ((length4 - companion2.getOurPercent()[i5]) / (companion2.getOurPercent()[i4 - 1] - companion2.getOurPercent()[i5]))) / ((float) (companion2.getOurPercent().length - 1));
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc$Companion;", "", "()V", "Epsilon", "", "_ourPercent", "", "ourPercent", "getOurPercent", "()[F", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: ArcSpline.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* access modifiers changed from: private */
            public final float[] getOurPercent() {
                if (Arc._ourPercent != null) {
                    float[] access$get_ourPercent$cp = Arc._ourPercent;
                    Intrinsics.checkNotNull(access$get_ourPercent$cp);
                    return access$get_ourPercent$cp;
                }
                Arc._ourPercent = new float[91];
                float[] access$get_ourPercent$cp2 = Arc._ourPercent;
                Intrinsics.checkNotNull(access$get_ourPercent$cp2);
                return access$get_ourPercent$cp2;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Companion;", "", "()V", "ArcAbove", "", "ArcBelow", "ArcStartFlip", "ArcStartHorizontal", "ArcStartLinear", "ArcStartVertical", "DownArc", "StartHorizontal", "StartLinear", "StartVertical", "UpArc", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ArcSpline.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
