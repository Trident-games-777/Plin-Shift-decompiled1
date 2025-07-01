package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.DialogNavigator;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\n\u001a%\u0010\u000b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0002²\u0006\u0010\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0002"}, d2 = {"DialogHost", "", "dialogNavigator", "Landroidx/navigation/compose/DialogNavigator;", "(Landroidx/navigation/compose/DialogNavigator;Landroidx/compose/runtime/Composer;I)V", "rememberVisibleList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/navigation/NavBackStackEntry;", "backStack", "", "(Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "PopulateVisibleList", "", "(Ljava/util/List;Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)V", "navigation-compose_release", "dialogBackStack", "", "transitionInProgress", ""}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DialogHost.kt */
public final class DialogHostKt {
    public static final void DialogHost(DialogNavigator dialogNavigator, Composer composer, int i) {
        int i2;
        DialogNavigator dialogNavigator2 = dialogNavigator;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(294589392);
        ComposerKt.sourceInformation(startRestartGroup, "C(DialogHost)41@1668L29,42@1751L16,43@1795L36,44@1853L36,46@1960L16,47@2004L52,73@3243L294,73@3188L349:DialogHost.kt#opm8kd");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) dialogNavigator2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(294589392, i2, -1, "androidx.navigation.compose.DialogHost (DialogHost.kt:40)");
            }
            boolean z = false;
            SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(startRestartGroup, 0);
            Continuation continuation = null;
            boolean z2 = true;
            State<List<NavBackStackEntry>> collectAsState = SnapshotStateKt.collectAsState(dialogNavigator2.getBackStack$navigation_compose_release(), (CoroutineContext) null, startRestartGroup, 0, 1);
            SnapshotStateList<NavBackStackEntry> rememberVisibleList = rememberVisibleList(DialogHost$lambda$0(collectAsState), startRestartGroup, 0);
            PopulateVisibleList(rememberVisibleList, DialogHost$lambda$0(collectAsState), startRestartGroup, 0);
            State<Set<NavBackStackEntry>> collectAsState2 = SnapshotStateKt.collectAsState(dialogNavigator2.getTransitionInProgress$navigation_compose_release(), (CoroutineContext) null, startRestartGroup, 0, 1);
            String str = "CC(remember):DialogHost.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1361033813, str);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(1361037007);
            ComposerKt.sourceInformation(startRestartGroup, "*52@2222L43,54@2331L588,51@2183L736");
            for (NavBackStackEntry navBackStackEntry : rememberVisibleList) {
                NavDestination destination = navBackStackEntry.getDestination();
                Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.DialogNavigator.Destination");
                DialogNavigator.Destination destination2 = (DialogNavigator.Destination) destination;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1136022005, str);
                boolean changedInstance = ((i2 & 14) == 4 ? z2 : false) | startRestartGroup.changedInstance(navBackStackEntry);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new DialogHostKt$DialogHost$1$1$1(dialogNavigator2, navBackStackEntry);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidDialog_androidKt.Dialog((Function0) rememberedValue2, destination2.getDialogProperties$navigation_compose_release(), ComposableLambdaKt.rememberComposableLambda(1129586364, z2, new DialogHostKt$DialogHost$1$2(navBackStackEntry, dialogNavigator2, rememberSaveableStateHolder, snapshotStateList, destination2), startRestartGroup, 54), startRestartGroup, 384, 0);
                collectAsState2 = collectAsState2;
                str = str;
                continuation = continuation;
                z2 = z2;
            }
            Continuation continuation2 = continuation;
            boolean z3 = z2;
            State<Set<NavBackStackEntry>> state = collectAsState2;
            startRestartGroup.endReplaceGroup();
            Set<NavBackStackEntry> DialogHost$lambda$1 = DialogHost$lambda$1(state);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1361073703, str);
            boolean changed = startRestartGroup.changed((Object) state);
            if ((i2 & 14) == 4) {
                z = z3;
            }
            boolean z4 = changed | z;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new DialogHostKt$DialogHost$2$1(state, dialogNavigator2, snapshotStateList, continuation2);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(DialogHost$lambda$1, snapshotStateList, (Function2) rememberedValue3, startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogHostKt$DialogHost$3(dialogNavigator2, i3));
        }
    }

    public static final void PopulateVisibleList(List<NavBackStackEntry> list, Collection<NavBackStackEntry> collection, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1537894851);
        ComposerKt.sourceInformation(startRestartGroup, "C(PopulateVisibleList)89@3710L7,*91@3793L961,91@3759L995:DialogHost.kt#opm8kd");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(collection) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1537894851, i2, -1, "androidx.navigation.compose.PopulateVisibleList (DialogHost.kt:88)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            boolean booleanValue = ((Boolean) consume).booleanValue();
            for (NavBackStackEntry navBackStackEntry : collection) {
                Lifecycle lifecycle = navBackStackEntry.getLifecycle();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -788103595, "CC(remember):DialogHost.kt#9igjgp");
                boolean changed = startRestartGroup.changed(booleanValue) | startRestartGroup.changedInstance(list) | startRestartGroup.changedInstance(navBackStackEntry);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DialogHostKt$PopulateVisibleList$1$1$1(navBackStackEntry, booleanValue, list);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.DisposableEffect((Object) lifecycle, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogHostKt$PopulateVisibleList$2(list, collection, i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0047, code lost:
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.snapshots.SnapshotStateList<androidx.navigation.NavBackStackEntry> rememberVisibleList(java.util.Collection<androidx.navigation.NavBackStackEntry> r5, androidx.compose.runtime.Composer r6, int r7) {
        /*
            java.lang.String r0 = "C(rememberVisibleList)121@4970L7,122@4989L399:DialogHost.kt#opm8kd"
            r1 = 467378629(0x1bdba1c5, float:3.6335052E-22)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0014
            r0 = -1
            java.lang.String r2 = "androidx.navigation.compose.rememberVisibleList (DialogHost.kt:119)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r7, r0, r2)
        L_0x0014:
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.InspectionModeKt.getLocalInspectionMode()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            java.lang.Object r7 = r6.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r0 = -393426303(0xffffffffe88cca81, float:-5.318935E24)
            java.lang.String r1 = "CC(remember):DialogHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            boolean r0 = r6.changed((java.lang.Object) r5)
            java.lang.Object r1 = r6.rememberedValue()
            if (r0 != 0) goto L_0x0049
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0089
        L_0x0049:
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r5 = r5.iterator()
        L_0x005a:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x007f
            java.lang.Object r2 = r5.next()
            r3 = r2
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            if (r7 == 0) goto L_0x006b
            r3 = 1
            goto L_0x0079
        L_0x006b:
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            androidx.lifecycle.Lifecycle$State r3 = r3.getCurrentState()
            androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r3 = r3.isAtLeast(r4)
        L_0x0079:
            if (r3 == 0) goto L_0x005a
            r0.add(r2)
            goto L_0x005a
        L_0x007f:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            r1.addAll(r0)
            r6.updateRememberedValue(r1)
        L_0x0089:
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = (androidx.compose.runtime.snapshots.SnapshotStateList) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0097
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0097:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.DialogHostKt.rememberVisibleList(java.util.Collection, androidx.compose.runtime.Composer, int):androidx.compose.runtime.snapshots.SnapshotStateList");
    }

    private static final List<NavBackStackEntry> DialogHost$lambda$0(State<? extends List<NavBackStackEntry>> state) {
        return (List) state.getValue();
    }

    /* access modifiers changed from: private */
    public static final Set<NavBackStackEntry> DialogHost$lambda$1(State<? extends Set<NavBackStackEntry>> state) {
        return (Set) state.getValue();
    }
}
