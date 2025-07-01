package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzaye;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzcd extends zzayc implements zzcf {
    zzcd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloadCallback");
    }

    public final void zze(zzft zzft) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzft);
        zzdc(1, zza);
    }

    public final void zzf(zzft zzft) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzft);
        zzdc(2, zza);
    }
}
