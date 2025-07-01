package androidx.compose.ui.window;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\u0015\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u0002"}, d2 = {"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
public final class AndroidDialog_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Dialog(kotlin.jvm.functions.Function0<kotlin.Unit> r20, androidx.compose.ui.window.DialogProperties r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r1 = r20
            r7 = r22
            r8 = r24
            r0 = -2032877254(0xffffffff86d4c13a, float:-8.002946E-35)
            r2 = r23
            androidx.compose.runtime.Composer r13 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Dialog)P(1,2)167@7096L7,168@7135L7,169@7190L7,170@7220L28,171@7275L29,172@7324L38,173@7380L616,194@8027L129,194@8002L154,203@8173L182,203@8162L193:AndroidDialog.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r2 = r25 & 1
            r3 = 4
            if (r2 == 0) goto L_0x001c
            r2 = r8 | 6
            goto L_0x002c
        L_0x001c:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002b
            boolean r2 = r13.changedInstance(r1)
            if (r2 == 0) goto L_0x0028
            r2 = r3
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r8
            goto L_0x002c
        L_0x002b:
            r2 = r8
        L_0x002c:
            r4 = r25 & 2
            r5 = 32
            if (r4 == 0) goto L_0x0035
            r2 = r2 | 48
            goto L_0x0047
        L_0x0035:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x0047
            r6 = r21
            boolean r9 = r13.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x0043
            r9 = r5
            goto L_0x0045
        L_0x0043:
            r9 = 16
        L_0x0045:
            r2 = r2 | r9
            goto L_0x0049
        L_0x0047:
            r6 = r21
        L_0x0049:
            r9 = r25 & 4
            if (r9 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x0050:
            r9 = r8 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0060
            boolean r9 = r13.changedInstance(r7)
            if (r9 == 0) goto L_0x005d
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r9
        L_0x0060:
            r9 = r2 & 147(0x93, float:2.06E-43)
            r10 = 146(0x92, float:2.05E-43)
            if (r9 != r10) goto L_0x0073
            boolean r9 = r13.getSkipping()
            if (r9 != 0) goto L_0x006d
            goto L_0x0073
        L_0x006d:
            r13.skipToGroupEnd()
            r2 = r6
            goto L_0x01c0
        L_0x0073:
            if (r4 == 0) goto L_0x0084
            androidx.compose.ui.window.DialogProperties r14 = new androidx.compose.ui.window.DialogProperties
            r18 = 7
            r19 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r14.<init>((boolean) r15, (boolean) r16, (boolean) r17, (int) r18, (kotlin.jvm.internal.DefaultConstructorMarker) r19)
            r6 = r14
        L_0x0084:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0090
            r4 = -1
            java.lang.String r9 = "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:166)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r4, r9)
        L_0x0090:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r9)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            android.view.View r0 = (android.view.View) r0
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r9)
            java.lang.Object r10 = r13.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r9)
            java.lang.Object r4 = r13.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            r9 = 0
            androidx.compose.runtime.CompositionContext r11 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r13, r9)
            int r12 = r2 >> 6
            r12 = r12 & 14
            androidx.compose.runtime.State r12 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r7, r13, r12)
            r14 = r9
            java.lang.Object[] r9 = new java.lang.Object[r14]
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1 r15 = androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1.INSTANCE
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r16 = r14
            r14 = 3072(0xc00, float:4.305E-42)
            r17 = r12
            r12 = r15
            r15 = 6
            r18 = r10
            r10 = 0
            r19 = r11
            r11 = 0
            r8 = r17
            r7 = r19
            r17 = r5
            r5 = r18
            java.lang.Object r9 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r9, r10, (java.lang.String) r11, r12, (androidx.compose.runtime.Composer) r13, (int) r14, (int) r15)
            java.util.UUID r9 = (java.util.UUID) r9
            r10 = -464840651(0xffffffffe44b1835, float:-1.4985733E22)
            java.lang.String r11 = "CC(remember):AndroidDialog.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r11)
            boolean r10 = r13.changed((java.lang.Object) r0)
            boolean r12 = r13.changed((java.lang.Object) r5)
            r10 = r10 | r12
            java.lang.Object r12 = r13.rememberedValue()
            r14 = 1
            if (r10 != 0) goto L_0x0123
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r12 != r10) goto L_0x011c
            goto L_0x0123
        L_0x011c:
            r9 = r2
            r2 = r6
            r0 = r12
            r10 = r17
            r12 = r3
            goto L_0x0145
        L_0x0123:
            r10 = r3
            r3 = r0
            androidx.compose.ui.window.DialogWrapper r0 = new androidx.compose.ui.window.DialogWrapper
            r12 = r9
            r9 = r2
            r2 = r6
            r6 = r12
            r12 = r10
            r10 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1 r3 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
            r3.<init>(r8)
            r5 = 488261145(0x1d1a4619, float:2.041797E-21)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r5, r14, r3)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0.setContent(r7, r3)
            r13.updateRememberedValue(r0)
        L_0x0145:
            androidx.compose.ui.window.DialogWrapper r0 = (androidx.compose.ui.window.DialogWrapper) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r3 = -464820434(0xffffffffe44b672e, float:-1.5008496E22)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r11)
            boolean r3 = r13.changedInstance(r0)
            java.lang.Object r5 = r13.rememberedValue()
            if (r3 != 0) goto L_0x0162
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x016d
        L_0x0162:
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1 r3 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1
            r3.<init>(r0)
            r5 = r3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r13.updateRememberedValue(r5)
        L_0x016d:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r3 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r5, (androidx.compose.runtime.Composer) r13, (int) r3)
            r3 = -464815709(0xffffffffe44b79a3, float:-1.5013816E22)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r11)
            boolean r3 = r13.changedInstance(r0)
            r5 = r9 & 14
            if (r5 != r12) goto L_0x0186
            r5 = r14
            goto L_0x0187
        L_0x0186:
            r5 = 0
        L_0x0187:
            r3 = r3 | r5
            r5 = r9 & 112(0x70, float:1.57E-43)
            if (r5 != r10) goto L_0x018e
            r9 = r14
            goto L_0x018f
        L_0x018e:
            r9 = 0
        L_0x018f:
            r3 = r3 | r9
            boolean r5 = r13.changed((java.lang.Object) r4)
            r3 = r3 | r5
            java.lang.Object r5 = r13.rememberedValue()
            if (r3 != 0) goto L_0x01a3
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x01ae
        L_0x01a3:
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1 r3 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
            r3.<init>(r0, r1, r2, r4)
            r5 = r3
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r13.updateRememberedValue(r5)
        L_0x01ae:
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r14 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r5, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c0:
            androidx.compose.runtime.ScopeUpdateScope r6 = r13.endRestartGroup()
            if (r6 == 0) goto L_0x01d6
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3 r0 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3
            r3 = r22
            r4 = r24
            r5 = r25
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r6.updateScope(r0)
        L_0x01d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt.Dialog(kotlin.jvm.functions.Function0, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void DialogLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1177876616);
        ComposerKt.sourceInformation(startRestartGroup, "C(DialogLayout)P(1)465@18400L455:AndroidDialog.android.kt#2oxthz");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1177876616, i3, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:464)");
            }
            MeasurePolicy measurePolicy = AndroidDialog_androidKt$DialogLayout$1.INSTANCE;
            int i5 = ((i3 >> 3) & 14) | 384 | ((i3 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i6 = ((i5 << 6) & 896) | 6;
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
            Updater.m3682setimpl(r5, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            function2.invoke(startRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidDialog_androidKt$DialogLayout$2(modifier, function2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Dialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
