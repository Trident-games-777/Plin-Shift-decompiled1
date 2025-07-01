package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextLinkStyles;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$TextLinkStylesSaver$2 extends Lambda implements Function1<Object, TextLinkStyles> {
    public static final SaversKt$TextLinkStylesSaver$2 INSTANCE = new SaversKt$TextLinkStylesSaver$2();

    SaversKt$TextLinkStylesSaver$2() {
        super(1);
    }

    public final TextLinkStyles invoke(Object obj) {
        SpanStyle spanStyle;
        SpanStyle spanStyle2;
        SpanStyle spanStyle3;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<SpanStyle, Object> spanStyleSaver = SaversKt.getSpanStyleSaver();
        SpanStyle spanStyle4 = null;
        if ((!Intrinsics.areEqual(obj2, (Object) false) || (spanStyleSaver instanceof NonNullValueClassSaver)) && obj2 != null) {
            spanStyle = spanStyleSaver.restore(obj2);
        } else {
            spanStyle = null;
        }
        Object obj3 = list.get(1);
        Saver<SpanStyle, Object> spanStyleSaver2 = SaversKt.getSpanStyleSaver();
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (spanStyleSaver2 instanceof NonNullValueClassSaver)) && obj3 != null) {
            spanStyle2 = spanStyleSaver2.restore(obj3);
        } else {
            spanStyle2 = null;
        }
        Object obj4 = list.get(2);
        Saver<SpanStyle, Object> spanStyleSaver3 = SaversKt.getSpanStyleSaver();
        if ((!Intrinsics.areEqual(obj4, (Object) false) || (spanStyleSaver3 instanceof NonNullValueClassSaver)) && obj4 != null) {
            spanStyle3 = spanStyleSaver3.restore(obj4);
        } else {
            spanStyle3 = null;
        }
        Object obj5 = list.get(3);
        Saver<SpanStyle, Object> spanStyleSaver4 = SaversKt.getSpanStyleSaver();
        if ((!Intrinsics.areEqual(obj5, (Object) false) || (spanStyleSaver4 instanceof NonNullValueClassSaver)) && obj5 != null) {
            spanStyle4 = spanStyleSaver4.restore(obj5);
        }
        return new TextLinkStyles(spanStyle, spanStyle2, spanStyle3, spanStyle4);
    }
}
