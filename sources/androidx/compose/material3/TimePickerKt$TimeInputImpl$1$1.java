package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1(MutableState<TextFieldValue> mutableState, TimePickerState timePickerState, TimePickerColors timePickerColors, MutableState<TextFieldValue> mutableState2) {
        super(2);
        this.$hourValue$delegate = mutableState;
        this.$state = timePickerState;
        this.$colors = timePickerColors;
        this.$minuteValue$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r9 = r25
            r1 = r26
            java.lang.String r2 = "C987@42239L3529:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r1 & 3
            r3 = 2
            if (r2 != r3) goto L_0x001b
            boolean r2 = r9.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x001b
        L_0x0017:
            r9.skipToGroupEnd()
            return
        L_0x001b:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x002a
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:987)"
            r4 = 1306700887(0x4de2ac57, float:4.7536816E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x002a:
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r1 = r0.$hourValue$delegate
            androidx.compose.material3.TimePickerState r4 = r0.$state
            androidx.compose.material3.TimePickerColors r8 = r0.$colors
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r12 = r0.$minuteValue$delegate
            r2 = 693286680(0x2952b718, float:4.6788176E-14)
            java.lang.String r3 = "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r3 = r3.getStart()
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r5 = r5.getTop()
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r3, r5, r9, r6)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r7 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r5, r7)
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r9, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            r10 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r11 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r10, r11)
            androidx.compose.runtime.Applier r10 = r9.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x007c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x007c:
            r9.startReusableNode()
            boolean r10 = r9.getInserting()
            if (r10 == 0) goto L_0x0089
            r9.createNode(r7)
            goto L_0x008c
        L_0x0089:
            r9.useNode()
        L_0x008c:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3675constructorimpl(r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r3, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r6, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r6 = r7.getInserting()
            if (r6 != 0) goto L_0x00bc
            java.lang.Object r6 = r7.rememberedValue()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r10)
            if (r6 != 0) goto L_0x00ca
        L_0x00bc:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r7.updateRememberedValue(r6)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7.apply(r5, r3)
        L_0x00ca:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r2, r3)
            r2 = -407918630(0xffffffffe7afa7da, float:-1.6590209E24)
            java.lang.String r3 = "C100@5047L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            androidx.compose.foundation.layout.RowScopeInstance r2 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r2 = (androidx.compose.foundation.layout.RowScope) r2
            r2 = -227350393(0xfffffffff272e887, float:-4.8112948E30)
            java.lang.String r3 = "C990@42357L529,1004@42963L451,1024@43854L52,988@42261L1727,1028@44005L123,1033@44248L422,1045@44749L429,1065@45620L52,1031@44145L1609:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = -284428440(0xffffffffef0bf768, float:-4.331751E28)
            java.lang.String r13 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r13)
            boolean r3 = r9.changed((java.lang.Object) r1)
            boolean r5 = r9.changedInstance(r4)
            r3 = r3 | r5
            java.lang.Object r5 = r9.rememberedValue()
            if (r3 != 0) goto L_0x010a
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x0115
        L_0x010a:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1$1 r3 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1$1
            r3.<init>(r4, r1)
            r5 = r3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r9.updateRememberedValue(r5)
        L_0x0115:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.key.KeyInputModifierKt.onKeyEvent(r2, r5)
            r3 = r2
            androidx.compose.ui.text.input.TextFieldValue r2 = androidx.compose.material3.TimePickerKt.TimeInputImpl$lambda$6(r1)
            r5 = -284409126(0xffffffffef0c42da, float:-4.340872E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r5, r13)
            boolean r5 = r9.changedInstance(r4)
            boolean r6 = r9.changed((java.lang.Object) r1)
            r5 = r5 | r6
            java.lang.Object r6 = r9.rememberedValue()
            if (r5 != 0) goto L_0x0140
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x014b
        L_0x0140:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$2$1 r5 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$2$1
            r5.<init>(r4, r1)
            r6 = r5
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r9.updateRememberedValue(r6)
        L_0x014b:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.material3.TimePickerSelectionMode$Companion r1 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r5 = r1.m2754getHouryecRtBI()
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r18 = r1.m6757getNexteUduSuo()
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r17 = r1.m6811getNumberPjHm6EE()
            androidx.compose.foundation.text.KeyboardOptions r14 = new androidx.compose.foundation.text.KeyboardOptions
            r22 = 115(0x73, float:1.61E-43)
            r23 = 0
            r15 = 0
            r16 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r14.<init>((int) r15, (java.lang.Boolean) r16, (int) r17, (int) r18, (androidx.compose.ui.text.input.PlatformImeOptions) r19, (java.lang.Boolean) r20, (androidx.compose.ui.text.intl.LocaleList) r21, (int) r22, (kotlin.jvm.internal.DefaultConstructorMarker) r23)
            r1 = -284381013(0xffffffffef0cb0ab, float:-4.354148E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r13)
            boolean r1 = r9.changedInstance(r4)
            java.lang.Object r7 = r9.rememberedValue()
            if (r1 != 0) goto L_0x018c
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r7 != r1) goto L_0x0197
        L_0x018c:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$3$1 r1 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$3$1
            r1.<init>(r4)
            r7 = r1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r9.updateRememberedValue(r7)
        L_0x0197:
            r18 = r7
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.foundation.text.KeyboardActions r15 = new androidx.compose.foundation.text.KeyboardActions
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 59
            r23 = 0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23)
            r10 = 24576(0x6000, float:3.4438E-41)
            r11 = 0
            r1 = r3
            r3 = r6
            r6 = r14
            r7 = r15
            androidx.compose.material3.TimePickerKt.m2721TimePickerTextField1vLObsk(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r2 = androidx.compose.material3.TimePickerKt.DisplaySeparatorWidth
            androidx.compose.material3.tokens.TimeInputTokens r3 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r3 = r3.m3555getPeriodSelectorContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m847sizeVpY3zN4(r1, r2, r3)
            r2 = 6
            androidx.compose.material3.TimePickerKt.DisplaySeparator(r1, r9, r2)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = -284368035(0xffffffffef0ce35d, float:-4.3602767E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r13)
            boolean r2 = r9.changed((java.lang.Object) r12)
            boolean r3 = r9.changedInstance(r4)
            r2 = r2 | r3
            java.lang.Object r3 = r9.rememberedValue()
            if (r2 != 0) goto L_0x01f2
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x01fd
        L_0x01f2:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$4$1 r2 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$4$1
            r2.<init>(r4, r12)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r9.updateRememberedValue(r3)
        L_0x01fd:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.key.KeyInputModifierKt.onPreviewKeyEvent(r1, r3)
            androidx.compose.ui.text.input.TextFieldValue r2 = androidx.compose.material3.TimePickerKt.TimeInputImpl$lambda$9(r12)
            r3 = -284351996(0xffffffffef0d2204, float:-4.367851E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r13)
            boolean r3 = r9.changedInstance(r4)
            boolean r5 = r9.changed((java.lang.Object) r12)
            r3 = r3 | r5
            java.lang.Object r5 = r9.rememberedValue()
            if (r3 != 0) goto L_0x0227
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x0232
        L_0x0227:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$5$1 r3 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$5$1
            r3.<init>(r4, r12)
            r5 = r3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r9.updateRememberedValue(r5)
        L_0x0232:
            r3 = r5
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.material3.TimePickerSelectionMode$Companion r5 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r5 = r5.m2755getMinuteyecRtBI()
            androidx.compose.ui.text.input.ImeAction$Companion r6 = androidx.compose.ui.text.input.ImeAction.Companion
            int r18 = r6.m6755getDoneeUduSuo()
            androidx.compose.ui.text.input.KeyboardType$Companion r6 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r17 = r6.m6811getNumberPjHm6EE()
            androidx.compose.foundation.text.KeyboardOptions r14 = new androidx.compose.foundation.text.KeyboardOptions
            r22 = 115(0x73, float:1.61E-43)
            r23 = 0
            r15 = 0
            r16 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r14.<init>((int) r15, (java.lang.Boolean) r16, (int) r17, (int) r18, (androidx.compose.ui.text.input.PlatformImeOptions) r19, (java.lang.Boolean) r20, (androidx.compose.ui.text.intl.LocaleList) r21, (int) r22, (kotlin.jvm.internal.DefaultConstructorMarker) r23)
            r6 = -284324501(0xffffffffef0d8d6b, float:-4.380835E28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r6, r13)
            boolean r6 = r9.changedInstance(r4)
            java.lang.Object r7 = r9.rememberedValue()
            if (r6 != 0) goto L_0x0274
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x027f
        L_0x0274:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$6$1 r6 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$6$1
            r6.<init>(r4)
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r9.updateRememberedValue(r7)
        L_0x027f:
            r18 = r7
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.foundation.text.KeyboardActions r15 = new androidx.compose.foundation.text.KeyboardActions
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 59
            r23 = 0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23)
            r10 = 24576(0x6000, float:3.4438E-41)
            r11 = 0
            r6 = r14
            r7 = r15
            androidx.compose.material3.TimePickerKt.m2721TimePickerTextField1vLObsk(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r25)
            r25.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r25)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02bc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
