package androidx.navigation.compose;

import androidx.activity.BackEventCompat;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H@"}, d2 = {"<anonymous>", "", "backEvent", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$25$1", f = "NavHost.kt", i = {0}, l = {524}, m = "invokeSuspend", n = {"currentBackStackEntry"}, s = {"L$0"})
/* compiled from: NavHost.kt */
final class NavHostKt$NavHost$25$1 extends SuspendLambda implements Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComposeNavigator $composeNavigator;
    final /* synthetic */ State<List<NavBackStackEntry>> $currentBackStack$delegate;
    final /* synthetic */ MutableState<Boolean> $inPredictiveBack$delegate;
    final /* synthetic */ MutableFloatState $progress$delegate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$25$1(ComposeNavigator composeNavigator, State<? extends List<NavBackStackEntry>> state, MutableFloatState mutableFloatState, MutableState<Boolean> mutableState, Continuation<? super NavHostKt$NavHost$25$1> continuation) {
        super(2, continuation);
        this.$composeNavigator = composeNavigator;
        this.$currentBackStack$delegate = state;
        this.$progress$delegate = mutableFloatState;
        this.$inPredictiveBack$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavHostKt$NavHost$25$1 navHostKt$NavHost$25$1 = new NavHostKt$NavHost$25$1(this.$composeNavigator, this.$currentBackStack$delegate, this.$progress$delegate, this.$inPredictiveBack$delegate, continuation);
        navHostKt$NavHost$25$1.L$0 = obj;
        return navHostKt$NavHost$25$1;
    }

    public final Object invoke(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$25$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        NavBackStackEntry navBackStackEntry;
        NavBackStackEntry navBackStackEntry2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flow = (Flow) this.L$0;
            if (NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate).size() > 1) {
                NavHostKt.NavHost$lambda$9(this.$progress$delegate, 0.0f);
                navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.lastOrNull(NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate));
                ComposeNavigator composeNavigator = this.$composeNavigator;
                Intrinsics.checkNotNull(navBackStackEntry2);
                composeNavigator.prepareForTransition(navBackStackEntry2);
                this.$composeNavigator.prepareForTransition((NavBackStackEntry) NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate).get(NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate).size() - 2));
            } else {
                navBackStackEntry2 = null;
            }
            final State<List<NavBackStackEntry>> state = this.$currentBackStack$delegate;
            final MutableState<Boolean> mutableState = this.$inPredictiveBack$delegate;
            final MutableFloatState mutableFloatState = this.$progress$delegate;
            this.L$0 = navBackStackEntry2;
            this.label = 1;
            if (flow.collect(new FlowCollector() {
                public final Object emit(BackEventCompat backEventCompat, Continuation<? super Unit> continuation) {
                    if (NavHostKt.NavHost$lambda$6(state).size() > 1) {
                        NavHostKt.NavHost$lambda$12(mutableState, true);
                        NavHostKt.NavHost$lambda$9(mutableFloatState, backEventCompat.getProgress());
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            navBackStackEntry = navBackStackEntry2;
        } else if (i == 1) {
            navBackStackEntry = (NavBackStackEntry) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException unused) {
                if (NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate).size() > 1) {
                    NavHostKt.NavHost$lambda$12(this.$inPredictiveBack$delegate, false);
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate).size() > 1) {
            NavHostKt.NavHost$lambda$12(this.$inPredictiveBack$delegate, false);
            ComposeNavigator composeNavigator2 = this.$composeNavigator;
            Intrinsics.checkNotNull(navBackStackEntry);
            composeNavigator2.popBackStack(navBackStackEntry, false);
        }
        return Unit.INSTANCE;
    }
}
