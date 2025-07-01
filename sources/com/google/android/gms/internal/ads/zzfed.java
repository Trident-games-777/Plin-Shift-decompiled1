package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfed implements zzgee {
    final /* synthetic */ zzenh zza;
    final /* synthetic */ zzfkl zzb;
    final /* synthetic */ zzfka zzc;
    final /* synthetic */ zzfee zzd;
    final /* synthetic */ zzfeg zze;

    zzfed(zzfeg zzfeg, zzenh zzenh, zzfkl zzfkl, zzfka zzfka, zzfee zzfee) {
        this.zza = zzenh;
        this.zzb = zzfkl;
        this.zzc = zzfka;
        this.zzd = zzfee;
        this.zze = zzfeg;
    }

    public final void zza(Throwable th) {
        zze zze2;
        zzfkl zzfkl;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfH)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Rewarded ad failed to load", th);
        }
        zzdow zzdow = (zzdow) this.zze.zze.zzd();
        if (zzdow == null) {
            zze2 = zzfgq.zzb(th, (zzefg) null);
        } else {
            zze2 = zzdow.zzb().zza(th);
        }
        synchronized (this.zze) {
            if (zzdow != null) {
                zzdow.zza().zzdB(zze2);
                this.zze.zzb.execute(new zzfeb(this, zze2));
            } else {
                this.zze.zzd.zzdB(zze2);
                this.zze.zzk(this.zzd).zze().zzb().zzc().zzh();
            }
            zzfgl.zzb(zze2.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zzb) == null) {
                zzfko zzg = this.zze.zzg;
                zzfka zzfka = this.zzc;
                zzfka.zza(zze2);
                zzfka.zzh(th);
                zzfka.zzg(false);
                zzg.zzb(zzfka.zzm());
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
        zzdor zzdor = (zzdor) obj;
        synchronized (this.zze) {
            zzdor.zzo().zzd(this.zze.zzd);
            this.zza.zzb(zzdor);
            zzfeg zzfeg = this.zze;
            Executor zzh = zzfeg.zzb;
            zzfdw zzf = zzfeg.zzd;
            Objects.requireNonNull(zzf);
            zzh.execute(new zzfec(zzf));
            this.zze.zzd.onAdMetadataChanged();
            if (!((Boolean) zzbeg.zzc.zze()).booleanValue() || (zzfkl = this.zzb) == null) {
                zzfko zzg = this.zze.zzg;
                zzfka zzfka = this.zzc;
                zzfka.zzb(zzdor.zzq().zzb);
                zzfka.zzd(zzdor.zzm().zzg());
                zzfka.zzg(true);
                zzg.zzb(zzfka.zzm());
            } else {
                zzfkl.zzg(zzdor.zzq().zzb);
                zzfkl.zze(zzdor.zzm().zzg());
                zzfka zzfka2 = this.zzc;
                zzfka2.zzg(true);
                zzfkl.zza(zzfka2);
                zzfkl.zzh();
            }
        }
    }
}
