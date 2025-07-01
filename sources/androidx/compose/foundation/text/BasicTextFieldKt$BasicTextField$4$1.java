package androidx.compose.foundation.text;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.internal.TextFieldCoreModifier;
import androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$BasicTextField$4$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ TextFieldDecorator $decorator;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $isDragHovered;
    final /* synthetic */ boolean $isFocused;
    final /* synthetic */ boolean $isWindowFocused;
    final /* synthetic */ TextFieldLineLimits $lineLimits;
    final /* synthetic */ Function2<Density, Function0<TextLayoutResult>, Unit> $onTextLayout;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ TextFieldSelectionState $textFieldSelectionState;
    final /* synthetic */ TextLayoutState $textLayoutState;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ TransformedTextFieldState $transformedState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextFieldKt$BasicTextField$4$1(TextFieldDecorator textFieldDecorator, TextFieldLineLimits textFieldLineLimits, TextLayoutState textLayoutState, TextStyle textStyle, boolean z, boolean z2, boolean z3, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z4, boolean z5, ScrollState scrollState, Orientation orientation, boolean z6, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        super(2);
        this.$decorator = textFieldDecorator;
        this.$lineLimits = textFieldLineLimits;
        this.$textLayoutState = textLayoutState;
        this.$textStyle = textStyle;
        this.$isFocused = z;
        this.$isWindowFocused = z2;
        this.$isDragHovered = z3;
        this.$transformedState = transformedTextFieldState;
        this.$textFieldSelectionState = textFieldSelectionState;
        this.$cursorBrush = brush;
        this.$enabled = z4;
        this.$readOnly = z5;
        this.$scrollState = scrollState;
        this.$orientation = orientation;
        this.$singleLine = z6;
        this.$onTextLayout = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C345@17737L2847,345@17726L2858:BasicTextField.kt#423gt5");
        if ((i2 & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-673241599, i2, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:344)");
            }
            TextFieldDecorator textFieldDecorator = this.$decorator;
            if (textFieldDecorator == null) {
                textFieldDecorator = BasicTextFieldKt.DefaultTextFieldDecorator;
            }
            final TextFieldLineLimits textFieldLineLimits = this.$lineLimits;
            final TextLayoutState textLayoutState = this.$textLayoutState;
            final TextStyle textStyle = this.$textStyle;
            final boolean z = this.$isFocused;
            final boolean z2 = this.$isWindowFocused;
            final boolean z3 = this.$isDragHovered;
            final TransformedTextFieldState transformedTextFieldState = this.$transformedState;
            final TextFieldSelectionState textFieldSelectionState = this.$textFieldSelectionState;
            final Brush brush = this.$cursorBrush;
            final boolean z4 = this.$enabled;
            final boolean z5 = this.$readOnly;
            final ScrollState scrollState = this.$scrollState;
            final Orientation orientation = this.$orientation;
            final boolean z6 = this.$singleLine;
            final Function2<Density, Function0<TextLayoutResult>, Unit> function2 = this.$onTextLayout;
            textFieldDecorator.Decoration(ComposableLambdaKt.rememberComposableLambda(1969169726, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    int i2;
                    int i3;
                    Composer composer2 = composer;
                    int i4 = i;
                    ComposerKt.sourceInformation(composer2, "C356@18098L2472:BasicTextField.kt#423gt5");
                    if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1969169726, i4, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:346)");
                        }
                        TextFieldLineLimits textFieldLineLimits = textFieldLineLimits;
                        if (textFieldLineLimits instanceof TextFieldLineLimits.MultiLine) {
                            i3 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits).getMinHeightInLines();
                            i2 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits).getMaxHeightInLines();
                        } else {
                            i3 = 1;
                            i2 = 1;
                        }
                        Modifier then = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m833heightInVpY3zN4$default(Modifier.Companion, textLayoutState.m1431getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, (Object) null), textStyle, i3, i2), textStyle)).then(new TextFieldCoreModifier(z && z2, z3, textLayoutState, transformedTextFieldState, textFieldSelectionState, brush, z4 && !z5, scrollState, orientation));
                        TextLayoutState textLayoutState = textLayoutState;
                        TransformedTextFieldState transformedTextFieldState = transformedTextFieldState;
                        TextStyle textStyle = textStyle;
                        boolean z = z6;
                        Function2<Density, Function0<TextLayoutResult>, Unit> function2 = function2;
                        boolean z2 = z4;
                        boolean z3 = z;
                        boolean z4 = z2;
                        TextFieldSelectionState textFieldSelectionState = textFieldSelectionState;
                        boolean z5 = z5;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, then);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        boolean z6 = z2;
                        int i5 = currentCompositeKeyHash;
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer r0 = Updater.m3675constructorimpl(composer2);
                        Updater.m3682setimpl(r0, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3682setimpl(r0, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(i5))) {
                            r0.updateRememberedValue(Integer.valueOf(i5));
                            r0.apply(Integer.valueOf(i5), setCompositeKeyHash);
                        }
                        Updater.m3682setimpl(r0, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1326300454, "C381@19361L648:BasicTextField.kt#423gt5");
                        BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(Modifier.Companion, textLayoutState.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState, transformedTextFieldState, textStyle, z, function2)), composer2, 0);
                        if (!z6 || !z3 || !z4 || !textFieldSelectionState.isInTouchMode()) {
                            composer2.startReplaceGroup(-1325155904);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-1325530694);
                            ComposerKt.sourceInformation(composer2, "398@20188L121");
                            BasicTextFieldKt.TextFieldSelectionHandles(textFieldSelectionState, composer2, 0);
                            if (!z5) {
                                composer2.startReplaceGroup(-1325351669);
                                ComposerKt.sourceInformation(composer2, "402@20379L125");
                                BasicTextFieldKt.TextFieldCursorHandle(textFieldSelectionState, composer2, 0);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(-1325177728);
                                composer2.endReplaceGroup();
                            }
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
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
