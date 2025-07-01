package com.plinkofortune.cash.winspin.nav;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.PopUpToBuilder;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.pream.PreamScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: PreamHost.kt */
final class PreamHostKt$PreamHost$1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $controller;

    PreamHostKt$PreamHost$1(NavHostController navHostController) {
        this.$controller = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, StringFog.decrypt(new byte[]{104, -3, 1, -64, 35, 94, 36, Ascii.RS, 33, -7, 6, -38, 49, Ascii.CAN, 43, Ascii.DC4}, new byte[]{76, -119, 105, -87, 80, 122, 71, 113}));
        Intrinsics.checkNotNullParameter(navBackStackEntry, StringFog.decrypt(new byte[]{92, -103}, new byte[]{53, -19, -118, 69, -35, -93, -50, 33}));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1726142686, i, -1, StringFog.decrypt(new byte[]{-65, 9, -75, -110, 42, 83, 33, Ascii.CAN, -73, 9, -66, -45, 40, 75, Base64.padSymbol, Ascii.CAN, -71, 72, -69, -35, 41, 87, 102, 1, -75, 8, -85, -52, 51, 81, 102, Ascii.CAN, -67, Ascii.DLE, -10, -20, 40, 90, 41, Ascii.ESC, -108, 9, -85, -56, 116, 3, 41, Ascii.CAN, -77, 8, -95, -47, 53, 74, 59, 72, -4, 78, -120, -50, Utf8.REPLACEMENT_BYTE, 94, 37, 62, -77, Ascii.NAK, -84, -110, 49, 75, 114, 71, -19, 79}, new byte[]{-36, 102, -40, -68, 90, Utf8.REPLACEMENT_BYTE, 72, 118}));
        }
        composer.startReplaceGroup(1872773117);
        boolean changedInstance = composer.changedInstance(this.$controller);
        NavHostController navHostController = this.$controller;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new PreamHostKt$PreamHost$1$$ExternalSyntheticLambda0(navHostController);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        PreamScreenKt.PreamScreen((Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{-76, 112, -108, 59, 8}, new byte[]{-60, 2, -15, 90, 101, -16, 1, -15}))) {
            navHostController.navigate(StringFog.decrypt(new byte[]{47, -115}, new byte[]{72, -68, 113, 93, SignedBytes.MAX_POWER_OF_TWO, -52, 44, -109}), (Function1<? super NavOptionsBuilder, Unit>) new PreamHostKt$PreamHost$1$$ExternalSyntheticLambda2());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, StringFog.decrypt(new byte[]{116, -22, Ascii.US, -50, Ascii.VT, -66, 67, -22, 38, -9, Ascii.DLE, -58, Ascii.FF, -1}, new byte[]{80, -98, 119, -89, 120, -102, 45, -117}));
        navOptionsBuilder.popUpTo(StringFog.decrypt(new byte[]{-43, 103, 114, 49, -114}, new byte[]{-91, Ascii.NAK, Ascii.ETB, 80, -29, -123, 33, -115}), (Function1<? super PopUpToBuilder, Unit>) new PreamHostKt$PreamHost$1$$ExternalSyntheticLambda1());
        navOptionsBuilder.setLaunchSingleTop(true);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1$lambda$0(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, StringFog.decrypt(new byte[]{Ascii.ESC, Ascii.GS, -73, -49, 58, -10, -63, 116, 79, 60, -81, -14, 38}, new byte[]{Utf8.REPLACEMENT_BYTE, 105, -33, -90, 73, -46, -79, Ascii.ESC}));
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }
}
