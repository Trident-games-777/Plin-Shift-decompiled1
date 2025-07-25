package androidx.compose.foundation;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J<\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH@¢\u0006\u0002\u0010\u0010JU\u0010\u0011\u001a\u0002H\n\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\n2\u0006\u0010\u0013\u001a\u0002H\u00122\b\b\u0002\u0010\u000b\u001a\u00020\f2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014¢\u0006\u0002\b\u0015H@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0001J\u0017\u0010\u0019\u001a\u00020\u00182\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\bJ\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0001R\"\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/MutatorMutex;", "", "()V", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/foundation/MutatorMutex$Mutator;", "Landroidx/compose/foundation/AtomicReference;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "mutate", "R", "priority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutateWith", "T", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "", "tryMutate", "Lkotlin/Function0;", "", "tryMutateOrCancel", "mutator", "unlock", "Mutator", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MutatorMutex.kt */
public final class MutatorMutex {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public final AtomicReference<Mutator> currentMutator = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/MutatorMutex$Mutator;", "", "priority", "Landroidx/compose/foundation/MutatePriority;", "job", "Lkotlinx/coroutines/Job;", "(Landroidx/compose/foundation/MutatePriority;Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getPriority", "()Landroidx/compose/foundation/MutatePriority;", "canInterrupt", "", "other", "cancel", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MutatorMutex.kt */
    private static final class Mutator {
        private final Job job;
        private final MutatePriority priority;

        public Mutator(MutatePriority mutatePriority, Job job2) {
            this.priority = mutatePriority;
            this.job = job2;
        }

        public final Job getJob() {
            return this.job;
        }

        public final MutatePriority getPriority() {
            return this.priority;
        }

        public final boolean canInterrupt(Mutator mutator) {
            return this.priority.compareTo(mutator.priority) >= 0;
        }

        public final void cancel() {
            this.job.cancel((CancellationException) new MutationInterruptedException());
        }
    }

    /* access modifiers changed from: private */
    public final void tryMutateOrCancel(Mutator mutator) {
        Mutator mutator2;
        do {
            mutator2 = this.currentMutator.get();
            if (mutator2 != null && !mutator.canInterrupt(mutator2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.currentMutator, mutator2, mutator));
        if (mutator2 != null) {
            mutator2.cancel();
        }
    }

    public static /* synthetic */ Object mutate$default(MutatorMutex mutatorMutex, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutate(mutatePriority, function1, continuation);
    }

    public final <R> Object mutate(MutatePriority mutatePriority, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        return CoroutineScopeKt.coroutineScope(new MutatorMutex$mutate$2(mutatePriority, this, function1, (Continuation<? super MutatorMutex$mutate$2>) null), continuation);
    }

    public static /* synthetic */ Object mutateWith$default(MutatorMutex mutatorMutex, Object obj, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutateWith(obj, mutatePriority, function2, continuation);
    }

    public final <T, R> Object mutateWith(T t, MutatePriority mutatePriority, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return CoroutineScopeKt.coroutineScope(new MutatorMutex$mutateWith$2(mutatePriority, this, function2, t, (Continuation<? super MutatorMutex$mutateWith$2>) null), continuation);
    }

    public final boolean tryMutate(Function0<Unit> function0) {
        boolean tryLock = tryLock();
        if (!tryLock) {
            return tryLock;
        }
        try {
            function0.invoke();
            return tryLock;
        } finally {
            unlock();
        }
    }

    public final boolean tryLock() {
        return Mutex.DefaultImpls.tryLock$default(this.mutex, (Object) null, 1, (Object) null);
    }

    public final void unlock() {
        Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
    }
}
