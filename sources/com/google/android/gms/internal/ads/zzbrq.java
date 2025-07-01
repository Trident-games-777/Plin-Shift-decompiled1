package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzbrq implements SignalCallbacks {
    final /* synthetic */ zzbri zza;

    zzbrq(zzbrs zzbrs, zzbri zzbri) {
        this.zza = zzbri;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final void onSuccess(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zza.zzf(str);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
