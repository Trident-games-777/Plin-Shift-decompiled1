package com.plinkofortune.cash.winspin.nav;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.rounds.RoundsScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: StartDest.kt */
final class StartDestKt$StartDest$1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $controller;

    StartDestKt$StartDest$1(NavHostController navHostController) {
        this.$controller = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, StringFog.decrypt(new byte[]{-101, Ascii.FS, -106, 10, Byte.MAX_VALUE, -109, -78, Ascii.VT, -46, Ascii.CAN, -111, Ascii.DLE, 109, -43, -67, 1}, new byte[]{-65, 104, -2, 99, Ascii.FF, -73, -47, 100}));
        Intrinsics.checkNotNullParameter(navBackStackEntry, StringFog.decrypt(new byte[]{-103, 105}, new byte[]{-16, Ascii.GS, 17, -37, -47, -86, -78, -33}));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1672431550, i, -1, StringFog.decrypt(new byte[]{-6, -31, 96, Byte.MAX_VALUE, -6, -29, -107, -15, -14, -31, 107, 62, -8, -5, -119, -15, -4, -96, 110, 48, -7, -25, -46, -24, -16, -32, 126, 33, -29, -31, -46, -15, -8, -8, 35, 2, -2, -18, -114, -21, -35, -21, 126, 37, -92, -77, -99, -15, -10, -32, 116, 60, -27, -6, -113, -95, -71, -90, 94, 37, -21, -3, -120, -37, -4, -3, 121, Byte.MAX_VALUE, -31, -5, -58, -90, -80}, new byte[]{-103, -114, Ascii.CR, 81, -118, -113, -4, -97}));
        }
        composer.startReplaceGroup(-245736447);
        boolean changedInstance = composer.changedInstance(this.$controller);
        NavHostController navHostController = this.$controller;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new StartDestKt$StartDest$1$$ExternalSyntheticLambda0(navHostController);
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-245730938);
        boolean changedInstance2 = composer.changedInstance(this.$controller);
        NavHostController navHostController2 = this.$controller;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new StartDestKt$StartDest$1$$ExternalSyntheticLambda1(navHostController2);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        RoundsScreenKt.RoundsScreen(function0, (Function1) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{-107, -43, Ascii.SUB, 85, 37}, new byte[]{-26, -95, 123, 39, 81, Ascii.US, 35, 4}))) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(NavHostController navHostController, int i) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{68, 125, -81, 108, -46}, new byte[]{55, 9, -50, Ascii.RS, -90, -1, 58, SignedBytes.MAX_POWER_OF_TWO}))) {
            NavController.navigate$default((NavController) navHostController, "seq/" + i, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
