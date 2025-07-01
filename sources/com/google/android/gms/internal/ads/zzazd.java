package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzazd implements Runnable {
    final /* synthetic */ zzaze zza;

    zzazd(zzaze zzaze) {
        this.zza = zzaze;
    }

    public final void run() {
        synchronized (this.zza.zzc) {
            zzaze zzaze = this.zza;
            if (!zzaze.zzd || !zzaze.zze) {
                zzm.zze("App is still foreground");
            } else {
                zzaze.zzd = false;
                zzm.zze("App went background");
                for (zzazf zza2 : this.zza.zzf) {
                    try {
                        zza2.zza(false);
                    } catch (Exception e) {
                        zzm.zzh("", e);
                    }
                }
            }
        }
    }
}
