package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbxj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzfp implements Runnable {
    public final /* synthetic */ zzbxj zza;

    public /* synthetic */ zzfp(zzbxj zzbxj) {
        this.zza = zzbxj;
    }

    public final void run() {
        zzbxj zzbxj = this.zza;
        if (zzbxj != null) {
            try {
                zzbxj.zze(1);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
