package com.plinkofortune.cash.winspin.nav;

import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.seq.SeqScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: SeqDest.kt */
final class SeqDestKt$SeqDest$2 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $controller;

    SeqDestKt$SeqDest$2(NavHostController navHostController) {
        this.$controller = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, StringFog.decrypt(new byte[]{115, -62, 39, 41, 98, Ascii.VT, -79, 58, 58, -58, 32, 51, 112, 77, -66, 48}, new byte[]{87, -74, 79, SignedBytes.MAX_POWER_OF_TWO, 17, 47, -46, 85}));
        Intrinsics.checkNotNullParameter(navBackStackEntry, StringFog.decrypt(new byte[]{-48, -117}, new byte[]{-71, -1, -90, 66, -10, -108, Base64.padSymbol, 91}));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(556836254, i, -1, StringFog.decrypt(new byte[]{-108, 55, Ascii.US, 10, -108, -12, -75, -102, -100, 55, Ascii.DC4, 75, -106, -20, -87, -102, -110, 118, 17, 69, -105, -16, -14, -125, -98, 54, 1, 84, -115, -10, -14, -102, -106, 46, 92, 119, -127, -23, -104, -111, -124, 44, 92, Ascii.CAN, -123, -10, -77, -102, -114, 53, Ascii.GS, 81, -105, -90, -4, -36, -92, Base64.padSymbol, 3, 96, -127, -21, -88, -38, -100, 44, 72, Ascii.NAK, -43, -79}, new byte[]{-9, 88, 114, 36, -28, -104, -36, -12}));
        }
        Bundle arguments = navBackStackEntry.getArguments();
        int i2 = arguments != null ? arguments.getInt(StringFog.decrypt(new byte[]{-25, 33, 19}, new byte[]{-111, 86, 98, -4, 35, Base64.padSymbol, -3, 43})) : 1;
        composer.startReplaceGroup(1198279922);
        boolean changedInstance = composer.changedInstance(this.$controller);
        NavHostController navHostController = this.$controller;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SeqDestKt$SeqDest$2$$ExternalSyntheticLambda0(navHostController);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        SeqScreenKt.SeqScreen(i2, (Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{-6, -122, -70, 55, -89, -17, 68, -68, -12}, new byte[]{-119, -29, -53, Ascii.CAN, -36, -103, 51, -51}))) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }
}
