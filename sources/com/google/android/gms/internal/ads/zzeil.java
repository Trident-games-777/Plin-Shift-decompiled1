package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeil extends zzeik {
    private final zzchk zza;
    private final zzcvu zzb;
    private final zzdcf zzc;
    private final zzeiv zzd;
    private final zzefg zze;

    zzeil(zzchk zzchk, zzcvu zzcvu, zzdcf zzdcf, zzeiv zzeiv, zzefg zzefg) {
        this.zza = zzchk;
        this.zzb = zzcvu;
        this.zzc = zzdcf;
        this.zzd = zzeiv;
        this.zze = zzefg;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzffo zzffo, Bundle bundle, zzfet zzfet, zzfff zzfff) {
        zzcvu zzcvu = this.zzb;
        zzcvu.zzi(zzffo);
        zzcvu.zzf(bundle);
        zzcvu.zzg(new zzcvo(zzfff, zzfet, this.zzd));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdG)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzchk zzchk = this.zza;
        zzcvu zzcvu2 = this.zzb;
        zzcoq zzd2 = zzchk.zzd();
        zzd2.zzd(zzcvu2.zzj());
        zzd2.zzc(this.zzc);
        zzcsy zzb2 = zzd2.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
