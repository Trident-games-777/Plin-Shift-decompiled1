package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets = new ArrayList<>();

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.orientation = i;
        build();
    }

    public String toString() {
        String concat = "ChainRun ".concat(this.orientation == 0 ? "horizontal : " : "vertical : ");
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            concat = ((concat + "<") + it.next()) + "> ";
        }
        return concat;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public long getWrapDimension() {
        int size = this.widgets.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            j = j + ((long) widgetRun.start.margin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.margin);
        }
        return j;
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            }
            previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            if (this.orientation == 0) {
                next.widget.horizontalChainRun = this;
            } else if (this.orientation == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl() && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d3, code lost:
        if (r10.dimension.resolved != false) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency r26) {
        /*
            r25 = this;
            r0 = r25
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x043e
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.end
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x0010
            goto L_0x043e
        L_0x0010:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.widget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.getParent()
            if (r1 == 0) goto L_0x0023
            boolean r3 = r1 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r3 == 0) goto L_0x0023
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r1
            boolean r1 = r1.isRtl()
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r0.end
            int r3 = r3.value
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r4 = r0.start
            int r4 = r4.value
            int r3 = r3 - r4
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r4 = r0.widgets
            int r4 = r4.size()
            r5 = 0
        L_0x0034:
            r6 = -1
            r7 = 8
            if (r5 >= r4) goto L_0x004c
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r8 = r0.widgets
            java.lang.Object r8 = r8.get(r5)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r8 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r8.widget
            int r8 = r8.getVisibility()
            if (r8 != r7) goto L_0x004d
            int r5 = r5 + 1
            goto L_0x0034
        L_0x004c:
            r5 = r6
        L_0x004d:
            int r8 = r4 + -1
            r9 = r8
        L_0x0050:
            if (r9 < 0) goto L_0x0066
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r10 = r0.widgets
            java.lang.Object r10 = r10.get(r9)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r10.widget
            int r10 = r10.getVisibility()
            if (r10 != r7) goto L_0x0065
            int r9 = r9 + -1
            goto L_0x0050
        L_0x0065:
            r6 = r9
        L_0x0066:
            r9 = 0
        L_0x0067:
            r11 = 2
            r12 = 1
            if (r9 >= r11) goto L_0x010b
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0072:
            if (r13 >= r4) goto L_0x00fb
            r26 = 0
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r10 = r0.widgets
            java.lang.Object r10 = r10.get(r13)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r10.widget
            int r2 = r2.getVisibility()
            if (r2 != r7) goto L_0x0088
            goto L_0x00f4
        L_0x0088:
            int r16 = r16 + 1
            if (r13 <= 0) goto L_0x0093
            if (r13 < r5) goto L_0x0093
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r10.start
            int r2 = r2.margin
            int r14 = r14 + r2
        L_0x0093:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r2 = r10.dimension
            int r2 = r2.value
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r10.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 == r7) goto L_0x009f
            r7 = r12
            goto L_0x00a0
        L_0x009f:
            r7 = 0
        L_0x00a0:
            if (r7 == 0) goto L_0x00c2
            int r11 = r0.orientation
            if (r11 != 0) goto L_0x00b2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r10.widget
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r11 = r11.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r11 = r11.dimension
            boolean r11 = r11.resolved
            if (r11 != 0) goto L_0x00b2
            goto L_0x043e
        L_0x00b2:
            int r11 = r0.orientation
            if (r11 != r12) goto L_0x00d6
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r10.widget
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r11 = r11.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r11 = r11.dimension
            boolean r11 = r11.resolved
            if (r11 != 0) goto L_0x00d6
            goto L_0x043e
        L_0x00c2:
            int r11 = r10.matchConstraintsType
            if (r11 != r12) goto L_0x00cf
            if (r9 != 0) goto L_0x00cf
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r2 = r10.dimension
            int r2 = r2.wrapValue
            int r15 = r15 + 1
            goto L_0x00d5
        L_0x00cf:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r11 = r10.dimension
            boolean r11 = r11.resolved
            if (r11 == 0) goto L_0x00d6
        L_0x00d5:
            r7 = r12
        L_0x00d6:
            if (r7 != 0) goto L_0x00e9
            int r15 = r15 + 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r10.widget
            float[] r2 = r2.mWeight
            int r7 = r0.orientation
            r2 = r2[r7]
            int r7 = (r2 > r26 ? 1 : (r2 == r26 ? 0 : -1))
            if (r7 < 0) goto L_0x00ea
            float r17 = r17 + r2
            goto L_0x00ea
        L_0x00e9:
            int r14 = r14 + r2
        L_0x00ea:
            if (r13 >= r8) goto L_0x00f4
            if (r13 >= r6) goto L_0x00f4
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r10.end
            int r2 = r2.margin
            int r2 = -r2
            int r14 = r14 + r2
        L_0x00f4:
            int r13 = r13 + 1
            r7 = 8
            r11 = 2
            goto L_0x0072
        L_0x00fb:
            r26 = 0
            if (r14 < r3) goto L_0x0108
            if (r15 != 0) goto L_0x0102
            goto L_0x0108
        L_0x0102:
            int r9 = r9 + 1
            r7 = 8
            goto L_0x0067
        L_0x0108:
            r2 = r16
            goto L_0x0112
        L_0x010b:
            r26 = 0
            r17 = r26
            r2 = 0
            r14 = 0
            r15 = 0
        L_0x0112:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r0.start
            int r7 = r7.value
            if (r1 == 0) goto L_0x011c
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r0.end
            int r7 = r7.value
        L_0x011c:
            r9 = 1056964608(0x3f000000, float:0.5)
            if (r14 <= r3) goto L_0x0133
            r10 = 1073741824(0x40000000, float:2.0)
            if (r1 == 0) goto L_0x012c
            int r11 = r14 - r3
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 + r10
            goto L_0x0133
        L_0x012c:
            int r11 = r14 - r3
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 - r10
        L_0x0133:
            if (r15 <= 0) goto L_0x023c
            int r10 = r3 - r14
            float r10 = (float) r10
            float r11 = (float) r15
            float r11 = r10 / r11
            float r11 = r11 + r9
            int r11 = (int) r11
            r13 = 0
            r16 = 0
        L_0x0140:
            if (r13 >= r4) goto L_0x01f2
            r19 = r9
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r9 = r0.widgets
            java.lang.Object r9 = r9.get(r13)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r9
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r9.widget
            int r12 = r12.getVisibility()
            r21 = r1
            r1 = 8
            if (r12 != r1) goto L_0x015a
            goto L_0x01dd
        L_0x015a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r9.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r12) goto L_0x01dd
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r1 = r9.dimension
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x01dd
            int r1 = (r17 > r26 ? 1 : (r17 == r26 ? 0 : -1))
            if (r1 <= 0) goto L_0x0179
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r9.widget
            float[] r1 = r1.mWeight
            int r12 = r0.orientation
            r1 = r1[r12]
            float r1 = r1 * r10
            float r1 = r1 / r17
            float r1 = r1 + r19
            int r1 = (int) r1
            goto L_0x017a
        L_0x0179:
            r1 = r11
        L_0x017a:
            int r12 = r0.orientation
            if (r12 != 0) goto L_0x01ab
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r9.widget
            int r12 = r12.mMatchConstraintMaxWidth
            r22 = r7
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r9.widget
            int r7 = r7.mMatchConstraintMinWidth
            r23 = r10
            int r10 = r9.matchConstraintsType
            r24 = r11
            r11 = 1
            if (r10 != r11) goto L_0x019a
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r10 = r9.dimension
            int r10 = r10.wrapValue
            int r10 = java.lang.Math.min(r1, r10)
            goto L_0x019b
        L_0x019a:
            r10 = r1
        L_0x019b:
            int r7 = java.lang.Math.max(r7, r10)
            if (r12 <= 0) goto L_0x01a5
            int r7 = java.lang.Math.min(r12, r7)
        L_0x01a5:
            if (r7 == r1) goto L_0x01d7
            int r16 = r16 + 1
            r1 = r7
            goto L_0x01d7
        L_0x01ab:
            r22 = r7
            r23 = r10
            r24 = r11
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r9.widget
            int r7 = r7.mMatchConstraintMaxHeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r9.widget
            int r10 = r10.mMatchConstraintMinHeight
            int r11 = r9.matchConstraintsType
            r12 = 1
            if (r11 != r12) goto L_0x01c7
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r11 = r9.dimension
            int r11 = r11.wrapValue
            int r11 = java.lang.Math.min(r1, r11)
            goto L_0x01c8
        L_0x01c7:
            r11 = r1
        L_0x01c8:
            int r10 = java.lang.Math.max(r10, r11)
            if (r7 <= 0) goto L_0x01d2
            int r10 = java.lang.Math.min(r7, r10)
        L_0x01d2:
            if (r10 == r1) goto L_0x01d7
            int r16 = r16 + 1
            r1 = r10
        L_0x01d7:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r7 = r9.dimension
            r7.resolve(r1)
            goto L_0x01e3
        L_0x01dd:
            r22 = r7
            r23 = r10
            r24 = r11
        L_0x01e3:
            int r13 = r13 + 1
            r9 = r19
            r1 = r21
            r7 = r22
            r10 = r23
            r11 = r24
            r12 = 1
            goto L_0x0140
        L_0x01f2:
            r21 = r1
            r22 = r7
            r19 = r9
            if (r16 <= 0) goto L_0x022f
            int r15 = r15 - r16
            r1 = 0
            r7 = 0
        L_0x01fe:
            if (r1 >= r4) goto L_0x022e
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r9 = r0.widgets
            java.lang.Object r9 = r9.get(r1)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r9
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r9.widget
            int r10 = r10.getVisibility()
            r11 = 8
            if (r10 != r11) goto L_0x0213
            goto L_0x022b
        L_0x0213:
            if (r1 <= 0) goto L_0x021c
            if (r1 < r5) goto L_0x021c
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.start
            int r10 = r10.margin
            int r7 = r7 + r10
        L_0x021c:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r10 = r9.dimension
            int r10 = r10.value
            int r7 = r7 + r10
            if (r1 >= r8) goto L_0x022b
            if (r1 >= r6) goto L_0x022b
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r9.end
            int r9 = r9.margin
            int r9 = -r9
            int r7 = r7 + r9
        L_0x022b:
            int r1 = r1 + 1
            goto L_0x01fe
        L_0x022e:
            r14 = r7
        L_0x022f:
            int r1 = r0.chainStyle
            r7 = 2
            if (r1 != r7) goto L_0x023a
            if (r16 != 0) goto L_0x023a
            r1 = 0
            r0.chainStyle = r1
            goto L_0x0244
        L_0x023a:
            r1 = 0
            goto L_0x0244
        L_0x023c:
            r21 = r1
            r22 = r7
            r19 = r9
            r1 = 0
            r7 = 2
        L_0x0244:
            if (r14 <= r3) goto L_0x0248
            r0.chainStyle = r7
        L_0x0248:
            if (r2 <= 0) goto L_0x0250
            if (r15 != 0) goto L_0x0250
            if (r5 != r6) goto L_0x0250
            r0.chainStyle = r7
        L_0x0250:
            int r7 = r0.chainStyle
            r11 = 1
            if (r7 != r11) goto L_0x02f5
            if (r2 <= r11) goto L_0x025b
            int r3 = r3 - r14
            int r2 = r2 - r11
            int r3 = r3 / r2
            goto L_0x0264
        L_0x025b:
            if (r2 != r11) goto L_0x0263
            int r3 = r3 - r14
            r18 = 2
            int r3 = r3 / 2
            goto L_0x0264
        L_0x0263:
            r3 = r1
        L_0x0264:
            if (r15 <= 0) goto L_0x0267
            r3 = r1
        L_0x0267:
            r2 = r1
            r7 = r22
        L_0x026a:
            if (r2 >= r4) goto L_0x043e
            if (r21 == 0) goto L_0x0273
            int r1 = r2 + 1
            int r1 = r4 - r1
            goto L_0x0274
        L_0x0273:
            r1 = r2
        L_0x0274:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r9 = r0.widgets
            java.lang.Object r1 = r9.get(r1)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r1.widget
            int r9 = r9.getVisibility()
            r11 = 8
            if (r9 != r11) goto L_0x0291
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            r1.resolve(r7)
            goto L_0x02f1
        L_0x0291:
            if (r2 <= 0) goto L_0x0298
            if (r21 == 0) goto L_0x0297
            int r7 = r7 - r3
            goto L_0x0298
        L_0x0297:
            int r7 = r7 + r3
        L_0x0298:
            if (r2 <= 0) goto L_0x02a9
            if (r2 < r5) goto L_0x02a9
            if (r21 == 0) goto L_0x02a4
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            int r9 = r9.margin
            int r7 = r7 - r9
            goto L_0x02a9
        L_0x02a4:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            int r9 = r9.margin
            int r7 = r7 + r9
        L_0x02a9:
            if (r21 == 0) goto L_0x02b1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.end
            r9.resolve(r7)
            goto L_0x02b6
        L_0x02b1:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
        L_0x02b6:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r9 = r1.dimension
            int r9 = r9.value
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = r1.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r11) goto L_0x02c9
            int r10 = r1.matchConstraintsType
            r11 = 1
            if (r10 != r11) goto L_0x02c9
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r9 = r1.dimension
            int r9 = r9.wrapValue
        L_0x02c9:
            if (r21 == 0) goto L_0x02cd
            int r7 = r7 - r9
            goto L_0x02ce
        L_0x02cd:
            int r7 = r7 + r9
        L_0x02ce:
            if (r21 == 0) goto L_0x02d6
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
            goto L_0x02db
        L_0x02d6:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.end
            r9.resolve(r7)
        L_0x02db:
            r11 = 1
            r1.resolved = r11
            if (r2 >= r8) goto L_0x02f1
            if (r2 >= r6) goto L_0x02f1
            if (r21 == 0) goto L_0x02eb
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 - r1
            goto L_0x02f1
        L_0x02eb:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 + r1
        L_0x02f1:
            int r2 = r2 + 1
            goto L_0x026a
        L_0x02f5:
            if (r7 != 0) goto L_0x038d
            int r3 = r3 - r14
            r20 = 1
            int r2 = r2 + 1
            int r3 = r3 / r2
            if (r15 <= 0) goto L_0x0300
            r3 = r1
        L_0x0300:
            r2 = r1
            r7 = r22
        L_0x0303:
            if (r2 >= r4) goto L_0x043e
            if (r21 == 0) goto L_0x030c
            int r1 = r2 + 1
            int r1 = r4 - r1
            goto L_0x030d
        L_0x030c:
            r1 = r2
        L_0x030d:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r9 = r0.widgets
            java.lang.Object r1 = r9.get(r1)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r1.widget
            int r9 = r9.getVisibility()
            r11 = 8
            if (r9 != r11) goto L_0x032a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            r1.resolve(r7)
            goto L_0x0389
        L_0x032a:
            if (r21 == 0) goto L_0x032e
            int r7 = r7 - r3
            goto L_0x032f
        L_0x032e:
            int r7 = r7 + r3
        L_0x032f:
            if (r2 <= 0) goto L_0x0340
            if (r2 < r5) goto L_0x0340
            if (r21 == 0) goto L_0x033b
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            int r9 = r9.margin
            int r7 = r7 - r9
            goto L_0x0340
        L_0x033b:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            int r9 = r9.margin
            int r7 = r7 + r9
        L_0x0340:
            if (r21 == 0) goto L_0x0348
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.end
            r9.resolve(r7)
            goto L_0x034d
        L_0x0348:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
        L_0x034d:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r9 = r1.dimension
            int r9 = r9.value
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = r1.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r11) goto L_0x0364
            int r10 = r1.matchConstraintsType
            r11 = 1
            if (r10 != r11) goto L_0x0364
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r10 = r1.dimension
            int r10 = r10.wrapValue
            int r9 = java.lang.Math.min(r9, r10)
        L_0x0364:
            if (r21 == 0) goto L_0x0368
            int r7 = r7 - r9
            goto L_0x0369
        L_0x0368:
            int r7 = r7 + r9
        L_0x0369:
            if (r21 == 0) goto L_0x0371
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
            goto L_0x0376
        L_0x0371:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.end
            r9.resolve(r7)
        L_0x0376:
            if (r2 >= r8) goto L_0x0389
            if (r2 >= r6) goto L_0x0389
            if (r21 == 0) goto L_0x0383
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 - r1
            goto L_0x0389
        L_0x0383:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 + r1
        L_0x0389:
            int r2 = r2 + 1
            goto L_0x0303
        L_0x038d:
            r2 = 2
            if (r7 != r2) goto L_0x043e
            int r2 = r0.orientation
            if (r2 != 0) goto L_0x039b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.widget
            float r2 = r2.getHorizontalBiasPercent()
            goto L_0x03a1
        L_0x039b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.widget
            float r2 = r2.getVerticalBiasPercent()
        L_0x03a1:
            if (r21 == 0) goto L_0x03a7
            r7 = 1065353216(0x3f800000, float:1.0)
            float r2 = r7 - r2
        L_0x03a7:
            int r3 = r3 - r14
            float r3 = (float) r3
            float r3 = r3 * r2
            float r3 = r3 + r19
            int r2 = (int) r3
            if (r2 < 0) goto L_0x03b1
            if (r15 <= 0) goto L_0x03b2
        L_0x03b1:
            r2 = r1
        L_0x03b2:
            if (r21 == 0) goto L_0x03b7
            int r7 = r22 - r2
            goto L_0x03b9
        L_0x03b7:
            int r7 = r22 + r2
        L_0x03b9:
            r2 = r1
        L_0x03ba:
            if (r2 >= r4) goto L_0x043e
            if (r21 == 0) goto L_0x03c3
            int r1 = r2 + 1
            int r1 = r4 - r1
            goto L_0x03c4
        L_0x03c3:
            r1 = r2
        L_0x03c4:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r3 = r0.widgets
            java.lang.Object r1 = r3.get(r1)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r1.widget
            int r3 = r3.getVisibility()
            r11 = 8
            if (r3 != r11) goto L_0x03e2
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            r3.resolve(r7)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            r1.resolve(r7)
            r12 = 1
            goto L_0x043a
        L_0x03e2:
            if (r2 <= 0) goto L_0x03f3
            if (r2 < r5) goto L_0x03f3
            if (r21 == 0) goto L_0x03ee
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            int r3 = r3.margin
            int r7 = r7 - r3
            goto L_0x03f3
        L_0x03ee:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            int r3 = r3.margin
            int r7 = r7 + r3
        L_0x03f3:
            if (r21 == 0) goto L_0x03fb
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.end
            r3.resolve(r7)
            goto L_0x0400
        L_0x03fb:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            r3.resolve(r7)
        L_0x0400:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r3 = r1.dimension
            int r3 = r3.value
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r1.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 != r10) goto L_0x0414
            int r9 = r1.matchConstraintsType
            r12 = 1
            if (r9 != r12) goto L_0x0415
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r3 = r1.dimension
            int r3 = r3.wrapValue
            goto L_0x0415
        L_0x0414:
            r12 = 1
        L_0x0415:
            if (r21 == 0) goto L_0x0419
            int r7 = r7 - r3
            goto L_0x041a
        L_0x0419:
            int r7 = r7 + r3
        L_0x041a:
            if (r21 == 0) goto L_0x0422
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            r3.resolve(r7)
            goto L_0x0427
        L_0x0422:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.end
            r3.resolve(r7)
        L_0x0427:
            if (r2 >= r8) goto L_0x043a
            if (r2 >= r6) goto L_0x043a
            if (r21 == 0) goto L_0x0434
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 - r1
            goto L_0x043a
        L_0x0434:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 + r1
        L_0x043a:
            int r2 = r2 + 1
            goto L_0x03ba
        L_0x043e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.ChainRun.update(androidx.constraintlayout.solver.widgets.analyzer.Dependency):void");
    }

    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = this.widgets.get(0).widget;
            ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
            if (this.orientation == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    margin = firstVisibleWidget.mLeft.getMargin();
                }
                if (target != null) {
                    addTarget(this.start, target, margin);
                }
                DependencyNode target2 = getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    margin2 = lastVisibleWidget.mRight.getMargin();
                }
                if (target2 != null) {
                    addTarget(this.end, target2, -margin2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    margin3 = firstVisibleWidget2.mTop.getMargin();
                }
                if (target3 != null) {
                    addTarget(this.start, target3, margin3);
                }
                DependencyNode target4 = getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    margin4 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (target4 != null) {
                    addTarget(this.end, target4, -margin4);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }
}
