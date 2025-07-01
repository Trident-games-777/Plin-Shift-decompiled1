package com.plinkofortune.cash.winspin.nav;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.terms.TermsScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: TermsDest.kt */
final class TermsDestKt$TermsDest$1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $controller;

    TermsDestKt$TermsDest$1(NavHostController navHostController) {
        this.$controller = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, StringFog.decrypt(new byte[]{-78, 33, 90, Ascii.SO, Ascii.RS, -57, Ascii.NAK, 109, -5, 37, 93, Ascii.DC4, Ascii.FF, -127, Ascii.SUB, 103}, new byte[]{-106, 85, 50, 103, 109, -29, 118, 2}));
        Intrinsics.checkNotNullParameter(navBackStackEntry, StringFog.decrypt(new byte[]{-109, -79}, new byte[]{-6, -59, 48, Ascii.US, -19, -78, -42, 117}));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(104495006, i, -1, StringFog.decrypt(new byte[]{59, 59, 7, -82, -61, -108, 81, -110, 51, 59, Ascii.FF, -17, -63, -116, 77, -110, Base64.padSymbol, 122, 9, -31, -64, -112, Ascii.SYN, -117, 49, 58, Ascii.EM, -16, -38, -106, Ascii.SYN, -110, 57, 34, 68, -44, -42, -118, 85, -113, Ascii.FS, 49, Ascii.EM, -12, -99, -60, 89, -110, 55, 58, 19, -19, -36, -115, 75, -62, 120, 124, 62, -27, -63, -107, 75, -72, Base64.padSymbol, 39, Ascii.RS, -82, -40, -116, 2, -59, 113}, new byte[]{88, 84, 106, Byte.MIN_VALUE, -77, -8, 56, -4}));
        }
        composer.startReplaceGroup(-603275530);
        boolean changedInstance = composer.changedInstance(this.$controller);
        NavHostController navHostController = this.$controller;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TermsDestKt$TermsDest$1$$ExternalSyntheticLambda0(navHostController);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TermsScreenKt.TermsScreen((Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{-15, 113, 88, Base64.padSymbol, 48}, new byte[]{-123, Ascii.DC4, 42, 80, 67, 1, -30, Ascii.NAK}))) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }
}
