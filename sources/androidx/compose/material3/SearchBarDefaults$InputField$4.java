package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "invoke", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBarDefaults$InputField$4 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ String $query;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarDefaults$InputField$4(String str, boolean z, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextFieldColors textFieldColors) {
        super(3);
        this.$query = str;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$placeholder = function2;
        this.$leadingIcon = function22;
        this.$trailingIcon = function23;
        this.$colors = textFieldColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Function2 function22;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C557@26571L15,541@25683L1096:SearchBar.android.kt#uh7d8r");
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        if ((i & 6) == 0) {
            i2 = i | (composer2.changedInstance(function23) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2029278807, i2, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous> (SearchBar.android.kt:541)");
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            int i3 = i2;
            String str = this.$query;
            TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
            boolean z = this.$enabled;
            VisualTransformation none = VisualTransformation.Companion.getNone();
            InteractionSource interactionSource = this.$interactionSource;
            Function2<Composer, Integer, Unit> function24 = this.$placeholder;
            Function2<Composer, Integer, Unit> function25 = this.$leadingIcon;
            composer2.startReplaceGroup(-1102017390);
            ComposerKt.sourceInformation(composer2, "*551@26196L64");
            Function2 function26 = null;
            if (function25 == null) {
                function22 = null;
            } else {
                function22 = ComposableLambdaKt.rememberComposableLambda(-1401341985, true, new SearchBarDefaults$InputField$4$1$1(function25), composer2, 54);
            }
            composer2.endReplaceGroup();
            Function2<Composer, Integer, Unit> function27 = this.$trailingIcon;
            composer2.startReplaceGroup(-1102010155);
            ComposerKt.sourceInformation(composer2, "*555@26423L66");
            if (function27 != null) {
                function26 = ComposableLambdaKt.rememberComposableLambda(907752083, true, new SearchBarDefaults$InputField$4$2$1(function27), composer2, 54);
            }
            composer2.endReplaceGroup();
            textFieldDefaults2.DecorationBox(str, function23, z, true, none, interactionSource, false, (Function2<? super Composer, ? super Integer, Unit>) null, function24, function22, function26, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer2, 6), this.$colors, TextFieldDefaults.m2662contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, (Object) null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m1935getLambda1$material3_release(), composer, ((i3 << 3) & 112) | 27648, 113246208, 14528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
