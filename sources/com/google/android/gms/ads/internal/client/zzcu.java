package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzaye;
import com.google.android.gms.internal.ads.zzbpf;
import com.google.android.gms.internal.ads.zzbpg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzcu extends zzayc implements zzcw {
    zzcu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public final zzbpg getAdapterCreator() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        zzbpg zzf = zzbpf.zzf(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzf;
    }

    public final zzfb getLiteSdkVersion() throws RemoteException {
        Parcel zzdb = zzdb(1, zza());
        zzfb zzfb = (zzfb) zzaye.zza(zzdb, zzfb.CREATOR);
        zzdb.recycle();
        return zzfb;
    }
}
