package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzegu implements zzgee {
    final /* synthetic */ zzegv zza;

    zzegu(zzegv zzegv) {
        this.zza = zzegv;
    }

    public final void zza(Throwable th) {
        zze zza2 = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zzdB(zza2);
        zzfgl.zzb(zza2.zza, th, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void zzb(Object obj) {
        ((zzcpd) obj).zzk();
    }
}
