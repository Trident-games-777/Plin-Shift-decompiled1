package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfpm implements Continuation {
    public final /* synthetic */ zzarl zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzfpm(zzarl zzarl, int i) {
        this.zza = zzarl;
        this.zzb = i;
    }

    public final Object then(Task task) {
        int i = zzfpp.zza;
        if (!task.isSuccessful()) {
            return false;
        }
        int i2 = this.zzb;
        zzfrp zza2 = ((zzfrr) task.getResult()).zza(((zzarp) this.zza.zzbr()).zzaV());
        zza2.zza(i2);
        zza2.zzc();
        return true;
    }
}
