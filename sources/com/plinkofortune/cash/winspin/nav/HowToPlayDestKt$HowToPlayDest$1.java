package com.plinkofortune.cash.winspin.nav;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.teach.TeachScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: HowToPlayDest.kt */
final class HowToPlayDestKt$HowToPlayDest$1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $controller;

    HowToPlayDestKt$HowToPlayDest$1(NavHostController navHostController) {
        this.$controller = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, StringFog.decrypt(new byte[]{-68, -68, 119, -53, -106, Ascii.DLE, -72, 94, -11, -72, 112, -47, -124, 86, -73, 84}, new byte[]{-104, -56, Ascii.US, -94, -27, 52, -37, 49}));
        Intrinsics.checkNotNullParameter(navBackStackEntry, StringFog.decrypt(new byte[]{-72, 65}, new byte[]{-47, 53, 71, 38, -68, 94, Byte.MIN_VALUE, 123}));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1350167906, i, -1, StringFog.decrypt(new byte[]{-13, Ascii.US, 5, Base64.padSymbol, -51, -116, -16, -43, -5, Ascii.US, Ascii.SO, 124, -49, -108, -20, -43, -11, 94, Ascii.VT, 114, -50, -120, -73, -52, -7, Ascii.RS, Ascii.ESC, 99, -44, -114, -73, -43, -15, 6, 70, 91, -46, -105, -51, -44, -64, Ascii.FS, 9, 106, -7, -123, -22, -49, -66, 76, 9, 125, -46, -114, -32, -42, -1, 5, Ascii.ESC, 45, -99, -56, -47, -44, -25, 36, 7, 67, -47, -127, -32, -1, -11, 3, Ascii.FS, Base64.padSymbol, -42, -108, -93, -126, -71}, new byte[]{-112, 112, 104, 19, -67, -32, -103, -69}));
        }
        composer.startReplaceGroup(152246450);
        boolean changedInstance = composer.changedInstance(this.$controller);
        NavHostController navHostController = this.$controller;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new HowToPlayDestKt$HowToPlayDest$1$$ExternalSyntheticLambda0(navHostController);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TeachScreenKt.TeachScreen((Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{38, 86, -81, Ascii.CAN, 75, 93, -53, -110, 55}, new byte[]{78, 57, -40, 108, 36, 45, -89, -13}))) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }
}
