package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ay\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0013\u001aR\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\b2#\b\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00190\bH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001e"}, d2 = {"DismissVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismissBox", "", "state", "Landroidx/compose/material3/SwipeToDismissBoxState;", "backgroundContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enableDismissFromStartToEnd", "", "enableDismissFromEndToStart", "gesturesEnabled", "content", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSwipeToDismissBoxState", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
public final class SwipeToDismissBoxKt {
    /* access modifiers changed from: private */
    public static final float DismissVelocityThreshold = Dp.m7111constructorimpl((float) 125);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.material3.SwipeToDismissBoxState, androidx.compose.material3.SwipeToDismissBoxValue>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: kotlin.jvm.functions.Function1<java.lang.Float, java.lang.Float>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.SwipeToDismissBoxState rememberSwipeToDismissBoxState(androidx.compose.material3.SwipeToDismissBoxValue r10, kotlin.jvm.functions.Function1<? super androidx.compose.material3.SwipeToDismissBoxValue, java.lang.Boolean> r11, kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "C(rememberSwipeToDismissBoxState)P(1)185@7607L19,187@7687L7,195@7929L102,188@7706L325:SwipeToDismissBox.kt#uh7d8r"
            r1 = -246335487(0xfffffffff1513801, float:-1.03600115E30)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            r0 = r15 & 1
            if (r0 == 0) goto L_0x000e
            androidx.compose.material3.SwipeToDismissBoxValue r10 = androidx.compose.material3.SwipeToDismissBoxValue.Settled
        L_0x000e:
            r0 = r15 & 2
            if (r0 == 0) goto L_0x0016
            androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$1 r11 = androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$1.INSTANCE
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
        L_0x0016:
            r0 = 4
            r15 = r15 & r0
            r2 = 6
            if (r15 == 0) goto L_0x0021
            androidx.compose.material3.SwipeToDismissBoxDefaults r12 = androidx.compose.material3.SwipeToDismissBoxDefaults.INSTANCE
            kotlin.jvm.functions.Function1 r12 = r12.getPositionalThreshold(r13, r2)
        L_0x0021:
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x002d
            r15 = -1
            java.lang.String r3 = "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:186)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r14, r15, r3)
        L_0x002d:
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r3)
            java.lang.Object r15 = r13.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            r1 = 0
            java.lang.Object[] r3 = new java.lang.Object[r1]
            androidx.compose.material3.SwipeToDismissBoxState$Companion r4 = androidx.compose.material3.SwipeToDismissBoxState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r4.Saver(r11, r12, r15)
            r5 = -1333458863(0xffffffffb0850851, float:-9.679387E-10)
            java.lang.String r6 = "CC(remember):SwipeToDismissBox.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            r5 = r14 & 14
            r2 = r2 ^ r5
            r5 = 1
            if (r2 <= r0) goto L_0x0061
            boolean r2 = r13.changed((java.lang.Object) r10)
            if (r2 != 0) goto L_0x0065
        L_0x0061:
            r2 = r14 & 6
            if (r2 != r0) goto L_0x0067
        L_0x0065:
            r0 = r5
            goto L_0x0068
        L_0x0067:
            r0 = r1
        L_0x0068:
            boolean r2 = r13.changed((java.lang.Object) r15)
            r0 = r0 | r2
            r2 = r14 & 112(0x70, float:1.57E-43)
            r2 = r2 ^ 48
            r6 = 32
            if (r2 <= r6) goto L_0x007b
            boolean r2 = r13.changed((java.lang.Object) r11)
            if (r2 != 0) goto L_0x007f
        L_0x007b:
            r2 = r14 & 48
            if (r2 != r6) goto L_0x0081
        L_0x007f:
            r2 = r5
            goto L_0x0082
        L_0x0081:
            r2 = r1
        L_0x0082:
            r0 = r0 | r2
            r2 = r14 & 896(0x380, float:1.256E-42)
            r2 = r2 ^ 384(0x180, float:5.38E-43)
            r6 = 256(0x100, float:3.59E-43)
            if (r2 <= r6) goto L_0x0091
            boolean r2 = r13.changed((java.lang.Object) r12)
            if (r2 != 0) goto L_0x0095
        L_0x0091:
            r14 = r14 & 384(0x180, float:5.38E-43)
            if (r14 != r6) goto L_0x0096
        L_0x0095:
            r1 = r5
        L_0x0096:
            r14 = r0 | r1
            java.lang.Object r0 = r13.rememberedValue()
            if (r14 != 0) goto L_0x00a6
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r0 != r14) goto L_0x00b1
        L_0x00a6:
            androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1 r14 = new androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1
            r14.<init>(r10, r15, r11, r12)
            r0 = r14
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r13.updateRememberedValue(r0)
        L_0x00b1:
            r6 = r0
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r8 = 0
            r9 = 4
            r5 = 0
            r7 = r13
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.material3.SwipeToDismissBoxState r10 = (androidx.compose.material3.SwipeToDismissBoxState) r10
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x00ca
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ca:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeToDismissBoxKt.rememberSwipeToDismissBoxState(androidx.compose.material3.SwipeToDismissBoxValue, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.SwipeToDismissBoxState");
    }

    /* JADX WARNING: Removed duplicated region for block: B:162:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SwipeToDismissBox(androidx.compose.material3.SwipeToDismissBoxState r27, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, boolean r31, boolean r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r1 = r27
            r2 = r28
            r7 = r33
            r8 = r35
            r0 = -402577235(0xffffffffe80128ad, float:-2.4397424E24)
            r3 = r34
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(SwipeToDismissBox)P(6!1,5,3,2,4)225@9211L7,227@9247L1205:SwipeToDismissBox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r36 & 1
            if (r4 == 0) goto L_0x001d
            r4 = r8 | 6
            goto L_0x002d
        L_0x001d:
            r4 = r8 & 6
            if (r4 != 0) goto L_0x002c
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = 2
        L_0x002a:
            r4 = r4 | r8
            goto L_0x002d
        L_0x002c:
            r4 = r8
        L_0x002d:
            r6 = r36 & 2
            if (r6 == 0) goto L_0x0034
            r4 = r4 | 48
            goto L_0x0044
        L_0x0034:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0044
            boolean r6 = r3.changedInstance(r2)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r4 = r4 | r6
        L_0x0044:
            r6 = r36 & 4
            if (r6 == 0) goto L_0x004b
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r9 = r8 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x005e
            r9 = r29
            boolean r10 = r3.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x005a
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r4 = r4 | r10
            goto L_0x0060
        L_0x005e:
            r9 = r29
        L_0x0060:
            r10 = r36 & 8
            if (r10 == 0) goto L_0x0067
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r12 = r8 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007a
            r12 = r30
            boolean r13 = r3.changed((boolean) r12)
            if (r13 == 0) goto L_0x0076
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r13
            goto L_0x007c
        L_0x007a:
            r12 = r30
        L_0x007c:
            r13 = r36 & 16
            if (r13 == 0) goto L_0x0083
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0083:
            r15 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r15 != 0) goto L_0x0097
            r15 = r31
            boolean r16 = r3.changed((boolean) r15)
            if (r16 == 0) goto L_0x0092
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r4 = r4 | r16
            goto L_0x0099
        L_0x0097:
            r15 = r31
        L_0x0099:
            r16 = r36 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a4
            r4 = r4 | r17
            r5 = r32
            goto L_0x00b7
        L_0x00a4:
            r17 = r8 & r17
            r5 = r32
            if (r17 != 0) goto L_0x00b7
            boolean r17 = r3.changed((boolean) r5)
            if (r17 == 0) goto L_0x00b3
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r4 = r4 | r17
        L_0x00b7:
            r17 = r36 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c0
            r4 = r4 | r18
            goto L_0x00d1
        L_0x00c0:
            r17 = r8 & r18
            if (r17 != 0) goto L_0x00d1
            boolean r17 = r3.changedInstance(r7)
            if (r17 == 0) goto L_0x00cd
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cd:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r4 = r4 | r17
        L_0x00d1:
            r17 = 599187(0x92493, float:8.3964E-40)
            r14 = r4 & r17
            r11 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r11) goto L_0x00ea
            boolean r11 = r3.getSkipping()
            if (r11 != 0) goto L_0x00e2
            goto L_0x00ea
        L_0x00e2:
            r3.skipToGroupEnd()
            r6 = r5
        L_0x00e6:
            r4 = r12
            r5 = r15
            goto L_0x03fd
        L_0x00ea:
            if (r6 == 0) goto L_0x00f3
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r19 = r6
            goto L_0x00f5
        L_0x00f3:
            r19 = r9
        L_0x00f5:
            r6 = 1
            if (r10 == 0) goto L_0x00f9
            r12 = r6
        L_0x00f9:
            if (r13 == 0) goto L_0x00fc
            r15 = r6
        L_0x00fc:
            if (r16 == 0) goto L_0x00ff
            r5 = r6
        L_0x00ff:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x010b
            r9 = -1
            java.lang.String r10 = "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:224)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r9, r10)
        L_0x010b:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r10)
            java.lang.Object r0 = r3.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.LayoutDirection r9 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r10 = 0
            if (r0 != r9) goto L_0x0127
            r0 = r6
            goto L_0x0128
        L_0x0127:
            r0 = r10
        L_0x0128:
            androidx.compose.material3.internal.AnchoredDraggableState r20 = r1.getAnchoredDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r21 = androidx.compose.foundation.gestures.Orientation.Horizontal
            if (r5 == 0) goto L_0x013b
            androidx.compose.material3.SwipeToDismissBoxValue r9 = r1.getCurrentValue()
            androidx.compose.material3.SwipeToDismissBoxValue r11 = androidx.compose.material3.SwipeToDismissBoxValue.Settled
            if (r9 != r11) goto L_0x013b
            r22 = r6
            goto L_0x013d
        L_0x013b:
            r22 = r10
        L_0x013d:
            r25 = 24
            r26 = 0
            r23 = 0
            r24 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.material3.internal.AnchoredDraggableKt.anchoredDraggable$default(r19, r20, r21, r22, r23, r24, r25, r26)
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r13 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r11, r13)
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r11 = r11.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r11, r6)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r14 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r13, r14)
            int r16 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r10)
            androidx.compose.runtime.CompositionLocalMap r6 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r3, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r20.getConstructor()
            r10 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r32 = r5
            java.lang.String r5 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r10, r5)
            androidx.compose.runtime.Applier r10 = r3.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x018a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x018a:
            r3.startReusableNode()
            boolean r10 = r3.getInserting()
            if (r10 == 0) goto L_0x0197
            r3.createNode(r13)
            goto L_0x019a
        L_0x0197:
            r3.useNode()
        L_0x019a:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m3675constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r11, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r6, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r11 = r10.getInserting()
            if (r11 != 0) goto L_0x01ca
            java.lang.Object r11 = r10.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r13)
            if (r11 != 0) goto L_0x01d8
        L_0x01ca:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)
            r10.updateRememberedValue(r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)
            r10.apply(r11, r6)
        L_0x01d8:
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r9, r6)
            r6 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r9 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r6, r9)
            androidx.compose.foundation.layout.BoxScopeInstance r6 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r6 = (androidx.compose.foundation.layout.BoxScope) r6
            r9 = -586717200(0xffffffffdd0767f0, float:-6.0981444E17)
            java.lang.String r10 = "C235@9549L71,239@9784L652,236@9629L817:SwipeToDismissBox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r10)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            androidx.compose.ui.Modifier r6 = r6.matchParentSize(r9)
            int r9 = r4 << 6
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            java.lang.String r10 = "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo"
            r11 = 693286680(0x2952b718, float:4.6788176E-14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r11, r10)
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r10 = r10.getStart()
            androidx.compose.ui.Alignment$Companion r13 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r13 = r13.getTop()
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r10, r13, r3, r11)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r13, r14)
            int r13 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r11)
            androidx.compose.runtime.CompositionLocalMap r11 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r3, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r21.getConstructor()
            r21 = r9
            r9 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r5)
            androidx.compose.runtime.Applier r9 = r3.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0245
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0245:
            r3.startReusableNode()
            boolean r9 = r3.getInserting()
            if (r9 == 0) goto L_0x0252
            r3.createNode(r8)
            goto L_0x0255
        L_0x0252:
            r3.useNode()
        L_0x0255:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m3675constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r10, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r11, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetCompositeKeyHash()
            boolean r10 = r8.getInserting()
            if (r10 != 0) goto L_0x0285
            java.lang.Object r10 = r8.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r13)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 != 0) goto L_0x0293
        L_0x0285:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r13)
            r8.updateRememberedValue(r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r13)
            r8.apply(r10, r9)
        L_0x0293:
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r6, r9)
            r6 = -407918630(0xffffffffe7afa7da, float:-1.6590209E24)
            java.lang.String r8 = "C100@5047L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r6, r8)
            androidx.compose.foundation.layout.RowScopeInstance r6 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r8 = r21 >> 6
            r8 = r8 & 112(0x70, float:1.57E-43)
            r8 = r8 | 6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2.invoke(r6, r3, r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r3.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.material3.internal.AnchoredDraggableState r8 = r1.getAnchoredDraggableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r9 = androidx.compose.foundation.gestures.Orientation.Horizontal
            r10 = 396722910(0x17a582de, float:1.0695911E-24)
            java.lang.String r11 = "CC(remember):SwipeToDismissBox.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r10, r11)
            r10 = r4 & 7168(0x1c00, float:1.0045E-41)
            r11 = 2048(0x800, float:2.87E-42)
            if (r10 != r11) goto L_0x02dc
            r11 = 1
            goto L_0x02dd
        L_0x02dc:
            r11 = 0
        L_0x02dd:
            boolean r10 = r3.changed((boolean) r0)
            r10 = r10 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r4
            r13 = 16384(0x4000, float:2.2959E-41)
            if (r11 != r13) goto L_0x02ec
            r11 = 1
            goto L_0x02ed
        L_0x02ec:
            r11 = 0
        L_0x02ed:
            r10 = r10 | r11
            r11 = r4 & 14
            r13 = 4
            if (r11 != r13) goto L_0x02f5
            r11 = 1
            goto L_0x02f6
        L_0x02f5:
            r11 = 0
        L_0x02f6:
            r10 = r10 | r11
            java.lang.Object r11 = r3.rememberedValue()
            if (r10 != 0) goto L_0x0305
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0310
        L_0x0305:
            androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1 r10 = new androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1
            r10.<init>(r1, r12, r0, r15)
            r11 = r10
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r3.updateRememberedValue(r11)
        L_0x0310:
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.Modifier r0 = androidx.compose.material3.internal.AnchoredDraggableKt.draggableAnchors(r6, r8, r9, r11)
            int r4 = r4 >> 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            java.lang.String r6 = "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo"
            r8 = 693286680(0x2952b718, float:4.6788176E-14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r8, r6)
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r6 = r6.getStart()
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r8 = r8.getTop()
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r6, r8, r3, r11)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r13, r14)
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r11)
            androidx.compose.runtime.CompositionLocalMap r9 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r3, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            r11 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r11, r5)
            androidx.compose.runtime.Applier r5 = r3.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x035f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x035f:
            r3.startReusableNode()
            boolean r5 = r3.getInserting()
            if (r5 == 0) goto L_0x036c
            r3.createNode(r10)
            goto L_0x036f
        L_0x036c:
            r3.useNode()
        L_0x036f:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r6, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r9, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r9 = r5.getInserting()
            if (r9 != 0) goto L_0x039f
            java.lang.Object r9 = r5.rememberedValue()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 != 0) goto L_0x03ad
        L_0x039f:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r5.updateRememberedValue(r9)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r5.apply(r8, r6)
        L_0x03ad:
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r0, r6)
            r0 = -407918630(0xffffffffe7afa7da, float:-1.6590209E24)
            java.lang.String r5 = "C100@5047L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r5)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r4 = r4 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r4 | 6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.invoke(r0, r3, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r3.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r3.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03f7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03f7:
            r6 = r32
            r9 = r19
            goto L_0x00e6
        L_0x03fd:
            androidx.compose.runtime.ScopeUpdateScope r10 = r3.endRestartGroup()
            if (r10 == 0) goto L_0x0412
            androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$2 r0 = new androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$2
            r8 = r35
            r3 = r9
            r9 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0412:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeToDismissBoxKt.SwipeToDismissBox(androidx.compose.material3.SwipeToDismissBoxState, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, boolean, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
