package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdnw implements zzgee {
    final /* synthetic */ zzfet zza;
    final /* synthetic */ zzfew zzb;
    final /* synthetic */ zzcnb zzc;
    final /* synthetic */ zzdoc zzd;

    zzdnw(zzdoc zzdoc, zzfet zzfet, zzfew zzfew, zzcnb zzcnb) {
        this.zza = zzfet;
        this.zzb = zzfew;
        this.zzc = zzcnb;
        this.zzd = zzdoc;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcfk zzcfk = (zzcfk) obj;
        zzcfk.zzW(this.zza, this.zzb);
        zzchc zzN = zzcfk.zzN();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjM)).booleanValue() && zzN != null) {
            zzcnb zzcnb = this.zzc;
            zzdoc zzdoc = this.zzd;
            zzN.zzJ(zzcnb, zzdoc.zzi, zzdoc.zzj);
            zzcnb zzcnb2 = this.zzc;
            zzdoc zzdoc2 = this.zzd;
            zzN.zzL(zzcnb2, zzdoc2.zzi, zzdoc2.zzd);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmH)).booleanValue() && zzN != null) {
            zzN.zzM(this.zza);
        }
    }
}
