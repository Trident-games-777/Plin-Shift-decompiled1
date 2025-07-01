package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbli extends zzayc implements IInterface {
    zzbli(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzblc zzblc, zzblh zzblh) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zzblc);
        zzaye.zzf(zza, zzblh);
        zzdd(2, zza);
    }
}
