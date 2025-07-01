package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$LayoutWithLinksAndInlineContent$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ ColorProducer $color;
    final /* synthetic */ FontFamily.Resolver $fontFamilyResolver;
    final /* synthetic */ boolean $hasInlineContent;
    final /* synthetic */ Map<String, InlineTextContent> $inlineContent;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit> $onShowTranslation;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ int $overflow;
    final /* synthetic */ SelectionController $selectionController;
    final /* synthetic */ boolean $softWrap;
    final /* synthetic */ TextStyle $style;
    final /* synthetic */ AnnotatedString $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$LayoutWithLinksAndInlineContent$6(Modifier modifier, AnnotatedString annotatedString, Function1<? super TextLayoutResult, Unit> function1, boolean z, Map<String, InlineTextContent> map, TextStyle textStyle, int i, boolean z2, int i2, int i3, FontFamily.Resolver resolver, SelectionController selectionController, ColorProducer colorProducer, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function12, int i4, int i5, int i6) {
        super(2);
        this.$modifier = modifier;
        this.$text = annotatedString;
        this.$onTextLayout = function1;
        this.$hasInlineContent = z;
        this.$inlineContent = map;
        this.$style = textStyle;
        this.$overflow = i;
        this.$softWrap = z2;
        this.$maxLines = i2;
        this.$minLines = i3;
        this.$fontFamilyResolver = resolver;
        this.$selectionController = selectionController;
        this.$color = colorProducer;
        this.$onShowTranslation = function12;
        this.$$changed = i4;
        this.$$changed1 = i5;
        this.$$default = i6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BasicTextKt.m1167LayoutWithLinksAndInlineContentvOo2fZY(this.$modifier, this.$text, this.$onTextLayout, this.$hasInlineContent, this.$inlineContent, this.$style, this.$overflow, this.$softWrap, this.$maxLines, this.$minLines, this.$fontFamilyResolver, this.$selectionController, this.$color, this.$onShowTranslation, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
