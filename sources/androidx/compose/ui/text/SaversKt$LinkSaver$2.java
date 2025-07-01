package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.LinkAnnotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$LinkSaver$2 extends Lambda implements Function1<Object, LinkAnnotation.Url> {
    public static final SaversKt$LinkSaver$2 INSTANCE = new SaversKt$LinkSaver$2();

    SaversKt$LinkSaver$2() {
        super(1);
    }

    public final LinkAnnotation.Url invoke(Object obj) {
        String str;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextLinkStyles textLinkStyles = null;
        if (obj2 != null) {
            str = (String) obj2;
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(str);
        Object obj3 = list.get(1);
        Saver<TextLinkStyles, Object> textLinkStylesSaver = SaversKt.getTextLinkStylesSaver();
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (textLinkStylesSaver instanceof NonNullValueClassSaver)) && obj3 != null) {
            textLinkStyles = textLinkStylesSaver.restore(obj3);
        }
        return new LinkAnnotation.Url(str, textLinkStyles, (LinkInteractionListener) null, 4, (DefaultConstructorMarker) null);
    }
}
