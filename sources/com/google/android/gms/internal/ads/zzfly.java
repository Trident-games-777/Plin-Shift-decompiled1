package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfly extends zzbn {
    final /* synthetic */ zzgfa zza;
    final /* synthetic */ zzby zzb;
    final /* synthetic */ zzflz zzc;

    zzfly(zzflz zzflz, zzgfa zzgfa, zzby zzby) {
        this.zza = zzgfa;
        this.zzb = zzby;
        this.zzc = zzflz;
    }

    public final void zzb(zze zze) {
        String adError = zze.zzb().toString();
        String str = this.zzc.zze.zza;
        zzm.zzj("Failed to load interstitial ad with error: " + adError + " for ad unit: " + str);
        new zzfmn(this.zzc, this.zza).zza(zze);
    }

    public final void zzc() {
        new zzfmn(this.zzc, this.zza).zzb(this.zzb);
    }
}
