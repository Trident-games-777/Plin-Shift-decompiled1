package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogNavigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DialogHost.kt */
final class DialogHostKt$DialogHost$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ NavBackStackEntry $backStackEntry;
    final /* synthetic */ DialogNavigator.Destination $destination;
    final /* synthetic */ DialogNavigator $dialogNavigator;
    final /* synthetic */ SnapshotStateList<NavBackStackEntry> $dialogsToDispose;
    final /* synthetic */ SaveableStateHolder $saveableStateHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogHostKt$DialogHost$1$2(NavBackStackEntry navBackStackEntry, DialogNavigator dialogNavigator, SaveableStateHolder saveableStateHolder, SnapshotStateList<NavBackStackEntry> snapshotStateList, DialogNavigator.Destination destination) {
        super(2);
        this.$backStackEntry = navBackStackEntry;
        this.$dialogNavigator = dialogNavigator;
        this.$saveableStateHolder = saveableStateHolder;
        this.$dialogsToDispose = snapshotStateList;
        this.$destination = destination;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C55@2378L247,55@2345L280,65@2842L67,65@2801L108:DialogHost.kt#opm8kd");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1129586364, i, -1, "androidx.navigation.compose.DialogHost.<anonymous>.<anonymous> (DialogHost.kt:55)");
            }
            NavBackStackEntry navBackStackEntry = this.$backStackEntry;
            ComposerKt.sourceInformationMarkerStart(composer, -1838164906, "CC(remember):DialogHost.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(this.$backStackEntry) | composer.changed((Object) this.$dialogNavigator);
            SnapshotStateList<NavBackStackEntry> snapshotStateList = this.$dialogsToDispose;
            NavBackStackEntry navBackStackEntry2 = this.$backStackEntry;
            DialogNavigator dialogNavigator = this.$dialogNavigator;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DialogHostKt$DialogHost$1$2$1$1(snapshotStateList, navBackStackEntry2, dialogNavigator);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.DisposableEffect((Object) navBackStackEntry, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, composer, 0);
            NavBackStackEntry navBackStackEntry3 = this.$backStackEntry;
            SaveableStateHolder saveableStateHolder = this.$saveableStateHolder;
            final DialogNavigator.Destination destination = this.$destination;
            final NavBackStackEntry navBackStackEntry4 = this.$backStackEntry;
            NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry3, saveableStateHolder, ComposableLambdaKt.rememberComposableLambda(-497631156, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C66@2872L23:DialogHost.kt#opm8kd");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-497631156, i, -1, "androidx.navigation.compose.DialogHost.<anonymous>.<anonymous>.<anonymous> (DialogHost.kt:66)");
                        }
                        destination.getContent$navigation_compose_release().invoke(navBackStackEntry4, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }, composer, 54), composer, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
