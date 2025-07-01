package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdhp implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;

    public zzdhp(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcvu zza2 = ((zzcwe) this.zzb).zza();
        zzcvu zzcvu = zza2;
        zzdcf zza3 = ((zzdcz) this.zzc).zza();
        zzdcf zzdcf = zza3;
        zzdhe zza4 = ((zzdhg) this.zzd).zza();
        zzdhe zzdhe = zza4;
        zzcze zza5 = ((zzcpc) this.zze).zzb();
        zzcze zzcze = zza5;
        zzeiv zzeiv = (zzeiv) this.zzf.zzb();
        zzcqg zze2 = ((zzchk) this.zza.zzb()).zze();
        zze2.zzi(zza2.zzj());
        zze2.zzf(zza3);
        zze2.zzd(zza4);
        zze2.zze(new zzelb((zzbdi) null));
        zze2.zzg(new zzcri(zza5, (zzdbk) null));
        zze2.zzc(new zzcpa((ViewGroup) null));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdJ)).booleanValue()) {
            zze2.zzj(zzeje.zzb(zzeiv));
        }
        zzcrt zzc2 = zze2.zzk().zzc();
        zzhgf.zzb(zzc2);
        zzcrt zzcrt = zzc2;
        return zzc2;
    }
}
