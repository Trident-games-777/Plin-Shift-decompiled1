package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzdi implements MuteThisAdReason {
    private final String zza;
    private final zzdh zzb;

    public zzdi(zzdh zzdh) {
        String str;
        this.zzb = zzdh;
        try {
            str = zzdh.zze();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            str = null;
        }
        this.zza = str;
    }

    public final String getDescription() {
        return this.zza;
    }

    public final String toString() {
        return this.zza;
    }

    public final zzdh zza() {
        return this.zzb;
    }
}
