package androidx.navigation.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a1\u0010\u0006\u001a\u00020\u00022\"\u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\b\"\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r*\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"NavControllerSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/navigation/NavHostController;", "context", "Landroid/content/Context;", "createNavController", "rememberNavController", "navigators", "", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "([Landroidx/navigation/Navigator;Landroidx/compose/runtime/Composer;I)Landroidx/navigation/NavHostController;", "currentBackStackEntryAsState", "Landroidx/compose/runtime/State;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/navigation/NavController;", "(Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "navigation-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavHostController.kt */
public final class NavHostControllerKt {
    public static final State<NavBackStackEntry> currentBackStackEntryAsState(NavController navController, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -120375203, "C(currentBackStackEntryAsState)42@1719L20:NavHostController.kt#opm8kd");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-120375203, i, -1, "androidx.navigation.compose.currentBackStackEntryAsState (NavHostController.kt:41)");
        }
        Composer composer2 = composer;
        State<NavBackStackEntry> collectAsState = SnapshotStateKt.collectAsState(navController.getCurrentBackStackEntryFlow(), null, (CoroutineContext) null, composer2, 48, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return collectAsState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.navigation.NavHostController rememberNavController(androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>[] r8, androidx.compose.runtime.Composer r9, int r10) {
        /*
            java.lang.String r0 = "C(rememberNavController)58@2312L7,*59@2406L52,59@2331L127:NavHostController.kt#opm8kd"
            r1 = -312215566(0xffffffffed63f7f2, float:-4.4095528E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0014
            r0 = -1
            java.lang.String r2 = "androidx.navigation.compose.rememberNavController (NavHostController.kt:57)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r10, r0, r2)
        L_0x0014:
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r1)
            java.lang.Object r10 = r9.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            android.content.Context r10 = (android.content.Context) r10
            int r0 = r8.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r8, r0)
            androidx.compose.runtime.saveable.Saver r2 = NavControllerSaver(r10)
            r0 = 2106381045(0x7d8cd2f5, float:2.339841E37)
            java.lang.String r3 = "CC(remember):NavHostController.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r3)
            boolean r0 = r9.changedInstance(r10)
            java.lang.Object r3 = r9.rememberedValue()
            if (r0 != 0) goto L_0x004e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x0059
        L_0x004e:
            androidx.navigation.compose.NavHostControllerKt$rememberNavController$1$1 r0 = new androidx.navigation.compose.NavHostControllerKt$rememberNavController$1$1
            r0.<init>(r10)
            r3 = r0
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r9.updateRememberedValue(r3)
        L_0x0059:
            r4 = r3
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r6 = 0
            r7 = 4
            r3 = 0
            r5 = r9
            java.lang.Object r9 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            androidx.navigation.NavHostController r9 = (androidx.navigation.NavHostController) r9
            int r10 = r8.length
            r0 = 0
        L_0x006b:
            if (r0 >= r10) goto L_0x0079
            r1 = r8[r0]
            androidx.navigation.NavigatorProvider r2 = r9.getNavigatorProvider()
            r2.addNavigator(r1)
            int r0 = r0 + 1
            goto L_0x006b
        L_0x0079:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0082
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0082:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostControllerKt.rememberNavController(androidx.navigation.Navigator[], androidx.compose.runtime.Composer, int):androidx.navigation.NavHostController");
    }

    /* access modifiers changed from: private */
    public static final NavHostController createNavController(Context context) {
        NavHostController navHostController = new NavHostController(context);
        navHostController.getNavigatorProvider().addNavigator(new ComposeNavGraphNavigator(navHostController.getNavigatorProvider()));
        navHostController.getNavigatorProvider().addNavigator(new ComposeNavigator());
        navHostController.getNavigatorProvider().addNavigator(new DialogNavigator());
        return navHostController;
    }

    private static final Saver<NavHostController, ?> NavControllerSaver(Context context) {
        return SaverKt.Saver(NavHostControllerKt$NavControllerSaver$1.INSTANCE, new NavHostControllerKt$NavControllerSaver$2(context));
    }
}
