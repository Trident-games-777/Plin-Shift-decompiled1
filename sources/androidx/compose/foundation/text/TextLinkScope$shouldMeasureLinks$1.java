package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLinkScope.kt */
final class TextLinkScope$shouldMeasureLinks$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TextLinkScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextLinkScope$shouldMeasureLinks$1(TextLinkScope textLinkScope) {
        super(0);
        this.this$0 = textLinkScope;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r1 = r1.getLayoutInput();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke() {
        /*
            r2 = this;
            androidx.compose.foundation.text.TextLinkScope r0 = r2.this$0
            androidx.compose.ui.text.AnnotatedString r0 = r0.getText$foundation_release()
            androidx.compose.foundation.text.TextLinkScope r1 = r2.this$0
            androidx.compose.ui.text.TextLayoutResult r1 = r1.getTextLayoutResult()
            if (r1 == 0) goto L_0x0019
            androidx.compose.ui.text.TextLayoutInput r1 = r1.getLayoutInput()
            if (r1 == 0) goto L_0x0019
            androidx.compose.ui.text.AnnotatedString r1 = r1.getText()
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLinkScope$shouldMeasureLinks$1.invoke():java.lang.Boolean");
    }
}
