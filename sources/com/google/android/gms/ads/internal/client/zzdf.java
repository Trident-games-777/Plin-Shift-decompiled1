package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayc;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzdf extends zzayc implements zzdh {
    zzdf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public final String zze() throws RemoteException {
        Parcel zzdb = zzdb(1, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzf() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }
}
