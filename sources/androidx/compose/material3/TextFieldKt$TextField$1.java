package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$TextField$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
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
    final /* synthetic */ Function1<String, Unit> $onValueChange;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ String $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$TextField$1(Modifier modifier, boolean z, TextFieldColors textFieldColors, String str, Function1<? super String, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Shape shape) {
        super(2);
        this.$modifier = modifier;
        this.$isError = z;
        this.$colors = textFieldColors;
        this.$value = str;
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
        this.$label = function2;
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
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C235@12157L38,253@12960L984,231@12014L1940:TextField.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1859145987, i2, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
            }
            Modifier modifier = this.$modifier;
            boolean z = this.$isError;
            Strings.Companion companion = Strings.Companion;
            Modifier r3 = SizeKt.m829defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier, z, Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.default_error_message), composer2, 0)), TextFieldDefaults.INSTANCE.m2677getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2676getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(this.$colors.m2609cursorColorvNxB06k$material3_release(this.$isError), (DefaultConstructorMarker) null);
            String str = this.$value;
            SolidColor solidColor2 = solidColor;
            Function1<String, Unit> function1 = this.$onValueChange;
            String str2 = str;
            boolean z2 = this.$enabled;
            SolidColor solidColor3 = solidColor2;
            boolean z3 = this.$readOnly;
            String str3 = str2;
            TextStyle textStyle = this.$mergedTextStyle;
            SolidColor solidColor4 = solidColor3;
            KeyboardOptions keyboardOptions = this.$keyboardOptions;
            String str4 = str3;
            KeyboardActions keyboardActions = this.$keyboardActions;
            SolidColor solidColor5 = solidColor4;
            boolean z4 = this.$singleLine;
            String str5 = str4;
            int i3 = this.$maxLines;
            SolidColor solidColor6 = solidColor5;
            int i4 = this.$minLines;
            String str6 = str5;
            VisualTransformation visualTransformation = this.$visualTransformation;
            String str7 = str6;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            Function1<String, Unit> function12 = function1;
            final String str8 = this.$value;
            final boolean z5 = this.$enabled;
            final boolean z6 = this.$singleLine;
            final VisualTransformation visualTransformation2 = this.$visualTransformation;
            final MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            final boolean z7 = this.$isError;
            final Function2<Composer, Integer, Unit> function2 = this.$label;
            final Function2<Composer, Integer, Unit> function22 = this.$placeholder;
            final Function2<Composer, Integer, Unit> function23 = this.$leadingIcon;
            final Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
            final Function2<Composer, Integer, Unit> function25 = this.$prefix;
            final Function2<Composer, Integer, Unit> function26 = this.$suffix;
            final Function2<Composer, Integer, Unit> function27 = this.$supportingText;
            final Shape shape = this.$shape;
            final TextFieldColors textFieldColors = this.$colors;
            AnonymousClass1 r2 = new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
                    int i2;
                    Composer composer2 = composer;
                    ComposerKt.sourceInformation(composer2, "C255@13115L811:TextField.kt#uh7d8r");
                    Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    if ((i & 6) == 0) {
                        i2 = i | (composer2.changedInstance(function22) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-288211827, i2, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        textFieldDefaults.DecorationBox(str8, function22, z5, z6, visualTransformation2, mutableInteractionSource2, z7, function2, function22, function23, function24, function25, function26, function27, shape, textFieldColors, (PaddingValues) null, (Function2<? super Composer, ? super Integer, Unit>) null, composer, (i2 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            };
            Composer composer3 = composer2;
            Function1<String, Unit> function13 = function12;
            BasicTextFieldKt.BasicTextField(str7, (Function1<? super String, Unit>) function13, r3, z2, z3, textStyle, keyboardOptions, keyboardActions, z4, i3, i4, visualTransformation, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, (Brush) solidColor6, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-288211827, true, r2, composer2, 54), composer3, 0, (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
