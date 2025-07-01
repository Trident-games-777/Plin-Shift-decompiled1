package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzaye;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzdp extends zzayc implements zzdr {
    zzdp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public final void zze(zzu zzu) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzu);
        zzdc(1, zza);
    }

    public final boolean zzf() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
