package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private int MAX_DIMENSION = 4;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private int mCurveFitType = -1;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private KeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    float mMotionStagger = Float.NaN;
    private int mPathMotionArc = Key.UNSET;
    private CurveFit[] mSpline;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private float[] mValuesBuff = new float[4];
    private float[] mVelocity = new float[1];
    View mView;

    /* access modifiers changed from: package-private */
    public MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    MotionController(View view) {
        setView(view);
    }

    /* access modifiers changed from: package-private */
    public float getStartX() {
        return this.mStartMotionPath.x;
    }

    /* access modifiers changed from: package-private */
    public float getStartY() {
        return this.mStartMotionPath.y;
    }

    /* access modifiers changed from: package-private */
    public float getFinalX() {
        return this.mEndMotionPath.x;
    }

    /* access modifiers changed from: package-private */
    public float getFinalY() {
        return this.mEndMotionPath.y;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildPath(float[] r20, int r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            int r3 = r2 + -1
            float r3 = (float) r3
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r4 / r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r5 = r0.mAttributesMap
            java.lang.String r6 = "translationX"
            r7 = 0
            if (r5 != 0) goto L_0x0016
            r5 = r7
            goto L_0x001c
        L_0x0016:
            java.lang.Object r5 = r5.get(r6)
            androidx.constraintlayout.motion.widget.SplineSet r5 = (androidx.constraintlayout.motion.widget.SplineSet) r5
        L_0x001c:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r8 = r0.mAttributesMap
            java.lang.String r9 = "translationY"
            if (r8 != 0) goto L_0x0024
            r8 = r7
            goto L_0x002a
        L_0x0024:
            java.lang.Object r8 = r8.get(r9)
            androidx.constraintlayout.motion.widget.SplineSet r8 = (androidx.constraintlayout.motion.widget.SplineSet) r8
        L_0x002a:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> r10 = r0.mCycleMap
            if (r10 != 0) goto L_0x0030
            r6 = r7
            goto L_0x0036
        L_0x0030:
            java.lang.Object r6 = r10.get(r6)
            androidx.constraintlayout.motion.widget.KeyCycleOscillator r6 = (androidx.constraintlayout.motion.widget.KeyCycleOscillator) r6
        L_0x0036:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> r10 = r0.mCycleMap
            if (r10 != 0) goto L_0x003b
            goto L_0x0041
        L_0x003b:
            java.lang.Object r7 = r10.get(r9)
            androidx.constraintlayout.motion.widget.KeyCycleOscillator r7 = (androidx.constraintlayout.motion.widget.KeyCycleOscillator) r7
        L_0x0041:
            r10 = 0
        L_0x0042:
            if (r10 >= r2) goto L_0x0118
            float r11 = (float) r10
            float r11 = r11 * r3
            float r12 = r0.mStaggerScale
            int r13 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            r14 = 0
            if (r13 == 0) goto L_0x0065
            float r13 = r0.mStaggerOffset
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x0054
            r11 = r14
        L_0x0054:
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x0065
            r16 = r10
            r15 = 0
            double r9 = (double) r11
            r17 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r9 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r9 >= 0) goto L_0x0068
            float r11 = r11 - r13
            float r11 = r11 * r12
            goto L_0x0068
        L_0x0065:
            r16 = r10
            r15 = 0
        L_0x0068:
            double r9 = (double) r11
            androidx.constraintlayout.motion.widget.MotionPaths r12 = r0.mStartMotionPath
            androidx.constraintlayout.motion.utils.Easing r12 = r12.mKeyFrameEasing
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r13 = r0.mMotionPaths
            java.util.Iterator r13 = r13.iterator()
            r17 = 2143289344(0x7fc00000, float:NaN)
        L_0x0075:
            boolean r18 = r13.hasNext()
            if (r18 == 0) goto L_0x00a4
            java.lang.Object r18 = r13.next()
            r4 = r18
            androidx.constraintlayout.motion.widget.MotionPaths r4 = (androidx.constraintlayout.motion.widget.MotionPaths) r4
            r18 = r15
            androidx.constraintlayout.motion.utils.Easing r15 = r4.mKeyFrameEasing
            if (r15 == 0) goto L_0x009f
            float r15 = r4.time
            int r15 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x0095
            androidx.constraintlayout.motion.utils.Easing r12 = r4.mKeyFrameEasing
            float r4 = r4.time
            r14 = r4
            goto L_0x009f
        L_0x0095:
            boolean r15 = java.lang.Float.isNaN(r17)
            if (r15 == 0) goto L_0x009f
            float r4 = r4.time
            r17 = r4
        L_0x009f:
            r15 = r18
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0075
        L_0x00a4:
            r18 = r15
            if (r12 == 0) goto L_0x00c0
            boolean r4 = java.lang.Float.isNaN(r17)
            if (r4 == 0) goto L_0x00b0
            r17 = 1065353216(0x3f800000, float:1.0)
        L_0x00b0:
            float r4 = r11 - r14
            float r17 = r17 - r14
            float r4 = r4 / r17
            double r9 = (double) r4
            double r9 = r12.get(r9)
            float r4 = (float) r9
            float r4 = r4 * r17
            float r4 = r4 + r14
            double r9 = (double) r4
        L_0x00c0:
            androidx.constraintlayout.motion.utils.CurveFit[] r4 = r0.mSpline
            r4 = r4[r18]
            double[] r12 = r0.mInterpolateData
            r4.getPos((double) r9, (double[]) r12)
            androidx.constraintlayout.motion.utils.CurveFit r4 = r0.mArcSpline
            if (r4 == 0) goto L_0x00d5
            double[] r12 = r0.mInterpolateData
            int r13 = r12.length
            if (r13 <= 0) goto L_0x00d5
            r4.getPos((double) r9, (double[]) r12)
        L_0x00d5:
            androidx.constraintlayout.motion.widget.MotionPaths r4 = r0.mStartMotionPath
            int[] r9 = r0.mInterpolateVariables
            double[] r10 = r0.mInterpolateData
            int r12 = r16 * 2
            r4.getCenter(r9, r10, r1, r12)
            if (r6 == 0) goto L_0x00ec
            r4 = r1[r12]
            float r9 = r6.get(r11)
            float r4 = r4 + r9
            r1[r12] = r4
            goto L_0x00f7
        L_0x00ec:
            if (r5 == 0) goto L_0x00f7
            r4 = r1[r12]
            float r9 = r5.get(r11)
            float r4 = r4 + r9
            r1[r12] = r4
        L_0x00f7:
            if (r7 == 0) goto L_0x0105
            int r12 = r12 + 1
            r4 = r1[r12]
            float r9 = r7.get(r11)
            float r4 = r4 + r9
            r1[r12] = r4
            goto L_0x0112
        L_0x0105:
            if (r8 == 0) goto L_0x0112
            int r12 = r12 + 1
            r4 = r1[r12]
            float r9 = r8.get(r11)
            float r4 = r4 + r9
            r1[r12] = r4
        L_0x0112:
            int r10 = r16 + 1
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0042
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.buildPath(float[], int):void");
    }

    /* access modifiers changed from: package-private */
    public void buildBounds(float[] fArr, int i) {
        int i2 = i;
        float f = 1.0f / ((float) (i2 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            SplineSet splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            SplineSet splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            KeyCycleOscillator keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            KeyCycleOscillator keyCycleOscillator2 = hashMap4.get("translationY");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            float f2 = ((float) i3) * f;
            float f3 = this.mStaggerScale;
            float f4 = 0.0f;
            if (f3 != 1.0f) {
                float f5 = this.mStaggerOffset;
                if (f2 < f5) {
                    f2 = 0.0f;
                }
                if (f2 > f5 && ((double) f2) < 1.0d) {
                    f2 = (f2 - f5) * f3;
                }
            }
            double d = (double) f2;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f6 = Float.NaN;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                if (next.mKeyFrameEasing != null) {
                    if (next.time < f2) {
                        easing = next.mKeyFrameEasing;
                        f4 = next.time;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                float f7 = f6 - f4;
                d = (double) ((((float) easing.get((double) ((f2 - f4) / f7))) * f7) + f4);
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 2);
        }
    }

    private float getPreCycleDistance() {
        char c;
        float[] fArr = new float[2];
        float f = 1.0f / ((float) 99);
        double d = 0.0d;
        double d2 = 0.0d;
        float f2 = 0.0f;
        for (int i = 0; i < 100; i++) {
            float f3 = ((float) i) * f;
            double d3 = (double) f3;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f4 = Float.NaN;
            float f5 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                if (next.mKeyFrameEasing != null) {
                    if (next.time < f3) {
                        Easing easing2 = next.mKeyFrameEasing;
                        f5 = next.time;
                        easing = easing2;
                    } else if (Float.isNaN(f4)) {
                        f4 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f4)) {
                    f4 = 1.0f;
                }
                float f6 = f4 - f5;
                d3 = (double) ((((float) easing.get((double) ((f3 - f5) / f6))) * f6) + f5);
            }
            this.mSpline[0].getPos(d3, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i > 0) {
                c = 1;
                f2 = (float) (((double) f2) + Math.hypot(d2 - ((double) fArr[1]), d - ((double) fArr[0])));
            } else {
                c = 1;
            }
            d = (double) fArr[0];
            d2 = (double) fArr[c];
        }
        return f2;
    }

    /* access modifiers changed from: package-private */
    public KeyPositionBase getPositionKeyframe(int i, int i2, float f, float f2) {
        float f3;
        float f4;
        int i3;
        int i4;
        RectF rectF = new RectF();
        rectF.left = this.mStartMotionPath.x;
        rectF.top = this.mStartMotionPath.y;
        rectF.right = rectF.left + this.mStartMotionPath.width;
        rectF.bottom = rectF.top + this.mStartMotionPath.height;
        RectF rectF2 = new RectF();
        rectF2.left = this.mEndMotionPath.x;
        rectF2.top = this.mEndMotionPath.y;
        rectF2.right = rectF2.left + this.mEndMotionPath.width;
        rectF2.bottom = rectF2.top + this.mEndMotionPath.height;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                i4 = i;
                i3 = i2;
                f4 = f;
                f3 = f2;
                if (keyPositionBase.intersects(i4, i3, rectF, rectF2, f4, f3)) {
                    return keyPositionBase;
                }
            } else {
                i4 = i;
                i3 = i2;
                f4 = f;
                f3 = f2;
            }
            i = i4;
            i2 = i3;
            f = f4;
            f2 = f3;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = it.next().mMode;
                i++;
            }
        }
        int i2 = 0;
        for (double pos : timePoints) {
            this.mSpline[0].getPos(pos, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    /* access modifiers changed from: package-private */
    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = it.next().mMode;
                i++;
            }
        }
        int i2 = 0;
        for (double pos : timePoints) {
            this.mSpline[0].getPos(pos, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    /* access modifiers changed from: package-private */
    public int getAttributeValues(String str, float[] fArr, int i) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = splineSet.get((float) (i2 / (fArr.length - 1)));
        }
        return fArr.length;
    }

    /* access modifiers changed from: package-private */
    public void buildRect(float f, float[] fArr, int i) {
        this.mSpline[0].getPos((double) getAdjustedPosition(f, (float[]) null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
    }

    /* access modifiers changed from: package-private */
    public void buildRectangles(float[] fArr, int i) {
        float f = 1.0f / ((float) (i - 1));
        for (int i2 = 0; i2 < i; i2++) {
            this.mSpline[0].getPos((double) getAdjustedPosition(((float) i2) * f, (float[]) null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 8);
        }
    }

    /* access modifiers changed from: package-private */
    public float getKeyFrameParameter(int i, float f, float f2) {
        float f3 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float f4 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float f5 = this.mStartMotionPath.x + (this.mStartMotionPath.width / 2.0f);
        float f6 = this.mStartMotionPath.y + (this.mStartMotionPath.height / 2.0f);
        float hypot = (float) Math.hypot((double) f3, (double) f4);
        if (((double) hypot) < 1.0E-7d) {
            return Float.NaN;
        }
        float f7 = f - f5;
        float f8 = f2 - f6;
        if (((float) Math.hypot((double) f7, (double) f8)) == 0.0f) {
            return 0.0f;
        }
        float f9 = (f7 * f3) + (f8 * f4);
        if (i == 0) {
            return f9 / hypot;
        }
        if (i == 1) {
            return (float) Math.sqrt((double) ((hypot * hypot) - (f9 * f9)));
        }
        if (i == 2) {
            return f7 / f3;
        }
        if (i == 3) {
            return f8 / f3;
        }
        if (i == 4) {
            return f7 / f4;
        }
        if (i != 5) {
            return 0.0f;
        }
        return f8 / f4;
    }

    private void insertKey(MotionPaths motionPaths) {
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Log.e(TAG, " KeyPath positon \"" + motionPaths.position + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    /* access modifiers changed from: package-private */
    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: double[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0413, code lost:
        r17 = r10;
        r18 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0417, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setup(int r17, int r18, float r19, long r20) {
        /*
            r16 = this;
            r0 = r16
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = r0.mPathMotionArc
            int r6 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r5 == r6) goto L_0x0027
            androidx.constraintlayout.motion.widget.MotionPaths r5 = r0.mStartMotionPath
            int r6 = r0.mPathMotionArc
            r5.mPathMotionArc = r6
        L_0x0027:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r5 = r0.mStartPoint
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.mEndPoint
            r5.different(r6, r2)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r5 = r0.mKeyList
            if (r5 == 0) goto L_0x008d
            java.util.Iterator r5 = r5.iterator()
            r7 = 0
        L_0x0037:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x008e
            java.lang.Object r8 = r5.next()
            androidx.constraintlayout.motion.widget.Key r8 = (androidx.constraintlayout.motion.widget.Key) r8
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyPosition
            if (r9 == 0) goto L_0x0065
            r13 = r8
            androidx.constraintlayout.motion.widget.KeyPosition r13 = (androidx.constraintlayout.motion.widget.KeyPosition) r13
            androidx.constraintlayout.motion.widget.MotionPaths r10 = new androidx.constraintlayout.motion.widget.MotionPaths
            androidx.constraintlayout.motion.widget.MotionPaths r14 = r0.mStartMotionPath
            androidx.constraintlayout.motion.widget.MotionPaths r15 = r0.mEndMotionPath
            r11 = r17
            r12 = r18
            r10.<init>(r11, r12, r13, r14, r15)
            r0.insertKey(r10)
            int r8 = r13.mCurveFit
            int r9 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r8 == r9) goto L_0x0037
            int r8 = r13.mCurveFit
            r0.mCurveFitType = r8
            goto L_0x0037
        L_0x0065:
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r9 == 0) goto L_0x006d
            r8.getAttributeNames(r3)
            goto L_0x0037
        L_0x006d:
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r9 == 0) goto L_0x0075
            r8.getAttributeNames(r1)
            goto L_0x0037
        L_0x0075:
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyTrigger
            if (r9 == 0) goto L_0x0086
            if (r7 != 0) goto L_0x0080
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x0080:
            androidx.constraintlayout.motion.widget.KeyTrigger r8 = (androidx.constraintlayout.motion.widget.KeyTrigger) r8
            r7.add(r8)
            goto L_0x0037
        L_0x0086:
            r8.setInterpolation(r4)
            r8.getAttributeNames(r2)
            goto L_0x0037
        L_0x008d:
            r7 = 0
        L_0x008e:
            r5 = 0
            if (r7 == 0) goto L_0x009b
            androidx.constraintlayout.motion.widget.KeyTrigger[] r8 = new androidx.constraintlayout.motion.widget.KeyTrigger[r5]
            java.lang.Object[] r7 = r7.toArray(r8)
            androidx.constraintlayout.motion.widget.KeyTrigger[] r7 = (androidx.constraintlayout.motion.widget.KeyTrigger[]) r7
            r0.mKeyTriggers = r7
        L_0x009b:
            boolean r7 = r2.isEmpty()
            java.lang.String r8 = ","
            java.lang.String r9 = "CUSTOM,"
            r10 = 1
            if (r7 != 0) goto L_0x0174
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.mAttributesMap = r7
            java.util.Iterator r7 = r2.iterator()
        L_0x00b1:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x0110
            java.lang.Object r11 = r7.next()
            java.lang.String r11 = (java.lang.String) r11
            boolean r12 = r11.startsWith(r9)
            if (r12 == 0) goto L_0x00fe
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.lang.String[] r13 = r11.split(r8)
            r13 = r13[r10]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r14 = r0.mKeyList
            java.util.Iterator r14 = r14.iterator()
        L_0x00d4:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x00f7
            java.lang.Object r15 = r14.next()
            androidx.constraintlayout.motion.widget.Key r15 = (androidx.constraintlayout.motion.widget.Key) r15
            r19 = 0
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r6 = r15.mCustomConstraints
            if (r6 != 0) goto L_0x00e7
            goto L_0x00d4
        L_0x00e7:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r6 = r15.mCustomConstraints
            java.lang.Object r6 = r6.get(r13)
            androidx.constraintlayout.widget.ConstraintAttribute r6 = (androidx.constraintlayout.widget.ConstraintAttribute) r6
            if (r6 == 0) goto L_0x00d4
            int r15 = r15.mFramePosition
            r12.append(r15, r6)
            goto L_0x00d4
        L_0x00f7:
            r19 = 0
            androidx.constraintlayout.motion.widget.SplineSet r6 = androidx.constraintlayout.motion.widget.SplineSet.makeCustomSpline(r11, r12)
            goto L_0x0104
        L_0x00fe:
            r19 = 0
            androidx.constraintlayout.motion.widget.SplineSet r6 = androidx.constraintlayout.motion.widget.SplineSet.makeSpline(r11)
        L_0x0104:
            if (r6 != 0) goto L_0x0107
            goto L_0x00b1
        L_0x0107:
            r6.setType(r11)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r12 = r0.mAttributesMap
            r12.put(r11, r6)
            goto L_0x00b1
        L_0x0110:
            r19 = 0
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r6 = r0.mKeyList
            if (r6 == 0) goto L_0x0130
            java.util.Iterator r6 = r6.iterator()
        L_0x011a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0130
            java.lang.Object r7 = r6.next()
            androidx.constraintlayout.motion.widget.Key r7 = (androidx.constraintlayout.motion.widget.Key) r7
            boolean r11 = r7 instanceof androidx.constraintlayout.motion.widget.KeyAttributes
            if (r11 == 0) goto L_0x011a
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r11 = r0.mAttributesMap
            r7.addValues(r11)
            goto L_0x011a
        L_0x0130:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.mStartPoint
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r7 = r0.mAttributesMap
            r6.addValues(r7, r5)
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.mEndPoint
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r7 = r0.mAttributesMap
            r11 = 100
            r6.addValues(r7, r11)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r6 = r0.mAttributesMap
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x014a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0176
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            boolean r11 = r4.containsKey(r7)
            if (r11 == 0) goto L_0x0167
            java.lang.Object r11 = r4.get(r7)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            goto L_0x0168
        L_0x0167:
            r11 = r5
        L_0x0168:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r12 = r0.mAttributesMap
            java.lang.Object r7 = r12.get(r7)
            androidx.constraintlayout.motion.widget.SplineSet r7 = (androidx.constraintlayout.motion.widget.SplineSet) r7
            r7.setup(r11)
            goto L_0x014a
        L_0x0174:
            r19 = 0
        L_0x0176:
            boolean r6 = r1.isEmpty()
            if (r6 != 0) goto L_0x0245
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r6 = r0.mTimeCycleAttributesMap
            if (r6 != 0) goto L_0x0187
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r0.mTimeCycleAttributesMap = r6
        L_0x0187:
            java.util.Iterator r1 = r1.iterator()
        L_0x018b:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x01f1
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r7 = r0.mTimeCycleAttributesMap
            boolean r7 = r7.containsKey(r6)
            if (r7 == 0) goto L_0x01a0
            goto L_0x018b
        L_0x01a0:
            boolean r7 = r6.startsWith(r9)
            if (r7 == 0) goto L_0x01df
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
            java.lang.String[] r11 = r6.split(r8)
            r11 = r11[r10]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r12 = r0.mKeyList
            java.util.Iterator r12 = r12.iterator()
        L_0x01b7:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01d8
            java.lang.Object r13 = r12.next()
            androidx.constraintlayout.motion.widget.Key r13 = (androidx.constraintlayout.motion.widget.Key) r13
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r14 = r13.mCustomConstraints
            if (r14 != 0) goto L_0x01c8
            goto L_0x01b7
        L_0x01c8:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r14 = r13.mCustomConstraints
            java.lang.Object r14 = r14.get(r11)
            androidx.constraintlayout.widget.ConstraintAttribute r14 = (androidx.constraintlayout.widget.ConstraintAttribute) r14
            if (r14 == 0) goto L_0x01b7
            int r13 = r13.mFramePosition
            r7.append(r13, r14)
            goto L_0x01b7
        L_0x01d8:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet r7 = androidx.constraintlayout.motion.widget.TimeCycleSplineSet.makeCustomSpline(r6, r7)
            r11 = r20
            goto L_0x01e5
        L_0x01df:
            r11 = r20
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet r7 = androidx.constraintlayout.motion.widget.TimeCycleSplineSet.makeSpline(r6, r11)
        L_0x01e5:
            if (r7 != 0) goto L_0x01e8
            goto L_0x018b
        L_0x01e8:
            r7.setType(r6)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r13 = r0.mTimeCycleAttributesMap
            r13.put(r6, r7)
            goto L_0x018b
        L_0x01f1:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.mKeyList
            if (r1 == 0) goto L_0x0211
            java.util.Iterator r1 = r1.iterator()
        L_0x01f9:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0211
            java.lang.Object r6 = r1.next()
            androidx.constraintlayout.motion.widget.Key r6 = (androidx.constraintlayout.motion.widget.Key) r6
            boolean r7 = r6 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r7 == 0) goto L_0x01f9
            androidx.constraintlayout.motion.widget.KeyTimeCycle r6 = (androidx.constraintlayout.motion.widget.KeyTimeCycle) r6
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r7 = r0.mTimeCycleAttributesMap
            r6.addTimeValues(r7)
            goto L_0x01f9
        L_0x0211:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r1 = r0.mTimeCycleAttributesMap
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x021b:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0245
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = r4.containsKey(r6)
            if (r7 == 0) goto L_0x0238
            java.lang.Object r7 = r4.get(r6)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            goto L_0x0239
        L_0x0238:
            r7 = r5
        L_0x0239:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r8 = r0.mTimeCycleAttributesMap
            java.lang.Object r6 = r8.get(r6)
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet r6 = (androidx.constraintlayout.motion.widget.TimeCycleSplineSet) r6
            r6.setup(r7)
            goto L_0x021b
        L_0x0245:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r1 = r0.mMotionPaths
            int r1 = r1.size()
            int r4 = r1 + 2
            androidx.constraintlayout.motion.widget.MotionPaths[] r6 = new androidx.constraintlayout.motion.widget.MotionPaths[r4]
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.mStartMotionPath
            r6[r5] = r7
            int r1 = r1 + r10
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.mEndMotionPath
            r6[r1] = r7
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r1 = r0.mMotionPaths
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0267
            int r1 = r0.mCurveFitType
            r7 = -1
            if (r1 != r7) goto L_0x0267
            r0.mCurveFitType = r5
        L_0x0267:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r1 = r0.mMotionPaths
            java.util.Iterator r1 = r1.iterator()
            r7 = r10
        L_0x026e:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x0280
            java.lang.Object r8 = r1.next()
            androidx.constraintlayout.motion.widget.MotionPaths r8 = (androidx.constraintlayout.motion.widget.MotionPaths) r8
            int r11 = r7 + 1
            r6[r7] = r8
            r7 = r11
            goto L_0x026e
        L_0x0280:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.mEndMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r7 = r7.attributes
            java.util.Set r7 = r7.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0291:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x02be
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            androidx.constraintlayout.motion.widget.MotionPaths r11 = r0.mStartMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r11 = r11.attributes
            boolean r11 = r11.containsKey(r8)
            if (r11 == 0) goto L_0x0291
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r9)
            java.lang.StringBuilder r11 = r11.append(r8)
            java.lang.String r11 = r11.toString()
            boolean r11 = r2.contains(r11)
            if (r11 != 0) goto L_0x0291
            r1.add(r8)
            goto L_0x0291
        L_0x02be:
            java.lang.String[] r2 = new java.lang.String[r5]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            r0.mAttributeNames = r1
            int r1 = r1.length
            int[] r1 = new int[r1]
            r0.mAttributeInterpCount = r1
            r1 = r5
        L_0x02ce:
            java.lang.String[] r2 = r0.mAttributeNames
            int r7 = r2.length
            if (r1 >= r7) goto L_0x0302
            r2 = r2[r1]
            int[] r7 = r0.mAttributeInterpCount
            r7[r1] = r5
            r7 = r5
        L_0x02da:
            if (r7 >= r4) goto L_0x02ff
            r8 = r6[r7]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r8 = r8.attributes
            boolean r8 = r8.containsKey(r2)
            if (r8 == 0) goto L_0x02fc
            int[] r8 = r0.mAttributeInterpCount
            r9 = r8[r1]
            r7 = r6[r7]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r7 = r7.attributes
            java.lang.Object r2 = r7.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r2 = (androidx.constraintlayout.widget.ConstraintAttribute) r2
            int r2 = r2.noOfInterpValues()
            int r9 = r9 + r2
            r8[r1] = r9
            goto L_0x02ff
        L_0x02fc:
            int r7 = r7 + 1
            goto L_0x02da
        L_0x02ff:
            int r1 = r1 + 1
            goto L_0x02ce
        L_0x0302:
            r1 = r6[r5]
            int r1 = r1.mPathMotionArc
            int r2 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r1 == r2) goto L_0x030c
            r1 = r10
            goto L_0x030d
        L_0x030c:
            r1 = r5
        L_0x030d:
            java.lang.String[] r2 = r0.mAttributeNames
            int r2 = r2.length
            r7 = 18
            int r7 = r7 + r2
            boolean[] r2 = new boolean[r7]
            r8 = r10
        L_0x0316:
            if (r8 >= r4) goto L_0x0326
            r9 = r6[r8]
            int r11 = r8 + -1
            r11 = r6[r11]
            java.lang.String[] r12 = r0.mAttributeNames
            r9.different(r11, r2, r12, r1)
            int r8 = r8 + 1
            goto L_0x0316
        L_0x0326:
            r8 = r5
            r1 = r10
        L_0x0328:
            if (r1 >= r7) goto L_0x0333
            boolean r9 = r2[r1]
            if (r9 == 0) goto L_0x0330
            int r8 = r8 + 1
        L_0x0330:
            int r1 = r1 + 1
            goto L_0x0328
        L_0x0333:
            int[] r1 = new int[r8]
            r0.mInterpolateVariables = r1
            int r8 = r1.length
            double[] r8 = new double[r8]
            r0.mInterpolateData = r8
            int r1 = r1.length
            double[] r1 = new double[r1]
            r0.mInterpolateVelocity = r1
            r8 = r5
            r1 = r10
        L_0x0343:
            if (r1 >= r7) goto L_0x0353
            boolean r9 = r2[r1]
            if (r9 == 0) goto L_0x0350
            int[] r9 = r0.mInterpolateVariables
            int r11 = r8 + 1
            r9[r8] = r1
            r8 = r11
        L_0x0350:
            int r1 = r1 + 1
            goto L_0x0343
        L_0x0353:
            int[] r1 = r0.mInterpolateVariables
            int r1 = r1.length
            r2 = 2
            int[] r7 = new int[r2]
            r7[r10] = r1
            r7[r5] = r4
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r7)
            double[][] r1 = (double[][]) r1
            double[] r7 = new double[r4]
            r8 = r5
        L_0x0368:
            if (r8 >= r4) goto L_0x037d
            r9 = r6[r8]
            r11 = r1[r8]
            int[] r12 = r0.mInterpolateVariables
            r9.fillStandard(r11, r12)
            r9 = r6[r8]
            float r9 = r9.time
            double r11 = (double) r9
            r7[r8] = r11
            int r8 = r8 + 1
            goto L_0x0368
        L_0x037d:
            r8 = r5
        L_0x037e:
            int[] r9 = r0.mInterpolateVariables
            int r11 = r9.length
            if (r8 >= r11) goto L_0x03c3
            r9 = r9[r8]
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.MotionPaths.names
            int r11 = r11.length
            if (r9 >= r11) goto L_0x03c0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.MotionPaths.names
            int[] r12 = r0.mInterpolateVariables
            r12 = r12[r8]
            r11 = r11[r12]
            java.lang.StringBuilder r9 = r9.append(r11)
            java.lang.String r11 = " ["
            java.lang.StringBuilder r9 = r9.append(r11)
            java.lang.String r9 = r9.toString()
            r11 = r5
        L_0x03a6:
            if (r11 >= r4) goto L_0x03c0
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.StringBuilder r9 = r12.append(r9)
            r12 = r1[r11]
            r12 = r12[r8]
            java.lang.StringBuilder r9 = r9.append(r12)
            java.lang.String r9 = r9.toString()
            int r11 = r11 + 1
            goto L_0x03a6
        L_0x03c0:
            int r8 = r8 + 1
            goto L_0x037e
        L_0x03c3:
            java.lang.String[] r8 = r0.mAttributeNames
            int r8 = r8.length
            int r8 = r8 + r10
            androidx.constraintlayout.motion.utils.CurveFit[] r8 = new androidx.constraintlayout.motion.utils.CurveFit[r8]
            r0.mSpline = r8
            r8 = r5
        L_0x03cc:
            java.lang.String[] r9 = r0.mAttributeNames
            int r11 = r9.length
            if (r8 >= r11) goto L_0x0437
            r11 = r19
            double[][] r11 = (double[][]) r11
            r9 = r9[r8]
            r12 = r19
            r14 = r12
            r11 = r5
            r13 = r11
        L_0x03dc:
            if (r11 >= r4) goto L_0x041c
            r15 = r6[r11]
            boolean r15 = r15.hasCustomData(r9)
            if (r15 == 0) goto L_0x0413
            if (r14 != 0) goto L_0x03fe
            double[] r12 = new double[r4]
            r14 = r6[r11]
            int r14 = r14.getCustomDataCount(r9)
            int[] r15 = new int[r2]
            r15[r10] = r14
            r15[r5] = r4
            java.lang.Class r14 = java.lang.Double.TYPE
            java.lang.Object r14 = java.lang.reflect.Array.newInstance(r14, r15)
            double[][] r14 = (double[][]) r14
        L_0x03fe:
            r15 = r6[r11]
            float r15 = r15.time
            r17 = r10
            r18 = r11
            double r10 = (double) r15
            r12[r13] = r10
            r10 = r6[r18]
            r11 = r14[r13]
            r10.getCustomData(r9, r11, r5)
            int r13 = r13 + 1
            goto L_0x0417
        L_0x0413:
            r17 = r10
            r18 = r11
        L_0x0417:
            int r11 = r18 + 1
            r10 = r17
            goto L_0x03dc
        L_0x041c:
            r17 = r10
            double[] r9 = java.util.Arrays.copyOf(r12, r13)
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r14, r13)
            double[][] r10 = (double[][]) r10
            androidx.constraintlayout.motion.utils.CurveFit[] r11 = r0.mSpline
            int r8 = r8 + 1
            int r12 = r0.mCurveFitType
            androidx.constraintlayout.motion.utils.CurveFit r9 = androidx.constraintlayout.motion.utils.CurveFit.get(r12, r9, r10)
            r11[r8] = r9
            r10 = r17
            goto L_0x03cc
        L_0x0437:
            r17 = r10
            androidx.constraintlayout.motion.utils.CurveFit[] r8 = r0.mSpline
            int r9 = r0.mCurveFitType
            androidx.constraintlayout.motion.utils.CurveFit r1 = androidx.constraintlayout.motion.utils.CurveFit.get(r9, r7, r1)
            r8[r5] = r1
            r1 = r6[r5]
            int r1 = r1.mPathMotionArc
            int r7 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r1 == r7) goto L_0x0488
            int[] r1 = new int[r4]
            double[] r7 = new double[r4]
            int[] r8 = new int[r2]
            r8[r17] = r2
            r8[r5] = r4
            java.lang.Class r2 = java.lang.Double.TYPE
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r2, r8)
            double[][] r2 = (double[][]) r2
            r8 = r5
        L_0x045e:
            if (r8 >= r4) goto L_0x0482
            r9 = r6[r8]
            int r9 = r9.mPathMotionArc
            r1[r8] = r9
            r9 = r6[r8]
            float r9 = r9.time
            double r9 = (double) r9
            r7[r8] = r9
            r9 = r2[r8]
            r10 = r6[r8]
            float r10 = r10.x
            double r10 = (double) r10
            r9[r5] = r10
            r9 = r2[r8]
            r10 = r6[r8]
            float r10 = r10.y
            double r10 = (double) r10
            r9[r17] = r10
            int r8 = r8 + 1
            goto L_0x045e
        L_0x0482:
            androidx.constraintlayout.motion.utils.CurveFit r1 = androidx.constraintlayout.motion.utils.CurveFit.getArc(r1, r7, r2)
            r0.mArcSpline = r1
        L_0x0488:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.mCycleMap = r1
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.mKeyList
            if (r1 == 0) goto L_0x04fd
            java.util.Iterator r1 = r3.iterator()
            r2 = 2143289344(0x7fc00000, float:NaN)
        L_0x0499:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04c5
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.motion.widget.KeyCycleOscillator r4 = androidx.constraintlayout.motion.widget.KeyCycleOscillator.makeSpline(r3)
            if (r4 != 0) goto L_0x04ac
            goto L_0x0499
        L_0x04ac:
            boolean r5 = r4.variesByPath()
            if (r5 == 0) goto L_0x04bc
            boolean r5 = java.lang.Float.isNaN(r2)
            if (r5 == 0) goto L_0x04bc
            float r2 = r0.getPreCycleDistance()
        L_0x04bc:
            r4.setType(r3)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> r5 = r0.mCycleMap
            r5.put(r3, r4)
            goto L_0x0499
        L_0x04c5:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.mKeyList
            java.util.Iterator r1 = r1.iterator()
        L_0x04cb:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04e3
            java.lang.Object r3 = r1.next()
            androidx.constraintlayout.motion.widget.Key r3 = (androidx.constraintlayout.motion.widget.Key) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r4 == 0) goto L_0x04cb
            androidx.constraintlayout.motion.widget.KeyCycle r3 = (androidx.constraintlayout.motion.widget.KeyCycle) r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> r4 = r0.mCycleMap
            r3.addCycleValues(r4)
            goto L_0x04cb
        L_0x04e3:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> r1 = r0.mCycleMap
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x04ed:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04fd
            java.lang.Object r3 = r1.next()
            androidx.constraintlayout.motion.widget.KeyCycleOscillator r3 = (androidx.constraintlayout.motion.widget.KeyCycleOscillator) r3
            r3.setup(r2)
            goto L_0x04ed
        L_0x04fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.setup(int, int, float, long):void");
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((float) ((int) this.mView.getX()), (float) ((int) this.mView.getY()), (float) this.mView.getWidth(), (float) this.mView.getHeight());
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    /* access modifiers changed from: package-private */
    public void setStartCurrentState(View view) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mStartMotionPath.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mStartPoint.setState(view);
    }

    /* access modifiers changed from: package-private */
    public void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        readView(this.mStartMotionPath);
        this.mStartMotionPath.setBounds((float) constraintWidget.getX(), (float) constraintWidget.getY(), (float) constraintWidget.getWidth(), (float) constraintWidget.getHeight());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    /* access modifiers changed from: package-private */
    public void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        this.mEndMotionPath.time = 1.0f;
        this.mEndMotionPath.position = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds((float) constraintWidget.getX(), (float) constraintWidget.getY(), (float) constraintWidget.getWidth(), (float) constraintWidget.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        float f2 = 0.0f;
        float f3 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.mStaggerScale;
            if (((double) f4) != 1.0d) {
                float f5 = this.mStaggerOffset;
                if (f < f5) {
                    f = 0.0f;
                }
                if (f > f5 && ((double) f) < 1.0d) {
                    f = (f - f5) * f4;
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        float f6 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (next.mKeyFrameEasing != null) {
                if (next.time < f) {
                    easing = next.mKeyFrameEasing;
                    f2 = next.time;
                } else if (Float.isNaN(f6)) {
                    f6 = next.time;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f6)) {
                f3 = f6;
            }
            float f7 = f3 - f2;
            double d = (double) ((f - f2) / f7);
            f = (((float) easing.get(d)) * f7) + f2;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d);
            }
        }
        return f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: androidx.constraintlayout.motion.widget.TimeCycleSplineSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: androidx.constraintlayout.motion.widget.TimeCycleSplineSet$PathRotate} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean interpolate(android.view.View r17, float r18, long r19, androidx.constraintlayout.motion.widget.KeyCache r21) {
        /*
            r16 = this;
            r0 = r16
            r2 = r17
            r1 = 0
            r3 = r18
            float r3 = r0.getAdjustedPosition(r3, r1)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r4 = r0.mAttributesMap
            if (r4 == 0) goto L_0x0027
            java.util.Collection r4 = r4.values()
            java.util.Iterator r4 = r4.iterator()
        L_0x0017:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0027
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.motion.widget.SplineSet r5 = (androidx.constraintlayout.motion.widget.SplineSet) r5
            r5.setProperty(r2, r3)
            goto L_0x0017
        L_0x0027:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r4 = r0.mTimeCycleAttributesMap
            r11 = 0
            if (r4 == 0) goto L_0x0059
            java.util.Collection r4 = r4.values()
            java.util.Iterator r7 = r4.iterator()
            r8 = r1
            r9 = r11
        L_0x0036:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet r1 = (androidx.constraintlayout.motion.widget.TimeCycleSplineSet) r1
            boolean r4 = r1 instanceof androidx.constraintlayout.motion.widget.TimeCycleSplineSet.PathRotate
            if (r4 == 0) goto L_0x004a
            r8 = r1
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$PathRotate r8 = (androidx.constraintlayout.motion.widget.TimeCycleSplineSet.PathRotate) r8
            goto L_0x0036
        L_0x004a:
            r4 = r19
            r6 = r21
            boolean r1 = r1.setProperty(r2, r3, r4, r6)
            r10 = r3
            r9 = r9 | r1
            r2 = r17
            goto L_0x0036
        L_0x0057:
            r12 = r9
            goto L_0x005b
        L_0x0059:
            r8 = r1
            r12 = r11
        L_0x005b:
            r10 = r3
            androidx.constraintlayout.motion.utils.CurveFit[] r1 = r0.mSpline
            r13 = 1
            if (r1 == 0) goto L_0x0142
            r1 = r1[r11]
            double r14 = (double) r10
            double[] r2 = r0.mInterpolateData
            r1.getPos((double) r14, (double[]) r2)
            androidx.constraintlayout.motion.utils.CurveFit[] r1 = r0.mSpline
            r1 = r1[r11]
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r14, (double[]) r2)
            androidx.constraintlayout.motion.utils.CurveFit r1 = r0.mArcSpline
            if (r1 == 0) goto L_0x0085
            double[] r2 = r0.mInterpolateData
            int r3 = r2.length
            if (r3 <= 0) goto L_0x0085
            r1.getPos((double) r14, (double[]) r2)
            androidx.constraintlayout.motion.utils.CurveFit r1 = r0.mArcSpline
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r14, (double[]) r2)
        L_0x0085:
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            int[] r3 = r0.mInterpolateVariables
            double[] r4 = r0.mInterpolateData
            double[] r5 = r0.mInterpolateVelocity
            r6 = 0
            r2 = r17
            r1.setView(r2, r3, r4, r5, r6)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r1 = r0.mAttributesMap
            if (r1 == 0) goto L_0x00c1
            java.util.Collection r1 = r1.values()
            java.util.Iterator r9 = r1.iterator()
        L_0x009f:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x00c1
            java.lang.Object r1 = r9.next()
            androidx.constraintlayout.motion.widget.SplineSet r1 = (androidx.constraintlayout.motion.widget.SplineSet) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.SplineSet.PathRotate
            if (r2 == 0) goto L_0x00be
            androidx.constraintlayout.motion.widget.SplineSet$PathRotate r1 = (androidx.constraintlayout.motion.widget.SplineSet.PathRotate) r1
            double[] r2 = r0.mInterpolateVelocity
            r4 = r2[r11]
            r6 = r2[r13]
            r2 = r17
            r3 = r10
            r1.setPathRotate(r2, r3, r4, r6)
            goto L_0x00bf
        L_0x00be:
            r3 = r10
        L_0x00bf:
            r10 = r3
            goto L_0x009f
        L_0x00c1:
            r3 = r10
            if (r8 == 0) goto L_0x00db
            double[] r1 = r0.mInterpolateVelocity
            r2 = r1
            r1 = r8
            r7 = r2[r11]
            r9 = r2[r13]
            r2 = r17
            r5 = r19
            r4 = r3
            r3 = r21
            boolean r1 = r1.setPathRotate(r2, r3, r4, r5, r7, r9)
            r3 = r4
            r1 = r1 | r12
            r12 = r1
            goto L_0x00dd
        L_0x00db:
            r2 = r17
        L_0x00dd:
            r1 = r13
        L_0x00de:
            androidx.constraintlayout.motion.utils.CurveFit[] r4 = r0.mSpline
            int r5 = r4.length
            if (r1 >= r5) goto L_0x0102
            r4 = r4[r1]
            float[] r5 = r0.mValuesBuff
            r4.getPos((double) r14, (float[]) r5)
            androidx.constraintlayout.motion.widget.MotionPaths r4 = r0.mStartMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r4 = r4.attributes
            java.lang.String[] r5 = r0.mAttributeNames
            int r6 = r1 + -1
            r5 = r5[r6]
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.widget.ConstraintAttribute r4 = (androidx.constraintlayout.widget.ConstraintAttribute) r4
            float[] r5 = r0.mValuesBuff
            r4.setInterpolatedValue(r2, r5)
            int r1 = r1 + 1
            goto L_0x00de
        L_0x0102:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mStartPoint
            int r1 = r1.mVisibilityMode
            if (r1 != 0) goto L_0x0130
            r1 = 0
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0115
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mStartPoint
            int r1 = r1.visibility
            r2.setVisibility(r1)
            goto L_0x0130
        L_0x0115:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0123
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mEndPoint
            int r1 = r1.visibility
            r2.setVisibility(r1)
            goto L_0x0130
        L_0x0123:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mEndPoint
            int r1 = r1.visibility
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r4 = r0.mStartPoint
            int r4 = r4.visibility
            if (r1 == r4) goto L_0x0130
            r2.setVisibility(r11)
        L_0x0130:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r1 = r0.mKeyTriggers
            if (r1 == 0) goto L_0x01b7
            r1 = r11
        L_0x0135:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r4 = r0.mKeyTriggers
            int r5 = r4.length
            if (r1 >= r5) goto L_0x01b7
            r4 = r4[r1]
            r4.conditionallyFire(r3, r2)
            int r1 = r1 + 1
            goto L_0x0135
        L_0x0142:
            r2 = r17
            r3 = r10
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            float r1 = r1.x
            androidx.constraintlayout.motion.widget.MotionPaths r4 = r0.mEndMotionPath
            float r4 = r4.x
            androidx.constraintlayout.motion.widget.MotionPaths r5 = r0.mStartMotionPath
            float r5 = r5.x
            float r4 = r4 - r5
            float r4 = r4 * r3
            float r1 = r1 + r4
            androidx.constraintlayout.motion.widget.MotionPaths r4 = r0.mStartMotionPath
            float r4 = r4.y
            androidx.constraintlayout.motion.widget.MotionPaths r5 = r0.mEndMotionPath
            float r5 = r5.y
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.mStartMotionPath
            float r6 = r6.y
            float r5 = r5 - r6
            float r5 = r5 * r3
            float r4 = r4 + r5
            androidx.constraintlayout.motion.widget.MotionPaths r5 = r0.mStartMotionPath
            float r5 = r5.width
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.mEndMotionPath
            float r6 = r6.width
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.mStartMotionPath
            float r7 = r7.width
            float r6 = r6 - r7
            float r6 = r6 * r3
            float r5 = r5 + r6
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.mStartMotionPath
            float r6 = r6.height
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.mEndMotionPath
            float r7 = r7.height
            androidx.constraintlayout.motion.widget.MotionPaths r8 = r0.mStartMotionPath
            float r8 = r8.height
            float r7 = r7 - r8
            float r7 = r7 * r3
            float r6 = r6 + r7
            r7 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r7
            int r8 = (int) r1
            float r4 = r4 + r7
            int r7 = (int) r4
            float r1 = r1 + r5
            int r1 = (int) r1
            float r4 = r4 + r6
            int r4 = (int) r4
            int r5 = r1 - r8
            int r6 = r4 - r7
            androidx.constraintlayout.motion.widget.MotionPaths r9 = r0.mEndMotionPath
            float r9 = r9.width
            androidx.constraintlayout.motion.widget.MotionPaths r10 = r0.mStartMotionPath
            float r10 = r10.width
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 != 0) goto L_0x01a7
            androidx.constraintlayout.motion.widget.MotionPaths r9 = r0.mEndMotionPath
            float r9 = r9.height
            androidx.constraintlayout.motion.widget.MotionPaths r10 = r0.mStartMotionPath
            float r10 = r10.height
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 == 0) goto L_0x01b4
        L_0x01a7:
            r9 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r9)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
            r2.measure(r5, r6)
        L_0x01b4:
            r2.layout(r8, r7, r1, r4)
        L_0x01b7:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> r1 = r0.mCycleMap
            if (r1 == 0) goto L_0x01e4
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x01c3:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x01e4
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.widget.KeyCycleOscillator r1 = (androidx.constraintlayout.motion.widget.KeyCycleOscillator) r1
            boolean r4 = r1 instanceof androidx.constraintlayout.motion.widget.KeyCycleOscillator.PathRotateSet
            if (r4 == 0) goto L_0x01e0
            androidx.constraintlayout.motion.widget.KeyCycleOscillator$PathRotateSet r1 = (androidx.constraintlayout.motion.widget.KeyCycleOscillator.PathRotateSet) r1
            double[] r4 = r0.mInterpolateVelocity
            r6 = r4
            r4 = r6[r11]
            r6 = r6[r13]
            r1.setPathRotate(r2, r3, r4, r6)
            goto L_0x01c3
        L_0x01e0:
            r1.setProperty(r2, r3)
            goto L_0x01c3
        L_0x01e4:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.interpolate(android.view.View, float, long, androidx.constraintlayout.motion.widget.KeyCache):boolean");
    }

    /* access modifiers changed from: package-private */
    public void getDpDt(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i = 0;
        if (curveFitArr != null) {
            double d = (double) adjustedPosition;
            curveFitArr[0].getSlope(d, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d, this.mInterpolateData);
            float f4 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i >= dArr.length) {
                    break;
                }
                dArr[i] = dArr[i] * ((double) f4);
                i++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d, dArr2);
                    this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        float f5 = f2;
        float f6 = f3;
        float[] fArr2 = fArr;
        float f7 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float f8 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float f9 = (this.mEndMotionPath.height - this.mStartMotionPath.height) + f8;
        fArr2[0] = (f7 * (1.0f - f5)) + (((this.mEndMotionPath.width - this.mStartMotionPath.width) + f7) * f5);
        fArr2[1] = (f8 * (1.0f - f6)) + (f9 * f6);
    }

    /* access modifiers changed from: package-private */
    public void getPostLayoutDvDp(float f, int i, int i2, float f2, float f3, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get("rotation");
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = hashMap8 == null ? null : hashMap8.get("rotation");
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            keyCycleOscillator = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator4, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator2, keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator5, keyCycleOscillator, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d = (double) adjustedPosition;
                curveFit.getPos(d, dArr);
                this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
            return;
        }
        int i3 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = (double) getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f4 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i3 < dArr2.length) {
                    dArr2[i3] = dArr2[i3] * ((double) f4);
                    i3++;
                } else {
                    float f5 = f2;
                    float f6 = f3;
                    float[] fArr2 = fArr;
                    this.mStartMotionPath.setDpDt(f5, f6, fArr2, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f5, f6, i, i2, fArr2);
                    return;
                }
            }
        } else {
            float f7 = this.mEndMotionPath.x - this.mStartMotionPath.x;
            float f8 = this.mEndMotionPath.y - this.mStartMotionPath.y;
            float f9 = f7;
            float f10 = (this.mEndMotionPath.height - this.mStartMotionPath.height) + f8;
            fArr[0] = (f9 * (1.0f - f2)) + ((f9 + (this.mEndMotionPath.width - this.mStartMotionPath.width)) * f2);
            fArr[1] = (f8 * (1.0f - f3)) + (f10 * f3);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator4, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator2, keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator5, keyCycleOscillator, adjustedPosition);
            velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
        }
    }

    public int getDrawPath() {
        int i = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i = Math.max(i, it.next().mDrawPath);
        }
        return Math.max(i, this.mEndMotionPath.mDrawPath);
    }

    public void setDrawPath(int i) {
        this.mStartMotionPath.mDrawPath = i;
    }

    /* access modifiers changed from: package-private */
    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    /* access modifiers changed from: package-private */
    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f, float f2, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        rectF.left = this.mStartMotionPath.x;
        rectF.top = this.mStartMotionPath.y;
        rectF.right = rectF.left + this.mStartMotionPath.width;
        rectF.bottom = rectF.top + this.mStartMotionPath.height;
        RectF rectF2 = new RectF();
        rectF2.left = this.mEndMotionPath.x;
        rectF2.top = this.mEndMotionPath.y;
        rectF2.right = rectF2.left + this.mEndMotionPath.width;
        rectF2.bottom = rectF2.top + this.mEndMotionPath.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.mKeyList.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            iArr[i] = next.mFramePosition + (next.mType * 1000);
            this.mSpline[0].getPos((double) (((float) next.mFramePosition) / 100.0f), this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
            i++;
        }
        return i;
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            if (next.mType == i || i != -1) {
                iArr[i3] = 0;
                iArr[i3 + 1] = next.mType;
                iArr[i3 + 2] = next.mFramePosition;
                this.mSpline[0].getPos((double) (((float) next.mFramePosition) / 100.0f), this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i3 + 3] = Float.floatToIntBits(fArr[0]);
                int i4 = i3 + 4;
                iArr[i4] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    iArr[i3 + 5] = keyPosition.mPositionType;
                    iArr[i3 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i4 = i3 + 7;
                    iArr[i4] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i5 = i4 + 1;
                iArr[i3] = i5 - i3;
                i2++;
                i3 = i5;
            }
        }
        return i2;
    }
}
