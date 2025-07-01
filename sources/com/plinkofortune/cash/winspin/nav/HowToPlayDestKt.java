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
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"HowToPlayDest", "", "Landroidx/navigation/NavGraphBuilder;", "controller", "Landroidx/navigation/NavHostController;", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: HowToPlayDest.kt */
public final class HowToPlayDestKt {
    public static final void HowToPlayDest(NavGraphBuilder navGraphBuilder, NavHostController navHostController) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, StringFog.decrypt(new byte[]{52, Ascii.ESC, 45, -116, -21, Ascii.SO}, new byte[]{8, 111, 69, -27, -104, 48, 66, -107}));
        Intrinsics.checkNotNullParameter(navHostController, StringFog.decrypt(new byte[]{Ascii.GS, 79, 46, -75, 58, -116, 65, 39, Ascii.ESC, 82}, new byte[]{126, 32, SignedBytes.MAX_POWER_OF_TWO, -63, 72, -29, 45, 75}));
        NavGraphBuilderKt.composable$default(navGraphBuilder, StringFog.decrypt(new byte[]{-66, 8, 46, -100, 6, 77, -99, -16, -81}, new byte[]{-42, 103, 89, -24, 105, Base64.padSymbol, -15, -111}), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1350167906, true, new HowToPlayDestKt$HowToPlayDest$1(navHostController)), 254, (Object) null);
    }
}
