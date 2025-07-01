package androidx.compose.foundation.text;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLinkScope.kt */
final class TextLinkScope$LinksComposables$1$2$1 extends Lambda implements Function1<TextAnnotatorScope, Unit> {
    final /* synthetic */ State<Boolean> $isFocused$delegate;
    final /* synthetic */ State<Boolean> $isHovered$delegate;
    final /* synthetic */ State<Boolean> $isPressed$delegate;
    final /* synthetic */ AnnotatedString.Range<LinkAnnotation> $range;
    final /* synthetic */ TextLinkScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextLinkScope$LinksComposables$1$2$1(TextLinkScope textLinkScope, AnnotatedString.Range<LinkAnnotation> range, State<Boolean> state, State<Boolean> state2, State<Boolean> state3) {
        super(1);
        this.this$0 = textLinkScope;
        this.$range = range;
        this.$isFocused$delegate = state;
        this.$isHovered$delegate = state2;
        this.$isPressed$delegate = state3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextAnnotatorScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextAnnotatorScope textAnnotatorScope) {
        TextLinkStyles styles;
        TextLinkStyles styles2;
        TextLinkStyles styles3;
        TextLinkScope textLinkScope = this.this$0;
        TextLinkStyles styles4 = this.$range.getItem().getStyles();
        SpanStyle spanStyle = null;
        SpanStyle access$mergeOrUse = textLinkScope.mergeOrUse(textLinkScope.mergeOrUse(styles4 != null ? styles4.getStyle() : null, (!TextLinkScope.LinksComposables$lambda$13$lambda$10(this.$isFocused$delegate) || (styles3 = this.$range.getItem().getStyles()) == null) ? null : styles3.getFocusedStyle()), (!TextLinkScope.LinksComposables$lambda$13$lambda$9(this.$isHovered$delegate) || (styles2 = this.$range.getItem().getStyles()) == null) ? null : styles2.getHoveredStyle());
        if (TextLinkScope.LinksComposables$lambda$13$lambda$11(this.$isPressed$delegate) && (styles = this.$range.getItem().getStyles()) != null) {
            spanStyle = styles.getPressedStyle();
        }
        SpanStyle access$mergeOrUse2 = textLinkScope.mergeOrUse(access$mergeOrUse, spanStyle);
        if (access$mergeOrUse2 != null) {
            AnnotatedString.Range<LinkAnnotation> range = this.$range;
            textAnnotatorScope.replaceStyle(access$mergeOrUse2, range.getStart(), range.getEnd());
        }
    }
}
