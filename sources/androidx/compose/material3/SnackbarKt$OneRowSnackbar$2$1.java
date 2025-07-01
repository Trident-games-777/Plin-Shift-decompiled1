package androidx.compose.material3;

import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $dismissActionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2$1(String str, String str2, String str3) {
        this.$actionTag = str;
        this.$dismissActionTag = str2;
        this.$textTag = str3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0165  */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.layout.MeasureResult m2523measure3p2s80s(androidx.compose.ui.layout.MeasureScope r22, java.util.List<? extends androidx.compose.ui.layout.Measurable> r23, long r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            int r5 = androidx.compose.ui.unit.Constraints.m7052getMaxWidthimpl(r3)
            float r6 = androidx.compose.material3.SnackbarKt.ContainerMaxWidth
            int r6 = r1.m7086roundToPx0680j_4(r6)
            int r10 = java.lang.Math.min(r5, r6)
            java.lang.String r5 = r0.$actionTag
            int r6 = r2.size()
            r7 = 0
        L_0x001f:
            r8 = 0
            if (r7 >= r6) goto L_0x0037
            java.lang.Object r9 = r2.get(r7)
            r12 = r9
            androidx.compose.ui.layout.Measurable r12 = (androidx.compose.ui.layout.Measurable) r12
            java.lang.Object r12 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r12)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r5)
            if (r12 == 0) goto L_0x0034
            goto L_0x0038
        L_0x0034:
            int r7 = r7 + 1
            goto L_0x001f
        L_0x0037:
            r9 = r8
        L_0x0038:
            androidx.compose.ui.layout.Measurable r9 = (androidx.compose.ui.layout.Measurable) r9
            if (r9 == 0) goto L_0x0042
            androidx.compose.ui.layout.Placeable r5 = r9.m5848measureBRTryo0(r3)
            r12 = r5
            goto L_0x0043
        L_0x0042:
            r12 = r8
        L_0x0043:
            java.lang.String r5 = r0.$dismissActionTag
            int r6 = r2.size()
            r7 = 0
        L_0x004a:
            if (r7 >= r6) goto L_0x0061
            java.lang.Object r9 = r2.get(r7)
            r13 = r9
            androidx.compose.ui.layout.Measurable r13 = (androidx.compose.ui.layout.Measurable) r13
            java.lang.Object r13 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r13)
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r5)
            if (r13 == 0) goto L_0x005e
            goto L_0x0062
        L_0x005e:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0061:
            r9 = r8
        L_0x0062:
            androidx.compose.ui.layout.Measurable r9 = (androidx.compose.ui.layout.Measurable) r9
            if (r9 == 0) goto L_0x006a
            androidx.compose.ui.layout.Placeable r8 = r9.m5848measureBRTryo0(r3)
        L_0x006a:
            r15 = r8
            if (r12 == 0) goto L_0x0073
            int r5 = r12.getWidth()
            r13 = r5
            goto L_0x0074
        L_0x0073:
            r13 = 0
        L_0x0074:
            if (r12 == 0) goto L_0x007c
            int r5 = r12.getHeight()
            r14 = r5
            goto L_0x007d
        L_0x007c:
            r14 = 0
        L_0x007d:
            if (r15 == 0) goto L_0x0086
            int r5 = r15.getWidth()
            r16 = r5
            goto L_0x0088
        L_0x0086:
            r16 = 0
        L_0x0088:
            if (r15 == 0) goto L_0x008f
            int r5 = r15.getHeight()
            goto L_0x0090
        L_0x008f:
            r5 = 0
        L_0x0090:
            if (r16 != 0) goto L_0x009b
            float r6 = androidx.compose.material3.SnackbarKt.TextEndExtraSpacing
            int r6 = r1.m7086roundToPx0680j_4(r6)
            goto L_0x009c
        L_0x009b:
            r6 = 0
        L_0x009c:
            int r7 = r10 - r13
            int r7 = r7 - r16
            int r7 = r7 - r6
            int r6 = androidx.compose.ui.unit.Constraints.m7054getMinWidthimpl(r3)
            int r6 = kotlin.ranges.RangesKt.coerceAtLeast((int) r7, (int) r6)
            java.lang.String r7 = r0.$textTag
            int r8 = r2.size()
            r9 = 0
        L_0x00b0:
            if (r9 >= r8) goto L_0x018a
            java.lang.Object r17 = r2.get(r9)
            r11 = r17
            androidx.compose.ui.layout.Measurable r11 = (androidx.compose.ui.layout.Measurable) r11
            java.lang.Object r0 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r11)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r0 == 0) goto L_0x017b
            r8 = 9
            r9 = 0
            r4 = 0
            r0 = r5
            r5 = r6
            r6 = 0
            r7 = 0
            r2 = r24
            long r2 = androidx.compose.ui.unit.Constraints.m7043copyZbe2FdA$default(r2, r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.layout.Placeable r2 = r11.m5848measureBRTryo0(r2)
            androidx.compose.ui.layout.HorizontalAlignmentLine r3 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            androidx.compose.ui.layout.AlignmentLine r3 = (androidx.compose.ui.layout.AlignmentLine) r3
            int r3 = r2.get(r3)
            androidx.compose.ui.layout.HorizontalAlignmentLine r4 = androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline()
            androidx.compose.ui.layout.AlignmentLine r4 = (androidx.compose.ui.layout.AlignmentLine) r4
            int r4 = r2.get(r4)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 1
            if (r3 == r5) goto L_0x00f3
            if (r4 == r5) goto L_0x00f3
            r7 = r6
            goto L_0x00f4
        L_0x00f3:
            r7 = 0
        L_0x00f4:
            if (r3 == r4) goto L_0x00fa
            if (r7 != 0) goto L_0x00f9
            goto L_0x00fa
        L_0x00f9:
            r6 = 0
        L_0x00fa:
            int r16 = r10 - r16
            int r19 = r16 - r13
            if (r6 == 0) goto L_0x012b
            androidx.compose.material3.tokens.SnackbarTokens r4 = androidx.compose.material3.tokens.SnackbarTokens.INSTANCE
            float r4 = r4.m3526getSingleLineContainerHeightD9Ej5fM()
            int r4 = r1.m7086roundToPx0680j_4(r4)
            int r0 = java.lang.Math.max(r14, r0)
            int r0 = java.lang.Math.max(r4, r0)
            int r4 = r2.getHeight()
            int r4 = r0 - r4
            int r4 = r4 / 2
            if (r12 == 0) goto L_0x0153
            androidx.compose.ui.layout.HorizontalAlignmentLine r6 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            androidx.compose.ui.layout.AlignmentLine r6 = (androidx.compose.ui.layout.AlignmentLine) r6
            int r6 = r12.get(r6)
            if (r6 == r5) goto L_0x0153
            int r3 = r3 + r4
            int r3 = r3 - r6
            goto L_0x0154
        L_0x012b:
            float r0 = androidx.compose.material3.SnackbarKt.HeightToFirstLine
            int r0 = r1.m7086roundToPx0680j_4(r0)
            int r4 = r0 - r3
            androidx.compose.material3.tokens.SnackbarTokens r0 = androidx.compose.material3.tokens.SnackbarTokens.INSTANCE
            float r0 = r0.m3527getTwoLinesContainerHeightD9Ej5fM()
            int r0 = r1.m7086roundToPx0680j_4(r0)
            int r3 = r2.getHeight()
            int r3 = r3 + r4
            int r0 = java.lang.Math.max(r0, r3)
            if (r12 == 0) goto L_0x0153
            int r3 = r12.getHeight()
            int r3 = r0 - r3
            int r3 = r3 / 2
            goto L_0x0154
        L_0x0153:
            r3 = 0
        L_0x0154:
            r20 = r3
            r14 = r4
            r3 = r0
            if (r15 == 0) goto L_0x0165
            int r0 = r15.getHeight()
            int r0 = r3 - r0
            int r11 = r0 / 2
            r17 = r11
            goto L_0x0167
        L_0x0165:
            r17 = 0
        L_0x0167:
            r18 = r12
            androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1$2 r12 = new androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1$2
            r13 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            r5 = r12
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6 = 4
            r7 = 0
            r4 = 0
            r2 = r10
            androidx.compose.ui.layout.MeasureResult r0 = androidx.compose.ui.layout.MeasureScope.layout$default(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x017b:
            r0 = r5
            r3 = r6
            r1 = r10
            r5 = r12
            int r9 = r9 + 1
            r1 = r22
            r3 = r24
            r5 = r0
            r0 = r21
            goto L_0x00b0
        L_0x018a:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            java.lang.String r1 = "Collection contains no element matching the predicate."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1.m2523measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }
}
