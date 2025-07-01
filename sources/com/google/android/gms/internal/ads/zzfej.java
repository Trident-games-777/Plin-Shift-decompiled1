package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfej implements zzenh {
    final /* synthetic */ zzfek zza;

    zzfej(zzfek zzfek) {
        this.zza = zzfek;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdor zzdor = (zzdor) obj;
        synchronized (this.zza) {
            this.zza.zzi = zzdor;
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzdE)).booleanValue()) {
                zzdor.zzd().zza = this.zza.zzd;
            }
            this.zza.zzi.zzk();
        }
    }
}
