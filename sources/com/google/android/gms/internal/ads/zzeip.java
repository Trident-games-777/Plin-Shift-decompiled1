package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeip extends zzeik {
    private final zzchk zza;
    private final zzcvu zzb;
    private final zzelb zzc;
    private final zzdcf zzd;
    private final zzeiv zze;
    private final zzefg zzf;

    public zzeip(zzchk zzchk, zzcvu zzcvu, zzelb zzelb, zzdcf zzdcf, zzeiv zzeiv, zzefg zzefg) {
        this.zza = zzchk;
        this.zzb = zzcvu;
        this.zzc = zzelb;
        this.zzd = zzdcf;
        this.zze = zzeiv;
        this.zzf = zzefg;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzffo zzffo, Bundle bundle, zzfet zzfet, zzfff zzfff) {
        zzcvu zzcvu = this.zzb;
        zzcvu.zzi(zzffo);
        zzcvu.zzf(bundle);
        zzcvu.zzg(new zzcvo(zzfff, zzfet, this.zze));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdG)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzchk zzchk = this.zza;
        zzcvu zzcvu2 = this.zzb;
        zzdgm zzg = zzchk.zzg();
        zzg.zze(zzcvu2.zzj());
        zzg.zzd(this.zzd);
        zzg.zzc(this.zzc);
        zzcsy zza2 = zzg.zzf().zza();
        return zza2.zzi(zza2.zzj());
    }
}
