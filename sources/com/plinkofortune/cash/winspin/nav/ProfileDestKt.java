package com.plinkofortune.cash.winspin.nav;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"ProfileDest", "", "Landroidx/navigation/NavGraphBuilder;", "controller", "Landroidx/navigation/NavHostController;", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: ProfileDest.kt */
public final class ProfileDestKt {
    public static final void ProfileDest(NavGraphBuilder navGraphBuilder, NavHostController navHostController) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, StringFog.decrypt(new byte[]{-123, -74, Ascii.SO, -103, 106, Byte.MAX_VALUE}, new byte[]{-71, -62, 102, -16, Ascii.EM, 65, -42, 1}));
        Intrinsics.checkNotNullParameter(navHostController, StringFog.decrypt(new byte[]{90, Ascii.SUB, -93, -17, -20, Ascii.EM, Ascii.SI, -90, 92, 7}, new byte[]{57, 117, -51, -101, -98, 118, 99, -54}));
        NavGraphBuilderKt.composable$default(navGraphBuilder, StringFog.decrypt(new byte[]{-9, Ascii.SO, 89, -44, -65, Base64.padSymbol, 52}, new byte[]{-121, 124, 54, -78, -42, 81, 81, 102}), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1238064930, true, new ProfileDestKt$ProfileDest$1(navHostController)), 254, (Object) null);
    }
}
