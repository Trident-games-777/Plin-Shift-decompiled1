package com.plinkofortune.cash.winspin.nav;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.leader.LeaderScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: LeadersDest.kt */
final class LeadersDestKt$LeadersDest$1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $controller;

    LeadersDestKt$LeadersDest$1(NavHostController navHostController) {
        this.$controller = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, StringFog.decrypt(new byte[]{90, Ascii.NAK, -89, 108, -37, -38, -7, 62, 19, 17, -96, 118, -55, -100, -10, 52}, new byte[]{126, 97, -49, 5, -88, -2, -102, 81}));
        Intrinsics.checkNotNullParameter(navBackStackEntry, StringFog.decrypt(new byte[]{54, -114}, new byte[]{95, -6, 43, -111, 51, 3, 112, -116}));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1226212610, i, -1, StringFog.decrypt(new byte[]{100, 102, -49, 1, 8, 68, Utf8.REPLACEMENT_BYTE, -25, 108, 102, -60, SignedBytes.MAX_POWER_OF_TWO, 10, 92, 35, -25, 98, 39, -63, 78, Ascii.VT, SignedBytes.MAX_POWER_OF_TWO, 120, -2, 110, 103, -47, 95, 17, 70, 120, -25, 102, Byte.MAX_VALUE, -116, 99, Ascii.GS, 73, 50, -20, 117, 122, -26, 74, Ascii.VT, 92, 120, -75, 102, 103, -51, 65, 1, 69, 57, -4, 116, 55, -126, 7, 52, 77, 55, -19, 98, 123, -47, 107, Ascii.GS, 91, 34, -89, 108, 125, -104, Ascii.SYN, 81}, new byte[]{7, 9, -94, 47, 120, 40, 86, -119}));
        }
        composer.startReplaceGroup(2025439707);
        boolean changedInstance = composer.changedInstance(this.$controller);
        NavHostController navHostController = this.$controller;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LeadersDestKt$LeadersDest$1$$ExternalSyntheticLambda0(navHostController);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        LeaderScreenKt.LeaderScreen((Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 19, 99, -25, 107, -14, -3}, new byte[]{44, 118, 2, -125, Ascii.SO, Byte.MIN_VALUE, -114, 4}))) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }
}
