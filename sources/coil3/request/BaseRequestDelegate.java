package coil3.request;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Lcoil3/request/BaseRequestDelegate;", "Lcoil3/request/RequestDelegate;", "job", "Lkotlinx/coroutines/Job;", "constructor-impl", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "dispose", "", "dispose-impl", "(Lkotlinx/coroutines/Job;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* compiled from: RequestDelegate.kt */
public final class BaseRequestDelegate implements RequestDelegate {
    private final Job job;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ BaseRequestDelegate m7532boximpl(Job job2) {
        return new BaseRequestDelegate(job2);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Job m7533constructorimpl(Job job2) {
        return job2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7535equalsimpl(Job job2, Object obj) {
        return (obj instanceof BaseRequestDelegate) && Intrinsics.areEqual((Object) job2, (Object) ((BaseRequestDelegate) obj).m7539unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7536equalsimpl0(Job job2, Job job3) {
        return Intrinsics.areEqual((Object) job2, (Object) job3);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7537hashCodeimpl(Job job2) {
        return job2.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7538toStringimpl(Job job2) {
        return "BaseRequestDelegate(job=" + job2 + ')';
    }

    public boolean equals(Object obj) {
        return m7535equalsimpl(this.job, obj);
    }

    public int hashCode() {
        return m7537hashCodeimpl(this.job);
    }

    public String toString() {
        return m7538toStringimpl(this.job);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Job m7539unboximpl() {
        return this.job;
    }

    private /* synthetic */ BaseRequestDelegate(Job job2) {
        this.job = job2;
    }

    public void dispose() {
        m7534disposeimpl(this.job);
    }

    /* renamed from: dispose-impl  reason: not valid java name */
    public static void m7534disposeimpl(Job job2) {
        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
    }
}
