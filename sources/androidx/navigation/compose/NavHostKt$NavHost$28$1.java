package androidx.navigation.compose;

import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$28$1", f = "NavHost.kt", i = {}, l = {621}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NavHost.kt */
final class NavHostKt$NavHost$28$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<List<NavBackStackEntry>> $currentBackStack$delegate;
    final /* synthetic */ MutableFloatState $progress$delegate;
    final /* synthetic */ SeekableTransitionState<NavBackStackEntry> $transitionState;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$28$1(SeekableTransitionState<NavBackStackEntry> seekableTransitionState, State<? extends List<NavBackStackEntry>> state, MutableFloatState mutableFloatState, Continuation<? super NavHostKt$NavHost$28$1> continuation) {
        super(2, continuation);
        this.$transitionState = seekableTransitionState;
        this.$currentBackStack$delegate = state;
        this.$progress$delegate = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NavHostKt$NavHost$28$1(this.$transitionState, this.$currentBackStack$delegate, this.$progress$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$28$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SeekableTransitionState<NavBackStackEntry> seekableTransitionState = this.$transitionState;
            float access$NavHost$lambda$8 = NavHostKt.NavHost$lambda$8(this.$progress$delegate);
            this.label = 1;
            if (seekableTransitionState.seekTo(access$NavHost$lambda$8, (NavBackStackEntry) NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate).get(NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate).size() - 2), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
