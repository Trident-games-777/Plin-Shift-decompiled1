package androidx.navigation.compose;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$33$1", f = "NavHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NavHost.kt */
final class NavHostKt$NavHost$33$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComposeNavigator $composeNavigator;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ Transition<NavBackStackEntry> $transition;
    final /* synthetic */ State<List<NavBackStackEntry>> $visibleEntries$delegate;
    final /* synthetic */ Map<String, Float> $zIndices;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$33$1(Transition<NavBackStackEntry> transition, NavHostController navHostController, Map<String, Float> map, State<? extends List<NavBackStackEntry>> state, ComposeNavigator composeNavigator, Continuation<? super NavHostKt$NavHost$33$1> continuation) {
        super(2, continuation);
        this.$transition = transition;
        this.$navController = navHostController;
        this.$zIndices = map;
        this.$visibleEntries$delegate = state;
        this.$composeNavigator = composeNavigator;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NavHostKt$NavHost$33$1(this.$transition, this.$navController, this.$zIndices, this.$visibleEntries$delegate, this.$composeNavigator, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual((Object) this.$transition.getCurrentState(), (Object) this.$transition.getTargetState()) && (this.$navController.getCurrentBackStackEntry() == null || Intrinsics.areEqual((Object) this.$transition.getTargetState(), (Object) this.$navController.getCurrentBackStackEntry()))) {
                ComposeNavigator composeNavigator = this.$composeNavigator;
                for (NavBackStackEntry onTransitionComplete : NavHostKt.NavHost$lambda$17(this.$visibleEntries$delegate)) {
                    composeNavigator.onTransitionComplete(onTransitionComplete);
                }
                Map<String, Float> map = this.$zIndices;
                Transition<NavBackStackEntry> transition = this.$transition;
                Map linkedHashMap = new LinkedHashMap();
                for (Map.Entry next : map.entrySet()) {
                    if (!Intrinsics.areEqual(next.getKey(), (Object) transition.getTargetState().getId())) {
                        linkedHashMap.put(next.getKey(), next.getValue());
                    }
                }
                Map<String, Float> map2 = this.$zIndices;
                for (Map.Entry key : linkedHashMap.entrySet()) {
                    map2.remove(key.getKey());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
