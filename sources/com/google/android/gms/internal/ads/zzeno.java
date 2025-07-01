package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzeno implements zzgee {
    final /* synthetic */ zzenh zza;
    final /* synthetic */ zzfkl zzb;
    final /* synthetic */ zzfka zzc;
    final /* synthetic */ zzdhj zzd;
    final /* synthetic */ zzenp zze;

    zzeno(zzenp zzenp, zzenh zzenh, zzfkl zzfkl, zzfka zzfka, zzdhj zzdhj) {
        this.zza = zzenh;
        this.zzb = zzfkl;
        this.zzc = zzfka;
        this.zzd = zzdhj;
        this.zze = zzenp;
    }

    public final void zza(Throwable th) {
        zzfkl zzfkl;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfH)).booleanValue()) {
            zze.zzb("Native ad failed to load", th);
        }
        com.google.android.gms.ads.internal.client.zze zza2 = this.zzd.zza().zza(th);
        this.zzd.zzb().zzdB(zza2);
        this.zze.zzb.zzC().execute(new zzenn(this, zza2));
        zzfgl.zzb(zza2.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zzb) == null) {
            zzenp zzenp = this.zze;
            zzfka zzfka = this.zzc;
            zzfko zze2 = zzenp.zze;
            zzfka.zza(zza2);
            zzfka.zzh(th);
            zzfka.zzg(false);
            zze2.zzb(zzfka.zzm());
            return;
        }
        zzfkl.zzc(zza2);
        zzfka zzfka2 = this.zzc;
        zzfka2.zzh(th);
        zzfka2.zzg(false);
        zzfkl.zza(zzfka2);
        zzfkl.zzh();
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkl zzfkl;
        zzcrq zzcrq = (zzcrq) obj;
        synchronized (this.zze) {
            zzcrq.zzo().zza(this.zze.zzd.zzd());
            this.zza.zzb(zzcrq);
            this.zze.zzb.zzC().execute(new zzenm(this));
            if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zzb) == null) {
                zzfko zze2 = this.zze.zze;
                zzfka zzfka = this.zzc;
                zzfka.zzb(zzcrq.zzq().zzb);
                zzfka.zzd(zzcrq.zzm().zzg());
                zzfka.zzg(true);
                zze2.zzb(zzfka.zzm());
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
