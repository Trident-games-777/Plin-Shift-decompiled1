package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/AnimatedContentScope;", "it", "Landroidx/navigation/NavBackStackEntry;", "invoke", "(Landroidx/compose/animation/AnimatedContentScope;Landroidx/navigation/NavBackStackEntry;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavHost.kt */
final class NavHostKt$NavHost$32 extends Lambda implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavBackStackEntry $backStackEntry;
    final /* synthetic */ MutableState<Boolean> $inPredictiveBack$delegate;
    final /* synthetic */ SaveableStateHolder $saveableStateHolder;
    final /* synthetic */ SeekableTransitionState<NavBackStackEntry> $transitionState;
    final /* synthetic */ State<List<NavBackStackEntry>> $visibleEntries$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$32(SeekableTransitionState<NavBackStackEntry> seekableTransitionState, NavBackStackEntry navBackStackEntry, SaveableStateHolder saveableStateHolder, MutableState<Boolean> mutableState, State<? extends List<NavBackStackEntry>> state) {
        super(4);
        this.$transitionState = seekableTransitionState;
        this.$backStackEntry = navBackStackEntry;
        this.$saveableStateHolder = saveableStateHolder;
        this.$inPredictiveBack$delegate = mutableState;
        this.$visibleEntries$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(final androidx.compose.animation.AnimatedContentScope r4, final androidx.navigation.NavBackStackEntry r5, androidx.compose.runtime.Composer r6, int r7) {
        /*
            r3 = this;
            java.lang.String r0 = "C702@29281L176,702@29240L217:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0014
            r0 = -1
            java.lang.String r1 = "androidx.navigation.compose.NavHost.<anonymous> (NavHost.kt:689)"
            r2 = 820763100(0x30ebd9dc, float:1.716042E-9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r7, r0, r1)
        L_0x0014:
            androidx.compose.animation.core.SeekableTransitionState<androidx.navigation.NavBackStackEntry> r7 = r3.$transitionState
            java.lang.Object r7 = r7.getCurrentState()
            androidx.navigation.NavBackStackEntry r0 = r3.$backStackEntry
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r0 = r3.$inPredictiveBack$delegate
            boolean r0 = androidx.navigation.compose.NavHostKt.NavHost$lambda$11(r0)
            if (r0 != 0) goto L_0x0051
            if (r7 == 0) goto L_0x002b
            goto L_0x0051
        L_0x002b:
            androidx.compose.runtime.State<java.util.List<androidx.navigation.NavBackStackEntry>> r7 = r3.$visibleEntries$delegate
            java.util.List r7 = androidx.navigation.compose.NavHostKt.NavHost$lambda$17(r7)
            int r0 = r7.size()
            java.util.ListIterator r7 = r7.listIterator(r0)
        L_0x0039:
            boolean r0 = r7.hasPrevious()
            if (r0 == 0) goto L_0x004d
            java.lang.Object r0 = r7.previous()
            r1 = r0
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0039
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            r5 = r0
            androidx.navigation.NavBackStackEntry r5 = (androidx.navigation.NavBackStackEntry) r5
        L_0x0051:
            if (r5 != 0) goto L_0x0054
            goto L_0x006c
        L_0x0054:
            androidx.compose.runtime.saveable.SaveableStateHolder r7 = r3.$saveableStateHolder
            androidx.navigation.compose.NavHostKt$NavHost$32$1 r0 = new androidx.navigation.compose.NavHostKt$NavHost$32$1
            r0.<init>(r5, r4)
            r4 = 54
            r1 = -1263531443(0xffffffffb4b00a4d, float:-3.279005E-7)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r1, r2, r0, r6, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0 = 384(0x180, float:5.38E-43)
            androidx.navigation.compose.NavBackStackEntryProviderKt.LocalOwnersProvider(r5, r7, r4, r6, r0)
        L_0x006c:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0075
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$32.invoke(androidx.compose.animation.AnimatedContentScope, androidx.navigation.NavBackStackEntry, androidx.compose.runtime.Composer, int):void");
    }
}
