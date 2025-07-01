package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbgx extends zzayc implements zzbgz {
    zzbgx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zze(zzbgp zzbgp) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbgp);
        zzdc(1, zza);
    }
}
