package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/intl/Locale;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$LocaleSaver$2 extends Lambda implements Function1<Object, Locale> {
    public static final SaversKt$LocaleSaver$2 INSTANCE = new SaversKt$LocaleSaver$2();

    SaversKt$LocaleSaver$2() {
        super(1);
    }

    public final Locale invoke(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        return new Locale((String) obj);
    }
}
