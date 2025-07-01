package com.plinkofortune.cash.winspin.nav;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"MenuDest", "", "Landroidx/navigation/NavGraphBuilder;", "controller", "Landroidx/navigation/NavHostController;", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: MenuDest.kt */
public final class MenuDestKt {
    public static final void MenuDest(NavGraphBuilder navGraphBuilder, NavHostController navHostController) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, StringFog.decrypt(new byte[]{119, -33, 81, 5, 17, 48}, new byte[]{75, -85, 57, 108, 98, Ascii.SO, -81, 77}));
        Intrinsics.checkNotNullParameter(navHostController, StringFog.decrypt(new byte[]{Ascii.SYN, 34, -13, Ascii.US, 44, -100, -118, -20, Ascii.DLE, Utf8.REPLACEMENT_BYTE}, new byte[]{117, 77, -99, 107, 94, -13, -26, Byte.MIN_VALUE}));
        NavGraphBuilderKt.composable$default(navGraphBuilder, StringFog.decrypt(new byte[]{Ascii.SUB, SignedBytes.MAX_POWER_OF_TWO, 65, -80}, new byte[]{119, 37, 47, -59, 69, 74, -67, -11}), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1554759398, true, new MenuDestKt$MenuDest$1(navHostController)), 254, (Object) null);
    }
}
