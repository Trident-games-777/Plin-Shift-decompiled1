package androidx.compose.foundation.text;

import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLinkScope.kt */
final class TextLinkScope$LinksComposables$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AnnotatedString.Range<LinkAnnotation> $range;
    final /* synthetic */ UriHandler $uriHandler;
    final /* synthetic */ TextLinkScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextLinkScope$LinksComposables$1$1$1(TextLinkScope textLinkScope, AnnotatedString.Range<LinkAnnotation> range, UriHandler uriHandler) {
        super(0);
        this.this$0 = textLinkScope;
        this.$range = range;
        this.$uriHandler = uriHandler;
    }

    public final void invoke() {
        this.this$0.handleLink(this.$range.getItem(), this.$uriHandler);
    }
}
