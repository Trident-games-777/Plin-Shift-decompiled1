package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun;
    public int[] wrapMeasure;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.horizontalRun;
        }
        if (i == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtuaLayout = z;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void setHasBaseline(boolean z) {
        this.hasBaseline = z;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public void setInPlaceholder(boolean z) {
        this.inPlaceholder = z;
    }

    /* access modifiers changed from: protected */
    public void setInBarrier(int i, boolean z) {
        this.mIsInBarrier[i] = z;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
        }
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str = "";
        StringBuilder append = new StringBuilder().append(this.mType != null ? "type: " + this.mType + " " : str);
        if (this.mDebugName != null) {
            str = "id: " + this.mDebugName + " ";
        }
        return append.append(str).append("(").append(this.mX).append(", ").append(this.mY).append(") - (").append(this.mWidth).append(" x ").append(this.mHeight).append(")").toString();
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int i = this.mWidth;
        int i2 = 0;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i2 = Math.max(this.mMatchConstraintMinWidth, i);
        } else {
            int i3 = this.mMatchConstraintMinWidth;
            if (i3 > 0) {
                this.mWidth = i3;
                i2 = i3;
            }
        }
        int i4 = this.mMatchConstraintMaxWidth;
        return (i4 <= 0 || i4 >= i2) ? i2 : i4;
    }

    public int getOptimizerWrapHeight() {
        int i = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                i = Math.max(this.mMatchConstraintMinHeight, i);
            } else {
                i = this.mMatchConstraintMinHeight;
                if (i > 0) {
                    this.mHeight = i;
                } else {
                    i = 0;
                }
            }
            int i2 = this.mMatchConstraintMaxHeight;
            return (i2 <= 0 || i2 >= i) ? i : i2;
        }
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i = constraintAnchor != null ? constraintAnchor.mMargin : 0;
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i + constraintAnchor2.mMargin : i;
    }

    public int getVerticalMargin() {
        int i = this.mLeft != null ? this.mTop.mMargin : 0;
        return this.mRight != null ? i + this.mBottom.mMargin : i;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
        } else if (i2 == 2) {
            this.mTop.mGoneMargin = i;
        } else if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else if (i2 == 4) {
            this.mBottom.mGoneMargin = i;
        }
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f > 0.0f && f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f > 0.0f && f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDimensionRatio(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0090
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x0090
        L_0x000b:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L_0x0039
            int r6 = r1 + -1
            if (r2 >= r6) goto L_0x0039
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002b
            goto L_0x0036
        L_0x002b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0035
            r3 = r4
            goto L_0x0036
        L_0x0035:
            r3 = r5
        L_0x0036:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L_0x0039:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L_0x0077
            int r1 = r1 - r4
            if (r2 >= r1) goto L_0x0077
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0086
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0086
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            if (r5 != r4) goto L_0x0071
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0071:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0077:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x0086
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0086:
            r9 = r0
        L_0x0087:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008f
            r8.mDimensionRatio = r9
            r8.mDimensionRatioSide = r5
        L_0x008f:
            return
        L_0x0090:
            r8.mDimensionRatio = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.setDimensionRatio(java.lang.String):void");
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.mWidth = i3;
        }
        this.mHeight = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.mHeight = i4;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i7 < (i6 = this.mWidth)) {
            i7 = i6;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i8 < (i5 = this.mHeight)) {
            i8 = i5;
        }
        this.mWidth = i7;
        this.mHeight = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.mHeight = i9;
        }
        int i10 = this.mMinWidth;
        if (i7 < i10) {
            this.mWidth = i10;
        }
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
        this.hasBaseline = i > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        boolean z;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0);
                } else if (z) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                } else if (z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                }
            } else if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
            } else if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
            }
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && type2 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0);
        } else {
            ConstraintAnchor anchor9 = getAnchor(type);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            if (anchor9.isValidConnection(anchor10)) {
                if (type == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                    i = 0;
                } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.BASELINE);
                    if (anchor13 != null) {
                        anchor13.reset();
                    }
                    ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor14.getTarget() != anchor10) {
                        anchor14.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    if (anchor15.isConnected()) {
                        opposite.reset();
                        anchor15.reset();
                    }
                } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor16.getTarget() != anchor10) {
                        anchor16.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    if (anchor17.isConnected()) {
                        opposite2.reset();
                        anchor17.reset();
                    }
                }
                anchor9.connect(anchor10, i);
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != (constraintAnchor2 = this.mLeft)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (i == 1 && this.mTop.mTarget != null && this.mTop.mTarget.mTarget == (constraintAnchor = this.mTop)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            if (this.mRight.mTarget == null || this.mRight.mTarget.mTarget != (constraintAnchor2 = this.mRight)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (i == 1 && this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == (constraintAnchor = this.mBottom)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        if (this.mListAnchors[i2].mTarget == null) {
            return false;
        }
        ConstraintAnchor constraintAnchor = this.mListAnchors[i2].mTarget.mTarget;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        if (constraintAnchor == constraintAnchorArr[i2]) {
            return false;
        }
        int i3 = i2 + 1;
        return constraintAnchorArr[i3].mTarget != null && this.mListAnchors[i3].mTarget.mTarget == this.mListAnchors[i3];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x04bc  */
    /* JADX WARNING: Removed duplicated region for block: B:250:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r43) {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mLeft
            androidx.constraintlayout.solver.SolverVariable r2 = r1.createObjectVariable(r2)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mRight
            androidx.constraintlayout.solver.SolverVariable r3 = r1.createObjectVariable(r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.mTop
            androidx.constraintlayout.solver.SolverVariable r4 = r1.createObjectVariable(r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r0.mBottom
            androidx.constraintlayout.solver.SolverVariable r5 = r1.createObjectVariable(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r0.mBaseline
            androidx.constraintlayout.solver.SolverVariable r6 = r1.createObjectVariable(r6)
            androidx.constraintlayout.solver.Metrics r7 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            r8 = 1
            if (r7 == 0) goto L_0x002f
            androidx.constraintlayout.solver.Metrics r7 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r10 = r7.widgets
            long r10 = r10 + r8
            r7.widgets = r10
        L_0x002f:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r7 = r0.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r7.start
            boolean r7 = r7.resolved
            r10 = 8
            r11 = 1
            r12 = 0
            if (r7 == 0) goto L_0x00e1
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r7 = r0.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r7.end
            boolean r7 = r7.resolved
            if (r7 == 0) goto L_0x00e1
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r7 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r7.start
            boolean r7 = r7.resolved
            if (r7 == 0) goto L_0x00e1
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r7 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r7.end
            boolean r7 = r7.resolved
            if (r7 == 0) goto L_0x00e1
            androidx.constraintlayout.solver.Metrics r7 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r7 == 0) goto L_0x005e
            androidx.constraintlayout.solver.Metrics r7 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r13 = r7.graphSolved
            long r13 = r13 + r8
            r7.graphSolved = r13
        L_0x005e:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r7 = r0.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r7.start
            int r7 = r7.value
            r1.addEquality(r2, r7)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r0.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r1.addEquality(r3, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            int r2 = r2.value
            r1.addEquality(r4, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r1.addEquality(r5, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.baseline
            int r2 = r2.value
            r1.addEquality(r6, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            if (r2 == 0) goto L_0x00de
            if (r2 == 0) goto L_0x009b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r2 = r2[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r4) goto L_0x009b
            r2 = r11
            goto L_0x009c
        L_0x009b:
            r2 = r12
        L_0x009c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.mParent
            if (r4 == 0) goto L_0x00aa
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r4.mListDimensionBehaviors
            r4 = r4[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r6) goto L_0x00aa
            r4 = r11
            goto L_0x00ab
        L_0x00aa:
            r4 = r12
        L_0x00ab:
            if (r2 == 0) goto L_0x00c4
            boolean[] r2 = r0.isTerminalWidget
            boolean r2 = r2[r12]
            if (r2 == 0) goto L_0x00c4
            boolean r2 = r0.isInHorizontalChain()
            if (r2 != 0) goto L_0x00c4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mRight
            androidx.constraintlayout.solver.SolverVariable r2 = r1.createObjectVariable(r2)
            r1.addGreaterThan(r2, r3, r12, r10)
        L_0x00c4:
            if (r4 == 0) goto L_0x00de
            boolean[] r2 = r0.isTerminalWidget
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x00de
            boolean r2 = r0.isInVerticalChain()
            if (r2 != 0) goto L_0x00de
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mBottom
            androidx.constraintlayout.solver.SolverVariable r2 = r1.createObjectVariable(r2)
            r1.addGreaterThan(r2, r5, r12, r10)
            return
        L_0x00de:
            r7 = r0
            goto L_0x04da
        L_0x00e1:
            androidx.constraintlayout.solver.Metrics r7 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r7 == 0) goto L_0x00ec
            androidx.constraintlayout.solver.Metrics r7 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r13 = r7.linearSolved
            long r13 = r13 + r8
            r7.linearSolved = r13
        L_0x00ec:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r0.mParent
            if (r7 == 0) goto L_0x0179
            if (r7 == 0) goto L_0x00fc
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r7.mListDimensionBehaviors
            r7 = r7[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r8) goto L_0x00fc
            r7 = r11
            goto L_0x00fd
        L_0x00fc:
            r7 = r12
        L_0x00fd:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r0.mParent
            if (r8 == 0) goto L_0x010b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r8.mListDimensionBehaviors
            r8 = r8[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r9) goto L_0x010b
            r8 = r11
            goto L_0x010c
        L_0x010b:
            r8 = r12
        L_0x010c:
            boolean r9 = r0.isChainHead(r12)
            if (r9 == 0) goto L_0x011b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r9
            r9.addChain(r0, r12)
            r9 = r11
            goto L_0x011f
        L_0x011b:
            boolean r9 = r0.isInHorizontalChain()
        L_0x011f:
            boolean r13 = r0.isChainHead(r11)
            if (r13 == 0) goto L_0x012e
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r13
            r13.addChain(r0, r11)
            r13 = r11
            goto L_0x0132
        L_0x012e:
            boolean r13 = r0.isInVerticalChain()
        L_0x0132:
            if (r9 != 0) goto L_0x0151
            if (r7 == 0) goto L_0x0151
            int r14 = r0.mVisibility
            if (r14 == r10) goto L_0x0151
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r0.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.mTarget
            if (r14 != 0) goto L_0x0151
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r0.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.mTarget
            if (r14 != 0) goto L_0x0151
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.mRight
            androidx.constraintlayout.solver.SolverVariable r14 = r1.createObjectVariable(r14)
            r1.addGreaterThan(r14, r3, r12, r11)
        L_0x0151:
            if (r13 != 0) goto L_0x0174
            if (r8 == 0) goto L_0x0174
            int r14 = r0.mVisibility
            if (r14 == r10) goto L_0x0174
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r0.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.mTarget
            if (r14 != 0) goto L_0x0174
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r0.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.mTarget
            if (r14 != 0) goto L_0x0174
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r0.mBaseline
            if (r14 != 0) goto L_0x0174
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.mBottom
            androidx.constraintlayout.solver.SolverVariable r14 = r1.createObjectVariable(r14)
            r1.addGreaterThan(r14, r5, r12, r11)
        L_0x0174:
            r18 = r9
            r19 = r13
            goto L_0x017f
        L_0x0179:
            r7 = r12
            r8 = r7
            r18 = r8
            r19 = r18
        L_0x017f:
            int r9 = r0.mWidth
            int r13 = r0.mMinWidth
            if (r9 >= r13) goto L_0x0186
            r9 = r13
        L_0x0186:
            int r13 = r0.mHeight
            int r14 = r0.mMinHeight
            if (r13 >= r14) goto L_0x018d
            r13 = r14
        L_0x018d:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r14 = r0.mListDimensionBehaviors
            r14 = r14[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r14 == r15) goto L_0x0197
            r14 = r11
            goto L_0x0198
        L_0x0197:
            r14 = r12
        L_0x0198:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r15 = r0.mListDimensionBehaviors
            r15 = r15[r11]
            r16 = r11
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 == r11) goto L_0x01a5
            r11 = r16
            goto L_0x01a6
        L_0x01a5:
            r11 = r12
        L_0x01a6:
            int r15 = r0.mDimensionRatioSide
            r0.mResolvedDimensionRatioSide = r15
            float r15 = r0.mDimensionRatio
            r0.mResolvedDimensionRatio = r15
            r17 = r12
            int r12 = r0.mMatchConstraintDefaultWidth
            int r10 = r0.mMatchConstraintDefaultHeight
            r21 = 0
            int r15 = (r15 > r21 ? 1 : (r15 == r21 ? 0 : -1))
            r21 = r4
            if (r15 <= 0) goto L_0x024b
            int r15 = r0.mVisibility
            r4 = 8
            if (r15 == r4) goto L_0x024b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r17]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r23 = r5
            r5 = 3
            if (r4 != r15) goto L_0x01d0
            if (r12 != 0) goto L_0x01d0
            r12 = r5
        L_0x01d0:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r15) goto L_0x01db
            if (r10 != 0) goto L_0x01db
            r10 = r5
        L_0x01db:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r17]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r15) goto L_0x01f3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r15) goto L_0x01f3
            if (r12 != r5) goto L_0x01f3
            if (r10 != r5) goto L_0x01f3
            r0.setupDimensionRatio(r7, r8, r14, r11)
            goto L_0x0247
        L_0x01f3:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r17]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r14 = 4
            if (r4 != r11) goto L_0x0218
            if (r12 != r5) goto L_0x0218
            r4 = r17
            r0.mResolvedDimensionRatioSide = r4
            float r4 = r0.mResolvedDimensionRatio
            int r5 = r0.mHeight
            float r5 = (float) r5
            float r4 = r4 * r5
            int r9 = (int) r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r27 = r13
            if (r4 == r5) goto L_0x0215
            r12 = r14
            goto L_0x024f
        L_0x0215:
            r4 = r16
            goto L_0x0250
        L_0x0218:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r11) goto L_0x0247
            if (r10 != r5) goto L_0x0247
            r4 = r16
            r0.mResolvedDimensionRatioSide = r4
            int r4 = r0.mDimensionRatioSide
            r5 = -1
            if (r4 != r5) goto L_0x0232
            r4 = 1065353216(0x3f800000, float:1.0)
            float r5 = r0.mResolvedDimensionRatio
            float r4 = r4 / r5
            r0.mResolvedDimensionRatio = r4
        L_0x0232:
            float r4 = r0.mResolvedDimensionRatio
            int r5 = r0.mWidth
            float r5 = (float) r5
            float r4 = r4 * r5
            int r13 = (int) r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r17 = 0
            r4 = r4[r17]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 == r5) goto L_0x0247
            r27 = r13
            r10 = r14
            goto L_0x024f
        L_0x0247:
            r27 = r13
            r4 = 1
            goto L_0x0250
        L_0x024b:
            r23 = r5
            r27 = r13
        L_0x024f:
            r4 = 0
        L_0x0250:
            int[] r5 = r0.mResolvedMatchConstraintDefault
            r17 = 0
            r5[r17] = r12
            r16 = 1
            r5[r16] = r10
            r0.mResolvedHasRatio = r4
            if (r4 == 0) goto L_0x0267
            int r5 = r0.mResolvedDimensionRatioSide
            r11 = -1
            if (r5 == 0) goto L_0x0265
            if (r5 != r11) goto L_0x0268
        L_0x0265:
            r5 = 1
            goto L_0x0269
        L_0x0267:
            r11 = -1
        L_0x0268:
            r5 = 0
        L_0x0269:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r0.mListDimensionBehaviors
            r17 = 0
            r13 = r13[r17]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r13 != r14) goto L_0x027a
            boolean r13 = r0 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r13 == 0) goto L_0x027a
            r13 = r9
            r9 = 1
            goto L_0x027c
        L_0x027a:
            r13 = r9
            r9 = 0
        L_0x027c:
            if (r9 == 0) goto L_0x027f
            r13 = 0
        L_0x027f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r0.mCenter
            boolean r14 = r14.isConnected()
            r16 = 1
            r26 = r14 ^ 1
            boolean[] r14 = r0.mIsInBarrier
            r15 = 8
            r17 = 0
            boolean r20 = r14[r17]
            boolean r28 = r14[r16]
            int r14 = r0.mHorizontalResolution
            r22 = r4
            r4 = 2
            r29 = 0
            if (r14 == r4) goto L_0x034c
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r14 = r0.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r14.start
            boolean r14 = r14.resolved
            if (r14 == 0) goto L_0x02df
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r14 = r0.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r14.end
            boolean r14 = r14.resolved
            if (r14 != 0) goto L_0x02ad
            goto L_0x02df
        L_0x02ad:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r5 = r0.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r5 = r5.start
            int r5 = r5.value
            r1.addEquality(r2, r5)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r5 = r0.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r5 = r5.end
            int r5 = r5.value
            r1.addEquality(r3, r5)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r0.mParent
            if (r5 == 0) goto L_0x034c
            if (r7 == 0) goto L_0x034c
            boolean[] r5 = r0.isTerminalWidget
            r9 = 0
            boolean r5 = r5[r9]
            if (r5 == 0) goto L_0x034c
            boolean r5 = r0.isInHorizontalChain()
            if (r5 != 0) goto L_0x034c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mRight
            androidx.constraintlayout.solver.SolverVariable r5 = r1.createObjectVariable(r5)
            r1.addGreaterThan(r5, r3, r9, r15)
            goto L_0x034c
        L_0x02df:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r0.mParent
            if (r14 == 0) goto L_0x02ea
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.mRight
            androidx.constraintlayout.solver.SolverVariable r14 = r1.createObjectVariable(r14)
            goto L_0x02ec
        L_0x02ea:
            r14 = r29
        L_0x02ec:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.mParent
            if (r4 == 0) goto L_0x02f7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mLeft
            androidx.constraintlayout.solver.SolverVariable r4 = r1.createObjectVariable(r4)
            goto L_0x02f9
        L_0x02f7:
            r4 = r29
        L_0x02f9:
            boolean[] r11 = r0.isTerminalWidget
            r17 = 0
            boolean r11 = r11[r17]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r15 = r0.mListDimensionBehaviors
            r15 = r15[r17]
            r30 = r22
            r22 = r10
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.mLeft
            r31 = r17
            r17 = r5
            r5 = r11
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mRight
            r32 = r21
            r21 = r12
            int r12 = r0.mX
            r33 = r3
            r3 = r7
            r7 = r14
            int r14 = r0.mMinWidth
            int[] r1 = r0.mMaxDimension
            r1 = r1[r31]
            r34 = r1
            float r1 = r0.mHorizontalBiasPercent
            r35 = r1
            int r1 = r0.mMatchConstraintMinWidth
            r36 = r1
            int r1 = r0.mMatchConstraintMaxWidth
            r37 = r1
            float r1 = r0.mMatchConstraintPercentWidth
            r38 = r2
            r2 = 1
            r25 = r1
            r41 = r6
            r40 = r23
            r39 = r32
            r16 = r35
            r23 = r36
            r24 = r37
            r1 = r43
            r6 = r4
            r4 = r8
            r8 = r15
            r15 = r34
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x035e
        L_0x034c:
            r38 = r2
            r33 = r3
            r41 = r6
            r3 = r7
            r4 = r8
            r39 = r21
            r30 = r22
            r40 = r23
            r22 = r10
            r21 = r12
        L_0x035e:
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            boolean r2 = r2.resolved
            if (r2 == 0) goto L_0x03b3
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            boolean r2 = r2.resolved
            if (r2 == 0) goto L_0x03b3
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            int r2 = r2.value
            r5 = r39
            r1.addEquality(r5, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r6 = r40
            r1.addEquality(r6, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r0.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.baseline
            int r2 = r2.value
            r7 = r41
            r1.addEquality(r7, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            if (r2 == 0) goto L_0x03ad
            if (r19 != 0) goto L_0x03ad
            if (r4 == 0) goto L_0x03ad
            boolean[] r8 = r0.isTerminalWidget
            r9 = 1
            boolean r8 = r8[r9]
            if (r8 == 0) goto L_0x03ab
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mBottom
            androidx.constraintlayout.solver.SolverVariable r2 = r1.createObjectVariable(r2)
            r8 = 0
            r15 = 8
            r1.addGreaterThan(r2, r6, r8, r15)
            goto L_0x03b1
        L_0x03ab:
            r8 = 0
            goto L_0x03af
        L_0x03ad:
            r8 = 0
            r9 = 1
        L_0x03af:
            r15 = 8
        L_0x03b1:
            r11 = r8
            goto L_0x03be
        L_0x03b3:
            r5 = r39
            r6 = r40
            r7 = r41
            r8 = 0
            r9 = 1
            r15 = 8
            r11 = r9
        L_0x03be:
            int r2 = r0.mVerticalResolution
            r10 = 2
            if (r2 != r10) goto L_0x03c5
            r12 = r8
            goto L_0x03c6
        L_0x03c5:
            r12 = r11
        L_0x03c6:
            if (r12 == 0) goto L_0x0483
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r0.mListDimensionBehaviors
            r2 = r2[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r10) goto L_0x03d6
            boolean r2 = r0 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r2 == 0) goto L_0x03d6
            r11 = r9
            goto L_0x03d7
        L_0x03d6:
            r11 = r8
        L_0x03d7:
            if (r11 == 0) goto L_0x03db
            r13 = r8
            goto L_0x03dd
        L_0x03db:
            r13 = r27
        L_0x03dd:
            if (r30 == 0) goto L_0x03e9
            int r2 = r0.mResolvedDimensionRatioSide
            if (r2 == r9) goto L_0x03e6
            r10 = -1
            if (r2 != r10) goto L_0x03e9
        L_0x03e6:
            r17 = r9
            goto L_0x03eb
        L_0x03e9:
            r17 = r8
        L_0x03eb:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            if (r2 == 0) goto L_0x03f6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mBottom
            androidx.constraintlayout.solver.SolverVariable r2 = r1.createObjectVariable(r2)
            goto L_0x03f8
        L_0x03f6:
            r2 = r29
        L_0x03f8:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r0.mParent
            if (r10 == 0) goto L_0x0402
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.mTop
            androidx.constraintlayout.solver.SolverVariable r29 = r1.createObjectVariable(r10)
        L_0x0402:
            int r10 = r0.mBaselineDistance
            if (r10 > 0) goto L_0x040a
            int r10 = r0.mVisibility
            if (r10 != r15) goto L_0x0438
        L_0x040a:
            int r10 = r0.getBaselineDistance()
            r1.addEquality(r7, r5, r10, r15)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.mTarget
            if (r10 == 0) goto L_0x0431
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.mTarget
            androidx.constraintlayout.solver.SolverVariable r10 = r1.createObjectVariable(r10)
            r1.addEquality(r7, r10, r8, r15)
            if (r4 == 0) goto L_0x042e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r0.mBottom
            androidx.constraintlayout.solver.SolverVariable r7 = r1.createObjectVariable(r7)
            r10 = 5
            r1.addGreaterThan(r2, r7, r8, r10)
        L_0x042e:
            r26 = r8
            goto L_0x0438
        L_0x0431:
            int r10 = r0.mVisibility
            if (r10 != r15) goto L_0x0438
            r1.addEquality(r7, r5, r8, r15)
        L_0x0438:
            boolean[] r7 = r0.isTerminalWidget
            boolean r7 = r7[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r0.mListDimensionBehaviors
            r8 = r8[r9]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.mTop
            r16 = r9
            r9 = r11
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mBottom
            int r12 = r0.mY
            int r14 = r0.mMinHeight
            int[] r15 = r0.mMaxDimension
            r15 = r15[r16]
            float r1 = r0.mVerticalBiasPercent
            r20 = r1
            int r1 = r0.mMatchConstraintMinHeight
            r23 = r1
            int r1 = r0.mMatchConstraintMaxHeight
            r24 = r1
            float r1 = r0.mMatchConstraintPercentHeight
            r32 = r5
            r5 = r7
            r7 = r2
            r2 = 0
            r16 = r4
            r4 = r3
            r3 = r16
            r16 = r19
            r19 = r18
            r18 = r16
            r16 = r22
            r22 = r21
            r21 = r16
            r25 = r1
            r40 = r6
            r16 = r20
            r20 = r28
            r6 = r29
            r1 = r43
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0487
        L_0x0483:
            r32 = r5
            r40 = r6
        L_0x0487:
            r7 = r0
            if (r30 == 0) goto L_0x04b2
            int r0 = r7.mResolvedDimensionRatioSide
            r6 = 8
            r4 = 1
            if (r0 != r4) goto L_0x04a1
            float r5 = r7.mResolvedDimensionRatio
            r0 = r43
            r2 = r32
            r3 = r33
            r4 = r38
            r1 = r40
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x04b2
        L_0x04a1:
            float r5 = r7.mResolvedDimensionRatio
            r0 = r43
            r4 = r32
            r1 = r33
            r2 = r38
            r3 = r40
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            r1 = r0
            goto L_0x04b4
        L_0x04b2:
            r1 = r43
        L_0x04b4:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x04da
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.getTarget()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.getOwner()
            float r2 = r7.mCircleConstraintAngle
            r3 = 1119092736(0x42b40000, float:90.0)
            float r2 = r2 + r3
            double r2 = (double) r2
            double r2 = java.lang.Math.toRadians(r2)
            float r2 = (float) r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.mCenter
            int r3 = r3.getMargin()
            r1.addCenterPoint(r7, r0, r2, r3)
        L_0x04da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }

    /* access modifiers changed from: package-private */
    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x03d8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:287:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:291:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(androidx.constraintlayout.solver.LinearSystem r29, boolean r30, boolean r31, boolean r32, boolean r33, androidx.constraintlayout.solver.SolverVariable r34, androidx.constraintlayout.solver.SolverVariable r35, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r36, boolean r37, androidx.constraintlayout.solver.widgets.ConstraintAnchor r38, androidx.constraintlayout.solver.widgets.ConstraintAnchor r39, int r40, int r41, int r42, int r43, float r44, boolean r45, boolean r46, boolean r47, boolean r48, int r49, int r50, int r51, int r52, float r53, boolean r54) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r10 = r34
            r12 = r38
            r13 = r39
            r14 = r42
            r2 = r43
            r4 = r51
            r5 = r52
            androidx.constraintlayout.solver.SolverVariable r6 = r1.createObjectVariable(r12)
            androidx.constraintlayout.solver.SolverVariable r7 = r1.createObjectVariable(r13)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r12.getTarget()
            androidx.constraintlayout.solver.SolverVariable r15 = r1.createObjectVariable(r8)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.getTarget()
            androidx.constraintlayout.solver.SolverVariable r8 = r1.createObjectVariable(r8)
            androidx.constraintlayout.solver.Metrics r9 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            if (r9 == 0) goto L_0x003c
            androidx.constraintlayout.solver.Metrics r9 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            long r11 = r9.nonresolvedWidgets
            r16 = 1
            long r11 = r11 + r16
            r9.nonresolvedWidgets = r11
        L_0x003c:
            boolean r11 = r38.isConnected()
            boolean r12 = r13.isConnected()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r0.mCenter
            boolean r16 = r9.isConnected()
            if (r12 == 0) goto L_0x004f
            int r9 = r11 + 1
            goto L_0x0050
        L_0x004f:
            r9 = r11
        L_0x0050:
            if (r16 == 0) goto L_0x0054
            int r9 = r9 + 1
        L_0x0054:
            r17 = r11
            if (r45 == 0) goto L_0x005b
            r18 = 3
            goto L_0x005d
        L_0x005b:
            r18 = r49
        L_0x005d:
            int[] r19 = androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour
            int r20 = r36.ordinal()
            r11 = r19[r20]
            r19 = r12
            r12 = 1
            if (r11 == r12) goto L_0x0073
            r12 = 2
            if (r11 == r12) goto L_0x0073
            r12 = 3
            if (r11 == r12) goto L_0x0073
            r12 = 4
            if (r11 == r12) goto L_0x0078
        L_0x0073:
            r11 = r18
        L_0x0075:
            r18 = 0
            goto L_0x007f
        L_0x0078:
            r11 = r18
            if (r11 != r12) goto L_0x007d
            goto L_0x0075
        L_0x007d:
            r18 = 1
        L_0x007f:
            int r12 = r0.mVisibility
            r3 = 8
            if (r12 != r3) goto L_0x0089
            r12 = 0
            r18 = 0
            goto L_0x008b
        L_0x0089:
            r12 = r41
        L_0x008b:
            if (r54 == 0) goto L_0x00ae
            if (r17 != 0) goto L_0x0099
            if (r19 != 0) goto L_0x0099
            if (r16 != 0) goto L_0x0099
            r3 = r40
            r1.addEquality(r6, r3)
            goto L_0x00a9
        L_0x0099:
            if (r17 == 0) goto L_0x00a9
            if (r19 != 0) goto L_0x00a9
            int r3 = r38.getMargin()
            r23 = r8
            r8 = 8
            r1.addEquality(r6, r15, r3, r8)
            goto L_0x00b1
        L_0x00a9:
            r23 = r8
            r8 = 8
            goto L_0x00b1
        L_0x00ae:
            r23 = r8
            r8 = r3
        L_0x00b1:
            if (r18 != 0) goto L_0x00da
            if (r37 == 0) goto L_0x00ca
            r3 = 3
            r8 = 0
            r1.addEquality(r7, r6, r8, r3)
            r8 = 8
            if (r14 <= 0) goto L_0x00c1
            r1.addGreaterThan(r7, r6, r14, r8)
        L_0x00c1:
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 >= r3) goto L_0x00cd
            r1.addLowerThan(r7, r6, r2, r8)
            goto L_0x00cd
        L_0x00ca:
            r1.addEquality(r7, r6, r12, r8)
        L_0x00cd:
            r3 = r5
            r5 = r7
            r2 = r9
            r24 = r18
            r12 = r23
            r18 = r33
        L_0x00d6:
            r23 = r4
            goto L_0x01c0
        L_0x00da:
            r2 = 2
            if (r9 == r2) goto L_0x00fd
            if (r45 != 0) goto L_0x00fd
            r2 = 1
            if (r11 == r2) goto L_0x00e4
            if (r11 != 0) goto L_0x00fd
        L_0x00e4:
            int r2 = java.lang.Math.max(r4, r12)
            if (r5 <= 0) goto L_0x00ee
            int r2 = java.lang.Math.min(r5, r2)
        L_0x00ee:
            r8 = 8
            r1.addEquality(r7, r6, r2, r8)
            r18 = r33
            r3 = r5
            r5 = r7
            r2 = r9
            r12 = r23
            r24 = 0
            goto L_0x00d6
        L_0x00fd:
            r2 = -2
            if (r4 != r2) goto L_0x0102
            r3 = r12
            goto L_0x0103
        L_0x0102:
            r3 = r4
        L_0x0103:
            if (r5 != r2) goto L_0x0107
            r2 = r12
            goto L_0x0108
        L_0x0107:
            r2 = r5
        L_0x0108:
            if (r12 <= 0) goto L_0x010e
            r4 = 1
            if (r11 == r4) goto L_0x010e
            r12 = 0
        L_0x010e:
            r8 = 8
            if (r3 <= 0) goto L_0x0119
            r1.addGreaterThan(r7, r6, r3, r8)
            int r12 = java.lang.Math.max(r12, r3)
        L_0x0119:
            r4 = 1
            if (r2 <= 0) goto L_0x0128
            if (r31 == 0) goto L_0x0121
            if (r11 != r4) goto L_0x0121
            goto L_0x0124
        L_0x0121:
            r1.addLowerThan(r7, r6, r2, r8)
        L_0x0124:
            int r12 = java.lang.Math.min(r12, r2)
        L_0x0128:
            if (r11 != r4) goto L_0x014e
            if (r31 == 0) goto L_0x0130
            r1.addEquality(r7, r6, r12, r8)
            goto L_0x0141
        L_0x0130:
            if (r46 == 0) goto L_0x013a
            r4 = 5
            r1.addEquality(r7, r6, r12, r4)
            r1.addLowerThan(r7, r6, r12, r8)
            goto L_0x0141
        L_0x013a:
            r4 = 5
            r1.addEquality(r7, r6, r12, r4)
            r1.addLowerThan(r7, r6, r12, r8)
        L_0x0141:
            r5 = r7
            r24 = r18
            r12 = r23
            r18 = r33
            r23 = r3
            r3 = r2
            r2 = r9
            goto L_0x01c0
        L_0x014e:
            r12 = 2
            if (r11 != r12) goto L_0x01b2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = r38.getType()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r4 == r5) goto L_0x017b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = r38.getType()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r4 != r5) goto L_0x0162
            goto L_0x017b
        L_0x0162:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.getAnchor(r5)
            androidx.constraintlayout.solver.SolverVariable r4 = r1.createObjectVariable(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.getAnchor(r8)
            androidx.constraintlayout.solver.SolverVariable r5 = r1.createObjectVariable(r5)
            goto L_0x0193
        L_0x017b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.getAnchor(r5)
            androidx.constraintlayout.solver.SolverVariable r4 = r1.createObjectVariable(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.getAnchor(r8)
            androidx.constraintlayout.solver.SolverVariable r5 = r1.createObjectVariable(r5)
        L_0x0193:
            r8 = r4
            androidx.constraintlayout.solver.ArrayRow r4 = r1.createRow()
            r37 = r7
            r7 = r5
            r5 = r37
            r37 = r2
            r2 = r9
            r12 = r23
            r9 = r53
            androidx.constraintlayout.solver.ArrayRow r4 = r4.createRowDimensionRatio(r5, r6, r7, r8, r9)
            r1.addConstraint(r4)
            r18 = r33
            r23 = r3
            r24 = 0
            goto L_0x01be
        L_0x01b2:
            r37 = r2
            r5 = r7
            r2 = r9
            r12 = r23
            r23 = r3
            r24 = r18
            r18 = 1
        L_0x01be:
            r3 = r37
        L_0x01c0:
            if (r54 == 0) goto L_0x03d1
            if (r46 == 0) goto L_0x01cb
            r11 = r35
            r12 = 2
            r13 = 8
            goto L_0x03d6
        L_0x01cb:
            if (r17 != 0) goto L_0x01d3
            if (r19 != 0) goto L_0x01d3
            if (r16 != 0) goto L_0x01d3
            goto L_0x03b7
        L_0x01d3:
            if (r17 == 0) goto L_0x01d9
            if (r19 != 0) goto L_0x01d9
            goto L_0x03b7
        L_0x01d9:
            if (r17 != 0) goto L_0x01f0
            if (r19 == 0) goto L_0x01f0
            int r2 = r13.getMargin()
            int r2 = -r2
            r8 = 8
            r1.addEquality(r5, r12, r2, r8)
            if (r31 == 0) goto L_0x03b7
            r4 = 5
            r8 = 0
            r1.addGreaterThan(r6, r10, r8, r4)
            goto L_0x03b7
        L_0x01f0:
            r4 = 5
            if (r17 == 0) goto L_0x03b7
            if (r19 == 0) goto L_0x03b7
            r2 = r38
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r7.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r8.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.getParent()
            r16 = 6
            if (r24 == 0) goto L_0x02b2
            if (r11 != 0) goto L_0x0236
            if (r3 != 0) goto L_0x0216
            if (r23 != 0) goto L_0x0216
            r3 = 8
            r17 = 8
            r19 = 0
            r25 = 1
            goto L_0x021d
        L_0x0216:
            r3 = r4
            r17 = r3
            r19 = 1
            r25 = 0
        L_0x021d:
            boolean r4 = r7 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r4 != 0) goto L_0x022b
            boolean r4 = r8 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r4 == 0) goto L_0x0226
            goto L_0x022b
        L_0x0226:
            r1 = r16
            r4 = r19
            goto L_0x0231
        L_0x022b:
            r1 = r16
            r4 = r19
            r17 = 4
        L_0x0231:
            r19 = r3
            r3 = 0
            goto L_0x02bc
        L_0x0236:
            r4 = 1
            if (r11 != r4) goto L_0x0243
            r1 = r16
            r3 = 1
            r4 = 1
            r17 = 4
            r19 = 8
            goto L_0x02ba
        L_0x0243:
            r4 = 3
            if (r11 != r4) goto L_0x02ad
            int r4 = r0.mResolvedDimensionRatioSide
            r1 = -1
            if (r4 != r1) goto L_0x025f
            if (r47 == 0) goto L_0x0253
            if (r31 == 0) goto L_0x0251
            r1 = 5
            goto L_0x0255
        L_0x0251:
            r1 = 4
            goto L_0x0255
        L_0x0253:
            r1 = 8
        L_0x0255:
            r3 = 1
            r4 = 1
            r17 = 5
            r19 = 8
        L_0x025b:
            r25 = 1
            goto L_0x02bc
        L_0x025f:
            if (r45 == 0) goto L_0x027e
            r1 = r50
            r4 = 2
            if (r1 == r4) goto L_0x026c
            r4 = 1
            if (r1 != r4) goto L_0x026a
            goto L_0x026c
        L_0x026a:
            r1 = 0
            goto L_0x026d
        L_0x026c:
            r1 = 1
        L_0x026d:
            if (r1 != 0) goto L_0x0273
            r1 = 8
            r3 = 5
            goto L_0x0275
        L_0x0273:
            r1 = 5
            r3 = 4
        L_0x0275:
            r19 = r1
            r17 = r3
            r1 = r16
            r3 = 1
            r4 = 1
            goto L_0x025b
        L_0x027e:
            if (r3 <= 0) goto L_0x0287
            r1 = r16
            r3 = 1
            r4 = 1
            r17 = 5
            goto L_0x02aa
        L_0x0287:
            if (r3 != 0) goto L_0x02a4
            if (r23 != 0) goto L_0x02a4
            if (r47 != 0) goto L_0x0294
            r1 = r16
            r3 = 1
            r4 = 1
            r17 = 8
            goto L_0x02aa
        L_0x0294:
            if (r7 == r9) goto L_0x029a
            if (r8 == r9) goto L_0x029a
            r1 = 4
            goto L_0x029b
        L_0x029a:
            r1 = 5
        L_0x029b:
            r19 = r1
            r1 = r16
            r3 = 1
            r4 = 1
            r17 = 4
            goto L_0x025b
        L_0x02a4:
            r1 = r16
            r3 = 1
            r4 = 1
            r17 = 4
        L_0x02aa:
            r19 = 5
            goto L_0x025b
        L_0x02ad:
            r1 = r16
            r3 = 0
            r4 = 0
            goto L_0x02b6
        L_0x02b2:
            r1 = r16
            r3 = 1
            r4 = 1
        L_0x02b6:
            r17 = 4
            r19 = 5
        L_0x02ba:
            r25 = 0
        L_0x02bc:
            if (r3 == 0) goto L_0x02c7
            if (r15 != r12) goto L_0x02c7
            if (r7 == r9) goto L_0x02c7
            r26 = 0
            r27 = 0
            goto L_0x02cb
        L_0x02c7:
            r26 = r3
            r27 = 1
        L_0x02cb:
            if (r4 == 0) goto L_0x02f5
            int r3 = r0.mVisibility
            r4 = 8
            if (r3 != r4) goto L_0x02d4
            r1 = 4
        L_0x02d4:
            r22 = r4
            int r4 = r2.getMargin()
            r3 = r8
            int r8 = r13.getMargin()
            r2 = r6
            r14 = r9
            r6 = r12
            r13 = r22
            r9 = r1
            r12 = r3
            r3 = r15
            r1 = r29
            r15 = r7
            r7 = r5
            r5 = r44
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            r5 = r6
            r6 = r2
            r2 = r5
            r5 = r7
            goto L_0x02fe
        L_0x02f5:
            r1 = r29
            r14 = r9
            r2 = r12
            r3 = r15
            r13 = 8
            r15 = r7
            r12 = r8
        L_0x02fe:
            int r4 = r0.mVisibility
            if (r4 != r13) goto L_0x0304
            goto L_0x0421
        L_0x0304:
            if (r26 == 0) goto L_0x032a
            if (r31 == 0) goto L_0x0317
            if (r3 == r2) goto L_0x0317
            if (r24 != 0) goto L_0x0317
            boolean r4 = r15 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r4 != 0) goto L_0x0314
            boolean r4 = r12 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r4 == 0) goto L_0x0317
        L_0x0314:
            r4 = r16
            goto L_0x0319
        L_0x0317:
            r4 = r19
        L_0x0319:
            int r7 = r38.getMargin()
            r1.addGreaterThan(r6, r3, r7, r4)
            int r7 = r39.getMargin()
            int r7 = -r7
            r1.addLowerThan(r5, r2, r7, r4)
            r19 = r4
        L_0x032a:
            if (r31 == 0) goto L_0x033c
            if (r48 == 0) goto L_0x033c
            boolean r4 = r15 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r4 != 0) goto L_0x033c
            boolean r4 = r12 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r4 != 0) goto L_0x033c
            r4 = r16
            r7 = r4
            r21 = 1
            goto L_0x0342
        L_0x033c:
            r4 = r17
            r7 = r19
            r21 = r27
        L_0x0342:
            if (r21 == 0) goto L_0x038f
            if (r25 == 0) goto L_0x036f
            if (r47 == 0) goto L_0x034a
            if (r32 == 0) goto L_0x036f
        L_0x034a:
            if (r15 == r14) goto L_0x0351
            if (r12 != r14) goto L_0x034f
            goto L_0x0351
        L_0x034f:
            r16 = r4
        L_0x0351:
            boolean r8 = r15 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r8 != 0) goto L_0x0359
            boolean r8 = r12 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r8 == 0) goto L_0x035b
        L_0x0359:
            r16 = 5
        L_0x035b:
            boolean r8 = r15 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r8 != 0) goto L_0x0363
            boolean r8 = r12 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r8 == 0) goto L_0x0365
        L_0x0363:
            r16 = 5
        L_0x0365:
            if (r47 == 0) goto L_0x0369
            r8 = 5
            goto L_0x036b
        L_0x0369:
            r8 = r16
        L_0x036b:
            int r4 = java.lang.Math.max(r8, r4)
        L_0x036f:
            if (r31 == 0) goto L_0x037f
            int r4 = java.lang.Math.min(r7, r4)
            if (r45 == 0) goto L_0x037f
            if (r47 != 0) goto L_0x037f
            if (r15 == r14) goto L_0x037d
            if (r12 != r14) goto L_0x037f
        L_0x037d:
            r12 = 4
            goto L_0x0380
        L_0x037f:
            r12 = r4
        L_0x0380:
            int r4 = r38.getMargin()
            r1.addEquality(r6, r3, r4, r12)
            int r4 = r39.getMargin()
            int r4 = -r4
            r1.addEquality(r5, r2, r4, r12)
        L_0x038f:
            if (r31 == 0) goto L_0x039f
            if (r10 != r3) goto L_0x0398
            int r4 = r38.getMargin()
            goto L_0x0399
        L_0x0398:
            r4 = 0
        L_0x0399:
            if (r3 == r10) goto L_0x039f
            r3 = 5
            r1.addGreaterThan(r6, r10, r4, r3)
        L_0x039f:
            if (r31 == 0) goto L_0x03b8
            if (r24 == 0) goto L_0x03b8
            if (r42 != 0) goto L_0x03b8
            if (r23 != 0) goto L_0x03b8
            if (r24 == 0) goto L_0x03b1
            r12 = 3
            if (r11 != r12) goto L_0x03b1
            r8 = 0
            r1.addGreaterThan(r5, r6, r8, r13)
            goto L_0x03b8
        L_0x03b1:
            r8 = 0
            r4 = 5
            r1.addGreaterThan(r5, r6, r8, r4)
            goto L_0x03b8
        L_0x03b7:
            r2 = r12
        L_0x03b8:
            if (r31 == 0) goto L_0x0421
            if (r18 == 0) goto L_0x0421
            r13 = r39
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r13.mTarget
            if (r3 == 0) goto L_0x03c7
            int r12 = r13.getMargin()
            goto L_0x03c8
        L_0x03c7:
            r12 = 0
        L_0x03c8:
            r11 = r35
            if (r2 == r11) goto L_0x0421
            r4 = 5
            r1.addGreaterThan(r11, r5, r12, r4)
            return
        L_0x03d1:
            r11 = r35
            r13 = 8
            r12 = 2
        L_0x03d6:
            if (r2 >= r12) goto L_0x0421
            if (r31 == 0) goto L_0x0421
            if (r18 == 0) goto L_0x0421
            r8 = 0
            r1.addGreaterThan(r6, r10, r8, r13)
            if (r30 != 0) goto L_0x03eb
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 != 0) goto L_0x03e9
            goto L_0x03eb
        L_0x03e9:
            r8 = 0
            goto L_0x03ec
        L_0x03eb:
            r8 = 1
        L_0x03ec:
            if (r30 != 0) goto L_0x041a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x041a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            float r3 = r2.mDimensionRatio
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0418
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r2.mListDimensionBehaviors
            r20 = 0
            r3 = r3[r20]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x0418
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r21 = 1
            r2 = r2[r21]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x0418
            r12 = r21
            goto L_0x041b
        L_0x0418:
            r12 = 0
            goto L_0x041b
        L_0x041a:
            r12 = r8
        L_0x041b:
            if (r12 == 0) goto L_0x0421
            r8 = 0
            r1.addGreaterThan(r11, r5, r8, r13)
        L_0x0421:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.solver.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = r0
                r1 = 1
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r4
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0062 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x0083 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type     // Catch:{ NoSuchFieldError -> 0x009b }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.<clinit>():void");
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (this.horizontalRun.start.resolved && this.horizontalRun.end.resolved) {
            objectVariableValue = this.horizontalRun.start.value;
            objectVariableValue3 = this.horizontalRun.end.value;
        }
        if (this.verticalRun.start.resolved && this.verticalRun.end.resolved) {
            objectVariableValue2 = this.verticalRun.start.value;
            objectVariableValue4 = this.verticalRun.end.value;
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget2 = null;
        this.mParent = this.mParent == null ? null : hashMap.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mOptimizerMeasurable = constraintWidget.mOptimizerMeasurable;
        this.mGroupsToSolver = constraintWidget.mGroupsToSolver;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.mVerticalNextWidget = constraintWidget2;
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean isResolved = z & this.horizontalRun.isResolved();
        boolean isResolved2 = z2 & this.verticalRun.isResolved();
        int i3 = this.horizontalRun.start.value;
        int i4 = this.verticalRun.start.value;
        int i5 = this.horizontalRun.end.value;
        int i6 = this.verticalRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (isResolved) {
            this.mX = i3;
        }
        if (isResolved2) {
            this.mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i9 < (i = this.mHeight)) {
                i9 = i;
            }
            this.mHeight = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.mHeight = i11;
            }
        }
    }
}
