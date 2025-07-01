package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzbid implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ zzby zzb;
    final /* synthetic */ zzbie zzc;

    zzbid(zzbie zzbie, AdManagerAdView adManagerAdView, zzby zzby) {
        this.zza = adManagerAdView;
        this.zzb = zzby;
        this.zzc = zzbie;
    }

    public final void run() {
        if (this.zza.zzb(this.zzb)) {
            zzbie zzbie = this.zzc;
            zzbie.zza.onAdManagerAdViewLoaded(this.zza);
            return;
        }
        zzm.zzj("Could not bind.");
    }
}
