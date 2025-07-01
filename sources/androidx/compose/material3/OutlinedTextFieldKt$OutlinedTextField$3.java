package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$OutlinedTextField$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ Density $density;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ KeyboardActions $keyboardActions;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ TextStyle $mergedTextStyle;
    final /* synthetic */ int $minLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$OutlinedTextField$3(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Density density, boolean z, TextFieldColors textFieldColors, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Shape shape) {
        super(2);
        this.$modifier = modifier;
        this.$label = function2;
        this.$density = density;
        this.$isError = z;
        this.$colors = textFieldColors;
        this.$value = textFieldValue;
        this.$onValueChange = function1;
        this.$enabled = z2;
        this.$readOnly = z3;
        this.$mergedTextStyle = textStyle;
        this.$keyboardOptions = keyboardOptions;
        this.$keyboardActions = keyboardActions;
        this.$singleLine = z4;
        this.$maxLines = i;
        this.$minLines = i2;
        this.$visualTransformation = visualTransformation;
        this.$interactionSource = mutableInteractionSource;
        this.$placeholder = function22;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$prefix = function25;
        this.$suffix = function26;
        this.$supportingText = function27;
        this.$shape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Modifier modifier;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C397@21584L38,415@22403L1290,382@20861L2842:OutlinedTextField.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1830921872, i2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:382)");
            }
            Modifier modifier2 = this.$modifier;
            if (this.$label != null) {
                modifier = PaddingKt.m779paddingqDBjuR0$default(SemanticsModifierKt.semantics(Modifier.Companion, true, AnonymousClass1.INSTANCE), 0.0f, this.$density.m7222toDpGaN1DYA(OutlinedTextFieldKt.getOutlinedTextFieldTopPadding()), 0.0f, 0.0f, 13, (Object) null);
            } else {
                modifier = Modifier.Companion;
            }
            Modifier then = modifier2.then(modifier);
            boolean z = this.$isError;
            Strings.Companion companion = Strings.Companion;
            Modifier r3 = SizeKt.m829defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(then, z, Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.default_error_message), composer2, 0)), OutlinedTextFieldDefaults.INSTANCE.m2327getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2326getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(this.$colors.m2609cursorColorvNxB06k$material3_release(this.$isError), (DefaultConstructorMarker) null);
            TextFieldValue textFieldValue = this.$value;
            SolidColor solidColor2 = solidColor;
            Function1<TextFieldValue, Unit> function1 = this.$onValueChange;
            TextFieldValue textFieldValue2 = this.$value;
            Function1<TextFieldValue, Unit> function12 = function1;
            final boolean z2 = this.$enabled;
            final boolean z3 = this.$singleLine;
            final VisualTransformation visualTransformation = this.$visualTransformation;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final boolean z4 = this.$isError;
            final Function2<Composer, Integer, Unit> function2 = this.$label;
            final Function2<Composer, Integer, Unit> function22 = this.$placeholder;
            final Function2<Composer, Integer, Unit> function23 = this.$leadingIcon;
            final Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
            final Function2<Composer, Integer, Unit> function25 = this.$prefix;
            final Function2<Composer, Integer, Unit> function26 = this.$suffix;
            final Function2<Composer, Integer, Unit> function27 = this.$supportingText;
            final TextFieldColors textFieldColors = this.$colors;
            final Shape shape = this.$shape;
            final TextFieldValue textFieldValue3 = textFieldValue2;
            boolean z5 = this.$enabled;
            Modifier modifier3 = r3;
            Function1<TextFieldValue, Unit> function13 = function12;
            Composer composer3 = composer2;
            TextFieldValue textFieldValue4 = textFieldValue;
            BasicTextFieldKt.BasicTextField(textFieldValue4, (Function1<? super TextFieldValue, Unit>) function13, modifier3, z5, this.$readOnly, this.$mergedTextStyle, this.$keyboardOptions, this.$keyboardActions, this.$singleLine, this.$maxLines, this.$minLines, this.$visualTransformation, (Function1<? super TextLayoutResult, Unit>) null, this.$interactionSource, (Brush) solidColor2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-757328870, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
                    int i2;
                    Composer composer2 = composer;
                    ComposerKt.sourceInformation(composer2, "C432@23262L391,416@22469L1206:OutlinedTextField.kt#uh7d8r");
                    Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    if ((i & 6) == 0) {
                        i2 = i | (composer2.changedInstance(function22) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-757328870, i2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:416)");
                        }
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                        String text = textFieldValue3.getText();
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults2 = outlinedTextFieldDefaults;
                        boolean z = z2;
                        int i3 = i2;
                        String str = text;
                        boolean z2 = z3;
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults3 = outlinedTextFieldDefaults2;
                        VisualTransformation visualTransformation = visualTransformation;
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults4 = outlinedTextFieldDefaults3;
                        boolean z3 = z4;
                        int i4 = i3;
                        InteractionSource interactionSource = mutableInteractionSource;
                        Function2<Composer, Integer, Unit> function23 = function2;
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults5 = outlinedTextFieldDefaults4;
                        Function2<Composer, Integer, Unit> function24 = function22;
                        int i5 = i4;
                        Function2<Composer, Integer, Unit> function25 = function23;
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults6 = outlinedTextFieldDefaults5;
                        Function2<Composer, Integer, Unit> function26 = function24;
                        int i6 = i5;
                        Function2<Composer, Integer, Unit> function27 = function25;
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults7 = outlinedTextFieldDefaults6;
                        Function2<Composer, Integer, Unit> function28 = function26;
                        int i7 = i6;
                        Function2<Composer, Integer, Unit> function29 = function27;
                        String str2 = str;
                        TextFieldColors textFieldColors = textFieldColors;
                        final boolean z4 = z2;
                        final boolean z5 = z4;
                        final MutableInteractionSource mutableInteractionSource = mutableInteractionSource;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final Shape shape = shape;
                        AnonymousClass1 r2 = new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                int i2 = i;
                                Composer composer2 = composer;
                                ComposerKt.sourceInformation(composer, "C433@23318L309:OutlinedTextField.kt#uh7d8r");
                                if ((i2 & 3) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(255570733, i2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:433)");
                                    }
                                    OutlinedTextFieldDefaults.INSTANCE.m2321Container4EFweAY(z4, z5, mutableInteractionSource, (Modifier) null, textFieldColors2, shape, 0.0f, 0.0f, composer2, 100663296, 200);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        };
                        Composer composer3 = composer2;
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults8 = outlinedTextFieldDefaults7;
                        outlinedTextFieldDefaults8.DecorationBox(str2, function2, z, z2, visualTransformation, interactionSource, z3, function23, function24, function25, function26, function27, function28, function29, textFieldColors, (PaddingValues) null, ComposableLambdaKt.rememberComposableLambda(255570733, true, r2, composer2, 54), composer3, (i7 << 3) & 112, 14155776, 32768);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composer2, 54), composer3, 0, (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
