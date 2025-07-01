package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzezy implements zzgee {
    final /* synthetic */ zzenh zza;
    final /* synthetic */ zzfkl zzb;
    final /* synthetic */ zzfka zzc;
    final /* synthetic */ zzezz zzd;
    final /* synthetic */ zzfab zze;

    zzezy(zzfab zzfab, zzenh zzenh, zzfkl zzfkl, zzfka zzfka, zzezz zzezz) {
        this.zza = zzenh;
        this.zzb = zzfkl;
        this.zzc = zzfka;
        this.zzd = zzezz;
        this.zze = zzfab;
    }

    public final void zza(Throwable th) {
        zze zze2;
        zzfkl zzfkl;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfH)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("App open ad failed to load", th);
        }
        zzcon zzcon = (zzcon) this.zze.zze.zzd();
        if (zzcon == null) {
            zze2 = zzfgq.zzb(th, (zzefg) null);
        } else {
            zze2 = zzcon.zzb().zza(th);
        }
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (zzcon != null) {
                zzcon.zzc().zzdB(zze2);
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzhP)).booleanValue()) {
                    this.zze.zzc.execute(new zzezx(this, zze2));
                }
            } else {
                this.zze.zzd.zzdB(zze2);
                ((zzcon) this.zze.zzm(this.zzd).zzh()).zzb().zzc().zzh();
            }
            zzfgl.zzb(zze2.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zzb) == null) {
                zzfko zzh = this.zze.zzh;
                zzfka zzfka = this.zzc;
                zzfka.zza(zze2);
                zzfka.zzh(th);
                zzfka.zzg(false);
                zzh.zzb(zzfka.zzm());
            } else {
                zzfkl.zzc(zze2);
                zzfka zzfka2 = this.zzc;
                zzfka2.zzh(th);
                zzfka2.zzg(false);
                zzfkl.zza(zzfka2);
                zzfkl.zzh();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkl zzfkl;
        zzcrq zzcrq = (zzcrq) obj;
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzhP)).booleanValue()) {
                zzcrq.zzo().zzb(this.zze.zzd);
            }
            this.zza.zzb(zzcrq);
            if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zzb) == null) {
                zzfko zzh = this.zze.zzh;
                zzfka zzfka = this.zzc;
                zzfka.zzb(zzcrq.zzq().zzb);
                zzfka.zzd(zzcrq.zzm().zzg());
                zzfka.zzg(true);
                zzh.zzb(zzfka.zzm());
            } else {
                zzfkl.zzg(zzcrq.zzq().zzb);
                zzfkl.zze(zzcrq.zzm().zzg());
                zzfka zzfka2 = this.zzc;
                zzfka2.zzg(true);
                zzfkl.zza(zzfka2);
                zzfkl.zzh();
            }
        }
    }
}
