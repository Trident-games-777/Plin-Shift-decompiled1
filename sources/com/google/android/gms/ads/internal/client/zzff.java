package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzff implements Runnable {
    final /* synthetic */ zzfg zza;

    zzff(zzfg zzfg) {
        this.zza = zzfg;
    }

    public final void run() {
        zzfi zzfi = this.zza.zza;
        if (zzfi.zza != null) {
            try {
                zzfi.zza.zze(1);
            } catch (RemoteException e) {
                zzm.zzk("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
