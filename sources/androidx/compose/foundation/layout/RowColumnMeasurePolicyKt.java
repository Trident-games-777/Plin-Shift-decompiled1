package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnMeasurePolicy.kt */
public final class RowColumnMeasurePolicyKt {
    public static /* synthetic */ MeasureResult measure$default(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, MeasureScope measureScope, List list, Placeable[] placeableArr, int i6, int i7, int[] iArr, int i8, int i9, Object obj) {
        int i10 = i9;
        return measure(rowColumnMeasurePolicy, i, i2, i3, i4, i5, measureScope, list, placeableArr, i6, i7, (i10 & 1024) != 0 ? null : iArr, (i10 & 2048) != 0 ? 0 : i8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x029b A[Catch:{ IllegalArgumentException -> 0x0337 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02ad A[SYNTHETIC, Splitter:B:74:0x02ad] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.layout.MeasureResult measure(androidx.compose.foundation.layout.RowColumnMeasurePolicy r58, int r59, int r60, int r61, int r62, int r63, androidx.compose.ui.layout.MeasureScope r64, java.util.List<? extends androidx.compose.ui.layout.Measurable> r65, androidx.compose.ui.layout.Placeable[] r66, int r67, int r68, int[] r69, int r70) {
        /*
            r8 = r59
            r9 = r61
            r10 = r62
            r11 = r63
            r12 = r65
            r13 = r68
            long r14 = (long) r11
            int r0 = r13 - r67
            int[] r1 = new int[r0]
            r16 = 0
            r2 = 0
            r3 = r67
            r17 = r1
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r18 = r7
            r1 = r16
        L_0x0020:
            r19 = 0
            r20 = r5
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r3 >= r13) goto L_0x00fd
            java.lang.Object r21 = r12.get(r3)
            r22 = r1
            r1 = r21
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            r21 = r1
            androidx.compose.ui.layout.IntrinsicMeasurable r21 = (androidx.compose.ui.layout.IntrinsicMeasurable) r21
            androidx.compose.foundation.layout.RowColumnParentData r21 = androidx.compose.foundation.layout.RowColumnImplKt.getRowColumnParentData((androidx.compose.ui.layout.IntrinsicMeasurable) r21)
            float r23 = androidx.compose.foundation.layout.RowColumnImplKt.getWeight(r21)
            if (r6 != 0) goto L_0x004b
            boolean r6 = androidx.compose.foundation.layout.RowColumnImplKt.isRelative(r21)
            if (r6 == 0) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r24 = r2
            goto L_0x004e
        L_0x004b:
            r6 = 1
            r24 = r6
        L_0x004e:
            int r6 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r6 <= 0) goto L_0x0060
            float r1 = r22 + r23
            int r4 = r4 + 1
            r28 = r0
            r26 = r3
            r5 = r20
            r0 = r58
            goto L_0x00f2
        L_0x0060:
            if (r10 != r5) goto L_0x0063
            goto L_0x0079
        L_0x0063:
            if (r21 == 0) goto L_0x0079
            androidx.compose.foundation.layout.FlowLayoutData r6 = r21.getFlowLayoutData()
            if (r6 == 0) goto L_0x0079
            float r6 = r6.getFillCrossAxisFraction()
            float r7 = (float) r10
            float r6 = r6 * r7
            int r6 = java.lang.Math.round(r6)
            java.lang.Integer r19 = java.lang.Integer.valueOf(r6)
        L_0x0079:
            int r6 = r9 - r20
            r7 = r66[r3]
            if (r7 != 0) goto L_0x00bb
            if (r19 == 0) goto L_0x0086
            int r7 = r19.intValue()
            goto L_0x0087
        L_0x0086:
            r7 = r2
        L_0x0087:
            if (r9 != r5) goto L_0x008a
            goto L_0x008e
        L_0x008a:
            int r5 = kotlin.ranges.RangesKt.coerceAtLeast((int) r6, (int) r2)
        L_0x008e:
            if (r19 == 0) goto L_0x0095
            int r19 = r19.intValue()
            goto L_0x0097
        L_0x0095:
            r19 = r10
        L_0x0097:
            r21 = r6
            r6 = 16
            r23 = r2
            r2 = r7
            r7 = 0
            r25 = r1
            r1 = 0
            r26 = r3
            r3 = r5
            r5 = 0
            r28 = r0
            r27 = r20
            r10 = r25
            r0 = r58
            r20 = r4
            r4 = r19
            long r1 = androidx.compose.foundation.layout.RowColumnMeasurePolicy.m814createConstraintsxF2OJ5Q$default(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.layout.Placeable r7 = r10.m5848measureBRTryo0(r1)
            goto L_0x00c7
        L_0x00bb:
            r28 = r0
            r26 = r3
            r21 = r6
            r27 = r20
            r0 = r58
            r20 = r4
        L_0x00c7:
            int r1 = r0.mainAxisSize(r7)
            int r2 = r0.crossAxisSize(r7)
            int r3 = r26 - r67
            r17[r3] = r1
            int r6 = r21 - r1
            r3 = 0
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r6, (int) r3)
            int r3 = java.lang.Math.min(r11, r4)
            int r1 = r1 + r3
            r10 = r27
            int r5 = r10 + r1
            r1 = r18
            int r1 = java.lang.Math.max(r1, r2)
            r66[r26] = r7
            r18 = r1
            r7 = r3
            r4 = r20
            r1 = r22
        L_0x00f2:
            int r3 = r26 + 1
            r10 = r62
            r6 = r24
            r0 = r28
            r2 = 0
            goto L_0x0020
        L_0x00fd:
            r28 = r0
            r22 = r1
            r1 = r18
            r10 = r20
            r0 = r58
            r20 = r4
            if (r20 != 0) goto L_0x0113
            int r5 = r10 - r7
            r4 = r1
            r63 = r6
            r2 = 0
            goto L_0x0459
        L_0x0113:
            if (r9 == r5) goto L_0x0117
            r7 = r9
            goto L_0x0118
        L_0x0117:
            r7 = r8
        L_0x0118:
            int r4 = r20 + -1
            long r2 = (long) r4
            long r2 = r2 * r14
            int r4 = r7 - r10
            r11 = r6
            long r5 = (long) r4
            long r5 = r5 - r2
            r4 = r1
            r0 = 0
            long r5 = kotlin.ranges.RangesKt.coerceAtLeast((long) r5, (long) r0)
            float r0 = (float) r5
            float r1 = r0 / r22
            r0 = r67
            r24 = r5
            r63 = r11
        L_0x0131:
            java.lang.String r11 = "weightedSize "
            r21 = r4
            java.lang.String r4 = "weightUnitSpace "
            r26 = r11
            java.lang.String r11 = "totalWeight "
            r27 = r1
            java.lang.String r1 = "remainingToTarget "
            r29 = r4
            java.lang.String r4 = "arrangementSpacingTotal "
            r30 = r11
            java.lang.String r11 = "fixedSpace "
            r31 = r5
            java.lang.String r5 = "weightChildrenCount "
            java.lang.String r6 = "arrangementSpacingPx "
            r33 = r1
            java.lang.String r1 = "targetSpace "
            r34 = r2
            java.lang.String r2 = "mainAxisMin "
            if (r0 >= r13) goto L_0x0212
            java.lang.Object r3 = r12.get(r0)
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            androidx.compose.ui.layout.IntrinsicMeasurable r3 = (androidx.compose.ui.layout.IntrinsicMeasurable) r3
            androidx.compose.foundation.layout.RowColumnParentData r3 = androidx.compose.foundation.layout.RowColumnImplKt.getRowColumnParentData((androidx.compose.ui.layout.IntrinsicMeasurable) r3)
            float r3 = androidx.compose.foundation.layout.RowColumnImplKt.getWeight(r3)
            float r12 = r27 * r3
            int r1 = java.lang.Math.round(r12)     // Catch:{ IllegalArgumentException -> 0x0182 }
            long r1 = (long) r1
            long r24 = r24 - r1
            int r0 = r0 + 1
            r12 = r65
            r4 = r21
            r1 = r27
            r5 = r31
            r2 = r34
            goto L_0x0131
        L_0x0182:
            r0 = move-exception
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r58 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r60 = r13
            java.lang.String r13 = "This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax "
            r0.<init>(r13)
            java.lang.StringBuilder r9 = r0.append(r9)
            java.lang.StringBuilder r2 = r9.append(r2)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.StringBuilder r1 = r1.append(r14)
            java.lang.StringBuilder r1 = r1.append(r5)
            r2 = r20
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.StringBuilder r1 = r1.append(r4)
            r4 = r34
            java.lang.StringBuilder r1 = r1.append(r4)
            r2 = r33
            java.lang.StringBuilder r1 = r1.append(r2)
            r4 = r31
            java.lang.StringBuilder r1 = r1.append(r4)
            r2 = r30
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r22
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r29
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r27
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "itemWeight "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r3)
            r3 = r26
            r1.append(r3)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            r1 = r60
            r1.<init>(r0)
            r0 = r58
            java.lang.Exception r0 = (java.lang.Exception) r0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Throwable r0 = r1.initCause(r0)
            throw r0
        L_0x0212:
            r12 = r20
            r36 = r22
            r3 = r26
            r37 = r30
            r20 = r5
            r38 = r21
            r0 = 0
            r5 = r67
        L_0x0221:
            if (r5 >= r13) goto L_0x0445
            r21 = r66[r5]
            if (r21 != 0) goto L_0x041b
            r13 = r65
            java.lang.Object r21 = r13.get(r5)
            r22 = r5
            r5 = r21
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            r21 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r21 = (androidx.compose.ui.layout.IntrinsicMeasurable) r21
            androidx.compose.foundation.layout.RowColumnParentData r21 = androidx.compose.foundation.layout.RowColumnImplKt.getRowColumnParentData((androidx.compose.ui.layout.IntrinsicMeasurable) r21)
            r26 = r5
            float r5 = androidx.compose.foundation.layout.RowColumnImplKt.getWeight(r21)
            r39 = r0
            r30 = r5
            r0 = 2147483647(0x7fffffff, float:NaN)
            r5 = r62
            if (r5 != r0) goto L_0x024f
        L_0x024c:
            r5 = r19
            goto L_0x0269
        L_0x024f:
            if (r21 == 0) goto L_0x024c
            androidx.compose.foundation.layout.FlowLayoutData r0 = r21.getFlowLayoutData()
            if (r0 == 0) goto L_0x024c
            float r0 = r0.getFillCrossAxisFraction()
            r40 = r0
            float r0 = (float) r5
            float r0 = r0 * r40
            int r0 = java.lang.Math.round(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5 = r0
        L_0x0269:
            int r0 = (r30 > r16 ? 1 : (r30 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x040f
            r40 = r5
            int r5 = kotlin.math.MathKt.getSign((long) r24)
            r41 = r1
            long r0 = (long) r5
            long r24 = r24 - r0
            float r1 = r27 * r30
            int r0 = java.lang.Math.round(r1)
            int r0 = r0 + r5
            r42 = r1
            r43 = r2
            r1 = 0
            int r2 = java.lang.Math.max(r1, r0)
            boolean r0 = androidx.compose.foundation.layout.RowColumnImplKt.getFill(r21)     // Catch:{ IllegalArgumentException -> 0x0337 }
            if (r0 == 0) goto L_0x0295
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r0) goto L_0x0298
            r1 = r2
            goto L_0x0299
        L_0x0295:
            r0 = 2147483647(0x7fffffff, float:NaN)
        L_0x0298:
            r1 = 0
        L_0x0299:
            if (r40 == 0) goto L_0x02a7
            int r18 = r40.intValue()     // Catch:{ IllegalArgumentException -> 0x0337 }
            r57 = r3
            r3 = r2
            r2 = r18
            r18 = r57
            goto L_0x02ab
        L_0x02a7:
            r18 = r3
            r3 = r2
            r2 = 0
        L_0x02ab:
            if (r40 == 0) goto L_0x02d7
            int r21 = r40.intValue()     // Catch:{ IllegalArgumentException -> 0x02b2 }
            goto L_0x02d9
        L_0x02b2:
            r0 = move-exception
            r21 = r20
            r20 = r10
            r10 = r21
            r56 = r4
            r51 = r5
            r21 = r12
            r53 = r18
            r54 = r29
            r49 = r30
            r47 = r31
            r55 = r33
            r45 = r34
            r50 = r40
            r52 = r42
            r12 = r43
            r18 = r11
            r11 = r41
            goto L_0x035b
        L_0x02d7:
            r21 = r62
        L_0x02d9:
            r44 = r5
            r5 = 1
            r13 = r20
            r20 = r10
            r10 = r13
            r56 = r4
            r53 = r18
            r4 = r21
            r13 = r26
            r54 = r29
            r49 = r30
            r47 = r31
            r55 = r33
            r45 = r34
            r50 = r40
            r52 = r42
            r51 = r44
            r26 = r0
            r18 = r11
            r21 = r12
            r11 = r41
            r12 = r43
            r0 = r58
            long r1 = r0.m815createConstraintsxF2OJ5Q(r1, r2, r3, r4, r5)     // Catch:{ IllegalArgumentException -> 0x0335 }
            androidx.compose.ui.layout.Placeable r1 = r13.m5848measureBRTryo0(r1)
            int r2 = r0.mainAxisSize(r1)
            int r3 = r0.crossAxisSize(r1)
            int r5 = r22 - r67
            r17[r5] = r2
            int r2 = r39 + r2
            r4 = r38
            int r38 = java.lang.Math.max(r4, r3)
            r66[r22] = r1
            r39 = r2
            r13 = r18
            r5 = r21
            r34 = r45
            r31 = r47
            r3 = r53
            r29 = r54
            r33 = r55
            goto L_0x0431
        L_0x0335:
            r0 = move-exception
            goto L_0x035b
        L_0x0337:
            r0 = move-exception
            r18 = r20
            r20 = r10
            r10 = r18
            r53 = r3
            r56 = r4
            r51 = r5
            r18 = r11
            r21 = r12
            r54 = r29
            r49 = r30
            r47 = r31
            r55 = r33
            r45 = r34
            r50 = r40
            r11 = r41
            r52 = r42
            r12 = r43
            r3 = r2
        L_0x035b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax "
            r2.<init>(r4)
            java.lang.StringBuilder r4 = r2.append(r9)
            java.lang.StringBuilder r4 = r4.append(r12)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.StringBuilder r4 = r4.append(r11)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r4 = r4.append(r14)
            java.lang.StringBuilder r4 = r4.append(r10)
            r5 = r21
            java.lang.StringBuilder r4 = r4.append(r5)
            r13 = r18
            java.lang.StringBuilder r4 = r4.append(r13)
            r5 = r20
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r56
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r45
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r55
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r47
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r37
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r36
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r54
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r27
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "weight "
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r49
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r53
            r4.append(r5)
            r4 = r52
            java.lang.StringBuilder r4 = r2.append(r4)
            java.lang.String r5 = "crossAxisDesiredSize "
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r50
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "remainderUnit "
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r51
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "childMainAxisSize "
            java.lang.StringBuilder r4 = r4.append(r5)
            r4.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Exception r0 = (java.lang.Exception) r0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Throwable r0 = r1.initCause(r0)
            throw r0
        L_0x040f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "All weights <= 0 should have placeables"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x041b:
            r13 = r20
            r20 = r10
            r10 = r13
            r39 = r0
            r56 = r4
            r22 = r5
            r13 = r11
            r5 = r12
            r4 = r38
            r26 = 2147483647(0x7fffffff, float:NaN)
            r0 = r58
            r11 = r1
            r12 = r2
        L_0x0431:
            int r1 = r22 + 1
            r0 = r20
            r20 = r10
            r10 = r0
            r2 = r12
            r0 = r39
            r4 = r56
            r12 = r5
            r5 = r1
            r1 = r11
            r11 = r13
            r13 = r68
            goto L_0x0221
        L_0x0445:
            r1 = r0
            r20 = r10
            r4 = r38
            r0 = r58
            long r1 = (long) r1
            long r1 = r1 + r34
            int r1 = (int) r1
            int r2 = r9 - r20
            r3 = 0
            int r2 = kotlin.ranges.RangesKt.coerceIn((int) r1, (int) r3, (int) r2)
            r5 = r20
        L_0x0459:
            if (r63 == 0) goto L_0x04a6
            r6 = r67
            r10 = r68
            r1 = 0
            r3 = 0
        L_0x0461:
            if (r6 >= r10) goto L_0x04a0
            r7 = r66[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            androidx.compose.foundation.layout.RowColumnParentData r9 = androidx.compose.foundation.layout.RowColumnImplKt.getRowColumnParentData((androidx.compose.ui.layout.Placeable) r7)
            androidx.compose.foundation.layout.CrossAxisAlignment r9 = androidx.compose.foundation.layout.RowColumnImplKt.getCrossAxisAlignment(r9)
            if (r9 == 0) goto L_0x0477
            java.lang.Integer r9 = r9.calculateAlignmentLinePosition$foundation_layout_release(r7)
            goto L_0x0479
        L_0x0477:
            r9 = r19
        L_0x0479:
            if (r9 == 0) goto L_0x049d
            r11 = r9
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            int r7 = r0.crossAxisSize(r7)
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == r12) goto L_0x048f
            int r9 = r9.intValue()
            goto L_0x0490
        L_0x048f:
            r9 = 0
        L_0x0490:
            int r1 = java.lang.Math.max(r1, r9)
            if (r11 == r12) goto L_0x0497
            goto L_0x0498
        L_0x0497:
            r11 = r7
        L_0x0498:
            int r7 = r7 - r11
            int r3 = java.lang.Math.max(r3, r7)
        L_0x049d:
            int r6 = r6 + 1
            goto L_0x0461
        L_0x04a0:
            r57 = r3
            r3 = r1
            r1 = r57
            goto L_0x04aa
        L_0x04a6:
            r10 = r68
            r1 = 0
            r3 = 0
        L_0x04aa:
            int r5 = r5 + r2
            r2 = 0
            int r5 = kotlin.ranges.RangesKt.coerceAtLeast((int) r5, (int) r2)
            int r5 = java.lang.Math.max(r5, r8)
            int r1 = r1 + r3
            r6 = r60
            int r1 = java.lang.Math.max(r6, r1)
            int r6 = java.lang.Math.max(r4, r1)
            r1 = r28
            int[] r4 = new int[r1]
            r7 = r2
        L_0x04c4:
            if (r7 >= r1) goto L_0x04cb
            r4[r7] = r2
            int r7 = r7 + 1
            goto L_0x04c4
        L_0x04cb:
            r7 = r64
            r8 = r17
            r0.populateMainAxisPositions(r5, r8, r4, r7)
            r1 = r66
            r9 = r67
            r8 = r70
            r2 = r7
            r7 = r69
            androidx.compose.ui.layout.MeasureResult r0 = r0.placeHelper(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.RowColumnMeasurePolicyKt.measure(androidx.compose.foundation.layout.RowColumnMeasurePolicy, int, int, int, int, int, androidx.compose.ui.layout.MeasureScope, java.util.List, androidx.compose.ui.layout.Placeable[], int, int, int[], int):androidx.compose.ui.layout.MeasureResult");
    }
}
