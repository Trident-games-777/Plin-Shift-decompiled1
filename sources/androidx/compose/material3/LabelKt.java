package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\b\u001a^\u0010\t\u001a\u00020\u00012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"HandleInteractions", "", "enabled", "", "state", "Landroidx/compose/material3/TooltipState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "Label", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "isPersistent", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Label.kt */
public final class LabelKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0200  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Label(kotlin.jvm.functions.Function3<? super androidx.compose.material3.TooltipScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.ui.Modifier r21, androidx.compose.foundation.interaction.MutableInteractionSource r22, boolean r23, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r1 = r20
            r5 = r24
            r6 = r26
            r0 = -544399326(0xffffffffdf8d2022, float:-2.033833E19)
            r2 = r25
            androidx.compose.runtime.Composer r10 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Label)P(3,4,1,2)74@3254L38,79@3493L33,80@3543L52,82@3646L103,88@3835L17,86@3755L249,95@4009L127:Label.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r2 = r27 & 1
            r3 = 2
            if (r2 == 0) goto L_0x001c
            r2 = r6 | 6
            goto L_0x002c
        L_0x001c:
            r2 = r6 & 6
            if (r2 != 0) goto L_0x002b
            boolean r2 = r10.changedInstance(r1)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = r3
        L_0x0029:
            r2 = r2 | r6
            goto L_0x002c
        L_0x002b:
            r2 = r6
        L_0x002c:
            r4 = r27 & 2
            if (r4 == 0) goto L_0x0033
            r2 = r2 | 48
            goto L_0x0046
        L_0x0033:
            r7 = r6 & 48
            if (r7 != 0) goto L_0x0046
            r7 = r21
            boolean r8 = r10.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0042
            r8 = 32
            goto L_0x0044
        L_0x0042:
            r8 = 16
        L_0x0044:
            r2 = r2 | r8
            goto L_0x0048
        L_0x0046:
            r7 = r21
        L_0x0048:
            r8 = r27 & 4
            if (r8 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r9 = r6 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0062
            r9 = r22
            boolean r11 = r10.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x005e
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r11
            goto L_0x0064
        L_0x0062:
            r9 = r22
        L_0x0064:
            r11 = r27 & 8
            if (r11 == 0) goto L_0x006b
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r12 = r6 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007e
            r12 = r23
            boolean r13 = r10.changed((boolean) r12)
            if (r13 == 0) goto L_0x007a
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r13
            goto L_0x0080
        L_0x007e:
            r12 = r23
        L_0x0080:
            r13 = r27 & 16
            if (r13 == 0) goto L_0x0087
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0087:
            r13 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0097
            boolean r13 = r10.changedInstance(r5)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r13
        L_0x0097:
            r13 = r2 & 9363(0x2493, float:1.312E-41)
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00ac
            boolean r13 = r10.getSkipping()
            if (r13 != 0) goto L_0x00a4
            goto L_0x00ac
        L_0x00a4:
            r10.skipToGroupEnd()
            r2 = r7
            r3 = r9
            r4 = r12
            goto L_0x01fa
        L_0x00ac:
            if (r4 == 0) goto L_0x00b3
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00b4
        L_0x00b3:
            r4 = r7
        L_0x00b4:
            r13 = 0
            if (r8 == 0) goto L_0x00ba
            r17 = r13
            goto L_0x00bc
        L_0x00ba:
            r17 = r9
        L_0x00bc:
            r14 = 0
            if (r11 == 0) goto L_0x00c2
            r18 = r14
            goto L_0x00c4
        L_0x00c2:
            r18 = r12
        L_0x00c4:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00d0
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.Label (Label.kt:70)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r7, r8)
        L_0x00d0:
            r0 = 519104973(0x1ef0e9cd, float:2.5507686E-20)
            r10.startReplaceGroup(r0)
            java.lang.String r0 = "72@3116L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.String r0 = "CC(remember):Label.kt#9igjgp"
            if (r17 != 0) goto L_0x00ff
            r7 = 519105624(0x1ef0ec58, float:2.5508738E-20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r7, r0)
            java.lang.Object r7 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r7 != r8) goto L_0x00f8
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r7)
        L_0x00f8:
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = (androidx.compose.foundation.interaction.MutableInteractionSource) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r15 = r7
            goto L_0x0101
        L_0x00ff:
            r15 = r17
        L_0x0101:
            r10.endReplaceGroup()
            androidx.compose.material3.TooltipDefaults r7 = androidx.compose.material3.TooltipDefaults.INSTANCE
            r8 = 0
            r9 = 48
            r11 = 1
            androidx.compose.ui.window.PopupPositionProvider r16 = r7.m2848rememberPlainTooltipPositionProviderkHDZbjc(r8, r10, r9, r11)
            if (r18 == 0) goto L_0x0142
            r7 = -1087377900(0xffffffffbf2fee14, float:-0.68722653)
            r10.startReplaceGroup(r7)
            java.lang.String r7 = "76@3335L29"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r7)
            r7 = 519112622(0x1ef107ae, float:2.5520044E-20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r7, r0)
            java.lang.Object r7 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r7 != r8) goto L_0x0136
            androidx.compose.material3.LabelStateImpl r7 = new androidx.compose.material3.LabelStateImpl
            r8 = 3
            r7.<init>(r14, r14, r8, r13)
            r10.updateRememberedValue(r7)
        L_0x0136:
            androidx.compose.material3.LabelStateImpl r7 = (androidx.compose.material3.LabelStateImpl) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r10.endReplaceGroup()
            androidx.compose.material3.TooltipState r7 = (androidx.compose.material3.TooltipState) r7
            r14 = r11
            goto L_0x0163
        L_0x0142:
            r7 = 519114025(0x1ef10d29, float:2.552231E-20)
            r10.startReplaceGroup(r7)
            java.lang.String r7 = "77@3378L56"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r7)
            androidx.compose.foundation.MutatorMutex r9 = new androidx.compose.foundation.MutatorMutex
            r9.<init>()
            r7 = r11
            r11 = 0
            r12 = 3
            r8 = r7
            r7 = 0
            r19 = r8
            r8 = 0
            r14 = r19
            androidx.compose.material3.TooltipState r7 = androidx.compose.material3.internal.BasicTooltipKt.rememberBasicTooltipState(r7, r8, r9, r10, r11, r12)
            r10.endReplaceGroup()
        L_0x0163:
            r9 = r7
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r8 = 519117682(0x1ef11b72, float:2.5528219E-20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r8, r0)
            java.lang.Object r8 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r8 != r11) goto L_0x0182
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r13, r3, r13)
            r10.updateRememberedValue(r8)
        L_0x0182:
            androidx.compose.runtime.MutableState r8 = (androidx.compose.runtime.MutableState) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r7.element = r8
            r3 = 519119301(0x1ef121c5, float:2.5530834E-20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r0)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r0 != r3) goto L_0x01aa
            androidx.compose.material3.TooltipScopeImpl r0 = new androidx.compose.material3.TooltipScopeImpl
            androidx.compose.material3.LabelKt$Label$scope$1$1 r3 = new androidx.compose.material3.LabelKt$Label$scope$1$1
            r3.<init>(r7)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r0.<init>(r3)
            r10.updateRememberedValue(r0)
        L_0x01aa:
            androidx.compose.material3.TooltipScopeImpl r0 = (androidx.compose.material3.TooltipScopeImpl) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.material3.LabelKt$Label$wrappedContent$1 r3 = new androidx.compose.material3.LabelKt$Label$wrappedContent$1
            r3.<init>(r7, r5)
            r7 = 1950723216(0x7445ac90, float:6.2645414E31)
            r8 = 54
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r14, r3, r10, r8)
            r13 = r3
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            androidx.compose.material3.LabelKt$Label$1 r3 = new androidx.compose.material3.LabelKt$Label$1
            r3.<init>(r1, r0)
            r0 = 784196780(0x2ebde4ac, float:8.635345E-11)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r14, r3, r10, r8)
            r8 = r0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            int r0 = r2 << 6
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = 1794096(0x1b6030, float:2.514064E-39)
            r0 = r0 | r2
            r7 = r16
            r16 = 0
            r11 = 0
            r12 = 0
            r2 = r15
            r15 = r0
            r0 = r2
            r14 = r10
            r2 = 0
            r10 = r4
            androidx.compose.material3.internal.BasicTooltip_androidKt.BasicTooltipBox(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r10 = r14
            r3 = r18 ^ 1
            HandleInteractions(r3, r9, r0, r10, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01f5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f5:
            r2 = r4
            r3 = r17
            r4 = r18
        L_0x01fa:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 == 0) goto L_0x020c
            androidx.compose.material3.LabelKt$Label$2 r0 = new androidx.compose.material3.LabelKt$Label$2
            r7 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x020c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.LabelKt.Label(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.foundation.interaction.MutableInteractionSource, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void HandleInteractions(boolean z, TooltipState tooltipState, MutableInteractionSource mutableInteractionSource, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-627258109);
        ComposerKt.sourceInformation(startRestartGroup, "C(HandleInteractions)P(!1,2)110@4384L587,110@4350L621:Label.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed((Object) tooltipState) : startRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627258109, i2, -1, "androidx.compose.material3.HandleInteractions (Label.kt:108)");
            }
            if (z) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 354570583, "CC(remember):Label.kt#9igjgp");
                boolean z2 = true;
                boolean z3 = (i2 & 896) == 256;
                if ((i2 & 112) != 32 && ((i2 & 64) == 0 || !startRestartGroup.changedInstance(tooltipState))) {
                    z2 = false;
                }
                boolean z4 = z3 | z2;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new LabelKt$HandleInteractions$1$1(mutableInteractionSource, tooltipState, (Continuation<? super LabelKt$HandleInteractions$1$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.LaunchedEffect((Object) mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue, startRestartGroup, (i2 >> 6) & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LabelKt$HandleInteractions$2(z, tooltipState, mutableInteractionSource, i));
        }
    }
}
