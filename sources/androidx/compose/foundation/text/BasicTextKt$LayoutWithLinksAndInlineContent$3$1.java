package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$LayoutWithLinksAndInlineContent$3$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TextLinkScope $textScope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$LayoutWithLinksAndInlineContent$3$1(TextLinkScope textLinkScope) {
        super(0);
        this.$textScope = textLinkScope;
    }

    public final Boolean invoke() {
        TextLinkScope textLinkScope = this.$textScope;
        return Boolean.valueOf(textLinkScope != null ? textLinkScope.getShouldMeasureLinks().invoke().booleanValue() : false);
    }
}
