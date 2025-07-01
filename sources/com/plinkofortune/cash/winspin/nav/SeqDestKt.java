package com.plinkofortune.cash.winspin.nav;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"SeqDest", "", "Landroidx/navigation/NavGraphBuilder;", "controller", "Landroidx/navigation/NavHostController;", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: SeqDest.kt */
public final class SeqDestKt {
    public static final void SeqDest(NavGraphBuilder navGraphBuilder, NavHostController navHostController) {
        NavHostController navHostController2 = navHostController;
        Intrinsics.checkNotNullParameter(navGraphBuilder, StringFog.decrypt(new byte[]{-41, -99, 77, -59, -115, -99}, new byte[]{-21, -23, 37, -84, -2, -93, 82, 7}));
        Intrinsics.checkNotNullParameter(navHostController2, StringFog.decrypt(new byte[]{125, 104, -93, -94, 38, 99, 93, 55, 123, 117}, new byte[]{Ascii.RS, 7, -51, -42, 84, Ascii.FF, 49, 91}));
        NavGraphBuilderKt.composable$default(navGraphBuilder, StringFog.decrypt(new byte[]{Ascii.DC2, Byte.MAX_VALUE, 70, 71, -108, Byte.MAX_VALUE, Ascii.CR, -8, Ascii.FS}, new byte[]{97, Ascii.SUB, 55, 104, -17, 9, 122, -119}), CollectionsKt.listOf(NamedNavArgumentKt.navArgument(StringFog.decrypt(new byte[]{-125, 10, -125}, new byte[]{-11, 125, -14, 91, -41, -47, 118, -39}), new SeqDestKt$$ExternalSyntheticLambda0())), (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(556836254, true, new SeqDestKt$SeqDest$2(navHostController2)), 252, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit SeqDest$lambda$0(NavArgumentBuilder navArgumentBuilder) {
        Intrinsics.checkNotNullParameter(navArgumentBuilder, StringFog.decrypt(new byte[]{1, 88, -2, -127, 58, -69, -95, -95, 83, 109, -28, -113, 60, -14, -86, -82, 81}, new byte[]{37, 44, -106, -24, 73, -97, -49, -64}));
        navArgumentBuilder.setType(NavType.IntType);
        return Unit.INSTANCE;
    }
}
