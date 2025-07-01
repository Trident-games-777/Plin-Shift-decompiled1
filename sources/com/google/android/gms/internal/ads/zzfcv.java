package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfcv implements zzgee {
    final /* synthetic */ zzenh zza;
    final /* synthetic */ zzfkl zzb;
    final /* synthetic */ zzfka zzc;
    final /* synthetic */ zzdgn zzd;
    final /* synthetic */ zzfcw zze;

    zzfcv(zzfcw zzfcw, zzenh zzenh, zzfkl zzfkl, zzfka zzfka, zzdgn zzdgn) {
        this.zza = zzenh;
        this.zzb = zzfkl;
        this.zzc = zzfka;
        this.zzd = zzdgn;
        this.zze = zzfcw;
    }

    public final void zza(Throwable th) {
        zzfkl zzfkl;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfH)).booleanValue()) {
            zze.zzb("Interstitial ad failed to load", th);
        }
        com.google.android.gms.ads.internal.client.zze zza2 = this.zzd.zza().zza(th);
        synchronized (this.zze) {
            this.zze.zzi = null;
            this.zzd.zzb().zzdB(zza2);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzhQ)).booleanValue()) {
                this.zze.zzb.execute(new zzfcr(this, zza2));
                this.zze.zzb.execute(new zzfcs(this, zza2));
            }
            zzfgl.zzb(zza2.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zzb) == null) {
                zzfko zze2 = this.zze.zzg;
                zzfka zzfka = this.zzc;
                zzfka.zza(zza2);
                zzfka.zzh(th);
                zzfka.zzg(false);
                zze2.zzb(zzfka.zzm());
            } else {
                zzfkl.zzc(zza2);
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
        zzdfj zzdfj = (zzdfj) obj;
        synchronized (this.zze) {
            this.zze.zzi = null;
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzhQ)).booleanValue()) {
                zzdas zzo = zzdfj.zzo();
                zzo.zza(this.zze.zzd);
                zzo.zzd(this.zze.zze);
            }
            this.zza.zzb(zzdfj);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzhQ)).booleanValue()) {
                this.zze.zzb.execute(new zzfct(this));
                this.zze.zzb.execute(new zzfcu(this));
            }
            if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zzb) == null) {
                zzfko zze2 = this.zze.zzg;
                zzfka zzfka = this.zzc;
                zzfka.zzb(zzdfj.zzq().zzb);
                zzfka.zzd(zzdfj.zzm().zzg());
                zzfka.zzg(true);
                zze2.zzb(zzfka.zzm());
            } else {
                zzfkl.zzg(zzdfj.zzq().zzb);
                zzfkl.zze(zzdfj.zzm().zzg());
                zzfka zzfka2 = this.zzc;
                zzfka2.zzg(true);
                zzfkl.zza(zzfka2);
                zzfkl.zzh();
            }
        }
    }
}
