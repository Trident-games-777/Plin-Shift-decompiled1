package androidx.compose.foundation.lazy;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u0001\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e¢\u0006\u0002\b\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tH\u0003¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyHeadersEnabled", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;ZLandroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
public final class LazyListKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyList(androidx.compose.ui.Modifier r27, androidx.compose.foundation.lazy.LazyListState r28, androidx.compose.foundation.layout.PaddingValues r29, boolean r30, boolean r31, androidx.compose.foundation.gestures.FlingBehavior r32, boolean r33, int r34, androidx.compose.ui.Alignment.Horizontal r35, androidx.compose.foundation.layout.Arrangement.Vertical r36, androidx.compose.ui.Alignment.Vertical r37, androidx.compose.foundation.layout.Arrangement.Horizontal r38, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42, int r43) {
        /*
            r1 = r27
            r2 = r28
            r5 = r31
            r0 = r39
            r3 = r41
            r4 = r42
            r6 = r43
            r7 = 620764179(0x25001c13, float:1.1111742E-16)
            r8 = r40
            androidx.compose.runtime.Composer r15 = r8.startRestartGroup(r7)
            java.lang.String r8 = "C(LazyList)P(7,9,2,8,6,3,10!1,4,12,11,5)81@3859L50,83@3935L48,84@4009L24,85@4081L7,86@4150L7,88@4183L395,109@4816L278,117@5164L153,123@5480L7,116@5108L481,128@5650L317,105@4671L1429:LazyList.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r8)
            r8 = r6 & 1
            if (r8 == 0) goto L_0x0023
            r8 = r3 | 6
            goto L_0x0033
        L_0x0023:
            r8 = r3 & 6
            if (r8 != 0) goto L_0x0032
            boolean r8 = r15.changed((java.lang.Object) r1)
            if (r8 == 0) goto L_0x002f
            r8 = 4
            goto L_0x0030
        L_0x002f:
            r8 = 2
        L_0x0030:
            r8 = r8 | r3
            goto L_0x0033
        L_0x0032:
            r8 = r3
        L_0x0033:
            r11 = r6 & 2
            if (r11 == 0) goto L_0x003a
            r8 = r8 | 48
            goto L_0x004a
        L_0x003a:
            r11 = r3 & 48
            if (r11 != 0) goto L_0x004a
            boolean r11 = r15.changed((java.lang.Object) r2)
            if (r11 == 0) goto L_0x0047
            r11 = 32
            goto L_0x0049
        L_0x0047:
            r11 = 16
        L_0x0049:
            r8 = r8 | r11
        L_0x004a:
            r11 = r6 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0053
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0053:
            r11 = r3 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0067
            r11 = r29
            boolean r17 = r15.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x0062
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r17 = r16
        L_0x0064:
            r8 = r8 | r17
            goto L_0x0069
        L_0x0067:
            r11 = r29
        L_0x0069:
            r17 = r6 & 8
            if (r17 == 0) goto L_0x0070
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0070:
            r9 = r3 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0084
            r9 = r30
            boolean r17 = r15.changed((boolean) r9)
            if (r17 == 0) goto L_0x007f
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r8 = r8 | r17
            goto L_0x0086
        L_0x0084:
            r9 = r30
        L_0x0086:
            r17 = r6 & 16
            if (r17 == 0) goto L_0x008d
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x008d:
            r10 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009d
            boolean r10 = r15.changed((boolean) r5)
            if (r10 == 0) goto L_0x009a
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r8 = r8 | r10
        L_0x009d:
            r10 = r6 & 32
            r18 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a6
            r8 = r8 | r18
            goto L_0x00ba
        L_0x00a6:
            r10 = r3 & r18
            if (r10 != 0) goto L_0x00ba
            r10 = r32
            boolean r18 = r15.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00b5
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r8 = r8 | r18
            goto L_0x00bc
        L_0x00ba:
            r10 = r32
        L_0x00bc:
            r18 = r6 & 64
            if (r18 == 0) goto L_0x00c7
            r18 = 1572864(0x180000, float:2.204052E-39)
            r8 = r8 | r18
            r7 = r33
            goto L_0x00dc
        L_0x00c7:
            r18 = 1572864(0x180000, float:2.204052E-39)
            r18 = r3 & r18
            r7 = r33
            if (r18 != 0) goto L_0x00dc
            boolean r19 = r15.changed((boolean) r7)
            if (r19 == 0) goto L_0x00d8
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r8 = r8 | r19
        L_0x00dc:
            r12 = r6 & 128(0x80, float:1.794E-43)
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            if (r12 == 0) goto L_0x00e7
            r8 = r8 | r20
            r13 = r34
            goto L_0x00fa
        L_0x00e7:
            r20 = r3 & r20
            r13 = r34
            if (r20 != 0) goto L_0x00fa
            boolean r21 = r15.changed((int) r13)
            if (r21 == 0) goto L_0x00f6
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f8
        L_0x00f6:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f8:
            r8 = r8 | r21
        L_0x00fa:
            r14 = r6 & 256(0x100, float:3.59E-43)
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            if (r14 == 0) goto L_0x0105
            r8 = r8 | r22
            r3 = r35
            goto L_0x0118
        L_0x0105:
            r22 = r3 & r22
            r3 = r35
            if (r22 != 0) goto L_0x0118
            boolean r22 = r15.changed((java.lang.Object) r3)
            if (r22 == 0) goto L_0x0114
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0116
        L_0x0114:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0116:
            r8 = r8 | r22
        L_0x0118:
            r3 = r6 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r3 == 0) goto L_0x0121
            r8 = r8 | r22
            goto L_0x0137
        L_0x0121:
            r22 = r41 & r22
            if (r22 != 0) goto L_0x0137
            r22 = r3
            r3 = r36
            boolean r23 = r15.changed((java.lang.Object) r3)
            if (r23 == 0) goto L_0x0132
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0134
        L_0x0132:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0134:
            r8 = r8 | r23
            goto L_0x013b
        L_0x0137:
            r22 = r3
            r3 = r36
        L_0x013b:
            r3 = r6 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0146
            r17 = r4 | 6
            r23 = r3
            r3 = r37
            goto L_0x0162
        L_0x0146:
            r23 = r4 & 6
            if (r23 != 0) goto L_0x015c
            r23 = r3
            r3 = r37
            boolean r24 = r15.changed((java.lang.Object) r3)
            if (r24 == 0) goto L_0x0157
            r17 = 4
            goto L_0x0159
        L_0x0157:
            r17 = 2
        L_0x0159:
            r17 = r4 | r17
            goto L_0x0162
        L_0x015c:
            r23 = r3
            r3 = r37
            r17 = r4
        L_0x0162:
            r3 = r6 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x016b
            r17 = r17 | 48
            r24 = r3
            goto L_0x0185
        L_0x016b:
            r24 = r4 & 48
            if (r24 != 0) goto L_0x0181
            r24 = r3
            r3 = r38
            boolean r25 = r15.changed((java.lang.Object) r3)
            if (r25 == 0) goto L_0x017c
            r19 = 32
            goto L_0x017e
        L_0x017c:
            r19 = 16
        L_0x017e:
            r17 = r17 | r19
            goto L_0x0185
        L_0x0181:
            r24 = r3
            r3 = r38
        L_0x0185:
            r3 = r17
            r7 = r6 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x018e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x019c
        L_0x018e:
            r7 = r4 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x019c
            boolean r7 = r15.changedInstance(r0)
            if (r7 == 0) goto L_0x019a
            r16 = 256(0x100, float:3.59E-43)
        L_0x019a:
            r3 = r3 | r16
        L_0x019c:
            r7 = 306783379(0x12492493, float:6.34695E-28)
            r7 = r7 & r8
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r4) goto L_0x01c0
            r4 = r3 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r4 != r7) goto L_0x01c0
            boolean r4 = r15.getSkipping()
            if (r4 != 0) goto L_0x01b2
            goto L_0x01c0
        L_0x01b2:
            r15.skipToGroupEnd()
            r9 = r35
            r10 = r36
            r11 = r37
            r12 = r38
            r8 = r13
            goto L_0x0383
        L_0x01c0:
            if (r12 == 0) goto L_0x01c5
            r4 = 0
            r7 = r4
            goto L_0x01c6
        L_0x01c5:
            r7 = r13
        L_0x01c6:
            r4 = 0
            if (r14 == 0) goto L_0x01cb
            r12 = r4
            goto L_0x01cd
        L_0x01cb:
            r12 = r35
        L_0x01cd:
            if (r22 == 0) goto L_0x01d1
            r13 = r4
            goto L_0x01d3
        L_0x01d1:
            r13 = r36
        L_0x01d3:
            if (r23 == 0) goto L_0x01d7
            r14 = r4
            goto L_0x01d9
        L_0x01d7:
            r14 = r37
        L_0x01d9:
            if (r24 == 0) goto L_0x01dc
            goto L_0x01de
        L_0x01dc:
            r4 = r38
        L_0x01de:
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r34 = r4
            if (r16 == 0) goto L_0x01ee
            java.lang.String r4 = "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)"
            r6 = 620764179(0x25001c13, float:1.1111742E-16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r8, r3, r4)
        L_0x01ee:
            int r4 = r8 >> 3
            r18 = r4 & 14
            int r4 = r3 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r18 | r4
            kotlin.jvm.functions.Function0 r4 = androidx.compose.foundation.lazy.LazyListItemProviderKt.rememberLazyListItemProviderLambda(r2, r0, r15, r4)
            int r6 = r8 >> 9
            r16 = r6 & 112(0x70, float:1.57E-43)
            r0 = r18 | r16
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r0 = androidx.compose.foundation.lazy.LazyListSemanticsKt.rememberLazyListSemanticState(r2, r5, r15, r0)
            r35 = r0
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r2 = "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r2)
            r0 = -954367824(0xffffffffc71d80b0, float:-40320.688)
            java.lang.String r2 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r2)
            java.lang.Object r0 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x0235
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r15)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r0)
            r15.updateRememberedValue(r2)
            r0 = r2
        L_0x0235:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            kotlinx.coroutines.CoroutineScope r0 = r0.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalGraphicsContext()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r36 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r1)
            java.lang.Object r2 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.graphics.GraphicsContext r2 = (androidx.compose.ui.graphics.GraphicsContext) r2
            r37 = r2
            androidx.compose.runtime.CompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalScrollCaptureInProgress()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r1)
            java.lang.Object r2 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r2 = r2 ^ 1
            r19 = r8 & 112(0x70, float:1.57E-43)
            r0 = r8 & 7168(0x1c00, float:1.0045E-41)
            r16 = 65520(0xfff0, float:9.1813E-41)
            r16 = r8 & r16
            int r20 = r8 >> 6
            r21 = 458752(0x70000, float:6.42848E-40)
            r17 = r20 & r21
            r16 = r16 | r17
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r20 & r17
            r16 = r16 | r17
            int r3 = r3 << 21
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r3 & r17
            r16 = r16 | r17
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r17
            r3 = r16 | r3
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r16 = r8 & r16
            r16 = r3 | r16
            r17 = 0
            r3 = r28
            r10 = r34
            r23 = r0
            r0 = r6
            r22 = r8
            r8 = r12
            r12 = r36
            r6 = r5
            r5 = r9
            r9 = r14
            r14 = r2
            r2 = r4
            r4 = r11
            r11 = r13
            r13 = r37
            kotlin.jvm.functions.Function2 r24 = rememberLazyListMeasurePolicy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r4 = r8
            r5 = r10
            r6 = r11
            r8 = r2
            r2 = r3
            r3 = r9
            if (r31 == 0) goto L_0x02c3
            androidx.compose.foundation.gestures.Orientation r9 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x02c5
        L_0x02c3:
            androidx.compose.foundation.gestures.Orientation r9 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x02c5:
            r10 = r9
            androidx.compose.ui.layout.RemeasurementModifier r9 = r2.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r11 = r27
            androidx.compose.ui.Modifier r9 = r11.then(r9)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r12 = r2.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            androidx.compose.ui.Modifier r9 = r9.then(r12)
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r20 & r12
            int r13 = r22 << 6
            r13 = r13 & r21
            r12 = r12 | r13
            r11 = r9
            r9 = r8
            r8 = r11
            r13 = r30
            r11 = r10
            r14 = r15
            r10 = r35
            r15 = r12
            r12 = r33
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r8, r9, r10, r11, r12, r13, r14, r15)
            r20 = r9
            r10 = r11
            r15 = r14
            int r9 = r22 >> 18
            r9 = r9 & 112(0x70, float:1.57E-43)
            r9 = r18 | r9
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r9 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(r2, r7, r15, r9)
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo r10 = r2.getBeyondBoundsInfo$foundation_release()
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r13, r1)
            java.lang.Object r1 = r15.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r12 = r1
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            int r1 = androidx.compose.runtime.collection.MutableVector.$stable
            int r1 = r1 << 6
            r1 = r1 | r23
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r22 & r13
            r16 = r1 | r13
            r14 = r33
            r13 = r11
            r11 = r30
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r10 = r13
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r8 = r2.getItemAnimator$foundation_release()
            androidx.compose.ui.Modifier r8 = r8.getModifier()
            androidx.compose.ui.Modifier r8 = r1.then(r8)
            r9 = r2
            androidx.compose.foundation.gestures.ScrollableState r9 = (androidx.compose.foundation.gestures.ScrollableState) r9
            androidx.compose.foundation.interaction.MutableInteractionSource r14 = r2.getInternalInteractionSource$foundation_release()
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r19 | r0
            r1 = 57344(0xe000, float:8.0356E-41)
            int r11 = r22 << 3
            r1 = r1 & r11
            r0 = r0 | r1
            r1 = r22 & r21
            r17 = r0 | r1
            r18 = 64
            r16 = r15
            r15 = 0
            r12 = r30
            r13 = r32
            r11 = r33
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.ScrollingContainerKt.scrollingContainer(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r15 = r16
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r10 = r2.getPrefetchState$foundation_release()
            r13 = 0
            r14 = 0
            r12 = r15
            r8 = r20
            r11 = r24
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r8, (androidx.compose.ui.Modifier) r9, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r10, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r11, (androidx.compose.runtime.Composer) r12, (int) r13, (int) r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x037e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x037e:
            r11 = r3
            r9 = r4
            r12 = r5
            r10 = r6
            r8 = r7
        L_0x0383:
            androidx.compose.runtime.ScopeUpdateScope r0 = r15.endRestartGroup()
            if (r0 == 0) goto L_0x03ac
            r1 = r0
            androidx.compose.foundation.lazy.LazyListKt$LazyList$1 r0 = new androidx.compose.foundation.lazy.LazyListKt$LazyList$1
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r13 = r39
            r14 = r41
            r15 = r42
            r16 = r43
            r26 = r1
            r1 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r26
            r1.updateScope(r0)
        L_0x03ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, int, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (r0.changed(r4) == false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0096, code lost:
        if (r0.changed((java.lang.Object) r9) == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b2, code lost:
        if (r0.changed((java.lang.Object) r12) == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ce, code lost:
        if (r0.changed((java.lang.Object) r13) == false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ea, code lost:
        if (r0.changed((java.lang.Object) r14) == false) goto L_0x00ef;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> rememberLazyListMeasurePolicy(kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.LazyListItemProvider> r21, androidx.compose.foundation.lazy.LazyListState r22, androidx.compose.foundation.layout.PaddingValues r23, boolean r24, boolean r25, int r26, androidx.compose.ui.Alignment.Horizontal r27, androidx.compose.ui.Alignment.Vertical r28, androidx.compose.foundation.layout.Arrangement.Horizontal r29, androidx.compose.foundation.layout.Arrangement.Vertical r30, kotlinx.coroutines.CoroutineScope r31, androidx.compose.ui.graphics.GraphicsContext r32, boolean r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r0 = r34
            r1 = r35
            r2 = r36
            java.lang.String r3 = "C(rememberLazyListMeasurePolicy)P(7,9,1,8,6!1,4,11,5,12)170@7305L8413:LazyList.kt#428nma"
            r4 = 1972347046(0x758fa0a6, float:3.6413906E32)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0019
            java.lang.String r3 = "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:170)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x0019:
            r3 = 581121742(0x22a336ce, float:4.4239265E-18)
            java.lang.String r4 = "CC(remember):LazyList.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r4)
            r3 = r1 & 112(0x70, float:1.57E-43)
            r3 = r3 ^ 48
            r4 = 32
            r6 = 1
            r8 = r22
            if (r3 <= r4) goto L_0x0032
            boolean r3 = r0.changed((java.lang.Object) r8)
            if (r3 != 0) goto L_0x0036
        L_0x0032:
            r3 = r1 & 48
            if (r3 != r4) goto L_0x0038
        L_0x0036:
            r3 = r6
            goto L_0x0039
        L_0x0038:
            r3 = 0
        L_0x0039:
            r4 = r1 & 896(0x380, float:1.256E-42)
            r4 = r4 ^ 384(0x180, float:5.38E-43)
            r7 = 256(0x100, float:3.59E-43)
            r10 = r23
            if (r4 <= r7) goto L_0x0049
            boolean r4 = r0.changed((java.lang.Object) r10)
            if (r4 != 0) goto L_0x004d
        L_0x0049:
            r4 = r1 & 384(0x180, float:5.38E-43)
            if (r4 != r7) goto L_0x004f
        L_0x004d:
            r4 = r6
            goto L_0x0050
        L_0x004f:
            r4 = 0
        L_0x0050:
            r3 = r3 | r4
            r4 = r1 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 ^ 3072(0xc00, float:4.305E-42)
            r9 = 2048(0x800, float:2.87E-42)
            r11 = r24
            if (r4 <= r9) goto L_0x0061
            boolean r4 = r0.changed((boolean) r11)
            if (r4 != 0) goto L_0x0065
        L_0x0061:
            r4 = r1 & 3072(0xc00, float:4.305E-42)
            if (r4 != r9) goto L_0x0067
        L_0x0065:
            r4 = r6
            goto L_0x0068
        L_0x0067:
            r4 = 0
        L_0x0068:
            r3 = r3 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r1
            r4 = r4 ^ 24576(0x6000, float:3.4438E-41)
            r9 = 16384(0x4000, float:2.2959E-41)
            if (r4 <= r9) goto L_0x007c
            r4 = r25
            boolean r12 = r0.changed((boolean) r4)
            if (r12 != 0) goto L_0x0082
            goto L_0x007e
        L_0x007c:
            r4 = r25
        L_0x007e:
            r12 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r12 != r9) goto L_0x0084
        L_0x0082:
            r9 = r6
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            r3 = r3 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r1
            r12 = 1572864(0x180000, float:2.204052E-39)
            r9 = r9 ^ r12
            r13 = 1048576(0x100000, float:1.469368E-39)
            if (r9 <= r13) goto L_0x0099
            r9 = r27
            boolean r14 = r0.changed((java.lang.Object) r9)
            if (r14 != 0) goto L_0x009e
            goto L_0x009b
        L_0x0099:
            r9 = r27
        L_0x009b:
            r12 = r12 & r1
            if (r12 != r13) goto L_0x00a0
        L_0x009e:
            r12 = r6
            goto L_0x00a1
        L_0x00a0:
            r12 = 0
        L_0x00a1:
            r3 = r3 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r1
            r13 = 12582912(0xc00000, float:1.7632415E-38)
            r12 = r12 ^ r13
            r14 = 8388608(0x800000, float:1.17549435E-38)
            if (r12 <= r14) goto L_0x00b5
            r12 = r28
            boolean r15 = r0.changed((java.lang.Object) r12)
            if (r15 != 0) goto L_0x00ba
            goto L_0x00b7
        L_0x00b5:
            r12 = r28
        L_0x00b7:
            r13 = r13 & r1
            if (r13 != r14) goto L_0x00bc
        L_0x00ba:
            r13 = r6
            goto L_0x00bd
        L_0x00bc:
            r13 = 0
        L_0x00bd:
            r3 = r3 | r13
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            r13 = r13 & r1
            r14 = 100663296(0x6000000, float:2.4074124E-35)
            r13 = r13 ^ r14
            r15 = 67108864(0x4000000, float:1.5046328E-36)
            if (r13 <= r15) goto L_0x00d1
            r13 = r29
            boolean r16 = r0.changed((java.lang.Object) r13)
            if (r16 != 0) goto L_0x00d6
            goto L_0x00d3
        L_0x00d1:
            r13 = r29
        L_0x00d3:
            r14 = r14 & r1
            if (r14 != r15) goto L_0x00d8
        L_0x00d6:
            r14 = r6
            goto L_0x00d9
        L_0x00d8:
            r14 = 0
        L_0x00d9:
            r3 = r3 | r14
            r14 = 1879048192(0x70000000, float:1.58456325E29)
            r14 = r14 & r1
            r15 = 805306368(0x30000000, float:4.656613E-10)
            r14 = r14 ^ r15
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            if (r14 <= r5) goto L_0x00ed
            r14 = r30
            boolean r17 = r0.changed((java.lang.Object) r14)
            if (r17 != 0) goto L_0x00f2
            goto L_0x00ef
        L_0x00ed:
            r14 = r30
        L_0x00ef:
            r1 = r1 & r15
            if (r1 != r5) goto L_0x00f4
        L_0x00f2:
            r1 = r6
            goto L_0x00f5
        L_0x00f4:
            r1 = 0
        L_0x00f5:
            r1 = r1 | r3
            r3 = r32
            boolean r5 = r0.changed((java.lang.Object) r3)
            r1 = r1 | r5
            r5 = r2 & 896(0x380, float:1.256E-42)
            r5 = r5 ^ 384(0x180, float:5.38E-43)
            r15 = r33
            if (r5 <= r7) goto L_0x010b
            boolean r5 = r0.changed((boolean) r15)
            if (r5 != 0) goto L_0x010f
        L_0x010b:
            r2 = r2 & 384(0x180, float:5.38E-43)
            if (r2 != r7) goto L_0x0111
        L_0x010f:
            r5 = r6
            goto L_0x0112
        L_0x0111:
            r5 = 0
        L_0x0112:
            r1 = r1 | r5
            java.lang.Object r2 = r0.rememberedValue()
            if (r1 != 0) goto L_0x0121
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x013e
        L_0x0121:
            androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1 r7 = new androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
            r16 = r14
            r14 = r13
            r13 = r16
            r16 = r26
            r17 = r31
            r18 = r3
            r19 = r9
            r20 = r12
            r12 = r21
            r9 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r2 = r7
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.updateRememberedValue(r2)
        L_0x013e:
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x014c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x014c:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.rememberLazyListMeasurePolicy(kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, int, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, kotlinx.coroutines.CoroutineScope, androidx.compose.ui.graphics.GraphicsContext, boolean, androidx.compose.runtime.Composer, int, int):kotlin.jvm.functions.Function2");
    }
}
