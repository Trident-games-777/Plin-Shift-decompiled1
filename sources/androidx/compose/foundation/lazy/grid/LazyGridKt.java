package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u0018\u001a~\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\u0002\b\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyGrid(androidx.compose.ui.Modifier r25, androidx.compose.foundation.lazy.grid.LazyGridState r26, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider r27, androidx.compose.foundation.layout.PaddingValues r28, boolean r29, boolean r30, androidx.compose.foundation.gestures.FlingBehavior r31, boolean r32, androidx.compose.foundation.layout.Arrangement.Vertical r33, androidx.compose.foundation.layout.Arrangement.Horizontal r34, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38, int r39) {
        /*
            r1 = r26
            r2 = r27
            r5 = r30
            r12 = r35
            r13 = r37
            r14 = r39
            r0 = -649686062(0xffffffffd94693d2, float:-3.49341097E15)
            r3 = r36
            androidx.compose.runtime.Composer r7 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(LazyGrid)P(5,8,7,1,6,4,2,9,10,3)68@3233L15,78@3657L50,80@3733L51,82@3811L24,83@3883L7,84@3915L269,102@4422L278,110@4770L48,113@4981L7,109@4714L376,118@5151L317,98@4277L1324:LazyGrid.kt#7791vq"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            r3 = r14 & 1
            if (r3 == 0) goto L_0x0024
            r8 = r13 | 6
            r9 = r8
            r8 = r25
            goto L_0x0038
        L_0x0024:
            r8 = r13 & 6
            if (r8 != 0) goto L_0x0035
            r8 = r25
            boolean r9 = r7.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0032
            r9 = 4
            goto L_0x0033
        L_0x0032:
            r9 = 2
        L_0x0033:
            r9 = r9 | r13
            goto L_0x0038
        L_0x0035:
            r8 = r25
            r9 = r13
        L_0x0038:
            r10 = r14 & 2
            if (r10 == 0) goto L_0x003f
            r9 = r9 | 48
            goto L_0x004f
        L_0x003f:
            r10 = r13 & 48
            if (r10 != 0) goto L_0x004f
            boolean r10 = r7.changed((java.lang.Object) r1)
            if (r10 == 0) goto L_0x004c
            r10 = 32
            goto L_0x004e
        L_0x004c:
            r10 = 16
        L_0x004e:
            r9 = r9 | r10
        L_0x004f:
            r10 = r14 & 4
            if (r10 == 0) goto L_0x0056
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x006f
        L_0x0056:
            r10 = r13 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x006f
            r10 = r13 & 512(0x200, float:7.175E-43)
            if (r10 != 0) goto L_0x0063
            boolean r10 = r7.changed((java.lang.Object) r2)
            goto L_0x0067
        L_0x0063:
            boolean r10 = r7.changedInstance(r2)
        L_0x0067:
            if (r10 == 0) goto L_0x006c
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r10 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r9 = r9 | r10
        L_0x006f:
            r10 = r14 & 8
            if (r10 == 0) goto L_0x0076
            r9 = r9 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r11 = r13 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0089
            r11 = r28
            boolean r15 = r7.changed((java.lang.Object) r11)
            if (r15 == 0) goto L_0x0085
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r15 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r9 = r9 | r15
            goto L_0x008b
        L_0x0089:
            r11 = r28
        L_0x008b:
            r15 = r14 & 16
            if (r15 == 0) goto L_0x0092
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a6
        L_0x0092:
            r4 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r4 != 0) goto L_0x00a6
            r4 = r29
            boolean r16 = r7.changed((boolean) r4)
            if (r16 == 0) goto L_0x00a1
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r9 = r9 | r16
            goto L_0x00a8
        L_0x00a6:
            r4 = r29
        L_0x00a8:
            r16 = r14 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00b1
            r9 = r9 | r17
            goto L_0x00c2
        L_0x00b1:
            r16 = r13 & r17
            if (r16 != 0) goto L_0x00c2
            boolean r16 = r7.changed((boolean) r5)
            if (r16 == 0) goto L_0x00be
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r9 = r9 | r16
        L_0x00c2:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00dc
            r16 = r14 & 64
            r0 = r31
            if (r16 != 0) goto L_0x00d7
            boolean r17 = r7.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00d7
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r9 = r9 | r17
            goto L_0x00de
        L_0x00dc:
            r0 = r31
        L_0x00de:
            r6 = r14 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r6 == 0) goto L_0x00e7
            r9 = r9 | r18
            goto L_0x00fb
        L_0x00e7:
            r6 = r13 & r18
            if (r6 != 0) goto L_0x00fb
            r6 = r32
            boolean r18 = r7.changed((boolean) r6)
            if (r18 == 0) goto L_0x00f6
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f8
        L_0x00f6:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f8:
            r9 = r9 | r18
            goto L_0x00fd
        L_0x00fb:
            r6 = r32
        L_0x00fd:
            r0 = r14 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0106
            r9 = r9 | r18
            goto L_0x011a
        L_0x0106:
            r0 = r13 & r18
            if (r0 != 0) goto L_0x011a
            r0 = r33
            boolean r18 = r7.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x0115
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r9 = r9 | r18
            goto L_0x011c
        L_0x011a:
            r0 = r33
        L_0x011c:
            r0 = r14 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0125
            r9 = r9 | r18
            goto L_0x0139
        L_0x0125:
            r0 = r13 & r18
            if (r0 != 0) goto L_0x0139
            r0 = r34
            boolean r18 = r7.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x0134
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0136
        L_0x0134:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0136:
            r9 = r9 | r18
            goto L_0x013b
        L_0x0139:
            r0 = r34
        L_0x013b:
            r0 = r14 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0142
            r0 = r38 | 6
            goto L_0x0154
        L_0x0142:
            r0 = r38 & 6
            if (r0 != 0) goto L_0x0152
            boolean r0 = r7.changedInstance(r12)
            if (r0 == 0) goto L_0x014e
            r0 = 4
            goto L_0x014f
        L_0x014e:
            r0 = 2
        L_0x014f:
            r0 = r38 | r0
            goto L_0x0154
        L_0x0152:
            r0 = r38
        L_0x0154:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r2 = r9 & r18
            r36 = r3
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r3) goto L_0x0178
            r2 = r0 & 3
            r3 = 2
            if (r2 != r3) goto L_0x0178
            boolean r2 = r7.getSkipping()
            if (r2 != 0) goto L_0x016c
            goto L_0x0178
        L_0x016c:
            r7.skipToGroupEnd()
            r0 = r1
            r5 = r4
            r1 = r8
            r4 = r11
            r8 = r7
            r7 = r31
            goto L_0x0335
        L_0x0178:
            r7.startDefaults()
            r2 = r13 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0199
            boolean r2 = r7.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0187
            goto L_0x0199
        L_0x0187:
            r7.skipToGroupEnd()
            r2 = r14 & 64
            if (r2 == 0) goto L_0x0192
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r9 = r9 & r2
        L_0x0192:
            r17 = r31
            r15 = r8
            r2 = r9
            r8 = r3
            r3 = r11
            goto L_0x01cf
        L_0x0199:
            if (r36 == 0) goto L_0x01a0
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01a1
        L_0x01a0:
            r2 = r8
        L_0x01a1:
            if (r10 == 0) goto L_0x01ae
            r8 = 0
            float r8 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r8)
            androidx.compose.foundation.layout.PaddingValues r8 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r8)
            goto L_0x01af
        L_0x01ae:
            r8 = r11
        L_0x01af:
            if (r15 == 0) goto L_0x01b2
            r4 = 0
        L_0x01b2:
            r10 = r14 & 64
            if (r10 == 0) goto L_0x01c8
            androidx.compose.foundation.gestures.ScrollableDefaults r10 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.gestures.FlingBehavior r10 = r10.flingBehavior(r7, r3)
            r11 = -3670017(0xffffffffffc7ffff, float:NaN)
            r9 = r9 & r11
            r15 = r8
            r8 = r3
            r3 = r15
            r15 = r2
            r2 = r9
            r17 = r10
            goto L_0x01cf
        L_0x01c8:
            r15 = r8
            r8 = r3
            r3 = r15
            r17 = r31
            r15 = r2
            r2 = r9
        L_0x01cf:
            r7.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01e0
            java.lang.String r9 = "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:77)"
            r10 = -649686062(0xffffffffd94693d2, float:-3.49341097E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r2, r0, r9)
        L_0x01e0:
            int r9 = r2 >> 3
            r10 = r9 & 14
            int r0 = r0 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r10
            kotlin.jvm.functions.Function0 r0 = androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(r1, r12, r7, r0)
            int r16 = r2 >> 9
            r11 = r16 & 112(0x70, float:1.57E-43)
            r11 = r11 | r10
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r18 = androidx.compose.foundation.lazy.grid.LazySemanticsKt.rememberLazyGridSemanticState(r1, r4, r7, r11)
            r11 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r8 = "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r11, r8)
            r8 = -954367824(0xffffffffc71d80b0, float:-40320.688)
            java.lang.String r11 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r8, r11)
            java.lang.Object r8 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r8 != r11) goto L_0x0223
            kotlin.coroutines.EmptyCoroutineContext r8 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            kotlinx.coroutines.CoroutineScope r8 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r8, r7)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r11 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r11.<init>(r8)
            r7.updateRememberedValue(r11)
            r8 = r11
        L_0x0223:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r8 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            kotlinx.coroutines.CoroutineScope r8 = r8.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalGraphicsContext()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r28 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r1)
            java.lang.Object r0 = r7.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.graphics.GraphicsContext r0 = (androidx.compose.ui.graphics.GraphicsContext) r0
            r19 = r2 & 112(0x70, float:1.57E-43)
            r1 = 57344(0xe000, float:8.0356E-41)
            r20 = r2 & r1
            r1 = 524272(0x7fff0, float:7.34662E-40)
            r1 = r1 & r2
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r16 & r11
            r1 = r1 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r11 = r11 & r9
            r11 = r11 | r1
            r1 = r26
            r6 = r34
            r21 = r2
            r12 = r9
            r13 = r10
            r22 = 6
            r2 = r27
            r9 = r0
            r10 = r7
            r0 = r28
            r7 = r33
            kotlin.jvm.functions.Function2 r23 = rememberLazyGridMeasurePolicy(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r5 = r1
            r1 = r0
            r0 = r5
            r24 = r3
            r5 = r10
            if (r30 == 0) goto L_0x027d
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x027f
        L_0x027d:
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x027f:
            r3 = r2
            androidx.compose.ui.layout.RemeasurementModifier r2 = r0.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = r15.then(r2)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r6 = r0.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Modifier r2 = r2.then(r6)
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r16 & r6
            int r7 = r21 << 3
            r8 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r8
            r8 = r6 | r7
            r6 = r2
            r2 = r1
            r1 = r6
            r6 = r4
            r7 = r5
            r5 = r32
            r4 = r3
            r3 = r18
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r1, r2, r3, r4, r5, r6, r7, r8)
            r16 = r2
            r3 = r4
            r4 = r6
            r5 = r7
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r2 = androidx.compose.foundation.lazy.grid.LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(r0, r5, r13)
            r6 = r3
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo r3 = r0.getBeyondBoundsInfo$foundation_release()
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r8, r9)
            java.lang.Object r7 = r5.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            int r8 = androidx.compose.runtime.collection.MutableVector.$stable
            int r8 = r8 << 6
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r12
            r9 = r9 | r8
            r8 = r5
            r5 = r7
            r7 = r32
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r6
            r5 = r8
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r2 = r0.getItemAnimator$foundation_release()
            androidx.compose.ui.Modifier r2 = r2.getModifier()
            androidx.compose.ui.Modifier r1 = r1.then(r2)
            r2 = r0
            androidx.compose.foundation.gestures.ScrollableState r2 = (androidx.compose.foundation.gestures.ScrollableState) r2
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r0.getInternalInteractionSource$foundation_release()
            int r6 = r21 >> 12
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r6 = r19 | r6
            r6 = r6 | r20
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r12
            r10 = r6 | r8
            r11 = 64
            r8 = 0
            r9 = r5
            r6 = r17
            r5 = r4
            r4 = r32
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ScrollingContainerKt.scrollingContainer(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r8 = r5
            r10 = r6
            r5 = r9
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r0.getPrefetchState$foundation_release()
            r6 = 0
            r7 = 0
            r1 = r16
            r4 = r23
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x032e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x032e:
            r1 = r8
            r8 = r5
            r5 = r1
            r7 = r10
            r1 = r15
            r4 = r24
        L_0x0335:
            androidx.compose.runtime.ScopeUpdateScope r15 = r8.endRestartGroup()
            if (r15 == 0) goto L_0x0357
            androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1 r0 = new androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1
            r2 = r26
            r3 = r27
            r6 = r30
            r8 = r32
            r9 = r33
            r10 = r34
            r11 = r35
            r12 = r37
            r13 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0357:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0093, code lost:
        if (r0.changed(r3) == false) goto L_0x0098;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> rememberLazyGridMeasurePolicy(kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.grid.LazyGridItemProvider> r17, androidx.compose.foundation.lazy.grid.LazyGridState r18, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider r19, androidx.compose.foundation.layout.PaddingValues r20, boolean r21, boolean r22, androidx.compose.foundation.layout.Arrangement.Horizontal r23, androidx.compose.foundation.layout.Arrangement.Vertical r24, kotlinx.coroutines.CoroutineScope r25, androidx.compose.ui.graphics.GraphicsContext r26, androidx.compose.runtime.Composer r27, int r28) {
        /*
            r0 = r27
            r1 = r28
            java.lang.String r2 = "C(rememberLazyGridMeasurePolicy)P(5,8,7!1,6,4,3,9)161@6721L9334:LazyGrid.kt#7791vq"
            r3 = -1585069765(0xffffffffa185c13b, float:-9.063578E-19)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r2)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0018
            r2 = -1
            java.lang.String r4 = "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:161)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r2, r4)
        L_0x0018:
            r2 = 1026581015(0x3d306217, float:0.043062296)
            java.lang.String r3 = "CC(remember):LazyGrid.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r3)
            r2 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 ^ 48
            r3 = 32
            r4 = 0
            r5 = 1
            r7 = r18
            if (r2 <= r3) goto L_0x0032
            boolean r2 = r0.changed((java.lang.Object) r7)
            if (r2 != 0) goto L_0x0036
        L_0x0032:
            r2 = r1 & 48
            if (r2 != r3) goto L_0x0038
        L_0x0036:
            r2 = r5
            goto L_0x0039
        L_0x0038:
            r2 = r4
        L_0x0039:
            r3 = r1 & 896(0x380, float:1.256E-42)
            r3 = r3 ^ 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            r12 = r19
            if (r3 <= r6) goto L_0x0049
            boolean r3 = r0.changed((java.lang.Object) r12)
            if (r3 != 0) goto L_0x004d
        L_0x0049:
            r3 = r1 & 384(0x180, float:5.38E-43)
            if (r3 != r6) goto L_0x004f
        L_0x004d:
            r3 = r5
            goto L_0x0050
        L_0x004f:
            r3 = r4
        L_0x0050:
            r2 = r2 | r3
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 ^ 3072(0xc00, float:4.305E-42)
            r6 = 2048(0x800, float:2.87E-42)
            r9 = r20
            if (r3 <= r6) goto L_0x0061
            boolean r3 = r0.changed((java.lang.Object) r9)
            if (r3 != 0) goto L_0x0065
        L_0x0061:
            r3 = r1 & 3072(0xc00, float:4.305E-42)
            if (r3 != r6) goto L_0x0067
        L_0x0065:
            r3 = r5
            goto L_0x0068
        L_0x0067:
            r3 = r4
        L_0x0068:
            r2 = r2 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r1
            r3 = r3 ^ 24576(0x6000, float:3.4438E-41)
            r6 = 16384(0x4000, float:2.2959E-41)
            r10 = r21
            if (r3 <= r6) goto L_0x007b
            boolean r3 = r0.changed((boolean) r10)
            if (r3 != 0) goto L_0x007f
        L_0x007b:
            r3 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r3 != r6) goto L_0x0081
        L_0x007f:
            r3 = r5
            goto L_0x0082
        L_0x0081:
            r3 = r4
        L_0x0082:
            r2 = r2 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r1
            r6 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 ^ r6
            r8 = 131072(0x20000, float:1.83671E-40)
            if (r3 <= r8) goto L_0x0096
            r3 = r22
            boolean r11 = r0.changed((boolean) r3)
            if (r11 != 0) goto L_0x009b
            goto L_0x0098
        L_0x0096:
            r3 = r22
        L_0x0098:
            r6 = r6 & r1
            if (r6 != r8) goto L_0x009d
        L_0x009b:
            r6 = r5
            goto L_0x009e
        L_0x009d:
            r6 = r4
        L_0x009e:
            r2 = r2 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r1
            r8 = 1572864(0x180000, float:2.204052E-39)
            r6 = r6 ^ r8
            r11 = 1048576(0x100000, float:1.469368E-39)
            r14 = r23
            if (r6 <= r11) goto L_0x00b1
            boolean r6 = r0.changed((java.lang.Object) r14)
            if (r6 != 0) goto L_0x00b5
        L_0x00b1:
            r6 = r1 & r8
            if (r6 != r11) goto L_0x00b7
        L_0x00b5:
            r6 = r5
            goto L_0x00b8
        L_0x00b7:
            r6 = r4
        L_0x00b8:
            r2 = r2 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r1
            r8 = 12582912(0xc00000, float:1.7632415E-38)
            r6 = r6 ^ r8
            r11 = 8388608(0x800000, float:1.17549435E-38)
            r13 = r24
            if (r6 <= r11) goto L_0x00cb
            boolean r6 = r0.changed((java.lang.Object) r13)
            if (r6 != 0) goto L_0x00ce
        L_0x00cb:
            r1 = r1 & r8
            if (r1 != r11) goto L_0x00cf
        L_0x00ce:
            r4 = r5
        L_0x00cf:
            r1 = r2 | r4
            r2 = r26
            boolean r4 = r0.changed((java.lang.Object) r2)
            r1 = r1 | r4
            java.lang.Object r4 = r0.rememberedValue()
            if (r1 != 0) goto L_0x00e6
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r4 != r1) goto L_0x00f8
        L_0x00e6:
            androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1 r6 = new androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
            r11 = r17
            r15 = r25
            r16 = r2
            r8 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r4 = r6
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.updateRememberedValue(r4)
        L_0x00f8:
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0106
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0106:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.rememberLazyGridMeasurePolicy(kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, kotlinx.coroutines.CoroutineScope, androidx.compose.ui.graphics.GraphicsContext, androidx.compose.runtime.Composer, int):kotlin.jvm.functions.Function2");
    }
}
