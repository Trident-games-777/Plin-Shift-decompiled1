package com.plinkofortune.cash.winspin.nav;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.profile.ProfileScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: ProfileDest.kt */
final class ProfileDestKt$ProfileDest$1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $controller;

    ProfileDestKt$ProfileDest$1(NavHostController navHostController) {
        this.$controller = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, StringFog.decrypt(new byte[]{Ascii.CAN, Byte.MAX_VALUE, Ascii.NAK, 83, -105, -117, Ascii.DLE, 8, 81, 123, Ascii.DC2, 73, -123, -51, Ascii.US, 2}, new byte[]{60, Ascii.VT, 125, 58, -28, -81, 115, 103}));
        Intrinsics.checkNotNullParameter(navBackStackEntry, StringFog.decrypt(new byte[]{-42, -100}, new byte[]{-65, -24, -126, 9, 6, 73, -74, 118}));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1238064930, i, -1, StringFog.decrypt(new byte[]{-66, -43, 114, -25, -45, -108, -102, 94, -74, -43, 121, -90, -47, -116, -122, 94, -72, -108, 124, -88, -48, -112, -35, 71, -76, -44, 108, -71, -54, -106, -35, 94, -68, -52, 49, -103, -47, -105, -107, 89, -79, -33, 91, -84, -48, -116, -35, Ascii.FF, -68, -44, 112, -89, -38, -107, -100, 69, -82, -124, Utf8.REPLACEMENT_BYTE, -31, -13, -118, -100, 86, -76, -42, 122, -115, -58, -117, -121, Ascii.RS, -74, -50, 37, -16, -118}, new byte[]{-35, -70, Ascii.US, -55, -93, -8, -13, 48}));
        }
        composer.startReplaceGroup(-157776486);
        boolean changedInstance = composer.changedInstance(this.$controller);
        NavHostController navHostController = this.$controller;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ProfileDestKt$ProfileDest$1$$ExternalSyntheticLambda0(navHostController);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ProfileScreenKt.ProfileScreen((Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{19, -88, 82, -42, 34, -28, -56}, new byte[]{99, -38, Base64.padSymbol, -80, 75, -120, -83, -18}))) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }
}
