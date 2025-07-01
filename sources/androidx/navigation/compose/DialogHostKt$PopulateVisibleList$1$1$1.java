package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DialogHost.kt */
final class DialogHostKt$PopulateVisibleList$1$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ NavBackStackEntry $entry;
    final /* synthetic */ boolean $isInspecting;
    final /* synthetic */ List<NavBackStackEntry> $this_PopulateVisibleList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogHostKt$PopulateVisibleList$1$1$1(NavBackStackEntry navBackStackEntry, boolean z, List<NavBackStackEntry> list) {
        super(1);
        this.$entry = navBackStackEntry;
        this.$isInspecting = z;
        this.$this_PopulateVisibleList = list;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        DialogHostKt$PopulateVisibleList$1$1$1$$ExternalSyntheticLambda0 dialogHostKt$PopulateVisibleList$1$1$1$$ExternalSyntheticLambda0 = new DialogHostKt$PopulateVisibleList$1$1$1$$ExternalSyntheticLambda0(this.$isInspecting, this.$this_PopulateVisibleList, this.$entry);
        this.$entry.getLifecycle().addObserver(dialogHostKt$PopulateVisibleList$1$1$1$$ExternalSyntheticLambda0);
        return new DialogHostKt$PopulateVisibleList$1$1$1$invoke$$inlined$onDispose$1(this.$entry, dialogHostKt$PopulateVisibleList$1$1$1$$ExternalSyntheticLambda0);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(boolean z, List list, NavBackStackEntry navBackStackEntry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (z && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_START && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_STOP) {
            list.remove(navBackStackEntry);
        }
    }
}
