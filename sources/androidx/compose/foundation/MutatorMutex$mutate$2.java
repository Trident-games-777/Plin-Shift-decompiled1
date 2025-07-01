package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.MutatorMutex$mutate$2", f = "MutatorMutex.kt", i = {0, 0, 1, 1}, l = {214, 126}, m = "invokeSuspend", n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: MutatorMutex.kt */
final class MutatorMutex$mutate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    final /* synthetic */ MutatePriority $priority;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutatorMutex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutatorMutex$mutate$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super MutatorMutex$mutate$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = mutatorMutex;
        this.$block = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MutatorMutex$mutate$2 mutatorMutex$mutate$2 = new MutatorMutex$mutate$2(this.$priority, this.this$0, this.$block, continuation);
        mutatorMutex$mutate$2.L$0 = obj;
        return mutatorMutex$mutate$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((MutatorMutex$mutate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x009b=Splitter:B:19:0x009b, B:25:0x00ac=Splitter:B:25:0x00ac} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0040
            if (r1 == r3) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r0 = r8.L$2
            androidx.compose.foundation.MutatorMutex r0 = (androidx.compose.foundation.MutatorMutex) r0
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r8.L$0
            androidx.compose.foundation.MutatorMutex$Mutator r2 = (androidx.compose.foundation.MutatorMutex.Mutator) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0020 }
            goto L_0x009b
        L_0x0020:
            r9 = move-exception
            goto L_0x00ac
        L_0x0023:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x002b:
            java.lang.Object r1 = r8.L$3
            androidx.compose.foundation.MutatorMutex r1 = (androidx.compose.foundation.MutatorMutex) r1
            java.lang.Object r3 = r8.L$2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.lang.Object r5 = r8.L$1
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r8.L$0
            androidx.compose.foundation.MutatorMutex$Mutator r6 = (androidx.compose.foundation.MutatorMutex.Mutator) r6
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r5
            goto L_0x0086
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            androidx.compose.foundation.MutatorMutex$Mutator r1 = new androidx.compose.foundation.MutatorMutex$Mutator
            androidx.compose.foundation.MutatePriority r5 = r8.$priority
            kotlin.coroutines.CoroutineContext r9 = r9.getCoroutineContext()
            kotlinx.coroutines.Job$Key r6 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r6 = (kotlin.coroutines.CoroutineContext.Key) r6
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            r1.<init>(r5, r9)
            androidx.compose.foundation.MutatorMutex r9 = r8.this$0
            r9.tryMutateOrCancel(r1)
            androidx.compose.foundation.MutatorMutex r9 = r8.this$0
            kotlinx.coroutines.sync.Mutex r9 = r9.mutex
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super R>, java.lang.Object> r5 = r8.$block
            androidx.compose.foundation.MutatorMutex r6 = r8.this$0
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.L$0 = r1
            r8.L$1 = r9
            r8.L$2 = r5
            r8.L$3 = r6
            r8.label = r3
            java.lang.Object r3 = r9.lock(r4, r7)
            if (r3 != r0) goto L_0x0082
            goto L_0x0096
        L_0x0082:
            r3 = r6
            r6 = r1
            r1 = r3
            r3 = r5
        L_0x0086:
            r8.L$0 = r6     // Catch:{ all -> 0x00a6 }
            r8.L$1 = r9     // Catch:{ all -> 0x00a6 }
            r8.L$2 = r1     // Catch:{ all -> 0x00a6 }
            r8.L$3 = r4     // Catch:{ all -> 0x00a6 }
            r8.label = r2     // Catch:{ all -> 0x00a6 }
            java.lang.Object r2 = r3.invoke(r8)     // Catch:{ all -> 0x00a6 }
            if (r2 != r0) goto L_0x0097
        L_0x0096:
            return r0
        L_0x0097:
            r0 = r1
            r1 = r9
            r9 = r2
            r2 = r6
        L_0x009b:
            java.util.concurrent.atomic.AtomicReference r0 = r0.currentMutator     // Catch:{ all -> 0x00b4 }
            androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(r0, r2, r4)     // Catch:{ all -> 0x00b4 }
            r1.unlock(r4)
            return r9
        L_0x00a6:
            r0 = move-exception
            r2 = r1
            r1 = r9
            r9 = r0
            r0 = r2
            r2 = r6
        L_0x00ac:
            java.util.concurrent.atomic.AtomicReference r0 = r0.currentMutator     // Catch:{ all -> 0x00b4 }
            androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(r0, r2, r4)     // Catch:{ all -> 0x00b4 }
            throw r9     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            r9 = move-exception
            r1.unlock(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MutatorMutex$mutate$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
