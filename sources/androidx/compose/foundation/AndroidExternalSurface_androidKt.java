package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a]\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"AndroidEmbeddedExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "transform", "Landroidx/compose/ui/graphics/Matrix;", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AndroidExternalSurface", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExternalSurface.android.kt */
public final class AndroidExternalSurface_androidKt {
    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -873615933, "C(rememberAndroidExternalSurfaceState)190@7150L24,191@7186L47:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873615933, i, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:189)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, -954367824, "CC(remember):Effects.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1983762950, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new AndroidExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        AndroidExternalSurfaceState androidExternalSurfaceState = (AndroidExternalSurfaceState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidExternalSurfaceState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4  */
    /* renamed from: AndroidExternalSurface-58FFMhA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m246AndroidExternalSurface58FFMhA(androidx.compose.ui.Modifier r21, boolean r22, long r23, int r25, boolean r26, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.AndroidExternalSurfaceScope, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r7 = r27
            r8 = r29
            r0 = 640888974(0x2633308e, float:6.2168904E-16)
            r1 = r28
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AndroidExternalSurface)P(2!1,4:c#ui.unit.IntSize,5:c#foundation.AndroidExternalSurfaceZOrder)288@12167L37,291@12241L150,299@12462L774,290@12210L1032:AndroidExternalSurface.android.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r30 & 1
            if (r1 == 0) goto L_0x001c
            r2 = r8 | 6
            r3 = r2
            r2 = r21
            goto L_0x0030
        L_0x001c:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r21
            boolean r3 = r14.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r8
            goto L_0x0030
        L_0x002d:
            r2 = r21
            r3 = r8
        L_0x0030:
            r4 = r30 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x004a
            r6 = r22
            boolean r9 = r14.changed((boolean) r6)
            if (r9 == 0) goto L_0x0046
            r9 = 32
            goto L_0x0048
        L_0x0046:
            r9 = 16
        L_0x0048:
            r3 = r3 | r9
            goto L_0x004c
        L_0x004a:
            r6 = r22
        L_0x004c:
            r9 = r8 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0063
            r9 = r30 & 4
            r11 = r23
            if (r9 != 0) goto L_0x005f
            boolean r9 = r14.changed((long) r11)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r9
            goto L_0x0065
        L_0x0063:
            r11 = r23
        L_0x0065:
            r9 = r30 & 8
            if (r9 == 0) goto L_0x006c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006c:
            r15 = r8 & 3072(0xc00, float:4.305E-42)
            if (r15 != 0) goto L_0x0080
            r15 = r25
            boolean r16 = r14.changed((int) r15)
            if (r16 == 0) goto L_0x007b
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r3 = r3 | r16
            goto L_0x0082
        L_0x0080:
            r15 = r25
        L_0x0082:
            r16 = r30 & 16
            if (r16 == 0) goto L_0x0089
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x0089:
            r13 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x009d
            r13 = r26
            boolean r18 = r14.changed((boolean) r13)
            if (r18 == 0) goto L_0x0098
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r3 = r3 | r18
            goto L_0x009f
        L_0x009d:
            r13 = r26
        L_0x009f:
            r18 = r30 & 32
            r19 = 196608(0x30000, float:2.75506E-40)
            if (r18 == 0) goto L_0x00a8
            r3 = r3 | r19
            goto L_0x00b9
        L_0x00a8:
            r18 = r8 & r19
            if (r18 != 0) goto L_0x00b9
            boolean r18 = r14.changedInstance(r7)
            if (r18 == 0) goto L_0x00b5
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r3 = r3 | r18
        L_0x00b9:
            r18 = 74899(0x12493, float:1.04956E-40)
            r10 = r3 & r18
            r5 = 74898(0x12492, float:1.04954E-40)
            if (r10 != r5) goto L_0x00d4
            boolean r5 = r14.getSkipping()
            if (r5 != 0) goto L_0x00ca
            goto L_0x00d4
        L_0x00ca:
            r14.skipToGroupEnd()
            r1 = r2
            r2 = r6
            r3 = r11
            r6 = r13
            r5 = r15
            goto L_0x01f4
        L_0x00d4:
            r14.startDefaults()
            r5 = r8 & 1
            r10 = 0
            r20 = 1
            if (r5 == 0) goto L_0x00f0
            boolean r5 = r14.getDefaultsInvalid()
            if (r5 == 0) goto L_0x00e5
            goto L_0x00f0
        L_0x00e5:
            r14.skipToGroupEnd()
            r1 = r30 & 4
            if (r1 == 0) goto L_0x00ee
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00ee:
            r1 = r2
            goto L_0x0115
        L_0x00f0:
            if (r1 == 0) goto L_0x00f7
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00f8
        L_0x00f7:
            r1 = r2
        L_0x00f8:
            if (r4 == 0) goto L_0x00fc
            r6 = r20
        L_0x00fc:
            r2 = r30 & 4
            if (r2 == 0) goto L_0x0109
            androidx.compose.ui.unit.IntSize$Companion r2 = androidx.compose.ui.unit.IntSize.Companion
            long r4 = r2.m7288getZeroYbymL2g()
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r11 = r4
        L_0x0109:
            if (r9 == 0) goto L_0x0112
            androidx.compose.foundation.AndroidExternalSurfaceZOrder$Companion r2 = androidx.compose.foundation.AndroidExternalSurfaceZOrder.Companion
            int r2 = r2.m242getBehindB_4ceCc()
            r15 = r2
        L_0x0112:
            if (r16 == 0) goto L_0x0115
            r13 = r10
        L_0x0115:
            r14.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0124
            r2 = -1
            java.lang.String r4 = "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:287)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r2, r4)
        L_0x0124:
            androidx.compose.foundation.AndroidExternalSurfaceState r0 = rememberAndroidExternalSurfaceState(r14, r10)
            r2 = -1356109309(0xffffffffaf2b6a03, float:-1.5590022E-10)
            java.lang.String r4 = "CC(remember):AndroidExternalSurface.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r2, r4)
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r3
            r5 = 131072(0x20000, float:1.83671E-40)
            if (r2 != r5) goto L_0x013a
            r2 = r20
            goto L_0x013b
        L_0x013a:
            r2 = r10
        L_0x013b:
            boolean r5 = r14.changedInstance(r0)
            r2 = r2 | r5
            java.lang.Object r5 = r14.rememberedValue()
            if (r2 != 0) goto L_0x014e
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r5 != r2) goto L_0x0159
        L_0x014e:
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1$1 r2 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1$1
            r2.<init>(r7, r0)
            r5 = r2
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r14.updateRememberedValue(r5)
        L_0x0159:
            r9 = r5
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2 r0 = androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = -1356101613(0xffffffffaf2b8813, float:-1.5600703E-10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r2, r4)
            r2 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 ^ 384(0x180, float:5.38E-43)
            r4 = 256(0x100, float:3.59E-43)
            if (r2 <= r4) goto L_0x0177
            boolean r2 = r14.changed((long) r11)
            if (r2 != 0) goto L_0x017b
        L_0x0177:
            r2 = r3 & 384(0x180, float:5.38E-43)
            if (r2 != r4) goto L_0x017e
        L_0x017b:
            r2 = r20
            goto L_0x017f
        L_0x017e:
            r2 = r10
        L_0x017f:
            r4 = r3 & 112(0x70, float:1.57E-43)
            r5 = 32
            if (r4 != r5) goto L_0x0188
            r4 = r20
            goto L_0x0189
        L_0x0188:
            r4 = r10
        L_0x0189:
            r2 = r2 | r4
            r4 = r3 & 7168(0x1c00, float:1.0045E-41)
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 != r5) goto L_0x0193
            r4 = r20
            goto L_0x0194
        L_0x0193:
            r4 = r10
        L_0x0194:
            r2 = r2 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r3
            r5 = 16384(0x4000, float:2.2959E-41)
            if (r4 != r5) goto L_0x019f
            r10 = r20
        L_0x019f:
            r2 = r2 | r10
            java.lang.Object r4 = r14.rememberedValue()
            if (r2 != 0) goto L_0x01b6
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x01af
            goto L_0x01b6
        L_0x01af:
            r2 = r4
            r4 = r11
            r18 = r13
            r17 = r15
            goto L_0x01d0
        L_0x01b6:
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1 r2 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
            r21 = r2
            r24 = r6
            r22 = r11
            r26 = r13
            r25 = r15
            r21.<init>(r22, r24, r25, r26)
            r4 = r22
            r17 = r25
            r18 = r26
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r14.updateRememberedValue(r2)
        L_0x01d0:
            r13 = r2
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            int r2 = r3 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r15 = r2 | 384(0x180, float:5.38E-43)
            r16 = 8
            r12 = 0
            r11 = r0
            r10 = r1
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ed
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ed:
            r3 = r4
            r2 = r6
            r1 = r10
            r5 = r17
            r6 = r18
        L_0x01f4:
            androidx.compose.runtime.ScopeUpdateScope r10 = r14.endRestartGroup()
            if (r10 == 0) goto L_0x0206
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$4 r0 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$4
            r9 = r30
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0206:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidExternalSurface_androidKt.m246AndroidExternalSurface58FFMhA(androidx.compose.ui.Modifier, boolean, long, int, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1057437053, "C(rememberAndroidEmbeddedExternalSurfaceState)384@15036L24,385@15072L55:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1057437053, i, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:383)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, -954367824, "CC(remember):Effects.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1142294264, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new AndroidEmbeddedExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = (AndroidEmbeddedExternalSurfaceState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidEmbeddedExternalSurfaceState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0132  */
    /* renamed from: AndroidEmbeddedExternalSurface-sv6N_fY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m245AndroidEmbeddedExternalSurfacesv6N_fY(androidx.compose.ui.Modifier r22, boolean r23, long r24, float[] r26, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.AndroidExternalSurfaceScope, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r6 = r27
            r7 = r29
            r0 = 217541314(0xcf76ac2, float:3.8120628E-31)
            r1 = r28
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AndroidEmbeddedExternalSurface)P(1!1,3:c#ui.unit.IntSize,4:c#ui.graphics.Matrix)455@18917L45,458@18999L203,467@19273L485,457@18968L796:AndroidExternalSurface.android.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r30 & 1
            if (r1 == 0) goto L_0x001c
            r2 = r7 | 6
            r3 = r2
            r2 = r22
            goto L_0x0030
        L_0x001c:
            r2 = r7 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r22
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r7
            goto L_0x0030
        L_0x002d:
            r2 = r22
            r3 = r7
        L_0x0030:
            r4 = r30 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r8 = r7 & 48
            if (r8 != 0) goto L_0x004a
            r8 = r23
            boolean r9 = r13.changed((boolean) r8)
            if (r9 == 0) goto L_0x0046
            r9 = 32
            goto L_0x0048
        L_0x0046:
            r9 = 16
        L_0x0048:
            r3 = r3 | r9
            goto L_0x004c
        L_0x004a:
            r8 = r23
        L_0x004c:
            r9 = r7 & 384(0x180, float:5.38E-43)
            r10 = 256(0x100, float:3.59E-43)
            if (r9 != 0) goto L_0x0064
            r9 = r30 & 4
            r11 = r24
            if (r9 != 0) goto L_0x0060
            boolean r9 = r13.changed((long) r11)
            if (r9 == 0) goto L_0x0060
            r9 = r10
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r11 = r24
        L_0x0066:
            r9 = r30 & 8
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x006d:
            r15 = r7 & 3072(0xc00, float:4.305E-42)
            if (r15 != 0) goto L_0x0085
            if (r26 == 0) goto L_0x0078
            androidx.compose.ui.graphics.Matrix r15 = androidx.compose.ui.graphics.Matrix.m4472boximpl(r26)
            goto L_0x0079
        L_0x0078:
            r15 = 0
        L_0x0079:
            boolean r15 = r13.changedInstance(r15)
            if (r15 == 0) goto L_0x0082
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r15 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r3 = r3 | r15
        L_0x0085:
            r15 = r30 & 16
            r14 = 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x008e
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x008e:
            r15 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r15 != 0) goto L_0x009d
            boolean r15 = r13.changedInstance(r6)
            if (r15 == 0) goto L_0x009a
            r15 = r14
            goto L_0x009c
        L_0x009a:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r3 = r3 | r15
        L_0x009d:
            r15 = r3 & 9363(0x2493, float:1.312E-41)
            r5 = 9362(0x2492, float:1.3119E-41)
            if (r15 != r5) goto L_0x00b4
            boolean r5 = r13.getSkipping()
            if (r5 != 0) goto L_0x00aa
            goto L_0x00b4
        L_0x00aa:
            r13.skipToGroupEnd()
            r5 = r26
            r1 = r2
            r2 = r8
            r3 = r11
            goto L_0x01cc
        L_0x00b4:
            r13.startDefaults()
            r5 = r7 & 1
            r15 = 1
            if (r5 == 0) goto L_0x00d2
            boolean r5 = r13.getDefaultsInvalid()
            if (r5 == 0) goto L_0x00c3
            goto L_0x00d2
        L_0x00c3:
            r13.skipToGroupEnd()
            r1 = r30 & 4
            if (r1 == 0) goto L_0x00cc
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00cc:
            r21 = r26
            r9 = r2
        L_0x00cf:
            r20 = r8
            goto L_0x00f6
        L_0x00d2:
            if (r1 == 0) goto L_0x00d9
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00da
        L_0x00d9:
            r1 = r2
        L_0x00da:
            if (r4 == 0) goto L_0x00dd
            r8 = r15
        L_0x00dd:
            r2 = r30 & 4
            if (r2 == 0) goto L_0x00ea
            androidx.compose.ui.unit.IntSize$Companion r2 = androidx.compose.ui.unit.IntSize.Companion
            long r4 = r2.m7288getZeroYbymL2g()
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r11 = r4
        L_0x00ea:
            if (r9 == 0) goto L_0x00f2
            r9 = r1
            r20 = r8
            r21 = 0
            goto L_0x00f6
        L_0x00f2:
            r21 = r26
            r9 = r1
            goto L_0x00cf
        L_0x00f6:
            r13.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0105
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:454)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r2)
        L_0x0105:
            r0 = 0
            androidx.compose.foundation.AndroidEmbeddedExternalSurfaceState r1 = rememberAndroidEmbeddedExternalSurfaceState(r13, r0)
            r2 = 184051342(0xaf8668e, float:2.3920108E-32)
            java.lang.String r4 = "CC(remember):AndroidExternalSurface.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r2, r4)
            boolean r2 = r13.changedInstance(r1)
            r5 = r3 & 896(0x380, float:1.256E-42)
            r5 = r5 ^ 384(0x180, float:5.38E-43)
            if (r5 <= r10) goto L_0x0122
            boolean r8 = r13.changed((long) r11)
            if (r8 != 0) goto L_0x0126
        L_0x0122:
            r8 = r3 & 384(0x180, float:5.38E-43)
            if (r8 != r10) goto L_0x0128
        L_0x0126:
            r8 = r15
            goto L_0x0129
        L_0x0128:
            r8 = r0
        L_0x0129:
            r2 = r2 | r8
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r3
            if (r8 != r14) goto L_0x0132
            r8 = r15
            goto L_0x0133
        L_0x0132:
            r8 = r0
        L_0x0133:
            r2 = r2 | r8
            java.lang.Object r8 = r13.rememberedValue()
            if (r2 != 0) goto L_0x0142
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r8 != r2) goto L_0x014d
        L_0x0142:
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1$1 r2 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1$1
            r2.<init>(r1, r11, r6)
            r8 = r2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r13.updateRememberedValue(r8)
        L_0x014d:
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$2 r2 = androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$2.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r14 = 184060392(0xaf889e8, float:2.3933406E-32)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r14, r4)
            if (r5 <= r10) goto L_0x0164
            boolean r4 = r13.changed((long) r11)
            if (r4 != 0) goto L_0x0168
        L_0x0164:
            r4 = r3 & 384(0x180, float:5.38E-43)
            if (r4 != r10) goto L_0x016a
        L_0x0168:
            r4 = r15
            goto L_0x016b
        L_0x016a:
            r4 = r0
        L_0x016b:
            boolean r5 = r13.changedInstance(r1)
            r4 = r4 | r5
            r5 = r3 & 112(0x70, float:1.57E-43)
            r10 = 32
            if (r5 != r10) goto L_0x0177
            goto L_0x0178
        L_0x0177:
            r15 = r0
        L_0x0178:
            r0 = r4 | r15
            if (r21 == 0) goto L_0x0181
            androidx.compose.ui.graphics.Matrix r14 = androidx.compose.ui.graphics.Matrix.m4472boximpl(r21)
            goto L_0x0182
        L_0x0181:
            r14 = 0
        L_0x0182:
            boolean r4 = r13.changedInstance(r14)
            r0 = r0 | r4
            java.lang.Object r4 = r13.rememberedValue()
            if (r0 != 0) goto L_0x0199
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x0196
            goto L_0x0199
        L_0x0196:
            r17 = r11
            goto L_0x01a9
        L_0x0199:
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3$1 r16 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3$1
            r19 = r1
            r17 = r11
            r16.<init>(r17, r19, r20, r21)
            r4 = r16
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r13.updateRememberedValue(r4)
        L_0x01a9:
            r12 = r4
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            int r0 = r3 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r14 = r0 | 384(0x180, float:5.38E-43)
            r15 = 8
            r11 = 0
            r10 = r2
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c5:
            r1 = r9
            r3 = r17
            r2 = r20
            r5 = r21
        L_0x01cc:
            androidx.compose.runtime.ScopeUpdateScope r9 = r13.endRestartGroup()
            if (r9 == 0) goto L_0x01de
            androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$4 r0 = new androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$4
            r8 = r30
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x01de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidExternalSurface_androidKt.m245AndroidEmbeddedExternalSurfacesv6N_fY(androidx.compose.ui.Modifier, boolean, long, float[], kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
