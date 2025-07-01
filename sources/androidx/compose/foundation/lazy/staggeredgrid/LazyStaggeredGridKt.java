package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-LJWHXA8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZFFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGrid.kt */
public final class LazyStaggeredGridKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    /* renamed from: LazyStaggeredGrid-LJWHXA8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1045LazyStaggeredGridLJWHXA8(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r28, androidx.compose.foundation.gestures.Orientation r29, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider r30, androidx.compose.ui.Modifier r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, androidx.compose.foundation.gestures.FlingBehavior r34, boolean r35, float r36, float r37, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41, int r42) {
        /*
            r1 = r28
            r3 = r30
            r12 = r38
            r13 = r40
            r14 = r42
            r0 = 288295126(0x112f08d6, float:1.3807789E-28)
            r2 = r39
            androidx.compose.runtime.Composer r7 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(LazyStaggeredGrid)P(9,6,8,5,1,7,3,10,4:c#ui.unit.Dp,2:c#ui.unit.Dp)51@2370L15,61@2769L55,62@2850L24,63@2922L7,64@2954L266,76@3245L60,82@3456L278,90@3804L57,93@4024L7,89@3748L385,98@4194L316,78@3311L1332:LazyStaggeredGrid.kt#fzvcnm"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r14 & 1
            if (r2 == 0) goto L_0x001f
            r2 = r13 | 6
            goto L_0x002f
        L_0x001f:
            r2 = r13 & 6
            if (r2 != 0) goto L_0x002e
            boolean r2 = r7.changedInstance(r1)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r2 = r2 | r13
            goto L_0x002f
        L_0x002e:
            r2 = r13
        L_0x002f:
            r6 = r14 & 2
            if (r6 == 0) goto L_0x0036
            r2 = r2 | 48
            goto L_0x0049
        L_0x0036:
            r6 = r13 & 48
            if (r6 != 0) goto L_0x0049
            r6 = r29
            boolean r8 = r7.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0045
            r8 = 32
            goto L_0x0047
        L_0x0045:
            r8 = 16
        L_0x0047:
            r2 = r2 | r8
            goto L_0x004b
        L_0x0049:
            r6 = r29
        L_0x004b:
            r8 = r14 & 4
            if (r8 == 0) goto L_0x0052
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0052:
            r8 = r13 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x006b
            r8 = r13 & 512(0x200, float:7.175E-43)
            if (r8 != 0) goto L_0x005f
            boolean r8 = r7.changed((java.lang.Object) r3)
            goto L_0x0063
        L_0x005f:
            boolean r8 = r7.changedInstance(r3)
        L_0x0063:
            if (r8 == 0) goto L_0x0068
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r2 = r2 | r8
        L_0x006b:
            r8 = r14 & 8
            if (r8 == 0) goto L_0x0072
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0072:
            r9 = r13 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0085
            r9 = r31
            boolean r10 = r7.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0081
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r2 = r2 | r10
            goto L_0x0087
        L_0x0085:
            r9 = r31
        L_0x0087:
            r10 = r14 & 16
            if (r10 == 0) goto L_0x008e
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008e:
            r11 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x00a1
            r11 = r32
            boolean r15 = r7.changed((java.lang.Object) r11)
            if (r15 == 0) goto L_0x009d
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r2 = r2 | r15
            goto L_0x00a3
        L_0x00a1:
            r11 = r32
        L_0x00a3:
            r15 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00ae
            r2 = r2 | r16
            r4 = r33
            goto L_0x00c1
        L_0x00ae:
            r16 = r13 & r16
            r4 = r33
            if (r16 != 0) goto L_0x00c1
            boolean r16 = r7.changed((boolean) r4)
            if (r16 == 0) goto L_0x00bd
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r2 = r2 | r16
        L_0x00c1:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00db
            r16 = r14 & 64
            r0 = r34
            if (r16 != 0) goto L_0x00d6
            boolean r17 = r7.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00d6
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r2 = r2 | r17
            goto L_0x00dd
        L_0x00db:
            r0 = r34
        L_0x00dd:
            r5 = r14 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r5 == 0) goto L_0x00e8
            r2 = r2 | r18
            r0 = r35
            goto L_0x00fb
        L_0x00e8:
            r18 = r13 & r18
            r0 = r35
            if (r18 != 0) goto L_0x00fb
            boolean r18 = r7.changed((boolean) r0)
            if (r18 == 0) goto L_0x00f7
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r2 = r2 | r18
        L_0x00fb:
            r0 = r14 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0104
            r2 = r2 | r18
            goto L_0x011a
        L_0x0104:
            r18 = r13 & r18
            if (r18 != 0) goto L_0x011a
            r18 = r0
            r0 = r36
            boolean r19 = r7.changed((float) r0)
            if (r19 == 0) goto L_0x0115
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r2 = r2 | r19
            goto L_0x011e
        L_0x011a:
            r18 = r0
            r0 = r36
        L_0x011e:
            r0 = r14 & 512(0x200, float:7.175E-43)
            r19 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0127
            r2 = r2 | r19
            goto L_0x013d
        L_0x0127:
            r19 = r13 & r19
            if (r19 != 0) goto L_0x013d
            r19 = r0
            r0 = r37
            boolean r20 = r7.changed((float) r0)
            if (r20 == 0) goto L_0x0138
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013a
        L_0x0138:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013a:
            r2 = r2 | r20
            goto L_0x0141
        L_0x013d:
            r19 = r0
            r0 = r37
        L_0x0141:
            r0 = r14 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0148
            r0 = r41 | 6
            goto L_0x015a
        L_0x0148:
            r0 = r41 & 6
            if (r0 != 0) goto L_0x0158
            boolean r0 = r7.changedInstance(r12)
            if (r0 == 0) goto L_0x0154
            r0 = 4
            goto L_0x0155
        L_0x0154:
            r0 = 2
        L_0x0155:
            r0 = r41 | r0
            goto L_0x015a
        L_0x0158:
            r0 = r41
        L_0x015a:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r39 = r2
            r2 = r39 & r20
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r3) goto L_0x0184
            r2 = r0 & 3
            r3 = 2
            if (r2 != r3) goto L_0x0184
            boolean r2 = r7.getSkipping()
            if (r2 != 0) goto L_0x0172
            goto L_0x0184
        L_0x0172:
            r7.skipToGroupEnd()
            r8 = r35
            r10 = r37
            r0 = r1
            r6 = r4
            r1 = r7
            r4 = r9
            r5 = r11
            r7 = r34
            r9 = r36
            goto L_0x038d
        L_0x0184:
            r7.startDefaults()
            r2 = r13 & 1
            r3 = 6
            if (r2 == 0) goto L_0x01b7
            boolean r2 = r7.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0193
            goto L_0x01b7
        L_0x0193:
            r7.skipToGroupEnd()
            r2 = r14 & 64
            if (r2 == 0) goto L_0x01a9
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r39 & r2
            r17 = r34
            r18 = r35
            r5 = r36
            r6 = r37
            r8 = r2
            goto L_0x01b3
        L_0x01a9:
            r17 = r34
            r18 = r35
            r5 = r36
            r6 = r37
            r8 = r39
        L_0x01b3:
            r15 = r9
            r2 = r11
            goto L_0x0209
        L_0x01b7:
            if (r8 == 0) goto L_0x01be
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01bf
        L_0x01be:
            r2 = r9
        L_0x01bf:
            r8 = 0
            if (r10 == 0) goto L_0x01cc
            float r9 = (float) r8
            float r9 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r9)
            androidx.compose.foundation.layout.PaddingValues r9 = androidx.compose.foundation.layout.PaddingKt.m768PaddingValues0680j_4(r9)
            goto L_0x01cd
        L_0x01cc:
            r9 = r11
        L_0x01cd:
            if (r15 == 0) goto L_0x01d0
            r4 = r8
        L_0x01d0:
            r10 = r14 & 64
            if (r10 == 0) goto L_0x01e0
            androidx.compose.foundation.gestures.ScrollableDefaults r10 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.gestures.FlingBehavior r10 = r10.flingBehavior(r7, r3)
            r11 = -3670017(0xffffffffffc7ffff, float:NaN)
            r11 = r39 & r11
            goto L_0x01e4
        L_0x01e0:
            r10 = r34
            r11 = r39
        L_0x01e4:
            if (r5 == 0) goto L_0x01e8
            r5 = 1
            goto L_0x01ea
        L_0x01e8:
            r5 = r35
        L_0x01ea:
            if (r18 == 0) goto L_0x01f2
            float r15 = (float) r8
            float r15 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r15)
            goto L_0x01f4
        L_0x01f2:
            r15 = r36
        L_0x01f4:
            if (r19 == 0) goto L_0x01ff
            float r8 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r8)
            r18 = r5
            r6 = r8
            goto L_0x0203
        L_0x01ff:
            r6 = r37
            r18 = r5
        L_0x0203:
            r17 = r10
            r8 = r11
            r5 = r15
            r15 = r2
            r2 = r9
        L_0x0209:
            r7.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x021a
            java.lang.String r9 = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:60)"
            r10 = 288295126(0x112f08d6, float:1.3807789E-28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r8, r0, r9)
        L_0x021a:
            r9 = r8 & 14
            int r0 = r0 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r9
            kotlin.jvm.functions.Function0 r0 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(r1, r12, r7, r0)
            r10 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r11 = "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r10, r11)
            r10 = -954367824(0xffffffffc71d80b0, float:-40320.688)
            java.lang.String r11 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r10, r11)
            java.lang.Object r10 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r10 != r11) goto L_0x0252
            kotlin.coroutines.EmptyCoroutineContext r10 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            kotlinx.coroutines.CoroutineScope r10 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r10, r7)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r11 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r11.<init>(r10)
            r7.updateRememberedValue(r11)
            r10 = r11
        L_0x0252:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r10 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            kotlinx.coroutines.CoroutineScope r10 = r10.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalGraphicsContext()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r31 = r0
            java.lang.String r0 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r0)
            java.lang.Object r0 = r7.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.graphics.GraphicsContext r0 = (androidx.compose.ui.graphics.GraphicsContext) r0
            int r3 = r8 >> 6
            r11 = r3 & 896(0x380, float:1.256E-42)
            r11 = r11 | r9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r3
            int r16 = r8 << 9
            r19 = 57344(0xe000, float:8.0356E-41)
            r16 = r16 & r19
            r11 = r11 | r16
            int r16 = r8 >> 9
            r20 = 458752(0x70000, float:6.42848E-40)
            r21 = r16 & r20
            r11 = r11 | r21
            r21 = 3670016(0x380000, float:5.142788E-39)
            r21 = r16 & r21
            r11 = r11 | r21
            int r21 = r8 << 18
            r22 = 234881024(0xe000000, float:1.5777218E-30)
            r21 = r21 & r22
            r11 = r11 | r21
            r12 = r10
            r10 = r7
            r7 = r12
            r22 = r3
            r3 = r4
            r21 = r8
            r12 = r9
            r23 = 6
            r4 = r29
            r8 = r30
            r9 = r0
            r0 = r1
            r1 = r31
            kotlin.jvm.functions.Function2 r24 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt.m1056rememberStaggeredGridMeasurePolicyqKj4JfE(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r25 = r2
            r26 = r5
            r27 = r6
            r7 = r10
            int r10 = r21 >> 12
            r2 = r10 & 112(0x70, float:1.57E-43)
            r2 = r2 | r12
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r2 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(r0, r3, r7, r2)
            androidx.compose.ui.layout.RemeasurementModifier r4 = r0.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.ui.Modifier r4 = r15.then(r4)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r5 = r0.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.ui.Modifier r4 = r4.then(r5)
            int r5 = r21 << 6
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r6 = r16 & r19
            r5 = r5 | r6
            r6 = r21 & r20
            r8 = r5 | r6
            r6 = r3
            r5 = r18
            r3 = r2
            r2 = r1
            r1 = r4
            r4 = r29
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r1, r2, r3, r4, r5, r6, r7, r8)
            r16 = r2
            r4 = r5
            r3 = r6
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r2 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(r0, r7, r12)
            r5 = r3
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo r3 = r0.getBeyondBoundsInfo$foundation_release()
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r8, r9)
            java.lang.Object r6 = r7.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            int r8 = androidx.compose.runtime.collection.MutableVector.$stable
            int r8 = r8 << 6
            r8 = r8 | r22
            int r9 = r21 << 12
            r9 = r9 & r20
            r8 = r8 | r9
            int r11 = r21 >> 3
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r11
            r9 = r9 | r8
            r8 = r7
            r7 = r4
            r4 = r5
            r5 = r6
            r6 = r29
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r4
            r4 = r7
            r7 = r8
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r2 = r0.getItemAnimator$foundation_release()
            androidx.compose.ui.Modifier r2 = r2.getModifier()
            androidx.compose.ui.Modifier r1 = r1.then(r2)
            r2 = r0
            androidx.compose.foundation.gestures.ScrollableState r2 = (androidx.compose.foundation.gestures.ScrollableState) r2
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r0.getMutableInteractionSource$foundation_release()
            int r5 = r21 << 3
            r5 = r5 & 1008(0x3f0, float:1.413E-42)
            r6 = r10 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r6
            r6 = r11 & r19
            r5 = r5 | r6
            r6 = r11 & r20
            r10 = r5 | r6
            r11 = 64
            r9 = r8
            r8 = 0
            r5 = r3
            r6 = r17
            r3 = r29
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.ScrollingContainerKt.scrollingContainer(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = r5
            r7 = r9
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r2 = r0.getPrefetchState$foundation_release()
            r5 = 0
            r8 = 0
            r32 = r1
            r33 = r2
            r36 = r5
            r35 = r7
            r37 = r8
            r31 = r16
            r34 = r24
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r31, (androidx.compose.ui.Modifier) r32, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r33, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r34, (androidx.compose.runtime.Composer) r35, (int) r36, (int) r37)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0382
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0382:
            r8 = r4
            r1 = r7
            r4 = r15
            r5 = r25
            r9 = r26
            r10 = r27
            r7 = r6
            r6 = r3
        L_0x038d:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 == 0) goto L_0x03a8
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$LazyStaggeredGrid$1 r0 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$LazyStaggeredGrid$1
            r1 = r28
            r2 = r29
            r3 = r30
            r11 = r38
            r12 = r13
            r13 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x03a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.m1045LazyStaggeredGridLJWHXA8(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, float, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
