package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfbe implements zzgee {
    final /* synthetic */ zzfkl zza;
    final /* synthetic */ zzfka zzb;
    final /* synthetic */ zzcqh zzc;
    final /* synthetic */ zzfbf zzd;

    zzfbe(zzfbf zzfbf, zzfkl zzfkl, zzfka zzfka, zzcqh zzcqh) {
        this.zza = zzfkl;
        this.zzb = zzfka;
        this.zzc = zzcqh;
        this.zzd = zzfbf;
    }

    public final void zza(Throwable th) {
        zzfkl zzfkl;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfH)).booleanValue()) {
            zze.zzb("Banner ad failed to load", th);
        }
        this.zzd.zzn = this.zzc.zzd().zza(th);
        synchronized (this.zzd) {
            this.zzc.zzf().zzdB(this.zzd.zzn);
            zzfgl.zzb(this.zzd.zzn.zza, th, "BannerAdLoader.onFailure");
            zzfbf zzfbf = this.zzd;
            if (zzfbf.zzm) {
                zzfbf.zzu();
                zzfbf zzfbf2 = this.zzd;
                zzfbf2.zzh.zzd(zzfbf2.zzj.zzc());
            }
            if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zza) == null) {
                zzfbf zzfbf3 = this.zzd;
                zzfko zzh = zzfbf3.zzi;
                zzfka zzfka = this.zzb;
                zzfka.zza(zzfbf3.zzn);
                zzfka.zzh(th);
                zzfka.zzg(false);
                zzh.zzb(zzfka.zzm());
            } else {
                zzfkl.zzc(this.zzd.zzn);
                zzfka zzfka2 = this.zzb;
                zzfka2.zzh(th);
                zzfka2.zzg(false);
                zzfkl.zza(zzfka2);
                zzfkl.zzh();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkl zzfkl;
        zzcpd zzcpd = (zzcpd) obj;
        synchronized (this.zzd) {
            zzfbf zzfbf = this.zzd;
            if (zzfbf.zzm) {
                zzfbf.zzr();
            }
            if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zza) == null) {
                zzfko zzh = this.zzd.zzi;
                zzfka zzfka = this.zzb;
                zzfka.zzb(zzcpd.zzq().zzb);
                zzfka.zzd(zzcpd.zzm().zzg());
                zzfka.zzg(true);
                zzh.zzb(zzfka.zzm());
            } else {
                zzfkl.zzg(zzcpd.zzq().zzb);
                zzfkl.zze(zzcpd.zzm().zzg());
                zzfka zzfka2 = this.zzb;
                zzfka2.zzg(true);
                zzfkl.zza(zzfka2);
                zzfkl.zzh();
            }
        }
    }
}
