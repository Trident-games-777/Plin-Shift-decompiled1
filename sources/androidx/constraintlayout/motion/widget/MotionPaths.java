package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    float height;
    int mDrawPath = 0;
    Easing mKeyFrameEasing;
    int mMode = 0;
    int mPathMotionArc = Key.UNSET;
    float mPathRotate = Float.NaN;
    float mProgress = Float.NaN;
    double[] mTempDelta = new double[18];
    double[] mTempValue = new double[18];
    float position;
    float time;
    float width;
    float x;
    float y;

    private static final float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    private static final float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f5 - f3) * f) + ((f6 - f4) * f2) + f4;
    }

    public MotionPaths() {
    }

    /* access modifiers changed from: package-private */
    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition2.mDrawPath;
        float f2 = Float.isNaN(keyPosition2.mPercentWidth) ? f : keyPosition2.mPercentWidth;
        float f3 = Float.isNaN(keyPosition2.mPercentHeight) ? f : keyPosition2.mPercentHeight;
        float f4 = motionPaths4.width;
        float f5 = motionPaths3.width;
        float f6 = motionPaths4.height;
        float f7 = motionPaths3.height;
        this.position = this.time;
        float f8 = motionPaths3.x;
        float f9 = motionPaths3.y;
        float f10 = f;
        float f11 = (motionPaths4.x + (f4 / 2.0f)) - ((f5 / 2.0f) + f8);
        float f12 = (motionPaths4.y + (f6 / 2.0f)) - (f9 + (f7 / 2.0f));
        float f13 = (f4 - f5) * f2;
        float f14 = f13 / 2.0f;
        this.x = (float) ((int) ((f8 + (f11 * f10)) - f14));
        float f15 = (f6 - f7) * f3;
        float f16 = f15 / 2.0f;
        this.y = (float) ((int) ((f9 + (f12 * f10)) - f16));
        this.width = (float) ((int) (f5 + f13));
        this.height = (float) ((int) (f7 + f15));
        float f17 = Float.isNaN(keyPosition2.mPercentX) ? f10 : keyPosition2.mPercentX;
        float f18 = 0.0f;
        float f19 = Float.isNaN(keyPosition2.mAltPercentY) ? 0.0f : keyPosition2.mAltPercentY;
        if (!Float.isNaN(keyPosition2.mPercentY)) {
            f10 = keyPosition2.mPercentY;
        }
        if (!Float.isNaN(keyPosition2.mAltPercentX)) {
            f18 = keyPosition2.mAltPercentX;
        }
        this.mMode = 2;
        this.x = (float) ((int) (((motionPaths3.x + (f17 * f11)) + (f18 * f12)) - f14));
        this.y = (float) ((int) (((motionPaths3.y + (f11 * f19)) + (f12 * f10)) - f16));
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        this.mPathMotionArc = keyPosition2.mPathMotionArc;
    }

    public MotionPaths(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i3 = keyPosition.mPositionType;
        if (i3 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i3 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i, i2, keyPosition, motionPaths, motionPaths2);
        }
    }

    /* access modifiers changed from: package-private */
    public void initScreen(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition2.mDrawPath;
        float f2 = Float.isNaN(keyPosition2.mPercentWidth) ? f : keyPosition2.mPercentWidth;
        float f3 = Float.isNaN(keyPosition2.mPercentHeight) ? f : keyPosition2.mPercentHeight;
        float f4 = motionPaths4.width;
        float f5 = motionPaths3.width;
        float f6 = motionPaths4.height;
        float f7 = motionPaths3.height;
        this.position = this.time;
        float f8 = motionPaths3.x;
        float f9 = motionPaths3.y;
        float f10 = motionPaths4.x + (f4 / 2.0f);
        float f11 = motionPaths4.y + (f6 / 2.0f);
        float f12 = (f4 - f5) * f2;
        this.x = (float) ((int) ((f8 + ((f10 - ((f5 / 2.0f) + f8)) * f)) - (f12 / 2.0f)));
        float f13 = (f6 - f7) * f3;
        this.y = (float) ((int) ((f9 + ((f11 - (f9 + (f7 / 2.0f))) * f)) - (f13 / 2.0f)));
        this.width = (float) ((int) (f5 + f12));
        this.height = (float) ((int) (f7 + f13));
        this.mMode = 3;
        if (!Float.isNaN(keyPosition2.mPercentX)) {
            this.x = (float) ((int) (keyPosition2.mPercentX * ((float) ((int) (((float) i) - this.width)))));
        }
        if (!Float.isNaN(keyPosition2.mPercentY)) {
            this.y = (float) ((int) (keyPosition2.mPercentY * ((float) ((int) (((float) i2) - this.height)))));
        }
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        this.mPathMotionArc = keyPosition2.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition2.mDrawPath;
        float f2 = Float.isNaN(keyPosition2.mPercentWidth) ? f : keyPosition2.mPercentWidth;
        float f3 = Float.isNaN(keyPosition2.mPercentHeight) ? f : keyPosition2.mPercentHeight;
        float f4 = motionPaths4.width - motionPaths3.width;
        float f5 = motionPaths4.height - motionPaths3.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition2.mPercentX)) {
            f = keyPosition2.mPercentX;
        }
        float f6 = motionPaths3.x;
        float f7 = motionPaths3.width;
        float f8 = motionPaths3.y;
        float f9 = motionPaths3.height;
        float f10 = f;
        float f11 = (motionPaths4.x + (motionPaths4.width / 2.0f)) - ((f7 / 2.0f) + f6);
        float f12 = (motionPaths4.y + (motionPaths4.height / 2.0f)) - ((f9 / 2.0f) + f8);
        float f13 = f11 * f10;
        float f14 = f4 * f2;
        float f15 = f14 / 2.0f;
        this.x = (float) ((int) ((f6 + f13) - f15));
        float f16 = f12 * f10;
        float f17 = f5 * f3;
        float f18 = f17 / 2.0f;
        this.y = (float) ((int) ((f8 + f16) - f18));
        this.width = (float) ((int) (f7 + f14));
        this.height = (float) ((int) (f9 + f17));
        float f19 = Float.isNaN(keyPosition2.mPercentY) ? 0.0f : keyPosition2.mPercentY;
        this.mMode = 1;
        float f20 = (float) ((int) ((motionPaths3.x + f13) - f15));
        this.x = f20;
        this.x = f20 + ((-f12) * f19);
        this.y = ((float) ((int) ((motionPaths3.y + f16) - f18))) + (f11 * f19);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition2.mTransitionEasing);
        this.mPathMotionArc = keyPosition2.mPathMotionArc;
    }

    private boolean diff(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    /* access modifiers changed from: package-private */
    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        zArr[1] = zArr[1] | diff(this.x, motionPaths.x) | z;
        zArr[2] = z | diff(this.y, motionPaths.y) | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    /* access modifiers changed from: package-private */
    public void getCenter(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.width;
        float f2 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f2;
    }

    /* access modifiers changed from: package-private */
    public void setView(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f;
        View view2 = view;
        int[] iArr2 = iArr;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        if (iArr2.length != 0 && this.mTempValue.length <= iArr2[iArr2.length - 1]) {
            int i = iArr2[iArr2.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        int i2 = 0;
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            double[] dArr4 = this.mTempValue;
            int i4 = iArr2[i3];
            dArr4[i4] = dArr[i3];
            this.mTempDelta[i4] = dArr2[i3];
        }
        float f6 = Float.NaN;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i2 >= dArr5.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr5[i2]);
            double d = 0.0d;
            if (!isNaN || !(dArr3 == null || dArr3[i2] == 0.0d)) {
                if (dArr3 != null) {
                    d = dArr3[i2];
                }
                if (!Double.isNaN(this.mTempValue[i2])) {
                    d = this.mTempValue[i2] + d;
                }
                f = f6;
                float f11 = (float) d;
                float f12 = (float) this.mTempDelta[i2];
                if (i2 == 1) {
                    f6 = f;
                    f2 = f11;
                    f7 = f12;
                } else if (i2 == 2) {
                    f6 = f;
                    f3 = f11;
                    f9 = f12;
                } else if (i2 == 3) {
                    f6 = f;
                    f4 = f11;
                    f8 = f12;
                } else if (i2 == 4) {
                    f6 = f;
                    f5 = f11;
                    f10 = f12;
                } else if (i2 == 5) {
                    f6 = f11;
                }
                i2++;
            } else {
                f = f6;
            }
            f6 = f;
            i2++;
        }
        float f13 = f6;
        if (!Float.isNaN(f13)) {
            float f14 = Float.NaN;
            if (Float.isNaN(Float.NaN)) {
                f14 = 0.0f;
            }
            view2.setRotation((float) (((double) f14) + ((double) f13) + Math.toDegrees(Math.atan2((double) (f9 + (f10 / 2.0f)), (double) (f7 + (f8 / 2.0f))))));
        } else if (!Float.isNaN(Float.NaN)) {
            view2.setRotation(Float.NaN);
        }
        float f15 = f2 + 0.5f;
        int i5 = (int) f15;
        float f16 = f3 + 0.5f;
        int i6 = (int) f16;
        int i7 = (int) (f15 + f4);
        int i8 = (int) (f16 + f5);
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        if (!(i9 == view2.getMeasuredWidth() && i10 == view2.getMeasuredHeight())) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
        }
        view2.layout(i5, i6, i7, i8);
    }

    /* access modifiers changed from: package-private */
    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        float f6 = f3 + f;
        float f7 = f4 + f2;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = f + 0.0f;
        fArr[i + 1] = f2 + 0.0f;
        fArr[i + 2] = f6 + 0.0f;
        fArr[i + 3] = f2 + 0.0f;
        fArr[i + 4] = f6 + 0.0f;
        int i4 = i + 6;
        fArr[i + 5] = f7 + 0.0f;
        fArr[i4] = f + 0.0f;
        fArr[i + 7] = f7 + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr2.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr2[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (f8 * (1.0f - f)) + (((f4 * 1.0f) + f8) * f) + 0.0f;
        fArr[1] = (f9 * (1.0f - f2)) + (((f6 * 1.0f) + f9) * f2) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int i = 0;
        for (int i2 : iArr) {
            if (i2 < 6) {
                dArr[i] = (double) fArr[i2];
                i++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    /* access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i] = (double) constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        float[] fArr = new float[noOfInterpValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        int i2 = 0;
        while (i2 < noOfInterpValues) {
            dArr[i] = (double) fArr[i2];
            i2++;
            i++;
        }
        return noOfInterpValues;
    }

    /* access modifiers changed from: package-private */
    public void setBounds(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        this.mPathMotionArc = constraint.motion.mPathMotionArc;
        this.mPathRotate = constraint.motion.mPathRotate;
        this.mDrawPath = constraint.motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (String next : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(next);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(next, constraintAttribute);
            }
        }
    }
}
