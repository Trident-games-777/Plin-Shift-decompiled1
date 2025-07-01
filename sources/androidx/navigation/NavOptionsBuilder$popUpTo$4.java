package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Landroidx/navigation/PopUpToBuilder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavOptionsBuilder.kt */
final class NavOptionsBuilder$popUpTo$4 extends Lambda implements Function1<PopUpToBuilder, Unit> {
    public static final NavOptionsBuilder$popUpTo$4 INSTANCE = new NavOptionsBuilder$popUpTo$4();

    NavOptionsBuilder$popUpTo$4() {
        super(1);
    }

    public final void invoke(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PopUpToBuilder) obj);
        return Unit.INSTANCE;
    }
}
