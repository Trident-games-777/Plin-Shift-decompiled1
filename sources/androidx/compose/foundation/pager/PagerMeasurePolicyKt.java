package androidx.compose.foundation.pager;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¡\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"rememberPagerMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pageCount", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasurePolicy.kt */
public final class PagerMeasurePolicyKt {
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0078, code lost:
        if (r0.changed((java.lang.Object) r4) == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        if (r0.changed((java.lang.Object) r9) == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b1, code lost:
        if (r0.changed((java.lang.Object) r12) == false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cd, code lost:
        if (r0.changed(r13) == false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e9, code lost:
        if (r0.changed((java.lang.Object) r14) == false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0102, code lost:
        if (r0.changed((java.lang.Object) r5) == false) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0135, code lost:
        if (r0.changed(r3) == false) goto L_0x013a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0144  */
    /* renamed from: rememberPagerMeasurePolicy-8u0NR3k  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> m1099rememberPagerMeasurePolicy8u0NR3k(kotlin.jvm.functions.Function0<androidx.compose.foundation.pager.PagerLazyLayoutItemProvider> r21, androidx.compose.foundation.pager.PagerState r22, androidx.compose.foundation.layout.PaddingValues r23, boolean r24, androidx.compose.foundation.gestures.Orientation r25, int r26, float r27, androidx.compose.foundation.pager.PageSize r28, androidx.compose.ui.Alignment.Horizontal r29, androidx.compose.ui.Alignment.Vertical r30, androidx.compose.foundation.gestures.snapping.SnapPosition r31, kotlinx.coroutines.CoroutineScope r32, kotlin.jvm.functions.Function0<java.lang.Integer> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r0 = r34
            r1 = r35
            r2 = r36
            java.lang.String r3 = "C(rememberPagerMeasurePolicy)P(4,11,1,9,5!1,8:c#ui.unit.Dp,7,3,12,10)56@2301L6278:PagerMeasurePolicy.kt#g6yjnt"
            r4 = 1391419623(0x52ef60e7, float:5.14061468E11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0019
            java.lang.String r3 = "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:56)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x0019:
            r3 = 35232261(0x2199a05, float:1.1284866E-37)
            java.lang.String r4 = "CC(remember):PagerMeasurePolicy.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r4)
            r3 = r1 & 112(0x70, float:1.57E-43)
            r3 = r3 ^ 48
            r4 = 32
            r8 = r22
            if (r3 <= r4) goto L_0x0031
            boolean r3 = r0.changed((java.lang.Object) r8)
            if (r3 != 0) goto L_0x0035
        L_0x0031:
            r3 = r1 & 48
            if (r3 != r4) goto L_0x0037
        L_0x0035:
            r3 = 1
            goto L_0x0038
        L_0x0037:
            r3 = 0
        L_0x0038:
            r4 = r1 & 896(0x380, float:1.256E-42)
            r4 = r4 ^ 384(0x180, float:5.38E-43)
            r7 = 256(0x100, float:3.59E-43)
            r10 = r23
            if (r4 <= r7) goto L_0x0048
            boolean r4 = r0.changed((java.lang.Object) r10)
            if (r4 != 0) goto L_0x004c
        L_0x0048:
            r4 = r1 & 384(0x180, float:5.38E-43)
            if (r4 != r7) goto L_0x004e
        L_0x004c:
            r4 = 1
            goto L_0x004f
        L_0x004e:
            r4 = 0
        L_0x004f:
            r3 = r3 | r4
            r4 = r1 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 ^ 3072(0xc00, float:4.305E-42)
            r9 = 2048(0x800, float:2.87E-42)
            r11 = r24
            if (r4 <= r9) goto L_0x0060
            boolean r4 = r0.changed((boolean) r11)
            if (r4 != 0) goto L_0x0064
        L_0x0060:
            r4 = r1 & 3072(0xc00, float:4.305E-42)
            if (r4 != r9) goto L_0x0066
        L_0x0064:
            r4 = 1
            goto L_0x0067
        L_0x0066:
            r4 = 0
        L_0x0067:
            r3 = r3 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r1
            r4 = r4 ^ 24576(0x6000, float:3.4438E-41)
            r9 = 16384(0x4000, float:2.2959E-41)
            if (r4 <= r9) goto L_0x007b
            r4 = r25
            boolean r12 = r0.changed((java.lang.Object) r4)
            if (r12 != 0) goto L_0x0081
            goto L_0x007d
        L_0x007b:
            r4 = r25
        L_0x007d:
            r12 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r12 != r9) goto L_0x0083
        L_0x0081:
            r9 = 1
            goto L_0x0084
        L_0x0083:
            r9 = 0
        L_0x0084:
            r3 = r3 | r9
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r1
            r12 = 100663296(0x6000000, float:2.4074124E-35)
            r9 = r9 ^ r12
            r13 = 67108864(0x4000000, float:1.5046328E-36)
            if (r9 <= r13) goto L_0x0098
            r9 = r29
            boolean r14 = r0.changed((java.lang.Object) r9)
            if (r14 != 0) goto L_0x009d
            goto L_0x009a
        L_0x0098:
            r9 = r29
        L_0x009a:
            r12 = r12 & r1
            if (r12 != r13) goto L_0x009f
        L_0x009d:
            r12 = 1
            goto L_0x00a0
        L_0x009f:
            r12 = 0
        L_0x00a0:
            r3 = r3 | r12
            r12 = 1879048192(0x70000000, float:1.58456325E29)
            r12 = r12 & r1
            r13 = 805306368(0x30000000, float:4.656613E-10)
            r12 = r12 ^ r13
            r14 = 536870912(0x20000000, float:1.0842022E-19)
            if (r12 <= r14) goto L_0x00b4
            r12 = r30
            boolean r15 = r0.changed((java.lang.Object) r12)
            if (r15 != 0) goto L_0x00b9
            goto L_0x00b6
        L_0x00b4:
            r12 = r30
        L_0x00b6:
            r13 = r13 & r1
            if (r13 != r14) goto L_0x00bb
        L_0x00b9:
            r13 = 1
            goto L_0x00bc
        L_0x00bb:
            r13 = 0
        L_0x00bc:
            r3 = r3 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r1
            r14 = 1572864(0x180000, float:2.204052E-39)
            r13 = r13 ^ r14
            r15 = 1048576(0x100000, float:1.469368E-39)
            if (r13 <= r15) goto L_0x00d0
            r13 = r27
            boolean r16 = r0.changed((float) r13)
            if (r16 != 0) goto L_0x00d5
            goto L_0x00d2
        L_0x00d0:
            r13 = r27
        L_0x00d2:
            r14 = r14 & r1
            if (r14 != r15) goto L_0x00d7
        L_0x00d5:
            r14 = 1
            goto L_0x00d8
        L_0x00d7:
            r14 = 0
        L_0x00d8:
            r3 = r3 | r14
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r14 = r14 & r1
            r15 = 12582912(0xc00000, float:1.7632415E-38)
            r14 = r14 ^ r15
            r5 = 8388608(0x800000, float:1.17549435E-38)
            if (r14 <= r5) goto L_0x00ec
            r14 = r28
            boolean r17 = r0.changed((java.lang.Object) r14)
            if (r17 != 0) goto L_0x00f1
            goto L_0x00ee
        L_0x00ec:
            r14 = r28
        L_0x00ee:
            r15 = r15 & r1
            if (r15 != r5) goto L_0x00f3
        L_0x00f1:
            r5 = 1
            goto L_0x00f4
        L_0x00f3:
            r5 = 0
        L_0x00f4:
            r3 = r3 | r5
            r5 = r2 & 14
            r5 = r5 ^ 6
            r15 = 4
            if (r5 <= r15) goto L_0x0105
            r5 = r31
            boolean r17 = r0.changed((java.lang.Object) r5)
            if (r17 != 0) goto L_0x010b
            goto L_0x0107
        L_0x0105:
            r5 = r31
        L_0x0107:
            r6 = r2 & 6
            if (r6 != r15) goto L_0x010d
        L_0x010b:
            r6 = 1
            goto L_0x010e
        L_0x010d:
            r6 = 0
        L_0x010e:
            r3 = r3 | r6
            r6 = r2 & 896(0x380, float:1.256E-42)
            r6 = r6 ^ 384(0x180, float:5.38E-43)
            r15 = r33
            if (r6 <= r7) goto L_0x011d
            boolean r6 = r0.changed((java.lang.Object) r15)
            if (r6 != 0) goto L_0x0121
        L_0x011d:
            r2 = r2 & 384(0x180, float:5.38E-43)
            if (r2 != r7) goto L_0x0123
        L_0x0121:
            r2 = 1
            goto L_0x0124
        L_0x0123:
            r2 = 0
        L_0x0124:
            r2 = r2 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r1
            r6 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 ^ r6
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r3 <= r6) goto L_0x0138
            r3 = r26
            boolean r6 = r0.changed((int) r3)
            if (r6 != 0) goto L_0x0141
            goto L_0x013a
        L_0x0138:
            r3 = r26
        L_0x013a:
            r6 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 & r6
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r1 != r6) goto L_0x0144
        L_0x0141:
            r16 = 1
            goto L_0x0146
        L_0x0144:
            r16 = 0
        L_0x0146:
            r1 = r2 | r16
            r2 = r32
            boolean r6 = r0.changed((java.lang.Object) r2)
            r1 = r1 | r6
            java.lang.Object r6 = r0.rememberedValue()
            if (r1 != 0) goto L_0x015d
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r6 != r1) goto L_0x0177
        L_0x015d:
            androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 r7 = new androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
            r20 = r2
            r18 = r3
            r19 = r5
            r17 = r9
            r16 = r12
            r12 = r13
            r13 = r14
            r14 = r21
            r9 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r6 = r7
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r0.updateRememberedValue(r6)
        L_0x0177:
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0185
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0185:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerMeasurePolicyKt.m1099rememberPagerMeasurePolicy8u0NR3k(kotlin.jvm.functions.Function0, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):kotlin.jvm.functions.Function2");
    }
}
