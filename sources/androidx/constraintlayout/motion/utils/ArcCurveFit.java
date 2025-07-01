package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    public void getPos(double d, double[] dArr) {
        if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        }
        Arc[] arcArr = this.mArcs;
        if (d > arcArr[arcArr.length - 1].mTime2) {
            Arc[] arcArr2 = this.mArcs;
            d = arcArr2[arcArr2.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i >= arcArr3.length) {
                return;
            }
            if (d > arcArr3[i].mTime2) {
                i++;
            } else if (this.mArcs[i].linear) {
                dArr[0] = this.mArcs[i].getLinearX(d);
                dArr[1] = this.mArcs[i].getLinearY(d);
                return;
            } else {
                this.mArcs[i].setPoint(d);
                dArr[0] = this.mArcs[i].getX();
                dArr[1] = this.mArcs[i].getY();
                return;
            }
        }
    }

    public void getPos(double d, float[] fArr) {
        if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        } else {
            Arc[] arcArr = this.mArcs;
            if (d > arcArr[arcArr.length - 1].mTime2) {
                Arc[] arcArr2 = this.mArcs;
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i >= arcArr3.length) {
                return;
            }
            if (d > arcArr3[i].mTime2) {
                i++;
            } else if (this.mArcs[i].linear) {
                fArr[0] = (float) this.mArcs[i].getLinearX(d);
                fArr[1] = (float) this.mArcs[i].getLinearY(d);
                return;
            } else {
                this.mArcs[i].setPoint(d);
                fArr[0] = (float) this.mArcs[i].getX();
                fArr[1] = (float) this.mArcs[i].getY();
                return;
            }
        }
    }

    public void getSlope(double d, double[] dArr) {
        if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        } else {
            Arc[] arcArr = this.mArcs;
            if (d > arcArr[arcArr.length - 1].mTime2) {
                Arc[] arcArr2 = this.mArcs;
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i >= arcArr3.length) {
                return;
            }
            if (d > arcArr3[i].mTime2) {
                i++;
            } else if (this.mArcs[i].linear) {
                dArr[0] = this.mArcs[i].getLinearDX(d);
                dArr[1] = this.mArcs[i].getLinearDY(d);
                return;
            } else {
                this.mArcs[i].setPoint(d);
                dArr[0] = this.mArcs[i].getDX();
                dArr[1] = this.mArcs[i].getDY();
                return;
            }
        }
    }

    public double getPos(double d, int i) {
        int i2 = 0;
        if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        } else {
            Arc[] arcArr = this.mArcs;
            if (d > arcArr[arcArr.length - 1].mTime2) {
                Arc[] arcArr2 = this.mArcs;
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return Double.NaN;
            }
            if (d > arcArr3[i2].mTime2) {
                i2++;
            } else if (!this.mArcs[i2].linear) {
                this.mArcs[i2].setPoint(d);
                if (i == 0) {
                    return this.mArcs[i2].getX();
                }
                return this.mArcs[i2].getY();
            } else if (i == 0) {
                return this.mArcs[i2].getLinearX(d);
            } else {
                return this.mArcs[i2].getLinearY(d);
            }
        }
    }

    public double getSlope(double d, int i) {
        int i2 = 0;
        if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        }
        Arc[] arcArr = this.mArcs;
        if (d > arcArr[arcArr.length - 1].mTime2) {
            Arc[] arcArr2 = this.mArcs;
            d = arcArr2[arcArr2.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return Double.NaN;
            }
            if (d > arcArr3[i2].mTime2) {
                i2++;
            } else if (!this.mArcs[i2].linear) {
                this.mArcs[i2].setPoint(d);
                if (i == 0) {
                    return this.mArcs[i2].getDX();
                }
                return this.mArcs[i2].getDY();
            } else if (i == 0) {
                return this.mArcs[i2].getLinearDX(d);
            } else {
                return this.mArcs[i2].getLinearDY(d);
            }
        }
    }

    public double[] getTimePoints() {
        return this.mTime;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r5 == 1) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ArcCurveFit(int[] r23, double[] r24, double[][] r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r0.<init>()
            r0.mTime = r1
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            androidx.constraintlayout.motion.utils.ArcCurveFit$Arc[] r2 = new androidx.constraintlayout.motion.utils.ArcCurveFit.Arc[r2]
            r0.mArcs = r2
            r2 = 0
            r4 = r2
            r5 = r3
            r6 = r5
        L_0x0014:
            androidx.constraintlayout.motion.utils.ArcCurveFit$Arc[] r7 = r0.mArcs
            int r8 = r7.length
            if (r4 >= r8) goto L_0x004d
            r8 = r23[r4]
            r9 = 3
            if (r8 == 0) goto L_0x002d
            if (r8 == r3) goto L_0x002b
            r10 = 2
            if (r8 == r10) goto L_0x0029
            if (r8 == r9) goto L_0x0027
            r9 = r6
            goto L_0x002d
        L_0x0027:
            if (r5 != r3) goto L_0x002b
        L_0x0029:
            r5 = r10
            goto L_0x002c
        L_0x002b:
            r5 = r3
        L_0x002c:
            r9 = r5
        L_0x002d:
            androidx.constraintlayout.motion.utils.ArcCurveFit$Arc r8 = new androidx.constraintlayout.motion.utils.ArcCurveFit$Arc
            r10 = r1[r4]
            int r6 = r4 + 1
            r12 = r1[r6]
            r14 = r25[r4]
            r16 = r14
            r14 = r16[r2]
            r16 = r16[r3]
            r18 = r25[r6]
            r20 = r18
            r18 = r20[r2]
            r20 = r20[r3]
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r8
            r4 = r6
            r6 = r9
            goto L_0x0014
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        boolean linear = false;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        Arc(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            double d7 = d;
            double d8 = d2;
            boolean z = false;
            int i2 = 1;
            this.mVertical = i == 1 ? true : z;
            this.mTime1 = d7;
            this.mTime2 = d8;
            this.mOneOverDeltaTime = 1.0d / (d8 - d7);
            if (3 == i) {
                this.linear = true;
            }
            double d9 = d5 - d3;
            double d10 = d6 - d4;
            if (this.linear || Math.abs(d9) < EPSILON || Math.abs(d10) < EPSILON) {
                this.linear = true;
                this.mX1 = d3;
                this.mX2 = d5;
                this.mY1 = d4;
                this.mY2 = d6;
                double hypot = Math.hypot(d10, d9);
                this.mArcDistance = hypot;
                this.mArcVelocity = hypot * this.mOneOverDeltaTime;
                double d11 = this.mTime2;
                double d12 = this.mTime1;
                this.mEllipseCenterX = d9 / (d11 - d12);
                this.mEllipseCenterY = d10 / (d11 - d12);
                return;
            }
            this.mLut = new double[101];
            boolean z2 = this.mVertical;
            this.mEllipseA = d9 * ((double) (z2 ? -1 : 1));
            this.mEllipseB = d10 * ((double) (!z2 ? -1 : i2));
            this.mEllipseCenterX = z2 ? d5 : d3;
            this.mEllipseCenterY = z2 ? d4 : d6;
            buildTable(d3, d4, d5, d6);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
        }

        /* access modifiers changed from: package-private */
        public void setPoint(double d) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d : d - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }

        /* access modifiers changed from: package-private */
        public double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        /* access modifiers changed from: package-private */
        public double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        /* access modifiers changed from: package-private */
        public double getDX() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
            return this.mVertical ? (-d) * hypot : d * hypot;
        }

        /* access modifiers changed from: package-private */
        public double getDY() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double d2 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, d2);
            return this.mVertical ? (-d2) * hypot : d2 * hypot;
        }

        public double getLinearX(double d) {
            double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d3 = this.mX1;
            return d3 + (d2 * (this.mX2 - d3));
        }

        public double getLinearY(double d) {
            double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d3 = this.mY1;
            return d3 + (d2 * (this.mY2 - d3));
        }

        public double getLinearDX(double d) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d) {
            return this.mEllipseCenterY;
        }

        /* access modifiers changed from: package-private */
        public double lookup(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d * ((double) (dArr.length - 1));
            int i = (int) length;
            double d2 = length - ((double) i);
            double d3 = dArr[i];
            return d3 + (d2 * (dArr[i + 1] - d3));
        }

        private void buildTable(double d, double d2, double d3, double d4) {
            double d5 = d3 - d;
            double d6 = d2 - d4;
            int i = 0;
            double d7 = 0.0d;
            double d8 = 0.0d;
            double d9 = 0.0d;
            while (true) {
                double[] dArr = ourPercent;
                if (i >= dArr.length) {
                    break;
                }
                int i2 = i;
                double radians = Math.toRadians((((double) i) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d5;
                double cos = Math.cos(radians) * d6;
                if (i2 > 0) {
                    d7 += Math.hypot(sin - d8, cos - d9);
                    ourPercent[i2] = d7;
                }
                i = i2 + 1;
                d8 = sin;
                d9 = cos;
            }
            this.mArcDistance = d7;
            int i3 = 0;
            while (true) {
                double[] dArr2 = ourPercent;
                if (i3 >= dArr2.length) {
                    break;
                }
                dArr2[i3] = dArr2[i3] / d7;
                i3++;
            }
            int i4 = 0;
            while (true) {
                double[] dArr3 = this.mLut;
                if (i4 < dArr3.length) {
                    double length = ((double) i4) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(ourPercent, length);
                    if (binarySearch >= 0) {
                        this.mLut[i4] = (double) (binarySearch / (ourPercent.length - 1));
                    } else if (binarySearch == -1) {
                        this.mLut[i4] = 0.0d;
                    } else {
                        int i5 = -binarySearch;
                        int i6 = i5 - 2;
                        double[] dArr4 = ourPercent;
                        double d10 = dArr4[i6];
                        this.mLut[i4] = (((double) i6) + ((length - d10) / (dArr4[i5 - 1] - d10))) / ((double) (dArr4.length - 1));
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }
    }
}
