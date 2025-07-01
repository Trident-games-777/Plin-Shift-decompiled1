package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzaye;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbp extends zzayc implements zzbr {
    zzbp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final String zzf() throws RemoteException {
        throw null;
    }

    public final void zzg(zzm zzm) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzm);
        zzdc(1, zza);
    }

    public final void zzh(zzm zzm, int i) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzm);
        zza.writeInt(i);
        zzdc(5, zza);
    }

    public final boolean zzi() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
