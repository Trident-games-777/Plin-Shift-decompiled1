package coil3.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.util.LifecyclesKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\nH@¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcoil3/request/LifecycleRequestDelegate;", "Lcoil3/request/RequestDelegate;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/Job;)V", "start", "", "awaitStarted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "dispose", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RequestDelegate.android.kt */
public final class LifecycleRequestDelegate implements RequestDelegate, DefaultLifecycleObserver {
    private final Job job;
    private final Lifecycle lifecycle;

    public LifecycleRequestDelegate(Lifecycle lifecycle2, Job job2) {
        this.lifecycle = lifecycle2;
        this.job = job2;
    }

    public void start() {
        this.lifecycle.addObserver(this);
    }

    public Object awaitStarted(Continuation<? super Unit> continuation) {
        Object awaitStarted = LifecyclesKt.awaitStarted(this.lifecycle, continuation);
        return awaitStarted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitStarted : Unit.INSTANCE;
    }

    public void complete() {
        this.lifecycle.removeObserver(this);
    }

    public void dispose() {
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        dispose();
    }
}
