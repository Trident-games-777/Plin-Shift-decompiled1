package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzflv extends zzbah {
    final /* synthetic */ zzgfa zza;
    final /* synthetic */ zzft zzb;
    final /* synthetic */ zzflw zzc;

    zzflv(zzflw zzflw, zzgfa zzgfa, zzft zzft) {
        this.zza = zzgfa;
        this.zzb = zzft;
        this.zzc = zzflw;
    }

    public final void zzb(int i) {
    }

    public final void zzc(zze zze) {
        String adError = zze.zzb().toString();
        String str = this.zzb.zza;
        zzm.zzj("Failed to load app open ad with error parcel: " + adError + " for ad unit: " + str);
        new zzfmn(this.zzc, this.zza).zza(zze);
    }

    public final void zzd(zzbaf zzbaf) {
        new zzfmn(this.zzc, this.zza).zzb(zzbaf);
    }
}
