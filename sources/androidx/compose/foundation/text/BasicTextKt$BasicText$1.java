package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$BasicText$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ ColorProducer $color;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ int $overflow;
    final /* synthetic */ boolean $softWrap;
    final /* synthetic */ TextStyle $style;
    final /* synthetic */ String $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$BasicText$1(String str, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, int i4, int i5) {
        super(2);
        this.$text = str;
        this.$modifier = modifier;
        this.$style = textStyle;
        this.$onTextLayout = function1;
        this.$overflow = i;
        this.$softWrap = z;
        this.$maxLines = i2;
        this.$minLines = i3;
        this.$color = colorProducer;
        this.$$changed = i4;
        this.$$default = i5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BasicTextKt.m1166BasicTextVhcvRP8(this.$text, this.$modifier, this.$style, (Function1<? super TextLayoutResult, Unit>) this.$onTextLayout, this.$overflow, this.$softWrap, this.$maxLines, this.$minLines, this.$color, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
