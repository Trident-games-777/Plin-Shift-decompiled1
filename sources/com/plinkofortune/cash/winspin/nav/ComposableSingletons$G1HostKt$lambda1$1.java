package com.plinkofortune.cash.winspin.nav;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: com.plinkofortune.cash.winspin.nav.ComposableSingletons$G1HostKt$lambda-1$1  reason: invalid class name */
/* compiled from: G1Host.kt */
final class ComposableSingletons$G1HostKt$lambda1$1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    public static final ComposableSingletons$G1HostKt$lambda1$1 INSTANCE = new ComposableSingletons$G1HostKt$lambda1$1();

    ComposableSingletons$G1HostKt$lambda1$1() {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.animation.AnimatedContentScope r23, androidx.navigation.NavBackStackEntry r24, androidx.compose.runtime.Composer r25, int r26) {
        /*
            r22 = this;
            r11 = r25
            r0 = 16
            byte[] r0 = new byte[r0]
            r0 = {-21, 91, -49, 13, -29, 127, 119, 81, -94, 95, -56, 23, -15, 57, 120, 91} // fill-array
            r1 = 8
            byte[] r2 = new byte[r1]
            r2 = {-49, 47, -89, 100, -112, 91, 20, 62} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r2)
            r2 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 2
            byte[] r0 = new byte[r0]
            r0 = {-17, -69} // fill-array
            byte[] r2 = new byte[r1]
            r2 = {-122, -49, -72, 33, -76, -69, -117, -67} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r2)
            r2 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x004c
            r0 = 100
            byte[] r0 = new byte[r0]
            r0 = {-47, -101, 91, 78, 23, -111, -92, -62, -39, -101, 80, 15, 21, -119, -72, -62, -41, -38, 85, 1, 20, -107, -29, -37, -37, -102, 69, 16, 14, -109, -29, -62, -45, -126, 24, 35, 8, -112, -67, -61, -63, -107, 84, 12, 2, -82, -92, -62, -43, -104, 83, 20, 8, -109, -66, -120, -11, -59, 126, 15, 20, -119, -122, -40, -100, -104, 87, 13, 5, -103, -84, -127, -125, -38, 10, 1, 9, -110, -93, -43, -33, -101, 67, 19, 89, -35, -27, -21, -125, -68, 89, 19, 19, -45, -90, -40, -120, -59, 3, 73} // fill-array
            byte[] r2 = new byte[r1]
            r2 = {-78, -12, 54, 96, 103, -3, -51, -84} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r2)
            r2 = 845742951(0x32690367, float:1.3563159E-8)
            r3 = -1
            r4 = r26
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r3, r0)
        L_0x004c:
            r0 = 0
            androidx.navigation.Navigator[] r2 = new androidx.navigation.Navigator[r0]
            androidx.navigation.NavHostController r2 = androidx.navigation.compose.NavHostControllerKt.rememberNavController(r2, r11, r0)
            r3 = 4
            byte[] r3 = new byte[r3]
            r3 = {-73, -103, 49, -13} // fill-array
            byte[] r1 = new byte[r1]
            r1 = {-38, -4, 95, -122, -21, 108, -26, 9} // fill-array
            java.lang.String r1 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r1)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 0
            r5 = 0
            r6 = 1
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r3, r4, r6, r5)
            int r3 = com.plinkofortune.cash.winspin.R.drawable.bg
            androidx.compose.ui.graphics.painter.Painter r13 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r3, r11, r0)
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r16 = r0.getFillBounds()
            r19 = 54
            r20 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.PainterModifierKt.paint$default(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r3 = -1044149050(0xffffffffc1c38cc6, float:-24.443737)
            r11.startReplaceGroup(r3)
            boolean r3 = r11.changedInstance(r2)
            java.lang.Object r4 = r11.rememberedValue()
            if (r3 != 0) goto L_0x009f
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x00a7
        L_0x009f:
            com.plinkofortune.cash.winspin.nav.ComposableSingletons$G1HostKt$lambda-1$1$$ExternalSyntheticLambda0 r4 = new com.plinkofortune.cash.winspin.nav.ComposableSingletons$G1HostKt$lambda-1$1$$ExternalSyntheticLambda0
            r4.<init>(r2)
            r11.updateRememberedValue(r4)
        L_0x00a7:
            r10 = r4
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r11.endReplaceGroup()
            r13 = 0
            r14 = 1016(0x3f8, float:1.424E-42)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r12 = 48
            r21 = r2
            r2 = r0
            r0 = r21
            androidx.navigation.compose.NavHostKt.NavHost(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00ca
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.nav.ComposableSingletons$G1HostKt$lambda1$1.invoke(androidx.compose.animation.AnimatedContentScope, androidx.navigation.NavBackStackEntry, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavHostController navHostController, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, StringFog.decrypt(new byte[]{39, 62, 77, -51, -41, 105, -109, 56, 117, 2, 74, -41, -48}, new byte[]{3, 74, 37, -92, -92, 77, -35, 89}));
        MenuDestKt.MenuDest(navGraphBuilder, navHostController);
        ProfileDestKt.ProfileDest(navGraphBuilder, navHostController);
        HowToPlayDestKt.HowToPlayDest(navGraphBuilder, navHostController);
        PolicyDestKt.PolicyDest(navGraphBuilder, navHostController);
        TermsDestKt.TermsDest(navGraphBuilder, navHostController);
        LeadersDestKt.LeadersDest(navGraphBuilder, navHostController);
        StartDestKt.StartDest(navGraphBuilder, navHostController);
        SeqDestKt.SeqDest(navGraphBuilder, navHostController);
        return Unit.INSTANCE;
    }
}
