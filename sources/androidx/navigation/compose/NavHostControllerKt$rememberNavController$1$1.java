package androidx.navigation.compose;

import android.content.Context;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/navigation/NavHostController;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavHostController.kt */
final class NavHostControllerKt$rememberNavController$1$1 extends Lambda implements Function0<NavHostController> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostControllerKt$rememberNavController$1$1(Context context) {
        super(0);
        this.$context = context;
    }

    public final NavHostController invoke() {
        return NavHostControllerKt.createNavController(this.$context);
    }
}
