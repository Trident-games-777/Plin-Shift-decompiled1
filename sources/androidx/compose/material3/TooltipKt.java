package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\u001al\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020!0%¢\u0006\u0002\b'¢\u0006\u0002\b(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020!01¢\u0006\u0002\b'H\u0007¢\u0006\u0002\u00102\u001a&\u00103\u001a\u00020*2\b\b\u0002\u00104\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020.2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a+\u00108\u001a\u00020*2\b\b\u0002\u00104\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020.2\b\b\u0002\u00106\u001a\u000207H\u0007¢\u0006\u0002\u00109\u001a\u001a\u0010:\u001a\u00020,*\u00020,2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020.0<H\u0000\u001a\u001c\u0010=\u001a\u00020,*\u00020,2\u0006\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020.H\u0001\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\t\u0010\u0003\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0003\"\u0010\u0010\u0011\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0012\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u0003\"\u0016\u0010\u0014\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0017\u0010\u0003\"\u0010\u0010\u0018\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0019\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001d\u0010\u0003\"\u0016\u0010\u001e\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001f\u0010\u0003¨\u0006@²\u0006\n\u0010A\u001a\u00020BX\u0002²\u0006\n\u0010C\u001a\u00020BX\u0002"}, d2 = {"ActionLabelBottomPadding", "Landroidx/compose/ui/unit/Dp;", "getActionLabelBottomPadding", "()F", "F", "ActionLabelMinHeight", "getActionLabelMinHeight", "HeightFromSubheadToTextFirstLine", "HeightToSubheadFirstLine", "getHeightToSubheadFirstLine", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "PlainTooltipHorizontalPadding", "PlainTooltipMaxWidth", "getPlainTooltipMaxWidth", "PlainTooltipVerticalPadding", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "RichTooltipMaxWidth", "getRichTooltipMaxWidth", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "TextBottomPadding", "TooltipFadeInDuration", "", "TooltipFadeOutDuration", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "TooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "Lkotlin/Function0;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "rememberTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "textVerticalPadding", "subheadExists", "actionExists", "material3_release", "scale", "", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
public final class TooltipKt {
    private static final float ActionLabelBottomPadding;
    private static final float ActionLabelMinHeight = Dp.m7111constructorimpl((float) 36);
    private static final float HeightFromSubheadToTextFirstLine;
    private static final float HeightToSubheadFirstLine = Dp.m7111constructorimpl((float) 28);
    private static final PaddingValues PlainTooltipContentPadding;
    private static final float PlainTooltipHorizontalPadding;
    private static final float PlainTooltipMaxWidth = Dp.m7111constructorimpl((float) 200);
    private static final float PlainTooltipVerticalPadding;
    private static final float RichTooltipHorizontalPadding;
    private static final float RichTooltipMaxWidth = Dp.m7111constructorimpl((float) 320);
    private static final float SpacingBetweenTooltipAndAnchor;
    private static final float TextBottomPadding;
    public static final int TooltipFadeInDuration = 150;
    public static final int TooltipFadeOutDuration = 75;
    private static final float TooltipMinHeight;
    private static final float TooltipMinWidth = Dp.m7111constructorimpl((float) 40);

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TooltipBox(androidx.compose.ui.window.PopupPositionProvider r17, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TooltipScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.material3.TooltipState r19, androidx.compose.ui.Modifier r20, boolean r21, boolean r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r2 = r18
            r3 = r19
            r0 = r23
            r1 = r25
            r4 = 1836749106(0x6d7a9132, float:4.846674E27)
            r5 = r24
            androidx.compose.runtime.Composer r10 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(TooltipBox)P(4,6,5,3,2,1)133@5704L64,134@5826L33,135@5876L52,137@5979L103,143@6168L64,141@6088L310:Tooltip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            r5 = r26 & 1
            if (r5 == 0) goto L_0x0020
            r5 = r1 | 6
            r7 = r5
            r5 = r17
            goto L_0x0034
        L_0x0020:
            r5 = r1 & 6
            if (r5 != 0) goto L_0x0031
            r5 = r17
            boolean r7 = r10.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x002e
            r7 = 4
            goto L_0x002f
        L_0x002e:
            r7 = 2
        L_0x002f:
            r7 = r7 | r1
            goto L_0x0034
        L_0x0031:
            r5 = r17
            r7 = r1
        L_0x0034:
            r8 = r26 & 2
            if (r8 == 0) goto L_0x003b
            r7 = r7 | 48
            goto L_0x004b
        L_0x003b:
            r8 = r1 & 48
            if (r8 != 0) goto L_0x004b
            boolean r8 = r10.changedInstance(r2)
            if (r8 == 0) goto L_0x0048
            r8 = 32
            goto L_0x004a
        L_0x0048:
            r8 = 16
        L_0x004a:
            r7 = r7 | r8
        L_0x004b:
            r8 = r26 & 4
            if (r8 == 0) goto L_0x0052
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0052:
            r8 = r1 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x006b
            r8 = r1 & 512(0x200, float:7.175E-43)
            if (r8 != 0) goto L_0x005f
            boolean r8 = r10.changed((java.lang.Object) r3)
            goto L_0x0063
        L_0x005f:
            boolean r8 = r10.changedInstance(r3)
        L_0x0063:
            if (r8 == 0) goto L_0x0068
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r7 = r7 | r8
        L_0x006b:
            r8 = r26 & 8
            if (r8 == 0) goto L_0x0072
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0072:
            r9 = r1 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0085
            r9 = r20
            boolean r11 = r10.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x0081
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r7 = r7 | r11
            goto L_0x0087
        L_0x0085:
            r9 = r20
        L_0x0087:
            r11 = r26 & 16
            if (r11 == 0) goto L_0x008e
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008e:
            r12 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x00a1
            r12 = r21
            boolean r13 = r10.changed((boolean) r12)
            if (r13 == 0) goto L_0x009d
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r7 = r7 | r13
            goto L_0x00a3
        L_0x00a1:
            r12 = r21
        L_0x00a3:
            r13 = r26 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00ab
            r7 = r7 | r14
            goto L_0x00bd
        L_0x00ab:
            r14 = r14 & r1
            if (r14 != 0) goto L_0x00bd
            r14 = r22
            boolean r15 = r10.changed((boolean) r14)
            if (r15 == 0) goto L_0x00b9
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r7 = r7 | r15
            goto L_0x00bf
        L_0x00bd:
            r14 = r22
        L_0x00bf:
            r15 = r26 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c8
            r7 = r7 | r16
            goto L_0x00d8
        L_0x00c8:
            r15 = r1 & r16
            if (r15 != 0) goto L_0x00d8
            boolean r15 = r10.changedInstance(r0)
            if (r15 == 0) goto L_0x00d5
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r7 = r7 | r15
        L_0x00d8:
            r15 = 599187(0x92493, float:8.3964E-40)
            r15 = r15 & r7
            r6 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r6) goto L_0x00f0
            boolean r6 = r10.getSkipping()
            if (r6 != 0) goto L_0x00e8
            goto L_0x00f0
        L_0x00e8:
            r10.skipToGroupEnd()
            r4 = r9
            r5 = r12
            r6 = r14
            goto L_0x01ac
        L_0x00f0:
            if (r8 == 0) goto L_0x00f7
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x00f8
        L_0x00f7:
            r6 = r9
        L_0x00f8:
            r8 = 1
            if (r11 == 0) goto L_0x00fc
            r12 = r8
        L_0x00fc:
            if (r13 == 0) goto L_0x00ff
            r14 = r8
        L_0x00ff:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x010b
            r9 = -1
            java.lang.String r11 = "androidx.compose.material3.TooltipBox (Tooltip.kt:131)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r7, r9, r11)
        L_0x010b:
            androidx.compose.animation.core.MutableTransitionState r4 = r3.getTransition()
            int r9 = androidx.compose.animation.core.MutableTransitionState.$stable
            r9 = r9 | 48
            r11 = 0
            java.lang.String r13 = "tooltip transition"
            androidx.compose.animation.core.Transition r4 = androidx.compose.animation.core.TransitionKt.updateTransition(r4, (java.lang.String) r13, (androidx.compose.runtime.Composer) r10, (int) r9, (int) r11)
            r9 = -1495108980(0xffffffffa6e2728c, float:-1.5712948E-15)
            java.lang.String r11 = "CC(remember):Tooltip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r9, r11)
            java.lang.Object r9 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r9 != r13) goto L_0x0138
            r9 = 0
            r13 = 2
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r9, r9, r13, r9)
            r10.updateRememberedValue(r9)
        L_0x0138:
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r13 = -1495107361(0xffffffffa6e278df, float:-1.5714662E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r13, r11)
            java.lang.Object r11 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r11 != r13) goto L_0x015e
            androidx.compose.material3.TooltipScopeImpl r11 = new androidx.compose.material3.TooltipScopeImpl
            androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1 r13 = new androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1
            r13.<init>(r9)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r11.<init>(r13)
            r10.updateRememberedValue(r11)
        L_0x015e:
            androidx.compose.material3.TooltipScopeImpl r11 = (androidx.compose.material3.TooltipScopeImpl) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1 r13 = new androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1
            r13.<init>(r9, r0)
            r9 = -1130808188(0xffffffffbc993c84, float:-0.018705614)
            r15 = 54
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r9, r8, r13, r10, r15)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            androidx.compose.material3.TooltipKt$TooltipBox$1 r13 = new androidx.compose.material3.TooltipKt$TooltipBox$1
            r13.<init>(r4, r2, r11)
            r4 = -149611544(0xfffffffff7151be8, float:-3.02429E33)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r8, r13, r10, r15)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r8 = r7 & 14
            r11 = 1572912(0x180030, float:2.204119E-39)
            r8 = r8 | r11
            r11 = r7 & 896(0x380, float:1.256E-42)
            r8 = r8 | r11
            r11 = r7 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r7
            r8 = r8 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r11
            r11 = r8 | r7
            r7 = r12
            r12 = 0
            r8 = r5
            r5 = r3
            r3 = r8
            r8 = r14
            androidx.compose.material3.internal.BasicTooltip_androidKt.BasicTooltipBox(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01a9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a9:
            r4 = r6
            r5 = r7
            r6 = r8
        L_0x01ac:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 == 0) goto L_0x01c5
            androidx.compose.material3.TooltipKt$TooltipBox$2 r0 = new androidx.compose.material3.TooltipKt$TooltipBox$2
            r3 = r19
            r7 = r23
            r9 = r26
            r8 = r1
            r1 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt.TooltipBox(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function3, androidx.compose.material3.TooltipState, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TooltipState rememberTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1413230530, "C(rememberTooltipState)436@18949L210:Tooltip.kt#uh7d8r");
        boolean z3 = false;
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1413230530, i, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:436)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1281295952, "CC(remember):Tooltip.kt#9igjgp");
        boolean z4 = (((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32;
        if ((((i & 896) ^ 384) > 256 && composer.changed((Object) mutatorMutex)) || (i & 384) == 256) {
            z3 = true;
        }
        boolean z5 = z4 | z3;
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TooltipStateImpl(z, z2, mutatorMutex);
            composer.updateRememberedValue(rememberedValue);
        }
        TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tooltipStateImpl;
    }

    public static /* synthetic */ TooltipState TooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return TooltipState(z, z2, mutatorMutex);
    }

    public static final TooltipState TooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex) {
        return new TooltipStateImpl(z, z2, mutatorMutex);
    }

    public static final Modifier textVerticalPadding(Modifier modifier, boolean z, boolean z2) {
        if (z || z2) {
            return PaddingKt.m779paddingqDBjuR0$default(AlignmentLineKt.m596paddingFromBaselineVpY3zN4$default(modifier, HeightFromSubheadToTextFirstLine, 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, (Object) null);
        }
        return PaddingKt.m777paddingVpY3zN4$default(modifier, 0.0f, PlainTooltipVerticalPadding, 1, (Object) null);
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    public static final float getPlainTooltipMaxWidth() {
        return PlainTooltipMaxWidth;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return PlainTooltipContentPadding;
    }

    public static final float getRichTooltipMaxWidth() {
        return RichTooltipMaxWidth;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }

    public static final float getHeightToSubheadFirstLine() {
        return HeightToSubheadFirstLine;
    }

    public static final float getActionLabelMinHeight() {
        return ActionLabelMinHeight;
    }

    public static final float getActionLabelBottomPadding() {
        return ActionLabelBottomPadding;
    }

    public static final Modifier animateTooltip(Modifier modifier, Transition<Boolean> transition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1(transition) : InspectableValueKt.getNoInspectorInfo(), new TooltipKt$animateTooltip$2(transition));
    }

    static {
        float f = (float) 4;
        SpacingBetweenTooltipAndAnchor = Dp.m7111constructorimpl(f);
        float f2 = (float) 24;
        TooltipMinHeight = Dp.m7111constructorimpl(f2);
        float r0 = Dp.m7111constructorimpl(f);
        PlainTooltipVerticalPadding = r0;
        float f3 = (float) 8;
        float r3 = Dp.m7111constructorimpl(f3);
        PlainTooltipHorizontalPadding = r3;
        PlainTooltipContentPadding = PaddingKt.m769PaddingValuesYgX7TsA(r3, r0);
        float f4 = (float) 16;
        RichTooltipHorizontalPadding = Dp.m7111constructorimpl(f4);
        HeightFromSubheadToTextFirstLine = Dp.m7111constructorimpl(f2);
        TextBottomPadding = Dp.m7111constructorimpl(f4);
        ActionLabelBottomPadding = Dp.m7111constructorimpl(f3);
    }
}
