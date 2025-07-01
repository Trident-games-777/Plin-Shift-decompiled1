package com.plinkofortune.cash.winspin.nav;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"AppNav", "", "(Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: AppNav.kt */
public final class AppNavKt {
    /* access modifiers changed from: private */
    public static final Unit AppNav$lambda$2(int i, Composer composer, int i2) {
        AppNav(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AppNav(androidx.compose.runtime.Composer r17, int r18) {
        /*
            r0 = r18
            r1 = -899010239(0xffffffffca6a3141, float:-3837008.2)
            r2 = r17
            androidx.compose.runtime.Composer r13 = r2.startRestartGroup(r1)
            if (r0 != 0) goto L_0x0018
            boolean r2 = r13.getSkipping()
            if (r2 != 0) goto L_0x0014
            goto L_0x0018
        L_0x0014:
            r13.skipToGroupEnd()
            goto L_0x0089
        L_0x0018:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r3 = 8
            if (r2 == 0) goto L_0x0034
            r2 = 55
            byte[] r2 = new byte[r2]
            r2 = {89, -51, -57, 56, 126, 56, 56, -8, 81, -51, -52, 121, 124, 32, 36, -8, 95, -116, -55, 119, 125, 60, 127, -31, 83, -52, -39, 102, 103, 58, 127, -8, 91, -44, -124, 87, 126, 36, 31, -9, 76, -126, -126, 87, 126, 36, 31, -9, 76, -116, -63, 98, 52, 108, 120} // fill-array
            byte[] r4 = new byte[r3]
            r4 = {58, -94, -86, 22, 14, 84, 81, -106} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r4)
            r4 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r4, r2)
        L_0x0034:
            r1 = 0
            androidx.navigation.Navigator[] r2 = new androidx.navigation.Navigator[r1]
            androidx.navigation.NavHostController r2 = androidx.navigation.compose.NavHostControllerKt.rememberNavController(r2, r13, r1)
            r1 = 5
            byte[] r1 = new byte[r1]
            r1 = {-14, -107, -53, -3, 73} // fill-array
            byte[] r3 = new byte[r3]
            r3 = {-126, -25, -82, -100, 36, -80, -54, -9} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r1, r3)
            r1 = 1196193583(0x474c772f, float:52343.184)
            r13.startReplaceGroup(r1)
            boolean r1 = r13.changedInstance(r2)
            java.lang.Object r4 = r13.rememberedValue()
            if (r1 != 0) goto L_0x0062
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r4 != r1) goto L_0x006a
        L_0x0062:
            com.plinkofortune.cash.winspin.nav.AppNavKt$$ExternalSyntheticLambda0 r4 = new com.plinkofortune.cash.winspin.nav.AppNavKt$$ExternalSyntheticLambda0
            r4.<init>(r2)
            r13.updateRememberedValue(r4)
        L_0x006a:
            r12 = r4
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r13.endReplaceGroup()
            r15 = 0
            r16 = 1020(0x3fc, float:1.43E-42)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r14 = 48
            androidx.navigation.compose.NavHostKt.NavHost(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0089
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0089:
            androidx.compose.runtime.ScopeUpdateScope r1 = r13.endRestartGroup()
            if (r1 == 0) goto L_0x0097
            com.plinkofortune.cash.winspin.nav.AppNavKt$$ExternalSyntheticLambda1 r2 = new com.plinkofortune.cash.winspin.nav.AppNavKt$$ExternalSyntheticLambda1
            r2.<init>(r0)
            r1.updateScope(r2)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.nav.AppNavKt.AppNav(androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final Unit AppNav$lambda$1$lambda$0(NavHostController navHostController, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, StringFog.decrypt(new byte[]{82, -8, -27, -22, -19, -69, 118, -88, 0, -60, -30, -16, -22}, new byte[]{118, -116, -115, -125, -98, -97, 56, -55}));
        PreamHostKt.PreamHost(navGraphBuilder, navHostController);
        G1HostKt.G1Host(navGraphBuilder);
        return Unit.INSTANCE;
    }
}
