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
import com.plinkofortune.cash.winspin.policy.PolicyScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: PolicyDest.kt */
final class PolicyDestKt$PolicyDest$1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $controller;

    PolicyDestKt$PolicyDest$1(NavHostController navHostController) {
        this.$controller = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, StringFog.decrypt(new byte[]{-77, 38, 109, 38, -89, 101, -72, -59, -6, 34, 106, 60, -75, 35, -73, -49}, new byte[]{-105, 82, 5, 79, -44, 65, -37, -86}));
        Intrinsics.checkNotNullParameter(navBackStackEntry, StringFog.decrypt(new byte[]{-73, 60}, new byte[]{-34, 72, -95, 124, 87, -58, -71, -8}));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-972872000, i, -1, StringFog.decrypt(new byte[]{71, 96, -45, -65, -78, 91, 88, 114, 79, 96, -40, -2, -80, 67, 68, 114, 65, 33, -35, -16, -79, 95, Ascii.US, 107, 77, 97, -51, -31, -85, 89, Ascii.US, 114, 69, 121, -112, -63, -83, 91, 88, Byte.MAX_VALUE, 93, 75, -37, -30, -74, Ascii.EM, Ascii.CR, 125, 74, 96, -48, -24, -81, 88, 68, 111, Ascii.SUB, 47, -106, -63, -83, 91, 88, Byte.MAX_VALUE, 93, 75, -37, -30, -74, Ascii.EM, 90, 104, Ascii.RS, 62, -114, -72}, new byte[]{36, Ascii.SI, -66, -111, -62, 55, 49, Ascii.FS}));
        }
        composer.startReplaceGroup(-2143245584);
        boolean changedInstance = composer.changedInstance(this.$controller);
        NavHostController navHostController = this.$controller;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new PolicyDestKt$PolicyDest$1$$ExternalSyntheticLambda0(navHostController);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        PolicyScreenKt.PolicyScreen((Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{SignedBytes.MAX_POWER_OF_TWO, -52, -101, 80, Ascii.DC4, 108}, new byte[]{48, -93, -9, 57, 119, Ascii.NAK, 32, -108}))) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }
}
