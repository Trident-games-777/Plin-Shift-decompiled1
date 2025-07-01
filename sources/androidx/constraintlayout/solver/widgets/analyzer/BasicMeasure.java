package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure = new Measure();
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public enum MeasureType {
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer2.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer2.mChildren.get(i);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer2.invalidateGraph();
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.constraintWidgetContainer = constraintWidgetContainer2;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer2) {
        int size = constraintWidgetContainer2.mChildren.size();
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer2.mChildren.get(i);
            if (!(constraintWidget instanceof Guideline) && (!constraintWidget.horizontalRun.dimension.resolved || !constraintWidget.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    measure(measurer, constraintWidget, false);
                    if (constraintWidgetContainer2.mMetrics != null) {
                        constraintWidgetContainer2.mMetrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer2, String str, int i, int i2) {
        int minWidth = constraintWidgetContainer2.getMinWidth();
        int minHeight = constraintWidgetContainer2.getMinHeight();
        constraintWidgetContainer2.setMinWidth(0);
        constraintWidgetContainer2.setMinHeight(0);
        constraintWidgetContainer2.setWidth(i);
        constraintWidgetContainer2.setHeight(i2);
        constraintWidgetContainer2.setMinWidth(minWidth);
        constraintWidgetContainer2.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        long j;
        int i10;
        boolean z;
        long j2;
        boolean z2;
        boolean z3;
        int i11;
        Measurer measurer;
        int i12;
        boolean z4;
        int i13;
        boolean z5;
        boolean z6;
        boolean z7;
        int i14;
        ConstraintWidgetContainer constraintWidgetContainer3 = constraintWidgetContainer2;
        int i15 = i;
        int i16 = i4;
        int i17 = i6;
        Measurer measurer2 = constraintWidgetContainer3.getMeasurer();
        int size = constraintWidgetContainer3.mChildren.size();
        int width = constraintWidgetContainer3.getWidth();
        int height = constraintWidgetContainer3.getHeight();
        boolean enabled = Optimizer.enabled(i15, 128);
        boolean z8 = enabled || Optimizer.enabled(i15, 64);
        if (z8) {
            int i18 = 0;
            while (true) {
                if (i18 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer3.mChildren.get(i18);
                boolean z9 = (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((!constraintWidget.isInHorizontalChain() || !z9) && ((!constraintWidget.isInVerticalChain() || !z9) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.isInHorizontalChain() && !constraintWidget.isInVerticalChain())) {
                    i18++;
                }
            }
            z8 = false;
        }
        if (z8 && LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.measures++;
        }
        int i19 = 2;
        if (z8 && ((i16 == 1073741824 && i17 == 1073741824) || enabled)) {
            int min = Math.min(constraintWidgetContainer3.getMaxWidth(), i5);
            j = 1;
            int min2 = Math.min(constraintWidgetContainer3.getMaxHeight(), i7);
            if (i16 == 1073741824 && constraintWidgetContainer3.getWidth() != min) {
                constraintWidgetContainer3.setWidth(min);
                constraintWidgetContainer3.invalidateGraph();
            }
            if (i17 == 1073741824 && constraintWidgetContainer3.getHeight() != min2) {
                constraintWidgetContainer3.setHeight(min2);
                constraintWidgetContainer3.invalidateGraph();
            }
            if (i16 == 1073741824 && i17 == 1073741824) {
                z = constraintWidgetContainer3.directMeasure(enabled);
                i10 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer3.directMeasureSetup(enabled);
                if (i16 == 1073741824) {
                    z7 = directMeasureSetup & constraintWidgetContainer3.directMeasureWithOrientation(enabled, 0);
                    i14 = 1;
                } else {
                    z7 = directMeasureSetup;
                    i14 = 0;
                }
                if (i17 == 1073741824) {
                    boolean directMeasureWithOrientation = constraintWidgetContainer3.directMeasureWithOrientation(enabled, 1) & z7;
                    i10 = i14 + 1;
                    z = directMeasureWithOrientation;
                } else {
                    i10 = i14;
                    z = z7;
                }
            }
            if (z) {
                constraintWidgetContainer3.updateFromRuns(i16 == 1073741824, i17 == 1073741824);
            }
        } else {
            j = 1;
            z = false;
            i10 = 0;
        }
        long j3 = 0;
        if (z && i10 == 2) {
            return 0;
        }
        if (size > 0) {
            measureChildren(constraintWidgetContainer2);
        }
        int optimizationLevel = constraintWidgetContainer3.getOptimizationLevel();
        int size2 = this.mVariableDimensionsWidgets.size();
        if (size > 0) {
            solveLinearSystem(constraintWidgetContainer3, "First pass", width, height);
        }
        if (size2 > 0) {
            boolean z10 = constraintWidgetContainer3.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z11 = constraintWidgetContainer3.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int max = Math.max(constraintWidgetContainer3.getWidth(), this.constraintWidgetContainer.getMinWidth());
            int max2 = Math.max(constraintWidgetContainer3.getHeight(), this.constraintWidgetContainer.getMinHeight());
            int i20 = 0;
            boolean z12 = false;
            while (i20 < size2) {
                long j4 = j3;
                ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i20);
                if (!(constraintWidget2 instanceof VirtualLayout)) {
                    z4 = z11;
                    i13 = i20;
                } else {
                    int width2 = constraintWidget2.getWidth();
                    int height2 = constraintWidget2.getHeight();
                    boolean measure = z12 | measure(measurer2, constraintWidget2, true);
                    z4 = z11;
                    if (constraintWidgetContainer3.mMetrics != null) {
                        z5 = measure;
                        i13 = i20;
                        constraintWidgetContainer3.mMetrics.measuredMatchWidgets += j;
                    } else {
                        z5 = measure;
                        i13 = i20;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z10 && constraintWidget2.getRight() > max) {
                            max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        z6 = true;
                    } else {
                        z6 = z5;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z4 && constraintWidget2.getBottom() > max2) {
                            max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        z6 = true;
                    }
                    z12 = z6 | ((VirtualLayout) constraintWidget2).needSolverPass();
                }
                i20 = i13 + 1;
                j3 = j4;
                z11 = z4;
                i19 = 2;
            }
            j2 = j3;
            boolean z13 = z11;
            int i21 = 0;
            for (int i22 = i19; i21 < i22; i22 = 2) {
                int i23 = 0;
                while (i23 < size2) {
                    ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i23);
                    if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.getVisibility() != 8 && ((!constraintWidget3.horizontalRun.dimension.resolved || !constraintWidget3.verticalRun.dimension.resolved) && !(constraintWidget3 instanceof VirtualLayout))) {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        i12 = i21;
                        z12 |= measure(measurer2, constraintWidget3, true);
                        if (constraintWidgetContainer3.mMetrics != null) {
                            measurer = measurer2;
                            i11 = i23;
                            constraintWidgetContainer3.mMetrics.measuredMatchWidgets += j;
                        } else {
                            measurer = measurer2;
                            i11 = i23;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z10 && constraintWidget3.getRight() > max) {
                                max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            z12 = true;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z13 && constraintWidget3.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            z12 = true;
                        }
                        if (constraintWidget3.hasBaseline() && baselineDistance != constraintWidget3.getBaselineDistance()) {
                            z12 = true;
                        }
                    } else {
                        i12 = i21;
                        measurer = measurer2;
                        i11 = i23;
                    }
                    i23 = i11 + 1;
                    i21 = i12;
                    measurer2 = measurer;
                }
                int i24 = i21;
                Measurer measurer3 = measurer2;
                if (z12) {
                    solveLinearSystem(constraintWidgetContainer3, "intermediate pass", width, height);
                    z12 = false;
                }
                i21 = i24 + 1;
                measurer2 = measurer3;
            }
            if (z12) {
                solveLinearSystem(constraintWidgetContainer3, "2nd pass", width, height);
                if (constraintWidgetContainer3.getWidth() < max) {
                    constraintWidgetContainer3.setWidth(max);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (constraintWidgetContainer3.getHeight() < max2) {
                    constraintWidgetContainer3.setHeight(max2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    solveLinearSystem(constraintWidgetContainer3, "3rd pass", width, height);
                }
            }
        } else {
            j2 = 0;
        }
        constraintWidgetContainer3.setOptimizationLevel(optimizationLevel);
        return j2;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.useCurrentDimensions = z;
        boolean z2 = this.mMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z5 = z3 && constraintWidget.mDimensionRatio > 0.0f;
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z5 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.useCurrentDimensions = false;
        return this.mMeasure.measuredNeedsSolverPass;
    }
}
