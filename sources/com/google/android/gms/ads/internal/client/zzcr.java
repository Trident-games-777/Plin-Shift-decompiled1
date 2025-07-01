package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzaye;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzcr extends zzayc implements zzct {
    zzcr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    public final void zzb() throws RemoteException {
        zzdc(5, zza());
    }

    public final void zzc() throws RemoteException {
        zzdc(3, zza());
    }

    public final void zzd(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zze);
        zzdc(1, zza);
    }

    public final void zze() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzf() throws RemoteException {
        zzdc(2, zza());
    }
}
