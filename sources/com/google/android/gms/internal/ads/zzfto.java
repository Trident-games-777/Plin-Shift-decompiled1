package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfto implements OnCompleteListener {
    public final /* synthetic */ zzftp zza;

    public /* synthetic */ zzfto(zzftp zzftp) {
        this.zza = zzftp;
    }

    public final void onComplete(Task task) {
        zzftp zzftp = this.zza;
        if (task.isCanceled()) {
            zzftp.cancel(false);
        } else if (task.isSuccessful()) {
            zzftp.zzc(task.getResult());
        } else {
            Exception exception = task.getException();
            if (exception != null) {
                zzftp.zzd(exception);
                return;
            }
            throw new IllegalStateException();
        }
    }
}
