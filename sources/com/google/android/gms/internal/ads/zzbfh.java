package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbfh extends zzayc implements IInterface {
    zzbfh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbuq zzbuq) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbuq);
        zzdc(1, zza);
    }
}
