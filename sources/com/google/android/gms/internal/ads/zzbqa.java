package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzbqa implements InitializationCompleteCallback {
    final /* synthetic */ zzblt zza;

    zzbqa(zzbqh zzbqh, zzblt zzblt) {
        this.zza = zzblt;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
