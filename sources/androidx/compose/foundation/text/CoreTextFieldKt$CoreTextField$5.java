package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ Modifier $cursorModifier;
    final /* synthetic */ Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> $decorationBox;
    final /* synthetic */ Density $density;
    final /* synthetic */ Modifier $drawModifier;
    final /* synthetic */ Modifier $magnifierModifier;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ Modifier $onPositionedModifier;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
    final /* synthetic */ boolean $showHandleAndMagnifier;
    final /* synthetic */ LegacyTextFieldState $state;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$5(Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, int i2, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, Function1<? super TextLayoutResult, Unit> function1, OffsetMapping offsetMapping, Density density) {
        super(2);
        this.$decorationBox = function3;
        this.$state = legacyTextFieldState;
        this.$textStyle = textStyle;
        this.$minLines = i;
        this.$maxLines = i2;
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$value = textFieldValue;
        this.$visualTransformation = visualTransformation;
        this.$cursorModifier = modifier;
        this.$drawModifier = modifier2;
        this.$onPositionedModifier = modifier3;
        this.$magnifierModifier = modifier4;
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$manager = textFieldSelectionManager;
        this.$showHandleAndMagnifier = z;
        this.$readOnly = z2;
        this.$onTextLayout = function1;
        this.$offsetMapping = offsetMapping;
        this.$density = density;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C695@31947L4735,695@31933L4749:CoreTextField.kt#423gt5");
        if ((i2 & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374338080, i2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
            }
            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function3 = this.$decorationBox;
            final LegacyTextFieldState legacyTextFieldState = this.$state;
            final TextStyle textStyle = this.$textStyle;
            final int i3 = this.$minLines;
            final int i4 = this.$maxLines;
            final TextFieldScrollerPosition textFieldScrollerPosition = this.$scrollerPosition;
            final TextFieldValue textFieldValue = this.$value;
            final VisualTransformation visualTransformation = this.$visualTransformation;
            final Modifier modifier = this.$cursorModifier;
            final Modifier modifier2 = this.$drawModifier;
            final Modifier modifier3 = this.$onPositionedModifier;
            final Modifier modifier4 = this.$magnifierModifier;
            final BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
            final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
            final boolean z = this.$showHandleAndMagnifier;
            final boolean z2 = this.$readOnly;
            final Function1<TextLayoutResult, Unit> function1 = this.$onTextLayout;
            final OffsetMapping offsetMapping = this.$offsetMapping;
            final Density density = this.$density;
            function3.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C711@32801L22,720@33160L3512,720@33124L3548:CoreTextField.kt#423gt5");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2032502107, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                        }
                        Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m833heightInVpY3zN4$default(Modifier.Companion, legacyTextFieldState.m1212getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, (Object) null), textStyle, i3, i4);
                        TextFieldScrollerPosition textFieldScrollerPosition = textFieldScrollerPosition;
                        TextFieldValue textFieldValue = textFieldValue;
                        VisualTransformation visualTransformation = visualTransformation;
                        ComposerKt.sourceInformationMarkerStart(composer, 713189947, "CC(remember):CoreTextField.kt#9igjgp");
                        boolean changedInstance = composer.changedInstance(legacyTextFieldState);
                        LegacyTextFieldState legacyTextFieldState = legacyTextFieldState;
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1(legacyTextFieldState);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        Modifier bringIntoViewRequester = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition, textFieldValue, visualTransformation, (Function0) rememberedValue).then(modifier).then(modifier2), textStyle).then(modifier3).then(modifier4), bringIntoViewRequester);
                        final TextFieldSelectionManager textFieldSelectionManager = textFieldSelectionManager;
                        final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                        final boolean z = z;
                        final boolean z2 = z2;
                        final Function1<TextLayoutResult, Unit> function1 = function1;
                        final TextFieldValue textFieldValue2 = textFieldValue;
                        final OffsetMapping offsetMapping = offsetMapping;
                        final Density density = density;
                        final int i2 = i4;
                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARNING: Removed duplicated region for block: B:37:0x0113  */
                            /* JADX WARNING: Removed duplicated region for block: B:38:0x0127  */
                            /* JADX WARNING: Removed duplicated region for block: B:41:0x0136  */
                            /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void invoke(androidx.compose.runtime.Composer r11, int r12) {
                                /*
                                    r10 = this;
                                    java.lang.String r0 = "C721@33178L2880,776@36076L322:CoreTextField.kt#423gt5"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
                                    r0 = r12 & 3
                                    r1 = 2
                                    if (r0 != r1) goto L_0x0015
                                    boolean r0 = r11.getSkipping()
                                    if (r0 != 0) goto L_0x0011
                                    goto L_0x0015
                                L_0x0011:
                                    r11.skipToGroupEnd()
                                    return
                                L_0x0015:
                                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r0 == 0) goto L_0x0024
                                    r0 = -1
                                    java.lang.String r1 = "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)"
                                    r2 = -363167407(0xffffffffea5a8151, float:-6.6039127E25)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r2, r12, r0, r1)
                                L_0x0024:
                                    androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2
                                    androidx.compose.foundation.text.LegacyTextFieldState r4 = r2
                                    kotlin.jvm.functions.Function1<androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r5 = r5
                                    androidx.compose.ui.text.input.TextFieldValue r6 = r6
                                    androidx.compose.ui.text.input.OffsetMapping r7 = r7
                                    androidx.compose.ui.unit.Density r8 = r8
                                    int r9 = r9
                                    r3.<init>(r4, r5, r6, r7, r8, r9)
                                    androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
                                    r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                                    java.lang.String r0 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r12, r0)
                                    androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
                                    r0 = 0
                                    int r1 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r0)
                                    androidx.compose.runtime.CompositionLocalMap r2 = r11.getCurrentCompositionLocalMap()
                                    androidx.compose.ui.Modifier r12 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r11, r12)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
                                    r5 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
                                    java.lang.String r6 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
                                    androidx.compose.runtime.Applier r5 = r11.getApplier()
                                    boolean r5 = r5 instanceof androidx.compose.runtime.Applier
                                    if (r5 != 0) goto L_0x0069
                                    androidx.compose.runtime.ComposablesKt.invalidApplier()
                                L_0x0069:
                                    r11.startReusableNode()
                                    boolean r5 = r11.getInserting()
                                    if (r5 == 0) goto L_0x0076
                                    r11.createNode(r4)
                                    goto L_0x0079
                                L_0x0076:
                                    r11.useNode()
                                L_0x0079:
                                    androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m3675constructorimpl(r11)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
                                    androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r3, r5)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
                                    androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r2, r3)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
                                    boolean r3 = r4.getInserting()
                                    if (r3 != 0) goto L_0x00a9
                                    java.lang.Object r3 = r4.rememberedValue()
                                    java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
                                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
                                    if (r3 != 0) goto L_0x00b7
                                L_0x00a9:
                                    java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
                                    r4.updateRememberedValue(r3)
                                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                                    r4.apply(r1, r2)
                                L_0x00b7:
                                    androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
                                    androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r4, r12, r1)
                                    r12 = -1674249312(0xffffffff9c34fba0, float:-5.988222E-22)
                                    java.lang.String r1 = "C:CoreTextField.kt#423gt5"
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r12, r1)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
                                    r11.endNode()
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
                                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r12 = r1
                                    androidx.compose.foundation.text.LegacyTextFieldState r1 = r2
                                    androidx.compose.foundation.text.HandleState r1 = r1.getHandleState()
                                    androidx.compose.foundation.text.HandleState r2 = androidx.compose.foundation.text.HandleState.None
                                    if (r1 == r2) goto L_0x00fd
                                    androidx.compose.foundation.text.LegacyTextFieldState r1 = r2
                                    androidx.compose.ui.layout.LayoutCoordinates r1 = r1.getLayoutCoordinates()
                                    if (r1 == 0) goto L_0x00fd
                                    androidx.compose.foundation.text.LegacyTextFieldState r1 = r2
                                    androidx.compose.ui.layout.LayoutCoordinates r1 = r1.getLayoutCoordinates()
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                                    boolean r1 = r1.isAttached()
                                    if (r1 == 0) goto L_0x00fd
                                    boolean r1 = r3
                                    if (r1 == 0) goto L_0x00fd
                                    r1 = 1
                                    goto L_0x00fe
                                L_0x00fd:
                                    r1 = r0
                                L_0x00fe:
                                    androidx.compose.foundation.text.CoreTextFieldKt.access$SelectionToolbarAndHandles(r12, r1, r11, r0)
                                    androidx.compose.foundation.text.LegacyTextFieldState r12 = r2
                                    androidx.compose.foundation.text.HandleState r12 = r12.getHandleState()
                                    androidx.compose.foundation.text.HandleState r1 = androidx.compose.foundation.text.HandleState.Cursor
                                    if (r12 != r1) goto L_0x0127
                                    boolean r12 = r4
                                    if (r12 != 0) goto L_0x0127
                                    boolean r12 = r3
                                    if (r12 == 0) goto L_0x0127
                                    r12 = -2032274(0xffffffffffe0fd6e, float:NaN)
                                    r11.startReplaceGroup(r12)
                                    java.lang.String r12 = "789@36600L40"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
                                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r12 = r1
                                    androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle(r12, r11, r0)
                                    r11.endReplaceGroup()
                                    goto L_0x0130
                                L_0x0127:
                                    r12 = -1955394(0xffffffffffe229be, float:NaN)
                                    r11.startReplaceGroup(r12)
                                    r11.endReplaceGroup()
                                L_0x0130:
                                    boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r11 == 0) goto L_0x0139
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                L_0x0139:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.AnonymousClass1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }, composer, 54), composer, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }, composer2, 54), composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
