package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/AnnotatedString;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$LayoutWithLinksAndInlineContent$styledText$1$1 extends Lambda implements Function0<AnnotatedString> {
    final /* synthetic */ AnnotatedString $text;
    final /* synthetic */ TextLinkScope $textScope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$LayoutWithLinksAndInlineContent$styledText$1$1(TextLinkScope textLinkScope, AnnotatedString annotatedString) {
        super(0);
        this.$textScope = textLinkScope;
        this.$text = annotatedString;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.applyAnnotators$foundation_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.AnnotatedString invoke() {
        /*
            r1 = this;
            androidx.compose.foundation.text.TextLinkScope r0 = r1.$textScope
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.text.AnnotatedString r0 = r0.applyAnnotators$foundation_release()
            if (r0 != 0) goto L_0x000b
            goto L_0x000c
        L_0x000b:
            return r0
        L_0x000c:
            androidx.compose.ui.text.AnnotatedString r0 = r1.$text
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$1$1.invoke():androidx.compose.ui.text.AnnotatedString");
    }
}
