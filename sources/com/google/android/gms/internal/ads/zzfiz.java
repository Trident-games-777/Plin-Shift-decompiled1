package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfiz {
    final /* synthetic */ zzfjj zza;
    private final Object zzb;
    private final List zzc;

    /* synthetic */ zzfiz(zzfjj zzfjj, Object obj, List list, zzfji zzfji) {
        this.zza = zzfjj;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfjh zza(Callable callable) {
        zzgeg zzb2 = zzgei.zzb(this.zzc);
        ListenableFuture zza2 = zzb2.zza(new zzfiy(), zzcaj.zzf);
        ListenableFuture zza3 = zzb2.zza(callable, this.zza.zzb);
        return new zzfjh(this.zza, this.zzb, (String) null, zza2, this.zzc, zza3, (zzfji) null);
    }
}
