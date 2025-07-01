package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aó\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2$\b\u0002\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0018\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0015\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001a»\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00100\u001f2$\b\u0002\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010$\u001a\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020%2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010%2$\b\u0002\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010&\u001aÚ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020%2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010%2\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0015\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u00112\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010'\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020%2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010%2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010(\u001a¿\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001d2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00100\u001f2$\b\u0002\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010)\u001a\u001c\u0010*\u001a\u0004\u0018\u00010\u000f*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010-\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010.\u001a\u0004\u0018\u00010\u000f*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010/\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u00100\u001a\u0004\u0018\u00010\u0017*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¨\u00061²\u0006\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e03X\u0002²\u0006\n\u00104\u001a\u000205X\u0002²\u0006\n\u00106\u001a\u000207X\u0002²\u0006\u0010\u00108\u001a\b\u0012\u0004\u0012\u00020\u000e03X\u0002²\u0006\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e03X\u0002"}, d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "graph", "Landroidx/navigation/NavGraph;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "enterTransition", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ExtensionFunctionType;", "exitTransition", "Landroidx/compose/animation/ExitTransition;", "popEnterTransition", "popExitTransition", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "startDestination", "", "route", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "builder", "Landroidx/navigation/NavGraphBuilder;", "(Landroidx/navigation/NavHostController;Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Lkotlin/reflect/KClass;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "createEnterTransition", "Landroidx/navigation/NavDestination;", "scope", "createExitTransition", "createPopEnterTransition", "createPopExitTransition", "createSizeTransform", "navigation-compose_release", "currentBackStack", "", "progress", "", "inPredictiveBack", "", "allVisibleEntries", "visibleEntries"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavHost.kt */
public final class NavHostKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: androidx.navigation.NavGraph} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void NavHost(androidx.navigation.NavHostController r16, java.lang.String r17, androidx.compose.ui.Modifier r18, java.lang.String r19, kotlin.jvm.functions.Function1 r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r0 = r16
            r12 = r17
            r13 = r20
            r14 = r22
            r1 = 141827520(0x8741dc0, float:7.346105E-34)
            r2 = r21
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(NavHost)P(2,4,1,3)93@3780L126,91@3740L190:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r23 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r14 | 6
            goto L_0x002d
        L_0x001d:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x002c
            boolean r2 = r9.changedInstance(r0)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r14
            goto L_0x002d
        L_0x002c:
            r2 = r14
        L_0x002d:
            r3 = r23 & 2
            r4 = 32
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            goto L_0x0045
        L_0x0036:
            r3 = r14 & 48
            if (r3 != 0) goto L_0x0045
            boolean r3 = r9.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x0042
            r3 = r4
            goto L_0x0044
        L_0x0042:
            r3 = 16
        L_0x0044:
            r2 = r2 | r3
        L_0x0045:
            r3 = r23 & 4
            if (r3 == 0) goto L_0x004c
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r5 = r14 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x005f
            r5 = r18
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r2 = r2 | r6
            goto L_0x0061
        L_0x005f:
            r5 = r18
        L_0x0061:
            r6 = r23 & 8
            r7 = 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x006a:
            r8 = r14 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007c
            r8 = r19
            boolean r10 = r9.changed((java.lang.Object) r8)
            if (r10 == 0) goto L_0x0078
            r10 = r7
            goto L_0x007a
        L_0x0078:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r10
            goto L_0x007e
        L_0x007c:
            r8 = r19
        L_0x007e:
            r10 = r23 & 16
            r11 = 16384(0x4000, float:2.2959E-41)
            if (r10 == 0) goto L_0x0087
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0087:
            r10 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x0096
            boolean r10 = r9.changedInstance(r13)
            if (r10 == 0) goto L_0x0093
            r10 = r11
            goto L_0x0095
        L_0x0093:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r2 = r2 | r10
        L_0x0096:
            r10 = r2 & 9363(0x2493, float:1.312E-41)
            r15 = 9362(0x2492, float:1.3119E-41)
            if (r10 != r15) goto L_0x00aa
            boolean r10 = r9.getSkipping()
            if (r10 != 0) goto L_0x00a3
            goto L_0x00aa
        L_0x00a3:
            r9.skipToGroupEnd()
            r3 = r5
            r4 = r8
            goto L_0x0128
        L_0x00aa:
            if (r3 == 0) goto L_0x00b1
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00b2
        L_0x00b1:
            r3 = r5
        L_0x00b2:
            if (r6 == 0) goto L_0x00b7
            r5 = 0
            r15 = r5
            goto L_0x00b8
        L_0x00b7:
            r15 = r8
        L_0x00b8:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00c4
            r5 = -1
            java.lang.String r6 = "androidx.navigation.compose.NavHost (NavHost.kt:90)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r2, r5, r6)
        L_0x00c4:
            r1 = 652764344(0x26e864b8, float:1.6125534E-15)
            java.lang.String r5 = "CC(remember):NavHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r5)
            r1 = r2 & 7168(0x1c00, float:1.0045E-41)
            r5 = 0
            r6 = 1
            if (r1 != r7) goto L_0x00d4
            r1 = r6
            goto L_0x00d5
        L_0x00d4:
            r1 = r5
        L_0x00d5:
            r7 = r2 & 112(0x70, float:1.57E-43)
            if (r7 != r4) goto L_0x00db
            r4 = r6
            goto L_0x00dc
        L_0x00db:
            r4 = r5
        L_0x00dc:
            r1 = r1 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r2
            if (r4 != r11) goto L_0x00e4
            r5 = r6
        L_0x00e4:
            r1 = r1 | r5
            java.lang.Object r4 = r9.rememberedValue()
            if (r1 != 0) goto L_0x00f3
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r4 != r1) goto L_0x0109
        L_0x00f3:
            r1 = r0
            androidx.navigation.NavController r1 = (androidx.navigation.NavController) r1
            androidx.navigation.NavigatorProvider r1 = r1.getNavigatorProvider()
            androidx.navigation.NavGraphBuilder r4 = new androidx.navigation.NavGraphBuilder
            r4.<init>((androidx.navigation.NavigatorProvider) r1, (java.lang.String) r12, (java.lang.String) r15)
            r13.invoke(r4)
            androidx.navigation.NavGraph r4 = r4.build()
            r9.updateRememberedValue(r4)
        L_0x0109:
            r1 = r4
            androidx.navigation.NavGraph r1 = (androidx.navigation.NavGraph) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r10 = r2 & 910(0x38e, float:1.275E-42)
            r11 = 504(0x1f8, float:7.06E-43)
            r2 = r3
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            NavHost(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0126
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0126:
            r3 = r2
            r4 = r15
        L_0x0128:
            androidx.compose.runtime.ScopeUpdateScope r8 = r9.endRestartGroup()
            if (r8 == 0) goto L_0x013f
            androidx.navigation.compose.NavHostKt$NavHost$2 r0 = new androidx.navigation.compose.NavHostKt$NavHost$2
            r1 = r16
            r7 = r23
            r2 = r12
            r5 = r13
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x013f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011e  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void NavHost(androidx.navigation.NavHostController r22, java.lang.String r23, androidx.compose.ui.Modifier r24, androidx.compose.ui.Alignment r25, java.lang.String r26, kotlin.jvm.functions.Function1 r27, kotlin.jvm.functions.Function1 r28, kotlin.jvm.functions.Function1 r29, kotlin.jvm.functions.Function1 r30, kotlin.jvm.functions.Function1 r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r0 = r22
            r12 = r23
            r13 = r31
            r14 = r33
            r15 = r34
            r1 = 410432995(0x1876b5e3, float:3.1886584E-24)
            r2 = r32
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(NavHost)P(5,9,4,1,8,2,3,6,7)145@6005L126,143@5965L320:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x001f
            r2 = r14 | 6
            goto L_0x002f
        L_0x001f:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x002e
            boolean r2 = r9.changedInstance(r0)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r2 = r2 | r14
            goto L_0x002f
        L_0x002e:
            r2 = r14
        L_0x002f:
            r3 = r15 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            goto L_0x0046
        L_0x0036:
            r3 = r14 & 48
            if (r3 != 0) goto L_0x0046
            boolean r3 = r9.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r2 = r2 | r3
        L_0x0046:
            r3 = r15 & 4
            if (r3 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r5 = r14 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0060
            r5 = r24
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r6
            goto L_0x0062
        L_0x0060:
            r5 = r24
        L_0x0062:
            r6 = r15 & 8
            if (r6 == 0) goto L_0x0069
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r7 = r14 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007c
            r7 = r25
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0078
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r8
            goto L_0x007e
        L_0x007c:
            r7 = r25
        L_0x007e:
            r8 = r15 & 16
            if (r8 == 0) goto L_0x0085
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0085:
            r11 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0099
            r11 = r26
            boolean r16 = r9.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x0094
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r16
            goto L_0x009b
        L_0x0099:
            r11 = r26
        L_0x009b:
            r16 = r15 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a6
            r2 = r2 | r17
            r4 = r27
            goto L_0x00b9
        L_0x00a6:
            r17 = r14 & r17
            r4 = r27
            if (r17 != 0) goto L_0x00b9
            boolean r17 = r9.changedInstance(r4)
            if (r17 == 0) goto L_0x00b5
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r2 = r2 | r17
        L_0x00b9:
            r17 = r15 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c4
            r2 = r2 | r18
            r10 = r28
            goto L_0x00d7
        L_0x00c4:
            r18 = r14 & r18
            r10 = r28
            if (r18 != 0) goto L_0x00d7
            boolean r19 = r9.changedInstance(r10)
            if (r19 == 0) goto L_0x00d3
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r2 = r2 | r19
        L_0x00d7:
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r19 = r14 & r19
            if (r19 != 0) goto L_0x00f3
            r1 = r15 & 128(0x80, float:1.794E-43)
            if (r1 != 0) goto L_0x00ec
            r1 = r29
            boolean r20 = r9.changedInstance(r1)
            if (r20 == 0) goto L_0x00ee
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ec:
            r1 = r29
        L_0x00ee:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r2 = r2 | r20
            goto L_0x00f5
        L_0x00f3:
            r1 = r29
        L_0x00f5:
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r20 = r14 & r20
            if (r20 != 0) goto L_0x0111
            r0 = r15 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010a
            r0 = r30
            boolean r20 = r9.changedInstance(r0)
            if (r20 == 0) goto L_0x010c
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010a:
            r0 = r30
        L_0x010c:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r2 = r2 | r20
            goto L_0x0113
        L_0x0111:
            r0 = r30
        L_0x0113:
            r0 = r15 & 512(0x200, float:7.175E-43)
            r20 = r0
            r21 = 805306368(0x30000000, float:4.656613E-10)
            if (r20 == 0) goto L_0x011e
            r2 = r2 | r21
            goto L_0x012f
        L_0x011e:
            r20 = r14 & r21
            if (r20 != 0) goto L_0x012f
            boolean r20 = r9.changedInstance(r13)
            if (r20 == 0) goto L_0x012b
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012d
        L_0x012b:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012d:
            r2 = r2 | r20
        L_0x012f:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r2 & r20
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x014f
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x0140
            goto L_0x014f
        L_0x0140:
            r9.skipToGroupEnd()
            r8 = r29
            r6 = r4
            r3 = r5
            r4 = r7
            r0 = r9
            r7 = r10
            r5 = r11
            r9 = r30
            goto L_0x0256
        L_0x014f:
            r9.startDefaults()
            r0 = r14 & 1
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r20 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r0 == 0) goto L_0x017b
            boolean r0 = r9.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0163
            goto L_0x017b
        L_0x0163:
            r9.skipToGroupEnd()
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x016c
            r2 = r2 & r20
        L_0x016c:
            r0 = r15 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0171
            r2 = r2 & r1
        L_0x0171:
            r6 = r29
        L_0x0173:
            r1 = r2
            r2 = r5
            r3 = r7
            r5 = r10
            r0 = r11
            r7 = r30
            goto L_0x01b6
        L_0x017b:
            if (r3 == 0) goto L_0x0182
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0182:
            if (r6 == 0) goto L_0x018b
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r7 = r0
        L_0x018b:
            if (r8 == 0) goto L_0x018f
            r0 = 0
            r11 = r0
        L_0x018f:
            if (r16 == 0) goto L_0x0196
            androidx.navigation.compose.NavHostKt$NavHost$3 r0 = androidx.navigation.compose.NavHostKt$NavHost$3.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r4 = r0
        L_0x0196:
            if (r17 == 0) goto L_0x019d
            androidx.navigation.compose.NavHostKt$NavHost$4 r0 = androidx.navigation.compose.NavHostKt$NavHost$4.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r10 = r0
        L_0x019d:
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01a5
            r2 = r2 & r20
            r0 = r4
            goto L_0x01a7
        L_0x01a5:
            r0 = r29
        L_0x01a7:
            r3 = r15 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x01b4
            r2 = r2 & r1
            r6 = r0
            r1 = r2
            r2 = r5
            r3 = r7
            r5 = r10
            r7 = r5
            r0 = r11
            goto L_0x01b6
        L_0x01b4:
            r6 = r0
            goto L_0x0173
        L_0x01b6:
            r9.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x01c8
            r8 = -1
            java.lang.String r10 = "androidx.navigation.compose.NavHost (NavHost.kt:142)"
            r11 = 410432995(0x1876b5e3, float:3.1886584E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r1, r8, r10)
        L_0x01c8:
            r8 = 652835544(0x26e97ad8, float:1.620092E-15)
            java.lang.String r10 = "CC(remember):NavHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r8, r10)
            r8 = 57344(0xe000, float:8.0356E-41)
            r10 = r1 & r8
            r16 = 1
            r24 = r8
            r8 = 16384(0x4000, float:2.2959E-41)
            if (r10 != r8) goto L_0x01e0
            r8 = r16
            goto L_0x01e1
        L_0x01e0:
            r8 = 0
        L_0x01e1:
            r10 = r1 & 112(0x70, float:1.57E-43)
            r11 = 32
            if (r10 != r11) goto L_0x01ea
            r10 = r16
            goto L_0x01eb
        L_0x01ea:
            r10 = 0
        L_0x01eb:
            r8 = r8 | r10
            r10 = 1879048192(0x70000000, float:1.58456325E29)
            r10 = r10 & r1
            r11 = 536870912(0x20000000, float:1.0842022E-19)
            if (r10 != r11) goto L_0x01f6
            r11 = r16
            goto L_0x01f7
        L_0x01f6:
            r11 = 0
        L_0x01f7:
            r8 = r8 | r11
            java.lang.Object r10 = r9.rememberedValue()
            if (r8 != 0) goto L_0x0206
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r10 != r8) goto L_0x021d
        L_0x0206:
            r8 = r22
            androidx.navigation.NavController r8 = (androidx.navigation.NavController) r8
            androidx.navigation.NavigatorProvider r8 = r8.getNavigatorProvider()
            androidx.navigation.NavGraphBuilder r10 = new androidx.navigation.NavGraphBuilder
            r10.<init>((androidx.navigation.NavigatorProvider) r8, (java.lang.String) r12, (java.lang.String) r0)
            r13.invoke(r10)
            androidx.navigation.NavGraph r10 = r10.build()
            r9.updateRememberedValue(r10)
        L_0x021d:
            androidx.navigation.NavGraph r10 = (androidx.navigation.NavGraph) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r8 = r1 & 8078(0x1f8e, float:1.132E-41)
            int r1 = r1 >> 3
            r11 = r1 & r24
            r8 = r8 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r1
            r8 = r8 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r1
            r8 = r8 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r11
            r1 = r1 | r8
            r11 = 256(0x100, float:3.59E-43)
            r8 = 0
            r16 = r10
            r10 = r1
            r1 = r16
            r16 = r0
            r0 = r22
            NavHost(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x024d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x024d:
            r8 = r6
            r0 = r9
            r6 = r4
            r9 = r7
            r4 = r3
            r7 = r5
            r5 = r16
            r3 = r2
        L_0x0256:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x026e
            r1 = r0
            androidx.navigation.compose.NavHostKt$NavHost$6 r0 = new androidx.navigation.compose.NavHostKt$NavHost$6
            r2 = r12
            r10 = r13
            r11 = r14
            r12 = r15
            r13 = r1
            r1 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x026e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavHost(androidx.navigation.NavHostController r25, java.lang.String r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.Alignment r28, java.lang.String r29, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r30, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r31, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r32, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r33, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r34, kotlin.jvm.functions.Function1<? super androidx.navigation.NavGraphBuilder, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38, int r39) {
        /*
            r1 = r25
            r12 = r26
            r13 = r35
            r14 = r37
            r15 = r39
            r0 = 1840250294(0x6daffdb6, float:6.8083243E27)
            r2 = r36
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(NavHost)P(5,10,4,1,8,2,3,6,7,9)213@8656L126,211@8616L343:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x001f
            r2 = r14 | 6
            goto L_0x002f
        L_0x001f:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x002e
            boolean r2 = r9.changedInstance(r1)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r2 = r2 | r14
            goto L_0x002f
        L_0x002e:
            r2 = r14
        L_0x002f:
            r5 = r15 & 2
            if (r5 == 0) goto L_0x0036
            r2 = r2 | 48
            goto L_0x0046
        L_0x0036:
            r5 = r14 & 48
            if (r5 != 0) goto L_0x0046
            boolean r5 = r9.changed((java.lang.Object) r12)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
        L_0x0046:
            r5 = r15 & 4
            if (r5 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r7 = r14 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0060
            r7 = r27
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005c
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r8
            goto L_0x0062
        L_0x0060:
            r7 = r27
        L_0x0062:
            r8 = r15 & 8
            if (r8 == 0) goto L_0x0069
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r10 = r14 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007c
            r10 = r28
            boolean r11 = r9.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0078
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r11
            goto L_0x007e
        L_0x007c:
            r10 = r28
        L_0x007e:
            r11 = r15 & 16
            if (r11 == 0) goto L_0x0085
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0085:
            r6 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x0099
            r6 = r29
            boolean r17 = r9.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x0094
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r17
            goto L_0x009b
        L_0x0099:
            r6 = r29
        L_0x009b:
            r17 = r15 & 32
            r18 = 196608(0x30000, float:2.75506E-40)
            if (r17 == 0) goto L_0x00a6
            r2 = r2 | r18
            r3 = r30
            goto L_0x00b9
        L_0x00a6:
            r18 = r14 & r18
            r3 = r30
            if (r18 != 0) goto L_0x00b9
            boolean r19 = r9.changedInstance(r3)
            if (r19 == 0) goto L_0x00b5
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r2 = r2 | r19
        L_0x00b9:
            r19 = r15 & 64
            r20 = 1572864(0x180000, float:2.204052E-39)
            if (r19 == 0) goto L_0x00c4
            r2 = r2 | r20
            r0 = r31
            goto L_0x00d7
        L_0x00c4:
            r20 = r14 & r20
            r0 = r31
            if (r20 != 0) goto L_0x00d7
            boolean r21 = r9.changedInstance(r0)
            if (r21 == 0) goto L_0x00d3
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r2 = r2 | r21
        L_0x00d7:
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r21 = r14 & r21
            if (r21 != 0) goto L_0x00f3
            r4 = r15 & 128(0x80, float:1.794E-43)
            if (r4 != 0) goto L_0x00ec
            r4 = r32
            boolean r22 = r9.changedInstance(r4)
            if (r22 == 0) goto L_0x00ee
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ec:
            r4 = r32
        L_0x00ee:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r2 = r2 | r22
            goto L_0x00f5
        L_0x00f3:
            r4 = r32
        L_0x00f5:
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            r22 = r14 & r22
            if (r22 != 0) goto L_0x0111
            r0 = r15 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010a
            r0 = r33
            boolean r22 = r9.changedInstance(r0)
            if (r22 == 0) goto L_0x010c
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010a:
            r0 = r33
        L_0x010c:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r2 = r2 | r22
            goto L_0x0113
        L_0x0111:
            r0 = r33
        L_0x0113:
            r0 = r15 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x011c
            r2 = r2 | r22
            goto L_0x0132
        L_0x011c:
            r22 = r14 & r22
            if (r22 != 0) goto L_0x0132
            r22 = r0
            r0 = r34
            boolean r23 = r9.changedInstance(r0)
            if (r23 == 0) goto L_0x012d
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012f
        L_0x012d:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012f:
            r2 = r2 | r23
            goto L_0x0136
        L_0x0132:
            r22 = r0
            r0 = r34
        L_0x0136:
            r0 = r15 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x013d
            r0 = r38 | 6
            goto L_0x014f
        L_0x013d:
            r0 = r38 & 6
            if (r0 != 0) goto L_0x014d
            boolean r0 = r9.changedInstance(r13)
            if (r0 == 0) goto L_0x0149
            r0 = 4
            goto L_0x014a
        L_0x0149:
            r0 = 2
        L_0x014a:
            r0 = r38 | r0
            goto L_0x014f
        L_0x014d:
            r0 = r38
        L_0x014f:
            r23 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r2 & r23
            r23 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x0178
            r1 = r0 & 3
            r2 = 2
            if (r1 != r2) goto L_0x0178
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x0167
            goto L_0x0178
        L_0x0167:
            r9.skipToGroupEnd()
            r8 = r4
            r5 = r6
            r0 = r9
            r4 = r10
            r9 = r33
            r10 = r34
            r6 = r3
            r3 = r7
            r7 = r31
            goto L_0x02a3
        L_0x0178:
            r9.startDefaults()
            r1 = r14 & 1
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r1 == 0) goto L_0x01ab
            boolean r1 = r9.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0189
            goto L_0x01ab
        L_0x0189:
            r9.skipToGroupEnd()
            r1 = r15 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0193
            r2 = r23 & r2
            goto L_0x0195
        L_0x0193:
            r2 = r23
        L_0x0195:
            r1 = r15 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x019d
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r2 & r1
        L_0x019d:
            r5 = r31
            r8 = r34
            r1 = r6
            r6 = r4
            r4 = r3
            r3 = r10
            r10 = r2
            r2 = r7
            r7 = r33
            goto L_0x01ff
        L_0x01ab:
            if (r5 == 0) goto L_0x01b2
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01b3
        L_0x01b2:
            r1 = r7
        L_0x01b3:
            if (r8 == 0) goto L_0x01bc
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            goto L_0x01bd
        L_0x01bc:
            r5 = r10
        L_0x01bd:
            r7 = 0
            if (r11 == 0) goto L_0x01c1
            r6 = r7
        L_0x01c1:
            if (r17 == 0) goto L_0x01c7
            androidx.navigation.compose.NavHostKt$NavHost$7 r3 = androidx.navigation.compose.NavHostKt$NavHost$7.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
        L_0x01c7:
            if (r19 == 0) goto L_0x01ce
            androidx.navigation.compose.NavHostKt$NavHost$8 r8 = androidx.navigation.compose.NavHostKt$NavHost$8.INSTANCE
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            goto L_0x01d0
        L_0x01ce:
            r8 = r31
        L_0x01d0:
            r10 = r15 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x01d8
            r2 = r23 & r2
            r4 = r3
            goto L_0x01da
        L_0x01d8:
            r2 = r23
        L_0x01da:
            r10 = r15 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x01e5
            r10 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r2 & r10
            r10 = r2
            r2 = r8
            goto L_0x01e8
        L_0x01e5:
            r10 = r2
            r2 = r33
        L_0x01e8:
            if (r22 == 0) goto L_0x01f6
            r24 = r2
            r2 = r1
            r1 = r6
            r6 = r4
            r4 = r3
            r3 = r5
            r5 = r8
            r8 = r7
            r7 = r24
            goto L_0x01ff
        L_0x01f6:
            r7 = r2
            r2 = r1
            r1 = r6
            r6 = r4
            r4 = r3
            r3 = r5
            r5 = r8
            r8 = r34
        L_0x01ff:
            r9.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0213
            java.lang.String r11 = "androidx.navigation.compose.NavHost (NavHost.kt:210)"
            r27 = r2
            r2 = 1840250294(0x6daffdb6, float:6.8083243E27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r0, r11)
            goto L_0x0215
        L_0x0213:
            r27 = r2
        L_0x0215:
            r2 = 652920376(0x26eac638, float:1.6290739E-15)
            java.lang.String r11 = "CC(remember):NavHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r11)
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r10
            r17 = 1
            r11 = 16384(0x4000, float:2.2959E-41)
            if (r2 != r11) goto L_0x022a
            r2 = r17
            goto L_0x022b
        L_0x022a:
            r2 = 0
        L_0x022b:
            r11 = r10 & 112(0x70, float:1.57E-43)
            r18 = r0
            r0 = 32
            if (r11 != r0) goto L_0x0236
            r0 = r17
            goto L_0x0237
        L_0x0236:
            r0 = 0
        L_0x0237:
            r0 = r0 | r2
            r2 = r18 & 14
            r11 = 4
            if (r2 != r11) goto L_0x0240
            r11 = r17
            goto L_0x0241
        L_0x0240:
            r11 = 0
        L_0x0241:
            r0 = r0 | r11
            java.lang.Object r2 = r9.rememberedValue()
            if (r0 != 0) goto L_0x0250
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0267
        L_0x0250:
            r0 = r25
            androidx.navigation.NavController r0 = (androidx.navigation.NavController) r0
            androidx.navigation.NavigatorProvider r0 = r0.getNavigatorProvider()
            androidx.navigation.NavGraphBuilder r2 = new androidx.navigation.NavGraphBuilder
            r2.<init>((androidx.navigation.NavigatorProvider) r0, (java.lang.String) r12, (java.lang.String) r1)
            r13.invoke(r2)
            androidx.navigation.NavGraph r2 = r2.build()
            r9.updateRememberedValue(r2)
        L_0x0267:
            androidx.navigation.NavGraph r2 = (androidx.navigation.NavGraph) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = r10 & 8078(0x1f8e, float:1.132E-41)
            int r10 = r10 >> 3
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r10
            r0 = r0 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r10
            r0 = r0 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r10
            r0 = r0 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r11 = r11 & r10
            r0 = r0 | r11
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r10 = r10 & r11
            r10 = r10 | r0
            r11 = 0
            r0 = r25
            r16 = r1
            r1 = r2
            r2 = r27
            NavHost(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0299
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0299:
            r10 = r8
            r0 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r5 = r16
            r4 = r3
            r3 = r2
        L_0x02a3:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x02bd
            r1 = r0
            androidx.navigation.compose.NavHostKt$NavHost$10 r0 = new androidx.navigation.compose.NavHostKt$NavHost$10
            r2 = r12
            r11 = r13
            r12 = r14
            r14 = r15
            r13 = r38
            r15 = r1
            r1 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x02bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavHost(androidx.navigation.NavHostController r27, kotlin.reflect.KClass<?> r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.Alignment r30, kotlin.reflect.KClass<?> r31, java.util.Map<kotlin.reflect.KType, androidx.navigation.NavType<?>> r32, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r33, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r34, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r35, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r36, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r37, kotlin.jvm.functions.Function1<? super androidx.navigation.NavGraphBuilder, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41, int r42) {
        /*
            r0 = r27
            r12 = r28
            r13 = r38
            r14 = r40
            r15 = r42
            r1 = 750467758(0x2cbb3aae, float:5.3213744E-12)
            r2 = r39
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(NavHost)P(5,10,4,1,8,11,2,3,6,7,9)285@11603L135,283@11563L352:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x001f
            r2 = r14 | 6
            goto L_0x002f
        L_0x001f:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x002e
            boolean r2 = r9.changedInstance(r0)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r2 = r2 | r14
            goto L_0x002f
        L_0x002e:
            r2 = r14
        L_0x002f:
            r5 = r15 & 2
            if (r5 == 0) goto L_0x0036
            r2 = r2 | 48
            goto L_0x0046
        L_0x0036:
            r5 = r14 & 48
            if (r5 != 0) goto L_0x0046
            boolean r5 = r9.changedInstance(r12)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
        L_0x0046:
            r5 = r15 & 4
            if (r5 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r8 = r14 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0060
            r8 = r29
            boolean r10 = r9.changed((java.lang.Object) r8)
            if (r10 == 0) goto L_0x005c
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r10
            goto L_0x0062
        L_0x0060:
            r8 = r29
        L_0x0062:
            r10 = r15 & 8
            if (r10 == 0) goto L_0x0069
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x0069:
            r11 = r14 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007d
            r11 = r30
            boolean r16 = r9.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x0078
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r16
            goto L_0x007f
        L_0x007d:
            r11 = r30
        L_0x007f:
            r16 = r15 & 16
            if (r16 == 0) goto L_0x0086
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0086:
            r3 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x009a
            r3 = r31
            boolean r17 = r9.changedInstance(r3)
            if (r17 == 0) goto L_0x0095
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r17
            goto L_0x009c
        L_0x009a:
            r3 = r31
        L_0x009c:
            r17 = r15 & 32
            r18 = 196608(0x30000, float:2.75506E-40)
            if (r17 == 0) goto L_0x00a7
            r2 = r2 | r18
            r4 = r32
            goto L_0x00ba
        L_0x00a7:
            r18 = r14 & r18
            r4 = r32
            if (r18 != 0) goto L_0x00ba
            boolean r19 = r9.changedInstance(r4)
            if (r19 == 0) goto L_0x00b6
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r2 = r2 | r19
        L_0x00ba:
            r19 = r15 & 64
            r20 = 1572864(0x180000, float:2.204052E-39)
            if (r19 == 0) goto L_0x00c5
            r2 = r2 | r20
            r6 = r33
            goto L_0x00d8
        L_0x00c5:
            r20 = r14 & r20
            r6 = r33
            if (r20 != 0) goto L_0x00d8
            boolean r21 = r9.changedInstance(r6)
            if (r21 == 0) goto L_0x00d4
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r2 = r2 | r21
        L_0x00d8:
            r7 = r15 & 128(0x80, float:1.794E-43)
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            if (r7 == 0) goto L_0x00e3
            r2 = r2 | r22
            r1 = r34
            goto L_0x00f6
        L_0x00e3:
            r22 = r14 & r22
            r1 = r34
            if (r22 != 0) goto L_0x00f6
            boolean r23 = r9.changedInstance(r1)
            if (r23 == 0) goto L_0x00f2
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r2 = r2 | r23
        L_0x00f6:
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r23 = r14 & r23
            if (r23 != 0) goto L_0x0112
            r0 = r15 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010b
            r0 = r35
            boolean r23 = r9.changedInstance(r0)
            if (r23 == 0) goto L_0x010d
            r23 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010b:
            r0 = r35
        L_0x010d:
            r23 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r2 = r2 | r23
            goto L_0x0114
        L_0x0112:
            r0 = r35
        L_0x0114:
            r23 = 805306368(0x30000000, float:4.656613E-10)
            r23 = r14 & r23
            if (r23 != 0) goto L_0x0130
            r0 = r15 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0129
            r0 = r36
            boolean r23 = r9.changedInstance(r0)
            if (r23 == 0) goto L_0x012b
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012d
        L_0x0129:
            r0 = r36
        L_0x012b:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012d:
            r2 = r2 | r23
            goto L_0x0132
        L_0x0130:
            r0 = r36
        L_0x0132:
            r0 = r15 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x013d
            r18 = r41 | 6
            r23 = r0
            r0 = r37
            goto L_0x0159
        L_0x013d:
            r23 = r41 & 6
            if (r23 != 0) goto L_0x0153
            r23 = r0
            r0 = r37
            boolean r24 = r9.changedInstance(r0)
            if (r24 == 0) goto L_0x014e
            r18 = 4
            goto L_0x0150
        L_0x014e:
            r18 = 2
        L_0x0150:
            r18 = r41 | r18
            goto L_0x0159
        L_0x0153:
            r23 = r0
            r0 = r37
            r18 = r41
        L_0x0159:
            r0 = r15 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0160
            r18 = r18 | 48
            goto L_0x0171
        L_0x0160:
            r0 = r41 & 48
            if (r0 != 0) goto L_0x0171
            boolean r0 = r9.changedInstance(r13)
            if (r0 == 0) goto L_0x016d
            r20 = 32
            goto L_0x016f
        L_0x016d:
            r20 = 16
        L_0x016f:
            r18 = r18 | r20
        L_0x0171:
            r0 = r18
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r2 & r18
            r39 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x019f
            r1 = r0 & 19
            r2 = 18
            if (r1 != r2) goto L_0x019f
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x018c
            goto L_0x019f
        L_0x018c:
            r9.skipToGroupEnd()
            r10 = r36
            r5 = r3
            r7 = r6
            r3 = r8
            r0 = r9
            r8 = r34
            r9 = r35
            r6 = r4
            r4 = r11
            r11 = r37
            goto L_0x02cb
        L_0x019f:
            r9.startDefaults()
            r1 = r14 & 1
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r18 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r1 == 0) goto L_0x01d3
            boolean r1 = r9.getDefaultsInvalid()
            if (r1 == 0) goto L_0x01b3
            goto L_0x01d3
        L_0x01b3:
            r9.skipToGroupEnd()
            r1 = r15 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01bd
            r1 = r39 & r18
            goto L_0x01bf
        L_0x01bd:
            r1 = r39
        L_0x01bf:
            r5 = r15 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x01c4
            r1 = r1 & r2
        L_0x01c4:
            r2 = r11
            r11 = r1
            r1 = r3
            r3 = r2
            r5 = r34
            r10 = r35
            r7 = r36
            r2 = r8
        L_0x01cf:
            r8 = r37
            goto L_0x022a
        L_0x01d3:
            if (r5 == 0) goto L_0x01da
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01db
        L_0x01da:
            r1 = r8
        L_0x01db:
            if (r10 == 0) goto L_0x01e4
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            goto L_0x01e5
        L_0x01e4:
            r5 = r11
        L_0x01e5:
            r8 = 0
            if (r16 == 0) goto L_0x01e9
            r3 = r8
        L_0x01e9:
            if (r17 == 0) goto L_0x01ef
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
        L_0x01ef:
            if (r19 == 0) goto L_0x01f5
            androidx.navigation.compose.NavHostKt$NavHost$11 r6 = androidx.navigation.compose.NavHostKt$NavHost$11.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
        L_0x01f5:
            if (r7 == 0) goto L_0x01fc
            androidx.navigation.compose.NavHostKt$NavHost$12 r7 = androidx.navigation.compose.NavHostKt$NavHost$12.INSTANCE
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            goto L_0x01fe
        L_0x01fc:
            r7 = r34
        L_0x01fe:
            r10 = r15 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0207
            r10 = r39 & r18
            r11 = r10
            r10 = r6
            goto L_0x020b
        L_0x0207:
            r10 = r35
            r11 = r39
        L_0x020b:
            r39 = r2
            r2 = r15 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0216
            r2 = r11 & r39
            r11 = r2
            r2 = r7
            goto L_0x0218
        L_0x0216:
            r2 = r36
        L_0x0218:
            if (r23 == 0) goto L_0x0223
            r26 = r2
            r2 = r1
            r1 = r3
            r3 = r5
            r5 = r7
            r7 = r26
            goto L_0x022a
        L_0x0223:
            r8 = r2
            r2 = r1
            r1 = r3
            r3 = r5
            r5 = r7
            r7 = r8
            goto L_0x01cf
        L_0x022a:
            r9.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r29 = r2
            if (r16 == 0) goto L_0x0240
            java.lang.String r2 = "androidx.navigation.compose.NavHost (NavHost.kt:282)"
            r30 = r3
            r3 = 750467758(0x2cbb3aae, float:5.3213744E-12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r11, r0, r2)
            goto L_0x0242
        L_0x0240:
            r30 = r3
        L_0x0242:
            r2 = 653014689(0x26ec36a1, float:1.6390597E-15)
            java.lang.String r3 = "CC(remember):NavHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            boolean r2 = r9.changed((java.lang.Object) r1)
            boolean r3 = r9.changed((java.lang.Object) r12)
            r2 = r2 | r3
            r3 = r0 & 112(0x70, float:1.57E-43)
            r39 = r0
            r0 = 32
            if (r3 != r0) goto L_0x025d
            r0 = 1
            goto L_0x025e
        L_0x025d:
            r0 = 0
        L_0x025e:
            r0 = r0 | r2
            java.lang.Object r2 = r9.rememberedValue()
            if (r0 != 0) goto L_0x026d
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0284
        L_0x026d:
            r0 = r27
            androidx.navigation.NavController r0 = (androidx.navigation.NavController) r0
            androidx.navigation.NavigatorProvider r0 = r0.getNavigatorProvider()
            androidx.navigation.NavGraphBuilder r2 = new androidx.navigation.NavGraphBuilder
            r2.<init>((androidx.navigation.NavigatorProvider) r0, (kotlin.reflect.KClass<?>) r12, (kotlin.reflect.KClass<?>) r1, (java.util.Map<kotlin.reflect.KType, androidx.navigation.NavType<?>>) r4)
            r13.invoke(r2)
            androidx.navigation.NavGraph r2 = r2.build()
            r9.updateRememberedValue(r2)
        L_0x0284:
            androidx.navigation.NavGraph r2 = (androidx.navigation.NavGraph) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = r11 & 8078(0x1f8e, float:1.132E-41)
            int r3 = r11 >> 6
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r11
            r0 = r0 | r3
            int r3 = r39 << 24
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r11
            r0 = r0 | r3
            r11 = 0
            r3 = r30
            r16 = r1
            r1 = r2
            r17 = r4
            r4 = r6
            r6 = r10
            r2 = r29
            r10 = r0
            r0 = r27
            NavHost(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02bf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02bf:
            r10 = r7
            r11 = r8
            r0 = r9
            r7 = r4
            r8 = r5
            r9 = r6
            r5 = r16
            r6 = r17
            r4 = r3
            r3 = r2
        L_0x02cb:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x02e7
            r1 = r0
            androidx.navigation.compose.NavHostKt$NavHost$14 r0 = new androidx.navigation.compose.NavHostKt$NavHost$14
            r25 = r1
            r2 = r12
            r12 = r13
            r13 = r14
            r1 = r27
            r14 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r25
            r1.updateScope(r0)
        L_0x02e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, kotlin.reflect.KClass, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.reflect.KClass, java.util.Map, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavHost(androidx.navigation.NavHostController r27, java.lang.Object r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.Alignment r30, kotlin.reflect.KClass<?> r31, java.util.Map<kotlin.reflect.KType, androidx.navigation.NavType<?>> r32, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r33, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r34, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r35, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r36, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r37, kotlin.jvm.functions.Function1<? super androidx.navigation.NavGraphBuilder, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41, int r42) {
        /*
            r0 = r27
            r12 = r28
            r13 = r38
            r14 = r40
            r15 = r42
            r1 = -1476019057(0xffffffffa805bc8f, float:-7.42387E-15)
            r2 = r39
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(NavHost)P(5,10,4,1,8,11,2,3,6,7,9)357@14555L135,355@14515L352:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x001f
            r2 = r14 | 6
            goto L_0x002f
        L_0x001f:
            r2 = r14 & 6
            if (r2 != 0) goto L_0x002e
            boolean r2 = r9.changedInstance(r0)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r2 = r2 | r14
            goto L_0x002f
        L_0x002e:
            r2 = r14
        L_0x002f:
            r5 = r15 & 2
            if (r5 == 0) goto L_0x0036
            r2 = r2 | 48
            goto L_0x0046
        L_0x0036:
            r5 = r14 & 48
            if (r5 != 0) goto L_0x0046
            boolean r5 = r9.changedInstance(r12)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
        L_0x0046:
            r5 = r15 & 4
            if (r5 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r8 = r14 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0060
            r8 = r29
            boolean r10 = r9.changed((java.lang.Object) r8)
            if (r10 == 0) goto L_0x005c
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r10
            goto L_0x0062
        L_0x0060:
            r8 = r29
        L_0x0062:
            r10 = r15 & 8
            if (r10 == 0) goto L_0x0069
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x0069:
            r11 = r14 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007d
            r11 = r30
            boolean r16 = r9.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x0078
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r16
            goto L_0x007f
        L_0x007d:
            r11 = r30
        L_0x007f:
            r16 = r15 & 16
            if (r16 == 0) goto L_0x0086
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0086:
            r3 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x009a
            r3 = r31
            boolean r17 = r9.changedInstance(r3)
            if (r17 == 0) goto L_0x0095
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r17
            goto L_0x009c
        L_0x009a:
            r3 = r31
        L_0x009c:
            r17 = r15 & 32
            r18 = 196608(0x30000, float:2.75506E-40)
            if (r17 == 0) goto L_0x00a7
            r2 = r2 | r18
            r4 = r32
            goto L_0x00ba
        L_0x00a7:
            r18 = r14 & r18
            r4 = r32
            if (r18 != 0) goto L_0x00ba
            boolean r19 = r9.changedInstance(r4)
            if (r19 == 0) goto L_0x00b6
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r2 = r2 | r19
        L_0x00ba:
            r19 = r15 & 64
            r20 = 1572864(0x180000, float:2.204052E-39)
            if (r19 == 0) goto L_0x00c5
            r2 = r2 | r20
            r6 = r33
            goto L_0x00d8
        L_0x00c5:
            r20 = r14 & r20
            r6 = r33
            if (r20 != 0) goto L_0x00d8
            boolean r21 = r9.changedInstance(r6)
            if (r21 == 0) goto L_0x00d4
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r2 = r2 | r21
        L_0x00d8:
            r7 = r15 & 128(0x80, float:1.794E-43)
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            if (r7 == 0) goto L_0x00e3
            r2 = r2 | r22
            r1 = r34
            goto L_0x00f6
        L_0x00e3:
            r22 = r14 & r22
            r1 = r34
            if (r22 != 0) goto L_0x00f6
            boolean r23 = r9.changedInstance(r1)
            if (r23 == 0) goto L_0x00f2
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r2 = r2 | r23
        L_0x00f6:
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r23 = r14 & r23
            if (r23 != 0) goto L_0x0112
            r0 = r15 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010b
            r0 = r35
            boolean r23 = r9.changedInstance(r0)
            if (r23 == 0) goto L_0x010d
            r23 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010b:
            r0 = r35
        L_0x010d:
            r23 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r2 = r2 | r23
            goto L_0x0114
        L_0x0112:
            r0 = r35
        L_0x0114:
            r23 = 805306368(0x30000000, float:4.656613E-10)
            r23 = r14 & r23
            if (r23 != 0) goto L_0x0130
            r0 = r15 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0129
            r0 = r36
            boolean r23 = r9.changedInstance(r0)
            if (r23 == 0) goto L_0x012b
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012d
        L_0x0129:
            r0 = r36
        L_0x012b:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012d:
            r2 = r2 | r23
            goto L_0x0132
        L_0x0130:
            r0 = r36
        L_0x0132:
            r0 = r15 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x013d
            r18 = r41 | 6
            r23 = r0
            r0 = r37
            goto L_0x0159
        L_0x013d:
            r23 = r41 & 6
            if (r23 != 0) goto L_0x0153
            r23 = r0
            r0 = r37
            boolean r24 = r9.changedInstance(r0)
            if (r24 == 0) goto L_0x014e
            r18 = 4
            goto L_0x0150
        L_0x014e:
            r18 = 2
        L_0x0150:
            r18 = r41 | r18
            goto L_0x0159
        L_0x0153:
            r23 = r0
            r0 = r37
            r18 = r41
        L_0x0159:
            r0 = r15 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0160
            r18 = r18 | 48
            goto L_0x0171
        L_0x0160:
            r0 = r41 & 48
            if (r0 != 0) goto L_0x0171
            boolean r0 = r9.changedInstance(r13)
            if (r0 == 0) goto L_0x016d
            r20 = 32
            goto L_0x016f
        L_0x016d:
            r20 = 16
        L_0x016f:
            r18 = r18 | r20
        L_0x0171:
            r0 = r18
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r2 & r18
            r39 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x019f
            r1 = r0 & 19
            r2 = 18
            if (r1 != r2) goto L_0x019f
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x018c
            goto L_0x019f
        L_0x018c:
            r9.skipToGroupEnd()
            r10 = r36
            r5 = r3
            r7 = r6
            r3 = r8
            r0 = r9
            r8 = r34
            r9 = r35
            r6 = r4
            r4 = r11
            r11 = r37
            goto L_0x02cb
        L_0x019f:
            r9.startDefaults()
            r1 = r14 & 1
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r18 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r1 == 0) goto L_0x01d3
            boolean r1 = r9.getDefaultsInvalid()
            if (r1 == 0) goto L_0x01b3
            goto L_0x01d3
        L_0x01b3:
            r9.skipToGroupEnd()
            r1 = r15 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01bd
            r1 = r39 & r18
            goto L_0x01bf
        L_0x01bd:
            r1 = r39
        L_0x01bf:
            r5 = r15 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x01c4
            r1 = r1 & r2
        L_0x01c4:
            r2 = r11
            r11 = r1
            r1 = r3
            r3 = r2
            r5 = r34
            r10 = r35
            r7 = r36
            r2 = r8
        L_0x01cf:
            r8 = r37
            goto L_0x022a
        L_0x01d3:
            if (r5 == 0) goto L_0x01da
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01db
        L_0x01da:
            r1 = r8
        L_0x01db:
            if (r10 == 0) goto L_0x01e4
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            goto L_0x01e5
        L_0x01e4:
            r5 = r11
        L_0x01e5:
            r8 = 0
            if (r16 == 0) goto L_0x01e9
            r3 = r8
        L_0x01e9:
            if (r17 == 0) goto L_0x01ef
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
        L_0x01ef:
            if (r19 == 0) goto L_0x01f5
            androidx.navigation.compose.NavHostKt$NavHost$15 r6 = androidx.navigation.compose.NavHostKt$NavHost$15.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
        L_0x01f5:
            if (r7 == 0) goto L_0x01fc
            androidx.navigation.compose.NavHostKt$NavHost$16 r7 = androidx.navigation.compose.NavHostKt$NavHost$16.INSTANCE
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            goto L_0x01fe
        L_0x01fc:
            r7 = r34
        L_0x01fe:
            r10 = r15 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0207
            r10 = r39 & r18
            r11 = r10
            r10 = r6
            goto L_0x020b
        L_0x0207:
            r10 = r35
            r11 = r39
        L_0x020b:
            r39 = r2
            r2 = r15 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0216
            r2 = r11 & r39
            r11 = r2
            r2 = r7
            goto L_0x0218
        L_0x0216:
            r2 = r36
        L_0x0218:
            if (r23 == 0) goto L_0x0223
            r26 = r2
            r2 = r1
            r1 = r3
            r3 = r5
            r5 = r7
            r7 = r26
            goto L_0x022a
        L_0x0223:
            r8 = r2
            r2 = r1
            r1 = r3
            r3 = r5
            r5 = r7
            r7 = r8
            goto L_0x01cf
        L_0x022a:
            r9.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r29 = r2
            if (r16 == 0) goto L_0x0240
            java.lang.String r2 = "androidx.navigation.compose.NavHost (NavHost.kt:354)"
            r30 = r3
            r3 = -1476019057(0xffffffffa805bc8f, float:-7.42387E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r11, r0, r2)
            goto L_0x0242
        L_0x0240:
            r30 = r3
        L_0x0242:
            r2 = 653109153(0x26eda7a1, float:1.6490614E-15)
            java.lang.String r3 = "CC(remember):NavHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r3)
            boolean r2 = r9.changed((java.lang.Object) r1)
            boolean r3 = r9.changed((java.lang.Object) r12)
            r2 = r2 | r3
            r3 = r0 & 112(0x70, float:1.57E-43)
            r39 = r0
            r0 = 32
            if (r3 != r0) goto L_0x025d
            r0 = 1
            goto L_0x025e
        L_0x025d:
            r0 = 0
        L_0x025e:
            r0 = r0 | r2
            java.lang.Object r2 = r9.rememberedValue()
            if (r0 != 0) goto L_0x026d
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0284
        L_0x026d:
            r0 = r27
            androidx.navigation.NavController r0 = (androidx.navigation.NavController) r0
            androidx.navigation.NavigatorProvider r0 = r0.getNavigatorProvider()
            androidx.navigation.NavGraphBuilder r2 = new androidx.navigation.NavGraphBuilder
            r2.<init>((androidx.navigation.NavigatorProvider) r0, (java.lang.Object) r12, (kotlin.reflect.KClass<?>) r1, (java.util.Map<kotlin.reflect.KType, androidx.navigation.NavType<?>>) r4)
            r13.invoke(r2)
            androidx.navigation.NavGraph r2 = r2.build()
            r9.updateRememberedValue(r2)
        L_0x0284:
            androidx.navigation.NavGraph r2 = (androidx.navigation.NavGraph) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = r11 & 8078(0x1f8e, float:1.132E-41)
            int r3 = r11 >> 6
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r11
            r0 = r0 | r3
            int r3 = r39 << 24
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r11
            r0 = r0 | r3
            r11 = 0
            r3 = r30
            r16 = r1
            r1 = r2
            r17 = r4
            r4 = r6
            r6 = r10
            r2 = r29
            r10 = r0
            r0 = r27
            NavHost(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02bf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02bf:
            r10 = r7
            r11 = r8
            r0 = r9
            r7 = r4
            r8 = r5
            r9 = r6
            r5 = r16
            r6 = r17
            r4 = r3
            r3 = r2
        L_0x02cb:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x02e7
            r1 = r0
            androidx.navigation.compose.NavHostKt$NavHost$18 r0 = new androidx.navigation.compose.NavHostKt$NavHost$18
            r25 = r1
            r2 = r12
            r12 = r13
            r13 = r14
            r1 = r27
            r14 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r25
            r1.updateScope(r0)
        L_0x02e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.Object, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.reflect.KClass, java.util.Map, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void NavHost(androidx.navigation.NavHostController r17, androidx.navigation.NavGraph r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r4 = r21
            r0 = -957014592(0xffffffffc6f51dc0, float:-31374.875)
            r1 = r20
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavHost)P(2)392@15641L39:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r22 & 1
            if (r1 == 0) goto L_0x001a
            r1 = r4 | 6
            r2 = r1
            r1 = r17
            goto L_0x002e
        L_0x001a:
            r1 = r4 & 6
            if (r1 != 0) goto L_0x002b
            r1 = r17
            boolean r2 = r14.changedInstance(r1)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r4
            goto L_0x002e
        L_0x002b:
            r1 = r17
            r2 = r4
        L_0x002e:
            r3 = r22 & 2
            if (r3 == 0) goto L_0x0037
            r2 = r2 | 48
            r6 = r18
            goto L_0x0049
        L_0x0037:
            r3 = r4 & 48
            r6 = r18
            if (r3 != 0) goto L_0x0049
            boolean r3 = r14.changedInstance(r6)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r2 = r2 | r3
        L_0x0049:
            r3 = r22 & 4
            if (r3 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r5 = r4 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0063
            r5 = r19
            boolean r7 = r14.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r5 = r19
        L_0x0065:
            r7 = r2 & 147(0x93, float:2.06E-43)
            r8 = 146(0x92, float:2.05E-43)
            if (r7 != r8) goto L_0x0077
            boolean r7 = r14.getSkipping()
            if (r7 != 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            r14.skipToGroupEnd()
            r3 = r5
            goto L_0x00a4
        L_0x0077:
            if (r3 == 0) goto L_0x007f
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r7 = r3
            goto L_0x0080
        L_0x007f:
            r7 = r5
        L_0x0080:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x008c
            r3 = -1
            java.lang.String r5 = "androidx.navigation.compose.NavHost (NavHost.kt:392)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r5)
        L_0x008c:
            r15 = r2 & 1022(0x3fe, float:1.432E-42)
            r16 = 504(0x1f8, float:7.06E-43)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r5 = r1
            NavHost(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00a3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00a3:
            r3 = r7
        L_0x00a4:
            androidx.compose.runtime.ScopeUpdateScope r6 = r14.endRestartGroup()
            if (r6 == 0) goto L_0x00ba
            androidx.navigation.compose.NavHostKt$NavHost$19 r0 = new androidx.navigation.compose.NavHostKt$NavHost$19
            r1 = r17
            r2 = r18
            r5 = r22
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r6.updateScope(r0)
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0112  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void NavHost(androidx.navigation.NavHostController r23, androidx.navigation.NavGraph r24, androidx.compose.ui.Modifier r25, androidx.compose.ui.Alignment r26, kotlin.jvm.functions.Function1 r27, kotlin.jvm.functions.Function1 r28, kotlin.jvm.functions.Function1 r29, kotlin.jvm.functions.Function1 r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r9 = r32
            r10 = r33
            r0 = -1818191915(0xffffffff93a097d5, float:-4.0539396E-27)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(NavHost)P(5,3,4)431@17424L199:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r9 | 6
            r11 = r23
            goto L_0x002d
        L_0x001b:
            r2 = r9 & 6
            r11 = r23
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changedInstance(r11)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r9
            goto L_0x002d
        L_0x002c:
            r2 = r9
        L_0x002d:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            r12 = r24
            goto L_0x0048
        L_0x0036:
            r3 = r9 & 48
            r12 = r24
            if (r3 != 0) goto L_0x0048
            boolean r3 = r1.changedInstance(r12)
            if (r3 == 0) goto L_0x0045
            r3 = 32
            goto L_0x0047
        L_0x0045:
            r3 = 16
        L_0x0047:
            r2 = r2 | r3
        L_0x0048:
            r3 = r10 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r4 = r9 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0062
            r4 = r25
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r5
            goto L_0x0064
        L_0x0062:
            r4 = r25
        L_0x0064:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x006b
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r6 = r9 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007e
            r6 = r26
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x007a
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r7
            goto L_0x0080
        L_0x007e:
            r6 = r26
        L_0x0080:
            r7 = r10 & 16
            if (r7 == 0) goto L_0x0087
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r8 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x009a
            r8 = r27
            boolean r13 = r1.changedInstance(r8)
            if (r13 == 0) goto L_0x0096
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r2 = r2 | r13
            goto L_0x009c
        L_0x009a:
            r8 = r27
        L_0x009c:
            r13 = r10 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a4
            r2 = r2 | r14
            goto L_0x00b6
        L_0x00a4:
            r14 = r14 & r9
            if (r14 != 0) goto L_0x00b6
            r14 = r28
            boolean r15 = r1.changedInstance(r14)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00b6:
            r14 = r28
        L_0x00b8:
            r15 = 1572864(0x180000, float:2.204052E-39)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00d3
            r15 = r10 & 64
            if (r15 != 0) goto L_0x00cc
            r15 = r29
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r15 = r29
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r2 = r2 | r16
            goto L_0x00d5
        L_0x00d3:
            r15 = r29
        L_0x00d5:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x00f1
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ea
            r0 = r30
            boolean r17 = r1.changedInstance(r0)
            if (r17 == 0) goto L_0x00ec
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ea:
            r0 = r30
        L_0x00ec:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r2 = r2 | r17
            goto L_0x00f3
        L_0x00f1:
            r0 = r30
        L_0x00f3:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r2 & r17
            r20 = r1
            r1 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r1) goto L_0x0112
            boolean r0 = r20.getSkipping()
            if (r0 != 0) goto L_0x0106
            goto L_0x0112
        L_0x0106:
            r20.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r8
            r6 = r14
            r7 = r15
            r8 = r30
            goto L_0x01a3
        L_0x0112:
            r20.startDefaults()
            r0 = r9 & 1
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x0141
            boolean r0 = r20.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0126
            goto L_0x0141
        L_0x0126:
            r20.skipToGroupEnd()
            r0 = r10 & 64
            if (r0 == 0) goto L_0x012f
            r2 = r2 & r17
        L_0x012f:
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0134
            r2 = r2 & r1
        L_0x0134:
            r18 = r30
            r13 = r4
        L_0x0137:
            r16 = r14
        L_0x0139:
            r17 = r15
            r0 = -1818191915(0xffffffff93a097d5, float:-4.0539396E-27)
            r14 = r6
            r15 = r8
            goto L_0x0176
        L_0x0141:
            if (r3 == 0) goto L_0x0148
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0149
        L_0x0148:
            r0 = r4
        L_0x0149:
            if (r5 == 0) goto L_0x0152
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r6 = r3
        L_0x0152:
            if (r7 == 0) goto L_0x0159
            androidx.navigation.compose.NavHostKt$NavHost$20 r3 = androidx.navigation.compose.NavHostKt$NavHost$20.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8 = r3
        L_0x0159:
            if (r13 == 0) goto L_0x0160
            androidx.navigation.compose.NavHostKt$NavHost$21 r3 = androidx.navigation.compose.NavHostKt$NavHost$21.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r14 = r3
        L_0x0160:
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0167
            r2 = r2 & r17
            r15 = r8
        L_0x0167:
            r3 = r10 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0172
            r2 = r2 & r1
            r13 = r0
            r16 = r14
            r18 = r16
            goto L_0x0139
        L_0x0172:
            r18 = r30
            r13 = r0
            goto L_0x0137
        L_0x0176:
            r20.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0185
            r1 = -1
            java.lang.String r3 = "androidx.navigation.compose.NavHost (NavHost.kt:430)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r1, r3)
        L_0x0185:
            r0 = 33554430(0x1fffffe, float:9.4039537E-38)
            r21 = r2 & r0
            r22 = 256(0x100, float:3.59E-43)
            r19 = 0
            NavHost(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x019a:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
        L_0x01a3:
            androidx.compose.runtime.ScopeUpdateScope r11 = r20.endRestartGroup()
            if (r11 == 0) goto L_0x01b7
            androidx.navigation.compose.NavHostKt$NavHost$22 r0 = new androidx.navigation.compose.NavHostKt$NavHost$22
            r1 = r23
            r2 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x046e, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0473;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x069f  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x06b2  */
    /* JADX WARNING: Removed duplicated region for block: B:284:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavHost(androidx.navigation.NavHostController r32, androidx.navigation.NavGraph r33, androidx.compose.ui.Modifier r34, androidx.compose.ui.Alignment r35, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r36, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r37, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r38, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r39, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r1 = r32
            r10 = r42
            r11 = r43
            r0 = -1964664536(0xffffffff8ae59928, float:-2.2109509E-32)
            r2 = r41
            androidx.compose.runtime.Composer r7 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(NavHost)P(5,3,4)492@19706L7,*494@19790L7,509@20395L16,511@20433L36,512@20498L34,513@20586L987,513@20537L1036,540@21612L138,540@21579L171,546@21782L29,548@21871L16,551@21976L186,561@22257L42,732@30615L27:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r7.changedInstance(r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r10
            goto L_0x002b
        L_0x002a:
            r2 = r10
        L_0x002b:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r10 & 48
            if (r4 != 0) goto L_0x0045
            r4 = r33
            boolean r5 = r7.changedInstance(r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r33
        L_0x0047:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0061
            r6 = r34
            boolean r8 = r7.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r8
            goto L_0x0063
        L_0x0061:
            r6 = r34
        L_0x0063:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r9 = r10 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007d
            r9 = r35
            boolean r12 = r7.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0079
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r12
            goto L_0x007f
        L_0x007d:
            r9 = r35
        L_0x007f:
            r12 = r11 & 16
            if (r12 == 0) goto L_0x0086
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            r13 = r36
            boolean r14 = r7.changedInstance(r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r36
        L_0x009b:
            r14 = r11 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a3
            r2 = r2 | r15
            goto L_0x00b6
        L_0x00a3:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b6
            r15 = r37
            boolean r16 = r7.changedInstance(r15)
            if (r16 == 0) goto L_0x00b1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r2 = r2 | r16
            goto L_0x00b8
        L_0x00b6:
            r15 = r37
        L_0x00b8:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r17 = r10 & r16
            if (r17 != 0) goto L_0x00d2
            r17 = r11 & 64
            r3 = r38
            if (r17 != 0) goto L_0x00cd
            boolean r18 = r7.changedInstance(r3)
            if (r18 == 0) goto L_0x00cd
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cd:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r2 = r2 | r18
            goto L_0x00d4
        L_0x00d2:
            r3 = r38
        L_0x00d4:
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r19 = r10 & r18
            if (r19 != 0) goto L_0x00f0
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00e9
            r0 = r39
            boolean r21 = r7.changedInstance(r0)
            if (r21 == 0) goto L_0x00eb
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r0 = r39
        L_0x00eb:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r2 = r2 | r21
            goto L_0x00f2
        L_0x00f0:
            r0 = r39
        L_0x00f2:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fb
            r2 = r2 | r21
            goto L_0x0111
        L_0x00fb:
            r21 = r10 & r21
            if (r21 != 0) goto L_0x0111
            r21 = r0
            r0 = r40
            boolean r22 = r7.changedInstance(r0)
            if (r22 == 0) goto L_0x010c
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010c:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r2 = r2 | r22
            goto L_0x0115
        L_0x0111:
            r21 = r0
            r0 = r40
        L_0x0115:
            r22 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r22
            r22 = r2
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x0137
            boolean r0 = r7.getSkipping()
            if (r0 != 0) goto L_0x0128
            goto L_0x0137
        L_0x0128:
            r7.skipToGroupEnd()
            r8 = r39
            r0 = r7
            r4 = r9
            r5 = r13
            r9 = r40
            r7 = r3
            r3 = r6
            r6 = r15
            goto L_0x0699
        L_0x0137:
            r7.startDefaults()
            r0 = r10 & 1
            r2 = 0
            if (r0 == 0) goto L_0x0169
            boolean r0 = r7.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0146
            goto L_0x0169
        L_0x0146:
            r7.skipToGroupEnd()
            r0 = r11 & 64
            if (r0 == 0) goto L_0x0154
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r22 & r0
            r22 = r0
        L_0x0154:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x015d
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r22 = r22 & r0
        L_0x015d:
            r8 = r39
            r0 = r3
            r3 = r6
            r4 = r9
            r5 = r13
            r6 = r15
            r12 = r22
        L_0x0166:
            r9 = r40
            goto L_0x01ad
        L_0x0169:
            if (r5 == 0) goto L_0x0170
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0170:
            if (r8 == 0) goto L_0x0179
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r9 = r0
        L_0x0179:
            if (r12 == 0) goto L_0x0180
            androidx.navigation.compose.NavHostKt$NavHost$23 r0 = androidx.navigation.compose.NavHostKt$NavHost$23.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r13 = r0
        L_0x0180:
            if (r14 == 0) goto L_0x0187
            androidx.navigation.compose.NavHostKt$NavHost$24 r0 = androidx.navigation.compose.NavHostKt$NavHost$24.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r15 = r0
        L_0x0187:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x0193
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r22 & r0
            r22 = r0
            r3 = r13
        L_0x0193:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01a0
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r22 & r0
            r22 = r0
            r0 = r15
            goto L_0x01a2
        L_0x01a0:
            r0 = r39
        L_0x01a2:
            r8 = r0
            r0 = r3
            r3 = r6
            r4 = r9
            r5 = r13
            r6 = r15
            r12 = r22
            if (r21 == 0) goto L_0x0166
            r9 = r2
        L_0x01ad:
            r7.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01bf
            r13 = -1
            java.lang.String r14 = "androidx.navigation.compose.NavHost (NavHost.kt:490)"
            r15 = -1964664536(0xffffffff8ae59928, float:-2.2109509E-32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r12, r13, r14)
        L_0x01bf:
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r14, r15)
            java.lang.Object r13 = r7.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.lifecycle.LifecycleOwner r13 = (androidx.lifecycle.LifecycleOwner) r13
            androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner r14 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.INSTANCE
            int r15 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.$stable
            androidx.lifecycle.ViewModelStoreOwner r14 = r14.getCurrent(r7, r15)
            if (r14 == 0) goto L_0x06b2
            androidx.lifecycle.ViewModelStore r14 = r14.getViewModelStore()
            r1.setViewModelStore(r14)
            r32.setGraph((androidx.navigation.NavGraph) r33)
            androidx.navigation.NavigatorProvider r14 = r1.getNavigatorProvider()
            java.lang.String r15 = "composable"
            androidx.navigation.Navigator r14 = r14.getNavigator((java.lang.String) r15)
            boolean r15 = r14 instanceof androidx.navigation.compose.ComposeNavigator
            if (r15 == 0) goto L_0x01fb
            androidx.navigation.compose.ComposeNavigator r14 = (androidx.navigation.compose.ComposeNavigator) r14
            goto L_0x01fc
        L_0x01fb:
            r14 = r2
        L_0x01fc:
            if (r14 != 0) goto L_0x021b
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0207
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0207:
            androidx.compose.runtime.ScopeUpdateScope r12 = r7.endRestartGroup()
            if (r12 == 0) goto L_0x06b1
            r7 = r0
            androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1 r0 = new androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1
            r2 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
            return
        L_0x021b:
            r11 = r0
            r0 = r1
            r10 = r5
            r15 = r6
            r1 = r8
            r5 = r9
            kotlinx.coroutines.flow.StateFlow r6 = r14.getBackStack()
            r8 = 0
            r9 = 1
            androidx.compose.runtime.State r6 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r2, r7, r8, r9)
            r40 = r8
            r8 = 653297150(0x26f085fe, float:1.6689664E-15)
            java.lang.String r9 = "CC(remember):NavHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r8, r9)
            java.lang.Object r8 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r20.getEmpty()
            if (r8 != r2) goto L_0x0249
            r2 = 0
            androidx.compose.runtime.MutableFloatState r8 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r2)
            r7.updateRememberedValue(r8)
        L_0x0249:
            androidx.compose.runtime.MutableFloatState r8 = (androidx.compose.runtime.MutableFloatState) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r2 = 653299228(0x26f08e1c, float:1.6691864E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r2, r9)
            java.lang.Object r2 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r30 = r3
            java.lang.Object r3 = r20.getEmpty()
            if (r2 != r3) goto L_0x0272
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r40)
            r41 = r4
            r3 = 2
            r4 = 0
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r4, r3, r4)
            r7.updateRememberedValue(r2)
            goto L_0x0274
        L_0x0272:
            r41 = r4
        L_0x0274:
            r27 = r2
            androidx.compose.runtime.MutableState r27 = (androidx.compose.runtime.MutableState) r27
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            java.util.List r2 = NavHost$lambda$6(r6)
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L_0x0288
            r2 = 1
            goto L_0x028a
        L_0x0288:
            r2 = r40
        L_0x028a:
            r3 = 653302997(0x26f09cd5, float:1.6695855E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r9)
            boolean r3 = r7.changed((java.lang.Object) r6)
            boolean r4 = r7.changed((java.lang.Object) r14)
            r3 = r3 | r4
            java.lang.Object r4 = r7.rememberedValue()
            if (r3 != 0) goto L_0x02ad
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02a8
            goto L_0x02ad
        L_0x02a8:
            r3 = r6
            r6 = r4
            r4 = r27
            goto L_0x02ca
        L_0x02ad:
            androidx.navigation.compose.NavHostKt$NavHost$25$1 r3 = new androidx.navigation.compose.NavHostKt$NavHost$25$1
            r4 = 0
            r34 = r3
            r39 = r4
            r36 = r6
            r37 = r8
            r35 = r14
            r38 = r27
            r34.<init>(r35, r36, r37, r38, r39)
            r6 = r34
            r3 = r36
            r4 = r38
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7.updateRememberedValue(r6)
        L_0x02ca:
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r31 = r12
            r12 = r40
            androidx.activity.compose.PredictiveBackHandlerKt.PredictiveBackHandler(r2, r6, r7, r12, r12)
            r2 = 653334980(0x26f119c4, float:1.6729718E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r2, r9)
            boolean r2 = r7.changedInstance(r0)
            boolean r6 = r7.changedInstance(r13)
            r2 = r2 | r6
            java.lang.Object r6 = r7.rememberedValue()
            if (r2 != 0) goto L_0x02f3
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r6 != r2) goto L_0x02fe
        L_0x02f3:
            androidx.navigation.compose.NavHostKt$NavHost$26$1 r2 = new androidx.navigation.compose.NavHostKt$NavHost$26$1
            r2.<init>(r0, r13)
            r6 = r2
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7.updateRememberedValue(r6)
        L_0x02fe:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r12 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r13, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r6, (androidx.compose.runtime.Composer) r7, (int) r12)
            androidx.compose.runtime.saveable.SaveableStateHolder r2 = androidx.compose.runtime.saveable.SaveableStateHolderKt.rememberSaveableStateHolder(r7, r12)
            kotlinx.coroutines.flow.StateFlow r6 = r0.getVisibleEntries()
            r37 = r2
            r2 = 1
            r13 = 0
            androidx.compose.runtime.State r6 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r13, r7, r12, r2)
            r2 = 653346676(0x26f14774, float:1.6742102E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r2, r9)
            java.lang.Object r2 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r2 != r12) goto L_0x0337
            androidx.navigation.compose.NavHostKt$NavHost$visibleEntries$2$1 r2 = new androidx.navigation.compose.NavHostKt$NavHost$visibleEntries$2$1
            r2.<init>(r6)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            androidx.compose.runtime.State r2 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r2)
            r7.updateRememberedValue(r2)
        L_0x0337:
            androidx.compose.runtime.State r2 = (androidx.compose.runtime.State) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            java.util.List r6 = NavHost$lambda$17(r2)
            java.lang.Object r6 = kotlin.collections.CollectionsKt.lastOrNull(r6)
            androidx.navigation.NavBackStackEntry r6 = (androidx.navigation.NavBackStackEntry) r6
            r12 = 653355524(0x26f16a04, float:1.675147E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r12, r9)
            java.lang.Object r12 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r12 != r13) goto L_0x0362
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
            java.util.Map r12 = (java.util.Map) r12
            r7.updateRememberedValue(r12)
        L_0x0362:
            java.util.Map r12 = (java.util.Map) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r13 = 653365120(0x26f18f80, float:1.676163E-15)
            r7.startReplaceGroup(r13)
            java.lang.String r13 = "564@22433L597,578@23128L597,594@23856L301,602@24190L146,602@24167L169,608@24368L348,615@24743L52,656@26717L1208,682@28002L1465,654@26649L2818,709@29540L861,709@29476L925"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r13)
            if (r6 == 0) goto L_0x0630
            r13 = 653361711(0x26f1822f, float:1.6758021E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r13, r9)
            boolean r13 = r7.changed((java.lang.Object) r14)
            r20 = 3670016(0x380000, float:5.142788E-39)
            r20 = r31 & r20
            r34 = r13
            r13 = r20 ^ r16
            r0 = 1048576(0x100000, float:1.469368E-39)
            if (r13 <= r0) goto L_0x0390
            boolean r13 = r7.changed((java.lang.Object) r11)
            if (r13 != 0) goto L_0x0394
        L_0x0390:
            r13 = r31 & r16
            if (r13 != r0) goto L_0x0396
        L_0x0394:
            r0 = 1
            goto L_0x0397
        L_0x0396:
            r0 = 0
        L_0x0397:
            r0 = r34 | r0
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r31 & r13
            r34 = r0
            r0 = 16384(0x4000, float:2.2959E-41)
            if (r13 != r0) goto L_0x03a6
            r0 = 1
            goto L_0x03a7
        L_0x03a6:
            r0 = 0
        L_0x03a7:
            r0 = r34 | r0
            java.lang.Object r13 = r7.rememberedValue()
            if (r0 != 0) goto L_0x03b7
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r13 != r0) goto L_0x03c2
        L_0x03b7:
            androidx.navigation.compose.NavHostKt$NavHost$finalEnter$1$1 r0 = new androidx.navigation.compose.NavHostKt$NavHost$finalEnter$1$1
            r0.<init>(r14, r11, r10, r4)
            r13 = r0
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r7.updateRememberedValue(r13)
        L_0x03c2:
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r0 = 653383951(0x26f1d90f, float:1.6781568E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r9)
            boolean r0 = r7.changed((java.lang.Object) r14)
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r31 & r16
            r34 = r0
            r0 = r16 ^ r18
            r16 = r10
            r10 = 8388608(0x800000, float:1.17549435E-38)
            if (r0 <= r10) goto L_0x03e5
            boolean r0 = r7.changed((java.lang.Object) r1)
            if (r0 != 0) goto L_0x03e9
        L_0x03e5:
            r0 = r31 & r18
            if (r0 != r10) goto L_0x03eb
        L_0x03e9:
            r0 = 1
            goto L_0x03ec
        L_0x03eb:
            r0 = 0
        L_0x03ec:
            r0 = r34 | r0
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r31 & r10
            r34 = r0
            r0 = 131072(0x20000, float:1.83671E-40)
            if (r10 != r0) goto L_0x03fa
            r0 = 1
            goto L_0x03fb
        L_0x03fa:
            r0 = 0
        L_0x03fb:
            r0 = r34 | r0
            java.lang.Object r10 = r7.rememberedValue()
            if (r0 != 0) goto L_0x040b
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r10 != r0) goto L_0x0416
        L_0x040b:
            androidx.navigation.compose.NavHostKt$NavHost$finalExit$1$1 r0 = new androidx.navigation.compose.NavHostKt$NavHost$finalExit$1$1
            r0.<init>(r14, r1, r15, r4)
            r10 = r0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r7.updateRememberedValue(r10)
        L_0x0416:
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r0 = 653406951(0x26f232e7, float:1.680592E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r9)
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r31 & r0
            r17 = r1
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            if (r0 != r1) goto L_0x042d
            r0 = 1
            goto L_0x042e
        L_0x042d:
            r0 = 0
        L_0x042e:
            java.lang.Object r1 = r7.rememberedValue()
            if (r0 != 0) goto L_0x043c
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0447
        L_0x043c:
            androidx.navigation.compose.NavHostKt$NavHost$finalSizeTransform$1$1 r0 = new androidx.navigation.compose.NavHostKt$NavHost$finalSizeTransform$1$1
            r0.<init>(r5)
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r7.updateRememberedValue(r1)
        L_0x0447:
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r28 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r28)
            r38 = r4
            r4 = 653417484(0x26f25c0c, float:1.6817073E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r4, r9)
            boolean r4 = r7.changed((java.lang.Object) r14)
            r34 = r4
            java.lang.Object r4 = r7.rememberedValue()
            if (r34 != 0) goto L_0x0471
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r5
            java.lang.Object r5 = r18.getEmpty()
            if (r4 != r5) goto L_0x047d
            goto L_0x0473
        L_0x0471:
            r19 = r5
        L_0x0473:
            androidx.navigation.compose.NavHostKt$NavHost$27$1 r4 = new androidx.navigation.compose.NavHostKt$NavHost$27$1
            r4.<init>(r2, r14)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r7.updateRememberedValue(r4)
        L_0x047d:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r5 = 6
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r4, (androidx.compose.runtime.Composer) r7, (int) r5)
            r0 = 653423382(0x26f27316, float:1.6823317E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r9)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r0 != r4) goto L_0x04a0
            androidx.compose.animation.core.SeekableTransitionState r0 = new androidx.compose.animation.core.SeekableTransitionState
            r0.<init>(r6)
            r7.updateRememberedValue(r0)
        L_0x04a0:
            androidx.compose.animation.core.SeekableTransitionState r0 = (androidx.compose.animation.core.SeekableTransitionState) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r4 = r0
            androidx.compose.animation.core.TransitionState r4 = (androidx.compose.animation.core.TransitionState) r4
            int r5 = androidx.compose.animation.core.SeekableTransitionState.$stable
            r5 = r5 | 48
            r26 = r2
            java.lang.String r2 = "entry"
            r18 = r11
            r11 = 0
            androidx.compose.animation.core.Transition r2 = androidx.compose.animation.core.TransitionKt.rememberTransition(r4, r2, r7, r5, r11)
            boolean r4 = NavHost$lambda$11(r38)
            if (r4 == 0) goto L_0x0508
            r4 = -1218260648(0xffffffffb762d158, float:-1.3519391E-5)
            r7.startReplaceGroup(r4)
            java.lang.String r4 = "618@24866L159,618@24841L184"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r4)
            float r4 = NavHost$lambda$8(r8)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r5 = 653439129(0x26f2b099, float:1.683999E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r5, r9)
            boolean r5 = r7.changed((java.lang.Object) r3)
            boolean r11 = r7.changedInstance(r0)
            r5 = r5 | r11
            java.lang.Object r11 = r7.rememberedValue()
            if (r5 != 0) goto L_0x04ed
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r11 != r5) goto L_0x04f9
        L_0x04ed:
            androidx.navigation.compose.NavHostKt$NavHost$28$1 r5 = new androidx.navigation.compose.NavHostKt$NavHost$28$1
            r11 = 0
            r5.<init>(r0, r3, r8, r11)
            r11 = r5
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r7.updateRememberedValue(r11)
        L_0x04f9:
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r3 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r4, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r11, (androidx.compose.runtime.Composer) r7, (int) r3)
            r7.endReplaceGroup()
            r4 = 0
            r11 = 0
            goto L_0x0550
        L_0x0508:
            r3 = -1218005611(0xffffffffb766b595, float:-1.3751346E-5)
            r7.startReplaceGroup(r3)
            java.lang.String r3 = "623@25086L1532,623@25055L1563"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            r3 = 653447542(0x26f2d176, float:1.6848898E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r9)
            boolean r3 = r7.changedInstance(r0)
            boolean r4 = r7.changedInstance(r6)
            r3 = r3 | r4
            boolean r4 = r7.changed((java.lang.Object) r2)
            r3 = r3 | r4
            java.lang.Object r4 = r7.rememberedValue()
            if (r3 != 0) goto L_0x0539
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0536
            goto L_0x0539
        L_0x0536:
            r3 = r4
            r4 = 0
            goto L_0x0544
        L_0x0539:
            androidx.navigation.compose.NavHostKt$NavHost$29$1 r3 = new androidx.navigation.compose.NavHostKt$NavHost$29$1
            r4 = 0
            r3.<init>(r0, r6, r2, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r7.updateRememberedValue(r3)
        L_0x0544:
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r11 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r6, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r3, (androidx.compose.runtime.Composer) r7, (int) r11)
            r7.endReplaceGroup()
        L_0x0550:
            r3 = 653499410(0x26f39c12, float:1.6903815E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r9)
            boolean r3 = r7.changedInstance(r12)
            boolean r5 = r7.changed((java.lang.Object) r14)
            r3 = r3 | r5
            boolean r5 = r7.changed((java.lang.Object) r13)
            r3 = r3 | r5
            boolean r5 = r7.changed((java.lang.Object) r10)
            r3 = r3 | r5
            boolean r5 = r7.changed((java.lang.Object) r1)
            r3 = r3 | r5
            java.lang.Object r5 = r7.rememberedValue()
            if (r3 != 0) goto L_0x0580
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x057d
            goto L_0x0580
        L_0x057d:
            r27 = r38
            goto L_0x0598
        L_0x0580:
            androidx.navigation.compose.NavHostKt$NavHost$30$1 r20 = new androidx.navigation.compose.NavHostKt$NavHost$30$1
            r27 = r38
            r25 = r1
            r24 = r10
            r21 = r12
            r23 = r13
            r22 = r14
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            r5 = r20
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r7.updateRememberedValue(r5)
        L_0x0598:
            r3 = r5
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.navigation.compose.NavHostKt$NavHost$31 r1 = androidx.navigation.compose.NavHostKt$NavHost$31.INSTANCE
            r5 = r1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.navigation.compose.NavHostKt$NavHost$32 r1 = new androidx.navigation.compose.NavHostKt$NavHost$32
            r35 = r0
            r34 = r1
            r36 = r6
            r39 = r26
            r38 = r27
            r34.<init>(r35, r36, r37, r38, r39)
            r0 = r34
            r1 = 54
            r6 = 820763100(0x30ebd9dc, float:1.716042E-9)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r8, r0, r7, r1)
            r6 = r0
            kotlin.jvm.functions.Function4 r6 = (kotlin.jvm.functions.Function4) r6
            int r0 = r31 >> 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r1 = 221184(0x36000, float:3.09945E-40)
            r0 = r0 | r1
            r1 = r31
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r8 = r0 | r1
            r0 = r9
            r9 = 0
            r1 = r2
            r29 = r4
            r2 = r30
            r4 = r41
            androidx.compose.animation.AnimatedContentKt.AnimatedContent(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r2
            java.lang.Object r2 = r1.getCurrentState()
            java.lang.Object r5 = r1.getTargetState()
            r6 = 653589399(0x26f4fb97, float:1.6999095E-15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r6, r0)
            boolean r0 = r7.changed((java.lang.Object) r1)
            r6 = r32
            boolean r8 = r7.changedInstance(r6)
            r0 = r0 | r8
            boolean r8 = r7.changed((java.lang.Object) r14)
            r0 = r0 | r8
            boolean r8 = r7.changedInstance(r12)
            r0 = r0 | r8
            java.lang.Object r8 = r7.rememberedValue()
            if (r0 != 0) goto L_0x060d
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r8 != r0) goto L_0x0627
        L_0x060d:
            androidx.navigation.compose.NavHostKt$NavHost$33$1 r0 = new androidx.navigation.compose.NavHostKt$NavHost$33$1
            r8 = 0
            r34 = r0
            r35 = r1
            r36 = r6
            r40 = r8
            r37 = r12
            r39 = r14
            r38 = r26
            r34.<init>(r35, r36, r37, r38, r39, r40)
            r8 = r0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateRememberedValue(r8)
        L_0x0627:
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r2, r5, r8, r7, r11)
            goto L_0x063f
        L_0x0630:
            r4 = r41
            r17 = r1
            r19 = r5
            r16 = r10
            r18 = r11
            r3 = r30
            r11 = 0
            r29 = 0
        L_0x063f:
            r7.endReplaceGroup()
            androidx.navigation.NavigatorProvider r0 = r32.getNavigatorProvider()
            java.lang.String r1 = "dialog"
            androidx.navigation.Navigator r0 = r0.getNavigator((java.lang.String) r1)
            boolean r1 = r0 instanceof androidx.navigation.compose.DialogNavigator
            if (r1 == 0) goto L_0x0654
            r2 = r0
            androidx.navigation.compose.DialogNavigator r2 = (androidx.navigation.compose.DialogNavigator) r2
            goto L_0x0656
        L_0x0654:
            r2 = r29
        L_0x0656:
            if (r2 != 0) goto L_0x0683
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0661
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0661:
            androidx.compose.runtime.ScopeUpdateScope r12 = r7.endRestartGroup()
            if (r12 == 0) goto L_0x06b1
            androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1 r0 = new androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1
            r1 = r32
            r2 = r33
            r10 = r42
            r11 = r43
            r6 = r15
            r5 = r16
            r8 = r17
            r7 = r18
            r9 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
            return
        L_0x0683:
            r6 = r15
            r5 = r16
            r8 = r17
            r9 = r19
            androidx.navigation.compose.DialogHostKt.DialogHost(r2, r7, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0696
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0696:
            r0 = r7
            r7 = r18
        L_0x0699:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 == 0) goto L_0x06b1
            androidx.navigation.compose.NavHostKt$NavHost$34 r0 = new androidx.navigation.compose.NavHostKt$NavHost$34
            r1 = r32
            r2 = r33
            r10 = r42
            r11 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x06b1:
            return
        L_0x06b2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final float NavHost$lambda$8(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* access modifiers changed from: private */
    public static final boolean NavHost$lambda$11(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void NavHost$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static final EnterTransition createEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getEnterTransition$navigation_compose_release();
            if (enterTransition$navigation_compose_release2 != null) {
                return enterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (enterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getEnterTransition$navigation_compose_release()) == null) {
            return null;
        } else {
            return enterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    /* access modifiers changed from: private */
    public static final ExitTransition createExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getExitTransition$navigation_compose_release();
            if (exitTransition$navigation_compose_release2 != null) {
                return exitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (exitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getExitTransition$navigation_compose_release()) == null) {
            return null;
        } else {
            return exitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    /* access modifiers changed from: private */
    public static final EnterTransition createPopEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopEnterTransition$navigation_compose_release();
            if (popEnterTransition$navigation_compose_release2 != null) {
                return popEnterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popEnterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopEnterTransition$navigation_compose_release()) == null) {
            return null;
        } else {
            return popEnterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    /* access modifiers changed from: private */
    public static final ExitTransition createPopExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopExitTransition$navigation_compose_release();
            if (popExitTransition$navigation_compose_release2 != null) {
                return popExitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popExitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopExitTransition$navigation_compose_release()) == null) {
            return null;
        } else {
            return popExitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    /* access modifiers changed from: private */
    public static final SizeTransform createSizeTransform(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getSizeTransform$navigation_compose_release();
            if (sizeTransform$navigation_compose_release2 != null) {
                return sizeTransform$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        } else if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (sizeTransform$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getSizeTransform$navigation_compose_release()) == null) {
            return null;
        } else {
            return sizeTransform$navigation_compose_release.invoke(animatedContentTransitionScope);
        }
    }

    /* access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$6(State<? extends List<NavBackStackEntry>> state) {
        return (List) state.getValue();
    }

    /* access modifiers changed from: private */
    public static final void NavHost$lambda$9(MutableFloatState mutableFloatState, float f) {
        mutableFloatState.setFloatValue(f);
    }

    /* access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$15(State<? extends List<NavBackStackEntry>> state) {
        return (List) state.getValue();
    }

    /* access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$17(State<? extends List<NavBackStackEntry>> state) {
        return (List) state.getValue();
    }
}
