package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.android.kt */
final class Tooltip_androidKt$RichTooltip$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ RichTooltipColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Tooltip_androidKt$RichTooltip$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, RichTooltipColors richTooltipColors, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(2);
        this.$title = function2;
        this.$action = function22;
        this.$colors = richTooltipColors;
        this.$text = function23;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: type inference failed for: r19v0 */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r19v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r30, int r31) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            java.lang.String r3 = "C179@7066L5,180@7133L5,181@7210L5,183@7225L1355:Tooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 3
            r4 = 2
            if (r3 != r4) goto L_0x001b
            boolean r3 = r1.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001b
        L_0x0017:
            r1.skipToGroupEnd()
            return
        L_0x001b:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002a
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.android.kt:179)"
            r6 = 317290958(0x12e979ce, float:1.4734394E-27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r3, r5)
        L_0x002a:
            androidx.compose.material3.tokens.RichTooltipTokens r2 = androidx.compose.material3.tokens.RichTooltipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r2 = r2.getActionLabelTextFont()
            r3 = 6
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.material3.TypographyKt.getValue(r2, r1, r3)
            androidx.compose.material3.tokens.RichTooltipTokens r5 = androidx.compose.material3.tokens.RichTooltipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = r5.getSubheadFont()
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.material3.TypographyKt.getValue(r5, r1, r3)
            androidx.compose.material3.tokens.RichTooltipTokens r6 = androidx.compose.material3.tokens.RichTooltipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r6 = r6.getSupportingTextFont()
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.material3.TypographyKt.getValue(r6, r1, r3)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            float r7 = androidx.compose.material3.TooltipKt.getRichTooltipHorizontalPadding()
            r8 = 0
            r9 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.PaddingKt.m777paddingVpY3zN4$default(r6, r7, r8, r4, r9)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.$title
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r0.$action
            androidx.compose.material3.RichTooltipColors r11 = r0.$colors
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r12 = r0.$text
            r13 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            java.lang.String r14 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r13, r14)
            androidx.compose.foundation.layout.Arrangement r13 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r13 = r13.getTop()
            androidx.compose.ui.Alignment$Companion r14 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r14 = r14.getStart()
            r15 = 0
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r13, r14, r1, r15)
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r4 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r14, r4)
            int r16 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r15)
            androidx.compose.runtime.CompositionLocalMap r14 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r17.getConstructor()
            r8 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r9 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r9)
            androidx.compose.runtime.Applier r8 = r1.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x00a5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00a5:
            r1.startReusableNode()
            boolean r8 = r1.getInserting()
            if (r8 == 0) goto L_0x00b2
            r1.createNode(r15)
            goto L_0x00b5
        L_0x00b2:
            r1.useNode()
        L_0x00b5:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m3675constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r13, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r14, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            boolean r14 = r8.getInserting()
            if (r14 != 0) goto L_0x00e5
            java.lang.Object r14 = r8.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r16)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r14 != 0) goto L_0x00f3
        L_0x00e5:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)
            r8.updateRememberedValue(r14)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)
            r8.apply(r14, r13)
        L_0x00f3:
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r8, r6, r13)
            r6 = -384862393(0xffffffffe90f7747, float:-1.0839979E25)
            java.lang.String r8 = "C87@4365L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r8)
            androidx.compose.foundation.layout.ColumnScopeInstance r6 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r6 = (androidx.compose.foundation.layout.ColumnScope) r6
            r6 = -459254051(0xffffffffe4a056dd, float:-2.3661906E22)
            java.lang.String r8 = "C193@7718L319:Tooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r8)
            r6 = 955016030(0x38ec635e, float:1.12718655E-4)
            r1.startReplaceGroup(r6)
            java.lang.String r6 = "*185@7347L344"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r6)
            java.lang.String r6 = "C73@3429L9:Box.kt#2w3rfo"
            java.lang.String r13 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            r14 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            if (r7 != 0) goto L_0x012c
            r21 = r10
            r20 = r11
            r19 = 1
            goto L_0x021f
        L_0x012c:
            androidx.compose.ui.Modifier$Companion r16 = androidx.compose.ui.Modifier.Companion
            r19 = 1
            r15 = r16
            androidx.compose.ui.Modifier r15 = (androidx.compose.ui.Modifier) r15
            float r8 = androidx.compose.material3.TooltipKt.getHeightToSubheadFirstLine()
            r21 = r10
            r20 = r11
            r0 = 0
            r10 = 2
            r11 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.AlignmentLineKt.m596paddingFromBaselineVpY3zN4$default(r15, r8, r11, r10, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r14, r13)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r10 = 0
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r0, r10)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r11, r4)
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r10)
            androidx.compose.runtime.CompositionLocalMap r10 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r1, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            r14 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r14, r9)
            androidx.compose.runtime.Applier r14 = r1.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x017a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x017a:
            r1.startReusableNode()
            boolean r14 = r1.getInserting()
            if (r14 == 0) goto L_0x0187
            r1.createNode(r15)
            goto L_0x018a
        L_0x0187:
            r1.useNode()
        L_0x018a:
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m3675constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r14, r0, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r14, r10, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r10 = r14.getInserting()
            if (r10 != 0) goto L_0x01ba
            java.lang.Object r10 = r14.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r11)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r15)
            if (r10 != 0) goto L_0x01c8
        L_0x01ba:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            r14.updateRememberedValue(r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            r14.apply(r10, r0)
        L_0x01c8:
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r14, r8, r0)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r6)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 1468424960(0x57866300, float:2.9551952E14)
            java.lang.String r8 = "C186@7446L227:Tooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r8)
            r10 = 2
            androidx.compose.runtime.ProvidedValue[] r0 = new androidx.compose.runtime.ProvidedValue[r10]
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            long r10 = r20.m2383getTitleContentColor0d7_KjU()
            androidx.compose.ui.graphics.Color r10 = androidx.compose.ui.graphics.Color.m4229boximpl(r10)
            androidx.compose.runtime.ProvidedValue r8 = r8.provides(r10)
            r18 = 0
            r0[r18] = r8
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.ProvidedValue r5 = r8.provides(r5)
            r0[r19] = r5
            int r5 = androidx.compose.runtime.ProvidedValue.$stable
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r0, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (androidx.compose.runtime.Composer) r1, (int) r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r1.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x021f:
            r1.endReplaceGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            if (r7 == 0) goto L_0x022b
            r5 = r19
            goto L_0x022c
        L_0x022b:
            r5 = 0
        L_0x022c:
            if (r21 == 0) goto L_0x0231
            r7 = r19
            goto L_0x0232
        L_0x0231:
            r7 = 0
        L_0x0232:
            androidx.compose.ui.Modifier r0 = androidx.compose.material3.TooltipKt.textVerticalPadding(r0, r5, r7)
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r13)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r10 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r5, r10)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r11, r4)
            int r7 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r10)
            androidx.compose.runtime.CompositionLocalMap r8 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r1, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            r14 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r14, r9)
            androidx.compose.runtime.Applier r11 = r1.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0270
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0270:
            r1.startReusableNode()
            boolean r11 = r1.getInserting()
            if (r11 == 0) goto L_0x027d
            r1.createNode(r10)
            goto L_0x0280
        L_0x027d:
            r1.useNode()
        L_0x0280:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m3675constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r8, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            boolean r8 = r10.getInserting()
            if (r8 != 0) goto L_0x02b0
            java.lang.Object r8 = r10.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r11)
            if (r8 != 0) goto L_0x02be
        L_0x02b0:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r10.updateRememberedValue(r8)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10.apply(r7, r5)
        L_0x02be:
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r0, r5)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r6)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1959181329(0xffffffff8b3943ef, float:-3.5680812E-32)
            java.lang.String r5 = "C194@7812L211:Tooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r5)
            r10 = 2
            androidx.compose.runtime.ProvidedValue[] r0 = new androidx.compose.runtime.ProvidedValue[r10]
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            long r7 = r20.m2382getContentColor0d7_KjU()
            androidx.compose.ui.graphics.Color r7 = androidx.compose.ui.graphics.Color.m4229boximpl(r7)
            androidx.compose.runtime.ProvidedValue r5 = r5.provides(r7)
            r18 = 0
            r0[r18] = r5
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.ProvidedValue r3 = r5.provides(r3)
            r0[r19] = r3
            int r3 = androidx.compose.runtime.ProvidedValue.$stable
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r0, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r12, (androidx.compose.runtime.Composer) r1, (int) r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r1.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r0 = 955039618(0x38ecbf82, float:1.1289028E-4)
            r1.startReplaceGroup(r0)
            java.lang.String r0 = "*201@8080L476"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            if (r21 != 0) goto L_0x0320
            goto L_0x0422
        L_0x0320:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r3 = androidx.compose.material3.TooltipKt.getActionLabelMinHeight()
            r5 = 0
            r10 = 2
            r11 = 0
            androidx.compose.ui.Modifier r22 = androidx.compose.foundation.layout.SizeKt.m836requiredHeightInVpY3zN4$default(r0, r3, r11, r10, r5)
            float r26 = androidx.compose.material3.TooltipKt.getActionLabelBottomPadding()
            r27 = 7
            r28 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m779paddingqDBjuR0$default(r22, r23, r24, r25, r26, r27, r28)
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r13)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r10 = 0
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r3, r10)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r11, r4)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r10)
            androidx.compose.runtime.CompositionLocalMap r5 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r1, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            r14 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r14, r9)
            androidx.compose.runtime.Applier r8 = r1.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x037b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x037b:
            r1.startReusableNode()
            boolean r8 = r1.getInserting()
            if (r8 == 0) goto L_0x0388
            r1.createNode(r7)
            goto L_0x038b
        L_0x0388:
            r1.useNode()
        L_0x038b:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3675constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r3, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r5, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r5 = r7.getInserting()
            if (r5 != 0) goto L_0x03bb
            java.lang.Object r5 = r7.rememberedValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)
            if (r5 != 0) goto L_0x03c9
        L_0x03bb:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r7.updateRememberedValue(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.apply(r4, r3)
        L_0x03c9:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r0, r3)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r6)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = 1469278235(0x5793681b, float:3.24150678E14)
            java.lang.String r3 = "C206@8306L232:Tooltip.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r3)
            r10 = 2
            androidx.compose.runtime.ProvidedValue[] r0 = new androidx.compose.runtime.ProvidedValue[r10]
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            long r4 = r20.m2380getActionContentColor0d7_KjU()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m4229boximpl(r4)
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r4)
            r18 = 0
            r0[r18] = r3
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.ProvidedValue r2 = r3.provides(r2)
            r0[r19] = r2
            int r2 = androidx.compose.runtime.ProvidedValue.$stable
            r3 = r21
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r0, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r3, (androidx.compose.runtime.Composer) r1, (int) r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r1.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0422:
            r1.endReplaceGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r1.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0440
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0440:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Tooltip_androidKt$RichTooltip$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
