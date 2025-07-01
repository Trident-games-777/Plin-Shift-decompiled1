package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbvh extends zzayc implements zzbvj {
    zzbvh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsService");
    }

    public final void zze(zzbvb zzbvb, zzbvm zzbvm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbvb);
        zzaye.zzf(zza, zzbvm);
        zzdc(3, zza);
    }

    public final void zzf(zzbuv zzbuv, zzbvm zzbvm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbuv);
        zzaye.zzf(zza, zzbvm);
        zzdc(1, zza);
    }
}
