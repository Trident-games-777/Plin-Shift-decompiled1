package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0002\u0010\f\u001ac\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0011H\u0001¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"ContextMenu", "", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "contextMenuBuilderBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ContextMenuArea", "enabled", "", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenuArea.android.kt */
public final class ContextMenuArea_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ContextMenuArea(androidx.compose.foundation.contextmenu.ContextMenuState r17, kotlin.jvm.functions.Function0<kotlin.Unit> r18, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.contextmenu.ContextMenuScope, kotlin.Unit> r19, androidx.compose.ui.Modifier r20, boolean r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r0 = r17
            r7 = r22
            r8 = r24
            r1 = -84584070(0xfffffffffaf5597a, float:-6.3696377E35)
            r2 = r23
            androidx.compose.runtime.Composer r4 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(ContextMenuArea)P(5,4,1,3,2)46@1865L231:ContextMenuArea.android.kt#3xeu6s"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            r2 = r25 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r8 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r4.changed((java.lang.Object) r0)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r8
            goto L_0x002b
        L_0x002a:
            r2 = r8
        L_0x002b:
            r3 = r25 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r8 & 48
            if (r3 != 0) goto L_0x0045
            r3 = r18
            boolean r5 = r4.changedInstance(r3)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r3 = r18
        L_0x0047:
            r5 = r25 & 4
            if (r5 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r5 = r8 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0061
            r5 = r19
            boolean r6 = r4.changedInstance(r5)
            if (r6 == 0) goto L_0x005d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r6
            goto L_0x0063
        L_0x0061:
            r5 = r19
        L_0x0063:
            r6 = r25 & 8
            if (r6 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r9 = r8 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007d
            r9 = r20
            boolean r10 = r4.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0079
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r10
            goto L_0x007f
        L_0x007d:
            r9 = r20
        L_0x007f:
            r10 = r25 & 16
            if (r10 == 0) goto L_0x0086
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0099
            r11 = r21
            boolean r12 = r4.changed((boolean) r11)
            if (r12 == 0) goto L_0x0095
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r12
            goto L_0x009b
        L_0x0099:
            r11 = r21
        L_0x009b:
            r12 = r25 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a3
            r2 = r2 | r13
            goto L_0x00b3
        L_0x00a3:
            r12 = r8 & r13
            if (r12 != 0) goto L_0x00b3
            boolean r12 = r4.changedInstance(r7)
            if (r12 == 0) goto L_0x00b0
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r2 = r2 | r12
        L_0x00b3:
            r12 = 74899(0x12493, float:1.04956E-40)
            r12 = r12 & r2
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r13) goto L_0x00c9
            boolean r12 = r4.getSkipping()
            if (r12 != 0) goto L_0x00c3
            goto L_0x00c9
        L_0x00c3:
            r4.skipToGroupEnd()
        L_0x00c6:
            r5 = r11
            goto L_0x01cd
        L_0x00c9:
            if (r6 == 0) goto L_0x00d0
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r9 = r6
        L_0x00d0:
            r6 = 1
            if (r10 == 0) goto L_0x00d4
            r11 = r6
        L_0x00d4:
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00e0
            r10 = -1
            java.lang.String r12 = "androidx.compose.foundation.contextmenu.ContextMenuArea (ContextMenuArea.android.kt:44)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r2, r10, r12)
        L_0x00e0:
            if (r11 == 0) goto L_0x00e7
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.contextMenuGestures(r9, r0)
            goto L_0x00e8
        L_0x00e7:
            r1 = r9
        L_0x00e8:
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r12 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r10, r12)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r10, r6)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r12 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r10, r12)
            r10 = 0
            int r10 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r4, r10)
            androidx.compose.runtime.CompositionLocalMap r12 = r4.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            r14 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r15 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r14, r15)
            androidx.compose.runtime.Applier r14 = r4.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0128
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0128:
            r4.startReusableNode()
            boolean r14 = r4.getInserting()
            if (r14 == 0) goto L_0x0135
            r4.createNode(r13)
            goto L_0x0138
        L_0x0135:
            r4.useNode()
        L_0x0138:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m3675constructorimpl(r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r6, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r12, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r12 = r13.getInserting()
            if (r12 != 0) goto L_0x0168
            java.lang.Object r12 = r13.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)
            if (r12 != 0) goto L_0x0176
        L_0x0168:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r13.updateRememberedValue(r12)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r13.apply(r10, r6)
        L_0x0176:
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r1, r6)
            r1 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r6 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r6)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = -1754330561(0xffffffff976f0a3f, float:-7.7237997E-25)
            java.lang.String r6 = "C47@1926L9,48@1944L146:ContextMenuArea.android.kt#3xeu6s"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r6)
            int r1 = r2 >> 15
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r7.invoke(r4, r1)
            r1 = r2 & 126(0x7e, float:1.77E-43)
            int r2 = r2 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r6 = 4
            r2 = 0
            r16 = r5
            r5 = r1
            r1 = r3
            r3 = r16
            ContextMenu(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r4.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00c6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x00c6
        L_0x01cd:
            androidx.compose.runtime.ScopeUpdateScope r10 = r4.endRestartGroup()
            if (r10 == 0) goto L_0x01e8
            androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt$ContextMenuArea$2 r0 = new androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt$ContextMenuArea$2
            r1 = r17
            r2 = r18
            r3 = r19
            r6 = r7
            r7 = r8
            r4 = r9
            r8 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt.ContextMenuArea(androidx.compose.foundation.contextmenu.ContextMenuState, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void ContextMenu(ContextMenuState contextMenuState, Function0<Unit> function0, Modifier modifier, Function1<? super ContextMenuScope, Unit> function1, Composer composer, int i, int i2) {
        int i3;
        Composer composer2;
        Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(645832757);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenu)P(3,2,1)67@2412L88,71@2506L197:ContextMenuArea.android.kt#3xeu6s");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) contextMenuState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
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
            i3 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(645832757, i3, -1, "androidx.compose.foundation.contextmenu.ContextMenu (ContextMenuArea.android.kt:63)");
            }
            ContextMenuState.Status status = contextMenuState.getStatus();
            if (!(status instanceof ContextMenuState.Status.Open)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new ContextMenuArea_androidKt$ContextMenu$1(contextMenuState, function0, modifier2, function1, i, i2));
                    return;
                }
                return;
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1573318964, "CC(remember):ContextMenuArea.android.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) status);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ContextMenuPopupPositionProvider(IntOffsetKt.m7257roundk4lQ0M(((ContextMenuState.Status.Open) status).m388getOffsetF1C5BW0()), (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            ContextMenuUi_androidKt.ContextMenuPopup((ContextMenuPopupPositionProvider) rememberedValue, function0, modifier2, function1, composer2, i3 & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new ContextMenuArea_androidKt$ContextMenu$2(contextMenuState, function0, modifier2, function1, i, i2));
        }
    }
}
