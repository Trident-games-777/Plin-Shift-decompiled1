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

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"TermsDest", "", "Landroidx/navigation/NavGraphBuilder;", "controller", "Landroidx/navigation/NavHostController;", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: TermsDest.kt */
public final class TermsDestKt {
    public static final void TermsDest(NavGraphBuilder navGraphBuilder, NavHostController navHostController) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, StringFog.decrypt(new byte[]{-41, 102, -93, 67, 103, -92}, new byte[]{-21, Ascii.DC2, -53, 42, Ascii.DC4, -102, -12, 98}));
        Intrinsics.checkNotNullParameter(navHostController, StringFog.decrypt(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 32, -60, -88, -100, 104, -28, 47, 70, Base64.padSymbol}, new byte[]{35, 79, -86, -36, -18, 7, -120, 67}));
        NavGraphBuilderKt.composable$default(navGraphBuilder, StringFog.decrypt(new byte[]{85, 58, -72, -15, Ascii.FS}, new byte[]{33, 95, -54, -100, 111, -99, 89, -39}), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(104495006, true, new TermsDestKt$TermsDest$1(navHostController)), 254, (Object) null);
    }
}
