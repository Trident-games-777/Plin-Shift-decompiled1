package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdkx implements zzcxg {
    private final zzdiy zza;
    private final zzdjd zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdkx(zzdiy zzdiy, zzdjd zzdjd, Executor executor, Executor executor2) {
        this.zza = zzdiy;
        this.zzb = zzdjd;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzcfk zzcfk) {
        this.zzc.execute(new zzdkv(zzcfk));
    }

    public final void zzr() {
        if (this.zzb.zzd()) {
            zzdiy zzdiy = this.zza;
            zzeew zzu = zzdiy.zzu();
            if (zzu == null && zzdiy.zzw() != null) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzfk)).booleanValue()) {
                    zzdiy zzdiy2 = this.zza;
                    ListenableFuture zzw = zzdiy2.zzw();
                    zzcao zzp = zzdiy2.zzp();
                    if (zzw != null && zzp != null) {
                        zzgei.zzr(zzgei.zzl(zzw, zzp), new zzdkw(this), this.zzd);
                        return;
                    }
                    return;
                }
            }
            if (zzu != null) {
                zzdiy zzdiy3 = this.zza;
                zzcfk zzr = zzdiy3.zzr();
                zzcfk zzs = zzdiy3.zzs();
                if (zzr == null) {
                    zzr = zzs != null ? zzs : null;
                }
                if (zzr != null) {
                    zzb(zzr);
                }
            }
        }
    }
}
