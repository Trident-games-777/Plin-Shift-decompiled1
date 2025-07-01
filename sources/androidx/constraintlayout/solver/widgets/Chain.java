package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = 0;
        } else {
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = 2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v84, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX WARNING: type inference failed for: r5v13, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r3.mHorizontalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r3.mVerticalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r6 = false;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x04ac  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04e7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x050b  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0521  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x052b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:320:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r35, androidx.constraintlayout.solver.LinearSystem r36, int r37, int r38, androidx.constraintlayout.solver.widgets.ChainHead r39) {
        /*
            r0 = r35
            r1 = r36
            r2 = r39
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r2.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r2.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r2.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r2.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r2.mHead
            float r4 = r2.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r2.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r2.mLastMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r0.mListDimensionBehaviors
            r5 = r5[r37]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 1
            if (r5 != r6) goto L_0x0021
            r5 = r7
            goto L_0x0022
        L_0x0021:
            r5 = 0
        L_0x0022:
            r6 = 2
            if (r37 != 0) goto L_0x0038
            int r13 = r3.mHorizontalChainStyle
            if (r13 != 0) goto L_0x002b
            r13 = r7
            goto L_0x002c
        L_0x002b:
            r13 = 0
        L_0x002c:
            int r14 = r3.mHorizontalChainStyle
            if (r14 != r7) goto L_0x0032
            r14 = r7
            goto L_0x0033
        L_0x0032:
            r14 = 0
        L_0x0033:
            int r15 = r3.mHorizontalChainStyle
            if (r15 != r6) goto L_0x004c
            goto L_0x004a
        L_0x0038:
            int r13 = r3.mVerticalChainStyle
            if (r13 != 0) goto L_0x003e
            r13 = r7
            goto L_0x003f
        L_0x003e:
            r13 = 0
        L_0x003f:
            int r14 = r3.mVerticalChainStyle
            if (r14 != r7) goto L_0x0045
            r14 = r7
            goto L_0x0046
        L_0x0045:
            r14 = 0
        L_0x0046:
            int r15 = r3.mVerticalChainStyle
            if (r15 != r6) goto L_0x004c
        L_0x004a:
            r6 = r7
            goto L_0x004d
        L_0x004c:
            r6 = 0
        L_0x004d:
            r7 = r9
            r15 = 0
        L_0x004f:
            r18 = r4
            r21 = 0
            if (r15 != 0) goto L_0x0134
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r7.mListAnchors
            r4 = r4[r38]
            if (r6 == 0) goto L_0x005e
            r19 = 1
            goto L_0x0060
        L_0x005e:
            r19 = 4
        L_0x0060:
            int r22 = r4.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r7.mListDimensionBehaviors
            r8 = r8[r37]
            r23 = r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r5) goto L_0x0076
            int[] r5 = r7.mResolvedMatchConstraintDefault
            r5 = r5[r37]
            if (r5 != 0) goto L_0x0076
            r5 = 1
            goto L_0x0077
        L_0x0076:
            r5 = 0
        L_0x0077:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r4.mTarget
            if (r8 == 0) goto L_0x0085
            if (r7 == r9) goto L_0x0085
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r4.mTarget
            int r8 = r8.getMargin()
            int r22 = r22 + r8
        L_0x0085:
            r8 = r22
            if (r6 == 0) goto L_0x008f
            if (r7 == r9) goto L_0x008f
            if (r7 == r11) goto L_0x008f
            r19 = 5
        L_0x008f:
            r22 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            if (r5 == 0) goto L_0x00c7
            if (r7 != r11) goto L_0x00a6
            androidx.constraintlayout.solver.SolverVariable r5 = r4.mSolverVariable
            r24 = r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r25 = r13
            r13 = 6
            r1.addGreaterThan(r5, r6, r8, r13)
            goto L_0x00b5
        L_0x00a6:
            r24 = r6
            r25 = r13
            androidx.constraintlayout.solver.SolverVariable r5 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r13 = 8
            r1.addGreaterThan(r5, r6, r8, r13)
        L_0x00b5:
            if (r22 == 0) goto L_0x00bb
            if (r24 != 0) goto L_0x00bb
            r5 = 5
            goto L_0x00bd
        L_0x00bb:
            r5 = r19
        L_0x00bd:
            androidx.constraintlayout.solver.SolverVariable r6 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r1.addEquality(r6, r4, r8, r5)
            goto L_0x00cb
        L_0x00c7:
            r24 = r6
            r25 = r13
        L_0x00cb:
            if (r23 == 0) goto L_0x0103
            int r4 = r7.getVisibility()
            r13 = 8
            if (r4 == r13) goto L_0x00f1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r7.mListDimensionBehaviors
            r4 = r4[r37]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x00f1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r7.mListAnchors
            int r5 = r38 + 1
            r4 = r4[r5]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r38]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            r6 = 5
            r8 = 0
            r1.addGreaterThan(r4, r5, r8, r6)
            goto L_0x00f2
        L_0x00f1:
            r8 = 0
        L_0x00f2:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r7.mListAnchors
            r4 = r4[r38]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r0.mListAnchors
            r5 = r5[r38]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            r13 = 8
            r1.addGreaterThan(r4, r5, r8, r13)
        L_0x0103:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r7.mListAnchors
            int r5 = r38 + 1
            r4 = r4[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0124
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r4.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r4.mListAnchors
            r5 = r5[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0124
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r4.mListAnchors
            r5 = r5[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r5.mOwner
            if (r5 == r7) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r21 = r4
        L_0x0124:
            if (r21 == 0) goto L_0x0129
            r7 = r21
            goto L_0x012a
        L_0x0129:
            r15 = 1
        L_0x012a:
            r4 = r18
            r5 = r23
            r6 = r24
            r13 = r25
            goto L_0x004f
        L_0x0134:
            r23 = r5
            r24 = r6
            r25 = r13
            if (r12 == 0) goto L_0x019c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r10.mListAnchors
            int r5 = r38 + 1
            r4 = r4[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x019c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r4 = r4[r5]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r12.mListDimensionBehaviors
            r6 = r6[r37]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x0170
            int[] r6 = r12.mResolvedMatchConstraintDefault
            r6 = r6[r37]
            if (r6 != 0) goto L_0x0170
            if (r24 != 0) goto L_0x0170
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r4.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 != r0) goto L_0x0170
            androidx.constraintlayout.solver.SolverVariable r6 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            int r8 = r4.getMargin()
            int r8 = -r8
            r13 = 5
            r1.addEquality(r6, r7, r8, r13)
            goto L_0x0188
        L_0x0170:
            r13 = 5
            if (r24 == 0) goto L_0x0188
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r4.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 != r0) goto L_0x0188
            androidx.constraintlayout.solver.SolverVariable r6 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            int r8 = r4.getMargin()
            int r8 = -r8
            r15 = 4
            r1.addEquality(r6, r7, r8, r15)
        L_0x0188:
            androidx.constraintlayout.solver.SolverVariable r6 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r10.mListAnchors
            r5 = r7[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            int r4 = r4.getMargin()
            int r4 = -r4
            r7 = 6
            r1.addLowerThan(r6, r5, r4, r7)
            goto L_0x019d
        L_0x019c:
            r13 = 5
        L_0x019d:
            if (r23 == 0) goto L_0x01ba
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r4 = r38 + 1
            r0 = r0[r4]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r10.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r10.mListAnchors
            r4 = r6[r4]
            int r4 = r4.getMargin()
            r6 = 8
            r1.addGreaterThan(r0, r5, r4, r6)
        L_0x01ba:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r2.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x026f
            int r4 = r0.size()
            r5 = 1
            if (r4 <= r5) goto L_0x026f
            boolean r6 = r2.mHasUndefinedWeights
            if (r6 == 0) goto L_0x01d3
            boolean r6 = r2.mHasComplexMatchWeights
            if (r6 != 0) goto L_0x01d3
            int r6 = r2.mWidgetsMatchCount
            float r6 = (float) r6
            r28 = r6
            goto L_0x01d5
        L_0x01d3:
            r28 = r18
        L_0x01d5:
            r6 = 0
            r27 = r6
            r7 = r21
            r8 = 0
        L_0x01db:
            if (r8 >= r4) goto L_0x026f
            java.lang.Object r15 = r0.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            float[] r5 = r15.mWeight
            r5 = r5[r37]
            int r18 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r18 >= 0) goto L_0x020c
            boolean r5 = r2.mHasComplexMatchWeights
            if (r5 == 0) goto L_0x0206
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r15.mListAnchors
            int r18 = r38 + 1
            r5 = r5[r18]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r15 = r15.mListAnchors
            r15 = r15[r38]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r35 = r6
            r6 = 4
            r13 = 0
            r1.addEquality(r5, r15, r13, r6)
            r6 = r13
            goto L_0x0229
        L_0x0206:
            r35 = r6
            r6 = 4
            r5 = 1065353216(0x3f800000, float:1.0)
            goto L_0x020f
        L_0x020c:
            r35 = r6
            r6 = 4
        L_0x020f:
            r29 = r5
            int r5 = (r29 > r35 ? 1 : (r29 == r35 ? 0 : -1))
            if (r5 != 0) goto L_0x022c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r15.mListAnchors
            int r13 = r38 + 1
            r5 = r5[r13]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r15.mListAnchors
            r13 = r13[r38]
            androidx.constraintlayout.solver.SolverVariable r13 = r13.mSolverVariable
            r6 = 0
            r15 = 8
            r1.addEquality(r5, r13, r6, r15)
        L_0x0229:
            r18 = r0
            goto L_0x0265
        L_0x022c:
            r6 = 0
            if (r7 == 0) goto L_0x0260
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r38]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r7.mListAnchors
            int r13 = r38 + 1
            r7 = r7[r13]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r15.mListAnchors
            r6 = r6[r38]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r18 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r15.mListAnchors
            r0 = r0[r13]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.ArrayRow r26 = r1.createRow()
            r33 = r0
            r30 = r5
            r32 = r6
            r31 = r7
            r26.createRowEqualMatchDimensions(r27, r28, r29, r30, r31, r32, r33)
            r0 = r26
            r1.addConstraint(r0)
            goto L_0x0262
        L_0x0260:
            r18 = r0
        L_0x0262:
            r7 = r15
            r27 = r29
        L_0x0265:
            int r8 = r8 + 1
            r6 = r35
            r0 = r18
            r5 = 1
            r13 = 5
            goto L_0x01db
        L_0x026f:
            if (r11 == 0) goto L_0x02c7
            if (r11 == r12) goto L_0x0275
            if (r24 == 0) goto L_0x02c7
        L_0x0275:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r9.mListAnchors
            r0 = r0[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            int r4 = r38 + 1
            r2 = r2[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r0.mTarget
            if (r5 == 0) goto L_0x0288
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            goto L_0x028a
        L_0x0288:
            r0 = r21
        L_0x028a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r2.mTarget
            if (r5 == 0) goto L_0x0294
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            r5 = r2
            goto L_0x0296
        L_0x0294:
            r5 = r21
        L_0x0296:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r12.mListAnchors
            r4 = r6[r4]
            if (r0 == 0) goto L_0x04e3
            if (r5 == 0) goto L_0x04e3
            if (r37 != 0) goto L_0x02a7
            float r3 = r3.mHorizontalBiasPercent
            goto L_0x02a9
        L_0x02a7:
            float r3 = r3.mVerticalBiasPercent
        L_0x02a9:
            int r6 = r2.getMargin()
            int r7 = r4.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r8 = 7
            r34 = r2
            r2 = r0
            r0 = r1
            r1 = r34
            r34 = r4
            r4 = r3
            r3 = r6
            r6 = r34
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04e3
        L_0x02c7:
            if (r25 == 0) goto L_0x03c5
            if (r11 == 0) goto L_0x03c5
            int r0 = r2.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x02d8
            int r0 = r2.mWidgetsCount
            int r1 = r2.mWidgetsMatchCount
            if (r0 != r1) goto L_0x02d8
            r16 = 1
            goto L_0x02da
        L_0x02d8:
            r16 = 0
        L_0x02da:
            r13 = r11
            r15 = r13
        L_0x02dc:
            if (r13 == 0) goto L_0x04e3
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r13.mNextChainWidget
            r0 = r0[r37]
        L_0x02e2:
            if (r0 == 0) goto L_0x02f1
            int r1 = r0.getVisibility()
            r6 = 8
            if (r1 != r6) goto L_0x02f3
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r37]
            goto L_0x02e2
        L_0x02f1:
            r6 = 8
        L_0x02f3:
            if (r0 != 0) goto L_0x0301
            if (r13 != r12) goto L_0x02f8
            goto L_0x0301
        L_0x02f8:
            r17 = r0
            r35 = r13
            r20 = 5
            r13 = r6
            goto L_0x03b9
        L_0x0301:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r38]
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x0310
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0312
        L_0x0310:
            r3 = r21
        L_0x0312:
            if (r15 == r13) goto L_0x031d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r4 = r38 + 1
            r3 = r3[r4]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0334
        L_0x031d:
            if (r13 != r11) goto L_0x0334
            if (r15 != r13) goto L_0x0334
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r9.mListAnchors
            r3 = r3[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0332
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r9.mListAnchors
            r3 = r3[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0334
        L_0x0332:
            r3 = r21
        L_0x0334:
            int r1 = r1.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            int r5 = r38 + 1
            r4 = r4[r5]
            int r4 = r4.getMargin()
            if (r0 == 0) goto L_0x0351
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r0.mListAnchors
            r7 = r7[r38]
            androidx.constraintlayout.solver.SolverVariable r8 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r13.mListAnchors
            r6 = r6[r5]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            goto L_0x0365
        L_0x0351:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r10.mListAnchors
            r6 = r6[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r6.mTarget
            if (r7 == 0) goto L_0x035d
            androidx.constraintlayout.solver.SolverVariable r6 = r7.mSolverVariable
            r8 = r6
            goto L_0x035f
        L_0x035d:
            r8 = r21
        L_0x035f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r13.mListAnchors
            r6 = r6[r5]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
        L_0x0365:
            if (r7 == 0) goto L_0x036c
            int r7 = r7.getMargin()
            int r4 = r4 + r7
        L_0x036c:
            if (r15 == 0) goto L_0x0377
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r15.mListAnchors
            r7 = r7[r5]
            int r7 = r7.getMargin()
            int r1 = r1 + r7
        L_0x0377:
            if (r2 == 0) goto L_0x03b1
            if (r3 == 0) goto L_0x03b1
            if (r8 == 0) goto L_0x03b1
            if (r6 == 0) goto L_0x03b1
            if (r13 != r11) goto L_0x0389
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            r1 = r1[r38]
            int r1 = r1.getMargin()
        L_0x0389:
            if (r13 != r12) goto L_0x0393
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r4 = r4[r5]
            int r4 = r4.getMargin()
        L_0x0393:
            r7 = r4
            r5 = r8
            if (r16 == 0) goto L_0x039a
            r8 = 8
            goto L_0x039b
        L_0x039a:
            r8 = 5
        L_0x039b:
            r4 = 1056964608(0x3f000000, float:0.5)
            r35 = r3
            r3 = r1
            r1 = r2
            r2 = r35
            r17 = r0
            r35 = r13
            r13 = 8
            r20 = 5
            r0 = r36
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x03b9
        L_0x03b1:
            r17 = r0
            r35 = r13
            r13 = 8
            r20 = 5
        L_0x03b9:
            int r0 = r35.getVisibility()
            if (r0 == r13) goto L_0x03c1
            r15 = r35
        L_0x03c1:
            r13 = r17
            goto L_0x02dc
        L_0x03c5:
            r13 = 8
            if (r14 == 0) goto L_0x04e3
            if (r11 == 0) goto L_0x04e3
            int r0 = r2.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x03d8
            int r0 = r2.mWidgetsCount
            int r1 = r2.mWidgetsMatchCount
            if (r0 != r1) goto L_0x03d8
            r16 = 1
            goto L_0x03da
        L_0x03d8:
            r16 = 0
        L_0x03da:
            r0 = r11
            r15 = r0
        L_0x03dc:
            if (r15 == 0) goto L_0x0491
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r15.mNextChainWidget
            r1 = r1[r37]
        L_0x03e2:
            if (r1 == 0) goto L_0x03ef
            int r2 = r1.getVisibility()
            if (r2 != r13) goto L_0x03ef
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r1.mNextChainWidget
            r1 = r1[r37]
            goto L_0x03e2
        L_0x03ef:
            if (r15 == r11) goto L_0x047e
            if (r15 == r12) goto L_0x047e
            if (r1 == 0) goto L_0x047e
            if (r1 != r12) goto L_0x03f9
            r1 = r21
        L_0x03f9:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            r2 = r2[r38]
            androidx.constraintlayout.solver.SolverVariable r3 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r2.mTarget
            if (r4 == 0) goto L_0x0407
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
        L_0x0407:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r0.mListAnchors
            int r5 = r38 + 1
            r4 = r4[r5]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            int r2 = r2.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r15.mListAnchors
            r6 = r6[r5]
            int r6 = r6.getMargin()
            if (r1 == 0) goto L_0x042f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r1.mListAnchors
            r7 = r7[r38]
            androidx.constraintlayout.solver.SolverVariable r8 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r13 = r7.mTarget
            if (r13 == 0) goto L_0x042c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r13 = r7.mTarget
            androidx.constraintlayout.solver.SolverVariable r13 = r13.mSolverVariable
            goto L_0x0440
        L_0x042c:
            r13 = r21
            goto L_0x0440
        L_0x042f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r12.mListAnchors
            r7 = r7[r38]
            if (r7 == 0) goto L_0x0438
            androidx.constraintlayout.solver.SolverVariable r8 = r7.mSolverVariable
            goto L_0x043a
        L_0x0438:
            r8 = r21
        L_0x043a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r15.mListAnchors
            r13 = r13[r5]
            androidx.constraintlayout.solver.SolverVariable r13 = r13.mSolverVariable
        L_0x0440:
            if (r7 == 0) goto L_0x0447
            int r7 = r7.getMargin()
            int r6 = r6 + r7
        L_0x0447:
            r7 = r6
            if (r0 == 0) goto L_0x0453
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r0.mListAnchors
            r5 = r6[r5]
            int r5 = r5.getMargin()
            int r2 = r2 + r5
        L_0x0453:
            r5 = r8
            if (r16 == 0) goto L_0x0459
            r8 = 8
            goto L_0x045a
        L_0x0459:
            r8 = 4
        L_0x045a:
            if (r3 == 0) goto L_0x0474
            if (r4 == 0) goto L_0x0474
            if (r5 == 0) goto L_0x0474
            if (r13 == 0) goto L_0x0474
            r6 = r1
            r1 = r3
            r3 = r2
            r2 = r4
            r4 = 1056964608(0x3f000000, float:0.5)
            r17 = r6
            r6 = r13
            r19 = 4
            r13 = r0
            r0 = r36
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x047b
        L_0x0474:
            r13 = r0
            r17 = r1
            r19 = 4
            r0 = r36
        L_0x047b:
            r1 = r17
            goto L_0x0483
        L_0x047e:
            r13 = r0
            r19 = 4
            r0 = r36
        L_0x0483:
            int r2 = r15.getVisibility()
            r6 = 8
            if (r2 == r6) goto L_0x048c
            r13 = r15
        L_0x048c:
            r15 = r1
            r0 = r13
            r13 = r6
            goto L_0x03dc
        L_0x0491:
            r0 = r36
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            r1 = r1[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r9.mListAnchors
            r2 = r2[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r12.mListAnchors
            int r4 = r38 + 1
            r9 = r3[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r10.mListAnchors
            r3 = r3[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r13 = r3.mTarget
            r8 = 5
            if (r2 == 0) goto L_0x04d2
            if (r11 == r12) goto L_0x04ba
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r1 = r1.getMargin()
            r0.addEquality(r3, r2, r1, r8)
            goto L_0x04d2
        L_0x04ba:
            if (r13 == 0) goto L_0x04d2
            r3 = r1
            androidx.constraintlayout.solver.SolverVariable r1 = r3.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r3 = r3.getMargin()
            androidx.constraintlayout.solver.SolverVariable r5 = r9.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r13.mSolverVariable
            int r7 = r9.getMargin()
            r4 = 1056964608(0x3f000000, float:0.5)
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x04d2:
            if (r13 == 0) goto L_0x04e5
            if (r11 == r12) goto L_0x04e5
            androidx.constraintlayout.solver.SolverVariable r1 = r9.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r2 = r13.mSolverVariable
            int r3 = r9.getMargin()
            int r3 = -r3
            r0.addEquality(r1, r2, r3, r8)
            goto L_0x04e5
        L_0x04e3:
            r0 = r36
        L_0x04e5:
            if (r25 != 0) goto L_0x04e9
            if (r14 == 0) goto L_0x0549
        L_0x04e9:
            if (r11 == 0) goto L_0x0549
            if (r11 == r12) goto L_0x0549
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            r1 = r1[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x0500
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x0502
        L_0x0500:
            r4 = r21
        L_0x0502:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r2.mTarget
            if (r5 == 0) goto L_0x050b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            goto L_0x050d
        L_0x050b:
            r5 = r21
        L_0x050d:
            if (r10 == r12) goto L_0x051f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r10.mListAnchors
            r5 = r5[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r5.mTarget
            if (r6 == 0) goto L_0x051d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            r21 = r5
        L_0x051d:
            r5 = r21
        L_0x051f:
            if (r11 != r12) goto L_0x0529
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            r1 = r1[r38]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r3]
        L_0x0529:
            if (r4 == 0) goto L_0x0549
            if (r5 == 0) goto L_0x0549
            r6 = r3
            int r3 = r1.getMargin()
            if (r12 != 0) goto L_0x0535
            goto L_0x0536
        L_0x0535:
            r10 = r12
        L_0x0536:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r10.mListAnchors
            r6 = r7[r6]
            int r7 = r6.getMargin()
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            r8 = 5
            r2 = r4
            r4 = 1056964608(0x3f000000, float:0.5)
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0549:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
