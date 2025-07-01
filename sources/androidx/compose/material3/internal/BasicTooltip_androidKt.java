package androidx.compose.material3.internal;

import androidx.compose.foundation.R;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000f\u001a@\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a,\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/material3/TooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "WrappedAnchor", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "anchorSemantics", "label", "", "enabled", "handleGestures", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTooltip.android.kt */
public final class BasicTooltip_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTooltipBox(androidx.compose.ui.window.PopupPositionProvider r17, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.material3.TooltipState r19, androidx.compose.ui.Modifier r20, boolean r21, boolean r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r1 = r19
            r8 = r25
            r0 = -550509567(0xffffffffdf2fe401, float:-1.2674256E19)
            r2 = r24
            androidx.compose.runtime.Composer r4 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(BasicTooltipBox)P(4,6,5,3,2,1)86@3910L24,87@3939L451,106@4420L35,106@4396L59:BasicTooltip.android.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            r2 = r26 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r8 | 6
            r3 = r2
            r2 = r17
            goto L_0x0030
        L_0x001c:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r17
            boolean r3 = r4.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r8
            goto L_0x0030
        L_0x002d:
            r2 = r17
            r3 = r8
        L_0x0030:
            r5 = r26 & 2
            if (r5 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r8 & 48
            if (r5 != 0) goto L_0x004a
            r5 = r18
            boolean r6 = r4.changedInstance(r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r18
        L_0x004c:
            r6 = r26 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0053:
            r6 = r8 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x006c
            r6 = r8 & 512(0x200, float:7.175E-43)
            if (r6 != 0) goto L_0x0060
            boolean r6 = r4.changed((java.lang.Object) r1)
            goto L_0x0064
        L_0x0060:
            boolean r6 = r4.changedInstance(r1)
        L_0x0064:
            if (r6 == 0) goto L_0x0069
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r3 = r3 | r6
        L_0x006c:
            r6 = r26 & 8
            if (r6 == 0) goto L_0x0073
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0073:
            r9 = r8 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0086
            r9 = r20
            boolean r10 = r4.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0082
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r3 = r3 | r10
            goto L_0x0088
        L_0x0086:
            r9 = r20
        L_0x0088:
            r10 = r26 & 16
            if (r10 == 0) goto L_0x008f
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008f:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x00a2
            r11 = r21
            boolean r12 = r4.changed((boolean) r11)
            if (r12 == 0) goto L_0x009e
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r3 = r3 | r12
            goto L_0x00a4
        L_0x00a2:
            r11 = r21
        L_0x00a4:
            r12 = r26 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00ac
            r3 = r3 | r13
            goto L_0x00be
        L_0x00ac:
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00be
            r13 = r22
            boolean r14 = r4.changed((boolean) r13)
            if (r14 == 0) goto L_0x00ba
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r14
            goto L_0x00c0
        L_0x00be:
            r13 = r22
        L_0x00c0:
            r14 = r26 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00c8
            r3 = r3 | r15
            goto L_0x00db
        L_0x00c8:
            r14 = r8 & r15
            if (r14 != 0) goto L_0x00db
            r14 = r23
            boolean r15 = r4.changedInstance(r14)
            if (r15 == 0) goto L_0x00d7
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r3 = r3 | r15
            goto L_0x00dd
        L_0x00db:
            r14 = r23
        L_0x00dd:
            r15 = r3
            r3 = 599187(0x92493, float:8.3964E-40)
            r3 = r3 & r15
            r7 = 599186(0x92492, float:8.39638E-40)
            if (r3 != r7) goto L_0x00f5
            boolean r3 = r4.getSkipping()
            if (r3 != 0) goto L_0x00ee
            goto L_0x00f5
        L_0x00ee:
            r4.skipToGroupEnd()
            r5 = r11
            r6 = r13
            goto L_0x02a7
        L_0x00f5:
            if (r6 == 0) goto L_0x00fc
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r9 = r3
        L_0x00fc:
            if (r10 == 0) goto L_0x0100
            r3 = 1
            goto L_0x0101
        L_0x0100:
            r3 = r11
        L_0x0101:
            if (r12 == 0) goto L_0x0104
            r13 = 1
        L_0x0104:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0110
            r6 = -1
            java.lang.String r10 = "androidx.compose.material3.internal.BasicTooltipBox (BasicTooltip.android.kt:85)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r6, r10)
        L_0x0110:
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r6 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r6)
            r0 = -954363344(0xffffffffc71d9230, float:-40338.188)
            java.lang.String r6 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r6)
            java.lang.Object r0 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r0 != r6) goto L_0x013d
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r4)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r6 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r6.<init>(r0)
            r4.updateRememberedValue(r6)
            r0 = r6
        L_0x013d:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            kotlinx.coroutines.CoroutineScope r0 = r0.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r10 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r10)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getTopStart()
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r10, r11)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r7 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r12, r7)
            int r7 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r4, r11)
            androidx.compose.runtime.CompositionLocalMap r12 = r4.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r4, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r16.getConstructor()
            r22 = r0
            r0 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r1 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r1)
            androidx.compose.runtime.Applier r0 = r4.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x018f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x018f:
            r4.startReusableNode()
            boolean r0 = r4.getInserting()
            if (r0 == 0) goto L_0x019c
            r4.createNode(r11)
            goto L_0x019f
        L_0x019c:
            r4.useNode()
        L_0x019f:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m3675constructorimpl(r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r10, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r12, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r10 = r0.getInserting()
            if (r10 != 0) goto L_0x01cf
            java.lang.Object r10 = r0.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 != 0) goto L_0x01dd
        L_0x01cf:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            r0.updateRememberedValue(r10)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.apply(r7, r1)
        L_0x01dd:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r6, r1)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r1 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 2072656365(0x7b8a39ed, float:1.4354237E36)
            java.lang.String r1 = "C98@4223L161:BasicTooltip.android.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r1)
            r0 = -625876949(0xffffffffdab1e02b, float:-2.50337731E16)
            r4.startReplaceGroup(r0)
            java.lang.String r0 = "89@3988L215"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            boolean r0 = r19.isVisible()
            if (r0 == 0) goto L_0x0229
            r0 = r15 & 14
            int r1 = r15 >> 3
            r6 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            int r6 = r15 << 9
            r1 = r1 & r6
            r6 = r0 | r1
            r0 = r5
            r5 = r4
            r4 = r0
            r1 = r19
            r0 = r2
            r2 = r22
            TooltipPopup(r0, r1, r2, r3, r4, r5, r6)
            r4 = r5
        L_0x0229:
            r7 = r3
            r4.endReplaceGroup()
            int r0 = r15 >> 15
            r0 = r0 & 14
            int r1 = r15 >> 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r15 >> 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r5 = r0 | r1
            r6 = 0
            r1 = r19
            r2 = r9
            r0 = r13
            r3 = r14
            WrappedAnchor(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r4.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r3 = -1907285077(0xffffffff8e5123ab, float:-2.5778412E-30)
            java.lang.String r5 = "CC(remember):BasicTooltip.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r3, r5)
            r3 = r15 & 896(0x380, float:1.256E-42)
            r5 = 256(0x100, float:3.59E-43)
            if (r3 == r5) goto L_0x0275
            r3 = r15 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0273
            boolean r3 = r4.changedInstance(r1)
            if (r3 == 0) goto L_0x0273
            goto L_0x0275
        L_0x0273:
            r3 = 0
            goto L_0x0276
        L_0x0275:
            r3 = 1
        L_0x0276:
            java.lang.Object r5 = r4.rememberedValue()
            if (r3 != 0) goto L_0x0284
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x028f
        L_0x0284:
            androidx.compose.material3.internal.BasicTooltip_androidKt$BasicTooltipBox$2$1 r3 = new androidx.compose.material3.internal.BasicTooltip_androidKt$BasicTooltipBox$2$1
            r3.<init>(r1)
            r5 = r3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r4.updateRememberedValue(r5)
        L_0x028f:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            int r3 = r15 >> 6
            r3 = r3 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r5, (androidx.compose.runtime.Composer) r4, (int) r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x02a4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a4:
            r6 = r0
            r9 = r2
            r5 = r7
        L_0x02a7:
            androidx.compose.runtime.ScopeUpdateScope r10 = r4.endRestartGroup()
            if (r10 == 0) goto L_0x02c1
            androidx.compose.material3.internal.BasicTooltip_androidKt$BasicTooltipBox$3 r0 = new androidx.compose.material3.internal.BasicTooltip_androidKt$BasicTooltipBox$3
            r2 = r18
            r7 = r23
            r3 = r1
            r4 = r9
            r1 = r17
            r9 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x02c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt.BasicTooltipBox(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.material3.TooltipState, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void WrappedAnchor(boolean z, TooltipState tooltipState, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1848240995);
        ComposerKt.sourceInformation(startRestartGroup, "C(WrappedAnchor)P(1,3,2)116@4644L24,117@4694L38,118@4737L212:BasicTooltip.android.kt#mqatfk");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? startRestartGroup.changed((Object) tooltipState) : startRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1848240995, i3, -1, "androidx.compose.material3.internal.WrappedAnchor (BasicTooltip.android.kt:115)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier anchorSemantics = anchorSemantics(handleGestures(modifier, z, tooltipState), StringResources_androidKt.stringResource(R.string.tooltip_label, startRestartGroup, 0), z, tooltipState, coroutineScope);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, anchorSemantics);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r5 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r5, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 400210223, "C124@4934L9:BasicTooltip.android.kt#mqatfk");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTooltip_androidKt$WrappedAnchor$2(z, tooltipState, modifier2, function2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void TooltipPopup(PopupPositionProvider popupPositionProvider, TooltipState tooltipState, CoroutineScope coroutineScope, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        PopupPositionProvider popupPositionProvider2;
        TooltipState tooltipState2 = tooltipState;
        CoroutineScope coroutineScope2 = coroutineScope;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-273292979);
        ComposerKt.sourceInformation(startRestartGroup, "C(TooltipPopup)P(2,4,3,1)136@5181L44,139@5314L109,145@5491L251,137@5230L512:BasicTooltip.android.kt#mqatfk");
        if ((i3 & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i2 = (startRestartGroup.changed((Object) popupPositionProvider2) ? 4 : 2) | i3;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= (i3 & 64) == 0 ? startRestartGroup.changed((Object) tooltipState2) : startRestartGroup.changedInstance(tooltipState2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(coroutineScope2) ? 256 : 128;
        }
        boolean z2 = z;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273292979, i2, -1, "androidx.compose.material3.internal.TooltipPopup (BasicTooltip.android.kt:135)");
            }
            boolean z3 = false;
            String stringResource = StringResources_androidKt.stringResource(R.string.tooltip_description, startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 162917156, "CC(remember):BasicTooltip.android.kt#9igjgp");
            if ((i2 & 112) == 32 || ((i2 & 64) != 0 && startRestartGroup.changedInstance(tooltipState2))) {
                z3 = true;
            }
            boolean changedInstance = z3 | startRestartGroup.changedInstance(coroutineScope2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BasicTooltip_androidKt$TooltipPopup$1$1(tooltipState2, coroutineScope2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AndroidPopup_androidKt.Popup(popupPositionProvider2, (Function0) rememberedValue, new PopupProperties(z2, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(610617071, true, new BasicTooltip_androidKt$TooltipPopup$2(stringResource, function22), startRestartGroup, 54), startRestartGroup, (i2 & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTooltip_androidKt$TooltipPopup$3(popupPositionProvider, tooltipState2, coroutineScope2, z, function22, i3));
        }
    }

    private static final Modifier handleGestures(Modifier modifier, boolean z, TooltipState tooltipState) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) tooltipState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new BasicTooltip_androidKt$handleGestures$1(tooltipState, (Continuation<? super BasicTooltip_androidKt$handleGestures$1>) null)), (Object) tooltipState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new BasicTooltip_androidKt$handleGestures$2(tooltipState, (Continuation<? super BasicTooltip_androidKt$handleGestures$2>) null)) : modifier;
    }

    private static final Modifier anchorSemantics(Modifier modifier, String str, boolean z, TooltipState tooltipState, CoroutineScope coroutineScope) {
        return z ? SemanticsModifierKt.semantics(modifier, true, new BasicTooltip_androidKt$anchorSemantics$1(str, coroutineScope, tooltipState)) : modifier;
    }
}
