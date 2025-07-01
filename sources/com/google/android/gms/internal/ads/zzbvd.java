package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbvd extends zzayc implements zzbvf {
    zzbvd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzbvx zzbvx, zzbvp zzbvp) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbvx);
        zzaye.zzf(zza, zzbvp);
        zzdc(6, zza);
    }

    public final void zzf(zzbvx zzbvx, zzbvp zzbvp) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbvx);
        zzaye.zzf(zza, zzbvp);
        zzdc(5, zza);
    }

    public final void zzg(zzbvx zzbvx, zzbvp zzbvp) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbvx);
        zzaye.zzf(zza, zzbvp);
        zzdc(4, zza);
    }

    public final void zzh(String str, zzbvp zzbvp) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaye.zzf(zza, zzbvp);
        zzdc(7, zza);
    }

    public final void zzi(zzbuz zzbuz, zzbvq zzbvq) throws RemoteException {
        throw null;
    }
}
