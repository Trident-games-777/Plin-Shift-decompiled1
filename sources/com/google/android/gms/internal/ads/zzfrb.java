package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfrb extends zzayc implements IInterface {
    zzfrb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfqz zze(zzfqx zzfqx) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzfqx);
        Parcel zzdb = zzdb(1, zza);
        zzfqz zzfqz = (zzfqz) zzaye.zza(zzdb, zzfqz.CREATOR);
        zzdb.recycle();
        return zzfqz;
    }

    public final zzfri zzf(zzfrg zzfrg) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzfrg);
        Parcel zzdb = zzdb(3, zza);
        zzfri zzfri = (zzfri) zzaye.zza(zzdb, zzfri.CREATOR);
        zzdb.recycle();
        return zzfri;
    }

    public final void zzg(zzfqu zzfqu) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzfqu);
        zzdc(2, zza);
    }
}
