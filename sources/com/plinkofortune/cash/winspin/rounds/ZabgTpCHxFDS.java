package com.plinkofortune.cash.winspin.rounds;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/plinkofortune/cash/winspin/rounds/ZabgTpCHxFDS;", "", "<init>", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "retryJob", "Lkotlinx/coroutines/Job;", "passed", "", "getPassed", "()Z", "setPassed", "(Z)V", "iQLhOuiIOxLa", "", "context", "Landroid/content/Context;", "retryCount", "", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryConnection", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ZabgTpCHxFDS.kt */
public final class ZabgTpCHxFDS {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    private boolean passed;
    private Job retryJob;

    public final boolean getPassed() {
        return this.passed;
    }

    public final void setPassed(boolean z) {
        this.passed = z;
    }

    public static /* synthetic */ Object iQLhOuiIOxLa$default(ZabgTpCHxFDS zabgTpCHxFDS, Context context, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 5;
        }
        return zabgTpCHxFDS.iQLhOuiIOxLa(context, i, continuation);
    }

    /* access modifiers changed from: private */
    public final void retryConnection(Context context, int i) {
        Job job = this.retryJob;
        if (job == null || !job.isActive()) {
            this.retryJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ZabgTpCHxFDS$retryConnection$1(this, context, i, (Continuation<? super ZabgTpCHxFDS$retryConnection$1>) null), 3, (Object) null);
        }
    }

    public final Object iQLhOuiIOxLa(Context context, int i, Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
        build.startConnection(new ZabgTpCHxFDS$iQLhOuiIOxLa$2$1(this, build, cancellableContinuationImpl, i, context));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
