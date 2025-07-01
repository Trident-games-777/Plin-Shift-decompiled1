package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzein extends zzeik {
    private final zzchk zza;
    private final zzcvu zzb;
    private final zzelb zzc;
    private final zzdcf zzd;
    private final zzdhe zze;
    private final zzcze zzf;
    private final ViewGroup zzg;
    private final zzdbk zzh;
    private final zzeiv zzi;
    private final zzefg zzj;

    public zzein(zzchk zzchk, zzcvu zzcvu, zzelb zzelb, zzdcf zzdcf, zzdhe zzdhe, zzcze zzcze, ViewGroup viewGroup, zzdbk zzdbk, zzeiv zzeiv, zzefg zzefg) {
        this.zza = zzchk;
        this.zzb = zzcvu;
        this.zzc = zzelb;
        this.zzd = zzdcf;
        this.zze = zzdhe;
        this.zzf = zzcze;
        this.zzg = viewGroup;
        this.zzh = zzdbk;
        this.zzi = zzeiv;
        this.zzj = zzefg;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzffo zzffo, Bundle bundle, zzfet zzfet, zzfff zzfff) {
        zzcvu zzcvu = this.zzb;
        zzcvu.zzi(zzffo);
        zzcvu.zzf(bundle);
        zzcvu.zzg(new zzcvo(zzfff, zzfet, this.zzi));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdG)).booleanValue()) {
            this.zzb.zzd(this.zzj);
        }
        zzchk zzchk = this.zza;
        zzcvu zzcvu2 = this.zzb;
        zzcqg zze2 = zzchk.zze();
        zze2.zzi(zzcvu2.zzj());
        zze2.zzf(this.zzd);
        zze2.zze(this.zzc);
        zze2.zzd(this.zze);
        zze2.zzg(new zzcri(this.zzf, this.zzh));
        zze2.zzc(new zzcpa(this.zzg));
        zzcsy zzd2 = zze2.zzk().zzd();
        return zzd2.zzi(zzd2.zzj());
    }
}
