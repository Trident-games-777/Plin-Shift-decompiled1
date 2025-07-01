package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzftq {
    public static ListenableFuture zza(Task task, CancellationTokenSource cancellationTokenSource) {
        zzftp zzftp = new zzftp(task, (Runnable) null);
        task.addOnCompleteListener(zzgey.zzb(), new zzfto(zzftp));
        return zzftp;
    }
}
