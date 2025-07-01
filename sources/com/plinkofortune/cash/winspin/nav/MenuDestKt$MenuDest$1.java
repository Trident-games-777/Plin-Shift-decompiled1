package com.plinkofortune.cash.winspin.nav;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: MenuDest.kt */
final class MenuDestKt$MenuDest$1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $controller;

    MenuDestKt$MenuDest$1(NavHostController navHostController) {
        this.$controller = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.animation.AnimatedContentScope r9, androidx.navigation.NavBackStackEntry r10, androidx.compose.runtime.Composer r11, int r12) {
        /*
            r8 = this;
            r0 = 16
            byte[] r0 = new byte[r0]
            r0 = {-123, 45, -47, 55, -76, -18, -96, -55, -52, 41, -42, 45, -90, -88, -81, -61} // fill-array
            r1 = 8
            byte[] r2 = new byte[r1]
            r2 = {-95, 89, -71, 94, -57, -54, -61, -90} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r9 = 2
            byte[] r9 = new byte[r9]
            r9 = {-101, 87} // fill-array
            byte[] r0 = new byte[r1]
            r0 = {-14, 35, -90, -125, 110, 112, 88, -100} // fill-array
            java.lang.String r9 = com.plinkofortune.cash.winspin.StringFog.decrypt(r9, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r9)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0044
            r9 = 71
            byte[] r9 = new byte[r9]
            r9 = {66, 110, 118, -93, 3, -71, -27, 104, 74, 110, 125, -30, 1, -95, -7, 104, 68, 47, 120, -20, 0, -67, -94, 113, 72, 111, 104, -3, 26, -69, -94, 104, 64, 119, 53, -64, 22, -69, -7, 66, 68, 114, 111, -93, 79, -76, -30, 105, 79, 120, 118, -30, 6, -90, -78, 38, 9, 76, 126, -29, 6, -111, -23, 117, 85, 47, 112, -7, 73, -20, -91} // fill-array
            byte[] r10 = new byte[r1]
            r10 = {33, 1, 27, -115, 115, -43, -116, 6} // fill-array
            java.lang.String r9 = com.plinkofortune.cash.winspin.StringFog.decrypt(r9, r10)
            r10 = 1554759398(0x5cabbee6, float:3.86736929E17)
            r0 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r12, r0, r9)
        L_0x0044:
            r9 = 1242959218(0x4a160d72, float:2458460.5)
            r11.startReplaceGroup(r9)
            androidx.navigation.NavHostController r9 = r8.$controller
            boolean r9 = r11.changedInstance(r9)
            androidx.navigation.NavHostController r10 = r8.$controller
            java.lang.Object r12 = r11.rememberedValue()
            if (r9 != 0) goto L_0x0060
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r12 != r9) goto L_0x0068
        L_0x0060:
            com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda0 r12 = new com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda0
            r12.<init>(r10)
            r11.updateRememberedValue(r12)
        L_0x0068:
            r0 = r12
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r11.endReplaceGroup()
            r9 = 1242964911(0x4a1623af, float:2459883.8)
            r11.startReplaceGroup(r9)
            androidx.navigation.NavHostController r9 = r8.$controller
            boolean r9 = r11.changedInstance(r9)
            androidx.navigation.NavHostController r10 = r8.$controller
            java.lang.Object r12 = r11.rememberedValue()
            if (r9 != 0) goto L_0x008a
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r12 != r9) goto L_0x0092
        L_0x008a:
            com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda1 r12 = new com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda1
            r12.<init>(r10)
            r11.updateRememberedValue(r12)
        L_0x0092:
            r1 = r12
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r11.endReplaceGroup()
            r9 = 1242970478(0x4a16396e, float:2461275.5)
            r11.startReplaceGroup(r9)
            androidx.navigation.NavHostController r9 = r8.$controller
            boolean r9 = r11.changedInstance(r9)
            androidx.navigation.NavHostController r10 = r8.$controller
            java.lang.Object r12 = r11.rememberedValue()
            if (r9 != 0) goto L_0x00b4
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r12 != r9) goto L_0x00bc
        L_0x00b4:
            com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda2 r12 = new com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda2
            r12.<init>(r10)
            r11.updateRememberedValue(r12)
        L_0x00bc:
            r2 = r12
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r11.endReplaceGroup()
            r9 = 1242987342(0x4a167b4e, float:2465491.5)
            r11.startReplaceGroup(r9)
            androidx.navigation.NavHostController r9 = r8.$controller
            boolean r9 = r11.changedInstance(r9)
            androidx.navigation.NavHostController r10 = r8.$controller
            java.lang.Object r12 = r11.rememberedValue()
            if (r9 != 0) goto L_0x00de
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r12 != r9) goto L_0x00e6
        L_0x00de:
            com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda3 r12 = new com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda3
            r12.<init>(r10)
            r11.updateRememberedValue(r12)
        L_0x00e6:
            r3 = r12
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r11.endReplaceGroup()
            r9 = 1242981744(0x4a166570, float:2464092.0)
            r11.startReplaceGroup(r9)
            androidx.navigation.NavHostController r9 = r8.$controller
            boolean r9 = r11.changedInstance(r9)
            androidx.navigation.NavHostController r10 = r8.$controller
            java.lang.Object r12 = r11.rememberedValue()
            if (r9 != 0) goto L_0x0108
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r12 != r9) goto L_0x0110
        L_0x0108:
            com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda4 r12 = new com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda4
            r12.<init>(r10)
            r11.updateRememberedValue(r12)
        L_0x0110:
            r4 = r12
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r11.endReplaceGroup()
            r9 = 1242976080(0x4a164f50, float:2462676.0)
            r11.startReplaceGroup(r9)
            androidx.navigation.NavHostController r9 = r8.$controller
            boolean r9 = r11.changedInstance(r9)
            androidx.navigation.NavHostController r10 = r8.$controller
            java.lang.Object r12 = r11.rememberedValue()
            if (r9 != 0) goto L_0x0132
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r12 != r9) goto L_0x013a
        L_0x0132:
            com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda5 r12 = new com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1$$ExternalSyntheticLambda5
            r12.<init>(r10)
            r11.updateRememberedValue(r12)
        L_0x013a:
            r5 = r12
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r11.endReplaceGroup()
            r7 = 0
            r6 = r11
            com.plinkofortune.cash.winspin.menu.MenuScreenKt.MenuScreen(r0, r1, r2, r3, r4, r5, r6, r7)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x014e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x014e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.nav.MenuDestKt$MenuDest$1.invoke(androidx.compose.animation.AnimatedContentScope, androidx.navigation.NavBackStackEntry, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{Ascii.SI, 39, -97, -4}, new byte[]{98, 66, -15, -119, -63, -24, -4, 9}))) {
            NavController.navigate$default((NavController) navHostController, StringFog.decrypt(new byte[]{-119, -61, -16, Ascii.CAN, 104, 108, 62, -49, -104}, new byte[]{-31, -84, -121, 108, 7, Ascii.FS, 82, -82}), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{Ascii.SUB, -87, -67, 55}, new byte[]{119, -52, -45, 66, 62, -98, Ascii.ESC, 96}))) {
            NavController.navigate$default((NavController) navHostController, StringFog.decrypt(new byte[]{49, Ascii.EM, Ascii.US, 113, -109, 106}, new byte[]{65, 118, 115, Ascii.CAN, -16, 19, -77, -95}), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{48, -125, -87, -24}, new byte[]{93, -26, -57, -99, Ascii.ETB, 73, -92, 60}))) {
            NavController.navigate$default((NavController) navHostController, StringFog.decrypt(new byte[]{34, 94, 88, -65, -89}, new byte[]{86, 59, 42, -46, -44, 91, 109, -98}), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$11$lambda$10(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{120, 8, -108, Ascii.NAK}, new byte[]{Ascii.NAK, 109, -6, 96, -36, 40, 91, 17}))) {
            NavController.navigate$default((NavController) navHostController, StringFog.decrypt(new byte[]{Ascii.SYN, -30, Ascii.FF, 90, 53, -74, -21}, new byte[]{122, -121, 109, 62, 80, -60, -104, -43}), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{Ascii.ETB, -90, -10, -4}, new byte[]{122, -61, -104, -119, -36, -69, 108, -124}))) {
            NavController.navigate$default((NavController) navHostController, StringFog.decrypt(new byte[]{72, -80, -22, -117, 72, 106, -86}, new byte[]{56, -62, -123, -19, 33, 6, -49, SignedBytes.MAX_POWER_OF_TWO}), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(NavHostController navHostController) {
        NavDestination currentDestination = navHostController.getCurrentDestination();
        if (Intrinsics.areEqual((Object) currentDestination != null ? currentDestination.getRoute() : null, (Object) StringFog.decrypt(new byte[]{48, 17, 39, -26}, new byte[]{93, 116, 73, -109, 93, -8, 89, 106}))) {
            NavController.navigate$default((NavController) navHostController, StringFog.decrypt(new byte[]{-105, 52, -84, 81, -34}, new byte[]{-28, SignedBytes.MAX_POWER_OF_TWO, -51, 35, -86, 125, 32, -71}), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
