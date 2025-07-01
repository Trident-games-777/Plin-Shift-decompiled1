package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfeo implements zzenh {
    final /* synthetic */ zzfeq zza;

    zzfeo(zzfeq zzfeq) {
        this.zza = zzfeq;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdor zzdor = (zzdor) obj;
        synchronized (this.zza) {
            this.zza.zzd = zzdor;
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzdE)).booleanValue()) {
                zzdor.zzd().zza = this.zza.zzc;
            }
            this.zza.zzd.zzk();
        }
    }
}
