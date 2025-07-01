package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeii extends zzeik {
    private final zzchk zza;
    private final zzdhe zzb;
    private final zzcvu zzc;
    private final zzdcf zzd;
    private final zzeiv zze;
    private final zzefg zzf;

    public zzeii(zzchk zzchk, zzdhe zzdhe, zzcvu zzcvu, zzdcf zzdcf, zzeiv zzeiv, zzefg zzefg) {
        this.zza = zzchk;
        this.zzb = zzdhe;
        this.zzc = zzcvu;
        this.zzd = zzdcf;
        this.zze = zzeiv;
        this.zzf = zzefg;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzffo zzffo, Bundle bundle, zzfet zzfet, zzfff zzfff) {
        zzcvu zzcvu = this.zzc;
        zzcvu.zzi(zzffo);
        zzcvu.zzf(bundle);
        zzcvu.zzg(new zzcvo(zzfff, zzfet, this.zze));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdG)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzchk zzchk = this.zza;
        zzcvu zzcvu2 = this.zzc;
        zzdhi zzh = zzchk.zzh();
        zzh.zzf(zzcvu2.zzj());
        zzh.zze(this.zzd);
        zzh.zzd(this.zzb);
        zzh.zzc(new zzcpa((ViewGroup) null));
        zzcsy zza2 = zzh.zzg().zza();
        return zza2.zzi(zza2.zzj());
    }
}
