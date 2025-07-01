package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbaz extends zzayc implements IInterface {
    zzbaz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbax zzbax) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbax);
        Parcel zzdb = zzdb(3, zza);
        long readLong = zzdb.readLong();
        zzdb.recycle();
        return readLong;
    }

    public final zzbau zzf(zzbax zzbax) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbax);
        Parcel zzdb = zzdb(1, zza);
        zzbau zzbau = (zzbau) zzaye.zza(zzdb, zzbau.CREATOR);
        zzdb.recycle();
        return zzbau;
    }

    public final zzbau zzg(zzbax zzbax) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzbax);
        Parcel zzdb = zzdb(2, zza);
        zzbau zzbau = (zzbau) zzaye.zza(zzdb, zzbau.CREATOR);
        zzdb.recycle();
        return zzbau;
    }
}
